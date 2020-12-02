package co.syeon.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import co.syeon.vo.enVO;

public class EnDAO extends DAO {
	private PreparedStatement psmt;

	private final String insert = "INSERT INTO ENCRYPTION VALUES(?,?,?)";

	public int insert(enVO vo) {
		int n = 0;
		try {
			psmt = conn.prepareStatement(insert);
			psmt.setInt(1, vo.getId());
			psmt.setString(2, vo.getPassword());
			psmt.setString(3, vo.getEncryptionpassword());
			n = psmt.executeUpdate();
			System.out.println("로그인되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return n;
	}
}
