package com.student;

import java.util.ArrayList;
import java.util.Scanner;

import com.common.Student;
import com.common.Teacher;
import com.io.ComInStudent;
import com.io.ComInTeacher;

public class ComStudentSearchT {
	
	private static Scanner scan;
	public static ComStudentSearchTemp temp;
	private static ComInTeacher list;
	private static ArrayList<Student> student;
	//private static Student loggedIn;
	
	private static ComInStudent c;
	static {
		student = new ArrayList<Student>();
		scan = new Scanner(System.in);
		temp = new ComStudentSearchTemp();
		list = new ComInTeacher();
		c.load();
		student = ComInStudent.getStudentlist();
		//loggedIn = student.get(3);
	}
	
	
	//선생님찾기!
	//조건선택(누적)해서 7번 완료 누르면 조건에 맞는 선생님 출력
	

	public static void searchT() {
			
			boolean loop = true;
			ComStudentMenu back = new ComStudentMenu();
			ComStudentSearchList filteredList = new ComStudentSearchList();
			
		
		
			
			while(loop) {
				
				System.out.println("==========================================");
				System.out.println("  	     선생님 찾기");
				System.out.println("(미 입력시 회원가입 기본정보로 설정됩니다)");
				System.out.println("==========================================");
			
				System.out.print("1.지역\t\t");
				System.out.print("4.학력\t\t");
				System.out.println("6.희망과외비");
				
				System.out.print("2.성별\t\t");
				System.out.print("5.과외경력\t");
				System.out.println("7.완료");
				
				//System.out.print("3.특기사항\t");
				System.out.print("3.과목\t\t");
				System.out.println("0.메인으로");
				System.out.print("입력 : ");
				
				String input = scan.nextLine(); 
				
				if(input.equals("1")) {
					region();
					
				}else if(input.equals("2")) {
					gender();
					
				}
//				else if(input.equals("3")) {
//					special();
//				}
				else if(input.equals("4")) {
					school();
				}else if(input.equals("5")) {
					career();
				}else if(input.equals("3")) {
					subject();
				}else if(input.equals("6")) {
					price();
				}else if(input.equals("7")) {
					loop = false;
					System.out.println();
					filteredList.filteredList();
					
					//filterCheck();
					
					
				}else if(input.equals("0")){
					loop = false;
				}else {
					System.out.println("정확히 입력해 주세요");
				}
				
			}//while
			
		}//searchT
	

	private static void region() { //지역 선택(대분류)

		
		
		boolean loop = true;
		while(loop) {
		
			System.out.println("===================================");
			System.out.println("●대분류●");
			System.out.println();
			System.out.println("1.서울특별시");
			System.out.println("2.경기도 남부");
			System.out.println("3.경기도 북부");
			System.out.println("4.인천광역시");
			System.out.println("5.무관");
			System.out.print("입력 : ");
			String input = scan.nextLine();
			
			if(input.equals("1")) {
				temp.setAddress("서울시");
				loop = false;
				seoul();
				
				
			}else if(input.equals("2")) {
				temp.setAddress("경기도");
				loop = false;
				ggdSouth();
				
				
			}else if(input.equals("3")) {
				temp.setAddress("경기도");
				loop = false;
				ggdNorth();
				

			}else if(input.equals("4")) {
				temp.setAddress("인천광역시");
				loop = false;
				ggdSouth();
				
				
			}else if(input.equals("5")) {
				temp.setAddress("");
				loop = false;
				
			}else {
				System.out.println("정확히 입력해 주세요");
			}
			
			
		}//대분류while
		

	}
	
	private static void seoul() {//지역선택 (서울)
		boolean loop = true;
		
		//while(loop) {
			System.out.println("===================================");
			System.out.println("●구 선택●");
			System.out.print("1.강남구\t");
			System.out.print("6.광진구\t");
			System.out.print("11.동대문구\t");
			System.out.print("16.성동구\t");
			System.out.println("21.용산구\t");
			System.out.print("2.강동구\t");
			System.out.print("7.구로구\t");
			System.out.print("12.동작구\t");
			System.out.print("17.성북구\t");
			System.out.println("22.은평구\t");
			System.out.print("3.강북구\t");
			System.out.print("8.금천구\t");
			System.out.print("13.마포구\t");
			System.out.print("18.송파구\t");
			System.out.println("23.종로구\t");
			System.out.print("4.강서구\t");
			System.out.print("9.노원구\t");
			System.out.print("14.서대문구\t");
			System.out.print("19.양천구\t");
			System.out.println("24.중구\t");
			System.out.print("5.관악구\t");
			System.out.print("10.도봉구\t");
			System.out.print("15.서초구\t");
			System.out.print("20.영등포구\t");
			System.out.println("25.중랑구\t");
			
			String input = scan.nextLine();
			
			
			if(input.equals("1")) {
				temp.setAddress2(" 강남구");
				
				loop = false;
				
				
			}else if(input.equals("2")) {
				temp.setAddress2(" 강동구");
				
				loop = false;
				
			}else if(input.equals("3")) {
				temp.setAddress2(" 강북구");
				
				loop = false;
				
			}else if(input.equals("4")) {
				temp.setAddress2(" 강서구");
				
				loop = false;
				
			}else if(input.equals("5")) {
				temp.setAddress2(" 관악구");
				
				loop = false;
				
			}else if(input.equals("6")) {
				temp.setAddress2(" 광진구");
				
				loop = false;
				
			}else if(input.equals("7")) {
				temp.setAddress2(" 구로구");
			
				loop = false;
				
			}else if(input.equals("8")) {
				temp.setAddress2(" 금천구");
			
				loop = false;
				
			}else if(input.equals("9")) {
				temp.setAddress2(" 노원구");
			
				loop = false;
				
			}else if(input.equals("10")) {
				temp.setAddress2(" 도봉구");
				
				loop = false;
				
			}else if(input.equals("11")) {
				temp.setAddress2(" 동대문구");
			
				loop = false;
				
			}else if(input.equals("12")) {
				temp.setAddress2(" 동작구");
			
				
				loop = false;
				
			}else if(input.equals("13")) {
				temp.setAddress2(" 마포구");
				
				loop = false;
				
			}else if(input.equals("14")) {
				temp.setAddress2(" 서대문구");
				
				loop = false;
				
			}else if(input.equals("15")) {
				temp.setAddress2(" 서초구");
				
				
				loop = false;
				
			}else if(input.equals("16")) {
				temp.setAddress2(" 성동구");
				
				loop = false;
				
			}else if(input.equals("17")) {
				temp.setAddress2(" 성북구");
				
				
				loop = false;
				
			}else if(input.equals("18")) {
				temp.setAddress2(" 송파구");
				
				
				loop = false;
				
			}else if(input.equals("19")) {
				temp.setAddress2(" 양천구");
				
				loop = false;
				
			}else if(input.equals("20")) {
				temp.setAddress2(" 영등포구");
			
				loop = false;
				
			}else if(input.equals("21")) {
				temp.setAddress2(" 용산구");
			
				loop = false;
				
			}else if(input.equals("22")) {
				temp.setAddress2(" 은평구");
			
				loop = false;
				
			}else if(input.equals("23")) {
				temp.setAddress2(" 종로구");
				
				loop = false;
				
			}else if(input.equals("24")) {
				temp.setAddress2(" 중구");
			
				loop = false;
				
			}else if(input.equals("25")) {
				temp.setAddress2(" 중랑구");
				
				loop = false;
				
			}else{
				System.out.println("정확히 입력해 주세요");
			}
			
		//}
	}
	
	private static void ggdSouth() {//GGD(경기도)
		boolean loop = true;
		
		//while(loop) {
			System.out.println("===================================");
			System.out.println("●시/군 선택●");
			System.out.print("1.과천시\t");
			System.out.print("6.성남시\t");
			System.out.print("11.안양시\t");
			System.out.println("16.이천시\t");
			
			System.out.print("2.광명시\t");
			System.out.print("7.수원시\t");
			System.out.print("12.여주시\t");
			System.out.println("17.평택시\t");
			
			System.out.print("3.광주시\t");
			System.out.print("8.시흥시\t");
			System.out.print("13.오산시\t");
			System.out.println("18.하남시\t");
			
			System.out.print("4.군포시\t");
			System.out.print("9.안산시\t");
			System.out.print("14.용인시\t");
			System.out.println("19.화성시\t");
			
			System.out.print("5.부천시\t");
			System.out.print("10.안성시\t");
			System.out.println("15.의왕시\t");
			
			System.out.print("입력 : ");
			String input = scan.nextLine();
			
			
			if(input.equals("1")) {
				temp.setAddress2(" 과천시");
				
				loop = false;
				
			}else if(input.equals("2")) {
				temp.setAddress2(" 광명시");
				
				loop = false;
				
			}else if(input.equals("3")) {
				temp.setAddress2(" 광주시");
			
				loop = false;
				
			}else if(input.equals("4")) {
				temp.setAddress2(" 군포시");
			
				loop = false;
				
			}else if(input.equals("5")) {
				temp.setAddress2(" 부천시");
			
				loop = false;
				
			}else if(input.equals("6")) {
				temp.setAddress2(" 성남시");
			
				loop = false;
				
			}else if(input.equals("7")) {
				temp.setAddress2(" 수원시");
			
				loop = false;
				
			}else if(input.equals("8")) {
				temp.setAddress2(" 시흥시");
			
				loop = false;
				
			}else if(input.equals("9")) {
				temp.setAddress2(" 안산시");
				
				loop = false;
				
			}else if(input.equals("10")) {
				temp.setAddress2(" 안성시");
			
				loop = false;
				
			}else if(input.equals("11")) {
				temp.setAddress2(" 안양시");
				
				loop = false;
				
			}else if(input.equals("12")) {
				temp.setAddress2(" 여주시");
				
				loop = false;
				
			}else if(input.equals("13")) {
				temp.setAddress2(" 오산시");
				
				loop = false;
				
			}else if(input.equals("14")) {
				temp.setAddress2(" 용인시");
			
				loop = false;
				
			}else if(input.equals("15")) {
				temp.setAddress2(" 의왕시");
				
				loop = false;
				
			}else if(input.equals("16")) {
				temp.setAddress2(" 이천시");
	
				loop = false;
				
			}else if(input.equals("17")) {
				temp.setAddress2(" 평택시");
		
				loop = false;
				
			}else if(input.equals("18")) {
				temp.setAddress2(" 하남시");
		
				loop = false;
				
			}else if(input.equals("19")) {
				temp.setAddress2(" 화성시");
	
				loop = false;
				
			}else {
				System.out.println("정확히 입력해 주세요");
			}
		//}//while
	}
	
	private static void ggdNorth() {	//경기도 북부
		
		
		boolean loop = true;
		
		while(loop) {
		
		System.out.println("===================================");
		System.out.println("●시/군 선택●");
		System.out.print("1.고양시\t");
		System.out.print("4.남양주시\t");
		System.out.print("7.파주시\t");
		System.out.println("10.가평군\t");
		
		System.out.print("2.구리시\t");
		System.out.print("5.동두천시\t");
		System.out.print("8.파주시.\t");
		System.out.println("11.양평군\t");
		
		System.out.print("3.김포시\t");
		System.out.print("6.양주시\t");
		System.out.println("9.연천군\t");
		
		System.out.print("입력 : ");
		String input = scan.nextLine();
		
		
		if(input.equals("1")) {
			temp.setAddress2(" 고양시");
		
			loop = false;
			
		}else if(input.equals("2")) {
			temp.setAddress2(" 구리시");
			
			loop = false;
			
		}else if(input.equals("3")) {
			temp.setAddress2(" 김포시");
			
			loop = false;
			
		}else if(input.equals("4")) {
			temp.setAddress2(" 남양주시");
			
			loop = false;
			
		}else if(input.equals("5")) {
			temp.setAddress2(" 동두천시");
			
			loop = false;
			
		}else if(input.equals("6")) {
			temp.setAddress2(" 양주시");
			
			loop = false;
			
		}else if(input.equals("7")) {
			temp.setAddress2(" 파주시");
			
			loop = false;
			
		}else if(input.equals("8")) {
			temp.setAddress2(" 포천시");
			
			loop = false;
			
		}else if(input.equals("9")) {
			temp.setAddress2(" 연천군");
			
			loop = false;
			
		}else if(input.equals("10")) {
			temp.setAddress2(" 가평군");
			
			loop = false;
			
		}else if(input.equals("11")) {
			temp.setAddress2(" 양평군");
		
			loop = false;
			
		}else {
			System.out.println("정확히 입력해 주세요");
		}
		
		
		}//while
	}
	
	
	private static void gender() {//성별선택
		
		boolean loop = true;
		
		while(loop) {
			System.out.println("===================================");
			System.out.println("●원하는 선생님의 성별●");
			System.out.println("1.남\t");
			System.out.println("2.여\t");
			System.out.println("3.무관\t");
			
			
			System.out.print("입력 : ");
			String input = scan.nextLine();
			
			if(input.equals("1")) {
				temp.setGender("남");
				loop = false;
	
			}else if(input.equals("2")) {
				temp.setGender("여");
				loop = false;
			}else if(input.equals("3")) {
				//무관 누르면 그냥 널값으러
				loop = false;
			}else{
				System.out.println("정확히 입력해 주세요");
			}
			
		}//while	
			
		
	}
	
//	private static void special() {//특이사항
//		boolean loop = true;
//		
//
//
//		while(loop) {
//			System.out.println("===================================");
//			System.out.println("●특기사항●");
//			System.out.println("1.해외거주경험\t");
//			System.out.println("2.학원강사경험\t");
//			System.out.println("3.특목고졸업\t");
//			System.out.println("4.대회입상경험\t");
//			System.out.println("5.없음\t");
//			
//			
//			System.out.print("입력 : ");
//			String input = scan.nextLine();
//			
//			if(input.equals("1")) {
//				temp.setSpecial("해외거주경험");
//				loop = false;
//			}else if(input.equals("2")) {
//				temp.setSpecial("학원강사경험");
//				loop = false;
//			}else if(input.equals("3")) {
//				temp.setSpecial("특목고졸업");
//				loop = false;
//			}else if(input.equals("4")) {
//				temp.setSpecial("대외입상경험");
//				loop = false;
//			}else if(input.equals("5")) {
//				temp.setSpecial("없음");
//				loop = false;
//			}else{
//				System.out.println("정확히 입력해 주세요");
//			}
//			
//		}//while	
//		
//	}
	
	private static void school() {//학력(학년)
		
		boolean loop = true;
		


		while(loop) {
			System.out.println("===================================");
			System.out.println("●학력●");
			System.out.println("1.1학년\t");
			System.out.println("2.2학년\t");
			System.out.println("3.3학년\t");
			System.out.println("4.4학년\t");
			System.out.println("5.대졸\t");
			System.out.println("6.석사\t");
			
			System.out.print("입력 : ");
			String input = scan.nextLine();
			
			if(input.equals("1")) {
				temp.setSchool("1학년");
				loop = false;
			}else if(input.equals("2")) {
				temp.setSchool("2학년");
				loop = false;
			}else if(input.equals("3")) {
				temp.setSchool("3학년");
				loop = false;
			}else if(input.equals("4")) {
				temp.setSchool("4학년");
				loop = false;
			}else if(input.equals("5")) {
				temp.setSchool("대졸");
				loop = false;
			}else if(input.equals("6")) {
				temp.setSchool("석사");
				loop = false;
			}else{
				System.out.println("정확히 입력해 주세요");
			}
			
		}//while	
		
	}
	
	private static void career() {//과외경력
		
	boolean loop = true;
		ArrayList<String> tempArray = new ArrayList<String>();


		while(loop) {
			System.out.println("===================================");
			System.out.println("●과외경력●");
			System.out.println("1.1년이하\t");
			System.out.println("2.2년\t");
			System.out.println("3.3년\t");
			System.out.println("4.4년\t");
			System.out.println("5.5년\t");
			System.out.println("6.6년\t");
			System.out.println("7.7년\t");
			System.out.println("8.8년\t");
			System.out.println("9.9년\t");
			System.out.println("10.10년이상\t");
			
			System.out.print("입력 : ");
			
			String input = scan.nextLine();
			
			if(input.equals("1")) {
				temp.setCareer("1년이하");
				
				loop = false;
			}else if(input.equals("2")){
				
				temp.setCareer("2년");
				
				loop = false;;
			}else if(input.equals("3")){
				
				temp.setCareer("3년");
				
				loop = false;;
			}else if(input.equals("4")){
				
				temp.setCareer("4년");
				
				loop = false;;
			}else if(input.equals("5")){
				
				temp.setCareer("5년");
				
				loop = false;;
			}else if(input.equals("6")){
				
				temp.setCareer("6년");
				
				loop = false;;
			}else if(input.equals("7")){
				
				temp.setCareer("7년");
				
				loop = false;;
			}else if(input.equals("8")){
				
				temp.setCareer("8년");
				
				loop = false;;
			}else if(input.equals("9")){
				
				temp.setCareer("9년");
				
				loop = false;;
			}else if(input.equals("10")){
				
				temp.setCareer("10년이상");
				
				loop = false;;
			}else{
				System.out.println("정확히 입력해 주세요");
			}
			
		}//while	
		
		
	}
	
	private static void subject() {//과목
		
		boolean loop = true;
		ArrayList<String> tempArray = new ArrayList<String>();


		while(loop) {
			System.out.println("===================================");
			System.out.println("●수강 희망 과목●");
			System.out.println("1.언어\t");
			System.out.println("2.외국어\t");
			System.out.println("3.수리\t");
			System.out.println("4.사탐\t");
			System.out.println("5.과탐\t");
			System.out.println("6.제2외국어\t");
			System.out.println("7.논술\t");
						
			System.out.print("입력 : ");
			String input = scan.nextLine();
			
			if(input.equals("1")) {
				temp.setSubject("언어");
				loop = false;
			}else if(input.equals("2")) {
				temp.setSubject("외국어");
				loop = false;
			}else if(input.equals("3")) {
				temp.setSubject("수리");
				loop = false;
			}else if(input.equals("4")) {
				temp.setSubject("사탐");
				loop = false;
			}else if(input.equals("5")) {
				temp.setSubject("과탐");
				loop = false;
			}else if(input.equals("6")) {
				temp.setSubject("제2외국어");
				loop = false;
			}else if(input.equals("7")) {
				temp.setSubject("논술");
				loop = false;
			}else{
				System.out.println("정확히 입력해 주세요");
			}
			
		}//while
		
	}
	
	private static void price() {//희망가격

		boolean loop = true;
		


		while(loop) {
			System.out.println("===================================");
			System.out.println("●가격대 설정(회당 가격)●");
			System.out.println("1.1만원\t");
			System.out.println("2.2만원\t");
			System.out.println("3.3만원\t");
			System.out.println("4.4만원\t");
			System.out.println("5.5만원\t");
			System.out.println("6.6만원\t");
			System.out.println("7.7만원\t");
			System.out.println("8.8만원\t");
			System.out.println("9.9만원\t");
			System.out.println("10.10만원\t");
			System.out.println("11.무관");
			
			
			System.out.print("입력 : ");
			String input = scan.nextLine();
			
			if(input.equals("1")) {
				temp.setPrice("1");
				loop = false;
			}else if(input.equals("2")) {
				temp.setPrice("2");
				loop = false;
			}else if(input.equals("3")) {
				temp.setPrice("3");
				loop = false;
			}else if(input.equals("4")) {
				temp.setPrice("4");
				loop = false;
			}else if(input.equals("5")) {
				temp.setPrice("5");
				loop = false;
			}else if(input.equals("6")) {
				temp.setPrice("6");
				loop = false;
			}else if(input.equals("7")) {
				temp.setPrice("7");
				loop = false;
			}else if(input.equals("8")) {
				temp.setPrice("8");
				loop = false;
			}else if(input.equals("9")) {
				temp.setPrice("9");
				loop = false;
			}else if(input.equals("10")) {
				temp.setPrice("10");
				loop = false;
			}else if(input.equals("11")) {
				//무관이면 널값
				loop = false;
			}else{
				System.out.println("정확히 입력해 주세요");
			}
			
		}//while
		
	}
	
	
	private static void filterCheck() {
		
		System.out.println(temp.toString());
		
	}


	

	
}






























