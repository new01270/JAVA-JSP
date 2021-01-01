package co.semi.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import co.semi.common.DAO;
import co.semi.vo.MemberVO;

public class MemberDAO extends DAO {

//	private Connection conn;
	private PreparedStatement psmt;
	private ResultSet rs;

	private final String member_insert = "INSERT INTO member VALUES(?, ?, ?, 'user')";
	private final String memberlogin = "SELECT * FROM MEMBER WHERE MEMBERID=? AND PASSWORD=?";
	private final String duplication = "SELECT memberid FROM member WHERE memberid=?";

	// 회원가입
	public int insert(MemberVO vo) {
		int n = 0;
		try {
			psmt = conn.prepareStatement(member_insert);
			psmt.setString(1, vo.getMemberId());
			psmt.setString(2, vo.getMemberName());
			psmt.setString(3, vo.getPassword());
			n = psmt.executeUpdate();
			System.out.println(n + "명의 회원이 가입하였습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return n;
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


	// 회원가입 중복체크
	public int duplicationCheck(String id) {
		int n = 1;
		try {
			psmt = conn.prepareStatement(duplication);
			psmt.setString(1, id);
			rs = psmt.executeQuery();
			if (rs.next()) {
				n = 0;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return n;
	}

	// 로그인
	public MemberVO login(MemberVO vo) {
		try {
			psmt = conn.prepareStatement(memberlogin);
			psmt.setString(1, vo.getMemberId());
			psmt.setString(2, vo.getPassword());
			rs = psmt.executeQuery();
			if (rs.next()) {
				vo.setMemberName(rs.getString("membername"));
				vo.setMemberAuth(rs.getString("memberauth"));
			}
			System.out.println("로그인이 완료되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return vo;
	}

}
