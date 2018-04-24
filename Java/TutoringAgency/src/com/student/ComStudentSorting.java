package com.student;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import com.common.Teacher;

public class ComStudentSorting {	//필터링된 선생님 중에 선택 후 선택한 선생님 정보 Detail클래스로 보내 상세 정보 가져오기
	private static ComStudenFilteredDetail detail;
	private static ArrayList<Teacher> t;  
	private static String primary = ""; //보고싶은 선생님 선택하면 그 선생님 구분할수 있는 구분자 얻어오기
	static {
		t = new  ArrayList<Teacher>();
		detail = new ComStudenFilteredDetail();
	}

	
	//조건 검색 후 출력된 선생님들을 정렬.dat에 임시 저장하고 출력
	//새로이 생성된 선생님의 번호(정렬번호)를 선택하면 FilteredDetail클래스로 이동!
	
	
	public static void sort() {
		String path = ".\\Data\\정렬.dat";
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(path));
			
			t= ComStudentSearchList.getList();
			
			System.out.print("[번호]\t[이름]\t[성별]\t	 [학교/전공]]\t\t  [지도과목]\t     [경력]\t [지역]\t\t[회당가격]\t[평점]\n");
			
			for(int i=0; i<t.size(); i++) {
			
				int one = Integer.parseInt(t.get(i).getTStar().get("1점"));
				int two = Integer.parseInt(t.get(i).getTStar().get("2점"));
				int three = Integer.parseInt(t.get(i).getTStar().get("3점"));
				int four = Integer.parseInt(t.get(i).getTStar().get("4점"));
				int five = Integer.parseInt(t.get(i).getTStar().get("5점"));
				
				int total = one + two + three + four + five;
				double point = (one + (two*2) + (three*3) + (four*4) + (five*5))/total;
				
				//String[] temp = app.getDays();
				String line = String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s"
						,i+1+"",t.get(i).getTJumin(),t.get(i).getTId(),t.get(i).getTName()
						,t.get(i).getTGender(),t.get(i).getTAge(),t.get(i).getTAddress(),t.get(i).getTTel()
						,t.get(i).getTUniv(),t.get(i).getTDepart(),t.get(i).getTGrade()
						,t.get(i).getTCareer(),t.get(i).getTZone()[0],t.get(i).getTZone()[1],t.get(i).getTZone()[2]
						,t.get(i).getTTarget(),t.get(i).getTPrice()
						,t.get(i).getTSubject()[0],t.get(i).getTSubject()[1]
						,point+""//별점
						,t.get(i).getTDivision(),t.get(i).getTNumber());
				writer.write(line);
				writer.newLine();
				
				System.out.printf("%d\t%s\t%s\t%7s/%7s\t%5s/%s\t%10s\t%s\t%s만원\t\t%.1f\t\n"
									,i+1
									,t.get(i).getTName()
									,t.get(i).getTGender()
									,t.get(i).getTUniv(),t.get(i).getTDepart()
									,t.get(i).getTSubject()[0],t.get(i).getTSubject()[1]
									,t.get(i).getTCareer()
									,t.get(i).getTAddress()
									,t.get(i).getTPrice()
									,point);
				
				
					
			}
			writer.close();
	
			Scanner scan = new Scanner(System.in);
			System.out.println();
			
			System.out.print("자세히 보고싶은 선생님 번호를 입력해 주세요 : ");
			
			String select = scan.nextLine();
			int sel = Integer.parseInt(select);
			
			String primary = ""; //보고싶은 선생님 선택하면 그 선생님 구분할수 있는 구분자 얻어오기
			
			for(int i=0; i<t.size(); i++) {//t 는 선생님 전체 목록
				
				if(i+1 == sel) {	//필터링된 선생님들 목록에서 ( 1부터 시작해서 i+1)
					
					primary =  t.get(i).getTNumber();	//그 선생님의 고유 번호만 가지고 저장.
					break;
					
				}
				
			}
			
			detail.detail(primary); //고유 번호만 쏴줌
			
			
		} catch (Exception e) {
			System.out.println("sort : " + e.toString());
		}
		
		
		
	}//sort
	
	
	
	
	
	
	
	
}
