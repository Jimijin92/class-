import java.io.*;



class Ex_If_Test1 {

	public static void main(String[] args) throws Exception {

	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	
		System.out.println("==============================================================");
		System.out.println("����1");

			System.out.printf("ù��° ���� : ");
			int num1 = Integer.parseInt(reader.readLine());
			
			System.out.printf("�ι�° ���� : ");
			int num2 = Integer.parseInt(reader.readLine());

			number(num1, num2);

		System.out.println("==============================================================");
		System.out.println("����2");

			System.out.printf("���� : ");
			int score1 = Integer.parseInt(reader.readLine());

			scoreIfMethod(score1);

		System.out.println("==============================================================");
		System.out.println("����3");
			
			calculate();


		System.out.println("==============================================================");
		System.out.println("����4");

			
			
			textPrint();

		System.out.println("==============================================================");
		System.out.println("����5");

			
			textTypeConversion();

	}//main


	public static void textTypeConversion () throws Exception {

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

			System.out.printf("���� : ");
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
		
			System.out.println("�Է��� �߸��Ǿ����ϴ�.");
		
		}
	
	
	}


	public static void textPrint () throws Exception {

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		System.out.printf("���� : ");
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
		
			System.out.printf("����� �����Ͱ� �����ϴ�.\n");

		}
	
	
	}

	

	public static void number(int num1, int num2) {
	
		if (num1 > num2) {
		
			System.out.printf("ū ���� %d�̰�, ���� ���� %d�Դϴ�.\n", num1, num2);
		
		} else {
		
			System.out.printf("ū ���� %d�̰�, ���� ���� %d�Դϴ�.\n", num2, num1);
		
		}

	
	
	}//number

	public static void scoreIfMethod (int score1) {
	
		if (score1 >=0 && score1 <= 100) { 

			if (score1 <= 100 && score1 >= 90) {
			
				System.out.printf("�Է��� ���� %d�� A�Դϴ�\n" , score1);

		
			} else if (score1 <= 89 && score1 >= 80) {
			
				System.out.printf("�Է��� ���� %d�� B�Դϴ�\n" , score1);

		
			} else if (score1 <= 79 && score1 >= 70) {
			
				System.out.printf("�Է��� ���� %d�� C�Դϴ�\n" , score1);

		
			} else if (score1 <= 69 && score1 >= 60) {
			
				System.out.printf("�Է��� ���� %d�� D�Դϴ�\n" , score1);

		
			} else  {
			
				System.out.printf("�Է��� ���� %d�� F�Դϴ�\n" , score1);
		
			}
		
		}else {
		
			System.out.println("���� �Է� ����");
		
		}
	
	}//scoreIfMethod

	public static void calculate() throws Exception {

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

			System.out.printf("����1 : ");
			int calcNum1 = Integer.parseInt(reader.readLine());

			System.out.printf("����2 : ");
			int calcNum2 = Integer.parseInt(reader.readLine());

			System.out.printf("������ : ");
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
		
			System.out.println("�Է��� �߸��Ǿ����ϴ�.");
		
		}

	
	}//calculate


	
}