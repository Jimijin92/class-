import java.io.*;

class Num_5_new {
	public static void main(String[] args) throws Exception
	{

		
		//�䱸����] ������ 1���� �Է¹޾� ��/�ҹ��ڸ� ��ȯ/����Ͻÿ�.




	System.out.println("������������������������������������������������");
	System.out.println("�����������ĺ� �ϳ��� �ƹ��ų� �Է��ϼ��䢿������");
	System.out.println("������������������������������������������������");
	BufferedReader reader = new BufferedReader(new InputStreamReader (System.in));

	System.out.print("���� : ");
	String alphabet = reader.readLine();
	char a = alphabet.charAt(0);
	alphabetChange(a);

	A - Z
	65  90

	a - z
	97  122
	32


	}//main

	public static void alphabetChange(char a) {
		
		//int alpha = 0;
		
		//if�� ��� 
		if (a >= 'a' && a <= 'z') {
			System.out.printf("��� : �Է��� ������ �빮�ڴ� %c �Դϴ�\n",
								a - 32);
			//alpha = a - 32;
		} else if (a >= 'A' && a <= 'Z') {
			System.out.printf("��� : �Է��� ������ �ҹ��ڴ� %c �Դϴ�\n", 
								a + 32);
			//alpha = a + 32;
		} else
			System.out.println("�����������ĺ��� �Է��ϼ���!!!!!!!!!!��������");
			//��ȿ�� �˻�


		//System.out.printf("��� : %c\n", alpha);

	}//alphabetChange

}//class