class quiz14 
{
	public static void main(String[] args) {
		

		
	m1();

	System.out.println();

	m2();
		


	} //main



/*

		
�䱸����] �Ʒ��� ���� ����Ͻÿ�.
���] 2�� for�� x 1��, 1�� for�� x 1��
1 ~ 10: 55
1 ~ 20: XXX
1 ~ 30: XXX
1 ~ 40: XXX

..

1 ~ 100: 5050


1 ~ 10: 55
11 ~ 20: XXX
21 ~ 30: XXX
31 ~ 40: XXX

..

91 ~ 100: xxxx



*/


	public static void m1() {

		
		int sum = 0; //���� �ʱ�ȭ
		


		
		for(int i=1; i<=10; i++) {
		
		
			for(int j=1; j<=(i*10); j++) {

				sum += j;
			
			} 
		
		
		
		System.out.printf("1 ~ %d: %d\n", i*10, sum);

		sum = 0; //������ ���ϱ� ���� 0���� �ʱ�ȭ
		
		}

	
	} //m1


	public static void m2() {
	
			
		int sum = 0; //���� �ʱ�ȭ
			
			
			
		for(int i=1; i<=10; i++) {
		
		
			for(int j=(i*10)-9; j<=(i*10); j++) {

				sum += j;
			
			} 

		
		
		System.out.printf("%d ~ %d: %d\n", (i*10)-9, i*10, sum);

		sum = 0; //������ ���ϱ� ���� 0���� �ʱ�ȭ
		
		}




	} //m2

 




} //class
