package com.teacher;

import java.util.ArrayList;
import java.util.Scanner;

import com.common.Application;
import com.common.Pickdays;
import com.common.Student;
import com.common.StudentAddInfor;
import com.common.Teacher;
import com.common.Time;
import com.io.ComInApplication;
import com.io.ComInStudent;
import com.io.ComInTeacher;
import com.register.ComRegisterLogin;
import com.student.ComStudentRequestTSList_T_profile;

//내가(선생님) 선택한 학생 보기!
public class ComTeacherRequestTSList {

	private static ArrayList<StudentAddInfor> StudentAddInfordentlist;
	private static ArrayList<Student> studentlist;
	private static ArrayList<Application> Applicationlist ;
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
	
	static {
		Applicationlist = new ArrayList<Application>();	//신청현황 넣은 리스트
		studentlist = new ArrayList<Student>(); 
		StudentAddInfordentlist = new ArrayList<StudentAddInfor>();
		
		scan = new Scanner(System.in);
		
		Snumber = new ArrayList<String>();
		//Snumber ="";
		Sname = "";//학생 이름
		//newlistnumber =1;
		startDay = new ArrayList<String>();//시작일
		sbject = new ArrayList<String>();//과목
		
		dayscount = new ArrayList<Integer>(); 
		daydays = new ArrayList<ArrayList>(); //요일
		
		times = new ArrayList<String>(); //시간
		state = new ArrayList<String>() ; //상태
		
		//listnumber = new ArrayList<Integer>();

		totalmoney = new ArrayList<Integer>();

	}
	
	public static void requestTSList() {
		ComInApplication.load();
		ComInStudent.load();
		ComInTeacher.load();
		
		Applicationlist = ComInApplication.getApplicationist();
		studentlist = ComInStudent.getStudentlist();

		
		System.out.println("[회원 목록]");
		
		//System.out.print("회원고유번호 : ");
		//String number = scan.nextLine();//회원 고유번호
		String number = ComRegisterLogin.getUserEndemic(); //로그인할때 고유번호 받아온것
		

		//회원고유번호 받은걸로 신청현황에서(신청부분이 0인걸 찾고) 선생님 고유번호, 시작일 , 과목 , 요일(*없애기), 시간(가공),상태 출력 
		//신청현황의 선생님 고유번호를 선생님 리스트에서 찾아서 이름만 뽑기!
		
		System.out.println("[학생이름]\t[시작일]\t[과목]\t[요일]\t\t[시간]\t\t[가격]\t[상태]");
		
				
		for(Application app : Applicationlist) {
				
				if(app.getTNumber().equals(number) && app.getAsk().equals("1") ) { //SNumber : 고유번호 /getState :상태 
					
					Snumber.add(app.getSNumber());//학생 고유번호
					
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
					
//					tprofile.setListnumber(listnumber.get(j)); 
//					tprofile.setTprofileName(t.getTName());
//					tprofile.setTprofileGender(t.getTGender());
//					tprofile.setSbject(sbject.get(j));
//					tprofile.setStartDay(startDay.get(j));
//					tprofile.setDaydays(daydays.get(j));
//					tprofile.setTimes(times.get(j));
//					tprofile.setTotalmoney(totalmoney.get(j));
//					tprofile.setTNumber(t.getTNumber()); 
//					
//					requestTSlist.add(tprofile);
//					
					//"[학생이름]\t[시작일]\t[과목]\t[요일]\t\t[시간]\t\t[가격]\t[상태]");
					System.out.printf("%s\t\t%s\t%s\t%s\t%s\t%s\t%s\n"
										,s.getSName()		//이름
										,startDay.get(j)	//희망 시작날짜
										,sbject.get(j)			//과목
										,daydays.get(j)		//요일
										,times.get(j)		//수업시간
										,totalmoney.get(j)		//가격
										,state.get(j));//상태
										break;

					
				}
			}
		}
//		startDay.clear();
//		sbject.clear();
//		daydays.clear();
//		times.clear();
//		totalmoney.clear();
//		state.clear();
		
	}	
}
