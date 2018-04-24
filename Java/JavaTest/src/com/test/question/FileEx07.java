package com.test.question;

import java.io.File;

public class FileEx07 {

	public static void main(String[] args) {
		
		//직원명_년도_일련번호.txt
		//아무개_2014__32.txt
		
		String path = "D:\\파일_디렉토리_문제\\직원";
		
		File dir = new File(path);
		
		
		File[] files = dir.listFiles();//파일 목록
		
		for(File file : files) {
			if(file.isFile()) {
				
				//아무개_2014_32.TXT
				int index = file.getName().indexOf("_");
				
				String name = file.getName().substring(0, index);
				System.out.println(name);
				
				String temp = file.getName().replaceAll("__", "_");
				
				String year = temp.substring(index+1, temp.lastIndexOf("_"));
				
				//이름으로 폴더 생성하기 
				File nameDir = new File(path + "\\" + name);
				if(!nameDir.exists()) nameDir.mkdir();
				
				//이름>년도로 폴더 생성하기 
				File yearDir = new File(path + "\\" + name + "\\" + year);
				
				if(!yearDir.exists()) yearDir.mkdir();
				
				//파일 이름>년도 폴더로 이동하기 
				File move = new File(path + "\\" + name + "\\" + year + "\\" + file.getName());
				file.renameTo(move);
			}
		}
		
	}
	
}
