package com.test.jdbc;

import java.sql.Connection;

public class Ex02 {

	public static void main(String[] args) {
		
		//Ex01 예제에서 정적 코드를 분리시켜 클래스로 만들기
		Connection conn = null;
		
		try {
			
			conn = DBUtil.open();
			//conn = DBUtil.open("211.63.89.35", "hr", "java1234");
			
			System.out.println(conn.isClosed());//isclosed는 소켓이 닫혀있는 경우 true, 열려있는 경우 false
			
			conn.close();
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
	}
	
}















