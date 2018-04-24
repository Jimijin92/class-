import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtil {

	public static Connection open(String serverIP, String id, String pw) {

	Connection conn = null; 
		
		
		//2. 연결 문자열 생성
		// - 접속에 필요한 정보로 구성된 문자열
		String url = "jdbc:oracle:thin:@" + serverIP + ":1521:xe";
		
		try {
	
			//DB 작업 -> 외부 환경 -> 예외처리 필수 
			//3. 설치한 JDBC 드라이버 로딩 
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//4. 접속
			// - Connection 객체 생성(new Connection();) + 접속까지 
			//System.out.println(conn.isClosed());
			conn = DriverManager.getConnection(url, id, pw);
			System.out.println(conn.isClosed());
			
			//5. 질의
			
			
			
			//6. 접속 종료 
			conn.close();
			System.out.println(conn.isClosed());
			
			
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return conn;
	
		
	}
		
		
		

}
