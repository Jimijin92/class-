import java.util.Scanner;

public class Ex_Test_String {

	public static void main(String[] args) {

		// test1();
		// test2();
		// test3();
		test4();
		 test5();
//		 test6();
//		 test7();
//		 test8();
//		test8_1();
//		 test9();
//		 test10();
//		 test11();

	}

	




	private static void test6() {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.printf("주민번호 : ");
		String jumin = scan.nextLine();
		
		String juminRe = jumin.replace("-", "");
//		System.out.println(juminRe);
		String juminReRe = "";
		int juminTestNum =0;
		int juminTestNum2 =0;
		int juminTestNum3 =0;
		
		for (int i = 0; i <= 7; i++) {
			
			juminReRe = juminRe.substring(i, i+1);
//			System.out.println(juminReRe);
			
			juminTestNum = Integer.parseInt(juminReRe);
			juminTestNum2 = juminTestNum2 + juminTestNum * (i + 2);
			
			
		}
		
		for (int i = 0; i < 4; i++) {
			
			juminReRe = juminRe.substring(i+8, i+9);
//			System.out.println(juminReRe);
			
			juminTestNum = Integer.parseInt(juminReRe);
			juminTestNum3 = juminTestNum3 + juminTestNum * (i + 2);
			
			
		}
		
		juminTestNum = 11-(juminTestNum2 + juminTestNum3)%11;
//		System.out.println(juminTestNum);
		
		juminReRe =  juminRe.substring(12);
		juminTestNum2 = Integer.parseInt(juminReRe);
		
		if ((juminTestNum-10 == juminTestNum2)||(juminTestNum == juminTestNum2)) {
			String result = String.format("유효한 주민등록번호입니다.");
			
			System.out.println(result);
			
			
		} else {
			String result = String.format("유효하지 않은 주민등록번호입니다.");
			
			System.out.println(result);
			
		}
		
		
		
		
	}



	private static void test7() {

		Scanner scan = new Scanner(System.in);

		System.out.printf("email : ");
		String email = scan.nextLine();
		
		int atMark = email.indexOf("@");
		
		String id = String.format("ID : %s", email.substring(0, atMark));
		String domain = String.format("DOMAIN : %s", email.substring(atMark+1));
		
		System.out.println(id);
		System.out.println(domain);

	}



	private static void test8() {
		Scanner scan = new Scanner(System.in);

		System.out.printf("Number : ");
		String num = scan.nextLine();
		int result = 0;
		
		for(int i=0; i<num.length(); i++) {
			int number = 0;
		
			String numOutput = String.format("%d + ", number = Integer.parseInt(num.substring(i, i+1)));
			
			result = result+number;
		
			if (i == num.length()-1) {
				
				numOutput = numOutput.replace("+", "=");
				
			}
			
			System.out.print(numOutput);
			
			if (i == num.length()-1) {
				
				System.out.printf(" %d", result);
				
			}
			
		}
	}

	private static void test8_1() {
		Scanner scan = new Scanner(System.in);
		System.out.printf("Number : ");
		int num1 = scan.nextInt();
		
		for (int i =10000; i >= 1; i+=1/10) {
			System.out.println(i);
		}
		
		
		
	}


	private static void test9() {
		Scanner scan = new Scanner(System.in);
		System.out.printf("문자열 : ");
		String str = scan.nextLine();
		
		String strTrim = str.trim();
		String strRe = strTrim.replace(" ", "");
		
		String strEnd = String.format("'%s'", str.replace(strTrim, strRe));
		
		System.out.println(strEnd);		
		
	}



	private static void test10() {
		
		Scanner scan = new Scanner(System.in);
		System.out.printf("단어 : ");
		String str = scan.nextLine();
		char c = 'Z';
		
//		System.out.println((int)c);
		for (int i =0; i<str.length(); i++) {
			
			String c1 = String.format("%s", c = str.charAt(i));
			String c2 = String.format(" %s", c = str.charAt(i));
			
			
			
			if (c >= 'A' && c <= 'Z' ) {
				 
				if (i == 0) {
				
				System.out.print(c1);
				
				} else {
					
				System.out.print(c2);
					
				}
				 
			} else {
				
				System.out.print(c1);
				
			}
			
		}
		
	}



	private static void test11() {
		
		Scanner scan = new Scanner(System.in);
		System.out.printf("파일명 : ");
		String str1 = scan.nextLine();
		System.out.printf("파일명 : ");
		String str2 = scan.nextLine();
		System.out.printf("파일명 : ");
		String str3 = scan.nextLine();
		System.out.printf("파일명 : ");
		String str4 = scan.nextLine();
		System.out.printf("파일명 : ");
		String str5 = scan.nextLine();
		System.out.printf("파일명 : ");
		String str6 = scan.nextLine();
		System.out.printf("파일명 : ");
		String str7 = scan.nextLine();
		System.out.printf("파일명 : ");
		String str8 = scan.nextLine();
		System.out.printf("파일명 : ");
		String str9 = scan.nextLine();
		System.out.printf("파일명 : ");
		String str0 = scan.nextLine();
		
		String strAll = String.format("%s %s %s %s %s %s %s %s %s %s ", str1, str2, str3, str4, str5, str6, str7, str8, str9, str0);
		System.out.println(strAll);
		String extecsion1 = ".gif ";
		String extecsion2 = ".jpg ";
		String extecsion3 = ".png ";
		String extecsion4 = ".hwp ";
		String extecsion5 = ".doc ";
		
		
		String result1 = String.format(findExtension(strAll, extecsion1));
		String result2 = String.format(findExtension(strAll, extecsion2));
		String result3 = String.format(findExtension(strAll, extecsion3));
		String result4 = String.format(findExtension(strAll, extecsion4));
		String result5 = String.format(findExtension(strAll, extecsion5));
				
		
		System.out.println(result1);
		System.out.println(result2);
		System.out.println(result3);
		System.out.println(result4);
		System.out.println(result5);
		
		
		
	}



	private static String findExtension(String strAll, String extecsion) {
		int subNum = 0;
		int i = 0;
		
		for (i = 0 ; i >= 0; i++) {
			
			subNum = strAll.indexOf(extecsion);
			strAll = strAll.substring(subNum + extecsion.length());
			if (subNum == -1) {
				
				break;
				
			}
		}
		String result = String.format("%s : %d", extecsion, i);
		return result;
	}






	private static void test1() {

		// 문제1
		//
		// 요구사항] 문장을 입력받아 역순으로 출력
		// 입력] 문자 : 안녕하세요
		// 출력] 결과 : 요세하녕안
		// 힌트] 첨자(index)
		Scanner scan = new Scanner(System.in);

		System.out.printf("문자 : ");
		String str = scan.nextLine();

		for (int i = 0; i < str.length(); i++) {

			System.out.print(str.replace(str.substring(str.indexOf(str)),
					(str.substring((str.length() - 1 - i), (str.length() - i)))));

		}
		System.out.println();

	}

	private static void test2() {

		Scanner scan = new Scanner(System.in);

		System.out.printf("숫자 : ");
		String num = scan.nextLine();

		if (num.length() == 1) {
			System.out.printf("00" + num);
			System.out.println();
		} else if (num.length() == 2) {
			System.out.printf("0" + num);
			System.out.println();
		} else if (num.length() == 3) {
			System.out.print(num);
			System.out.println();
		} else {
			System.out.println("정해진 범위가 아님");
		}

	}

	private static void test3() {

		Scanner scan = new Scanner(System.in);

		System.out.printf("숫자 : ");
		int num = scan.nextInt();
		int num1 = 0;
		int num2 = 0;
		int num3 = 0;
		int num4 = 0;

		if (num > 999999999) {

			num4 = (int) (num / 1000000000);
			num1 = (int) ((num / 1000000) - (num4 * 1000));
			num2 = (int) (num / 1000) - (num1 * 1000) - (num4 * 1000000);
			num3 = num - (num1 * 1000000) - (num2 * 1000) - (num4 * 1000000000);

			System.out.printf("%d,%d,%d,%d\n", num4, num1, num2, num3);

		} else if (num > 999999 && num <= 999999999) {

			num1 = (int) (num / 1000000);
			num2 = (int) (num / 1000) - (num1 * 1000);
			num3 = num - (num1 * 1000000) - (num2 * 1000);

			System.out.printf("%d,%d,%d\n", num1, num2, num3);

		} else if (num <= 999999 && num > 999) {

			// num1 = (int)(num/1000000);
			num2 = (int) (num / 1000) - (num1 * 1000);
			num3 = num - (num1 * 1000000) - (num2 * 1000);

			System.out.printf("%d,%d\n", num2, num3);
		} else if (num <= 999 && num > 0) {

			// num1 = (int)(num/1000000);
			// num2 = (int)(num/1000) - (num1 * 1000);
			// num3 = num - (num1 * 1000000) - (num2 * 1000);

			System.out.printf("%d\n", num);

		} else {

			System.out.println("장난치면 혼난다^^");

		}

		// String word1 = "";
		//
		//// word1 = num
		//
		//
		//
		//
		//
		// String word2 = "";

		// for (int i =0; i < num.length(); i++) {
		//
		//
		//
		// }
		//
		// String sub1 = str.substring(0, str.indexOf(word1));
		//
		//
		//
		//// String sub1 = str.substring(0, str.indexOf(word1));
		// String sub2 = str.substring(str.indexOf(word1) + word1.length());
		// System.out.println(sub1 + word2 + sub2);

	}

	private static void test4() {

		Scanner scan = new Scanner(System.in);

		System.out.printf("금액(원) : ");
		String money = scan.nextLine();

		int num = money.length();
		String money1 = "";
		String money2 = "";

		System.out.print("결과 : ");

		for (int i = 0; i < money.length(); i++) {

			char numChar = money.charAt(i);

			money1 = numConversion(numChar);

			money2 = numlength(numChar, num - i);

			System.out.print(money1 + money2);

		}
		System.out.println();
		System.out.println();

	}

	private static String numlength(char numChar, int num) {

		String unit = "";

		if (num == 4) {
			if (numChar == '0') {

				unit = "";
				return unit;

			} else {
				unit = "천";
				return unit;
			}
		} else if (num == 3) {
			if (numChar == '0') {

				unit = "";
				return unit;

			} else {

				unit = "백";
				return unit;
			}
		} else if (num == 2) {
			if (numChar == '0') {

				unit = "";
				return unit;

			} else {
			}

			unit = "십";
			return unit;
		}

		return "원";
	}

	public static String numConversion(char numChar) {

		String money = "";

		if (numChar == '1') {

			money = "일";

		} else if (numChar == '2') {

			money = "이";
		} else if (numChar == '3') {

			money = "삼";
		} else if (numChar == '4') {

			money = "사";
		} else if (numChar == '5') {

			money = "오";
		} else if (numChar == '6') {

			money = "육";
		} else if (numChar == '7') {

			money = "칠";
		} else if (numChar == '8') {

			money = "팔";
		} else if (numChar == '9') {

			money = "구";
		} else if (numChar == '0') {

			money = "";
		}

		return money;
	}

	private static void test5() {
		
		String content = "안녕~ 길동아~ 잘가~ 길동아~ 또 왔지 길동아";
		String word = "길동";
		int subNum = 0;
		int i = 0;
		
		
		for (i = 0 ; i >= 0; i++) {
			
			subNum = content.indexOf(word);
			content = content.substring(subNum + word.length());
			if (subNum == -1) {
				
				break;
				
			}
		}
		
		String result = String.format("길동을 총 %d회 발견했습니다.", i);
		
		System.out.println(result);
		
		
		
		
		
		
		/*	//replace() 사용
		String content = "안녕~ 길동아~ 잘가~ 길동아~";
		String word = "길동";
		
		String content2 = content.replace(word, "");
		int word2 = (content.length() - content2.length())/word.length();
		
		String result = String.format("길동을 총 %d회 발견했습니다.", word);
		
		System.out.println(result);
		
		*/

	}

}
