package com.test.mvc.auth;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Login extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//login.do?id=hong&pw=1111
		
		//1.데이터 가져오기
		//2. DB작업
		//3. 결과에 따른 인증 처리
		
		//로그인? 로그아웃?
		
		//서블릿에서 세션 객체 얻어오는 방법 
		HttpSession session = req.getSession();
		
		if(req.getParameter("mode") == null) {
		
			String id = req.getParameter("id");
			String lv = req.getParameter("lv");
	
			//인증 티켓
			session.setAttribute("auth", id);
			session.setAttribute("lv", lv);
		
		}else {
			
			//로그아웃
			session.removeAttribute("auth");
			session.removeAttribute("lv");
			
		}
		
		/*RequestDispatcher dispatcher = req.getRequestDispatcher("");
		dispatcher.forward(req, resp);*/
		
		//서블릿 -> 서블릿
		// : "*/mvc"로 시작
		resp.sendRedirect("/mvc/auth/index.do"); //서블릿에서 서블릿으로 이동할 때는 위에거 말고 이거씀 
		//    /가 여기서도 동등한 의미가 되려면 프로젝트명까지 들어가야함
		
		
	}

}