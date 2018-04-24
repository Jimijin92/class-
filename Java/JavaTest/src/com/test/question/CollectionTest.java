package com.test.question;

import java.util.ArrayList;

public class CollectionTest {

	public static void main(String[] args) {
		
		//컬렉션 클래스를 선언하시오.
	
		//공통
		//	a. 멤버변수
		//	b. 생성자
		//  c. toString()
		
		
		//1. ArrayList
		//	a. add X 2개 그냥 Array 끼워넣는 Array
		//	b. get
		//	c. set
		//	d. remove
		//	e. size
		//	d. trimToSize
		
		A();
		
		//2. HashMap (배열 2개)
		//	a. put : 추가, 수정
		//	b. get
		//	c. remove
		//	d. size
		//	e. trimToSize
		
		//3. Stack (배열 1개)
		//	a. push
		//	b. pop
		//	c. size
		//	d. peek
		//	e. trimToSize
		
		//4. Queue (배열 1개)
		//	a. add
		//	b. poll
		//  c. size
		//  d. peek
		//  e. trimToSize
		
		
		
		
	}//main

	private static void A() {
		
		MyArrayListGroup2 list = new MyArrayListGroup2();
		
		//a-1 요소 추가하기
		list.add("지미진");
		list.add("문창현");
		list.add("홍세진");
		list.add("박애리");
		list.add("지미라");
		list.add("지미라");
		list.add("지미라");
		
		list.set(0, "mijin0");
		System.out.println(list.size());
		System.out.println(list.get(0));
		System.out.println(list.get(1));
		System.out.println(list.get(2));
		System.out.println(list.get(3));
		//a-2 
		
		
		
	}
	
}//CollectionTest
