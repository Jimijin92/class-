package com.teacher;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import com.common.Student;
import com.common.StudentAddInfor;

import com.common.Teacher;
import com.common.TeacherAddInfor;
import com.io.ComInTeacher;
import com.student.ComStudentRequestSTList;
import com.student.ComStudentRequestTSList;


public class ComTeacherMenu {
	private static ArrayList<Teacher> Teacherlist;
	private static ArrayList<TeacherAddInfor> TeacherAddInforlist;
	private static Scanner scan ;
	
	static {
		scan = new Scanner(System.in);
		Teacherlist = new ArrayList<Teacher>();	//선생님 기본정보 넣은 리스트
		TeacherAddInforlist = new ArrayList<TeacherAddInfor>();	//선생님 추가정보 넣은 리스트
	}
	public static void TMenu() {
		
		boolean loop = true;
	      
	    //ComStudentSearchT search = new ComStudentSearchT();
	      
	    while(loop) {
	    	System.out.println("===================================");
	    	System.out.println("   원하는 메뉴를 선택해 주세요");
	    	System.out.println("===================================");
	    	System.out.println(" --------------------------------");
	    	System.out.println("ㅣ 1.학생 찾기      ㅣ");
	    	System.out.println("ㅣ 2.내가 신청한 학생 보기   ㅣ");
	    	System.out.println("ㅣ 3.나를 선택한 학생 보기   ㅣ");
	    	System.out.println("ㅣ 4.스케줄 보기      ㅣ");
	    	System.out.println("ㅣ 5.일정 취소하기      ㅣ");
	    	System.out.println("ㅣ 6.마이페이지      ㅣ");
	    	System.out.println("ㅣ 7.종료         ㅣ");
	    	System.out.println(" --------------------------------");

	    	System.out.print("입력 : ");
	    	String temp = scan.nextLine();
	         
	    	 if(temp.equals("1")) {
		        	// search.searchT();
		        	// loop = false;
		        }else if(temp.equals("2")) {
		        	ComTeacherRequestTSList.requestTSList();
		        }else if(temp.equals("3")) {
		        	ComTeacherRequestSTList.requestSTList();

		        }else if(temp.equals("4")) {
		        	ComTeacherCalendar.teacherdiary();
		        }else if(temp.equals("5")) {
		        	ComTeacherCancle.cancle();
		        }else if(temp.equals("6")) {
	            
		        }else if(temp.equals("7")) {
		            
			    }else {
		        	System.out.println("제대로된 숫자를 입력해 주세요");
		        }
		    }
	    
	}

}
