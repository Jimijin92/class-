package com.test.collection;

public class NewArrayList {

	//1. 멤버변수 
	private String[] list;	//
	private int index;		//***
	private int capacity;	//
	
	//2. 생성자(여기서 배열 만들지 말고 add할 때 만들기)
	public NewArrayList() {
		this(4);
	}
	
	public NewArrayList(int capacity) {
		this.capacity = capacity;
		this.index = 0;
	}
	
	//3. add
	public void add(String s) {
		
		if(this.list == null) {
			this.list = new String[this.capacity];
		}
		//여기서 else걸지 말기 중복코드 생김 
		
		doubleArray();
		
		this.list[this.index] = s;
		this.index++;
		
	}

	private void doubleArray() {
		
		// 배열의 크기(this.list.length) == 요소의 개수(this.index)
		if(this.list.length == this.index) {
			
			//2배 크기 생성 + 깊은 복사 
			String[] temp = new String[this.list.length * 2];
			
			for(int i=0; i<this.list.length; i++) {
				temp[i] = this.list[i];
			}
			
			this.list = temp;
			
			//대부분 조들이 더블하는 걸 add에 넣어놨는데 다른 분야니까 빼주는게 낫다.
		}
		
	}
	
	public String get(int index) {
		
		//요소가 존재하지 않은 방번호를 요청하면?
		//안전장치 걸기
		if(this.index <= index || index < 0) {
			throw new IndexOutOfBoundsException();
		}
		
		return this.list[index];
	}//get
	
	public int size() {		
		return this.index;
	}
	
	public void set(int index, String s) {
		
		if(this.index <= index || index < 0) {
			throw new IndexOutOfBoundsException();
		}
		//더블링과는 상관없는 행위
		this.list[index] = s;
	}
	
	
	public void remove(int index) {
		
		
		//[빨강] - [파랑] - [노랑] - [검정]
		//list.remove(1);
		//[빨강] - [노랑] - [노랑] - [검정]
		//[빨강] - [노랑] - [검정] - [검정]
		//[빨강] - [노랑] - [검정] - [null]
		
		//index대신 length로 하면 낭비임
		for (int i=index; i<this.index-1; i++) {
			this.list[i] = this.list[i+1];
		}
		
		//this.list[this.index] = null;
		
		this.index --;
		
		
	}
	
	
	
	public void remove(String s) {
		
		//검색 -> 지울 방 번호 알아내기 -> remove(index) 진행
		int index = -1;
		
		for(int i=0; i<this.index; i++) {
			if(this.list[i].equals(s)) {
				index = i;
				break;
			}
		}
		
		//index <- 지울 방 번호
		if(index != -1) {
		remove(index);
		}
		
	}//remove
	
	
	public void add(int index, String s) {
		
		if(index >= this.index) {
			throw new IndexOutOfBoundsException();
		}
		
		doubleArray();
		
		for (int i=this.index-1; i>=index; i--) {
			this.list[i+1] = this.list[i];
		}
		
		this.list[index] = s;
		this.index++;
		
	}
	
	
	public void trimToSize() {
		
		String[] temp = new String[this.index];//***
		
		for(int i=0; i<temp.length; i++) {
			temp[i] = this.list[i];
		}
		
		this.list = temp;
		
	}
	
	
	
	
}




























