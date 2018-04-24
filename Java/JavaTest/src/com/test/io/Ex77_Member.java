package com.test.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Ex77_Member {

	
	
	private static Scanner scan; // 모든 메소드에서 사용
	private static final String FILEPATH = "member.dat"; //변수로 설정하는게 주소 길어질 경우 편리하다. 
	private static ArrayList<Member> list;
	
	
	static {
		scan = new Scanner(System.in);
		list = new ArrayList<Member>();//Ex70 예제
		
	}
	
	public static void main(String[] args) {
		
		//Ex77_Member.java
		
		//Member의 단점
		//1. 파일 입출력이 너무 잦음. > 고비용
		//2. 스트림은 사용하기가 불편
		
		//회원 정보 관리 프로그램
		//	: 컬렉션 + 파일 입출력
		
		//추가, 목록, 삭제
		
		load();
		
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
		
		save();
		
	}//main		
		
		
	private static void save() {
		//메모리 -> member.dat 옮기기
		
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(FILEPATH));
			//ArrayList -> Member 1개 -> member.dat -> 1줄
			for(Member m : list) {
				String line = String.format("%s,%s,%s,%s"
										, m.getName()
										, m.getAge()
										, m.getAddress()
										, m.getTel());
				writer.write(line); //메모리 -> 텍스트파일 복사
				writer.newLine();
			}
			
			writer.close();
			
		} catch (Exception e) {
			System.out.println("save : " + e.toString());
		}
		
		
	}


	private static void load() {
		//member.dat ->메모리 옮기기
		
		try {
			BufferedReader reader = new BufferedReader(new FileReader(FILEPATH));
			
			String line = "";
			
			while((line = reader.readLine()) != null) {
				//텍스트 1줄 = 1명 회원 = Member 객체 1개 
				String[] temp = line.split(",");
				
				Member m = new Member();
				m.setName(temp[0]);
				m.setAge(temp[1]);
				m.setAddress(temp[2]);
				m.setTel(temp[3]);
				
				list.add(m);
			}	
				
			reader.close();
			
		} catch (Exception e) {
			System.out.println("load : " + e.toString());
		}
		
	}//load

	//main

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
		
		//파일 쓰기 -> Member 객체를 ArrayList에 추가하기
		Member m = new Member();
		m.setName(name);
		m.setAge(age);
		m.setAddress(address);
		m.setTel(tel);
		
		list.add(m);//★★★★★★★★회원 목록에 새회원 추가하기
		//★★★★★★★★    list.add(m); 이 작업 함으로서 밑에 try catch 삭제해도 됨!
		
		
		/*try {
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
		}*/
		
		
	}

	private static void listMember() {
		System.out.println("[회원 목록]");
		
		for (Member m : list) {
			System.out.println("이름 : " + m.getName());
			System.out.println("나이 : " + m.getAge());
			System.out.println("주소 : " + m.getAddress());
			System.out.println("전화 : " + m.getTel());
		}
		
		//윗 작업으로 아래작업 생략가능
		/*try {
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
		}*/
		
	}

	private static void deldteMember() {
		
		//파일 입출력 > 스트림은 수정&삭제 작업이 존재하지 않는다!
		//              > 새로생성 + 데이터 추가 & 데이터 읽기 (덮어쓰기 사용해서 수정, 삭제처럼 보이는 것)
		
		//회원 삭제
		System.out.println("[회원 삭제]");

		System.out.println("이름 : ");
		String name = scan.nextLine();
		
		
		for (Member m : list) {
			if(m.getName().equals(name)) {
				list.remove(m);
			}
		}
		
		
		
		
		
		/*try {
			BufferedReader reader = new BufferedReader(new FileReader(FILEPATH));
			String temp = ""; //이곳에 기존의 내용을 옮겨놓기

			String line = "";

			while((line = reader.readLine()) != null) {
				if(삭제하려는 회원만 빼고line.startsWith(name)) {
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
*/
		
	}
	
}//Ex77









	

