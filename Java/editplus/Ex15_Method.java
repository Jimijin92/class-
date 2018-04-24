
//클래스
//	- 메소드의 집합
class Ex15_Method {
	
	//메소드
	//main 메소드
	//	- 특수한 메소드
	//	- JVM이 호출한다 -> main();
	//	- 프로그램 시작점 (start Point)
	//	- 프로그램 통틀어 main메소드는 유일하다.
	//	- 필요에 따라 서로서로 부를 수 있다. 
	public static void main(String[] args) {
		 

		//Ex15_Method.java

		//메소드, Method
		//	- 함수(Function, 프로시저(Procedure), 루틴(Routine))..
		//	- 클래스 내부에서 선언된 함수

		//	- (객체의) 행동, Behavior

		//메소드 장점(특징)
		//1. 반복되는 코드를 1번만 정의 x 재사용(***) /// 코드 재사용성이 높습니다.
		//2. 코드의 성격을 나타낸다. -> 가독성 높음 -> 그룹역할 

		//요구사항] "안녕하세요" x 5번 출력
		//수정사항] "반갑습니다"
		System.out.println("반갑습니다");
		System.out.println("안녕하세요");
		System.out.println("안녕하세요");
		System.out.println("안녕하세요");
		System.out.println("안녕하세요");

		//1. 메소드 선언하기
		//2. 메소드 호출하기

		//2. 메소드 호출하기(사용하기)
		//	- 이름을 부른다.
		hello();
		hello();
		hello();
		hello();
		hello();
		
		//이곳에서 딱 1번만 사용
        count();		
	} //main

	//클래스 영역
	//1. 메소드 선언하기
	//	- 클래스 내부에서만 선언 가능
	//	- 다른 메소드 내부에서 선언 불가능
	//	- 메소드 순서는 무관

	//public : 접근 지정자(제어자), Access Modifier
	//static : 정적 키워드 
	//void : 반환 타입
	//파란색 글자는 예약어
	//hello : 메소드명(식별자 - 여러 메소드 중 이 메소드를 구별)
	//() : 인자 리스트, 매개변수 목록, Arguments, parameters
	//{} : 메소드 구현부(**), 메소드 몸통
	public static void hello() {
		System.out.println("Hi~");
	}

    public static void count() {
		System.out.println("오");
		System.out.println("사");
		System.out.println("삼");
		System.out.println("이");
		System.out.println("일");

    }
} //class Ex15
