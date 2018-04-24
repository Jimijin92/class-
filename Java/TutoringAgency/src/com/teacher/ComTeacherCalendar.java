
package com.teacher;

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
import com.register.ComRegisterLogin;

public class ComTeacherCalendar {
	
	private static Scanner scan;
    //매니저 기본정보 넣은 리스트
	private static ArrayList<Schedule> Schedulelist ;
	private static ArrayList<Student> StudentList;
	private static ArrayList<Teacher> TeacherList;
	
	
	static {
		 scan = new Scanner(System.in);
		 Schedulelist = new ArrayList<Schedule>();
		 StudentList = new ArrayList<Student>();
		 TeacherList = new ArrayList<Teacher>();
		 //고유번호
		 
		 
	 }
	
	
	
	public static void teacherdiary() {
			
		ComInStudent.load();
		StudentList= ComInStudent.getStudentlist();
		ComInSchedule.load();
		Schedulelist = ComInSchedule.getSchedulelist();
		ComInTeacher.load();
		TeacherList = ComInTeacher.getTeacherlist();
		
		
		
		
		//로그인한 고유 번호
		//★★임시변수★★★스케쥴에서 몇번째 방인지★★★77라인, 108라인★★★★★★★★★★ 11이면 11번 방 찾기 
		
		int roomNumber = 0;
		String tNumber = ComRegisterLogin.getUserEndemic();
		
		
		
		
		
		
		ArrayList<String> myclasslist = new ArrayList<String>();
		for(int i=0; i<Schedulelist.size(); i++) {
			if(tNumber.equals(Schedulelist.get(i).getTNumber())) {
				roomNumber = i;
				myclasslist.add(roomNumber+"");
			}
		}
//		System.out.println("스케쥴이 들어있는 방번호" + myclasslist);//확인
		
		
		
		ArrayList<ArrayList> TutoringDayAllStudent = new ArrayList<ArrayList>();
		for(int k=0; k<myclasslist.size(); k++) {	
				roomNumber = Integer.parseInt(myclasslist.get(k));
				 //1. 첫 수업일 추출하기   //미진언니 힘내요... 이제 3일 남았어요.,, 할수있어 우린,,,
				String startday = "";//없을 경우 생각해서 초기화
				startday = Schedulelist.get(roomNumber).getStartDay();
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
				dates = Schedulelist.get(roomNumber).getDays(); //1번째 학생의 희망요일 배열을 date 배열로 선언
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
				for(int i=0; i<realTutoringDay.size(); i++) {
					
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
						
//						System.out.printf("%s요일의 첫 수업 : %d-%d-%d\n"
//																, realTutoringDay.get(i)
//																, yearTemp
//																, monthTemp
//																, dayTemp);//확인용
						
						//4주간 해당 요일 수업날짜 추출하기 
						dateString = String.format("%04d-%02d-%02d", 
															temp.get(Calendar.YEAR), 
															temp.get(Calendar.MONTH) + 1, 
															temp.get(Calendar.DATE));
//						System.out.println(dateString);//확인용
						TutoringDayAll.add(dateString);
						
							for(int j=0; j<3; j++) {	
								
								
								
								temp.add(Calendar.DATE,(7));
								dateString = String.format("%04d-%02d-%02d", 
																temp.get(Calendar.YEAR), 
																temp.get(Calendar.MONTH) + 1, 
																temp.get(Calendar.DATE));
//								System.out.println(dateString);
								TutoringDayAll.add(dateString);
							}
					
					}else if(firstDayOfWeek > daynumber){
							
						
						temp.add(Calendar.DATE,(7+daynumber-firstDayOfWeek));
					
						yearTemp = temp.get(Calendar.YEAR);// 증가된 년 얻기
						monthTemp =temp.get(Calendar.MONTH) + 1;//증가된 월 얻기 (-1 하고 계산했으니까 다시 +1해주기)
						dayTemp = temp.get(Calendar.DATE);//증가된 일 얻기
						
//						System.out.printf("%s요일의 첫 수업 : %d-%d-%d\n"
//																	, realTutoringDay.get(i)
//																	, yearTemp
//																	, monthTemp
//																	, dayTemp);//확인용		
						
						//4주간 해당 요일 수업날짜 추출하기 
						dateString = String.format("%04d-%02d-%02d", 
																temp.get(Calendar.YEAR), 
																temp.get(Calendar.MONTH) + 1, 
																temp.get(Calendar.DATE));
//						System.out.println(dateString);//확인용
						TutoringDayAll.add(dateString);
						
						for(int j=0; j<3; j++) {	
							temp.add(Calendar.DATE,(7));
							dateString = String.format("%04d-%02d-%02d", 
																temp.get(Calendar.YEAR), 
																temp.get(Calendar.MONTH) + 1, 
																temp.get(Calendar.DATE));
//								System.out.println(dateString);
							TutoringDayAll.add(dateString);
						}//for							
					}//else if 						
				}//for
				//System.out.println("수업일 모두 담은 배열" + TutoringDayAll);
				
				
				TutoringDayAllStudent.add(TutoringDayAll);
		//System.out.println("전체학생 수업일 모두 담은 배열" + TutoringDayAllStudent);
					
	}//myScheduleList()

//	System.out.println(TutoringDayAllStudent);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
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
		
		Calendar f = Calendar.getInstance();//현재 운영체제에 설정되어 있는 시간대를 기준으로 하위 객체얻기
		f.set(Calendar.YEAR, year);
		f.set(Calendar.MONTH, month - 1);
		f.set(Calendar.DATE, 1);
		
		lastDay = f.getActualMaximum(Calendar.DATE);//특정월의 마지막일 구하기
		day_of_week = f.get(Calendar.DAY_OF_WEEK);//요일을 리턴하는 함수 
		
	
		//★★일정 메모용 달력 B
		
		int day2 = 1;// B 캘린더의 O을 초기화 시켜주기 위해서
		int myTodo = 1; // 스케쥴이 있는 일
		String myTodoCheck = "수업"; // 일정 있는 날 표시
		String vacancy = ""; // 일정 없는 날 표시 
		
		int year2 = 0;
		int month2 = 0;
		int lastDay2 = 0; //해당 달력의 마지막 날짜
		int day_of_week2 = 0; //1일에 해당하는 요일
		
		Calendar e = Calendar.getInstance();
		e.set(Calendar.YEAR, year);
		e.set(Calendar.MONTH, month - 1);
		e.set(Calendar.DATE, 1);
		
		lastDay = e.getActualMaximum(Calendar.DATE);//특정월의 마지막일 구하기
		day_of_week = e.get(Calendar.DAY_OF_WEEK);//요일을 리턴하는 함수 
		
		
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
				
		
		
		
		
		//A캘린더
		for (int day=1; day<=lastDay; day++) {
			System.out.printf("%3d\t\t", day);
			
			
			
			//토요일 만나면 개행
			if ((day + day_of_week - 2) % 7 == 6) {
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
					for(int j =0; j<TutoringDayAllStudent.size(); j++) {
						for(int k =0; k<TutoringDayAllStudent.get(j).size(); k++) {
						
							String yeatemp = ""; //첫 수업일의 연도 초기화
							String montemp = ""; //첫 수업일의 달	초기화
						    String daytemp = ""; //첫 수업일의 일 초기화		
							
						    // 첫수업일 넣는 배열 생성			   
						    String[] arrayDate;
					        arrayDate = ((String) TutoringDayAllStudent.get(j).get(k)).split("-"); //첫수업일 -을 기준으로 나눠 배열에 넣기
					        yeatemp = arrayDate[0];//연도가 들어간 방   
					        montemp = arrayDate[1];//월이 들어간 방 
					        daytemp = arrayDate[2];//일이 들어간 방	
							
							int yearint = Integer.parseInt(yeatemp);//스트링으로 받은 연도 인트로 변환
							int monthint = Integer.parseInt(montemp);//스트링으로 받은 월 인트로 변환
							int dayint = Integer.parseInt(daytemp);//스트링으로 받은 일 인트로 변환
						
						
							if(yearint == year && monthint == month && dayint == day2) {
								S = true;
							}//if
						
						}//for	 
					}//for
					
					
					 if(S == true) {
						 System.out.printf("%3s\t\t", myTodoCheck);
						 
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
					
					
				}//for
				
				
				
			}//if
			
			
		}//for
		
		
		
		
		
		
		//B캘린더 마지막 주 출력 (안 넣으면 마지막주는 토요일이 없어서 출력 안함 )
		System.out.println();
		
		for (; day2<=lastDay; day2++) {	
			boolean S = false;
			 //일정있는 날 ★표시하기, 없으면 O표시 
			for(int j =0; j<TutoringDayAllStudent.size(); j++) {
				for(int k =0; k<TutoringDayAllStudent.get(j).size(); k++) {
					
						String yeatemp = ""; //첫 수업일의 연도 초기화
						String montemp = ""; //첫 수업일의 달	초기화
					    String daytemp = ""; //첫 수업일의 일 초기화		
						
					    String[] arrayDate; 		     
				        arrayDate = ((String) TutoringDayAllStudent.get(j).get(k)).split("-"); //첫수업일 -을 기준으로 나눠 배열에 넣기
				        yeatemp = arrayDate[0];//연도가 들어간 방   
				        montemp = arrayDate[1];//월이 들어간 방 
				        daytemp = arrayDate[2];//일이 들어간 방	
						
						int yearint = Integer.parseInt(yeatemp);//스트링으로 받은 연도 인트로 변환
						int monthint = Integer.parseInt(montemp);//스트링으로 받은 월 인트로 변환
						int dayint = Integer.parseInt(daytemp);//스트링으로 받은 일 인트로 변환
					
					
						if(yearint == year && monthint == month && dayint == day2) {
							S = true;
						}//if
								 
				}//for
			}
			
			 if(S == true) {
				 System.out.printf("%3s\t", myTodoCheck);
				 
			 } else {
				 System.out.printf("%3s\t", vacancy);
				 
			 }
			 
			if ((day2 + day_of_week - 2) % 7 == 6) {
				System.out.println();
				System.out.println();	
				System.out.println();
				System.out.println();
				day2++;
				break;
			}//if
		}//for	
		System.out.println();
		System.out.println("---------------------------------------------------------------------------------------------------");
		//31일까지 가고 끝나니까 필요없음 		
		/*	if ((day2 + day_of_week - 2) % 7 =
		 * = 6) {
				System.out.println();
				day2++;
				break;
			} 
		}*/
		
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println("===================================================================================================");
		System.out.print("                                                                           세부일정을 확인할 번호를 선택하세요\n");
		System.out.println("===================================================================================================");
		System.out.println("---------------------------------------------------------------------------------------------------");
		
		System.out.print("확인할 날짜를 입력하세요 : ");
		int dayinput = scan.nextInt();
		System.out.println("---------------------------------------------------------------------------------------------------");
		System.out.println("   [수업시간]              [학생이름]               [과목]               [가격]             [과외 시작일]");
		
		//System.out.println(TutoringDayAll);//확인
		for(int j =0; j<TutoringDayAllStudent.size(); j++) {
			for(int k =0; k<TutoringDayAllStudent.get(j).size(); k++) {
				
					String yeatemp = ""; 
					String montemp = ""; 
				    String daytemp = ""; 	
				    
				    String[] arrayDate;
			        arrayDate = ((String) TutoringDayAllStudent.get(j).get(k)).split("-"); //첫수업일 -을 기준으로 나눠 배열에 넣기
			        yeatemp = arrayDate[0];  
			        montemp = arrayDate[1]; 
			        daytemp = arrayDate[2];
					
					int yearint = Integer.parseInt(yeatemp);//스트링으로 받은 연도 인트로 변환
					int monthint = Integer.parseInt(montemp);//스트링으로 받은 월 인트로 변환
					int dayint = Integer.parseInt(daytemp);//스트링으로 받은 일 인트로 변환
					
//					System.out.println("스케쥴별 일자 확인 "+dayint);
					
					if(yearint == year && monthint == month && dayint == dayinput) {
					
//						System.out.println(j); //스케쥴이 들어있는 방번호 에서 j번방의 넘버 10, 10번쨰 방의 정보 불러오기		
						
						int findNum = Integer.parseInt(myclasslist.get(j));
						//스케쥴이 들어있는 방번호[10, 60]
						//[[2018-01-01, 2018-01-08, 2018-01-15, 2018-01-22], 
						//[2017-12-30, 2018-01-06, 2018-01-13, 2018-01-20]]		
								
		
								
						//시간 구하기 
						String startTimeForLastChoice = Schedulelist.get(findNum).getStartTime();
						int realStartHourInt = Integer.parseInt(startTimeForLastChoice.substring(0,2));
						int realStartMinuteInt = Integer.parseInt(startTimeForLastChoice.substring(3));
						
						String endTimeForLastChoice = Schedulelist.get(findNum).getTime();
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
							}//if
						
						
						String sName = "";
						for(int n=0; n<StudentList.size(); n++) {
							if((StudentList.get(n).getSNumber()).equals(Schedulelist.get(findNum).getSNumber())) {
								sName = StudentList.get(n).getSName();
							}
						}		
								
								
						System.out.printf(" %d:%s - %d:%s \t\t     %s\t\t\t  %s\t\t    %s만원\t      %s\n"
								, realStartHourInt-12 
								, startTimeForLastChoice.substring(3)
								, EndfinalHour
								, EndfinalMinute
								
								, sName
								, Schedulelist.get(findNum).getSubject()	
								, Schedulelist.get(findNum).getPrice()
								, Schedulelist.get(findNum).getStartDay());
//						System.out.println(dayinput);
//						System.out.println(dayint);
						
								
							}//if
							
						}//for
						
					}//if
		System.out.println("---------------------------------------------------------------------------------------------------");

	}//메소드
}//class
	
