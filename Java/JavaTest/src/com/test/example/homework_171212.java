package com.test.example;
import java.util.Random;
import java.util.Scanner;

public class homework_171212 {

	public static void main (String[]args)	{
	
		//m1();
		//m2();
		//m3();
		//m4();
		//m5();
		m6();
		//m12();//다시
		
		
		
	}//main
	
	private static void m6() {
		
	/*문제6.
	 요구사항] 아래와 같이 출력하시오.
	
	1	2	4	7	11
	3	5	8	12	16
	6	9	13	17	20
	10	14	18	21	23	
	15	19	22	24	25
    */
		
		

		
		
	}

	private static void m5() {
		/*문제5.
		요구사항] 아래와 같이 출력하시오. 홀수로

		0	0	1	0	0
		0	2	3	4	0
		5	6	7	8	9
		0	10	11	12	0
		0	0	13	0	0*/
		
		int totalnum = 5;
		int[][] nums = new int[totalnum][totalnum];
		
		int n = 1;
		int a = nums.length;
		int b = nums[0].length;
		
		int sa = a/2;
		
		
		//배열 초기화
				for (int i=0; i<a; i++) {		
					if(i<=sa) {
						for(int j=sa-i; j<b-(sa-i); j++) {
							nums[i][j] = n;
							n++;	
						}

					}else {
						for(int j=i-sa; j<b-(i-sa); j++ ) {
							nums[i][j] = n;
							n++;
						}
						
					}
				}
				
				//출력용(수정 금지)
				
						for (int i=0; i<a; i++) {
							for(int j=0; j<a; j++) {
								System.out.printf("%4d", nums[i][j]);
							}
							System.out.println();
						}
		
		
		
		
		
		
		
	}

	private static void m4() {
		/*문제4.
		요구사항] 아래와 같이 출력하시오.
		참고] 0은 지정한 숫자가 아닌 원래 들어있는 숫자

		1	2	3	4	5
		6	7	8	9	0
		10	11	12	0	0	
		13	14	0	0	0	
		15	0	0	0	0*/
		
		int totalnum = 5;
		
		int[][] nums = new int[totalnum][totalnum];
		int n = 1;
		int a = nums.length;
		int b = nums[0].length;
		
		
		//배열 초기화
				for (int i=0; i<nums.length; i++) {		
					
					for(int j=0; j<b-i; j++) {
					nums[i][j] = n;
					n++;	
					}
					
				}
				
				//출력용(수정 금지)
				
						for (int i=0; i<5; i++) {
							for(int j=0; j<5; j++) {
								System.out.printf("%4d", nums[i][j]);
							}
							System.out.println();
						}
		
		
	}//m4

	//private static void m12() //{
		/*문제 12.
		요구사항] 숫자 N개를 입력받아 순차적으로 출력하시오.
		입력] 총 몇개의 숫자를 입력받겠습니까? 5
			  숫자 : 5
			  숫자 : 3
			  숫자 : 10
			  숫자 : 8
			  숫자 : 1
		출력] 10 > 8 > 5 > 3 > 1
		사용] 1차원 배열(N칸)
		조건] 중복 입력 받지 않기
		추후] -> 정렬 알고리즘*/
		
		/*Scanner scan = new Scanner(System.in);
		
		int[] nums = new int[5];
		int n = 1;
		
		System.out.print("총 몇개의 숫자를 입력받겠습니까?");
		int Q = Integer.parseInt(scan.nextLine());
		
		
		for(int i=0; i<5; i++) {
			System.out.print("숫자 : ");
			int num = Integer.parseInt(scan.nextLine());
			nums[i]= num;
			
			if(i>=1) {
		       // for(i=1; i; i++){
					if(nums[i] <= nums[i-1]) {
						nums[i] = nums[i-1];
						nums[i-1] = nums[i];
					} else {*/
/*						nums[i] = nums[i];
					}
	
		        }*/
/*			}
		}
		
		for (int i=0; i<5; i++) {
			System.out.printf("%d", nums[i]);
		}
			
		
		
		
		
		
	}
*/

	private static void m3() {
		/*문제3.
		요구사항] 아래와 같이 출력하시오.

		1	6	11	16	21
		2	7	12	17	22
		3	8	13	18	23	
		4	9	14	19	24
		5	10	15	20	25*/
		
		int[][] nums = new int[5][5];
		int n = 1;
	
		//배열 초기화
				for (int j=0; j<5; j++) {					
					for(int i=0; i<5; i++) {
					nums[i][j] = n;
					n++;
					}
				}
				
		//출력용(수정 금지)
				
				for (int i=0; i<5; i++) {
					for(int j=0; j<5; j++) {
						System.out.printf("%4d", nums[i][j]);
					}
					System.out.println();
				}
		
	}//m3

	private static void m2() {
		
		/*문제 2.
		요구사항]아래와 같이 출력하시오

		25	24	23	22	21
		20	19	18	17	16
		15	14	13	12	11	
		10	9	8	7	6	
		5	4	3	2	1*/
		
		int[][] nums = new int[5][5];
		int n = 1;
	
		//배열 초기화
				for (int i=4; i>=0; i--) {					
					for(int j=4; j>=0; j--) {
					nums[i][j] = n;
					n++;
					}
				}
				
				//출력용(수정 금지)
				
						for (int i=0; i<5; i++) {
							for(int j=0; j<5; j++) {
								System.out.printf("%4d", nums[i][j]);
							}
							System.out.println();
						}
		
		
	}//m2

	

	private static void m1() {
		
		/*문제 1.
		요구사항]아래와 같이 출력하시오
	
		1	2	3	4	5
		10	9	8	7	6	
		11	12	13	14	15	
		20	19	18	17	16
		21	22	23	24	25
	
		0,0
		0,1
		0,2
		0,3
		0,4
		1,4
		1,3
		1,2
		1,1
		1,0
		*/
	
		int[][] nums = new int[5][5];
		int n = 1;
	
		
		//배열 초기화
		for (int i=0; i<5; i++) {
			
		
				if(i%2==0) {
					for(int j=0; j<5; j++) {
					nums[i][j] = n;
					n++;
					}
				} else {
					for(int j=4; j>=0; j--) {
						nums[i][j] = n;
						n++;
					}
				}

		}
		
		//출력용(수정 금지)
		
				for (int i=0; i<5; i++) {
					for(int j=0; j<5; j++) {
						System.out.printf("%4d", nums[i][j]);
					}
					System.out.println();
				}
	}//m1

	
	
	
	
	


}//class
