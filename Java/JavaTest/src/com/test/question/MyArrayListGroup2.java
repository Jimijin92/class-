package com.test.question;

public class MyArrayListGroup2 {

	//1. 멤버변수
	private String[] list; // 데이터 저장
	private int index;	   // 입출력 요소의 위치
	private int capacity;  // 배열 초기 크기
	
	//2. 생성자
	public MyArrayListGroup2() {
		capacity = 4;
		index = 0;
		list = new String [capacity];
	}
	
	public MyArrayListGroup2(int capacity) {
		this.capacity = capacity;
		//list = new String [capacity];
	}
	
	//3. toString() 재정의 -> 배열 데이터 덤프 
	/*public String toString() {
	
		String name = "";
		//for(int i=0; i<list.length; i++) {
		
		//혜령이랑
		for(int i=0; i<list.length; i++) {
			name += list[i] + ", ";
		return String.format("%s\b\b", name);
		}
		
		//준필님
		for(int i=0; i<index; i++) {
			if(i != 0)
		}
		
		
		
	}//toString
*/	
	
	//4. 주업무
	public void add(String s) {
		
		if(index == capacity) {
			capacity*=2;
			
			String[] temp = new String[capacity];
			for(int i=0; i<index; i++) {
				temp[i] = list[i];
	
			}
			list = new String[capacity];
			for(int i=0; i<index; i++) {
				list[i] = temp[i];
			}
		}
		
		list[index] = s;
		index++;
		
	}
	
	public String get(int index) {
		return list[index];
	}
	
	public void set(int index, String s) {
		list[index] = s;
	}
	
	public void add(int index, String s) {}
	
	public int size() {
		return index;
	}
	
	
	
}
