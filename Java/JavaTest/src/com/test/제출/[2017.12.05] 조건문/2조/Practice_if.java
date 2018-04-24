import java.io.BufferedReader;
import java.io.InputStreamReader;


class Practice_if {

	public static void main(String[] args)throws Exception{


	//num();  //문제 1번
	//gradeIf(); //문제 2번(If)
	//gradeSwitch(); //문제 2번(switch)
	//calc(); //문제 3번
	family(); //문제 4번
	//change();


	
	}//main
/*
	public static void change()throws Exception{ //문제 5번

		
		BufferedReader br = new BufferedReader (new 
								InputStreamReader(System.in));

		System.out.print("문자 : ");
			char letter = 


	}

*/
	public static void family()throws Exception{	//문제 4번

		BufferedReader br = new BufferedReader(new 
								InputStreamReader(System.in));

		System.out.print("문자 : ");
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
				System.out.println("f,m,s,b 중 하나를 입력하세요");
			}


			System.out.printf("%s" , result);

	}


/*

	public static void calc()throws Exception{ //문제 3번
		BufferedReader br = new BufferedReader(new 
								InputStreamReader(System.in));

		System.out.print("숫자1 : ");
			int first = Integer.parseInt(br.readLine());
		System.out.print("숫자2 : ");
			int second = Integer.parseInt(br.readLine());
		System.out.print("연산자 : " );
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




	public static void gradeSwitch()throws Exception{ //문제 2번 (switch)

		BufferedReader br = new BufferedReader (new 
								InputStreamReader(System.in));

		System.out.print("점수 : ");
			int score = Integer.parseInt(br.readLine());

			

	}




	public static void gradeIf()throws Exception{	//문제 2번 (If)

		BufferedReader br = new BufferedReader ( new InputStreamReader(System.in));

		System.out.print("점수 : ");
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
			System.out.println("점수는 0~ 100점 입니다."); //예외 처리
		}

		System.out.printf("입력한 점수 %d 는 '%s' 입니다.",score, result);



	}

	
	public static void num()throws Exception{	// 문제 1번

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.print("첫 번째 숫자 : ");
			int firstNum = Integer.parseInt(br.readLine());
		System.out.print("두 번째 숫자 : ");
			int secondNum = Integer.parseInt(br.readLine());



		if(firstNum > secondNum){
			System.out.printf("큰수는 %d 이고 작은수는 %d 입니다.", firstNum, secondNum);

		}else if(firstNum < secondNum){
			System.out.printf("큰수는 %d 이고 작은수는 %d 입니다.", secondNum, firstNum);
		}else{
			System.out.println("같은 숫자를 입력 하셨습니다.");
		}
	

	}*/




}

