//block 
//class Ex05_Variable { // K&R ��Ÿ��(����̾� Ŀ���� & ���Ͻ� ��ġ)


class Ex05_Variable
{//Allman��Ÿ��

	public static void main(String[] args) {

		//Ex05_Variable.java

		byte a;
		//byte a;
		//int a;
		//a=10;

		//����, ����, ����
		int kor, eng, math; //����, ����, ����
		// � �뵵�� ��������� �ּ��� �޾��ִ°� �߿��ϴ�.
		

		int weight // ������
			, height; // Ű
	

		//���ڷ��� ���� ���� + ������
		

		//������ 
		//1. byte

		//������ ���, ������ ���ͷ� ��� �θ���(����Ʈ��� �ƴ�)
		byte b1 = 10; //b1(����), 10(������, ���, Literal)
		//b1 = 128; //OverFlow Error /�����÷ο� ���� -128~127
		//b1 = -129;//UnderFlow, Error/����÷ο� ���� 
		//-> ���ļ� OverFlow Error��� �θ��⵵ ��


		//2. short
		short s1 = 10;
		//si = 32768;// 32767������ ���� //incompatible types: possible lossy conversation from int to short


        //3. int
		int n1 =10;
		//n1 = 21000000000;//integer number too large: 2200000000

		//4. long
		long l1 = 10;
		//l1 = 10000000000000000L;//integer umber too large:10000000000000000000000 

		//��� ����� �� integer�� ����Ѵ�.

		//���� ������
		// - ���� = ��;
		// - LValue(����) = RValue(����, ���);
		// - �ݵ�� LValue�� RValue�� �ڷ����� ��ġ

		//int a = 10;
		//int b;
		//b = a;

		//�Ǽ���(float�� double�� ���̴� ���е�����/double�� �⺻������ ���� )
		float f1 = 3.14F;
		f1 = 1234567890123456789.1234567890123456789F;
		System.out.println(f1);

		double d1 = 2.58;
		d1 = 1234567890123456789.1234567890123456789;
		System.out.println(d1);

		//����
		boolean flag = true;
		flag = false;
		System.out.println(flag);

        //������
		char c1 = 'A';
		System.out.println(c1);

		c1 = '��';
		System.out.println(c1);

		//c1 = 'ABC';
		//System.out.println(c1);

		c1 = '1';
		System.out.println(c1);



		//�⺻��x
		//������o

		//char : ���� 1��

		//ȫ�浿
		//String : ���� ������

		String name = "ȫ�浿";

		
		//int num = 10;
		int Num = 20;
		int nuM = 30;
		int nUm = 40;

		//�ڹٿ���..
		//������
		//1. �ܾ �ҹ��ڷ� ����
		int NUM = 10;
		int num = 10;

		//�л� ��ȣ
		//Student Number
		int studentNumber; //ĳ�� ǥ���
		int student_number; //������ũ ǥ���
		
		//����� �����
		//10����, 2����, 8����, 16����...

		int n2 = 10; //10����
		System.out.println(n2);

		int n3 = 010; //8����
		System.out.println(n3);

		int n4 = 0x10; //16����
		System.out.println(n4);

	

























     }
}




























