

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Random;
import java.util.Scanner;

public class dummy {
	
	
	private static ArrayList<Member> studentList; //회원 정보 집합(*********)

	
	static {
		
		studentList = new ArrayList<Member>();
	}
	
	
	
public static void main(String[] args) {
	stuentdummy();
	
}


		
		
		
		
		
		private static void stuentdummy() {
			//테스트용 데이터
		
			String[] name1 = {"김", "이", "박", "최", "문", "지", "편", "천", "추","방", "남궁", "선우", "황보", "강", "임", "서"
							, "차", "고","손", "배", "남", "탁", "구", "황", "라", "조"};
			String[] name2 = {"도", "하","원","혜","상","태","주","만","병","철", "동","향","령","모","난","재","인","명","순"
							,"란","하","별","송", "근","문","현", "채", "은", "창", "형", "대", "건", "준", "필", "미", "진"};
			
			String[] address1 = {"서울시", "부산시", "인천시", "대전시", "광주시","수원시","대구시"};
			String[] address2 = {"강동구", "강남구", "강서구", "강북구", "중구", "중랑구", "영등포구", "마포구", "양천구", "노원구", "용산구"};
			String[] sex1 = {"여","남"};
		    String[] schoolname1 = {"신","목","하","훈","중","화","원","묵","현","상","봉","송","곡","대","원","혜","원","대","명"};
		    String[] depart1 = {"문과","이과","예체능"};
		   
		    String[] sext1 = {"여","남","무관"};
		    String[] subject = {"논술","수리","과탐","언어","외국어","사탐"};
		    String[] subjectp = {"논술","수리","과탐","언어","외국어","사탐","*"};
		    
		    
			Random rnd = new Random();
			
			for (int i=300; i<1000; i++) {
				
				
				
				
				String jumin = ("0" + rnd.nextInt(3) +"") + (rnd.nextInt(13)+1000+"").substring(2) + (rnd.nextInt(29)+1000+"").substring(2)
								+ "-" + (rnd.nextInt(2)+3)+(rnd.nextInt(1000000) + 1000000+ "").substring(1) + "";
				String id = "Sid"+(100000+i+"").substring(2);
				String password = "Spass" +(100000+i+"").substring(2);
				
				String sex ="";
				if(jumin.substring(7, 8).equals("3")) {
					sex = "남";
				}else {
					sex ="여";
				}
				
				
				
				String schoolname = schoolname1[rnd.nextInt(schoolname1.length)]
									+ schoolname1[rnd.nextInt(schoolname1.length)]
									+ "고등학교";
				String name = name1[rnd.nextInt(name1.length)] 
								+ name2[rnd.nextInt(name2.length)] 
							    + name2[rnd.nextInt(name2.length)];
				Calendar c = Calendar.getInstance();
				String age = (c.get(Calendar.YEAR)-(Integer.parseInt(jumin.substring(0,2))+2000)) + 1 +"";
				String address = 
						address1[rnd.nextInt(address1.length)]
					  + " "
					  + address2[rnd.nextInt(address1.length)];			
				
				String tel = "010-" 
				             + (rnd.nextInt(9000) + 1000)
				             + "-"
				             + (rnd.nextInt(9000) + 1000);
				String depart = depart1[rnd.nextInt(depart1.length)];
				
				
				
				String grade = (age.equals("19"))? "고3":((age.equals("18"))?"고2":((age.equals("17"))?"고1": "N수")); 
			
				
				
				
				String sext = sext1[rnd.nextInt(sext1.length)];
				String price = rnd.nextInt(10)+1+"";
				String subject1 = subject[rnd.nextInt(subject.length)];
				String subject2 = subjectp[rnd.nextInt(subjectp.length)];
				String type = "B";
				String num = i+"";
				
				
				Member m = new Member(jumin, id, password, name, sex, age, address, tel, schoolname, depart, grade, sext, price, subject1, subject2, type, num);
				
				studentList.add(m);
				System.out.println(studentList);
				studentList.clear();
			}
			
			
			
			
		}
}

