
public class HomeArray2 {
	public static void main(String[] args) {
	
		
		q6();
}// main
	
	/*
	 * 문제6.

		요구사항] 아래와 같이 출력하시오.
		
		1	2	4	7  	11
		3	5	8 	12 	16
		6	9	13	17 	20
		10 	14	18  21 	23
		15	19	22  24 	25

	 */
	
	public static void q6() {
		
		int [][] nums6 = new int [5][5];
		int n = 0;
		
		for(int i =0 ; i< 9; i++) {   //대각선 9번
			for(int x =0; x <nums6.length; x++) {   // length 5번 5x5
				//System.out.print("hello");
				
				
				/*   00 01 02 03 04 
				 *   10 11 12 13 14 
				 *   20 21 22 23 24 
				 *   30 31 32 33 34 
				 *   40 41 42 43 44 
				 * 
				 */
				
				
				
				
				int j = i-x; // 열      
				//System.out.print(j); //  j 0  10  210  3210  43210  4321 432 43  4
				if( j >=0 && j < 5) {   
					
					n = n +1;
					nums6[x][j] = n;
					
				}
				
				
			}
			
			//System.out.println();
		}  //for
		
		
		//출력//
		
		for(int i=0; i < 5; i++) {  //5 nums6.length
			for(int j = 0; j < 5;j++) {    ///5/// nums6[i].length
				System.out.print(nums6[i][j] + "\t");
				
			}
			
			System.out.println();
		}
		
		
		
		
	} //문제 6//
	
	
} //class
