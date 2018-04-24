package com.project2.mvc.model;

public class TblGoDTO {

	private String go_seq; //외출번호, PK
	private String att_seq;//출결번호, FK
	private String reason;//외출이유 
	
	public String getGo_seq() {
		return go_seq;
	}
	public void setGo_seq(String go_seq) {
		this.go_seq = go_seq;
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

