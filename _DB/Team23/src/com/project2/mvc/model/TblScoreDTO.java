package com.project2.mvc.model;

public class TblScoreDTO {

	private String sco_seq ; // 성적번호, PK   
    private int org_w_score;//필기성적 원점수
    private int org_p_score;//실기성적 원점수
    private int org_a_score;//출결점수 원점수
    private int f_w_score;//필기성적 환산점수
    private int f_p_score;//실기성적 환산점수
    private int f_a_score;//출결점수 환산점수
    private String o_sub_seq;//개설과목코드, FK
    private String st_cou_seq;//과정학생번호, FK	
	public String getSco_seq() {
		return sco_seq;
	}
	public void setSco_seq(String sco_seq) {
		this.sco_seq = sco_seq;
	}
	public int getOrg_w_score() {
		return org_w_score;
	}
	public void setOrg_w_score(int org_w_score) {
		this.org_w_score = org_w_score;
	}
	public int getOrg_p_score() {
		return org_p_score;
	}
	public void setOrg_p_score(int org_p_score) {
		this.org_p_score = org_p_score;
	}
	public int getOrg_a_score() {
		return org_a_score;
	}
	public void setOrg_a_score(int org_a_score) {
		this.org_a_score = org_a_score;
	}
	public int getF_w_score() {
		return f_w_score;
	}
	public void setF_w_score(int f_w_score) {
		this.f_w_score = f_w_score;
	}
	public int getF_p_score() {
		return f_p_score;
	}
	public void setF_p_score(int f_p_score) {
		this.f_p_score = f_p_score;
	}
	public int getF_a_score() {
		return f_a_score;
	}
	public void setF_a_score(int f_a_score) {
		this.f_a_score = f_a_score;
	}
	public String getO_sub_seq() {
		return o_sub_seq;
	}
	public void setO_sub_seq(String o_sub_seq) {
		this.o_sub_seq = o_sub_seq;
	}
	public String getSt_cou_seq() {
		return st_cou_seq;
	}
	public void setSt_cou_seq(String st_cou_seq) {
		this.st_cou_seq = st_cou_seq;
	}
    
   
	
	
}
