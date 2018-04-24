package com.project2.mvc.model;

public class TblAvaSubjectDTO {

	private String ava_sub_seq;		//강의가능과목 번호
	private String t_id;		//선생님 식별코드 'B1'
	private String sub_seq;		//과목번호
	
	
	public String getAva_sub_seq() {
		return ava_sub_seq;
	}
	public void setAva_sub_seq(String ava_sub_seq) {
		this.ava_sub_seq = ava_sub_seq;
	}
	public String getT_id() {
		return t_id;
	}
	public void setT_id(String t_id) {
		this.t_id = t_id;
	}
	public String getSub_seq() {
		return sub_seq;
	}
	public void setSub_seq(String sub_seq) {
		this.sub_seq = sub_seq;
	}
	
	
	
}
