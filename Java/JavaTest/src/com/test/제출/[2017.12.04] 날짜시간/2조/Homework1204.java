import java.util.*;
import java.io.*;

class Homework1204 {
	public static void main(String[] args) throws Exception
	{
		

		/*
		���� 1. 
		�䱸����] �¾ �⵵�� �Է¹޾� ���̸� ����Ͻÿ�.
		�Է�]	�⵵ : 1995
		���]	���� : 23��
		����] ���� �⵵�� ��������, �츮���� ���� ��������~
		*/
		System.out.println("===����1===");
		printAge();

		/*
		����2.
		�䱸����] ���ڿ� ������ �̸��� �Է¹ޱ� + ������ �Է¹ޱ� ->������� ����ϱ�
		�Է�]	�����̸� : ȫ�浿
				�����̸� : ȣȣȣ
				�� : 2017
				�� : 12
				�� : 4
		���]
		==============================
		'ȫ�浿'�� 'ȣȣȣ'�� �����
		==============================
		100�� : 2018�� 3�� 28��
		200�� : 
		300�� : 
		500�� :
		1000�� :
		*/
		System.out.println();
		System.out.println("===����2===");
		anniversary();


		/*
		����3.
		�䱸����] ��������� ���Ѹ԰�ʹ� , �������������� ���ÿ� �԰�ʹ�(���ÿ� ��� �ް�ʹ�)
		������ ������ ���� �ֹ��ϸ�Ǵ���? 
		����]	����� 10���� ����
			ġŲ 18�� �� ����
			���� 25�� �� ����

		�Է�]	���ϴ� ���� �ð�
			�� : 17
			�� : 30

		���]	¥��� : 17��20��
			ġŲ : 17�� 12��
			���� : 17�� 5��
		*/
		System.out.println();
		System.out.println("===����3===");
		deliveryTime();


	}//main

	public static void printAge() throws Exception {

		BufferedReader reader = new BufferedReader(new
		InputStreamReader(System.in));

		System.out.print("�⵵ : ");
		String year = reader.readLine();
		int intYear = Integer.parseInt(year);

		Calendar now = Calendar.getInstance();

		System.out.printf("���� : %d��\n", (now.get(Calendar.YEAR)-intYear)+1);
	
	}//getAge


	public static void anniversary()throws Exception{

		BufferedReader reader = new BufferedReader(new
		InputStreamReader(System.in));

		System.out.print("�����̸� : ");
		String boy = reader.readLine();

		System.out.print("�����̸� : ");
		String girl = reader.readLine();

		System.out.print("�� : ");
		String year = reader.readLine();
		int intYear = Integer.parseInt(year);
		System.out.print("�� : ");
		String month = reader.readLine();
		int intMonth = Integer.parseInt(month);
		System.out.print("�� : ");
		String day = reader.readLine();
		int intDay = Integer.parseInt(day);

		System.out.println("================================");
		System.out.printf("'%s'��(��) '%s'�� �����\n",boy,girl);
		System.out.println("================================");

		Calendar first = Calendar.getInstance();
		first.set(intYear,intMonth-1,intDay); 

	
		first.add(Calendar.DATE,100);
		System.out.printf("100�� : %d�� %d�� %d��\n",first.get(Calendar.YEAR),first.get(Calendar.MONTH)+1,first.get(Calendar.DATE));

		first.add(Calendar.DATE,100);
		System.out.printf("200�� : %d�� %d�� %d��\n",first.get(Calendar.YEAR),first.get(Calendar.MONTH)+1,first.get(Calendar.DATE));

		first.add(Calendar.DATE,100);
		System.out.printf("300�� : %d�� %d�� %d��\n",first.get(Calendar.YEAR),first.get(Calendar.MONTH)+1,first.get(Calendar.DATE));

		first.add(Calendar.DATE,200);
		System.out.printf("500�� : %d�� %d�� %d��\n",first.get(Calendar.YEAR),first.get(Calendar.MONTH)+1,first.get(Calendar.DATE));

		first.add(Calendar.DATE,500);
		System.out.printf("1000�� : %d�� %d�� %d��\n",first.get(Calendar.YEAR),first.get(Calendar.MONTH)+1,first.get(Calendar.DATE));

	}//anniversary
			/*
		����3.
		�䱸����] ��������� ���Ѹ԰�ʹ� , �������������� ���ÿ� �԰�ʹ�(���ÿ� ��� �ް�ʹ�)
		������ ������ ���� �ֹ��ϸ�Ǵ���? 
		����]	����� 10���� ����
			ġŲ 18�� �� ����
			���� 25�� �� ����

		�Է�]	���ϴ� ���� �ð�
			�� : 17
			�� : 30

		���]	¥��� : 17��20��
				ġŲ : 17�� 12��
				���� : 17�� 5��
		*/
	public static void deliveryTime()throws Exception{

		BufferedReader reader = new BufferedReader(new
		InputStreamReader(System.in));
		
		System.out.print("�� : ");
		String hour = reader.readLine();
		int intHour = Integer.parseInt(hour);
		System.out.print("�� : ");
		String minute = reader.readLine();
		int intMinute = Integer.parseInt(minute);
		
		Calendar arrive = Calendar.getInstance();
		arrive.set(arrive.get(Calendar.YEAR),arrive.get(Calendar.MONTH),arrive.get(Calendar.DATE),intHour,intMinute,arrive.get(Calendar.SECOND));
		
		
		arrive.add(Calendar.MINUTE,-10);
		System.out.printf("¥��� : %d��%d��\n",arrive.get(Calendar.HOUR_OF_DAY),arrive.get(Calendar.MINUTE));
		arrive.add(Calendar.MINUTE,-8);
		System.out.printf("ġŲ : %d��%d��\n",arrive.get(Calendar.HOUR_OF_DAY),arrive.get(Calendar.MINUTE));
		arrive.add(Calendar.MINUTE,-7);
		System.out.printf("���� : %d��%d��\n",arrive.get(Calendar.HOUR_OF_DAY),arrive.get(Calendar.MINUTE));
	
	
	}//deliverytime()



}//class

