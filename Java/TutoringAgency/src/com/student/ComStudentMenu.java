package com.student;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
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
import com.io.*;




public class ComStudentMenu {
	private static final String FILEAPPLYPATH = ".\\Data\\신청현황.dat";	
	private static final String FILESCHEDULEPATH = ".\\Data\\스케줄.dat";
	
	private static ArrayList<Student> Studentlist;
	private static ArrayList<Teacher> Teacherlist;
	private static ArrayList<Application> Applicationlist ;
	private static ArrayList<TeacherAddInfor> TeacherAddInforlist;
	//스케쥴에 덮어씌우기 위해 일단 어레이 리스트에 담아놓고 추가하기!!!
	private static ArrayList<Schedule> Schedulelist ;
		
	private static Scanner scan ;
	
	static {
		scan = new Scanner(System.in);
		Studentlist = new ArrayList<Student>();
		Applicationlist = new ArrayList<Application>();	//신청현황 넣은 리스트
		Teacherlist = new ArrayList<Teacher>(); 
		TeacherAddInforlist = new ArrayList<TeacherAddInfor>(); 
		Schedulelist = new ArrayList<Schedule>();	//스케줄 기본정보 넣은 리스트
	}
	public static void SMenu() {
		
		//콘솔에서는 목록을 보여주긴 하는데 , 잠깐 보여주는것! -> 완전히 dat에 넣어줘야한다!

		
		
		boolean loop = true;
	      
	    //ComStudentSearchT search = new ComStudentSearchT();
	      
	    while(loop) {
	    	System.out.println("===================================");
	    	System.out.println("   원하는 메뉴를 선택해 주세요");
	    	System.out.println("===================================");
	    	System.out.println(" --------------------------------");
	    	System.out.println("ㅣ 1.선생님 찾기		ㅣ");
	    	System.out.println("ㅣ 2.내가 신청한 선생님 보기	ㅣ");
	    	System.out.println("ㅣ 3.나를 선택한 선생님 보기	ㅣ");
	    	System.out.println("ㅣ 4.스케줄 보기		ㅣ");
	    	System.out.println("ㅣ 5.선생님 평가하기		ㅣ");
	    	System.out.println("ㅣ 6.마이페이지			ㅣ");
	    	System.out.println("ㅣ 7.종료			ㅣ");
	    	System.out.println(" --------------------------------");

	    	System.out.print("입력 : ");
	    	String temp = scan.nextLine();
	    
	        if(temp.equals("1")) {
	        	ComStudentSearchT search = new ComStudentSearchT();
	        	//ComInStudent.load();
	    		//Studentlist = ComInStudent.getStudentlist();
	    		//Student student =  Studentlist.get(1);
	        	search.searchT();
	        }else if(temp.equals("2")) {
	        	ComStudentRequestSTList.requestSTList();
	        }else if(temp.equals("3")) {
	        	ComStudentRequestTSList.requestTSList();
	        	//ComStudentRequestTSList.save();
	        	//save();
	        }else if(temp.equals("4")) {
	        	ComStudentCalendar.studentdiary();
	        }else if(temp.equals("5")) {
	        	ComStudentStar.SCHList();
	        }else if(temp.equals("6")) {
            
	        }else if(temp.equals("7")) {
	            
		    }else {
	        	System.out.println("제대로된 숫자를 입력해 주세요");
	        }
	    }
	    
	    

	}
	
	




}
