package com.project2.mvc.manager;

import java.util.Scanner;

import com.project2.mvc.auth.AuthClass;
import com.project2.mvc.manager.view.ManagerView;

import com.project2.mvc.view.MainView;

public class ManagerClass {
   
   private MainView mView;
   private ManagerView view ;
   private Scanner scan;
   private StudentManageClass smClass;
   
   
   public ManagerClass() {

      mView = new MainView();
      view = new ManagerView();
      scan = new Scanner(System.in);
      smClass = new StudentManageClass();
   }
   

   public void start() { 
      
      System.out.println(AuthClass.ID);
      boolean loop = true;
      
      
      while(loop) {
         view.menu();
         
         String sel = scan.nextLine();
         
         switch (sel) {
         case "1":
            
            break;
         case "2":
            
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

   
   
   
}