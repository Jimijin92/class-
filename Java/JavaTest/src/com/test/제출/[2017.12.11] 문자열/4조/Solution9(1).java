
public class Solution9 {

		public static void main(String[] args) {
			solution9();
		}
		
		public static void solution9() {
			
//			요구사항]	공백 제거하시오.
//					원본] 문자열 : "		하나		둘		셋		"
//					출력] 문자열 : "		하나둘셋		"
			
			String sentence = "     하나     둘              셋             ";
			
			String 	sentence1 = "",
					sentence2 = "",
					sentence3 = "",
					result = "";
			
			for (int i = 0; i < sentence.length(); i++) {
				if (sentence.charAt(i) > 32) {
					String test = sentence.substring(i);
					sentence1 = sentence.replace(test, "");
					break;
				}
			}
			
			for (int i = sentence.length() - 1; i >= 0; i--) {
				if (sentence.charAt(i) > 32) {
					sentence3 = sentence.substring(i+1);
					break;
				}
			}
			
			sentence2 = sentence.replace(" ", "");
			
			result = sentence1 + sentence2 + sentence3;
			
			System.out.println("sentence : " + sentence);
			System.out.println("sentence1 : " + sentence1);
			System.out.println("sentence2 : " + sentence2);
			System.out.println("sentence3 : " + sentence3);
			System.out.println("result : " + result);
		}
}
