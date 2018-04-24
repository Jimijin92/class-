package com.common;

import java.util.HashMap;

public class Teacher {
	private String TJumin ;		//주민번호
	private String TId ;		//ID(아이디)
	private String TPw ;		//pw(비밀번호)
	private String TName ;		//이름
	private String TGender ;	//성별
	private String TAge ;		//나이
	private String TAddress ;	//주소
	private String TTel ;		//휴대폰번호
	private String TUniv;		//대학교명
	private String TDepart ;	//학과
	private String TGrade ;		//학년
	
	private String TCareer ;						//과외경력
	private String[] TZone = new String[3] ;		//희망교습지역 (3개 고정 배열)
	private String TTarget ;						//교습대상
	private String TPrice ;							//회당 가격
	private String[] TSubject = new String[2] ;	//교습과목 (2개 고정배열)
	
	HashMap<String,String> TStar = new HashMap<String,String>() ;		//별점 - class 따로빼기
	
	private String TDivision ;	//식별번호
	private String TNumber ;		//고유번호
	

	@Override
	public String toString() {
		return String.format("[주민번호][%s][id][%s][pw][%s][이름][%s]\n[성별][%s][나이][%s][주소][%s][핸드폰번호][%s]\n[대학교명][%s][학과][%s][학년][%s]\n[과외경력][%s][희망교습지역1][%s][희망교습지역2][%s][희망교습지역3][%s]\n[교습대상][%s][회당 가격][%s][교습과목1][%s][교습과목2][%s]\n[별점][%s]\n[식별번호][%s][고유번호][%s]\n\n"
								,this.TJumin,this.TId,this.TPw,this.TName
								,this.TGender,this.TAge,this.TAddress,this.TTel
								,this.TUniv,this.TDepart,this.TGrade
								,this.TCareer,this.TZone[0],this.TZone[1],this.TZone[2]
								,this.TTarget,this.TPrice
								,this.TSubject[0],this.TSubject[1]
								,TStar
								,this.TDivision,this.TNumber);
	}
	
	public String getTJumin() {
		return TJumin;
	}
	public void setTJumin(String tJumin) {
		TJumin = tJumin;
	}
	public String getTId() {
		return TId;
	}
	public void setTId(String tId) {
		TId = tId;
	}
	public String getTPw() {
		return TPw;
	}
	public void setTPw(String tPw) {
		TPw = tPw;
	}
	public String getTName() {
		return TName;
	}
	public void setTName(String tName) {
		TName = tName;
	}
	public String getTGender() {
		return TGender;
	}
	public void setTGender(String tGender) {
		TGender = tGender;
	}
	public String getTAge() {
		return TAge;
	}
	public void setTAge(String tAge) {
		TAge = tAge;
	}
	public String getTAddress() {
		return TAddress;
	}
	public void setTAddress(String tAddress) {
		TAddress = tAddress;
	}
	public String getTTel() {
		return TTel;
	}
	public void setTTel(String tTel) {
		TTel = tTel;
	}
	public String getTUniv() {
		return TUniv;
	}
	public void setTUniv(String tUniv) {
		TUniv = tUniv;
	}
	public String getTDepart() {
		return TDepart;
	}
	public void setTDepart(String tDepart) {
		TDepart = tDepart;
	}
	public String getTGrade() {
		return TGrade;
	}
	public void setTGrade(String tGrade) {
		TGrade = tGrade;
	}
	public String getTCareer() {
		return TCareer;
	}
	public void setTCareer(String tCareer) {
		TCareer = tCareer;
	}
	public String[] getTZone() {
		return TZone;
	}
	public void setTZone(String[] tZone) {
		TZone = tZone;
	}
	public String getTTarget() {
		return TTarget;
	}
	public void setTTarget(String tTarget) {
		TTarget = tTarget;
	}

	public String getTPrice() {
		return TPrice;
	}
	public void setTPrice(String tPrice) {
		TPrice = tPrice;
	}
	public String[] getTSubject() {
		return TSubject;
	}
	public void setTSubject(String[] tSubject) {
		TSubject = tSubject;
	}
	public HashMap<String, String> getTStar() {
		return TStar;
	}
	public void setTStar(HashMap<String, String> tStar) {
		TStar = tStar;
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
