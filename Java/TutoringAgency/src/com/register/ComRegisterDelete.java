package com.register;

import java.util.Scanner;

public class ComRegisterDelete {
	
	private static Scanner scan;
	private static ComRegisterLogin goLogin;
	
	
	static {
		scan = new Scanner(System.in);
		goLogin = new ComRegisterLogin();
		
	}


	public static void deleteAccount() {

		System.out.println("=======================");
		System.out.println("        회원탈퇴");
		System.out.println("=======================");
		System.out.println("탈퇴하기를 원하시는");
		System.out.println("아이디와 비밀번호를 입력해주세요.");
		
		System.out.print("아이디 : ");
		String idDelete = scan.nextLine();
		
		System.out.print("비밀번호 : ");
		String pwDelete = scan.nextLine();
		
		
		
		//kiki111,P00001
		//String wantDelete = goLogin.loginCheck(idDelete, pwDelete);
		//System.out.println(wantDelete);
		
	}
	
	
	
	
	
	
	
	
	
	
}
