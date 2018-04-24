package com.test.question;

import java.io.File;
import java.util.HashMap;
import java.util.ArrayList;

public class FileDir {

	
	public static void main(String[] args) {
	
		//m1();
		//m1_1();
		m2();
		//m3();
		//m5();	//완성
		//m7();
		//m4();
		//m6();
		
		
	}//main
	
	private static void m6() {

		String path = "D:\\파일_디렉토리_문제\\크기 정렬";
		File file = new File(path);
		
		if(file.exists()) {
			
			File[] list = file.listFiles();
			
			for(File f : list) {
				
				if(f.isFile()) {
				System.out.println(f.getName());
				}else if(f.isDirectory()) {
					
				}
				
			}
			
			
			
			
			
			
			
			
			
		}
		
		
		
		
	}

	private static void m4() {

		String path = "D:\\파일_디렉토리_문제\\파일 제거";
		File file = new File(path);
		File[]list = file.listFiles();
		
		
		for(File d : list) {
			if(d.length() == 0) {
				d.delete();
			}
		}
		
		
	}

	private static void m2() {

		String path = "D:\\파일_디렉토리_문제\\확장자별 카운트";
		File file = new File(path);
		
		
		if(file.exists()) {
		
		File[] list = file.listFiles();
		
		
		
		HashMap<String,Integer> count = new HashMap<String, Integer>();
		
		
		ArrayList<String> print = new ArrayList<String>();
		
		
		int num = 1;
		
		for(File f : list) {
			String name = f.getName();
			
			int dot = name.lastIndexOf('.');
			String extension = name.substring(dot+1);	//확장자명 추출
			
			//System.out.println(extension);
			
			if(!count.keySet().contains(extension)) {	//없는 확장자명(Key)이면 Value 1로 추가
			count.put(extension, num);
			print.add(extension);
			
			}else {	//이미 있는 key에선 Value +1
				count.put(extension, count.get(extension)+1);
			}
			
		}
		
		
		
		
		for(String s : print) {
			System.out.println(s + ":" + count.get(s) + "개");
		}
		
		
		
		
		}//file.exists()
				
		
		
	}

	private static void m7() {

		String path = "D:\\파일_디렉토리_문제\\직원";
		
		File emp = new File(path);
		
		File[] list = emp.listFiles();
		ArrayList<String> nameOnly = new ArrayList<String>();	//중복 값 제거를 위한 list
		
		for(File f : list) {
				
			String names = f.getName().substring(0,3);	//이름만 출력
			if(!nameOnly.contains(names)) {				//이름이 list에 없으면 add
				nameOnly.add(names);
			}
		}
		
		for(int i=0; i<nameOnly.size(); i++) {
		
		String path2 = String.format("D:\\파일_디렉토리_문제\\직원\\%s",nameOnly.get(i));
		File dir = new File(path2);
		dir.mkdir();
		
		if()
		String dest = "D:\\파일_디렉토리_문제\\직원\\";
		
		
		}//for - 폴더생성
		
		
		
		
		
		
		
		for(File f : list) {
			if(f.isFile()) {
				
				
				
			}
			
			}
		
		}

	
	
	private static void m5() {
		String path1 = "D:\\파일_디렉토리_문제\\동일 파일\\Music_1";
		String path2 = "D:\\파일_디렉토리_문제\\동일 파일\\Music_2";
		
		File music1 = new File(path1);
		File music2 = new File(path2);
		
		
		if(music1.exists() && music2.exists()) {
		
		String[] m1Name = music1.list();
		String[] m2Name = music2.list();
		
		for(String s : m1Name) {
			for(String s2 : m2Name) {
				if(s.equals(s2)) {
					System.out.println(s2);
				}
			}
		}
		
		}
		
	}

	private static void m3() {
		
		String path = "D:\\파일_디렉토리_문제\\폴더 삭제";
		File dir = new File(path);
		
		
		int fCount =0;
		int dCount =0;
		
		System.out.printf("파일 %d개, 폴더 %d개 가 삭제되었습니다.", getDelFile(dir,fCount),getDelDir(dir,dCount));
		

		}


	public static int getDelFile(File dir, int fCount) {
		if(dir.exists()) {
		
			
			
			
			File[] list = dir.listFiles();
			
			for(File n : list) {
				
				if(n.isFile()) {
					fCount += 1;
					n.delete();
				}	
				
			}
			for(File n2 : list) {
				if(n2.isDirectory()) {
					
				fCount = getDelFile(n2,fCount);
					
					
				}
				}
			}
			
		
		
		return fCount;
	}
	
	public static int getDelDir(File dir, int dCount) {
		
		if(dir.exists()) {
			
			File[] list = dir.listFiles();
			
			for(File n : list) {
				if(n==null) {
					n.delete();
					dCount+=1;
				}
				
			}
			
			for(File n2 : list) {
				if(n2.isDirectory()) {
					dCount = getDelDir(n2,dCount);
				}
				
				
			}
			
			
			
			
		
			
		}
		
		
		return dCount;
	}
	

//	private static void m1_1() {
//
//		String path = "D:\\파일_디렉토리_문제\\음악 파일\\Music";
//		File fi = new File(path);
//		
//		
//		
//		int count = 0;
//		
//		if(fi.exists()) {
//			File[] list = fi.listFiles();
//				
//			for(File n : list ) {
//				count ++;
//				
//				String num = "";
//				
//				String newName = list[count];
//					
//					if(count<10) {
//						num = "[00" + count + "]";
//					}else if(count<100) {
//						num = "[0" + count + "]";
//					}else {
//						num = "["+ count +"]";
//					}
//				
//				list[count].renameTo(num+list[count]);
//				
//		
//				
//				
//			
//				
//				
//				
				
				
//			}
//		}
		
		
		
//	}

	public static void m1() {
		
		String path = "D:\\파일_디렉토리_문제\\음악 파일\\Music";
		
		File f = new File(path);
	
		
		File[] files = f.listFiles();
		int index = 0;
		
		for(File c : files) {
			index+=1;
		}
		
		
		
					
		for(int i=0; i<index; i++) {
		
			String num = count(i);
			String[] newName = new String[index] ;
			
			newName[i] = String.format("%s%s",num,files[i].getName());
			
			String path2 = path + "\\" + newName[i];
			File file = new File(path2);
			
			files[i].renameTo(file);
			
//			File dest = new File(path + "\\"+ files[i]);
//					
//			String num = count(i);
//			String[] newName = new String[100] ;
//			newName[i] = String.format("%s%s",num,files[i]);
//			
//			String path2 = path + "\\" + newName[i];
//			File file = new File(path2);
//			
//			dest.renameTo(file);
			
			
			
		}
			
			
			
		}
	

	public static String count(int i) {
		
		String num = "";
		
		int j = i+1;
			
			if(j<10) {
				num = "[00" + j + "]";
			}else if(j<100) {
				num = "[0" + j + "]";
			}else {
				num = "["+j+"]";
			}
		
		return num;
		
	
	}
	
	
	
	
	
	
	
	
	
	
}//class




