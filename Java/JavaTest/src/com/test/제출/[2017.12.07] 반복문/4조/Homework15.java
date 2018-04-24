class Homework15 {

	public static void main(String[] args) {
	
	/*
	문제15.
	요구사항] 아래와 같이 출력하시오.

	1 + 2 + 4 + 7 + 11 + 16 + ... + N = 469

	조건] 더하는 N이 100을 넘지 않을 때까지
	*/

	int temp = 1; 
	int sum = 0; 
		
		for (int i=0; ;i++) {
			temp += i; 

			if (temp > 100)
				break; 
			
			System.out.printf("%d + ", temp);

			sum += temp;
		}
			
	System.out.printf("\b\b= %d\n", sum);
	
	}

}
