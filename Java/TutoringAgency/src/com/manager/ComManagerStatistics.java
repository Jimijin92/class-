package com.manager;

import java.util.Scanner;


public class ComManagerStatistics {
	
	private static Scanner scan;
					

		
	static {
	scan = new Scanner(System.in);
	

	}
	
	
	public static void statisticsMenu() {
		
		boolean loop = true;
		
		while (loop) {
			
			System.out.println("============================");
			System.out.println("통계 보기");
			System.out.println("============================");
			System.out.println("1.회원 가입 통계");
			System.out.println("2.월별 수익");
			System.out.println("3.과목별 성사 비율 그래프");
			System.out.println("4.뒤로 가기");
			System.out.println("선택 : ");
			
			String sel = scan.nextLine();
			
			if(sel.equals("1")) ComManagerRegisterStatistics.registerStatisticsMenu();
			else if (sel.equals("2")) ComManagerProfitStatistics.profitStatistics();
			else if (sel.equals("3")) ComManagerSubjectStatistics.subjectStatistics();
			else loop = false; //메뉴탈출
			
			
		}
		
		
		
		
	}




	
	

	
}//Statistics
