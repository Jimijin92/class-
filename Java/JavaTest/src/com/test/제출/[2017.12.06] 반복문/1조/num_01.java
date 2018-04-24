import java.io.*;

class  num_01{

	public static void main(String[] args) throws Exception{
	


 num();


	}//main

/*
문제2.
요구사항] 숫자 1개를 입력받아 1부터 ~ 입력 숫자까지의 합을 출력하시오.
입력] 숫자 : 5
출력] 1 ~ 5 : 15
조건] 천단위 출력 ,
*/
			
		public static void num()throws Exception{

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
			System.out.print("숫자 : ");
				int num = Integer.parseInt(reader.readLine());

				int sum = 0;

				for (int i=1; i<=num; i++){
					
					sum += i; 
				}
				System.out.printf("1 ~ %d : %,d \n", num, sum);

				}
	

		     
		

}
