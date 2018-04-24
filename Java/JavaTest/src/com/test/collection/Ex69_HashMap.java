package com.test.collection;

import java.util.HashMap;

public class Ex69_HashMap {

	public static void main(String[] args) {
		
		//Ex69_HashMap.java
		
		//해시맵을 언제 사용할까?
		// 사용자 입력
		String name = "홍길동";
		String age = "20";
		String address = "서울시";
		String tel = "010-9999-1111";
		String email = "hong@naver.com";
		
		//위의 정보를 가지고 업무 처리.. -> 메소드 추출
		
		process(name, age, address, tel, email);
		
		//매개변수가 많을수록 개수, 타입 헷갈려짐 -> 	불편해짐 -> 주고 받는것을 개선해보자
		//데이터 집합 생성
		// : 5개의 데이터 -> 한 덩어리
		//	-> 배열, 클래스, ArrayList, HashMap..
		Data data = new Data();//데이터 객체 선언/ data변수
		
		data.name = name;
		data.age = age;
		data.address = address;
		data.tel = tel;
		data.email = email;
		
		process(data);
		
		HashMap<String, String> map = new HashMap<String,String>();
		
		map.put("name", name);
		map.put("age", age);
		map.put("address", address);
		map.put("tel", tel);
		map.put("email", email);
		
		process(map);
		
		
		Data data2 = new Data();
		data2.name = "아무개";
		
		HashMap<String, String> map2 = new HashMap<String,String>();
		map2.put("nick", "아무개");
		//해시맵은 클래스와 달리 틀역할을 못한다. 정신안차리면 첫번째 객체와 두번째 객체 모양 달라질 수 있음. 
		
		//다량 데이터를 전달할 때
		//1. 동일한 자료형 + 동일한 성격
		//	a. 배열
		//		- 고정 길이
		//	b. ArrayList
		//		- 가변 길이
		//2. 자료집합
		//	a. 클래스 //틀이 있으니까 이름 있음
		//		- 다시 사용해야 하는 집합이면
		//	b. HashMap //틀이 없으니까 이름 없음
		//		- 1회용 틀이 필요할 때 .... //붕어빵 틀 만들어서 한번만 만들어 먹을때...
		
		
		
	}//main
	
	
	public static void process(HashMap<String,String> map) {
		System.out.println("가공 처리..");
	}
	
	
	public static void process(Data data) {
		System.out.println("가공 처리..");
	}
	
	
	//요즘은 이렇게 절대 안함 무조건 포장! -> process(data);
	public static void process(String name, String age, String address, String tel, String email) {
		System.out.println("가공 처리..");
	}
	
	
}//Ex69_HashMap

class Data {
	public String name;
	public String age;
	public String address;
	public String tel;
	public String email;
}








