class Ex06_EscapeSequence {

	public static void main(String[] args) {
	//Ex06_EscapeSequence.java 
	//	- Ư������
	//	- Escape Character
	//	- �ڷ����� char��
	//	- ����� ���� �����Ͱ� �ƴ϶� �̹� ��ӵ� �ൿ�� �ϱ� ���� Ư���� ����


	//1. \n
	//	- new line
	//	- ���� ����
	char c1 = '\n';


	String s1 = "�ȳ��ϼ���.\nȫ�浿��";
	System.out.println(s1);
	

	//2. \r 
	//	- carriage return
	//	- Ŀ��(ĳ��)�� ��ġ�� ���� ������ ó��(ù��° �÷�)���� �̵��ض�
	System.out.println("�ϳ���\r�³�");

	//���� = \r + \n
	System.out.println("�ϳ�\r\n��");
	System.out.println("�ϳ�\n��");

	//3. \b
	//	- backspace (���� ���� ����� �Ѱ���)
	System.out.println("ȫ��\b��");
	System.out.println("ȫ�浿��\b\b\b\b����");


	//4. \t
	//	- tab? ���� ����� ������ �̵��ض� -> �����߱� ���ؼ� ����Ѵ�.
	System.out.println("ȫ��\t��");


	String name = "ȫ�浿";
	String height = "18";
	String adress = "����� ������ ���ﵿ";
	
	System.out.println("�̸� : \t" + name); //concat
	System.out.println("Ű : \t" + height + "cm"); 
	System.out.println("���ּ� : \t" + adress); 

	System.out.println("���ڿ�" + 100);//100�� "100�� ����"
	

	//5. \", \', \\

	//�䱸����] ȭ�鿡 <�ȳ��ϼ���. "ȫ�浿"�Դϴ�.> 
	System.out.println("�ȳ��ϼ���. \"ȫ�浿\"�Դϴ�.");

	//�䱸����] ���� ���� ������ ��θ� ���
	String path = "D:\\Class\\JAVA";
	System.out.println(path);

	// \f, \a
	//���ڵ����͸� ����� �� ������ �� 
	//�ֹε�Ϲ�ȣ�� ���ڸ��� �����ؾ� �Ѵ�.
	// - 901220
	int jumin1 = 901220;
	System.out.println("�ֹι�ȣ : " + jumin1);

	jumin1 = 011125;
	System.out.println("�ֹι�ȣ : " + jumin1);

	String jumin2 = "011125"; //0���� �����ϸ� �����̶� ""�ٿ��ֱ�
	System.out.println("�ֹι�ȣ : " + jumin2);
	
	//�ֹι�ȣ, ��ȭ��ȣ, ��ǰ��ȣ, �л���ȣ, �۹�ȣ ��....
	// - ���´� ���������� ���� ������ ���ڿ� 
	// - ���� ���� �����Ͱ� ��� ������ �ұ? �ֹι�ȣ ���ϱ� 100? �Խ��� 100�� ���ϱ� 100?



		//�ĺ��� ǥ��� -> ����
		
		//1. �밡���� ǥ���
		//	- �ڷ����� �ĺ��ڿ� �ִ� ���
		//  - �ڹ�) �������̽���(Itest)
		
		String name;
		String strName;

		int num;
		int inum;


		//2. �Ľ�Į ǥ���
		//	- �ĺ��ڰ� �Ѵܾ� Ȥ�� �Ѵܾ� �̻����� ���� -> ��� �ܾ ������� ���� + ��� ���� �ҹ��� + ���ܾ��� ù���� �빮�� 
		//	- �ڹ�) Ŭ������
		String StudentName;

		NumberPaser

		//3. ĳ�� ǥ���
		//	- �ĺ��ڰ� �Ѵܾ� Ȥ�� �Ѵܾ� �̻����� ���� -> ��� �ܾ ������� ���� + ��� ���� �ҹ��� + ���ܾ��� ù���� �빮�� + ���� ���ڸ��� �ҹ��ڷ�
		//	- �ڹ�) ������, �޼ҵ��
		String studentName;
	





















	}

}
