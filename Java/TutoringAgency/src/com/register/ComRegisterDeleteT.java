package com.register;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import com.common.Schedule;
import com.common.Student;
import com.common.Teacher;
import com.io.ComInSchedule;
import com.io.ComInTeacher;

public class ComRegisterDeleteT {
	
	private static final String FILESPATH = ".\\Data\\학생 기본정보.dat";
	private static final String FILETPATH = ".\\Data\\선생님 기본정보.dat";
	private static final String FILESCHEDULEPATH = ".\\Data\\스케줄.dat";
	
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
	
	public static void deleteTMember(String teacherNum) {
		
		//ComInTeacher.load();
			
		Teacherlist= ComInTeacher.getTeacherlist();//있어야함 
		Schedulelist= ComInSchedule.getSchedulelist();

		
//		for (Teacher t : Teacherlist) {
//			
//			if (t.getTName().equals(teacherNum)) {
//				
//				Teacherlist.remove(t);
//			}
//	
//			
//		}
		
		
		
		
		
	for (int i = 0; i < Teacherlist.size(); i++) {
	
	if(teacherNum.equals(Teacherlist.get(i).getTNumber())){
		
//		Teacherlist.remove(Teacherlist.get(i));
		Teacherlist.remove(i);
		
		
	}
	
}
//	//스케줄 지우기 
//	for (int i = 0; i < Schedulelist.size(); i++) {
//		
//		if(teacherNum.equals(Schedulelist.get(i).getTNumber())){
//			
////			Teacherlist.remove(Teacherlist.get(i));
//			Schedulelist.remove(i);
//			
//			
//		}
//		
//	}
		
		

		
		
		saveT1();
		
//		saveT2();
		
	}
	



	private static void saveT1() {
		
		
		try {
			
			BufferedWriter writer = new BufferedWriter(new FileWriter(FILETPATH));
			
	
			
			for(Teacher app : Teacherlist) {
				String[] tSubject = app.getTSubject();
				String[] tZone = app.getTZone();
				HashMap <String, String> tStar = app.getTStar();
				String line = String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s"
						,app.getTJumin(),app.getTId(),app.getTPw(),app.getTName()
						,app.getTGender(),app.getTAge(),app.getTAddress(),app.getTTel()
						,app.getTUniv(),app.getTDepart(),app.getTGrade()
						,app.getTCareer(),tZone[0],tZone[1],tZone[2]
						,app.getTTarget(), app.getTPrice()
						,tSubject[0], tSubject[1]
						,"1점", tStar.get("1점"), "2점", tStar.get("2점"), "3점", tStar.get("3점"), "4점", tStar.get("4점"), "5점", tStar.get("5점")
						,app.getTDivision(),app.getTNumber());
				

				
				
				writer.write(line); //메모리 -> 텍스트파일(dat) 복사
				writer.newLine();
				
			}
			
			writer.close();
			System.out.println("삭제완료");
			
		} catch (Exception e) {
			System.out.println("saveT1 : " + e.toString());

		}
		

		
	}
	
//	private static void saveT2() {
//		
//		try {
//			
//			BufferedWriter writer = new BufferedWriter(new FileWriter(FILESCHEDULEPATH));
//			
//	
//			
//			for(Schedule app : Schedulelist) {
//				String[] temp = app.getDays();
//				
//				
//				
//				String line = String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s"
//						,app.getClassNumber(),app.getTNumber(),app.getSNumber(),app.getStartDay()
//						,app.getSubject(),app.getPrice(),app.getStartTime(),app.getTime()
//						,app.getTcancel(),app.getScancel(),app.getTotalCancel()
//						,temp[0], temp[1], temp[2], temp[3], temp[4], temp[5], app.getStar());
//				
//
////				,this.classNumber,this.TNumber,this.SNumber,this.startDay
////				,this.subject,this.price,this.startTime,this.time
////				,this.Tcancel,this.Scancel,this.totalCancel
////				,this.state,this.days[0],this.days[1],this.days[2],this.days[3],this.days[4]);
//				
//				
//				
//				
//				writer.write(line); //메모리 -> 텍스트파일(dat) 복사
//				writer.newLine();
//				
//			}
//			
//			writer.close();
//			
//		} catch (Exception e) {
//			System.out.println("saveT2 : " + e.toString());
//
//		}
//		
//
//		
//	}
	

}
