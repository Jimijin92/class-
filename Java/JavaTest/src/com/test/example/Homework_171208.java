package com.test.example;
import java.util.Scanner;

public class Homework_171208 {

	public static void main(String[] args) {
			
		//n1();	
		//n2();	
		//n3();
		//m4();
		//m5();
		//m6();
		//m6_1();
		//m7();
		//m8();
		//m9();
		m10();
		//m11();
		
		//발표
		// - 시연 횟수 늘리기
		//      ->올바른 경우, 예외 상황.....
		
		
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

	
	private static void m11() {
	/*문제 11.
	
	요구사항] 파일명 x 10개입력 -> 확장자별로 갯수 출력하시오.
	입력] 파일명 : dog.gif
		 파일명 : cat.jpg
		 파일명 : 컵.jpg
		 파일명 : 책상.jpg
		 
	출력] gif : 1개
		 jpg : 3개
		 hwp : 1개
		 ...
		 
	
	조건] 확장자(gif, jpg, png, hwp, doc)
		 확장자 추출 + 누적값 구하기*/ 
		
    String type = "";
    int gifsum = 0;
	int jpgsum = 0;
	int pngsum = 0;
	int hwpsum = 0;
	int docsum = 0;
		
	Scanner scan = new Scanner(System.in);
	for(int i = 0; i < 10; i++) {
		System.out.print("파일명 : ");
		String fileName = scan.nextLine();

			int comma = fileName.indexOf(".");
			type = fileName.substring(comma+1);
			
			switch(type) {
		    case "gif": gifsum += 1;
		    	break;
		    case "jpg": jpgsum += 1;	
	    		break;
		    case "png": pngsum += 1;
	    		break;
		    case "hwp": hwpsum += 1;
	    	    break;
		    case "doc": docsum += 1;
	    	    break;
		    }//switch
	    
	}//for i
	
	System.out.printf("gif : %d개\n"
			           + "jpg : %d개\n"
			           + "png : %d개\n"
			           + "hwp : %d개\n"
			           + "doc : %d개\n"
			           			, gifsum
			           			, jpgsum
			           			, pngsum
			           			, hwpsum
			           			, docsum);
	
	}//m11

	private static void m9() {
		
	/*문제9. 
	요구사항] 공백 제거하시오.
	원본] 문자열 : "	하나	둘	  셋	"
	출력] 문자열 : "	하나둘셋	"*/
		
	Scanner scan = new Scanner(System.in);
	System.out.print("문자열 : ");
	String sentence = scan.nextLine();
	
	
	String pureSentence = sentence.trim();
	char firstChar = pureSentence.charAt(0);
	char lastChar = pureSentence.charAt(pureSentence.length()-1);
	
	int first = sentence.indexOf(firstChar);
	int last = sentence.lastIndexOf(lastChar);
	
	String forward = sentence.substring(0, first);
	String back = sentence.substring(last+1); 
	String middle = sentence.substring(first, last+1); 
	String middleWithoutBlank = middle.replace(" ", "");
	System.out.println("\"" + forward + middleWithoutBlank + back + "\"");	
		

		
	}

	private static void m8() {
	/*문제8
	요구사항] 숫자를 입력받아 각 숫자의 합을 구하시오.
	입력] 숫자 : 314
	출력] 결과 : 3+1+4=8
	생각] 1. nextLine() - >"314" // 쉬움
		 2. nextInt() - >"314" // 어려움
		  
		  369게임 생각해보기

	조건] 최대 5자리까지만..*/	
		
	Scanner scan = new Scanner(System.in);
	System.out.print("숫자 : ");
	
	String num = scan.nextLine();
	int sumCal = 0;
    String sumExpress = "";
    String separateNumberForExpress = " ";
	
	for(int i=0 ; i<num.length(); i++) {
		separateNumberForExpress = num.substring(i,i+1);
		int separateNumberForCal = Integer.parseInt(separateNumberForExpress);
		sumCal += separateNumberForCal;
		sumExpress += separateNumberForExpress; 
			if(i != num.length()-1) {
				sumExpress += "+";	
			}else {
				break;
			}		
	}//for
	
	System.out.printf("결과 : %s = %d ", sumExpress, sumCal);
		
		
	}//m8

	private static void m7() {
	
	/*문제7.
	요구사항] 이메일 주소를 입력받아 아이디/도메인을 추출하시오.
	입력] 이메일 :hong@naver.com
		  아이디: hong
		  도메인 : naver.com */	
	
	Scanner scan = new Scanner(System.in);
	System.out.print("이메일 : ");
	String email = scan.nextLine();
	
	if(email.contains("@")){
		for(int i=0; i<email.length(); i++) {
			if(email.charAt(i) == '@') {
				System.out.printf("아이디 : %s\n", email.substring(0,i));
				System.out.printf("도메인 : %s\n", email.substring(i,email.length()));
			}				
		}
	} else {
		System.out.println("잘못 입력하셨습니다.");
	}
		
	}//m7

	private static void m6() {
	/*문제6.
	요구사항] 주민번호 유효성 검사
	입력] 주민번호 :951220-1021547
	출력] 결과 : 올바른(올바르지 않은) 주민번호입니다.
	추가] '-' 선택 , 월,일 검사까지 */
		
	Scanner scan = new Scanner(System.in);
	System.out.print("주민번호 : ");
	String idfirst = scan.nextLine();
	String id = idfirst.replace("-","");
	int month = Integer.parseInt(id.substring(2,4));
	int day = Integer.parseInt(id.substring(4,6));
	System.out.println(id);
	
	int sum = 0;
	if ((month>=1 && month<=12) && (day>=1 && day<=31)) {
		for(int i=0; i < 12; i++) {
			sum += ((id.charAt(i)-'0')*((i<8) ? (i+2) : (i-6)));
		}
	}else {
	    System.out.println("잘못된 형식입니다. 다시 입력하세요.");
	}//else
	
	if((11 - (sum % 11)) % 10 == (int)id.charAt(12)-'0') {
		System.out.println("올바른 주민번호입니다.");	
	} else {
		System.out.println("유효하지 않은 주민번호입니다.");
	}//else
	
	}//m6
	
	private static void m6_1() {
    //선생님 해설 추가
	
	//12자리 루프로 접근(x2....9-> 총합)
	String jumin = "961211-1021342";
	jumin = jumin.replace("-","");
	
	for(int i=0; i<12; i++) {
		//문자열의 문자 추출 -> 정수 변환
		//1.charAt()-> 문자코드값(code - 48)
		//2. substring() -> Integer.parseInt() //추천
		int n = Integer.parseInt(jumin.substring(i, i+1));
		System.out.println(n + "," + (i % 8 + 2));
		
		
	}
	

	}//m6_1

	private static void m5() {
	
		/*요구사항] 특정 단어가 몇번 들어갔는지 세시오.
		상황 String content = "안녕 길동아 잘가 길동아"
			String word = "길동";
	
		출력] '길동'을 총 2회 발견했습니다.
		힌트] 1.indexOf() , 시작위치 조절 for문 으로 잘 엮어서 ->일단 이걸로 풀기
			  2. replace (word, "") */
			
		String content = "홍동길은 동길이고 몰라하하하하하";
		String word = "길동";
		int find = content.indexOf(word);
		int num = 0;
		
		if(find > -1) { 
			for(int i = 1 ; ; i++) {
				find = content.indexOf(word, find + word.length());
				num += 1;
					if(find == -1) {
						System.out.printf("'%s'을 총 %d회 발견했습니다", word, num);
						break;
			        }//if
			}//for
		} else {
			System.out.printf("'%s'을(를) 발견하지 못했습니다.", word);
		}//else		
	}//m5

	
	
	private static void m4() {
		/*문제4.
		요구사항] 숫자를 입력받아 한글로 바꿔서 출력하시오.
		입력] 금액(원) : 1500
		출력] 결과 :일천오백원
		조건] 입력값은 최대 천단위까지(4자리 숫자까지)
		힌트] 369문제, 한자리씩 끊어서 
		*/
		
		Scanner scan = new Scanner(System.in);
		System.out.print("금액(원) : ");
		String num = scan.nextLine();
	  
		String sum = "";
		
		for(int i=0; i <4; i++) {
				//숫자 한글로 치환하기
				if(num.charAt(i) == '1') {
					sum += "일";
			    }else if(num.charAt(i) == '2') {
					sum += "이";
				}else if(num.charAt(i) == '3') {
					sum += "삼";
				}else if(num.charAt(i) == '4') {
					sum += "사";
				}else if(num.charAt(i) == '5') {
					sum += "오";
				}else if(num.charAt(i) == '6') {
					sum += "육";
				}else if(num.charAt(i) == '7') {
					sum += "칠";
				}else if(num.charAt(i) == '8') {
					sum += "팔";
				}else if(num.charAt(i) == '9') {
					sum += "구";
				}else if(num.charAt(i) == '0') {
					sum += "";
				}//if
				//단위수 붙여주기
				if(num.charAt(i) != '0') {
					if(i==2) {
						sum += "십";
					}else if(i==1) {
						sum += "백";	
					}else if(i==0) {
						sum += "천";
				    } 
		        }//if
		}//for
		
		System.out.println(sum + "원");
		
		

	}//m4

	private static void m10() {
				
		/*문제 10.
		요구사항] 영어 단어를 입력받아 아래와 같이 출력하시오.
		입력] 단어 : StudentNameHongGildong
		출력] 결과 : Student Name Hong Gildong
		조건] 입력은 파스칼 표기법으로만..
		힌트] 쪼개기*/	
		
		Scanner scan = new Scanner(System.in);
		System.out.print("단어 : ");
		String word = scan.nextLine();
		
		String result = ""; // 누적변수 
		String b = " "; // 공백(띄어쓰기)
		
		//입력받은 문자열의 처음부터 끝까지 문자를 추출한다.
		for (int i=0; i<word.length(); i++) {		
			char c = word.charAt(i);
			
			//추출문자가 대문자이이고 첫번째 글자가 아닌 경우
			//->대문자 앞에 띄어쓰기(b)를 더해준 후 누적
			if (c >= 'A' && c <='Z' && i>0) {
				result += (b + (char)c);
			//추출문자가 소문자이고 첫번째 글자인 경우
		    //->소문자 그대로 누적
			} else {
				result += c;
			}	
			
		}
		//누적값 출력
		System.out.print(result);

	}//m1	
	
}//class

