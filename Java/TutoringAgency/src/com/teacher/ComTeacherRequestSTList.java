package com.teacher;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

import com.common.Application;
import com.common.Pickdays;
import com.common.Schedule;
import com.common.Student;
import com.common.StudentAddInfor;
import com.common.Teacher;
import com.common.TeacherAddInfor;
import com.common.Time;
import com.io.ComInApplication;
import com.io.ComInSchedule;
import com.io.ComInStudent;
import com.io.ComInTeacher;
import com.student.ComStudentRequestTSList;
import com.student.ComStudentRequestTSList_T_profile;


//학생이 나를 선택한것 보기
public class ComTeacherRequestSTList {
	private static final String FILEAPPLYPATH = ".\\Data\\신청현황.dat";
	private static final String FILESCHEDULEPATH = ".\\Data\\스케줄.dat";	
	
	private static ArrayList<StudentAddInfor> StudentAddInfordentlist;
	private static ArrayList<Student> studentlist;
	private static ArrayList<Application> Applicationlist ;
	private static ArrayList<Schedule> Schedulelist ;
	
	private static Scanner scan ;
	
	static ArrayList<String> Snumber ;			//학생고유번호
	static String Sname ;			//학생 이름
	static int newlistnumber; //새로 다시 정렬할 번호
	
	static ArrayList<String> startDay ;		//시작일
	static ArrayList<String> sbject ;			//과목
	
	static ArrayList<Integer> dayscount; //요일 //원래 어레이 리스트였는데...이걸 또 에레이 리스트에 담아야한다..
	static ArrayList<ArrayList> daydays; //요일
	static ArrayList<String> times ;		 	//시간
	static ArrayList<String> state; 			//상태
	static ArrayList<Integer> listnumber; //리스트 번호
	static ArrayList<Integer> totalmoney; //한달동안 받을 돈
	
	///////////학생프로필 담을 리스트////////////////
	static ArrayList<ComTeacherRequestSTList_S_profile> requestSTlist;
	

	static String StringSnumber;//학생 고유번호
	static String inputnumber;
	static int addSchedulelistnum;
	
	static {
		Applicationlist = new ArrayList<Application>();	//신청현황 넣은 리스트
		Schedulelist = new ArrayList<Schedule>();
		studentlist = new ArrayList<Student>(); 
		StudentAddInfordentlist = new ArrayList<StudentAddInfor>();
		
		scan = new Scanner(System.in);
		
		Snumber = new ArrayList<String>();

		Sname = "";//학생 이름
		newlistnumber =1;
		startDay = new ArrayList<String>();//시작일
		sbject = new ArrayList<String>();//과목
		
		dayscount = new ArrayList<Integer>(); 
		daydays = new ArrayList<ArrayList>(); //요일
		
		times = new ArrayList<String>(); //시간
		state = new ArrayList<String>() ; //상태
		
		listnumber = new ArrayList<Integer>();

		totalmoney = new ArrayList<Integer>();
		
		/////////////////////////////////////////////
		requestSTlist = new ArrayList<ComTeacherRequestSTList_S_profile>();
		
		
		//===========================================================//
		//개인 프로필 불러올때 사용하는것
		StringSnumber = ""; //선생님고유번호
	
		inputnumber = "";
		
		
		addSchedulelistnum=0;
		

	}
	public static void requestSTList() {
		ComInApplication.load();
		ComInStudent.load();
		ComInTeacher.load();

		studentlist = ComInStudent.getStudentlist();
		Applicationlist = ComInApplication.getApplicationist();
		//Teacherlist = ComInTeacher.getTeacherlist();

		
		System.out.println("[회원 목록]");
		
		System.out.print("회원고유번호 : ");
		String number = scan.nextLine();//회원 고유번호
	
		//System.out.println(Studentlist.size());
		//회원고유번호 받은걸로 신청현황에서(신청부분이 1인걸 찾고) 선생님 고유번호, 시작일 , 과목 , 요일(*없애기), 시간(가공),상태 출력 
		//신청현황의 선생님 고유번호를 선생님 리스트에서 찾아서 이름만 뽑기!
		
		System.out.println("[번호]\t[학생이름]\t[성별]\t[과목]\t[시작 날짜]\t[요일]\t\t[시간]\t\t[가격]");
		
				
		for(Application app : Applicationlist) {
				
			
			if(app.getTNumber().equals(number) && app.getAsk().equals("0") &&app.getState().equals("대기")) { //SNumber : 고유번호 /getState :상태 
				
				Snumber.add(app.getSNumber());//학생 고유번호
				
				app.setHopeclassNumber(newlistnumber+"");
				listnumber.add(Integer.parseInt(app.getHopeclassNumber()));
				newlistnumber++;
				
				startDay.add(app.getHopestartDay()); //시작일
				sbject.add(app.getHopesubject()); //과목
				
				//요일 선택
				Pickdays p = new Pickdays(app.getDays());
				dayscount.add(p.getPickday().size());
				daydays.add(p.getPickday());
				//System.out.println(p.getPickday().size());
				
				totalmoney.add(Integer.parseInt(app.getHopeprice()));
				
				
				Time t = new Time(app.getHopestartTime(),app.getHopetime()); //시간
				times.add(t.getTotalTime()); //시간

				state.add(app.getState());
				
			}	
		}//for
	
	
		for(Student s : studentlist) {
			for(int j=0 ; j<Snumber.size();j++) {
				if(s.getSNumber().equals(Snumber.get(j))) {
					
					ComTeacherRequestSTList_S_profile Sprofile  = new ComTeacherRequestSTList_S_profile();
					Sprofile.setListnumber(listnumber.get(j)); 
					Sprofile.setSNumber(s.getSNumber()); 
	
					requestSTlist.add(Sprofile);
					
					//"[신청번호][학생이름]\t[학생성별]\t[과목]\t[시작날짜]\t[요일]\t\t[시간]\t\t[가격]");
					System.out.printf("%d\t%s\t\t%s\t%s\t%s\t%s\t%s\t%d\n"
										,listnumber.get(j)	//번호
										,s.getSName()		//이름
										,s.getSGender()	//학생 성별
										,sbject.get(j)			//과목
										,startDay.get(j)	//희망 시작날짜
										,daydays.get(j)		//요일
										,times.get(j)		//수업시간
										,totalmoney.get(j));		//가격
									
										break;
	
					
				}
			}
		}
			
		if(Snumber.isEmpty()) {
			save();
			System.out.println();
			System.out.println("신청한 학생이 없습니다..");
		}else {showSprofile();}

	}//requestTSList()
	
	//선생님 프로필 불러오기
	public static void showSprofile() {
		ComInApplication.load();
		ComInStudent.load();
		ComInTeacher.load();
		ComInSchedule.load();

		
		//Teacherlist = ComInTeacher.getTeacherlist();
		//TeacherAddInforlist = ComInTeacher.getTeacherAddInforlist();
		
		Schedulelist = ComInSchedule.getSchedulelist();
		studentlist = ComInStudent.getStudentlist();
		StudentAddInfordentlist = ComInStudent.getStudentAddInforlist();
		Applicationlist = ComInApplication.getApplicationist();
		
		
		//System.out.println(requestTSlist.size());
		System.out.print("학생을 선택하세요 : ");
		String number2  = scan.nextLine();//선생님 선택
		
		System.out.println("[기본정보]");
		System.out.println("[이름]\t[성별]\t[나이]\t[핸드폰번호]\t[고등학교명]\t[계열]\t\t[학년]");
		for(ComTeacherRequestSTList_S_profile tp : requestSTlist) {
			if(tp.getListnumber() == Integer.parseInt(number2)) { //SNumber : 고유번호 /getState :상태 
				StringSnumber = tp.getSNumber(); 
				}
		}
		for(Student s : studentlist) {
			if(s.getSNumber().equals(StringSnumber)) {
				System.out.printf("%s\t%s\t%s\t%s\t%s\t%s\t%s\n"
									,s.getSName()
									,s.getSGender()
									,s.getSAge()
									,s.getSTel()
									,s.getSHighSchool()
									,s.getSDepart()
									,s.getSGrade());
									break;
				
			}
		}
			
		System.out.println("[추가정보]");
		System.out.println("[자기소개]");
		for(StudentAddInfor sad : StudentAddInfordentlist) {
			if(sad.getSNumber().equals(StringSnumber)) {
				System.out.printf("%s\n"
									,sad.getSSelfIntro());
									break;
				
			}
		}
		
		System.out.println("해당 학생을 수락/거절하시겠습니까?");
		System.out.println("1.수락 2. 거절 3.다른학생 보기");
		System.out.print("번호 선택 : ");
		inputnumber = scan.nextLine();
		
		
		if(inputnumber.equals("1")) {
			//for(Application app : Applicationlist) {
			for(int i =0; i <Applicationlist.size();i++) {
				if(Applicationlist.get(i).getSNumber().equals(StringSnumber) && Applicationlist.get(i).getAsk().equals("0") 
						&& Applicationlist.get(i).getState().equals("대기")) {
					
					Applicationlist.get(i).setState("수락");

					
					Schedule sch = new Schedule();
					//Schedulelist.size();
					//System.out.println(Applicationlist.size());
					addSchedulelistnum = Schedulelist.size()+1;
					Applicationlist.get(i).setHopeclassNumber(addSchedulelistnum+"");
					
					sch.setClassNumber(Applicationlist.get(i).getHopeclassNumber()); //가공하기
					sch.setTNumber(Applicationlist.get(i).getTNumber());
					sch.setSNumber(Applicationlist.get(i).getSNumber());
					sch.setStartDay(Applicationlist.get(i).getHopestartDay());
					sch.setSubject(Applicationlist.get(i).getHopesubject());
					sch.setPrice(Applicationlist.get(i).getHopeprice());
					sch.setStartTime(Applicationlist.get(i).getHopestartTime());
					sch.setTime(Applicationlist.get(i).getHopetime());
					sch.setTcancel("0");
					sch.setScancel("0");
					sch.setTotalCancel("0");
					sch.setState(Applicationlist.get(i).getState());
					sch.setDays(Applicationlist.get(i).getDays());
					sch.setStar("0");
					
					Schedulelist.add(sch);
					
				
					
					//신청현황에서 지우기
					Applicationlist.remove(Applicationlist.get(i));
					System.out.println("수락이 완료되어 스케쥴로 이동하였습니다.");
					
					
				}
				
			}
			
			
		}else if(inputnumber.equals("2")) {
			for(int i =0; i <Applicationlist.size();i++) {
				if(Applicationlist.get(i).getSNumber().equals(StringSnumber)) {
					Applicationlist.get(i).setState("거절");
					Applicationlist.remove(Applicationlist.get(i));
					System.out.println("거절되어 리스트에서 삭제되었습니다.");
				}
			}
			
		}
		else if(inputnumber.equals("3")) {
			ComStudentRequestTSList.showTprofile();
		}

		
		save();
		
	}//showTprofile()
	


	public static void save() {
		
		//신청현황에서 대기를 수락으로 바꾸는게 아니라 대기인거는 remove로 지우고 -> 스케줄에 덮어쓰기하기!!!
		//스케쥴에 넣기
		
		try {
			
			BufferedWriter writer = new BufferedWriter(new FileWriter(FILEAPPLYPATH));
			
			//ArrayList -> Applicationlist 1개 => Applicationlist.dat의 1줄로 나타나게 해야한다!!
			
			for(Application app : Applicationlist) {
				String[] temp = app.getDays();
				String line = String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s"
						,app.getHopeclassNumber(),app.getTNumber(),app.getSNumber(),app.getHopestartDay()
						,app.getHopesubject(),app.getHopestartTime(),app.getHopetime(),app.getHopeprice()
						,app.getState(),temp[0],temp[1],temp[2],temp[3],temp[4],app.getAsk());
				writer.write(line); //메모리 -> 텍스트파일(dat) 복사
				writer.newLine();
				
			}
			
			writer.close();
			
		} catch (Exception e) {
			System.out.println("save : " + e.toString());

		}

		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(FILESCHEDULEPATH));
			
			//ArrayList -> Applicationlist 1개 => Applicationlist.dat의 1줄로 나타나게 해야한다!!
			
			for(Schedule sch : Schedulelist) {
				String[] temp = sch.getDays();
				String line = String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s"
						,sch.getClassNumber(),sch.getTNumber(),sch.getSNumber(),sch.getStartDay()
						,sch.getSubject(),sch.getPrice(),sch.getStartTime(),sch.getTime()
						,sch.getTcancel(),sch.getScancel(),sch.getTotalCancel()
						,sch.getState(),temp[0],temp[1],temp[2],temp[3],temp[4],sch.getStar());
				writer.write(line); //메모리 -> 텍스트파일(dat) 복사
				writer.newLine();
				
			}
			
			writer.close();
			
		} catch (Exception e) {
			System.out.println("save : " + e.toString());

		}
		
		Snumber.clear(); //학생 고유번호

		startDay.clear();//시작일 (여러날일 경우가 있어서)
		sbject.clear();//과목 
		
		dayscount.clear(); //요일 //원래 어레이 리스트였는데...이걸 또 에레이 리스트에 담아야한다..
		daydays.clear();//한사람의 요일을 담을 ArrayList
		
		times.clear(); //시간
		state.clear(); //상태
		listnumber.clear(); //리스트 번호
		totalmoney.clear(); //한달동안 받을 돈
		
		
		///////////선생님프로필 담을 리스트////////////////
		//개인 프로필 불러올때 사용하는 것
		//선생님이 학생을 신청했을때 , 불러오는 목록들을 하나의 클래스 변수에 담고 그 하나의 클래스들을 
		//ArrayList 에 담아서 사용!!
		requestSTlist.clear();

	}//save
	
	
	
}
