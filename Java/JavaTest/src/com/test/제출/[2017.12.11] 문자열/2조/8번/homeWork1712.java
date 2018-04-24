import java.io.*;
import java.util.Scanner;


public class homeWork1712 {

	public static void main(String[] args) {
		
		
		
		
	//qna01();
	//qna02();	
	//qna03();	
	//qna04();	
	//qna05();	
	//qna06();	
	//qna07();	
	qna08();	
	//qna09();	
	//qna10();	
	//qna11();	
	
	
		
		
		
		
		
		
		
		
	}//main

	//문자열 문제

	/*문제1.
	요구사항] 문장을 입력받아 역순으로 출력하시오.
	입력] 문자 : 안녕하세요. 홍길동입니다.
	출력] 결과 : .다니입동길홍 .요세하녕안
	힌트] 첨자(index)
	 */

	private static void qna01() {
		
	}
	
	
	
	
	
	
	
	/*문제2.
	요구사항] 숫자를 입력받아 항상 3자리로 출력하시오.
	입력] 숫자 : 1
	출력] 결과 : 001
	입력] 숫자 : 24
	출력] 결과 : 024
	입력] 숫자 : 123
	출력] 결과 : 123
	조건] 최대 3자리까지만 입력한다는 가정..
	*/

	private static void qna02() {
		
	}
	
	
	
	
	
	
	
	/*문제3. 
	요구사항] 숫자를 입력받아 3자리마다 ','를 붙이시오.
	입력] 숫자 : 1234567
	출력] 결과 : 1,234,567
	조건] %,d 사용불가
	*/

	private static void qna03() {
		
	}
	
	
	
	
	
	
	
	
	/*문제4.
	요구사항] 숫자를 입력받아 한글로 바꿔서 출력하시오.
	입력] 금액(원) : 1500
	결과] 결과 :  일천오백원
	조건] 입력값은 최대 천단위까지(4자리 숫자까지)
	힌트] 369문제랑 유사
	*/

	private static void qna04() {
		
	}
	
	
	
	
	
	
	
	/*문제5.
	요구사항] 특정 단어가 몇번 들어갔는지 세시오.
	상황] String content = "안녕~ 길동아~ 잘가~ 길동아~";
		  String word = "길동";
	출력] '길동'을 총 2회 발견했습니다.
	힌트] 1. indexOf() , 무한 루프 생각해보기 -> 일단 이걸로 풀기
		  * replace(word, "")	->너무 쉬움
	*/

	private static void qna05() {
		
	}
	
	
	
	
	
	
	
	

	/*문제6. 면접******
	요구사항] 주민번호 유효성 검사
	입력] 주민번호 : 951220-1021547
	출력] 결과 : 올바른(올바르지 않은) 주민번호입니다.
	추가] '-' 선택
	1800년대 9,0으로 시작
	5,6,7,8 귀화한 사람들
	맨마지막 번호 : 유효성 검사 번호
	 */

	private static void qna06() {
		
	}
	
	
	
	
	
	
	
	

	/*문제7.
	요구사항] 이메일 주소를 입력받아 아이디/도메인을 추출하시오.
	입력] 이메일 : hong@naver.com
	출력] 아이디 : hong
		  도메인 : naver.com
	*/

	private static void qna07() {
		
	}

	
	
	
	
	
	
	
	/*문제8. ***월요일 발표
	요구사항] 숫자를 입력받아 각 숫자의 합을 구하시오.
	입력] 숫자 : 314
	출력] 결과 : 3 + 1 + 4 = 8
	생각] 1. nextLine() -> "314"  : 훨씬 쉽다
		  2. nextInt() 	-> 314
	조건] 최대 5자리까지만..
	for문 length / integer 
	*/

	private static void qna08() {

		Scanner scan = new Scanner(System.in);
		
		System.out.print("숫자 : ");
		String num = scan.nextLine();
		
		int n = 0;
		int sum = 0;
		
		
		if(num.length()>0 && num.length()<=5) {
			
			for(int i=0; i<num.length(); i++) {
				
				n = (int)(num.charAt(i)) - 48 ;
				sum = sum + n ;	
				
				if( i == 0 ) {							//입력한 첫번째 숫자
					System.out.print("결과 :  ");
					System.out.printf("%d + ", n);
					
				}else if( i == num.length()-1 ) {		//입력한 마지막 숫자
					System.out.printf("%d ", n);
					
				}else {
					System.out.printf("%d + ", n);		
				}
			}
		} else {
			System.out.println("최대 5자리까지 입력하시오");
		}
		
			
		System.out.printf("= %d\n" ,sum);
	}
	
	
	
	
	
	
	
	
	/*문제9.
	요구사항] 공백을 제거하시오.
	원본] 문자열 : "     하나     둘      셋      "
	출력] 문자역 : "     하나둘셋      "
	trim x
	replace x 못씀
	*/

	private static void qna09() {
		
	}
	
	
	
	
	
	
	
	
	/*문제10.
	요구사항] 영어 단어를 입력받아 아래와 같이 출력하시오.
	입력] 단어 : StudentName
	출력] 결과 : Student Name -> 각 단어에 공백을 넣어서
	조건] 입력은 파스칼 표기법으로만(각 단어의 시작은 대문자)
	*/

	private static void qna10() {
		
	}

	
	
	
	
	
	
	
	/*문제11.
	요구사항] 파일명 x 10개 입력 -> 확장자별로 갯수 출력하시오.
	입력] 파일명 : dog.gif
		  파일명 : cat.jpg
		  파일명 : 컵.jpg
		  파일명	 : 이력서.hwp
		  파일명 : 책상.jpg
		  ...
	출력]
		gif : 1개
		jpg : 3개
		hwp : 1개
		...
	조건] 확장자(gif, jpg, png, hwp, doc)
		  확장자 추출 + 누적값을 구하기
	*/
	
	private static void qna11() {
		
	}
	
	
	
	
	
	
	
	
	
	
	
}
