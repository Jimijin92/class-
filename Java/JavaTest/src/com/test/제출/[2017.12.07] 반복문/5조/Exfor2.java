class Exfor2 {
	
	public static void main(String[] args) {

		//Exfor2.java

		//Triangle();
		InvertedTriangle();
		//star();
	
	} //main

/*
문제8
요구사항] 별찍기 -> print(" ")

	    *
       **
      ***
     ****
    *****

*/

	public static void Triangle()  {
		for(int i=0;i<5;i++){	//행 i가 4까지 반복문 걸고
			for(int j=4;j>=0;j--){ //셀
        if(i<j){
            System.out.print(" ");
        } else {
            System.out.print("*");
        }
    }
    System.out.println("");
  }

  //if문을 써도 되나, 코딩을 줄이기 위해 삼항연산자로 결과값 출력.


 }


/*

문제9
요구사항] 별찍기

*********
 *******
  *****
   ***
    *


*/

	public static void InvertedTriangle() {
		for (int i=0; i<5; i++) { // 5번 반복하는 순환문
			for (int j=0; j<(9-i); j++) { // 9-i로 반복횟수 줄임
				System.out.print((j<i)?" ": "*"); //i 값이 커질수록 true가 많이 출력되게 해놓음.
			}
			System.out.println();
		}
	}


/*

문제10
요구사항]
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






