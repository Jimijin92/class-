class Ex18_Method {

	public static void main(String[] args) {

		//Ex18_Method.java

		//�޼ҵ� �����ε�, Method Overloading
        // - ���� �̸��� �޼ҵ带 ������ ����� ���
		// - ������ ������ Ÿ���� �ٸ��� ������ �̸��� �޼ҵ带 ������ ������ �� �ִ�.

		//�޼ҵ� �����ε� ���� ���� 
		// - ���� ���� 
		// - ���� Ÿ��

		//�޼ҵ� �����ε� ���� ���� X
		// - ���� �̸�
		// - ��ȯ�� Ÿ��

		//�����ε��� ���� �Ǵ�?
		// - ȣ���� ���� ��Ȳ�� ����(***)

		// - test(); //2
		// - test(10); //���� �θ��� �𸣰� ��, �׷��� 4�� 5 ���ÿ� ������ �� ���� 
		// - test("ȫ�浿");
		// - test(10, 20);
		// - int num = test(); -> 2, 8 ���� ����
		// - test(); -> 2, 8 ���� ����
		// - �޼ҵ带 �ø� ���� ���� ������ ������ �־�� ��

		// test(10); //4
		// byte b = 10;
		// test(b); //9

		//�ҽ��� �ۼ� ��..
        // 1. main() //o
		// 2. public static void test() {} //o
		// 3. public static void test() {} //x 2�� ������ �ȵ�
		// 4. public static void test(itn n) {} //�Ű����� ����, o
		// 5. public static void test(int m) {} //X(4)
		// 6. public static void test(String s) {} //o
		// 7. public static void test(int n, int m){} //o
		// 8. public static int test() {} //X (2���̶� ������ �� ��) 
		// 9. public static void test(byte n) {} //�Ű����� ����, o
		

		//�䱸����] �� ���� �����͸� ���ڷ� ���� -> ���ؼ� ����ϴ� �޼ҵ�
		// - int + int 
		// - double + double
		// - String + String
		add(10, 20);
		add(5, 7);
		add(33, 99);

		add(3.1, 2.1);

		add("ȫ�浿","�ƹ���");
		
		System.out.println(100);
		System.out.println("ȫ�浿");
		
	} //main

	public static void println(int a){
	
	}
	
	public static void println(String a){
	
	}
	
	//�ڹٴ� �޼ҵ带 ������ �� �޼ҵ���� ����Ѵ�.(X)
	//�ڹٴ� �޼ҵ带 ������ �� �޼ҵ��� ���ڸ���Ʈ�� ����Ѵ�.(O)
	//���� ���Ǽ��� ���� ������� ��� 

	//add(*******)
	// - �޼ҵ��� �̸��� add��� �ܾ ���� ������ ��Ȳ
	public static void/*(��ȯ�� ������ void)*/add(int a, int b) {

		System.out.printf("%d + %d = %d\n", a, b, a + b);
		
	}


	public static void/*(��ȯ�� ������ void)*/add(double a, double b) {

		System.out.printf("%.1f + %.1f = %.1f\n", a, b, a + b);
		
	}

    public static void/*(��ȯ�� ������ void)*/add(String a, String b) {

		System.out.printf("%s + %s = %s\n", a, b, a + b);
		
	}




}
