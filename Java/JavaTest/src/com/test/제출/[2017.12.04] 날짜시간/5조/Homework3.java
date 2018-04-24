import java.util.Calendar;
import java.util.Date;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class Homework3 {
	public static void main(String[] args)throws Exception {
		
		
		//Homework3.java
		
		//age();
		//anniversary();
		delivery();
		
	}//main()
	
	public static void age() throws Exception {
		/*
		����1.
		�䱸����] �¾ �⵵�� �Է¹޾� ���̸� ����Ͻÿ�.
		�Է�] �⵵ : 1995
		���] ���� : 23��
		����] ���� �⵵�� ����, �츮 ���� ����
		*/
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		Calendar nowYear = Calendar.getInstance();
		int now = nowYear.get(Calendar.YEAR);
		System.out.print("�⵵ :");
		int year = Integer.parseInt(reader.readLine());
		int age = now - year +1;
		System.out.printf("���� : %d\n",age);
		
	}//age()
	

	public static void anniversary() throws Exception {
		
		/*
		����2.
		�䱸����] ���ڿ� ������ �̸� �Է� + ������ �Է¹޾� -> ����� ���
		�Է�] ���� : ȫ�浿
			  ���� : ȣȣȣ
			  �� : 2017
			  �� : 12
			  �� : 4
		*/
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		Calendar anniversary = Calendar.getInstance();
		System.out.print("���� : ");
		String man = reader.readLine();
		System.out.print("���� : ");
		String girl = reader.readLine();
		System.out.print("�� : ");
		int year = Integer.parseInt(reader.readLine());
		System.out.print("�� : ");
		int month = Integer.parseInt(reader.readLine())-1;
		System.out.print("�� : ");
		int date = Integer.parseInt(reader.readLine());

		anniversary.set(year,month,date);

		System.out.println("===============================================");
		System.out.printf("            '%s'��(��) '%s'�� �����\n",man,girl);
		System.out.println("===============================================");
		
		anniversary.add(Calendar.DATE, 100);
		year = anniversary.get(Calendar.YEAR);
		month = anniversary.get(Calendar.MONTH)+1;
		date = anniversary.get(Calendar.DATE);
		System.out.printf("100�� : %d�� %d�� %d�� \n",year,month,date);
		
		anniversary.add(Calendar.DATE, 100);
		year = anniversary.get(Calendar.YEAR);
		month = anniversary.get(Calendar.MONTH)+1;
		date = anniversary.get(Calendar.DATE);
		System.out.printf("200�� : %d�� %d�� %d�� \n",year,month,date);

		anniversary.add(Calendar.DATE, 300);
		year = anniversary.get(Calendar.YEAR);
		month = anniversary.get(Calendar.MONTH)+1;
		date = anniversary.get(Calendar.DATE);
		System.out.printf("500�� : %d�� %d�� %d�� \n",year,month,date);

		anniversary.add(Calendar.DATE, 500);
		year = anniversary.get(Calendar.YEAR);
		month = anniversary.get(Calendar.MONTH)+1;
		date = anniversary.get(Calendar.DATE);
		System.out.printf("1000�� : %d�� %d�� %d�� \n",year,month,date);

	}//anniversary()
	
	public static void delivery() throws Exception{
		/*
		����3.
		�䱸����] ����� ���ÿ� �ޱ⸦ ���ϴ� ��. ������ ������ ���� �ֹ�
		����] ¥���10�� �� ����
			  ġŲ  18�� �� ����
			  ����  25�� �� ����
		�Է�] ���ϴ� ���� �ð�
			  �� : 17
			  �� : 30
		���] ¥��� : 17�� 20��
			  ġŲ : 17�� 12��
			  ���� : 17�� 5��
		*/
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("���ϴ� ���� �ð�");
		System.out.print("�� : ");
		int hour = Integer.parseInt(reader.readLine());
		System.out.print("�� : ");
		int min = Integer.parseInt(reader.readLine());

		Calendar deliveryTime = Calendar.getInstance();
		deliveryTime.set(Calendar.HOUR_OF_DAY, hour);
		deliveryTime.set(Calendar.MINUTE, min);
	

		deliveryTime.add(Calendar.MINUTE,-10);
		System.out.printf("¥��� : %tR\n",deliveryTime);
		deliveryTime.add(Calendar.MINUTE,-8);
		System.out.printf("ġŲ : %tR\n",deliveryTime);
		deliveryTime.add(Calendar.MINUTE,-7);
		System.out.printf("���� : %tR\n",deliveryTime);


	}//delivery()

}
