import java.io.*;

class Ex24_switch {

	public static void main(String[] args) throws Exception {

		//Ex24_switch.java
		
		/*

			switch (조건값) {
				case 값:
				     실행코드;
					 break;
				[case 값:
				     실행코드;
					 break;]
                [case 값:
				     실행코드;
					 break;]
		        [case 값:
				     실행코드;
					 break;]
			    [default:
				     실행코드;
					 break;]
	        }

		*/

		//요구사항]숫자 입력(1~3) 받아 한글로 출력
		int num =1;

		//switch 문의 조건값은 정수만 가능하다(true, false 넣으면 이상하니까, num>0 이런것도 true, false임). + String 가능
		switch (num){
			case 1:
				System.out.println("하나");
			    //break; //현재 제어문을 탈출// 없어도 됨 단 없으면 흘러내림

			case 2:
				System.out.println("둘");
			    break; 

			case 3:
				System.out.println("셋");
			    break;
				
			default: //if 문의 else 절 역할
				System.out.println("모름");
				break;
			}//switch(num)
		



		//자판기 -> 음료 선택 -> 가격 출력
		System.out.println("===========================================");
		System.out.println("                  자판기                 ");
		System.out.println("===========================================");
		System.out.println("1. 콜라 ");
		System.out.println("2. 사이다 ");
		System.out.println("3. 박카스 ");
		System.out.println("===========================================");
		System.out.println("음료 선택(번호) : ");
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String input = reader.readLine();

		switch (input) {
			case "1" :
				//System.out.println("700원입니다");
			    //break;
				//머리통은 두갠데 몸통은 하나
		    case "2" :
				System.out.println("700원입니다");
			    break;
			case "3" :
				System.out.println("500원입니다");
			    break;				
		}//switch(input)


		//여행 상품 or 쇼핑몰

		//카메라 구입
		//1. 옵션 : 카메라 + 메모리 + 삼각대
		//2. 옵션 : 카메라 + 메모리 
		//3. 옵션 : 카메라
		System.out.println("카메라 쇼핑몰");
		System.out.println("옵션 선택 : ");
		input = reader.readLine();

		switch (input) {
			case "1":
				//System.out.println("카메라");
				//System.out.println("메모리");
				System.out.println("삼각대");
				//break;
			case "2":
				//System.out.println("카메라");
			    System.out.println("메모리");
				//break;
			case "3":
				System.out.println("카메라");
				break;
		}

	}

}
