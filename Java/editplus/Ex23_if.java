import java.util.Calendar;

class Ex23_if {

	public static void main(String[] args) {

		//Ex23_if.java

		//m1();
		//m2();
		//System.out.println(m3());//매개변수, 반환값 두가지 반드시 지켜주기 
		//m4();
		//m5();
		m6();

	} //main

	public static void m6() {
	
		// 요구사항] 문자 1개 입력 -> 영소문자?
		String input = "e";

		char c = input.charAt(0); //"e" -> 'e'
		
	    int code = (int)c;//101



		//if (code >= 97 && code <= 122){
		//if (code >= (int)'a' && code <= (int)'z'){
		if (c >= 'a' && c <= 'z'){
			System.out.println("소문자O");
		} else {
			System.out.println("소문자X");
		} 



		c = 'D';
	
	    if ((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z') || (c >= '0' && c <= '9')) {
			System.out.println("영문자 + 숫자O");
		} else {
			System.out.println("영문자 + 숫자X");
		} 


	}//m6

    public static void m5() {
		//중첩된 if문, Nested if Statements
		/*
			if() {
				if () {
				    if () {
					
					}
				}

			} else if() {
			
			} else {
			
	        }

		*/
		//국어 점수 입력 -> 합격, 불합격?
		//조건 : 60점 이상
		int kor = 100;
		if(kor >= 60){
		System.out.println("합격");
		} else {
		System.out.println("불합격");
		}


		if(kor < 60){
		System.out.println("불합격");
		} else {
		System.out.println("합격");
		}
        // else 보다 if가 긍정적인 업무, 결과는 같지만 합 불 순으로 쓰기 


		//유효성 검사
        if (kor >= 0 && kor <= 100) {

            //비즈니스 코드, 업무 코드
			if (kor >= 60) {
		       System.out.println("합격");
		    } else {
		       System.out.println("불합격");
		    }
		
		} else {
			//예외 처리 코드
			System.out.println("점수 다시입력");
		}


		/*
        kor = ; // 0~100이어야 함, 따라서 사전에 미리 자격조건 갖춰야함
		if(kor >= 60){
		System.out.println("합격");
		}else {
		System.out.println("불합격");
		}
		*/

		

	}


	public static void m4() {

	 System.out.println("하나");

     Calendar c = Calendar.getInstance();

	 if (c.get(Calendar.SECOND) % 2 == 0){
		return; //빈 return문 -> 메소드 종료
	 }


	 System.out.println("둘");
	 System.out.println("셋");
	
	
	}








	public static String m3(){
		//return문

		int num = -10;

		if (num > 0){
		    return "통과";
        // 거짓일 경우도 생각, 컴파일러는 실제 숫자가 아닌 문법검사만 함 
		// 모든 경우의 수의 끝에 리턴이 존재해야 한다.
		}

		return "실패";


	}//m3

	public static void m2(){
	
	    //이렇게는 안쓰는 문장-> 무조건 참이니까, 아래 boolean처럼 씀
		if(true){
			System.out.println("참");
		} else {
			System.out.println("거짓");
		}
	


		

		boolean flag = true;//변수로 넣는 경우 


		if(flag){
			System.out.println("참");
		} else {
			System.out.println("거짓");
		}



		//C -> Java
		//C언어 : boolean이 없다.
		// - 정수 : 0(false), 나머지(true)
		// - 실수 : 0.0(false), 나머지(true)
		// - 문자 : \0 (false), 나머지(true)
		// - 문자열 : ""(false), 나머지(true)
		if(flag){
			System.out.println("참");
		} else {
			System.out.println("거짓");
		}



	}//m2


	public static void m1() {

		//요구사항] 숫자 1개 입력받아 짝수? 홀수?
		int num = 5;
		String result = " "; //모든 변수는 무조건 초기화 시켜놓고 시작하기// 오류 방지하기 위해서 

		if (num % 2 == 0){
			//짝수 
			//System.out.printf("입력한 숫자 %d는 짝수입니다.\n", num);
			result = "짝수";
		} else{
			//홀수
			//System.out.printf("입력한 숫자 %d는 홀수입니다.\n", num);
			result = "홀수";
		}
	
		System.out.printf("입력한 숫자 %d는 %s입니다.\n", num, result);
	    //컴파일러는 아무것도 만족못한 경우도 생각함. 그 경우 result 초기화 안돼있으면 출력할게 없어서 오류남
	
	}//m1

}
