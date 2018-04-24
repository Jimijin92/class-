import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Calendar;
import java.util.Date;

class ExDateTime {
	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		//����1
		System.out.print("�⵵ : ");
		int birthYear = Integer.parseInt(reader.readLine());
		
		age(birthYear);

		//����2
		System.out.print("���� : ");
		String man = reader.readLine();
		System.out.print("���� : ");
		String woman = reader.readLine();
		System.out.print("�� : ");
		int year = Integer.parseInt(reader.readLine());
		System.out.print("�� : ");
		int month = Integer.parseInt(reader.readLine());
		System.out.print("�� : ");
		int date = Integer.parseInt(reader.readLine());

		day(man, woman, year, month, date);

		//����3
		System.out.println("���ϴ� ���� �ð�");
		System.out.print("�� : ");
		int hour = Integer.parseInt(reader.readLine());
		System.out.print("�� : ");
		int minute = Integer.parseInt(reader.readLine());

		delivery(hour, minute);
	}

	public static void age(int birthYear) {
		Calendar c = Calendar.getInstance();
		int nowYear = c.get(Calendar.YEAR);

		int age = nowYear - birthYear + 1;

		System.out.printf("���� : %d��\n\n", age);
	} //age()

	public static void day(String man, String woman, int year, int month, int date) {
		Calendar c = Calendar.getInstance();
		
		System.out.println("======================================================");
		System.out.printf("\t\t'%s'��(��) '%s'�� �����\n", man, woman);
		System.out.println("======================================================");
		
		c.set(year, month, date, 0, 0, 0);
		c.add(Calendar.DATE, 100);
		int year1 = c.get(Calendar.YEAR);
		int month1 = c.get(Calendar.MONTH);
		int date1 = c.get(Calendar.DATE);
		System.out.printf("100�� : %d�� %d�� %d��\n", year1, month1, date1);

		c.set(year, month, date, 0, 0, 0);
		c.add(Calendar.DATE, 200);
		year1 = c.get(Calendar.YEAR);
		month1 = c.get(Calendar.MONTH);
		date1 = c.get(Calendar.DATE);
		System.out.printf("200�� : %d�� %d�� %d��\n", year1, month1, date1);

		c.set(year, month, date, 0, 0, 0);
		c.add(Calendar.DATE, 300);
		year1 = c.get(Calendar.YEAR);
		month1 = c.get(Calendar.MONTH);
		date1 = c.get(Calendar.DATE);
		System.out.printf("300�� : %d�� %d�� %d��\n", year1, month1, date1);

		c.set(year, month, date, 0, 0, 0);
		c.add(Calendar.DATE, 500);
		year1 = c.get(Calendar.YEAR);
		month1 = c.get(Calendar.MONTH);
		date1 = c.get(Calendar.DATE);
		System.out.printf("500�� : %d�� %d�� %d��\n", year1, month1, date1);

		c.set(year, month, date, 0, 0, 0);
		c.add(Calendar.DATE, 1000);
		year1 = c.get(Calendar.YEAR);
		month1 = c.get(Calendar.MONTH);
		date1 = c.get(Calendar.DATE);
		System.out.printf("1000�� : %d�� %d�� %d��\n\n", year1, month1, date1);
	} //day()

	public static void delivery(int hour, int minute) {
		Calendar c = Calendar.getInstance();
		int nowHour = c.get(Calendar.HOUR_OF_DAY);
		int nowMinute = c.get(Calendar.MINUTE);

		int aHour = minute < 10 ? hour - 1 : hour;
		int aMinute = minute < 10 ? minute - 10 + 60 : minute - 10;
		System.out.printf("¥��� : %d�� %d��\n", aHour, aMinute);

		aHour = minute < 18 ? hour - 1 : hour;
		aMinute = minute < 18 ? minute - 18 + 60 : minute - 18;
		System.out.printf("ġŲ : %d�� %d��\n", aHour, aMinute);

		aHour = minute < 25 ? hour - 1 : hour;
		aMinute = minute < 25 ? minute - 25 + 60 : minute - 25;
		System.out.printf("���� : %d�� %d��\n", aHour, aMinute);
	} //delivery()
}
