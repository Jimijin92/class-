package com.project2.mvc.model;

public class TblOpenCourseDTO {

	private String o_cou_seq; //개설과정 pk
	private String cl_seq; //강의실 pk
	private String cou_seq; //과정코드
	private String start_date; //시작일
	private String end_date; //끝일
	private String t_id;//선생님 아이디
	private String m_id;//매니저 아이디
	private String state; //삭제여부라는데
	
	
	public String getO_cou_seq() {
		return o_cou_seq;
	}
	public void setO_cou_seq(String o_cou_seq) {
		this.o_cou_seq = o_cou_seq;
	}
	public String getCl_seq() {
		return cl_seq;
	}
	public void setCl_seq(String cl_seq) {
		this.cl_seq = cl_seq;
	}
	public String getCou_seq() {
		return cou_seq;
	}
	public void setCou_seq(String cou_seq) {
		this.cou_seq = cou_seq;
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
	public String getT_id() {
		return t_id;
	}
	public void setT_id(String t_id) {
		this.t_id = t_id;
	}
	public String getM_id() {
		return m_id;
	}
	public void setM_id(String m_id) {
		this.m_id = m_id;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
	
	
	
	
	
	
}
