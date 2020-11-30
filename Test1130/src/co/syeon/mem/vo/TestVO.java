package co.syeon.mem.vo;

import java.sql.Date;

public class TestVO {
	private String id;
	private String name;
	private String password;
	private Date signdate;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getSigndate() {
		return signdate;
	}
	public void setSigndate(Date signdate) {
		this.signdate = signdate;
	}
	public void setSigndate(String parameter) {
		// TODO Auto-generated method stub
		
	}
}
