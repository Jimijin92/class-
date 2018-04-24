import java.util.Calendar;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

class group2test {
	
	public static void main(String[] args) throws Exception{

    

	//hello();//문제1.
    //calFromOne();//문제2.
    sum();//문제3.
    //twoTypeCal();//문제4.
	//CallTo1000();//문제5.



	}//main

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



}
