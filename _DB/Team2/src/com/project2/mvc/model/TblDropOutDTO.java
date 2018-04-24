package com.project2.mvc.model;

public class TblDropOutDTO {
	private String drop_seq; //중퇴 현황번호
	private String reason; //중퇴 사유
	private String drop_date; //날짜
	private String st_cou_seq; //과정학생번호
	
	
	public String getDrop_seq() {
		return drop_seq;
	}
	public void setDrop_seq(String drop_seq) {
		this.drop_seq = drop_seq;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public String getDrop_date() {
		return drop_date;
	}
	public void setDrop_date(String drop_date) {
		this.drop_date = drop_date;
	}
	public String getSt_cou_seq() {
		return st_cou_seq;
	}
	public void setSt_cou_seq(String st_cou_seq) {
		this.st_cou_seq = st_cou_seq;
	}
	
	
}
