package com.register;

import java.util.Scanner;


public class ComRegisterMenu {
	
	private static Scanner scan;
//	private static ComRegisterLogin goLogin;
	private static ComRegisterTeacher regiT;
	private static ComRegisterStudent regiS;
	private static ComRegisterManager regiM;
	private static ComRegisterModify modif;
	private static ComRegisterDelete delete;
//	
	
	static {
		
		scan = new Scanner(System.in);
		//goLogin = new ComRegisterLogin();
		regiT = new ComRegisterTeacher();
		regiS = new ComRegisterStudent();
		regiM = new ComRegisterManager();
		modif = new ComRegisterModify();
		delete = new ComRegisterDelete();

	}

	
	public static void main(String[] args) {

	
			boolean loop = true;
			
			while(loop) {
				
				System.out.println("=======================");
				System.out.println("	구 해 줘");
				System.out.println("=======================");
				System.out.println("----------------------");
				System.out.println("  1. 로그인");
				System.out.println("  2. 회원가입");
				System.out.println("  3. 회원정보수정");
				System.out.println("  4. 회원탈퇴");
				System.out.println("  5. 종료");
				System.out.println("----------------------");
				System.out.print("선택 : ");
				
				String sel = scan.nextLine();
				
				if(sel.equals("1")) {
					ComRegisterLogin.login();
				} 
				else if(sel.equals("2")) {
					register();
				}
				else if(sel.equals("3")) {
					//modif.modification();}
				}
				else if(sel.equals("4")) {
					//delete.deleteAccount();
				}
				else System.exit(0); 			//그냥 다 끝내버려~!	
				
			}
			
			System.out.println("프로그램 종료");
			
			
		
	}//main



//===============================================================================================회원가입

	 static void register() {
		
		boolean loop = true;
		
		while(loop) {
			
			System.out.println();
			System.out.println("================");
			System.out.println("  가입자 선택 화면");
			System.out.println("================");
			System.out.println("1. 선생님");
			System.out.println("2. 학생");
			System.out.println("3. 매니저");
			System.out.println("0. 메인으로 돌아가기");
			System.out.print("선택 : ");
			

			String sel = scan.nextLine();
			
			if(sel.equals("1")) regiT.registTeacher();
			else if(sel.equals("2")) regiS.registStudent();
			else if(sel.equals("3")) regiM.registManager();
			else if(sel.equals("0")) loop = false;	
			
		}
	 }


}


