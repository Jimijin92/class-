
public class quizNumber2 {
public static void main(String[] args) {
	
m2();
/*
요구사항] 아래와 같이 출력하시오.

25	24	23	22	21
20	19	18	17	16
15	14	13	12	11
10	9	8	7	6
5	4	3	2	1
*/
}
private static void m2() {
	int [][]nums = new int[5][5];
	System.out.println(nums.length);
	
	int n = 1;
	
	//배열 초기화
	for (int i = nums.length-1; i>=0; i--) {
		for(int j=nums.length-1; j>=0; j--) {
			nums[i][j] = n;
			n++;
			
		}
		
	}
	
	//출력용(수정 금지)
	for (int i =0; i<5; i++) {
		for(int j =0; j<5; j++) {
			System.out.printf("%4d",nums[i][j]);
		}
		System.out.println();
	}

}

}
