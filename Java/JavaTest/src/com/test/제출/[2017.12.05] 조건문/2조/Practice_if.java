import java.io.BufferedReader;
import java.io.InputStreamReader;


class Practice_if {

	public static void main(String[] args)throws Exception{


	//num();  //���� 1��
	//gradeIf(); //���� 2��(If)
	//gradeSwitch(); //���� 2��(switch)
	//calc(); //���� 3��
	family(); //���� 4��
	//change();


	
	}//main
/*
	public static void change()throws Exception{ //���� 5��

		
		BufferedReader br = new BufferedReader (new 
								InputStreamReader(System.in));

		System.out.print("���� : ");
			char letter = 


	}

*/
	public static void family()throws Exception{	//���� 4��

		BufferedReader br = new BufferedReader(new 
								InputStreamReader(System.in));

		System.out.print("���� : ");
			String alp = br.readLine();

		String result = "";

			if(alp.equals("f") || alp.equals("F")){
				result = "Father" ;
			}else if(alp.equals("m") || alp.equals("F")){
				result = "Mother" ;
			}else if(alp.equals("s") || alp.equals("S")){
				result = "Sister" ;
			}else if(alp.equals("b") || alp.equals("B")){
				result = "Brother" ;
			}else{
				System.out.println("f,m,s,b �� �ϳ��� �Է��ϼ���");
			}


			System.out.printf("%s" , result);

	}


/*

	public static void calc()throws Exception{ //���� 3��
		BufferedReader br = new BufferedReader(new 
								InputStreamReader(System.in));

		System.out.print("����1 : ");
			int first = Integer.parseInt(br.readLine());
		System.out.print("����2 : ");
			int second = Integer.parseInt(br.readLine());
		System.out.print("������ : " );
			String operate = br.readLine();
			
			
			int result ;
			

			if(operate.equals("+")){
				result = first + second;
			}else if(operate.equals("-")){
				result = first - second;
			}else if(operate.equals("*")){
				result = first * second;
			}else if(operate.equals("/")){
				result = first / second;
			}else{
				result = first % second;
			}

			System.out.printf("%d %s %d = %d",first, operate, second, result);
			

	}




	public static void gradeSwitch()throws Exception{ //���� 2�� (switch)

		BufferedReader br = new BufferedReader (new 
								InputStreamReader(System.in));

		System.out.print("���� : ");
			int score = Integer.parseInt(br.readLine());

			

	}




	public static void gradeIf()throws Exception{	//���� 2�� (If)

		BufferedReader br = new BufferedReader ( new InputStreamReader(System.in));

		System.out.print("���� : ");
			int score = Integer.parseInt(br.readLine());
		
		String result = "";

		if(score <= 100 && score >= 0){

			if(score <= 100 && score >= 90){
				result = "A" ;

			}else if(score <= 89 && score >= 80){
				result = "B" ;

			}else if(score <= 79 && score >= 70){
				result = "C" ;

			}else if(score <= 69 && score >= 60){
				result = "D" ;

			}else if(score <= 59 && score >= 0){
				result = "F" ;
			}

		}else{
			System.out.println("������ 0~ 100�� �Դϴ�."); //���� ó��
		}

		System.out.printf("�Է��� ���� %d �� '%s' �Դϴ�.",score, result);



	}

	
	public static void num()throws Exception{	// ���� 1��

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.print("ù ��° ���� : ");
			int firstNum = Integer.parseInt(br.readLine());
		System.out.print("�� ��° ���� : ");
			int secondNum = Integer.parseInt(br.readLine());



		if(firstNum > secondNum){
			System.out.printf("ū���� %d �̰� �������� %d �Դϴ�.", firstNum, secondNum);

		}else if(firstNum < secondNum){
			System.out.printf("ū���� %d �̰� �������� %d �Դϴ�.", secondNum, firstNum);
		}else{
			System.out.println("���� ���ڸ� �Է� �ϼ̽��ϴ�.");
		}
	

	}*/




}

