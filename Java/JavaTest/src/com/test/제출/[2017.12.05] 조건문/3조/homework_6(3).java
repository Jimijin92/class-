import java.io.*;

class homework_6 {
	public static void main(String[] args) throws Exception
	{
	BufferedReader reader = new BufferedReader(new InputStreamReader (System.in));

	/*
	문제6.
	요구사항] 주차 요금을 계산하시오.
	입력] <들어온 시간>
		   시 : 13
		   분 : 30
	    <나간 시간>
		   시 : 14
		   분 : 20
	출력] 주차 요금은 4,000원입니다.
	조건] 무료 주차 : 30분
	      초과 10분 : 2,000원		*/
	System.out.println("=========================\n	주차요금");
	System.out.print("<들어온 시간>\n시 : ");
	int hourIn = Integer.parseInt(reader.readLine());

	System.out.print("분 : ");
	int minuteIn = Integer.parseInt(reader.readLine());
	
	System.out.println();

	System.out.print("<나간 시간>\n시 : ");
	int hourOut = Integer.parseInt(reader.readLine());

	System.out.print("분 : ");
	int minuteOut = Integer.parseInt(reader.readLine());

	System.out.println();

	park(hourIn, minuteIn, hourOut, minuteOut);

	System.out.println("=========================");

	}//main

	public static void park(int inH, int inM, int outH, int outM)				throws Exception {
	if(inM <= 60 && inM >= 0 && outM <= 60 && outM >= 0){
		int in = (inH * 60) + inM;
		int out = (outH * 60) + outM;
		int parking = out - in;

		if(parking <= 39 && parking >= 0) {
			System.out.printf("주차 요금은 무료입니다.\n");
		} if(parking > 40) {
				
			if(parking % 10 == 0){
				parking =  parking - 10;
			}
				int fee = (parking / 10 * 2000)-4000;
			System.out.printf("주차 요금은 %d입니다.\n", fee);
		} else if (parking < 0) {
			System.out.println("다시 입력해 주세요.");
		}
	} else {
		System.out.println("다시 입력해 주세요.");
	}

	}//park

}//class