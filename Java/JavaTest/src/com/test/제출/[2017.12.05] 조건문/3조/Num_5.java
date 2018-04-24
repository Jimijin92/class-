import java.io.*;

class Num_5 {
	public static void main(String[] args) throws Exception
	{

		
		//요구사항] 영문자 1개를 입력받아 대/소문자를 변환/출력하시오.




	System.out.println("♧♣♧♣♧♣♧♣♧♣♧♣♧♣♧♣♧♣♧♣♧♣♧♣");
	System.out.println("♧♣♧♣알파벳 하나만 아무거나 입력하세요♧♣♧♣");
	System.out.println("♧♣♧♣♧♣♧♣♧♣♧♣♧♣♧♣♧♣♧♣♧♣♧♣");
	BufferedReader reader = new BufferedReader(new InputStreamReader (System.in));

	System.out.print("문자 : ");
	String alphabet = reader.readLine();
	char a = alphabet.charAt(0);
	alphabetChange(a);

	}//main

	public static void alphabetChange(char a) {
		
		//int alpha = 0;
		
		//if문 사용 
		if (a >= 'a' && a <= 'z') {
			System.out.printf("결과 : 입력한 문자의 대문자는 %c 입니다\n", (char)a - 32);
			//alpha = a - 32;
		} else if (a >= 'A' && a <= 'Z') {
			System.out.printf("결과 : 입력한 문자의 소문자는 %c 입니다\n", (char)a + 32);
			//alpha = a + 32;
		} else
			System.out.println("♧♣♧♣알파벳을 입력하세요!!!!!!!!!!♧♣♧♣");   //유효성 검사

		//System.out.printf("결과 : %c\n", alpha);

	}//alphabetChange

}//class