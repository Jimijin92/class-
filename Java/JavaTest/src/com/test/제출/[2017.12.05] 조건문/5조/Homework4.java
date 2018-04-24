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
		����1.
		�䱸����] ���ڸ� 2�� �Է¹޾� ū���� �������� ����Ͻÿ�.
		�Է�] ù��° ���� : 5
			  �ι�° ���� : 3
		���] ū���� 5�̰�, �������� 3�Դϴ�.
		*/
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		System.out.print("ù��° ���� : ");
		int num1 = Integer.parseInt(reader.readLine());

		System.out.print("�ι�° ���� : ");
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
			System.out.println("�ΰ��� ���ڴ� ���� �� �Դϴ�.\n");
		}
		System.out.printf("ū���� '%d'�̰�, �������� '%s'�Դϴ�.\n",big, small);
	}//comparison()

	
	public static void grade() throws Exception{
	/*
	
		����2.
		�䱸����] ������ �Է¹޾� ������ ����Ͻÿ�.
		�Է�] ���� : 85
		���] �Է��� ���� 85���� B�Դϴ�.
		����] 90 ~ 100 : A
			  80 ~ 89  : B
			  70 ~ 79  : C
			  60 ~ 69  : D
			   0 ~ 59  : F
		�߰�] ��ȿ�� �˻� (���� 0~100�̳�)

	*/
	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	System.out.print("���� : ");
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
		System.out.println("������ �ƴմϴ�");
	}
	System.out.printf("�Է��� ���� %d���� %s�Դϴ�.\n",gradeNum,grade);

	}//grade()

	public static void switchGrade() throws Exception{

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("���� : ");
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
				System.out.println("������ �ƴմϴ�.");
				break;
		}

		System.out.printf("�Է��� ���� %d���� %s�Դϴ�.\n",gradeNum,grade);

	}//switchGrade()


	public static void arithmetic() throws Exception{
	/*
		����3.
		�䱸����] ���� 2���� ������ 1���� �Է¹޾� ��������� ����� ����Ͻÿ�.
		�Է�] ���� : 5
			  ���� : 3
			  ������ : *
		���] 5 * 3 = 15
		����] �Է�(����)
			  ���(�Ҽ����� 1�ڸ�����)
			  ������(��� ����)
	*/
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		System.out.print("ù��° ���� : ");
		int num1 = Integer.parseInt(reader.readLine());

		System.out.print("�ι�° ���� : ");
		int num2 = Integer.parseInt(reader.readLine());

		System.out.print("������ : ");
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
		����4.
		�䱸����] ���� 1���� �Է¹޾� �Ʒ��� ���� ����Ͻÿ�.
		�Է�] ���� : f
		���] Father
		����] f,F -> Fater
			  m,M -> Mother
			  s,S -> Sister
			  b,B -> Brother
		
	*/
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		System.out.print("���� : ");
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
			System.out.println("�߸��Է��ϼ̽��ϴ�.");
		}

	}//word()

	public static void switchWord() throws Exception{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("���� : ");
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
				System.out.println("�߸� �Է��ϼ̽��ϴ�.");
				break;

		}	
	}//switchWord()

	public static void alphabet() throws Exception{
	/*
		����5.
		�䱸����] ������ 1���� �Է¹޾� ��/�ҹ��ڸ� ��ȯ/����Ͻÿ�.
		�Է�] ���� : a
		���] ��� : A
		�Է�] ���� : F
		���] ��� : f
			
	*/
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("������ : ");
		String input = reader.readLine();
		char alphabet = input.charAt(0);
		int alphabetCode = (int)alphabet;

		if(alphabetCode>='a' && alphabetCode<='z'){
			char bAlphabet = (char)(alphabetCode - 32);
			System.out.printf("��� : %s\n",bAlphabet);
		}else if(alphabetCode>='A' && alphabetCode<='Z'){
			char bAlphabet = (char)(alphabetCode + 32);
			System.out.printf("��� : %s\n",bAlphabet);
		}else{
			System.out.println("���ĺ��� �ƴմϴ�.");
		}

	} 
/*
	public static void throws charge() Exception{
	
		
		����6.
		�䱸����] ���� ����� ����Ͻÿ�.
		�Է�] <���� �ð�>
			   �� : 13
			   �� : 30
			  <���� �ð�>
			   �� : 14
			   �� : 20
		���] ���� ����� 4,000���Դϴ�.
		����] ���� ���� : 30��
			  �ʰ� 10�� : 2,000��
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("<���� �ð�>");

		System.out.print("�� : ");
		int inHour =  Integer.parseInt(reader.readLine());

		System.out.print("�� : ");
		int inMinute =  Integer.parseInt(reader.readLine());

		System.out.println("<���� �ð�>");

		System.out.print("�� : ");
		int outHour =  Integer.parseInt(reader.readLine());

		System.out.print("�� : ");
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
			System.out.println("���� ����� 0�� �Դϴ�.");
		}else if(minute>30){
			minute = (minute -30)/10;
			
			
		}

	}
		*/
	public static void years() throws Exception{

	/*
		����7.
		�䱸����] �⵵�� �Է¹޾� "���" ���� "����"���� ����Ͻÿ�.
		�Է�] �Է� : 2017
		���] 2017���� '���'�Դϴ�.
		����] a. �⵵�� 4�� ������ �������� -> b.
								   �������� ������ "���"
			  b. �⵵�� 100���� ������ �������� -> c.
								   �������� ������ "����"
			  c. �⵵�� 400���� ������ �������� "����"
								   �������� ������ "���"
	*/
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("�⵵ : ");
		int year = Integer.parseInt(reader.readLine());
		
		if((year%4 != 0)){
			System.out.println("���");
		}else if(!(year%100 == 0)){
			System.out.println("����"); 
		}else if(year%400 == 0){
			System.out.println("����");
		}else{
			System.out.println("���");
		}
		
	}//years()
}
