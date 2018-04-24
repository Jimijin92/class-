package com.project2.mvc.model;

public class TblGoSickDTO {
	
	private String go_sick_seq; //외출병가번호, PK
	private String go_seq;//외출번호, FK
	
	public String getGo_sick_seq() {
		return go_sick_seq;
	}
	public void setGo_sick_seq(String go_sick_seq) {
		this.go_sick_seq = go_sick_seq;
	}
	public String getGo_seq() {
		return go_seq;
	}
	public void setGo_seq(String go_seq) {
		this.go_seq = go_seq;
	}
	

	
}
