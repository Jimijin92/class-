class Homework15 {

	public static void main(String[] args) {
	
	/*
	����15.
	�䱸����] �Ʒ��� ���� ����Ͻÿ�.

	1 + 2 + 4 + 7 + 11 + 16 + ... + N = 469

	����] ���ϴ� N�� 100�� ���� ���� ������
	*/

	int temp = 1; 
	int sum = 0; 
		
		for (int i=0; ;i++) {
			temp += i; 

			if (temp > 100)
				break; 
			
			System.out.printf("%d + ", temp);

			sum += temp;
		}
			
	System.out.printf("\b\b= %d\n", sum);
	
	}

}
