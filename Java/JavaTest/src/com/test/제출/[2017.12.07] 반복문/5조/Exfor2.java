class Exfor2 {
	
	public static void main(String[] args) {

		//Exfor2.java

		//Triangle();
		InvertedTriangle();
		//star();
	
	} //main

/*
����8
�䱸����] ����� -> print(" ")

	    *
       **
      ***
     ****
    *****

*/

	public static void Triangle()  {
		for(int i=0;i<5;i++){	//�� i�� 4���� �ݺ��� �ɰ�
			for(int j=4;j>=0;j--){ //��
        if(i<j){
            System.out.print(" ");
        } else {
            System.out.print("*");
        }
    }
    System.out.println("");
  }

  //if���� �ᵵ �ǳ�, �ڵ��� ���̱� ���� ���׿����ڷ� ����� ���.


 }


/*

����9
�䱸����] �����

*********
 *******
  *****
   ***
    *


*/

	public static void InvertedTriangle() {
		for (int i=0; i<5; i++) { // 5�� �ݺ��ϴ� ��ȯ��
			for (int j=0; j<(9-i); j++) { // 9-i�� �ݺ�Ƚ�� ����
				System.out.print((j<i)?" ": "*"); //i ���� Ŀ������ true�� ���� ��µǰ� �س���.
			}
			System.out.println();
		}
	}


/*

����10
�䱸����]
*
 *
  *
   *
    *




	public static void star() 
	{
		for (int i = 0; i < 5; i++) 
		{
			for (int j = 0; j < 5; j++) {
			}
			if (j == i)
				printf("*");
			else
				printf(" ");
		}
		printf("\n");
	}

	return 0;	
*/
}






