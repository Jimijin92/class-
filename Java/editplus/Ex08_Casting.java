class Ex08_Casting {

	public static void main(String[] args) {

		//형변환
		//1. 암시적인 형변환
		//2. 명시적인 형변환
		
		//정수 -> 정수
		
		byte b1 =10;	//원본   1byte
		long l1 = 11;		//복사본 8byte
		
		//암시적인 형변환(원본손실x)
		//l1 = b1;
		l1 = (long)b1;  //권장

		System.out.println(l1);//복사본 확인 		


        //실수형
		float f1 =3.14f; //원본// 에러나는 이유 왼쪽은 8 오른쪽은 4 /큰게 작은데로 /그럴땐 명시적인 형변환 필요/원래 (float)3.14
		double d1;       // 복사본
		
		//float을 doble로 바꾸거나 그 반대는 보통 잘 안함
		//암시적인 형변환
		d1 =f1;

		System.out.println(d1);
		//키 매크로 
	    
		double d2 = 1.23456789012345; //원본
		float f2; //복사본
		System.out.println(d2); 
		
		f2 = (float)d2;
		System.out.println(f2);	


		//실수 <-> 정수
		double d3 = 3.14;   //3.99로 하면 4가 되는지 아니면 아예버리는지 확인 꼭하기 // 상황따라 다름
		int n3;

		//?
		n3 = (int)d3; //무조건 버림 //명시적 형변환 필요

		System.out.println(n3);

		float f4 = 3.14F;
		long l4;

		//큰형(8) = 작은형(4)// 숫자 자체는 8바이트, 4바이트지만 범위는 왼쪽항이 훨씬 크다 그래서 명시적으로 해줘야함
		//수의 범위(o), 바이트 크기(x)-> 정수형과 실수형 경우에 
	
		l4 = (long)f4;
		
		System.out.println(l4);


		//기본형의 범위 비교  (Stirng은 참조형으로 밑에 애들이랑 뒤섞을 수가 없음)
		//byte(1) < short(2) < int(4) < long(8) < float(4) < double(8)
		//			char(2)
		//boolean(1)

		//** 기본형과 참조형끼리는 변환이 불가능(메모리 구조 떄문에..)

		//boolean은 형변환의 대상이 될 수 없다.
		// (int)true; <- 이런거 없다


		//문자형
		// - 'A' -> 65 (문자코드값이라 불리는 정수와의 전환만 가능하다)
		char c5 = '가'; //2byte ★★★★★A대신 '가'를 넣으면 -21504 나옴 컴파일 에러없이 그래서 short 안씀
		                // char는 부호비트가 없음, 양의 정수밖에 없음 숫자니까 그래서 4만대까지 표현가능하지만 short는 3만대까지밖에 표현이 안됨 -> int사용 
		short s5; //2byte

		//숫자 = 문자
		s5 = (short)c5;

		System.out.println(s5);

		System.out.println((char)66);


		char c6 = '가'; // 2byte
		int n6; //4byte

		n6 = c6;

		System.out.println(n6);

		
		int n7 = 65;
		char c7 = '5';

	    System.out.println(n7);
		System.out.println((int)c7);

		System.out.println((int)'A');//65
		System.out.println((int)'Z');//90
		System.out.println((int)'a');//97
		System.out.println((int)'z');//122
		System.out.println((int)'0');//48
		System.out.println((int)'9');//57

		System.out.println((int)'가');//한글의 시작
		System.out.println((int)'힣');//한글의 끝







			}

}
