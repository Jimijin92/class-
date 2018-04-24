package com.test.jsp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Ex05 extends HttpServlet {

	int c =10;
	public void test(){
		
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setCharacterEncoding("UTF-8");
		PrintWriter writer = resp.getWriter();
		
		int a=10;
		
		writer.print("\r\n"+
				"<!DOCTYPE html>\r\n" + 
				"<html>\r\n" + 
				"<head>\r\n" + 
				"<meta charset=\"UTF-8\">\r\n" + 
				"<title>Insert title here</title>\r\n" + 
				"</head>\r\n" + 
				"<body>\r\n" + 
				"<!-- ex05.jsp -->\r\n" + 
				"\r\n" + 
				"<h1>구구단</h1>"+
				"\r\n"+
				"");
		
		
		for(int i=1; i<=9; i++) {
			writer.print("\r\n" + 
					"<div>9x");
			writer.print(i);
			writer.print("=");
			writer.print(i*9);
			writer.print("</div>\r\n" + 
					"\r\n" + 
					"");
			
		}
		
			writer.print("<% } %>\r\n" + 
					"\r\n" + 
					"\r\n" + 
					"</body>\r\n" + 
					"</html>");
			
			int b = a;
			
	}

}
