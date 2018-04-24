package com.test.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Scanner;

import oracle.jdbc.OracleTypes;

public class Home01 {

	/*
	 문제3.
<<요구사항>> 카테고리 탐색을 구현하시오.

<<입출력>>
[대분류]
1. 전자제품
2. 식음료
3. 운동용품
선택 : 1

[중분류]
1. 모니터
2. 마우스
3. 키보드
선택 : 1

[소분류]
1. 소형
2. 중형
3. 대형
선택 : 3

[상품]
7. LG300(수량 : 72개)
8. Dell300(수량 : 23개)
9. HP300(수량 : 22개)
	*/
	private static Connection conn;
	private static CallableStatement stat;
	private static Scanner scan;
	private static ArrayList<String> list;
	
	static {
		conn = null;
		stat = null;
		scan = new Scanner(System.in);
		list = new ArrayList<String>();
	}
	
	public static void main(String[] args) {
		
		try {
			
			conn = DBUtil.open();
			
			//카데고리 검색 시작
			big();
			
			System.out.println("프로그램 종료");
			
			scan.close();
			stat.close();
			conn.close();
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
	}

	private static void big() {

		try {
			
			String sql = "{ call proc_list_big_category(?) }";
			stat = conn.prepareCall(sql);
			
			stat.registerOutParameter(1, OracleTypes.CURSOR);
			
			//반환값있는애 선택
			stat.executeQuery();
			
			//커서담기
			ResultSet rs = (ResultSet)stat.getObject(1);
			
			System.out.println("[대분류]");
			
			while(rs.next()) {
				System.out.println(rs.getInt("seq") + ". " + rs.getString("name"));
			}
			
			System.out.print("선택 : ");
			String sel = scan.nextLine();
			System.out.println();
			
			rs.close();
			
			middle(sel);
				
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
	}

	private static void middle(String sel) {

		try {
		
			String sql = "{ call proc_list_middle_category(?, ?, ?) }";
			stat = conn.prepareCall(sql);
			
			stat.setString(1, sel);
			stat.registerOutParameter(2, OracleTypes.CURSOR);
			stat.registerOutParameter(3, OracleTypes.NUMBER);
			
			stat.executeQuery();
			
			ResultSet rs = (ResultSet)stat.getObject(2);
			int result = stat.getInt(3);
			
			if (result > 0) { //값이 있으면
				
				System.out.println("[중분류]");
				
				while(rs.next()) {
					list.add(rs.getInt("seq") + "");
					System.out.println(rs.getInt("seq") + ". " + rs.getString("name"));
				}
				
				System.out.print("선택 : ");
				sel = scan.nextLine();
				System.out.println();
				
				rs.close();
				
				if(list.contains(sel)) small(sel);
				
			} else { //값이 없으면
				System.out.println("해당하는 값이 없습니다.");
			}
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
	} //middle

	private static void small(String sel) {
		
		try {
			
			String sql = " call proc_list_small_category(?, ?, ?) ";
			stat = conn.prepareCall(sql);
			
			stat.setString(1, sel);
			stat.registerOutParameter(2, OracleTypes.CURSOR);
			stat.registerOutParameter(3, OracleTypes.NUMBER);
			
			stat.executeQuery();
			
			ResultSet rs = (ResultSet)stat.getObject(2);
			int result = stat.getInt(3);
			
			if (result > 0) { //값이 있으면
				
				System.out.println("[소분류]");
				
				while(rs.next()) {
					list.add(rs.getInt("seq") + "");
					System.out.println(rs.getInt("seq") + ". " + rs.getString("name"));
				}
				
				System.out.print("선택 : ");
				sel = scan.nextLine();
				System.out.println();
				
				rs.close();
				
				if(list.contains(sel)) product(sel);
				
			} else { //값이 없으면
				System.out.println("해당하는 값이 없습니다.");
			}
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
	} //small

	private static void product(String sel) {

		try {
			
			String sql = " call proc_list_product(?, ?, ?) ";
			stat = conn.prepareCall(sql);
			
			stat.setString(1, sel);
			stat.registerOutParameter(2, OracleTypes.CURSOR);
			stat.registerOutParameter(3, OracleTypes.NUMBER);
			
			stat.executeQuery();
			
			ResultSet rs = (ResultSet)stat.getObject(2);
			int result = stat.getInt(3);
			
			if (result > 0) { //값이 있으면
				
				System.out.println("[상품]");
				
				while(rs.next()) {
					list.add(rs.getInt("seq") + "");
					System.out.println(String.format("%d. %s(수량 : %d개)"
														,rs.getInt("seq")
														,rs.getString("name")
														,rs.getInt("qty")));
				}
				
				rs.close();
				
			} else { //값이 없으면
				System.out.println("해당하는 값이 없습니다.");
			}
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
	} //product
}
