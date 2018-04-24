class Ex11_Input {

	public static void main(String[] args) throws Exception {

	//Ex11_Input.java
	//콘솔 입력 -> 키보드를 통한 입력(내용)을 자바 프로그램에서 사용하기
	
	//1.System.in.read()
	//2. BufferedReader 클래스
	//3. Scanner 클래스
    
	//요구사항] 사용자로부터 문자 1개를 입력받아서 그대로 출력하시오.
	

	//block 걸렸다.
	//입력 대기 상태..



	/*	

	System.out.print("문자입력 : "); //Label (문자입력바로옆에 뜨게하려면 println 말고 print)

	int n = System.in.read(); // System.in.read(); 는 1byte를 읽어서 int로 반환합니다. int data=System.in.read();
	
	
	//System.out.println(n);
	System.out.printf("입력하신 문자는 '%c'입니다.\n", (char)n);

	*/
	


	System.out.print("문자입력 : "); 
	
	int n = System.in.read();
	System.out.println(n);

	n = System.in.read();
	System.out.println(n);

	n = System.in.read();
	System.out.println(n);

	n = System.in.read();
	System.out.println(n);

	n = System.in.read();
	System.out.println(n);

	//입력버퍼라는곳에 데이터 저장,  read를 호출하면 입력버퍼에 가서 읽어옴 , 앤터는 \r\n, 실제로는 세글자가 들어가있는것 a\r\n, 한번 읽은 글자는 다시 안읽음
	//한개 읽으면 2개 남아있으니까 읽으라는 소리 안하고 알아서 다음거 읽음 \r의 값은 13, \n의 값은 10, 그래서 4번째부터는 다시 요구함,
	//프로그램 종료시 버퍼에 남아있던 것도 버림
	// 카톡 메모리입출력 등등 모두 버퍼 사용 이유는 나중에 



	


	}

}
