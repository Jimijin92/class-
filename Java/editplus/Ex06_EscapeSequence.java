class Ex06_EscapeSequence {

	public static void main(String[] args) {
	//Ex06_EscapeSequence.java 
	//	- 특수문자
	//	- Escape Character
	//	- 자료형이 char형
	//	- 출력을 위한 데이터가 아니라 이미 약속된 행동을 하기 위한 특수한 문자


	//1. \n
	//	- new line
	//	- 개행 문자
	char c1 = '\n';


	String s1 = "안녕하세요.\n홍길동님";
	System.out.println(s1);
	

	//2. \r 
	//	- carriage return
	//	- 커서(캐럿)의 위치를 현재 라인의 처음(첫번째 컬럼)으로 이동해라
	System.out.println("하나둘\r셋넷");

	//엔터 = \r + \n
	System.out.println("하나\r\n둘");
	System.out.println("하나\n둘");

	//3. \b
	//	- backspace (길자 위에 덮어쓰기 한거임)
	System.out.println("홍길\b동");
	System.out.println("홍길동아\b\b\b\b무개");


	//4. \t
	//	- tab? 가장 가까운 텝으로 이동해라 -> 열맞추기 위해서 사용한다.
	System.out.println("홍길\t동");


	String name = "홍길동";
	String height = "18";
	String adress = "서울시 강남구 역삼동";
	
	System.out.println("이름 : \t" + name); //concat
	System.out.println("키 : \t" + height + "cm"); 
	System.out.println("집주소 : \t" + adress); 

	System.out.println("문자열" + 100);//100은 "100과 같다"
	

	//5. \", \', \\

	//요구사항] 화면에 <안녕하세요. "홍길동"입니다.> 
	System.out.println("안녕하세요. \"홍길동\"입니다.");

	//요구사항] 현재 수업 폴더의 경로를 출력
	String path = "D:\\Class\\JAVA";
	System.out.println(path);

	// \f, \a
	//숫자데이터를 사용할 때 생각할 점 
	//주민등록번호의 앞자리를 저장해야 한다.
	// - 901220
	int jumin1 = 901220;
	System.out.println("주민번호 : " + jumin1);

	jumin1 = 011125;
	System.out.println("주민번호 : " + jumin1);

	String jumin2 = "011125"; //0으로 시작하면 진법이라 ""붙여주기
	System.out.println("주민번호 : " + jumin2);
	
	//주민번호, 전화번호, 상품번호, 학생번호, 글번호 등....
	// - 형태는 숫자이지만 실제 성질은 문자열 
	// - 내가 가진 데이터가 산술 연산을 할까나? 주민번호 더하기 100? 게시판 100번 더하기 100?



		//식별자 표기법 -> 패턴
		
		//1. 헝가리언 표기법
		//	- 자료형을 식별자에 넣는 방법
		//  - 자바) 인터페이스명(Itest)
		
		String name;
		String strName;

		int num;
		int inum;


		//2. 파스칼 표기법
		//	- 식별자가 한단어 혹은 한단어 이상으로 구성 -> 모든 단어를 공백없이 연결 + 모든 문자 소문자 + 각단어의 첫문자 대문자 
		//	- 자바) 클래스명
		String StudentName;

		NumberPaser

		//3. 캐멀 표기법
		//	- 식별자가 한단어 혹은 한단어 이상으로 구성 -> 모든 단어를 공백없이 연결 + 모든 문자 소문자 + 각단어의 첫문자 대문자 + 시작 문자만은 소문자로
		//	- 자바) 변수명, 메소드명
		String studentName;
	





















	}

}
