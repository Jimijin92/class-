class Homework1 {

	public static void main(String[] args) {

		/*
		기본 자료형(8가지) + String를 사용해서 주변의 데이터를 변수화 + 데이터 입력 +문장 출력하시오

		자료형 1개 x 10개
		*/

		//내 몸무게
		//1. 내 몸무게가 어떤 자료형에 속하는지? (양의 정수 128키로 안넘으니까 byte)
		//2. 변수명 <- 의미있게
		//3. 상수 표기(대입)
		//4. 출력

		byte myWeight;
		myWeight = 70;
		System.out.println("내 몸무게는" + myWeight + "kg입니다.");
		//myweight = 70.5F; 처럼 상수형으로도 해보기 


	//1. 1. 원시형(Primitive Type),
			//a. 숫자형
				//1. 정수형
					//a. byte
						byte numberOfFinger;
						numberOfFinger = 5;
						System.out.println("내 손가락 개수는 " + numberOfFinger + "개 입니다.");

						byte myAge;
						myAge = 26;
						System.out.println("내 나이는" + myAge + "입니다.");

						byte myFamilSize;
						myFamilSize = 5;
						System.out.println("우리 가족 수는" + myFamilSize + "명 입니다.");

						byte myFavoritNumber;
						myFavoritNumber = 9;
						System.out.println("내가 가장 좋아하는 숫자는" + myFavoritNumber + "입니다.");

						byte numberOfBook;
						numberOfBook = 10;
						System.out.println("내 책의 숫자는" + numberOfBook + "입니다.");

						byte numberOfFriend;
						numberOfFriend = 5;
						System.out.println("내 친구의 숫자는" + numberOfFriend + "입니다.");

						byte mySubwayline;
						mySubwayline = 7;
						System.out.println("내 나이는" + mySubwayline + "입니다.");

						byte ageOfMyBoyfriend;
						ageOfMyBoyfriend = 31;
						System.out.println("창현이의 나이는" + ageOfMyBoyfriend + "입니다.");
																				

					//b. short
						short myShoesize;
						myShoesize = 240;
						System.out.println("내 신발사이즈는" + myShoesize + "입니다.");

						short myHeight;
						myHeight = 163;
						System.out.println("내 키는" + myHeight + "입니다.");
                        
						short namsanTowerHeight;
                        namsanTowerHeight = 246;
						System.out.println("남산타워의 높이는" + namsanTowerHeight + "M입니다.");	

					//c. int

					    int 
						

					//d. long
						long myAccountNumber;
						myAccountNumber = 1002043711882L;
						System.out.println("내 계좌번호는" + myAccountNumber + "입니다.");

					

				//2. 실수형
					//a. float 
					    float f1 = 3.14f;
		                System.out.println("내ㅇㅁㄴㄻㅇㄻ" + f1 + "따라라라아ㅣㄹ");

					//b. double
						double d1 = 2.58;
						d1 = 1234567890123456789.1234567890123456789;
						System.out.println(d1);

			//b. 문자형
				//1. 문자형
					//a.char	
                        char c1 = 'A';
		                System.out.println("알파벳의 첫글자는" + c1 + "이다");


   
					
			//c. 논리형
				//1. 논리형
					//a.boolean

					  boolean stop = true;
					  if(stop) {
						System.out.println("중지합니다");
					  } else {
					    System.out.println("시작합니다");

                      }
					  
					  boolean woman = true;
					  if(woman) {
						System.out.println("입장가능");
					  } else {
					    System.out.println("시작합니다");

                      }

            // string
						String hello = "안녕하세요.\n홍길동님";
						System.out.println(hello);

						String introduce = "쌍용교육센터입니다.";
						System.out.println(introduce);

						


	}

}
