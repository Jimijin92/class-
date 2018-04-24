import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Collections;

public class Ex05_SELECT {
	public static void main(String[] args) {
		//Ex05_SELECT.java
		
		m1(); 
	
	}

	private static void m1() {
		
		//단일값을 반환하기 
		// : SELECT -> 1행 1열 -> 단일값 1개 (숫자)
		
		//준비물 아래 세개
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null; 
		
		try {
			conn = DBUtil.open();
			if(!conn.isClosed()) {
				stat = conn.createStatement();
				//String sql = "SELECT count(*) FROM tbladdress";
				String sql = "SELECT name FROM tbladdress WHERE seq = 22";
				
				//executeUpdate() vs executeQuery()
				rs = stat.executeQuery(sql); //Ctrl + Enter
				
				//ResultSet -> 탐색
				// : 1행 1열짜리 테이블 
				rs.next(); //전진커서, back이 안됨 
				
				//int total = rs.getInt(0); //6
				String name = rs.getString(1); //6
				
				
				System.out.println(total);
				
				rs.close();
				stat.close();
				conn.close();
				
			}else {
				System.out.println("DB접속이 원활하지 않습니다. 관리자에게 연락...");
			}
			
			
		} catch (Exception e) {
			 System.out.println(e.toString());
		}
		
		
		
		
		
		
		
		
		
		
		
	}
}
