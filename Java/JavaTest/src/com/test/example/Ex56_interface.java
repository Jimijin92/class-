package com.test.example;

public class Ex56_interface {

	public static void main(String[] args) {
	//Ex56_interface.java
	
	//지난 수업
	//일반클래스 < 일반 클래스
	//추상클래스 < 일반 클래스
	//일반클래스 < 추상 클래스 //x
	//추상클래스 < 추상 클래스
	
	//일반클래스 - 추상클래스 - 인터페이스 : 상속
	//1. 일반클래스 < 일반클래스 //***
	//2. 추상클래스 < 일반클래스 //일반멤버 상속, 추상메소드 구현 ***
	//3. 인터페이스 < 일반클래스 //추상메소드 구현 ***
	
	//4. 일반클래스 < 추상클래스 //X
	//5. 일반클래스 < 인터페이스 //X
	
	//6. 추상클래스 < 추상클래스 < 일반클래스 //O
	//7. 인터페이스 < 인터페이스 < 일반클래스 //O ***
	
	//8. 추상클래스 < 인터페이스 < 일반클래스 //5, X
	//9. 인터페이스 < 추상클래스 < 일반클래스 //O **
		
	}
	
}



class AAAA{
	//public int num;
	public void aaaaa() {
		
	}
}

interface BBBBB extends AAAAA {
	public int num;
	void bbbbb ();
}