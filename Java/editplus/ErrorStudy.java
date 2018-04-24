class ErrorStudy {

	public static void main(String[] args) {

//1.
    byte ageOfMyBoyfriend;
	myAge = 31;
	System.out.println("창현이의 나이는" + ageOfMyBoyfriend + "입니다.");
	//	-오류
		//Homework1.java:57: error: variable ageOfMyBoyfriend might not have been initialized
		//System.out.println("내 남자친구의 나이는" + ageOfMyBoyfriend + "입니다.");
		//심볼값이랑 정의 잘못했음 -> 용어 공부 후 수정 필요
    
	byte ageOfMyBoyfriend;
	ageOfMyBoyfriend = 31;
	System.out.println("창현이의 나이는" + ageOfMyBoyfriend + "입니다.");


//2. 
	int myAccountNumber
	myAccountNumber = 1002043711882
	System.out.println("내 계좌번호는" + myAccountNumber + "입니2017-11-29다.");
	//	-오류
	/*
	Homework1.java:71: error: ';' expected
	int myAccountNumber
    Homework1.java:72: error: integer number too large: 1002043711882
    myAccountNumber = 1002043711882
    Homework1.java:72: error: ';' expected
    myAccountNumber = 10020437118828
    */
	//초과) int 숫자범위를 잘 몰랐음. 숫자 너무 크게 설정함

//3.
	int myAccountNumber
	\myAccountNumber = 1002043711882
	\System.out.println("내 계좌번호는" + myAccountNumber + "입니다.");
    //오류
	/*
	Homework1.java:75: error: integer number too large: 1002043711882
                                                myAccountNumber = 1002043711882;
												*/
    //오타) long으로 생각하고 int로 쳐버렸음
//4.
	long myAccountNumber;
	myAccountNumber = 1002043711882;
	System.out.println("내 계좌번호는" + myAccountNumber + "입니다.");
	//오류
	/*
	Homework1.java:75: error: integer number too large: 1002043711882
                                                myAccountNumber = 1002043711882;
    */
    //누락) long은 정수값 뒤에 소문자 l이나 대문자 L붙여야 함 
//5.
	//오류
	/*
	Homework1.java:101: error: ';' expected
                                          boolean myName = true
                                                               ^
    Homework1.java:102: error: ')' expected
                                          System.out.println("내 이름은" + myName + "이다"

    ^
    Homework1.java:109: error: reached end of file while parsing
}
 ^
3 errors
	*/


//6. 
//오류
Ex08_Casting.java:12: error: not a statement
                long 11;                //복사본 8byte
                ^
Ex08_Casting.java:12: error: ';' expected
                long 11;                //복사본 8byte
                    ^
Ex08_Casting.java:28: error: ';' expected
                System.out.println(d1)

//7오류
Ex08_Casting.java:36: error: incompatible types: possible lossy conversion fro
double to float
                f2 = d2;
                     ^

//8 오류 
Ex08_Casting.java:77: error: incompatible types: possible lossy conversion from
char to short
                s5 = c5;

//9 printf에 조건 ,age 안쳤을때 컴파일은 되는데 결과창에 이렇게 뜸 
홍길동의 나이는 Exception in thread "main" java.util.MissingFormatArgumentExcept
ion: Format specifier '%d'
        at java.util.Formatter.format(Formatter.java:2519)
        at java.io.PrintStream.format(PrintStream.java:970)
        at java.io.PrintStream.printf(PrintStream.java:871)
        at Ex09_Output.main(Ex09_Output.java:55)
계속하려면 아무 키나 누르십시오 . . .










		
	}

}
