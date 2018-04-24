package com.test.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Random;
import java.util.Scanner;
import java.util.jar.Attributes.Name;

import oracle.jdbc.internal.OracleTypes;

public class Ex08_CallableStatement {
	
	public static void main(String[] args) {
		
		//Ex08_CallableStatement.java
		
		//1. Statement : 정적 쿼리 실행
		//2. PreparedStatement : 동적 쿼리 실행
		//3. CallableStatement : 프로시저 호출 전용
		
		//SELECT * FROM tblinsa WHERE buseo = 입력값;
		
		//m1();
		//m2();
		//m3();
		//m4();
		//m5();
		//m6();
		//m7();
		//m8();
		//m9();
		m10();
		//m11();
		//m12();
	}
	
	private static void m12() {
		
		Connection conn = null;
		CallableStatement stat = null;
		
		try {
			
			conn = DBUtil.open();
			String sql = "{ call proc_list_electronics(?) }";
			stat = conn.prepareCall(sql);
			stat.registerOutParameter(1, OracleTypes.CURSOR);
			
			stat.executeQuery();
			
			ResultSet rs = (ResultSet)stat.getObject(1);
			
			while (rs.next()) {
				
				//System.out.println(rs.getString("name"));
				
				sql = "{ call proc_check(?, ?) }";
				stat = conn.prepareCall(sql);
				stat.setString(1, rs.getString("seq"));
				stat.registerOutParameter(2, OracleTypes.DOUBLE);
				
				stat.executeQuery();
				
				//System.out.println(Math.round(stat.getDouble(2)));
				int totalHours = (int)Math.round(stat.getDouble(2)); 
				
				
				sql = "{ call proc_get_total_capacity(?, ?) }";
				stat = conn.prepareCall(sql);
				stat.setString(1, rs.getString("seq"));
				stat.registerOutParameter(2, OracleTypes.INTEGER);
				
				stat.executeQuery();
				
				//System.out.println(Math.round(stat.getInt(2)));
				int totalCapacity = Math.round(stat.getInt(2));
				
//				System.out.printf("%s : %d : %d : %d : %d\n"
//											, rs.getString("name")
//											, rs.getInt("consumption")
//											, totalHours
//											, totalCapacity
//											, totalCapacity - (totalHours * rs.getInt("consumption")));
				String state = "";
				if (totalCapacity - (totalHours * rs.getInt("consumption")) > 0) {
					state = String.format("%d 시간 사용 가능함", (totalCapacity - (totalHours * rs.getInt("consumption"))) / rs.getInt("consumption"));
				} else {
					state = "배터리 없음";
				}
				System.out.printf("%s : %s\n", rs.getString("name"), state);
			}
			
			
			rs.close();
			stat.close();
			conn.close();
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
	}

	private static void m11() {

		Connection conn = null;
		CallableStatement stat = null;
		
		try {
			
			conn = DBUtil.open();
			String sql = "{ call proc_distance(?) }";
			stat = conn.prepareCall(sql);
			stat.registerOutParameter(1, OracleTypes.CURSOR);
			
			stat.executeQuery();
			
			ResultSet rs = (ResultSet)stat.getObject(1);
			
			while (rs.next()) {
				System.out.printf("%s ▷ %s (%skm)\n"
											, rs.getString("sname")
											, rs.getString("ename")
											, rs.getString("distance"));
			}
			
			
			rs.close();
			stat.close();
			conn.close();
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
	}

	private static void m10() {
		
		Connection conn = null;
		CallableStatement stat = null;
		
		try {
			
			conn = DBUtil.open();
			String sql = "{ call proc_mergency(?) }";
			stat = conn.prepareCall(sql);
			stat.registerOutParameter(1, OracleTypes.CURSOR);
			
			stat.executeQuery();
			
			ResultSet rs = (ResultSet)stat.getObject(1);
			String buseo = "";
			String temp = "";
			
			while (rs.next()) {
				if (!buseo.equals(rs.getString("buseo").trim())) {
					buseo = rs.getString("buseo").trim();
					if (temp.length() == 0)
						temp += String.format("[%s]\n", buseo);
					else
						temp = temp.substring(0, temp.length()-2) +  String.format("(종료)\n[%s]\n", buseo);
				}
				temp += rs.getString("name") + " ▷ ";				
			}
			System.out.println(temp.substring(0, temp.length()-2) + "(종료)");
			
			rs.close();
			stat.close();
			conn.close();
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
	}

	private static void m9() {
		
		Scanner scan = new Scanner(System.in);
		
		Connection conn = null;
		CallableStatement stat = null;
		
		try {
			
			conn = DBUtil.open();
			String sql = "{ call proc_employees(?, ?) }";
			stat = conn.prepareCall(sql);
			stat.registerOutParameter(2, OracleTypes.CURSOR);
			
			
			System.out.print("직원 번호 입력 : ");
			stat.setString(1, scan.nextLine());
			
			stat.executeQuery();
			
			ResultSet rs = (ResultSet)stat.getObject(2);
			
			while (rs.next()) {
				String temp = "";
				
				for (int i=1; i<rs.getInt("level"); i++) {
					temp += "        ";
				}
				if (rs.getInt("level") > 1)
					temp += "▷ ";
				
				System.out.printf("%s%s(tel:%s)\n"
											, temp
											, rs.getString("name")
											, rs.getString("phone"));
			}
			
			rs.close();
			stat.close();
			conn.close();
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
	}

	private static void m8() {
		
		Scanner scan = new Scanner(System.in);
		
		Connection conn = null;
		CallableStatement stat = null;
		
		try {
			
			conn = DBUtil.open();
			String sql = "{ call proc_list_big_category(?) }";
			stat = conn.prepareCall(sql);
			stat.registerOutParameter(1, OracleTypes.CURSOR);
			
			stat.executeQuery();
			
			ResultSet rs = (ResultSet)stat.getObject(1);
			
			System.out.println("[대분류]");
			while (rs.next()) {
				System.out.printf("%s. %s\n"
											, rs.getString("seq")
											, rs.getString("name"));
			}
			rs.close();
			
			System.out.print("선택 : ");
			int sel = scan.nextInt();
			
			
			
			sql = "{ call proc_list_middle_category(?, ?) }";
			stat = conn.prepareCall(sql);
			stat.setInt(1, sel);
			stat.registerOutParameter(2, OracleTypes.CURSOR);
			
			stat.executeQuery();
			
			rs = (ResultSet)stat.getObject(2);
			
			System.out.println("\n[중분류]");
			while (rs.next()) {
				System.out.printf("%s. %s\n"
											, rs.getString("seq")
											, rs.getString("name"));
			}
			rs.close();
			
			System.out.print("선택 : ");
			sel = scan.nextInt();
			
			
			
			
			
			
			
			sql = "{ call proc_list_small_category(?, ?) }";
			stat = conn.prepareCall(sql);
			stat.setInt(1, sel);
			stat.registerOutParameter(2, OracleTypes.CURSOR);
			
			stat.executeQuery();
			
			rs = (ResultSet)stat.getObject(2);
			
			System.out.println("\n[소분류]");
			while (rs.next()) {
				System.out.printf("%s. %s\n"
											, rs.getString("seq")
											, rs.getString("name"));
			}
			rs.close();
			
			System.out.print("선택 : ");
			sel = scan.nextInt();
	
			
			
			
			
			
			sql = "{ call proc_list_product(?, ?) }";
			stat = conn.prepareCall(sql);
			stat.setInt(1, sel);
			stat.registerOutParameter(2, OracleTypes.CURSOR);
			
			stat.executeQuery();
			
			rs = (ResultSet)stat.getObject(2);
			
			System.out.println("\n[상품]");
			while (rs.next()) {
				System.out.printf("%s. %s(수량 : %s개)\n"
											, rs.getString("seq")
											, rs.getString("name")
											, rs.getString("qty"));
			}
			
			rs.close();
			stat.close();
			conn.close();
			
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
	}

	private static void m7() {
		
		Scanner scan = new Scanner(System.in);
		
		Connection conn = null;
		CallableStatement stat = null;
		
		try {
			
			conn = DBUtil.open();
			String sql = "{ call proc_auth(?, ?) }";
			stat = conn.prepareCall(sql);
			stat.registerOutParameter(2, OracleTypes.INTEGER);
			
			while (true) {
				System.out.print("아이디 입력 : ");
				stat.setString(1, scan.nextLine());
				
				stat.executeQuery();
				
				if (stat.getInt(2) == 0) {
					System.out.println("사용이 가능합니다.");
					break;
				} else {
					System.out.println("이미 사용중입니다.");
				}
			}
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
	}

	private static void m6() {
		
		String[] names = { "홍길동", "아무개", "하하하", "테스트", "호호호" };
		String[] items = { "키보드", "마우스", "모니터", "프린터" };
		Random rnd = new Random();
		Scanner scan = new Scanner(System.in);
		
		Connection conn = null;
		CallableStatement stat = null;
		
		try {
			
			conn = DBUtil.open();
			String sql = "{ call proc_addbuy(?, ?, ?) }";
			stat = conn.prepareCall(sql);
			
			for (int i=0; i<100; i++) {
				stat.setString(1, names[rnd.nextInt(names.length)]);
				stat.setString(2, items[rnd.nextInt(items.length)]);
				stat.setInt(3, rnd.nextInt(10) + 1);
				
				stat.executeUpdate();
			}
			
			
			
			System.out.print("검색 수량 : ");
			int count = scan.nextInt();
			
			sql = "{ call proc_listbuy(?, ?) }";
			
			stat = conn.prepareCall(sql);
			stat.setInt(1, count);
			stat.registerOutParameter(2, OracleTypes.CURSOR);
			
			stat.executeQuery();
			
			ResultSet rs = (ResultSet)stat.getObject(2);
			
			System.out.println("[검색 결과]");
			while (rs.next()) {
				System.out.printf("%s\t%s\t%s\t%s\n"
											, rs.getString("name")
											, rs.getString("item")
											, rs.getString("qty")
											, rs.getString("regdate"));
			}
			
			
			stat.close();
			conn.close();
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
	}

	private static void m5() {
		
		//5. 전화번호 일부 입력 -> 직원 명단을 출력(이름, 부서, 직위, 전화번호)
		//번호 입력 : 123
		//proc_m5(?, ?)
		//011-234-5678 //O
		
		Connection conn = null;
		CallableStatement stat = null;
		
		try {
			
			conn = DBUtil.open();
			
			String sql = "{ call proc_m5(?, ?) }";
			stat = conn.prepareCall(sql);
			
			Scanner scan = new Scanner(System.in);
			System.out.print("번호 입력 : ");
			String word = scan.nextLine();
			
			stat.setString(1, word);
			stat.registerOutParameter(2, OracleTypes.CURSOR);
			
			stat.executeQuery();
			
			ResultSet rs = (ResultSet)stat.getObject(2);
			
			System.out.println("[검색 결과]");
			while (rs.next()) {
				System.out.printf("%s\t%s\t%s\t%s\n"
											, rs.getString("name")
											, rs.getString("buseo")
											, rs.getString("jikwi")
											, rs.getString("tel"));
			}
			
			rs.close();
			stat.close();
			conn.close();
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
	}

	private static void m4() {
		
		//4. 커서 반환
		
		Connection conn = null;
		CallableStatement stat = null;
		
		try {
			
			conn = DBUtil.open();
			
			String sql = "{ call proc_m4(?, ?) }";
			stat = conn.prepareCall(sql);
			
			stat.setString(1, "서울");
			stat.registerOutParameter(2, OracleTypes.CURSOR);
			
			stat.executeQuery();
			
			ResultSet rs = (ResultSet)stat.getObject(2);
			
			while (rs.next()) {
				System.out.println(rs.getString("name") + " - " + rs.getString("buseo"));
			}
			
			rs.close();
			stat.close();
			conn.close();
			
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
	}
	
	private static void m3() {
		
		//3. 반환값O
		Connection conn = null;
		CallableStatement stat = null;
		
		try {
			
			conn = DBUtil.open();
			
//			String sql = "{ call proc_m3(?) }";
//			stat = conn.prepareCall(sql);
//			
//			//out 매개변수 등록
//			stat.registerOutParameter(1, OracleTypes.INTEGER); //out 변수 생성
//			stat.executeQuery(); //out 변수 채우기
//			
//			//?
//			int count = stat.getInt(1);//out 변수값 접근
//			System.out.println(count);
						
//			String sql = "{ call proc_m3(?, ?, ?) }";
//			stat = conn.prepareCall(sql);
//			
//			stat.registerOutParameter(1, OracleTypes.VARCHAR); //pname
//			stat.registerOutParameter(2, OracleTypes.INTEGER); //page
//			stat.registerOutParameter(3, OracleTypes.VARCHAR); //ptel
//			
//			stat.executeQuery();
//			
//			System.out.println(stat.getString(1));
//			System.out.println(stat.getInt(2));
//			System.out.println(stat.getString(3));
			
			
			String sql = "{ call proc_m3(?, ?, ?, ?) }";
			stat = conn.prepareCall(sql);
			
			stat.setString(1, "68");
			
			stat.registerOutParameter(2, OracleTypes.VARCHAR); //pname
			stat.registerOutParameter(3, OracleTypes.INTEGER); //page
			stat.registerOutParameter(4, OracleTypes.VARCHAR); //ptel
			
			stat.executeQuery();
			
			System.out.println(stat.getString(2));
			System.out.println(stat.getInt(3));
			System.out.println(stat.getString(4));
			
			stat.close();
			conn.close();
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
	}

	private static void m2() {
		
		//2. 매개변수X, 반환값X
		Connection conn = null;
		CallableStatement stat = null;
		
		try {
			
			conn = DBUtil.open();
			
			String sql = "{ call proc_m2 }";
			stat = conn.prepareCall(sql);
			
			stat.executeUpdate();
			
			stat.close();
			conn.close();
			
			System.out.println("tbladdress 초기화 완료");
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
	}

	private static void m1() {
		
		//1. 반환값이 없는 SQL(프로시저)
		Connection conn = null;
		CallableStatement stat = null;
		
		try {
			
			conn = DBUtil.open();
			
			String sql = "{ call proc_m1(?, ?, ?, ?) }";
			
			stat = conn.prepareCall(sql);
			
			stat.setString(1, "아무개");
			stat.setInt(2, 25);
			stat.setString(3, "010-5555-6666");
			stat.setString(4, "서울시 강남구 대치동");
			
			stat.executeUpdate();
			
			System.out.println("완료");		
			
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
	}

}

























