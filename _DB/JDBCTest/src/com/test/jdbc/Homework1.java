package com.test.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import oracle.jdbc.internal.OracleTypes;

public class Homework1 {
	
	private static Scanner scan;
	
	static {
		scan = new Scanner(System.in);
	}

	public static void main(String[] args) {
		
		//m1();
		//m2();
		
		m4();
	}
/*
	문제2.
	<<요구사항>> 직원 번호를 입력하면 조직도를 출력하시오.

	<<입출력>>
	직원 번호 입력 : 101
	Neena Kochhar(515.123.4568)
	        ▷ Nancy Greenberg(515.124.4569)
	                ▷ Daniel Faviet(515.124.4169)
	                ▷ John Chen(515.124.4269)
	                ▷ Ismael Sciarra(515.124.4369)
	                ▷ Jose Manuel Urman(515.124.4469)
	                ▷ Luis Popp(515.124.4567)
	        ▷ Jennifer Whalen(515.123.4444)
	        ▷ Susan Mavris(515.123.7777)
	        ▷ Hermann Baer(515.123.8888)
	        ▷ Shelley Higgins(515.123.8080)
	                ▷ William Gietz(515.123.8181)
*/

	private static void m2() {

		Connection conn = null;
		CallableStatement stat = null;
		
		try {
			
			conn = DBUtil.open();
			
			String sql = "{ call proc_employees(?,?) }";
			stat = conn.prepareCall(sql);
			
			System.out.print("직원 번호 입력 : ");
			int num = scan.nextInt();
			
			stat.setInt(1, num);
			stat.registerOutParameter(2, OracleTypes.CURSOR);
			stat.executeQuery();
			
			ResultSet rs = (ResultSet)stat.getObject(2);
			
			while (rs.next()) {
				System.out.println(rs.getString("name"));
			}
			
			rs.close();
			stat.close();
			conn.close();
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
	}
//	<<조건>>
//	1. 부서별 출력
//	2. 부서내 직원명 오름차순으로 연결
	
//	<<입출력>>
//	[개발부]
//	김신애 ▷ 엄용수 ▷ 이기상 ▷ 이기자 ▷ 이미성 ▷ 이상헌 ▷ 이성길 ▷ 이순애 ▷ 임수봉 ▷ 장인철 ▷ 정영희 ▷ 채정희 ▷ 홍길남 ▷ 황진이 (종료)
//	[기획부]
//	권옥경 ▷ 김말자 ▷ 김신제 ▷ 이영숙 ▷ 이정석 ▷ 지재환 ▷ 홍길동 (종료)
//	[영업부]
//	고순정 ▷ 권영미 ▷ 김미나 ▷ 김숙남 ▷ 김인수 ▷ 김정훈 ▷ 김종서 ▷ 산마루 ▷ 손인수 ▷ 양미옥 ▷ 우재옥 ▷ 유관순 ▷ 전용재 ▷ 정한나 ▷ 지수환 ▷ 홍원신 (종료)
//	[인사부]
//	나윤균 ▷ 박문수 ▷ 박세열 ▷ 이남신 (종료)
//	[자재부]
//	김싱식 ▷ 문길수 ▷ 심심해 ▷ 유영희 ▷ 이미경 ▷ 이재영 (종료)
//	[총무부]
//	김말숙 ▷ 김영길 ▷ 이순신 ▷ 이현숙 ▷ 정정해 ▷ 한석봉 ▷ 허경운 (종료)
//	[홍보부]
//	김영년 ▷ 이미인 ▷ 정상호 ▷ 정한국 ▷ 조미숙 ▷ 최석규 (종료)
	

	private static void m4() {
		
		Connection conn = null;
		CallableStatement stat = null;
		
		try {
			
			conn = DBUtil.open();
			
			String sql = "{ call proc_mergency(?,?)} ";
			stat = conn.prepareCall(sql);
			
			System.out.print("부서 입력 : ");
			String buseo = scan.nextLine();
			
			stat.setString(1, buseo);
			stat.registerOutParameter(2, OracleTypes.CURSOR);
			stat.executeQuery();
			
			ResultSet rs = (ResultSet)stat.getObject(2);
			
			System.out.println();
			System.out.printf("[%s]\n", buseo);
			
			while (rs.next()) {
				System.out.print(rs.getString("name") + " ▷ ");
			}
			System.out.println("(종료)");
			
			
			rs.close();
			stat.close();
			conn.close();
			
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
	}

	private static void m1() {

		
		Connection conn = null;
		CallableStatement stat = null;
		
		
		try {
			
			conn = DBUtil.open();
			
			System.out.print("아이디 입력 : ");
			String id = scan.nextLine();
			
			String sql = "{ call proc_auth(?,?) }";
			stat = conn.prepareCall(sql);
			
			stat.setString(1, id);
			
			stat.registerOutParameter(2, OracleTypes.INTEGER);
			
			stat.executeQuery();
			
			int result = stat.getInt(2);
			
				if (result == 0 )  {
					System.out.println("사용 가능합니다.");
				} else {
					System.out.println("이미 사용 중입니다.");
				}
			
			
			
			stat.close();
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
		
		
		
		
		
	}
	
}
