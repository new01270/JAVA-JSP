package co.syeon.id.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class MemberDAO extends DAO {
	PreparedStatement psmt;
	ResultSet rs;
	
	private String IDCHK = "SELECT memberid FROM member WHERE memberid=?";
	
	public String idCheck(String key) {
		String checkKey = null;
		try {
			psmt = conn.prepareCall(IDCHK);
			psmt.setString(1, key);
			rs = psmt.executeQuery();
			if(rs.next()) {
				checkKey = rs.getString("memberid");						
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return checkKey;
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
	
}
