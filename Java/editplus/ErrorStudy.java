class ErrorStudy {

	public static void main(String[] args) {

//1.
    byte ageOfMyBoyfriend;
	myAge = 31;
	System.out.println("â������ ���̴�" + ageOfMyBoyfriend + "�Դϴ�.");
	//	-����
		//Homework1.java:57: error: variable ageOfMyBoyfriend might not have been initialized
		//System.out.println("�� ����ģ���� ���̴�" + ageOfMyBoyfriend + "�Դϴ�.");
		//�ɺ����̶� ���� �߸����� -> ��� ���� �� ���� �ʿ�
    
	byte ageOfMyBoyfriend;
	ageOfMyBoyfriend = 31;
	System.out.println("â������ ���̴�" + ageOfMyBoyfriend + "�Դϴ�.");


//2. 
	int myAccountNumber
	myAccountNumber = 1002043711882
	System.out.println("�� ���¹�ȣ��" + myAccountNumber + "�Դ�2017-11-29��.");
	//	-����
	/*
	Homework1.java:71: error: ';' expected
	int myAccountNumber
    Homework1.java:72: error: integer number too large: 1002043711882
    myAccountNumber = 1002043711882
    Homework1.java:72: error: ';' expected
    myAccountNumber = 10020437118828
    */
	//�ʰ�) int ���ڹ����� �� ������. ���� �ʹ� ũ�� ������

//3.
	int myAccountNumber
	\myAccountNumber = 1002043711882
	\System.out.println("�� ���¹�ȣ��" + myAccountNumber + "�Դϴ�.");
    //����
	/*
	Homework1.java:75: error: integer number too large: 1002043711882
                                                myAccountNumber = 1002043711882;
												*/
    //��Ÿ) long���� �����ϰ� int�� �Ĺ�����
//4.
	long myAccountNumber;
	myAccountNumber = 1002043711882;
	System.out.println("�� ���¹�ȣ��" + myAccountNumber + "�Դϴ�.");
	//����
	/*
	Homework1.java:75: error: integer number too large: 1002043711882
                                                myAccountNumber = 1002043711882;
    */
    //����) long�� ������ �ڿ� �ҹ��� l�̳� �빮�� L�ٿ��� �� 
//5.
	//����
	/*
	Homework1.java:101: error: ';' expected
                                          boolean myName = true
                                                               ^
    Homework1.java:102: error: ')' expected
                                          System.out.println("�� �̸���" + myName + "�̴�"

    ^
    Homework1.java:109: error: reached end of file while parsing
}
 ^
3 errors
	*/


//6. 
//����
Ex08_Casting.java:12: error: not a statement
                long 11;                //���纻 8byte
                ^
Ex08_Casting.java:12: error: ';' expected
                long 11;                //���纻 8byte
                    ^
Ex08_Casting.java:28: error: ';' expected
                System.out.println(d1)

//7����
Ex08_Casting.java:36: error: incompatible types: possible lossy conversion fro
double to float
                f2 = d2;
                     ^

//8 ���� 
Ex08_Casting.java:77: error: incompatible types: possible lossy conversion from
char to short
                s5 = c5;

//9 printf�� ���� ,age �������� �������� �Ǵµ� ���â�� �̷��� �� 
ȫ�浿�� ���̴� Exception in thread "main" java.util.MissingFormatArgumentExcept
ion: Format specifier '%d'
        at java.util.Formatter.format(Formatter.java:2519)
        at java.io.PrintStream.format(PrintStream.java:970)
        at java.io.PrintStream.printf(PrintStream.java:871)
        at Ex09_Output.main(Ex09_Output.java:55)
����Ϸ��� �ƹ� Ű�� �����ʽÿ� . . .










		
	}

}
