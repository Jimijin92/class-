import java.util.Calendar;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

class test {
	
	public static void main(String[] args) throws Exception{

    

		//m1();
		//m2();
		m14();
		//m14m();
		//m15();

	}//main

//=======================================================================================		

/*문제8.
요구사항] 별찍기 -> (" ") (space사용한거)

	*
   **
  ***	
 ****
*****
*/

	public static void m1(){
	
		for (int i=0; i<5; i++){
			
			for(int j=0; j<(4-i); j++){
				System.out.print(" ");
            }
			for(int j=0; j<(i+1); j++){
				System.out.print("*");
			}
				System.out.println();
		}

	}
	//m15()






	/*
문제9.
요구사항] 별찍기

*********
 *******
  *****
   ***
    *
*/

	public static void m2(){
	
		for (int i=0; i<5; i++){
			
			for(int k=0; k<=i; k++){
				System.out.print(" ");
            }

			for(int j=0; j<(9-(2*i)); j++){
				System.out.print("*");
			}

				System.out.println();
		}

	}

/*

문제10.
요구사항] 별찍기
*
 *
  *
   *
    *
*/



/*
	public static void m2(){
	
		for (int i=0; i<5; i++){
			
			for(int k=0; k<=i; k++){
				System.out.print(" ");
            }

			for(int j=0; j<(9-(2*i)); j++){
				System.out.print("*");
			}

				System.out.println();
		}

	}

*/



/*


문제11.
요구사항] 별찍기
*
**
***
*******
	***
	 **
	  *

문제12. 난이도***
요구사항] 아래와 같이 출력하시오.

	aa
   abba
  abccba
 abcddbca
abcdeedcba


문제13.
요구사항] 구구단을 출력하시오.
힌트] 2중 for문 x 2 or 3중 for문 x 1번

2 x 1 = 2	2 x 1 = 2	2 x 1 = 2	5 x 1 = 2  
2 x 2 = 2							5 x 2 = 10
2 x 3 = 2							5 x 3 = 15
2 x 4 = 2
..
2 x 9 = 18							5 x 9 = 2

6 x 1 = 6							2 x 1 = 2
6 x 1 = 12							2 x 1 = 2
6 x 1 = 18							2 x 1 = 2


*/

/*
문제14-1.
요구사항] 아래와 같이 출력하시오.
사용] 2중 for문 x 1번, 1중 for문 x 1번


1 ~ 10 :  55
1 ~ 20 : XXX
1 ~ 30 : XXX
1 ~ 40 : XXX
1 ~ 50 : XXX
...
1 ~ 100 : 5050

*/

	public static void m14(){
	
		int plus = 0;
			  
		for (int i=1; i<=10; i++){

			for(int j=1; j<=(i*10); j++){
		        plus += j;
			}
				System.out.printf("1 ~ %d : %d\n", (i*10) , plus);
				plus = 0;

		}
		
	}
/*
문제14-2.

1 ~ 10 :  55
11 ~ 20 : XXX
21 ~ 30 : XXX

...
91 ~ 100 : XXX

*/

	public static void m14m(){
	
		int plus = 0;
			  
		for (int i=1; i<=10; i++){

			for(int j=(i*10)-9; j<=(i*10); j++){
		        plus += j;
			}

 
				System.out.printf("%d ~ %d : %d\n", (i*10)-9, (i*10) , plus);
				
				plus = 0;
				
		}
		
	}//m14
	





/*

문제15.   4조거 참고
요구사항] 아래와 같이 출력하시오.

1 + 2 + 4 + 7 + 11 + 16 + .... + N = 469
조건] 더하는 N이 100을 넘지 않을 때까지...


*/

/*
	public static void m15(){
	
		int plus = 0;
		int sum =0;
			  
		for (int i=0; ; i++){
			
			for(int j=1; j = i+1 ; j++){
			sum += (plus += j);  
			}

			for(int j=1; j = i-1 ; j++){
			sum = plus + i;   
			}
		
        someNew = (plus += j) + sum;
		

		}

		System.out.print(someNew);
	}

*/

/*


문제16. 난이도 **** 4조
요구사항] 아래와 같이 출력하시오

1 + 1 + 2 + 3 + 5 + 8 + 13 + 21 + 34 + 55 + 89 = 232

조건] 더하는 N이 100을 넘지 않을 때까지...



문제17. 1조
요구사항] 2부터 100사이의 소수를 구하시오.
출력] 2, 3, 5, 7, 11, 13.....
힌트] 소수 : 1과 자기자신으로밖에 나눠지지 않는 수 


문제18.준필님거 
요구사항] 1부터 100사이의 완전수를 구하시오.
출력] 

6 = [1, 2, 3, 6]
28 = [1,2,4,7,14,28]

힌트] 완전수 : 자기 자신을 제외한 나머지 약수들의 합이 자신과 동일한 수



*/
	
}
