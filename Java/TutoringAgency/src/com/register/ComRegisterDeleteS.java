package com.register;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import com.common.Schedule;
import com.common.Student;
import com.common.Teacher;
import com.io.ComInStudent;
import com.io.ComInTeacher;

public class ComRegisterDeleteS {
	
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
	
	public static void deleteSMember(String studentNum) {
		
		//ComRegisterDeleteS.deleteSMember("1");//->이렇게 쓰면 됌!
		
//		ComInStudent.load();
			
		Studentlist= ComInStudent.getStudentlist();//있어야함 
		
//		for (Teacher t : Teacherlist) {
//			
//			if (t.getTName().equals(teacherNum)) {
//				
//				Teacherlist.remove(t);
//			}
//	
//			
//		}
		
		
		
		
		
	for (int i = 0; i < Studentlist.size(); i++) {
	
	if(studentNum.equals(Studentlist.get(i).getSNumber())){
		
//		Teacherlist.remove(Teacherlist.get(i));
		Studentlist.remove(i);
		
		
	}
	
}
		
		

		
		
		saveS();
		
		
		
	}
	

	
	
	private static void saveS() {
		
		
		try {
			
			BufferedWriter writer = new BufferedWriter(new FileWriter(FILESPATH));
			
			
			for(Student app : Studentlist) {
			String[] temp = app.getSSubject();
			
			String line = String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s"
					,app.getSJumin(),app.getSId(),app.getSPw(),app.getSName()
					,app.getSGender(),app.getSAge(),app.getSAddress(),app.getSTel()
					,app.getSHighSchool(),app.getSDepart(),app.getSGrade()
					,app.getSWantGender(),app.getSPrice(),temp[0],temp[1]
					,app.getSDivision(),app.getSNumber());
			
	
			

				

				
				
				writer.write(line); //메모리 -> 텍스트파일(dat) 복사
				writer.newLine();
				
			}
			
			writer.close();
			System.out.println("삭제완료");
			
		} catch (Exception e) {
			System.out.println("saveS : " + e.toString());

		}
		

		
	}
	
	
	

}
