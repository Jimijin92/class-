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

����1.
�䱸����] ���ڸ� 2�� �Է¹޾� ū���� �������� ����Ͻÿ�.
�Է�] ù��° ���� : 5
	  �ι�° ���� : 3
���] ū���� 5�̰�, �������� 3�Դϴ�.

*/

	public static void big() throws Exception{

		BufferedReader reader = new BufferedReader (new InputStreamReader(System.in));
		
		System.out.println("ù��° ����:");
		int firstNumber = Integer.parseIt(reader.readLine());

		System.out.println("�ι��� ����:");
		int secondNumber = Integer.parseInt(reader.readLine());


		if(firstNumber != secondNumber){
			
			if( firstNumber > secondNumber){
		
			System.out.printf("ū���� %d�̰�, �������� %d�Դϴ�.\n"
											,firstNumber,secondNumber);
		
			} else{
		
			System.out.printf("ū���� %d�̰�, �������� %d�Դϴ�.\n"
											,secondNumber,firstNumber);
			}
		
		}else{
		
		
			System.out.printf(" %d�� %d��(��) �����ϴ�."
											,firstNumber,secondNumber);
		
		}

		

	
	
	} //���� 1//

/*
����2.
�䱸����] ������ �Է¹޾� ������ ����Ͻÿ�.
�Է�] ���� : 85
���] �Է��� ���� 85���� B�Դϴ�.
����] 90~100 : A
	  80~ 90 : B
	  70 ~79 : C
	  60 ~69 : D
	  0 ~ 59 : F
�߰�] ��ȿ�� �˻�(���� 0~100�̳�) 
���] if, switch(���� - ���� �˻�x)

*/

	public static void grade() throws Exception{
	
		BufferedReader reader = new BufferedReader (new InputStreamReader(System.in));

		System.out.println("���� :");
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
		
			System.out.println("��ȿ�� ���ڸ� �Է��ϼ���.");
		
		}

			System.out.printf("�Է��� ���� %d�� %s�Դϴ�.\n", score,grade);
	
	
	
	
	} //����2  if ��� //////





/*����3.
�䱸����] ���� 2���� ������ 1���� �Է¹޾� ��������� ����� ����Ͻÿ�.
�Է�] ����1 :5
	  ����2 :3
	  ������ : *
���] 5 * 3 = 15

����] �Է�(����)
	  ���(�Ҽ����� 1�ڸ�����)
	  ������(��� ���길.. + ,- , *, /)
���]if


*/




	public static void calculate() throws Exception{

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		System.out.println("����1 : ");
		int number1 = Integer.parseInt(reader.readLine());

		System.out.println("����2 : ");
		int number2 = Integer.parseInt(reader.readLine());

		System.out.println("������ : ");
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

		


		

	
	

	} //���� 3//////////////


/*

����4.
�䱸����] ���� 1���� �Է¹޾� �Ʒ��� ���� ����Ͻÿ�.
�Է�] ����: f
���] Father
����] f,F -> Father
	  m,M -> Mother
	  s,S -> Sister
	  b,B -> Brother

���]if, switch


*/
	public static void character() throws Exception{

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		System.out.println("���� : ");

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
		
				System.out.println("���� 'f','F','m','M','s','S','b','B'�� �ϳ��� �Է��ϼ���.");
		
		}
		
		
		
		
		
		
		
		
		
	
	
	
	
	} //���� 4//

/*
����5.
�䱸����] ������ 1���� �Է¹޾� ��/�ҹ��ڸ� ��ȯ/����Ͻÿ�.
�Է�] ���� : a
���] ��� : A
�Է�] ���� : F
���] ��� : f


*/


	public static void change() throws Exception{
	
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("���� : ");
		int n = System.in.read();

		if(n >= 65 && n <= 90){
			System.out.printf("��� : %c\n", (char)(n + 32));
		
		}else if( n >= 97 && n <= 122) {
		
			System.out.printf("��� : %c\n", (char)(n - 32));
		
		}

		


		
		
		//System.out.println(n);  ��ҹ��� ���� 32   a 97 z 122  ,  A 65 Z 90

	
	
	
	
	} //5���� //

/*
����6.
�䱸����] ���� ����� ����Ͻÿ�.
�Է�] < ���� �ð�>
	  �� : 13
	  �� : 30
	  <���� �ð�>
	  �� : 14
	  �� : 20
���] ���� ����� 4,000���Դϴ�.
����] ���� ���� : 30��
	  �ʰ� 10�� : 2,000��

*/

	public static void parking() throws Exception{

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		
		System.out.println("<���� �ð�>");

		System.out.println("�� :");
		int inTime = Integer.parseInt(reader.readLine());

		System.out.println("�� :");
		int inMinute = Integer.parseInt(reader.readLine());

		System.out.println("<���� �ð�");

		System.out.println("�� :");
		int outTime = Integer.parseInt(reader.readLine());

		System.out.println("�� :");
		int outMinute = Integer.parseInt(reader.readLine());

		
		int in = 60 * inTime + inMinute;

		int out = 60 * outTime + outMinute;

		int parkingFee = (out - in -30)/10 *2000;

		System.out.printf("���� ����� %,d���Դϴ�\n",parkingFee);



	
	
	
	
	} //���� 6// ���� ����� 


/*
����7.
�䱸����]�⵵�� �Է¹޾� "���" ���� "����"���� ����Ͻÿ�.
�Է�] �Է� : 2017
���] 2017���� '���'�Դϴ�.

2���� 29�ϱ��� �ִ� �ظ� �����̶�� �θ� 
������ ���¿��� ���� ���� �ι� ����

4�⿡ �ѹ� ������ �ְ� 100�⿡ �ѹ����� 400�⿡ �ѹ� +1

����] a. �⵵�� �⵵�� 4�� ������ �������� b �˻�
								  �������� ������ "���"
	
	 b.�⵵�� 100���� ������ �������� c �˻�
							 �������� ������ "����"
	c. �⵵�� 400���� ������ �������� "����"
							  �������� ������ "���"

����] Calendar ������
*/



	public static void calendar7() throws Exception{

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


		System.out.println("�Է� : ");
		int year = Integer.parseInt(reader.readLine());

		String result = "";


		if( year % 4 == 0){
			
			if( year % 100 == 0){
				if( year % 400 ==0){
					result = "����";
				}else{
					result ="���";
				}
			
			
			}else{
			
				result = "����";
			}
		
		
		} else{
		
				result = "���";
		
		}


		System.out.printf(" %d���� '%s' �Դϴ�. \n",year ,result);




		
		

	} //����7//







} //class
