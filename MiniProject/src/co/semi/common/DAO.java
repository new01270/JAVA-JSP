package co.semi.common;

import java.sql.Connection;
import java.sql.DriverManager;

public class DAO {
	
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String user = "semi";
	private String password = "semi";
	public Connection conn = null; // 연결객체

	public DAO() {		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
			System.out.println("연결성공");
		} catch (Exception e) {
			System.out.println("DB연결 실패!");
		}
	}
}

