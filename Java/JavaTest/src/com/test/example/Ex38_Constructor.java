package com.test.example;

public class Ex38_Constructor {
	
	public static void main(String[] args) {
	
		//Ex38_Constructor.java
		
		//Speaker s1 = new Speaker();
		Speaker s1 = new Speaker();
		//Speaker.count = Speaker.count + 1;
		
		Speaker s2 = new Speaker();
		
		Speaker s3 = new Speaker();
		
		Speaker s4 = new Speaker();
		
		System.out.println(Speaker.count);
		
	}
}

class Speaker{

	private String model;
	private String type;
	
	public static int count; //스피커 객체 총 갯수
	
	public Speaker() {
		this.model = "A100";
		this.type = "Portable";
		
		Speaker.count = Speaker.count + 1; //Speaker.count = 10;랑은 다른 성질의 행동임

		//정적 변수의 초기화는 절대로 객체 생성자에서 하면 안된다.(***)
		//객체 생성자에서는 반드시 객체 멤버만 초기화를 한다.(*******)
		//Speaker.count = 10;
	}
	
	//정적 생성자
	static {
		Speaker.count = 10;
	}
	
}























