package com.manager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Scanner;

import com.common.Schedule;
import com.common.Student;
import com.common.Teacher;
import com.io.ComInManager;
import com.io.ComInSchedule;
import com.io.ComInStudent;
import com.io.ComInTeacher;

public class ComManagerMenu {

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
	public static void MMenu() {
		//메뉴 시작전 학생 기본정보.dat 와 학생 추가정보.dat 읽어서 메모리에 옮기기
		ComInManager.load();
		//System.out.println(ComInManager.getManagerlist());
		boolean loop = true;
		
		while (loop) {
			
			System.out.println("============================");
			System.out.println("관리자");
			System.out.println("============================");
			System.out.println("1.회원 목록");
			System.out.println("2.통계");
			System.out.println("3.블랙리스트 관리");
			System.out.println("4.마이페이지");
			System.out.println("5.캘린더 보기");
			System.out.println("선택 : ");
			
			String sel = scan.nextLine();
			
			if(sel.equals("1")) listMember();
			else if (sel.equals("2")) ComManagerStatistics.statisticsMenu();
			else if (sel.equals("3")) ComManagerBlacklist.blacklistMenu();
			else if (sel.equals("4")) myPage();
			else if (sel.equals("5")) ComManagerCalendar.main();
			else loop = false; //메뉴탈출
			
			
		}
		
		System.out.println("관리자 프로그램 종료");
	
	}
	private static void listMember() {
		
	}

	
	private static void myPage() {
		
	}
	private static void diary() {
		
	}
	
	
}
