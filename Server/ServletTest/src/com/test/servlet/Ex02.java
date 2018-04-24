package com.test.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Ex02 extends HttpServlet {//a. javax.servlet.http.HttpServlet 클래스를 상속받아야 한다!!(상속)

   /*   
   //2. doGet/ doPost 메소드 선언(매개변수 작성) + 예외 미루기 (처리)를 꼭 옆에 해야한다!
   public void doGet(HttpServletRequest request , HttpServletResponse response) throws IOException,ServletException{
   //3. 메소드 내부 구현
   //PrintWriter writer = response.getWriter();
   }*/
   
   //우리가 직접 만드는게 아니고 doGet Override 하자!
   //2. doGet/ doPost 메소드 선언(매개변수 작성) + 예외 미루기 (처리)를 꼭 옆에 해야한다!
   @Override
   protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      //한글을 안깨지게 하는것
      resp.setCharacterEncoding("UTF-8");
      
      
      //3. 메소드 내부 구현
      PrintWriter writer = resp.getWriter();
   
      writer.println("<html>");
      writer.println("<head>");
      writer.println("<title>구구단!</title>");
      writer.println("<meta charset = 'UTF-8'>");
      writer.println("</head>");
      writer.println("<body>");
      
      writer.println("<h1>구구단  - 5단</h1>");
      
      for(int i =1 ; i<10 ; i++) {
         
         writer.printf("<div>5 X %d = %d</div>\n",i , i*5);
      
      }

      writer.println("</body>");
      writer.println("</html>");
      
      writer.close(); //동적으로 HTML 페이지 작성 완료!!!
		
		System.out.println("doGet() 호출");
		
	}//doGet()
	
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		System.out.println("init호출()");
	}
	
	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("service() 호출 전");
		super.service(arg0, arg1);
		System.out.println("service() 호출 후");
	}
	
}












