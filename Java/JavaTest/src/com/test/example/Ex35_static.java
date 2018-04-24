package com.test.example;

public class Ex35_static {

	public static void main(String[] args) {
		//Ex35_static.java
		
		//m1();
		m2();//잘못된 예시
		m3();
	}//main
	
	private static void m3() {
		
		//m1() vs m3() // m3는 완전히 종속시킴
		
		Mouse m1 = new Mouse();
		Mouse.setWholeCount(Mouse.getWholeCount() + 1);

		Mouse m2 = new Mouse();
		Mouse.setWholeCount(Mouse.getWholeCount() + 1);
		
		Mouse m3 = new Mouse();
		Mouse.setWholeCount(Mouse.getWholeCount() + 1);
	
		System.out.println("생산된 마우스 갯수: " + Mouse.getWholeCount());
		
	}//m3

	private static void m2() {
		
//		Mouse m1 = new Mouse();
//		//마우스에 만들었는데 static 안 붙였으니까 객체변수
//	    
//		//count = count + 1
//		m1.setTotalCount(m1.getTotalCount()+1);
//		
//		Mouse m2 = new Mouse();
//		m2.setTotalCount(m2.getTotalCount()+1);
//		
//		Mouse m3 = new Mouse();
//		m3.setTotalCount(m3.getTotalCount()+1);
//		
//		System.out.println("생산된 마우스 갯수: " + count);
		
	}//m2
	
	
	private static void m1() {
		
		int count = 0; //마우스 갯수
		
		Mouse m1 = new Mouse();
		count++;
		
		Mouse m2 = new Mouse();
		count++;
		
		Mouse m3 = new Mouse();
		count++;
		
		//의문1. count가 정말로 마우스 갯수가 맞아?
		System.out.println("생산된 마우스 갯수: " + count);
	}//m1
	
	
	
}//Ex35_static






class Mouse{

	//객체 정보(제각각 가져야 하는 개인 정보)
	private String model;
	private int price;
	private int buttons;
	
	private int totalCount; //x
	private static int wholeCount; //o
	
	//요구사항] 마우스 객체 종류에 상관없이 Mouse라는 설계도로부터 생산된 모든 마우스의 총 갯수를 관리하시오.
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getButtons() {
		return buttons;
	}
	public void setButtons(int buttons) {
		this.buttons = buttons;
	}
	
	
	
	
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	
	
	
	public static int getWholeCount() {
		return wholeCount;
	}
	public static void setWholeCount(int wholeCount) {
		Mouse.wholeCount = wholeCount;
	}
	
	
	
}