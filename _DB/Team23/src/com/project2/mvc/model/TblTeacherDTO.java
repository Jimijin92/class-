package com.project2.mvc.model;

public class TblTeacherDTO {

	private String t_id;	//선생님 식별코드 'B1'
	private String name;	//선생님 이름
	private String ssn;	//주민번호
	private String phone_number;	//휴대폰 번호
	private String password;		//변경한 비밀번호
	private String state;	//선생님 재직상태
	
	
	public String getT_id() {
		return t_id;
	}
	public void setT_id(String t_id) {
		this.t_id = t_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSsn() {
		return ssn;
	}
	public void setSsn(String ssn) {
		this.ssn = ssn;
	}
	public String getPhone_number() {
		return phone_number;
	}
	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
	
	
}
