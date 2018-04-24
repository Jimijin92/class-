package com.test.question;

import java.io.File;

public class M7_2017_12_22 {

	public static void main(String[] args) {
	
		/*
		문제7.

		요구사항] 직원 폴더를 접근 -> 직원별 이름으로 폴더 생성 -> 년도별 폴더 생성 -> 각 파일들을 해당 폴더로 이동
		리소스] 직원
		결과] 분류가 완료되었습니다.
		*/
		
		fileEmployee();
		System.out.println("분류가 완료 되었습니다.");
		
	}//main

private static void fileEmployee() {
		
	String path = "D:\\파일_디렉토리_문제\\직원";
	File dir = new File (path);
	String name = "";
	String dump = "";
	String rename = "";
	String year = "";
	String fileName = "";
	
	int f = 0;
	int e = 0;
	int g = 0;

	
	File[] files = dir.listFiles();
	
	if(dir.exists()) {
	
		for(File file : files) {
			if(file.isFile()) {
				path = "D:\\파일_디렉토리_문제\\직원";
				//path 초기화
				
				name = file.getName();
				f = name.indexOf("_");
				dump = name.substring(f+1); //이름 제외한 뒷부분
				rename = name.substring(0 , f); //이름만
				e = dump.indexOf("_");
				year = dump.substring(0, e); //년도만
				fileName = file.getName(); //파일명
				
				path = String.format("%s\\[직원 폴더]%s", path, rename);
				File subdir = new File(path);
				
				if (!(subdir.exists())) {
					formed(subdir); //폴더 생성
					path = String.format("%s\\%s", path, year);
					subdir = new File(path);
					if (!(subdir.exists())) {
						formed(subdir); //하위 폴더 생성
					}
					fileName(path, fileName, file); //파일 위치 변환
					
				} else {
					path = String.format("%s\\%s", path, year);
					subdir = new File(path);
					
					if (!(subdir.exists())) {
						formed(subdir); //하위 폴더 생성
						fileName(path, fileName, file); //파일 위치 변환
					} else {
						fileName(path, fileName, file); //파일 위치 변환
					} //if 년도폴더 존재유무
				} //if 이름폴더 존재유무
			} //if 파일만
		} //향상된 for문
	} //if dir 존재 유무
} //fileEmployee()

private static void formed(File subdir) {
	subdir.mkdir();
}

private static void fileName(String path, String fileName, File file) {
	File subdir;
	path = String.format("%s\\%s", path, fileName);
	subdir = new File(path);
	file.renameTo(subdir); 
}
} //M17_2017_12_22

