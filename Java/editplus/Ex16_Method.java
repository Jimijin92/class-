import java.io.BufferedReader;
import java.io.InputStreamReader;

class Ex16_Method {

	public static void main(String[] args) throws Exception {
    //Ex16_Method.java

	/*�޼ҵ� ����

	���������� ����Ű���� ��ȯ�� �޼ҵ��(���ڸ���Ʈ){
		������
	}

	*/
	
	//���ڸ���Ʈ

	//�䱸����] "ȫ�浿�� �ȳ��ϼ���." ���
	//System.out.println("ȫ�浿�� �ȳ��ϼ���.");
	//hello();
	
	//public static void hi(String name)
	hi("ȫ�浿");

	//�߰�����] "�ƹ����� �ȳ��ϼ���." ���
	//System.out.println("�ƹ����� �ȳ��ϼ���.");
	//hello();
	hi("�ƹ���");

	

	//�߰�����] �츮 ���ǽ��� ��� ��� ���
	//�߰�����] �ѵ� �ǹ�   
	//�߰�����] ������
    //hi();   �Ű� ������ �������� ������ �ȳ����� ���� ��
	//hi();   String�� ����(100)�־ �ȵ�
	//hi("������", 100); //rŸ�԰� ���� �¾ƾ���
	
    add(10, 20);
	add(5, 2);
	add(22, 33);

    check("ȫ�浿", 25);
	check("�ƹ���", 12);
	check("������", 80);

		int n = num();
		System.out.println(n);
    
	bye();

	int m =5;
	int result = getSquare(m);//������
	System.out.println(result);
	System.out.println(getSquare(m));

	} //main





	public static void hello() {
		System.out.println("ȫ�浿�� �ȳ��ϼ���.");	
	}//hello


	public static void hi(String name) {
		//String name = "ȫ�浿";
		System.out.println( name + "�� �ȳ��ϼ���.");	
	}//hi


    public static void add(int a, int b){
		System.out.printf("%d + %d = %d\n", a, b, a + b);
	}//add


	public static void check(String name, int age) {		
		String result = (age >= 20 && age < 60) ? "���" : "Ż��";
		System.out.printf("�� '%s'���� '%s'�Դϴ�.\n", name, result);
	}//check


	public static int num() {
		//���Ϲ�, ��ȯ��
		return 10;	
	}//num

	//�̸��� �Է��ϸ� �λ��ϱ�
	//��ǲ�� ���� �Ͼ�ϱ� �Ű��������� �����ϱ� 


	public static void/*���ϰ��� ���� �׳� ���� �̸� void*/ bye()throws Exception {
		BufferedReader reader 
			= new BufferedReader(new InputStreamReader(System.in));
		System.out.print("�̸� �Է� : ");
		String name = reader.readLine();
		System.out.printf("%s�� �ȳ��ϼ���.\n", name);







    }//void

	/*���� �����ؼ� 
	public static void print(String msg){
	}
      public static String readLine() {
	} return "�Է°�"
    */

	//���� 1�� ���� -> �������� ��ȯ
	// 2 -> 4
	// 8 ->64


	//�޼ҵ� ���
	// -> �޼ҵ� �ñ׳���(Signature)
	// -> �޼ҵ� ����
	public static int getSquare(int n){//������
	
		int result = 0;
		
		result = n * n ;

		System.out.println("�۾��� �Ϸ�Ǿ����ϴ�.");

		return result; //return ������ ���⼭ �г�/ �Ʒ����� "�۾��� �Ϸ�Ǿ����ϴ�." ���常���� ������ 
		

		//return n * n

		//System.out.println("�۾��� �Ϸ�Ǿ����ϴ�.");



	}



}
