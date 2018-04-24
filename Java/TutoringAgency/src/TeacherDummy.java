
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Random;
import java.util.Scanner;

public class TeacherDummy {
	
	
	private static ArrayList<TeacherMember> studentList; //회원 정보 집합(*********)
	private static int i;
	
	static {
		
		studentList = new ArrayList<TeacherMember>();
		i=61;
	}
	
	
	
public static void main(String[] args) {
	teacherdummy();
}

		private static void teacherdummy() {
	
	String[] name1 = {"김", "이", "박", "최", "문", "지", "편", "천", "추","방", "남궁", "선우", "황보", "강", "임", "서"
					, "차", "고","손", "배", "남", "탁", "구", "황", "라", "조"};
	String[] name2 = {"도", "하","원","혜","상","태","주","만","병","철", "동","향","령","모","난","재","인","명","순"
					,"란","하","별","송", "근","문","현", "채", "은", "창", "형", "대", "건", "준", "필", "미", "진"};
	
	String[] address5 = {"서울시"};
	//String[] address6 = {"강동구", "강남구", "강서구", "강북구", "중구", "중랑구", "영등포구", "마포구", "양천구", "노원구", "용산구"};
	String[] address6 = {"강동구", "강서구", "강북구", "중구", "중랑구", "영등포구", "마포구", "양천구", "노원구", "용산구"};
	//String[] sex1 = {"여","남"};
	String[] sex1 = {"여"};
    String[] schoolname1 = {"서울","한양","중앙","성균관","부산","고려","연세","서강","경희","한국외국어","서울시립","경기","삼육","서울과학기술","세명"};
    String[] depart1 = {"인문계열","사회과학계열","사범계열","공과계열","자연과학계열","의과계열"};
    String[] tgrade1 = {"1학년", "2학년", "3학년", "4학년", "대졸", "석사"};
    String[] sgrade1 = {"고1","고2","고3","N수"};
    
    
    //String[] subject = {"논술","수리","과탐","언어","외국어","사탐"};
    //String[] subjectp = {"논술","수리","과탐","언어","외국어","사탐","*"};
    
    String[] subject = {"언어"};
    String[] subjectp = {"*"};
    
    
	Random rnd = new Random();
	
	
	for (i =1001; i<1500; i++) {
		
		String num = i+"";
		
		
		
		String jumin = (87 + rnd.nextInt(13) +"") + (rnd.nextInt(13)+1000+"").substring(2) + (rnd.nextInt(29)+1000+"").substring(2)
						+ "-" + (rnd.nextInt(2)+1)+(rnd.nextInt(1000000) + 1000000+ "").substring(1) + "";
		String id = ("Sid"+(100000+i)+"").substring(2);
		String password = ("Spass" +(100000+i)+"").substring(2);
		
		String sex ="";
		if(jumin.substring(7, 8).equals("1")) {
			sex = "남";
		}else {
			sex ="여";
		}
		
		
		
		String schoolname = schoolname1[rnd.nextInt(schoolname1.length)]
							+ "대학교";
		String name = name1[rnd.nextInt(name1.length)] 
						+ name2[rnd.nextInt(name2.length)] 
					    + name2[rnd.nextInt(name2.length)];
		Calendar c = Calendar.getInstance();
		String age = (c.get(Calendar.YEAR)-(Integer.parseInt(jumin.substring(0,2))+1900)) + 1 +"";
		String address = 
				"서울시"+ " "
						  + address6[rnd.nextInt(address6.length)];	
			
		
		String tel = "010-" 
		             + (rnd.nextInt(9000) + 1000)
		             + "-"
		             + (rnd.nextInt(9000) + 1000);
		String depart = depart1[rnd.nextInt(depart1.length)];
		
		String tgrade = "";
		if(age.equals("20")) {
			tgrade = "1학년";	
			
		}else if(age.equals("21")) {
			tgrade = "2학년";	
			
		}else {
			tgrade = tgrade1[rnd.nextInt(tgrade1.length)];
		}
			
		
		
		String career = (rnd.nextInt(7)+2) + "년";
		
		String address1 = 
				"서울시 강남구";
						  //+ address6[rnd.nextInt(address6.length)];	
						
		
		String address2 = 
				"서울시"+ " "
						  + address6[rnd.nextInt(address6.length)];	
		
		
		String address3 = 
				"서울시"+ " "
						  + address6[rnd.nextInt(address6.length)];	
		
		
		String sgrade = sgrade1[rnd.nextInt(sgrade1.length)];
		
		String price = rnd.nextInt(10)+1+"";
		
		
		String subject1 = subject[rnd.nextInt(subject.length)];
		String subject2 = subjectp[rnd.nextInt(subjectp.length)];
		
		String num1 = "1점";
		String num2 = "2점";
		String num3 = "3점";
		String num4 = "4점";
		String num5 = "5점";
		
		
		String num11 = rnd.nextInt(5)+"";
		String num21 = rnd.nextInt(5)+"";
		String num31 = rnd.nextInt(5)+"";
		String num41 = rnd.nextInt(5)+"";
		String num51 = rnd.nextInt(5)+"";
		
		
		String type = "A";
		
		
		
		TeacherMember m = new TeacherMember(jumin, id, password, name, sex, age, address, tel
						, schoolname, depart, tgrade, career ,address1, address2, address3, sgrade
						, price,subject1,subject2,num1,num11,num2,num21,num3,num31,num4,num41,num5,num51, type, num);
		
		studentList.add(m);
		System.out.println(studentList);
		studentList.clear();
	

	}	
	}
}
