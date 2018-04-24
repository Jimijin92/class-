import java.io.BufferedReader;                               
import java.io.InputStreamReader;




class Examif

{
	public static void main(String[] args) throws Exception 
	{
	m2();
	

	 /*문제 2.
	 요구사항] 점수를 입력받아 성적을 출력하시오.
	 입력]  점수 : 85
	 출력] 입력한 점수 85점은 B입니다.

	 조건] 90~100:A
		   80~89:B
		   70~79:C
		   60~69:D
		   0~59:F */

	}//main
	
	
	
	
	public static void m2()throws Exception {

 
	 

		    BufferedReader reader = new BufferedReader(new
			InputStreamReader(System.in));
								 
	 

			System.out.println("점수 :");
			String score=reader.readLine();
			  
			int intscore=Integer.parseInt(score); 

  

		    if(intscore>=90){
				System.out.printf("입력한 점수 %d는 A학점입니다\n.",intscore);
			}			
			else if(intscore>=80){
				System.out.printf("입력한 점수 %d는 B학점입니다\n.",intscore);
			}				
			else if (intscore>=70){
				System.out.printf("입력한 점수 %d는 C학점입니다\n.",intscore);
			}
			else if (intscore>=60){
				System.out.printf("입력한 점수 %d는 D학점입니다\n.",intscore);
			}
			else{
				System.out.printf("입력한 점수 %d는 F학점입니다\n.",intscore);
			}
			


	}

	






}
