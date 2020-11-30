package co.syeon.member.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import co.syeon.border.vo.BorderVO;
import co.syeon.member.vo.MemberVO;

public class MemberDAO {

	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String user = "syeon";
	private String password = "1234";

	private Connection conn;
	private PreparedStatement psmt;
	private ResultSet rs;

	private final String member_all = "SELECT * FROM member ORDER BY memberid ASC";
	private String member_one = "SELECT * FROM member WHERE memberid = ?";
	private final String memberlogin = "SELECT * FROM member WHERE memberid=? AND password=?";
	// private final String member_edit = "SELECT * FROM member WHERE memberid=?";
	private final String update = "UPDATE member SET memberauth=?, memberpoint=? WHERE memberid=?";
	private final String insert = "INSERT INTO member(memberid, membername, password, memberauth) VALUES(?,?,?,'user')";

	public MemberDAO() {
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
			System.out.println("DB연결 성공");
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("DB연결 실패");
		}
	}

	// 전체데이터
	public ArrayList<MemberVO> selectAll() {
		ArrayList<MemberVO> list = new ArrayList<MemberVO>();
		MemberVO vo;
		try {
			psmt = conn.prepareStatement(member_all);
			rs = psmt.executeQuery();
			while (rs.next()) {
				vo = new MemberVO();
				vo.setMemberId(rs.getString("memberid"));
				vo.setMemberName(rs.getString("membername"));
				vo.setMemberAuth(rs.getString("memberauth"));
				vo.setMemberPoint(rs.getInt("memberpoint"));
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}

	// 검색
	public MemberVO select(MemberVO vo) {
		try {
			psmt = conn.prepareStatement(member_one);
			psmt.setString(1, vo.getMemberId());
			rs = psmt.executeQuery();
			if (rs.next()) {
				vo.setMemberId(rs.getString("memberid"));
				vo.setMemberName(rs.getString("membername"));
				vo.setMemberAuth(rs.getString("memberauth"));
				vo.setMemberPoint(rs.getInt("memberpoint"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return vo;
	}

	public MemberVO memberLoginCheck(MemberVO vo) {
		try {
			psmt = conn.prepareStatement(memberlogin);
			psmt.setString(1, vo.getMemberId());
			psmt.setString(2, vo.getPassword());
			rs = psmt.executeQuery();
			if (rs.next()) {
				vo.setMemberName(rs.getString("membername"));
				vo.setMemberAuth(rs.getString("memberauth"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return vo;
	}

	public MemberVO editBefore(MemberVO vo) {
		try {
			psmt = conn.prepareStatement(member_one);
			psmt.setString(1, vo.getMemberId());
			rs = psmt.executeQuery();
			if (rs.next()) {
				vo.setMemberId(rs.getString("memberid"));
				vo.setMemberName(rs.getString("membername"));
				vo.setMemberAuth(rs.getString("memberauth"));
				vo.setMemberPoint(rs.getInt("memberpoint"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return vo;
	}

	public int insert(MemberVO vo) {
		int n = 0;
		try {
			psmt = conn.prepareStatement(insert);
			psmt.setString(1, vo.getMemberId());
			psmt.setString(2, vo.getMemberName());
			psmt.setString(3, vo.getPassword());
			n = psmt.executeUpdate();
			System.out.println(n + "명의 회원이 가입하였습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return n;
	}

	public int update(MemberVO vo) {
		int n = 0;
		try {
			psmt = conn.prepareStatement(update);
			psmt.setString(1, vo.getMemberAuth());
			psmt.setInt(2, vo.getMemberPoint());
			psmt.setString(3, vo.getMemberId());
			n = psmt.executeUpdate();
			System.out.println(n + "건이 수정되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n;
	}

	public MemberVO delete(MemberVO vo) {
		return vo;
	}

	private void close() {
		try {
			if (rs != null)
				rs.close();
			System.out.println("rs클로즈");
			if (psmt != null)
				psmt.close();
			System.out.println("psmt클로즈");
			if (conn != null)
				conn.close();
			System.out.println("conn클로즈");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

} // end of dao
