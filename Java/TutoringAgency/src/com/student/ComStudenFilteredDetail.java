package com.student;

import java.util.ArrayList;
import java.util.Scanner;

import com.common.Teacher;
import com.common.TeacherAddInfor;
import com.io.ComInTeacher;

public class ComStudenFilteredDetail {
	
	private static ArrayList<Teacher> teacher;
	private static ArrayList<TeacherAddInfor> teacherAdd;
	private static ComInTeacher list;
	private static Scanner scan;
	
	static {
		teacher = new ArrayList<Teacher>();
		teacherAdd = new ArrayList<TeacherAddInfor>();
		list = new ComInTeacher();
		scan = new Scanner(System.in);
	}

	
	//필터된 선생님 선택 -> 선택된 선생님의 상세 정보 출력해주는 클래스
	//선생님이 맘에 들면 선생님의 상세 스케줄 보기 클래스로 이동(TScedule)
	//다른 선생님 보기를 원하면 필터링된 선생님 목록으로 되돌아가기(Sorting)
	
	
	public static void detail(String s) {	//s는 선생님의 고유번호
		
		list.load();
		teacherAdd = list.getTeacherAddInforlist();
		teacher = list.getTeacherlist();
		
		
		int num = teacher.size();
		int teacherNum = 0;
		
		for(int i=0; i<num; i++) {
			if(teacher.get(i).getTNumber().equals(s)) {
				
				teacherNum = i;	//선생님의 고유번호 찾기!
				break;
			}
		}//for
		System.out.println();
		System.out.println();
		System.out.println("☆★☆★☆★☆★☆★☆★☆★☆★☆");
		System.out.println("★선택하신 선생님 정보 상세정보 ☆");
		System.out.println("☆★☆★☆★☆★☆★☆★☆★☆★☆");
		System.out.println();
		
		System.out.printf("[이름] : %s\n",teacher.get(teacherNum).getTName());		//위에서 찾아온 고유번호로 선생님의 상세 정보 print
		System.out.printf("[성별] : %s\n",teacher.get(teacherNum).getTGender());
		System.out.printf("[나이] : %s\n",teacher.get(teacherNum).getTAge());
		System.out.println();
		System.out.printf("[1회당 가격]\t: %s만원\n",teacher.get(teacherNum).getTPrice());
		System.out.printf("[지도 과목]\t: %s/%s\n",teacher.get(teacherNum).getTSubject()[0]
													,teacher.get(teacherNum).getTSubject()[1]);
		System.out.printf("[휴대폰 번호]\t: %s\n",teacher.get(teacherNum).getTTel());
		System.out.printf("[학교/학과]\t: %s/%s\n",teacher.get(teacherNum).getTUniv()
													,teacher.get(teacherNum).getTDepart());
		System.out.printf("[특이사항]\t: %s\n",teacherAdd.get(teacherNum).getTSpecialNote());
		System.out.printf("[교습 스타일]\t: %s\n",teacherAdd.get(teacherNum).getTStyle());
		System.out.printf("[선생님 소개]\t: %s\n",teacherAdd.get(teacherNum).getTSelfIntro());
		System.out.println();
		System.out.println();
		
		boolean loop = true;
		
		while(loop) {
			System.out.println("수강신청을 하시겠습니까?????");
			System.out.println();
			System.out.println("1.예(선생님 스케줄 보기)");
			System.out.println("2.아니오(목록으로 돌아가기)");
			System.out.print("입력 : ");
			String select = scan.nextLine();
			
			if(select.equals("1")) {
				loop = false;
				ComStudentTSchedule.schedule(teacherNum+"");
			}else if(select.equals("2")) {
				loop = false;
				ComStudentSorting.sort();
			}else {
				System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
				System.out.println("정확한 숫자를 입력해 주세요");
				System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
			}
		}//while
		

		
		
	}
	
	
}














