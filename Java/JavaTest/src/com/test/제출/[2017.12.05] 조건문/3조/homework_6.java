import java.io.*;

class homework_6 {
	public static void main(String[] args) throws Exception
	{
	BufferedReader reader = new BufferedReader(new InputStreamReader (System.in));

	/*
	����6.
	�䱸����] ���� ����� ����Ͻÿ�.
	�Է�] <���� �ð�>
		   �� : 13
		   �� : 30
	    <���� �ð�>
		   �� : 14
		   �� : 20
	���] ���� ����� 4,000���Դϴ�.
	����] ���� ���� : 30��
	      �ʰ� 10�� : 2,000��		*/
	System.out.println("=========================\n	�������");
	System.out.print("<���� �ð�>\n�� : ");
	int hourIn = Integer.parseInt(reader.readLine());

	System.out.print("�� : ");
	int minuteIn = Integer.parseInt(reader.readLine());
	
	System.out.println();

	System.out.print("<���� �ð�>\n�� : ");
	int hourOut = Integer.parseInt(reader.readLine());

	System.out.print("�� : ");
	int minuteOut = Integer.parseInt(reader.readLine());

	System.out.println();

	park(hourIn, minuteIn, hourOut, minuteOut);

	System.out.println("=========================");

	}//main

	public static void park(int inH, int inM, int outH, int outM)				throws Exception {

		int in = (inH * 60) + inM;
		int out = (outH * 60) + outM;
		int parking = out - in;

		if(parking <= 39 && parking >= 0) {
			System.out.printf("���� ����� �����Դϴ�.\n");
		} if(parking > 40) {
				
			if(parking % 10 == 0){
				parking =  parking - 10;
			}
				int fee = (parking / 10 * 2000)-4000;
			System.out.printf("���� ����� %d�Դϴ�.\n", fee);
		} if (parking < 0) {
			System.out.println("�ٽ� �Է��� �ּ���.");
		}

	}//park

}//class