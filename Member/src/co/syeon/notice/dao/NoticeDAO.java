package co.syeon.notice.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import co.syeon.border.vo.BorderVO;
import co.syeon.notice.vo.NoticeVO;

public class NoticeDAO {
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String user = "syeon";
	private String password = "1234";

	private Connection conn;
	private PreparedStatement psmt;
	private ResultSet rs = null;;

	public NoticeDAO() {
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("DB연결 실패");
		}
	}

	private void close() {
		try {
			if (rs != null)
				rs.close();
			if (psmt != null)
				psmt.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// todo
	private final String noticelist = "SELECT * FROM notice ORDER BY noticeid desc";
	private final String noticeinsert = "INSERT INTO notice(noticeid, noticewriter, noticetitle, noticecontent, noticeattach) VALUES(no_val.nextval, ?, ?, ?, ?)";
	private final String noticeselect = "SELECT * FROM notice WHERE noticeid=?";
	private final String hit_update = "UPDATE notice SET noticehit = noticehit + 1 WHERE noticeid = ?";
	private final String update = "UPDATE notice SET noticecontent=?, noticeattach=? WHERE noticeid=?";
	private final String delete = "DELETE FROM notice WHERE noticeid=?";
	private final String searchOpt = "SELECT * FROM notice WHERE noticetitle LIKE ? ORDER BY BORDERID DESC";
	private final String searchOpt2 = "SELECT * FROM notice WHERE noticecontent LIKE ? ORDER BY BORDERID DESC";

	public ArrayList<NoticeVO> selectAll() {
		ArrayList<NoticeVO> list = new ArrayList<>();
		NoticeVO vo = new NoticeVO();
		try {
			psmt = conn.prepareStatement(noticelist);
			rs = psmt.executeQuery();
			while (rs.next()) {
				vo = new NoticeVO();
				vo.setNoticeid(rs.getInt("noticeid"));
				vo.setNoticetitle(rs.getString("noticetitle"));
				vo.setNoticedate(rs.getDate("noticedate"));
				vo.setNoticewriter(rs.getString("noticewriter"));
				vo.setNoticehit(rs.getInt("noticehit"));
				vo.setNoticeattach(rs.getString("noticeattach"));
				vo.setNoticecontent(rs.getString("noticecontent"));
				list.add(vo);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}

		return list;
	}

	public NoticeVO select(NoticeVO vo) {
		try {
			psmt = conn.prepareStatement(noticeselect);
			psmt.setInt(1, vo.getNoticeid());
			rs = psmt.executeQuery();
			if (rs.next()) {
				psmt = conn.prepareStatement(hit_update);
				psmt.setInt(1, vo.getNoticeid());
				psmt.executeUpdate();

				vo.setNoticeid(rs.getInt("noticeid"));
				vo.setNoticewriter(rs.getString("noticewriter"));
				vo.setNoticetitle(rs.getString("noticetitle"));
				vo.setNoticecontent(rs.getString("noticecontent"));
				vo.setNoticehit(rs.getInt("noticehit"));
				vo.setNoticeattach(rs.getString("noticeattach"));
				vo.setNoticedate(rs.getDate("noticedate"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return vo;
	}

	public NoticeVO editBefore(NoticeVO vo) {
		try {
			psmt = conn.prepareStatement(noticeselect);
			psmt.setInt(1, vo.getNoticeid());
			rs = psmt.executeQuery();
			if (rs.next()) {
				psmt = conn.prepareStatement(hit_update);
				psmt.setInt(1, vo.getNoticeid());
				psmt.executeUpdate();

				vo.setNoticeid(rs.getInt("noticeid"));
				vo.setNoticewriter(rs.getString("noticewriter"));
				vo.setNoticetitle(rs.getString("noticetitle"));
				vo.setNoticecontent(rs.getString("noticecontent"));
				vo.setNoticehit(rs.getInt("noticehit"));
				vo.setNoticeattach(rs.getString("noticeattach"));
				vo.setNoticedate(rs.getDate("noticedate"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return vo;
	}

	public int insert(NoticeVO vo) {
		int n = 0;
		try {
			psmt = conn.prepareStatement(noticeinsert);
			psmt.setString(1, vo.getNoticewriter());
			psmt.setString(2, vo.getNoticetitle());
			psmt.setString(3, vo.getNoticecontent());
			psmt.setString(4, vo.getNoticeattach());
			n = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return n;
	}

	public int update(NoticeVO vo) {
		int n = 0;
		try {
			psmt = conn.prepareStatement(update);
			psmt.setString(1, vo.getNoticecontent());
			psmt.setString(2, vo.getNoticeattach());
			psmt.setInt(3, vo.getNoticeid());
			n = psmt.executeUpdate();
			System.out.println(n + "건이 수정되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return n;
	}

	public int delete(NoticeVO vo) {
		int n = 0;
		try {
			psmt = conn.prepareStatement(delete);
			psmt.setInt(1, vo.getNoticeid());
			n = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return n;
	}

	// 검색기능
	// select * from border where bordertitle like'%404%';
	public ArrayList<NoticeVO> getBoardList(HashMap<String, Object> search) {
		ArrayList<NoticeVO> list = new ArrayList<NoticeVO>();

		String opt = (String) search.get("opt"); // 검색옵션(제목,작성자,작성일 등)
		String condition = (String) search.get("condition"); // 검색내용

		try {
			if (opt.equals("noticetitle")) {
				psmt = conn.prepareStatement(searchOpt);
				psmt.setString(1, "%" + condition + "%");
			} else {
				psmt = conn.prepareStatement(searchOpt2);
				psmt.setString(1, "%" + condition + "%");
			}
			rs = psmt.executeQuery();
			while (rs.next()) {
				NoticeVO vo = new NoticeVO();
				vo.setNoticeid(rs.getInt("noticeid"));
				vo.setNoticetitle(rs.getString("noticetitle"));
				vo.setNoticedate(rs.getDate("noticedate"));
				vo.setNoticewriter(rs.getString("noticewriter"));
				vo.setNoticehit(rs.getInt("noticehit"));
				vo.setNoticeattach(rs.getString("noticeattach"));
				vo.setNoticecontent(rs.getString("noticecontent"));
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}

}
