package com.test.question;

import java.io.File;
import java.lang.Character.Subset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Ex73and74 {//class명 항상 대문자로 시작!

	public static void main(String[] args) {
		
		//m1();//문제1.
		//m2();//문제1-1 다른방법
		
		m3();//문제2
		m5();//문제4
		
	}

	private static void m5() {
		
		/*문제4.
		요구사항] 사이즈가 0byte인 파일만 골라서 삭제하시오.
		리소스] 파일 제거 
		결과] 총 34개의 파일을 삭제했습니다.*/
		
		String path = "D:\\파일_디렉토리_문제\\파일 제거";
		File dir = new File(path);
		
		if(dir.exists()) {
			File[] list = dir.listFiles();
			for(File files : list) {
				String fileString = String.format("%s\\%s", path, files);
				File file = new File(fileString);
		
					if(file.exists()) {
						System.out.println(file.delete());
						
					}
			}
		}
	
		
	}

	private static void m3() {
		/*문제2.
		요구사항] 이미지 파일이 확장자별로 있다. 확장자별로 몇개인지 카운트?
		리소스] 확장자별 카운트
		결과] *.gif : 10개
			  *.jpg : 5개	
			  *.png : 3개
		추가] mouse.bmp 추가
			  -> 소스 수정없이 *.bmp : 1개
		힌트]HashMap 사용*/
		
		String path = "D:\\파일_디렉토리_문제\\확장자별 카운트";
		File folder = new File(path);
		
		int count = 0;
		String name1 = "";
		
		if(folder.exists()) {
			File[] list = folder.listFiles();
			
			//****
			HashMap<String, String> map = new HashMap<String,String>();
			Map.put(name1, count);
			
			for(File files : list) {
				if(files.isFile()) {
					String name = files.getName();
					String extention = name.substring(name.indexOf(".")+1);
					
					ArrayList<String>extenionList = new ArrayList<String>();
					extenionList.add(extention);
					
					set<String> keys = count
					
					
					
					
					//String fileString = String.format("%s\\%s", path, files.getName());
					//File file = new File(fileString);
					
				}
				
			}
			
		}
		
		
		
		
		
		
	}

	private static void m2() {
	
		String path = "D:\\파일_디렉토리_문제\\음악 파일\\Music";
		File folder = new File(path);
		int num3 = 1;

		if(folder.exists()) {
			File[] files = folder.listFiles();
			
			for(File file : files ) {
				if(file.exists()) {
					
				String pathnew = String.format("%s//[%s]%s", path, num3(num3), file.getName() );
				
				num3++;
				
				File fileNew = new File(pathnew);
				file.renameTo(fileNew);
				
				}
			
			}
		}
		
	}//m2

	private static String num3(int num3) {
		String num4 = "";
		
		if(num3<10) {
			num4 = "00"+ num3;
		}else if(num3<100) {
			num4 = "0" + num3;
		}else {
			num4 = "" + num3;
		}
		
		return num4;
		
	}

	private static void m1() {
	
	/*요구사항] 음악 파일이 100개 있다. 파일명
	리소스] 음악 파일
	결과]
	[001]7 go up-Yum-Yum(얌얌).mp3
	[002]10cm - 봄이 좋냐__.mp3
	[003]10cm- 스토커.mp3
	..
	[100]화려강산-Don't Matter.mp3
    */
		
	//path지정
	String path = "D:\\파일_디렉토리_문제\\음악 파일\\Music";
	File folder = new File(path);
	
	
	
	if(folder.exists()) {
		String[] list = folder.list();
		
		for (int i=0; i<100; i++) {
			
			String[] name= new String[100]; 
			File file = new File(path + "\\" + list[i]);

			String count = count(i);
			
			name[i] = String.format("[%s]%s", count, list[i]);
			
			File fileNew = new File(path + "\\" + name[i]);
			
			
			file.renameTo(fileNew);
			
		}
	}		
		
	}

	private static String count(int i) {
		String num = "";
		int num2 = i+1;
		if(num2<10) {
			num = "00"+ num2;
		}else if(num2<100) {
			num = "0" + num2;
		}else {
			num = "" + num2;
		}
		
		return num;
		
	}	
		
	
		
  
}
