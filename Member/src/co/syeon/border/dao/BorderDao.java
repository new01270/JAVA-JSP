package co.syeon.border.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import co.syeon.border.vo.BorderVO;
import co.syeon.common.DAO;

/*
 * 편의를 위해 상위 DAO 상속받아 사용.
 * 
CREATE sequence b_seq
INCREMENT BY 1
START WITH 1
MINVALUE 1
NOCYCLE;

SELECT b_seq.CURRVAL FROM dual;

 */

public class BorderDao extends DAO {
	private PreparedStatement psmt;
	private ResultSet rs;

	private final String select_all = "SELECT * FROM BORDER ORDER BY BORDERID DESC";
	private final String select_one = "SELECT * FROM BORDER WHERE borderid = ?";
	private final String insert = "INSERT INTO border(borderid, borderwriter, bordertitle, bordercontent, borderdate)\r\n"
			+ "VALUES(b_seq.nextval, ?, ?, ?, ?)";
	private final String hit_update = "UPDATE border SET borderhit = borderhit + 1 WHERE borderid = ?";
	private final String update = "UPDATE border SET bordercontent=? WHERE borderid = ?";
	private final String dalete = "DELETE FROM border WHERE borderid=?";
	private final String pagingAllList = "SELECT b.* FROM (select a.*, rownum rn from (select * from border order by 1 desc)a )b WHERE rn BETWEEN ? and ?";
	private final String pagingTitleList = "SELECT * FROM( SELECT rownum rn, b.* FROM (SELECT * FROM border WHERE bordertitle LIKE ? ORDER BY BORDERID DESC)b ) WHERE rn BETWEEN ? and ?";
	private final String pagingWriterList = "SELECT * FROM( SELECT rownum rn, b.* FROM (SELECT * FROM border WHERE borderwriter LIKE ? ORDER BY BORDERID DESC)b ) WHERE rn BETWEEN ? and ?";
	private final String pagingContentList = "SELECT * FROM( SELECT rownum rn, b.* FROM (SELECT * FROM border WHERE bordercontent LIKE ? ORDER BY BORDERID DESC)b ) WHERE rn BETWEEN ? and ?";
	private final String pagingAllCount = "SELECT COUNT(*) cnt FROM border";
	private final String keywordTitleCount = "SELECT count(*) cnt FROM border WHERE bordertitle LIKE ?";
	private final String keywordWriterCount = "SELECT count(*) cnt FROM border WHERE borderwriter LIKE ?";
	private final String keywordContentCount = "SELECT count(*) cnt FROM border WHERE bordercontent LIKE ?";

	// 리스트 개수만큼 페이지 가져오기.
	public ArrayList<BorderVO> getList(String pageNum, Integer pSize) {

		int pNum = Integer.parseInt(pageNum);

		ArrayList<BorderVO> list = new ArrayList<BorderVO>();

		try {
			psmt = conn.prepareStatement(pagingAllList);
			psmt.setInt(1, pNum * pSize - (pSize - 1));
			psmt.setInt(2, pNum * pSize);
			rs = psmt.executeQuery();
			while (rs.next()) {
				BorderVO vo = new BorderVO(); // borderVO값 초기화.
				vo.setBorderId(rs.getInt("borderid"));
				vo.setBorderWrite(rs.getString("borderwriter"));
				vo.setBorderTitle(rs.getString("bordertitle"));
				vo.setBorderContent(rs.getString("bordercontent"));
				vo.setBorderDate(rs.getDate("borderdate"));
				vo.setBorderHit(rs.getInt("borderhit"));
				list.add(vo);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;

	}

	// 검색기능
	// select * from border where bordertitle like'%404%';
	public ArrayList<BorderVO> getKeywordList(String pageNum, Integer pSize, String opt, String condition) {

		ArrayList<BorderVO> list = new ArrayList<BorderVO>();

		int pNum = Integer.parseInt(pageNum);

		try {
			if (opt.equals("bordertitle")) {
				psmt = conn.prepareStatement(pagingTitleList);
				psmt.setString(1, "%" + condition + "%");
				psmt.setInt(2, pNum * pSize - (pSize - 1));
				psmt.setInt(3, pNum * pSize);
			} else if (opt.equals("borderwriter")) {
				psmt = conn.prepareStatement(pagingWriterList);
				psmt.setString(1, "%" + condition + "%");
				psmt.setInt(2, pNum * pSize - (pSize - 1));
				psmt.setInt(3, pNum * pSize);
			} else {
				psmt = conn.prepareStatement(pagingContentList);
				psmt.setString(1, "%" + condition + "%");
				psmt.setInt(2, pNum * pSize - (pSize - 1));
				psmt.setInt(3, pNum * pSize);
			}
			rs = psmt.executeQuery();
			while (rs.next()) {
				BorderVO vo = new BorderVO(); // borderVO값 초기화.
				vo.setBorderId(rs.getInt("borderid"));
				vo.setBorderWrite(rs.getString("borderwriter"));
				vo.setBorderTitle(rs.getString("bordertitle"));
				vo.setBorderContent(rs.getString("bordercontent"));
				vo.setBorderDate(rs.getDate("borderdate"));
				vo.setBorderHit(rs.getInt("borderhit"));
				list.add(vo);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}

		return list;

	}

	// 글의 갯수
	public int getAllCount() {

		int cnt = 0;
		try {
			psmt = conn.prepareStatement(pagingAllCount);
			rs = psmt.executeQuery();
			if (rs.next()) {
				cnt = rs.getInt("cnt");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return cnt;

	}

	// 검색 후 글의 갯수
	public int getKeywordCount(String opt, String condition) {

		int cnt = 0;

		try {
			if (opt.equals("bordertitle")) {
				psmt = conn.prepareStatement(keywordTitleCount);
				psmt.setString(1, "%" + condition + "%");
			} else if (opt.equals("borderwriter")) {
				psmt = conn.prepareStatement(keywordWriterCount);
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

		return cnt;
	}

	// 전체 데이터 가져오기.
	public ArrayList<BorderVO> selectAll() {

		ArrayList<BorderVO> list = new ArrayList<BorderVO>();
		BorderVO vo;

		try {
			psmt = conn.prepareStatement(select_all);
			rs = psmt.executeQuery();
			while (rs.next()) {
				vo = new BorderVO(); // borderVO값 초기화.
				vo.setBorderId(rs.getInt("borderid"));
				vo.setBorderWrite(rs.getString("borderwriter"));
				vo.setBorderTitle(rs.getString("bordertitle"));
				vo.setBorderContent(rs.getString("bordercontent"));
				vo.setBorderDate(rs.getDate("borderdate"));
				vo.setBorderHit(rs.getInt("borderhit"));
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}

		return list; // 돌아오는 데이터가 없으면 return에 null을 반환.

	}

	// 한 레코드 검색 -> if.
	public BorderVO selectOne(BorderVO vo) {

		try {
			psmt = conn.prepareStatement(select_one);
			psmt.setInt(1, vo.getBorderId());
			rs = psmt.executeQuery();
			if (rs.next()) {

				// 조회수 증가.
				psmt = conn.prepareStatement(hit_update);
				psmt.setInt(1, vo.getBorderId());
				psmt.executeUpdate();

				vo.setBorderId(rs.getInt("borderid"));
				vo.setBorderWrite(rs.getString("borderwriter"));
				vo.setBorderTitle(rs.getString("bordertitle"));
				vo.setBorderContent(rs.getString("bordercontent"));
				vo.setBorderDate(rs.getDate("borderdate"));
				vo.setBorderHit(rs.getInt("borderhit"));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}

		return vo;

	}

	// 게시글 입력
	public int insert(BorderVO vo) {

		int n = 0;

		try {
			psmt = conn.prepareStatement(insert);
			psmt.setString(1, vo.getBorderWrite());
			psmt.setString(2, vo.getBorderTitle());
			psmt.setString(3, vo.getBorderContent());
			psmt.setDate(4, vo.getBorderDate());
			n = psmt.executeUpdate();
			System.out.println(n + "건이 데이터베이스에 입력 완료 되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}

		return n;

	}

	// 수정버튼->뿌려주는 data
	public BorderVO selectSearch(BorderVO vo) {

		try {
			psmt = conn.prepareStatement(select_one);
			psmt.setInt(1, vo.getBorderId());
			rs = psmt.executeQuery();
			if (rs.next()) {
				vo.setBorderId(rs.getInt("borderid"));
				vo.setBorderWrite(rs.getString("borderwriter"));
				vo.setBorderTitle(rs.getString("bordertitle"));
				vo.setBorderContent(rs.getString("bordercontent"));
				vo.setBorderDate(rs.getDate("borderdate"));
				vo.setBorderHit(rs.getInt("borderhit"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}

		return vo;

	}

	// 게시글 수정
	public int update(BorderVO vo) {

		int n = 0;
		try {
			psmt = conn.prepareStatement(update);
			psmt.setString(1, vo.getBorderContent());
			psmt.setInt(2, vo.getBorderId());
			n = psmt.executeUpdate();
			System.out.println(n + "건이 수정 완료 되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}

		return n;

	}

	// 게시글 삭제
	public int delete(BorderVO vo) {

		int n = 0;
		try {
			psmt = conn.prepareStatement(dalete);
			psmt.setInt(1, vo.getBorderId());
			n = psmt.executeUpdate();
			System.out.println(n + "건이 삭제 완료되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}

		return n;

	}

	// close() 메서드 총괄.
	private void close() {

		try {
			if (rs != null) {
				rs.close();
			}
			if (psmt != null) {
				psmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
