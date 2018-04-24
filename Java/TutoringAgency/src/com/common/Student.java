package com.common;



public class Student {
	private String SJumin ;		//주민번호
	private String SId ;		//ID(아이디)
	private String SPw ;		//pw(비밀번호)
	private String SName ;		//이름
	private String SGender ;	//성별
	private String SAge ;		//나이
	private String SAddress ;	//주소
	private String STel ;		//휴대폰번호
	
	private String SHighSchool;	//고등학교명
	
	private String SDepart ;	//계열
	private String SGrade ;		//학년
	
	private String SWantGender ;		//원하는 선생님 성별
	private String SPrice ;				//희망 회차별 가격
	private String[] SSubject = new String[2] ;	//희망교습과목

	
	private String SDivision ;	//식별번호
	private String SNumber ;		//고유번호
	
	
	@Override
	public String toString() {
		return String.format("[주민번호][%s][id][%s][pw][%s][이름][%s]\n[성별][%s][나이][%s][주소][%s][핸드폰번호][%s]\n[고등학교명][%s][계열][%s][학년][%s]\n[원하는 선생님 성별][%s]\n[희망 회차별 가격][%s][희망교습과목1][%s][희망교습과목2][%s]\n[식별번호][%s][고유번호][%s]\n\n"
								,this.SJumin,this.SId,this.SPw,this.SName
								,this.SGender,this.SAge,this.SAddress,this.STel
								,this.SHighSchool,this.SDepart,this.SGrade
								,this.SWantGender,this.SPrice,this.SSubject[0],this.SSubject[1]
								,this.SDivision,this.SNumber);
	}

	
	
	public String getSJumin() {
		return SJumin;
	}
	public void setSJumin(String sJumin) {
		SJumin = sJumin;
	}
	public String getSId() {
		return SId;
	}
	public void setSId(String sId) {
		SId = sId;
	}
	public String getSPw() {
		return SPw;
	}
	public void setSPw(String sPw) {
		SPw = sPw;
	}
	public String getSName() {
		return SName;
	}
	public void setSName(String sName) {
		SName = sName;
	}
	public String getSGender() {
		return SGender;
	}
	public void setSGender(String sGender) {
		SGender = sGender;
	}
	public String getSAge() {
		return SAge;
	}
	public void setSAge(String sAge) {
		SAge = sAge;
	}
	public String getSAddress() {
		return SAddress;
	}
	public void setSAddress(String sAddress) {
		SAddress = sAddress;
	}
	public String getSTel() {
		return STel;
	}
	public void setSTel(String sTel) {
		STel = sTel;
	}
	public String getSHighSchool() {
		return SHighSchool;
	}
	public void setSHighSchool(String sHighSchool) {
		SHighSchool = sHighSchool;
	}
	public String getSDepart() {
		return SDepart;
	}
	public void setSDepart(String sDepart) {
		SDepart = sDepart;
	}
	public String getSGrade() {
		return SGrade;
	}
	public void setSGrade(String sGrade) {
		SGrade = sGrade;
	}
	public String getSWantGender() {
		return SWantGender;
	}
	public void setSWantGender(String sWantGender) {
		SWantGender = sWantGender;
	}

	public String getSPrice() {
		return SPrice;
	}
	public void setSPrice(String sPrice) {
		SPrice = sPrice;
	}
	public String[] getSSubject() {
		return SSubject;
	}
	public void setSSubject(String[] sSubject) {
		SSubject = sSubject;
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
