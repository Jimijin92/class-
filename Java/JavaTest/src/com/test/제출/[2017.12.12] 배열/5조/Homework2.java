import java.rmi.server.SocketSecurityException;
import java.util.Random;

public class Homework2 {
	public static void main(String[] args) {
		
		//q1();
		//q2();
		//q3();
		//q4();
		//q5();
		//q6();
		q10();
		
	}//main
	
	public static void q1(){
		
		/*
		문제1.

		요구사항] 아래와 같이 출력하시오.

		1	2	3	4	5
		10	9	8	7	6
		11	12	13	14	15
		20	19	18	17	16
		21	22	23	24	25
		*/
		
		int[][] nums = new int [5][5];
		int n = 1;
		
		for(int i =0;i<nums.length;i++) {
			if(i%2==0) {
				for(int j=0;j<nums.length;j++) {
					nums[i][j] = n;
					n++;
				}
			}else {
				for(int j=nums.length-1;j>=0;j--) {
					nums[i][j] = n;
					n++;
				}
			}
		}
		
		for(int i =0;i<nums.length;i++) {
			for(int j=0;j<nums.length;j++) {
				System.out.printf("%4d",nums[i][j]);
			}
			System.out.println();
		}

	}//q1
	
	public static void q2(){
		
		/*
		문제2.

		요구사항] 아래와 같이 출력하시오.

		25	24	23	22	21
		20	19	18	17	16
		15	14	13	12	11
		10	9	8	7	6
		5	4	3	2	1
		*/
		
		int[][] nums = new int [5][5];
		int n = 1;
		
		for(int i =nums.length-1;i>=0;i--) {
			for(int j=nums.length-1;j>=0;j--) {
				nums[i][j] = n;
				n++;
			}
		}
		for(int i =0;i<nums.length;i++) {
			for(int j=0;j<nums.length;j++) {
				System.out.printf("%4d",nums[i][j]);
			}
			System.out.println();
		}
	}//q2
	
	public static void q3(){
		/*
		문제3.

		요구사항] 아래와 같이 출력하시오.


		1	6	11	16	21
		2	7	12	17	22
		3	8	13	18	23
		4	9	14	19	24
		5	10	15	20	25
		*/
		
		int[][] nums = new int [5][5];
		int n = 1;
		
		for(int i=0;i<nums.length;i++) {
			for(int j=0;j<nums.length;j++) {
				nums[j][i] = n;
				n++;
			}
		}
		for(int i =0;i<nums.length;i++) {
			for(int j=0;j<nums.length;j++) {
				System.out.printf("%4d",nums[i][j]);
			}
			System.out.println();
		}
		
	}//p3
	
	public static void q4(){
		/*
		문제4.

		요구사항] 아래와 같이 출력하시오.

		1	2	3	4	5
		6	7	8	9	0
		10	11	12	0	0
		13	14	0	0	0
		15	0	0	0	0
		*/
		
		int[][] nums = new int [5][5];
		int n = 1;
		
		for(int i =0;i<nums.length;i++) {
			for(int j=0;j<nums.length-i;j++) {
				nums[i][j] = n;
				n++;
			}

		}
		
		for(int i =0;i<nums.length;i++) {
			for(int j=0;j<nums.length;j++) {
				System.out.printf("%4d",nums[i][j]);
			}
			System.out.println();
		}

	}//q4()
	
	public static void q5(){
		/*
		문제5.

		요구사항] 아래와 같이 출력하시오.
		0	1	2	3	4
		
	0	0	0	1	0	0
	1	0	2	3	4	0
	2	5	6	7	8	9
	3	0	10	11	12	0
	4	0	0	13	0	0
		*/
		//2~3   1~4   0~5
		int[][] nums = new int [5][5];
		int n = 1;
		
		for(int i =0;i<nums.length;i++) {
			if(i<3) {
				for(int j=2-i;j<3+i;j++) {
					nums[i][j] = n;
					n++;
				}
			}else{
				for(int j=i-2;j<7-i;j++) {
					nums[i][j] = n;
					n++;
				}
			}

		}
		
		for(int i =0;i<nums.length;i++) {
			for(int j=0;j<nums.length;j++) {
				System.out.printf("%4d",nums[i][j]);
			}
			System.out.println();
		}
		
	}//q5
	
	public static void q6(){
		/*
		문제 6.

		요구사항] 아래와 같이 출력하시오.
		0	1	2	3	4			1		2			3				4
									0,0    0,1  1,0    0,2  1,1  2,0    0,3  1,2  2,1  3,0
	0	1	2	4	7	11
	1	3	5	8	12	16
	2	6	9	13	17	20
	3	10	14	18	21	23
	4	15	19	22	24	25
		*/
		
		int[][] nums = new int [5][5];
		int n = 1;
		
		for(int i =0;i<nums.length;i++) {
			i = 0;
			for(int j=i+1;j>i-1;j--) {
				nums[i][j] = n;
				n++;
				i++;
			}
		}
		for(int i =0;i<nums.length;i++) {
			for(int j=0;j<nums.length;j++) {
				System.out.printf("%4d",nums[i][j]);
			}
			System.out.println();
		}
		
	}//q6
	
	public static void q10(){
		/*
		문제10.

		요구사항] 임의의 숫자 5개를 만드시오.
		출력] [5,6,1,3,2]
		조건]a. 숫자 범위 : 1~9
			 b. 중복값 배제
		사용] 1차원 배열 사용(5칸)
		추가] 로또 번호 생성기
		 */
		
		Random rnd = new Random();
		int count = 5;
		int[] nums = new int[count];
		boolean result = true;
		
		for(int i=0;i<count;i++) {
			int a = rnd.nextInt(9)+1; //난수
			for(int j=0;j<i;j++) { //중복검사
				if(nums[j]==a){
					result = false;					
					break;
				}
			}
			if(result) {
				nums[i]=a;
				
			}else {
				result = true;
				i--;
			}
		}
		System.out.print("출력] [");
		for(int i=0;i<count;i++) {
			System.out.printf("%d ",nums[i]);
		}
		System.out.print("]");
	}//q10	

	
}

























