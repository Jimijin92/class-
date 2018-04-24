package com.register;

import java.util.Scanner;

public class ComRegisterModify {
	
	private static Scanner scan;
	public static ComRegisterMenu mainList;
	
	static {
		scan = new Scanner(System.in);
		mainList = new ComRegisterMenu();
		
	}


	public static void modification() {
		
		boolean loop = true;
		
		while(loop) {

		System.out.println("=========================");
		System.out.println("     회원 정보 수정");
		System.out.println("     (본인을 선택)");
		System.err.println("=========================");
		System.out.println("1. 선생님");
		System.out.println("2. 학생");
		
		System.out.print("선택 : ");
		String sel = scan.nextLine();
		

		if(sel.equals("1")) modiTeacher();
		else if(sel.equals("2")) modiStudent();
		else loop = false;
	
		}
	}

	
	
	private static void modiTeacher() {
		

		boolean loop = true;
		
		while(loop) {
		
			System.out.println("===========================");
			System.out.println("       회원 정보 수정");
			System.out.println("        (선 생 님)");
			System.out.println("===========================");	
			
			System.out.println("1. 비밀번호 변경");
			System.out.println("2. 휴대폰 변경");
			System.out.println("3. 학교 변경");
			System.out.println("4. 전공 변경");
			System.out.println("5. 학년 변경");
			System.out.println("6. 과외경력 변경");
			System.out.println("7. 회당가격 변경");
			System.out.println("8. 지도과목 변경");
			System.out.println("9. 이전으로 돌아가기");
			System.out.println("0. 메인으로 돌아가기");
			
			System.out.print("선택  : ");
			String sel = scan.nextLine();
			
			if(sel.equals("1")) changeTPw();
			else if(sel.equals("2")) changeTTel();
			else if(sel.equals("3")) changeTUniv();
			else if(sel.equals("4")) changeTDepart();
			else if(sel.equals("5")) changeTGrade();
			else if(sel.equals("6")) changeTCareer();
			else if(sel.equals("7")) changeTPrice();
			else if(sel.equals("8")) changeTSubject();
			else if(sel.equals("9")) modification();
			else if(sel.equals("0")) loop = false;
			
		}
			
		
	}

	private static void changeTPw() {
		// TODO Auto-generated method stub
		
	}

	private static void changeTTel() {
		// TODO Auto-generated method stub
		
	}

	private static void changeTUniv() {
		// TODO Auto-generated method stub
		
	}

	private static void changeTDepart() {
		// TODO Auto-generated method stub
		
	}

	private static void changeTGrade() {
		// TODO Auto-generated method stub
		
	}

	private static void changeTCareer() {
		// TODO Auto-generated method stub
		
	}

	private static void changeTPrice() {
		// TODO Auto-generated method stub
		
	}

	private static void changeTSubject() {
		// TODO Auto-generated method stub
		
	}

	
	
	
	
	
	
	
	
	
	
	
	private static void modiStudent() {

		boolean loop = true;
		
		while(loop) {
			
		
			System.out.println("===========================");
			System.out.println("       회원 정보 수정");
			System.out.println("          (학 생)");
			System.out.println("===========================");	
			
			System.out.println("1. 비밀번호 변경");
			System.out.println("2. 휴대폰 변경");
			System.out.println("3. 학교 변경");
			System.out.println("4. 전공 변경");
			System.out.println("5. 학년 변경");
			System.out.println("6. 희망가격 변경");
			System.out.println("7. 희망 선생님성별 변경");
			System.out.println("8. 희망과외 과목 변경");
			System.out.println("9. 이전으로 돌아가기");
			System.out.println("0. 메인으로 돌아가기");
			
			System.out.print("선택  : ");
			String sel = scan.nextLine();
			
			if(sel.equals("1")) changeSPw();
			else if(sel.equals("2")) changeSTel();
			else if(sel.equals("3")) changeShigh();
			else if(sel.equals("4")) changeSDepart();
			else if(sel.equals("5")) changeSGrade();
			else if(sel.equals("6")) changeSPrice();
			else if(sel.equals("7")) changewantGenger();
			else if(sel.equals("8")) changeSSubject();
			else if(sel.equals("9")) modification();
			else if(sel.equals("0")) loop = false;
			
		}
			
	}

	private static void changeSPw() {
		// TODO Auto-generated method stub
		
	}

	private static void changeSTel() {
		// TODO Auto-generated method stub
		
	}

	private static void changeShigh() {
		// TODO Auto-generated method stub
		
	}

	private static void changeSDepart() {
		// TODO Auto-generated method stub
		
	}

	private static void changeSGrade() {
		// TODO Auto-generated method stub
		
	}

	private static void changeSPrice() {
		// TODO Auto-generated method stub
		
	}

	private static void changewantGenger() {
		// TODO Auto-generated method stub
		
	}

	private static void changeSSubject() {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
