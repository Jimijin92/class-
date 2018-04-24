package com.test.collection;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import com.test.io.Member;

public class Home29 {
	
	public static ArrayList<quest2> name2;
	
	static {
		
		name2 = new ArrayList<quest2>();
	}
	
	
	public static void main(String[] args) {
		
		//m1();
		m2();
		//m3();
		//m4();
		//m5();
	} //main
	
	
	/*
	 * 문제5.
		리소스] 일기.dat
		요구사항] 적혀있는 문장들을 역순으로 저장하시오.
		조건] 일기_역순 dat

		-------------------------------------------------

	 * 
	 */
	

	private static void m5() {
		
		try {
			
			String filepath = "D:\\파일_입출력_문제\\일기.dat";
			BufferedReader reader = new BufferedReader(new FileReader(filepath));
			String line = "";
			ArrayList<String> save = new ArrayList<String>();
			
			String text = "";
			
			
			while( (line = reader.readLine() ) != null) {
				
				
				save.add(line);
				
			} //while
			for(int i = save.size(); i > 0; i--) {
				text = text + save.get(i);
				
			} //for
				
			
			System.out.println(text);
			
			
			
			reader.close();
			
			
			
		} catch (Exception e) {
			System.out.println("m5 : " + e.toString());

		}
		
		
		
	}
	
	/*
	 * 문제4.
		요구사항] 임의의 숫자를 10개를 입력받아 파일에 저장하시오.
		입력] 숫자 : 5
        숫자 : 3
	    숫자 : 100
         숫자 :  22
	         ..
			
		파일저장]
		5
		3
		100
		22
			
		조건] 배열 or 컬렌션을 사용하지 말 것
			
		순수하게 String만 사용

	 * 
	 * 
	 */
	
	
	
	
	
	
	
	


	private static void m4() {
		
		Scanner scan = new Scanner(System.in);
		
		int count = 0;
		
		System.out.print("입력 :");
		
		while( count <10) {
			System.out.println("숫자 :");
			String input = scan.nextLine();
		
		
			try {
				BufferedWriter writer = new BufferedWriter(new FileWriter("D:\\파일_입출력_문제\\문제4.dat",true));   
			
				writer.write(input);
				writer.newLine();
				writer.close();
			
			
			
			} catch (Exception e) {
				System.out.println("m4 : " + e.toString());

			}
		
		
		count++;
		
		} //while
		
		System.out.println("숫자 10개를 입력받아 저장을 완료하였습니다.");
		
		
	} //m4
	
	
		
	/*
	 * 문제3.
			리소스] 이름수정.dat
			요구사항] '유재석'을 '메뚜기'로 수정하시오.
			조건] 이름수정_변환 dat
	 * 
	 */
	
	



	private static void m3() {
		
		
		try {
			
			String filepath = "D:\\파일_입출력_문제\\이름수정.dat";
			String line = "";
			String text  = "";
			BufferedReader reader = new BufferedReader(new FileReader(filepath));
			
			
			
			while((line =reader.readLine()) != null) {
				//System.out.println(line); 확인
				
				text = text + line;
			}
			
			text =text.replace("유재석", "메뚜기");
			//System.out.println(text);
			reader.close();
			
			BufferedWriter writer = new BufferedWriter(new FileWriter("D:\\파일_입출력_문제\\이름수정_변환.dat"));   
			
			writer.write(text);
			writer.close();
			
			System.out.println("끝났습니다.");
			
			
			
			
			
		} catch (Exception e) {
			System.out.println("m3 : " + e.toString());

		}
		
		
	}


	
/*
 * 
 * 문제2.
		리소스] 성적.dat
		파일형식] 홍길동, 47, 61,73
			   이름, 국,영,수
		조건] 합격 조건 : 3과목 평균 60점 이상
		      과락 조건 : 40점 미만
		
		결과] 홍길동
		      하하
		      정형돈
		
		사용] 컬렉션 사용해서..(Ex77 예제)
 * 
 */


	private static void m2() {
		
		
		
		
		try {
			
			
			String filepath ="D:\\파일_입출력_문제\\성적.dat" ;
			String line = "";
			BufferedReader reader = new BufferedReader(new FileReader(filepath));
			
			
			
			String name = "";
			int korean = 0;
			int english = 0;
			int math = 0;
			
			
			while( (line = reader.readLine() ) != null) {
				
				
				String [] result = line.split(",");  //, 나누기
			
				// 이름 result[0], 국어 result[1], 영어 result[2], 수학 result[3]
			
				//String을 int type으로 변환
				korean = Integer.parseInt(result[1]);
				english = Integer.parseInt(result[2]);
				math = Integer.parseInt(result[3]);
			
				if( 60 <= (korean + english +math)/3 && korean > 40 && english >40 && math > 40) {
						
					// System.out.println(result[0]);
					//name2.add(result[0]);
					 
				
					quest2 q = new quest2();
					q.setName(result[0]);
					q.setKorean(result[1]);
					q.setEng(result[2]);
					q.setMath(result[3]);
					name2.add(q);
							
					
				}  //if
			
			
		
			} //while
			
			//출력
			
		for ( quest2 q : name2) {
				System.out.println(q.getName());
			}
			
			reader.close(); //닫기
				
				
			
			
		} catch (Exception e) {
			System.out.println("load : " + e.toString());

		}
		
	} //m2
	
	
	
	
	/*
	 * 
	 * 문제1.
		리소스] 숫자.dat
		요구사항] 아라비안 숫자를 찾아서 한글을 바꾸시오. -> 복사본으로 저장하기
		
		조건] 0 -> 영, 1 -> 일, .. 9 -> 구
      	저장할 파일명 : 숫자_변환.dat
		indexOf, replace? 아무거나 사용

	 * 
	 */
	
	
	// txt = txt.replace("0", "영"); 버리면 불가능 버리지 말 것
	
	
	private static void m1() {
		
		load();
		
		
		
	}


	
	







	private static void load() {
		
		
		
		try {
			

			String filepath ="D:\\파일_입출력_문제\\숫자.dat" ;
			
			BufferedReader reader = new BufferedReader(new FileReader(filepath));
			
			String line ="";
			String text = "";
			
			
			
			
			while( (line = reader.readLine() ) != null) {
				
				
				text = text + line;
				
				
				

				
				
				
			}
			
			text = text.replace("0", "영");
			text = text.replace("1", "일");
			text = text.replace("2", "이");
			text = text.replace("3", "삼");
			text = text.replace("4", "사");
			text = text.replace("5", "오");
			text = text.replace("6", "육");
			text = text.replace("7", "칠");
			text = text.replace("8", "팔");
			text = text.replace("9", "구");
			
		
			//System.out.println(text);
			
			reader.close();
			
			BufferedWriter writer = new BufferedWriter(new FileWriter("D:\\파일_입출력_문제\\숫자111.dat"));   
			
			writer.write(text);
			writer.close();
			
			System.out.println("끝났습니다.");
			
			
		} catch (Exception e) {
			System.out.println("m1 : " + e.toString());

		}
		

		
		
		
		
		
		
		
	}

	
	
	
	
} //Home29
