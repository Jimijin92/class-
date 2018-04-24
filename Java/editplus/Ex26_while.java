class Ex26_while {

	public static void main(String[] args) {

		//Ex26_while.java

		//반복문
	    // - for
		// - while
		// - do while


		//while(do while) 예제/문제 -> for문 같이

		/*
		
			while (조건식){
				실행코드;
			}
		
		*/
		//요구사항] 1~10까지 출력하시오.
		
		int num = 1; //초기식

		while (num <= 10){ //조건식
		
			System.out.println(num);
			num++; //증감식
		
		}

		//요구사항] 구구단 출력
		
		int m = 2;
		while (m < 10) {
			
			int n = 1;
			while (n < 10){
				System.out.printf("%d x %d = %d\n", m, n, m*n);
				n++;
			}//while
			m++;
		}//while

		
		//do while 문
		// - 선실행 후조건
		// - 만족을 못하더라도 1회는 실행함
		
		/*

		while (조건식)
		{

		}

		do {

		} while (조건식);
		
		*/
		
		num = 100;

		do{
			System.out.println(num);
			num++;
		}while(num <= 10);

	}//main method
}//class









		