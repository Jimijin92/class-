import java.util.Calendar;

class Ex23_if {

	public static void main(String[] args) {

		//Ex23_if.java

		//m1();
		//m2();
		//System.out.println(m3());//�Ű�����, ��ȯ�� �ΰ��� �ݵ�� �����ֱ� 
		//m4();
		//m5();
		m6();

	} //main

	public static void m6() {
	
		// �䱸����] ���� 1�� �Է� -> ���ҹ���?
		String input = "e";

		char c = input.charAt(0); //"e" -> 'e'
		
	    int code = (int)c;//101



		//if (code >= 97 && code <= 122){
		//if (code >= (int)'a' && code <= (int)'z'){
		if (c >= 'a' && c <= 'z'){
			System.out.println("�ҹ���O");
		} else {
			System.out.println("�ҹ���X");
		} 



		c = 'D';
	
	    if ((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z') || (c >= '0' && c <= '9')) {
			System.out.println("������ + ����O");
		} else {
			System.out.println("������ + ����X");
		} 


	}//m6

    public static void m5() {
		//��ø�� if��, Nested if Statements
		/*
			if() {
				if () {
				    if () {
					
					}
				}

			} else if() {
			
			} else {
			
	        }

		*/
		//���� ���� �Է� -> �հ�, ���հ�?
		//���� : 60�� �̻�
		int kor = 100;
		if(kor >= 60){
		System.out.println("�հ�");
		} else {
		System.out.println("���հ�");
		}


		if(kor < 60){
		System.out.println("���հ�");
		} else {
		System.out.println("�հ�");
		}
        // else ���� if�� �������� ����, ����� ������ �� �� ������ ���� 


		//��ȿ�� �˻�
        if (kor >= 0 && kor <= 100) {

            //����Ͻ� �ڵ�, ���� �ڵ�
			if (kor >= 60) {
		       System.out.println("�հ�");
		    } else {
		       System.out.println("���հ�");
		    }
		
		} else {
			//���� ó�� �ڵ�
			System.out.println("���� �ٽ��Է�");
		}


		/*
        kor = ; // 0~100�̾�� ��, ���� ������ �̸� �ڰ����� �������
		if(kor >= 60){
		System.out.println("�հ�");
		}else {
		System.out.println("���հ�");
		}
		*/

		

	}


	public static void m4() {

	 System.out.println("�ϳ�");

     Calendar c = Calendar.getInstance();

	 if (c.get(Calendar.SECOND) % 2 == 0){
		return; //�� return�� -> �޼ҵ� ����
	 }


	 System.out.println("��");
	 System.out.println("��");
	
	
	}








	public static String m3(){
		//return��

		int num = -10;

		if (num > 0){
		    return "���";
        // ������ ��쵵 ����, �����Ϸ��� ���� ���ڰ� �ƴ� �����˻縸 �� 
		// ��� ����� ���� ���� ������ �����ؾ� �Ѵ�.
		}

		return "����";


	}//m3

	public static void m2(){
	
	    //�̷��Դ� �Ⱦ��� ����-> ������ ���̴ϱ�, �Ʒ� booleanó�� ��
		if(true){
			System.out.println("��");
		} else {
			System.out.println("����");
		}
	


		

		boolean flag = true;//������ �ִ� ��� 


		if(flag){
			System.out.println("��");
		} else {
			System.out.println("����");
		}



		//C -> Java
		//C��� : boolean�� ����.
		// - ���� : 0(false), ������(true)
		// - �Ǽ� : 0.0(false), ������(true)
		// - ���� : \0 (false), ������(true)
		// - ���ڿ� : ""(false), ������(true)
		if(flag){
			System.out.println("��");
		} else {
			System.out.println("����");
		}



	}//m2


	public static void m1() {

		//�䱸����] ���� 1�� �Է¹޾� ¦��? Ȧ��?
		int num = 5;
		String result = " "; //��� ������ ������ �ʱ�ȭ ���ѳ��� �����ϱ�// ���� �����ϱ� ���ؼ� 

		if (num % 2 == 0){
			//¦�� 
			//System.out.printf("�Է��� ���� %d�� ¦���Դϴ�.\n", num);
			result = "¦��";
		} else{
			//Ȧ��
			//System.out.printf("�Է��� ���� %d�� Ȧ���Դϴ�.\n", num);
			result = "Ȧ��";
		}
	
		System.out.printf("�Է��� ���� %d�� %s�Դϴ�.\n", num, result);
	    //�����Ϸ��� �ƹ��͵� �������� ��쵵 ������. �� ��� result �ʱ�ȭ �ȵ������� ����Ұ� ��� ������
	
	}//m1

}
