package com.project2.mvc.manager.view;

import com.project2.mvc.view.MainView;

public class ManagerView {

	private MainView mainView;
	
	public ManagerView() {
		mainView = new MainView();
	}
	
	
	public void menu() {
		

        System.out.println("====================");
        System.out.println("관리자 메뉴");
        System.out.println("====================");
        System.out.println("1. 과정 관리");
        System.out.println("2. 교사 관리");
        System.out.println("3. 교육생 관리 ");
        System.out.println("4. 마이페이지");
        System.out.println("5. 로그아웃");
        mainView.backmenu();
        System.out.print("메뉴선택 : ");
        
        
	}

	public void header(String text) {
		
		System.out.printf("[%s]\n", text);
		
	}

	public void result(String text) {
		
		System.out.printf("**%s\n", text);
		
	}
}
