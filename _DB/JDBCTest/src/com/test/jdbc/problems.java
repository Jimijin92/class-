package com.test.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Statement;
import java.util.Scanner;

import oracle.jdbc.internal.OracleTypes;

public class problems {

	public static void main(String[] args) {

//		q1();
//		q2();
		q5();

	}// main

	private static void q5() {
		
		Connection conn = null;
		CallableStatement stat = null;
		
		try {
			
			conn = DBUtil.open();
			
			String sql = "{call proc_distance(?,?,?,?,?,?)}";
			stat = conn.prepareCall(sql);
			
			stat.setInt(1, 3);	// 첫번쨰 지점
			stat.setInt(2, 2);	// 두번쨰 지점
			stat.registerOutParameter(3, OracleTypes.VARCHAR); //첫번째 지점 이름 반환
			stat.registerOutParameter(4, OracleTypes.VARCHAR); //두번째 지점 이름 반환
			stat.registerOutParameter(5, OracleTypes.DOUBLE);  //결과 값 반환
			stat.registerOutParameter(6, OracleTypes.INTEGER); //레코드 수 반환	
			
			stat.executeQuery();
			
			int max = stat.getInt(6);
			
			for(int i=1 ; i<=max ; i++) {
				for(int j=1 ; j<=max ; j++) {
					
					if(i == j) {
						continue;
					}
						
					stat.setInt(1, i);	// 첫번쨰 지점
					stat.setInt(2, j);	// 두번쨰 지점	
					stat.registerOutParameter(3, OracleTypes.VARCHAR); //첫번째 지점 이름 반환
					stat.registerOutParameter(4, OracleTypes.VARCHAR); //두번째 지점 이름 반환
					stat.registerOutParameter(5, OracleTypes.DOUBLE);  //결과 값 반환
					stat.registerOutParameter(6, OracleTypes.INTEGER); //레코드 수 반환	
					
					stat.executeQuery();					
									
					String start = stat.getString(3);
					String dest = stat.getString(4);
					double dis = stat.getDouble(5);
					
					System.out.printf("%s > %s (%.2fkm)\n", start, dest, dis);
				}
			}
			
			conn.close();
			stat.close();
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
	}//q5

	private static void q2() {
		
		Scanner scan = new Scanner(System.in);
		
		Connection conn = null;
		CallableStatement stat = null;
		
		try {
			
			conn = DBUtil.open();
			
			String sql = "{call proc_employees(?,?,?,?,?)}";
			stat = conn.prepareCall(sql);
			
			System.out.print("직원 번호 입력 : ");
			int sel = Integer.parseInt(scan.nextLine());
			
			stat.setInt(1, sel);
			stat.registerOutParameter(2, OracleTypes.VARCHAR);
			stat.registerOutParameter(3, OracleTypes.VARCHAR);
			stat.registerOutParameter(4, OracleTypes.VARCHAR);
			stat.registerOutParameter(5, OracleTypes.INTEGER);
			
			stat.executeQuery();
			
			
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
	}//q2

	private static void q1() {
		
		Scanner scan = new Scanner(System.in);
		boolean flag = true;

		Connection conn = null;
		CallableStatement stat = null;

		try {

			conn = DBUtil.open();
			
			String sql = "{call proc_auth(?,?)}";
			stat = conn.prepareCall(sql);			
			
			while(flag) {
				
				System.out.print("아이디 입력 : ");
				String id = scan.nextLine();
				
				stat.setString(1, id);
				stat.registerOutParameter(2, OracleTypes.INTEGER);
				
				stat.executeQuery();
				
				if(Integer.parseInt(stat.getString(2)) != 1) {
					System.out.println("사용이 가능합니다.");
					flag = false;
				} else {
					System.out.println("이미 사용중입니다.");
					flag = true;
				}
				
			}//while
			

		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
	}//q1()

}// pro






































