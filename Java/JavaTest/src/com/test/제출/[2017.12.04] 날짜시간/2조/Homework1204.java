import java.util.*;
import java.io.*;

class Homework1204 {
	public static void main(String[] args) throws Exception
	{
		

		/*
		문제 1. 
		요구사항] 태어난 년도를 입력받아 나이를 출력하시오.
		입력]	년도 : 1995
		출력]	나이 : 23세
		조건] 현재 년도를 기준으로, 우리나라 나이 기준으로~
		*/
		System.out.println("===문제1===");
		printAge();

		/*
		문제2.
		요구사항] 남자와 여자의 이름을 입력받기 + 만난날 입력받기 ->기념일을 출력하기
		입력]	남자이름 : 홍길동
				여자이름 : 호호호
				년 : 2017
				월 : 12
				일 : 4
		출력]
		==============================
		'홍길동'와 '호호호'의 기념일
		==============================
		100일 : 2018년 3월 28일
		200일 : 
		300일 : 
		500일 :
		1000일 :
		*/
		System.out.println();
		System.out.println("===문제2===");
		anniversary();


		/*
		문제3.
		요구사항] 배달음식을 시켜먹고싶다 , 여러가지음식을 동시에 먹고싶다(동시에 배달 받고싶다)
		각각의 음식을 언제 주문하면되는지? 
		조건]	자장면 10분후 도착
			치킨 18분 후 도착
			피자 25분 후 도착

		입력]	원하는 도착 시간
			시 : 17
			분 : 30

		출력]	짜장면 : 17시20분
			치킨 : 17시 12분
			피자 : 17시 5분
		*/
		System.out.println();
		System.out.println("===문제3===");
		deliveryTime();


	}//main

	public static void printAge() throws Exception {

		BufferedReader reader = new BufferedReader(new
		InputStreamReader(System.in));

		System.out.print("년도 : ");
		String year = reader.readLine();
		int intYear = Integer.parseInt(year);

		Calendar now = Calendar.getInstance();

		System.out.printf("나이 : %d세\n", (now.get(Calendar.YEAR)-intYear)+1);
	
	}//getAge


	public static void anniversary()throws Exception{

		BufferedReader reader = new BufferedReader(new
		InputStreamReader(System.in));

		System.out.print("남자이름 : ");
		String boy = reader.readLine();

		System.out.print("여자이름 : ");
		String girl = reader.readLine();

		System.out.print("년 : ");
		String year = reader.readLine();
		int intYear = Integer.parseInt(year);
		System.out.print("월 : ");
		String month = reader.readLine();
		int intMonth = Integer.parseInt(month);
		System.out.print("일 : ");
		String day = reader.readLine();
		int intDay = Integer.parseInt(day);

		System.out.println("================================");
		System.out.printf("'%s'과(와) '%s'의 기념일\n",boy,girl);
		System.out.println("================================");

		Calendar first = Calendar.getInstance();
		first.set(intYear,intMonth-1,intDay); 

	
		first.add(Calendar.DATE,100);
		System.out.printf("100일 : %d년 %d월 %d일\n",first.get(Calendar.YEAR),first.get(Calendar.MONTH)+1,first.get(Calendar.DATE));

		first.add(Calendar.DATE,100);
		System.out.printf("200일 : %d년 %d월 %d일\n",first.get(Calendar.YEAR),first.get(Calendar.MONTH)+1,first.get(Calendar.DATE));

		first.add(Calendar.DATE,100);
		System.out.printf("300일 : %d년 %d월 %d일\n",first.get(Calendar.YEAR),first.get(Calendar.MONTH)+1,first.get(Calendar.DATE));

		first.add(Calendar.DATE,200);
		System.out.printf("500일 : %d년 %d월 %d일\n",first.get(Calendar.YEAR),first.get(Calendar.MONTH)+1,first.get(Calendar.DATE));

		first.add(Calendar.DATE,500);
		System.out.printf("1000일 : %d년 %d월 %d일\n",first.get(Calendar.YEAR),first.get(Calendar.MONTH)+1,first.get(Calendar.DATE));

	}//anniversary
			/*
		문제3.
		요구사항] 배달음식을 시켜먹고싶다 , 여러가지음식을 동시에 먹고싶다(동시에 배달 받고싶다)
		각각의 음식을 언제 주문하면되는지? 
		조건]	자장면 10분후 도착
			치킨 18분 후 도착
			피자 25분 후 도착

		입력]	원하는 도착 시간
			시 : 17
			분 : 30

		출력]	짜장면 : 17시20분
				치킨 : 17시 12분
				피자 : 17시 5분
		*/
	public static void deliveryTime()throws Exception{

		BufferedReader reader = new BufferedReader(new
		InputStreamReader(System.in));
		
		System.out.print("시 : ");
		String hour = reader.readLine();
		int intHour = Integer.parseInt(hour);
		System.out.print("분 : ");
		String minute = reader.readLine();
		int intMinute = Integer.parseInt(minute);
		
		Calendar arrive = Calendar.getInstance();
		arrive.set(arrive.get(Calendar.YEAR),arrive.get(Calendar.MONTH),arrive.get(Calendar.DATE),intHour,intMinute,arrive.get(Calendar.SECOND));
		
		
		arrive.add(Calendar.MINUTE,-10);
		System.out.printf("짜장면 : %d시%d분\n",arrive.get(Calendar.HOUR_OF_DAY),arrive.get(Calendar.MINUTE));
		arrive.add(Calendar.MINUTE,-8);
		System.out.printf("치킨 : %d시%d분\n",arrive.get(Calendar.HOUR_OF_DAY),arrive.get(Calendar.MINUTE));
		arrive.add(Calendar.MINUTE,-7);
		System.out.printf("피자 : %d시%d분\n",arrive.get(Calendar.HOUR_OF_DAY),arrive.get(Calendar.MINUTE));
	
	
	}//deliverytime()



}//class

