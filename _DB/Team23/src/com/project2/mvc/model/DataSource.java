package com.project2.mvc.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;


public class DataSource {
	
	//쿼리추가는 txt 파일에 직접입력하기 
	
	//*.dat 파일의 위치 
	// 	- com.test.mvc.member.model.sql > member.dat
	// 	- com.test.mvc.memo.model.sql > memo.dat
	private BufferedReader reader;
	private ArrayList<String> path;
	private HashMap<String,String> sql; //쿼리 저장
	
	
	
	public DataSource() {
		//SQL이 적혀있는 파일들을 관리하는 경로들...
		path = new ArrayList<String>();
		path.add(".\\src\\com\\project2\\mvc\\manager\\model\\sql"); //쿼리가 들어있는 경로 
		path.add(".\\src\\com\\project2\\mvc\\teacher\\model\\sql");
		path.add(".\\src\\com\\project2\\mvc\\student\\model\\sql");
		path.add(".\\src\\com\\project2\\mvc\\auth\\model\\sql");
		
		
		sql = new HashMap<String,String>();
		
		
		//*.dat -> (SQL) ->컬렉션에 복사 
		load();
	
	}
	
	
	private void load() {
		
		
		for (String strPath : path) {
			
		
			File dir = new File(strPath);
	
			File[] files = dir.listFiles(); //*.dat 파일들...

			for (File file : files) {
				if(file.getName().endsWith(".mapper")) {
					
					try {//예외처리해야 에러X
						reader = new BufferedReader(new FileReader(file));
						String line = "";
						while ((line = reader.readLine()) != null) {
							
//							System.out.println(line);
							int index = line.indexOf("|");
							
							sql.put(line.substring(0, index), line.substring(index+1));
							
						
						}
						
						reader.close();
						
					} catch (Exception e) {
						
//						e.printStackTrace();
						System.out.println(e.toString());
					}
				}
				
//				System.out.println(file.getName());
				
				
			}
			
			
		}
		

	}
	
	
	public String get(String key) { //key를 주면 value(쿼리)를 돌려주는 메소드 
		
		if(sql.containsKey(key)) {
			
			return sql.get(key);
			
		}else {
			
			return null;
			
		}
		
		
		
	}
	
	
	
	
	
	

}
