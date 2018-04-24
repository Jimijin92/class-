import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class test6 {
	
	public static void main(String[] args)	throws Exception {


		//문제6.
		//요구사항] 서기 1년 1월 1일부터 2017년 12월 6일까지 총 며칠이 지났는지 구하시오.
		//출력] 총 4,563,543일 지났습니다.
		//조건] Calendar 사용 금지
		//사용] for문 사용, 윤년 계산
		//검증] 결과 %7 = ?


			BufferedReader reader
			= new BufferedReader(new InputStreamReader(System.in));

		int day = 0;
		int sum = 0;

		for(int i=1;i<2018 ;i++){

				if(i==2017){ 
					sum = sum+day-26;
				
					break;
				}//if				

			if(i % 4 != 0){
				day = 365;
			}else if(i % 100 != 0){
				day = 366;
			}else if(i % 400 == 0) {
				day = 366;
			}else{ 
				day = 365;
			}


			sum += day;

		}//for
	System.out.println(sum);
	System.out.println(sum%7);

	}//main
	}//class