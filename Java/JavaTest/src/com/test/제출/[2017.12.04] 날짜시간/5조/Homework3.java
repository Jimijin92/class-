import java.util.Calendar;
import java.util.Date;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class Homework3 {
	public static void main(String[] args)throws Exception {
		
		
		//Homework3.java
		
		//age();
		//anniversary();
		delivery();
		
	}//main()
	
	public static void age() throws Exception {
		/*
		문제1.
		요구사항] 태어난 년도를 입력받아 나이를 출력하시오.
		입력] 년도 : 1995
		출력] 나이 : 23세
		조건] 현재 년도를 기준, 우리 나라 나이
		*/
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		Calendar nowYear = Calendar.getInstance();
		int now = nowYear.get(Calendar.YEAR);
		System.out.print("년도 :");
		int year = Integer.parseInt(reader.readLine());
		int age = now - year +1;
		System.out.printf("나이 : %d\n",age);
		
	}//age()
	

	public static void anniversary() throws Exception {
		
		/*
		문제2.
		요구사항] 남자와 여자의 이름 입력 + 만날날 입력받아 -> 기념일 출력
		입력] 남자 : 홍길동
			  여자 : 호호호
			  년 : 2017
			  월 : 12
			  일 : 4
		*/
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		Calendar anniversary = Calendar.getInstance();
		System.out.print("남자 : ");
		String man = reader.readLine();
		System.out.print("여자 : ");
		String girl = reader.readLine();
		System.out.print("년 : ");
		int year = Integer.parseInt(reader.readLine());
		System.out.print("월 : ");
		int month = Integer.parseInt(reader.readLine())-1;
		System.out.print("일 : ");
		int date = Integer.parseInt(reader.readLine());

		anniversary.set(year,month,date);

		System.out.println("===============================================");
		System.out.printf("            '%s'와(과) '%s'의 기념일\n",man,girl);
		System.out.println("===============================================");
		
		anniversary.add(Calendar.DATE, 100);
		year = anniversary.get(Calendar.YEAR);
		month = anniversary.get(Calendar.MONTH)+1;
		date = anniversary.get(Calendar.DATE);
		System.out.printf("100일 : %d년 %d월 %d일 \n",year,month,date);
		
		anniversary.add(Calendar.DATE, 100);
		year = anniversary.get(Calendar.YEAR);
		month = anniversary.get(Calendar.MONTH)+1;
		date = anniversary.get(Calendar.DATE);
		System.out.printf("200일 : %d년 %d월 %d일 \n",year,month,date);

		anniversary.add(Calendar.DATE, 300);
		year = anniversary.get(Calendar.YEAR);
		month = anniversary.get(Calendar.MONTH)+1;
		date = anniversary.get(Calendar.DATE);
		System.out.printf("500일 : %d년 %d월 %d일 \n",year,month,date);

		anniversary.add(Calendar.DATE, 500);
		year = anniversary.get(Calendar.YEAR);
		month = anniversary.get(Calendar.MONTH)+1;
		date = anniversary.get(Calendar.DATE);
		System.out.printf("1000일 : %d년 %d월 %d일 \n",year,month,date);

	}//anniversary()
	
	public static void delivery() throws Exception{
		/*
		문제3.
		요구사항] 배달을 동시에 받기를 원하는 고객. 각각의 음식을 언제 주문
		조건] 짜장면10분 후 도착
			  치킨  18분 후 도착
			  피자  25분 후 도착
		입력] 원하는 도착 시각
			  시 : 17
			  분 : 30
		출력] 짜장면 : 17시 20분
			  치킨 : 17시 12분
			  피자 : 17시 5분
		*/
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("원하는 도착 시각");
		System.out.print("시 : ");
		int hour = Integer.parseInt(reader.readLine());
		System.out.print("분 : ");
		int min = Integer.parseInt(reader.readLine());

		Calendar deliveryTime = Calendar.getInstance();
		deliveryTime.set(Calendar.HOUR_OF_DAY, hour);
		deliveryTime.set(Calendar.MINUTE, min);
	

		deliveryTime.add(Calendar.MINUTE,-10);
		System.out.printf("짜장면 : %tR\n",deliveryTime);
		deliveryTime.add(Calendar.MINUTE,-8);
		System.out.printf("치킨 : %tR\n",deliveryTime);
		deliveryTime.add(Calendar.MINUTE,-7);
		System.out.printf("피자 : %tR\n",deliveryTime);


	}//delivery()

}
