package com.project2.mvc.model;

public class TblAttendanceDTO {
	private String att_seq;//출결번호, PK
	private String st_cou_seq;//과정학생번호, FK
	private String state_seq;//상태번호, FK
	private String s_date;//날짜(시간포함)
	
	
	public String getAtt_seq() {
		return att_seq;
	}
	public void setAtt_seq(String att_seq) {
		this.att_seq = att_seq;
	}
	public String getSt_cou_seq() {
		return st_cou_seq;
	}
	public void setSt_cou_seq(String st_cou_seq) {
		this.st_cou_seq = st_cou_seq;
	}
	public String getState_seq() {
		return state_seq;
	}
	public void setState_seq(String state_seq) {
		this.state_seq = state_seq;
	}
	public String getS_date() {
		return s_date;
	}
	public void setS_date(String s_date) {
		this.s_date = s_date;
	}
	
}
