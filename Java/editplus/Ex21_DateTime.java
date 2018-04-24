import java.util.Calendar;


class Ex21_DateTime {

	public static void main(String[] args) {

		//Ex21_DateTime.java
		
		//��¥�ð���
		//	- ������
		//	- Date Ŭ����
		//	- Calendar Ŭ����(***)

		//8���� �⺻�� + String + ��¥�ð���
		





		// �ð� = ��ġ // �ð� = ��
		//1. �ð� + �ð� // ���x (�ð�). ������ �޶� ��� �ȵ�/ �Ѵ޿� ���� ���Ǹ� ���� ���� ����.
		//2. �ð� - �ð� // ��뤷(�ð�). �ð����� �ð��� ���� �ð��� ����
		//3. �ð� + �ð� // �ð� 
		//4. �ð� + �ð� // �ð�
		//5. �ð� - �ð� // �ð�
		// ���α׷������δ� ���� �� ���� �ȳѾ (�ð��� �ִ�)

		//2018. 6. 30 12:00:00
		//2017. 12. 4 12:35:00

		//1970. 1. 1 ���������� ��� 
		
		//m1();
		//m2();
		//m3();
		//m4();
		//m5();
		//m6();
        m7();

	}//main


		public static void m7(){

			//1. ���� �ð� ��� : Calendar.getInstance()
			//2. Ư�� �ð� ��� : Calendar.getInstance() -> set() ���
			//3. Ư�� �ð� ��� : int ����
			//4. �ð� - �ð� : tick�� ���
			//5. �ð� + �ð� : int ����
			//6. �ð� - �ð� : int ����
			//7. �ð� + �ð� : add() ���
			//8. �ð� - �ð� : add() ���

			//2�ð� 30�� �ʿ�
			//Calendar c = Calendar.getInstance();
			//c.set(Calendar.HOUR, 2);
			//c.set(Calendar,MINUTE, 30);

			int hour = 2;
			int min = 30;
		
		}

		public static void m6() {

			//�ð� - �ð� = �ð�
			//  : Ư�� ������ �������� �ؼ� ���� �ð��� ���� -> ������ ���� ��Ų �� ����
			//�¾�� �� �ð�?
			//  : ���� - ����
			
			Calendar now = Calendar.getInstance();
			Calendar birthday = Calendar.getInstance();
			birthday.set(1995, 2, 25, 13, 30, 0);

			//System.out.println(now -birthday);  -> ������

			//tick ���ϱ�
			//1. ���� �ð��� tick
			System.out.println(System.currentTimeMillis());

			//2. 
		    Date nowDate = now.getTime();
			long nowTick = nowDate.getTime();
			System.out.println(nowTick);

			Date birthdayDate = birthday.getTime();
			long birthdayTick = birthdayDate.getTime();
			System.out.println(birthdayTick);

			long span = nowTick - birthdayTick;

			System.out.println(span / 1000 / 60 / 60 / 24);

			//���� ũ���������� ��ĥ ���ҽ��ϱ�?
			//  : ũ�������� - ����
		    Calendar christmas = Calendar.getInstance();
			christmas.set(2017, 11, 25, 0, 0, 0); //���� ������ �ʴ� �ú��ʵ� ����ض�// ���� �ú��ʷ� ������

			//�޼ҵ� ü�̴�
			long christmasTick = christmas.getTime().getTime();
			
			span = christmasTick - nowTick; //ms

			System.out.println(span / 1000.0 / 60 / 60 / 24); //�Ǽ������� ������ �Ǽ�
		
		}


		public static void m5() {
		
		//����
		// - void add(int, int)
		// - ������ �����Ѵ�.
		
		//100��°?
		// = ����(�ð�) + 100��(�ð�)
		Calendar today = Calendar.getInstance();
		today.add(Calendar.DATE, 100); //������ �ǵ帲
		System.out.printf("100��° : %tF\n", today);

		//��� 5�ð� 35�� ���� 
		today = Calendar.getInstance();
		
		today.add(Calendar.HOUR, 5);
		today.add(Calendar.MINUTE, 35);
		System.out.printf("%tF %tT\n", today, today);


		//100�� ��� Ŀ�� -> ������? 
		today = Calendar.getInstance();
		today.add(Calendar.DATE, -100);
		System.out.printf("100���� : %tT\n", today);

		}//m5


		public static void m4() {
		
			//printf() �޼ҵ�
			//	- ��¥/�ð� ����
			Calendar c = Calendar.getInstance();

			System.out.printf("%tF\n", c); // 2017-12-04
			System.out.printf("%tT\n", c); // 14:48:38
			System.out.printf("%tR\n", c); // 14:49
			System.out.printf("%tr\n", c); // 02:50:13 ����
			System.out.printf("%tA\n", c); // ������




		
		}//m4




	    public static void m3() {
		 

		    // �ϴ� ����ð� �ҷ����� set�޼ҵ�� ���ϴ� �κ� �����ϱ� 
			//m1(), m2() -> ���� �ð�
			//m3() -> Ư�� �ð�

			//�� ���� : 1995�� 3�� 25�� 15�� 30�� 0��
			Calendar birth = Calendar.getInstance();

			//�� ���Ϸ� ��ġ��
			//void set(int, int)
			//void set(int, int, int)
			//void set(int, int, int)
			//void set(int, int, int, int, int, int)

			//birth.set(Calendar.YEAR, 1995);
			//birth.set(Calendar.MONTH, 2);
			//birth.set(Calendar.DATE, 25);

			//�Ϻκ��� �ٲٰ� ������ Ķ���� ���, ��ü�� �����ε� 

            //2017-12-1
			//birth.set(2017, 11, 1);
			//birth.set(Calendar.DATE, 1);

			birth.set(1995, 2, 25, 13, 30, 0);

			System.out.printf("%d-%d-%d\n"
			                              , birth.get(Calendar.YEAR)
				                          , birth.get(Calendar.MONTH) + 1
				                          , birth.get(Calendar.DATE)
										  );
											
		} //m3



		public static void m2() {
		
		Calendar c = Calendar.getInstance();

		//int get(int)
		//System.out.println(c.get(1));
		//System.out.println(c.get(2));
		//System.out.println(c.get(3));
		//System.out.println(c.get(4));
		//System.out.println(c.get(5));
		
		int year = 1;
		int month = 2;
		System.out.println(c.get(year));
		System.out.println(c.get(month));

		//Ķ���� ���
		System.out.println(Calendar.YEAR);
		System.out.println(Calendar.MONTH);

		System.out.println(c.get(Calendar.YEAR));
		System.out.println(c.get(Calendar.MONTH));

		System.out.println();
		System.out.println();
		System.out.println(c.get(Calendar.YEAR)); //��
		System.out.println(c.get(Calendar.MONTH)); //��(0~11)
		System.out.println(c.get(Calendar.DATE)); //��
		System.out.println(c.get(Calendar.HOUR)); //��(12H)
		System.out.println(c.get(Calendar.DAY_OF_YEAR)); //��(24H)
		System.out.println(c.get(Calendar.MINUTE)); //��
		System.out.println(c.get(Calendar.SECOND)); //��
		System.out.println(c.get(Calendar.MILLISECOND)); //�и���
		System.out.println(c.get(Calendar.DAY_OF_WEEK)); //����(1~7)
		System.out.println(c.get(Calendar.AM_PM)); //����(0)����(1)
		
		//"���� ��¥�� 2017�� 12�� 4���Դϴ�." - ���
		System.out.printf("���� ��¥�� %d�� %d�� %d���Դϴ�.\n", c.get(Calendar.YEAR), c.get(Calendar.MONTH) + 1, c.get(Calendar.DATE));



		

		}//m2



		public static void m1() {

		    //���� �ý����� �ð��� ������
			int a;
			a = 10;

			String b;
			b = "���ڿ�";

			Calendar c;
			c = Calendar.getInstance();

			System.out.println(c);

		}//m1


}
