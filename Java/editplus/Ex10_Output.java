class Ex10_Output {

	public static void main(String[] args) {

		//Ex10_Output.java

		//printf()
		//1. %숫자d
		//	- 출력할 내용을 최소 너비
		//	- 양수/음수
		//	- 모든 형식 문자에 적용

		System.out.printf("[%d]\n",100);
		System.out.printf("[%10d]\n",100);// 총 열자리 100(3자리)사용했으니까 공백 7자리 
		System.out.printf("[%-10d]\n",100); //음수는 우측정렬
		
		System.out.printf("[%10d]\n",123845879305L);

		System.out.printf("[%d]\n",100);

		

		//2. %.숫자f
		//	- 실수형에만 적용 가능
		//	- 소수 이하 자릿수 지정

		System.out.printf("%f\n", 3.1234);
		System.out.printf("%,f\n", 3.1234);
		System.out.printf("%,f\n", 3.1934);  //위에거랑 비교해서 반올림 체크 2->9로 바꿔서 
		
		

		//3. %,d
		//	- 숫자형만 가능(%d,%f)
		//	- 자릿수 표기
		System.out.printf("%d\n", 12345678);
		System.out.printf("%,d\n", 12345678);
		

		//한번에~
		System.out.printf("%,15.2f\n", 12987.6543);  //자릿수는 컴마와 닷도 포함

		//주소록

		String name1 = "홍길동";
		String address1 = "서울시 강남구 역삼동";
		String email1 = "hong@naver.com";
		int salary1 = 20000;
		 
		String name2 = "테스트";
		String address2 = "서울시 중구";
		String email2 = "test@naver.com";
		int salary2 = 500;


		System.out.println("==============================================");
		System.out.println("           주소록");
		System.out.println("==============================================");
		System.out.println("[이름]\t[급여(원)]\t[주소]\t\t\t[이메일]");

		
		System.out.printf("%s\t%,10d\t%-14s\t%s\n", name1, salary1, address1, email1);
		System.out.printf("%s\t%,10d\t%-14s\t%s\n", name2, salary2, address2, email2);


		//출력 시 주의사항
		//1. 숫자는 단위 기재(***)
		//2. 정렬
		//	a. 문자(열)
	    //		1. 좌측
		//			- 가변 길이
		//		2. 가운데
		//			- 고정 길이
		//  b. 숫자
		//		1. 좌측
		//		2. 가운데
		//			- 010-123-4567
		//			- 010-1234-5678
		//		3. 우측
		//		    - 수치(비교)




	}

}
