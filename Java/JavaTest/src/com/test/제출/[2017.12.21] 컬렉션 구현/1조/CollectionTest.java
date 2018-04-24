package com.test.collection;

import java.util.HashMap;

import com.test.question.MyHashMap;
import com.test.question.Myqueue;

public class CollectionTest {
	public static void main(String[] args) {

		// 컬렉션 클래스를 선언하시오.

		// 공통
		// a. 멤버변수
		// b. 생성자
		// c. toString()

		// 문자열만 입출력하는 컬렉션으로 생성

		// 1. ArrayList
		/*
		 * a. add X 2 b. get c. set d. remove e. size d. trimToSize
		 */

		// 2. HashMap
		/*
		 * a. put : 추가이자 수정 즉 덮어쓰기 b. get c. remove d. size e. trimToSize
		 */

		// 3. Stack
		/*
		 * a. push -> 배열에 값 추가 b. pop -> 배열에서 값 뽑아내고 삭제 c. size -> 현재 저장되어 있는 값의
		 * 크기 d. peek -> 저장된 값 중 마지막 값을 출력만. 삭제X e. trimToSize
		 */ // -> 빈 배열 만큼 줄일 것.

		// 4. Queue
		/*
		 * a. add -> 값을 넣기 b. poll -> 값을 꺼내고 사이즈 -1 c. size -> 현재 저장된 값의 숫자를
		 * 나타냄. d. peek -> poll 처럼 값을 현재 위치의 값을 출력하나 삭제X e. trimToSize
		 */ // -> 현재 저장된 값의 크기로 배열을 줄인다.


	 
	/*	HashMap<String, String> h = new HashMap<>();
		h.toString()
*/		
		
		//test_queue();
		//test_hashmap();
		
		test_hash();
	}

	private static void test_hash() {
		HashMap< String, String> t = new HashMap<>();
		
		t.put("일번", "넣는다");
		t.put("이번", "맞는다");
		t.put("삼번", "먹는다");
		System.out.println(t.remove("이번")+"  t.remove");
		//삭제할 키가 없으면 null 반환
		
		System.out.println(t.size());
		
		System.out.println(t.toString());
	}

	private static void test_hashmap() {
		MyHashMap t = new MyHashMap();
		t.put("일번", "넣는다");
		t.put("이번", "맞는다");
		t.put("삼번", "먹는다");
		t.put("사번", "잊는다");
		
		System.out.println(t.get("구번"));
		
		System.out.println(t.toString());
	}

	private static void test_queue() {
		Myqueue t = new Myqueue();

		t.add("가");
		t.add("나");
		t.add("다");
		t.add("라");
		t.add("마");
		t.add("바");

		t.trimToSize();

		System.out.println(t.mylength());

		System.out.println(t.size());

		System.out.println(t.poll());
		
		System.out.println(t.poll()); 
	 	System.out.println(t.poll());
		System.out.println(t.poll()); 
		System.out.println(t.peek());
		System.out.println(t.peek());
		  
		System.out.println(t.toString());
	}
}