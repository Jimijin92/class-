package com.test.example;

public class Ex60_Generic {

	public static void main(String[] args) {
		
		//Ex60_Generic.java
		Paper<Integer> p1 = new Paper<Integer>();//값형 표시는 못들어감 , 참조형만 들어갈 수 있음
		p1.n = 100;
		System.out.println(p1.n + 100);
		
		Paper<String> p2 = new Paper<String>();
		p2.n = "홍길동";
		p2.n = 100;
		System.out.println(p2.n.length());
		
		Paper<Boolean> p3 = new Paper<Boolean>();
		p3.n = true;
		System.out.println(p3.n);
	
		
		Bag<Double> b1 = new Bag<Double>();
	    b1.test(3.14);
	    
	    Bag<Double> b2 = new Bag<Double>();
	    b2.test(new Random());
	    
		
	    Desk<Integer,String> d1 = new Desk<Integer,String>();
	    d1.a = 10;
	    d1.b = "문자열";
	    int result = d1.test("문자열");
	    
		
	}
	
}

class Desk<T,U>{
	public T a;
	public U b;
	public T test(U u) {
		return a;
	}
	
}




class Coffee<T> {
	public T a;
	public T b;
	public T c;
	public T test(T t) {
		return t;
		//읽기전용 , 덮어쓰기 안 됨
	}
	
	public T test(T t1, T t2) {
		return t1;
	}
	
	
}




class Bag<T>{
	public String name;
	public T test(T t) {
		return t; 
	}
	
}




//제네릭 클래스
//	- T : 타입 변수(데이터를 담는 용도X, 자료형 자체를 담는 용도O)
class Paper<T> {
	public T n; //타입 변수 사용 용도
	//나머지는 일반 클래스와 동일
	public int m;
	public void test() {
		
	}
	
	
class Bag<T>{
	public String name;
	public void test(T t)
	
}
	
}