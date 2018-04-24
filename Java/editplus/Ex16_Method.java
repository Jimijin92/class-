import java.io.BufferedReader;
import java.io.InputStreamReader;

class Ex16_Method {

	public static void main(String[] args) throws Exception {
    //Ex16_Method.java

	/*메소드 선언

	접근지정자 정적키워드 반환형 메소드명(인자리스트){
		구현부
	}

	*/
	
	//인자리스트

	//요구사항] "홍길동님 안녕하세요." 출력
	//System.out.println("홍길동님 안녕하세요.");
	//hello();
	
	//public static void hi(String name)
	hi("홍길동");

	//추가사항] "아무개님 안녕하세요." 출력
	//System.out.println("아무개님 안녕하세요.");
	//hello();
	hi("아무개");

	

	//추가사항] 우리 강의실의 모든 사람 대상
	//추가사항] 한독 건물   
	//추가사항] 지구인
    //hi();   매개 변수가 있음에도 데이터 안넣으면 오류 뜸
	//hi();   String에 숫자(100)넣어도 안됨
	//hi("하하하", 100); //r타입과 숫자 맞아야함
	
    add(10, 20);
	add(5, 2);
	add(22, 33);

    check("홍길동", 25);
	check("아무개", 12);
	check("히히히", 80);

		int n = num();
		System.out.println(n);
    
	bye();

	int m =5;
	int result = getSquare(m);//실인자
	System.out.println(result);
	System.out.println(getSquare(m));

	} //main





	public static void hello() {
		System.out.println("홍길동님 안녕하세요.");	
	}//hello


	public static void hi(String name) {
		//String name = "홍길동";
		System.out.println( name + "님 안녕하세요.");	
	}//hi


    public static void add(int a, int b){
		System.out.printf("%d + %d = %d\n", a, b, a + b);
	}//add


	public static void check(String name, int age) {		
		String result = (age >= 20 && age < 60) ? "통과" : "탈락";
		System.out.printf("고객 '%s'님은 '%s'입니다.\n", name, result);
	}//check


	public static int num() {
		//리턴문, 반환문
		return 10;	
	}//num

	//이름을 입력하면 인사하기
	//인풋이 먼저 일어나니까 매개변수부터 생각하기 


	public static void/*리턴값이 없는 그냥 붙인 이름 void*/ bye()throws Exception {
		BufferedReader reader 
			= new BufferedReader(new InputStreamReader(System.in));
		System.out.print("이름 입력 : ");
		String name = reader.readLine();
		System.out.printf("%s님 안녕하세요.\n", name);







    }//void

	/*유래 관련해서 
	public static void print(String msg){
	}
      public static String readLine() {
	} return "입력값"
    */

	//숫자 1개 전달 -> 제곱값을 반환
	// 2 -> 4
	// 8 ->64


	//메소드 헤더
	// -> 메소드 시그너쳐(Signature)
	// -> 메소드 서명
	public static int getSquare(int n){//가인자
	
		int result = 0;
		
		result = n * n ;

		System.out.println("작업이 완료되었습니다.");

		return result; //return 만나면 여기서 쫑냄/ 아래에서 "작업이 완료되었습니다." 문장만나면 오류남 
		

		//return n * n

		//System.out.println("작업이 완료되었습니다.");



	}



}
