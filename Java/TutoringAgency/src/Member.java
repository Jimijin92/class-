

//회원 1명 분량의 데이터 집합
public class Member {

	//1. 멤버 변수 선언
	
	private String id;
	private String password;
	private String sex;
	private String schoolname;
	private String name;
	private String age; //생각? 숫자형 데이터 -> 산술(비교) 연산 
	private String address;	
	private String tel;
	private String jumin;
	private String depart;
	private String grade;
	
	private String sext;
	private String price;
	private String subject1;
	private String subject2;
	private String type;
	private String num;
	
	//2. 생성자
	public Member(String jumin, String id, String password, String sex, String schoolname,
					String name, String age, String address, String tel, String depart, 
					String grade,  String sext, String price,String subject1, String subject2, String type,
					String num) {
		
		this.jumin = jumin;
		this.id = id;
		this.password = password;
		this.sex =sex;
		this.name = name;
		this.age = age;
		this.address = address;
		this.tel = tel;
		this.schoolname = schoolname;
		this.depart = depart;
		this.grade = grade;
		
		this.sext = sext;
		this.price = price;
		
		this.subject1 = subject1;
		this.subject2 = subject2;
		this.type = type;
		this.num = num;
		
	}


	//4. 개발자용 -> dump 용
	@Override
	public String toString() {
		return String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s"
							, this.jumin
							, this.id
							, this.password
							, this.name
							, this.sex
							, this.age
							, this.address
							, this.tel
							, this.schoolname
							, this.depart
							, this.grade
							
							, this.sext
							, this.price
							, this.subject1
							, this.subject2
							, this.type
							, this.num);
	}
//	
//	
//	
//	
//	
}
//
//
//















