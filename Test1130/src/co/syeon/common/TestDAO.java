package co.syeon.common;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import co.syeon.mem.vo.TestVO;

public class TestDAO extends DAO {
	private PreparedStatement psmt;

	private final String insert = "insert into test values(?,?,?,?)";

	public TestVO insert(TestVO vo) {
		int n = 0;
		try {
			psmt = conn.prepareStatement(insert);
			psmt.setString(1, vo.getId());
			psmt.setString(2, vo.getName());
			psmt.setString(3, vo.getPassword());
			psmt.setDate(4, vo.getSigndate());
			n = psmt.executeUpdate();
			System.out.println(n + "명의 회원이 가입되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return vo;

	}
}
