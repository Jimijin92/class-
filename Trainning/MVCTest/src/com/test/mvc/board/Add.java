package com.test.mvc.board;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/board/add.do")
public class Add extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//비회원 접근 금지//모든 페이지에 다 붙여넣어야함
				Check check = new Check();
				check.isauth(req, resp);

		RequestDispatcher dispatcher = req.getRequestDispatcher("/board/add.jsp");
		dispatcher.forward(req, resp);
	}

}
