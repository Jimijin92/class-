
class h18_2017_12_07 {
	public static void main(String[] args) 
	{
		
		h18();
		
	}//main
	
	/*
	����18.
	�䱸����] 1���� 100������ �������� ���Ͻÿ�
	���] 

	6 = [1, 2, 3, 6]
	28 = [1,2,4,7,14,28]

	��Ʈ ������ : �ڱ� �ڽ��� ������ ������ ������� ���� �ڽŰ� ������
				  ��			*/
	

	public static void h18(){
		for(int i =1; i<=100; i++) {
			
			String txt = "";
			int a = 0;	//�ʱ�ȭ

			for(int j=1; j<i; j++) {
				
				if ((i%j)==0) {
					a += j;	//���� �� �� ���
					txt +=  j+ "+"; //��� ���
				}//if
			}//for

			if ((a == i )) {
				txt += i+""; //���� �߰�
				System.out.printf("%s = %d\n",txt,a);
			}//if
		}//for
	}//h18

}//class