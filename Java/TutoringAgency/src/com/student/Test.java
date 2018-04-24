package com.student;

import java.util.ArrayList;

import com.common.Teacher;
import com.common.TeacherAddInfor;
import com.io.ComInTeacher;

public class Test {
	private static ArrayList<Teacher> teacher;
	private static ArrayList<TeacherAddInfor> teacherAdd;
	private static ComInTeacher list;
	
	static {
		teacher = new ArrayList<Teacher>();
		teacherAdd = new ArrayList<TeacherAddInfor>();
		list = new ComInTeacher();
	}

	
	public static void main(String[] args) {
		
		
		list.load();
		teacherAdd = list.getTeacherAddInforlist();
		teacher = list.getTeacherlist();
		
		
		System.out.println(teacherAdd.size());
		
		
		
	}
	
}

