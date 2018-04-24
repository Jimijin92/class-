package com.test.question;

public class MyHashMap {
	
	private String[] key; //입출력 요소의 위치
	private String[] value; //데이터 저장
	private int capacity; //배열 초기 크기
	private int size = 0; //배열 초기 번호	
	
	//생성자
	public MyHashMap(){
		capacity = 4;
	}
	public MyHashMap(int capacity){
		this.capacity = capacity;
	}
	
	@Override
	public String toString() {
		String key ="";
		String value  ="";
		for(int i=0;i<size;i++) {
//			key = key + this.key[i];
//			value = value + this.value[i];
			key = key + String.format("%s\t", this.key[i]);
			value = value + String.format("%s\t", this.value[i]);
		}
		return String.format("%s\n%s",key,value);
	}
	
	
	//주업무
	public void put(String key, String value) {
		if(size == 0) {
			this.key = new String[capacity];
			this.value = new String[capacity];
			this.key[size] = key;
			this.value[size] = value;	
			size++;
		}else if(size==capacity){
			int j = 0;
			//해당 key가 존재하면 배열에 추가 시키지 않고 수정
			for(int i=0;i<size;i++) {
				if(key.equals(this.key[i])) {
					this.value[i] = value;
					j=1;
					break;
				}
			}
			//key 값이 중복 되지 않고 배열이 꽉찼을때 배열을 증가시켜 복사 시킨다.
			if(j==0) {
				String[] key2 = new String[capacity];
				String[] value2 = new String[capacity];
				
				//값 복사
				for(int i=0;i<size;i++) {
					key2[i] = this.key[i];
					value2[i] = this.value[i];
				}
				//크기가 배수인 원래 배열 생성
				capacity *= 2;
				this.key = new String[capacity];
				this.value = new String[capacity];
				
				//원래 배열에 값복사
				for(int i=0;i<size;i++) {
					this.key[i] = key2[i];
					this.value[i] = value2[i];
				}
				
				this.key[size] = key;
				this.value[size] = value;
				size++;
			}
			
		}else {
			int j = 0;
			
			//key의 중복값 확인
			for(int i=0;i<size;i++) {
				//key의 중복값이 있을경우 해당 value 값 수정
				if(key.equals(this.key[i])) {
					this.value[i] = value;
					j=1;
					break;
				}
			}
			if(j==0) {
				this.key[size] = key;
				this.value[size] = value;
				size++;
			}
		}
	}//put()
	
	public String get(String key) {
		String value = null;
		for(int i=0;i<size;i++) {
			if(key.equals(this.key[i])) {
				value = this.value[i];
			}
		}
		return value;
	}// get()
	
	public void remove(String key) {	
		for(int i=0;i<size;i++) {
			if(key.equals(this.key[i])) {
				for(int j=i;j<size;j++) {
					this.key[j] = this.key[j+1];
					this.value[j] = this.value[j+1];
				}
				size --;
			}
		//실질적인 배열값 삭제
		this.key[size] = null;
		this.value[size] = null; 
		}
	}// remove()
	
	
	public int size() {
		
		return size;
		
	}//size()
	
	public void trimToSize() {
		
		String[] key2 = new String[capacity];
		String[] value2 = new String[capacity];
		
		//값 복사
		for(int i=0;i<size;i++) {
			key2[i] = this.key[i];
			value2[i] = this.value[i];
		}
		
		//크기가 실제 데이터 들어있는 갯수 만큼의 배열을 생성
		this.key = new String[size];
		this.value = new String[size];
		//원래 배열에 값복사
		for(int i=0;i<size;i++) {
			this.key[i] = key2[i];
			this.value[i] = value2[i];
		}
	}//trimTotrim
	
	public int length() {
		int length = key.length;
		return length;
	}

	public boolean containsKey(String key) {
		
		boolean result = false;	
		for(int i=0;i<size;i++) {
			if(key.equals(this.key[i])) {
				result = true;
			}
		}
		
		return result;
	}
		
	public boolean containsValue(String value) {
			
		boolean result = false;	
		for(int i=0;i<size;i++) {
			if(value.equals(this.value[i])) {
				result = true;
			}
		}
		return result;
	}
	
}
