class Ex08_Casting {

	public static void main(String[] args) {

		//����ȯ
		//1. �Ͻ����� ����ȯ
		//2. ������� ����ȯ
		
		//���� -> ����
		
		byte b1 =10;	//����   1byte
		long l1 = 11;		//���纻 8byte
		
		//�Ͻ����� ����ȯ(�����ս�x)
		//l1 = b1;
		l1 = (long)b1;  //����

		System.out.println(l1);//���纻 Ȯ�� 		


        //�Ǽ���
		float f1 =3.14f; //����// �������� ���� ������ 8 �������� 4 /ū�� �������� /�׷��� ������� ����ȯ �ʿ�/���� (float)3.14
		double d1;       // ���纻
		
		//float�� doble�� �ٲٰų� �� �ݴ�� ���� �� ����
		//�Ͻ����� ����ȯ
		d1 =f1;

		System.out.println(d1);
		//Ű ��ũ�� 
	    
		double d2 = 1.23456789012345; //����
		float f2; //���纻
		System.out.println(d2); 
		
		f2 = (float)d2;
		System.out.println(f2);	


		//�Ǽ� <-> ����
		double d3 = 3.14;   //3.99�� �ϸ� 4�� �Ǵ��� �ƴϸ� �ƿ��������� Ȯ�� ���ϱ� // ��Ȳ���� �ٸ�
		int n3;

		//?
		n3 = (int)d3; //������ ���� //����� ����ȯ �ʿ�

		System.out.println(n3);

		float f4 = 3.14F;
		long l4;

		//ū��(8) = ������(4)// ���� ��ü�� 8����Ʈ, 4����Ʈ���� ������ �������� �ξ� ũ�� �׷��� ��������� �������
		//���� ����(o), ����Ʈ ũ��(x)-> �������� �Ǽ��� ��쿡 
	
		l4 = (long)f4;
		
		System.out.println(l4);


		//�⺻���� ���� ��  (Stirng�� ���������� �ؿ� �ֵ��̶� �ڼ��� ���� ����)
		//byte(1) < short(2) < int(4) < long(8) < float(4) < double(8)
		//			char(2)
		//boolean(1)

		//** �⺻���� ������������ ��ȯ�� �Ұ���(�޸� ���� ������..)

		//boolean�� ����ȯ�� ����� �� �� ����.
		// (int)true; <- �̷��� ����


		//������
		// - 'A' -> 65 (�����ڵ尪�̶� �Ҹ��� �������� ��ȯ�� �����ϴ�)
		char c5 = '��'; //2byte �ڡڡڡڡ�A��� '��'�� ������ -21504 ���� ������ �������� �׷��� short �Ⱦ�
		                // char�� ��ȣ��Ʈ�� ����, ���� �����ۿ� ���� ���ڴϱ� �׷��� 4������� ǥ������������ short�� 3��������ۿ� ǥ���� �ȵ� -> int��� 
		short s5; //2byte

		//���� = ����
		s5 = (short)c5;

		System.out.println(s5);

		System.out.println((char)66);


		char c6 = '��'; // 2byte
		int n6; //4byte

		n6 = c6;

		System.out.println(n6);

		
		int n7 = 65;
		char c7 = '5';

	    System.out.println(n7);
		System.out.println((int)c7);

		System.out.println((int)'A');//65
		System.out.println((int)'Z');//90
		System.out.println((int)'a');//97
		System.out.println((int)'z');//122
		System.out.println((int)'0');//48
		System.out.println((int)'9');//57

		System.out.println((int)'��');//�ѱ��� ����
		System.out.println((int)'�R');//�ѱ��� ��







			}

}
