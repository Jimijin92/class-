import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.Calendar; //필요한 도구들은 import

class Problems3 {

	public static void main(String[] args) throws Exception{
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


		//문제 1
		System.out.print("태어난 년도 : ");
		String age = reader.readLine();
		int myAge = Integer.parseInt(age);

		currentAge(myAge);


		//문제 2
		System.out.print("남자 이름 : ");
		String man = reader.readLine();

		System.out.print("여자 이름 : ");
		String woman = reader.readLine();

		System.out.print("년 : ");
		String year = reader.readLine();
		int yearInt = Integer.parseInt(year);

		System.out.print("월 : ");
		String month = reader.readLine();
		int monthInt = Integer.parseInt(month);

		System.out.print("일 : ");
		String date = reader.readLine();
		int dateInt = Integer.parseInt(date); //데이터 입력부

		anniversary(man, woman, yearInt, monthInt, dateInt);


		//문제 3
		System.out.print("시 : ");
		String hour = reader.readLine();
		int hourInt = Integer.parseInt(hour);

		System.out.print("분 : ");
		String minute = reader.readLine();
		int minuteInt = Integer.parseInt(minute);

		delivery(hourInt, minuteInt);

		
	} //main

	public static void currentAge(int n) {
		
		Calendar now = Calendar.getInstance();
		Calendar birth = Calendar.getInstance();


		//now.set(Calendar.MONTH, 0);
		//now.set(Calendar.DATE, 0);
		now.set(Calendar.HOUR, 0);
		now.set(Calendar.MINUTE, 0);
		now.set(Calendar.SECOND, 0);
		
		birth.set(Calendar.YEAR, n);

		long birthYearTick = birth.getTime().getTime();
		long nowTick = now.getTime().getTime();

		double result = ((nowTick - birthYearTick) / 1000.0 / 60 / 60 / 24 / 365);

		System.out.printf("%d년생은 %.1f살 입니다.\n\n", n, result+1);

	
	} //currentAge


	public static void anniversary(String man, String woman, int year, int month, int date) {
		
		Calendar now = Calendar.getInstance();

				
		System.out.println("===============================");
		System.out.printf("    '%s'와(과) '%s'의 기념일      \n", man, woman);
		System.out.println("===============================\n");

		/*
		now.add(Calendar.DATE, 100);
		System.out.printf("100일 : %tF\n", now);

		now.add(Calendar.DATE, 100);
		System.out.printf("200일 : %tF\n", now);

		now.add(Calendar.DATE, 100);
		System.out.printf("300일 : %tF\n", now);

		now.add(Calendar.DATE, 200);
		System.out.printf("500일 : %tF\n", now);

		now.add(Calendar.DATE, 500);
		System.out.printf("1000일 : %tF\n\n", now);
		*/ //YYYY-MM-DD표기
				
		now.add(Calendar.DATE, 100);
		System.out.printf("100일 : %d년 %d월 %d일\n", now.get(Calendar.YEAR), now.get(Calendar.MONTH) + 1, now.get(Calendar.DATE));

		now.add(Calendar.DATE, 100);
		System.out.printf("200일 : %d년 %d월 %d일\n", now.get(Calendar.YEAR), now.get(Calendar.MONTH) + 1, now.get(Calendar.DATE));

		now.add(Calendar.DATE, 100);
		System.out.printf("300일 : %d년 %d월 %d일\n", now.get(Calendar.YEAR), now.get(Calendar.MONTH) + 1, now.get(Calendar.DATE));

		now.add(Calendar.DATE, 200);
		System.out.printf("500일 : %d년 %d월 %d일\n", now.get(Calendar.YEAR), now.get(Calendar.MONTH) + 1, now.get(Calendar.DATE));
		
		now.add(Calendar.DATE, 500);
		System.out.printf("1000일 : %d년 %d월 %d일\n\n\n", now.get(Calendar.YEAR), now.get(Calendar.MONTH) + 1, now.get(Calendar.DATE));
		
		
	} //anniversary


	public static void delivery(int hour, int minute) {

		Calendar time = Calendar.getInstance();
		
				
		time.set(Calendar.HOUR, hour);
		time.set(Calendar.MINUTE, minute);
	

		time.add(Calendar.MINUTE, -10);
		System.out.printf("짜장면 : %d시 %d분\n", time.get(Calendar.HOUR_OF_DAY), time.get(Calendar.MINUTE));

		time.add(Calendar.MINUTE, -8);
		System.out.printf("치킨 : %d시 %d분\n", time.get(Calendar.HOUR_OF_DAY), time.get(Calendar.MINUTE));

		time.add(Calendar.MINUTE, -7);
		System.out.printf("피자 : %d시 %d분\n\n", time.get(Calendar.HOUR_OF_DAY), time.get(Calendar.MINUTE));
	
	} //delivery


} //Class Problems3
