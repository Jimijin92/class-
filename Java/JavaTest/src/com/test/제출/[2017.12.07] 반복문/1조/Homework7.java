class Homework7 {

	public static void main(String[] args) {
		/*
문제8.

요구사항) 별 찍기

    *
   **
  ***
 ****
*****
		*/
		//starStairs();
		
		
		
		/*


문제9.

요구사항) 별 찍기

*********
 *******
  *****
   ***
    *
  */
	//	triStar();
  /*

문제10.

요구사항) 별 찍기

*
 *
  *
   *
    *



문제11.
요구사항) 별 찍기

*
**
***
*******
    ***
     **
      *
     

문제12.

요구사항) 아래와 같이 출력하시오.
    
    aa
   abba
  abccba
 abcddcba
abcdeedcba



문제13.

요구사항) 구구단을 출력하시오.
힌트) 2중 for문 x 2번 
      3중 for문 1번


2 x 1 = 2	3 x 1 = 3	4 x 1 = 4	5 x 1 = 5
2 x 2 = 4	3 x 2 = 6
2 x 3 = 6	3 x 3 = 9
..		..
2 x 9 = 18	3 x 9 = 27



문제14.

요구사항) 아래와 같이 출력하시오.
사용) 2중 for문 x 1번, 1중 for문 x 1번



1 ~ 10 : 55
1 ~ 20 : XXX
1 ~ 30 : XXX
1 ~ 40 : XXX
..
1 ~ 100 : 5050


1 ~ 10 : 55
11 ~ 20 : 
21 ~ 30 :
..
91 ~ 100 :



문제15.

요구사항) 아래와 같이 출력하시오.

 1 + 2 + 4 + 7 + 11 + 16 + ... + n = 469
// 1   2   3   4    5
조건) 더하는 N이 100을 넘지 않을때까지..



문제16.

요구사항) 아래와 같이 출력하시오.

1 + 1 + 2 + 3 + 5 + 8 + 13 + 21 + 34 + 55 + 89 = 232 

조건) 더하는 n이 100을 넘지 않을때 까지..


*/

/*
문제17.

요구사항) 2부터 100사이의 소수를 구하시오.
출력) 2, 3, 5, 7, 11, 13 ....
힌트) 소수 : 1과 자기자신으로밖에 나눠지지않는 수


*/

	
	getPrimeNum();


/*
문제18.

요구사항) 1부터 100사이의 완전수를 구하시오.
출력)

6 = [1, 2, 3, 6]
28 = [1, 2, 4, 7, 14, 28]

힌트) 완전수 : 자기자신을 제외한 나머지 약수들의 합이 자신과 동일한 수 

		*/


} // main()


	public static void triStar() {
		for (int i = 0; i < 9; i += 2)
		{
			for (int j = 0; j < (i / 2); j++)
			{
				System.out.print(" ");
			}
			for (int k = 0; k < (9 - i); k++)
			{
				System.out.print("*");
			}
		
			System.out.println();
		} // for
	
	} // triStar()


	public static void starStairs() {
		for (int i = 0; i < 5; i++)
		{
			for (int j = 0; j < (4 - i); j++)
			{
				System.out.print(" ");
			}
			for (int k = 1; k <= (1 + i); k++)
			{	
				System.out.print("*");
			}
			System.out.println();
		} // for
		
	} // starStairs()


	public static void getPrimeNum() {
	/*
	문제17.

	요구사항) 2부터 100사이의 소수를 구하시오.
	출력) 2, 3, 5, 7, 11, 13 ....
	힌트) 소수 : 1과 자기자신으로밖에 나눠지지않는 수
	*/

		int numCount = 0;

	// 2 부터 100 사이
		for (int i = 2; i <= 100; i++)
		{		// j를 i로 초기화하고 1씩 감소시켜 나머지를 구한다.
			for (int j = i; j > 0 ; j--)
			{	// i와 j를 나눠 나머지가 0 일경우 카운트에 1 을 추가한다.
				if (i % j == 0)
				{
					numCount++;
				
				}

			}
			// 소수는 1과 자기자신으로밖에 나누어 지지 않으므로 총 약수는 무조건 2개이다.
			if (numCount == 2)
			{
				System.out.printf("%d ", i);
			
			}	

			// 새로운 값을 계산하기 위해 카운트를 0 으로 다시 초기화 시킨다.
			numCount = 0;

		} // for

	} // getPrimeNum()

} // class
