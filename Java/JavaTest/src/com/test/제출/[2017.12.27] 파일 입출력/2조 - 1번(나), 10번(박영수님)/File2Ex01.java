package com.test.question;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class File2Ex01 {
	
	public static void main(String[] args) {
		
		m1();
		//m10();
		
	}//main
	
	private static void m1() {
		/*문제1.
		리소스] 숫자.dat
		요구사항]아라비안 숫자를 찾아서 한글로 바꾸시오. -> 복사본으로 저장하기 
		조건] 0-> 영, 1-> 일, ..9-> 구
	  	저장할 파일명 : 숫자_변환.dat*/
		
		String path = "D:\\파일_입출력_문제\\숫자.dat";
		String pathNew = "D:\\파일_입출력_문제\\숫자_변환.dat";
		
		try {	
			String line = "";
			String temp = "";//기존의 내용 옮겨놓기
			
			BufferedReader reader 
				= new BufferedReader(new FileReader(path));
																
			while((line = reader.readLine()) != null) {
				line = line.replaceAll("0", "영");
				line = line.replaceAll("1", "일");
				line = line.replaceAll("2", "이");
				line = line.replaceAll("3", "삼");
				line = line.replaceAll("4", "사");
				line = line.replaceAll("5", "오");
				line = line.replaceAll("6", "육");
				line = line.replaceAll("7", "칠");
				line = line.replaceAll("8", "팔");
				line = line.replaceAll("9", "구");
					
				temp = temp + line + "\r\n";
				System.out.println(line);
			}
			
	        reader.close();
			
	        BufferedWriter writer
				= new BufferedWriter(new FileWriter(pathNew));
			
			writer.write(temp);	//수정된 데이터
			writer.close();
		
		} catch (Exception e) {
			System.out.println("m1 : " + e.toString());
		}
		
	}//m1
	
	
	

	
	
	
	

	private static void m2() {
		/*문제10.
		리소스] 출결.dat
		요구사항] 각 직원별로 지각 횟수, 조퇴횟수를 카운트하시오.
		조건]  출근 : 정각 9시
			   퇴근 : 정각 6시
		결과]  총카운트
		추가]  날짜별 카운트*/	   

		String path = "D:\\파일_입출력_문제\\출결.dat";
		
		
		
		
	}//m10
}//File2Ex01
































