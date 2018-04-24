package com.student;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

import com.common.Schedule;
import com.io.ComInSchedule;

public class ComStudentCancle {

	private static ArrayList<Schedule> sch;
	
	
	static {
		sch = new ArrayList<Schedule>();
	}
	
	
	
	public static void cancle(ArrayList<String> schNum) {	//매개변수로 스케줄의 고유번호를 포함하고 있는 리스트를 받음
		
		ComInSchedule.load();
		sch = ComInSchedule.getSchedulelist();
		String path = ".\\Data\\스케줄.dat";
		try {
			BufferedReader reader = new BufferedReader(new FileReader(path));
			BufferedWriter writer = new BufferedWriter(new FileWriter(path));
			
			
			ArrayList<String> number = new ArrayList<String>();		//스케줄 번호 == line 번호가 아님. getNum = 스케줄 번호
			ArrayList<Integer> lineNum = new ArrayList<Integer>();	//스케줄 번호를 갖고 있는 라인의 번호 가져오기(수정할때 사용)
			
			ArrayList<Schedule> line = new ArrayList<Schedule>();	
			number = schNum;
			
			int loop = number.size();//본인 스케줄 갯수(루프 돌리기용)
			
			int count = 0;//index 값(몇번째 줄에 원하는 값이 들어있는지. count가 알아내줌
			for(Schedule s : sch) {
				for(int i=0; i<number.size(); i++) {
					
					if(s.getClassNumber().equals(number.get(i))) {	//매개변수로 받은 스케줄 번호로 그 번호의 위치 (line)을 찾아내 lineNum에 저장
						lineNum.add(count);							//lineNum = 해당 스케줄들의 번호(식별자)를 갖고 있는 라인의 위치들의 list
					}
				}
				count ++;
			}
			
			
			
			
			for(Integer i : lineNum) {	//해당학생 취소횟수 늘리기!
			
				
				Schedule temp = new Schedule();
				String[] setDays = new String[5];
				setDays[0] = sch.get(i).getDays()[0];
				setDays[1] = sch.get(i).getDays()[1];
				setDays[2] = sch.get(i).getDays()[2];
				setDays[3] = sch.get(i).getDays()[3];
				setDays[4] = sch.get(i).getDays()[4];
				
				
				temp.setClassNumber(sch.get(i).getClassNumber());
				temp.setTNumber(sch.get(i).getTNumber());
				temp.setSNumber(sch.get(i).getSNumber());
				temp.setStartDay(sch.get(i).getStartDay());
				temp.setSubject(sch.get(i).getSubject());
				temp.setPrice(sch.get(i).getPrice());
				temp.setStartTime(sch.get(i).getStartTime());
				temp.setTime(sch.get(i).getTime());
				temp.setTcancel(sch.get(i).getTcancel());
				temp.setScancel(Integer.parseInt(sch.get(i).getScancel())+1+"");			//학생이 취소 -> 취소횟수 +1
				temp.setTotalCancel(Integer.parseInt(sch.get(i).getTotalCancel())+1+"");	//학생+선생님 취소 +1
				temp.setState(sch.get(i).getState());
				temp.setDays(setDays);;
				temp.setStar(sch.get(i).getStar());
				
				sch.add(i,temp); //<--변경된 i번쨰 줄에 temp 끼워넣기
				sch.remove(i+1);	//<- 한칸 뒤로 밀린 기존의 i번쨰 삭제!
			
			}
			
			for(Schedule s : sch) {	//수정된 값이 포함된 스케줄로 덮어쓰기
				String modifiedLine = String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s"
						,s.getClassNumber(),s.getTNumber(),s.getSNumber(),s.getStartDay()
						,s.getSubject(),s.getPrice(),s.getStartTime(),s.getTime()
						,s.getTcancel(),s.getScancel(),s.getTotalCancel()
						,s.getState(),s.getDays()[0],s.getDays()[1],s.getDays()[2],s.getDays()[3],s.getDays()[4],s.getStar());
				writer.write(modifiedLine);
				writer.newLine();
			}
			writer.close();
			
			
			
		} catch (Exception e) {
			System.out.println("cancle : " + e.toString());
		}
		
		
		System.out.println("취소가 완료되었습니다.");
		ComStudentMenu.SMenu();
		
		
	}
	
}
