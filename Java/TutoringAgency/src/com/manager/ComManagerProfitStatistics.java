package com.manager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import com.common.Schedule;
import com.io.ComInSchedule;

public class ComManagerProfitStatistics {
	
	private static Scanner scan;
	
	private static ArrayList<Schedule> Schedulelist;
		
		
	static {
		scan = new Scanner(System.in);
		
		Schedulelist = new ArrayList<Schedule>();	
	}
	
	public static void profitStatistics() {//2. 해당연도의 월별 수익
		
		
		ComInSchedule.load();
		Schedulelist = ComInSchedule.getSchedulelist();
		
		String startDate = ""; //성사일(스케줄 첫 수업일)
		String[] arrayDate; // 첫수업일 넣는 배열
		String year = ""; //첫 수업일의 연도
		String month = ""; //첫 수업일의 달
		
		int cost = 0; //각 수업의 가격 
		double commission = 0.08;//수수료

		HashMap<String,int[]> outerMap = new HashMap<String, int[]>();//연도별 카운트 담을 배열 
		
		for (int i=0; i<Schedulelist.size(); i++) {
			

			
			startDate = Schedulelist.get(i).getStartDay(); //첫수업일 : 2017-01-03
			
			cost = Integer.parseInt(Schedulelist.get(i).getPrice()); //각 수업별 가격 
			
			arrayDate = startDate.split("-"); //첫수업일 배열에 넣기
			
			year = arrayDate[0];//연도가 들어간 방 "2017"
			
			month = arrayDate[1];//월이 들어간 방 "01"
			
			
//				System.out.println(year);
//				System.out.println(month);
			
			
			if (!outerMap.containsKey(year)) { //key에 연도가 없으면  
	
				
				outerMap.put(year, new int[12]); //key연도랑 배열 만들고 

				
			} 
			
			
			
			
			
			
			if (month.equals("01")) {//연도별 수익 넣기
				
				outerMap.get(year)[0] = outerMap.get(year)[0]+(int)(cost*10000*commission); //수익 계산해서 넣기 (한달가격*수수료)

				
			}else if (month.equals("02")) {
				
				outerMap.get(year)[1] = outerMap.get(year)[1]+(int)(cost*10000*commission); //수익 계산해서 넣기 (한달가격*수수료)
				
			}else if (month.equals("03")) {
				
				outerMap.get(year)[2] = outerMap.get(year)[2]+(int)(cost*10000*commission); //수익 계산해서 넣기 (한달가격*수수료)

				
			}else if (month.equals("04")) {
				
				outerMap.get(year)[3] = outerMap.get(year)[3]+(int)(cost*10000*commission); //수익 계산해서 넣기 (한달가격*수수료)

				
			
			}else if (month.equals("05")) {
				
				outerMap.get(year)[4] = outerMap.get(year)[4]+(int)(cost*10000*commission); //수익 계산해서 넣기 (한달가격*수수료)

				
			
			}else if (month.equals("06")) {
				
				outerMap.get(year)[5] = outerMap.get(year)[5]+(int)(cost*10000*commission); //수익 계산해서 넣기 (한달가격*수수료)

				
			
			}else if (month.equals("07")) {
				
				outerMap.get(year)[6] = outerMap.get(year)[6]+(int)(cost*10000*commission); //수익 계산해서 넣기 (한달가격*수수료)

				
			
			}else if (month.equals("08")) {
				
				outerMap.get(year)[7] = outerMap.get(year)[7]+(int)(cost*10000*commission); //수익 계산해서 넣기 (한달가격*수수료)


				
			}else if (month.equals("09")) {
				
				outerMap.get(year)[8] = outerMap.get(year)[8]+(int)(cost*10000*commission); //수익 계산해서 넣기 (한달가격*수수료)

				
			
			}else if (month.equals("10")) {
				
				outerMap.get(year)[9] = outerMap.get(year)[9]+(int)(cost*10000*commission); //수익 계산해서 넣기 (한달가격*수수료)

				
			
			}else if (month.equals("11")) {
				
				outerMap.get(year)[10] = outerMap.get(year)[10]+(int)(cost*10000*commission); //수익 계산해서 넣기 (한달가격*수수료)

				
			
			}else if (month.equals("12")) {
				
				outerMap.get(year)[11] = outerMap.get(year)[11]+(int)(cost*10000*commission); //수익 계산해서 넣기 (한달가격*수수료)

			}		
			
		
				

		
		}//for
		
//			System.out.println(outerMap.get("2017")[11]);
		
				
		
		
		//그래프 찍기 
		
		System.out.println("=============================");
		System.out.println("해당 연,월 별 수익표 보기");
		
		
		
		System.out.println("원하는 연도를 입력해주세요.");
		String putYear = scan.nextLine();
		
		
		//해당 연도의 전체 수익 구하기
		int totalCost =0;
		
		for (int i = 0; i<12; i++) {
			
			totalCost = totalCost+outerMap.get(putYear)[i];
			
	
			
		}

		
		

		System.out.println();
		System.out.println("=============================");
		System.out.printf("%s의 월별 수익", putYear);
		System.out.println();
		System.out.println("=============================");
		
		for (int i = 0; i<12; i++) {
			
			System.out.printf("%d월 : %,d원", i+1, outerMap.get(putYear)[i] );
			
			System.out.println();
			
		}
		
		System.out.println("=============================");
		
		System.out.printf("%s년의 총수익 : %,d원", putYear, totalCost);
		
		System.out.println();
		
		System.out.println("=============================");
		
		

		

		
		
	
		
		
		
		
		
	}//profit
	
	

} //
