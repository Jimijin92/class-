package com.project2.mvc.model;

public class TblStudentDTO {
	private String s_id; //학생 고유번호
	private String name; //이름
	private String birth_ssn; //생년월일
	private String ssn; //주민번호 뒷자리
	private String phone_number; //전화번호
	private String password; //패쓰워드
	private String state; //삭제상태번호 
						//(1: 유지 , 0 : 삭제 , defualt)
	
	public String getS_id() {
		return s_id;
	}
	public void setS_id(String s_id) {
		this.s_id = s_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBirth_ssn() {
		return birth_ssn;
	}
	public void setBirth_ssn(String birth_ssn) {
		this.birth_ssn = birth_ssn;
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
