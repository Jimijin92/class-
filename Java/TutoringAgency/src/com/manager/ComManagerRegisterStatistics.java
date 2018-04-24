package com.manager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import com.common.Schedule;
import com.common.Student;
import com.common.Teacher;
import com.io.ComInSchedule;
import com.io.ComInStudent;
import com.io.ComInTeacher;

public class ComManagerRegisterStatistics {//1. 회원가입 통계
	
	private static Scanner scan;
	
	private static ArrayList<Student> Studentlist;
	private static ArrayList<Schedule> Schedulelist;
	private static ArrayList<Teacher> Teacherlist;
		
		
	static {
	scan = new Scanner(System.in);
	
	Studentlist = new ArrayList<Student>();	
	Schedulelist = new ArrayList<Schedule>();	
	Teacherlist = new ArrayList<Teacher>();	
	}
	
	public static void registerStatisticsMenu() {
		
		boolean loop = true;
		
		while (loop) {
			
			System.out.println("============================");
			System.out.println("회원가입 통계");
			System.out.println("============================");
			System.out.println("1.회원가입 성별 비율");
			System.out.println("2.해당연도 월별 성사율");
			System.out.println("3.전체 선생님 수와 전체 학생수 비율");
			System.out.println("4.뒤로 가기");
			System.out.println("선택 : ");
			
			String sel = scan.nextLine();
			
			if(sel.equals("1")) genderStatistics();
			else if (sel.equals("2")) outcomeStatistics();
			else if (sel.equals("3")) totalNumberStatistics();
			else loop = false; //메뉴탈출
			
			
		}
		
		
		
		
	}

		
		
		
	
	
	public static void genderStatistics() {//1-1 회원가입 성별 비율 (학생, 선생님 따로)
			
			
		ComInStudent.load();
		Studentlist = ComInStudent.getStudentlist();
		
		int countBoy = 0; //남자 학생수 카운트 
		
		
		for (int i = 0; i<Studentlist.size(); i++) {
			
			
			if (Studentlist.get(i).getSGender().equals("남")) {
				
				countBoy++; //남자 학생수 누적
				

			}
			
		}//for
		
				
		double boyRate = (double)countBoy/(double)Studentlist.size()*100; //남학생 수 비율		
		long boyRateRound = Math.round(boyRate); //남학생 수 비율 반올림
		int girlRateRound = (100 - (int)boyRateRound); //여학생 수 비율 반올림 
		
		
		System.out.println("=================================================");
		System.out.println("				회원가입 성별 비율			");
		
		System.out.println("=================================================");
		
		System.out.printf("남학생 비율 : %d%% (%d명),	여학생 비율 : %d%% (%d명)", boyRateRound, countBoy, girlRateRound, Studentlist.size()-countBoy);

		System.out.println();
		
		//그래프 찍기 남자

		for (int i = 0; i<boyRateRound/5; i++) {
			
			
			System.out.print("●");
			
			
		}
		

			
		if (boyRateRound%10 == 3 || boyRateRound%10 == 4 || boyRateRound%10 == 8 || boyRateRound%10 == 9) {
			
			System.out.print("◐");
		}
			

		//그래프 찍기 여자
		
		
		if (girlRateRound%10 == 3 || girlRateRound%10 == 4 || girlRateRound%10 == 8 || girlRateRound%10 == 9) {
			
			System.out.print("◐");
		}
		
		
		for (int i = 0; i<girlRateRound/5; i++) {
			
			
			System.out.print("○");
			
		}
			
		System.out.println();
		
		
	}//genderStatistics();

	public static void outcomeStatistics() {//1-2 해당연도 월별 성사율
		
		ComInSchedule.load();
		Schedulelist = ComInSchedule.getSchedulelist();
		
	
		String startDate = ""; //성사일(스케줄 첫 수업일)
		String[] arrayDate; // 첫수업일 넣는 배열
		String year = ""; //첫 수업일의 연도
		String month = ""; //첫 수업일의 달
	
		HashMap<String,int[]> outerMap = new HashMap<String, int[]>();//연도별 카운트 담을 배열 
			
	
		for (int i=0; i<Schedulelist.size(); i++) {
			
	
			
			startDate = Schedulelist.get(i).getStartDay(); //첫수업일 : 2017-01-03
			
			
			arrayDate = startDate.split("-"); //첫수업일 배열에 넣기
			
			year = arrayDate[0];//연도가 들어간 방 "2017"
			
			month = arrayDate[1];//월이 들어간 방 "01"
			
	
			
			if (!outerMap.containsKey(year)) { //key에 연도가 없으면  
	
				
				outerMap.put(year, new int[12]); //key연도랑 배열 만들고 
	
				
			} 
			
			
			if (month.equals("01")) {//해당 month를 해당 연도 배열안에서 카운트하기
				
				outerMap.get(year)[0]++;
	
				
			}else if (month.equals("02")) {
				
				outerMap.get(year)[1]++;
				
			}else if (month.equals("03")) {
				
				outerMap.get(year)[2]++;
			
			}else if (month.equals("04")) {
				
				outerMap.get(year)[3]++;
			
			}else if (month.equals("05")) {
				
				outerMap.get(year)[4]++;
			
			}else if (month.equals("06")) {
				
				outerMap.get(year)[5]++;
			
			}else if (month.equals("07")) {
				
				outerMap.get(year)[6]++;
			
			}else if (month.equals("08")) {
				
				outerMap.get(year)[7]++;
			
			}else if (month.equals("09")) {
				
				outerMap.get(year)[8]++;
			
			}else if (month.equals("10")) {
				
				outerMap.get(year)[9]++;
			
			}else if (month.equals("11")) {
				
				outerMap.get(year)[10]++;
			
			}else if (month.equals("12")) {
				
				outerMap.get(year)[11]++;
			
			}		
			
				
	
		
		}//for
		
		
		
		
	//		Iterator iterator = outerMap.entrySet().iterator();
	//
	//		while (iterator.hasNext()) {
	//		Entry entry = (Entry)iterator.next();
	//
	//		System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
	//
	//		}
		
	//	System.out.println(outerMap.get("2017")[11]); //확인용
	//	System.out.println(Arrays.toString(outerMap.get("2017"))); //확인용
		
		
		
		//그래프 찍기 
		
		System.out.println("================================");
		System.out.println("연도별 성사율 그래프 보기");
		
		
		
		System.out.println("원하는 연도를 입력해주세요.");
		String putYear = scan.nextLine();
		
	
	
		
		int january= outerMap.get(putYear)[0]; //1월 
		int february= outerMap.get(putYear)[1]; //2월 
		int march=outerMap.get(putYear)[2]; //3월 
		int april=outerMap.get(putYear)[3]; //4월 
		int may=outerMap.get(putYear)[4]; //5월 
		int june=outerMap.get(putYear)[5]; //6월 
		int july=outerMap.get(putYear)[6]; //7월 
		int august= outerMap.get(putYear)[7]; //8월 
		int september= outerMap.get(putYear)[8]; //9월 
		int october=outerMap.get(putYear)[9]; //10월 
		int november=outerMap.get(putYear)[10]; //11월
		int december=outerMap.get(putYear)[11]; //12월 
		
		int totalMonthCount = january+february+march+april+may+june+july+august+september+october+november+december;
		
		double januaryRate = ((double)january/(double)totalMonthCount)*100;
		double februaryRate = ((double)february/(double)totalMonthCount)*100;
		double marchRate = ((double)march/(double)totalMonthCount)*100;
		double aprilRate = ((double)april/(double)totalMonthCount)*100;
		double mayRate = ((double)may/(double)totalMonthCount)*100;
		double juneRate = ((double)june/(double)totalMonthCount)*100;
		double julyRate = ((double)july/(double)totalMonthCount)*100;
		double augustRate = ((double)august/(double)totalMonthCount)*100;
		double septemberRate = ((double)september/(double)totalMonthCount)*100;
		double octoberRate = ((double)october/(double)totalMonthCount)*100;
		double novemberRate = ((double)november/(double)totalMonthCount)*100;
		double decemberRate = ((double)december/(double)totalMonthCount)*100;
	
		
		long januaryRateRound = Math.round(januaryRate);
		long februaryRateRound = Math.round(februaryRate);
		long marchRateRound = Math.round(marchRate);
		long aprilRateRound = Math.round(aprilRate);
		long mayRateRound = Math.round(mayRate);
		long juneRateRound = Math.round(juneRate);
		long julyRateRound = Math.round(julyRate);
		long augustRateRound = Math.round(augustRate);
		long septemberRateRound = Math.round(septemberRate);
		long octoberRateRound = Math.round(octoberRate);
		long novemberRateRound = Math.round(novemberRate);
		long decemberRateRound = Math.round(decemberRate);
		
		
		
		
		
		
		//그래프찍기
		String[][] star = new String[20][12];   //별 20개 , 12달
		
		for (int i = 0; i < 20; i++) {   //점수를 10으로 나눈 값만큼 저장
	         if (i < januaryRate / 5) {   
	            star[i][0] = "*";      //0~ 점수/10 번째 방에는 *
	         } else {
	            star[i][0] = "";      //나머지 방에는 ""
	         }
	
	      }
	      for (int i = 0; i < 20; i++) {
	         if (i < februaryRate / 5) {
	            star[i][1] = "*";
	         } else {
	            star[i][1] = "";
	         }
	      }
	      for (int i = 0; i < 20; i++) {
	         if (i < marchRate / 5) {
	            star[i][2] = "*";
	         } else {
	            star[i][2] = "";
	         }
	      }
	      for (int i = 0; i < 20; i++) {
		         if (i < aprilRate / 5) {
		            star[i][3] = "*";
		         } else {
		            star[i][3] = "";
		         }
		      }
	      
	      for (int i = 0; i < 20; i++) {
		         if (i < mayRate / 5) {
		            star[i][4] = "*";
		         } else {
		            star[i][4] = "";
		         }
		      }
	      
	      for (int i = 0; i < 20; i++) {
		         if (i < juneRate / 5) {
		            star[i][5] = "*";
		         } else {
		            star[i][5] = "";
		         }
		      }
	      
	      for (int i = 0; i < 20; i++) {
		         if (i < julyRate / 5) {
		            star[i][6] = "*";
		         } else {
		            star[i][6] = "";
		         }
		      }
	      for (int i = 0; i < 20; i++) {
		         if (i < augustRate / 5) {
		            star[i][7] = "*";
		         } else {
		            star[i][7] = "";
		         }
		      }
	      for (int i = 0; i < 20; i++) {
		         if (i < septemberRate / 5) {
		            star[i][8] = "*";
		         } else {
		            star[i][8] = "";
		         }
		      }
	      for (int i = 0; i < 20; i++) {
		         if (i < octoberRate / 5) {
		            star[i][9] = "*";
		         } else {
		            star[i][9] = "";
		         }
		      }
	      for (int i = 0; i < 20; i++) {
		         if (i < novemberRate / 5) {
		            star[i][10] = "*";
		         } else {
		            star[i][10] = "";
		         }
		      }
	      for (int i = 0; i < 20; i++) {
		         if (i < decemberRate / 5) {
		            star[i][11] = "*";
		         } else {
		            star[i][11] = "";
		         }
		      }
	      
	
	      for (int i = 19; i >= 0; i--) {      //빈방이 마지막방이라 루프를 9부터 거꾸로
	         for (int j = 0; j < 12; j++) {   // 1월~12월 순으로 찍기
	
	            System.out.print(star[i][j] + "\t");
	
	         }
	         System.out.println();   //한줄찍고 개행
	      }
	      System.out.println("=============================================================================================");
	      System.out.print("1월\t2월\t3월\t4월\t5월\t6월\t7월\t8월\t9월\t10월\t11월\t12월");
	      System.out.println();
	      System.out.printf("(%d%%)\t(%d%%)\t(%d%%)\t(%d%%)\t(%d%%)\t(%d%%)\t(%d%%)\t(%d%%)\t(%d%%)\t(%d%%)\t(%d%%)\t(%d%%)"
							    		  						,januaryRateRound
							    		  						,februaryRateRound
							    		  						,marchRateRound
							    		  						,aprilRateRound
							    		  						,mayRateRound
							    		  						,juneRateRound
							    		  						,julyRateRound
							      								,augustRateRound
							      								,septemberRateRound
							      								,octoberRateRound
							      								,novemberRateRound
							      								,decemberRateRound);
	      System.out.println();
	      System.out.println("=============================================================================================");
	      
	      System.out.println();
		
		
	
		
		
		
		
		
	}//outcomeStatistics
	
	public static void totalNumberStatistics() {//1-3 전체 선생님 수와 전체 학생수 비율
		
		
		ComInStudent.load();
		ComInTeacher.load();
		Studentlist = ComInStudent.getStudentlist();
		Teacherlist = ComInTeacher.getTeacherlist();
		
		int countStudent = Studentlist.size(); //학생 수  
		int countTeacher = Teacherlist.size(); //선생님 수 
				
				
		double studentRate = (double)countStudent/(double)(countStudent+countTeacher)*100; //학생 수 비율		
		long studentRateRound = Math.round(studentRate); //학생 수 비율 반올림
		int teacherRateRound = (100 - (int)studentRateRound); //선생님 수 비율 반올림 
		
		System.out.printf("학생 비율 : %d%% (총 %d명), 선생님 비율 : %d%% (총 %d명)", studentRateRound, countStudent, teacherRateRound, countTeacher);
		
		System.out.println();
	
		
		//그래프 찍기 학생
	
		for (int i = 0; i<studentRateRound/5; i++) {
			
			
			System.out.print("●");
			
			
		}
		
	
			
		if (studentRateRound%10 == 3 || studentRateRound%10 == 4 || studentRateRound%10 == 8 || studentRateRound%10 == 9) {
			
			System.out.print("◐");
		}
			
	
		//그래프 찍기 여자
		
		
		if (teacherRateRound%10 == 3 || teacherRateRound%10 == 4 || teacherRateRound%10 == 8 || teacherRateRound%10 == 9) {
			
			System.out.print("◑");
		}
		
		
		for (int i = 0; i<teacherRateRound/5; i++) {
			
			
			System.out.print("○");
			
		}
			
		System.out.println();
		
		
		
		
		
	}//totalNumberStatistics
	
	

}
