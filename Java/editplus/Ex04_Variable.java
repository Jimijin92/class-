class Ex04_Variable {

	public static void main(String[] args) {

		//Ex_Variable.java

		//변수, Variable
		//	- 자료형을 사용해서 메모리에 얻은 공간
		//	- 값(데이터)을 저장하는 공간(용도)

		//1. 변수 선언(생성)
		//	- 자료형 변수명;
		byte kor;

		//2. 변수 초기화
		//	- 변수 = 값; // 대입 연산자(우측에 있는 값을 좌측에 있는 변수에 넣어주세요)
		kor=100;

		//3. 변수 사용(호출, 접근 ..)
		System.out.println(kor);

		//4. 변수 치환
		kor= 96;
		//틀리면 처음부터 다 고쳐서 비용문제 그래서 인터프리터 병행됨
		//소스 수정하면 재컴파일, 재컴파일 안하면 반영 안 돼있음
		//byte -128 ~127 
		System.out.println(kor);



		//변수 vs 상수
		//	- 변수 사용? 상수 사용?
		//내 몸무게 출력
		//1. 상수(사용x 뭘 뜻하는지 모르기 때문에, 나중에 자기코드 자기가 못알아봄) 
		System.out.println(70);

		//2. 변수(무조건 변수 택해라)
		byte weight;
		weight = 70;
		System.out.println(weight);



		//변수명 명명법
		//1. 영문자, 숫자, _
		//2. 숫자 시작x
		//3. 예약어 사용 불가(java reserved word)
		//4. 의미있게(*********)
		byte eng;
		byte MATH;
		byte name1;
	    byte name2;
		byte student_kor;
		//byte test+-;
		byte 국어;
		국어 = 80;
		System.out.println(국어);


		byte _100kor;
		byte byte;

		byte a;
		byte b;
		byte c;


		byte kor;
		byte math;
		byte eng;

		byte korScore;
		byte mathScore;

		//약어 x 간단한거보다 가독성을 중요시해
		byte studentNumber;
		byte sn; //-> 하지마

		
		int n1;//변수 선언
		n1 = 100;//변수 초기화
		int n2 = 200; //변수 선언 + 초기화
		
		int n3;
		int n4;

		int n5, n6, n7, n8;

		int n9 =10, n10 = 20, n11 = 30;
		int n12 =10 , n13, n14=30; //꼭 다 선언해야 하는 것은 아님
		
	}

}
