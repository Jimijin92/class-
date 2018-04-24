package com.project2.mvc.model;

public class TblManagerDTO {

	private String m_id;	//매니저 식별코드 'A1'
	private String password;	//변경한 비밀번호
	private String ssn;	//주민번호
	private String name;	//매니저 이름
	
	
	public String getM_id() {
		return m_id;
	}
	public void setM_id(String m_id) {
		this.m_id = m_id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSsn() {
		return ssn;
	}
	public void setSsn(String ssn) {
		this.ssn = ssn;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	
	
	
	
}
