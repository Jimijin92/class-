package com.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

import com.common.Manager;

public class ComInManager {
	private static final String FILEMPATH = ".\\Data\\매니저 기본정보.dat";	
		
	private static ArrayList<Manager> Managerlist ;	
		//private static Scanner scan = new Scanner(System.in);
			//매니저 기본정보 넣은 리스트
	static {
		//scan = new Scanner(System.in);
		Managerlist = new ArrayList<Manager>();	//매니저 기본정보 넣은 리스트
		
		
	}


	public static ArrayList<Manager> getManagerlist() {
		return Managerlist;
	}
	
	
	public static void load() {
		try {
			Managerlist.clear();
			//관리자 기본정보.dat list에 옮기기
			BufferedReader reader = new BufferedReader(new FileReader(FILEMPATH));
			
			String line ="";
			
			while((line = reader.readLine()) != null) {
				
				//텍스트 1줄 = 1명 회원 = StudentAddInfor객체 1개
				String[] temp = line.split(",");
				
				Manager m = new Manager();
				
				m.setMJumin(temp[0]);
				m.setMId(temp[1]);
				m.setMPw(temp[2]);
				m.setMName(temp[3]);
				m.setMDivision(temp[4]);
				m.setMNumber(temp[5]);
	
	
				Managerlist.add(m);
			}
			
			reader.close();
			
		} catch (Exception e) {
			System.out.println("load : " + e.toString());
	
		}
		
	}



	
}
