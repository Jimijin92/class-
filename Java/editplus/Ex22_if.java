import java.io.*;

class Ex22_if {

	public static void main(String[] args) throws Exception {

		//Ex22_if.java

		/*

			���(***�����ϱ�***)
				- ���α׷� �ڵ��� ���� ������ �����ϴ� ����
			
			1. ���ǹ�
				a. if
				b. switch

			2. �ݺ���
				a. for
				b. while
				c. do while
				d. for

			3. �б⹮
				a. break
				b. continue
				[c. goto] x



			if �� 
			- ������ ������ �� ����� ���� ������ �ڵ带 ����
			- ������ �ݵ�� boolean���� ������. 
			- A ? B : C
			

			�⺻ ���
			if(���ǽ�){
			   ���� �ڵ�;
			   
			}
				



			if(���ǽ�){
			   ���� �ڵ�;
	        } else {
			   ���� �ڵ�;
			}
			
				

            //���� if��

			if(���ǽ�){
			   ���� �ڵ�;
	        } else if {
			   ���� �ڵ�;
			} else if {
			   ���� �ڵ�;
	        } else {
			   ���� �ڵ�;
			}

		*/


		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		//�䱸����] ���� 1�� �Է� �޾� �������?
		System.out.print("���� �Է� : ");
		int num = Integer.parseInt(reader.readLine());
        
		/*
		if (true) {
			//true block (���� �� �����ؼ� Ʈ����̶�� ��)
			System.out.printf("�Է��Ͻ� ���� %d�� ����Դϴ�.\n", num);

		}
		*/
		
		//���? ����?

		if(num > 0) {
			System.out.printf("�Է��� ���� %d�� ����Դϴ�.\n", num);
		}else{
		    System.out.printf("�Է��� ���� %d�� �����Դϴ�.\n", num);
		}

       

        if(num > 0) {
			System.out.printf("�Է��� ���� %d�� ����Դϴ�.\n", num);
		}else if (num < 0){
		    System.out.printf("�Է��� ���� %d�� �����Դϴ�.\n", num);
		}else if(num == 0){
			System.out.printf("�Է��� ���� %d�� 0�Դϴ�.\n", num);
		}

					
		

		System.out.println("���α׷� ����");


	}//main






}
