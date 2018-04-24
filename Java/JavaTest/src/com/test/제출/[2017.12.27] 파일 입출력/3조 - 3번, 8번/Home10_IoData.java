package home;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

import com.test.example.Ex30_Class;

public class Home10_IoData {
	
	private static final String PATH = "D:\\파일_입출력_문제";
	
	public static void main(String[] args) {
		//ex1();
		//ex2();
		//ex3();
//		ex4();
		//ex5();
		//ex6();
		//ex7();
		ex8();
		//ex9();
		//ex10();
	}
	

	private static void ex1() {
		/*
		문제1.
		리소스] 숫자.dat
		요구사항] 아라비안 숫자를 찾아서 한글을 바꾸시오. -> 복사본으로 저장하기
		조건] 0 -> 영, 1 -> 일, .. 9 -> 구
				저장할 파일명 : 숫자_변환.dat
		*/
		
		String filePath = PATH + "\\숫자.dat";
		
		try {
			//내용 변환
			BufferedReader reader = new BufferedReader(new FileReader(filePath));
			
			String temp = "";
			String line = null;
			
			while ((line = reader.readLine()) != null) {
				temp += changeNum(line) + "\r\n";
			}
			
			reader.close();
			
			//새로운 파일 생성
			BufferedWriter writer = new BufferedWriter(new FileWriter(PATH + "\\숫자_변환.dat"));
			
			writer.write(temp);
			
			writer.close();
			
		} catch (Exception e) {
			System.out.println("ex1 : " + e.toString());
		}
		
	}

	private static String changeNum(String line) {
		
		line = line.replace("0", "영");
		line = line.replace("1", "일");
		line = line.replace("2", "이");
		line = line.replace("3", "삼");
		line = line.replace("4", "사");
		line = line.replace("5", "오");
		line = line.replace("6", "육");
		line = line.replace("7", "칠");
		line = line.replace("8", "팔");
		line = line.replace("9", "구");
		
		return line;
	}


	private static void ex2() {
		/*	
		문제2.
		리소스] 성적.dat
		파일형식] 홍길동,47,61,73
					이름,국,영,수
		요구사항] 합격자 명단을 출력하시오.
		조건] 합격 조건 : 3고목 평균 60점 이상
			과락 조건 : 40점 미만
		결과] 홍길동
				하하
				정형돈  합격한 사람들의 이름만 출력!!!
		사용] 컬렉션 사용해서..(Ex77 예제 처럼)
		*/
		
		String filePath = PATH + "\\성적.dat";
		
		
		ArrayList<Home10_Ex2> list = new ArrayList<Home10_Ex2>(organize(filePath));
		
		
		for (Home10_Ex2 grade : list) {
			int kor = Integer.parseInt(grade.getKor());
			int eng = Integer.parseInt(grade.getEng());
			int math = Integer.parseInt(grade.getMath());
			
			if (kor < 40 || eng < 40 || math < 40) {
				continue;
			} else {
				if (((kor + eng + math) / 3) >= 60) {
					System.out.println(grade.getName());
				}
			}
		}
	}

	private static ArrayList<Home10_Ex2> organize(String filePath) {
		
		ArrayList<Home10_Ex2> list = new ArrayList<Home10_Ex2>();
		
		try {
			
			BufferedReader reader = new BufferedReader(new FileReader(filePath));
			
			String line = null;
			
			while ((line = reader.readLine()) != null) {
				String [] temp = line.split(",");
				
				Home10_Ex2 grade = new Home10_Ex2();
				grade.setName(temp[0]);
				grade.setKor(temp[1]);
				grade.setEng(temp[2]);
				grade.setMath(temp[3]);
				
				list.add(grade);
			}
			reader.close();
			
		} catch (Exception e) {
			System.out.println("organize : " + e.toString());
		}
		return list;
	}


	private static void ex3() {
		/*
		문제3. - 문제 1과 동일
		리소스] 이름수정.dat
		요구사항] '유재석'을 '메뚜기'로 수정하시오.
		조건] 이름수정_변환.dat
		*/
		
		String filePath = PATH + "\\이름수정.dat";
		
		try {
			BufferedReader reader = new BufferedReader(new FileReader(filePath));
			
			String result = "";
			String line = null;
			
			while ((line = reader.readLine()) != null) {
				result += line.replace("유재석", "메뚜기") + "\r\n";
			}
			reader.close();
			
			filePath = PATH + "\\이름수정_변환.dat";
			BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));
			
			writer.write(result);
			
			writer.close();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		System.out.println("변환 완료");
	}

	private static void ex4() {
		/*
		문제4.
		요구사항] 임의의 숫자를 10개를 입력받아 파일에 저장하시오.
		입력] 숫자 : 5
				숫자 : 3
				숫자 : 100
				숫자 : 22
				..

		파일저장]
		100
		22
		5
		3

		조건] 배열 or 컬렉션 사용하지 말 것
		*/
		
		String filePath = PATH + "\\number.dat";
		
		try {
			
			Scanner scan = new Scanner(System.in);
			
			//for (int i = 0; i < 10; i++) {
			for (int i = 0; i < 4; i++) {
				System.out.print("숫자 : ");
				
				
			}
			
			
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
	}

	private static void ex5() {
		/*
		문제5.
		리소스] 일기.dat
		요구사항] 적혀있는 문장들을 역순으로 저장하시오.
		조건] 일기_역순.dat
		*/
		
		String filePath = PATH + "\\일기.dat";
		
		try {
			BufferedReader reader = new BufferedReader(new FileReader(filePath));
			ArrayList<String> note = new ArrayList<String>();
			
			String line = null;
			
			while((line = reader.readLine()) != null) {
				note.add(line);
			}
			reader.close();
			
			filePath = PATH + "\\일기_역순.dat";
			BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));
			
			for (int i = note.size()-1; i > -1; i--) {
				writer.write(note.get(i));
				writer.newLine();
			}
			writer.close();

		} catch (Exception e) {
			// TODO: handle exception
		}
		System.out.println("저장 완료");
	}

	private static void ex6() {
		/*
		문제6.
		리소스] 단일검색.dat
		요구사항] 이름을 검색 -> 해당 회원의 모든 정보를 출력하시오.
		입력] 이름 : 홍길동
		출력]
		번호 : 33
		이름 : 홍길동
		주소 : 서울시 강남구 역삼동
		전화 : 010-2345-6778
		*/
		
		String filePath = PATH + "\\단일검색.dat";
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("이름 : ");
		String name = scan.nextLine();
		
		try {
			BufferedReader reader = new BufferedReader(new FileReader(filePath));
			
			String line = null;
			
			boolean flag = false;
			
			while ((line = reader.readLine()) != null) {
				
				String[] list = line.split(",");
				
				if (list[1].equals(name)) {
					System.out.println("번호 : " + list[0]);
					System.out.println("이름 : " + list[1]);
					System.out.println("주소 : " + list[2]);
					System.out.println("번호 : " + list[3]);
					flag = true;
					break;
				}
			}
			reader.close();
			
			//파일에 값이 존재하지 않으면 Error
			if (flag == false) throw new Exception();
			
		} catch (Exception e) {
			System.out.println("ex6 : " + e.toString());
		}
		
	}

	


	private static void ex7() {
		/*
		문제7.
		리소스] 검색_회원.dat, 검색_주문.dat
								주문번호, 주문품목, 주문수량, 회원 번호
		요구사항] 이름을 검색 -> 주문내역을 출력하시오.  -> 여러개 있을 수 있다고 가정
		입력] 회원명 : 홍길동
		출력]
		구매내역
		[번호(판매내역)]	[이름]	[상품명]	[개수]	[배송지]
		3					홍길동	마우스		3		서울시 강동구 길동
		사용] 컬렉션 2개 사용
		*/
		
		
		
		//ArrayList<Member> memberList = new ArrayList<Member>();
		//ArrayList<OrderList> orderList = new ArrayList<OrderList>();
		
		String filePath = PATH + "\\검색_회원.dat";
		ArrayList<Member> memberList = new ArrayList<Member>(mkMember(filePath));
		
		filePath = PATH + "\\검색_주문.dat";
		ArrayList<OrderList> orderList = new ArrayList<OrderList>(mkOrder(filePath));
		
		Scanner scan = new Scanner(System.in);
		System.out.print("회원명 : ");
		String name = scan.nextLine();
		
		System.out.println("[번호]	[이름]	[상품명]  [개수]	[배송지]");
		
		//멤버에서 해당 회원 찾기
		for (Member list : memberList) {
			if (list.getName().equals(name)) {
				//주문에서 회원의 id찾기
				for (OrderList order : orderList) {
					if(order.getId().equals(list.getId())) {
						
						String result = String.format("%3s\t%s\t%4s  %5s\t\t%s"
														, order.getGoodsNum()
														, list.getName()
														, order.getGoods()
														, order.getOrderNum()
														, list.getAddress());
						System.out.println(result);
					}
				}
				break;
			}
		}
	}

	private static ArrayList<Member> mkMember(String filePath) {
		ArrayList<Member> memberList = new ArrayList<Member>();
		try {
			
			BufferedReader reader = new BufferedReader(new FileReader(filePath));
			
			String line = null;
			
			while((line = reader.readLine()) != null) {
				String[] s = line.split(",");
				
				Member m = new Member();
				m.setId(s[0]);
				m.setName(s[1]);
				m.setAddress(s[2]);
				memberList.add(m);
			}
			reader.close();
					
		} catch (Exception e) {
			System.out.println("eex7" + e.toString());
		}
		return memberList;
	}
	
	private static ArrayList<OrderList> mkOrder(String filePath) {
		ArrayList<OrderList> orderList = new ArrayList<OrderList>();
		try {
			
			BufferedReader reader = new BufferedReader(new FileReader(filePath));
			
			String line = null;
			
			while((line = reader.readLine()) != null) {
				String[] s = line.split(",");
				
				OrderList o = new OrderList();
				o.setGoodsNum(s[0]);
				o.setGoods(s[1]);
				o.setOrderNum(s[2]);
				o.setId(s[3]);
				orderList.add(o);
			}
			reader.close();
					
		} catch (Exception e) {
			System.out.println("eex7" + e.toString());
		}
		return orderList;
	}

	private static void ex8() {
		/*
		문제8.
		리소스] 괄호.java
		요구사항] 괄호들이 쌍이 맞는지 안맞는지 검사?
		결과] 올바른(올바르지 않은) 소스입니다.
		대상] (), {}
		사용] Stack
		*/
		
		String filePath = PATH + "\\괄호.java";
		
		try {
			BufferedReader reader = new BufferedReader(new FileReader(filePath));
			Stack<Character> stack = new Stack<Character>();
			
			String line = null;
			
			while((line = reader.readLine()) != null) {
				//주석문 제외
				if (line.startsWith("//")) continue;
				
				for (int i = 0; i < line.length(); i++) {
					if (line.charAt(i) == '(' || line.charAt(i) == '{' || line.charAt(i) == ')' || line.charAt(i) == '}') {
						stack.push(line.charAt(i));
						stackTest(stack);
					}
				}

			}
			reader.close();
			
			if(stack.size() == 0) System.out.println("올바른 소스입니다.");
			else System.out.println("올바르지 않은 소스입니다.");
			
		} catch (Exception e) {
			System.out.println("ex8 : " + e.toString());
		}
		
		
		
	}

	private static void stackTest(Stack<Character> stack) {
		if (stack.lastIndexOf('(') - stack.lastIndexOf(')') == -1 || stack.lastIndexOf('{') - stack.lastIndexOf('}') == -1) {
			stack.pop();
			stack.pop();
			//stackTest(stack);
		} 
	}


	private static void ex9() {
		/*
		문제9.
		리소스] 자바소스.java, 자바예약어.dat
		요구사항] 소스에서 예약어가 총 몇회 사용되었는지?
		결과]
		if : 5회
		countinue : 2회
		..
		abstract : 0회
		*/
		
		String filePath = PATH + "\\자바예약어.dat";
		
		try {
			BufferedReader reader = new BufferedReader(new FileReader(filePath));
			
			String line = null;
			
			while ((line = reader.readLine()) != null) {
				System.out.println(line + " : " + count(line) + "회");
			}
			reader.close();
		} catch (Exception e) {
			System.out.println("eex9" + e.toString());
		}
	}

	private static int count(String word) {
		String filePath = PATH + "\\자바소스.java";
		int count = 0;
		try {
			BufferedReader reader = new BufferedReader(new FileReader(filePath));
			
			String line = null;
			
			while((line = reader.readLine()) != null) {
				while (line.contains(word)) {
					line = line.substring(line.indexOf(word) + word.length());
					count++;
				}
			}
			reader.close();
		} catch (Exception e) {
			System.out.println("ecount" + e.toString());
		}
		return count;
	}


	private static void ex10() {
		/*
		문제10.
		리소스] 출결.dat
		요구사항] 각 직원별로 지각 횟수, 조퇴횟수를 카운트하시오.
		조건] 출근 : 정각 9시
				퇴근 : 정각 6시
		결과] 총카운트
		추가] 날짜별 카운트
		*/
		
		String filePath = PATH + "\\출결.dat";
		
		ArrayList<TimeTable> list = new ArrayList<TimeTable>(); 
		
		try {
			BufferedReader reader = new BufferedReader(new FileReader(filePath));
			
			String line = null;
			
			while((line = reader.readLine()) != null) {
				String[] organ = line.split(",");
				
				TimeTable t = new TimeTable();
				 t.setDate(organ[0]);
				 t.setName(organ[1]);
				 t.setHello(organ[2]);
				 t.setBye(organ[3]);
				 list.add(t);
			}
			reader.close();
			
		} catch (Exception e) {
			System.out.println("ex10 : " + e.toString());
		}
		System.out.println("출근 : " + hello(list));
		System.out.println("퇴근 : " + bye(list));
		
	}

	private static String hello(ArrayList<TimeTable> list) {
		//출근 : 정각 9시
		for (TimeTable time : list) {
			GetTime(time.getHello());
			//if (Integer.parseInt(time.getHello()) > 9)
		}
		return null;
	}
	


	private static String bye(ArrayList<TimeTable> list) {
		// TODO Auto-generated method stub
		return null;
	}
	

	private static void GetTime(String hello) {
		// TODO Auto-generated method stub
		
	}
	
}



class Home10_Ex2 {
	
	private String name;
	private String kor;
	private String eng;
	private String math;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getKor() {
		return kor;
	}
	public void setKor(String kor) {
		this.kor = kor;
	}
	public String getEng() {
		return eng;
	}
	public void setEng(String eng) {
		this.eng = eng;
	}
	public String getMath() {
		return math;
	}
	public void setMath(String math) {
		this.math = math;
	}
	
}


class search {
	private String number;
	private String name;
	private String address;
	private String tel;
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
}


class Member {
	private String id;
	private String name;
	private String address;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
}

class OrderList {
	private String goodsNum;
	private String goods;
	private String orderNum;
	private String id;
	
	public String getGoodsNum() {
		return goodsNum;
	}
	public void setGoodsNum(String goodsNum) {
		this.goodsNum = goodsNum;
	}
	public String getGoods() {
		return goods;
	}
	public void setGoods(String goods) {
		this.goods = goods;
	}
	public String getOrderNum() {
		return orderNum;
	}
	public void setOrderNum(String orderNum) {
		this.orderNum = orderNum;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
}

class TimeTable {
	private String date;
	private String name;
	private String hello;
	private String bye;
	
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getHello() {
		return hello;
	}
	public void setHello(String hello) {
		this.hello = hello;
	}
	public String getBye() {
		return bye;
	}
	public void setBye(String bye) {
		this.bye = bye;
	}
	
}































