package com.project2.mvc.manager;

import java.sql.SQLException;
import java.util.Calendar;
import java.util.Scanner;

import com.project2.mvc.manager.model.BasicInfoDAO;
import com.project2.mvc.manager.model.TeacherManagerDAO;
import com.project2.mvc.model.TblAvaSubjectDTO;
import com.project2.mvc.model.TblClassRoomDTO;
import com.project2.mvc.model.TblOpenCourseDTO;
import com.project2.mvc.model.TblTeacherDTO;
import com.project2.mvc.view.MainView;

public class TeacherInfoClass {
	
	private TeacherManagerDAO dao;
	private BasicInfoDAO bdao;
	private Scanner scan;
	private boolean loop;
	private MainView mainView;
	private String m_id = "A2";
	private String t_id;
	
	public TeacherInfoClass() {
		mainView = new MainView();
		dao = new TeacherManagerDAO();
		bdao = new BasicInfoDAO();
		scan = new Scanner(System.in);
		loop = true;
	}
	
//	public static void main(String[] args) throws SQLException {
//		TeacherInfoClass a = new TeacherInfoClass();
//		
//		
//		//a.teacherList();//전체목록
//		//a.teacherListMy();//담당전체목록
//		//a.teacherListMy();
//		//a.teacherOpenCourse();
//		//a.teacherOpenSubject();
//		//a.teacherAvaSubject();
//		//a.teacherAdd(); 
//		//a.teacherDel();
//		//a.teacherInfoEdit();
//		//a.teacherAvaSubjectEdit();
//		//a.teacherAvaSubjectDel();
//		a.teacherAvaSubjectAdd();
//		
//		//a.teacherOpenCourseMy();
//		
//	}
	
	
	//전체용=================================================
	//출력
	
	
	//전체)교사목록출력
	public void teacherList() throws SQLException {
		dao.teacherList();
	}
	
	
	
	
	
	
	
	//전체)특정교사 개설과정 출력
	public void teacherOpenCourse() throws SQLException {
		mainView.header("개설과정조회");

		
		TblTeacherDTO dto = new TblTeacherDTO();	
		String t_id = "";
		
		while(loop) {
			mainView.choice("교사아이디");
			t_id = scan.nextLine();
			dto.setT_id(t_id);
			
			if(!t_id.equals("")) {
				
						if (dao.check(dto) == 1) {
					
								if(dao.teacherOpenCoursePrint(dto)==1) {
									dao.teacherOpenCourse(dto);
									loop = false;
								}else if(dao.teacherOpenCoursePrint(dto)==0)  {
									mainView.result("담당 개설과정이 없습니다.");
									loop = false;
								}
								
						} else if (dao.check(dto) == 2){
							mainView.result("목록에 있는 아이디만 입력해주세요");
						} else if (dao.check(dto) == 0){
							mainView.result("아이디를 정확히 입력해 주세요.");
						}
						
			}else {
				mainView.result("번호를 입력해주세요.");
			}
		}//while
	}
	
	
	
	//전체)특정교사 개설과목 출력
	public void teacherOpenSubject() throws SQLException {
		mainView.header("개설과목조회");

		TblTeacherDTO dto = new TblTeacherDTO();	
		String t_id = "";
		
		while(loop) {
			mainView.choice("교사아이디");
			t_id = scan.nextLine();
			dto.setT_id(t_id);
			
			if(!t_id.equals("")) {
				
						if (dao.check(dto) == 1) {
					
								if(dao.teacherOpenSubjectPrint(dto)==1) {
									dao.teacherOpenSubject(dto);
									loop = false;
								}else if(dao.teacherOpenSubjectPrint(dto)==0)  {
									mainView.result("담당 개설과목이 없습니다.");
									loop = false;
								}
								
						} else if (dao.check(dto) == 2){
							mainView.result("목록에 있는 아이디만 입력해주세요");
						} else if (dao.check(dto) == 0){
							mainView.result("아이디를 정확히 입력해 주세요.");
						}
						
			}else {
				mainView.result("번호를 입력해주세요.");
			}
		}//while
	}
	
	
	
	//전체)특정교사 강의가능과목과목 출력
		public void teacherAvaSubject() throws SQLException {
			mainView.header("강의가능과목");

			TblTeacherDTO dto = new TblTeacherDTO();	
			
			
			while(loop) {
				mainView.choice("교사아이디");
				t_id = scan.nextLine();
				dto.setT_id(t_id);
				
				if(!t_id.equals("")) {
					
							if (dao.check(dto) == 1) {
						
									if(dao.teacherAvaSubjectPrint(dto)==1) {
										dao.teacherAvaSubject(dto);//비즈니스코드
										loop = false;
									}else if(dao.teacherAvaSubjectPrint(dto)==0)  {
										mainView.result("강의가능한 과목이 없습니다.");
										
									}
									
							} else if (dao.check(dto) == 2){
								mainView.result("목록에 있는 아이디만 입력해주세요");
							} else if (dao.check(dto) == 0){
								mainView.result("아이디를 정확히 입력해 주세요.");
							}
							
				}else {
					mainView.result("번호를 입력해주세요.");
				}
			}//while
		}
	
	
	//담당용============================================
	//출력
	public void teacherListMy() {
		dao.teacherListMy(m_id);
	}
	
	
	
	//담당)특정교사 개설과정 출력
	public void teacherOpenCourseMy() throws SQLException {
		mainView.header("개설과정조회");
		TblTeacherDTO dto = new TblTeacherDTO();	
		String t_id = "";
		
		boolean loop = true;
		while(loop) {
			mainView.choice("교사아이디");
			t_id = scan.nextLine();
			dto.setT_id(t_id);
			
			if(!t_id.equals("")) {
				
						if (dao.checkMy(dto,m_id) == 1) {
					
								if(dao.teacherOpenCoursePrint(dto)==1) {
									dao.teacherOpenCourse(dto);
									loop = false;
								}else if(dao.teacherOpenCoursePrint(dto)==0)  {
									mainView.result("담당 개설과정이 없습니다.");
									loop = false;
								}
								
						} else if (dao.checkMy(dto,m_id)  == 2){
							mainView.result("목록에 있는 아이디만 입력해주세요");
						} else if (dao.checkMy(dto,m_id) == 0){
							mainView.result("아이디를 정확히 입력해 주세요.");
						}
						
			}else {
				mainView.result("번호를 입력해주세요.");
			}
		}//while
	}
	
	//담당)특정교사 개설과목 출력
		public void teacherOpenSubjectMy() throws SQLException {
			mainView.header("개설과목조회");		
			TblTeacherDTO dto = new TblTeacherDTO();	
			String t_id = "";
			
			while(loop) {
				mainView.choice("교사아이디");
				t_id = scan.nextLine();
				dto.setT_id(t_id);
				
				if(!t_id.equals("")) {
					
							if (dao.checkMy(dto, m_id) == 1) {
						
									if(dao.teacherOpenSubjectPrint(dto)==1) {
										dao.teacherOpenSubject(dto);
										loop = false;
									}else if(dao.teacherOpenSubjectPrint(dto)==0)  {
										mainView.result("담당 개설과목이 없습니다.");
										loop = false;
									}
									
							} else if (dao.checkMy(dto, m_id) == 2){
								mainView.result("목록에 있는 아이디만 입력해주세요");
							} else if (dao.checkMy(dto, m_id) == 0){
								mainView.result("아이디를 정확히 입력해 주세요.");
							}
							
				}else {
					mainView.result("번호를 입력해주세요.");
				}
			}//while
		}
		
		
		
		//담당)특정교사 강의가능과목과목 출력
			public void teacherAvaSubjectMy() throws SQLException {
				mainView.header("강의가능과목조회");
				TblTeacherDTO dto = new TblTeacherDTO();	
				String t_id = "";
				
				while(loop) {
					mainView.choice("교사아이디");
					t_id = scan.nextLine();
					dto.setT_id(t_id);
					
					if(!t_id.equals("")) {
						
								if (dao.checkMy(dto, m_id) == 1) {
							
										if(dao.teacherAvaSubjectPrint(dto)==1) {
											dao.teacherAvaSubject(dto);
											loop = false;
										}else if(dao.teacherAvaSubjectPrint(dto)==0)  {
											mainView.result("강의가능한 과목이 없습니다.");
											loop = false;
										}
										
								} else if (dao.checkMy(dto, m_id) == 2){
									mainView.result("목록에 있는 아이디만 입력해주세요");
								} else if (dao.checkMy(dto, m_id) == 0){
									mainView.result("아이디를 정확히 입력해 주세요.");
								}
								
					}else {
						mainView.result("번호를 입력해주세요.");
					}
				}//while
			}
		
	
	//===============================================등록====================================
			
			
			//신규교사등록
			public void teacherAdd() throws SQLException {
				mainView.header("신규교사 등록하기");
				
				

				//주민번호
				boolean loopFirst = true;
				TblTeacherDTO dto = new TblTeacherDTO();	
				String ssn = "";
				
				while(loopFirst) {
					
						mainView.choice("주민등록번호(뒷자리)");
						ssn =  scan.nextLine();
						dto.setSsn(ssn);
						
							if(     (ssn.length() == 7) &&((ssn.startsWith( "1" )) || (ssn.startsWith( "2" )) || (ssn.startsWith( "3" )) || (ssn.startsWith( "4" )))     ) {
								
								int result = dao.teacherAddCheck(dto);
								
								if(result == 1) {
									loopFirst = false;
								}else if(result == 2) {
									mainView.result("이미 존재하는 교사입니다. 다시입력하세요");
								}else {
									mainView.result("숫자로만 바르게 입력하세요.");
								}
								
							}else if(  !(ssn.length() == 7) || !((ssn.startsWith( "1" )) || (ssn.startsWith( "2" )) || (ssn.startsWith( "3" )) || (ssn.startsWith( "4" )))){
								mainView.result("7자리 주민등록번호로 바르게 입력하세요.");
							}						
						
							
					}//while
				
				boolean loop = true;
				while(loop) {
					String name = "";
						mainView.choice("이름");
						name =  scan.nextLine();
						dto.setName(name);
						
				
					String phone_number = "";
						mainView.choice("전화번호");
						phone_number =  scan.nextLine();
						dto.setPhone_number(phone_number);	
				
						if(!name.equals("")&& ! phone_number.equals("")) {
					dao.teacherAdd(dto);
					mainView.result("등록되었습니다.");
					loop = false;
						}else {
							mainView.result("모든 항목을 입력하세요.");
						}
						
				}
			
			}//teacherAdd()
	
			
			
			
			//강의가능과목 등록
			public void teacherAvaSubjectAdd() throws SQLException {
					teacherList();

							teacherAvaSubject();
							System.out.println("=============================");
							bdao.subjectList();
							
							mainView.header("강의가능과목등록");
						
						
							TblTeacherDTO dto = new TblTeacherDTO();
							dto.setT_id(t_id);
						
							
	
								
								boolean loop = true;
								while(loop) {
									
	
									String sub_seq = "";
									TblAvaSubjectDTO adto = new TblAvaSubjectDTO();
				
										mainView.choice("추가할 과목번호");
										sub_seq = scan.nextLine();
										adto.setSub_seq(sub_seq);
								
									if(dao.teacherAvaSubjectAdd(dto, adto) ==1) {
										mainView.result("등록되었습니다.");
										loop = false;
									
									}else if(dao.teacherAvaSubjectAdd(dto, adto) ==2){
										mainView.result("이미 강의가능한 과목입니다.");
									}else if(dao.teacherAvaSubjectAdd(dto, adto) ==3) {
										mainView.result("과목번호를 똑바로 다시입력하세요");
									}else {
										System.out.println("문제가뭐냐고");
									}
									
								}		
			}
			
	
//======================================교사삭제=================================================
	public void teacherDel() throws SQLException {
		
		
		mainView.header("교사계정 삭제하기");
		
		
			boolean loop = true;
			while(loop) {
				mainView.choice("교사아이디");
				String t_id = "";
				t_id =  scan.nextLine();
				TblTeacherDTO dto = new TblTeacherDTO();
				
				if(!t_id.equals("")) {
					dto.setT_id(t_id);
						int checkMy = dao.check(dto);
						if (checkMy == 1) {
								int delAva = dao.teacherDelAva(dto);
								if(delAva ==1) {
									dao.teacherDel(dto);
									mainView.result("삭제되었습니다.");
									loop = false;
								}else if(delAva ==2) {
									mainView.result("강의 중/강의예정인 교사입니다. 삭제를 원하시면 개설과정에서 교사를 변경해주세요");
								}else {
									mainView.result("아이디를 바르게 입력하세요");
								}
	
					} else if (checkMy == 2){
						mainView.result("목록에 있는 아이디만 입력해주세요");
					} else if (checkMy == 0){
						mainView.result("아이디를 정확히 입력해 주세요.");
					}
				
				}else {
					mainView.result("번호를 입력해주세요.");
				}

				

			}
	}//teacherDel()


	
	
	
	//교사 강의가능과목 삭제하기 
	public void teacherAvaSubjectDel() throws SQLException {
		
		teacherList();

		teacherAvaSubject();
		System.out.println("=============================");
		mainView.header("강의가능과목삭제");
	
	
		TblTeacherDTO dto = new TblTeacherDTO();
		dto.setT_id(t_id);
	
		
		int delAva = dao.teacherDelAva(dto);
	
		if(delAva ==1) {
			
			boolean loop = true;
			while(loop) {
				
				String ava_sub_seq = "";
				
				TblAvaSubjectDTO adto = new TblAvaSubjectDTO();
					mainView.choice("강의가능번호");
					ava_sub_seq = scan.nextLine();
					
					adto.setAva_sub_seq(ava_sub_seq);
					
					//과목리스트 출력

				if(dao.teacherAvaSubjectDel(dto, adto) ==1) {
					mainView.result("삭제되었습니다.");
					loop = false;
				
				}else if(dao.teacherAvaSubjectDel(dto, adto) ==2){
					mainView.result("이미 강의가능한 과목입니다.");
				}else if(dao.teacherAvaSubjectDel(dto, adto) ==3) {
					mainView.result("강의가능번호를 똑바로 다시입력하세요");
				}else {
					System.out.println("문제가뭐냐고");
				}
				
			}
			

		}else if(delAva ==2) {
			mainView.result("강의 중/강의예정인 교사입니다. 수정 불가합니다.");
		}else {
			mainView.result("다시입력하세요.");
		}	
		
	}
	


	
	
//==============================교사정보 수정==================================	
//교사 개인정보 수정 
public void teacherInfoEdit() throws SQLException {

	dao.teacherList();
	
	TblTeacherDTO dto = new TblTeacherDTO();	
	String t_id = "";
	
	while(loop) {
		mainView.choice("교사아이디");
		t_id = scan.nextLine();
		dto.setT_id(t_id);
		
						if(!t_id.equals("")) {
							
									if (dao.check(dto) == 1) {
					
												
												
												String name = "";
												mainView.choice("이름");
												name = scan.nextLine();
												dto.setName(name);
											
												String phone_number = "";
												mainView.choice("전화번호");
												phone_number = scan.nextLine();
												dto.setPhone_number(phone_number);
												
												String password = "";
												mainView.choice("비밀번호");
												password = scan.nextLine();
												dto.setPassword(password);
												
												dao.teacherEdit(dto);//수정 비즈니스 코드
												mainView.result("수정되었습니다.");
												
												loop = false;
												
									} else if (dao.check(dto) == 2){
										mainView.result("목록에 있는 아이디만 입력해주세요");
									} else if (dao.check(dto) == 0){
										mainView.result("아이디를 정확히 입력해 주세요.");
									}
									
						}else {
							mainView.result("번호를 입력해주세요.");
						}
			}//while
		
}


//교사 강의가능과목 수정하기
public void teacherAvaSubjectEdit() throws SQLException {
	teacherList();

			teacherAvaSubject();
			System.out.println("=============================");
			bdao.subjectList();
			
			mainView.header("강의가능과목수정");
		
		
			TblTeacherDTO dto = new TblTeacherDTO();
			dto.setT_id(t_id);
		
			
			int delAva = dao.teacherDelAva(dto);
		
			if(delAva ==1) {
				
				boolean loop = true;
				while(loop) {
					
					String ava_sub_seq = "";
					String sub_seq = "";
					TblAvaSubjectDTO adto = new TblAvaSubjectDTO();
						mainView.choice("강의가능번호");
						ava_sub_seq = scan.nextLine();
						adto.setAva_sub_seq(ava_sub_seq);
						
						//과목리스트 출력

		
						mainView.choice("과목번호");
						sub_seq = scan.nextLine();
						adto.setSub_seq(sub_seq);
				
					if(dao.teacherAvaSubjectEdit(dto, adto) ==1) {
						mainView.result("수정되었습니다.");
						loop = false;
					
					}else if(dao.teacherAvaSubjectEdit(dto, adto) ==2){
						mainView.result("이미 강의가능한 과목입니다.");
					}else if(dao.teacherAvaSubjectEdit(dto, adto) ==3) {
						mainView.result("강의가능번호를 똑바로 다시입력하세요");
					}else {
						System.out.println("문제가뭐냐고");
					}
					
				}
				

			}else if(delAva ==2) {
				mainView.result("강의 중/강의예정인 교사입니다. 수정 불가합니다.");
			}else {
				mainView.result("다시입력하세요.");
			}
	
	}
	
}//class












