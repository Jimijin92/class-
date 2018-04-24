package com.test.question;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

public class FileDirQuestion {
	
	public static void main(String[] args) {
		
		
		
//		fileNum();
//		extCount();
		
//		String path = "E:\\파일_디렉토리_문제\\폴더 삭제";
//		
//		q3(path);
		
//		q4();
		
//		q5();
		
		q6();
		
		
		
	}
	
	private static void q6() {
		
		String path = "D:\\파일_디렉토리_문제\\크기 정렬";		
		
		File dir = new File(path);
		ArrayList<File> fileList = new ArrayList<File>();
				
		insertFile(dir, fileList);
		
		arrayListSort(fileList);
		
		System.out.printf("%-25s\t%s\t\t\t%s\n", "[크기]", "[용량]", "[경로]");
		
		for(File files : fileList) {
			
			String extName = getFolderPath(files);
			
			String size = sizeConvert(files);
			
			System.out.printf("%-25s\t%s\t\t\t %s\n"
									, files.getName()
									, size
									, extName);
		}
		
	}//q6();

	private static String sizeConvert(File files) {
		
		double kb = files.length()/1024;
		double mb = kb/1024;
		String size = "";
		
		if(kb >= 1 && kb < 1024) {
			size = kb + "KB";
		} else if (kb >= 1 && mb >= 1) {
			size = String.format("%.2fMB", mb);
		} else {
			size = files.length() + "B";
		}
		return size;
		
	}//sizeConvert(File files);

	private static String getFolderPath(File files) {
		
		String fileName = files.getPath();
		String temp = fileName.substring(0, fileName.lastIndexOf("\\"));
		String extName = temp.substring(temp.lastIndexOf("\\")+1);
		return extName;
		
	}//getFolderPath(File files);

	private static void arrayListSort(ArrayList<File> fileList) {
		for(int i=0 ; i<fileList.size()-1 ; i++) {
			for(int j=i+1 ; j<fileList.size() ; j++) {
				
				File temp;
				if(fileList.get(i).length() < fileList.get(j).length()) {
					temp = fileList.get(i);
					fileList.set(i, fileList.get(j));
					fileList.set(j, temp);
				}				
				
			}//for		
		}//for
	}//arrayListSort();

	private static void insertFile(File dir, ArrayList<File> fileList) {
		
		if(dir.exists()) {
			File[] list = dir.listFiles();
						
			for(File file : list) {
				if(file.isFile()) {
					fileList.add(file);
				} else if(file.isDirectory()) {
					insertFile(file, fileList);
				}
			}
			
		} //if;
	} //insetFile();

	private static void q5() {
		
		String path1 = "E:\\파일_디렉토리_문제\\동일 파일\\Music_1";
		String path2 = "E:\\파일_디렉토리_문제\\동일 파일\\Music_2";
		
		File file1 = new File(path1);
		File file2 = new File(path2);
		
		System.out.println(file1.getName());
		
		if(file1.exists() && file2.exists()) {
			File[] list1 = file1.listFiles();
			File[] list2 = file2.listFiles();
			
			for(int i=0 ; i<list1.length ; i++) {
				
				for(int j=0 ; j<list2.length ; j++) {
					
					if(list1[i] == list2[j]) {
						System.out.println(list1[i].getName());
						
					}
				}
			}
			
		}		
		
	}//q5();

	private static void q4() {
		
		String path = "E:\\파일_디렉토리_문제\\파일 제거";
		
		File file = new File(path);
		
		File[] list = file.listFiles();
		
		for(File files : list) {
			if(files.length() == 0) {
				files.delete();
			}
		}
		
	}

	private static void q3(String path) {
		
		File file = new File(path);
		if(file.exists()) {
			File[] subList = file.listFiles();
			for(File subFile : subList) {
				if(subFile.isDirectory()) {
					q3(subFile.getPath());
				} else {
					subFile.delete();
				}
			}
			file.delete();
		}
		if(file.exists()) {
			file.delete();
		}
		
		
		
		
	} //q3();

	public static void extCount() {
		
		String path = "D:\\파일_디렉토리_문제\\확장자별 카운트";
		
		File dir = new File(path);
		
		File[] list = dir.listFiles();
		
		HashMap<String, Integer> extList = new HashMap<String, Integer>();
		
		for(int i=0 ; i<list.length ; i++) {
			String fileName = list[i].getName();
			
			int extIndex = fileName.lastIndexOf('.');
			
			String ext = fileName.substring(extIndex);
			
			extList.put(ext, 1);
			
		}
		
		for(int i=0 ; i<extList.size() ; i++) {
			
		}
		
		
		
		
	}//extCount();
	
	
	public static void fileNum() {
		
		String path = "D:\\파일_디렉토리_문제\\음악 파일\\Music";
		
		File file = new File(path);
		
		File[] list = file.listFiles();
		
		for(int i=0 ; i<list.length ; i++) {
			String num = numbering(i+1);
			
			String destPath = String.format("%s\\[%s]%s", path, num, list[i].getName());
			
			File destFile = new File(destPath);
			
			list[i].renameTo(destFile);
		}
		
		
	}//fileNum();
	
	
	
	public static String numbering(int n) {
			
			String number = "";
			
			if(n >= 1 && n <= 9) {
				for(int i=1 ; i<10; i++) {
					number = "00"+n;
				}
			} else if(n >=10 && n <= 99) {
				for(int i=10 ; i<=99; i++) {
					number = "0"+n;
				}
			} else {
				number = n+"";
			}
			
			return number;
		}

}//Class FileDirQuestion
