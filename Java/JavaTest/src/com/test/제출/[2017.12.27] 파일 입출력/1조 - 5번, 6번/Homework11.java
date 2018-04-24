package com.test.question;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;


public class Homework11 {

	private static Scanner scan;
	private static ArrayList<Data> list;
	static {
		scan = new Scanner(System.in);
		list = new ArrayList<Data>();
	}
	
	public static void main(String[] args) {
		m6();
		//m3();
		//m2();
		//m1();
		
	
	}




	/*
	문제6. 1조
	리소스] 단일검색.dat
	요구사항] 이름을 검색-> 해당 회원의 모든 정보를 출력하시오.
	입력] 이름 : 홍길동
	출력]
	번호 : 33
	이름 : 홍길동
	주소 : 서울시 강남구 역삼동
	전화 : 010-1234-5678
	*/
	private static void m6() {
	
		
		try {
				
			
			BufferedReader reader = new BufferedReader(new FileReader("D:\\파일_입출력_문제\\단일검색.dat"));
			
			String line = null;
			
			while ((line = reader.readLine()) != null) {
				
				String[] result = line.split(","); 
					
				Data d = new Data(); 
					
				d.setNum(result[0]);
				d.setName(result[1]);
				d.setAddress(result[2]);
				d.setTel(result[3]);
				
				list.add(d);
			}
				reader.close();

				System.out.print("이름 : ");
				String name = scan.nextLine();	
				
				for (int i = 0; i < list.size(); i++) {
					String numList = list.get(i).getNum();
					String nameList = list.get(i).getName();
					String addList = list.get(i).getAddress();
					String telList = list.get(i).getTel();
					
					if (nameList.equals(name)) {
						System.out.println("번호 : " + numList);					
						System.out.println("이름 : " + nameList);					
						System.out.println("주소 : " + addList);					
						System.out.println("전화 :" + telList);
						System.out.println();
					}
					
				}
			
			//황명게
			
		} catch (Exception e) {
			System.out.println("m6 : " + e.toString());
		}
		
	}//m6
	
	
	
//	문제3. - 문제1과 동일
//	리소스] 이름수정.dat
//	요구사항] '유재석'을 '메뚜기'로 수정하시오.
//	조건] 이름수정_변환.dat

	private static void m3() {

		String path = "D:\\파일_입출력_문제\\이름수정.dat";
		
		try {
			
			BufferedReader reader = new BufferedReader(new FileReader(path));
			
			
			
			
			
			
			
		} catch (Exception e) {
			System.out.println("m3 : " + e.toString());
		}
		
	}//m3
		
//	문제2.
//	리소스] 성적.dat
//	파일형식] 홍길동,47,61,73
//			이름,국,영,수
//	요구사항] 합격자 명단을 출력하시오.
//	조건] 합격 조건 : 3과목 평균 60점 이상
//		 과락 조건 : 40점 미만
//	결과] 홍길동
//		  하하
//		  정형돈
//	사용] 컬렉션 사용해서..(Ex77 예제)
	
	private static void m2() {

		String path = "D:\\파일_입출력_문제\\성적.dat";
		
		try {
			
			BufferedReader reader = new BufferedReader(new FileReader(path));
			
			String line = "";
			
			while  ((line = reader.readLine())!= null) {
				
				System.out.println(line);
				String[] result = line.split(",");
				
				
			}
			
			
		} catch (Exception e) {
			System.out.println("m2 : " + e.toString());
		}
		
		
	}//m2
	
	/*	문제1.
	리소스] 숫자.dat
	요구사항] 아리비안 숫자를 찾아서 한글로 바꾸시오. -> 복사본으로 저장하기
	조건] 0 -> 영, 1-> 일,...... 9 -> 구
		저장할 파일명 : 숫자_변환.dat*/
	
	private static void m1() {
		
		String path = "D:\\파일_입출력_문제\\숫자.dat";
		
		
		String file = "";
		
		try {
			
			BufferedReader reader = new BufferedReader(new FileReader(path));

			String line = null;
			
			while ((line = reader.readLine())!= null) {
				
				file = line.replace("0", "영");
				file = file.replace("1", "일");
				file = file.replace("2", "이");
				file = file.replace("3", "삼");
				file = file.replace("4", "사");
				file = file.replace("5", "오");
				file = file.replace("6", "육");
				file = file.replace("7", "칠");
				file = file.replace("8", "팔");
				file = file.replace("9", "구");
				
				System.out.println(file);
			}
			
		
			
			
			
			
			
			
		} catch (Exception e) {
			System.out.println("m1 : " + e.toString());
		}
		
		
	}//m1
}//FileTest
