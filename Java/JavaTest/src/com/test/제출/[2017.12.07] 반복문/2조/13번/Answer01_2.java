import java.io.*;



class Answer01_2 {

	public static void main(String[] args)  {	
	
		

	
		forQna13();    
	

	}
	//main method



/*
����13.
�䱸����]�������� ����Ͻÿ�.
2~9�ܱ���
���]
2�� for�� x 2�� / 3�� for�� x 1��

2 3 4 5 ��

6 7 8 9 ���������� �����
*/

	public static void forQna13() {
		
		System.out.println(" < 2 �� >\t < 3 �� >\t < 4 �� >\t < 5 �� >");
	

		//2~5��
		for (int i=1; i<=9; i++) {						//��
			for (int j=2; j<6; j++){					//��
				System.out.printf("%d x %d = %2d\t"  //��������, ��������
								  , j,  i,	j*i); 
			}
			System.out.println();
		}


		System.out.println();							//���Ʒ� ����


		//6~9��
		System.out.println(" < 6 �� >\t < 7 �� >\t < 8 �� >\t < 9 �� >");

		for (int i=1; i<=9; i++) {
			for (int j=6; j<10; j++){
				System.out.printf("%d x %d = %2d\t" 
								  , j,  i,	j*i); 
			}
			System.out.println();
		}
	}


	










}