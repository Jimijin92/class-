package com.test.question;

import java.io.File;

public class FileEx04 {

	public static void main(String[] args) {
		
		String path = "D:\\파일_디렉토리_문제\\파일 제거";
		File dir = new File(path);
		File[] files = dir.listFiles();
		
		for(File file : files) {
			if(file.isFile()) {
				if(file.length() == 0) {
					file.delete();//사이즈 0 바이트 파일 제거
				}
			}
		}
		System.out.println("삭제 완료");
		
	}
	
}
