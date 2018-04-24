package com.project2.mvc.manager.view;

import com.project2.mvc.view.MainView;

public class TeacherManageView {

	private MainView mainView;
	
	public TeacherManageView() {
		mainView = new MainView();
	}
	
	
	public void menu() {
		
		mainView.titlebar("교사 관리메뉴");
	    System.out.println("1. 담당교사 조회");//완
	    System.out.println("2. 전체교사 관리");//완
	    mainView.backmenu();
	    mainView.singlebar();
	    mainView.menuchoice();
	}
	
	public void myCourseMenuMy() {
		mainView.titlebar("담당교사조회");
		System.out.println("1. 교사 강의 가능과목 조회");//완
		System.out.println("2. 교사 담당 개설과정 조회");//완
		System.out.println("3. 교사 담당 개설과목 조회");//완
	    
	    mainView.backmenu();
	    mainView.singlebar();
	    mainView.menuchoice();
	}
	
	
	public void myCourseMenu() {
		mainView.titlebar("전체교사관리");
		System.out.println("1. 교사개인정보 관리");//완
	    System.out.println("2. 강의가능과목 관리");//완
	    System.out.println("3. 교사상세정보 조회");//완
	    
	    mainView.backmenu();
	    mainView.singlebar();
	    mainView.menuchoice();
	}
	
	//공통메뉴

		
	public void myCourseMenuEdit() {
		mainView.titlebar("교사개인정보 관리");
		System.out.println("1. 교사 개인정보 등록");//완
		System.out.println("2. 교사 개인정보 조회");//완
		System.out.println("3. 교사 개인정보 수정");//완
		System.out.println("4. 교사 개인정보 삭제");//완
		
	    mainView.backmenu();
	    mainView.singlebar();
	    mainView.menuchoice();
	}
	
	public void myAvaSubMenuEdit() {
		mainView.titlebar("강의가능과목 관리");
		System.out.println("1. 강의가능과목 등록");//완
		System.out.println("2. 강의가능과목 조회");//완
		System.out.println("3. 강의가능과목 수정");//완
		System.out.println("4. 강의가능과목 삭제");//완
	    mainView.backmenu();
	    mainView.singlebar();
	    mainView.menuchoice();
	}
	
	public void MenuInfoMy() {
		mainView.titlebar("교사상세정보조회");
		System.out.println("1. 교사 강의 가능과목 조회");//완
		System.out.println("2. 교사 담당 개설과정 조회");//완
		System.out.println("2. 교사 담당 개설과목 조회");//완
	    mainView.backmenu();
	    mainView.singlebar();
	    mainView.menuchoice();
	}
	

}
