package com.test.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Ex04_Receive extends HttpServlet{

	//이 서블릿을 부른 페이지가
	//method="get" -> doGet()
	//method= "post" -> doPost()
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		//1. 넘어온 데이터를 가져오기 
		String type = req.getParameter("type");
		int count = Integer.parseInt(req.getParameter("count"));
		
		//2. 위의 데이터를 사용해서 동적으로 이미지 생성
		resp.setCharacterEncoding("uTf-8");
		PrintWriter writer = resp.getWriter();
		
		writer.println("<!DOCTYPE html>\r\n" + 
				"<html>\r\n" + 
				"<head>\r\n" + 
				"<meta charset='UTF-8'>\r\n" + 
				"<title>Insert title here</title>\r\n" + 
				"	<style>\r\n" + 
				"	#box{border: 10px solid yellow; padding: 20px;}\r\n" + 
				"	#box img{display: inline-block; margin: 10px;}\r\n" + 
				"	</style>\r\n" + 
				"	\r\n" + 
				"</head>\r\n" + 
				"<body>\r\n" + 
				"	<h1>고양이 분양</h1>\r\n" + 
				"	<div id = \"box\">\r\n" );
		
		for (int i=0; i<count; i++) {
			writer.printf("<img src=\"/ServletTest/images/catty01.png\">\r\n", type);//전 페이지에서 넘긴 타입에 따라 
		}		
		
		writer.print("</div>\r\n" + 
				"</body>\r\n" + 
				"</html>");
		
		writer.close();
	}
	
}
