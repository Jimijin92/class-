package com.student;

import java.util.ArrayList;
import java.util.HashMap;


	//선생님 찾기에서 필터링 조건들 저장하는 클래스.
	//미 선택 사항들은 무관으로 간주(조건에 상관없이 전부 출력)
	
//선생님찾기 조건들을 임시로 저장하는 클래스


public class ComStudentSearchTemp {
	
	//선생님 찾기 필터링

	 private String address;	//주소 대분류(ex.서울시)
	 private String address2;	//주소 소분류(ex.중랑구)
	
	 private String gender; //성별
	 private String special;//특이사항
	 private String school;	//
	
	 private String subject;
	 private String career;
	 private String price;
	 
	 
//	 private HashMap<String,ArrayList<String>> filter = new HashMap<String,ArrayList<String>>();
//	 
	 
	 
	 
	 @Override
	public String toString() {
		return "ComStudentSearchTemp [getGender()=" + getGender() + ", getSpecial()=" + getSpecial() + ", getSchool()="
				+ getSchool() + ", getCareer()=" + getCareer() + ", getSubject()=" + getSubject() + ", getPrice()="
				+ getPrice() + ", getAddress()=" + getAddress() + ", getAddress2()=" + getAddress2() + "]";
		
		
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getSpecial() {
		return special;
	}
	public void setSpecial(String special) {
		this.special = special;
	}
	public String getSchool() {
		return school;
	}
	public void setSchool(String school) {
		this.school = school;
	}
	public String getCareer() {
		return career;
	}
	public void setCareer(String career) {
		this.career = career;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getAddress2() {
		return address2;
	}
	public void setAddress2(String address2) {
		this.address2 = this.address+address2;
	}
	 
	 
	 
	 
	
}
