package com.project2.mvc.model;

public class TblCaseDTO {
	private String state_seq;//상태번호, FK
	private String f_att_seq;//최종번호, FK
	
	
	public String getState_seq() {
		return state_seq;
	}
	public void setState_seq(String state_seq) {
		this.state_seq = state_seq;
	}
	public String getF_att_seq() {
		return f_att_seq;
	}
	public void setF_att_seq(String f_att_seq) {
		this.f_att_seq = f_att_seq;
	}
}
