import java.util.Scanner;

public class quiz_1208 {
	
public static void main(String[] args) {

//m1();
m2();
//m3();
//m5();	
//m7();
//m8();
	
	
	
	
	
	
	
	
	
	
}//main

private static void m8() {

	Scanner scan = new Scanner(System.in);
	System.out.print("숫자 : ");
	String input = scan.nextLine();
	
	System.out.println(input);
	
	
}

private static void m7() {

	String email = "hong@naver.com";
	
	int gol = email.indexOf("@")+1;
	
	System.out.println(email.substring(gol)); //도메인 추출
	
	System.out.println(email.substring(0, gol-1)); //아이디 추출
	
	
			
			
	
	
	
	
	
	
}

private static void m5() {

	
String content = "안녕~길동아~ 잘가~길동아~";	
String word = "길동";	
int time = 0;

for(int i=0; i>content.length(); i++) {

	if(content.indexOf(word)<-1) {
		time += 1;
		
	}
	
}


System.out.printf("'%s'을 총 %d회 발견했습니다.",word,time);	
	
	

	
	
	
}

private static void m3() {

	Scanner scan = new Scanner(System.in);
	System.out.print("숫자 : ");
	String number = scan.nextLine();
	

	
	for(int i = number.length()-3; i>0; i -= 3) {
		
		// 글자수 -3 부터 시작해서 -될때까지, 글자수 -3을 누적
	String temp1 = number.substring(0,i);
	String temp2 = number.substring(i);
	number = temp1 + "," + temp2;
		
			
	}
	System.out.println(number);
	
	
	
	
	
	
}

private static void m2() {

	Scanner scan = new Scanner(System.in);
	System.out.print("숫자 : ");
	int inputNum = scan.nextInt();
	
	if(inputNum<10) { 
		System.out.printf("결과 : 00"+"%d\n",inputNum);
		
		
	}else if(inputNum>=10 && inputNum<100){
		System.out.printf("결과 : 0"+"%d\n",inputNum);
		
		
	}else {
		System.out.printf("결과 : %d",inputNum);
	}
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

public static void m1(){
	
	
	//입력받기
	Scanner scan = new Scanner(System.in);
	System.out.print("문자 : ");
	String input = scan.nextLine();
	
	
	//출력하기
	// i 시작값 = input의 길이값 -1
	// i 종료  = i가 0보다 클때까지 (마이너스가 되기전 까지)
	// 최초값부터 계속 마이너스
	for (int i = input.length()-1; i>=0; i--) {
		
		System.out.print(input.charAt(i));
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}//m1













}//class