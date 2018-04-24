package com.test.access;

import com.test.example.Red;

public class yellow extends Red {

	
	//Red 클래스와 다른 패키지에 있는 클래스
		public void check() {
			
		
			//protected 
			//	- 패키지 같은 때 : public 처럼
			//	- 패키지 다르면 : private 처럼
			//	- 패키지 상관없이 자식 클래스이면 : public 처럼
		
			//System.out.println(this.a);
			//System.out.println(this.b);
			System.out.println(this.c);
			System.out.println(this.d);
		}
	
		
		
}
