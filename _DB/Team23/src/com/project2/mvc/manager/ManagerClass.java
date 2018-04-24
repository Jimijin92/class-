package com.project2.mvc.manager;

import java.sql.SQLException;
import java.util.Scanner;

import com.project2.mvc.auth.AuthClass;
import com.project2.mvc.manager.view.BasicInfoView;
import com.project2.mvc.manager.view.ManagerView;

import com.project2.mvc.view.MainView;

public class ManagerClass {
   
   private MainView mView;
   private ManagerView view ;
   private Scanner scan;
   private StudentManageClass smClass;
   private BasicInfoClass bIClass;
   private OpenCourseInfoClass oClClass;
   private TeacherInfoClass tlClass;
   private BasicInfoView bView;
   
   
   public ManagerClass() {

      mView = new MainView();
      view = new ManagerView();
      scan = new Scanner(System.in);
      smClass = new StudentManageClass();
      bIClass = new BasicInfoClass();
      oClClass = new OpenCourseInfoClass();
      tlClass = new TeacherInfoClass();
      bView = new BasicInfoView();
   }
   
   
   public static void main(String[] args) throws SQLException {
	ManagerClass a = new ManagerClass();
	   a.start();
}
   

   public void start() throws SQLException { 
      
      System.out.println(AuthClass.ID);
      boolean loop = true;
      
      
      while(loop) {
         view.menu();
         
         String sel = scan.nextLine();
         
         switch (sel) {
         case "1":
        	 courseMenu();
            break;
         case "2":
        	 tlClass.start();
            break;
        	 
         case "3":
            
//            smClass.menu();
            break;
         
         case "4":
            
            break;
            
         case "5":
            
            break;
         case "0":
            
            loop = false;
            
            break;


         default : 
            mView.header("정확히 입력해 주세요");
            mView.menuchoice();
            break;
         }
         
      }
 
   }

   public void courseMenu() throws SQLException {
	      
	      boolean loop = true;
	      while (loop) {
	    	  bView.courseMenu();
	         int input = scan.nextInt();
	         scan.skip("\r\n");
	         switch (input) {
	            case 1: bIClass.start(); break; //1. 담당개설과정 관리
	            case 2: oClClass.start(); break; //2. 전체개설과정 조회
	            case 3:  break;
	            case 0: loop = false; break;
	            default: System.out.println("다시입력"); break;
	         }
	      }
  }
   
   
}