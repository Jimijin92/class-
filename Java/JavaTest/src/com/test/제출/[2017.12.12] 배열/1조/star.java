class star
{
	public static void main(String[] args) 
	{
		
		
	//m1();	
	m2();
		
	

	
	

	}//메인

	private static void m2() {
		int n = 1;
		int[][] nums = new int[5][5]; 
		
		
		
		
		for(int i =0; i<5; i++) {
				
			
			for(int j=0; j<5-i; j++) {
				nums[i][j]= n;
				n++;			
			}
			System.out.println();
			
		}
		
		
		
		
		System.out.println();
		
		
		for(int i=0; i<5; i++) {
			for (int j=0; j<5; j++) {
				
				System.out.printf("%4d",nums[i][j]);
				
			}System.out.println();
		}
		
		
	

			
				
	}
		


	private static void m1() {
		int[][] nums = new int[5][5]; 
		
		for(int i=0; i<5; i++) {
			int n = 1;
			
			if(i%2 == 0) {
				for(int j=0; i<5; i++) {
					nums[i][j] = n;
					n++;
				}
			} else {
				for(int j=4; j>=0; j--) {
						nums[i][j]= n;
						n++;
				}
			 
			}
			
		}
		for(int i=0; i<5; i++) {
			for(int j=0; j<5; j++) {
				System.out.printf("%4d",nums[i][j]);
			}System.out.println();
		}
		
		
	}
}

	
