package com.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

import com.common.Manager;
import com.common.Schedule;

public class ComInSchedule {
	private static final String FILESCHEDULEPATH = ".\\Data\\스케줄.dat";	
	
	private static ArrayList<Schedule> Schedulelist ;	
		//private static Scanner scan = new Scanner(System.in);

	static {
		//scan = new Scanner(System.in);
		Schedulelist = new ArrayList<Schedule>();	//스케줄 기본정보 넣은 리스트
		
		
	}
	public static ArrayList<Schedule> getSchedulelist() {
		return Schedulelist;
	}

	public static void load() {
		try {
			Schedulelist.clear();
			//스케줄.dat list에 옮기기
			BufferedReader reader = new BufferedReader(new FileReader(FILESCHEDULEPATH));
			
			String line ="";
			
			while((line = reader.readLine()) != null) {
				
				//텍스트 1줄 = 1명 회원 = StudentAddInfor객체 1개
				String[] temp = line.split(",");
				
				Schedule sch = new Schedule();

				//총 취소 횟수
				temp[10] = Integer.parseInt(temp[8])+Integer.parseInt(temp[9])+"";
				
				//요일
				String[] days = new String[5];
				days[0] = temp[12];
				days[1] = temp[13];
				days[2] = temp[14];
				days[3] = temp[15];
				days[4] = temp[16];
				
				sch.setClassNumber(temp[0]);
				sch.setTNumber(temp[1]);
				sch.setSNumber(temp[2]);
				sch.setStartDay(temp[3]);
				sch.setSubject(temp[4]);
				sch.setPrice(temp[5]);
				sch.setStartTime(temp[6]);
				sch.setTime(temp[7]);
				sch.setTcancel(temp[8]);
				sch.setScancel(temp[9]);
				sch.setTotalCancel(temp[10]);
				sch.setState(temp[11]);
				sch.setDays(days);
				sch.setStar(temp[17]);;
				
				Schedulelist.add(sch);
			}
			
			reader.close();
			
		} catch (Exception e) {
			System.out.println("load : " + e.toString());
	
		}
		
	}
	
	
	
}
