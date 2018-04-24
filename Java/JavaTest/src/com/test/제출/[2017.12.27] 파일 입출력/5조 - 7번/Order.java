package com.test.question;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

		/*
		문제7.
		리소스] 검색_회원.dat, 검색_주문.dat
		요구사항] 이름을 검색 -> 주문내역을 출력하시오.
		입력] 회원명 : 홍길동
		출력]
		구매내역
		[번호]	[이름]	[상품명]		[개수]	[배송지]
		3		홍길동	마우스		3		서울시 강동구 길동
		사용] 컬렉션 사용
		 */
public class Order {
	private static ArrayList<OrderMember> list1;
	private static ArrayList<OrderList> list2;
	
	static {
		list1 = new ArrayList<OrderMember>();
		list2 = new ArrayList<OrderList>();
		
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String name = "";
		String num = "";
		String address = "";
		
		load();
		
		System.out.print("회원명 : ");
		name = scan.nextLine();
		System.out.println("[번호]\t[이름]\t[상품명]\t[개수]\t[배송지]");
		for(OrderMember OM : list1) {
			if(OM.getname().equals(name)) {
				num = OM.getMemberNum();
				address = OM.getAddress();
				break;
			}
		}

		for(OrderList OL : list2) {
			if(OL.getMemberNum().equals(num)) {
				System.out.printf("%s\t%s\t%s\t%s\t%s\n",OL.getNum(),name,OL.getGoodsName(),OL.getCount(),address);
			}
		}
		
	}//main
	
	private static void load() {
		try {
			
			BufferedReader reader1 = new BufferedReader(new FileReader("D:\\파일_입출력_문제\\검색_회원.dat"));
			BufferedReader reader2 = new BufferedReader(new FileReader("D:\\파일_입출력_문제\\검색_주문.dat"));
			
			String line = "";
			
			while ((line = reader1.readLine()) != null) {
				
				String[] temp = line.split(",");
				
				OrderMember OM = new OrderMember();
				OM.setMemberNum(temp[0]);
				OM.setname(temp[1]);
				OM.setAddress(temp[2]);
				
				list1.add(OM);
			}
			reader1.close();
			
			line = "";
			while ((line = reader2.readLine()) != null) {
				
				String[] temp = line.split(",");
				
				OrderList OL = new OrderList();
				OL.setNum(temp[0]);
				OL.setGoodsName(temp[1]);
				OL.setCount(temp[2]);
				OL.setMemberNum(temp[3]);

				list2.add(OL);
			}
			reader2.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	
}//Order



