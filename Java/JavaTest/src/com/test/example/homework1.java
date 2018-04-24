package com.test.example;
import java.util.Scanner;

public class homework1 {
	

	public static void main(String[] args) throws Exception {
		
	//n1();	
	//n2();	
	n3();
    }//main
	
	
	
	
	
	private static void n3() {
		/*문제3.
		
		요구사항] 숫자를 입력받아 3자리마다 ','를 붙이시오.
		입력] 숫자 : 1234567
		출력] 결과 : 1,234,567
		조건] %,d 사용불가 (직접 쪼개서 사이사이마다 콤마 붙이기 substring사용)
		
		*/
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("===========문제3===========");

			System.out.print("숫자 : ");
			String num = scan.nextLine();
			
		
			String sub2 = "";
			int circle = (num.length() / 3)*3;
			int middlenum = num.length()-circle;
			
			//String sub1 = "," + number.substring(number.length()-3)
			
			
			//System.out.print(num.substring(0, middlenum)); 
			//System.out.println(num.substring(middlenum, middlenum+3));
			//System.out.println(num.substring(middlenum+3, middlenum+6));
			
			
			System.out.print(num.substring(0, middlenum)); 	
			System.out.print(",");
			
			for(int i = 0 ; middlenum+i+3 <= num.length() ; i+=3  ) {
			System.out.print(num.substring(middlenum+i, middlenum+i+3));
			if(middlenum+i+3 < num.length()) {
			System.out.print(",");
			}
			
			}
			//}
				//루프변수
						
				//sub2 = sub1.substring(sub1.length()-(i+4), sub1.length()-i);
				
				//System.out.print(num.substring(num.length()-i, num.length()-i-3) + ",");
			//}	
			
			//System.out.print(num.substring(1, num.length()-circle)
			
			
			
			
		//	 System.out.println(sub2);
		
	}//n3
			
	





	private static void n2() {
		
		/*문제2.

		요구사항] 숫자를 입력받아 항상 3자리로 출력하시오.
		입력] 숫자 : 1
		출력] 결과 : 001
		입력] 숫자 : 24
		출력] 결과 : 024
		입력] 숫자 : 123
		출력] 결과 : 123
		조건] 최대 3자리까지만 입력...*/
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("===========문제2===========");

	
			System.out.print("숫자 : ");
			String number = scan.nextLine();
			int leng = number.length();
			
			if(leng == 1) {
				System.out.print("00"+number);
			} else if(leng == 2){
				System.out.println("0"+number);
			} else {
				System.out.println(number);
			}
			
	}//n2

	
	
	private static void n1() {
		
		/*문제1. 
		요구사항] 문장을 입력받아 역순으로 출력하시오.
		입력] 문자 : 안녕하세요 홍길동입니다.
		출력] 결과 : .다니입동길홍 .요세하녕안
		힌트] 첨자(index)
	    */
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("===========문제1===========");
		System.out.print("문자 : ");
		
		String munja = scan.nextLine();
		
		for(int i = 0; i<munja.length() ;i++) {
			System.out.print(munja.charAt(munja.length()-1-i));
		}
		
		
	}//n1

	
	
	
	
	
	
	
	
}
