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
		System.out.print("이름을 입력하세요 : ");
		String name = reader.readLine();

		System.out.print("횟수를 입력하세요 : ");
		int input = Integer.parseInt(reader.readLine());

		for(int i=0; i<input; i++){
			System.out.printf("%s 님 안녕하세요~ \n", name);
		}

	}

	public static void t2() throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		System.out.print("숫자 하나를 입력하세요 : ");
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
			System.out.printf("%d 번째 숫자 입력 : ", i+1);
			input = Integer.parseInt(reader.readLine());

			if(input%2 != 0){
				odd += input;
			} else {
				even += input;
			}
			

		}
		System.out.printf("짝수의 합 %d \n", even);
		System.out.printf("홀수의 합 %d \n", odd);

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

			System.out.printf("%d 까지의 합은 %d 입니다. \n", i ,sum);
			

		}
		
	}

	public static void t6() {
		
		int totalDay = 0;
		for(int year=1; year<=2017; year++){
			if( year%4 != 0) {
				//System.out.println("평년"); //365
				totalDay += 365;
				
			} else if( year%100 != 0) {
				//System.out.println("윤년"); //366
				totalDay += 366;
			} else if( year%400 != 0) {
				//System.out.println("평년");//365
				totalDay += 365;
			} else {
				//System.out.println("윤년"); //366
				totalDay += 366;
			}
		}

		totalDay = totalDay -(31-6);

		System.out.printf("총 %d 일이 지났습니다. \n", totalDay);
		System.out.printf("검증 결과 : %d MOD 7 : %d \n", totalDay, totalDay%7);


	}

	public static void t7() {
		for(int i=1; i<101; i++){
			System.out.print(i + " ");

			//10의 자리 3, 6, 9 검증 이후 1의 자리 3, 6, 9 검증을 위한 조건문
			if((i/10) == 3 || (i/10) == 6 || (i/10) == 9){
				
				if((i%10) == 3 || (i%10) == 6 || (i%10) == 9){
					System.out.println("짝짝");
				} else {
					System.out.println("짝");
				}

			//10의 자리가 3, 6, 9 와는 상관없을 때 1의 자리만을 검증하기 위한 조건문.
			} else if((i%10) == 3 || (i%10) == 6 || (i%10) == 9){
				System.out.println("짝");

			} else {
				System.out.println(i);
			}
			

		}
	}
}
