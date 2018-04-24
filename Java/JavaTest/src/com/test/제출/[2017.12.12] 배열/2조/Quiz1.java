import java.util.Scanner;

public class Quiz1 {
	
	public static void main(String[] args) {
		
		
		/*	문제1.

		요구사항] 아래와 같이 출력하시오.

		1	2	3	4	5
		10	9	8	7	6
		11	12	13	14	15
		20	19	18	17	16
		21	22	23	24	25 */
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("총 몇 행을 입력하시겠습니까? (행과 열 동일, 홀수만) : ");
		int totalNum = scan.nextInt();
		
		
		int[][] nums = new int[totalNum][totalNum];  //배열 선언
		
		int n = 1; //데이터 
		
		//배열 초기화
		for (int i = 0; i<nums.length; i++) { //행 
			
			if (i%2==0) { //짝수행 
				
				for(int j=0; j<nums[0].length; j++) { //열
					
					nums[i][j] = n;
					n++;
						
					
				}
				
				
				
			} else { //홀수행 
				
				
				for (int j=nums[0].length-1; j>=0; j--) { //열

					nums[i][j] = n;
					n++;
					
				
				
				
			}
			
			
			
			}	
		} 
		
		
		//출력
		for (int i = 0; i<nums.length; i++) {
			
			for (int j=0; j<nums[0].length; j++) {
				
				System.out.printf("%4d", nums[i][j]);
				
				
			}
			
			System.out.println();
		}
		
		
		
		
		
	}//main
	

}//class
