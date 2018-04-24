  class Homework9_8
{
	public static void main(String[] args) 
	{
	/*	  
	문제8.
	요구사항] 별찍기 -> (" ")

		   *
		  **
		 ***
		****
	   *****
	*/
	m1();
	//m2();
	//m3();
	//m4();
	//m5();
	//m6();


	}
	public static void m1() {

	for (int i=1; i<=6; i++) { //행
			for (int j=6; j>0; j--) { //셀
				System.out.print(j>i ? " " : "*");
			}
			System.out.println();
		}
	}

	public static void m2() {
/*
문제9.
요구사항] 별찍기

*********
 *******
  *****
   ***
    *
*/

	for (int i=0; i<9; i++) { //행
			for (int j=0; j<(9-(2*i)); j++) { //셀
				System.out.print("*");
			}
			System.out.println();
		}
 	}
	public static void m3 () {
		/*
		문제10.
요구사항] 별찍기
*
 *
  *
   *
    *
		*/

		
	}
/*	문제12.
요구사항] 아래와 같이 출력하시오.
    aa
   abba
  abccba
 abcddbca
abcdeedcba
*/
	public static void m4() {
		 
		 char a = 'a';
		 for (int i=1; i<6; i++) {
			 a = 'a';
			 for (int j=6; j>1; j--) {
				 System.out.print(a++);
			 }
		 }
		 System.out.println();

	}

	public static void m5() {
/*		
문제13.
요구사항] 구구단을 출력하시오.
힌트] 2중 for문 x 2번, 3중 for문 x 1번

2 x 1 = 2  3 x 1 = 3  4 x 1 = 4  5 x 1 = 5
2 x 2 = 4
2 x 3 = 6
..
2 x 9 = 18                       5 x 9 = 45

6 x 1 = 6                        9 x 1 = 9
..
6 x 9 = 54			             9 x 9 = 81
*/
		int i,j;

		for (i=2; i<=9; i++) {
			
			System.out.println();
		
		for (j=1; j<9; j++) {
			System.out.println(i + " x " + j + " = " + i*j);
		}
		System.out.println();

		}
		/*
		문제17.
요구사항] 2부터 100사이의 소수를 구하시오.
출력] 2, 3, 5, 7, 11, 13...
힌트] 소스 : 1과 자기자신으로밖에 나눠지지 않는 수
		*/


	//public static void m6() {

	}
   
   
  }







