package com.test.mvc.board;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//@XXX : annotation(프로그래밍 기능 주석)
@WebServlet("/board/list.do")
public class List extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//비회원 접근 금지//모든 페이지에 다 붙여넣어야함
		Check check = new Check();
		check.isauth(req, resp);
		
		//읽음 표시에 사용할 세션 저장
		HttpSession session = req.getSession();
		 session.setAttribute("read", "n");
		
		
		
		//1.DAO 위임(select)
		//2. 결과 전달 + JSP 호출하기
		
		//1. 
		BoardDAO dao = new BoardDAO();
		ArrayList<BoardDTO> list = dao.list();//24번
		
		
		//1.5 데이터 가공//28번
		for(BoardDTO dto :list) {
			
		
			//c. 최근에 쓴글인지? -1 시간이내
			//현재 시각 - 글쓴 시각 = 차이가 1시간 이내? 
			//Calendar
			//dto.getRegdate()
			
			//a. 날짜 포맷 설정
			// - 오늘 쓴 글 : 시분초 
			// - 어제 이전 쓴 글 : 년월일 
			Calendar now = Calendar.getInstance();
			String temp = String.format("%tF", now);//2018-04-16
		
			if(dto.getRegdate().startsWith(temp)) {
				//오늘 쓴 글 : 시분초
				dto.setRegdate(dto.getRegdate().substring(10,dto.getRegdate().length()-2));
			}else {
				//어제 이전 쓴 글: 년월일
				dto.setRegdate(dto.getRegdate().substring(0, 10));//덮어쓰기
			}
			
			
			
			//b. 제목이 길면 자르기..
			String subject = dto.getSubject();
			
			if(subject.length() > 30) {
				subject = subject.substring(0, 30) + "..";
				dto.setSubject(subject);//덮어쓰기
			}
		
			
			//c. 제목에 HTML 태그 적용해제 
			subject = subject.replace("<", "&lt;");
			dto.setSubject(subject);
		
			
			//사용자의 데이터는 반드시 원본을 보관한다.(DB)
			//사용자 입력 -> DB -> 화면 출력
			
		}
		
		
		//2.
		req.setAttribute("list", list);
		

		RequestDispatcher dispatcher = req.getRequestDispatcher("/board/list.jsp");
		dispatcher.forward(req, resp);
	}

}


