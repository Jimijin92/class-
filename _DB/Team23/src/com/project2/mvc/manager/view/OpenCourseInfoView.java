package com.project2.mvc.manager.view;

import com.project2.mvc.view.MainView;

public class OpenCourseInfoView {

	private MainView mainView;
	
	public OpenCourseInfoView() {
		mainView = new MainView();
	}
	
	
	public void menu() {
		
		mainView.titlebar("개설과정 관리메뉴");
	    System.out.println("1. 담당개설과정 관리");
	    System.out.println("2. 전체개설과정 조회");//완료
	    mainView.backmenu();
	    mainView.singlebar();
	    mainView.menuchoice();
	}
	
	public void myCourseMenu() {
		mainView.titlebar("담당개설과정 관리");
		System.out.println("1. 상세정보 조회");//완료
	    System.out.println("2. 개설과정 등록");//완료
	    System.out.println("3. 개설과정 수정");
	    System.out.println("4. 개설과정 삭제");//완료
	    mainView.backmenu();
	    mainView.singlebar();
	    mainView.menuchoice();
	}
	
	//공통메뉴
	public void MenuList() {
		mainView.titlebar("상세정보 조회");
		System.out.println("1. 개설과목 정보확인하기");//완료
		System.out.println("2. 수강학생 정보확인하기");//완료
	    mainView.backmenu();
	    mainView.singlebar();
	    mainView.menuchoice();
	}
		
	public void myCourseMenuEdit() {
		mainView.titlebar("개설과정 수정");
		System.out.println("1. 강의실 변경하기");
		System.out.println("2. 과정 변경하기");
		System.out.println("3. 선생님 변경하기");
	    mainView.backmenu();
	    mainView.singlebar();
	    mainView.menuchoice();
	}
	
}
