import java.util.Random;
import java.util.Scanner;

public class Array_ex12 {
	public static void main(String[] args) {
		//배열문제
		/*
		문제12 
		요구사항] 숫자 n개를 입력 받아 순차적으로 출력하시오
		입력] 총 몇개의 숫자를 입력받겠습니까? 5
			숫자 : 5
			숫자 : 4
			숫자 : 3
			숫자 : 2
			숫자 : 1

		출력] 5 > 4 > 3 > 2 > 1
		사용] 1차원 배열(n칸)
		조건] 중복 입력은 받지 않는다!! (Random)
		추후] -> 정렬 알고리즘 
		*/
		
		m12();
		
	}//main
	private static void m12() {
		Random rnd = new Random();
		
		Scanner scan = new Scanner(System.in);
		System.out.print("총 몇개의 숫자를 입력받겠습니까? ");
		int inum = scan.nextInt();
		
		Scanner sscan = new Scanner(System.in);
		
		
		int[] vs = new int[inum];
		
	
		for(int i=0 ; i<inum;i++) {
			System.out.print("숫자 : ");
			vs[i] = sscan.nextInt();
		}
		
		int[] copy = compare(vs); 
		
		for(int i=0 ; i<inum;i++) {
			
			if(i == inum -1) {
				System.out.printf("%d",copy[i]);
			}else {
				System.out.printf("%d > ",copy[i]);
			}
		}
		
	}//m12
	private static int[] compare(int[] vs) {
		
		int small = 0;
		
		for(int j = 0;j<vs.length;j++) {
			for(int i =0 ; i<vs.length-1;i++) {
				if(vs[i]<vs[i+1]) {
					small = vs[i];
					vs[i] = vs[i+1];
					vs[i+1] = small; 
					
				}else {
					vs[i] = vs[i];
					vs[i+1] =vs[i+1];
				}
			}
		}
	
		return vs;
	}
	
	
	
}//class
