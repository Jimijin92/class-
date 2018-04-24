package com.test.collection;

import java.util.ArrayList;
import java.util.LinkedList;

import org.omg.Messaging.SyncScopeHelper;

public class Ex81_Collection {

	public static void main(String[] args) {
		
		//Ex81_Collection.java
		
		//LinkedList
		//	- Queue queue = new LinkedList();
		//	- List 인터페이스 구현
		//	- ArrayList와 사용법이나 성질이 비슷함
		//	- 데이터 추가/삭제가 용이하다.
		
		
		//ArrayList vs LinkedList
		//(연속적)  vs (비연속적)
		
		//1. 기본 LinkedList
		//	- 이전 데이터의 접근이 불편하다.
		//	- 데이터 추가/삭제가 용이하다.
	
		
		//2. Double LinkedList
		//	- 이전 요소의 주소도 같이 기억(접근성 향상)
		
		
		//3. Double Circular LinkedList
		//	- 처음 요소와 마지막 요소를 연결
		// 	- 자바의 LinkedList는 Double Circular LinkedList이다.
		
		ArrayList<Integer> aList = new ArrayList<Integer>();
		LinkedList<Integer> lList = new LinkedList<Integer>();
		
		aList.add(100);
		aList.add(200);
		aList.add(300);
		
		lList.add(100);
		lList.add(200);
		lList.add(300);
		
		System.out.println(aList.size());
		System.out.println(lList.size());
		
		System.out.println(aList.get(0));
		System.out.println(lList.get(0));
		
		aList.add(1, 500);
		lList.add(1, 500);

		aList.remove(0);
		lList.remove(0);
		
		aList.remove(200);
		lList.remove(200);
	
		for(int n : aList) System.out.println(n);
		for(int n : lList) System.out.println(n);
		
		
		//차이점? -> 둘 중 어떤것을 사용할지 결정하는 요소 
	
		//ArrayList
		//	- 장점
		//	: 컬렉션 중 요소에 대한 접근 속도가 가장 빠르다. (방 찾기가 빠르다)(번호로 접근하는게 아니고 계산으로 접근해서...)
		//	- 단점
		//	: 요소의 추가/삭제시 작업 비용이 많이 발생한다.(느리다.)
		
		//LinkedList
		//	- 장점
		//	: 요소의 추가/삭제 작업 비용이 적게 발생한다.(빠르다.)
		//	- 단점
		//	: 컬렉션 중 요소에 대한 접근 속도가 느리다.(방 찾기가 느리다.)
		
		//1. 순차적으로 데이터 추가하기. Append
		System.out.println("순차적으로 데이터 추가하기");
		
		long begin = 0, end = 0;
		
		
		begin = System.currentTimeMillis();
		
		//작업
		for (int i=0; i<1000000; i++) {
			aList.add(i);
		}
		
		
		end = System.currentTimeMillis();
		System.out.println("작업 소요 시간 : " + (end - begin));
		                         
		
		
		
		
		
        begin = System.currentTimeMillis();
		
		//작업
		for (int i=0; i<1000000; i++) {
			lList.add(i);
		}
		
		
		end = System.currentTimeMillis();
		System.out.println("작업 소요 시간 : " + (end - begin));

		
		
		
		
		
		
		
		System.out.println("중간에 데이터 추가하기");
		
		begin = System.currentTimeMillis();
		
		//작업
		for (int i=0; i<10000; i++) {
			aList.add(100, i);
		}
		
		
		end = System.currentTimeMillis();
		System.out.println("작업 소요 시간 : " + (end - begin));

		
		
		
		
		begin = System.currentTimeMillis();
		
		//작업
		for (int i=0; i<10000; i++) {
			lList.add(i);
		}
		
		
		end = System.currentTimeMillis();
		System.out.println("작업 소요 시간 : " + (end - begin));

		
		
		
		
		System.out.println("중간에 데이터 삭제하기");
		
		begin = System.currentTimeMillis();
		
		//작업
		for (int i=0; i<10000; i++) {
			aList.remove(i);
		}
		
		
		end = System.currentTimeMillis();
		System.out.println("작업 소요 시간 : " + (end - begin));

		
		
		
		
		
		begin = System.currentTimeMillis();
		
		//작업
		for (int i=0; i<10000; i++) {
			lList.add(i);
		}
		
		
		end = System.currentTimeMillis();
		System.out.println("작업 소요 시간 : " + (end - begin));

		
		
		
		
		
		System.out.println("순차적으로 데이터 삭제하기(끝 -> 처음)"); //데이터의 이동이 없어도 되는 작업이란 소리야~
	
		begin = System.currentTimeMillis();
		
		//작업
		for (int i=aList.size()-1; i>=0; i--) {
			lList.add(i);
		}
		
		end = System.currentTimeMillis();
		System.out.println("작업 소요 시간 : " + (end - begin));
		
		
		
		
		System.out.println("순차적으로 데이터 읽기");
		for  (int i = 0; i<100000; i++) {
			aList.add(i);
			lList.add(i);
		}
		
		begin = System.currentTimeMillis();
		
	
		//작업
		for (int i=0; i<100000; i++) {
			aList.add(i);
		}
		
		
		end = System.currentTimeMillis();
		System.out.println("작업 소요 시간 : " + (end - begin));
		
		begin = System.currentTimeMillis();
	
		//작업
		for (int i=0; i<100000; i++) {
			lList.get(i);
		}
		
		
		end = System.currentTimeMillis();
		System.out.println("작업 소요 시간 : " + (end - begin));

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
	
}





















