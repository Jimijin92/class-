package com.manager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

import com.common.Schedule;
import com.common.Student;
import com.common.Teacher;
import com.io.ComInSchedule;
import com.io.ComInStudent;
import com.io.ComInTeacher;
import com.register.ComRegisterDeleteS;
import com.register.ComRegisterDeleteT;

public class ComManagerBlacklist {
	
	//월기준 과목 다 합쳐서 취소횟수 50%이상일시  -> 블랙리스트 (선생님, 학생 따로)
	//=>BUT!!! 수업마다 시작일이 다 달라서 계산불가능-> 수업 하나라도 취소횟수 50%이상이면 블랙리스트 
	//매니저 -> 회원리스트에서 삭제할지 말지 결정 
	private static final String FILESPATH = ".\\Data\\학생 기본정보.dat";
	private static final String FILETPATH = ".\\Data\\선생님 기본정보.dat";
	
	private static Scanner scan;
			
	private static ArrayList<Student> Studentlist;
	private static ArrayList<Teacher> Teacherlist;
	private static ArrayList<Schedule> Schedulelist;
	
	
	static {
		scan = new Scanner(System.in);
		
		Studentlist = new ArrayList<Student>();	
		Teacherlist = new ArrayList<Teacher>();	
		Schedulelist = new ArrayList<Schedule>();	
	}
	
	public static void blacklistMenu() {
		
	
		boolean loop = true;
		
		while (loop) {
			
			System.out.println("============================");
			System.out.println("블랙리스트 관리");
			System.out.println("============================");
			System.out.println("1.학생");
			System.out.println("2.선생님");
			System.out.println("3.뒤로 가기");
			System.out.println("선택 : ");
			
			String sel = scan.nextLine();
			
			if(sel.equals("1")) studentBlacklist();
			else if (sel.equals("2")) teacherBlacklist();
			else loop = false; //메뉴탈출
			
			
		}
		
		
		
	}
	




	public static void studentBlacklist() {
		
		ComInSchedule.load();
		ComInStudent.load();
		ComInTeacher.load();
		
		Schedulelist = ComInSchedule.getSchedulelist();
		Studentlist = ComInStudent.getStudentlist();
		Teacherlist = ComInTeacher.getTeacherlist();
		
		
		ArrayList<String> StudentBlacklist = new ArrayList<String>(); //학생 블랙리스트
		
//		HashMap<String, ArrayList<String>> eachStudentClass = new HashMap<String, ArrayList<String>>(); //학생당 수업 담을 리스트 
		HashMap<String, HashSet<String>> eachStudentClass = new HashMap<String, HashSet<String>>();
		
		HashMap<String, Long> eachClassSCancelRate = new HashMap<String, Long>(); //수업별 취소율 담을 배열

		
		String classSubject = ""; //과목이름
		String studentNum = ""; //학생번호-> 학생 블랙리스트(StudentBlacklist)에도 넣고 eachStudent의 key값으로도 쓰임 
		String classNum = ""; //수업번호
		long studentCancelRateRound = 0; //학생 취소율 반올림
		
		//1-1 학생당 수업 담을 리스트 만들기 (애리)
		for (int i=0; i<Schedulelist.size(); i++) {
			

			
			studentNum = Schedulelist.get(i).getSNumber(); //해당 수업의 학생번호 얻기 
			
			
			
			if (!eachStudentClass.containsKey(studentNum)) { //key에 학생번호가 없으면  
	
				
//				eachStudentClass.put(studentNum, new ArrayList<String>()); //key값:학생번호 value값: 수업배열 방만들기
				eachStudentClass.put(studentNum, new HashSet<String>());
			} 
			
			
			classNum = Schedulelist.get(i).getClassNumber();
			
			eachStudentClass.get(studentNum).add(classNum); //각 수업번호를 해당학생의 value에 넣기
			
			
			
			//수업별 취소율 배열의 key만들기
			if (!eachClassSCancelRate.containsKey(classNum)) { //key에 수업번호가 없으면
				
				eachClassSCancelRate.put(classNum, studentCancelRateRound);
				
			}
			
			
			
			
			

		}//for 
		
		
		//확인
////		Iterator iterator = eachStudentClass.entrySet().iterator();
//
//		while (iterator.hasNext()) {
//		Entry entry = (Entry)iterator.next();
//
//		System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
//
//		}
		
		
//		//확인
//		Set<String> set = eachStudentClass.keySet();
//
//		Iterator<String> iter2 = set.iterator();
//
//		while(iter2.hasNext()) {
//		String key = iter2.next();
//
//		String result = String.format("%s : %s",key,eachStudentClass.get(key));
//
//		System.out.println(result);
//
//		System.out.println("------------------------------");
//		
//		}
		
//		//수업번호별 학생취소율 배열 확인
//		Set<String> set = eachClassSCancelRate.keySet();
//
//		Iterator<String> iter2 = set.iterator();
//
//		while(iter2.hasNext()) {
//		String key = iter2.next();
//
//		String result = String.format("%s : %d",key,eachClassSCancelRate.get(key));
//
//		System.out.println(result);
//
//		System.out.println("------------------------------");
//		
//		}
		
		
		
		
		//1-2 학생 블랙리스트에 올리기 + 수업당 취소율 배열에 value값 넣기
		
		//블랙리스트 올릴때 쓸 변수	
		int studentCancel = 0;//취소 횟수
		int weekClass = 0; // 각 수업의 한 주 수업 횟수 (ex. 주 3회)
		int totalClass = 0; //각 수업의 전체 수업 횟수 (한달)
		double studentCancelRate = 0; //학생 취소율
		                                                                                                        
//		int studentCancelRate = (studentCancel/totalClass)*100; //학생 취소율 //error ->Exception in thread "main" java.lang.ArithmeticException: / by zero

		
		
		String [] days = new String[5]; //요일 담을 배열
		
		for (int i=0; i<Schedulelist.size(); i++) {
			
			
			studentCancel = Integer.parseInt(Schedulelist.get(i).getScancel()); //각 수업의 학생 취소횟수
			
//			System.out.println(studentCancel); //OK!
			
			
			studentNum = Schedulelist.get(i).getSNumber(); //각 수업의 학생번호
			
			
			//각 수업의 전체 수업 횟수
			
			days = Schedulelist.get(i).getDays();
			
			for (int j=0; j<days.length; j++) {
				
				if(!days[j].equals("*")) {
				
				
				weekClass++; 
				
				
				}
				
			}//for2
			
//			System.out.println(weekClass); //OK!
			
			totalClass = weekClass*4; //전체 취소횟수
			
//			System.out.println(totalClass); //OK!
			
			
			
			
			
			
			studentCancelRate = ((double)studentCancel/(double)totalClass)*100; //취소율 계산//
			
			studentCancelRateRound = Math.round(studentCancelRate);
			
//			System.out.println(studentCancelRate); //확인용
//			System.out.println(studentCancelRateRound); //확인용
			
			
			
//			수업당 학생취소율 배열 value에 취소율 넣기
			classNum = Schedulelist.get(i).getClassNumber();
			eachClassSCancelRate.put(classNum, studentCancelRateRound);
			
			
			
			
			
			
		//만약 (취소횟수/전체 수업횟수*100>=50)면 블랙리스트에 올리기 
			if (studentCancelRate>=50) {
				
				
				//studentNum이 존재하지 않으면 넣기
				if(!StudentBlacklist.contains(studentNum)) {
					
					StudentBlacklist.add(studentNum);
					
				}	
				
				
			}	
			
			weekClass = 0; //주 횟수 초기화 
			totalClass = 0; //전체 횟수 초기화
			studentCancelRate = 0; //취소율 초기화
			
			
		}//for1
		
		
//		System.out.println(StudentBlacklist); //확인용
//		
//		//수업번호별 학생취소율 배열 확인
//		Set<String> set = eachClassSCancelRate.keySet();
//
//		Iterator<String> iter2 = set.iterator();
//
//		while(iter2.hasNext()) {
//		String key = iter2.next();
//
//		String result = String.format("%s : %d",key,eachClassSCancelRate.get(key));
//
//		System.out.println(result);
//
//		System.out.println("------------------------------");
//		
//		}

		
		
		
		//블랙리스트 학생 띄우기
		
		String studentName = "";
		
		System.out.println("=================================");
		System.out.println("\t블랙리스트 학생\t");
		
		for(int i = 0; i<StudentBlacklist.size(); i++) {
			
			for (int j = 0; j<Studentlist.size(); j++) {
				
//				if(Studentlist.get(j).getClassNumber().equals(StudentBlacklist.get(i)){
				
				if(StudentBlacklist.get(i).equals(Studentlist.get(j).getSNumber())){
					
					studentName = Studentlist.get(j).getSName();
					
				}
				
			}//for2
			
			System.out.printf("%d. 학생번호: %s, 이름: %s", i+1, StudentBlacklist.get(i), studentName);
			System.out.println();
			
		}//for1
		
		//학생의 각 수업 취소율 보여주기
		
			
		System.out.println("취소율을 보고싶은 학생의 학생번호를 입력해주세요.");
		String wantStudent = scan.nextLine();
		
		
		for (int i = 0; i<Schedulelist.size(); i++) {
			
			studentNum = Schedulelist.get(i).getSNumber();
			classSubject =  Schedulelist.get(i).getSubject();
			classNum = Schedulelist.get(i).getClassNumber();
			
			
			if (wantStudent.equals(studentNum)) {
				
				
				
				
				for (int z =0; z<Studentlist.size(); z++) {
					
				if (studentNum.equals(Studentlist.get(z).getSNumber()))

				studentName = Studentlist.get(z).getSName();
				
				
				
				}
				
				
				
				
				
				System.out.printf("%s 학생의 수업별 취소율", studentName);
				
				System.out.println();
				
				for (int j = 0; j<eachStudentClass.get(studentNum).size(); j++) {
					
					System.out.printf("수업과목 : %s, 학생의 취소율 : %d%%", classSubject, eachClassSCancelRate.get(classNum));
					System.out.println();
					
				}//for2
				
				break;
				
			}
			
			
		} //for1
		
		
		ComRegisterDeleteS.deleteSMember(wantStudent);
		


	
	
	}//studentBlacklist
	
		
	public static void teacherBlacklist() {
		
		
		ComInSchedule.load();
		ComInTeacher.load();
		ComInStudent.load();
		Schedulelist = ComInSchedule.getSchedulelist();
		Teacherlist= ComInTeacher.getTeacherlist();
		Studentlist= ComInStudent.getStudentlist();
		
		
		ArrayList<String> TeacherBlacklist = new ArrayList<String>(); //선생 블랙리스트

		HashMap<String, HashSet<String>> eachTeacherClass = new HashMap<String, HashSet<String>>();//선생당 수업 담을 리스트
		
		HashMap<String, Long> eachClassTCancelRate = new HashMap<String, Long>(); //수업별 취소율 담을 배열
		
//		TeacherBlacklist.clear();//이거이거
//		eachTeacherClass.clear();
//		eachClassTCancelRate.clear();

		
		String classSubject = ""; //과목이름
		String teacherNum = ""; //선생님 번호-> 선생님 블랙리스트(StudentBlacklist)에도 넣고 eachStudent의 key값으로도 쓰임 
		String classNum = ""; //수업번호
		
		long teacherCancelRateRound = 0; //선생님 취소율 반올림
		
		//1-1 선생님당 수업 담을 리스트 만들기 
		for (int i=0; i<Schedulelist.size(); i++) {
			

			
			teacherNum = Schedulelist.get(i).getTNumber(); //해당 수업의 학생번호 얻기 
			
			
			
			if (!eachTeacherClass.containsKey(teacherNum)) { //key에 학생번호가 없으면  
	
				
				eachTeacherClass.put(teacherNum, new HashSet<String>());
			} 
			
			
			classNum = Schedulelist.get(i).getClassNumber();
			
			eachTeacherClass.get(teacherNum).add(classNum); //각 수업번호를 해당학생의 value에 넣기
			
			
			
			//수업별 취소율 배열의 key만들기
			if (!eachClassTCancelRate.containsKey(classNum)) { //key에 수업번호가 없으면
				
				eachClassTCancelRate.put(classNum, teacherCancelRateRound);
				
			}
			
			
			
			
			

		}//for 
		
		
		//확인
////		Iterator iterator = eachTeacherClass.entrySet().iterator();
//
//		while (iterator.hasNext()) {
//		Entry entry = (Entry)iterator.next();
//
//		System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
//
//		}
		
		
		//확인
//		Set<String> set = eachTeacherClass.keySet();
//
//		Iterator<String> iter2 = set.iterator();
//
//		while(iter2.hasNext()) {
//		String key = iter2.next();
//
//		String result = String.format("%s : %s",key,eachTeacherClass.get(key));
//
//		System.out.println(result);
//
//		System.out.println("------------------------------");
//		
//		}
		
//		//수업번호별 선생님 취소율 배열 확인
//		Set<String> set = eachClassTCancelRate.keySet();
//
//		Iterator<String> iter2 = set.iterator();
//
//		while(iter2.hasNext()) {
//		String key = iter2.next();
//
//		String result = String.format("%s : %d",key,eachClassTCancelRate.get(key));
//
//		System.out.println(result);
//
//		System.out.println("------------------------------");
//		
//		}
		
		
		
		
		//1-2 선생님 블랙리스트에 올리기 + 수업당 취소율 배열에 value값 넣기
		
		//블랙리스트 올릴때 쓸 변수	
		
		int teacherCancel1 = 0;//취소 횟수
		int weekClass = 0; // 각 수업의 한 주 수업 횟수 (ex. 주 3회)
		int totalClass = 0; //각 수업의 전체 수업 횟수 (한달)
		double teacherCancelRate = 0; //학생 취소율
		                                                                                                        

		String [] days = new String[5]; //요일 담을 배열
		
		for (int i=0; i<Schedulelist.size(); i++) {
			
			
			teacherCancel1 = Integer.parseInt(Schedulelist.get(i).getTcancel()); //각 수업의 선생님 취소횟수
			
//			System.out.println(teacherCancel); //OK!
			
			
			teacherNum = Schedulelist.get(i).getTNumber(); //각 수업의 선생님 번호
			
			
			//각 수업의 전체 수업 횟수
			
			days = Schedulelist.get(i).getDays();
			
			for (int j=0; j<days.length; j++) {
				
				if(!days[j].equals("*")) {
				
				
				weekClass++; 
				
				
				}
				
			}//for2
			
//			System.out.println(weekClass); //OK!
			
			totalClass = weekClass*4; //전체 취소횟수
			
//			System.out.println(totalClass); //OK!
			
			
			
			
			
			
			teacherCancelRate = ((double)teacherCancel1/(double)totalClass)*100; //취소율 계산//->********이게 문제임!!!!!!******
			
			teacherCancelRateRound = Math.round(teacherCancelRate);
			
//			System.out.println(teacherCancelRate); //확인용
//			System.out.println(teacherCancelRateRound); //확인용
			
			
			
//			수업당 선생님 취소율 배열 value에 취소율 넣기
			classNum = Schedulelist.get(i).getClassNumber();
			eachClassTCancelRate.put(classNum, teacherCancelRateRound);
			
			
			
			
			
			
		//만약 (취소횟수/전체 수업횟수*100>=50)면 블랙리스트에 올리기 
			if (teacherCancelRate>=50) {
				
				
				//teacherNum이 존재하지 않으면 넣기
				if(!TeacherBlacklist.contains(teacherNum)) {
					
					TeacherBlacklist.add(teacherNum);
					
				}	
				
				
			}	
			
			weekClass = 0; //주 횟수 초기화 
			totalClass = 0; //전체 횟수 초기화
			teacherCancelRate = 0; //취소율 초기화
			
			
		}//for1
		
		
//		System.out.println(TeacherBlacklist); //확인용
//		
//		//수업번호별 선생님 취소율 배열 확인
//		Set<String> set = eachClassTCancelRate.keySet();
//
//		Iterator<String> iter2 = set.iterator();
//
//		while(iter2.hasNext()) {
//		String key = iter2.next();
//
//		String result = String.format("%s : %d",key,eachClassTCancelRate.get(key));
//
//		System.out.println(result);
//
//		System.out.println("------------------------------");
//		
//		}

		
		
		
		//블랙리스트 선생님 띄우기
		
		//ArrayList<String> teacherName = new ArrayList<String>();
		String teacherName = "";
		System.out.println("=================================");
		System.out.println("\t블랙리스트 선생님\t");
		
		for(int i = 0; i<TeacherBlacklist.size(); i++) {
			for (int j = 0; j<Teacherlist.size(); j++) {
				if(TeacherBlacklist.get(i).equals(Teacherlist.get(j).getTNumber())){
					teacherName = Teacherlist.get(j).getTName();
					
				}
				
			}//for2
			
			System.out.printf("선생님 번호: %s, 이름: %s", TeacherBlacklist.get(i), teacherName);
			System.out.println();
			
			
		}//for1
		
		//선생님의 각 수업 취소율 보여주기
		
			
		System.out.println("취소율을 보고싶은 선생님의 번호를 입력해주세요.");
		String wantTeacher = scan.nextLine();
		
		
		for (int i = 0; i<Schedulelist.size(); i++) {
			
			teacherNum = Schedulelist.get(i).getTNumber();
			classSubject =  Schedulelist.get(i).getSubject();
			classNum = Schedulelist.get(i).getClassNumber();
			
			
			if (wantTeacher.equals(teacherNum)) {
				
				
				
				
				for (int z =0; z<Teacherlist.size(); z++) {
					
				if (teacherNum.equals(Teacherlist.get(z).getTNumber()))

				teacherName = Teacherlist.get(z).getTName();
				
				
				
				}
				
				
				
				
				
				System.out.printf("%s 선생님의 수업별 취소율", teacherName);
				
				System.out.println();
				
				for (int j = 0; j<eachTeacherClass.get(teacherNum).size(); j++) {
					
					System.out.printf("수업과목 : %s, 선생님의 취소율 : %d%%", classSubject, eachClassTCancelRate.get(classNum));
					System.out.println();
					
				}//for2
				
				break;
				
			}
			
			
		} //for1
		
//		TeacherBlacklist.clear();//이거이거
//		eachTeacherClass.clear();
//		eachClassTCancelRate.clear();
		
		System.out.println("회원목록에서 삭제 하시겠습니까?");
		
		System.out.println("1. 네     2. 아니오");
		
		String answer = scan.nextLine();
		
		
		if (answer.equals("1")) {
			
			ComRegisterDeleteT.deleteTMember(wantTeacher);
			
			System.out.println("삭제가 완료되었습니다.");
			
		}
		
		

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		//		//초기화 //이거이거
//		for (int i = TeacherBlacklist.size()-1; i>=0; i--) {
//			
//			TeacherBlacklist.remove(i);
//			
//		}
//		
		
//		TeacherBlacklist.remove(TeacherBlacklist.indexOf(wantTeacher));//이거이거
		
//		TeacherBlacklist.clear(); //이거이거
//		
		
//		System.out.println("방배열도 삭제");
		
		
//		System.out.printf("%s 선생님을 삭제하겠습니까?", teacherName);
//		
//		System.out.println("1. 네  2. 아니오");
//		
//		String answer = scan.nextLine();
//		
//		
//		if (answer.equals("1")) {
//			
//			com.register.ComRegisterDeleteT.deleteTMember(wantTeacher);
//			
//		
//		
//		}else  {
//			
//			
//			
//			
//		}
		
		
	}//teacherblacklist






}//Blacklist
