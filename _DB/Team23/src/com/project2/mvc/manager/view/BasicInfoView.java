package com.project2.mvc.manager.view;

import com.project2.mvc.view.MainView;

public class BasicInfoView {
	

	private MainView mainView;
	
	public BasicInfoView() {
		mainView = new MainView();
	}
	
	
	public void courseMenu() {
			
			mainView.titlebar("과정관리메뉴");
	        System.out.println("1. 기초정보관리");//완료
	        System.out.println("2. 개설과정관리");//완료
	        System.out.println("3. 개설과목관리");//애리가
	        mainView.backmenu();
	        mainView.singlebar();
	        mainView.menuchoice();
		}	
		
		
	public void menu() {
			
			mainView.titlebar("기초정보 관리메뉴");
	        System.out.println("1. 과정 관리");//완료
	        System.out.println("2. 과목 관리");//완료
	        System.out.println("3. 강의실 관리");//완료
	        System.out.println("4. 교재 관리");//완료
	        System.out.println("5. 교재 관리(출판사 관리)");//완료
	        mainView.backmenu();
	        mainView.singlebar();
	        mainView.menuchoice();
		}
	
	public void middle_menu() {
		
		    System.out.println("1. 등록");//완료
		    System.out.println("2. 수정");//완료
		    System.out.println("3. 삭제");//완료
		    mainView.backmenu();
		    mainView.singlebar();
		    mainView.menuchoice();
	}

	
	
	 public void titlebar(String text) {
	    	
         System.out.println("==========================================================================================================================================================");
         System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t"+text+"\t");
         System.out.println("==========================================================================================================================================================");
    
 }
	 
	 public void result (String text) {

         System.out.printf(" ▶▶%s\n",text);
         
      }
	 
}//BasicInfoClass
