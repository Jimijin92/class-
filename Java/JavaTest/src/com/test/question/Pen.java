package com.test.question;

class Pen {
	
	//멤버변수
	private String color;
	private int ink;

	//기본생성자
	public Pen() {
		this("검정",100);
	}
	
	//오버로딩 생성자
	public Pen(String color, int ink) {
		this.color = color;
		this.ink = ink;
	}

	public Pen(String color) {
		this.color = color;
		this.ink = 100;
	}
	
	public Pen(int ink) {
		this.color = "검정";
		this.ink = ink;
	}
	
	//메소드 구현
	public void drawLine() {
		System.out.printf("%s색으로 선을 그렸습니다", this.color);
	}
	
	
	
	
}