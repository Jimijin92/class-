class Ex10_Output {

	public static void main(String[] args) {

		//Ex10_Output.java

		//printf()
		//1. %����d
		//	- ����� ������ �ּ� �ʺ�
		//	- ���/����
		//	- ��� ���� ���ڿ� ����

		System.out.printf("[%d]\n",100);
		System.out.printf("[%10d]\n",100);// �� ���ڸ� 100(3�ڸ�)��������ϱ� ���� 7�ڸ� 
		System.out.printf("[%-10d]\n",100); //������ ��������
		
		System.out.printf("[%10d]\n",123845879305L);

		System.out.printf("[%d]\n",100);

		

		//2. %.����f
		//	- �Ǽ������� ���� ����
		//	- �Ҽ� ���� �ڸ��� ����

		System.out.printf("%f\n", 3.1234);
		System.out.printf("%,f\n", 3.1234);
		System.out.printf("%,f\n", 3.1934);  //�����Ŷ� ���ؼ� �ݿø� üũ 2->9�� �ٲ㼭 
		
		

		//3. %,d
		//	- �������� ����(%d,%f)
		//	- �ڸ��� ǥ��
		System.out.printf("%d\n", 12345678);
		System.out.printf("%,d\n", 12345678);
		

		//�ѹ���~
		System.out.printf("%,15.2f\n", 12987.6543);  //�ڸ����� �ĸ��� �嵵 ����

		//�ּҷ�

		String name1 = "ȫ�浿";
		String address1 = "����� ������ ���ﵿ";
		String email1 = "hong@naver.com";
		int salary1 = 20000;
		 
		String name2 = "�׽�Ʈ";
		String address2 = "����� �߱�";
		String email2 = "test@naver.com";
		int salary2 = 500;


		System.out.println("==============================================");
		System.out.println("           �ּҷ�");
		System.out.println("==============================================");
		System.out.println("[�̸�]\t[�޿�(��)]\t[�ּ�]\t\t\t[�̸���]");

		
		System.out.printf("%s\t%,10d\t%-14s\t%s\n", name1, salary1, address1, email1);
		System.out.printf("%s\t%,10d\t%-14s\t%s\n", name2, salary2, address2, email2);


		//��� �� ���ǻ���
		//1. ���ڴ� ���� ����(***)
		//2. ����
		//	a. ����(��)
	    //		1. ����
		//			- ���� ����
		//		2. ���
		//			- ���� ����
		//  b. ����
		//		1. ����
		//		2. ���
		//			- 010-123-4567
		//			- 010-1234-5678
		//		3. ����
		//		    - ��ġ(��)




	}

}
