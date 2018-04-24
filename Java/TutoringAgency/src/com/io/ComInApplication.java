package com.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

import com.common.Application;
import com.common.Manager;

public class ComInApplication {
	private static final String FILEAPPLYPATH = ".\\Data\\신청현황.dat";	
	
	private static ArrayList<Application> Applicationist ;	
		//private static Scanner scan = new Scanner(System.in);

	static {
		//scan = new Scanner(System.in);
		Applicationist = new ArrayList<Application>();	//신청현황 넣은 리스트
	}



	
	public static ArrayList<Application> getApplicationist() {
		return Applicationist;
	}




	public static void load() {
		try {
			
			Applicationist.clear();
			
			
			//신청현황.dat list에 옮기기
			BufferedReader reader = new BufferedReader(new FileReader(FILEAPPLYPATH));
			
			String line ="";
			
			while((line = reader.readLine()) != null) {
				
				//텍스트 1줄 = 1명 회원 = StudentAddInfor객체 1개
				String[] temp = line.split(",");
				
				Application apply = new Application();
				
				//요일
				String[] days = new String[5];
				days[0] = temp[9];
				days[1] = temp[10];
				days[2] = temp[11];
				days[3] = temp[12];
				days[4] = temp[13];
				
				apply.setHopeclassNumber(temp[0]);
				apply.setTNumber(temp[1]);
				apply.setSNumber(temp[2]);
				apply.setHopestartDay(temp[3]);
				apply.setHopesubject(temp[4]);
				apply.setHopestartTime(temp[5]);
				apply.setHopetime(temp[6]);
				apply.setHopeprice(temp[7]);
				apply.setState(temp[8]);
				apply.setDays(days);
				apply.setAsk(temp[14]);
	
	
				Applicationist.add(apply);
			}
			
			reader.close();
			
		} catch (Exception e) {
			System.out.println("loadComInApplication : " + e.toString());
	
		}
		
	}
}
