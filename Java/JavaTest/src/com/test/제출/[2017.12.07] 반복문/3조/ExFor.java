import java.io.BufferedReader;
import java.io.InputStreamReader;

class ExFor {
	public static void main(String[] args) throws Exception {
		//q1();
		//q2();
		//q3();
		//q4();
		//q5();
		//q6();
		//q7();

		//q8();
		//q9();
		//q10();
		//q11();
		q12();

		//q13();

		//q14();
		//q15();
		//q16();
		//q17();
		//q18();

		
	}

	public static void q1() throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("이름 : ");
		String name = reader.readLine();
		System.out.print("횟수 : ");
		int num = Integer.parseInt(reader.readLine());

		for (int i = 0; i < num; i++) {
			System.out.printf("%s님 안녕하세요~\n", name);
		}

		System.out.println();
	} //q1()

	public static void q2() throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("숫자 : ");
		int num = Integer.parseInt(reader.readLine());

		int sum = 0;

		for (int i = 1; i <= num; i++) {
			sum += i;
		}

		System.out.printf("1 ~ %d : %,d\n", num, sum);

		System.out.println();
	} //q2()

	public static void q3() throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		int evenSum = 0;
		int oddSum = 0;

		for (int i = 0; i < 10; i++) {
			System.out.print("숫자 : ");
			int num = Integer.parseInt(reader.readLine());
			
			if (num % 2 == 0) {
				evenSum += num;
			} else {
				oddSum += num;
			}
		}
		System.out.printf("짝수의 합 : %d\n", evenSum);
		System.out.printf("홀수의 합 : %d\n", oddSum);

		System.out.println();
	} //q3()

	public static void q4() {
		int sum = 0;

		//1 + 2 + 3 + 4 + 5 + 6 + 7 + 8 + 9 + 10 = 55
		for (int i = 1; i <=10; i++) {
			
			sum += i;

			if (i != 10) {
				System.out.printf("%d + ", i);
			} else {
				System.out.printf("%d = ", i);
			}
		}
		System.out.println(sum);


		/*for(int i = 1; i <=10; i++) {
			System.out.printf("%d + ", i);
		}
		System.out.println("\b\b= %,b\n", sum);
		*/  //강사님
		
		//sum 초기화
		sum = 0;
		
		//1 + 2 + 3 - 4 + 5 - 6 + 7 + 8 + 9 - 10 = 15
		for (int i = 1; i <=10; i++) {
			
			if (i == 4 || i == 6 || i == 10) {
				sum -= i;

			} else {
				sum += i;		
			}

			if (i != 10) {
				if((i + 1) == 4 || (i + 1) == 6 || (i + 1) == 10) {
					System.out.printf("%d - ", i);
				} else {
					System.out.printf("%d + ", i);
				}	
			} else {
				System.out.printf("%d = ", i);
			}
		}
		System.out.println(sum);
	} //q4()

	public static void q5() {
		int sum = 0;

		for (int i = 1; ; i++) {
			sum += i;
			
			if (sum <= 1000) {
				System.out.printf("%d + ", i);
			} else {
				System.out.printf("%d = %d \n", i, sum);
				break;
			}
		}
		System.out.println();
	} //q5()

	public static void q6() {
		 int year = 2017;
		 int month = 12;
		 int date = 6;
		 int totalDay = 0;
	//1.1.1~2016.12.31 * 365(but 윤년 t & f 구분) -> 2017.1.1 ~ 2017.11.30 날짜 수 -> 원하는 날짜수 다 더해

	} //q6()
	//736669

	public static void q7() {
		//백i/100
		//십	i/10%10
		//일	i%10
		for(int a = 0; a < 2; a++) {

			if(a == 1) {
				System.out.println(100);
			} else {

				for (int iTen = 0; iTen < 10; iTen++) {
					
					for(int i = 0; i < 10; i++) {

						if(i == 3 || i == 6|| i == 9) {
							if(iTen == 3 || iTen == 6 || iTen == 9) {
								System.out.printf("%s ", "짝짝");
							} else {
								System.out.printf("%s ", "짝");
							}

						} else if (iTen == 3 || iTen == 6 || iTen == 9){
							System.out.printf("%s ", "짝");	

						} else if (iTen == 0){
							if (i == 0) {continue;}
							else { System.out.printf("%d ", i); }

						} else {
							System.out.printf("%d%d ", iTen, i);
						}
					}
				}
			}
		}

		//i/10%10 일의 자리가 3,6,9면 if i%10 십의 자리가 
	} //q7()


	public static void q8() {
		for (int i = 1; i <= 5; i++) {
			for (int j = 0; j < (5 - i); j++) {
				System.out.print(" ");
			}
			for (int k = 0; k < i; k++) {
				System.out.print("*");
			}
			System.out.println();
		}
	} //q8()

	public static void q9() {
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < i; j++) {
				System.out.print(" ");
			}
			for (int k = 0; k < 9 - (i*2); k++) {
				System.out.print("*");
			}
			System.out.println();
		}
	} //q9()

	public static void q10() {
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < i; j++) {
				System.out.print(" ");
			}
			System.out.println("*");
		}
	} //q10()

	public static void q11() {
		for (int i = 0; i < 7; i++) {

			if (i < 3) {

				for (int j = 0; j <= i; j++) {
					System.out.print("*");
				}
				System.out.println();

			} else if (i == 3) {

				for (int j = 0; j < 7; j++) {
					System.out.print("*");
				}
				System.out.println();

			} else {

				for (int j = 0; j < i; j++) {
					System.out.print(" ");
				}
				for (int k = 0; k < 7 - i; k++) {
					System.out.print("*");
				}
				System.out.println();
			}
		}	
	} //q11()

	public static void q12() {
		int a = 0;

		for (int i = 1; i <= 5; i++) {
			//a로 초기화
			a = 97;
			
			//공백
			for (int j = 0; j < (5 - i); j++) {
				System.out.print(" ");
			}
			
			//정순
			for (int k = 0; k < i; k++) {
				System.out.printf("%c", (char)a);
				++a;
			}
			//역순
			for (int f = 0; f < i; f++) {
				--a;
				System.out.printf("%c", (char)a);
			}
			System.out.println();
		}
	} //q12()

	public static void q13() {
		for (int i = 2; i < 10; i++) {
			if (i == 2) {
				for (int j = 1; j <= 9; j++) {
					
					System.out.printf("%d x %d = %d\t", i, j, (i * j));
	
				}
				System.out.println();
			
			} else if (i == 6) {
				
			} else return;
		}

	}

	public static void q14() {

		int sum = 0;

		for (int i = 10; i <= 100; i += 10) {
			for (int j = 1; j <= i; j++) {
				sum += j;
			}
			System.out.printf("1 ~ %d : %d\n", i, sum);
		}
		System.out.println();
		
		sum = 0;

		for (int i = 0; i <= 90; i += 10) {
			for (int j = 1; j <= 10; j++) {
				sum = sum + i + j;
			}
			System.out.printf("%d ~ %d : %d\n", i + 1, i + 10, sum);
			sum = 0;
		}
		System.out.println();
	} //q14()

	public static void q15() {
		int num = 1;
		int sum = 0;

		for (int i = 0; ; i++) {
			num += i;

			if (num > 100) 
				break;
			
			System.out.printf("%d + ", num);
			sum += num;
		}
		System.out.printf("\b\b= %d", sum);
	} //q15()

	public static void q16() {
		
		int x = 1;
		int y = 1;
		int z = 1;
		int sum = 2;
		
		System.out.printf("%d + ", x);
		for(;;y = z) {
			z = x + y;
			x = y;

			if (x > 100)
				break;

			System.out.printf("%d + ", x);
			sum += z;
		}
		System.out.printf("\b\b= %d\n", sum);
	}
}
 //String.Valueof(숫자값)