package com.student;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import com.common.Teacher;
import com.io.ComInTeacher;

public class ComStudentSearchList {	//필터링 클래스
	
	private static Scanner scan;
	//public static ComStudentSearchTemp temp;
	private static ComInTeacher list;
	private static ArrayList<Teacher> filteredTeacher;
	
	
	static {
		scan = new Scanner(System.in);
		list = new ComInTeacher();
		filteredTeacher = new ArrayList<Teacher>();
	}
	
	
	//SearchTemp 에 저장된 값에 부합하는 선생님들만 출력!
	//미 입력한 조건들은 무관으로 간주 null 이면 모두 출력
	
	
	
	public static void filteredList() {
		
		String address = ComStudentSearchT.temp.getAddress2();
		String gender = ComStudentSearchT.temp.getGender();
		String career = ComStudentSearchT.temp.getCareer();
		String price = ComStudentSearchT.temp.getPrice();
		String subject =ComStudentSearchT.temp.getSubject();
		String grade = ComStudentSearchT.temp.getSchool();
		String special = ComStudentSearchT.temp.getSpecial();
		
		
		System.out.println();
		System.out.println("조건에 맞는 선생님이 검색되었습니다.");
		System.out.println("조건검색 결과");
		
		
		
		ArrayList<Teacher> test = new ArrayList<Teacher>();
		
		ComInTeacher.load();
		test = ComInTeacher.getTeacherlist();
		
		//ArrayList<Teacher> filteredTeacher  = new ArrayList<Teacher>();	//필터링된 선생님 저장하는 리스트
		
		
		for(Teacher t : test) {	
			
			//필터 조건이 저장된 클래스와 전체 리스트를 대조.
			//조건에 맞는 선생님만 출력!
			
			if(address == null || address.equals(t.getTAddress())) {
				
				if(gender == null || gender.equals(t.getTGender())) {
						
					if(grade == null || grade.equals(t.getTGrade())){
							
						if(career == null || career.equals(t.getTCareer())) {
								
							if(subject == null || subject.equals(t.getTSubject()[0]) || subject.equals(t.getTSubject()[1]) ){
									
								if(price == null || price.equals(t.getTPrice())){
										
									filteredTeacher.add(t);
								}
								
							}
							
						}
					}
				}
			}
		
		
		
		}//for


		ComStudentSorting.sort();
	
	
	}//filteredList
	
	
	public static ArrayList<Teacher> getList() {
		
		return filteredTeacher;
		
	}

}
















