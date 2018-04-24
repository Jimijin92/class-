
class h18_2017_12_07 {
	public static void main(String[] args) 
	{
		
		h18();
		
	}//main
	
	/*
	문제18.
	요구사항] 1부터 100사이의 완전수를 구하시오
	출력] 

	6 = [1, 2, 3, 6]
	28 = [1,2,4,7,14,28]

	힌트 완전수 : 자기 자신을 제외한 나머지 약수들의 합이 자신과 동일한
				  수			*/
	

	public static void h18(){
		for(int i =1; i<=100; i++) {
			
			String txt = "";
			int a = 0;	//초기화

			for(int j=1; j<i; j++) {
				
				if ((i%j)==0) {
					a += j;	//누적 후 값 출력
					txt +=  j+ "+"; //약수 출력
				}//if
			}//for

			if ((a == i )) {
				txt += i+""; //본인 추가
				System.out.printf("%s = %d\n",txt,a);
			}//if
		}//for
	}//h18

}//class