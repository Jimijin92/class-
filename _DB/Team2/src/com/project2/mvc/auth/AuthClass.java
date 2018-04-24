package com.project2.mvc.auth;

import java.util.Scanner;

import com.project2.mvc.auth.model.AuthDAO;
import com.project2.mvc.auth.model.AuthDTO;
import com.project2.mvc.manager.ManagerClass;
import com.project2.mvc.student.StudentClass;
import com.project2.mvc.teacher.TeacherClass;
import com.project2.mvc.view.MainView;

public class AuthClass {

   private MainView mView;
   private Scanner scan;
   private AuthDAO authdao;
   private ManagerClass mClass;
   private TeacherClass tClass;
   private StudentClass sClass;
   
   public static String ID;
   
   public AuthClass() {
      mView = new MainView();
      scan = new Scanner(System.in);
      authdao = new AuthDAO();
      mClass = new ManagerClass();
      tClass = new TeacherClass();
      sClass = new StudentClass();
   }
   
   
   public void logIn() {
      
      boolean loop = true;
      
      while(loop) {
      
         mView.idIn();
         String id = scan.nextLine();
         mView.pwIn();
         String pw = scan.nextLine();
         
         AuthDTO dto = new AuthDTO();
         dto.setId(id);
         dto.setPw(pw);
         
         
         String check = authdao.idCheck(dto);
         
         AuthClass.ID = check; 
         
         if(!check.equals("rejected")) {
            
            if(check.contains("A")) {      
               mClass.start();
               loop = false;
            }else if(check.contains("B")) {
//               tClass.start();
               loop = false;
            }else if(check.contains("C")) {
               
               loop = false;
            }
            
         }else{
            mView.header("아이디, 비밀번호를 확인해 주세요");
         }
         
      }//while
      
   }
   
   
}
