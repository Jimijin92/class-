package com.common;

public class Schedule {
	private String classNumber ;		//수업번호
	private String TNumber ;			//선생님고유번호
	private String SNumber ;			//학생고유번호
	private String startDay ;			//시작일
	
	private String subject ;			//과목
	private String price ;				//가격
	private String startTime ;			//시작시간
	private String time ;				//수업시간
	
	private String Tcancel ;			//선생님취소횟수
	private String Scancel ;			//학생취소횟수
	private String totalCancel ;		//총 취소횟수
	
	private String state ;				//상태
	private String[] days = new String[5] ;		//요일
	
	//새로 추가 (2017.01.08)
	
	private String star ;		//각 스케쥴당 별 -> 이게 있어야 평가를 했는지 안했는지 알 수 있어서,
	
	public String getStar() {
		return star;
	}

	public void setStar(String star) {
		this.star = star;
	}

	@Override
	public String toString() {
		return String.format("[수업번호][%s][선생님고유번호][%s][학생고유번호][%s][시작일][%s]\n[과목][%s][가격][%s][시작시간][%s][수업시간][%s]\n[선생님취소횟수][%s][학생취소횟수][%s][총 취소횟수][%s]\n[상태][%s][요일][%s][%s][%s][%s][%s][별점][%s]\n\n"
							,this.classNumber,this.TNumber,this.SNumber,this.startDay
							,this.subject,this.price,this.startTime,this.time
							,this.Tcancel,this.Scancel,this.totalCancel
							,this.state,this.days[0],this.days[1],this.days[2],this.days[3],this.days[4],star);
	}
	
	public String getClassNumber() {
		return classNumber;
	}
	public void setClassNumber(String classNumber) {
		this.classNumber = classNumber;
	}
	public String getTNumber() {
		return TNumber;
	}
	public void setTNumber(String tNumber) {
		TNumber = tNumber;
	}
	public String getSNumber() {
		return SNumber;
	}
	public void setSNumber(String sNumber) {
		SNumber = sNumber;
	}
	public String getStartDay() {
		return startDay;
	}
	public void setStartDay(String startDay) {
		this.startDay = startDay;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getTcancel() {
		return Tcancel;
	}
	public void setTcancel(String tcancel) {
		Tcancel = tcancel;
	}
	public String getScancel() {
		return Scancel;
	}
	public void setScancel(String scancel) {
		Scancel = scancel;
	}
	public String getTotalCancel() {
		return totalCancel;
	}
	public void setTotalCancel(String totalCancel) {
		this.totalCancel = totalCancel;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String[] getDays() {
		return days;
	}
	public void setDays(String[] days) {
		this.days = days;
	}
	
	
	
}
