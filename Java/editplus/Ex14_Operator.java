class Ex14_Operator {

	public static void main(String[] args) {
/*
		//Ex14_Operator.java
		

		//������, Operator
		//	- �ǿ�����(Operand)�� ������� �̸� ������ ������ �� �Ŀ� ������� ��ȯ�ϴ� ����

		//1. ���������
		//	- +, -, *, /, %(������������, mod)
		// - ���� ������(2��) -> �ǿ����ڸ� 2���� ���� ������

		int a = 10;
		int b = 3;

		System.out.println(a + b);
		System.out.println(a - b);
		System.out.println(a * b);
		System.out.println(a / b);//3 -> ����/������ ����
		System.out.println(a % b);//1

		
		//�޷� ����� 		
		//�ش� �� ���� ��������? -> �׳� �ϱ��ϱ� ���� ����
		//�ش� �� ���� 1���� ���� -> ���ذ� 1970.1.1 or 1.1.1




		//������ �۾�
		//���� / ���� = ����
		//�Ǽ� / �Ǽ� = �Ǽ�
		//���� / �Ǽ� = �Ǽ�
		//�Ǽ� / ���� = �Ǽ�
		// -> ��� ��� ������ �� �ǿ����� �� �� ū�ڷ������� ���� ����� ��ȯ�ȴ�.(****)

		System.out.println(10 / 3); //����/������ �Ҽ��� ���� ����
		System.out.println(10.0 / 3.0); //
		System.out.println(10/3.0); //int ������ double
		System.out.println(10.0/3); //int ������ double


		byte b1 = 10;
		int n1 =20;
		System.out.println(b1+n1); //���� ����� int

		int n2 = 2000000000;
		int n3 = 1000000000;
		System.out.println(n2 + (long)n3); // ������ �� int �ʰ��ع����� �ȵ� , �����ϳ� ĳ�������ֱ�

		//������ ���ͷ� = int�� ���� 64bit�ϱ� 8byte�� �ƾ�� �ϴµ� ������ ��� 4byte��� ���Ǽ� ���ؼ� 4������

		byte b2 = 10, b3 = 20, b4;

		b4 = (byte)(b2 + b3); //������� int�� ���� b2+(int)b3
		System.out.println(b4)
*/		

		//2. �񱳿�����
		//	- �ǿ����ڵ��� �� ������ ��ȯ�ϴ� ����
		//	- ���� ������
		//	- >, >=, <, <=, ==(equal), !=(not equal, �����ʴ�.)
		//	- A > B : ������, �Ǽ��� ���
		//	- �׻� ������ ����� boolean���� ��ȯ�Ѵ�. (true, false)


		int result = 0;
		result = 1 + 2 * 3 + 4;

		System.out.println(result);
		
		//������� : 1. ������� 2. �񱳿���
		//������ ������ �������� �����ְ� ������ (2 + 3 + 4) -> ( 5 + 4 )

		int a = 10; 
		int b = 3;

		System.out.println(a > b);
		System.out.println(a >= b);
		System.out.println(a < b);
		System.out.println(a <= b);
		System.out.println(a == b);
		System.out.println(a != b);

		//�Ǽ��� �������� ��
		System.out.println(3.5 > 3);

		//���� �� x
		//System.out.println(true > false);
		System.out.println(true == true);

		//������ ��
		//��ȿ�� �˻�
		System.out.println('A' > 'B');//���������δ� �����ڵ尪���� ��
		// ����� ���� �Է� -> 'c' -> ���� �ҹ���?

		char input = 'c';

		System.out.println(input >= 'a');
		System.out.println(input <= 'z');
		//�Ѵ� �ƴϿ���� ���� ���ü��� ����, ���߿� �ϳ��� false������ ������
		//�Ѵ� �׶�� ���� ���;���

		
		//���ڿ�(������) ��
		String s1 = "ȫ�浿";
		String s2 = "ȫ�浿";
		String s3 ="ȫ";
		s3 = s3 + "�浿";

		System.out.println(s3);

		//System.out.println(s1 > s2); //�ȵ�
		System.out.println(s1 == s2);
		System.out.println(s1 == s3);

		//***��� ������(���ڿ�)�� �񱳴� �� ������(==, !=)�� ����� �� ����.
		// -> equals()�޼ҵ� ��� // ������ �̰� ���
		System.out.println();
		System.out.println(s1.equals(s2));
		System.out.println(s1.equals(s3));
		System.out.println();

		int m1 = 10;
		int m2 = 10;
		int m3 = 5;
		m3 = m3 + 5;

		System.out.println(m1 == m2);
		System.out.println(m1 == m3);


		System.out.println((2 * 3) > (4 / 2));

		//3. �� ������
		//	- �̹� ������ ���� ��Ģ�� ���� ����� ��ȯ
		//	- ���� ������
		//	- ���� ������(!)
		//	- &&(and), ||(or), !(not)
		//	- �ǿ����ڸ� boolean�� ���´�.
		//	- ������ ����� boolean�� ��ȯ�Ѵ�.
	
		//	- A&&B
		//		T	T     -> T
		//		T	F     -> F
		//		F	F     -> F
		//		F	F     -> F

		//	- A&&B
		//		T	T     -> T
		//		T	F     -> T
		//		T	F     -> T
		//		F	F     -> F

		// !true -> f
		// !


		//boolean f1 = true;
		//boolean f2 = false;
		System.out.println();
		System.out.println();
		System.out.println();

		//System.out.println(f1 && f2);
		//System.out.println(fq || f2);

		//���� �Է� -> ���, ����
		//���� ; 20�� �̻� ~ 60�� �̸�
		int age = 85;
		//System.out.println(20 <= age < 60);// true < 60 �� �ż� ���� �ȵǴ� ���� ��
		System.out.println((20 <= age) && (age < 60)); //���� �� �Ʒ��� ���� ���ļ� ���� �� 
		System.out.println((age >= 20) && (age < 60)); //����

		//�߽��� �Ǵ� �����͸� ���� ������
		//age >= 20 //o 
		//20 <= age //x

		//&& -> ||
		
		System.out.println(!((age < 20) || (age >= 60))); // &&�� ||�� �ٲ�� �¿��� ���ǵ� ���ݴ�� �ٲٸ� �� 
		//  =  System.out.println((age >= 20) && (age < 60));


		//short circuit
		age = 10;
		System.out.println((age >= 20) && (age < 60));// &&�ڿ� Ʋ�� ������ �͵� ���� false�� �ƿ� �õ� ����, ���� f�ϱ� �� f
		System.out.println(!((age < 20) || (age >= 60)));// -- ���� t�ϱ� �� t

		//4. ���� ������
		//	- �Ҵ� ������ 
		//	- ���� ������
		//	- LValue(����) = RValue(���, ����)
		//  - LValue �� RValue�� �ݵ�� �ڷ��� ����(����ȯ ����)
		//	- =
		//	- +=, -=, *=, /=, %= ...   (->���մ��Կ�����)
		//	- ������ �켱 ������ ���� ����.

		int num = 10;
        //      �� ��
		//10 = 5; -> ������ �ƴϸ� ���ʿ� ����
        //����� ����� ������ 4����Ʈ�� �����־�
		//�� �㿡 int num ��Ƽ� ���� ������ ���� �ִ� �ڸ��� 4����Ʈ ����


		//����
		num = num + 1;
		num += 1;

		System.out.println(num);//12
		
		num = num - 1;
		num -= 1;
		System.out.println(num);//10

		num *= 3; //num = num * 3
		System.out.println(num);//30

		num /= 4; //num = num / 4;
		System.out.println(num);//7

		num %= 3; //num = num % 3;
		System.out.println(num);//1

		//����!! ���̱� �ȵǴ°�
		//num = 100 -num;
		//num -= 100; -> �����Ŷ� �ٸ� ����
		
		//���� �켱 ����
		//	- �� ���峻���� �����ڵ��� 2�� �̻� ������ �� ������ ����
		//	- () > ��� > �� > �� > ����
		
		//������ ���� ����
		//	- �� ���峻���� ������ �����ڰ� 2�� �̻� ������ ��
		//	- ��κ� : ���� -> ������
		//	- ���� ������ : ���� <- ������

		/*
		int a, b, c;
		a = 10;
		b = a;
		c = a;
		
		c = b = a;
          ��  ��
		*/

	   //5. ���� ������
	   //	- ++(����), --(����)
	   //	- ���� ������
	   //	- �ǿ������� ���� +1/-1
	   //	- ��Ȳ�� ���� ������ �켱 ���� ����ȴ�.
	   //		a. ++num : ����(������ �켱 ���� �ְ�)
	   //		b. num++ : ����(������ �켱 ���� ����)

	   num = 10;
	   
	   //num = num + 1
	   //num += 1
	   ++num; //1���� Ȥ�� 1���� 

	   System.out.println(num);

	   --num;

	   System.out.println(num);//10

	   num = 10;
	   result = 0;

	   //result = 20 + ++num;
	   ++num;
	   result = 20 + num;

	   System.out.println(result);

	   num = 10;
	   result = 0;

	   //result = 20 + num++;
	   //       ��    ��   ��
	   result = 20 + num;
	   num++;
	   
	   System.out.println(num);
	   System.out.println(result);

	   int o = 10;
	   System.out.println(--o - o--);

	   // �Ʒ� 4���� �ٸ��ֵ��̶� ���� ���� �򰥸� ���ξ���
	   // num++;
	   // ++num;
	   // num--;
	   // --num;

	   //6. ���� ������
	   //	- ������ �����ϰ� �� ����� ���� ������ ����� ��ȯ
	   //	- ���� ������
	   //	- A ? B : C 
	   //	- A(���ǽ� -> �ݵ��boolean�� -> t �ƴϸ� f)
	   //	- B, C : ����, ���
	   

	   num = true ? 10 : 20;    // ->10
	   //false ? 10 : 20;   // ->20
		//-> ������ ������ int ����� ���´�. �׷��� num�� ��Ƶд�
		System.out.println(num);
	
		age = 25;
		String msg = (age >= 20 && age <60) ? "���" : "����";
		System.out.printf("���� %d���� '%s'�Դϴ�\n", age, msg);

		

	  
























		



















































        




















		
	}

}
