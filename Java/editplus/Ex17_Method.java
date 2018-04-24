class Ex17_Method {

	public static void main(String[] args) {

		 //Ex17_Method.java

		 //메소드
		 //	 - 행동의 단위(1가지 목적을 가지고 있는 코드의 집합)
		 //	 - 프로그램의 전체 흐름 : main() 메소드 -> 메소드 ->
		 //  - 메소드 호출 -> 해달 메소드 정의부로 제어가 이동 -> 해당 메소드 종료 -> 메소드 호출했던 곳으로 돌아가기 : 흐름 파악(***)
		 //	 - 메소드 구성 요소 : 메소드명, 인자리스트, 반환값
		 
		 int a = 10;
		 int b = 20;

		 int result = m1("둘");

		 //System.out.printf("'%s'는 숫자 '%d'입니다.\n", str, result);

		 //상수가 두군데 이상 오면 변수로 고쳐놓기 
		 //문자열 더하기 연산자 -> 연산자 실행 순서
		 System.out.println(10 + 20 + 30); // 60
		 System.out.println(10 + 20 + "30"); //3030
	     System.out.println(10 + "20" + 30); // 102030
		 System.out.println("10" + 20 + 30); // 10 ? -> 102030 

		
         //10 + 20 = 30
		 System.out.println(a + " + " + " b " + " = " + a + b);
		 System.out.println(a + " + " + " b " + " = " + (a + b)); //정상 결과치 괄호 넣어줘서 우선순위 높이기
		 //연산결과는 10 + 20 = 1020 으로 나옴

		 //변수 
		 //1. 지역 변수, Local Variable
		 //	 - 특정 지역내에서 선언된 변수
		 //  - 지역 : 메소드, 제어문 등
		 //  - 선언될 때 태어나고 다시 돌아갈 때 소멸
		 //2. 멤버 변수, Member Variable
		 //	 - 클래스 변수, Class Variable

		 //지역 변수의 생명 주기(Life Cycle)
		 //	 - 변수가 언제 태어나고,        언제 죽는지?
		 //				   (메모리 할당)    (메모리 소멸)
		 //  - 변수 선언문이 실행될 때 태어나고, 변수 선언문이 포함된 블럭에서 제어가 벗어날 때 소멸된다. -> 면접에서 나올 수 있음 , 30~60초 정도 설명가능하게 외우기
		 //  - 평균적으로 메인메소드에 있는 변수들이 제일 오래 살아남음, 메모리 쓸데없이 점유하고 있기 때문에 메인에는 적게하고 최대한 메소드 활용
         
		 m2();

		 m3();
		
		 int num  = 10;
		
		 m3();

		 System.out.println(num);

		 m4();


	}//main

    public static void m4(int num){
		System.out.println(num);//10
		num = 20;
	 
	}

	public static void m3() { 
		
		int num = 20 ;

	}


	public static int m1(String str){ //매개변수
		
		int n = str.equals("하나") ? 1 : (str.equals("둘")? 2 : (str.equals("셋") ? 3 : 0));  // 너무 중첩돼서 좋은 코드는 아님

		// n = 1 + (2 + 3) 같은 형식이라고 생각하기 

		return n ; //반환값

	}

     public static void m2() {

		int n = 10;
		System.out.println(n);

	 }

}
