package com.test.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import oracle.jdbc.OracleTypes;

public class Practice {

	public static void main(String[] args) {
		
		m1();
		//m2();
		
	}

	private static void m2() {

		Scanner scan = new Scanner(System.in);
		
		try {
			Connection conn = DBUtil.open();
			String sql = "{call proc_employees(?,?)}";
			CallableStatement stat = conn.prepareCall(sql);
			
			System.out.println("직원번호를 입력해주세요");
			int empNum = scan.nextInt(); scan.skip("\r\n");
			
			stat.setInt(1, empNum);
			stat.registerOutParameter(2,OracleTypes.CURSOR);
			
			stat.executeQuery();
			
			ResultSet rs = (ResultSet) stat.getObject(2);
			
			while(rs.next()) {
				System.out.println(rs.getString("name")+ "-" + rs.getString("phone_number"));
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
	}

	private static void m1() {
		
		Connection conn = null;
		CallableStatement stat = null;
		Scanner scan = new Scanner(System.in);
		
		
		try {

			Boolean loop = true;
			
			while(loop) {
			System.out.print("id 입력 : ");
			String id = scan.nextLine();
			conn = DBUtil.open();
			
			String sql = "{call proc_auth(?,?)}";

			stat = conn.prepareCall(sql);
			
			stat.setString(1, id);
			stat.registerOutParameter(2, OracleTypes.NUMBER);
			stat.executeQuery();
			
			int result = stat.getInt(2);
			
			
			if(result == 1) {
				System.out.println("id 등록 완료");
				loop = false;
				
			}else {
				
				System.out.println("이미 사용중인 아이디 입니다.");
			}
			
			}
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
			
	}
	
}
