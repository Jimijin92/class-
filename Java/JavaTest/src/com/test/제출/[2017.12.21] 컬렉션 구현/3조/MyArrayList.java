package com.test.question;

public class MyArrayList {
	
	//1. 멤버 변수
	private String[] list;	//데이터 저장
	private int index = 0;		//입출력 요소의 위치
	private int capacity;	//배열 초기 크기
	
	
	
	//2. 생성자
	public MyArrayList() {
		this(4);
		capacity = 4;
	}
	
	public MyArrayList(int capacity) {
		//기본 배열 4개짜리 만들기
		this.list = new String[capacity];
		this.capacity = capacity; 
	}
	
	//3. toString() 재정의 -> 배열 데이터 덤프 dump해라 (member객테 뭐시기)
	@Override
	public String toString() {
		String result = "";
		int size = this.size();
		for (int i = 0; i < size; i++) {
			result += list[i];
			if (i < (size - 1))
				result += ", ";			
		}
		result = String.format("[%s]", result);
		return result;
	}
	
	//4. 주업무
	//값 추가
	public void add(String s) {
		//배열의 길이와 인덱스 값이 같은 경우 x 2
		if (index == capacity) {
			reArray();
		}
		
		list[index] = s;
		index++;
	}

	//요소 출력
	public String get(int index) {
		
		return this.list[index];
	}
	
	//원하는 자리에 요소 덮어쓰기
	public void set(int index, String s) {
		
		//String original = this.list[index];
		
		this.list[index] = s;
		
		//이전의 값을 돌려받고 싶을 경우
		//return original;
	}
	
	//원하는 자리에 값 추가하기
	public void add(int index, String s) {
		
		//index가 가르키는 값이 최대값과 같을때
		if(this.index == this.capacity) {
			reArray();
		}
		
		String[] list2 = new String[size() - index];
		
		//원하는 index값 부터 끝까지 저장
		for (int i = 0, start = index; i < list2.length; i++, start++) {
			
			list2[i] = this.list[start];
			
		}
		
		
		this.list[index] = s;
		
		//index 다음부터 list2의 값 깊은 복사
		for (int i = 0, start = index + 1; i < list2.length; i++, start++) {
			this.list[start] = list2[i];
		}
		
		this.index ++;
		
	}
	
	//배열자리 부족할때 늘려서 재정의
	private void reArray() {
		
		String[] list2 = new String[this.capacity];
		
		//얕은 복사
		list2 = list;
		
		capacity = capacity * 2;
		
		clear();
		
		//깊은 복사
		for (int i = 0; i < list2.length; i++) {
			list[i] = list2[i];
		}
		
	}
	
	//배열 실 값의 크기
	public int size() {
		
		int result = 0;
		
//		for (int i = 0; i < list.length; i++) {
//			if (list[i] == null) 
//				break;
//			
//			result++;
//		}
		
		result = this.index;
		
		return result;
	}
	
	//요소 삭제
	public String remove(int index) {
		
		String remove = this.list[index];
		
		String[] list2 = new String[list.length];
		
		//얕은 복사
		list2 = this.list;
		
		//list 초기화
		clear();
		
		//list2의 요소를 list에 깊은 복사 단, j == index -> j값 ++
		//i : list의 index / j : list2의 index
		for (int i = 0, j = 0; j < list2.length; i++, j++) {
			if(j == index) 
				j++;
			this.list[i] = list2[j];
		}
		
		this.index--;
		return remove;
	}
	
	
	public void clear() {
		this.list = new String[capacity];
	}
	
	public void trimToSize() {
		
		//실요소의 갯수만큼 생성
		String[] list2 = new String[size()];
		
		for (int i = 0; i < list2.length; i++) {
			list2[i] = list[i];
		}
		
		this.list = list2;
		
	}
	
	//contains..etc
	
}
