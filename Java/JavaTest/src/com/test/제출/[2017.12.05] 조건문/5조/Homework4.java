import java.io.*;
import java.util.*;

class Homework4 {
	public static void main(String[] args) throws Exception{
		

		//Homework4.java

		//comparison(); //1
		//grade(); //2
		//switchGrade(); //2
		//arithmetic(); //3
		//word(); //4
		//switchWord(); //4
		//alphabet(); //5
		//charge(); //6
		years(); //7


	}//main()
	
	public static void comparison() throws Exception{
		/*
		문제1.
		요구사항] 숫자를 2개 입력받아 큰수와 작은수를 출력하시오.
		입력] 첫번째 숫자 : 5
			  두번째 숫자 : 3
		출력] 큰수는 5이고, 작은수는 3입니다.
		*/
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		System.out.print("첫번째 숫자 : ");
		int num1 = Integer.parseInt(reader.readLine());

		System.out.print("두번째 숫자 : ");
		int num2 = Integer.parseInt(reader.readLine());

		int big = 0;
		int small = 0;

		if(num1 > num2){
			big = num1;
			small = num2;
		}else if(num2 > num1){
			big = num2;
			small = num1;
		}else{
			System.out.println("두개의 숫자는 같은 수 입니다.\n");
		}
		System.out.printf("큰수는 '%d'이고, 작은수는 '%s'입니다.\n",big, small);
	}//comparison()

	
	public static void grade() throws Exception{
	/*
	
		문제2.
		요구사항] 점수를 입력받아 성적을 출력하시오.
		입력] 점수 : 85
		출력] 입력한 점수 85점은 B입니다.
		조건] 90 ~ 100 : A
			  80 ~ 89  : B
			  70 ~ 79  : C
			  60 ~ 69  : D
			   0 ~ 59  : F
		추가] 유효성 검사 (점수 0~100이내)

	*/
	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	System.out.print("점수 : ");
	int gradeNum = Integer.parseInt(reader.readLine());

	String grade = "";
	
	if(gradeNum>=0 && gradeNum<=100){
		if(gradeNum>=90){
			grade = "A";
		}else if(gradeNum<90 && gradeNum>=80){
			grade = "B";
		}else if(gradeNum<80 && gradeNum>=70){
			grade = "C";
		}else if(gradeNum<70 && gradeNum>=60){
			grade = "D";
		}else if(gradeNum<60){
			grade = "F";
		}
	}else{
		System.out.println("점수가 아닙니다");
	}
	System.out.printf("입력한 점수 %d점은 %s입니다.\n",gradeNum,grade);

	}//grade()

	public static void switchGrade() throws Exception{

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("점수 : ");
		int gradeNum = Integer.parseInt(reader.readLine());
		int gradeNum2 = (int)(gradeNum/10);
		String grade = "";
		switch(gradeNum2){
			case 10:
			case 9:
				grade = "A";
				break;
			case 8:
				grade = "B";
				break;
			case 7:
				grade = "C";
				break;
			case 6:
				grade = "D";
				break;
			case 5:
			case 4:
			case 3:
			case 2:
			case 1:
			case 0:
				grade = "F";
				break;
			default:
				System.out.println("점수가 아닙니다.");
				break;
		}

		System.out.printf("입력한 점수 %d점은 %s입니다.\n",gradeNum,grade);

	}//switchGrade()


	public static void arithmetic() throws Exception{
	/*
		문제3.
		요구사항] 숫자 2개와 연산자 1개를 입력받아 연산과정과 결과를 출력하시오.
		입력] 숫자 : 5
			  숫자 : 3
			  연산자 : *
		출력] 5 * 3 = 15
		조건] 입력(정수)
			  출력(소수이하 1자리까지)
			  연산자(산술 연산)
	*/
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		System.out.print("첫번째 숫자 : ");
		int num1 = Integer.parseInt(reader.readLine());

		System.out.print("두번째 숫자 : ");
		int num2 = Integer.parseInt(reader.readLine());

		System.out.print("연산자 : ");
		String arithmetic = reader.readLine();
		
		if(arithmetic.equals("+")){

			System.out.printf("%d %s %d = %d\n",num1, arithmetic, num2, num1 + num2);

		}
		else if(arithmetic.equals("-")){

			System.out.printf("%d %s %d = %d\n",num1, arithmetic, num2, num1 - num2);

		}
		else if(arithmetic.equals("*")){

			System.out.printf("%d %s %d = %d\n",num1, arithmetic, num2, num1 * num2);

		}
		else if(arithmetic.equals("/")){

			System.out.printf("%d %s %d = %.1f\n",num1, arithmetic, num2, (double)num1 / num2);

		}
		else if(arithmetic.equals("%")){

			System.out.printf("%d %s %d = %d\n",num1, arithmetic, num2, num1 % num2);

		}
		
	}//arithmetic()

	public static void word() throws Exception{

	/*
		문제4.
		요구사항] 문자 1개를 입력받아 아래와 같이 출력하시오.
		입력] 문자 : f
		출력] Father
		조건] f,F -> Fater
			  m,M -> Mother
			  s,S -> Sister
			  b,B -> Brother
		
	*/
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		System.out.print("문자 : ");
		String alphabet = reader.readLine();
		
		if(alphabet.equals("f") || alphabet.equals("F")){

			System.out.println("Father");
		
		}
		else if(alphabet.equals("m") || alphabet.equals("M")){

			System.out.println("Mother");
		
		}
		else if(alphabet.equals("s") || alphabet.equals("S")){

			System.out.println("Sister");
		
		}
		else if(alphabet.equals("b") || alphabet.equals("B")){

			System.out.println("Borther");
		
		}else{
			System.out.println("잘못입력하셨습니다.");
		}

	}//word()

	public static void switchWord() throws Exception{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("문자 : ");
		String alphabet = reader.readLine();

		switch(alphabet){
			case "f":
			case "F":
				System.out.println("Father");
				break;
			case "m":
			case "M":
				System.out.println("Mother");
				break;
			case "s":
			case "S":
				System.out.println("Sister");
				break;
			case "b":
			case "B":
				System.out.println("Borther");
				break;
			default:
				System.out.println("잘못 입력하셨습니다.");
				break;

		}	
	}//switchWord()

	public static void alphabet() throws Exception{
	/*
		문제5.
		요구사항] 영문자 1개를 입력받아 대/소문자를 변환/출력하시오.
		입력] 문자 : a
		출력] 결과 : A
		입력] 문자 : F
		출력] 결과 : f
			
	*/
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("영문자 : ");
		String input = reader.readLine();
		char alphabet = input.charAt(0);
		int alphabetCode = (int)alphabet;

		if(alphabetCode>='a' && alphabetCode<='z'){
			char bAlphabet = (char)(alphabetCode - 32);
			System.out.printf("결과 : %s\n",bAlphabet);
		}else if(alphabetCode>='A' && alphabetCode<='Z'){
			char bAlphabet = (char)(alphabetCode + 32);
			System.out.printf("결과 : %s\n",bAlphabet);
		}else{
			System.out.println("알파벳이 아닙니다.");
		}

	} 
/*
	public static void throws charge() Exception{
	
		
		문제6.
		요구사항] 주차 요금을 계산하시오.
		입력] <들어온 시간>
			   시 : 13
			   분 : 30
			  <나간 시간>
			   시 : 14
			   분 : 20
		출력] 주차 요금은 4,000원입니다.
		조건] 무료 주차 : 30분
			  초과 10분 : 2,000원
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("<들어온 시간>");

		System.out.print("시 : ");
		int inHour =  Integer.parseInt(reader.readLine());

		System.out.print("분 : ");
		int inMinute =  Integer.parseInt(reader.readLine());

		System.out.println("<나간 시간>");

		System.out.print("시 : ");
		int outHour =  Integer.parseInt(reader.readLine());

		System.out.print("분 : ");
		int outMinute =  Integer.parseInt(reader.readLine());

		Calendar outTime = Calendar.getInstance();
		
		outTime.set(Calendar.HOUR_OF_DAY,outHour);
		outTime.set(Calendar.MINUTE, outMinute);

		Calendar parkingTime = Calendar.getInstance();
		parkingTime.add(Calendar.HOUR_OF_DAY, outHour - inHour);
		parkingTime.add(Calendar.MINUTE, outMinute - inMinute);
		
		int hour = parkingTime.get(Calendar.HOUR_OF_DAY);
		int minute = parkingTime.get(Calendar.MINUTE);
		
		minute = minute + hour*60;

		if(minute<=30){
			System.out.println("주차 요금은 0원 입니다.");
		}else if(minute>30){
			minute = (minute -30)/10;
			
			
		}

	}
		*/
	public static void years() throws Exception{

	/*
		문제7.
		요구사항] 년도를 입력받아 "평년" 인지 "윤년"인지 출력하시오.
		입력] 입력 : 2017
		출력] 2017년은 '평년'입니다.
		조건] a. 년도를 4로 나눠서 떨어지면 -> b.
								   떨어지지 않으면 "평년"
			  b. 년도를 100으로 나눠서 떨어지면 -> c.
								   떨어지지 않으면 "윤년"
			  c. 년도를 400으로 나눠서 떨어지면 "윤년"
								   떨어지지 않으면 "평년"
	*/
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("년도 : ");
		int year = Integer.parseInt(reader.readLine());
		
		if((year%4 != 0)){
			System.out.println("평년");
		}else if(!(year%100 == 0)){
			System.out.println("윤년"); 
		}else if(year%400 == 0){
			System.out.println("윤년");
		}else{
			System.out.println("평년");
		}
		
	}//years()
}
