package temp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class Num3_1226 {

	private static String temp;
	
	private static final String PATH = "D:\\파일_입출력_문제\\";
	
	
	static {
		
		temp = "";
		
	}
	public static void main(String[] args) {

		// 문제3. 문제1과 동일 v
		// 리소스] 이름수정.dat
		// 요구사항] '유재석'을 '메뚜기'로 수정하시오
		// 조건] 이름수정_변환.dat
		
		//m7();
		
		
		
		read(); //파일을 읽어오는 메소드
		write(); //파일을 저장하는 메소드


	}// main

	

	private static void write() {

		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(PATH+"이름수정_변환.dat"));
			writer.write(temp);
			writer.close();
			System.out.println("파일 저장 완료");
			
			
			
			
		} catch (Exception e) {
			System.out.println("write: " + e.toString());
		}
		
		
		
		
	}//write
	private static void read() {

		try {
			
			BufferedReader reader = new BufferedReader(new FileReader(PATH+"이름수정.dat"));
			String line = "";
			
			while ((line = reader.readLine()) != null) {
				line = line.replace("유재석", "메뚜기");
				temp = temp + line +"\r\n"; // 결과값을 정적변수에 저장
			}
			reader.close();
			System.out.println("변환 완료");
			
			
			
			
			
		} catch (Exception e) {
			System.out.println("read: " + e.toString());
		}
		
		
		
		
	}//read


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
/*
	private static void m7() {

		try {

			BufferedReader reader = new BufferedReader(new FileReader(PATH+"이름수정.dat"));
			BufferedWriter writer = new BufferedWriter(new FileWriter(PATH+"이름수정_변환.dat",true));
			String line = "";

			while ((line = reader.readLine()) != null) {
				line = line.replace("유재석", "메뚜기");
				writer.write(line);
				writer.newLine();
			}

			writer.close(); 
			reader.close();
			System.out.println("변환 완료.");

		} catch (Exception e) {
			System.out.println("m7: " + e.toString());
		}

	}
	
*/

}// class
