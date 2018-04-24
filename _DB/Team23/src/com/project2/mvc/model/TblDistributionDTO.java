package com.project2.mvc.model;

public class TblDistributionDTO {//교재배부 
	
	
	
	private String book_seq; //교재코드
	private String st_cou_seq; //과정학생번호
	
	
	public String getBook_seq() {
		return book_seq;
	}
	public void setBook_seq(String book_seq) {
		this.book_seq = book_seq;
	}
	public String getSt_cou_seq() {
		return st_cou_seq;
	}
	public void setSt_cou_seq(String st_cou_seq) {
		this.st_cou_seq = st_cou_seq;
	}
	
	

	

}
