package com.test.example;

public class Ex47_Override {

	public static void main(String[] args) {
		//Ex47_Override.java
		
		//메소드 오버라이드, Method Override
		//	- 메소드 재정의 > 상속 할 때 발생
		//	- 메소드 오버로딩 vs 메소드 오버라이딩
	
		OverrideParent p = new OverrideParent();
		p.hello();
		
		OverrideChild c = new OverrideChild();
		//c.hello(); //자식메소드에 의해 부모메소드가 가려짐 
		//c.hi();
		
	}
	
}

//동네 주민
class OverrideParent{
	public String name;
	public void hello() {
		System.out.println("안녕하세요.");
	}
}

class OverrideChild extends OverrideParent{
//	public void hi() {
//		System.out.println("하이~");
//	}
	
	//메소드 오버라이딩(재정의)
	public void hello() {
		System.out.println("하이~");
	}
}