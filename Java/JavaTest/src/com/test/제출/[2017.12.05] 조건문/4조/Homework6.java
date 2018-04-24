import java.io.*;


class Homework6 {
	public static void main(String[] args) throws Exception {
		
	
	big();
	//grade();
	//calculate();
	//character();
	//change();
	//parking();
	//calendar7();


	} //main


/*

문제1.
요구사항] 숫자를 2개 입력받아 큰수와 작은수를 출력하시오.
입력] 첫번째 숫자 : 5
	  두번째 숫자 : 3
출력] 큰수는 5이고, 작은수는 3입니다.

*/

	public static void big() throws Exception{

		BufferedReader reader = new BufferedReader (new InputStreamReader(System.in));
		
		System.out.println("첫번째 숫자:");
		int firstNumber = Integer.parseIt(reader.readLine());

		System.out.println("두번재 숫자:");
		int secondNumber = Integer.parseInt(reader.readLine());


		if(firstNumber != secondNumber){
			
			if( firstNumber > secondNumber){
		
			System.out.printf("큰수는 %d이고, 작은수는 %d입니다.\n"
											,firstNumber,secondNumber);
		
			} else{
		
			System.out.printf("큰수는 %d이고, 작은수는 %d입니다.\n"
											,secondNumber,firstNumber);
			}
		
		}else{
		
		
			System.out.printf(" %d와 %d은(는) 같습니다."
											,firstNumber,secondNumber);
		
		}

		

	
	
	} //문제 1//

/*
문제2.
요구사항] 점수를 입력받아 성적을 출력하시오.
입력] 점수 : 85
출력] 입력한 점수 85점은 B입니다.
조건] 90~100 : A
	  80~ 90 : B
	  70 ~79 : C
	  60 ~69 : D
	  0 ~ 59 : F
추가] 유효성 검사(점수 0~100이내) 
사용] if, switch(생각 - 범위 검사x)

*/

	public static void grade() throws Exception{
	
		BufferedReader reader = new BufferedReader (new InputStreamReader(System.in));

		System.out.println("점수 :");
		int score = Integer.parseInt(reader.readLine());
		String grade = "";

		if( score >= 0 && score <= 100){
			if(score >=90 && score <= 100){
				grade = "A";	
			}else if(score >=80 && score < 90){
				grade = "B";
			
			}else if(score >=70 && score < 80){
				grade = "C";
			}else if(score >=60 && score < 70){
				grade = "D";
			
			}else{
				grade = "F";
			}
		
		
		}else{
		
			System.out.println("유효한 숫자를 입력하세요.");
		
		}

			System.out.printf("입력한 점수 %d는 %s입니다.\n", score,grade);
	
	
	
	
	} //문제2  if 사용 //////





/*문제3.
요구사항] 숫자 2개와 연산자 1개를 입력받아 연산과정과 결과를 출력하시오.
입력] 숫자1 :5
	  숫자2 :3
	  연산자 : *
출력] 5 * 3 = 15

조건] 입력(정수)
	  출력(소수이하 1자리까지)
	  연산자(산술 연산만.. + ,- , *, /)
사용]if


*/




	public static void calculate() throws Exception{

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		System.out.println("숫자1 : ");
		int number1 = Integer.parseInt(reader.readLine());

		System.out.println("숫자2 : ");
		int number2 = Integer.parseInt(reader.readLine());

		System.out.println("연산자 : ");
		String operator = reader.readLine();

		char c = operator.charAt(0);


		if(c == '+') {
			System.out.printf("%d + %d = %d\n",number1,number2,number1 + number2);

		}else if(c == '-'){
			System.out.printf("%d - %d = %d\n",number1,number2,number1 - number2);
		
		}else if(c == '*'){
			System.out.printf("%d * %d = %.1f\n",number1,number2,(double)(number1 * number2));
			
		}else if(c == '/'){
			System.out.printf("%d / %d = %.1f\n",number1,number2, (double)(number1 / number2));
		
		}

		


		

	
	

	} //문제 3//////////////


/*

문제4.
요구사항] 문자 1개를 입력받아 아래와 같이 출력하시오.
입력] 문자: f
출력] Father
조건] f,F -> Father
	  m,M -> Mother
	  s,S -> Sister
	  b,B -> Brother

사용]if, switch


*/
	public static void character() throws Exception{

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		System.out.println("문자 : ");

		String input = reader.readLine();

		char alpha = input.charAt(0);

		
		if(alpha =='f' ||  alpha =='F' ||  alpha =='m' ||  alpha =='M' ||  alpha =='s' ||  alpha =='S' || alpha =='b' ||  alpha =='B'){
			
			if(alpha =='f' ||  alpha =='F' ) {
				System.out.println("Father");
		
			}else if(alpha =='m' ||  alpha =='M'){
				System.out.println("Mother");
		
			}else if( alpha =='s' ||  alpha =='S'){
				System.out.println("Sister");
		
			}else{
				System.out.println("Brother");
		
			}
		
		}else{
		
				System.out.println("문자 'f','F','m','M','s','S','b','B'중 하나를 입력하세요.");
		
		}
		
		
		
		
		
		
		
		
		
	
	
	
	
	} //문제 4//

/*
문제5.
요구사항] 영문자 1개를 입력받아 대/소문자를 변환/출력하시오.
입력] 문자 : a
출력] 결과 : A
입력] 문자 : F
출력] 결과 : f


*/


	public static void change() throws Exception{
	
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("문자 : ");
		int n = System.in.read();

		if(n >= 65 && n <= 90){
			System.out.printf("결과 : %c\n", (char)(n + 32));
		
		}else if( n >= 97 && n <= 122) {
		
			System.out.printf("결과 : %c\n", (char)(n - 32));
		
		}

		


		
		
		//System.out.println(n);  대소문자 차이 32   a 97 z 122  ,  A 65 Z 90

	
	
	
	
	} //5문제 //

/*
문제6.
요구사항] 주차 요금을 계산하시오.
입력] < 들어온 시간>
	  시 : 13
	  분 : 30
	  <나간 시간>
	  시 : 14
	  분 : 20
출력] 주차 요금은 4,000원입니다.
조건] 무료 주차 : 30분
	  초과 10분 : 2,000원

*/

	public static void parking() throws Exception{

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		
		System.out.println("<들어온 시간>");

		System.out.println("시 :");
		int inTime = Integer.parseInt(reader.readLine());

		System.out.println("분 :");
		int inMinute = Integer.parseInt(reader.readLine());

		System.out.println("<나간 시간");

		System.out.println("시 :");
		int outTime = Integer.parseInt(reader.readLine());

		System.out.println("분 :");
		int outMinute = Integer.parseInt(reader.readLine());

		
		int in = 60 * inTime + inMinute;

		int out = 60 * outTime + outMinute;

		int parkingFee = (out - in -30)/10 *2000;

		System.out.printf("주차 요금은 %,d원입니다\n",parkingFee);



	
	
	
	
	} //문제 6// 가장 어려움 


/*
문제7.
요구사항]년도를 입력받아 "평년" 인지 "윤년"인지 출력하시오.
입력] 입력 : 2017
출력] 2017년은 '평년'입니다.

2월이 29일까지 있는 해를 윤년이라고 부름 
윤달은 음력에서 같은 달을 두번 넣음

4년에 한번 윤년을 넣고 100년에 한번빼고 400년에 한번 +1

조건] a. 년도를 년도를 4로 나눠서 떨어지면 b 검사
								  떨어지지 않으면 "평년"
	
	 b.년도를 100으로 나눠서 떨어지면 c 검사
							 떨어지지 않으면 "윤년"
	c. 년도를 400으로 나눠서 떨어지면 "윤년"
							  떨어지지 않으면 "평년"

조건] Calendar 사용금지
*/



	public static void calendar7() throws Exception{

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


		System.out.println("입력 : ");
		int year = Integer.parseInt(reader.readLine());

		String result = "";


		if( year % 4 == 0){
			
			if( year % 100 == 0){
				if( year % 400 ==0){
					result = "윤년";
				}else{
					result ="평년";
				}
			
			
			}else{
			
				result = "윤년";
			}
		
		
		} else{
		
				result = "평년";
		
		}


		System.out.printf(" %d년은 '%s' 입니다. \n",year ,result);




		
		

	} //문제7//







} //class
