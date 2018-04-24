package com.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;

import com.common.Teacher;
import com.common.TeacherAddInfor;

public class ComInTeacher {
	private static final String FILETPATH = ".\\Data\\선생님 기본정보.dat";	
	private static final String FILETAIPATH = ".\\Data\\선생님 추가정보.dat";
	
	private static ArrayList<Teacher> Teacherlist;
	private static ArrayList<TeacherAddInfor> TeacherAddInforlist;
	//private static Scanner scan ;
	
	static {
		//scan = new Scanner(System.in);
		Teacherlist = new ArrayList<Teacher>();	//선생님 기본정보 넣은 리스트
		TeacherAddInforlist = new ArrayList<TeacherAddInfor>();	//선생님 추가정보 넣은 리스트
	}
	
	//학생 기본정보 보이기
	public static ArrayList<Teacher> getTeacherlist() {
		return Teacherlist;
	}

	//학생 기본정보 보이기
	public static ArrayList<TeacherAddInfor> getTeacherAddInforlist() {
		return TeacherAddInforlist;
	}


	public static void load() {
		try {
			Teacherlist.clear();
			TeacherAddInforlist.clear();
			//선생님 기본정보.dat list에 옮기기
			BufferedReader reader = new BufferedReader(new FileReader(FILETPATH));
			
			String line ="";
			
			while((line = reader.readLine()) != null) {
				//텍스트 1줄 = 1명 회원 = Member객체 1개
				String[] temp = line.split(",");
				
				Teacher t = new Teacher();
				
				//희망지역
				String[] tZone = new String[3];
				tZone[0] = temp[12];
				tZone[1] = temp[13];
				tZone[2] = temp[14];
				
				//희망과목
				String[] tSubject = new String[2];
				tSubject[0] = temp[17];
				tSubject[1] = temp[18];
				
				//별점
				HashMap<String,String> tStar = new HashMap<String,String>() ;
				tStar.put(temp[19], temp[20]);
				tStar.put(temp[21], temp[22]);
				tStar.put(temp[23], temp[24]);
				tStar.put(temp[25], temp[26]);
				tStar.put(temp[27], temp[28]);
				
				t.setTJumin(temp[0]);
				t.setTId(temp[1]);
				t.setTPw(temp[2]);
				t.setTName(temp[3]);
				t.setTGender(temp[4]);
				t.setTAge(temp[5]);
				t.setTAddress(temp[6]);
				t.setTTel(temp[7]);
				t.setTUniv(temp[8]);
				t.setTDepart(temp[9]);
				t.setTGrade(temp[10]);
				t.setTCareer(temp[11]);
				
				t.setTZone(tZone);			//12,13,14
				
				t.setTTarget(temp[15]);
				t.setTPrice(temp[16]);
				t.setTSubject(tSubject);	//17,18
				t.setTStar(tStar);			//19,20/21,22/
				t.setTDivision(temp[29]);
				t.setTNumber(temp[30]);

				Teacherlist.add(t);
			}
			
			reader.close();
			
		} catch (Exception e) {
			System.out.println("loadTeacherlist : " + e.toString());

		}
		
		try {
			//학생 추가정보.dat list에 옮기기
			BufferedReader reader = new BufferedReader(new FileReader(FILETAIPATH));
			
			String line ="";
			
			while((line = reader.readLine()) != null) {
				
				//텍스트 1줄 = 1명 회원 = TeacherAddInfor객체 1개
				String[] temp = line.split(",");
				
				TeacherAddInfor tai = new TeacherAddInfor();
				
				tai.setTSpecialNote(temp[0]);
				tai.setTStyle(temp[1]);
				tai.setTSelfIntro(temp[2]);
				
				tai.setTDivision(temp[3]);
				tai.setTNumber(temp[4]);

				TeacherAddInforlist.add(tai);
				
			}
			
			reader.close();
			
		} catch (Exception e) {
			System.out.println("loadTeacherAddInforlist : " + e.toString());

		}

		
	}
}
