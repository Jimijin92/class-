package com.register;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Scanner;

import com.common.Teacher;
import com.common.TeacherAddInfor;
import com.io.ComInTeacher;

public class ComRegisterTeacher {
	private static final String FILETPATH = ".\\Data\\선생님 기본정보.dat";
	private static final String FILETAIPATH = ".\\Data\\선생님 추가정보.dat";
	
	private static Scanner scan;
	private static ArrayList<Teacher> TeacherList ;
	private static ArrayList<TeacherAddInfor> TeacherAdd;
	private static Teacher temp ;
	private static TeacherAddInfor tempAdd;
	private static ComRegisterMenu registList;
	
	
	static {
		
		scan = new Scanner(System.in);
		TeacherList = new ArrayList<Teacher>();
		TeacherAdd = new ArrayList<TeacherAddInfor>();	
		temp = new Teacher();
		tempAdd = new TeacherAddInfor();
		registList = new ComRegisterMenu();
		
	}


	
	static int registTeacher() {

		ComInTeacher.load();
		
		
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
			System.out.println("5. 주소");
			System.out.println("6. 휴대폰");
			System.out.println("7. 대학교");
			System.out.println("8. 학과");
			System.out.println("9. 학년");
			System.out.println("10. 과외경력");
			System.out.println("11. 교습지역");
			System.out.println("12. 교습대상");
			System.out.println("13. 희망과외비");
			System.out.println("14. 교습과목");
			System.out.println("15. 특기사항");
			System.out.println("16. 교습스타일");
			System.out.println("17. 자기소개(20자 내외)");
			System.out.println("18. 대상 선택화면으로 돌아가기");
			System.out.println("0. 메인으로 돌아가기");
			
			System.out.print("선택 : ");
			String sel = scan.nextLine();
			
			
			if(sel.equals("1")) jumin();			//주민번호
			else if(sel.equals("2")) id();			//ID
			else if(sel.equals("3")) password();	//PW
			else if(sel.equals("4")) name();		//이름
			else if(sel.equals("5")) address();		//주소
			else if(sel.equals("6")) phone();		//휴대폰
			else if(sel.equals("7")) univ();		//대학교
			else if(sel.equals("8")) depart();		//학과
			else if(sel.equals("9")) grade();		//학년
			else if(sel.equals("10")) career();		//과외경력
			else if(sel.equals("11")) teachZone();	//교습지역
			else if(sel.equals("12")) target();		//교습대상
			else if(sel.equals("13")) price();		//희망과외비(회당)
			else if(sel.equals("14")) subject();	//교습과목
			else if(sel.equals("15")) special();	//특기사항
			else if(sel.equals("16")) style();		//교습스타일
			else if(sel.equals("17")) selfIntro(); 	//자기소개
			else if(sel.equals("18")) registList.register();
			else if(sel.equals("0")) return 1;			//메인 
			
		}
		return 0;

	}


	private static void jumin() {
		
		Calendar c = Calendar.getInstance()	;
		int thisYear = c.get(Calendar.YEAR);
		//System.out.println(thisYear);
		
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
			System.out.println("유효한 주민번호입니다0.");
			temp.setTJumin(jum);
		}else {
			System.out.println("유효하지 않은 주민번호입니다.");
		}
	
			
		
		//성별 저장
		int genderNum = Integer.parseInt(jum.substring(7,8));
			if(genderNum % 2 == 0) {
				temp.setTGender("여자");
				//System.out.println("여자입니다");
			}else if(genderNum % 2 ==1 ) {
				temp.setTGender("남자");
			}
			
			
				
		//나이 저장
		String born = "";
		
		String ageNum = jum.substring(0,2);
		if(genderNum == 1 || genderNum == 2) {
			born ="19"+ageNum;
			
		}else if(genderNum == 3 || genderNum == 4) {
			born = "20" +ageNum ;		
		}
		int bornYear = Integer.parseInt(born) ;
		int cal = thisYear - bornYear +1;
		
		String age = cal + "";
		//System.out.printf("%s세입니다.\n", age);
		
		temp.setTAge(age);
		
		
		
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
			temp.setTId(idMini) ;
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
		for(int i=0; i<TeacherList.size(); i++)
			if(idMini == TeacherList.get(i).getTId()) {
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
			temp.setTPw(pwTemp);
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
		for(int i=0; i<TeacherList.size(); i++)
			if(pwTemp == TeacherList.get(i).getTPw()) {
				return false;
			}
		
		
		//올바른 pw
		return true;
	
	}
	


	private static void name() {
		System.out.println("===========================");
		System.out.println("         이름 입력");
		System.out.println("===========================");
		System.out.print("이름 : ");
		
		String n = scan.nextLine();
		
		if(n.length()>0 || n.length()<12) {
			temp.setTName(n);
		}else {
			System.out.println("다시 입력하세요.");
		}
	
	}


	private static void address() {		

		System.out.println("===========================");
		System.out.println("         주소 입력");
		System.out.println("===========================");
		System.out.println("1. 서울지역");
		System.out.println("2. 경기북부");
		System.out.println("3. 경기남부");
		System.out.println("4. 기타");						
		
		
		System.out.print("선택 : ");
		String sel = scan.nextLine();
		
		if(sel.equals("1")) seoul();
		else if(sel.equals("2")) ggdNorth();
		else if(sel.equals("3")) ggdSouth();


	}
	
	
	private static void seoul() {
		System.out.println("===================================");
        System.out.println("●구 선택●");
        System.out.print("1.강남구\t");
        System.out.print("6.광진구 ");
        System.out.print("11.동대문구 ");
        System.out.print("16.성동구\t");
        System.out.println("21.용산구\t");
        System.out.print("2.강동구\t");
        System.out.print("7.구로구 ");
        System.out.print("12.동작구   ");
        System.out.print("17.성북구\t");
        System.out.println("22.은평구\t");
        System.out.print("3.강북구\t");
        System.out.print("8.금천구 ");
        System.out.print("13.마포구   ");
        System.out.print("18.송파구\t");
        System.out.println("23.종로구\t");
        System.out.print("4.강서구\t");
        System.out.print("9.노원구 ");
        System.out.print("14.서대문구 ");
        System.out.print("19.양천구\t");
        System.out.println("24.중구\t");
        System.out.print("5.관악구\t");
        System.out.print("10.도봉구 ");
        System.out.print("15.서초구  ");
        System.out.print("20.영등포구\t");
        System.out.println("25.중랑구\t");
        System.out.print("선택 : ");
        
        String sel = scan.nextLine();
        
        if(sel.equals("1")) temp.setTAddress("서울시 강남구");
        else if(sel.equals("2")) temp.setTAddress("서울시 강동구");
        else if(sel.equals("3")) temp.setTAddress("서울시 강북구");
        else if(sel.equals("4")) temp.setTAddress("서울시 강서구");
        else if(sel.equals("5")) temp.setTAddress("서울시 관악구");
        else if(sel.equals("6")) temp.setTAddress("서울시 광진구");
        else if(sel.equals("7")) temp.setTAddress("서울시 구로구");
        else if(sel.equals("8")) temp.setTAddress("서울시 금천구");
        else if(sel.equals("9")) temp.setTAddress("서울시 노원구");
        else if(sel.equals("10")) temp.setTAddress("서울시 도봉구");
        else if(sel.equals("11")) temp.setTAddress("서울시 동대문구");
        else if(sel.equals("12")) temp.setTAddress("서울시 동작구");
        else if(sel.equals("13")) temp.setTAddress("서울시 마포구");
        else if(sel.equals("14")) temp.setTAddress("서울시 서대문구");
        else if(sel.equals("15")) temp.setTAddress("서울시 서초구");
        else if(sel.equals("16")) temp.setTAddress("서울시 성동구");
        else if(sel.equals("17")) temp.setTAddress("서울시 성북구");
        else if(sel.equals("18")) temp.setTAddress("서울시 송파구");
        else if(sel.equals("19")) temp.setTAddress("서울시 양천구");
        else if(sel.equals("20")) temp.setTAddress("서울시 영등포구");
        else if(sel.equals("21")) temp.setTAddress("서울시 용산구");
        else if(sel.equals("22")) temp.setTAddress("서울시 은평구");
        else if(sel.equals("23")) temp.setTAddress("서울시 종로구");
        else if(sel.equals("24")) temp.setTAddress("서울시 중구");
        else if(sel.equals("25")) temp.setTAddress("서울시 중랑구");
 
        System.out.printf("입력하신 주소는 %s입니다\n"	 , temp.getTAddress());
		
		
	}




	private static void ggdNorth() {

		System.out.println("=====================================");
	      System.out.println("●시/군 선택●");
	      System.out.print("1.고양시  ");
	      System.out.print("4.남양주시  ");
	      System.out.print("7.파주시  ");
	      System.out.println("10.양평군\t");
	      
	      System.out.print("2.구리시  ");
	      System.out.print("5.동두천시  ");
	      System.out.println("8.연천군  ");
	      
	      System.out.print("3.김포시  ");
	      System.out.print("6.양주시    ");
	      System.out.println("9.가평군\t");
	      System.out.print("선택 : ");
	      
	      String sel = scan.nextLine();
	      
	      if(sel.equals("1")) temp.setTAddress("경기도 고양시");
	        else if(sel.equals("2")) temp.setTAddress("경기도 구리시");
	        else if(sel.equals("3")) temp.setTAddress("경기도 김포시");
	        else if(sel.equals("4")) temp.setTAddress("경기도 남양주시");
	        else if(sel.equals("5")) temp.setTAddress("경기도 동두천시");
	        else if(sel.equals("6")) temp.setTAddress("경기도 양주시");
	        else if(sel.equals("7")) temp.setTAddress("경기도 파주시");
	        else if(sel.equals("8")) temp.setTAddress("경기도 연천군");
	        else if(sel.equals("9")) temp.setTAddress("경기도 가평군");
	        else if(sel.equals("10")) temp.setTAddress("경기도 양평군");
	       
	 
	        System.out.printf("입력하신 주소는 %s입니다\n"	 , temp.getTAddress());
			
	
	}
	


	private static void ggdSouth() {
		
		System.out.println("===================================");
		System.out.println("●시/군 선택●");
		System.out.print("1.과천시\t");
		System.out.print("6.성남시\t");
		System.out.print("11.안양시 ");
		System.out.println("16.이천시\t");
		
		System.out.print("2.광명시\t");
		System.out.print("7.수원시\t");
		System.out.print("12.여주시 ");
		System.out.println("17.평택시\t");
		
		System.out.print("3.광주시\t");
		System.out.print("8.시흥시\t");
		System.out.print("13.오산시 ");
		System.out.println("18.하남시\t");
		
		System.out.print("4.군포시\t");
		System.out.print("9.안산시\t");
		System.out.print("14.용인시 ");
		System.out.println("19.화성시\t");
		
		System.out.print("5.부천시\t");
		System.out.print("10.안성시");
		System.out.println("15.의왕시 ");
		System.out.print("선택 : ");
		
		 String sel = scan.nextLine();
	      
	      if(sel.equals("1")) temp.setTAddress("경기도 과천시");
	        else if(sel.equals("2")) temp.setTAddress("경기도 광명시");
	        else if(sel.equals("3")) temp.setTAddress("경기도 광주시");
	        else if(sel.equals("4")) temp.setTAddress("경기도 군포시");
	        else if(sel.equals("5")) temp.setTAddress("경기도 부천시");
	        else if(sel.equals("6")) temp.setTAddress("경기도 성남시");
	        else if(sel.equals("7")) temp.setTAddress("경기도 수원시");
	        else if(sel.equals("8")) temp.setTAddress("경기도 시흥군");
	        else if(sel.equals("9")) temp.setTAddress("경기도 안산시");
	        else if(sel.equals("10")) temp.setTAddress("경기도 안성시");
	        else if(sel.equals("11")) temp.setTAddress("경기도 안양시");
	        else if(sel.equals("12")) temp.setTAddress("경기도 여주시");
	        else if(sel.equals("13")) temp.setTAddress("경기도 오산시");
	        else if(sel.equals("14")) temp.setTAddress("경기도 용인시");
	        else if(sel.equals("15")) temp.setTAddress("경기도 의왕시");
	        else if(sel.equals("16")) temp.setTAddress("경기도 이천시");
	        else if(sel.equals("17")) temp.setTAddress("경기도 평택시");
	        else if(sel.equals("18")) temp.setTAddress("경기도 하남시");
	        else if(sel.equals("19")) temp.setTAddress("경기도 화성시");
	      
	 
	        System.out.printf("입력하신 주소는 %s입니다\n"	 , temp.getTAddress());
			
		
	}
	
	
	private static void phone() {
		
		System.out.println("===========================");
		System.out.println("        휴대폰 번호");
		System.out.println("===========================");
		System.out.print("휴대폰 번호 : ");
		
		String pnum = scan.nextLine();			//01012345678
		
		if((pnum.length()>9) && (pnum.length()<14)) {
			if(!(pnum.contains("-"))) {
				String numFir = pnum.substring(0, 3);	//010
				String numSec = pnum.substring(3, 7);	//1234
				String numThr = pnum.substring(7);		//5678
				
				pnum = numFir+"-"+numSec+"-"+numThr;
				temp.setTTel(pnum);
				System.out.printf("입력하신 %s는 올바른 휴대폰 번호입니다.\n"	
										, temp.getTTel());
			}else {
				temp.setTTel(pnum);
				System.out.printf("입력하신 %s는 올바른 휴대폰 번호입니다.\n"	
										, temp.getTTel());
			}
		}else {
			System.out.println("다시 입력하세요.");
		}
		

	}


	private static void univ() {					
		
		
		System.out.println("===========================");
		System.out.println("           대 학");
		System.out.println("===========================");
		
		System.out.print("대학 : ");
		String university = scan.nextLine();
		
		temp.setTUniv(university);
		System.out.printf("입력하신 대학은 %s입니다.\n"	, university);

	}


	
	private static void depart() {
		

		System.out.println("=====================");
		System.out.println("      학과 계열");
		System.out.println("=====================");
		System.out.print("1.인문계열\t");
		System.out.print("2.사회과학계열\t");
		System.out.println("3.사범계열");
		System.out.print("4.자연과학계열\t");
		System.out.print("5.공과계열\t");
		System.out.println("6.예체능계열\t");

		System.out.print("선택 : ");
		String sel = scan.nextLine();
		
		if(sel.equals("1")) temp.setTDepart("인문계열");
		else if(sel.equals("2")) temp.setTDepart("사회과학계열");
		else if(sel.equals("3")) temp.setTDepart("사범계열");
		else if(sel.equals("4")) temp.setTDepart("자연과학계열");
		else if(sel.equals("5")) temp.setTDepart("공과계열");
		else if(sel.equals("6")) temp.setTDepart("예체능계열");
		
		System.out.printf("입력하신 학과는 %s입니다.\n"	, temp.getTDepart());

		//System.out.println(departT);
	}


	private static void grade() {

		System.out.println("====================");
		System.out.println("      본인 학년");
		System.out.println("====================");
		System.out.print("1. 1학년\t");
		System.out.println("4. 4학년");
		System.out.print("2. 2학년\t");
		System.out.println("5. 대졸");
		System.out.print("3. 3학년\t");
		System.out.println("6. 석사");
		
		System.out.print("선택 : ");
		String sel = scan.nextLine();
		
		if(sel.equals("1")) temp.setTGrade("1학년");
		else if(sel.equals("2")) temp.setTGrade("2학년");
		else if(sel.equals("3")) temp.setTGrade("3학년");
		else if(sel.equals("4")) temp.setTGrade("4학년");
		else if(sel.equals("5")) temp.setTGrade("대졸");
		else if(sel.equals("6")) temp.setTGrade("석사");
	
		System.out.printf("입력하신 학년은 %s입니다.\n"	, temp.getTGrade());
		
		
	}
		//과외경력
	private static void career() {
		
		System.out.println("=======================");
		System.out.println("      과 외 경 력");
		System.out.println("========================");
		System.out.print("1. 1년이하  ");
		System.out.print("5. 4년  ");
		System.out.println("9. 8년");

		System.out.print("2. 1년\t   ");
		System.out.print("6. 5년  ");
		System.out.println("10. 9년");
		
		System.out.print("3. 2년\t   ");
		System.out.print("7. 6년  ");
		System.out.println("11. 10년이상");
		
		System.out.print("4. 3년\t   ");
		System.out.println("8. 7년  ");
		
		System.out.print("선택 : ");
		String sel = scan.nextLine();
		
		if(sel.equals("1")) temp.setTCareer("1년이하");
		else if(sel.equals("2")) temp.setTCareer("1년");
		else if(sel.equals("3")) temp.setTCareer("2년");
		else if(sel.equals("4")) temp.setTCareer("3년");
		else if(sel.equals("5")) temp.setTCareer("4년");
		else if(sel.equals("6")) temp.setTCareer("5년");
		else if(sel.equals("6")) temp.setTCareer("6년");
		else if(sel.equals("6")) temp.setTCareer("7년");
		else if(sel.equals("6")) temp.setTCareer("8년");
		else if(sel.equals("6")) temp.setTCareer("9년");
		else if(sel.equals("6")) temp.setTCareer("10년이상");
		
		System.out.printf("입력하신 경력은 %s입니다.\n"	, temp.getTCareer());
		//System.out.println(careerT);
	}

	
	
	//희망 교습지역
	private static void teachZone() {
		
		
		String sel = "";
		
		String[] area = new String[3];   
		
		
		for(int i=0; i<3; i++) {
		
			System.out.println("====================");
			System.out.println("    희망 교습 지역");
			System.out.println("====================");
			System.out.println("1. 서울지역");
			System.out.println("2. 경기북부");
			System.out.println("3. 경기남부");
			
			System.out.print("선택 : ");
			sel = scan.nextLine();
			
			if(sel.equals("1")){			
				area[i] = seoulZone();
				
			}else if(sel.equals("2")){			
				area[i]= ggdNorthZone();
				
			}else if(sel.equals("3")){	
				area[i]= ggdSouthZone();
			}
			
			
		}
		
	
			temp.setTZone(area);
			System.out.printf("입력하신 희망 교습 지역은 %s, %s, %s입니다.\n"	
										, temp.getTZone()[0]
										, temp.getTZone()[1]	
										, temp.getTZone()[2]		);
		
		
	}
	
	
	


	public static String seoulZone() {
		
		System.out.println("===================================");
        System.out.println("●구 선택●");
        System.out.print("1.강남구\t");
        System.out.print("6.광진구 ");
        System.out.print("11.동대문구 ");
        System.out.print("16.성동구\t");
        System.out.println("21.용산구\t");
        System.out.print("2.강동구\t");
        System.out.print("7.구로구 ");
        System.out.print("12.동작구   ");
        System.out.print("17.성북구\t");
        System.out.println("22.은평구\t");
        System.out.print("3.강북구\t");
        System.out.print("8.금천구 ");
        System.out.print("13.마포구   ");
        System.out.print("18.송파구\t");
        System.out.println("23.종로구\t");
        System.out.print("4.강서구\t");
        System.out.print("9.노원구 ");
        System.out.print("14.서대문구 ");
        System.out.print("19.양천구\t");
        System.out.println("24.중구\t");
        System.out.print("5.관악구\t");
        System.out.print("10.도봉구 ");
        System.out.print("15.서초구  ");
        System.out.print("20.영등포구\t");
        System.out.println("25.중랑구\t");
        System.out.print("선택 : ");
        
        String zone = scan.nextLine();
        String choice = "";
        
        if(zone.equals("1")) choice ="서울시 강남구";
        else if(zone.equals("2")) choice ="서울시 강동구";
        else if(zone.equals("3")) choice ="서울시 강북구";
        else if(zone.equals("4")) choice ="서울시 강서구";
        else if(zone.equals("5")) choice ="서울시 관악구";
        else if(zone.equals("6")) choice ="서울시 광진구";
        else if(zone.equals("7")) choice ="서울시 구로구";
        else if(zone.equals("8")) choice ="서울시 금천구";
        else if(zone.equals("9")) choice ="서울시 노원구";
        else if(zone.equals("10")) choice ="서울시 도봉구";
        else if(zone.equals("11")) choice ="서울시 동대문구";
        else if(zone.equals("12")) choice ="서울시 동작구";
        else if(zone.equals("13")) choice ="서울시 마포구";
        else if(zone.equals("14")) choice ="서울시 서대문구";
        else if(zone.equals("15")) choice ="서울시 서초구";
        else if(zone.equals("16")) choice ="서울시 성동구";
        else if(zone.equals("17")) choice ="서울시 성북구";
        else if(zone.equals("18")) choice ="서울시 송파구";
        else if(zone.equals("19")) choice ="서울시 양천구";
        else if(zone.equals("20")) choice ="서울시 영등포구";
        else if(zone.equals("21")) choice ="서울시 용산구";
        else if(zone.equals("22")) choice ="서울시 은평구";
        else if(zone.equals("23")) choice ="서울시 종로구";
        else if(zone.equals("24")) choice ="서울시 중구";
        else if(zone.equals("25")) choice ="서울시 중랑구";
        
        return choice;
 
       // System.out.printf("입력하신 주소는 %s입니다\n"	 , temp.getTAddress());
		
		
	}




	public static String ggdNorthZone() {

		System.out.println("=====================================");
	      System.out.println("●시/군 선택●");
	      System.out.print("1.고양시  ");
	      System.out.print("4.남양주시  ");
	      System.out.print("7.파주시  ");
	      System.out.println("10.양평군\t");
	      
	      System.out.print("2.구리시  ");
	      System.out.print("5.동두천시  ");
	      System.out.println("8.연천군  ");
	      
	      System.out.print("3.김포시  ");
	      System.out.print("6.양주시    ");
	      System.out.println("9.가평군\t");
	      System.out.print("선택 : ");
	      
	      String zone = scan.nextLine();
	      String choice = "";
	      
	      if(zone.equals("1")) choice = "경기도 고양시";
	        else if(zone.equals("2")) choice = "경기도 구리시";
	        else if(zone.equals("3")) choice = "경기도 김포시";
	        else if(zone.equals("4")) choice = "경기도 남양주시";
	        else if(zone.equals("5")) choice = "경기도 동두천시";
	        else if(zone.equals("6")) choice = "경기도 양주시";
	        else if(zone.equals("7")) choice = "경기도 파주시";
	        else if(zone.equals("8")) choice = "경기도 연천군";
	        else if(zone.equals("9")) choice = "경기도 가평군";
	        else if(zone.equals("10")) choice = "경기도 양평군";
	       
	      return choice;

	}
	


	public static String ggdSouthZone() {
		
		System.out.println("===================================");
		System.out.println("●시/군 선택●");
		System.out.print("1.과천시\t");
		System.out.print("6.성남시\t");
		System.out.print("11.안양시 ");
		System.out.println("16.이천시\t");
		
		System.out.print("2.광명시\t");
		System.out.print("7.수원시\t");
		System.out.print("12.여주시 ");
		System.out.println("17.평택시\t");
		
		System.out.print("3.광주시\t");
		System.out.print("8.시흥시\t");
		System.out.print("13.오산시 ");
		System.out.println("18.하남시\t");
		
		System.out.print("4.군포시\t");
		System.out.print("9.안산시\t");
		System.out.print("14.용인시 ");
		System.out.println("19.화성시\t");
		
		System.out.print("5.부천시\t");
		System.out.print("10.안성시");
		System.out.println("15.의왕시 ");
		System.out.print("선택 : ");
		
		String zone = scan.nextLine();
	    String choice = "";
	      
	      if(zone.equals("1")) choice ="경기도 과천시";
	        else if(zone.equals("2")) choice ="경기도 광명시";
	        else if(zone.equals("3")) choice ="경기도 광주시";
	        else if(zone.equals("4")) choice ="경기도 군포시";
	        else if(zone.equals("5")) choice ="경기도 부천시";
	        else if(zone.equals("6")) choice ="경기도 성남시";
	        else if(zone.equals("7")) choice ="경기도 수원시";
	        else if(zone.equals("8")) choice ="경기도 시흥군";
	        else if(zone.equals("9")) choice ="경기도 안산시";
	        else if(zone.equals("10")) choice ="경기도 안성시";
	        else if(zone.equals("11")) choice ="경기도 안양시";
	        else if(zone.equals("12")) choice ="경기도 여주시";
	        else if(zone.equals("13")) choice ="경기도 오산시";
	        else if(zone.equals("14")) choice ="경기도 용인시";
	        else if(zone.equals("15")) choice ="경기도 의왕시";
	        else if(zone.equals("16")) choice ="경기도 이천시";
	        else if(zone.equals("17")) choice ="경기도 평택시";
	        else if(zone.equals("18")) choice ="경기도 하남시";
	        else if(zone.equals("19")) choice ="경기도 화성시";
	      
	      return choice;
			
		
	}

	
	//희망 교습대상
	private static void target() {

		System.out.println("=====================");
		System.out.println("    교 습 대 상");
		System.out.println("=====================");
		System.out.println("1. 고1");
		System.out.println("2. 고2");
		System.out.println("3. 고3");
		System.out.println("4. N수생");
		
		System.out.print("선택 : ");
		String sel = scan.nextLine();
		
		if(sel.equals("1")) temp.setTTarget("고1");
		else if(sel.equals("2")) temp.setTTarget("고2");
		else if(sel.equals("3")) temp.setTTarget("고3");
		else if(sel.equals("4")) temp.setTTarget("N수생");
	
		System.out.printf("입력하신 교습대상은 %s입니다.\n"	, temp.getTTarget());
	}

	
	//희망 과외비(회당)
	private static void price() {	

		System.out.println("=======================");
		System.out.println("    희망 과외비(회당)");
		System.out.println("=======================");
		
		System.out.print("교습비(만원) : ");
		String wantMoney = scan.nextLine();
		int money = Integer.parseInt(wantMoney);
		
		
		//1~10만원
		if(money>0 && money<11) {
			temp.setTPrice(wantMoney);
			System.out.printf("입력하신 희망과외비(회당)은 %s만원입니다.\n"	, wantMoney);
		}else {
			System.out.println("다시 입력하세요.");
		}
		
		
	}


	private static void subject() {

		System.out.println("======================");
		System.out.println("    희망 교습 과목");
		System.out.println("======================");
		System.out.print("1.언어\t");
		System.out.print("2.외국어\t");
		System.out.println("3.수리 ");
		System.out.print("4.사탐\t");
		System.out.print("5.과탐\t");
		System.out.print("6.제2외국어");
		System.out.println("7.논술");
		
		System.out.print("선택1 : ");
		String sel1 = scan.nextLine();
			
		System.out.print("선택2 : ");
		String sel2 = scan.nextLine();
		
		String[] sel = new String[2];   
		sel[0] = sel1;
		sel[1] = sel2;
		String[] select = new String[2];
		

		for(int i=0; i<2; i++) {
			if(sel[i].equals("1")){select[i]="언어";}
			else if(sel[i].equals("2")){select[i]="외국어";}
			else if(sel[i].equals("3")){select[i]="수리";}
			else if(sel[i].equals("4")){select[i]="사탐";}
			else if(sel[i].equals("5")){select[i]="과탐";}
			else if(sel[i].equals("6")){select[i]="제2외국어";}
			else if(sel[i].equals("7")){select[i]="논술";}	
			
		}
		
			temp.setTSubject(select);
			System.out.printf("입력하신 희망 교습 과목은 %s, %s입니다.\n"	
										, temp.getTSubject()[0]
										, temp.getTSubject()[1]		);
			
			
	}


	private static void special() {

		ComInTeacher.load();
		
		System.out.println("=========================");
		System.out.println("       특 기 사 항");
		System.out.println("========================");
		System.out.print("1.해외거주경험\t\t");
		System.out.println("4.대회입상경험");
		System.out.print("2.학원강사경험\t\t ");
		System.out.println("5.없음");
		System.out.print("3.특목고 졸업");
		
		System.out.print("선택 : ");
		
		String sel = scan.nextLine();
		
		if(sel.equals("1")) tempAdd.setTSpecialNote("해외거주경험");
		else if(sel.equals("2")) tempAdd.setTSpecialNote("학원강사경험");
		else if(sel.equals("3")) tempAdd.setTSpecialNote("특목고졸업");
		else if(sel.equals("4")) tempAdd.setTSpecialNote("대회입상경험");
		else if(sel.equals("5")) tempAdd.setTSpecialNote("없음");		
		
		System.out.printf("입력하신 특기사항은 %s입니다.\n"	
									, tempAdd.getTSpecialNote());
		
	}


	private static void style() {

		ComInTeacher.load();
		
		System.out.println("==========================");
		System.out.println("      교 습 스 타 일");
		System.out.println("==========================");
		System.out.print("1.카리스마형\t");
		System.out.println("4.문제풀이형");
		System.out.print("2.자상한지도자형\t ");
		System.out.println("5.쪽집게형");
		System.out.print("3.기초다지기형\t");
		System.out.println("6.혼합형");
		
		System.out.print("선택 : ");
		String sel = scan.nextLine();
		
		if(sel.equals("1")) tempAdd.setTStyle("카리스마형");
		else if(sel.equals("2")) tempAdd.setTStyle("자상한지도형");
		else if(sel.equals("3")) tempAdd.setTStyle("기초다지기형");
		else if(sel.equals("4")) tempAdd.setTStyle("문제풀이형");
		else if(sel.equals("5")) tempAdd.setTStyle("쪽집게형");
		else if(sel.equals("6")) tempAdd.setTStyle("혼합형");
		
		System.out.printf("입력하신 교습스타일은 %s입니다.\n"	
									, tempAdd.getTStyle());

	}


	private static void selfIntro() {								
		 
		ComInTeacher.load();
	
		System.out.println("===============================");
		System.out.println("          자 기 소 개");
		System.out.println("===============================");
		
		System.out.print("자기소개(20자이내) : ");
		String self = scan.nextLine();
		
		if( self.length()<0 || self.length()>21 ) {
			System.out.println("20자 이내로 입력해주세요.");
		}else {
			tempAdd.setTSelfIntro(self);		
		}
		
		saveTeacher();
	}

	
	public static void saveTeacher() {


		TeacherList.add(temp);
		
		try {
				
				BufferedWriter writer = new BufferedWriter(new FileWriter(FILETPATH,true));
				
				
				for(Teacher t : TeacherList) {
					
					//901220-1129513,pbg1220,A123456,박보검,남,29,서울시 강남구,010-9513-9012,서울대학교,사회과학계열,대졸,6년,서울시 강남구,서울시 송파구,서울시 금천구
					//	,N수,3,외국어,언어,1점,0,2점,0,3점,0,4점,0,5점,1,A,16
					HashMap<String,String> tstar = t.getTStar();
					String line = String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s"
												,t.getTJumin(),t.getTId(),t.getTPw(),t.getTName()
												,t.getTGender(),t.getTAge(),t.getTAddress(),t.getTTel()
												,t.getTUniv(),t.getTDepart(),t.getTGrade(),t.getTCareer()
												,t.getTZone()[0],t.getTZone()[1],t.getTZone()[2]
												,t.getTTarget(),t.getTPrice()
												,t.getTSubject()[0],t.getTSubject()[1]
												,"1점","0","2점","0","3점",tstar.get("3점"),"4점",tstar.get("4점"),"5점",tstar.get("5점")
												,"A",((TeacherList.size()+1)+"")	);
					System.out.println(line);
				
					writer.newLine();
					writer.write(line); //메모리 -> 텍스트파일(dat) 복사
					
				}
				
				writer.close();
				
			} catch (Exception e) {
				System.out.println("saveTeacher : " + e.toString());

			}
		
		saveTeacherAdd();

		}//saveTeacher
		
		
	


	
	private static void saveTeacherAdd() {

		TeacherAdd.add(tempAdd);

			try {
				
					BufferedWriter writer = new BufferedWriter(new FileWriter(FILETAIPATH, true));
					
					
					for(TeacherAddInfor t : TeacherAdd) {
						
						//특목고졸업,기초다지기형,질문받는것을 가장 좋아합니다,A,38
						String line = String.format("%s,%s,%s,%s,%s"
													,t.getTSpecialNote(),t.getTStyle(),t.getTSelfIntro()
													,"A",((TeacherList.size()+1)+"")	);
						
						writer.write(line); //메모리 -> 텍스트파일(dat) 복사
						writer.newLine();
						
					}
					
					writer.close();
					
				} catch (Exception e) {
					System.out.println("saveTeacherAdd : " + e.toString());

				}

			System.out.println("회원가입이 완료되었습니다.");
			
	}

	
	
}
