import java.io.*;
import java.util.Random;

class Ex25_for {

	public static void main(String[] args) throws Exception{

		//Ex25_for.java

		/*

		for ��
		- �ݺ���
		- ������ �����ϴ� ���� (����) �ݺ��ؼ� �����ض�

		for (�ʱ��; ���ǽ�; ������){
			 ���� �ڵ�;
		}

		*/

		//m1();
		//m2();
		//m3();
		//m4();
		//m5();
        //m6();
		//m7();
		//m8();
		//m9();
		//m10();
		//m11();
		//m12();
		//m13();
		//m14();
		m15();
				
	}//main

	public static void m15(){
	
		//2�� for�� - > �����
		for (int i=0; i<5; i++){//��
			for(int j=0; j<(5-i); j++){//��
				System.out.print("*");
			}
			System.out.println();
		}

	}//m15()





	public static void m14(){
	
		for(int i=0; i<10; i++){
			for(int j=0; j<10; j++){

				if (j > 5 || i < 3){
					//break;
					continue;

				}


				System.out.printf("i : d%, j : d%\n", i, j);
			}
		
		}

	}//m14()
	

	public static void m13(){
		
		//������ ���
        for(int j =2; j<10; j++){
			for (int i =1; i<10; i++){
				System.out.printf("%d x %d = %d\n", j, i, j * i);
			}
			System.out.println();
		}
	}



	public static void m12(){
		//25��
		//6���ǽ�
		//�л����� ������� ���� üũ
		for(int i=1; i<=6; i++){//���ǽ�
			for(int j=1; j<=25; j++){//�л�
				System.out.printf("%d ���ǽ� %d�� �л� ���� üũ\n", i, j);
			}
		
		}//for��
	
		//����Ʈ
		
		for(int k=1; k<=5; k++){
			for (int j=1; j<=23; j++){
				 //23��
				for(int i=1; i<=10; i++){
					//10����
					//1�� 1ȣ ->101ȣ
					//1�� 12ȣ-> 112ȣ
					System.out.printf("%d�� %d%sȣ\n", k, j, getNum(i));
				}
		    } 
        }//for��
    
	 }//m12()


		public static String getNum(int i) {
			//1  -> "01"
			//10- > "10"
			if (i < 10){
				return "0" + i;
			}else{
				//return String.valueOf(i);//10 - > "10"
				return i + "";
			}
		}//getNum



	








	public static void m11(){
	
	//��ø
	//	- for���ȿ� �� �ٸ� for���� ���
	
	/*2�� for��
		for (int i=0; i<10; i++){
		//x10ȸ
			for (int j=0; j<60; j++){
		    //x10ȸ
			//System.out.println("�ȳ�~");
			System.out.printf("i : %d, j : %d\n", i, j);
			}
	*/

		for (int i=0; i<10; i++){
			for(int j=0; j<10; j++){
				for(int k=0; k<10; k++){
					System.out.printf("i : %d, j : %d, k : %d\n", i, j, k);
				}
			
			}
		
		}

	}//m11()
	




	public static void m10(){
	
		//break, continue
		//	- �������� ����� ���ϰ� �ٸ� ����� �Բ� ����Ѵ�.
		//	- �ݺ����� ���� �� ����Ѵ�.

		//break
		//	- �ڽ��� ���� ����� Ż���Ѵ�.
		//  - if���� ����(if���� �ν����� �ʴ´�.)

		//continue
		//	- - �ڽ��� ���� ����� Ż���Ѵ�.
		//  - if���� ����(if���� �ν����� �ʴ´�.)
		//	- �ϴ����� ���߰� ������ �ö󰡼���.
	
		for(int i=1; i<=10; i++) {
			

			if (i == 5){
				//break;
				continue;
			}

			System.out.println(i);
		}
		//�䱸����] �б� ���� ������ -> �л� ��� -> ��ȣ �������..
		for (int i=1; i<30; i++){

			//15��������..
			//if(i == 16) {
			//	break;
			//}
			
			//7�� �Ἦ
			if(i == 7 || i == 12 || i == 25){//(7���л��� �Ἦ, ������)
				continue; 
			}

			System.out.printf("%d�� �л� �����..\n",i);
		}


	}//m10


/*
	public static void m9(){
	
		//��������
		for (int i=0; j=0; i<10 && j<50; i++, j+=2+i) {
			System.out.printf("i : %d, j: %d\n", i, j);
		}
	
	}//m9

*/


	public static void m8(){

		Random rnd = new Random();
	
		//���� ����(�����ǰ��ӱ�, ȸ������ �����ϱⰡ ����ﶧ)

		//for(int i=0; i=<10; i++){// ���ѿ� �������� �������� ����
		//for (int i=0; true; i++){
		//for( ; ; ){
		//for(int i=1; ;i+=3){
			//System.out.println(rnd.nextInt(1000));
			//System.out.println(i);
		}
	


	



	public static void m7(){
	
		//���� -> ������ �� 
		//�ڹ� ���� ������
		
		//Math Ŭ���� java.lang (�⺻����)
		//Random Ŭ���� java.util (import�ؾ���) /��Ƽ�� ���� ������ ������ �߻���Ŵ

		Random rnd = new Random();
		int sum = 0;

		//0(inclusive)~1(exclusive) ������ �Ǽ� ��ȯ
		for (int i=0; i<10; i++){
			//System.out.println(Math.random());

			//0.0  -> 0.0
			//0.1  -> 1.0
			//0.2  -> 2.0
			//0.99 -> 9.9

			//1 ~ 10
			//System.out.println((int)(Math.random()*10)+1); // ��Ƽ���� ��ȯ��Ű�� ������ ������
			
			
			//1 ~ 45 -> 0~44
			//������ �ߺ����� �������� ����.
			//System.out.println((int)(Math.random()*45)+1); 

			//System.out.println(rnd.nextInt(10));
			//System.out.println(rnd.nextDouble());
			//System.out.println(rnd.nextBoolean());
			
			sum += rnd.nextInt(10) + 1;
		}

		//1~10 ������ ������ �� 10���� ���Ͻÿ�. 
		System.out.println(sum);

	}

	public static void m6() throws Exception {
	
	//�䱸����] ����ڰ� �Է��� 10���� ������ ������ ���Ͻÿ�.
	//�Է�] ���� : 5
	//      ���� : 7
	//..
	//      ���� : 10
	//���] ���� : 424

	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

	//�������� 0���� �ʱ�ȭ�� 	
	int sum = 0;
	int num = 0;

	for (int i=0; i<10; i++) {
		//�Է�
		System.out.print("���� : ");
		num =Integer.parseInt(reader.readLine());

		//����
		sum += num;
	}
	System.out.println(sum);
	}




	public static void m5() {
	
		//���� -> ������ ���ϱ�

		//�䱸����]1 ~ 10������ �� ���ϱ�
		// 0 + 1 + 2 + 3 + 4 + 5 + 6 + 7 + 8 + 9 + 10 
		// (0 + 1) + 2 + 3 + 4 + 5 + 6 + 7 + 8 + 9 + 10 
		// ((0 + 1) + 2) + 3 + 4 + 5 + 6 + 7 + 8 + 9 + 10 
		// (((0 + 1) + 2) + 3) + 4 + 5 + 6 + 7 + 8 + 9 + 10 

		//���� ����
		//	- ���� ������ ���� ���꿡 ������ ���� �ʱ� ���ؼ� �׻� 0���� �ʱ�ȭ
		int sum = 0;
        // �׳� int sum �ȵ�, �ʱ�ȭ ������� 
		// �ȵ� ��츦 �����ϱ� ������ ��������� ���� ���� ����.
		for (int i =1; i<=100; i++){
			sum = sum + i;//����
		}

		System.out.println(sum);


		//1~100������ ¦���� ��
		sum = 0;
		for (int i=2; i<=100; i+=2){ //(i=1 �ϸ� Ȧ���� ��)
			sum += i;
		}
		
		System.out.println(sum);


	}



	
	public static void m4() throws Exception {
	
		//������ ����ϱ�
		//5 x 1 = 5
		//5 x 2 = 10
		//5 x 3 = 15
		//..
		//5 x 9 = 45

		System.out.println("==============");
		System.out.println("      5��     ");
		System.out.println("==============");
		
		
		//>=���ٴ� >�� ���־�
		for(int i=1; i<10; i++){
			System.out.printf("5 x %d = %2 d\n", i, 5*i);
		}

		//�䱸����] ����ڷκ��� ���ϴ� �ܰ� �ִ밪�� �Է¹޾Ƽ� �������� ����Ͻÿ�
		//�Է�] �� : 5
		//      �ִ밪 : 15
		//���]
		// 5 x 1 = 5
		// ..
		// 5 x 15 = 75

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		int dan = 0;
		int max = 0;

		System.out.print("�� : ");
		dan = Integer.parseInt(reader.readLine());

		System.out.print("�ִ밪 : ");
		max = Integer.parseInt(reader.readLine());

		System.out.println("==============");
		System.out.printf("      %d��\n     ", dan);
		System.out.println("==============");		

		for (int i=1; i<=max; i++){
			System.out.printf("%2d x %2d = %4d\n", dan, i, dan*i);
		}


	}





	public static void m3() {

		for (int i=0; i<10; i++){
			System.out.print(i+ "\t");
		}
		System.out.println();

		//�䱸����] 10~1���� ���
		

		for (int i=1; i<=10; i++)  {
			System.out.print(11-i+ "\t");
		}
		System.out.println();


		
		for (int i=10; i>10; i--) {
			System.out.print(i+ "\t");
		}
		System.out.println();
	
	}




	public static void m2() {
	
		//for (int i=0; i<10; i++){
		for (int i=1; i<=10; i++){
			System.out.println("���ﵿ");
		}


		//���� ������ ����
		//1. ȸ�� ���� �����Ѵ�.(�ʱ�)
		//2. ���� ������ ���� ������ ����Ѵ�.(��/���)
		
		//�䱸����] ���ڸ� 1~10���� ����Ͻÿ�.
		for(int i=1; i<=10; i++) {
		System.out.println(i);
		//i = i + 1;
		//i += 1;
		//i++
		//i=5;
		}

		//�䱸����] ���� 1~10 ������ ¦���� ����Ͻÿ�.
		for (int i=1; i<=10; i++) {
			if(i % 2 == 0){
			System.out.println(i);
			}
		}


		for (int i=2; i<=10; i=i+2) {
			System.out.println(i);
		}


	}





	public static void m1() {


		//�ݺ� -> loop
		//for i, j -> ���� ����(���� ����)

		for (int i=0; i<3; i++) {
			System.out.println("�ȳ��ϼ���.");
		}

		int j = 0;
		for (j=0; j<3; j++){
		    System.out.println("�ݰ����ϴ�.");
		}


	}

}


