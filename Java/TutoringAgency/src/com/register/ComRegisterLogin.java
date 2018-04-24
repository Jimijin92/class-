package com.register;

import java.util.ArrayList;
import java.util.Scanner;

import com.common.Manager;
import com.common.Student;
import com.common.Teacher;
import com.io.ComInManager;
import com.io.ComInStudent;
import com.io.ComInTeacher;
import com.manager.ComManagerMenu;
import com.student.ComStudentMenu;
import com.teacher.ComTeacherMenu;

public class ComRegisterLogin {
	
	private static Scanner scan;
	private static ArrayList<Teacher> TeacherList;
	private static ArrayList<Student> StudentList;
	private static ArrayList<Manager> ManagerList;
	private static String userEndemic; // 고유번호 (식별번호 뺐다.)
	static String tempId;
	static String tempPw;
	

	static {
		scan = new Scanner(System.in);
		TeacherList = new ArrayList<Teacher>();
		StudentList = new ArrayList<Student>();
		ManagerList = new ArrayList<Manager>();
		
		tempId = "";
		tempPw ="";
		
		userEndemic = "";
		//userEndemic[1]="";

	}

	public static String getUserEndemic() {
		return userEndemic;
	}
	
	
	public static void setUserEndemic(String userEndemic) {
		ComRegisterLogin.userEndemic = userEndemic;
	}
	
	
	static void login() {
		
		
		
		ComInTeacher.load();
		ComInStudent.load();
		ComInManager.load();
		
		
		System.out.println("---------------------");
		System.out.println("       로  그  인 ");
		System.out.println("---------------------");
		System.out.println("ID와 PW를 입력하시오.");
		System.out.print("ID: ");
		tempId = scan.nextLine();
		tempId = tempId.toLowerCase();
		
		
		System.out.print("PW : ");
		tempPw = scan.nextLine();


		loginCheckT(tempId, tempPw);

		//userEndemic = loginCheck(tempId, tempPw);	//loginCheck() -> 해당 사용자 [고유번호 , 식별번호] 받음
		
		
		
	}

	
//	//pbg1220,A123456
//	//utfe1002,korute313
	public static void loginCheckT(String id, String pw) {
		ComInTeacher.load();
		ComInStudent.load();
		ComInManager.load();
		
		TeacherList = ComInTeacher.getTeacherlist();
		StudentList = ComInStudent.getStudentlist();
		ManagerList = ComInManager.getManagerlist();
		
		//식별자와 고유번호 뽑아오기
		
	

		for(int i=0; i<TeacherList.size(); i++) {		//id 가 선생님이면?
			if(id.equals(TeacherList.get(i).getTId()) && pw.equals(TeacherList.get(i).getTPw())) {
				userEndemic = TeacherList.get(i).getTNumber();
				System.out.println(TeacherList.get(i).getTName()+"님 로그인 되었습니다.");
				ComTeacherMenu.TMenu();
				
				break;
				//userEndemic[1] = TeacherList.get(i).getTDivision(); 
				//ComStudentMenu.UserNumber(userEndemic);
				
			}//else {
			//	loginCheckS(tempId, tempPw);
			//}	
		}
		for(int i =0 ;i< StudentList.size();i++) {		//id 가 학생이면?
			if(id.equals(StudentList.get(i).getSId()) && pw.equals(StudentList.get(i).getSPw())) {
				userEndemic = StudentList.get(i).getSNumber();
				System.out.println(StudentList.get(i).getSName()+"님 로그인 되었습니다.");
				
				ComStudentMenu.SMenu();
				break;
				//userEndemic[0] = StudentList.get(i).getSNumber();
				//userEndemic[1] = StudentList.get(i).getSDivision();
				//ComStudentMenu.UserNumber(userEndemic);
				
			}//else {
			//	loginCheckM(tempId, tempPw);
			//}
		}
		for(int i=0; i<ManagerList.size();i++) {		//id 가 매니저이면?
		if(id.equals(ManagerList.get(i).getMId()) && pw.equals(ManagerList.get(i).getMPw())) {
			userEndemic = ManagerList.get(i).getMNumber();
			System.out.println(ManagerList.get(i).getMName() + "님 로그인 되었습니다.");
			ComManagerMenu.MMenu();
			
			break;
			//ComStudentMenu.UserNumber(getUserEndemic());
			//userEndemic[0] = ManagerList.get(i).getMNumber();
			//userEndemic[1] = ManagerList.get(i).getMDivision();
		}//else {
//
//			System.out.println("아이디와 비밀번호가 맞지 않습니다.");
//			System.out.println("다시 확인하시고 입력해주시기 바랍니다.");
//			break;
//
//			}
		}
		System.out.println("아이디와 비밀번호가 맞지 않습니다.");
		System.out.println("다시 확인하시고 입력해주시기 바랍니다.");
		
		
		
		
	}//loginCheckT
//	public static void loginCheckS(String id, String pw) {
//		ComInStudent.load();
//
//		StudentList = ComInStudent.getStudentlist();
//	
//		//식별자와 고유번호 뽑아오기
//		for(int i =0 ;i< StudentList.size();i++) {		//id 가 학생이면?
//			if(id.equals(StudentList.get(i).getSId()) && pw.equals(StudentList.get(i).getSPw())) {
//				userEndemic = StudentList.get(i).getSNumber();
//				System.out.println("로그인 되었습니다.");
//				ComStudentMenu.SMenu();
//				break;
//				//userEndemic[0] = StudentList.get(i).getSNumber();
//				//userEndemic[1] = StudentList.get(i).getSDivision();
//				//ComStudentMenu.UserNumber(userEndemic);
//				
//			}else {
//				loginCheckM(tempId, tempPw);
//			}
//		}
//		
//	}//loginCheckS
//	public static void loginCheckM(String id, String pw) {
//
//		ComInManager.load();		
//
//		ManagerList = ComInManager.getManagerlist();
//
//		for(int i=0; i<ManagerList.size();i++) {		//id 가 매니저이면?
//			if(id.equals(ManagerList.get(i).getMId()) && pw.equals(ManagerList.get(i).getMPw())) {
//				userEndemic = ManagerList.get(i).getMNumber();
//				System.out.println("로그인 되었습니다.");
//				ComManagerMenu.MMenu();
//				break;
//				//ComStudentMenu.UserNumber(getUserEndemic());
//				//userEndemic[0] = ManagerList.get(i).getMNumber();
//				//userEndemic[1] = ManagerList.get(i).getMDivision();
//			}else {
//
//				System.out.println("아이디와 비밀번호가 맞지 않습니다.");
//				System.out.println("다시 확인하시고 입력해주시기 바랍니다.");
//				break;
//
//			}
//		}
//		
//	}//loginCheckM
	
	
//		
//		//로그인 - ID대조
//		
//		//pbg1220,A123456
//		//utfe1002,korute313
//		//선생님 파일과 비교
//		
//
//		for(int i=0; i<TeacherList.size(); i++) {
//			
//			if( !(idIn.equals(TeacherList.get(i).getTId())) ) {	//선생님이 아니라면
//				
//				
//			}else {	//선생님이 맞다면
//				
//				for(int j=i; j<TeacherList.size(); j++) {
//					if( pw.equals(TeacherList.get(j).getTPw()) ) {
//							System.out.println("선생님이다");
//							endemicNum = TeacherList.get(j).getTDivision() +","+ TeacherList.get(j).getTNumber();		//선생님 식별, 고유번호
//							break;
//						}else {
//							System.out.println("올바르지 않은 비밀번호입니다.");
//							break;
//						}
//				}
//			}
//		}
//		
//		
//		//jordan23,Bills07,
//		//학생 파일과 비교
//		for(int i=0; i<StudentList.size(); i++) {
//			
//			if( !(idIn.equals(StudentList.get(i).getSId())) ) {	//학생이 아니라면
//			
//			}else {	//학생이 맞다면
//				
//				for(int j=i; j<StudentList.size(); j++) {
//					if( pw.equals(StudentList.get(j).getSPw()) ) {
//							System.out.println("학생이다");
//							endemicNum = StudentList.get(j).getSDivision() +","+ StudentList.get(j).getSNumber();		//학생 고유번호
//							break;
//						}else {
//							System.out.println("올바르지 않은 비밀번호입니다.");
//							break;
//						}
//				}
//			}
//		}
//		
//		
//		//wlalwlss0,tkfkdmsm1 -> 이거 쓰면 안됨.
//		//kiki111,P00001
//		//매니저 파일과 비교
//		for(int i=0; i<ManagerList.size(); i++) {
//			
//			if( !(idIn.equals(ManagerList.get(i).getMId())) ) {	//매니저가 아니라면
//				
//			
//			}else {	//매니저가 맞다면
//				
//				for(int j=i; j<ManagerList.size(); j++) {
//					if( pw.equals(ManagerList.get(j).getMPw()) ) {
//							System.out.println("매니저이다");
//							endemicNum = ManagerList.get(j).getMDivision() +","+ ManagerList.get(j).getMNumber();		//매니저 고유번호
//							break;
//						}else {
//							System.out.println("올바르지 않은 비밀번호입니다.");
//							break;
//						}
//				}
//			}
//		}
//		
//		
//		
//		
//		return endemicNum;
			


		
	
	
	
	
	
	
	
}






















