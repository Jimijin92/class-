import java.io.*;

class Ex24_switch {

	public static void main(String[] args) throws Exception {

		//Ex24_switch.java
		
		/*

			switch (���ǰ�) {
				case ��:
				     �����ڵ�;
					 break;
				[case ��:
				     �����ڵ�;
					 break;]
                [case ��:
				     �����ڵ�;
					 break;]
		        [case ��:
				     �����ڵ�;
					 break;]
			    [default:
				     �����ڵ�;
					 break;]
	        }

		*/

		//�䱸����]���� �Է�(1~3) �޾� �ѱ۷� ���
		int num =1;

		//switch ���� ���ǰ��� ������ �����ϴ�(true, false ������ �̻��ϴϱ�, num>0 �̷��͵� true, false��). + String ����
		switch (num){
			case 1:
				System.out.println("�ϳ�");
			    //break; //���� ����� Ż��// ��� �� �� ������ �귯����

			case 2:
				System.out.println("��");
			    break; 

			case 3:
				System.out.println("��");
			    break;
				
			default: //if ���� else �� ����
				System.out.println("��");
				break;
			}//switch(num)
		



		//���Ǳ� -> ���� ���� -> ���� ���
		System.out.println("===========================================");
		System.out.println("                  ���Ǳ�                 ");
		System.out.println("===========================================");
		System.out.println("1. �ݶ� ");
		System.out.println("2. ���̴� ");
		System.out.println("3. ��ī�� ");
		System.out.println("===========================================");
		System.out.println("���� ����(��ȣ) : ");
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String input = reader.readLine();

		switch (input) {
			case "1" :
				//System.out.println("700���Դϴ�");
			    //break;
				//�Ӹ����� �ΰ��� ������ �ϳ�
		    case "2" :
				System.out.println("700���Դϴ�");
			    break;
			case "3" :
				System.out.println("500���Դϴ�");
			    break;				
		}//switch(input)


		//���� ��ǰ or ���θ�

		//ī�޶� ����
		//1. �ɼ� : ī�޶� + �޸� + �ﰢ��
		//2. �ɼ� : ī�޶� + �޸� 
		//3. �ɼ� : ī�޶�
		System.out.println("ī�޶� ���θ�");
		System.out.println("�ɼ� ���� : ");
		input = reader.readLine();

		switch (input) {
			case "1":
				//System.out.println("ī�޶�");
				//System.out.println("�޸�");
				System.out.println("�ﰢ��");
				//break;
			case "2":
				//System.out.println("ī�޶�");
			    System.out.println("�޸�");
				//break;
			case "3":
				System.out.println("ī�޶�");
				break;
		}

	}

}
