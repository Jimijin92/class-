import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.Calendar; //�ʿ��� �������� import

class Problems3 {

	public static void main(String[] args) throws Exception{
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


		//���� 1
		System.out.print("�¾ �⵵ : ");
		String age = reader.readLine();
		int myAge = Integer.parseInt(age);

		currentAge(myAge);


		//���� 2
		System.out.print("���� �̸� : ");
		String man = reader.readLine();

		System.out.print("���� �̸� : ");
		String woman = reader.readLine();

		System.out.print("�� : ");
		String year = reader.readLine();
		int yearInt = Integer.parseInt(year);

		System.out.print("�� : ");
		String month = reader.readLine();
		int monthInt = Integer.parseInt(month);

		System.out.print("�� : ");
		String date = reader.readLine();
		int dateInt = Integer.parseInt(date); //������ �Էº�

		anniversary(man, woman, yearInt, monthInt, dateInt);


		//���� 3
		System.out.print("�� : ");
		String hour = reader.readLine();
		int hourInt = Integer.parseInt(hour);

		System.out.print("�� : ");
		String minute = reader.readLine();
		int minuteInt = Integer.parseInt(minute);

		delivery(hourInt, minuteInt);

		
	} //main

	public static void currentAge(int n) {
		
		Calendar now = Calendar.getInstance();
		Calendar birth = Calendar.getInstance();


		//now.set(Calendar.MONTH, 0);
		//now.set(Calendar.DATE, 0);
		now.set(Calendar.HOUR, 0);
		now.set(Calendar.MINUTE, 0);
		now.set(Calendar.SECOND, 0);
		
		birth.set(Calendar.YEAR, n);

		long birthYearTick = birth.getTime().getTime();
		long nowTick = now.getTime().getTime();

		double result = ((nowTick - birthYearTick) / 1000.0 / 60 / 60 / 24 / 365);

		System.out.printf("%d����� %.1f�� �Դϴ�.\n\n", n, result+1);

	
	} //currentAge


	public static void anniversary(String man, String woman, int year, int month, int date) {
		
		Calendar now = Calendar.getInstance();

				
		System.out.println("===============================");
		System.out.printf("    '%s'��(��) '%s'�� �����      \n", man, woman);
		System.out.println("===============================\n");

		/*
		now.add(Calendar.DATE, 100);
		System.out.printf("100�� : %tF\n", now);

		now.add(Calendar.DATE, 100);
		System.out.printf("200�� : %tF\n", now);

		now.add(Calendar.DATE, 100);
		System.out.printf("300�� : %tF\n", now);

		now.add(Calendar.DATE, 200);
		System.out.printf("500�� : %tF\n", now);

		now.add(Calendar.DATE, 500);
		System.out.printf("1000�� : %tF\n\n", now);
		*/ //YYYY-MM-DDǥ��
				
		now.add(Calendar.DATE, 100);
		System.out.printf("100�� : %d�� %d�� %d��\n", now.get(Calendar.YEAR), now.get(Calendar.MONTH) + 1, now.get(Calendar.DATE));

		now.add(Calendar.DATE, 100);
		System.out.printf("200�� : %d�� %d�� %d��\n", now.get(Calendar.YEAR), now.get(Calendar.MONTH) + 1, now.get(Calendar.DATE));

		now.add(Calendar.DATE, 100);
		System.out.printf("300�� : %d�� %d�� %d��\n", now.get(Calendar.YEAR), now.get(Calendar.MONTH) + 1, now.get(Calendar.DATE));

		now.add(Calendar.DATE, 200);
		System.out.printf("500�� : %d�� %d�� %d��\n", now.get(Calendar.YEAR), now.get(Calendar.MONTH) + 1, now.get(Calendar.DATE));
		
		now.add(Calendar.DATE, 500);
		System.out.printf("1000�� : %d�� %d�� %d��\n\n\n", now.get(Calendar.YEAR), now.get(Calendar.MONTH) + 1, now.get(Calendar.DATE));
		
		
	} //anniversary


	public static void delivery(int hour, int minute) {

		Calendar time = Calendar.getInstance();
		
				
		time.set(Calendar.HOUR, hour);
		time.set(Calendar.MINUTE, minute);
	

		time.add(Calendar.MINUTE, -10);
		System.out.printf("¥��� : %d�� %d��\n", time.get(Calendar.HOUR_OF_DAY), time.get(Calendar.MINUTE));

		time.add(Calendar.MINUTE, -8);
		System.out.printf("ġŲ : %d�� %d��\n", time.get(Calendar.HOUR_OF_DAY), time.get(Calendar.MINUTE));

		time.add(Calendar.MINUTE, -7);
		System.out.printf("���� : %d�� %d��\n\n", time.get(Calendar.HOUR_OF_DAY), time.get(Calendar.MINUTE));
	
	} //delivery


} //Class Problems3
