class Homework7 {

	public static void main(String[] args) {


	m10();

	}//main


	/*

����10.
�䱸����] �����
*
 *
  *
   *
    *
*/

	public static void m10() {
		for (int i=0; i<5; i++) { 
			for (int j=0; j<i; j++) {
				System.out.print(" ");
			} 
			System.out.print("*");
			System.out.println();
		}

	}



/*
����8.
�䱸����] ����� -> " "

    *
   **
  ***
 ****
*****

*/
	public static void m8() {
		for (int i=0; i<5; i++) { 
			for(int j=0; j<4-i; j++) {
				System.out.print(" ");
			}
			for (int k=0; k<i+1; k++) {
				System.out.print("*");
			}
				System.out.println();
		}

	}






}
