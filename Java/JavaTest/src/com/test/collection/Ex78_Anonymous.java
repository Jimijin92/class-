package com.test.collection;

public class Ex78_Anonymous {

	public static void main(String[] args) {
		
		//Ex78_Anonymous.java
		
		//Anonymous Class, 익명 클래스
		//	- 익명(이름이 없다.)
		//	- 재사용이 불가능하다. -> 1회용 클래스 
		//	- 인터페이스를 사용해서 만든다. 
		
		//m1. Red가 필요해서 생성
		Red r1 = new Red();
		r1.print();
		r1.fill();
		r1.draw();
		
		//m2. Color 자격을 가지는 객체가 필요해서 생성 
		Color r2 = new Red();
		r2.print();
		r2.fill();
		//r2.draw();
		
		//m3.
		Color r3 = new Color() {

			@Override
			public void print() {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void fill() {
				// TODO Auto-generated method stub
				
			}
			
			
		};
		
		//? r3 = new ?() {}; //Red 클래스와 동급..
		r3.print();
		r3.fill(); 
		
	}
	
}

//class ? implements Color{
	
//}


interface Color {
	
	void print();
	void fill();
	
}

class Red implements Color{

	@Override
	public void print() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void fill() {
		// TODO Auto-generated method stub
		
	}
	
	public void draw() {
		
	}
	
}