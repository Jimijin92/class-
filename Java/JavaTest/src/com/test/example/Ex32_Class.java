package com.test.example;

public class Ex32_Class {

	public static void main(String []args) {
		
		//Ex32_Class.java
		
		//접근 지정자(제어자), Access Modifier
		//	- public, private/ protected. default
		
		//1. public
		//	- 클래스 멤버를 외부에 공개해야 하는 경우 사용
		//  - 100%
		
		//2. private
		//	- 클래스 멤버를 외부에 비공개해야 하는 경우 사용
		//	- 100% 비공개
		//	- 같은 클래스의 멤버끼리는 접근 가능(100% 가능)
		//	- 외부에서의 접근이 필요할 때 -> getter/setter 를 사용
		
		AccessTest t1 = new AccessTest();
		
		t1.a = 10;
		//t1.b = 20;
		
		t1.aaa();
		//t1.bbb();
		
		t1.test(); //요렇게 하면 공개안하는 b도 공개한 것처럼 보임, 컴파일 결과 나옴
		
		//e1 
		//	- Employee 타입의 참조변수
		//	- e1 이라는 객체 -> 객체 변수
		//	- e1 이라는 인스턴스 -> 인스턴스 변수
		Employee e1 = new Employee();
		
		//집어넣을 때도, 꺼낼 때도 대리자 메소드 사용
		e1.aaa(40);
		System.out.println(e1.bbb());
		
		e1.setAge(20);
		System.out.println(e1.getAge());
		
		//e1.name = "홍길동";
		//e1.age = 40;
		//e1.department = "영업부";
		
		//System.out.println(e1.name);
		//System.out.println(e1.department);
		
		Employee e2 = new Employee();
		
		e2.setAge(200000000);
		System.out.println(e2.getAge());
		
		//변수는 제어 불가능
		//메소드는 제어 가능
		
		//e2.name = "아무개";
		//e2.age = 23000; //-23000 해도 오류안남 -> 논리오류
		//e2.department = "안드로메다";
		

	}//main
}//class Ex32_Class


class Employee {
	
	//접근 지정자 사용 가이드
	//1. 멤버 변수
	//	1. 멤버 변수는 무조건 private 으로 지정한다.
	//	2. setter/getter 메소드를 구현한다.
	//2. 멤버 메소드
	//	1. 멤버 메소드는 용도를 잘 모르겠으면 일단private으로 한다.
	// 	2. 멤버 메소드의 역할을 충분히 이해 -> 외부 접근 발생 -> 그 때 public으로 수정한다.
	
	
	
	/*public String name; 		//직원명
	public int age; 			//나이
	public String department;	//부서
    */
	
	private String name; 		//직원명
	private int age; 			//나이
	private String department;	//부서
	
	//집어넣는 역할 메소드
	public void aaa(int a) {
		age = a;
	}
	
	public int bbb() {
		return age;
	}
	
	public void setAge(int age) {
		
		if(age>= 0 && age<= 130) {
			this.age = age;
		}else {
			System.out.println("올바른 나이가 아닙니다.");
		}
		//멤버변수와 지역변수는 이름이 같아도 동시에 존재 가능하다.
		//큰범위와 작은범위가 충돌할 떄 무조건 작은게 이김(더 구체적이라고 판단돼서), 자식이기는 부모 없다.
		this.age = age;
	}
	
	public void getAge() {
		return this.age; //(그냥 age라고 해도 된다(this없이))
	}
	
	
	
	
	
	
}//Employee 




class AccessTest{
	
	//접근 지정자
	//	- 클래스 멤버에게
	
	public int a = 10;
	private int b = 20;
	
	public void aaa() {
		System.out.println("aaa");
	}
	
	public void bbb() {
		System.out.println("bbb");
	}
	
	public void test() {
		System.out.println(a);
		System.out.println(b);
		aaa();
		bbb();
	}
	
	
}// class AccessTest