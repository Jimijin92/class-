import java.io.BufferedReader;                               
import java.io.InputStreamReader;




class Examif

{
	public static void main(String[] args) throws Exception 
	{
	m2();
	

	 /*���� 2.
	 �䱸����] ������ �Է¹޾� ������ ����Ͻÿ�.
	 �Է�]  ���� : 85
	 ���] �Է��� ���� 85���� B�Դϴ�.

	 ����] 90~100:A
		   80~89:B
		   70~79:C
		   60~69:D
		   0~59:F */

	}//main
	
	
	
	
	public static void m2()throws Exception {

 
	 

		    BufferedReader reader = new BufferedReader(new
			InputStreamReader(System.in));
								 
	 

			System.out.println("���� :");
			String score=reader.readLine();
			  
			int intscore=Integer.parseInt(score); 

  

		    if(intscore>=90){
				System.out.printf("�Է��� ���� %d�� A�����Դϴ�\n.",intscore);
			}			
			else if(intscore>=80){
				System.out.printf("�Է��� ���� %d�� B�����Դϴ�\n.",intscore);
			}				
			else if (intscore>=70){
				System.out.printf("�Է��� ���� %d�� C�����Դϴ�\n.",intscore);
			}
			else if (intscore>=60){
				System.out.printf("�Է��� ���� %d�� D�����Դϴ�\n.",intscore);
			}
			else{
				System.out.printf("�Է��� ���� %d�� F�����Դϴ�\n.",intscore);
			}
			


	}

	






}
