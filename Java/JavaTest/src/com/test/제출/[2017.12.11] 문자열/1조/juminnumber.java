import java.util.Scanner;

class juminnumber
{
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		
		System.out.print("주민등록번호 입력 : ");
		String a = scan.nextLine(); 
		 
	
		String jumin= (a.replace("-", ""));
			
	
		if (jumin.length() == 13);
			{
			int num1=Integer.parseInt(jumin.substring(0,1))*2;
			int num2=Integer.parseInt(jumin.substring(1,2))*3;
			int num3=Integer.parseInt(jumin.substring(2,3))*4;
			int num4=Integer.parseInt(jumin.substring(3,4))*5;
			int num5=Integer.parseInt(jumin.substring(4,5))*6;
			int num6=Integer.parseInt(jumin.substring(5,6))*7;
			int num7=Integer.parseInt(jumin.substring(6,7))*8;
			int num8=Integer.parseInt(jumin.substring(7,8))*9;
			int num9=Integer.parseInt(jumin.substring(8,9))*2;
			int num10=Integer.parseInt(jumin.substring(9,10))*3;
			int num11=Integer.parseInt(jumin.substring(10,11))*4;
			int num12=Integer.parseInt(jumin.substring(11,12))*5;
			int num13=Integer.parseInt(jumin.substring(12,13));
			
			int result = num1+num2+num3+num4+num5+num6+
				num7+num8+num9+num10+num11+num12;
				
			result= (11-(result%11))%10;
	

	

	
		if (num13 == result) {
			System.out.println("올바른 주민번호입니다.");
		
		} else { 
	
			System.out.println("올바르지 않은 주민번호 입니다..");
		}
	
		
		
	
	
		
		}
	

	}//메인



	
	
}//클래스마감



	
	
	
	

	
	
	
	