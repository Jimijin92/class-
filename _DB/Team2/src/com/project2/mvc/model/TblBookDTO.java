package com.project2.mvc.model;

public class TblBookDTO {
	private String book_seq; //교재코드
	private String name; //교재명
	private String book_stock; //교재 재고 현황
	private String pub_seq; //출판사 코드
	
	public String getBook_seq() {
		return book_seq;
	}
	public void setBook_seq(String book_seq) {
		this.book_seq = book_seq;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBook_stock() {
		return book_stock;
	}
	public void setBook_stock(String book_stock) {
		this.book_stock = book_stock;
	}
	public String getPub_seq() {
		return pub_seq;
	}
	public void setPub_seq(String pub_seq) {
		this.pub_seq = pub_seq;
	}

	
	
}
