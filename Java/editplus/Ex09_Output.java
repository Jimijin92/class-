class Ex09_Output {

	public static void main(String[] args) {

		//Ex09_Output.java

		//�ܼ� �⺻ �����, Console Input / Output -> IO
		//	- �⺻ �Է� ��ġ : Ű����
		//	- �⺻ ��� ��ġ : ����� 
		//	- �⺻ ���� ��ġ : �����

		//Ŭ����.������Ƽ.�޼ҵ�();
		//System.out.println();
		

		//�ܼ� ���
		//1. print �޼ҵ�
		//	- ������ ����ϰ� �׳� ����

		//2. println �޼ҵ�, print line
		//	- ������ ����ϰ� �����ϰ� ����


		//3. printf �޼ҵ�, print format
		//	- ���� ���ڸ� �����ϴ� ���
		//	- ����ϴ� ���ڿ��� ���� ������ ����� ������ ����
		//  - ���Ĺ��� ���
		//		a. %s : String
		//		b. %d : Deciaml(byte, short, int, long)
		//		c. %f : Float(float, double)
		//		d. %c : char(char)
		//		e. %b : boolean(boolean)
				


		System.out.print(100);
		System.out.print(200);
		System.out.println();  //ln ������ ����
		System.out.print(300 + "\n");
		
		System.out.println();  
		System.out.println();  

		//����ǥ
		System.out.println("[�̸�]\t[����]\t[����]\t[����]");
		System.out.println("ȫ�浿\t80\t100\t95"); //���ڶ��� �ִ� ������ �������� 
		System.out.print("�ƹ���\t");
		System.out.print("85\t");
		System.out.print("77\t");
		System.out.print("60");
		System.out.println();

		//�䱸����] "ȫ�浿��. �ȳ��ϼ���." ���
		String name = "ȫ�浿";
		System.out.println(name + "��. �ȳ��ϼ���.");
		System.out.printf("%s��. �ȳ��ϼ���.\n", name); //%s�� ��� �ټ��ִ� ��

		int age = 20;
		System.out.println("ȫ�浿�� ���̴�" + age + "���Դϴ�");
		System.out.printf("ȫ�浿�� ���̴� %d���Դϴ�.\n",age); //�ڸ��þ��ִ� �ְ� �ѵ��� �ƴ�, ������ Ÿ�Կ� ���� �ٸ�/%d�� ���� byte short int �� ����
		System.out.println("����" + name + "�Դϴ�. �� ���̴�" + age + "���Դϴ�.");
		System.out.printf("���� %s�Դϴ�. �� ���̴� %d���Դϴ�\n.",name, age);

		//����Ŭ -> SQL
		//insert into tblStudent (num, naem, age, address) values (10, 'ȫ�浿', 20, '����� ������')
		int num = 10;
		String address = "����� ������";

		System.out.println("insert into tblStudent (num, naem, age, address) values (" + num + ", '" + name + "', " + age + ", '" + address + "')");

		System.out.printf("insert into tblStudent (num, naem, age, address) values (%d, '%s', %d, '%s')\n", num, name, age, address);


		//FM ���
		System.out.printf("���ڿ� : %s\n","ȫ�浿");
		System.out.printf("���� : %d\n", 100);
		System.out.printf("�Ǽ� ; %f\n", 3.14);
		System.out.printf("���� : %c\n", 'A');
		System.out.printf("�� : %b\n", true);
		


		//��ȯ��� -> �̰� ����Ȯ�� ���� ������ �򰥸���
		System.out.printf("���� ; %s\n", 200);
		System.out.printf("�Ǽ� : %d\n", (int)3.14); //3.14�� (int)�־ ������ �ٲٴ��� d�� f�� �ٲٴ���
		System.out.printf("�Ǽ� : %d\n", (int)'A');
		System.out.printf("�Ǽ� : %c\n", 65);



		
	}

}
