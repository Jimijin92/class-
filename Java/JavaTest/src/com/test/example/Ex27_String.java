package com.test.example;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Scanner;

public class Ex27_String {
	
	//main+ctrl+space
	public static void main(String[] args) throws IOException  {
		
		
		//인텔리센스(VS), Code Assist(Eclipse)
		//System.out.println("아무개"); 
		

		//Code Template 
		System.out.println();
		
		//Shift + Alt + Y : 자동 줄바꿈
		//ddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddd
		
		//Ctrl+/ 단일라인 단축키
		
//		int a;
//		int b;
//		int c;
		
		
//		다중라인 단축키
		//Ctrl+Shift + /
		//Ctrl+Shift + \
/*		int d;
		int e;
		int f;*/
		
		
		//int a = 10
		
		
		
		/*
		
		문자열, String
		-기본형(원시형) vs 참조형 
		-문자열은 참조형이다.
		- String 클래스 
		
		
		 */
		
		
		//m1();
		//m2(); //m2뒤에 f3 , 선언된 곳 찾으려면 f3
		//m3(); //ctrl+1
		//m4();
		//m5();
		//m6();
		//m7();
		//m8();
		//m9();
		//q1();
		
		//m10();
		
		//m11();
		
		//m12();
		
		//m13();
		
		//m14();
		
		//m15();
		
		//m16();
		
		//m17();
		
		//m18();
		
		
		int a = 10;
		
		if (a>0) ; // ; 를 붙이면 if (a>0) { }으로 생각함 -> 에러표시X
			
			
			{System.out.println("참");	//1줄일땐 {}생략가능
		     
			System.out.println("참"); //2줄이상이면 {}묶기
		         
			}
		
		
		
		for (int i=0; i<5; i++) System.out.println(i);	
		
		
		

		
	}//main
	
	
	
	private static void m18() {
		
		//숫자를 n자리로 만들기(homework171208 문제 3)
		// 1-> 001
		
		String result = paddingZero(4, 10);
		System.out.println(result); // "0010"
		
		result = paddingZero(8, 23);
		System.out.println(result); // "0000023"
		
		
	}//m18



	private static String paddingZero(int size, int num) {
		// -> for문 사용, 이 루프는 0을 붙이는데만 사용 (8자리라고 8번 도는게 아님)
		
		//for(int )
		
		return null;
		
	}//paddingZero



	private static void m17() {
		
		Scanner scan = new Scanner(System.in);
		
		
		
		System.out.print("아이디 : ");
		String id = scan.nextLine();
		
		
		if (idCheck(id)) {
			System.out.printf("입력하신 아이디 '%s'는(은) 사용가능합니다.\n", id);
			
			
			
		} else {System.out.printf("입력하신 아이디 '%s'는(은) 사용 불가능합니다.\n", id);
			
			
			
		}
		
		
		
		
	}

	private static boolean idCheck(String id) {
		
		
		//1. 4자~ 12자 이내
		if (id.length() < 4 || id.length() > 12) {
			
			System.out.println("4자~ 12자 이내");
			
			return false;
			
		} 
		
		//2. 영문자+숫자+_
		
		for (int i = 0; i<id.length(); i++) {
			char c = id.charAt(i);
					
			if ((c<'A' || c > 'Z') && (c < 'a' || c > 'z') && (c < '0' || c > '9') && c !='_')
					
					{System.out.println("영문자 + 숫자 + _");
					return false;
					
				
					} //if
			
			
		} //for
		
		//3. 숫자로 시작 불가능
		char c = id.charAt(0);
		if(c >='0' && c <='9') {
			
			System.out.println("숫자로 시작 불가능");
			return false;
			
		}
		
		//올바른 아이디
		return true; //꼭써야 에러x
		
		
		
		
	}//idCheck



	private static void m16() {
		
		//유효성 검사
		//아이디 입력
		//1. 4자~ 12자 이내
		//2. 영문자 + 숫자 + _
		//3. 숫자로 시작 불가능
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("아이디 : ");
		String id = scan.nextLine();
		
		//1. 잘못된 부분을 조건으로 검사
		//2. 결과 boolean를 사용해서 판단
		
		boolean isValid = true;
		
		
		//1. 4자~ 12자 이내
		if (id.length() < 4 || id.length() > 12) {
			
			System.out.println("4자~ 12자 이내");
			
			isValid = false;
			
		} 
		
		//2. 영문자+숫자+_
		
		for (int i = 0; i<id.length(); i++) {
			char c = id.charAt(i);
					
			if ((c<'A' || c > 'Z') && (c < 'a' || c > 'z') && (c < '0' || c > '9') && c !='_')
					
					{System.out.println("영문자 + 숫자 + _");
					isValid = false;
					break;
				
					} //if
			
			
		} //for
		
		//3. 숫자로 시작 불가능
		char c = id.charAt(0);
		if(c >='0' && c <='9') {
			
			System.out.println("숫자로 시작 불가능");
			isValid = false;
			
		}
		
		
		//최종
		
		if (isValid) {
			System.out.printf("입력하신 아이디 '%s'는(은) 사용가능합니다.\n", id);
			
			
			
		} else {System.out.printf("입력하신 아이디 '%s'는(은) 사용 불가능합니다.\n", id);
			
			
			
		}
		
		
		
	} //m16

	private static void m15() {
		
		//사용자 입력
		// - System.in.read() -> BufferedReader -> Scanner
		
		
		Scanner scan = new Scanner(System.in);
		//이름(문자열) 입력
		System.out.print("이름 입력 : ");
		String name = scan.nextLine(); 
		
		System.out.println(name);
		
		//숫자 입력
		
		System.out.print("숫자 입력 : ");
		int num = Integer.parseInt(scan.nextLine());
		System.out.println(num + 10);
		
		
		System.out.print("숫자 입력 : ");
		num = scan.nextInt();//숫자열로 받을 수 있게 
		System.out.println(num + 10);
		
		
		System.out.print("숫자 입력 : ");
		num = scan.nextInt();//숫자열로 받을 수 있게 
		System.out.println(num + 10);
		
		
		
		//Scanner 사용시 주의점
		//nextInt() ->nextLine() 사용시
		// ->nextInt() 가 \r\n 남겨버린다. -> \r\n를 nextLine()이 사용한다.
		
		//scan.nextLine(); //->대신 처리함 
		scan.skip("\r\n");
		
		
		System.out.println("문자열 입력 : ");
		String str = scan.nextLine();
		System.out.println(str);
		
		
		System.out.println("종료");
		
		String s1 = scan.nextLine();
		String s2 = scan.next(); //token을 읽어오는 기능 (공백으로 구분되는 단어 하나하나)
		
		System.out.println(s1);
		System.out.println(s2);
		
		s2 = scan.next(); //버퍼에 남아있는 나머지 token을 읽어오라는 뜻. 새 입력x
		System.out.println(s2);
		
		
		
		
		
		
		
		
		
	}

	private static void m14() {
		
		
		//형식 문자열 지원
		// - printf() : 화면 출력만..//콘솔 전용 , 웹에서 사용불가
		// - String format() : 형식 문자를 사용해서 형식을 가공한 문자열을 출력이 아닌 그대로 반환 
		
		System.out.printf("%d\n", 100);
		
		//System.out.println("%d\n", 100);
		
		//System.out.print("%d\n", 100);
		
		
		String name = "홍길동";
		String result = String.format("안녕하세요. %s님", name);
		
		System.out.println(result);
		
	} //m14
	
	
	

	private static void m13() {
		
		//대소문자 변환
		String str = "Hello~ Hong!!";
		String result = ""; // 누적변수 
		
		for (int i=0; i<str.length(); i++) {
			
			char c = str.charAt(i);
			
			//Stirng c  = str.substring(i, i+1);//문자코드값X int로 형변환X
			
			if (c >= 'a' && c <='z') {
				
				result += (char)(c -32);
				
				
			} else {
				result += c;
				
				
			}
			
			
			
		}
		
		System.out.println(result);
		
		
		
		// - String toUpperCase()
		// - String toLowerCase()
		System.out.println(str.toLowerCase());
		System.out.println(str.toUpperCase());
		
		//System.out.println("Java".equals("java")); //자바는 대문자 소문자를 다른 데이터로 인식
		
		String content = "대상 문자열.. 글내용.. Java가 어쩌구";
		String search = "java";
		
		//if (content.contains(search)) {
		if (content.toLowerCase().contains(search.toLowerCase())) { //메소드 체인 
			System.out.println("검색 결과 있음");
			
			
			
		} else {
			
			System.out.println("검색 결과 없음");
		}
		
		
		String s1 = "Hong";
		
		String s2 = "hong";
		
		System.out.println(s1.equals(s2));
		System.out.println(s1.toUpperCase().equals(s2.toUpperCase()));
		
		System.out.println(s1.equalsIgnoreCase(s2)); //한번에 비교
		
		str = "";
		//비어있습니까?
		//if (str.equals("")) {		
		//if (str.isEmpty()) {
		
		if (isEmpty(str)) {
			System.out.println("비었음");
		}else {
			
			System.out.println("뭔가 있음");
			
		}
		
		
		//자바 메소드명
		//1. isXXX() : 확인? -> boolean 반환 
		//2. getXXX() : 값을 반환 +읽기
		//3. setXXX() : 값을 전달 + 세팅 + 쓰기
				
			
		
	} //m13
	
	
	public static boolean isEmpty(String str) {
		
		if (str.equals("")) {
			
			return true;
		} else {
			
			return false;
			
		}
		
		
		
		
		
	}
	

	private static void m12() {
		
		//특정 문자열의 포함 유무
		// - boolean contains (String word)
		String str = "안녕하세요. 홍길동님.";
		
		System.out.println(str.contains("홍길동"));
		
		System.out.println(str.contains("아무개"));
		
		
		System.out.println(str.indexOf("홍길동") > -1 ); // str.contains
		
		
		
		
		
		
		
		
		
	}

	private static void m11() {
		
		
		
		//문자열 치환, 바꾸기
		// - 대상 문자열에서 특정 문자열을 찾아서 다른 문자열로 바꾸기 
		// - String replace(String old-찾을 문자, String new-바꿀 문자)
		
		String str = "안녕하세요. 홍길동님. 안녕히가세요. 홍길동님.";
		
		String word1 = "홍길동";
		
		String word2 = "아무개";
		
		//str : word1 -> word2
		
		String sub1 = str.substring(0, str.indexOf(word1));
		
		String sub2  = str.substring(str.indexOf(word1) + word1.length());
		
		System.out.println(sub1+word2+sub2);
		
		//CharSequence ~ : String으로 생각하기
		System.out.println(str.replace(word1, word2)); //replace는 모두 바꿈 
		
		System.out.println(str.replace(word1, "")); //문자열 제거 용도
		
		System.out.println(str.replace(" ", "")); //내부 모든 공백제거 cf. trim은 좌우공백만
		
		
		//주민번호 입력 - > '-' 입력 
		String jumin = "9512202012457";
		
		System.out.println(jumin.replace("-", "")); // replace 해당문자열못찾으면 아무것도 안함 
		
		
		//게시판 글쓰기 -> 금지어 "바보"
		String content = "게시판 바보야!!";
		
		System.out.println(content.replace("바보", "**"));
		
		
		
		
				
		
		
		
				
		
		
		
		
		
		
	}

	private static void m10() {
		
		//지역변수
		// - 메소드나 제어문안에서 선언된 변수 
		
		int m = 10;
		
		int n = 0;
		
		if (m > 0) {
			
			//int n = 10;
			
			n = 10;
			System.out.println(n);
		
			
		}
		
		 System.out.println(n);
		 
		 
		 int i = 0;
		 
		 for (i = 0; i<10; i++) {
			 
			 
			 
		 }
		 
		 //i ?
		 
		 System.out.println(i);
		 
		 
		 for (int j = 0; j<10; j++) {
			 
			 
			 
		 }
		 
		for (int j = 0; j < 10; j++) {

		}
		
		for (int j = 0; j < 10; j++) {

		}
		 
		 
// ctrl+shift+f => 배열 정리 
		 
		 
		 
		
	} //m10

	private static void q1() {
		
		//요구사항]
		// - 경로 : "D:\Class\Java\JavaTest\src\Ex27_String.java"
		// - 경로 : "C:\Images\dog.png"
		//1. 파일명? -> "Ex27_String.java"
		//2. 확장자를 뺀 순수한 파일명? -> "Ex27_String"
		//3. 확장자? -> ".java"
		
		//사용]
		//1. indexOf / lastIndexOf
		//2. substring 
		
		String path = "D:\\class\\Java\\JavaTest\\src\\Ex27_String.java";
		
		// 1. 파일명
		
		int index = path.lastIndexOf("\\");
		
		System.out.println(index);
		
		String filename = path.substring(index+1);
		System.out.println(filename);
		
		
		
		//System.out.println (path.substring(path.lastIndexOf("\\")+1, path.length()));
		
		
		//2. 순수파일명
		
		index = filename.lastIndexOf(".");
		
		System.out.println(filename.substring(0, index)); // 순수파일 
		
		
		
		//"."은 파일명에 쓸수있는 글자라서 lastIndexOf써야함 
		//System.out.println (path.substring(path.lastIndexOf("\\")+1, path.lastIndexOf(".")));
		
		
		//3. 확장자
		
		System.out.println(filename.substring(index)); //확장자 
		
		//System.out.println (path.substring(path.lastIndexOf(".")+1, path.length() ));
		
		

		
		
		
		
		
		
		
		
	}

	private static void m9() {
		
		//문자열 추출
		// - char charAt(int index)
		// - String substring(int start, int end) 
//									포함	미포함
		
		String str = "안녕하세요. 홍길동님.";
		
		System.out.println(str.substring(3, 8)); //3은포함 8은 미포함 
		System.out.println(str.substring(7, 10));
		
		
		String jumin = "951220-2014587";
		
		//성별?
		if (jumin.substring(7, 8).equals("1")) {
			
			System.out.println("남자");
			
			
			
		}else {
			
			System.out.println("여자");
		}
		
		
		//몇년생?
		System.out.println("19" + jumin.substring(0, 2));
		
		//몇월생?
		System.out.println(jumin.substring(2,4));
		
		
		
		System.out.println(str.substring(3, 8));
		System.out.println(str.substring(3)); //4번째부터 끝까지 
		System.out.println(str.substring(3, str.length())); //굳이X
		
		
		
		
	}

	private static void m8() {
		
		//패턴 검색
		// - boolean startsWith(String str)
		// - boolean endsWith(String str)
		
		String name = "홍길동";
		
		//'홍'씨 입니까?
		System.out.println(name.startsWith("홍"));
		System.out.println(name.charAt(0) == '홍');
		System.out.println(name.indexOf("홍") == 0);
		
		//동으로 끝납니까?
		System.out.println(name.endsWith("동"));
		System.out.println(name.charAt(name.length()-1) == '동');
		System.out.println(name.lastIndexOf("동") == name.length()-1);
		
		
	}

	private static void m7() {
		//문자열 검색(*****)
		// - 문자열내에서 원하는 문자(열)을 검색 -> 찾은 위치를 반환 
		// - int indexOf(char c)
		// - int indexOf(String s) 
		// - int indexOf(char c, int startIndex)
		// - int indexOf(char s, int startIndex)
		
		
		// - int lastIndexOf(char c)
		// - int lastIndexOf(String s)
		
		
		String str = "안녕하세요. 길동님";
		
		
		
		System.out.println(str.indexOf('홍'));
		System.out.println(str.indexOf("홍길동")); //문자열을 반환해도 첫글자 순서반환
		System.out.println(str.indexOf("아무개")); //문자열이 없으면 -1 반환 
		
		if (str.indexOf("홍길동") > -1) {
			System.out.println("홍길동 발견!!");
			
		} else {
			System.out.println("홍길동 없음;;");
			
		}
		
		
		String jumin = "951220-2102145";
		
		//if (jumin.charAt(6) == '-') {
		
		if (jumin.indexOf('-') == 6) {
			System.out.println("올바름");
			
			
		} else {
			System.out.println("올바르지 않음");
			
			
		}
		
		
		//게시판 글쓰기 
		// - 관리자 모드
		// - 금지어 
		String content = "게시판 테스트입니다. 바보 블라~블라~";
		String word = "바보";
		
		if (content.indexOf(word) > -1) {
			
			System.out.println("금지어 사용 불가!!!");
			
			
		} else {
			
			System.out.println("글쓰기 완료!!");
			
			
		}
		
		
		//
		str = "안녕하세요. 홍길동. 하하하하. 홍길동님.  안녕히가세요. 홍길동님.";
		
		System.out.println(str.indexOf("홍길동"));
		System.out.println(str.indexOf("홍길동", 10));
		
		int index =  str.indexOf("홍길동");
		System.out.println(index);
		
		index = str.indexOf("홍길동", index + "홍길동".length());
		System.out.println(index);
		
		index = str.indexOf("홍길동", index + "홍길동".length());
		System.out.println(index);


		
		
		
		
		
		str = "안녕하세요. 홍길동. 하하하하. 홍길동님.  안녕히가세요. 홍길동님.";
		
		System.out.println(str.indexOf("홍길동"));
		System.out.println(str.lastIndexOf("홍길동"));
		
		
		
		
	} //m7

	private static void m6() {
		
		//문자열 공백 제거
		//	- String trim()
		
		String str = "    하나   둘   셋    ";
		System.out.printf("[%s]\n", str);
		System.out.printf("[%s]\n", str.trim());
		

		
	}

	private static void m5() {
		
		//주민번호 입력 -> 반드시 '-'를 입력 
		String jumin = "951220-1014785";
		
		if (jumin.charAt(6) == '-') {
			System.out.println("올바릅니다.");
			
			
			
		} else {
			
			System.out.println("올바르지 않습니다.");
			
			
		}
		
		if (jumin.charAt(7) == '1') {
			System.out.println("남자");
		}else {
			System.out.println("여자");
			
			
		}
		
	}

	private static void m4() throws IOException {
		
		//사용자 아이디 입력 -> 유효성 검사
		//조건] 
		//1. 영어 소문자만
		//2. 길이 4자 ~ 12자 이내
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("아이디 입력 : ");
		String id = reader.readLine();
		boolean flag = false;
		
		//한글자씩 추출 -> 문자코드값 비교
		for (int i = 0; i<id.length(); i++ ) {
			
			char c = id.charAt(i);
			
//			if (c >= 'a' && c <= 'z' ) {
//				
//				System.out.println("사용 가능한 아이디입니다.");
//				
//			} else {
//				
//				System.out.println("사용 불가능한 아이디입니다.");
//				
//				
//				
//			}
			
			
//			유효성 검사 -> 잘못된 것을 찾는 조건을 사용한다. -> 로직짜기가 더 쉬워짐 
			if ((c < 'a' || c > 'z') && (c < 'A' || c > 'Z')) {
				flag = true;
				break; 
				
				
				
				
			}
			
			
			
		} //문자검사
		
		//길이검사
		
		if(id.length() < 4 || id.length() > 12) {
			
			flag = true;
		}
		
		
		//마무리
		if (!flag) {
		
		 System.out.println("아이디 사용 가능");
		 
		}else {
			
			System.out.println("아이디 사용 불가능");
			
			
		}
		
		
		
	}

// Alt + 위아래 방향키 // 코드이동
//	Ctrl+Alt+위아래 방향키//코드 복제
	public static void m1() {
		
		
		//문자열, String
		// - 자바에서 String 클래스내에 여러가지 기능을 구현 
		
		//문자열의 길이 
		// - 문자열을 구성하는 문자의 갯수
		// - 영문자, 숫자, 한글, 특수문자 등에 상관없이 문자 1개당 1개로 계산 (유니코드 기반)
		// -int length()
		
		String str = "홍길동 입니다.";
		System.out.println(str.length());
				
		
		
	}//m1


	
	private static void m2() throws IOException {
		
		
		//유효성 검사 
		//회원가입 > 이름 > 길이 제한
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		String name = "";
		
		System.out.print("이름 입력 : ");
		name = reader.readLine();
		
		// System.out.println(name.length());
		
		if (name.length() >=2 && name.length() <=5) {
			
			System.out.println("회원 가입 완료");
			
		
		}else {
			System.out.println("이름을 다시 입력하세요.");
		}
		
		
		System.out.println(name.length());
		System.out.println("홍길동".length());
		
		
		
		
		
		
		
	}//m2

	
	private static void m3() {
		
		
		//문자열 추출
		// - char charAt(int index)
		// - 문자열 내에 특정 위치에 있는 문자 1개를 추출
		// - ★자바는 서수를 0부터 시작 . zero-based Index 사용
		// - 문자열 첨자 범위 : 0 ~ (length-1)
		
		String str = "안녕하세요. 홍길동님.";
		
		char c = str.charAt(3);
		
		System.out.println(c);
		
		c = str.charAt(11);
		
		System.out.println(c);
		
		
		//StringIndexOutOfBoundsException 
		//c = str.charAt(14);	
		//System.out.println(c);
		
		c = str.charAt(3);
		
		System.out.println(c);
		
		System.out.println(str);
		
		
		c = str.charAt(str.length()-1); //마지막글자 추출 
		
		System.out.println(c);
		
		
		System.out.println();
		
		str = "가나다라마바사"; //사용자 입력
		
		// 요구사항 ] str을 1문자씩 추출해주세요.
				
		//str.charAt(0)
		//str.charAt(1)
		//str.charAt(2)
		//..
		
		for (int i=0; i<str.length(); i++) { //length-1보다는 <=에서 =없애기
			
			System.out.println(str.charAt(i));	
		}
		
			
		
		
	}//m3
	
	


	 
	
	
	
}
