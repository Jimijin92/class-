package com.test.question;

public class Myqueue {
	//생성자를 이용해 처음 객체를 생성했을 경우
	// capacity = 4
	// index = 0;
	// list 는 capacity 의 크기로 초기화
	
	private String[] list;
	private int index;
	private int capacity = 4;
	
	public Myqueue() {
		this(4);
	}
	public Myqueue(int capacity) {
		this.list = new String[capacity];
		this.index = 0;
	}
	
	@Override
	public String toString() {
		String out = "";
		
		out += "[";
		for(int i=0; i<index; i++) {
			out += this.list[i];
			
			if(i == index -1) {
				break;
			}
				out += ", ";
		}
		out += "]";
		
		return out;
	}
	
	public void add(String str) {
		//배열이 꽉 차 있는지 아닌지 유효성 검사 -> list.length 값은 4 저장의 index 는 3까지
		//꽉 찼으면 배열의 사이즈를 2배로 늘리는 것을 우선
		//그렇지 않은 경우 배열에 값을 추가해주고
		//index += 1; 을 해준다, 다음 빈 공간을 가르키게
		
		if(this.capacity == index) {
			//배열이 꽉 차 있으면 기존 배열을 두배 큰 배열로 이사시킨다.
			this.capacity *= 2;
			String[] temp = new String[this.capacity];
			
			for(int i=0; i<this.size(); i++) {
				temp[i] = this.list[i];
			}
			this.list = temp;
		}
		//배열에 값을 넣어주고 인덱스를 증가.
		this.list[this.index] = str;
		index += 1;
	}
	
	public String poll() {
		if(index == 0) {
			return null;
			
		} else {
			String str = this.list[0];
			//첫번째 값을 반환하기 위해 저장.
			for(int i=1; i<index; i++) {
				this.list[i-1] = this.list[i];

			}
			//나머지 1번부터 마지막 저장값까지를 한칸씩 당겨준다.
			
			this.list[index-1] = null;
			//마지막 위치를 null 로 초기화
			this.index -= 1;
			return str;
			
		}
	}
	public String peek() {
		if(index == 0) {
			return null;
			
		} else {
			return this.list[0];
		}
	}
	public void trimToSize() {
		//배열 내부가 현재 얼마나 채워져 있는가?
		//인덱스가 0인 경우 그대로 return.
		//인덱스가 1 이상인 경우는 사이즈만큼 배열 생성해서 옮겨갈 것.
		if(size() == 0) {
			return;
		} else {
			//저장된 값이 1개 이상인 경우 저장된 갯수만큼 배열을 만들어서 거기로 이동
			String[] temp = new String[size()];
			
			for(int i=0; i<this.size(); i++) {
				temp[i] = this.list[i];
			}
			
			this.list = temp;
		}
	}
	
	public int size() {
		
		return this.index;
	}
	
	public int mylength() {
		return this.list.length;
	}
	
}