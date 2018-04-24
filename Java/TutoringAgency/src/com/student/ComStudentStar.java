package com.student;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import com.common.Application;
import com.common.Schedule;
import com.common.Teacher;
import com.common.TeacherAddInfor;
import com.io.ComInSchedule;
import com.io.ComInStudent;
import com.io.ComInTeacher;
import com.register.ComRegisterLogin;

public class ComStudentStar {
	
	private static final String FILETPATH = ".\\Data\\선생님 기본정보.dat";	
	private static final String FILESCHEDULEPATH = ".\\Data\\스케줄.dat";	
	
	private static Scanner scan ;
	private static ArrayList<Teacher> Teacherlist;
	private static ArrayList<Schedule> Schedulelist ;
	
	static String inputnumber; 
	
	static ArrayList<String> Tnumber ;//수강하고 있는 여러 선생님들 담기
	static ArrayList<String> schStar ;//각각의 스케쥴마다 평가된 별점
	static ArrayList<String> schNumber ;//스케쥴마다 해당 스케쥴번호를 담음
	static ArrayList<String> schSub ; //스케쥴의 과목을 담음
	
	static ArrayList<String> Tname ;//선생님 리스트에서 선생님 이름 뽑기
	static ArrayList<String> starcheck; 
	static ArrayList<String> starnum;
	static String starName;
	static HashMap<String,String> Hstar;
	static int starcount; 
	static String inputnumber3;
	static String inputnumber2;
	
	//초기화////////////////////////////////////////////////
	static {
		inputnumber = "";
		Teacherlist = new ArrayList<Teacher>(); 
		Schedulelist = new ArrayList<Schedule>();
	
		scan = new Scanner(System.in);
		
		Tnumber = new ArrayList<String>();
		schStar = new ArrayList<String>();
		schNumber = new ArrayList<String>();
		schSub = new ArrayList<String>();
		Tname = new ArrayList<String>();
		starnum = new ArrayList<String>();
		starcheck = new ArrayList<String>();
		
		starName = "";
		Hstar = new HashMap<String,String>();
		starcount = 0;
		
		inputnumber3 = "";
		inputnumber2 = "";
	}
	
	public static void SCHList() {
		ComInSchedule.load();
		ComInTeacher.load();
		
		//System.out.print("회원입력 : ");
		inputnumber = ComRegisterLogin.getUserEndemic();//로그인시 고유번호 불러옴
		
		
		Schedulelist = ComInSchedule.getSchedulelist();
		Teacherlist = ComInTeacher.getTeacherlist();
		

		System.out.println("[수업번호]\t[이름]\t[과목]\t\t[평가여부]");
		
		for(Schedule sch : Schedulelist) {
			if(sch.getSNumber().equals(inputnumber)) {
				
				Tnumber.add(sch.getTNumber());
				
				schStar.add(sch.getStar());
				schNumber.add(sch.getClassNumber());
				schSub.add(sch.getSubject());
				starnum.add(sch.getStar());
				
			
			}
		}
		
		for(int k =0; k<starnum.size();k++) {
			if(starnum.get(k).equals("0")) {
				starcheck.add("미평가");
			}else{
				starcheck.add("평가완료");
			}
		}
		
		for(Teacher t : Teacherlist) {
			for(int i=0 ; i<Tnumber.size();i++) {
				if(t.getTNumber().equals(Tnumber.get(i))){
					Tname.add(t.getTName());
				}
			}
		}
		//System.out.println(Tname);
		//System.out.println(Tnumber.size());
		for(int j =0; j<Tnumber.size();j++) {
				
				System.out.printf("%s\t\t%s\t%s\t\t%s\n"
									,schNumber.get(j)
									,Tname.get(j)
									,schSub.get(j)
									,starcheck.get(j));

		}
		boolean flag = false;
		for(int k =0; k<starcheck.size();k++) {
			if(starcheck.get(k).equals("평가완료")) {
				
				flag = true;
				
			}else{
				STGiveStar();
			}
		}
		
		if(flag) {
			System.out.println();
			System.out.println("모든 선생님을 평가하셨습니다.");
		}
		//STGiveStar();



	}//SCHList()
	public static void STGiveStar() {
		ComInSchedule.load();
		ComInTeacher.load();
		
		Schedulelist = ComInSchedule.getSchedulelist();
		Teacherlist = ComInTeacher.getTeacherlist();
		
		System.out.print("평가하실 선생님의 수업번호를 입력해주세요 : ");
		inputnumber3 = scan.nextLine();
		
		for(int j =0; j<Tnumber.size();j++) {
			if(schNumber.get(j).equals(inputnumber3) && schStar.get(j).equals("0")) {
				System.out.println();
				System.out.println("[수업번호]\t[이름]\t[과목]\t\t[평가여부]");
				System.out.printf("%s\t\t%s\t%s\t\t%s\n"
									,schNumber.get(j)
									,Tname.get(j)
									,schSub.get(j)
									,starcheck.get(j));
				System.out.println();
				System.out.println("===============<별점선택>===============");
				System.out.println("1.★ 2.★★ 3.★★★ 4.★★★★ 5.★★★★★");
				System.out.println();
				System.out.print("평가하실 별점을 선택해 주세요 : ");
				inputnumber2 = scan.nextLine();
				System.out.println();
				System.out.println();
				
				starnum.set(j,inputnumber2);
				
				for(Schedule sch : Schedulelist) {
					if(sch.getSNumber().equals(inputnumber) && sch.getClassNumber().equals(inputnumber3)) {
						sch.setStar(inputnumber2);
						
					}else if(schNumber.get(j).equals(inputnumber) &&schStar.get(j).equals("1")) {
						System.out.println("평가하셨습니다. 다른 수업번호를 선택해주세요.");
						System.out.println();
						STGiveStar();
					}
				}

			}else if(schNumber.get(j).equals(inputnumber3) && !(schStar.get(j).equals("0"))){
				System.out.println();
				System.out.println("평가 하셨습니다. 다른선생님을 선택해 주세요.");
				System.out.println();
				save();
				ComStudentStar.SCHList();
				System.out.println();
				
			}
		}

		for(Teacher t : Teacherlist) {
			for(int i=0 ; i<Tnumber.size();i++) {
				Hstar = t.getTStar();
				if(t.getTNumber().equals(Tnumber.get(i))){
					if(inputnumber2.equals("1")) {
						starName = "1점";
						starcount = Integer.parseInt(t.getTStar().get(starName));
						
						//System.out.println(starcount); //질문!!!
	
						Hstar.put(starName, (starcount+1)+"");
						t.setTStar(Hstar);
						break;
					}else if(inputnumber2.equals("2")) {
						starName = "2점";
						starcount = Integer.parseInt(t.getTStar().get(starName));
						Hstar.put(starName, (starcount+1)+"");
						t.setTStar(Hstar);
						break;
					}else if(inputnumber2.equals("3")) {
						starName = "3점";
						starcount = Integer.parseInt(t.getTStar().get(starName));
						Hstar.put(starName, (starcount+1)+"");

						break;
					}else if(inputnumber2.equals("4")) {
						starName = "4점";
						starcount = Integer.parseInt(t.getTStar().get(starName));
						Hstar.put(starName, (starcount+1)+"");
						t.setTStar(Hstar);
						break;
					}else if(inputnumber2.equals("5")) {
						
						starName = "5점";
						starcount = Integer.parseInt(t.getTStar().get(starName));
						Hstar.put(starName,(starcount+1)+"");
						t.setTStar(Hstar);
						
						//starName = "5점";
						//starcount = Integer.parseInt(t.getTStar().get(starName));
						//t.getTStar().put(starName, (starcount+1)+"");
						break;
					}
				}
			}
		}

		save();
		
	
	}//STGiveStar()	
	private static void save() { //선생님과 스케쥴에 저장하기 다시 쓰기!
		try {//선생님 리스트에 수정하기
			
			BufferedWriter writer = new BufferedWriter(new FileWriter(FILETPATH));
			
			//ArrayList -> Applicationlist 1개 => Applicationlist.dat의 1줄로 나타나게 해야한다!!
			
			for(Teacher t : Teacherlist) {
				String[] tZone = t.getTZone();
				String[] tSubject = t.getTSubject();
				HashMap<String,String> tStar = t.getTStar() ;
				
				String line = String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s"
						,t.getTJumin(),t.getTId(),t.getTPw(),t.getTName()
						,t.getTGender(),t.getTAge(),t.getTAddress(),t.getTTel()
						,t.getTUniv(),t.getTDepart(),t.getTGrade()
						,t.getTCareer(),tZone[0],tZone[1],tZone[2]
						,t.getTTarget(),t.getTPrice()
						,tSubject[0],tSubject[1]
						,"1점",tStar.get("1점"),"2점",tStar.get("2점"),"3점",tStar.get("3점")
						,"4점",tStar.get("4점"),"5점",tStar.get("5점")
						,t.getTDivision(),t.getTNumber());
				writer.write(line); //메모리 -> 텍스트파일(dat) 복사
				writer.newLine();
				
			}
			
			writer.close();
			
		} catch (Exception e) {
			System.out.println("save : " + e.toString());

		}

		try {//스케쥴에 덮어쓰기
			BufferedWriter writer = new BufferedWriter(new FileWriter(FILESCHEDULEPATH));
			
			//ArrayList -> Applicationlist 1개 => Applicationlist.dat의 1줄로 나타나게 해야한다!!
			
			for(Schedule sch : Schedulelist) {
				String[] temp = sch.getDays();
				String line = String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s"
						,sch.getClassNumber(),sch.getTNumber(),sch.getSNumber(),sch.getStartDay()
						,sch.getSubject(),sch.getPrice(),sch.getStartTime(),sch.getTime()
						,sch.getTcancel(),sch.getScancel(),sch.getTotalCancel()
						,sch.getState(),temp[0],temp[1],temp[2],temp[3],temp[4],sch.getStar());
				writer.write(line); //메모리 -> 텍스트파일(dat) 복사
				writer.newLine();
				
			}
			
			writer.close();
			
		} catch (Exception e) {
			System.out.println("save : " + e.toString());
		}
		
		Tnumber.clear();//수강하고 있는 여러 선생님들 담기
		schStar.clear();//각각의 스케쥴마다 평가된 별점
		schNumber.clear();//스케쥴마다 해당 스케쥴번호를 담음
		schSub.clear(); //스케쥴의 과목을 담음
		
		Tname.clear();//선생님 리스트에서 선생님 이름 뽑기
		starcheck.clear(); 
		starnum.clear();

		Hstar.clear();

		
	}
	
}//ComStudentStar
