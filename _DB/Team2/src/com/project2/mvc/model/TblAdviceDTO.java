package com.project2.mvc.model;

public class TblAdviceDTO {
	private String ad_seq;//상담번호(pk)
    private String content;//교재명
    private String ad_date;//상담날짜
	private String m_id;//관리자 코드(fk)
    private String st_cou_seq;//과정학생번호(fk)    
    
    public String getAd_seq() {
		return ad_seq;
	}
	public void setAd_seq(String ad_seq) {
		this.ad_seq = ad_seq;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getAd_date() {
		return ad_date;
	}
	public void setAd_date(String ad_date) {
		this.ad_date = ad_date;
	}
	public String getM_id() {
		return m_id;
	}
	public void setM_id(String m_id) {
		this.m_id = m_id;
	}
	public String getSt_cou_seq() {
		return st_cou_seq;
	}
	public void setSt_cou_seq(String st_cou_seq) {
		this.st_cou_seq = st_cou_seq;
	}

}
