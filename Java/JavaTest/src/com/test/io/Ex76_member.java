package com.test.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.Buffer;
import java.util.Scanner;

import javax.naming.NamingEnumeration;

public class Ex76_member {

	private static Scanner scan; // 모든 메소드에서 사용
	private static final String FILEPATH = "member.dat"; //변수로 설정하는게 주소 길어질 경우 편리하다. 
	
	static {
		scan = new Scanner(System.in);
		
	}
	
	public static void main(String[] args) {
		
//		try {
//			//드라이브명으로 시작 경로 : 절대 경로
//			//.으로 시작 경로 : 상대 경로(나를 중심으로 표현)
//			//	- . : 현재 프로그램이 실행 중인 디렉토리
//			BufferedWriter writer = new BufferedWriter(new FileWriter("member.dat", true));//절대 경로, 앞에 .\\생략 돼있음, 배포에 유리 앞에경로 무시하고..
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		
		
		//Ex76_Member.java
		
		//회원 정보 관리 프로그램
		//	: 컬렉션 + 파일입출력
		
		//추가, 목록, 삭제 
		
		boolean loop = true;
		while(loop) {
			System.out.println("=============================");
			System.out.println("회원 정보 관리");
			System.out.println("=============================");
			System.out.println("1. 회원 추가");
			System.out.println("2. 회원 목록");
			System.out.println("3. 회원 삭제");
			System.out.println("4. 종료");
			System.out.println("선택 : ");

			String sel = scan.nextLine();
			
			if(sel.equals("1")) addMember();
			else if (sel.equals("2")) listMember();
			else if (sel.equals("3")) deldteMember();
			else loop = false; //메뉴 탈출
			
		}//while
		System.out.println("프로그램 종료");
		
		
		
	}//main

	private static void addMember() {
		
		System.out.println("[회원추가]");
		
		String name = "";
		String age = "";
		String address = "";
		String tel = "";
		
		System.out.print("이름 : ");
		name = scan.nextLine();
		
		System.out.print("나이 : ");
		age = scan.nextLine();
		
		System.out.print("주소 : ");
		address = scan.nextLine();

		System.out.print("전화 : ");
		tel = scan.nextLine();
		
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(FILEPATH, true));
			//파일 기록
			// - 1명 = 1줄
			//홍길동,20,서울시,010-1111-1111 //, 20, 서울시, 010-1111-1111이런식으로 사이에 쓸데없는 공백 넣지 말기 
			
			writer.write(String.format("%s,%s,%s,%s"
										, name, age, address, tel));
			writer.newLine();
		
			writer.close();
			
			System.err.println("회원 추가 완료");
			
		} catch (Exception e) {
			System.out.println("main : " + e.toString());
		}
		
		
	}

	private static void listMember() {
		System.out.println("[회원 목록]");
		
		try {
			BufferedReader reader = new BufferedReader(new FileReader(FILEPATH));
			
			String line = "";
			while((line = reader.readLine()) != null) {
				//System.out.println(line);
				//홍길동,20,서울시 강남구,010-2222-4444
				
				String[] result = line.split(",");//반환값이 스트링 배열
				
				//System.out.println(result.length);
				System.out.println("이름 : " + result[0]);
				System.out.println("나이 : " + result[1]);
				System.out.println("주소 : " + result[2]);
				System.out.println("전화 : " + result[3]);
				System.out.println();
			}
			
			
			reader.close();
			System.out.println("회원 목록 출력 완료");
			
		} catch (Exception e) {
			System.out.println("listMember : " + e.toString());
		}
		
	}

	private static void deldteMember() {
		
		//파일 입출력 > 스트림은 수정&삭제 작업이 존재하지 않는다!
		//              > 새로생성 + 데이터 추가 & 데이터 읽기 (덮어쓰기 사용해서 수정, 삭제처럼 보이는 것)
		
		//회원 삭제
		System.out.println("[회원 삭제]");

		System.out.println("이름 : ");
		String name = scan.nextLine();
		
		try {
			BufferedReader reader = new BufferedReader(new FileReader(FILEPATH));
			String temp = ""; //이곳에 기존의 내용을 옮겨놓기

			String line = "";

			while((line = reader.readLine()) != null) {
				if(/*삭제하려는 회원만 빼고*/line.startsWith(name)) {
					temp += line + "\r\n";
					
				}//if	
			}//while
			
			//System.out.println(temp);
			reader.close();
			
			BufferedWriter writer= new BufferedWriter(new FileWriter(FILEPATH));
			
			writer.write(temp);//삭제할 회원만 빠진 나머지 회원 정보들
			
			writer.close();
			System.out.println("회원 정보 삭제");
			
			
		} catch (Exception e) {
			System.out.println("deldteMember : " + e.toString());
		}

		
	}
	
}//Ex76






















