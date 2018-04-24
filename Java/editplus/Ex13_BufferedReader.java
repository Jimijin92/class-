//1.
import java.io.BufferedReader;
import java.io.InputStreamReader;

class Ex13_BufferedReader {

	public static void main(String[] args) throws Exception { //2.
		//Ex13_BufferedReader.java


		char c1 = ' '; //비어있으면 허용 안됨
		System.out.println(c1);

		String s1 = "";//= 빈문자열, Empty String //비어있어도 허용됨
		System.out.println(s1);

//==============================================================================================
		//int num = 0;

		//System.out.println(num+10);
		//모든 변수는 null 상태일때는 사용불가, 변수는 초기화를 하지 않으면 사용할 수 없다.
//==============================================================================================


		BufferedReader reader = new BufferedReader(new
		InputStreamReader(System.in));

		//요구사항] 태어난 년도를 입력받아 나이를 출력하시오.
		//			2017 - 태어난 년도 = 나이
		System.out.print("태어난 년도 : ");

		String input = reader.readLine(); // "1990"

		int age = 2017 - Integer.parseInt(input);

		System.out.printf("%s년도 태어난 사람은 %d세입니다.\n", input, age);


		//요구사항] 숫자를 2개 입력받아 아래와 같은 연산식을 출력
		//			2.5 + 3.4 = 5.9
		//조건] 소수 이하 1자리까지만 출력
		

		System.out.print("첫번째 숫자 : ");
		String input1 = reader.readLine();
		double num1 = Double.parseDouble(input1);

		System.out.print("두번째 숫자 : ");
		String input2 = reader.readLine();
		double num2 = Double.parseDouble(input2);

		System.out.printf("%.1f + %.1f = %.1f\n", num1, num2, num1 + num2);   








	}

}
