
class homework_5 {
	public static void main(String[] args) 
	{
		
		loop();
		
		
	}//main

/*
����5. 
�䱸����] �Ʒ��� ���� ��� 45
���] 1 + 2 + 3 + 4 + 5 + 6 + 7 +... + ? = 10XX
����] �������� 1000�� �Ѿ�� ���������� ����Ͻÿ�
���] ���� ���� + break
*/


	
	public static void loop () {
		int num = 0; 
		
		for (int i=1; ; i++) {
			num += i; //�����հ�
			if (num < 1000) {
				System.out.printf("%d + ", i);
			} else {
				System.out.printf("%d = ", i);
			}//if
			if (num > 1000){
				break;
			}
		}//for
		System.out.printf("%d\n", num);
	}//loop 5.


}//class