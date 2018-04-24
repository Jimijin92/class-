
public class TeacherMember {

	private String jumin;
	private String id;
	private String password;
	private String name;
	private String sex;
	private String age;
	private String address;	
	private String tel;
	private String schoolname;
	private String depart;
	private String tgrade;
	private String career;
	
	private String address1;
	private String address2;
	private String address3;
	private String sgrade;
	private String price;
		
	private String subject1;
	private String subject2;
	
	private String num1; 
	private String num2 ;
	private String num3 ;
	private String num4 ;
	private String num5 ;
	
	
	private String num11 ;
	private String num21;
	private String num31 ;
	private String num41 ;
	private String num51 ;
	
	
	private String type;
	private String num;

	public TeacherMember (String jumin, String id, String password, String name, String sex, String age, String address,
			String tel, String schoolname,  String depart, String tgrade, String career, String address1, String address2, String address3, String sgrade, 
					String price, String subject1, String subject2, String num1, String num11, 
					String num2, String num21, String num3, String num31, String num4, String num41, 
					String num5, String num51,String type, String num) {
		
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
		this.tgrade = tgrade;
		this.career = career;
		
		this.address1 = address1;
		this.address2 = address2;
		this.address3 = address3;
		this.sgrade = sgrade;
		this.price = price;
		
		this.subject1 = subject1;
		this.subject2 = subject2;
		
		this.num1 = num1;
		this.num2 = num2;
		this.num3 = num3;
		this.num4 = num4;
		this.num5 = num5;
		
		this.num11 = num11;
		this.num21 = num21;
		this.num31 = num31;
		this.num41 = num41;
		this.num51 = num51;
		
		
		
		this.type = type;
		this.num = num;
		
	}


	//4. 개발자용 -> dump 용
	@Override
	public String toString() {
		return String.format("%s,%s,%s,%s,%s,"
				+ "%s,%s,%s,%s,%s"
				+ ",%s,%s,%s,%s,%s"
				+ ",%s,%s,%s,%s,%s"
				+ ",%s,%s,%s,%s,%s"
				+ ",%s,%s,%s,%s,%s,%s"
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
							, this.tgrade
							, this.career
							, this.address1
							, this.address2
							, this.address3						
							, this.sgrade
							, this.price
						
							, this.subject1
							, this.subject2
							, this.num1
							, this.num11
							, this.num2
							, this.num21
							, this.num3
							, this.num31
							, this.num4
							, this.num41
							, this.num5
							, this.num51
							
							, this.type
							, this.num
							);
	}

}

