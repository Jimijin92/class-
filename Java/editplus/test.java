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

/*����8.
�䱸����] ����� -> (" ") (space����Ѱ�)

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
����9.
�䱸����] �����

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

����10.
�䱸����] �����
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


����11.
�䱸����] �����
*
**
***
*******
	***
	 **
	  *

����12. ���̵�***
�䱸����] �Ʒ��� ���� ����Ͻÿ�.

	aa
   abba
  abccba
 abcddbca
abcdeedcba


����13.
�䱸����] �������� ����Ͻÿ�.
��Ʈ] 2�� for�� x 2 or 3�� for�� x 1��

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
����14-1.
�䱸����] �Ʒ��� ���� ����Ͻÿ�.
���] 2�� for�� x 1��, 1�� for�� x 1��


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
����14-2.

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

����15.   4���� ����
�䱸����] �Ʒ��� ���� ����Ͻÿ�.

1 + 2 + 4 + 7 + 11 + 16 + .... + N = 469
����] ���ϴ� N�� 100�� ���� ���� ������...


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


����16. ���̵� **** 4��
�䱸����] �Ʒ��� ���� ����Ͻÿ�

1 + 1 + 2 + 3 + 5 + 8 + 13 + 21 + 34 + 55 + 89 = 232

����] ���ϴ� N�� 100�� ���� ���� ������...



����17. 1��
�䱸����] 2���� 100������ �Ҽ��� ���Ͻÿ�.
���] 2, 3, 5, 7, 11, 13.....
��Ʈ] �Ҽ� : 1�� �ڱ��ڽ����ιۿ� �������� �ʴ� �� 


����18.���ʴ԰� 
�䱸����] 1���� 100������ �������� ���Ͻÿ�.
���] 

6 = [1, 2, 3, 6]
28 = [1,2,4,7,14,28]

��Ʈ] ������ : �ڱ� �ڽ��� ������ ������ ������� ���� �ڽŰ� ������ ��



*/
	
}
