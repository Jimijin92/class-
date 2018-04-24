package com.test.collection;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Ex70_Collection {

	
	private static Scanner scan;// = new Scanner(System.in);
	private static ArrayList<Member> list; //회원 정보 집합(*********)

	
	static {
		scan = new Scanner(System.in);
		list = new ArrayList<Member>();
	}
	
	public static void main(String[] args) {
		
	
	//1. 회원정보
	//	- 이름
	//	- 나이
	//	- 주소
	//	- 연락처
	
	
	
	//2. 기능
	//	- 회원 정보 추가
	//	- 회원 정보 보기
	//	- 회원 정보 검색
	//	- 회원 정보 삭제
	
	
	//3. 추가
	//	- 회원 정보 -> 어떤 형태로 ? -> 클래스(o) vs HashMap
	//	- 회원들 -> 회원 정보의 집합 ? -> 배열(학생 수 고정일 때) vs ArrayList(o) vs HashMap
	
	//4. 골격 -> (메뉴 -> 선택 -> 기능 실행 -> 완료) X N 
	
//	Member m = new Member("홍길동", "20", "서울시 강남구 역삼동", "010-1111-2222");
//	
//	//m : 회원 1명
//	
//	System.out.println(m.getName());
//	System.out.println(m.getAdress());
//	System.out.println(m.getAge());
//	System.out.println(m.getTel());
//	
//	System.out.println(m);
	
		dummy();
		
		
		System.out.println("프로그램을 시작합니다.");
		
		boolean loop = true;
		
		Scanner scan = new Scanner(System.in);
		
		
		while(loop) {
			
			//메뉴 > 선택 > 해당 업무 실행 > 메뉴 > 선택..
			System.out.println("=========================");
			System.out.println("회원 정보 관리");
			System.out.println("1. 회원 추가");
			System.out.println("2. 회원 목록");
			System.out.println("3. 회원 검색");
			System.out.println("4. 회원 삭제");
			System.out.println("5. 종료");
			
			System.out.println("6. 회원 검색(나이)");//10대, 20대, 30대, 40대, 50대(번호를 선택하던 숫자를 입력받던...)
			System.out.println("7. 회원 검색(주소)");
			System.out.println("8. 회원 검색(연락처)");
			System.out.println("=========================");
			System.out.print("선택(번호입력) : ");
			
			
			String sel = scan.nextLine();
			
			if (sel.equals("1")) {
				addMember();
			} else if (sel.equals("2")) {
				listMember();
			} else if (sel.equals("3")) {
				searchMember();
			} else if (sel.equals("4")) {
				deleteMember();
			} else if (sel.equals("5"))	{
				loop = false;
			} else if (sel.equals("6")) {
				searchMemberAge();
			} else if (sel.equals("7")) {
				searchMemberAddress();
			} else if (sel.equals("8")) {
				searchMemberTel();
			}//if
				
		}//while
		
		System.out.println("프로그램을 종료합니다.");
	
	
	}//main

	private static void searchMemberTel() {
		// TODO Auto-generated method stub
		
	}

	private static void searchMemberAddress() {
		// TODO Auto-generated method stub
		
	}

	private static void searchMemberAge() {
		//기존 검색 회원들을 저장하기 위한 자리
		ArrayList<Member> temp = new ArrayList<Member>();
		
		//검색 대상? 이름
		System.out.print("검색어(나이) : ");
		String search = scan.nextLine();	
		for (Member m : list) {
			
			//1. 동등 검색 : 정확도 높음, 검색률 낮음
			//2. 포함 검색 : 정확도 낮음, 검색률 높음 
			//if (m.getName().equals(search)) {	
			//if(m.getName().indexOf(search) > -1) {
			
			if(m.getName().contains(search)) {
			
				//발견 -> 출력
				//System.out.println("이름 : " + m.getName());
				//System.out.println("나이 : " + m.getAge());
				//System.out.println("연락처 : " + m.getTel());
				//System.out.println("주소 : " + m.getAddress());
				//System.out.println();
	
				//이곳에 검색된 회원들을 따로 저장할 집합?
				temp.add(m); //이동이 아니라 복사의 개념
				
			}//if
			
		}//for
		
		//출력
		if (temp.size() > 0) {
			
			System.out.printf("총 %d명의 회원이 검색되었습니다.", temp.size());
			
			for (Member m : temp) {//검색된 애들의 집합
				System.out.println("이름 : " + m.getName());
				System.out.println("나이 : " + m.getAge());
				System.out.println("연락처 : " + m.getTel());
				System.out.println("주소 : " + m.getAddress());
				System.out.println();
				
			}
			
		} else {
			System.out.println("검색된 회원이 없습니다.");
		}
		
		pause();
		
	}

	private static void dummy() {
		//테스트용 데이터
		String[] name1 = {"김", "이", "박", "최", "동", "근", "채", "은", "창", "형", "대", "건", "준", "필", "미", "진"};
		String[] address1 = {"서울시", "부산시", "인천시", "대전시", "광주시"};
		String[] address2 = {"강동구", "강남구", "강서구", "강북구", "중구"};
		
		
		Random rnd = new Random();
		
		for (int i=0; i<10; i++) {
			String name = name1[rnd.nextInt(name1.length)] 
							+ name1[rnd.nextInt(name1.length)] 
						    + name1[rnd.nextInt(name1.length)];
			
			String age = rnd.nextInt(40) + 20 + "";
			String address = 
					address1[rnd.nextInt(address1.length)]
				  + " "
				  + address2[rnd.nextInt(address1.length)];			
			
			String tel = "010-" 
			             + (rnd.nextInt(9000) + 1000)
			             + "-"
			             + (rnd.nextInt(9000) + 1000);
			
			
			Member m = new Member(name, age, address, tel);
			
			list.add(m);
		}
		
	}

	private static void deleteMember() {
		
		//회원 정보 삭제
		System.out.println("[회원 삭제]");
		
	    //목록 출력
		list();
		
		System.out.print("삭제할 회원(이름) : ");
		String name = scan.nextLine();
		
		//검색
		for (int i=0; i<list.size(); i++) {
			Member m = list.get(i);
			//동명이인이 없다는 전제하에
			
			if(m.getName().equals(name)) {
				list.remove(i);
				break;
			}
		}
		
		for (Member m : list) {
			if (m.getName().equals(name)) {
				list.remove(m);
				break;
			}
		}
		
		//list.remove(m);
		
		pause();
		
	}

	private static void searchMember() {
		
		//검색된 회원들만 임시저장하기 위한 공간
		ArrayList<Member> temp = new ArrayList<Member>();
		
		
		//검색 대상? 이름
		System.out.print("검색어(이름) : ");
		String search = scan.nextLine();	
		for (Member m : list) {
			
			//1. 동등 검색 : 정확도 높음, 검색률 낮음
			//2. 포함 검색 : 정확도 낮음, 검색률 높음 
			//if (m.getName().equals(search)) {	
			//if(m.getName().indexOf(search) > -1) {
			
			if(m.getName().contains(search)) {
			
				//발견 -> 출력
				//System.out.println("이름 : " + m.getName());
				//System.out.println("나이 : " + m.getAge());
				//System.out.println("연락처 : " + m.getTel());
				//System.out.println("주소 : " + m.getAddress());
				//System.out.println();

				//이곳에 검색된 회원들을 따로 저장할 집합?
				temp.add(m); //이동이 아니라 복사의 개념
				
			}//if
			
		}//for
		
		//출력
		if (temp.size() > 0) {
			
			System.out.printf("총 %d명의 회원이 검색되었습니다.", temp.size());
			
			for (Member m : temp) {//검색된 애들의 집합
				System.out.println("이름 : " + m.getName());
				System.out.println("나이 : " + m.getAge());
				System.out.println("연락처 : " + m.getTel());
				System.out.println("주소 : " + m.getAddress());
				System.out.println();
				
			}
			
		} else {
			System.out.println("검색된 회원이 없습니다.");
		}
		
		pause();
		
		
	}

	private static void listMember() {
		// 회원 정보 목록 출력하기
		System.out.println("[회원 목록]");
		
		list();
		
		pause();
		
		//기운 글씨는 static
	}

	private static void list() {
		//테이블 헤더 출력
		System.out.println("[이름]\t[나이]\t[연락처]\t[주소]");
		
		//list -> Member -> 출력
		for(Member m : list) {
			
			System.out.printf("%s\t%6s\t%s\t%s\n"
										, m.getName()
										, m.getAge()
										, m.getTel()
										, m.getAddress());
			
		}//for
	}

	private static void addMember() {
		
		//미리 초기화 해 놓는게 좋은 코딩!
		String name = "";
		String age = "";
		String address = "";
		String tel = "";
		
		//회원 정보 추가 
		System.out.println("[회원 정보 추가]");
		
		System.out.print("이름 : ");
		name = scan.nextLine();
		
		System.out.print("나이 : ");
		age = scan.nextLine();
		
		System.out.print("주소 : ");
		address = scan.nextLine();
		
		System.out.print("연락처 : ");
		tel = scan.nextLine();
		
		//회원 정보 수집 > 회원 정보 1개 단위 > Member 객체
		Member m = new Member(name, age, address, tel);
		
		//회원 정보 > 리스트 추가
		list.add(m);
		
		pause();
		
	}

	private static void pause() {
		System.out.println("계속하시려면 엔터를 입력하세요.");
		scan.nextLine();
	}
	
	

	
	
	
	
	
	
	
}//Ex70
