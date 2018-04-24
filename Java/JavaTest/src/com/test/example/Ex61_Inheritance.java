package com.test.example;

public class Ex61_Inheritance {

	public static void main(String[] args) {
		//Ex61_Inheritance.java
		
		//private, public, this, super + 상속

		TestParent p1 = new TestParent();
		System.out.println(p1.a);
		//System.out.println(p1.b);
		p1.print();
		
		TestChild c1 = new TestChild(); //c1의 멤버 x 5개
		System.out.println(c1.a);
		//System.out.println(c1.b);
		System.out.println(c1.c);
		//System.out.println(c1.d);
		
		//오버라이딩된 자식의 print()가 아니고 부모의 print()를 호출
		c1.print();
		
	}
}


class TestParent {
	public int a = 10;
	private int b = 20;
	
	public void print() {
		System.out.println(this.a);
		System.out.println(this.b);
	}
}


class TestChild extends TestParent {
	public int c = 30;
	private int d = 40;
	
	public void print()/*프린트로 오버라이, 부모가 물려준 프린트가 있음에도 내가 재정의*/ {
		System.out.println(this.a);//public 부모가 물려준
		//System.out.println(this.b);//private 부모가 물려준
		System.out.println(this.c);//public 자기가 선언한
		System.out.println(this.d);//private 자기가 선언한
		
		
		// 부모가 물려준 private는 접근이 안되는 현상, why? 
		// 자식이라고 할지라도 부모가 열어준 public 메소드를 통해서 접근해야함
		
	}
	
	public void print2() {
		//나 자신
		this.print();
		
		//내 부모
		super.print();//슈퍼는 의미정도만 알고 있기 
	}
	
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		//return super.toString();//아무런 변화가 없는 코드
		
		
	}
	
}























