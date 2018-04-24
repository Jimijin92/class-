package com.project2.mvc.model;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtil {
	
public static Connection open() { //행동에 변화가 없음 -> 정적으로 만들기 //내꺼 전용 
		
		Connection conn = null; //connection interface 참조를 사용 (오라클이던 mysql이던 모두 다 connection interface를 쓴다는 뜻)

		
		//2. 연결 문자열 생성 
		// - 접속에 필요한 정보로 구성된 문자열 
		String url = "jdbc:oracle:thin:@localhost:1521:xe"; //지미진 노트북용
		String id = "system";//지미진 노트북용
		String pw = "java1234";//지미진 노트북용
		
		try {
			
			//DB 작업 -> 외부 환경 -> 예외처리 필수
			//3.설치한 JDBC 드라이버 로딩 (복붙수준)
			Class.forName("oracle.jdbc.driver.OracleDriver"); //db에 접속할 상황을 만들어주는 코드 
			
			//4.접속
			conn=DriverManager.getConnection(url,id,pw); 
			return conn;
			
			
		} catch (Exception e) {
			
			System.out.println(e.toString());
			
		}
		
			return null; //실패하면 null을 돌려줌 
		
	}
		
	

}
