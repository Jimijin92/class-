class Ex26_while {

	public static void main(String[] args) {

		//Ex26_while.java

		//�ݺ���
	    // - for
		// - while
		// - do while


		//while(do while) ����/���� -> for�� ����

		/*
		
			while (���ǽ�){
				�����ڵ�;
			}
		
		*/
		//�䱸����] 1~10���� ����Ͻÿ�.
		
		int num = 1; //�ʱ��

		while (num <= 10){ //���ǽ�
		
			System.out.println(num);
			num++; //������
		
		}

		//�䱸����] ������ ���
		
		int m = 2;
		while (m < 10) {
			
			int n = 1;
			while (n < 10){
				System.out.printf("%d x %d = %d\n", m, n, m*n);
				n++;
			}//while
			m++;
		}//while

		
		//do while ��
		// - ������ ������
		// - ������ ���ϴ��� 1ȸ�� ������
		
		/*

		while (���ǽ�)
		{

		}

		do {

		} while (���ǽ�);
		
		*/
		
		num = 100;

		do{
			System.out.println(num);
			num++;
		}while(num <= 10);

	}//main method
}//class









		