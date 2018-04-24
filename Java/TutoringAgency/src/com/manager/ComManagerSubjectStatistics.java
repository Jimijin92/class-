package com.manager;

import java.util.ArrayList;
import java.util.Scanner;

import com.common.Schedule;
import com.io.ComInSchedule;

public class ComManagerSubjectStatistics {
	
	private static Scanner scan;
	
	private static ArrayList<Schedule> Schedulelist;
		
		
	static {
		scan = new Scanner(System.in);
	
		Schedulelist = new ArrayList<Schedule>();	
	
	}
	
	public static void subjectStatistics() {//3. 해당연도 해당월의 과목별 성사 비율 그래프
		
		ComInSchedule.load();
		Schedulelist = ComInSchedule.getSchedulelist();
		
		String startDate = ""; //성사일(스케줄 첫 수업일)
		String[] arrayDate; // 첫수업일 넣는 배열
		String year = ""; //첫 수업일의 연도
		String month = ""; //첫 수업일의 달
		String subject = ""; //과목명
		
		int kor =0; //언어
		int math =0; //수리
		int eng =0; //영어
		int society =0; // 사탐
		int science =0; // 과탐
		int seclang =0; //제 2외국어
		int essay =0; //논술 
		
		
		System.out.println("원하시는 연도를 입력해주세요");
		String putYear = scan.nextLine();
		
		System.out.println("원하시는 월을 입력해주세요");
		String putMonth = scan.nextLine();
		
		
		for (int i=0; i<Schedulelist.size(); i++) {
			
			
			startDate = Schedulelist.get(i).getStartDay(); //첫수업일 : 2017-01-03
			
			
			
			arrayDate = startDate.split("-"); //첫수업일 배열에 넣기
			
			year = arrayDate[0];//연도가 들어간 방 "2017"
			
			month = arrayDate[1];//월이 들어간 방 "01"
			
			subject = Schedulelist.get(i).getSubject();
			
			if(putYear.equals(year) && putMonth.equals(month)) {
				
				if(subject.equals("외국어")) {
					
					eng++;
					
				}else if (subject.equals("수리")) {
					
					math++;
				}else if (subject.equals("사탐")) {
					
					society++;
				}else if (subject.equals("과탐")) {
					
					science++;
				}else if (subject.equals("제2외국어")) {
					
					seclang++;
				}else if (subject.equals("논술")) {
					
					essay++;
				}else if (subject.equals("언어")) {
					
					kor++;
				}
				
				
				
				
			}
			

					
			
		}//for	
		

		System.out.printf("%s년 %s월의 과목별 성사횟수", putYear, putMonth);
		System.out.println("=================================================");
		System.out.println();
		System.out.printf("%s : %d회", "언어", kor);
		System.out.println();
		System.out.printf("%s : %d회", "수리", math);
		System.out.println();
		System.out.printf("%s : %d회", "외국어", eng);
		System.out.println();
		System.out.printf("%s : %d회", "사탐", society);
		System.out.println();
		System.out.printf("%s : %d회", "과탐", science);
		System.out.println();
		System.out.printf("%s : %d회", "제2외국어", seclang);
		System.out.println();
		System.out.printf("%s : %d회", "논술", essay);
		System.out.println();

		
		
		//과목 그래프찍기 
		int totalSubject = kor+math+eng+society+science+seclang+essay;
//			System.out.println(totalSubject); //OK
		
		
		double korRate = ((double)kor/(double)totalSubject)*100;
		
		double mathRate = ((double)math/(double)totalSubject)*100;
		
		double engRate = ((double)eng/(double)totalSubject)*100;
		
		double societyRate = ((double)society/(double)totalSubject)*100;
		
		double scienceRate = ((double)science/(double)totalSubject)*100;
		
		double seclangRate = ((double)seclang/(double)totalSubject)*100;
		
		double essayRate = ((double)essay/(double)totalSubject)*100;
		
		
		
		long korRateRound = Math.round(korRate);//여기까지
		
		long mathRateRound = Math.round(mathRate);
		
		long engRateRound = Math.round(engRate);
		
		long societyRateRound = Math.round(societyRate);
		
		long scienceRateRound = Math.round(scienceRate);
		
		long seclangRateRound = Math.round(seclangRate);
		
		long essayRateRound = Math.round(essayRate);
		
		
		
		
		
		
//		System.out.println(korRate);
//		System.out.println(mathRate);
//		System.out.println(engRate);
//		System.out.println(societyRate);
//		System.out.println(seclangRate);
//		System.out.println(essayRate);
		
		
		
		//그래프찍기 =>이중배열을 이용하여 루프를 돌며 그래프 찍기 
		
		String[][] star = new String[20][7];   //별 20개 , 7과목
		
		for (int i = 0; i < 20; i++) {   //점수를 5으로 나눈 값만큼 저장
	         if (i < korRate / 5) {   
	            star[i][0] = "*";      //0~ 점수/5 번째 방에는 *
	         } else {
	            star[i][0] = "";      //나머지 방에는 ""
	         }

	      }
	      for (int i = 0; i < 20; i++) {
	         if (i < mathRate / 5) {
	            star[i][1] = "*";
	         } else {
	            star[i][1] = "";
	         }
	      }
	      for (int i = 0; i < 20; i++) {
	         if (i < engRate / 5) {
	            star[i][2] = "*";
	         } else {
	            star[i][2] = "";
	         }
	      }
	      for (int i = 0; i < 20; i++) {
		         if (i < societyRate / 5) {
		            star[i][3] = "*";
		         } else {
		            star[i][3] = "";
		         }
		      }
	      
	      for (int i = 0; i < 20; i++) {
		         if (i < scienceRate / 5) {
		            star[i][4] = "*";
		         } else {
		            star[i][4] = "";
		         }
		      }
	      
	      for (int i = 0; i < 20; i++) {
		         if (i < seclangRate / 5) {
		            star[i][5] = "*";
		         } else {
		            star[i][5] = "";
		         }
		      }
	      
	      for (int i = 0; i < 20; i++) {
		         if (i < essayRate / 5) {
		            star[i][6] = "*";
		         } else {
		            star[i][6] = "";
		         }
		      }

	      for (int i = 19; i >= 0; i--) {      //빈방이 마지막방이라 루프를 9부터 거꾸로
	         for (int j = 0; j < 7; j++) {   //언 수 외 사탐 과탐 제2외국어 논술 순으로 찍기

	            System.out.print(star[i][j] + "\t");

	         }
	         System.out.println();   //한줄찍고 개행
	      }
	      System.out.println("===================================================");
	      System.out.print("언\t수\t외\t사\t과\t2외\t논");
	      System.out.println();
	      System.out.printf("(%d%%)\t(%d%%)\t(%d%%)\t(%d%%)\t(%d%%)\t(%d%%)\t(%d%%)"
	    		  						,korRateRound
	    		  						,mathRateRound
	    		  						,engRateRound
	    		  						,societyRateRound
	    		  						,scienceRateRound
	    		  						,seclangRateRound
	    		  						,essayRateRound);
	      System.out.println();
	      System.out.println("===================================================");
	      
	      System.out.println();
	   
	
				

		
		
	}//subjectStatistics

	
	

}
