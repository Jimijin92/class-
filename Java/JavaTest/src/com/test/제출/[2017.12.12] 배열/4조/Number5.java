
public class Number5 {

	public static void main(String[] args) {
	
		/*
		문제5.

		요구사항] 아래와 같이 출력하시오.

		0	0	1	0	0				
		0	2	3	4	0				
		5	6	7	8	9						
		0	10	11	12	0				
		0	0	13	0	0				
		
		
		
		
		0		0		(0,2)	0		0
		0		(1,1)	(1,2)	(1,3)	0
		(2,0)	(2,1)	(2,2)	(2,3)	(2,4)
		0		(3,1)	(3,2)	(3,3)	0 
		0		0		(4,2)	0		0
		*/
		
		
		int[][] nums = new int[5][5];
		
		int n = 1;
		
		
		for (int i=0; i<5 ; i++) {
			if (i<=2) {
				for (int j=2-i; j<=i+2; j++) {
					nums[i][j] = n;
					n++;

				}		
			} else if (i>2) {
				for (int j=i-2; j<7-i; j++) {
					nums[i][j] = n;
					n++;
				}
			}
		}
		
		
		//출력
		for (int i=0; i<5; i++) {
			for (int j=0; j<5; j++) {
				System.out.printf("%4d", nums[i][j]);
			}
			System.out.println();
		}
		

		
	}
}
