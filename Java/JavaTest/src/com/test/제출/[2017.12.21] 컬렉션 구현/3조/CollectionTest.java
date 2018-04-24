package com.test.question;

public class CollectionTest {

	public static void main(String[] args) {
		
		//컬렉션 클래스를 선언하시오. //문자열만 입력할수 있는!!Generic x
		
		//공통
		//	a. 멤버변수
		//	b. 생성자
		//	c. toString()
		
		
		arrayList();
		//hashMap();		
		
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
		
	}

	private static void hashMap() {
		//2. HashMap //배열 2개 (key, value)
		//	a. put : 추가, 수정
		//	b. get
		//	c. remove
		//	d. size
		//	e. trimgToSize
		
		
		MyHashMap map = new MyHashMap(); //<key , value>
		
		//요소 추가
		map.put("국어", "100");
		map.put("영어", "90");
		map.put("수학", "80");
		map.put("과학", "80");
		map.put("사회", "80");
		map.put("체육", "80");
		
		//요소 접근
		System.out.println(map.get("국어"));
		
		//HashMap은 순서는 의미가 없다. -> 순서가 필요할 시 ArrayList 사용할 것
		
		//1. 요소 추가
		map.put("과학", "100");
		map.put("윤리", "80");
		
		//2. 요소 갯수
		System.out.println(map.size());
		
		//3. 요소 접근
		System.out.println(map.get("국어"));
		System.out.println(map.get("도덕")); //없는 key를 입력시 null값을 반환함
		
		//4. 요소 수정
		//	- HashMap의 key는 유일해야 한다. -> 중복된 key가 존재시 덮어쓰기를 함
		map.put("과학", "90");
		System.out.println(map.get("과학"));
		
		//5. 요소 삭제
		map.remove("과학");
		System.out.println(map.size());
		System.out.println(map.get("과학"));
		
//		//6. 요소 확인
//		//	- ArrayList or 배열 -> contains
//		System.out.println(map.containsKey("국어"));
//		System.out.println(map.containsValue("100"));
		
		//7. 초기화
//		map.clear();
//		System.out.println(map.size());
		
	}

	private static void arrayList() {
		//1. ArrayList
		//	a. add x 2개
		//	b. get
		//	c. set
		//	d. remove
		//	e. size
		//	f. trimgToSize
		MyArrayList list = new MyArrayList();
		
		list.add("빨강");
		list.add("주황");
		list.add("노랑");
		list.add("초록");
		list.add("파랑");
		list.add("남색");
		list.add("보라");
	
		
		System.out.println("<get>");
		System.out.println(list.get(1));
		System.out.println(list.get(4));
		System.out.println(list.get(list.size() - 1));
		System.out.println(list.toString());
		System.out.println(list.size());
		
		System.out.println();
		System.out.println("===========================================");
		System.out.println();
		
		System.out.println("<add>");
		list.add(2, "우호균");
		System.out.println(list.toString());
		list.add(6, "무지개");
		System.out.println(list.toString());
		System.out.println(list.size());
		
		System.out.println();
		System.out.println("===========================================");
		System.out.println();
		
		System.out.println("<set>");
		list.set(1, "*금색*");
		list.set(5, "*은색*");
		System.out.println(list.toString());
		System.out.println(list.size());
		
		System.out.println();
		System.out.println("===========================================");
		System.out.println();
		
		System.out.println("<remove>");
		System.out.println(list.remove(2));
		System.out.println(list.toString());
		System.out.println(list.size());
		System.out.println("===========================================");
		System.out.println(list.remove(2));
		System.out.println(list.toString());
		System.out.println(list.size());
		
		list.trimToSize();
		
		System.out.println();
		System.out.println("===========================================");
		System.out.println();
		
		list.clear();
		System.out.println(list.toString());
	}
	
}
