package com.test.example;

import java.util.Calendar;
import java.util.Random;
import java.util.Scanner;

public class Ex52_Casting {

	public static void main (String[] args) {
	
	AAAA a = new AAAA();
	AAAA b = new BBBB();// 업캐스팅, 부모 = 자식
	AAAA c = new CCCC(); // 업캐스팅, 할아버지 = 손자
	AAAA d = new DDDD(); // 업캐스팅, 증조할아버지 = 증손자
	
	AAAA[] list = new AAAA[4];
	list[0] = new AAAA();
	list[1] = new BBBB();
	list[2] = new CCCC();
	list[3] = new DDDD();
	
	//****Object : 자바에 존재하는 모든 클래스의 최상위 클래스
	Object o1 = new Object();
	Object o2 = new AAAA();
	Object o3 = new BBBB();
	Object o4 = new CCCC();
	Object o5 = new DDDD();
	
	Object o6 = new Random();
	Object o7 = new Scanner(System.in);
	Object o8 = Calendar.getInstance();
	
	//Object 변수는 만능 : 세상에 존재하는 모든 데이터를 담을 수 있는 타입
	//모든 데이터를 한번에 제어할 수 있는 집합
	
	//만능 -> 물리 장점
	//     -> 개발자 입장 - > 다시 접근 -> 해당 요소의 자료형? -> 가독성 + 관리 최악 -> instanceof 연산자 사용
	//	   -> 개발자 -> 논리적 약속 & 기억 -> 반드시 오류 발생(사람이라서... 실수), 논리오류에 가까움
	//****** Object 참조 변수를 사용할 때 주의점!! -> 처음에 넣은 자료형을 끝까지 사용한다.(처음 넣은 자료형 이외의 타입을 다시 넣지 않는다.)
	Object[] list2 = new Object[100];
	
	System.out.println(list[0] instanceof Random);
	list2[0] = new Random();
	list2[1] = Calendar.getInstance();
	list2[2] = new BBBB();
	
	Object aaaa = new AAAA();
	AAAA aaaa2 = new AAAA();
	
	aaaa = new BBBB();
	aaaa = new CCCC();
	
	//list2[1]
	//System.out.println(list2[1]);
	//System.out.println(aaaa);
	
	//Object에 한해서..
	//참조변수 = 값데이터;
	//물리적으로 불가능한 상황
	//박싱(Boxing) (객체에 의해서 실제 데이터 상수가 감싸져서 박싱)
	// 상수를 발견하는 순간 상수를 감싸는 객체 발생. 불리언 발견-> 불리언 객체, 인티저 발견 -> 인티저 객체
	Object o9 = 100;		//값형
	Object o10 = true;		//값형
	Object o11 = 'a';		//값형
	
	System.out.println(o9);
	
	
	Object o12 = "홍길동";	//String - 참조형
	

	Object num = 100; //박싱
	int num2 = 100;
	
	System.out.println(num); //데이터 출력x -> 객체 출력 -> toString()
	System.out.println(num.toString()); //데이터를 돌려주도록 재정의
	System.out.println(num2); //데이터 출력
	//System.out.println(num + num2);
	//언박싱(UnBoxing) : Object 참조 변수에 넣어놨던 값형의 데이터를 다시 꺼내는 작업(Object -> int)
	System.out.println((int)num + num2);
	System.out.println((Integer)num + num2);
	
	Object temp = true;
	
	if((boolean)temp) {
		System.out.println("참");
	} else {
		System.out.println("거짓");
	}
	
	
	
	System.out.println(temp);
	
	//Object 특징 (단점보다 장점이 큼..)
	//1. 장점
	//	- 모든 자료형(참조형, 값형)을 담을 수 있다. -> 코드 유연하게...
	
	//2. 단점
	//	- 원래 자료형으로 꺼낼때(형변환) 원래 자료형이 어떤 타입이었는지를 알기가 힘들다.(초기화 구문을 직접 보기 전에는 알기 힘듬)
	//	- 고비용 (박싱 + 언박싱)
	Object n = 10;
	System.out.println((int)n +10);
	
	
	
	}//main
	
			
}//Ex52 class



class AAAA{}
class BBBB extends AAAA{}
class CCCC extends BBBB{}
class DDDD extends CCCC{}