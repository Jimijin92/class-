//import java.io.BufferedReader;						//Ŭ������ import
//import java.io.InputStreamReader;						//��Ű���� import
import java.io.*; //io��� ���ھȿ� �ִ� ��� Ŭ������ ������ ���ڽ��ϴ�.

//java.lang // String, System �������, �⺻��Ű��(import���� �ʾƵ� ��� ����)






class Ex12_BufferedReader {

	public static void main(String[] args) throws Exception {


	//Ex12_BufferedReader.java

	//System.in.read(); //����Ʈ ���� �Է�
	//BufferedReader    //���� ���� �Է�

	//System.out.print("���� �Է� : ");

	BufferedReader reader = new BufferedReader(new
    InputStreamReader(System.in));


	//BufferedReader reader = ������; 

	//int n = reader.read();
	//System.out.println((char)n);


	
	//String str = reader.readLine();
	//System.out.println(str);

	
	//str = reader.readLine();
	//System.out.println(str);

	// ���Ͱ��� ������ �������� �о����
	// ���°� �ڵ����� ������ ���� 

	//�Է¹��� �� �ִ� �������� ����?
	//1. ����
	//System.in.read()
	//reader.read() -> ���� �ڵ� ��ȯ
	//reader.readLine() -> ���ڿ� ��ȯ
//=======================================================
	//�䱸����] ���� 1�� �Է� + 100�� �Ͻÿ�.
	//String num = reader.readLine(); // 5 -> "5"
	//System.out.println(num);
	//System.out.println(num + 100);

	//int code = reader.read();
	//System.out.println(code - 48 +100); //�տ������� ���ؼ� ���ڸ� ����� �ڿ������� ���ؼ� ������ �ϸ� �� 
//===============================================================================================================
	//�䱸����] ���� 2�ڸ� �Է� + 100�� �Ͻÿ�.
	
	/*
	int num;
	int code = reader.read();
	System.out.println(code - 48);


	num = (code - 48)*10;
	
	code = reader.read();
	System.out.println(code - 48);

	num = num + (code - 48);

	System.out.println(num + 100);

	*/
//=====================================================================================================
	//String str = reader.readLine();
	//System.out.println(str + 100);   //"25" ->25

	//System.out.println(Integer.parseInt(str) + 100); //����ȯ�� �ƴ����� ����ȯ�� ���ϴ� �ൿ
//=========================================================================================================

	//���ڿ� -> int


	//�ڷ��� -> Wrapper Class(Util Class)
	//byte -> Byte 
	//short -> Short
	//int -> Integer
	//long -> Long
	//float -> Float
	//double -> Double
	//boolean -> Boolean

	System.out.println(Integer.parseInt("100")); //100
	System.out.println(Byte.parseByte("100")); 
	System.out.println(Double.parseDouble("3.14")); 
	System.out.println(Boolean.parseBoolean("true")); 

	//int�� �ִ밪? ��ƿŬ���� ���ؼ� Ȯ��
	System.out.println(Integer.MAX_VALUE);
	System.out.println(Integer.MIN_VALUE);


	//reader.readLine() ��� ��
	// - ���� �Է� -> "���ڿ�" -> util Class ParseXXX() ��� -> ����
	// - ���ڿ� �Է� -> "���ڿ�"
	// - ���� �Է� -> "���ڿ�" -> '����'


	String str = reader.readLine();
	//System.out.println(str);//"a" -> 'a'((char)str) �ϸ� �ȵ�  
	System.out.println((int)str.charAt(0));
	//������ char��� Ŭ������ ���� �׷���������� ���
	




	
//=====================================================================






























	}

}
