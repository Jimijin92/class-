package com.common;

public class TeacherAddInfor {
	private String TSpecialNote ;	//특이사항
	private String TStyle ;			//교습스타일
	private String TSelfIntro ;		//자기소개
	
	private String TDivision ;		//식별번호
	private String TNumber ;		//고유번호
	
	@Override
	public String toString() {
		return String.format("[특이사항][%s][교습스타일][%s]\n[자기소개][%s]\n[식별번호][%s][고유번호][%s]\n\n"
								,this.TSpecialNote
								,this.TStyle,this.TSelfIntro
								,this.TDivision,this.TNumber);
	}
	
	
	public String getTSpecialNote() {
		return TSpecialNote;
	}
	public void setTSpecialNote(String tSpecialNote) {
		TSpecialNote = tSpecialNote;
	}
	public String getTStyle() {
		return TStyle;
	}
	public void setTStyle(String tStyle) {
		TStyle = tStyle;
	}
	public String getTSelfIntro() {
		return TSelfIntro;
	}
	public void setTSelfIntro(String tSelfIntro) {
		TSelfIntro = tSelfIntro;
	}
	public String getTDivision() {
		return TDivision;
	}
	public void setTDivision(String tDivision) {
		TDivision = tDivision;
	}
	public String getTNumber() {
		return TNumber;
	}
	public void setTNumber(String tNumber) {
		TNumber = tNumber;
	}
	
	
}
