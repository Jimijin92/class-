//block 
//class Ex05_Variable { // K&R 스타일(브라이언 커니핸 & 데니스 리치)


class Ex05_Variable
{//Allman스타일

	public static void main(String[] args) {

		//Ex05_Variable.java

		byte a;
		//byte a;
		//int a;
		//a=10;

		//국어, 영어, 수학
		int kor, eng, math; //국어, 영어, 수학
		// 어떤 용도로 만들었는지 주석을 달아주는게 중요하다.
		

		int weight // 몸무게
			, height; // 키
	

		//각자료형 변수 생성 + 데이터
		

		//정수형 
		//1. byte

		//정수형 상수, 정수형 리터럴 라고 부른다(바이트상수 아님)
		byte b1 = 10; //b1(변수), 10(데이터, 상수, Literal)
		//b1 = 128; //OverFlow Error /오버플로우 에러 -128~127
		//b1 = -129;//UnderFlow, Error/언더플로우 에러 
		//-> 합쳐서 OverFlow Error라고 부르기도 함


		//2. short
		short s1 = 10;
		//si = 32768;// 32767까지만 가능 //incompatible types: possible lossy conversation from int to short


        //3. int
		int n1 =10;
		//n1 = 21000000000;//integer number too large: 2200000000

		//4. long
		long l1 = 10;
		//l1 = 10000000000000000L;//integer umber too large:10000000000000000000000 

		//모든 상수는 다 integer로 취급한다.

		//대입 연산자
		// - 변수 = 값;
		// - LValue(변수) = RValue(변수, 상수);
		// - 반드시 LValue와 RValue의 자료형이 일치

		//int a = 10;
		//int b;
		//b = a;

		//실수형(float와 double의 차이는 정밀도차이/double이 기본형으로 쓰임 )
		float f1 = 3.14F;
		f1 = 1234567890123456789.1234567890123456789F;
		System.out.println(f1);

		double d1 = 2.58;
		d1 = 1234567890123456789.1234567890123456789;
		System.out.println(d1);

		//논리형
		boolean flag = true;
		flag = false;
		System.out.println(flag);

        //문자형
		char c1 = 'A';
		System.out.println(c1);

		c1 = '가';
		System.out.println(c1);

		//c1 = 'ABC';
		//System.out.println(c1);

		c1 = '1';
		System.out.println(c1);



		//기본형x
		//참조형o

		//char : 문자 1개

		//홍길동
		//String : 문자 여러개

		String name = "홍길동";

		
		//int num = 10;
		int Num = 20;
		int nuM = 30;
		int nUm = 40;

		//자바에서..
		//변수명
		//1. 단어를 소문자로 기재
		int NUM = 10;
		int num = 10;

		//학생 번호
		//Student Number
		int studentNumber; //캐멀 표기법
		int student_number; //스네이크 표기법
		
		//記數法 기수법
		//10진법, 2진법, 8진법, 16진법...

		int n2 = 10; //10진수
		System.out.println(n2);

		int n3 = 010; //8진수
		System.out.println(n3);

		int n4 = 0x10; //16진수
		System.out.println(n4);

	

























     }
}




























