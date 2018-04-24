
public class h07 {
	public static void main(String[] args) {
		m7();
	}
	private static void m7() {
		
		//문제풀이
		int s[][] = new int[5][5];
		int n = 1;
		int r1[] = new int[4];
		int r2[] = new int[4];
		int r = 0;
		
		for (int i=0; i<s.length-1; i++) {
			for(int j=0; j<s[0].length-1; j++) {
				s[i][j] = n;
				r1[i] += n;
				r2[j] += n;
				n++;
			}//2중 for문
		}//for문
		
		for (int i=0; i<s.length-1; i++) {
			for (int j=s[0].length-1; j<s[0].length; j++) {
				s[i][j] = r1[i];
			}//2중 for문
		}//for문
		
		for (int i=s.length-1; i<s.length; i++) {
			for (int j=0; j<s[0].length-1; j++) {
				s[i][j] = r2[j];
				r = r2[j] + r;
			}//2중 for문
		}//for문
		
		s[s.length-1][s[0].length-1] = r;
		
		//출력
		for (int i=0; i<s.length; i++) {
			for (int j=0; j<s[0].length; j++) {
				System.out.printf("%4d", s[i][j]);
			}
			System.out.println();
		}
		
	}//m7
}
