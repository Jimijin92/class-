class Ex18_Method {

	public static void main(String[] args) {

		//Ex18_Method.java

		//메소드 오버로딩, Method Overloading
        // - 같은 이름의 메소드를 여러개 만드는 기술
		// - 인자의 개수와 타입이 다르면 동일한 이름의 메소드를 여러개 선언할 수 있다.

		//메소드 오버로딩 구현 조건 
		// - 인자 개수 
		// - 인자 타입

		//메소드 오버로딩 구현 조건 X
		// - 인자 이름
		// - 반환값 타입

		//오버로딩의 유무 판단?
		// - 호출할 때의 상황을 생각(***)

		// - test(); //2
		// - test(10); //누구 부를지 모르게 됨, 그래서 4와 5 동시에 존재할 수 없음 
		// - test("홍길동");
		// - test(10, 20);
		// - int num = test(); -> 2, 8 구분 못함
		// - test(); -> 2, 8 구분 못함
		// - 메소드를 늘릴 때는 같은 목적을 가지고 있어야 함

		// test(10); //4
		// byte b = 10;
		// test(b); //9

		//소스를 작성 중..
        // 1. main() //o
		// 2. public static void test() {} //o
		// 3. public static void test() {} //x 2번 때문에 안됨
		// 4. public static void test(itn n) {} //매개변수 가짐, o
		// 5. public static void test(int m) {} //X(4)
		// 6. public static void test(String s) {} //o
		// 7. public static void test(int n, int m){} //o
		// 8. public static int test() {} //X (2번이랑 구분이 안 감) 
		// 9. public static void test(byte n) {} //매개변수 가짐, o
		

		//요구사항] 두 개의 데이터를 인자로 전달 -> 더해서 출력하는 메소드
		// - int + int 
		// - double + double
		// - String + String
		add(10, 20);
		add(5, 7);
		add(33, 99);

		add(3.1, 2.1);

		add("홍길동","아무개");
		
		System.out.println(100);
		System.out.println("홍길동");
		
	} //main

	public static void println(int a){
	
	}
	
	public static void println(String a){
	
	}
	
	//자바는 메소드를 구분할 때 메소드명을 사용한다.(X)
	//자바는 메소드를 구분할 때 메소드명과 인자리스트를 사용한다.(O)
	//개발 편의성을 위해 만들어진 기술 

	//add(*******)
	// - 메소드의 이름을 add라는 단어가 가장 최적인 상황
	public static void/*(반환값 없으니 void)*/add(int a, int b) {

		System.out.printf("%d + %d = %d\n", a, b, a + b);
		
	}


	public static void/*(반환값 없으니 void)*/add(double a, double b) {

		System.out.printf("%.1f + %.1f = %.1f\n", a, b, a + b);
		
	}

    public static void/*(반환값 없으니 void)*/add(String a, String b) {

		System.out.printf("%s + %s = %s\n", a, b, a + b);
		
	}




}
