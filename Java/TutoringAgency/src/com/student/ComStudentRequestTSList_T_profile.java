package com.student;

import java.util.ArrayList;

public class ComStudentRequestTSList_T_profile {
	//선생님이 학생 신청할때 나오는 목록 들어갈것!
	private int listnumber ;		//번호
	private String TNumber ; //선생님 고유번호
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.format("번호 : %d 고유번호 : %s",listnumber,TNumber);
	}
	
	public int getListnumber() {
		return listnumber;
	}
	public void setListnumber(int listnumber) {
		this.listnumber = listnumber;
	}
	public String getTNumber() {
		return TNumber;
	}
	public void setTNumber(String tNumber) {
		TNumber = tNumber;
	}

	
	
}
