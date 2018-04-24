import java.util.Scanner;

public class Problems_String {
	
	public static void main(String[] args) {
		
		//q1();
		//q2();
		//q3();
		//q4();
		//test();
		//q5();
		//q6();
		//q7();
		//q8();
		//q9();
		//q10();
		//q11();
		
		
	} //main
	

	private static void q11() {
		
		
		/*	문제11.
				요구사항] 파일명 10개 입력 -> 확장자별로 갯수 출력
				입력] 파일명 : dog.gif
				               cat.jpg
				               sup.jpg
				               aie.hwp
				               책상.jpg
				출력] gif : 1개
				      jpg : 3개
				      hwp : 1개
				      ...
				조건] 확장자(gif, jpg, png, hwp, doc)
				      확장자 추출 + 누적값 구하기                   
		 */
		
		Scanner scan = new Scanner(System.in);
		
		int gifCount = 0;
		int jpgCount = 0;
		int pngCount = 0;
		int hwpCount = 0;
		int docCount = 0;  //각 확장자별로 Count 변수를 0으로 초기화
		
		for(int i=0 ; i<10 ; i++) { //10회 반복
			
			System.out.print("파일명 입력 : ");
			String fileName = scan.nextLine(); //파일명을 입력 받음
			
			//파일의 끝에서부터 처음으로 '.'을 만날 때까지 잘라서 extName변수에 저장
			String extName = fileName.substring(fileName.lastIndexOf('.')+1, fileName.length());
			
			//extName과 비교하여 확장자갯수를 카운트
			if(extName.equals("gif")) {
				gifCount++;
			} else if (extName.equals("jpg")) {
				jpgCount++;
			} else if (extName.equals("png")) {
				pngCount++;
			} else if (extName.equals("hwp")) {
				hwpCount++;
			} else if (extName.equals("doc")) {
				docCount++;
			} else {
				System.out.println("알 수 없는 확장자 명입니다"); // 모두 해당 안 될시 에러 출력
			}
			
		} //for
		
		//각 확장자별로 카운트한 갯수를 출력
		System.out.printf("gif : %d개\njpg : %d개\npng : %d개\nhwp : %d개\ndoc : %d개\n"
				, gifCount
				, jpgCount
				, pngCount
				, hwpCount
				, docCount);
		
	} // q11();
	
	
	private static void q10() {
		
		/*
		문제10.
		요구사항] 영어 단어를 입력받아 아래와 같이 출력하시오.
		입력] 단어 : StudentName
		출력] 결과 : Student Name
		조건] 입력은 파스칼 표기법으로만...(각 단어의 시작이 대문자)
		*/

		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("단어 : ");
		String str = scan.nextLine();
		
		String result = "";
		String temp = "";
		
		for (int i = 1 ; true ; i++) { //첫글자는 판별할 필요가 없으므로 i는 1부터 시작한다
			
			if(i >= str.length()) { //i값이 str의 길이를 넘어서면 탈출한다
				break;
			}
			
			char c = str.charAt(i); //i위치의 문자를 받아온다
			
			
			if((int)c > 'A' && (int)c < 'Z') { //대문자이면
				temp = str.substring(0, i);
				str = str.substring(i, str.length()); //대문자를 기준으로 앞뒤로 잘라준다
				
				str = temp + " " + str; // 사이에 공백을 넣고 다시 합친다
				i++; //공백이 1칸 들어간 만큼 i값을 하나 올려주어야 중복을 막을 수 있다
			}
			
		} //for
		
		System.out.printf("result : %s\n", str);
		
	} //q10();
	
	
	private static void q9() {
			
		/*
		문제9.
		요구사항] 공백을 제거하시오.
		원본] 문자열 : "      하나       둘      셋     "
		출력] 문자열 : "      하나둘셋     "
		*/
		int first = 0;
		int last = 0;
		
		String str = "          하나         둘          셋             ";
		
		System.out.println(str);

		
		for (int i = 0; i < str.length(); i++) { //앞에서 출발하여 뒤로
			
			char c = str.charAt(i);
			
			if(c != ' ') {
				first = i; //앞에서부터 공백의 갯수를 구한다
				i = str.length(); //for문 탈출을 위해 i값을 변경한다
			} //처음으로 문자를 만날 때까지의 간격을 구한다
			
		} //for
		
		
		for (int i = str.length()-1; i > 0; i--) { //뒤에서 출발하여 앞으로
					
			char c = str.charAt(i);
					
			if(c != ' ') {
				last = str.length() - 1 - i ; //뒤에서부터 공백의 갯수를 구한다
				i = -1; //for문 탈출을 위해 i값을 변경한다
			} //뒤에서부터 처음으로 문자를 만날 때까지의 간격을 구한다
					
		} //for
		
		str = str.replace(" ", ""); //모든 공백을 제거한다
		
		for (int i = 0; i < first ; i++) {
			str = " " + str;	//앞의 공백만큼 공백을 다시 채워넣는다		
		}
		
		for(int i = 0 ; i < last ; i++) {
			str = str + " ";	//위의 공백만큼 공백을 다시 채워넣는다
		}
		
		System.out.println(str);
					
			
			
	} //q9();

	

	private static void q8() {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("숫자 : ");
		String num = scan.nextLine();
		int numInt = 0;
		int sum = 0;
		
		for(int i=0 ; i<num.length() ; i++) {
			
			numInt = (int)(num.charAt(i)) - 48;
			
			sum += numInt;
		}
		
		System.out.printf("%s의 각 숫자들의 합은 %d입니다.\n", num, sum);
		
	} //q8();

	private static void q7() {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("이메일 주소 입력 : ");
		String email = scan.nextLine();
		
		String id = email.substring(0, email.indexOf("@"));
		String domain = email.substring(email.indexOf("@")+1, email.length());
		
		System.out.printf("id : %s\n", id);
		System.out.printf("domain : %s\n", domain);
		
	} //q7()

	private static void q6() {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("주민번호 입력 : ");
		String str = scan.nextLine();
		
		int index = str.indexOf("-") + 1;
		char check = str.charAt(str.length()-1);
		int num = 2;
		int temp = 0;
		int sum = 0;
		boolean flag = true;
		
		str = str.replace("-", "");
		
		if(str.length() != 13) {
			System.out.println("올바른 주민등록번호가 아닙니다!");
			flag = false;
			return;
		}
		
		System.out.println(str);
		
		for(int i=0 ; i<12 ; i++) {
			
			char c = str.charAt(i);
			temp = ((int)c-48)*num;
			
			sum += temp;
			
			num++;
			
			if(num == 10) {
				num = 2;
			}			
		} //for
		
		sum = sum % 11;
		
		if(sum >= 10) {
			sum = 11 - (sum%10);
		} else {
			sum = 11 - sum;
		}
		
		
		if(sum == (int)(str.charAt(str.length()-1)-48)) {
			System.out.println("이 주민등록번호는 유효합니다");
		} else {
			System.out.println("이 주민등록번호는 유효하지 않습니다");
		}
		
		
	} //q6()

	private static void q5() {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("문장 입력 : ");
		String str = scan.nextLine();
		System.out.print("찾을 단어 입력 : ");
		String find = scan.nextLine();
		
		int index = -1;
		int count = 0;
		int start = 0;
		
		for(int i=0 ; i<str.length() - find.length() ; i++) {
		
		str = str.substring(start, str.length());
		
		System.out.println();
		//System.out.println(str);
			
		index = str.indexOf(find);
		//System.out.println(index);
		
		if(index != -1) {
			count++;		
		}
		
		start = index + find.length();
		index = -1;
		
		
		} //for
		
		System.out.printf("문장에서 %s의 수는 %d개 입니다.", find, count);
		
	} //q5();

	private static void test() {
		
		char c = 1;
		int n = (int)(c);
		
		System.out.println(n);
		
	} //test();

	private static void q4() {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("금액(원) : ");
		String money = scan.nextLine();
		int cip = 10;
		String han = "";
		
		for(int i=1 ; i<=10 ; i++) {
			
			
			if(money.length()-i < 0) {
				break;
			}
						
			//단위 입력
			if (i == 1) {
				han = han;
			} else if (i == 2) {
				han = "십" + han;
			} else if (i == 3) {
				han = "백" + han;
			} else if (i == 4) {
				han = "천" + han;
			} else if (i == 5) {
				han = "만" + han;
			} else if (i == 6) {
				han = "십" + han;
			} else if (i == 7) {
				han = "백" + han;
			} else if (i == 8) {
				han = "천" + han;
			} else if (i == 9) {
				han = "억" + han;
			} else if (i == 10) {
				han = "십" + han;
			}
			
			char c = money.charAt(money.length()-i);
			
//			System.out.printf("char c = %s\n", c);
//			
//			System.out.printf("int c = %d\n", (int)(c));
			
			int n = (int)c - 48;
			
//			System.out.printf("n = %d\n", n);
			
			//숫자 변환
			if (n == 1) {
				han = "일" + han;
			} else if (n == 2) {
				han = "이" + han;
			} else if (n == 3) {
				han = "삼" + han;
			} else if (n == 4) {
				han = "사" + han;
			} else if (n == 5) {
				han = "오" + han;
			} else if (n == 6) {
				han = "육" + han;
			} else if (n == 7) {
				han = "칠" + han;
			} else if (n == 8) {
				han = "팔" + han;
			} else if (n == 9) {
				han = "구" + han;
			} else if (n == 0) {
				han = han.substring(1);
			} 
			
//			System.out.println(han);
									
		}
		
		System.out.println(han + "원");
		
	} //q4()

	private static void q3() {
		
//		요구사항] 숫자를 입력받아 3자리마다 ','를 붙이시오
//		입력] 숫자 : 1234567
//		출력] 1,234,567
//		조건] %,d 사용불가
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("숫자 입력 : ");
		String num = scan.nextLine();
		String temp = "";
		String result = "";
		int i=0;
		
		for(i=0 ; i<num.length() ; i++) {
			
			if(num.length()-3*(i+1) < 0) {
				break;
			}
			
				temp = num.substring(num.length()-3*(i+1), num.length()-3*i);
		
				result = "," + temp + result;
		
//				System.out.println(result);			
			} //for
		
		temp = num.substring(0, num.length()-3*i);
		
//		System.out.println(temp);
		
		result = temp + result;	
		
		System.out.println(result);	
		
	} //q3()

	private static void q2() {
		
//		요구사항] 숫자를 입력받아 항상 3자리로 출력하시오.
//		입력] 숫자 : 1
//		출력] 결과 : 001
//		입력] 숫자 : 24
//		출력] 결과 : 024
//		입력] 숫자 : 123
//		출력] 결과 : 123
//		조건] 최대 3자리까지만 입력...
		
		Scanner scan = new Scanner(System.in);		
		
		System.out.print("세자리 이하 숫자 입력 : ");
		String num = scan.nextLine();
		
		
		
			if (num.length() < 3) {
//				String temp = num.substring(num.length(), num.length());
				if(num.length() == 2) {
					num = "0" + num;
					System.out.println(num);
				} else if(num.length() == 1) {
					num = "00" + num;		
					System.out.println(num);					
				}
				
			} else {
				System.out.println(num);
			}
		
	} //q2()

	private static void q1() {
		
//		요구사항] 문장을 입력받아 역순으로 출력하시오.
//		입력] 문자 : 안녕하세요. 홍길동입니다.
//		출력] 결과 : .다니입동길홍 .요세하녕안
//		힌트] 첨자(index)
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("이름 입력 : ");
		String str = scan.nextLine();
		String result = reverseString(str);
		
	} //q1()
	
	
	
	private static String reverseString(String str) {
		String temp = "";
		
		for (int i=str.length()-1 ; i>=0 ; i--) {
			
			char c = str.charAt(i);
			temp += c;
		}
		
		str = temp;
		System.out.println(str);
		
		return str;
	}

}
