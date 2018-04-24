package com.test.collection;

public class Ex79_Collection {

	public static void main(String[] args) {
		//Ex79_Collection.java
		/*
		 
		 컬렉션
		 1. ArrayList
		 2. HashMap
		 3. Stack
		 4. Queue
		 
		 자바에서의 모든 컬렉션들은 아래의 인터페이스를 구현한다.
		 1. Collection 인터페이스
		 2. List 인터페이스
		 	- 순서가 있는 데이터 집합
		 	- 방번호가 존재한다.(첨자, index 사용)
		 	- 데이터 중복을 허용한다. (방번호가 있기 때문에...)	
		 	ex) ArrayList, Stack, Queue, LinkedList, Vector 등 ...
		 	
		 3. Set 인터페이스
		 	- 순서가 없는 데이터 집합
		 	- 방번호가 없다...(첨자 사용 불가)
		 	- 순서가 중요하지 않은 데이터 집합
		 	- 데이터 중복을 허용하지 않는다.
		 	ex) HashSet, TreeSet 등..
		
		 4. Map 인터페이스
		 	- 키와 값의 쌍으로 구성된 데이터 집합
		 	- 순서가 없는 데이터 집합
		 	- 키(key) 집합 : set(중복값 존재X)
		 	- 값(value) 집합 : List(중복값 존재O)
		 	ex) HashMap, TreeMap, HashTable, properties 등...
		 	
		 ** Vector, HashTable, Properties 들은 호환성 때문에 남겨둔 클래스 -> 조만간 없어짐, 잘 안씀
		 ** 자바에서 컬렉션 JDK1.5때에 만들어짐(최근)
		 
		 Vector -> ArrayList
		 HashTable -> HashMap
		 Properties -> X -> XML, JSON
		 
		 Collection //append 모드
		 - add(Object o)
		 - clear()
		 - contains()
		 - isEmpty()
		 - iterator()
		 - remove(Object o)
		 - size()

		 List(순서와 관련된 행동)
		 - add(int index, Object o) //삽입모드
		 - remove(int index)
		 - get()
		 - indexOf(), lastIndexOf()

		 Map
		 - put()
		 - get()
		 - clear()
		 - containsKey(), containsValue()
		 - KeySet(), value()..
		 - size()
		 
		 
		 
		 */
		
	}
	
}
