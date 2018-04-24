package com.project2.mvc.model;

public class TblGoHomeDTO {

	private String go_home_seq; //조퇴병가번호, PK
	private String att_seq; //조퇴번호, FK
	private String reason; //조퇴이유
	
	public String getGo_home_seq() {
		return go_home_seq;
	}
	public void setGo_home_seq(String go_home_seq) {
		this.go_home_seq = go_home_seq;
	}
	public String getAtt_seq() {
		return att_seq;
	}
	public void setAtt_seq(String att_seq) {
		this.att_seq = att_seq;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}

}
