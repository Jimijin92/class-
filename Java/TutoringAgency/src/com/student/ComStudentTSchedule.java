package com.student;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import com.common.Schedule;
import com.common.Student;
import com.common.Teacher;
import com.common.Time;
import com.io.ComInApplication;
import com.io.ComInSchedule;
import com.io.ComInStudent;
import com.io.ComInTeacher;
import com.register.ComRegisterLogin;

public class ComStudentTSchedule {	//선택받은 선생님 스케줄 뿌려주기!!

	private static ArrayList<Schedule> sch;
	private static ComInSchedule list;	//스케줄 리스트
	private static ArrayList<Integer>schNum ;	//해당 선생님의 스케줄(번호)을 담는 리스트
	private static Scanner scan;
	private static ArrayList<Student> student;
	private static ArrayList<Teacher> teacher;
	
	
	private static String tNum;
	
	static {
		sch = new ArrayList<Schedule>();
		list = new ComInSchedule();
		schNum = new ArrayList<Integer>();
		scan = new Scanner(System.in);
		student = new ArrayList<Student>();
		teacher = new ArrayList<Teacher>();
	}
	
	
	public static void schedule(String s) {	//String s 는 선택받은 선생님의 고유 번호
		
		ComInStudent.load();
		student = ComInStudent.getStudentlist();
		ComInTeacher.load();
		teacher = ComInTeacher.getTeacherlist();
		
		tNum = s;
		
		
		list.load();
		sch=list.getSchedulelist();
		
		
		
		int forLoop = sch.size();	//for 루프 범위( sch 의 line 수)
									//총 몇개인지 모름
									//선생님마다 보통 한두줄

		

		
		for(int i=0; i<forLoop; i++) {
			
			if(sch.get(i).getTNumber().equals(s)) {
		
				schNum.add(i+1);	//한명의 선생님 스케줄 담아놓는 리스트(i번째 줄 , i+1번째 스케줄)
								
			}
		}//for
		
	
		
		//System.out.println(schNum.get(0));
		
		
		
		
		String[] teacherSchedule = new String[5];	//선생님 스케줄 하나당 무슨요일 하는지 저장하는 배열	
		String[] days = new String[7];	//선생님의 스케줄.[0] = 월 [1] = 화 ... [6] = 일
		
		List<String[]> tSchedule = new ArrayList<String[]>();//선생님의 스케줄이 여러개일 수 있어 옮겨담는 배열
		List<String[]> eachDay = new ArrayList<String[]>();// 모든 개인 스캐줄이 들어가 있는 리스트

		
		

	
		
		for(int i=0; i<schNum.size(); i++) {
			for(int j=0; j<5; j++) {
				teacherSchedule[j] = sch.get(schNum.get(i)).getDays()[j];
			}
			tSchedule.add(teacherSchedule);
		}
		
		
		System.out.println(" -----------------------------------------------------------------------------------------------------------------");
		System.out.println("ㅣ\t월\tㅣ\t화\tㅣ\t수\tㅣ\t목\tㅣ\t금\tㅣ\t토\tㅣ\t일\t ㅣ");
		System.out.println(" -----------------------------------------------------------------------------------------------------------------");
		for(int i=0; i<schNum.size(); i++) {
			Time time = new Time(sch.get(schNum.get(i)).getStartTime(),sch.get(schNum.get(i)).getTime());	//수업 시작 시간 ~ 수업끝나는 시간!
			for(int j=0; j<5; j++) {
				
				if(tSchedule.get(i)[j].equals("월")) {
					days[0] =  time.getTotalTime();
				}else if(tSchedule.get(0)[j].equals("화")){
					
					days[1] = time.getTotalTime();;
				}else if(tSchedule.get(0)[j].equals("수")){
					days[2] = time.getTotalTime();;
				}else if(tSchedule.get(0)[j].equals("목")){
					days[3] = time.getTotalTime();;
				}else if(tSchedule.get(0)[j].equals("금")){
					days[4] = time.getTotalTime();;
				}else if(tSchedule.get(0)[j].equals("토")){
					days[5] = time.getTotalTime();;
				}else if(tSchedule.get(0)[j].equals("일")){
					days[6] = time.getTotalTime();;
				}
				
			
			}
			eachDay.add(days);
			
			for(int j=0; j<7; j++) {
				if(eachDay.get(i)[j] == null) {
					eachDay.get(i)[j] = "    ";
				}
			}
			
			
			
			System.out.printf("ㅣ %11s\t  %11s\t %11s\t %11s\t  %11s\t %11s\t   %11s  ㅣ\n",eachDay.get(i)[0],eachDay.get(i)[1],eachDay.get(i)[2]
					,eachDay.get(i)[3],eachDay.get(i)[4],eachDay.get(i)[5],eachDay.get(i)[6]);
		}//for
		
		System.out.println(" -----------------------------------------------------------------------------------------------------------------");
		//System.out.println(Arrays.toString(eachDay.get(0)));	//없는날은 null 있는날은 프린트.
		
		
		
		System.out.println();
		System.out.println();
		
		boolean flag = true;
		
		while(flag) {
			System.out.println("해당 선생님에게 수강신청을 하시겠습니까?");
			System.out.println("1.예(수강신청 페이지)");
			System.out.print("2.아니오(선생님 목록으로 돌아가기)");
			String goStop = scan.nextLine();
			
			if(goStop.equals("1")) {
				flag = false;
				choice();	//수강 신청 메소드!!(여러 과정 여기 메소드 하나에 다 만들 예정)
			}else if(goStop.equals("2")) {
				flag = false;
				ComStudentSorting.sort();
			}else {
				System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
				System.out.println("정확한 숫자를 입력해 주세요");
				System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
			}
			
		}
	}//schedule

	
	
	
	private static void choice() {	//스케줄 출력 이후에  해당 선생님 스케줄에 맞춰 수강신청하기
		
		
		//[☆☆☆ 선생님 번호 관련된 모든건 s , index 는 선생님의 index 번호. 선생님 번호는 index+1];
		int index = Integer.parseInt(tNum); //선생님 번호 int 로 살짝 바꿔주기
		
		boolean flag = true;
		
		ComInStudent.load();
		student = ComInStudent.getStudentlist();
		ComInTeacher.load();
		teacher = ComInTeacher.getTeacherlist();
		
		
		
		String subject1 = teacher.get(index).getTSubject()[0];
		String subject2	= teacher.get(index).getTSubject()[1];	
		
		String selSubject= "";	//최종 선택 과목
		
		if(!subject2.equals("*")) {
			System.out.println();
			System.out.printf("%s선생님의 수강과목은 %s / %s 입니다. ",teacher.get(index).getTName(),subject1,subject2);
			System.err.println();
			while(flag) {
				
				System.out.println("수강을 원하는 과목을 선택해 주세요");
				
				System.out.println("1."+ subject1);
				System.out.println("2."+ subject2);
				System.out.print("입력 : ");
				String temp = scan.nextLine();
				
				if(temp.equals("1")) {
					flag = false;
					selSubject = subject1;
				}else if(temp.equals("2")) {
					flag = false;
					selSubject = subject2;
				}else {
					System.out.println("정확히 입력해 주세요");
				}
				
			}
		}else {
			System.out.printf("%s 선생님의 지도과목은 %s 입니다.",teacher.get(index).getTName(),subject1);
		}
		
		
		
		
		
		
		
		
		
		flag = true;
		
		String startYear = "";
		String startMonth = "";
		String startDay = "";
		
		while(flag) {
			System.out.println();
			System.out.println();
			
			System.out.println("<과외 시작일을 입력해 주세요>");
			
			System.out.print("년도 : ");
			startYear = scan.nextLine();
			System.out.println();
			System.out.print("월 : ");
			startMonth = scan.nextLine();
			System.out.println();
			System.out.print("일 : ");
			startDay = scan.nextLine();
			System.out.println();
			
			System.out.printf("%s-%s-%s 은 %s 요일 입니다.", startYear,startMonth,startDay,dateCalc(startYear, startMonth, startDay));	//요일 컬큘레이터 호출!
			flag = false;
			
			System.out.println("------------------------------------------------");
			System.out.println();
			System.out.print("주별 희망 횟수를 입력해 주세요 : ");
			
		}
		
		
		
		
		
		flag = true;
		int num = 0;
		
		
		while(flag) {
			System.out.println();
			System.out.println();
			
			System.out.println("<주의사항>");
			
			System.out.println("선생님 일정을 고려하여 신청하면");
			System.out.println("선생님이 수강신청 수락을 할 확률이 높습니다.");
			System.out.println("------------------------------------------------");
			System.out.println();
			System.out.print("주별 희망 횟수를 입력해 주세요 : ");
			String strNum = scan.nextLine();
			num = Integer.parseInt(strNum);	//희망 요일을 몇번 받을지..
		
		if(num<6) {
			flag = false;
		}else {
			System.out.println("주 5회 이상 수강할 수 없습니다.");
			System.out.println("다시 입력해 주세요");
		}
		
		}
		
		ArrayList<String> dayOfWeek = new ArrayList<String>();
		String[] daysList = new String[5];
		
		System.out.println("1.월  2.화  3.수  4.목  5.금  6.토  7.일 ");
		for(int i=0; i<num; i++) {
			
			System.out.print("원하는 요일을 선택해 주세요 : ");
			String input = scan.nextLine();
			
			if(input.equals("1")) {
				dayOfWeek.add("월");
				daysList[i] = "월";
			}else if(input.equals("2")) {
				dayOfWeek.add("화");
				daysList[i] = "화";
			}else if(input.equals("3")) {
				dayOfWeek.add("수");
				daysList[i] = "수";
			}else if(input.equals("4")) {
				dayOfWeek.add("목");
				daysList[i] = "목";
			}else if(input.equals("5")) {
				dayOfWeek.add("금");
				daysList[i] = "금";
			}else if(input.equals("6")) {
				dayOfWeek.add("토");
				daysList[i] = "토";
			}else if(input.equals("7")) {
				dayOfWeek.add("일");
				daysList[i] = "일";
			}else {
				System.out.println("정확히 입력해 주세요");	//1~7이 아닌 숫자를 입력하면 warning
				num ++;
			}
			
		}//for
		
		String strPrice = teacher.get(index).getTPrice();
		int price = Integer.parseInt(strPrice);
		int totalPrice = num * price * 4;
		System.out.println();
		System.out.printf("☆%s 선생님과 주 %d회,  한달 과외비는 총 %s 입니다." ,teacher.get(index).getTName(),num,totalPrice);
		System.out.println();
		for(int i=num;i<5;i++) {	//신청현황 파일에 저장하기위한 요일들
			daysList[i] = "*";
		}
		
		
		
		System.out.println();
		System.out.println();
		for(String a : dayOfWeek) {
			System.out.printf("\'%s\' ", a);
		}
		System.out.println(" 요일을 선택하셨습니다.");	//요일선택 끝 -> dayOfWeek 리스트에 저장.
		System.out.println();
		System.out.println();
		System.out.println();
		
		
		
		
		
		
		
		
		
		
		
		
		System.out.println("<<22시 이후 개인과외는 불법입니다>>");	//시작시간선택
		
		
		System.out.println();
		System.out.println();
		System.out.println();
		
		flag = true;	//과외 시작 시간 플래그
		
		
		String startTime = "";
		
		int timeLimit = 0;//시작시간 + 과외시간이 22시가 넘으면 경고하기 위한 변수..
		
		while(flag) {
			
			System.out.print("1.17시\t");	System.out.println("2.17시 30분");
			System.out.print("3.18시\t");	System.out.println("4.18시 30분");
			System.out.print("5.19시\t");	System.out.println("6.19시 30분");
			System.out.print("7.20시\t");	System.out.println("8.20시 30분");
			System.out.println("9.21시\t");
			
			System.out.println();	
			System.out.println("희망 시작시간");
			
			String temp = scan.nextLine();
			
			if(temp.equals("1")) {
				startTime = "17:00";
				timeLimit = 1700;	//17:00 은 int 1700으로 입력
				flag = false;
			}else if(temp.equals("2")) {
				startTime = "17:30";
				timeLimit = 1730;
				flag = false;
			}else if(temp.equals("3")) {
				startTime = "18:00";
				timeLimit = 1800;
				flag = false;
			}else if(temp.equals("4")) {
				startTime = "18:30";
				timeLimit = 1830;
				flag = false;
			}else if(temp.equals("5")) {
				startTime = "19:00";
				timeLimit = 1900;
				flag = false;
			}else if(temp.equals("6")) {
				startTime = "19:30";
				timeLimit = 1930;
				flag = false;
			}else if(temp.equals("7")) {
				startTime = "20:00";
				timeLimit = 2000;
				flag = false;
			}else if(temp.equals("8")) {
				startTime = "20:30";
				timeLimit = 2030;
				flag = false;
			}else if(temp.equals("9")) {
				startTime = "21:00";
				timeLimit = 2100;
				flag = false;
			}else {
				
				System.out.println("정확히 입력해 주세요");
				System.out.println();
			}
			
		}//시작 시간 물어보는 while!!
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		flag = true; //과외 지속시간 플래그
		System.out.println();
		System.out.println();
		
		String tutorTime = ""; //수업시간 저장!
		int timeLimit2 = 0;	//앞의 타임 리밋이랑 더할 숫자
		
		System.out.printf("%s시 부터 몇시간 수강하시겠습니까??\n",startTime);
		while(flag) {
			System.out.print("1.1시간\t");	System.out.println("2.1시간 30분");
			System.out.print("3.2시간\t");	System.out.println("4.2시간 30분");
			System.out.print("5.3시간\t");	System.out.println("6.3시간 30분");
			System.out.print("7.4시간\t");	
			
			System.out.println();
			System.out.print("시간을 선택해 주세요 : ");
			
			String temp = scan.nextLine();
			
			// 1시간은 100 1시간 30분은 150
			//TimeLimit1 은 과외 시작시간 ( 17:00 -> 1700)
			//TimeLimit2 는 수업 시간 (1:30 -> 150)
			//둘을 더해 2200이 넘으면 불법과외!
			
			if(temp.equals("1")) {
				timeLimit2 = 100;									
				
				if(timeLimit + timeLimit2 < 2200) {	//과외 종료 시간이 22:00 이전이면 자료 저장 후 loop 종료
					tutorTime = "1:00";								
					flag = false;									
				}else {												
					System.out.println("<경고>");	//과외 종료 시간이 22:00를 넘으면 <경고> 저장하지 않고 다시 입력받기.				
					System.out.println("과외 종료시간이 22시 이후입니다. 다시 선택해주세요");	
					System.out.println();
				}
					
			}else if(temp.equals("2")) {
				timeLimit2 = 150;	
				
				if(timeLimit + timeLimit2 < 2200) {
					tutorTime = "1:30";
					flag = false;
				}else {
					System.out.println("<경고>");
					System.out.println("과외 종료시간이 22시 이후입니다. 다시 선택해주세요");
					System.out.println();
				}
					
			}else if(temp.equals("3")) {
				timeLimit2 = 200;	
				
				if(timeLimit + timeLimit2 < 2200) {
					tutorTime = "2:00";
					flag = false;
				}else {
					System.out.println("<경고>");
					System.out.println("과외 종료시간이 22시 이후입니다. 다시 선택해주세요");
					System.out.println();
				}
				
			}else if(temp.equals("4")) {
				timeLimit2 = 250;	
				
				if(timeLimit + timeLimit2 < 2200) {
					tutorTime = "2:30";
					flag = false;
				}else {
					System.out.println("<경고>");
					System.out.println("과외 종료시간이 22시 이후입니다. 다시 선택해주세요");
					System.out.println();
				}
				
			}else if(temp.equals("5")) {
				timeLimit2 = 300;	
				
				if(timeLimit + timeLimit2 < 2200) {
					tutorTime = "3:00";
					flag = false;
				}else {
					System.out.println("<경고>");
					System.out.println("과외 종료시간이 22시 이후입니다. 다시 선택해주세요");
					System.out.println();
				}
	
			}else if(temp.equals("6")) {
				timeLimit2 = 350;	
				
				if(timeLimit + timeLimit2 < 2200) {
					tutorTime = "3:30";
					flag = false;
				}else {
					System.out.println("<경고>");
					System.out.println("과외 종료시간이 22시 이후입니다. 다시 선택해주세요");
					System.out.println();
				}
	
			}else if(temp.equals("7")) {
				timeLimit2 = 400;	
				
				if(timeLimit + timeLimit2 < 2200) {
					tutorTime = "4:00";
					flag = false;
				}else {
					System.out.println("<경고>");
					System.out.println("과외 종료시간이 22시 이후입니다. 다시 선택해주세요");
					System.out.println();
				}
	
			}else {
				
				System.out.println("정확히 입력해 주세요");
				System.out.println();
			}
			
			
		}
		
		
		
		//다 하고 입력 ! : 번호,선생번호,학생번호,시작일,과목 , 시작시간, 과외시간, 가격(월) , 상태(대기), 요일,요일,*,*,*, 0(학생->선생)
		//번호 : 신청현황.dat.size() +1 번째 숫자
		//선생번호 : 아까 받아온 선생정보에서 빼내기
		//학생번호 : 현재 유저 번호
		//시작일 : 받아온 날짜
		// 과목 : 입력받기
		// 시작시간 : startTime
		// 과외시간 : tutorTime
		// 가격 : 선생님 정보의 희망가격 * 주x회 * 4
		// 상태는 다 대기
		// 요일 : 다섯칸에 빈곳은 *
		// 마지막은 여기선 그냥 다 0
		
		//한줄 작성 ㄱㄱ
		
		String path = ".\\Data\\신청현황.dat";
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(path,true)); //신청현황에 더하기!
			BufferedReader reader = new BufferedReader(new FileReader(path));		//신청현황에 뭐있나 봐야됨
			
			int line = 1;
			
			while(reader.readLine() != null) {
				line +=1;
			}
		
			
			if(startMonth.length() == 1 ) {
				
				startMonth = "0"+startMonth;	// 형식에 맞추기 위해 1의자리 달을 입력하면 월 앞에 0 추가
			}else {
				
			}
			
			if(startDay.length() == 1) {
				startDay = "0"+startDay;		//이건 한자리수 일 앞에 0추가.
			}
			
			
			
			String startFullDate = startYear + "-" + startMonth + "-" + startDay;	//입력받은 희망 시작일을 형식에 맞춰 변수에 저장
			String teacherNum = index +1+"";	//선생님 번호는 라인번호 +1
			
			String newApply = String.format("\r\n%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s",line+""
																							,teacherNum 
																							//받아온 고유번호
																							,ComRegisterLogin.getUserEndemic()
																							,startFullDate
																							,selSubject
																							,startTime
																							,tutorTime
																							,totalPrice+""
																							,"대기"
																							,daysList[0]
																							,daysList[1]
																							,daysList[2]
																							,daysList[3]
																							,daysList[4]
																							,"0");

			writer.write(newApply);
			writer.close();
			System.out.println();
			System.out.printf("%s 선생님에게 수강신청이 완료되었습니다. 선생님이 수락하면 스케줄에서 확인하실 수 있습니다." , teacher.get(index).getTName());
			System.out.println();
		} catch (Exception e) {
			System.out.println("choice : " + e.toString());
		}
		
		
		
		
	}//choice
	
	
	
	
	
	
	public static String dateCalc(String year, String month, String date) {	//날짜 - 요일 계산기
		
		 Calendar temp = Calendar.getInstance();
		 
		 int y = Integer.parseInt(year);
		 int m = Integer.parseInt(month);
		 int d = Integer.parseInt(date);
		 
		 temp.set(y,m-1,d);
		 int day = temp.get(Calendar.DAY_OF_WEEK);
		
		 String dayOfWeek = "";
		 
		 if(day == 1) {
			 dayOfWeek = "일";
		 }else if(day == 2){
			 dayOfWeek = "월";
		 }else if(day == 3){
			 dayOfWeek = "화";
		 }else if(day == 4){
			 dayOfWeek = "수";
		 }else if(day == 5){
			 dayOfWeek = "목";
		 }else if(day == 6){
			 dayOfWeek = "금";
		 }else if(day == 7){
			 dayOfWeek = "토";
		 }
		 
		 
		 return dayOfWeek;
		
	}
	
	
	
	
	

	
}//class















