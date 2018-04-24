package com.test.example;

import org.omg.CORBA.INTERNAL;

public class Ex62_Wrapper {

	
	public static void main(String[] args) {
	
	
	//값형에 대응하는 참조형 클래스가 제공된다.
	//	-> Wrapper Class, Utility Class
	//int -> Integer
	//double -> Double
	//boolean -> Boolean
	
	int n1 = 10;					//값형
	Integer n2 = new Integer(20);	//참조형
		
	System.out.println(n1 + 10);
	System.out.println(n2 + 10);
	
	//추가 기능
	int n3 = Integer.parseInt("100");
	System.out.println(Integer.MAX_VALUE);//뒤에 소괄호 없으니 변수, 대문자니 파이널 상수, 스테틱상수
	System.out.println(Integer.MIN_VALUE);
	
	System.out.println(Integer.compare(10, 20)); // -1
	System.out.println(Integer.compare(20, 10)); //  1
	System.out.println(Integer.compare(10, 10)); //  0
	
	System.out.println(Integer.SIZE);//인티저가 몇 바이트인지, 자료형의 크기 반환
	System.out.println(Long.SIZE);//롱이 몇 바이트인지, 자료형의 크기 반환
	
	System.out.println(Integer.max(10, 5));
	System.err.println(Integer.min(10, 5));
	
	System.out.println(Integer.toBinaryString(10));
	System.out.println(Integer.toHexString(20));
	System.out.println(Integer.toOctalString(10));

	
	
	}
}
