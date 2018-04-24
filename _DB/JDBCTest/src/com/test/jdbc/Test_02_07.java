package com.test.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import oracle.jdbc.OracleTypes;

public class Test_02_07 {
	public static void main(String[] args) {
		
		//q1();
		q2();
		
		
		
		
	}

	private static void q1() {

		
		
		
	}

	private static void q2() {

		Connection conn = null;
		CallableStatement cStat = null; //프로시저 호출전용
		Scanner scan = new Scanner(System.in);
		System.out.println("조직도");
		System.out.print("Employees Number : ");
		String en = scan.nextLine();
		
		try {
			
			conn = DBUtil.open();
			String sql = "{call proc_employees(?,?)}";
			cStat = conn.prepareCall(sql);
			
			cStat.setString(1, en);
			cStat.registerOutParameter(2, OracleTypes.CURSOR);
			
			cStat.executeQuery();
			
			ResultSet rs = (ResultSet)cStat.getObject(2);//커서로 받아온 값을 형변환
			
			while (rs.next()) {
				System.out.println(rs.getString("subject"));
			}
			
			rs.close();
			cStat.close();
			conn.close();
			
			
			
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
	}
}
