  class Homework9_8
{
	public static void main(String[] args) 
	{
	/*	  
	����8.
	�䱸����] ����� -> (" ")

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

	for (int i=1; i<=6; i++) { //��
			for (int j=6; j>0; j--) { //��
				System.out.print(j>i ? " " : "*");
			}
			System.out.println();
		}
	}

	public static void m2() {
/*
����9.
�䱸����] �����

*********
 *******
  *****
   ***
    *
*/

	for (int i=0; i<9; i++) { //��
			for (int j=0; j<(9-(2*i)); j++) { //��
				System.out.print("*");
			}
			System.out.println();
		}
 	}
	public static void m3 () {
		/*
		����10.
�䱸����] �����
*
 *
  *
   *
    *
		*/

		
	}
/*	����12.
�䱸����] �Ʒ��� ���� ����Ͻÿ�.
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
����13.
�䱸����] �������� ����Ͻÿ�.
��Ʈ] 2�� for�� x 2��, 3�� for�� x 1��

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
		����17.
�䱸����] 2���� 100������ �Ҽ��� ���Ͻÿ�.
���] 2, 3, 5, 7, 11, 13...
��Ʈ] �ҽ� : 1�� �ڱ��ڽ����ιۿ� �������� �ʴ� ��
		*/


	//public static void m6() {

	}
   
   
  }







