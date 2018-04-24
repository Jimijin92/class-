import java.io.IOException;
import java.util.Scanner;

public class Num3_1211 {

	public static void  main(String[] args) throws IOException {
		
		m3();
		
	} //main
	
	private static void m3() {
		
//		요구사항] 숫자를 입력받아 3자리마다 ','를 붙이시오.
//	입력] 숫자 : 1234567
//	출력] 결과 : 1,234,567
//	조건] %,d 사용불가
		
		Scanner scan = new Scanner(System.in);
		System.out.print("숫자를 입력하세요 : ");
		String num = scan.nextLine();
		
		for (int i = num.length()-3; i>0; i-=3) {
			String s1 = num.substring(0, i);
			String s2 = num.substring(i);
			num = s1 + "," + s2;
		}
		System.out.println(num);
		
	} //m3
}
