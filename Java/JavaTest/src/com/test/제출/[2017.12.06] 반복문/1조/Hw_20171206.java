import java.io.*;
import java.util.Random;

class Hw_20171206 
{
	public static void main(String[] args) throws Exception
	{
		//t1();

		//t2();

		//t3();

		//t4();

		//t5();

		//t6();

		t7();

		
	}

	public static void t1() throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("�̸��� �Է��ϼ��� : ");
		String name = reader.readLine();

		System.out.print("Ƚ���� �Է��ϼ��� : ");
		int input = Integer.parseInt(reader.readLine());

		for(int i=0; i<input; i++){
			System.out.printf("%s �� �ȳ��ϼ���~ \n", name);
		}

	}

	public static void t2() throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		System.out.print("���� �ϳ��� �Է��ϼ��� : ");
		int input = Integer.parseInt(reader.readLine());

		int sum = 0;

		for(int i=1; i<=input; i++){
			sum += i;
		}

		System.out.printf("1 ~ %d : %d \n", input, sum);
	}

	public static void t3() throws Exception {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		int odd = 0;
		int even = 0;
		int input = 0;

		for(int i=0; i<10; i++){
			System.out.printf("%d ��° ���� �Է� : ", i+1);
			input = Integer.parseInt(reader.readLine());

			if(input%2 != 0){
				odd += input;
			} else {
				even += input;
			}
			

		}
		System.out.printf("¦���� �� %d \n", even);
		System.out.printf("Ȧ���� �� %d \n", odd);

	}

	public static void t4() {
		
		int sum = 0;
		for(int i=0; i<10; i++){
			sum += i+1;

			System.out.printf("%d ", i+1);

			if(i != 9) {
				System.out.print("+ ");
			}
			
		}

		System.out.printf("= %d\n", sum);



		sum = 0;

		for(int i=1; i<=10; i++){
			if(i%2 == 1){
				sum += i;
				System.out.printf("%d + ",i);
				
			} else {
				sum -= i;
				if(i == 10){
					System.out.printf("%d", i);
					break;
				}

				System.out.printf("%d - ",i);
			}
			
		}
		System.out.println(" = " + sum);
	}

	public static void t5() {
		
		int sum = 0;

		for(int i=0;;i++){
			
			if( sum > 1000 ) {
				break;
			}

			sum += i;

			System.out.printf("%d ������ ���� %d �Դϴ�. \n", i ,sum);
			

		}
		
	}

	public static void t6() {
		
		int totalDay = 0;
		for(int year=1; year<=2017; year++){
			if( year%4 != 0) {
				//System.out.println("���"); //365
				totalDay += 365;
				
			} else if( year%100 != 0) {
				//System.out.println("����"); //366
				totalDay += 366;
			} else if( year%400 != 0) {
				//System.out.println("���");//365
				totalDay += 365;
			} else {
				//System.out.println("����"); //366
				totalDay += 366;
			}
		}

		totalDay = totalDay -(31-6);

		System.out.printf("�� %d ���� �������ϴ�. \n", totalDay);
		System.out.printf("���� ��� : %d MOD 7 : %d \n", totalDay, totalDay%7);


	}

	public static void t7() {
		for(int i=1; i<101; i++){
			System.out.print(i + " ");

			//10�� �ڸ� 3, 6, 9 ���� ���� 1�� �ڸ� 3, 6, 9 ������ ���� ���ǹ�
			if((i/10%10) == 3 || (i/10%10) == 6 || (i/10%10) == 9){
				
				if((i%10) == 3 || (i%10) == 6 || (i%10) == 9){
					System.out.println("¦¦");
				} else {
					System.out.println("¦");
				}

			//10�� �ڸ��� 3, 6, 9 �ʹ� ������� �� 1�� �ڸ����� �����ϱ� ���� ���ǹ�.
			} else if((i%10) == 3 || (i%10) == 6 || (i%10) == 9){
				System.out.println("¦");

			} else {
				System.out.println(i);
			}
			

		}
	}
}
