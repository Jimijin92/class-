import java.util.Calendar;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

class group2test {
	
	public static void main(String[] args) throws Exception{

    

	//hello();//����1.
    //calFromOne();//����2.
    sum();//����3.
    //twoTypeCal();//����4.
	//CallTo1000();//����5.



	}//main

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



}
