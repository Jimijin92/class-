import java.util.Scanner;

public class m11 {
	
	public static void main(String[] args) {

//		문제11.
//
//		요구사항] 성적을 입력받아 출력하시오.
//		입력] 국어 : 80
//			  수학 : 50
//			  영어 : 70
//		사용] 10 x 3 배열
//			  String [][] score = new String[10][3];
//
//			*
//			*		*
//			*		*
//			*	*	*
//			*	*	*
//			*	*	*
//			*	*	*
//			*	*	*
//		=================
//			국	수	영

		Scanner scan = new Scanner(System.in);
		System.out.print("점수를 입력해 주세요\n국어 : ");
		int kor = scan.nextInt();
		System.out.print("수학 : ");
		int math = scan.nextInt();
		System.out.print("영어 : ");
		int eng = scan.nextInt();
		System.out.println();System.out.println();
		
		h11 (kor, math, eng);
		System.out.println();System.out.println();
	
	} //main
	
	
	private static void h11 (int kor, int math, int eng) {
		
		//문제 풀이
		String [][] score = new String [10][3];
		int s[] = {kor, math, eng};
		String star = "*";
		
		for (int i=score.length-1; i>=0; i--) {
			for (int j=0; j<score[0].length; j++) {
				if (s[j]/10%10>i) {
					//System.out.print("\t*");
					score[i][j] = star;
				} else {
					score[i][j] = "";
				} //if
			} //2중 for문
		} //for문
		
		//출력
		for (int i=score.length-1; i>=0; i--) {
			for (int j=0; j<score[0].length; j++) {
				System.out.printf("\t%s", score[i][j]);
			}//2중 for문
			System.out.println();
		}//for문
		
		System.out.println("=================================");
		System.out.println("\t국\t수\t영");
	}//m11
	
} //class
