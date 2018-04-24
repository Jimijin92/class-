import java.util.Scanner;

public class Ex01 {

	//문제7. 

	//요구사항] 이메일 주소를 입력받아서 아이디와 도메인을 추출하시오.
	//입력] 이메일 : hong@naver.com
	//출력] 아이디 : hong
    //      도메인 : naver.com
		
	private static void m7() {
		
		Scanner scan = new Scanner(System.in);
		
		
		System.out.print("이메일 : ");
		String id = scan.nextLine();
		
		//@ 앞에있는 문자를 가져온다.(0값부터 인덱스까지)
		int index = id.lastIndexOf("@");
		System.out.println("아이디 : " + id.substring(0, index));
		
		//@ 이후에있는 문자를 가져온다. (+1를 해서 @이후의 문자를 가져온다)
		String filename = id.substring(index + 1);
		System.out.println("도메인 : " + filename);
	}
}
