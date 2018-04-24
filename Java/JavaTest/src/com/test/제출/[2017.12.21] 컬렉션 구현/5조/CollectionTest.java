package com.test.question;

public class CollectionTest {
	public static void main(String[] args) {
		
		//컬렉션 클래스를 선언하시오.
		
		//공통
		//	a. 멤버 변수
		//	b. 생성자
		//	c. toString()
		
		
		//1. ArrayList
		//	a. add X2
		//	b. get
		//	c. set
		//	d. remove
		//	e. size
		//	d. trimToSize
		
		//2. HashMap : 배열 2개 생성(Key, Value)
		//	a. put : 추가, 수정
		//	b. get
		//	c. remove
		//	d. size
		//	e. trimToSize
		
		//3. Stack
		//	a. push
		//	b. pop
		//	c. size
		//	d. peek
		//	e. trimToSize
		
		//4. Queue
		//	a. add
		//	b. poll
		//	c. size
		//	d. peek
		//	e. trimToSize
		
		MyHashMap map = new MyHashMap();
		map.put("국어", "100");
		map.put("수학", "80");
		map.put("영어", "70");
		map.put("사회", "75");
		map.put("과학", "90");
		
		System.out.println(map.toString());
		
		System.out.println("=========================================");
		
		System.out.println(map.size());//사이즈 확인
		
		System.out.println("=========================================");
		
		System.out.println(map.get("국어"));
		System.out.println(map.get("수학"));
		System.out.println(map.get("영어"));
		System.out.println(map.get("사회"));
		System.out.println(map.get("과학"));
		
		System.out.println("========================================");
		
		map.remove("영어");						//값 삭제
		System.out.println(map.get("영어"));		//null 값
		System.out.println(map.size());
		System.out.println("========================================");
		
		map.put("사회", "90");					//값 수정
		System.out.println(map.get("사회"));
		System.out.println(map.size());
		
		
		System.out.println("========================================");
		System.out.println(map.containsKey("사회"));
		System.out.println(map.containsValue("60"));

//		System.out.println(map.length());
//		map.trimToSize();
//		System.out.println(map.length());
		
	}
}













