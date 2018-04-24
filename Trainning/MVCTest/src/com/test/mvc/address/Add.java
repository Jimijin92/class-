package com.test.mvc.address;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Add extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		/*int n =0;
		int m = 100 /n; //일부러 에러 내본거 -> 서버측에러니까 500번대 에러 발생 / by zero 잘라서 add.jsp로 가져가보기
*/		
		
		//업무 없음
		//2. JSP호출하기
		// - "/": WebContent 폴더
		
		RequestDispatcher dispatcher
		= req.getRequestDispatcher("/address/add.jsp");
	dispatcher.forward(req, resp);//pageContext.forward()와 동일한 역할 
		//고객은 서블릿하고만 대화했다고 생각하지만 실상 서블릿과 jsp 같이 일한거임
	
	//404 에러 종류 2가지
	//에러 메세지 do로 끝나면 서블릿잘못 web.xml 가짜주소 매핑했는지 확인
	//do없으면 서블릿은 잘못없고 서블릿이 jsp를 못찾은거 , request가서 확인하기 
	
	//빈페이지로 갈지라도 반드시 서블릿을 통해서! jsp로 바로가지 말기 
		
	}
	
}
