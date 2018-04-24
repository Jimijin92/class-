package com.common;

public class Application {
	private String HopeclassNumber ;		//신청현황번호
	private String TNumber ;				//선생님고유번호
	private String SNumber ;				//학생고유번호
	private String HopestartDay ;			//희망시작일
	
	private String Hopesubject ;			//희망과목
	private String HopestartTime ;			//희망시작시간
	private String Hopetime ;				//희망수업시간
	private String Hopeprice ;				//희망가격
	private String state ;					//상태
	private String[] days = new String[5] ;	//요일
	private String ask  ;						//신청
	

	@Override
	public String toString() {
		return String.format("[신청현황번호][%s][선생님고유번호][%s][학생고유번호][%s][희망시작일][%s]\n[희망과목][%s][희망시작시간][%s][희망수업시간][%s][희망가격][%s][상태][%s]\n[요일][%s][%s][%s][%s][%s][신청][%s]\n\n"
							,this.HopeclassNumber,this.TNumber,this.SNumber,this.HopestartDay
							,this.Hopesubject,this.HopestartTime,this.Hopetime,this.Hopeprice
							,this.state,this.days[0],this.days[1],this.days[2],this.days[3],this.days[4],this.ask);
	}
	
	
	public String getHopeclassNumber() {
		return HopeclassNumber;
	}
	public void setHopeclassNumber(String hopeclassNumber) {
		HopeclassNumber = hopeclassNumber;
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
	public String getHopestartDay() {
		return HopestartDay;
	}
	public void setHopestartDay(String hopestartDay) {
		HopestartDay = hopestartDay;
	}
	public String getHopesubject() {
		return Hopesubject;
	}
	public void setHopesubject(String hopesubject) {
		Hopesubject = hopesubject;
	}
	public String getHopeprice() {
		return Hopeprice;
	}
	public void setHopeprice(String hopeprice) {
		Hopeprice = hopeprice;
	}
	public String getHopestartTime() {
		return HopestartTime;
	}
	public void setHopestartTime(String hopestartTime) {
		HopestartTime = hopestartTime;
	}
	public String getHopetime() {
		return Hopetime;
	}
	public void setHopetime(String hopetime) {
		Hopetime = hopetime;
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
	
	public String getAsk() {
		return ask;
	}

	public void setAsk(String ask) {
		this.ask = ask;
	}


	
	
}
