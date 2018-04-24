package com.project2.mvc.manager;

import java.sql.SQLException;
import java.util.Calendar;
import java.util.Scanner;

import com.project2.mvc.manager.model.BasicInfoDAO;
import com.project2.mvc.manager.model.OpenCourseInfoDAO;
import com.project2.mvc.model.TblBookDTO;
import com.project2.mvc.model.TblClassRoomDTO;
import com.project2.mvc.model.TblCourseDTO;
import com.project2.mvc.model.TblManagerDTO;
import com.project2.mvc.model.TblOpenCourseDTO;
import com.project2.mvc.model.TblTeacherDTO;
import com.project2.mvc.view.MainView;

public class OpenCourseInfoClass {

	private OpenCourseInfoDAO dao;
	private Scanner scan;
	private boolean loop;
	private MainView mainView;
	private String m_id = "A1";
	private String o_cou_seq;
    private BasicInfoDAO bdao;
	
	
	public OpenCourseInfoClass() {
		mainView = new MainView();
		dao = new OpenCourseInfoDAO();		
		scan = new Scanner(System.in);
		loop = true;
		bdao = new BasicInfoDAO();
	}

	
	//확인용
	public static void main(String[] args) throws SQLException {
		
		OpenCourseInfoClass a = new OpenCourseInfoClass();
		//a.openCourseList();
		a.openCourseSubjectList();
		//a.openCourseStudentList();
		
//		a.openCourseListM();
//		a.openCourseSubjectListMy();
//		a.openCourseStudentListMy();
		
		
		//a.openCourseAdd();
		//a.openCourseDel();
	    //a.openCourseClEdit();
		
		
	}//main



//=================================전체용=====================================
	//(전체용)개설과정 출력
	private void openCourseList() {
		dao.openCourseList();
	}
	
	//(전체용)특정 개설과정의 개설과목 출력
	private void openCourseSubjectList() throws SQLException {
		
		mainView.titlebar("개설과목 정보확인하기");
		
		TblOpenCourseDTO dto = new TblOpenCourseDTO();
		String o_cou_seq = "";
		while(loop) {
			mainView.choice("과정번호");
			o_cou_seq = scan.nextLine();
			dto.setO_cou_seq(o_cou_seq);
			if(!o_cou_seq.equals("")) {
				if(dao.checkOpenCourseChoice(dto) == 1) {
					//제대로 선택한거
					dao.openCourseSubjectList(dto);// 목록출력해서 보여주기
					loop = false;
				} else {
					mainView.result("목록내에서 선택해주세요.");
				}
			}else {
			System.out.println("번호를 입력해주세요.");
			}
		
		}//while
		
	}

	//(전체용)특정 개설과정의 개설과목 출력
		private void openCourseStudentList() throws SQLException {
			
			mainView.header("과정학생 정보확인하기");
			
			TblOpenCourseDTO dto = new TblOpenCourseDTO();
			String o_cou_seq = "";
			
			while(loop) {
				mainView.choice("과정번호");
				o_cou_seq = scan.nextLine();
				dto.setO_cou_seq(o_cou_seq);
				if(!o_cou_seq.equals("")) {
					if(dao.checkOpenCourseChoice(dto) == 1) {
						//제대로 선택한거
						dao.openCourseStudentList(dto);
						loop = false;
					} else {
						mainView.result("목록내에서 선택해주세요.");
					}
				}else {
				System.out.println("번호를 입력해주세요.");
				}
			
				
			}//while
			
		}
	
//===============================담당용=======================================
		//출력
		private void openCourseListM() {	

			if(dao.openCourseListMyCheck(m_id) == 1) {
				dao.openCourseListMy(m_id);
			}else if (dao.openCourseListMyCheck(m_id) == 0){
				mainView.result("담당개설과정이 없습니다.");
			}
				
		}
	
	//(전체용)특정 개설과정의 개설과목 출력
		private void openCourseSubjectListMy() throws SQLException {
	
			mainView.header("개설과목 정보확인하기");
			
			TblOpenCourseDTO dto = new TblOpenCourseDTO();
		
			String o_cou_seq = "";
			while(loop) {
				mainView.choice("과정번호");
				o_cou_seq = scan.nextLine();
				dto.setO_cou_seq(o_cou_seq);
				if(!o_cou_seq.equals("")) {
					if(dao.checkOpenCourseChoiceMy(dto, m_id) == 1) {
						//제대로 선택한거
						dao.openCourseSubjectList(dto);// 목록출력해서 보여주기
						loop = false;
					} else {
						mainView.result("목록내에서 선택해주세요.");
					}
				}else {
				System.out.println("번호를 입력해주세요.");
				}
			
			}//while
			
		}

		//(전체용)특정 개설과정의 개설과목 출력
			private void openCourseStudentListMy() throws SQLException {
				
				mainView.header("과정학생 정보확인하기");
				
		
				TblOpenCourseDTO dto = new TblOpenCourseDTO();
				String o_cou_seq = "";
				while(loop) {
					mainView.choice("과정번호");
					o_cou_seq = scan.nextLine();
					dto.setO_cou_seq(o_cou_seq);
					if(!o_cou_seq.equals("")) {
						if(dao.checkOpenCourseChoiceMy(dto, m_id) == 1) {
							//제대로 선택한거
							dao.openCourseStudentList(dto);
							loop = false;
						} else {
							mainView.result("목록내에서 선택해주세요.");
						}
					}else {
					System.out.println("번호를 입력해주세요.");
					}
				
					
				}//while
				
			}
	
	

	//개설과정 등록하기 
			public void openCourseAdd() throws SQLException {
				mainView.header("개설과정 등록하기");
				
				

				//개강일, 종강일 맞게 입력하는 루프
				boolean loopFirst = true;
				String start_date = "";
				String end_date = "";
				while(loopFirst) {
					
						mainView.choice("개강년도");
						String start_year =  scan.nextLine();
						mainView.choice("개강월");
						String start_month = scan.nextLine();
						mainView.choice("개강일");
						String start_day =  scan.nextLine();
						start_date = start_year+  "-" + start_month + "-" + start_day;
						
						mainView.choice("종강년도");
						String end_year = scan.nextLine();
						mainView.choice("종강월");
						
						String end_month = scan.nextLine();
						mainView.choice("종강일");
						String end_day = scan.nextLine();
						end_date = (end_year+ "") + "-" + (end_month+"") + "-" + (end_day+"");
						
						Calendar cal = Calendar.getInstance();
						
						cal.set(Calendar.YEAR, Integer.parseInt(start_year));
						cal.set(Calendar.YEAR, Integer.parseInt(start_month));
						cal.set(Calendar.YEAR, Integer.parseInt(start_day));
						
						Calendar cal2 = Calendar.getInstance();
						
						cal2.set(Calendar.YEAR, Integer.parseInt(end_year));
						cal2.set(Calendar.YEAR, Integer.parseInt(end_month));
						cal2.set(Calendar.YEAR, Integer.parseInt(end_day));
						
//						System.out.println(cal);
//						System.out.printf("%tF\n", cal);
						
						//앞의 변수가 더 크면 1, 더 작으면 -1 같으면 0
					
							if( cal2.compareTo(cal) == 1) {
								loopFirst = false;
							}else {
								mainView.result("종강일은 개강일 이후여야 합니다. 다시입력하세요");
							}						
						
							
					}//while
				
				
				System.out.println(start_date);
				System.out.println(end_date);
				
		        TblOpenCourseDTO odto = new TblOpenCourseDTO();
		        odto.setStart_date(start_date);
		        odto.setEnd_date(end_date);
				dao.avaClassRoom(odto); //현재 진행, 예정인 과정과 겹치지 않는, 사용 가능한 강의실 출력
				
				
				//강의실 번호 제대로 입력했는지 확인
				loopFirst = true;
				String cl_seq = "";
				while(loopFirst) {
					mainView.choice("강의실번호");
					cl_seq =  scan.nextLine();

					odto.setCl_seq(cl_seq);
					
					if(dao.avaClassRoomCheck(odto) == 1){
						loopFirst = false;
					}else if(dao.avaClassRoomCheck(odto) == 2){
						mainView.result("목록에 있는 번호만 입력하세요.");
					}else if(dao.avaClassRoomCheck(odto) == 0) {
						mainView.result("번호는 숫자로만 입력하세요.");
					}
				}
						
				
				BasicInfoClass basiclnfo = new BasicInfoClass();
				basiclnfo.courseList(); //전체 과정 기초정보 출력
				
				//과정 번호 제대로 입력했는지 확인
				loopFirst = true;
				String cou_seq = "";
				while(loopFirst) {
					mainView.choice("과정번호");
					cou_seq =  scan.nextLine();
					odto.setCou_seq(cou_seq);
					
					if(dao.courseChoiceCheck(odto) == 1){
						loopFirst = false;
					}else if(dao.courseChoiceCheck(odto) == 2){
						mainView.result("목록에 있는 번호만 입력하세요.");
					}else if(dao.courseChoiceCheck(odto) == 0) {
						mainView.result("번호는 숫자로만 입력하세요.");
					}
				}
						
				

				//겹치지 않는 선생님 출력 
				dao.avaTeacher(odto);
				
				
				//선생님 고르기
				loopFirst = true;
				String t_id = "";
				while(loopFirst) {
					mainView.choice("선생님 번호");
					t_id =  scan.nextLine();

					odto.setT_id(t_id);
					
					if(dao.avaTeacherCheck(odto) == 1){
						dao.openCourseAdd(odto, m_id);
						System.out.println("과정이 등록되었습니다.");
						loopFirst = false;
					}else if(dao.avaTeacherCheck(odto) == 2){
						mainView.result("목록에 있는 번호만 입력하세요.");
					}else if(dao.avaTeacherCheck(odto) == 0) {
						mainView.result("번호는 숫자로만 입력하세요.");
					}
				}
	
			}

			
			
			
			//삭제(개설과정은 삭제는 내담당만 가능)
			public void openCourseDel() throws SQLException{
				
				//삭제할 목록 보여주기
				mainView.header("개설과정 삭제하기");
				
				if(dao.openCourseListMyCheck(m_id) == 1) {
					dao.openCourseListMy(m_id);
					boolean loop = true;
					while(loop) {
						mainView.choice("개설과정 번호");
						String o_cou_seq = "";
						o_cou_seq =  scan.nextLine();
						
						TblOpenCourseDTO dto = new TblOpenCourseDTO();
						dto.setO_cou_seq(o_cou_seq);
						
						dao.checkOpenCourseChoiceMy(dto, m_id);
						
						if(dao.checkOpenCourseChoiceMy(dto, m_id) == 1) {
							
							dao.openCourseDel( dto, m_id);
							mainView.result("삭제되었습니다.");
							loop = false;
						}else{
							mainView.result("목록에 있는 번호를 입력하세요 ");
						}
					}//while
				}else{
					mainView.result("담당과정이 없습니다.");
				};	
				
			}
				
				//수정하기(개설과정 수정은 내 담당만 가능)
				//강의실 수정하기
				private void openCourseClEdit() throws SQLException {
					mainView.header("강의실 변경하기 ");
					
					if(dao.openCourseListMyCheck(m_id) == 1) {
						dao.openCourseListMy(m_id);
						boolean loop = true;
						while(loop) {
							mainView.choice("개설과정 번호");
							String o_cou_seq = "";
							o_cou_seq =  scan.nextLine();
	
							TblOpenCourseDTO dto =new TblOpenCourseDTO();
					
						    dto.setO_cou_seq(o_cou_seq);
			
							dao.checkOpenCourseChoiceMy(dto, m_id);
							if(dao.checkOpenCourseChoiceMy(dto, m_id) == 1) {
								
								dao.avaClassRoom(dto);
								System.out.println();
								
								boolean loopFirst = true;
								String cl_seq = "";
									while(loopFirst) {
										mainView.choice("강의실번호");
										cl_seq =  scan.nextLine();
	
										dto.setCl_seq(cl_seq);//강의실 목록
										
										if(dao.avaClassRoomCheck(dto) == 1){
											
											//비즈니스 코드
											dao.openCourseClEdit(dto);
											loop = false;
											loopFirst = false;
											
										}else if(dao.avaClassRoomCheck(dto) == 2){
											mainView.result("목록에 있는 번호만 입력하세요.");
										}else if(dao.avaClassRoomCheck(dto) == 0) {
											mainView.result("번호는 숫자로만 입력하세요.");
										}
									}
								
							}else{
								mainView.result("목록에 있는 번호를 입력하세요 ");
							}
							
							
						}//while
					}else{
						mainView.result("담당과정이 없습니다.");
					};	
					
					
					
				}
				
				
				
				
				
	
			

}


