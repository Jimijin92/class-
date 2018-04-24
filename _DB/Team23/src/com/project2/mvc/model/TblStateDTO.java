package com.project2.mvc.model;

public class TblStateDTO {
	 private String state_seq;//상태번호, PK
     private String state;//상태
     
     
	public String getState_seq() {
		return state_seq;
	}
	public void setState_seq(String state_seq) {
		this.state_seq = state_seq;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
}
