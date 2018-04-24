class Homework6 {
	public static void main(String[] args){
		

		//Homework6.java

		//star();
		//star1();
		//star2();
		//star3();
		add();
		//add2();
	}//main

	public static void star(){
	
		/*
		
		문제8.
		요구사항] 별찍기
			*
		   **
		  ***
		 ****
		*****
		*/

		for(int i=0;i<5;i++){
			
			for(int j=5-i;j>1;j--){
				System.out.print(" ");
			}
			for(int k=1;k<=i+1;k++){
				System.out.print("*");
			}
			System.out.println();
		}
	}//star()

	public static void star1(){
		/*
			문제9.
			요구사항] 별찍기
			*********
			 *******
			  *****
			   ***
				*
		
		*/

		for(int i=9 ;i>0;i-=2){


			for(int k=i;k<9 ;k+=2){
				System.out.print(" ");
			}
			for(int j=i ;j>0 ;j--){
				System.out.print("*");
			}
			
			System.out.println();
		}
		
	}//star1()

	public static void star2(){
	
		/*
		
		문제10.
		요구사항]
		*
		 *
		  *
		   *
			*
		*/

		for(int i=5;i>0;i--){
			
			for(int j=0;j<=5-i;j++){
				
				System.out.print(" ");
			}
			System.out.print("*");
			System.out.println();
		}
	}//star2()

	public static void star3(){
	
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

		*/
	
		
		for(int i=7;i>0;i--){ //행
		
			for(int j=8-i;j>0;j--){ //셀
				if(j>3){
					break;
				}
				System.out.print("*");
			}
			System.out.println();
		}

	}//star3()


	public static void add() {
		
		/*	
	  	문제16.
		요구사항]아래와 같이 출력하시오.
		
		1 + 1 + 2 + 3 + 5 + 8 + 13 + 21 + 34 + 55 + 89 = 232
		i + n + i + n
		조건] 더하는 n이 100을 넘지 않을 때까지
		*/
		int num = 0;
		int sum = 0;
		
		for(int i=1;;i+=num) {//i=i+num
			num+=i;//num=num+i
			sum+=num;      
			if(num<100) {
				System.out.printf("%d + %d + ",i,num);
			}else {
				System.out.printf("%d ",i);
				break;
			}
			
			
		}
		System.out.printf("= %d\n",sum);
	}


	public static void add2(){
		/*
		문제18.
		요구사항] 1부터 100사이의 완전수를 구하시오.
		출력] 

		6 = [1, 2, 3, 6]
		28 = [1, 2, 4, 7, 14, 28]

		힌트] 완전수 : 자기 자신을 제외한 나머지 약수들의 합이 자신과 동일한 수
		*/

		int sum = 0;
		int su=0;

		for(int i=1;i<=100;i++){

			for(int j=1;j<=i;j++){
				if(i%j == 0){
					sum+=j;
				}
			}
			
			if(sum==i){
				
				System.out.printf("%d \n",i);
				
			}
		}
		
	}

}
