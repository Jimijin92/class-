package javaTest;

public class Ex29_test2 {

	public static void main(String[] args) {
		//test1();
		//test2();
		//test3();
		//test4();
		test5();
		//test6();
		//test7();
		//test8();
		//test9();
		//test10();
		//test11();
		//test12();
		
		
		
	}

	

	private static void test3() {
	/*	문제3.
		요구] 아래와 같이 출력하시오.

		1(0,0)  6(0,1)  11(0,2)  16(0,3)  21(0,4)
		2(1,0)  7  12  17  22	
		3(2,0)  8  13  18  23
		4(3,0)  9  14  19  24
		5(4,0) 10  15  20  25 */
		
		
		int[][] nums = new int[5][5];
		int n = 1;
		
		for(int i=0; i<5; i++) {
			for(int j=0; j<5; j++) {
				nums[j][i] = n;
				n++;
			}
			
		}
		for(int i=0; i<5; i++) {
			for(int j=0; j<nums.length; j++) {
				System.out.printf("%4d", nums[i][j]);
			}
		System.out.println();
		}
		
		
	}

	private static void test2() {

		
		
		int[][] nums = new int[5][5];
		int n = 1;
		
		for(int i=0; i<5; i++) {
			for(int j=0; j<nums.length; j--) {
				nums[i][j] = n;
				n++;
			}
			
		}
		for(int i=0; i<5; i++) {
			for(int j=0; j<nums.length; j++) {
				System.out.printf("%4d", nums[i][j]);
			}
		System.out.println();
		}
		
		
		
	}

	private static void test1() {
		/*문제1.
		요구] 아래와 같이 출력하시오.

		1  2  3  4  5
		10 9  8  7  6
		11 12 13 14 15
		20 19 18 17 16
		21 22 23 24 25 */
		
		int[][] nums = new int[5][5];
		int n = 1;
		
		for(int i=0; i<5; i++) {
			if(i%2 == 0) {
			for(int j=0; j<5; j++) {
				nums[i][j] = n;
				n++;
		 		}
			
			}
			else {
				for(int j=4; j>=0; j--) {
					nums[i][j] = n;
					n++;
				}
					
			}
		}
		for(int i=0; i<5; i++) {
			for(int j=0; j<nums.length; j++) {
				System.out.printf("%4d", nums[i][j]);
			}
		System.out.println();
		}
		
		
		
		
		
		
		
	}

	private static void test4() {

	/*	요구]아래와 같이 출력하시오.

		1  2  3  4  5
		6  7  8  9  0
		10 11 12 0  0
		13 14 0  0  0
		15 0  0  0  0*/
		
		int[][] nums = new int[5][5];
		int n = 1;
		
		for(int i=0; i<5; i++) {
			for(int j=0; j<5-i; j++) {
				nums[i][j] = n;
				n++;
			}
			
		}
		for(int i=0; i<5; i++) {
			for(int j=0; j<nums.length; j++) {
				System.out.printf("%4d", nums[i][j]);
			}
		System.out.println();
		}
		
	}

	private static void test5() {

		int[][] nums = new int[5][5];
		int n = 1;
		
		for(int i=0; i<5; i++) {
			for(int j=0; j<5-i; j++) {
				nums[i][j] = n;
				n++;
			}
			
		}
		for(int i=0; i<5; i++) {
			for(int j=0; j<nums.length; j++) {
				System.out.printf("%4d", nums[i][j]);
			}
		System.out.println();
		}
		
		
		
		
		
	}

	private static void test6() {
		// TODO Auto-generated method stub
		
	}

	private static void test7() {
		// TODO Auto-generated method stub
		
	}

	private static void test8() {
		// TODO Auto-generated method stub
		
	}

	private static void test9() {
		// TODO Auto-generated method stub
		
	}

	private static void test10() {
		// TODO Auto-generated method stub
		
	}
	
	private static void test12() {
		// TODO Auto-generated method stub
		
	}

	private static void test11() {
		// TODO Auto-generated method stub
		
	}
	
	

}
