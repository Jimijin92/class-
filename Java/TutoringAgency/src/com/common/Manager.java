package com.common;

public class Manager {
	private String MJumin ;		//주민번호
	private String MId ;		//ID(아이디)
	private String MPw ;		//pw(비밀번호)
	private String MName ;		//이름
	
	private String MDivision ;	//식별번호
	private String MNumber ;		//고유번호
	
	@Override
	public String toString() {
		return String.format("[주민번호][%s] [id][%s] [pw][%s] [이름][%s]\n[식별번호][%s] [고유번호][%s]\n\n"
								,this.MJumin,this.MId,this.MPw,this.MName
								,this.MDivision,this.MNumber);
	}
	
	
	public String getMJumin() {
		return MJumin;
	}
	public void setMJumin(String mJumin) {
		MJumin = mJumin;
	}
	public String getMId() {
		return MId;
	}
	public void setMId(String mId) {
		MId = mId;
	}
	public String getMPw() {
		return MPw;
	}
	public void setMPw(String mPw) {
		MPw = mPw;
	}
	public String getMName() {
		return MName;
	}
	public void setMName(String mName) {
		MName = mName;
	}
	public String getMDivision() {
		return MDivision;
	}
	public void setMDivision(String mDivision) {
		MDivision = mDivision;
	}
	public String getMNumber() {
		return MNumber;
	}
	public void setMNumber(String mNumber) {
		MNumber = mNumber;
	}
	
	
}
