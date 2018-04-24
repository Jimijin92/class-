package com.test.question;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;
import java.util.Stack;

import com.test.collection.Member;

public class MakingConsoleMemo {

	private static Scanner scan;
	
	static {
		scan = new Scanner(System.in);
	}
	
	
	public static void main (String[] args) {
		
	
       
		
		boolean loop = true;
		Scanner scan = new Scanner(System.in);
		
		
		while(loop) {
			
			//메뉴 > 선택 > 해당 업무 실행 > 메뉴 > 선택..
			
			System.out.println("심플콘솔메모장");
			System.out.println("1. 쓰기");
			System.out.println("2. 읽기");
			System.out.println("3. 종료");
	
			System.out.println("=========================");
			System.out.print("선택(번호입력) : ");
			
			String sel = scan.nextLine();
			
			if (sel.equals("1")) {
				writting();
			} else if (sel.equals("2")) {
				reading();
			} else if (sel.equals("3")) {
				loop = false;
			}//if
				
		}//while
		
		System.out.println("메모장을 종료합니다.");
	
		
	}

	private static String reading() {
		
		try {
			BufferedReader reader = new BufferedReader(new FileReader("D:\\memo.txt"));
			String line = null;
			
			while ((line = reader.readLine()) != null) {
				System.out.println(line);
				return line;
			}
			
		} catch (Exception e) {
			System.out.println("m9 : " + e.toString());
		}
		
		
		
		pause();
	}//reading

	
	
	
	
	
	
	private static void writting() {
		
		Scanner scan = new Scanner(System.in);
		
		boolean loop = true;
		
		
		//이름 받기
		System.out.print("이름 : ");
		String name = scan.nextLine();
		
		//날짜 계산하기

		Calendar cal = Calendar.getInstance ();
		String date = String.format("%tF %tT", cal, cal);
		
		System.out.print("날짜 : ");
		System.out.println(date);
		
		//메모 내용 받기
		String body = scan.nextLine();
		
        pause();
		

		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter("D:\\memo.txt",true));
			
			reading();
			
			writer.write("이름 : " + name);
			writer.newLine();
			
			writer.write("날짜 : " + date);
			writer.newLine();
			
			writer.write(body);
			writer.newLine();
			writer.write("=========================");
			writer.newLine();
			
			writer.close();
			
		} catch (Exception e) {
			System.out.println("m1 : " + e.toString());
		}
		
		
		
		
		
	}//writting
	
	private static void pause() {
		System.out.println("계속하시려면 엔터를 입력하세요.");
		scan.nextLine();
	}
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
