package com.test.question;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class FileIO {

	public static void main(String[] args) {
		
		
		//p1();
		p10();
	
		
	}

	/*
		문제10

		리소스]출결.dat
		
		요구사항]각 직원별로 지각 회수, 조퇴 횟수를 카운트하시오
		
		조건] 출근 : 정각9시;
		      조퇴 : 정각6시;
		
		결과] 총 카운트
		
		추가] 날짜별 카운트

		
	*/

	private static void p10() {
	
		String path = "D:\\파일_입출력_문제\\출결.dat";
		
		try {
			
			BufferedReader reader = new BufferedReader(new FileReader(path));
			
			ArrayList<Employee> list = new ArrayList<Employee>();
			
			
			String line = "";
			
			while((line = reader.readLine()) != null) {	//ArrayList list 
			
				Employee emp = new Employee();
				
				
				String[] temp = line.split(",");
				
				emp.setDate(temp[0]);	//날짜 date
				emp.setName(temp[1]);	//이름 name
				emp.setCome(temp[2]);	//출근시간 come
				emp.setGo(temp[3]);		//퇴근시간 go
				
				
				
				list.add(emp);
				
				
			
				
			}//while
			
				
			
			
			reader.close();
			
			HashMap<String,Integer> dailyLateCount = new HashMap<String,Integer>(); 
			HashMap<String,Integer> dailyEarlyCount = new HashMap<String,Integer>();
			
			//------------------추가문제---------------------------
			
			HashMap<String,Integer> lateCount = new HashMap<String,Integer>();
			HashMap<String,Integer> earlyCount = new HashMap<String,Integer>();
			
			//=====================생성&누적==========================
			
			for(Employee e : list) {
				
				
				
				if(!lateCount.containsKey(e.getName())) {
					lateCount.put(e.getName(),0);
					earlyCount.put(e.getName(),0);
				}	//key 생성
				
				if(Integer.parseInt(e.getCome().substring(0,1)) >= 9) {
					lateCount.put(e.getName(), lateCount.get(e.getName())+1) ;
					
				}	//지각 count
				
				if(Integer.parseInt(e.getGo().substring(0,2))<18) {
					earlyCount.put(e.getName(), earlyCount.get(e.getName())+1);
				}
				
				//---------------------추가문제------------------------
				
				if(!dailyLateCount.containsKey(e.getDate())) {
					dailyLateCount.put(e.getDate(), 0);
					dailyEarlyCount.put(e.getDate(), 0);
					
				}
				
				if(Integer.parseInt(e.getCome().substring(0,1)) >= 9) {
					dailyLateCount.put(e.getDate(), dailyLateCount.get(e.getDate())+1) ;
					
				}	//지각 count
				
				if(Integer.parseInt(e.getGo().substring(0,2))<18) {
					dailyEarlyCount.put(e.getDate(), dailyEarlyCount.get(e.getDate())+1);
				}
				
				
				
				
				
			}
			
			//======================출력=========================
			
			
			Set<String> set1 = lateCount.keySet();	//직원이름
			
			
//			Set<String> set2 = dailyLateCount.keySet();	//날짜
			
			
			
			Iterator<String> iter1 = set1.iterator();
			
			
//			Iterator<String> iter2 = set2.iterator();
			
			
			
			while(iter1.hasNext()) {
				String key = iter1.next();
				
				System.out.printf("%s\t지각 : %s회\n\t조퇴 :%s회\n",key,lateCount.get(key),earlyCount.get(key));
			}
			
//			while(iter2.hasNext()) {
//				String key = iter2.next();
//				
//				System.out.printf("%s\t지각 : %s회\n\t\t조퇴 : %s회\n\n",key,dailyLateCount.get(key),dailyEarlyCount.get(key));
//			}
			
			
			
		
			
		} catch (Exception e) {
			System.out.println("p10 : " + e.toString());
		}
		
		
	}

	
	
	
	
	
	
	private static void p1() {
		
		String path = "D:\\파일_입출력_문제\\숫자.dat";
		String newPath = "D:\\파일_입출력_문제\\숫자_변환.dat";
		
		//ArrayList<String> lines = new ArrayList<String>();
		
		
		
		try {
			BufferedReader reader = new BufferedReader(new FileReader(path));
			BufferedWriter writer = new BufferedWriter(new FileWriter(newPath));

			
			
			String line = "";
			
			
			while((line = reader.readLine())!=null) {
				
				line = line.replace("0","영");
				line = line.replace("1","일");
				line = line.replace("2","이");
				line = line.replace("3","삼");
				line = line.replace("4","사");
				line = line.replace("5","오");
				line = line.replace("6","육");
				line = line.replace("7","칠");
				line = line.replace("8","팔");
				line = line.replace("9","구");
				line = line.replace("10","십");
				
				
				writer.write(line);
				writer.newLine();
				
			}
			
			
			
			writer.close();
			
			
			
			
			
			
		} catch (Exception e) {
			System.out.println("p1 : " + e.toString());
		}
		
		
		
	}
}
