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
	private final String pagingAllList = "SELECT b.* FROM (SELECT rownum rn, a.* FROM (SELECT * FROM notice ORDER BY noticeid DESC)a )b WHERE rn between ? and ?";
	private final String keywordTitleList = "SELECT b.* FROM (SELECT rownum rn, a.* FROM (SELECT * FROM notice WHERE noticetitle LIKE ? ORDER BY noticeid DESC)a )b WHERE rn BETWEEN ? AND ?";
	private final String keywordContentList = "SELECT * FROM (SELECT rownum rn, a.* FROM (SELECT * FROM notice WHERE noticecontent LIKE ? ORDER BY noticeid DESC)a )b WHERE rn BETWEEN ? AND ?";
	private final String pagingAllcount = "SELECT count(*) cnt FROM notice";
	private final String keywordTitleCount = "SELECT count(*) cnt FROM notice WHERE noticetitle LIKE ?";
	private final String keywordContentCount = "SELECT count(*) cnt FROM notice WHERE noticecontent LIKE ?";

	// 검색기능
	// select * from border where bordertitle like'%404%';
	public ArrayList<NoticeVO> getNoticeAllList(int currentPage, int pageSize) {

		ArrayList<NoticeVO> list = new ArrayList<NoticeVO>();

		try {
			psmt = conn.prepareStatement(pagingAllList);
			psmt.setInt(1, currentPage * pageSize - (pageSize - 1));
			psmt.setInt(2, currentPage * pageSize);
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


	// 검색 후 리스트
	public ArrayList<NoticeVO> getKeywordList(String condition, String opt, int currentPage, int pageSize) {

		ArrayList<NoticeVO> list = new ArrayList<NoticeVO>();

		try {
			if (opt.equals("noticetitle")) {
				psmt = conn.prepareStatement(keywordTitleList);
				psmt.setString(1, "%" + condition + "%");
				psmt.setInt(2, currentPage * pageSize - (pageSize - 1));
				psmt.setInt(3, currentPage * pageSize);
			} else {
				psmt = conn.prepareStatement(keywordContentList);
				psmt.setString(1, "%" + condition + "%");
				psmt.setInt(2, currentPage * pageSize - (pageSize - 1));
				psmt.setInt(3, currentPage * pageSize);
			}
			rs = psmt.executeQuery();
			while (rs.next()) {
				NoticeVO vo = new NoticeVO();
				vo.setNoticeid(rs.getInt("noticeid"));
				vo.setNoticewriter(rs.getString("noticewriter"));
				vo.setNoticetitle(rs.getString("noticetitle"));
				vo.setNoticecontent(rs.getString("noticecontent"));
				vo.setNoticehit(rs.getInt("noticehit"));
				vo.setNoticeattach(rs.getString("noticeattach"));
				vo.setNoticedate(rs.getDate("noticedate"));
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}

	// 모든 리스트 count
	public int getAllCount() {

		int cnt = 0;
		try {
			psmt = conn.prepareStatement(pagingAllcount);
			rs = psmt.executeQuery();
			if (rs.next()) {
				cnt = rs.getInt("cnt");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;

	}

	// 검색 후 튜플 수
	public int getKeywordCount(String opt, String condition) {
		int cnt = 0;
		try {
			if (opt.equals("noticetitle")) {
				psmt = conn.prepareStatement(keywordTitleCount);
				psmt.setString(1, "%" + condition + "%");
			} else {
				psmt = conn.prepareStatement(keywordContentCount);
				psmt.setString(1, "%" + condition + "%");
			}
			rs = psmt.executeQuery();
			if (rs.next()) {
				cnt = rs.getInt("cnt");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("cnt" + cnt);
		return cnt;
	}

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

}
