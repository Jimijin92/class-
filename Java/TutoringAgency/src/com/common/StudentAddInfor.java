package com.common;

public class StudentAddInfor {
	
	private String SSelfIntro ;	//학생 자기소개
	
	private String SDivision ;	//식별번호
	private String SNumber ;		//고유번호
	
	@Override
	public String toString() {
		return String.format("[학생 자기소개][%s]\n[식별번호][%s][고유번호][%s]\n\n"
								,this.SSelfIntro
								,this.SDivision,this.SNumber);
	}
	
	public String getSSelfIntro() {
		return SSelfIntro;
	}
	public void setSSelfIntro(String sSelfIntro) {
		SSelfIntro = sSelfIntro;
	}
	public String getSDivision() {
		return SDivision;
	}
	public void setSDivision(String sDivision) {
		SDivision = sDivision;
	}
	public String getSNumber() {
		return SNumber;
	}
	public void setSNumber(String sNumber) {
		SNumber = sNumber;
	}
	
	
}
