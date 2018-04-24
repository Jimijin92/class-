import java.beans.Statement;
import java.sql.Connection;

public class Ex03_Statement {
	
	public static void main(String[] args) {
	
		/*
		 Ex03_Statement 
		 
		Statement 클래스
		- SQL 구문을 실행하는 역할
		- 스스로는 해당 쿼리를 어떤 DB?
		- 모든 DML은 자동 커밋이 된다. 
		
		
		
		Statement 종류
		1. Statement
			- 기본
		
		Statement 종류
		1, Statement
			- 기본
		2. PreparedStatement
			- 
		
		*/
		
		//localhost > hr > 
		
		
		//접속
		Connection conn = null;
		try {
			//1. 접속
			conn= DBUtil.open();
			
			//2. 질의 - 문장 종결자 사용 불가능 
			String sql = "INSERT INTO tbladress(seq, name, age, tel, address, "
					+ "regdate) VALUES (adress_seq.nextval, '후후후', 20, '010-1111-2222', '서울시', default)";
		
			//2. Statement 객체 생성 
			Statement stat = conn.createStatement();
			
			//반환값이 없는 쿼리
			//- stat.executeQuery();
			//반환값이 있는 쿼리
			//- stat.executeUpdate();
			
			stat.executeUpdate(sql);// DataGrip : Ctrl + Enter 동일 
		
			//3. 종료
			stat.close();
			conn.close();
			
			
			System.out.println("완료");
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
			
			
			
	
		
		
		
	}
}
