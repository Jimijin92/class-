
package com.manager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

import com.common.Schedule;
import com.common.Student;
import com.common.Teacher;
import com.io.ComInSchedule;
import com.io.ComInStudent;
import com.io.ComInTeacher;

public class ComManagerCalendar {
	
	private static Scanner scan;
    //매니저 기본정보 넣은 리스트
	private static ArrayList<Schedule> Schedulelist ;
	private static ArrayList<Student> StudentList;
	private static ArrayList<Teacher> TeacherList;
	public static String id;
	
	static {
		 scan = new Scanner(System.in);
		 Schedulelist = new ArrayList<Schedule>();
		 StudentList = new ArrayList<Student>();
		 TeacherList = new ArrayList<Teacher>();
		 //고유번호
		 
		 id= "harden0";//사용자 아이디
		 
	 }
	
	
	
	public static void main() {
		//whosIdNumber(id);//로그인한 학생의 고유번호 얻는 메소드 
		
		
		//myScheduleList();
		
		ArrayList<ArrayList> TutoringDayAllStudent = new ArrayList<ArrayList>();		
		TutoringDayAllStudent = myScheduleList();
		
		managerdiary(TutoringDayAllStudent);//캘린더
		
		
		
	}//main
		
	
	private static ArrayList<ArrayList> myScheduleList() {//어레이리스트 돌려줌 
		
	    ComInSchedule.load();
		Schedulelist = ComInSchedule.getSchedulelist();
		
		
		ArrayList<ArrayList> TutoringDayAllStudent = new ArrayList<ArrayList>();
		for(int k=0; k<Schedulelist.size(); k++) {		 
				 //1. 첫 수업일 추출하기
				 String startday = "";//없을 경우 생각해서 초기화
				 startday = Schedulelist.get(k).getStartDay();
				 //System.out.println("시작일 : " + startday); //확인	 
					 
			    //2. 1번에서 추출한 첫 수업일의 년, 월, 일을 배열에 넣기 
				String y = ""; //첫 수업일의 연도 초기화
				String m = ""; //첫 수업일의 달	초기화
			    String d = ""; //첫 수업일의 일 초기화		
				
			    String[] arrayDate; // 첫수업일 넣는 배열 생성			     
		        arrayDate = startday.split("-"); //첫수업일 -을 기준으로 나눠 배열에 넣기
		        y = arrayDate[0];//연도가 들어간 방   
		        m = arrayDate[1];//월이 들어간 방 
		        d = arrayDate[2];//일이 들어간 방	
				
				int year = Integer.parseInt(y);//스트링으로 받은 연도 인트로 변환
				int month = Integer.parseInt(m);//스트링으로 받은 월 인트로 변환
				int day = Integer.parseInt(d);//스트링으로 받은 일 인트로 변환
				
				//3. 2번에서 추출한 연도, 월, 일을 활용해서 첫번째 수업일로 캘린더 재설정 (4주간의 수업일자 추출하기 위해서)
				Calendar c = Calendar.getInstance(); //캘린더 객체 생성
				c.set(Calendar.YEAR, year);//로그인 한 학생의 첫번째 수업일자의 연도로 캘린더 재설정
				c.set(Calendar.MONTH, month-1);//로그인 한 학생의 첫번째 수업일자의 월로 캘린더 재설정
				c.set(Calendar.DATE, day);//로그인 한 학생의 첫번째 수업일자의 일로 캘린더 재설정
			
				
				
				//4. 첫번째 수업요일이 무슨 요일이었는지 추출하기
				
				//4-1.
				
				String[] dates = new String[5];//방이 5개인 배열 생성
				dates = Schedulelist.get(k).getDays(); //1번째 학생의 희망요일 배열을 date 배열로 선언
				ArrayList<String> realTutoringDay = new ArrayList<String>();//*을 제외한 수업일만 들어가있을 어레이리스트 배열 선언 
				
				 //System.out.println(Arrays.toString(dates));
				 for(int j=0; j<5; j++) {//희망요일은 5개의 방이니까 5번 돌기
					 if(!dates[j].equals("*")) {//5개의 요일 방 중에 *이 안들어 있으면 realTutoringDay 배열에 추가하기
						 realTutoringDay.add(dates[j]);	
					 }
				 } 
				//System.out.println("수업요일 : " + realTutoringDay); //확인	
				 
				int firstDayOfWeek = 0; //요일 초기화
				firstDayOfWeek = c.get(Calendar.DAY_OF_WEEK);//첫번째 수업일의 요일을 리턴	
				//System.out.println("수업을 시작하는 요일(숫자값) : " + firstDayOfWeek);//확인 
				
				//6. 다음 수업 요일마다 첫 수업일자 추출하기 
				int daynumber = 0;
							
				//한개의 수업의 모든수업일 어레이리스트에 담기
				ArrayList<String> TutoringDayAll = new ArrayList<String>();
				//한개의 수업의 모든수업일 어레이리스트에 담기
				for(int i=0; i<realTutoringDay.size(); 
						i++) {
					
					//뽑아온 요일에따라 스트링인 요일을 인트값으로 생각하기
					if((realTutoringDay.get(i)).equals("일")) {
						daynumber = 1;
					}else if((realTutoringDay.get(i)).equals("월")) {
						daynumber = 2;
					}else if((realTutoringDay.get(i)).equals("화")) {
						daynumber = 3;
					}else if((realTutoringDay.get(i)).equals("수")) {
						daynumber = 4;
					}else if((realTutoringDay.get(i)).equals("목")) {
						daynumber = 5;
					}else if((realTutoringDay.get(i)).equals("금")) {
						daynumber = 6;
					}else if((realTutoringDay.get(i)).equals("토")) {
						daynumber = 7;
					}
					//System.out.println("요일을 숫자로 전환한 값 : " + daynumber);//확인용	
						
					
					
					
					//추출한 희망요일이 시작요일보다 전(시작요일 목요일, 희망요일 월요일) 후인지 따져서 각 요일별 시작일 추출하기 			
					Calendar temp = Calendar.getInstance();//담아놓을 임시 캘린더 객체 생성
					int yearTemp = 0;
					int monthTemp = 0;
					int dayTemp = 0;
					String dateString = "";
					temp.set(Calendar.YEAR, year);//로그인 한 학생의 첫번째 수업일자의 연도로 캘린더 재설정
					temp.set(Calendar.MONTH, month-1);//로그인 한 학생의 첫번째 수업일자의 월로 캘린더 재설정
					temp.set(Calendar.DATE, day);//로그인 한 학생의 첫번째 수업일자의 일로 캘린더 재설정
					
					
					
					
					
					
						if(firstDayOfWeek <= daynumber) {
								
							temp.add(Calendar.DATE,(daynumber-firstDayOfWeek)); // 요일의 차 계산에서 추가해주기 
						
							yearTemp = temp.get(Calendar.YEAR);// 증가된 년 얻기
							monthTemp =temp.get(Calendar.MONTH) + 1;//증가된 월 얻기 (-1 하고 계산했으니까 다시 +1해주기)
							dayTemp = temp.get(Calendar.DATE);//증가된 일 얻기
							
//							System.out.printf("%s요일의 첫 수업 : %d-%d-%d\n"
//																	, realTutoringDay.get(i)
//																	, yearTemp
//																	, monthTemp
//																	, dayTemp);//확인용
							
							//4주간 해당 요일 수업날짜 추출하기 
							dateString = String.format("%04d-%02d-%02d", 
																temp.get(Calendar.YEAR), 
																temp.get(Calendar.MONTH) + 1, 
																temp.get(Calendar.DATE));
							//System.out.println(dateString);//확인용
							TutoringDayAll.add(dateString);
							
								for(int j=0; j<3; j++) {	
									
									
									
									temp.add(Calendar.DATE,(7));
									dateString = String.format("%04d-%02d-%02d", 
																	temp.get(Calendar.YEAR), 
																	temp.get(Calendar.MONTH) + 1, 
																	temp.get(Calendar.DATE));
									//System.out.println(dateString);
									TutoringDayAll.add(dateString);
								}
						
						}else if(firstDayOfWeek > daynumber){
							
							temp.add(Calendar.DATE,(7+daynumber-firstDayOfWeek));
						
							yearTemp = temp.get(Calendar.YEAR);// 증가된 년 얻기
							monthTemp =temp.get(Calendar.MONTH) + 1;//증가된 월 얻기 (-1 하고 계산했으니까 다시 +1해주기)
							dayTemp = temp.get(Calendar.DATE);//증가된 일 얻기
							
//							System.out.printf("%s요일의 첫 수업 : %d-%d-%d\n"
//																, realTutoringDay.get(i)
//																, yearTemp
//																, monthTemp
//																, dayTemp);//확인용	
							
							//4주간 해당 요일 수업날짜 추출하기 
							dateString = String.format("%04d-%02d-%02d", 
																	temp.get(Calendar.YEAR), 
																	temp.get(Calendar.MONTH) + 1, 
																	temp.get(Calendar.DATE));
							//System.out.println(dateString);//확인용
							TutoringDayAll.add(dateString);
							
								for(int j=0; j<3; j++) {	
									temp.add(Calendar.DATE,(7));
									dateString = String.format("%04d-%02d-%02d", 
																		temp.get(Calendar.YEAR), 
																		temp.get(Calendar.MONTH) + 1, 
																		temp.get(Calendar.DATE));
									//System.out.println(dateString);
									TutoringDayAll.add(dateString);
								}//for							
						}//else if 						
				}//for
				//System.out.println("수업일 모두 담은 배열" + TutoringDayAll);
				
				TutoringDayAllStudent.add(TutoringDayAll);
		}//for

		//System.out.println("전체학생 수업일 모두 담은 배열" + TutoringDayAllStudent);
		
			return TutoringDayAllStudent;
	}//myScheduleList()
	 

		 
		 
	

	private static void managerdiary(ArrayList<ArrayList> TutoringDayAll) {
		
		ComInStudent.load();
		StudentList= ComInStudent.getStudentlist();
		ComInTeacher.load();
		TeacherList= ComInTeacher.getTeacherlist();
		
		//System.out.println(TutoringDayAll);
		//★★날짜표시용 달력 고정 틀 A
		int year = 0;
		int month = 0;
		int lastDay = 0; //해당 달력의 마지막 날짜
		int day_of_week = 0; //1일에 해당하는 요일
		
		System.out.println("===================================================================================================");
		System.out.println("                                                                              확인할 연도와 월을 입력하세요");
		System.out.println("===================================================================================================");
		System.out.println("---------------------------------------------------------------------------------------------------");

		System.out.print("확인할 연도 : ");
		year = scan.nextInt();	
		System.out.print("확인할 월 : ");
		month = scan.nextInt();
		System.out.println("---------------------------------------------------------------------------------------------------");
		System.out.println();
		System.out.println();
		
		
		Calendar c = Calendar.getInstance();//현재 운영체제에 설정되어 있는 시간대를 기준으로 하위 객체얻기
		c.set(Calendar.YEAR, year);
		c.set(Calendar.MONTH, month - 1);
		c.set(Calendar.DATE, 1);
		
		lastDay = c.getActualMaximum(Calendar.DATE);//특정월의 마지막일 구하기
		day_of_week = c.get(Calendar.DAY_OF_WEEK);//요일을 리턴하는 함수 
		
	
		//★★일정 메모용 달력 B
		
		int day2 = 1;// B 캘린더의 O을 초기화 시켜주기 위해서
		int myTodo = 1; // 스케쥴이 있는 일
		String myTodoCheck = "O"; // 일정 있는 날 표시
		String vacancy = "X"; // 일정 없는 날 표시 
		
		int year2 = 0;
		int month2 = 0;
		int lastDay2 = 0; //해당 달력의 마지막 날짜
		int day_of_week2 = 0; //1일에 해당하는 요일
		
		Calendar d = Calendar.getInstance();
		d.set(Calendar.YEAR, year);
		d.set(Calendar.MONTH, month - 1);
		d.set(Calendar.DATE, 1);
		
		lastDay = d.getActualMaximum(Calendar.DATE);//특정월의 마지막일 구하기
		day_of_week = d.get(Calendar.DAY_OF_WEEK);//요일을 리턴하는 함수 
		
		
		//★★달력 출력
		System.out.println();
		System.out.println("===================================================================================================");
		System.out.printf("                                                                                                               ▶%d년 %d월◀\n", year, month);
		System.out.println("===================================================================================================");
		System.out.println("[일]\t\t[월]\t\t[화]\t\t[수]\t\t[목]\t\t[금]\t\t[토]");
		System.out.println("---------------------------------------------------------------------------------------------------");
		
		//1일을 해당 요일의 위치에 맞추기 위해 공백을 출력
		for (int i=1; i<day_of_week; i++) {
			System.out.print("\t\t");
		}
		
		
		//TODO O넣을 때 날짜와 비교해서 맞으면 O, 아니면 탭 넣기
				
		
		
		
		int scheduleSum = 0;//날짜별 총 수업건수를 카운트하기 위해 초기화
		//A캘린더
		
		for (int day=1; day<=lastDay; day++) {
			System.out.printf("%3d\t\t", day);

			//토요일 만나면 개행
			if ((day + day_of_week - 2) % 7 == 6) {
				System.out.println();	
				System.out.println();
				
				if(day<=7) {
					for (int j=1; j<day_of_week; j++) {
						System.out.print("\t\t");
					}
				}
				
				
				
		
				//B캘린더 - A 캘린더 한주마다 똑같이 반복하기
				
				for (; day2<=lastDay; day2++) {	
					boolean S = false;
					 //일정있는 날 ★표시하기, 없으면 O표시 
					//for(int i =0; i<TutoringDayAll.size(); i++) {
						for(int j =0; j<TutoringDayAll.size(); j++) {
							for(int k =0; k<TutoringDayAll.get(j).size(); k++) {
								String yeatemp = ""; //첫 수업일의 연도 초기화
								String montemp = ""; //첫 수업일의 달	초기화
							    String daytemp = ""; //첫 수업일의 일 초기화		
								
							    String[] arrayDate; // 첫수업일 넣는 배열 생성			     
						        arrayDate = ((String) TutoringDayAll.get(j).get(k)).split("-"); //첫수업일 -을 기준으로 나눠 배열에 넣기
						        yeatemp = arrayDate[0];//연도가 들어간 방   
						        montemp = arrayDate[1];//월이 들어간 방 
						        daytemp = arrayDate[2];//일이 들어간 방	
								
								int yearint = Integer.parseInt(yeatemp);//스트링으로 받은 연도 인트로 변환
								int monthint = Integer.parseInt(montemp);//스트링으로 받은 월 인트로 변환
								int dayint = Integer.parseInt(daytemp);//스트링으로 받은 일 인트로 변환
								
								
								if(yearint == year && monthint == month && dayint == day2) {
				
									scheduleSum+=1;
								}//if
							}//for
						}//for
						
						 if(scheduleSum>0) {
							 System.out.printf("·%2d건\t\t", scheduleSum);
							 scheduleSum = 0;
						 } else {
							 System.out.printf("%3s\t\t", vacancy);
							 
						 }
						 
						if ((day2 + day_of_week - 2) % 7 == 6) {
							System.out.println();
							System.out.println();
							System.out.println();
							System.out.println();
							day2++;
							break;
						}//if
					//}//for
				}//for
				
				
			}//if
		
		}//for
		
		//B캘린더 마지막 주 출력 (안 넣으면 마지막주는 토요일이 없어서 출력 안함 )
		System.out.println();
		System.out.println();
		
		
		for (; day2<=lastDay; day2++) {	
			boolean S = false;
			 //일정있는 날 ★표시하기, 없으면 O표시 
			//for(int i =0; i<TutoringDayAll.size(); i++) {
				for(int j =0; j<TutoringDayAll.size(); j++) {
					for(int k =0; k<TutoringDayAll.get(j).size(); k++) {
						String yeatemp = ""; //첫 수업일의 연도 초기화
						String montemp = ""; //첫 수업일의 달	초기화
					    String daytemp = ""; //첫 수업일의 일 초기화		
						
					    String[] arrayDate; // 첫수업일 넣는 배열 생성			     
				        arrayDate = ((String) TutoringDayAll.get(j).get(k)).split("-"); //첫수업일 -을 기준으로 나눠 배열에 넣기
				        yeatemp = arrayDate[0];//연도가 들어간 방   
				        montemp = arrayDate[1];//월이 들어간 방 
				        daytemp = arrayDate[2];//일이 들어간 방	
						
						int yearint = Integer.parseInt(yeatemp);//스트링으로 받은 연도 인트로 변환
						int monthint = Integer.parseInt(montemp);//스트링으로 받은 월 인트로 변환
						int dayint = Integer.parseInt(daytemp);//스트링으로 받은 일 인트로 변환
						
						
						if(yearint == year && monthint == month && dayint == day2) {
		
							scheduleSum+=1;
						}//if
					}//for
				}//for
				
				 if(scheduleSum>0) {
					 System.out.printf("·%2d건\t\t", scheduleSum);
					 scheduleSum = 0;
				 } else {
					 System.out.printf("%3s\t\t", vacancy);
					 
				 }
				 
				if ((day2 + day_of_week - 2) % 7 == 6) {
					System.out.println();
					System.out.println();
					day2++;
					break;
				}//if
			//}//for
				
		}//for
		
		

		
		//31일까지 가고 끝나니까 필요없음 		
		/*	if ((day2 + day_of_week - 2) % 7 =
		 * = 6) {
				System.out.println();
				day2++;
				break;
			} 
		}*/
		System.out.println();
		System.out.println("---------------------------------------------------------------------------------------------------");
		System.out.println();
		System.out.println();
	
		
		
		
		//스케쥴 세부보기
		System.out.println("===================================================================================================");
		System.out.print("                                                                     시작시간별 건수를 확인할 날짜를 선택하세요  \n");
		System.out.println("===================================================================================================");
		System.out.println("---------------------------------------------------------------------------------------------------");
		
		System.out.print("확인할 일(날짜)를 입력하세요 : ");
		int dayinput = scan.nextInt();
		System.out.println("---------------------------------------------------------------------------------------------------");
		System.out.println("                      [번호]                 [시작시간]                [수업건수]");
		
		
		
//		System.out.println("전체수업일정담은" + TutoringDayAll);//확인
			
		ArrayList<String> startTimeList = new ArrayList();
			
		for(int j =0; j<TutoringDayAll.size(); j++) {
			for(int k =0; k<TutoringDayAll.get(j).size(); k++) {
				String yeatemp = ""; 
				String montemp = ""; 
			    String daytemp = ""; 	
				
			    String[] arrayDate; 	     
		        arrayDate = ((String) TutoringDayAll.get(j).get(k)).split("-"); //첫수업일 -을 기준으로 나눠 배열에 넣기
		        yeatemp = arrayDate[0];  
		        montemp = arrayDate[1]; 
		        daytemp = arrayDate[2];
				
				int yearint = Integer.parseInt(yeatemp);//스트링으로 받은 연도 인트로 변환
				int monthint = Integer.parseInt(montemp);//스트링으로 받은 월 인트로 변환
				int dayint = Integer.parseInt(daytemp);//스트링으로 받은 일 인트로 변환
				
				
				if(yearint == year && monthint == month && dayint == dayinput) {
					
					String startTime = Schedulelist.get(j).getStartTime();		
					String realStartTime = startTime.substring(0,2);
					startTimeList.add(realStartTime);	
				}//if	
			}//for
		}	
					
			//System.out.println(startTimeList);//확인용
				
			
			
			
			
			
		for(int i=0; i<startTimeList.size(); i++) {
			String startTimeTemp = ""; 
					    
			String[] arrayStartTime; 	     
			arrayStartTime = startTimeList.get(i).split(":");
			startTimeTemp = arrayStartTime[0];  
		}
        
		
		
		
        int num = 1;
        ArrayList<Integer> match = new ArrayList<Integer>();
		for(int i=17 ; i<=21; i++) {
			int timeQuantitySum=0;
			
			for(int j=0; j<startTimeList.size(); j++) {
				if(i == Integer.parseInt(startTimeList.get(j))){
					timeQuantitySum+=1;
				}
			}//for
			
			if(timeQuantitySum>0) {
			System.out.printf("                      %3d                  %1d시,%d시30분                                    %d건\n", num,i-12,i-12,timeQuantitySum);
			match.add(i);//넘버랑 시간이랑 맞춘거 0번째 방이 넘버 원
			num++;
			}
						
		}//for
		
		System.out.println("---------------------------------------------------------------------------------------------------");
		
		
		
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println("===================================================================================================");
		System.out.print("                                                                           세부일정을 확인할 번호를 선택하세요\n");
		System.out.println("===================================================================================================");
		System.out.println("---------------------------------------------------------------------------------------------------");
		
		System.out.print("확인할 번호를 입력하세요 : ");
		int choice = scan.nextInt();
		System.out.println("---------------------------------------------------------------------------------------------------");
		
		int lank = 1;
		System.out.println(" [번호]\t      [시작시간]         [학생이름]       [선생님이름]       [과목]      [가격]         [요일]");
		//스케쥴 세부사항 마지막 확인하기
		for(int j =0; j<TutoringDayAll.size(); j++) {
			for(int k =0; k<TutoringDayAll.get(j).size(); k++) {
				String yeatemp = ""; 
				String montemp = ""; 
			    String daytemp = ""; 	
				
			    String[] arrayDate; 	     
		        arrayDate = ((String) TutoringDayAll.get(j).get(k)).split("-"); //첫수업일 -을 기준으로 나눠 배열에 넣기
		        yeatemp = arrayDate[0];  
		        montemp = arrayDate[1]; 
		        daytemp = arrayDate[2];
				
				int yearint = Integer.parseInt(yeatemp);//스트링으로 받은 연도 인트로 변환
				int monthint = Integer.parseInt(montemp);//스트링으로 받은 월 인트로 변환
				int dayint = Integer.parseInt(daytemp);//스트링으로 받은 일 인트로 변환
				
				
					if(yearint == year && monthint == month && dayint == dayinput) {
					
					String startTime = Schedulelist.get(j).getStartTime();		
					String realStartTime = startTime.substring(0,2);
					
					String choiceTime = match.get(choice-1)+"";  
					//System.out.println(choiceTime);//확인
					
					//System.out.println(match);//확인
					
						if(choiceTime.equals(realStartTime)) {
							
							String startTimeForLastChoice = Schedulelist.get(j).getStartTime();
							int realStartHourInt = Integer.parseInt(startTimeForLastChoice.substring(0,2));
							int realStartMinuteInt = Integer.parseInt(startTimeForLastChoice.substring(3));
							
							String endTimeForLastChoice = Schedulelist.get(j).getTime();
							int realEndHourInt = Integer.parseInt(endTimeForLastChoice.substring(0,1));
							int realEndMinuteInt= Integer.parseInt(endTimeForLastChoice.substring(2));
							int sumEndTime = realEndHourInt*60+realEndMinuteInt;
							
							
							//System.out.println(endTimeForLastChoice.substring(2));//확인
							
							
							Calendar p = Calendar.getInstance();
							p.set(Calendar.HOUR, realStartHourInt);
							p.set(Calendar.MINUTE, realStartMinuteInt);
							p.add(Calendar.MINUTE, sumEndTime);
							
							int EndfinalHour = p.get(Calendar.HOUR);
							String EndfinalMinute = p.get(Calendar.MINUTE)+"";
							
							
							
							if(EndfinalMinute.equals("0")) {
								EndfinalMinute = "00";
							}
								
							
							
							String[] dates = new String[5];//방이 5개인 배열 생성
							dates = Schedulelist.get(j).getDays(); //1번째 학생의 희망요일 배열을 date 배열로 선언
							ArrayList<String> tutoringDay = new ArrayList<String>();//*을 제외한 수업일만 들어가있을 어레이리스트 배열 선언 
							
							 //System.out.println(Arrays.toString(dates));
							 for(int f=0; f<5; f++) {//희망요일은 5개의 방이니까 5번 돌기
								 if(!dates[f].equals("*")) {//5개의 요일 방 중에 *이 안들어 있으면 realTutoringDay 배열에 추가하기
									 tutoringDay.add(dates[f]);	
								 }
							 }
							
							 
							 
							 
							 
							String sName = "";
							for(int n=0; n<StudentList.size(); n++) {
								if((StudentList.get(n).getSNumber()).equals(Schedulelist.get(j).getSNumber())) {
									sName = StudentList.get(n).getSName();
									
								}
							}
							//System.out.println(StudentList.get(10).getSNumber());
							//System.out.println(j);
							//System.out.println(Schedulelist.get(j).getSNumber());
							
							String tName = "";
							for(int n=0; n<TeacherList.size(); n++) {
								if((TeacherList.get(n).getTNumber()).equals(Schedulelist.get(j).getTNumber())) {
									tName = TeacherList.get(n).getTName();
									
								}
							}
							//System.out.println("선생님 이름" + tName);
							 
							 
							
							
							
							
							
							
								
							System.out.printf("   %d\t    %d:%s - %d:%s    \t %s\t\t%s\t              %s\t   %s\t   %s\n"
									, lank
									, realStartHourInt-12 
									, startTimeForLastChoice.substring(3)
									, EndfinalHour
									, EndfinalMinute
									
									, sName
									, tName
									
									, Schedulelist.get(j).getSubject()	
									, Schedulelist.get(j).getPrice()
									, tutoringDay);
									
							
							lank++;
							
						}//if
						
					}//if	
					
					
					
			}//for
			
			
		}//for
		
		System.out.println("---------------------------------------------------------------------------------------------------");
		
		
		
		
		
		
		
		
	}//managerdiary
	
}//class
