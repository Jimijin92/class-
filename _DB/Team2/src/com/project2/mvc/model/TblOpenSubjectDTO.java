package com.project2.mvc.model;

public class TblOpenSubjectDTO {
	
	private String o_sub_seq; //개설과목코드 
	private String sub_seq; //과목코드
	private String start_date;
	private String end_date;
	private String book_seq; //교재번호
	private String o_cou_seq; //개설과정코드
	
	private int w_ratio; //필기배점
	private int p_ratio; //실기배점
	private int at_ratio; //출결배점
	
	private String w_test; //필기 시험일
	private String p_test; //실기 시험일
	
	
	public String getO_sub_seq() {
		return o_sub_seq;
	}
	public void setO_sub_seq(String o_sub_seq) {
		this.o_sub_seq = o_sub_seq;
	}
	public String getSub_seq() {
		return sub_seq;
	}
	public void setSub_seq(String sub_seq) {
		this.sub_seq = sub_seq;
	}
	public String getStart_date() {
		return start_date;
	}
	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}
	public String getEnd_date() {
		return end_date;
	}
	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}
	public String getBook_seq() {
		return book_seq;
	}
	public void setBook_seq(String book_seq) {
		this.book_seq = book_seq;
	}
	public String getO_cou_seq() {
		return o_cou_seq;
	}
	public void setO_cou_seq(String o_cou_seq) {
		this.o_cou_seq = o_cou_seq;
	}
	public int getW_ratio() {
		return w_ratio;
	}
	public void setW_ratio(int w_ratio) {
		this.w_ratio = w_ratio;
	}
	public int getP_ratio() {
		return p_ratio;
	}
	public void setP_ratio(int p_ratio) {
		this.p_ratio = p_ratio;
	}
	public int getAt_ratio() {
		return at_ratio;
	}
	public void setAt_ratio(int at_ratio) {
		this.at_ratio = at_ratio;
	}
	public String getW_test() {
		return w_test;
	}
	public void setW_test(String w_test) {
		this.w_test = w_test;
	}
	public String getP_test() {
		return p_test;
	}
	public void setP_test(String p_test) {
		this.p_test = p_test;
	}
	
	
	
	
	
	

}
