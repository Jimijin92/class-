import java.io.BufferedReader;
import java.io.InputStreamReader;

class 연습용 {
	
	public static void main(String[] args) throws Exception{

BufferedReader reader = new BufferedReader(new
		InputStreamReader(System.in));

/*
문제1.
요구사항] 나이를 입력받아 태어난 년도를 출력하시오.
입력]나이 : 27
출력] 태어난 년도 : 1990년
조건] 현재 년도 = 2017년
*/
		
		System.out.println("==========문제1==========");
		System.out.print("나이 : ");
		String age = reader.readLine();
		int intage = Integer.parseInt(age);

		System.out.printf("태어난 년도 : %d\n", 2017 - intage);
		



/*
문제 2. -> 완료
요구사항] 숫자 2개를 입력받아서 연산과정과 결과를 출력하시오
입력] 첫번째 숫자 :5
      두번째 숫자 :3
출력] 5 + 3 = 8
      5 - 3 =2
      5 * 3 = 15
      5 / 3 = 1
      5 % 3 = 2
조건] 입력값은 정수만
      숫자 천단위 표기
*/

		System.out.println("==========문제2==========");
		System.out.print("첫번째 숫자 : ");
		String n1 = reader.readLine();
		int n2 = Integer.parseInt(n1);

		System.out.print("두번째 숫자 : ");
		String n3= reader.readLine();
		int n4 = Integer.parseInt(n3);

		System.out.printf("%d + %d = %d\n", n2, n4, n2+n4);
		System.out.printf("%d - %d = %d\n", n2, n4, n2-n4);
		System.out.printf("%d * %d = %d\n", n2, n4, n2*n4);
		System.out.printf("%d / %d = %d\n", n2, n4, n2/n4);
		System.out.printf("%d %% %d = %d\n", n2, n4, n2%n4);


/*
문제3. -> 완료
요구사항] 사각형의 너비와 높이를 입력받아 넓이와 둘레를 출력하시오.
입력] 너비(cm) : 20
      높이(cm) : 10
출력] 넓이 : 200cm2
      둘레 : 60cm 
*/
		System.out.println("==========문제3==========");
		System.out.print("너비(cm) : ");
		String wideth = reader.readLine();
		int w1 = Integer.parseInt(wideth);

		System.out.print("높이(cm) : ");
		String height= reader.readLine();
		int h1 = Integer.parseInt(height);

		System.out.printf("넓이 : %dcm2 \n", w1 + h1);
		System.out.printf("둘레 : %dcm \n", 2*(w1+h1));


/*
문제4.
요구사항] 자전거 바퀴휠(지름26인치), 페달수 입력받아 총 m를 갔는지 출력하시오.
조건] 페달 1바퀴 -> 바퀴 1회전
      소수 이하 출력
입력] 페달 수 : 1000
출력] 총 3,000m를 이동했습니다.
*/
		System.out.println("==========문제4==========");
		System.out.print("페달 수 : ");
		String roll = reader.readLine();
		
        double douRoll = Double.parseDouble(roll);
		double total = douRoll*3.14*26*0.0254;
		int intRoll = (int)total;

		System.out.printf("총 %dm를 이동했습니다.\n", intRoll);


/*
문제5.
요구사항] 영소문자 1개 입력받아 대문자로 변환시켜 출력하시오.
입력] 문자 : a
출력] 'a'의 대문자는 'A'입니다.
조건] 문자 코드값 + 형변환 + (대문자와 소문자간의 차이?)
*/
		System.out.println("==========문제5==========");
		System.out.print("영 소문자 : "); 
		int alpha = reader.read();
        System.out.printf("'%c'의 대문자는 '%c'입니다.\n", alpha, alpha-32); 
		
  


/*
문제6.  -> 완료
요구사항] 한달 수익을 입력받아 세후 금액을 출력하시오.
입력] 금액(원) : 1000000
출력] 세후(원) : 967000원
조건] 세금 : 3.3%
      출력 소수점 이하x
*/
    /*  System.out.println("==========문제6==========");
      System.out.print("금액(원) : "); 
      String income = reader.readLine();
	  int inc = Integer.parseInt(income);
      System.out.printf("세후(원) : %.0f원\n", inc*(1-0.033));


	  System.out.println("==========문제6-1, 다른 방식==========");
      System.out.print("금액(원) : "); 
      String income2 = reader.readLine();
	  int inc2 = Integer.parseInt(income2);
      System.out.printf("세후(원) : %,d원\n", inc2-inc2*(33/1000));	  


	  System.out.println("==========문제6-2, 다른 방식==========");
      System.out.print("금액(원) : "); 
      String income2 = reader.readLine();
	  int inc2 = Integer.parseInt(income2);
	  double inc3 = inc2*(1-0.003);
      System.out.printf("세후(원) : %,d원\n", (int)inc3);	  */ //5번이랑 연결했을 때 에러남


/*
문제7. -> 완료
요구사항] 숫자를 2개 입력받아 그 중 큰 숫자를 출력하시오.
입력] 첫번째 숫자 : 5
      두번째 숫자 : 3
출력] 큰 수 : 5
*/      System.out.println("==========문제7==========");
        System.out.print("첫번째 숫자 : ");
		String firstNumber1 = reader.readLine();
		int fn1 = Integer.parseInt(firstNumber1);

		System.out.print("두번째 숫자 : ");
		String secondNumber1= reader.readLine();
		int sn2 = Integer.parseInt(secondNumber1);

        int greater1 = (fn1 > sn2) ? fn1 : sn2;
		System.out.printf("큰 수 : %d\n", greater1);



/*
문제 7-1. -> 완료
입력] 첫번째 숫자 : 5
      두번째 숫자 : 3
	  세번째 숫자 : 8
출력] 가장 큰 수 : 8
//조건 연산자 써서 풀기 
*/
        System.out.println("==========문제7-1==========");
        System.out.print("첫번째 숫자 : ");
		String firstNumber = reader.readLine();
		int fn = Integer.parseInt(firstNumber);

		System.out.print("두번째 숫자 : ");
		String secondNumber= reader.readLine();
		int sn = Integer.parseInt(secondNumber);

		System.out.print("세번째 숫자 : ");
		String thirdNumber = reader.readLine();
		int tn = Integer.parseInt(thirdNumber);

        int greater = (fn > sn) ? fn : sn; 
        
		int firstGreater = (tn > greater) ? tn : greater;
		System.out.printf("큰 수 : %d\n", firstGreater);


/*
문제8.
요구사항] 2017년 11월 1일은 수요일입니다. 2017년 11월 중 한 날짜를 입력받아 무슨 요일인지 출력하시오.
입력] 날짜 : 28
출력] 28일은 화요일입니다.
//나머지 연산자, 조건연산자 써서
*/
 
        System.out.println("==========문제8==========");
        System.out.print("날짜 : ");
        String day = reader.readLine();
        int = 30 % day 
        








        System.out.printf("%d일은 %s입니다.\n", day, );






/*
문제9. 
요구사항] 영문자를 1개 입력받아 대문자? 소문자?
입력] 문자 : a
출력] 'a'는 소문자입니다.
입력] 문자 : H
출력] 'H'는 대문자입니다.

*/

	}////////////////////////////////////main///////////////////////////////////////////////
//================================================================================================================================

/*
문제1.
요구사항]이름을 건네주면 이름뒤에 "님"을 붙여서 반환하는 메소드 선언
입력] 이름 : 홍길동
출력] 고객 : 홍길동님
서명] String getName(String name)//{}
*/


/*
문제2.
요구사항] 숫자를 건네주면 '짝수'인지 '홀수'인지 반환하는 메소드 선언
입력] 숫자 : 5
출력] 입력하신 숫자 5는(은) '홀수'입니다.
서명] String getNumber(int num)
*/



/*
문제3.
요구사항] 국/영/수 점수를 건네주면 합격/불합격을 반환하는 메소드
입력] 국어 : 80
	  영어 : 75
	  수학 : 60
출력] (불)합격입니다.
조건] 평균 60점 이상 합격, 미만 불합격
추가] 과락 40점 미만 불합격
서명] String test(int kor, int eng, int math)
*/


/*
문제4.
요구사항] 지하철의 역의 개수, 환승 횟수 입력받아 총 소요시간을 반환하는 메소드
입력] 역의 개수 : 15
      환승 횟수 : 1
출력] 총 소요 시간은 33분입니다.
조건] 각역의 소요시간 : 2분
      환승시간 : 3분 
서명] int getTime(int, int)

추가] 역의 개수 : 15
      환승 횟수 : 1
	  구분      : 평상
추가] 환승 소요시간 
      - 평상 : 3분
	  - 출근 : 4분
	  - 퇴근 : 5분
서명] int getTime(int, int, String)
*/

/*
문제5.
요구사항] 사과나무. 며칠이 지났을 때 사과가 몇개가 열리는지?
입력] 맑은 날 : 20
      흐린 날 : 5
출력] 사과가 좋 00개 열렸습니다.
조건] 사과나무를 처음 심었을 때 : 0m
      맑은 날 성장률 : 5cm
	  흐린 날 성장률 : 2cm
	  사과나무가 1m넘는(초과) 시점부터 사과가 열린다.
	  1m넘는 시점 10cm 자랄때마다 사과가 1개씩 열린다
서명] int getApple(int,int)





*/
	
//=================================================================================

/*
날짜/시간 문제
	- 제어문 사용x
	- 삼항 연산자o

문제1. 
요구사항] 태어난 년도를 입력받아 나이를 출력하시오.
입력] 년도 : 1995
출력] 나이 : 27세
조건] 현재 년도를 기준, 우리 나라 나이 
*/
          
        public static void age() throws Exception{
		BufferedReader reader = new BufferedReader(new
        InputStreamReader(System.in));

        System.out.println("==========문제1==========");
        System.out.print("첫번째 숫자 : ");
	    String birth = reader.readLine();

		int mybirth = Integer.parseInt(birth);    
		Calendar c = Calendar.getInstance();

		System.out.printf("나이 : %d세\n", (c.get(Calendar.YEAR) - mybirth) + 1 );
		
		
		}//age()

/*
문제2.

요구사항]남자와 여자의 이름 입력 + 만난날 입력 -> 기념일 출력
입력] 남자 : 홍길동
      여자 : 호호호
	  년 : 2017
	  월 : 12
	  일 : 4

출력] 
================================
'홍길동'과(와) '호호호'의 기념일 
================================

100일 : 2018년 3월 28일
200일 : 2018년 7월 10일
300일 : 2018년 11월 25일
500일 : 2018년 3월 28일
1000일 : 2018년 3월 28일
*/

        public static void aniversary() throws Exception{
		BufferedReader reader = new BufferedReader(new
        InputStreamReader(System.in));


        System.out.println("==========문제2==========");
        System.out.print("남자 : ");
	    String manName = reader.readLine();
		
	    System.out.print("여자 : ");
	    String womanName = reader.readLine();



		System.out.print("년 : ");
	    String year = reader.readLine();
		int intYear = Integer.parseInt(year); 

		System.out.print("월 : ");
	    String month = reader.readLine();
		int intMonth = Integer.parseInt(month); 

		System.out.print("일 : ");
	    String day = reader.readLine();
		int intDay = Integer.parseInt(day);

        Calendar meeting = Calendar.getInstance ( );
        meeting.set(intYear, intMonth-1, intDay);
		
        System.out.println("=====================================");
	    System.out.printf("'%s'과(와) '%s'의 기념일\n", manName, womanName);
		System.out.println("=====================================");
		meeting.add(Calendar.DATE, 100 );
		System.out.printf("100일 : %d년 %d월 %d일\n"
		                                            , meeting.get(Calendar.YEAR)
												    , meeting.get(Calendar.MONTH)+1
													, meeting.get(Calendar.DATE));
		meeting.add(Calendar.DATE, 100 );
		System.out.printf("200일 : %d년 %d월 %d일\n"
		                                            , meeting.get(Calendar.YEAR)
													, meeting.get(Calendar.MONTH)+1
													, meeting.get(Calendar.DATE));
		meeting.add(Calendar.DATE, 100 );
		System.out.printf("300일 : %d년 %d월 %d일\n"
		                                            , meeting.get(Calendar.YEAR)
													, meeting.get(Calendar.MONTH)+1
													, meeting.get(Calendar.DATE));
		meeting.add(Calendar.DATE, 200 );
		System.out.printf("500일 : %d년 %d월 %d일\n"
		                                            , meeting.get(Calendar.YEAR)
												    , meeting.get(Calendar.MONTH)+1
													, meeting.get(Calendar.DATE));
		meeting.add(Calendar.DATE, 500 );
		System.out.printf("1000일 : %d년 %d월 %d일\n"
		                                            , meeting.get(Calendar.YEAR)
													, meeting.get(Calendar.MONTH)+1
													, meeting.get(Calendar.DATE));
	   
		
		}//aniversary()
	
  




/*
문제3
요구사항] 배달을 동시에 받기를 원하는 고객. 각각의 음식을 언제 주문?
조건] 짜장면 10분 후 도착 
      치킨 18분 후 도착
	  피자 25분 후 도착

입력] 원하는 도착 시간
      시 : 17
	  분 : 30
출력] 짜장면 : 17시 20분
      치킨 : 17시 12분
      피자 : 17시 5분
*/

		public static void delivery() throws Exception{
		
		BufferedReader reader = new BufferedReader(new
        InputStreamReader(System.in));

		System.out.println("==========문제3==========");
		
		System.out.println("원하는 도착 시간");
        System.out.print("시 : ");
	    String hour = reader.readLine();
		int intHour = Integer.parseInt(hour);
		
	    System.out.print("분 : ");
	    String minute = reader.readLine();
		int intMinute = Integer.parseInt(minute);
 
        Calendar jit = Calendar.getInstance( );
		jit.set(Calendar.HOUR_OF_DAY, intHour);
		jit.set(Calendar.MINUTE, intMinute);
		
		jit.add(Calendar.MINUTE, -10);   
        System.out.printf("짜장면 : %d 시 %d 분\n"
		                                         , jit.get(Calendar.HOUR_OF_DAY)
											     , jit.get(Calendar.MINUTE));
	    jit.add(Calendar.MINUTE, -8);   
        System.out.printf("치킨 : %d 시 %d 분\n"
		                                         , jit.get(Calendar.HOUR_OF_DAY)
											     , jit.get(Calendar.MINUTE));
		jit.add(Calendar.MINUTE, -7);   
        System.out.printf("피자 : %d 시 %d 분\n" 
			                                     , jit.get(Calendar.HOUR_OF_DAY)
			                                     , jit.get(Calendar.MINUTE));
		

		}//delivery()




//=====================================================================================================================

/*
if문(switch문)

문제1.
요구사항] 숫자를 2개 입력받아 큰수와 작은수를 출력하시오.
입력] 첫번째 숫자 : 5
      두번째 숫자 : 3
출력] 큰수는 5이고, 작은수는 3입니다.
사용] if
*/
	public static void greater() throws Exception{
   
		 BufferedReader reader = new BufferedReader(new
		 InputStreamReader(System.in));

		 System.out.print("첫번째 숫자 : ");
		 int firstNum = Integer.parseInt(reader.readLine());
         System.out.print("두번째 숫자 : ");
		 int secondNum = Integer.parseInt(reader.readLine());

		 if (firstNum > secondNum) {
			 System.out.printf("큰수는 %d이고, 작은수는 %d입니다.\n"
			                                               , firstNum
														   , secondNum);
		 } else if(firstNum < secondNum) {
			 System.out.printf("큰수는 %d이고, 작은수는 %d입니다.\n"
			                                               , secondNum
														   , firstNum);
		 } else {
             System.out.printf("%d와 %d는 같은수입니다.\n"
			                                               ,secondNum
														   , firstNum);	  
		 } 
 
      //같지 않으면을 큰 카테고리로 놓고 크다만 안에 넣을수도 있음

	}//greater() 문제1.


/*
문제2.
요구사항] 점수를 입력받아 성적을 출력하시오.
입력] 점수 : 85
출력] 입력한 점수 85점은 B입니다.
조건] 90~100 : A
      80~89  : B
	  70~79  : C
	  60~69  : D
	  0~59   : F
추가]유효성 검사(점수 0~100이내) (가정: 무조건 숫자만 입력했다)
사용]if, switch(생각 - 범위 검사 x)
*/

	public static void grade() throws Exception{

		 BufferedReader reader = new BufferedReader(new
         InputStreamReader(System.in));

	     System.out.print("점수 : ");
	     int score = Integer.parseInt(reader.readLine());
		 String result = " ";
		
		 //유효성 검사
		 if (score >= 0 && score <= 100) {
			 
			 //비즈니스 코드, 업무 코드
			 if(score >=90) {
			 result = "A";

			 } else if (score >=80){
			 result = "B";

			 } else if (score >=70){
			 result = "C";

			 } else if (score >=60){
			 result = "D";
			 
			 } else {
			 result = "F";
		     }
			 System.out.printf("입력한 점수 %d점은 %s입니다.\n"
			                                               , score
														   , result);
	     
         //예외 처리 코드
		 } else {
			System.out.println("점수 다시입력");
		 }
		
	}//grade(), 문제 2
 

/*
문제3.
요구사항] 숫자 2개와 연산자 1개를 입력받아 연산과정과 결과를 출력하세요
입력] 숫자1 : 5
      숫자2 : 3
	  연산자 : *

출력] 5*3 = 15
조건] 입력(정수)
      출력(소수이하 1자리까지)
	  연산자(산술 연산만...)
사용]if
*/

	
	public static void cal() throws Exception{

		 BufferedReader reader = new BufferedReader(new
         InputStreamReader(System.in));
        
		 System.out.print("숫자1 : ");
	     int num1 = Integer.parseInt(reader.readLine());
		 
         System.out.print("숫자2 : ");
	     int num2 = Integer.parseInt(reader.readLine());

		 System.out.print("연산자 : ");
	     String cal = reader.readLine();

              
		 if (cal.equals("+")){
			int calResult = num1 + num2;
		 } else if(cal.equals("-")){
	        calResult = num1 - num2;
         } else if(cal.equals("*")){
			calResult = num1 * num2;
		 } else if(cal.equals("/")){
			calResult = num1 / num2;
		 } else if(cal.equals("%")){
			calResult = num1 % num2;
		 }

		 System.out.printf("%d %s %d = %d", num1, num2, calResult);
	
		 //inputOperater.equals(" + ");

	}
          
		 



/*문제4.
요구사항] 문자 1개를 입력받아 아래와 같이 출력하시오
입력] 문자 : f
출력] Father
조건] f, F -> Father
      m, M -> Mother
	  s, S -> Sister
	  b, B -> Brother
사용] if, switch
*/
	
	public static void family() throws Exception{

		 BufferedReader reader = new BufferedReader(new
         InputStreamReader(System.in));
         
		 System.out.print("문자 : ");
	     char alphabet = reader.readLine().charAt(0);
		 String resultChar = " ";

		 //유효성 검사
         if ((alphabet >= 'a' && alphabet <= 'z') || (alphabet >= 'A' && alphabet <= 'Z')){
         
		 //비즈니스 코드, 업무 코드
			if (alphabet == 'f' || alphabet == 'F') {
			resultChar = "Father";

			} else if (alphabet == 'm' || alphabet == 'M'){
			resultChar = "Mother";

			} else if (alphabet == 's' || alphabet == 'S'){
			resultChar = "Sister";

			} else if (alphabet == 'b' || alphabet == 'B'){
			resultChar = "Brother";
			} 
			
			System.out.println(resultChar);
			
			
		    }else {
			System.out.println("알파벳만 입력하세요.");
		    }
			
			
            
			//예외 처리 코드
		  


	}



/*문제5.
요구사항] 영문자 1개를 입력받아 대/소문자를 변환/출력하시오.
입력] 문자 : a
출력] 결과 : A
입력] 문자 : F
출력] 결과 : f
*/



/*
문제6.
요구사항] 주차 요금을 계산하시오
입력] <들어온 시간>
	시 ; 13
	분 : 30
	  <나간 시간>
	시 : 14
	분 : 20
출력] 주차 요금은 4,000원입니다.
조건] 무료 주차 : 30분
      초과 10분 : 2,000원
*/



/*
문제7.
요구사항]년도를 입력받아 "평년"인지 "윤년"인지 출력하시오
입력] 입력 : 2017
출력] 2017년은 "평년"입니다.
*/

//=======================================================================================	

/*for 문

문제1.
요구사항] 이름과 횟수를 입력받아서 횟수만큼 인사하시오.
입력] 이름 : 홍길동
      횟수 : 3
출력] 홍길동님 안녕하세요~
	  홍길동님 안녕하세요~
	  홍길동님 안녕하세요~
*/

	public static void hello() throws Exception{
	
	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		System.out.println("=========문제1========");

        System.out.print("이름 : ");
		String name = reader.readLine();

		System.out.print("횟수 : ");
		int number  = Integer.parseInt(reader.readLine());
        
        for(int i=0; i<number; i++){
			System.out.printf("%s님 안녕하세요~.\n", name);
		}

	
	}//hello() //문제1 






/*
문제2. 
요구사항] 숫자 1개를 입력받아 1부터 ~ 입력한 숫자까지의 합을 출력하시오.
입력] 숫자 : 5
출력] 1 ~ 5 : 15
조건] 천단위 출력.찍기
*/

	public static void calFromOne() throws Exception{
	
	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

	    System.out.println("=========문제2========");
        
		System.out.print("숫자 : ");
		int number  = Integer.parseInt(reader.readLine());
        int sum = 0; 
		
		for(int i=1; i<=number; i++){
			sum += i; 		
		}

		System.out.printf("1 ~ %d : %d\n", number, sum);

	}//calFromOne() //문제2











/*
문제3.
요구사항] 숫자 10개를 입력받아 짝수의 합과 홀수의 합을 각각 출력하세요.
입력] 숫자 : 5
      숫자 : 7
	  ..
	  숫자 : 10
출력] 짝수의 합 : 52
      홀수의 합 : 46
*/

	public static void sum() throws Exception{
	
	BufferedReader reader = new BufferedReader(new 
	InputStreamReader(System.in));

	    System.out.println("=======문제3=======");
        
		//1. 짝수, 홀수의 합 변수값 초기화
		int sum10Even = 0;  
		int sum10Odd = 0;  
        
		//2. for문 선언
		for(int i=0; i<10; i++){
         
		//3. 숫자를 10번 입력받는다.
		System.out.printf("%d.숫자 : ",i+1);
		int number 
			= Integer.parseInt(reader.readLine());
		
        //4. 짝수와 홀수로 나누어 합을 구한다.
			if(number % 2 == 0){
				sum10Even += number;
			}else{
				sum10Odd += number;
			} 
      
		}

        //5. 결과 출력 
		System.out.printf("짝수의 합 : %d\n"
		                             , sum10Even);
		System.out.printf("홀수의 합 : %d\n"
		                             , sum10Odd);


	}//sum() //문제3












/*
문제4. 루프변수활용
요구사항] 아래와 같이 출력하시오.
출력] 1 + 2 + 3 + 4 + 5 + 6 + 9 + 10 = 55
출력] 1 - 2 + 3 - 4 + 5 - 6 + 9 - 10 = -5
*/


	public static void twoTypeCal(){

	    System.out.println("=========문제4========");
		
		int sumOnlyPlus = 0;
		int sumMinusPlus = 0;
		
		String express = " ";
        String expressResult = " ";


		for(int i=1; i<=10; i++){
		
		sumOnlyPlus += i;
		express += ((i)+"+");

		if(i == 10){
			expressResult = express + i;
				break;
			}

		
		}
        
		System.out.printf("%s = %d",expressResult, sumOnlyPlus);







	}//twoTypeCal()// 문제4. 
	


/*
문제5. 
요구사항] 아래와 같이 출력하시오.
출력] 1 + 2 + 3 + 4 + 5 + .....+ ? = 10xx
조건] 누적값이 1000이 넘어가는 순간까지만 출력하시오.
사용] 무한 루프 + break
*/


	public static void CallTo1000(){

		Random rnd = new Random();

	    System.out.println("=========문제5========");
        
		int sum = 0;
		String express = " ";
        String expressResult = " ";

		for(int i=1; ;i++){
		
		sum += i; 
        express += ((i)+"+");

			if(sum > 1000){
			expressResult = express + i;
				break;
			}
		
		}

        System.out.printf("%s = %d", expressResult, sum);


	}//CallTo1000()//문제5.


/*
문제6.
요구사항] 서기 1년 1월 1일부터 2017년 12월 6일까지 총 며칠이 지났는지 구하시오.
출력] 총 4,563,543일 지났습니다. 
조건] Calendar 사용 금지
사용] for문 사용, 운년 계산/ 돌리는데 걸리는 부분이 뭔지 잘생각해보기
검증] 결과 % 7 = ? 오늘 요일 생각해보기 
*/

/*
문제7.
요구사항] 369 게임을 출력하시오.
출력] 1 2 짝 4 5 짝 7......
조건] 100까지
      33 - 짝짝
      루프를 1~100까지 돌리되 그안에서 조건이 3이나 6이나 9가 들어가는지 
*/  

//=======================================================================
/*문제8.
요구사항] 별찍기 -> (" ") (space사용한거)

	*
   **
  ***	
 ****
*****
*/

	
문제9.
요구사항] 별찍기

*********
 *******
  *****
   ***
    *

문제10.
요구사항] 별찍기
*
 *
  *
   *
    *

문제11.
요구사항] 별찍기
*
**
***
*******
	***
	 **
	  *

문제12. 난이도***
요구사항] 아래와 같이 출력하시오.

	aa
   abba
  abccba
 abcddbca
abcdeedcba


문제13.
요구사항] 구구단을 출력하시오.
힌트] 2중 for문 x 2 or 3중 for문 x 1번

2 x 1 = 2	2 x 1 = 2	2 x 1 = 2	5 x 1 = 2  
2 x 2 = 2							5 x 2 = 10
2 x 3 = 2							5 x 3 = 15
2 x 4 = 2
..
2 x 9 = 18							5 x 9 = 2

6 x 1 = 6							2 x 1 = 2
6 x 1 = 12							2 x 1 = 2
6 x 1 = 18							2 x 1 = 2

문제14-1.
요구사항] 아래와 같이 출력하시오.
사용] 2중 for문 x 1번, 1중 for문 x 1번


1 ~ 10 :  55
1 ~ 20 : XXX
1 ~ 30 : XXX
1 ~ 40 : XXX
1 ~ 50 : XXX
...
1 ~ 100 : 5050


문제14-2.

1 ~ 10 :  55
11 ~ 20 : XXX
21 ~ 30 : XXX

...
91 ~ 100 : XXX




문제15.
요구사항] 아래와 같이 출력하시오.

1 + 2 + 4 + 7 + 11 + 16 + .... + N = 469
조건] 더하는 N이 100을 넘지 않을 때까지...





문제16. 난이도 ****
요구사항] 아래와 같이 출력하시오

1 + 1 + 2 + 3 + 5 + 8 + 13 + 21 + 34 + 55 + 89 = 232

조건] 더하는 N이 100을 넘지 않을 때까지...



문제17.
요구사항] 2부터 100사이의 소수를 구하시오.
출력] 2, 3, 5, 7, 11, 13.....
힌트] 소수 : 1과 자기자신으로밖에 나눠지지 않는 수 


문제18.
요구사항] 1부터 100사이의 완전수를 구하시오.
출력] 

6 = [1, 2, 3, 6]
28 = [1,2,4,7,14,28]

힌트] 완전수 : 자기 자신을 제외한 나머지 약수들의 합이 자신과 동일한 수


































