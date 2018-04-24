class Ex14_Operator {

	public static void main(String[] args) {
/*
		//Ex14_Operator.java
		

		//연산자, Operator
		//	- 피연산자(Operand)를 대상으로 미리 정해진 연산을 한 후에 결과값을 반환하는 역할

		//1. 산술연산자
		//	- +, -, *, /, %(나머지연산자, mod)
		// - 이항 연산자(2항) -> 피연산자를 2개를 갖는 연산자

		int a = 10;
		int b = 3;

		System.out.println(a + b);
		System.out.println(a - b);
		System.out.println(a * b);
		System.out.println(a / b);//3 -> 정수/정수는 정수
		System.out.println(a % b);//1

		
		//달력 만들기 		
		//해당 년 월의 마지막날? -> 그냥 암기하기 패턴 없음
		//해당 년 월의 1일의 요일 -> 기준값 1970.1.1 or 1.1.1




		//나머지 작업
		//정수 / 정수 = 정수
		//실수 / 실수 = 실수
		//정수 / 실수 = 실수
		//실수 / 정수 = 실수
		// -> 모든 산술 연산은 두 피연산자 중 더 큰자료형으로 연산 결과가 반환된다.(****)

		System.out.println(10 / 3); //정수/정수는 소수점 이하 버림
		System.out.println(10.0 / 3.0); //
		System.out.println(10/3.0); //int 나누기 double
		System.out.println(10.0/3); //int 나누기 double


		byte b1 = 10;
		int n1 =20;
		System.out.println(b1+n1); //연산 결과는 int

		int n2 = 2000000000;
		int n3 = 1000000000;
		System.out.println(n2 + (long)n3); // 합쳤을 때 int 초과해버리면 안됨 , 둘중하나 캐스팅해주기

		//정수형 리터럴 = int형 원래 64bit니까 8byte가 됐어야 하는데 이전에 계속 4byte였어서 편의성 위해서 4배정함

		byte b2 = 10, b3 = 20, b4;

		b4 = (byte)(b2 + b3); //결과값이 int로 나옴 b2+(int)b3
		System.out.println(b4)
*/		

		//2. 비교연산자
		//	- 피연산자들의 비교 우위를 반환하는 역할
		//	- 이항 연산자
		//	- >, >=, <, <=, ==(equal), !=(not equal, 같지않다.)
		//	- A > B : 정수형, 실수형 대상
		//	- 항상 연산의 결과를 boolean으로 반환한다. (true, false)


		int result = 0;
		result = 1 + 2 * 3 + 4;

		System.out.println(result);
		
		//연산순위 : 1. 산술연산 2. 비교연산
		//연산이 끝나면 연산결과를 돌려주고 끝난다 (2 + 3 + 4) -> ( 5 + 4 )

		int a = 10; 
		int b = 3;

		System.out.println(a > b);
		System.out.println(a >= b);
		System.out.println(a < b);
		System.out.println(a <= b);
		System.out.println(a == b);
		System.out.println(a != b);

		//실수와 정수간의 비교
		System.out.println(3.5 > 3);

		//논리형 비교 x
		//System.out.println(true > false);
		System.out.println(true == true);

		//문자형 비교
		//유효성 검사
		System.out.println('A' > 'B');//내부적으로는 문자코드값으로 비교
		// 사용자 문자 입력 -> 'c' -> 영어 소문자?

		char input = 'c';

		System.out.println(input >= 'a');
		System.out.println(input <= 'z');
		//둘다 아니오라는 답이 나올수는 없고, 둘중에 하나라도 false나오면 거짓임
		//둘다 네라는 답이 나와야함

		
		//문자열(참조형) 비교
		String s1 = "홍길동";
		String s2 = "홍길동";
		String s3 ="홍";
		s3 = s3 + "길동";

		System.out.println(s3);

		//System.out.println(s1 > s2); //안됨
		System.out.println(s1 == s2);
		System.out.println(s1 == s3);

		//***모든 참조형(문자열)의 비교는 비교 연산자(==, !=)를 사용할 수 없다.
		// -> equals()메소드 사용 // 무조건 이거 사용
		System.out.println();
		System.out.println(s1.equals(s2));
		System.out.println(s1.equals(s3));
		System.out.println();

		int m1 = 10;
		int m2 = 10;
		int m3 = 5;
		m3 = m3 + 5;

		System.out.println(m1 == m2);
		System.out.println(m1 == m3);


		System.out.println((2 * 3) > (4 / 2));

		//3. 논리 연산자
		//	- 이미 정해진 연산 규칙에 따라 결과를 반환
		//	- 이항 연산자
		//	- 일항 연산자(!)
		//	- &&(and), ||(or), !(not)
		//	- 피연산자를 boolean만 갖는다.
		//	- 연산의 결과를 boolean만 반환한다.
	
		//	- A&&B
		//		T	T     -> T
		//		T	F     -> F
		//		F	F     -> F
		//		F	F     -> F

		//	- A&&B
		//		T	T     -> T
		//		T	F     -> T
		//		T	F     -> T
		//		F	F     -> F

		// !true -> f
		// !


		//boolean f1 = true;
		//boolean f2 = false;
		System.out.println();
		System.out.println();
		System.out.println();

		//System.out.println(f1 && f2);
		//System.out.println(fq || f2);

		//나이 입력 -> 통과, 거절
		//조건 ; 20세 이상 ~ 60세 미만
		int age = 85;
		//System.out.println(20 <= age < 60);// true < 60 이 돼서 말이 안되는 식이 됨
		System.out.println((20 <= age) && (age < 60)); //위의 식 아래와 같이 고쳐서 쓰면 됨 
		System.out.println((age >= 20) && (age < 60)); //권장

		//중심이 되는 데이터를 먼저 쓰세요
		//age >= 20 //o 
		//20 <= age //x

		//&& -> ||
		
		System.out.println(!((age < 20) || (age >= 60))); // &&가 ||로 바뀌면 좌우측 조건도 정반대로 바꾸면 됨 
		//  =  System.out.println((age >= 20) && (age < 60));


		//short circuit
		age = 10;
		System.out.println((age >= 20) && (age < 60));// &&뒤에 틀린 문장이 와도 앞이 false면 아예 시도 안함, 앞이 f니까 걍 f
		System.out.println(!((age < 20) || (age >= 60)));// -- 앞이 t니까 걍 t

		//4. 대입 연산자
		//	- 할당 연산자 
		//	- 이항 연산자
		//	- LValue(변수) = RValue(상수, 변수)
		//  - LValue 와 RValue는 반드시 자료형 동알(형변환 관계)
		//	- =
		//	- +=, -=, *=, /=, %= ...   (->복합대입연산자)
		//	- 연산자 우선 순위가 가장 낮다.

		int num = 10;
        //      ② ①
		//10 = 5; -> 공간이 아니면 왼쪽에 못와
        //상수도 어딘가의 공간에 4바이트로 잡혀있어
		//그 담에 int num 잡아서 넣은 다음에 원래 있던 자리인 4바이트 버려


		//누적
		num = num + 1;
		num += 1;

		System.out.println(num);//12
		
		num = num - 1;
		num -= 1;
		System.out.println(num);//10

		num *= 3; //num = num * 3
		System.out.println(num);//30

		num /= 4; //num = num / 4;
		System.out.println(num);//7

		num %= 3; //num = num % 3;
		System.out.println(num);//1

		//주의!! 줄이기 안되는것
		//num = 100 -num;
		//num -= 100; -> 위에거랑 다른 뜻임
		
		//연산 우선 순위
		//	- 한 문장내에서 연산자들이 2개 이상 존재할 때 실행할 순서
		//	- () > 산술 > 비교 > 논리 > 대입
		
		//연산자 실행 방향
		//	- 한 문장내에서 동급의 연산자가 2개 이상 존재할 때
		//	- 대부분 : 왼쪽 -> 오른쪽
		//	- 대입 연산자 : 왼쪽 <- 오른쪽

		/*
		int a, b, c;
		a = 10;
		b = a;
		c = a;
		
		c = b = a;
          ②  ①
		*/

	   //5. 증감 연산자
	   //	- ++(증가), --(감소)
	   //	- 단항 연산자
	   //	- 피연산자의 값을 +1/-1
	   //	- 상황에 따라 연산자 우선 순위 변경된다.
	   //		a. ++num : 전위(연산자 우선 순위 최고)
	   //		b. num++ : 후위(연산자 우선 순위 최하)

	   num = 10;
	   
	   //num = num + 1
	   //num += 1
	   ++num; //1증가 혹은 1감소 

	   System.out.println(num);

	   --num;

	   System.out.println(num);//10

	   num = 10;
	   result = 0;

	   //result = 20 + ++num;
	   ++num;
	   result = 20 + num;

	   System.out.println(result);

	   num = 10;
	   result = 0;

	   //result = 20 + num++;
	   //       ②    ①   ③
	   result = 20 + num;
	   num++;
	   
	   System.out.println(num);
	   System.out.println(result);

	   int o = 10;
	   System.out.println(--o - o--);

	   // 아래 4개는 다른애들이랑 엮지 말기 헷갈림 따로쓰기
	   // num++;
	   // ++num;
	   // num--;
	   // --num;

	   //6. 조건 연산자
	   //	- 조건을 제시하고 그 결과에 따라 연산의 결과를 반환
	   //	- 삼항 연산자
	   //	- A ? B : C 
	   //	- A(조건식 -> 반드시boolean값 -> t 아니면 f)
	   //	- B, C : 변수, 상수
	   

	   num = true ? 10 : 20;    // ->10
	   //false ? 10 : 20;   // ->20
		//-> 연산이 끝나면 int 상수가 남는다. 그래서 num에 담아둔다
		System.out.println(num);
	
		age = 25;
		String msg = (age >= 20 && age <60) ? "통과" : "거절";
		System.out.printf("나이 %d세는 '%s'입니다\n", age, msg);

		

	  
























		



















































        




















		
	}

}
