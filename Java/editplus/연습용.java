import java.io.BufferedReader;
import java.io.InputStreamReader;

class ������ {
	
	public static void main(String[] args) throws Exception{

BufferedReader reader = new BufferedReader(new
		InputStreamReader(System.in));

/*
����1.
�䱸����] ���̸� �Է¹޾� �¾ �⵵�� ����Ͻÿ�.
�Է�]���� : 27
���] �¾ �⵵ : 1990��
����] ���� �⵵ = 2017��
*/
		
		System.out.println("==========����1==========");
		System.out.print("���� : ");
		String age = reader.readLine();
		int intage = Integer.parseInt(age);

		System.out.printf("�¾ �⵵ : %d\n", 2017 - intage);
		



/*
���� 2. -> �Ϸ�
�䱸����] ���� 2���� �Է¹޾Ƽ� ��������� ����� ����Ͻÿ�
�Է�] ù��° ���� :5
      �ι�° ���� :3
���] 5 + 3 = 8
      5 - 3 =2
      5 * 3 = 15
      5 / 3 = 1
      5 % 3 = 2
����] �Է°��� ������
      ���� õ���� ǥ��
*/

		System.out.println("==========����2==========");
		System.out.print("ù��° ���� : ");
		String n1 = reader.readLine();
		int n2 = Integer.parseInt(n1);

		System.out.print("�ι�° ���� : ");
		String n3= reader.readLine();
		int n4 = Integer.parseInt(n3);

		System.out.printf("%d + %d = %d\n", n2, n4, n2+n4);
		System.out.printf("%d - %d = %d\n", n2, n4, n2-n4);
		System.out.printf("%d * %d = %d\n", n2, n4, n2*n4);
		System.out.printf("%d / %d = %d\n", n2, n4, n2/n4);
		System.out.printf("%d %% %d = %d\n", n2, n4, n2%n4);


/*
����3. -> �Ϸ�
�䱸����] �簢���� �ʺ�� ���̸� �Է¹޾� ���̿� �ѷ��� ����Ͻÿ�.
�Է�] �ʺ�(cm) : 20
      ����(cm) : 10
���] ���� : 200cm2
      �ѷ� : 60cm 
*/
		System.out.println("==========����3==========");
		System.out.print("�ʺ�(cm) : ");
		String wideth = reader.readLine();
		int w1 = Integer.parseInt(wideth);

		System.out.print("����(cm) : ");
		String height= reader.readLine();
		int h1 = Integer.parseInt(height);

		System.out.printf("���� : %dcm2 \n", w1 + h1);
		System.out.printf("�ѷ� : %dcm \n", 2*(w1+h1));


/*
����4.
�䱸����] ������ ������(����26��ġ), ��޼� �Է¹޾� �� m�� ������ ����Ͻÿ�.
����] ��� 1���� -> ���� 1ȸ��
      �Ҽ� ���� ���
�Է�] ��� �� : 1000
���] �� 3,000m�� �̵��߽��ϴ�.
*/
		System.out.println("==========����4==========");
		System.out.print("��� �� : ");
		String roll = reader.readLine();
		
        double douRoll = Double.parseDouble(roll);
		double total = douRoll*3.14*26*0.0254;
		int intRoll = (int)total;

		System.out.printf("�� %dm�� �̵��߽��ϴ�.\n", intRoll);


/*
����5.
�䱸����] ���ҹ��� 1�� �Է¹޾� �빮�ڷ� ��ȯ���� ����Ͻÿ�.
�Է�] ���� : a
���] 'a'�� �빮�ڴ� 'A'�Դϴ�.
����] ���� �ڵ尪 + ����ȯ + (�빮�ڿ� �ҹ��ڰ��� ����?)
*/
		System.out.println("==========����5==========");
		System.out.print("�� �ҹ��� : "); 
		int alpha = reader.read();
        System.out.printf("'%c'�� �빮�ڴ� '%c'�Դϴ�.\n", alpha, alpha-32); 
		
  


/*
����6.  -> �Ϸ�
�䱸����] �Ѵ� ������ �Է¹޾� ���� �ݾ��� ����Ͻÿ�.
�Է�] �ݾ�(��) : 1000000
���] ����(��) : 967000��
����] ���� : 3.3%
      ��� �Ҽ��� ����x
*/
    /*  System.out.println("==========����6==========");
      System.out.print("�ݾ�(��) : "); 
      String income = reader.readLine();
	  int inc = Integer.parseInt(income);
      System.out.printf("����(��) : %.0f��\n", inc*(1-0.033));


	  System.out.println("==========����6-1, �ٸ� ���==========");
      System.out.print("�ݾ�(��) : "); 
      String income2 = reader.readLine();
	  int inc2 = Integer.parseInt(income2);
      System.out.printf("����(��) : %,d��\n", inc2-inc2*(33/1000));	  


	  System.out.println("==========����6-2, �ٸ� ���==========");
      System.out.print("�ݾ�(��) : "); 
      String income2 = reader.readLine();
	  int inc2 = Integer.parseInt(income2);
	  double inc3 = inc2*(1-0.003);
      System.out.printf("����(��) : %,d��\n", (int)inc3);	  */ //5���̶� �������� �� ������


/*
����7. -> �Ϸ�
�䱸����] ���ڸ� 2�� �Է¹޾� �� �� ū ���ڸ� ����Ͻÿ�.
�Է�] ù��° ���� : 5
      �ι�° ���� : 3
���] ū �� : 5
*/      System.out.println("==========����7==========");
        System.out.print("ù��° ���� : ");
		String firstNumber1 = reader.readLine();
		int fn1 = Integer.parseInt(firstNumber1);

		System.out.print("�ι�° ���� : ");
		String secondNumber1= reader.readLine();
		int sn2 = Integer.parseInt(secondNumber1);

        int greater1 = (fn1 > sn2) ? fn1 : sn2;
		System.out.printf("ū �� : %d\n", greater1);



/*
���� 7-1. -> �Ϸ�
�Է�] ù��° ���� : 5
      �ι�° ���� : 3
	  ����° ���� : 8
���] ���� ū �� : 8
//���� ������ �Ἥ Ǯ�� 
*/
        System.out.println("==========����7-1==========");
        System.out.print("ù��° ���� : ");
		String firstNumber = reader.readLine();
		int fn = Integer.parseInt(firstNumber);

		System.out.print("�ι�° ���� : ");
		String secondNumber= reader.readLine();
		int sn = Integer.parseInt(secondNumber);

		System.out.print("����° ���� : ");
		String thirdNumber = reader.readLine();
		int tn = Integer.parseInt(thirdNumber);

        int greater = (fn > sn) ? fn : sn; 
        
		int firstGreater = (tn > greater) ? tn : greater;
		System.out.printf("ū �� : %d\n", firstGreater);


/*
����8.
�䱸����] 2017�� 11�� 1���� �������Դϴ�. 2017�� 11�� �� �� ��¥�� �Է¹޾� ���� �������� ����Ͻÿ�.
�Է�] ��¥ : 28
���] 28���� ȭ�����Դϴ�.
//������ ������, ���ǿ����� �Ἥ
*/
 
        System.out.println("==========����8==========");
        System.out.print("��¥ : ");
        String day = reader.readLine();
        int = 30 % day 
        








        System.out.printf("%d���� %s�Դϴ�.\n", day, );






/*
����9. 
�䱸����] �����ڸ� 1�� �Է¹޾� �빮��? �ҹ���?
�Է�] ���� : a
���] 'a'�� �ҹ����Դϴ�.
�Է�] ���� : H
���] 'H'�� �빮���Դϴ�.

*/

	}////////////////////////////////////main///////////////////////////////////////////////
//================================================================================================================================

/*
����1.
�䱸����]�̸��� �ǳ��ָ� �̸��ڿ� "��"�� �ٿ��� ��ȯ�ϴ� �޼ҵ� ����
�Է�] �̸� : ȫ�浿
���] �� : ȫ�浿��
����] String getName(String name)//{}
*/


/*
����2.
�䱸����] ���ڸ� �ǳ��ָ� '¦��'���� 'Ȧ��'���� ��ȯ�ϴ� �޼ҵ� ����
�Է�] ���� : 5
���] �Է��Ͻ� ���� 5��(��) 'Ȧ��'�Դϴ�.
����] String getNumber(int num)
*/



/*
����3.
�䱸����] ��/��/�� ������ �ǳ��ָ� �հ�/���հ��� ��ȯ�ϴ� �޼ҵ�
�Է�] ���� : 80
	  ���� : 75
	  ���� : 60
���] (��)�հ��Դϴ�.
����] ��� 60�� �̻� �հ�, �̸� ���հ�
�߰�] ���� 40�� �̸� ���հ�
����] String test(int kor, int eng, int math)
*/


/*
����4.
�䱸����] ����ö�� ���� ����, ȯ�� Ƚ�� �Է¹޾� �� �ҿ�ð��� ��ȯ�ϴ� �޼ҵ�
�Է�] ���� ���� : 15
      ȯ�� Ƚ�� : 1
���] �� �ҿ� �ð��� 33���Դϴ�.
����] ������ �ҿ�ð� : 2��
      ȯ�½ð� : 3�� 
����] int getTime(int, int)

�߰�] ���� ���� : 15
      ȯ�� Ƚ�� : 1
	  ����      : ���
�߰�] ȯ�� �ҿ�ð� 
      - ��� : 3��
	  - ��� : 4��
	  - ��� : 5��
����] int getTime(int, int, String)
*/

/*
����5.
�䱸����] �������. ��ĥ�� ������ �� ����� ��� ��������?
�Է�] ���� �� : 20
      �帰 �� : 5
���] ����� �� 00�� ���Ƚ��ϴ�.
����] ��������� ó�� �ɾ��� �� : 0m
      ���� �� ����� : 5cm
	  �帰 �� ����� : 2cm
	  ��������� 1m�Ѵ�(�ʰ�) �������� ����� ������.
	  1m�Ѵ� ���� 10cm �ڶ������� ����� 1���� ������
����] int getApple(int,int)





*/
	
//=================================================================================

/*
��¥/�ð� ����
	- ��� ���x
	- ���� ������o

����1. 
�䱸����] �¾ �⵵�� �Է¹޾� ���̸� ����Ͻÿ�.
�Է�] �⵵ : 1995
���] ���� : 27��
����] ���� �⵵�� ����, �츮 ���� ���� 
*/
          
        public static void age() throws Exception{
		BufferedReader reader = new BufferedReader(new
        InputStreamReader(System.in));

        System.out.println("==========����1==========");
        System.out.print("ù��° ���� : ");
	    String birth = reader.readLine();

		int mybirth = Integer.parseInt(birth);    
		Calendar c = Calendar.getInstance();

		System.out.printf("���� : %d��\n", (c.get(Calendar.YEAR) - mybirth) + 1 );
		
		
		}//age()

/*
����2.

�䱸����]���ڿ� ������ �̸� �Է� + ������ �Է� -> ����� ���
�Է�] ���� : ȫ�浿
      ���� : ȣȣȣ
	  �� : 2017
	  �� : 12
	  �� : 4

���] 
================================
'ȫ�浿'��(��) 'ȣȣȣ'�� ����� 
================================

100�� : 2018�� 3�� 28��
200�� : 2018�� 7�� 10��
300�� : 2018�� 11�� 25��
500�� : 2018�� 3�� 28��
1000�� : 2018�� 3�� 28��
*/

        public static void aniversary() throws Exception{
		BufferedReader reader = new BufferedReader(new
        InputStreamReader(System.in));


        System.out.println("==========����2==========");
        System.out.print("���� : ");
	    String manName = reader.readLine();
		
	    System.out.print("���� : ");
	    String womanName = reader.readLine();



		System.out.print("�� : ");
	    String year = reader.readLine();
		int intYear = Integer.parseInt(year); 

		System.out.print("�� : ");
	    String month = reader.readLine();
		int intMonth = Integer.parseInt(month); 

		System.out.print("�� : ");
	    String day = reader.readLine();
		int intDay = Integer.parseInt(day);

        Calendar meeting = Calendar.getInstance ( );
        meeting.set(intYear, intMonth-1, intDay);
		
        System.out.println("=====================================");
	    System.out.printf("'%s'��(��) '%s'�� �����\n", manName, womanName);
		System.out.println("=====================================");
		meeting.add(Calendar.DATE, 100 );
		System.out.printf("100�� : %d�� %d�� %d��\n"
		                                            , meeting.get(Calendar.YEAR)
												    , meeting.get(Calendar.MONTH)+1
													, meeting.get(Calendar.DATE));
		meeting.add(Calendar.DATE, 100 );
		System.out.printf("200�� : %d�� %d�� %d��\n"
		                                            , meeting.get(Calendar.YEAR)
													, meeting.get(Calendar.MONTH)+1
													, meeting.get(Calendar.DATE));
		meeting.add(Calendar.DATE, 100 );
		System.out.printf("300�� : %d�� %d�� %d��\n"
		                                            , meeting.get(Calendar.YEAR)
													, meeting.get(Calendar.MONTH)+1
													, meeting.get(Calendar.DATE));
		meeting.add(Calendar.DATE, 200 );
		System.out.printf("500�� : %d�� %d�� %d��\n"
		                                            , meeting.get(Calendar.YEAR)
												    , meeting.get(Calendar.MONTH)+1
													, meeting.get(Calendar.DATE));
		meeting.add(Calendar.DATE, 500 );
		System.out.printf("1000�� : %d�� %d�� %d��\n"
		                                            , meeting.get(Calendar.YEAR)
													, meeting.get(Calendar.MONTH)+1
													, meeting.get(Calendar.DATE));
	   
		
		}//aniversary()
	
  




/*
����3
�䱸����] ����� ���ÿ� �ޱ⸦ ���ϴ� ��. ������ ������ ���� �ֹ�?
����] ¥��� 10�� �� ���� 
      ġŲ 18�� �� ����
	  ���� 25�� �� ����

�Է�] ���ϴ� ���� �ð�
      �� : 17
	  �� : 30
���] ¥��� : 17�� 20��
      ġŲ : 17�� 12��
      ���� : 17�� 5��
*/

		public static void delivery() throws Exception{
		
		BufferedReader reader = new BufferedReader(new
        InputStreamReader(System.in));

		System.out.println("==========����3==========");
		
		System.out.println("���ϴ� ���� �ð�");
        System.out.print("�� : ");
	    String hour = reader.readLine();
		int intHour = Integer.parseInt(hour);
		
	    System.out.print("�� : ");
	    String minute = reader.readLine();
		int intMinute = Integer.parseInt(minute);
 
        Calendar jit = Calendar.getInstance( );
		jit.set(Calendar.HOUR_OF_DAY, intHour);
		jit.set(Calendar.MINUTE, intMinute);
		
		jit.add(Calendar.MINUTE, -10);   
        System.out.printf("¥��� : %d �� %d ��\n"
		                                         , jit.get(Calendar.HOUR_OF_DAY)
											     , jit.get(Calendar.MINUTE));
	    jit.add(Calendar.MINUTE, -8);   
        System.out.printf("ġŲ : %d �� %d ��\n"
		                                         , jit.get(Calendar.HOUR_OF_DAY)
											     , jit.get(Calendar.MINUTE));
		jit.add(Calendar.MINUTE, -7);   
        System.out.printf("���� : %d �� %d ��\n" 
			                                     , jit.get(Calendar.HOUR_OF_DAY)
			                                     , jit.get(Calendar.MINUTE));
		

		}//delivery()




//=====================================================================================================================

/*
if��(switch��)

����1.
�䱸����] ���ڸ� 2�� �Է¹޾� ū���� �������� ����Ͻÿ�.
�Է�] ù��° ���� : 5
      �ι�° ���� : 3
���] ū���� 5�̰�, �������� 3�Դϴ�.
���] if
*/
	public static void greater() throws Exception{
   
		 BufferedReader reader = new BufferedReader(new
		 InputStreamReader(System.in));

		 System.out.print("ù��° ���� : ");
		 int firstNum = Integer.parseInt(reader.readLine());
         System.out.print("�ι�° ���� : ");
		 int secondNum = Integer.parseInt(reader.readLine());

		 if (firstNum > secondNum) {
			 System.out.printf("ū���� %d�̰�, �������� %d�Դϴ�.\n"
			                                               , firstNum
														   , secondNum);
		 } else if(firstNum < secondNum) {
			 System.out.printf("ū���� %d�̰�, �������� %d�Դϴ�.\n"
			                                               , secondNum
														   , firstNum);
		 } else {
             System.out.printf("%d�� %d�� �������Դϴ�.\n"
			                                               ,secondNum
														   , firstNum);	  
		 } 
 
      //���� �������� ū ī�װ��� ���� ũ�ٸ� �ȿ� �������� ����

	}//greater() ����1.


/*
����2.
�䱸����] ������ �Է¹޾� ������ ����Ͻÿ�.
�Է�] ���� : 85
���] �Է��� ���� 85���� B�Դϴ�.
����] 90~100 : A
      80~89  : B
	  70~79  : C
	  60~69  : D
	  0~59   : F
�߰�]��ȿ�� �˻�(���� 0~100�̳�) (����: ������ ���ڸ� �Է��ߴ�)
���]if, switch(���� - ���� �˻� x)
*/

	public static void grade() throws Exception{

		 BufferedReader reader = new BufferedReader(new
         InputStreamReader(System.in));

	     System.out.print("���� : ");
	     int score = Integer.parseInt(reader.readLine());
		 String result = " ";
		
		 //��ȿ�� �˻�
		 if (score >= 0 && score <= 100) {
			 
			 //����Ͻ� �ڵ�, ���� �ڵ�
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
			 System.out.printf("�Է��� ���� %d���� %s�Դϴ�.\n"
			                                               , score
														   , result);
	     
         //���� ó�� �ڵ�
		 } else {
			System.out.println("���� �ٽ��Է�");
		 }
		
	}//grade(), ���� 2
 

/*
����3.
�䱸����] ���� 2���� ������ 1���� �Է¹޾� ��������� ����� ����ϼ���
�Է�] ����1 : 5
      ����2 : 3
	  ������ : *

���] 5*3 = 15
����] �Է�(����)
      ���(�Ҽ����� 1�ڸ�����)
	  ������(��� ���길...)
���]if
*/

	
	public static void cal() throws Exception{

		 BufferedReader reader = new BufferedReader(new
         InputStreamReader(System.in));
        
		 System.out.print("����1 : ");
	     int num1 = Integer.parseInt(reader.readLine());
		 
         System.out.print("����2 : ");
	     int num2 = Integer.parseInt(reader.readLine());

		 System.out.print("������ : ");
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
          
		 



/*����4.
�䱸����] ���� 1���� �Է¹޾� �Ʒ��� ���� ����Ͻÿ�
�Է�] ���� : f
���] Father
����] f, F -> Father
      m, M -> Mother
	  s, S -> Sister
	  b, B -> Brother
���] if, switch
*/
	
	public static void family() throws Exception{

		 BufferedReader reader = new BufferedReader(new
         InputStreamReader(System.in));
         
		 System.out.print("���� : ");
	     char alphabet = reader.readLine().charAt(0);
		 String resultChar = " ";

		 //��ȿ�� �˻�
         if ((alphabet >= 'a' && alphabet <= 'z') || (alphabet >= 'A' && alphabet <= 'Z')){
         
		 //����Ͻ� �ڵ�, ���� �ڵ�
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
			System.out.println("���ĺ��� �Է��ϼ���.");
		    }
			
			
            
			//���� ó�� �ڵ�
		  


	}



/*����5.
�䱸����] ������ 1���� �Է¹޾� ��/�ҹ��ڸ� ��ȯ/����Ͻÿ�.
�Է�] ���� : a
���] ��� : A
�Է�] ���� : F
���] ��� : f
*/



/*
����6.
�䱸����] ���� ����� ����Ͻÿ�
�Է�] <���� �ð�>
	�� ; 13
	�� : 30
	  <���� �ð�>
	�� : 14
	�� : 20
���] ���� ����� 4,000���Դϴ�.
����] ���� ���� : 30��
      �ʰ� 10�� : 2,000��
*/



/*
����7.
�䱸����]�⵵�� �Է¹޾� "���"���� "����"���� ����Ͻÿ�
�Է�] �Է� : 2017
���] 2017���� "���"�Դϴ�.
*/

//=======================================================================================	

/*for ��

����1.
�䱸����] �̸��� Ƚ���� �Է¹޾Ƽ� Ƚ����ŭ �λ��Ͻÿ�.
�Է�] �̸� : ȫ�浿
      Ƚ�� : 3
���] ȫ�浿�� �ȳ��ϼ���~
	  ȫ�浿�� �ȳ��ϼ���~
	  ȫ�浿�� �ȳ��ϼ���~
*/

	public static void hello() throws Exception{
	
	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		System.out.println("=========����1========");

        System.out.print("�̸� : ");
		String name = reader.readLine();

		System.out.print("Ƚ�� : ");
		int number  = Integer.parseInt(reader.readLine());
        
        for(int i=0; i<number; i++){
			System.out.printf("%s�� �ȳ��ϼ���~.\n", name);
		}

	
	}//hello() //����1 






/*
����2. 
�䱸����] ���� 1���� �Է¹޾� 1���� ~ �Է��� ���ڱ����� ���� ����Ͻÿ�.
�Է�] ���� : 5
���] 1 ~ 5 : 15
����] õ���� ���.���
*/

	public static void calFromOne() throws Exception{
	
	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

	    System.out.println("=========����2========");
        
		System.out.print("���� : ");
		int number  = Integer.parseInt(reader.readLine());
        int sum = 0; 
		
		for(int i=1; i<=number; i++){
			sum += i; 		
		}

		System.out.printf("1 ~ %d : %d\n", number, sum);

	}//calFromOne() //����2











/*
����3.
�䱸����] ���� 10���� �Է¹޾� ¦���� �հ� Ȧ���� ���� ���� ����ϼ���.
�Է�] ���� : 5
      ���� : 7
	  ..
	  ���� : 10
���] ¦���� �� : 52
      Ȧ���� �� : 46
*/

	public static void sum() throws Exception{
	
	BufferedReader reader = new BufferedReader(new 
	InputStreamReader(System.in));

	    System.out.println("=======����3=======");
        
		//1. ¦��, Ȧ���� �� ������ �ʱ�ȭ
		int sum10Even = 0;  
		int sum10Odd = 0;  
        
		//2. for�� ����
		for(int i=0; i<10; i++){
         
		//3. ���ڸ� 10�� �Է¹޴´�.
		System.out.printf("%d.���� : ",i+1);
		int number 
			= Integer.parseInt(reader.readLine());
		
        //4. ¦���� Ȧ���� ������ ���� ���Ѵ�.
			if(number % 2 == 0){
				sum10Even += number;
			}else{
				sum10Odd += number;
			} 
      
		}

        //5. ��� ��� 
		System.out.printf("¦���� �� : %d\n"
		                             , sum10Even);
		System.out.printf("Ȧ���� �� : %d\n"
		                             , sum10Odd);


	}//sum() //����3












/*
����4. ��������Ȱ��
�䱸����] �Ʒ��� ���� ����Ͻÿ�.
���] 1 + 2 + 3 + 4 + 5 + 6 + 9 + 10 = 55
���] 1 - 2 + 3 - 4 + 5 - 6 + 9 - 10 = -5
*/


	public static void twoTypeCal(){

	    System.out.println("=========����4========");
		
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







	}//twoTypeCal()// ����4. 
	


/*
����5. 
�䱸����] �Ʒ��� ���� ����Ͻÿ�.
���] 1 + 2 + 3 + 4 + 5 + .....+ ? = 10xx
����] �������� 1000�� �Ѿ�� ���������� ����Ͻÿ�.
���] ���� ���� + break
*/


	public static void CallTo1000(){

		Random rnd = new Random();

	    System.out.println("=========����5========");
        
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


	}//CallTo1000()//����5.


/*
����6.
�䱸����] ���� 1�� 1�� 1�Ϻ��� 2017�� 12�� 6�ϱ��� �� ��ĥ�� �������� ���Ͻÿ�.
���] �� 4,563,543�� �������ϴ�. 
����] Calendar ��� ����
���] for�� ���, ��� ���/ �����µ� �ɸ��� �κ��� ���� �߻����غ���
����] ��� % 7 = ? ���� ���� �����غ��� 
*/

/*
����7.
�䱸����] 369 ������ ����Ͻÿ�.
���] 1 2 ¦ 4 5 ¦ 7......
����] 100����
      33 - ¦¦
      ������ 1~100���� ������ �׾ȿ��� ������ 3�̳� 6�̳� 9�� ������ 
*/  

//=======================================================================
/*����8.
�䱸����] ����� -> (" ") (space����Ѱ�)

	*
   **
  ***	
 ****
*****
*/

	
����9.
�䱸����] �����

*********
 *******
  *****
   ***
    *

����10.
�䱸����] �����
*
 *
  *
   *
    *

����11.
�䱸����] �����
*
**
***
*******
	***
	 **
	  *

����12. ���̵�***
�䱸����] �Ʒ��� ���� ����Ͻÿ�.

	aa
   abba
  abccba
 abcddbca
abcdeedcba


����13.
�䱸����] �������� ����Ͻÿ�.
��Ʈ] 2�� for�� x 2 or 3�� for�� x 1��

2 x 1 = 2	2 x 1 = 2	2 x 1 = 2	5 x 1 = 2  
2 x 2 = 2							5 x 2 = 10
2 x 3 = 2							5 x 3 = 15
2 x 4 = 2
..
2 x 9 = 18							5 x 9 = 2

6 x 1 = 6							2 x 1 = 2
6 x 1 = 12							2 x 1 = 2
6 x 1 = 18							2 x 1 = 2

����14-1.
�䱸����] �Ʒ��� ���� ����Ͻÿ�.
���] 2�� for�� x 1��, 1�� for�� x 1��


1 ~ 10 :  55
1 ~ 20 : XXX
1 ~ 30 : XXX
1 ~ 40 : XXX
1 ~ 50 : XXX
...
1 ~ 100 : 5050


����14-2.

1 ~ 10 :  55
11 ~ 20 : XXX
21 ~ 30 : XXX

...
91 ~ 100 : XXX




����15.
�䱸����] �Ʒ��� ���� ����Ͻÿ�.

1 + 2 + 4 + 7 + 11 + 16 + .... + N = 469
����] ���ϴ� N�� 100�� ���� ���� ������...





����16. ���̵� ****
�䱸����] �Ʒ��� ���� ����Ͻÿ�

1 + 1 + 2 + 3 + 5 + 8 + 13 + 21 + 34 + 55 + 89 = 232

����] ���ϴ� N�� 100�� ���� ���� ������...



����17.
�䱸����] 2���� 100������ �Ҽ��� ���Ͻÿ�.
���] 2, 3, 5, 7, 11, 13.....
��Ʈ] �Ҽ� : 1�� �ڱ��ڽ����ιۿ� �������� �ʴ� �� 


����18.
�䱸����] 1���� 100������ �������� ���Ͻÿ�.
���] 

6 = [1, 2, 3, 6]
28 = [1,2,4,7,14,28]

��Ʈ] ������ : �ڱ� �ڽ��� ������ ������ ������� ���� �ڽŰ� ������ ��


































