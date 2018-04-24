package com.register;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

import com.common.Manager;
import com.common.Student;
import com.io.ComInManager;

public class ComRegisterManager {
	
	private static final String FILEMPATH = ".\\Data\\매니저 기본정보.dat";
	private static Scanner scan;
	private static ArrayList<Manager> ManagerList ;
	private static Manager temp ;
	private static ComRegisterMenu registList;
	
	
	static {
		
		scan = new Scanner(System.in);
		ManagerList = new ArrayList<Manager>();
		temp = new Manager();
		registList = new ComRegisterMenu();
		
	}


	//940611-2304516,wlals369,rmakdks00,김지민,C,2
	
	static int registManager() {
		
		ComInManager.load();
		
		boolean loop = true;
		
		while(loop) {
				
			System.out.println();
			System.out.println("====================");
			System.out.println("     회 원 가 입");
			System.out.println("====================");
			System.out.println("1. 주민번호");
			System.out.println("2. ID");
			System.out.println("3. PW");
			System.out.println("4. 이름");
			System.out.println("5. 대상 선택화면으로 돌아가기");
			System.out.println("0. 메인으로 돌아가기");
			
			System.out.print("선택 : ");
			String sel = scan.nextLine();
			
			
			if(sel.equals("1")) jumin();			//주민번호
			else if(sel.equals("2")) id();			//ID
			else if(sel.equals("3")) password();	//PW
			else if(sel.equals("4")) name();		//이름	
			else if(sel.equals("5")) registList.register();	//대상 선택화면
			else if(sel.equals("0")) return 1;			//메인 	
			
		}
		return 0;
	}

	private static void jumin() {
		
		Calendar c = Calendar.getInstance()	;
		int thisYear = c.get(Calendar.YEAR);
		
		System.out.println();
		System.out.println("========================");
		System.out.println("      주민번호 입력 ");
		System.out.println("========================");
		
		System.out.print("주민번호 : ");
		String jum = scan.nextLine();
		boolean flag ;
		
		
		//1. 주민에 '-' 넣어주기
		if( !(jum.contains("-")) ) {
			String jumFir = jum.substring(0, 6);	//주민 앞자리
			String jumSec = jum.substring(6);		//주민 뒷자리
			
			jum = jumFir+"-"+jumSec;
			
		}else {
			
		}

		flag = jumincheck(jum);
		
			
		//주민번호 저장	
		if(flag) {
			System.out.println("유효한 주민번호입니다.");
			temp.setMJumin(jum);
		}else {
			System.out.println("유효하지 않은 주민번호입니다.");
			jumin();
		}
	
			
	
		
		
	}//jumin

	

	private static boolean jumincheck(String jum) {

	
		//1. 주민번호 길이 검사
		if( (jum.length()<0) || (jum.length()>14) ) {
			return false;
			
		}else {
		
		//2. 주민번호 유효성  검사	
		int number = 0;
		int sum = 0;
		int total = 0;
		
		for(int i=0; i<jum.length()-1; i++) {
			
			char c = jum.charAt(i);
			
			if(i<7) {
				if(c=='-'){
					continue;
				}else {
					number = ((int)c)-48;
					number = number * (i+2);
				}
			}else if(i<9) {
				number = ((int)c)-48;
				number = number * (i+1);	
			} else{
				number = ((int)c)-48;
				number = number * (i-7);	
			}
			
			sum = sum + number;	
		}
		
		
		total = sum % 11;
		
			if(total == 0) {
				total = 1;
			}else if(total == 1) {
				total = 0;
			}else {
				total = 11-total;
			}
		
		char last = jum.charAt(jum.length()-1);
		int ilast = ((int)last)-48;
		
			if(total == ilast) {
				return true;
				
			}else {
				return false;
			}
			
		}
	
		
		
	}//jumin check







	private static void id() {
		
		System.out.println("=================================================");
		System.out.println("                    아이디 입력");
		System.out.println("==================================================");
		System.out.println("영어 대,소문자,숫자를 이용하여 6~10자리로 입력하세요");
		System.out.print("아이디 : ");
	
		
		String idTemp = scan.nextLine();
		String idMini = idTemp.toLowerCase();
		
		
		
		if(idCheck(idMini)) {
			System.out.printf("입력하신 아이디 %s는(은) 사용 가능합니다.\n" , idMini );
			temp.setMId(idMini) ;
		}else {
			System.out.printf("입력하신 아이디 %s는(은) 사용 불가능합니다.\n" , idMini);
		}
	
	}
				




	private static boolean idCheck(String idMini) {
		
		//1. 6자 ~10자 이내
		if(idMini.length()<6 || idMini.length()>10) {
			System.out.println("<6자 ~ 10자 이내로 입력하세요.>");
			return false; 	//위로 돌려주기
		} 
		
		
		//2. 영문자+숫자 
		for( int i=0; i<idMini.length(); i++) {
			char a = idMini.charAt(i);
			if( (a<'a' || a> 'z') && (a<'0' || a> '9')) {
				return false;
			}
		}
		
			
		//3. 기존 아이디들과 비교
		for(int i=0; i<ManagerList.size(); i++)
			if(idMini == ManagerList.get(i).getMId()) {
				return false;
			}
		
		
		//올바른 id
		return true;
	
	}


	private static void password() {
		System.out.println("=================================================");
		System.out.println("                 비밀번호 입력");
		System.out.println("==================================================");
		System.out.println("영어 대,소문자,숫자를 이용하여 6~10자리로 입력하세요");
		System.out.print("비밀번호 : ");

		String pwTemp = scan.nextLine();
	
		
		if(pwCheck(pwTemp)) {
			System.out.printf("입력하신 비밀번호 %s는(은) 사용 가능합니다.\n" , pwTemp );
			temp.setMPw(pwTemp);
		}else {
			System.out.printf("입력하신 비밀번호 %s는(은) 사용 불가능합니다.\n" , pwTemp);
		}
				
	}
				


	private static boolean pwCheck(String pwTemp) {
		
		//1. 6자 ~10자 이내
		if(pwTemp.length()<6 || pwTemp.length()>10) {
			System.out.println("<6자 ~ 10자 이내로 입력하세요.>");
			return false; 	//위로 돌려주기
		} 
		
		
		
		//2. 대문자+소문자+숫자 
		for( int i=0; i<pwTemp.length(); i++) {
			char a = pwTemp.charAt(i);
			if( (a<'A' || a>'Z') && (a<'a' || a>'z') && (a<'0' || a>'9')) {
				return false;
			}
		}
		
			
		//3. 기존 패스워드들과 비교
		for(int i=0; i<ManagerList.size(); i++)
			if(pwTemp == ManagerList.get(i).getMPw()) {
				return false;
			}
		
		
		//올바른 pw
		return true;
	
	}


	private static void name() {
		
		ComInManager.load();
		
		System.out.println("===========================");
		System.out.println("         이름 입력");
		System.out.println("===========================");
		System.out.print("이름 : ");
		
		String n = scan.nextLine();
		
		if(n.length()>0 || n.length()<12) {
			temp.setMName(n);
		}else {
			System.out.println("다시 입력하세요.");
		}
	
		saveManager();
		
	}

	

	public static void saveManager() {


		ManagerList.add(temp);
		
		try {
				
				BufferedWriter writer = new BufferedWriter(new FileWriter(FILEMPATH,true));
				
				
				for(Manager m : ManagerList) {
					
					//940611-2304516,wlals369,rmakdks00,김지민,C,2
					String line = String.format("%s,%s,%s,%s,%s,%s"
												,m.getMJumin(),m.getMId(),m.getMPw(),m.getMName()
												,"C",((ManagerList.size()+1)+"")	);
				
					writer.newLine();
					writer.write(line); //메모리 -> 텍스트파일(dat) 복사
					
				}
				
				writer.close();
				
			} catch (Exception e) {
				System.out.println("saveManager: " + e.toString());

			}
		
		System.out.println("회원가입이 완료되었습니다.");
		
		}
	
	
	

}
