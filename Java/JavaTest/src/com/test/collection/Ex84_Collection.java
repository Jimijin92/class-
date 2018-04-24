package com.test.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Set;


public class Ex84_Collection {

	public static void main(String[] args) {
	
		//Ex84_Collection.java
		
		//enum, Enumeration : 열거형
		
		//Enumeration, Iterator, ListIterator : 탐색기(반복자) 
		//	- 컬렉션의 요소에 접근하기 위한 인터페이스
		//	- Enumeration -> Iterator -> ListIterator
		
		//m1();
		//m2();
		
		
	}

	private static void m2() {
		//Iterator -> ListIterator
		//	- Iterator : 단방향 -> 전진 커서
		//  - ListIterator : 양방향 -> 전진 + 후진 커서
		//	- List 계열만 지원(Set 계열은 지원 안함 - 방번호X)
		
		ArrayList<String> list = new ArrayList<String>();
		
		list.add("빨강");
		list.add("주황");
		list.add("노랑");
		list.add("초록");
		list.add("파랑");
		list.add("남색");
		list.add("보라");
		
		Iterator<String> iter = list.iterator();
		ListIterator<String> liter = list.listIterator();
		
		
		while (iter.hasNext()) {
			System.out.println(iter.next());
		}
		System.out.println();
		
		
		
		while (liter.hasNext()) {
			System.out.println(liter.next());
		}
		System.out.println();
		
		//liter.hasPrevious();
		//liter.previous();
		
		while (liter.hasPrevious()) {
			System.out.println(liter.previous());
		}
		
	}

	private static void m1() {
		
		//Iterator
		//	- 컬렉션 프레임워크에서 저장된 요소를 읽어오는(***) 방법을 표준화하기 위한 역할(인터페이스)
		//	- Collection의 하위 컬렉션들이 Iterator를 반환하는 메소드 제공 -> set.iterator()
		//	- List. Set에서 구현(Map에는 없음)
		//	- 읽기 전용으로 사용한다. 
		
		//1. Boolean hasNext() : 다음 요소가 있는지 확인
		//2. T next() : 다음 요소를 가져오기
		//3. remove() : 다음 요소를 삭제하기(잘 사용 안함)
		
		ArrayList<String> list = new ArrayList<String>();
		
		list.add("사과");
		list.add("귤");
		list.add("딸기");
		list.add("포도");
		list.add("바나나");
		
		//list 컬렉션을 Iterator를 구현해서 요소를 탐색
		Iterator<String> iter = list.iterator();
		
		//System.out.println(iter.hasNext());
		//System.out.println(iter.next()); //한칸 옆으로 전진 후 그 방에 있는 데이터를 돌려줌 // 향상된 for이 iterator사용해서 구현한 것 
		
		//System.out.println(iter.hasNext());
		//System.out.println(iter.next()); 
		
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
		
		//System.out.println(iter.next()); 
		//커서는 전진만 가능하다. (후진 불가능)(한번 읽은 걸 다시 읽을수 없다. 스트림처럼)
		
		//부분 탐색x -> 전체 탐색 O
		iter = list.iterator();
		
		iter.next();
		iter.next();
		iter.next();
		
		System.out.println(iter.next()); // 이렇게 한 번 회전해서 뒤로가는 방식은 안 좋은 방식이다. 이렇게만 봐서 몇번짼지 어떻게 알아.... 다루기 힘들어서 부분탐색 안함
		
		HashMap<String,String> map = new HashMap<String,String>();
		map.put("one", "하나");
		map.put("two", "둘");
		map.put("three", "셋");
		map.put("four", "넷");
		map.put("five", "다섯");
		
		//Map -> 루프 X 인 이유 
		//1. 방번호가 없어서... -> 일반 for문 사용 불가
		//2. Iterator를 구현하지 않아서 -> 향상된 for문 사용 불가 
		
		Set<String> keys = map.keySet();
		Collection<String> values = map.values();
		
		Iterator<String> iter2 = keys.iterator();
		
		while(iter2.hasNext()) {
			System.out.println(iter2.next());
		}
		
		Iterator<String>iter3 = values.iterator();
		
		while(iter3.hasNext()) {
			System.out.println(iter3.next());
		}
		
		
		
		
		
		
		
		
		
	}
	
}
























