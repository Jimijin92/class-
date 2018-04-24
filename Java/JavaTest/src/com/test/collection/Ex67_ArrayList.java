package com.test.collection;

import java.util.ArrayList;

public class Ex67_ArrayList {

	public static void main(String[] args) {
		//Ex67_ArrayList.java
		
		//컬렉션, collection
		//	- 배열의 업그레이드 버전
		//	- 배열을 사용 목적에 맞게 특화시켜 다양한 형태로 제공 (=> 자료구조)
		
		//	- 길이 가변(늘리거나 줄이는게 가능)
		//	- 내부 자료형 -> Object형
		
		//ArrayList 클래스
		//	- 사용 빈도가 가장 높음
		//	- 순수 배열과 모습이 가장 비슷함
		//	- 첨자(index)를 사용해서 요소(Element)를 관리

	//m1();
	//m2();
	m3();	
		
		
		
		
	}//main

	private static void m3() {
		ArrayList<String>list = new ArrayList<String>();
		//1. 요소 추가하기 
		//	- add()
		//	- 배열의 맨 끝에 추가하기(append)
		list.add("홍길동");
		list.add("아무개");
		list.add("테스트");
		list.add("하하하");
		
		//2. 요소 몇개?
		//	- size()
		System.out.println(list.size());
		
		//3. 요소 접근
		//	- get()
		System.out.println(list.get(0));
		System.out.println(list.get(3));
		System.out.println(list.get(list.size()-1));
		//System.out.println(list.get(4));
		
		//4. 요소 수정
		// list[0] = "김길동";
		list.add("김길동"); //append, 새로운 요소 추가
		
		
		String temp = list.set(0, "이길동"); //0번째 요소를 이길동으로 수정 /set-> 수정할 떄 쓰는 ...
		System.out.println(list.get(0));
		System.out.println(temp); // 고치기 바로 전 단계 보여줌
		
		//5. 요소 삭제
		//	- 순수 배열은 방삭제가 불가능 
		//	- 컬렉션은 방삭제가 가능
		
		System.out.println();
		
		for(String name : list) {
			System.out.println(name);
		}
		
		list.remove(2);// 2번째 방을 아예 날려버림, 사이즈 줄어듬
		System.out.println(list.size());
		
		for (String name : list) {
			System.out.println(name);
		}
		
		
		//쓰기, 읽기, 수정, 삭제
		//	- 데이터를 조작하는 기본 행동
		//	- CRUD(Create, Read, Update, Delete)
		
		//삭제할 때 주의할점!!!!!!!!!!!!1
		System.out.println(list.get(2));
		
		list.remove(0);//이길동 탈퇴
		
		System.out.println(list.get(2));
		
		
		//6. 요소 추가
		//	- 삽입, Insert
		// 이때도 방번호(index변경) 주의, append는 맨 끝에 넣는거니까 주의 안해도 됨
		
		System.out.println();
		
		for (String name : list) {
			System.out.println(name);
		}
		
		list.add(1, "후후후");
		
		System.out.println();
		
		for (String name : list) {
			System.out.println(name);
		}
		
		//7. 초기화
		//	- 모든 요소 삭제
		list.clear();
		System.out.println(list.size());
		
		//8. 비었는지? 
		System.out.println(list.size()==0); //true
		System.out.println(list.isEmpty()); //true
		
		//9. 나머지...
		list.add("가가가");
		list.add("나나나");
		list.add("다다다");
		list.add("라라라");
		
		//String == Char[] == 배열 == 컬렉션
		System.out.println(list.indexOf("나나나")); //1
		System.out.println(list.contains("다다다")); //true
		System.out.println(list.lastIndexOf("라라라")); //4
		
		
	}

	private static void m2() {
		
		//raw type : 옛날꺼.... 향후 사라질 가능이 있는 문법
		ArrayList list1 = new ArrayList();
		list1.add(100);
		System.out.println((int)list1.get(0) + 100);
		//에러 java.lang.ClassCastException
		//처음에 100 넣었으면 다음부터 동일한 타입이 들어가야하는데 "홍길동" 넣어서...
//		list1.add("홍길동");
//		System.out.println(list1.get(1) + "님");
//		
//		for(int i=0; i<2; i++) {
//			System.out.println((int)list1.get(i) + 100);
//		}
		
		
		
		//제네릭 버전으로 갈아타주세요....
		ArrayList<Integer> list2 = new ArrayList<Integer>();
		list2.add(100);
		System.out.println(list2.get(0) + 100);
		
		
		
	}

	private static void m1() {
		//배열 생성
		//	- 타입 명시(int)
		//	- 길이 명시(3)
		int[] nums1 = new int[3];
		
		//초기화 + 요소 접근 -> index 사용
		nums1[0] = 100;
		nums1[1] = 200;
		nums1[2] = 300;
		
		//탐색
		for (int i=0; i<nums1.length; i++) {
			System.out.println(nums1[i]);
		}
		
		
		//ArrayList 생성
		//	- 타입 없음(Object 배열) -> 관리하기는 편하지만 꺼냈을때 원래타입으로 바꾸지 않으면 못(산술연산)씀
		//  - 길이 없음(가변이라서...)
		ArrayList nums2 = new ArrayList();
		
		//초기화
		nums2.add(100);
		nums2.add(200);
		nums2.add(300);
		
		//탐색
		for (int i=0; i<3; i++) {
			System.out.println((int)nums2.get(i)*2);	//기본적으로 문자여서 굳이 INT로 바꿔줘야함
		}
		
		
		
	}
}//Ex67


//class ArrayList<T> {
//	
//	public void add(T arg) {
//		
//	}
//	
//}
















