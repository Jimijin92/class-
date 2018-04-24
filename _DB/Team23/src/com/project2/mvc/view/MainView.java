package com.project2.mvc.view;

public class MainView {
	public void primary() {
        
        System.out.println("========================");
        System.out.println(" 환영합니다~ 메뉴를 선택해 주세요");
        System.out.println("========================");
        System.out.println("1.로그인");
        System.out.println("2.프로그램 종료");
        System.out.print("메뉴선택 : ");
        
     }
     
     public void idIn(){
        
        System.out.println("========================");
        System.out.println(" 아이디와 비밀번호를 입력해 주세요");
        System.out.println("========================");
        System.out.println("아이디 : ");
        
     }
     
     public void pwIn() {
        
        
        System.out.println("비밀번호 : ");
        
     }
     
     //바
     public void titlebar(String text) {
    	
             System.out.println("==========================================================================================================================================================");
             System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t"+text+"\t");
             System.out.println("==========================================================================================================================================================");
          
     }
     public static void onesinglebar() {
         System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------");
     }
     public void singlebar() {
         System.out.println("==========================================================================================================================================================");
     }
     
     public void menuchoice() {
        System.out.print(" 메뉴 선택 : ");
        }
     
     public void numchoice() {
           System.out.print(" 번호 선택 : ");
        }
     
     
     public void choice(String text) {
        System.out.printf(" %s : ",text);
     }
     
     public void backmenu() {
       System.out.println("0. 상위 메뉴로 이동");
    }
     
     //헤더
     public void header(String text) {
         System.out.printf("[%s]\n",text);
      }

      public void result (String text) {

         System.out.printf("** %s\n",text);
         
      }
}
