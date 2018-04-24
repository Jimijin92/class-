//import java.io.BufferedReader;						//클래스를 import
//import java.io.InputStreamReader;						//패키지를 import
import java.io.*; //io라는 상자안에 있는 모든 클래스를 가지고 오겠습니다.

//java.lang // String, System 들어있음, 기본패키지(import하지 않아도 사용 가능)






class Ex12_BufferedReader {

	public static void main(String[] args) throws Exception {


	//Ex12_BufferedReader.java

	//System.in.read(); //바이트 단위 입력
	//BufferedReader    //문자 단위 입력

	//System.out.print("문자 입력 : ");

	BufferedReader reader = new BufferedReader(new
    InputStreamReader(System.in));


	//BufferedReader reader = 데이터; 

	//int n = reader.read();
	//System.out.println((char)n);


	
	//String str = reader.readLine();
	//System.out.println(str);

	
	//str = reader.readLine();
	//System.out.println(str);

	// 엔터값을 만나기 전까지만 읽어들임
	// 남는건 자동으로 버리고 끝남 

	//입력받을 수 있는 데이터의 형태?
	//1. 문자
	//System.in.read()
	//reader.read() -> 문자 코드 반환
	//reader.readLine() -> 문자열 반환
//=======================================================
	//요구사항] 숫자 1개 입력 + 100을 하시오.
	//String num = reader.readLine(); // 5 -> "5"
	//System.out.println(num);
	//System.out.println(num + 100);

	//int code = reader.read();
	//System.out.println(code - 48 +100); //앞에과정을 통해서 숫자를 만들고 뒤에과정을 통해서 연산을 하면 됨 
//===============================================================================================================
	//요구사항] 숫자 2자리 입력 + 100을 하시오.
	
	/*
	int num;
	int code = reader.read();
	System.out.println(code - 48);


	num = (code - 48)*10;
	
	code = reader.read();
	System.out.println(code - 48);

	num = num + (code - 48);

	System.out.println(num + 100);

	*/
//=====================================================================================================
	//String str = reader.readLine();
	//System.out.println(str + 100);   //"25" ->25

	//System.out.println(Integer.parseInt(str) + 100); //형변환은 아니지만 형변환에 준하는 행동
//=========================================================================================================

	//문자열 -> int


	//자료형 -> Wrapper Class(Util Class)
	//byte -> Byte 
	//short -> Short
	//int -> Integer
	//long -> Long
	//float -> Float
	//double -> Double
	//boolean -> Boolean

	System.out.println(Integer.parseInt("100")); //100
	System.out.println(Byte.parseByte("100")); 
	System.out.println(Double.parseDouble("3.14")); 
	System.out.println(Boolean.parseBoolean("true")); 

	//int의 최대값? 유틸클래스 통해서 확인
	System.out.println(Integer.MAX_VALUE);
	System.out.println(Integer.MIN_VALUE);


	//reader.readLine() 사용 시
	// - 숫자 입력 -> "문자열" -> util Class ParseXXX() 사용 -> 숫자
	// - 문자열 입력 -> "문자열"
	// - 문자 입력 -> "문자열" -> '문자'


	String str = reader.readLine();
	//System.out.println(str);//"a" -> 'a'((char)str) 하면 안됨  
	System.out.println((int)str.charAt(0));
	//문제는 char라는 클래스가 없음 그래서편법으로 사용
	




	
//=====================================================================






























	}

}
