package com.project2.mvc.model;

public class TblPublisherDTO {
	private String pub_seq;//출판사 코드, PK
	private String name;//출판사 명
	private String state;//삭제여부
	
	public String getPub_seq() {
		return pub_seq;
	}
	public void setPub_seq(String pub_seq) {
		this.pub_seq = pub_seq;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
	

	
}
