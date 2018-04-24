package com.test.mvc.member.auth;

import java.util.Scanner;

import com.test.mvc.member.model.MemberDAO;
import com.test.mvc.member.model.MemberDTO;

public class Auth {
	
	private MemberDAO dao;
	public static boolean isAuth = false;
	public static String mseq; //자주 알아야 하는건 정적변수로
	
	public Auth() {
		dao = new MemberDAO();
	}

	public void logout() {
		
		System.out.println("[회원 로그아웃]");
		
		//로그아웃
		Auth.isAuth = false;
		Auth.mseq = null;
		
		System.out.println("**로그아웃 성공");
		
	}

	//
	public void login() {
		
		Scanner scan = new Scanner(System.in);
		System.out.println("[회원 로그인]");
		
		System.out.print("이메일 : ");
		String email = scan.nextLine();
		
		System.out.print("비밀번호 : ");
		String pw = scan.nextLine();
		
		MemberDTO dto = new MemberDTO();
		dto.setEmail(email);
		dto.setPw(pw);
		
		if (dao.auth(dto) == 1) {
			//성공
			Auth.isAuth = true; //보통은 한번에 아이디까지 얻음, 아이디없는경우 반환값 null 로 인증
			Auth.mseq = dao.getMseq(dto);
			System.out.println("**로그인 성공");
		} else {
			//실패
			Auth.isAuth = false;
			System.out.println("**로그인 실패");
		}
		
	}


}





