import java.io.*;



class Ex_If_Test1 {

	public static void main(String[] args) throws Exception {

	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	
		System.out.println("==============================================================");
		System.out.println("문제1");

			System.out.printf("첫번째 숫자 : ");
			int num1 = Integer.parseInt(reader.readLine());
			
			System.out.printf("두번째 숫자 : ");
			int num2 = Integer.parseInt(reader.readLine());

			number(num1, num2);

		System.out.println("==============================================================");
		System.out.println("문제2");

			System.out.printf("점수 : ");
			int score1 = Integer.parseInt(reader.readLine());

			scoreIfMethod(score1);

		System.out.println("==============================================================");
		System.out.println("문제3");
			
			calculate();


		System.out.println("==============================================================");
		System.out.println("문제4");

			
			
			textPrint();

		System.out.println("==============================================================");
		System.out.println("문제5");

			
			textTypeConversion();

	}//main


	public static void textTypeConversion () throws Exception {

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

			System.out.printf("문자 : ");
			//int textType = (int)(reader.read());
			
			String textType = reader.readLine();
	//System.out.println(str);
			int textNum = (int)textType.charAt(0);
			System.out.println(textNum);
	
		if (((textNum >= 65) && (textNum <=90)) || ((textNum >= 97) && (textNum <=122))) {
		
			if ((textNum >= 65) || (textNum <=90)) {
			
				char textTypeCon = (char)(textNum + 32);
				System.out.println(textTypeCon);
			
			} else {
			
				char textTypeCon = (char)(textNum - 32);
				System.out.println(textTypeCon);
			
			}
		
		} else {
		
			System.out.println("입력이 잘못되었습니다.");
		
		}
	
	
	}


	public static void textPrint () throws Exception {

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		System.out.printf("문자 : ");
			//int textNum = Integer.parseInt(reader.readLine());
			//char text = (char)(textNum);
			int textNum = System.in.read();
			
			//System.out.println((int)textNum.charAt(0));
		char text = (char)textNum;
	
		if ((text == 'f') || (text == 'F')) {
		
			System.out.printf("Father\n");
		
		} else if ((text == 'm') || (text == 'M')) {
		
			System.out.printf("Mather\n");
		
		} else if ((text == 's') || (text == 'S')) {
		
			System.out.printf("Sister\n");
		
		} else if ((text == 'b') || (text == 'B')) {
		
			System.out.printf("Brother\n");
		
		} else {
		
			System.out.printf("저장된 데이터가 없습니다.\n");

		}
	
	
	}

	

	public static void number(int num1, int num2) {
	
		if (num1 > num2) {
		
			System.out.printf("큰 수는 %d이고, 작은 수는 %d입니다.\n", num1, num2);
		
		} else {
		
			System.out.printf("큰 수는 %d이고, 작은 수는 %d입니다.\n", num2, num1);
		
		}

	
	
	}//number

	public static void scoreIfMethod (int score1) {
	
		if (score1 >=0 && score1 <= 100) { 

			if (score1 <= 100 && score1 >= 90) {
			
				System.out.printf("입력한 점수 %d는 A입니다\n" , score1);

		
			} else if (score1 <= 89 && score1 >= 80) {
			
				System.out.printf("입력한 점수 %d는 B입니다\n" , score1);

		
			} else if (score1 <= 79 && score1 >= 70) {
			
				System.out.printf("입력한 점수 %d는 C입니다\n" , score1);

		
			} else if (score1 <= 69 && score1 >= 60) {
			
				System.out.printf("입력한 점수 %d는 D입니다\n" , score1);

		
			} else  {
			
				System.out.printf("입력한 점수 %d는 F입니다\n" , score1);
		
			}
		
		}else {
		
			System.out.println("점수 입력 오류");
		
		}
	
	}//scoreIfMethod

	public static void calculate() throws Exception {

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

			System.out.printf("숫자1 : ");
			int calcNum1 = Integer.parseInt(reader.readLine());

			System.out.printf("숫자2 : ");
			int calcNum2 = Integer.parseInt(reader.readLine());

			System.out.printf("연산자 : ");
			int operatorNum = (int)(reader.read());
			char operator = (char)(operatorNum);
	
	
		if (operator == '+') {
		
			System.out.printf("%d + %d = %d \n", calcNum1, calcNum2, calcNum1 + calcNum2 );
		
		} else if (operator == '-') {
		
			System.out.printf("%d - %d = %d \n", calcNum1, calcNum2, calcNum1 - calcNum2 );
		
		} else if (operator == '*') {
		
			System.out.printf("%d * %d = %d \n", calcNum1, calcNum2, calcNum1 * calcNum2 );
		
		} else if (operator == '/') {
		
			System.out.printf("%d / %d = %.1f \n", calcNum1, calcNum2, (float)calcNum1 / calcNum2 );
		
		} else {
		
			System.out.println("입력이 잘못되었습니다.");
		
		}

	
	}//calculate


	
}