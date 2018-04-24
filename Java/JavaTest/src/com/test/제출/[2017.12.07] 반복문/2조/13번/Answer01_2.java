import java.io.*;



class Answer01_2 {

	public static void main(String[] args)  {	
	
		

	
		forQna13();    
	

	}
	//main method



/*
문제13.
요구사항]구구단을 출력하시오.
2~9단까지
출력]
2중 for문 x 2번 / 3중 for문 x 1번

2 3 4 5 단

6 7 8 9 단형식으로 만들기
*/

	public static void forQna13() {
		
		System.out.println(" < 2 단 >\t < 3 단 >\t < 4 단 >\t < 5 단 >");
	

		//2~5단
		for (int i=1; i<=9; i++) {						//행
			for (int j=2; j<6; j++){					//열
				System.out.printf("%d x %d = %2d\t"  //우측정렬, 간격조절
								  , j,  i,	j*i); 
			}
			System.out.println();
		}


		System.out.println();							//위아래 구분


		//6~9단
		System.out.println(" < 6 단 >\t < 7 단 >\t < 8 단 >\t < 9 단 >");

		for (int i=1; i<=9; i++) {
			for (int j=6; j<10; j++){
				System.out.printf("%d x %d = %2d\t" 
								  , j,  i,	j*i); 
			}
			System.out.println();
		}
	}


	










}