import java.io.*;

class  num_01{

	public static void main(String[] args) throws Exception{
	


 num();


	}//main

/*
����2.
�䱸����] ���� 1���� �Է¹޾� 1���� ~ �Է� ���ڱ����� ���� ����Ͻÿ�.
�Է�] ���� : 5
���] 1 ~ 5 : 15
����] õ���� ��� ,
*/
			
		public static void num()throws Exception{

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
			System.out.print("���� : ");
				int num = Integer.parseInt(reader.readLine());

				int sum = 0;

				for (int i=1; i<=num; i++){
					
					sum += i; 
				}
				System.out.printf("1 ~ %d : %,d \n", num, sum);

				}
	

		     
		

}
