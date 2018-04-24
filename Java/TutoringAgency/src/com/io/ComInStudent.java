package com.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

import com.common.Student;
import com.common.StudentAddInfor;

public class ComInStudent {
	private static final String FILESPATH = ".\\Data\\학생 기본정보.dat";	
	private static final String FILESAIPATH = ".\\Data\\학생 추가정보.dat"; 
	
	private static ArrayList<Student> Studentlist;
	private static ArrayList<StudentAddInfor> StudentAddInforlist;
	//private static Scanner scan ;
	
	static {
		//scan = new Scanner(System.in);
		Studentlist = new ArrayList<Student>();	//학생 기본정보 넣은 리스트
		StudentAddInforlist = new ArrayList<StudentAddInfor>();	//학생 추가정보 넣은 리스트
		
		
	}
	
	
	
	public static ArrayList<Student> getStudentlist() {
		return Studentlist;
	}
	public static ArrayList<StudentAddInfor> getStudentAddInforlist() {
		return StudentAddInforlist;
	}


	//메뉴 시작전 학생 기본정보.dat 와 학생 추가정보.dat 읽어서 메모리에 옮기기
	public static void load() {
		try {
			Studentlist.clear();
			StudentAddInforlist.clear();
			//학생 기본정보.dat list에 옮기기
			BufferedReader reader = new BufferedReader(new FileReader(FILESPATH));
			
			String line ="";
			
			while((line = reader.readLine()) != null) {
				//텍스트 1줄 = 1명 회원 = Member객체 1개
				String[] temp = line.split(",");
				
				Student s = new Student();
				
				String[] sSubject = new String[2];
				sSubject[0] = temp[13];
				sSubject[1] = temp[14];
				
				s.setSJumin(temp[0]);
				s.setSId(temp[1]);
				s.setSPw(temp[2]);
				s.setSName(temp[3]);
				s.setSGender(temp[4]);
				s.setSAge(temp[5]);
				s.setSAddress(temp[6]);
				s.setSTel(temp[7]);
				s.setSHighSchool(temp[8]);
				
				s.setSDepart(temp[9]);
				s.setSGrade(temp[10]);
				s.setSWantGender(temp[11]);
				s.setSPrice(temp[12]);
				s.setSSubject(sSubject);
				s.setSDivision(temp[15]);
				s.setSNumber(temp[16]);
				
				Studentlist.add(s);
			}
			
			reader.close();
			
		} catch (Exception e) {
			System.out.println("load : " + e.toString());

		}
		
		try {
			//학생 추가정보.dat list에 옮기기
			BufferedReader reader = new BufferedReader(new FileReader(FILESAIPATH));
			
			String line ="";
			
			while((line = reader.readLine()) != null) {
				
				//텍스트 1줄 = 1명 회원 = StudentAddInfor객체 1개
				String[] temp = line.split(",");
				
				StudentAddInfor sai = new StudentAddInfor();
				
				sai.setSSelfIntro(temp[0]);
				sai.setSDivision(temp[1]);
				sai.setSNumber(temp[2]);

				StudentAddInforlist.add(sai);
			}
			
			reader.close();
			
		} catch (Exception e) {
			System.out.println("load : " + e.toString());

		}

		
	}
}
