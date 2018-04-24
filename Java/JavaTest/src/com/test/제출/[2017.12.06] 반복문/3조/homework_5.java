
class homework_5 {
	public static void main(String[] args) 
	{
		
		loop();
		
		
	}//main

/*
문제5. 
요구사항] 아래와 같이 출력 45
출력] 1 + 2 + 3 + 4 + 5 + 6 + 7 +... + ? = 10XX
조건] 누적값이 1000을 넘어가는 순간까지만 출력하시오
사용] 무한 루프 + break
*/


	
	public static void loop () {
		int num = 0; 
		
		for (int i=1; ; i++) {
			num += i; //누적합계
			if (num < 1000) {
				System.out.printf("%d + ", i);
			} else {
				System.out.printf("%d = ", i);
			}//if
			if (num > 1000){
				break;
			}
		}//for
		System.out.printf("%d\n", num);
	}//loop 5.


}//class