package com.project2.mvc.manager;

import java.sql.SQLException;
import java.util.Calendar;
import java.util.Scanner;

import com.project2.mvc.manager.model.BasicInfoDAO;
import com.project2.mvc.manager.model.TeacherManagerDAO;
import com.project2.mvc.manager.view.BasicInfoView;
import com.project2.mvc.manager.view.TeacherInfoView;
import com.project2.mvc.manager.view.TeacherManageView;
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
	private BasicInfoView bView;
	private String m_id = "A2";
	private String t_id;
    private TeacherManageView view;
	
	public TeacherInfoClass() {
		view = new TeacherManageView();
		bView = new BasicInfoView();
		mainView = new MainView();
		dao = new TeacherManagerDAO();
		bdao = new BasicInfoDAO();
		scan = new Scanner(System.in);
		loop = true;
	}
	
	
   public void start() throws SQLException {
	      
	      boolean loop = true;
	      while (loop) {
	         view.menu(); 
	         int input = scan.nextInt();
	         scan.skip("\r\n");
	         switch (input) {
	            case 1: teacherListMy(); break; //1. 담당개설과정 관리
	            case 2: myCourseMenu(); break; //2. 전체개설과정 조회
	            case 0: loop = false; break;
	            default: System.out.println("다시입력"); break;
	         }
	      }
   }
	
   public void teacherInfoMy() throws SQLException {
	      
	      boolean loop = true;
	      while (loop) {
	         view.myCourseMenuMy(); 
	         int input = scan.nextInt();
	         scan.skip("\r\n");
	         switch (input) {
	            case 1: teacherAvaSubjectMy(); break; //1. 담당개설과정 관리
	            case 2: teacherOpenCourseMy(); break; //2. 전체개설과정 조회
	            case 3: teacherOpenSubjectMy(); break;
	            case 0: loop = false; break;
	            default: System.out.println("다시입력"); break;
	         }
	      }
}
   
   
   public void myCourseMenu() throws SQLException {
	      
	      boolean loop = true;
	      while (loop) {
	         view.myCourseMenu();
	         int input = scan.nextInt();
	         scan.skip("\r\n");
	         switch (input) {
	            case 1: myCourseMenuEdit(); break; //1. 담당개설과정 관리
	            case 2: myAvaSubMenuEdit(); break; //2. 전체개설과정 조회
	            case 3: MenuInfoMy(); break; //2. 전체개설과정 조회
	            case 0: loop = false; break;
	            default: System.out.println("다시입력"); break;
	         }
	      }
}
   
   public void myCourseMenuEdit() throws SQLException {
	      
	      boolean loop = true;
	      while (loop) {
	         view.myCourseMenu();
	         int input = scan.nextInt();
	         scan.skip("\r\n");
	         switch (input) {
	            case 1: teacherAdd(); break; //1. 담당개설과정 관리
	            case 2: teacherList(); break; //2. 전체개설과정 조회
	            case 3: teacherInfoEdit(); break; //2. 전체개설과정 조회
	            case 4: teacherDel(); break;
	            case 0: loop = false; break;
	            default: System.out.println("다시입력"); break;
	         }
	      }
}
   
   public void myAvaSubMenuEdit() throws SQLException {
	      
	      boolean loop = true;
	      while (loop) {
	         view.myCourseMenu();
	         int input = scan.nextInt();
	         scan.skip("\r\n");
	         switch (input) {
	            case 1: teacherAvaSubjectAdd(); break; //1. 담당개설과정 관리
	            case 2: teacherAvaSubject(); break; //2. 전체개설과정 조회
	            case 3: teacherAvaSubjectEdit(); break; //2. 전체개설과정 조회
	            case 4: teacherAvaSubjectDel(); break;
	            case 0: loop = false; break;
	            default: System.out.println("다시입력"); break;
	         }
	      }
}
   
   public void MenuInfoMy() throws SQLException {
	      
	      boolean loop = true;
	      while (loop) {
	         view.myCourseMenu();
	         int input = scan.nextInt();
	         scan.skip("\r\n");
	         switch (input) {
	         	case 1: teacherAvaSubjectMy(); break; //1. 담당개설과정 관리
	            case 2: teacherOpenCourseMy(); break; //2. 전체개설과정 조회
	            case 3: teacherOpenSubjectMy(); break;
	            case 0: loop = false; break;
	            default: System.out.println("다시입력"); break;
	         }
	      }
}
	
	
	public static void main(String[] args) throws SQLException {
		TeacherInfoClass a = new TeacherInfoClass();
		
		
		//a.teacherList();//전체목록
		//a.teacherListMy();//담당전체목록 -> 3가지 기능으로 나뉘고 각 기능은 각자 목록출력함
		//a.teacherOpenCourse();
		//a.teacherOpenSubject();
		//a.teacherAvaSubject();//완
		
		
		//a.teacherAdd(); 
		//a.teacherDel();
		//a.teacherInfoEdit();
		
		
		//a.teacherAvaSubjectEdit();
		a.teacherAvaSubjectDel();
		//a.teacherAvaSubjectAdd();
		
		//a.teacherOpenCourseMy();
		//a.teacherOpenSubjectMy();
		//a.teacherAvaSubjectMy();
	}
	
	
	//전체용=================================================
	//출력
	
	
	//전체)교사목록출력
	public void teacherList() throws SQLException {
		mainView.titlebar("교사목록조회");
		dao.teacherList();
		mainView.singlebar();
	}
	
	
	
	
	
	
	
	//전체)특정교사 개설과정 출력
	public void teacherOpenCourse() throws SQLException {
		mainView.titlebar("개설과정조회");

		
		TblTeacherDTO dto = new TblTeacherDTO();	
		String t_id = "";
		
		while(loop) {
			mainView.choice("교사아이디");
		
			t_id = scan.nextLine();
			dto.setT_id(t_id);
			mainView.singlebar();
			dao.teacherListOne(dto);
			mainView.onesinglebar();
			
			
			if(!t_id.equals("")) {
				
						if (dao.check(dto) == 1) {
					
								if(dao.teacherOpenCoursePrint(dto)==1) {
									dao.teacherOpenCourse(dto);
									mainView.singlebar();
									loop = false;
								}else if(dao.teacherOpenCoursePrint(dto)==0)  {
									bView.result("담당 개설과정이 없습니다.");
									mainView.singlebar();
									loop = false;
								}
								
						} else if (dao.check(dto) == 2){
							bView.result("목록에 있는 아이디만 입력해주세요");
							mainView.singlebar();
						} else if (dao.check(dto) == 0){
							bView.result("아이디를 정확히 입력해 주세요.");
							mainView.singlebar();
						}
						
			}else {
				bView.result("번호를 입력해주세요.");
				mainView.singlebar();
			}
		}//while
	}
	
	
	
	//전체)특정교사 개설과목 출력
	public void teacherOpenSubject() throws SQLException {
mainView.titlebar("개설과목조회");

		
		TblTeacherDTO dto = new TblTeacherDTO();	
		String t_id = "";
		
		while(loop) {
			mainView.choice("교사아이디");
		
			t_id = scan.nextLine();
			dto.setT_id(t_id);
			mainView.singlebar();
			dao.teacherListOne(dto);
			mainView.onesinglebar();
			
			if(!t_id.equals("")) {
				
						if (dao.check(dto) == 1) {
					
								if(dao.teacherOpenSubjectPrint(dto)==1) {
									dao.teacherOpenSubject(dto);
									mainView.singlebar();
									loop = false;
								}else if(dao.teacherOpenSubjectPrint(dto)==0)  {
									bView.result("담당 개설과목이 없습니다.");
									mainView.singlebar();
									loop = false;
								}
								
						} else if (dao.check(dto) == 2){
							bView.result("목록에 있는 아이디만 입력해주세요");
							mainView.singlebar();
						} else if (dao.check(dto) == 0){
							bView.result("아이디를 정확히 입력해 주세요.");
							mainView.singlebar();
						}
						
			}else {
				bView.result("번호를 입력해주세요.");
				mainView.singlebar();
			}
		}//while
	}
	
	
	
	//전체)특정교사 강의가능과목과목 출력
		public void teacherAvaSubject() throws SQLException {
			mainView.titlebar("강의가능과목");

			TblTeacherDTO dto = new TblTeacherDTO();	
			
			
			while(loop) {
				mainView.choice("교사아이디");
				t_id = scan.nextLine();
				dto.setT_id(t_id);
				mainView.singlebar();
				
				if(!t_id.equals("")) {
					
							if (dao.check(dto) == 1) {
						
									if(dao.teacherAvaSubjectPrint(dto)==1) {
										dao.teacherListOne(dto);// 교사 1명 정보
										
										dao.teacherAvaSubject(dto);//비즈니스코드
										mainView.singlebar();
										loop = false;
									}else if(dao.teacherAvaSubjectPrint(dto)==0)  {
										bView.result("강의가능한 과목이 없습니다.");
										mainView.singlebar();
										
									}
									
							} else if (dao.check(dto) == 2){
								bView.result("목록에 있는 아이디만 입력해주세요");
								mainView.singlebar();
							} else if (dao.check(dto) == 0){
								bView.result("아이디를 정확히 입력해 주세요.");
								mainView.singlebar();
							}
							
				}else {
					bView.result("번호를 입력해주세요.");
					mainView.singlebar();
				}
			}//while
		}
	
	
	//담당용============================================
	//출력
	public void teacherListMy() throws SQLException {
		
		teacherInfoMy();
	}
	
	
	
	//담당)특정교사 개설과정 출력
	public void teacherOpenCourseMy() throws SQLException {
		mainView.titlebar("개설과정조회");
		
		mainView.onesinglebar();
		System.out.println("                                                                                                                                 담당교사목록");
		mainView.onesinglebar();
		dao.teacherListMy(m_id);
		mainView.onesinglebar();
		
		TblTeacherDTO dto = new TblTeacherDTO();	
		String t_id = "";
		
		while(loop) {
			mainView.singlebar();
			mainView.choice("교사아이디");
			t_id = scan.nextLine();
			dto.setT_id(t_id);
			mainView.singlebar();
			
			if(!t_id.equals("")) {
				
						if (dao.checkMy(dto,m_id) == 1) {
					
								if(dao.teacherOpenCoursePrint(dto)==1) {
									dao.teacherListOne(dto);// 교사 1명 정보
									dao.teacherOpenCourse(dto);
									loop = false;
								}else if(dao.teacherOpenCoursePrint(dto)==0)  {
									bView.result("담당 개설과정이 없습니다.");
									loop = false;
								}
								
						} else if (dao.checkMy(dto,m_id)  == 2){
							bView.result("목록에 있는 아이디만 입력해주세요");
						} else if (dao.checkMy(dto,m_id) == 0){
							bView.result("아이디를 정확히 입력해 주세요.");
						}
						
			}else {
				bView.result("번호를 입력해주세요.");
			}
		}//while
	}
	
	//담당)특정교사 개설과목 출력
		public void teacherOpenSubjectMy() throws SQLException {
			mainView.titlebar("개설과목조회");
			
			mainView.onesinglebar();
			System.out.println("                                                                                                                                 담당교사목록");
			mainView.onesinglebar();
			dao.teacherListMy(m_id);
			mainView.onesinglebar();
			
			TblTeacherDTO dto = new TblTeacherDTO();	
			String t_id = "";
			
			while(loop) {
				mainView.singlebar();
				mainView.choice("교사아이디");
				t_id = scan.nextLine();
				dto.setT_id(t_id);
				mainView.singlebar();
				if(!t_id.equals("")) {
					
							if (dao.checkMy(dto, m_id) == 1) {
						
									if(dao.teacherOpenSubjectPrint(dto)==1) {
										dao.teacherListOne(dto);// 교사 1명 정보
										dao.teacherOpenSubject(dto);
										mainView.singlebar();
										loop = false;
									}else if(dao.teacherOpenSubjectPrint(dto)==0)  {
										bView.result("담당 개설과목이 없습니다.");
										loop = false;
									}
									
							} else if (dao.checkMy(dto, m_id) == 2){
								bView.result("목록에 있는 아이디만 입력해주세요");
							} else if (dao.checkMy(dto, m_id) == 0){
								bView.result("아이디를 정확히 입력해 주세요.");
							}
							
				}else {
					bView.result("번호를 입력해주세요.");
				}
			}//while
		}
		
		
		
		//담당)특정교사 강의가능과목과목 출력
			public void teacherAvaSubjectMy() throws SQLException {
				
				
				
				mainView.titlebar("강의가능과목조회");
				
				mainView.onesinglebar();
				System.out.println("                                                                                                                                 담당교사목록");
				mainView.onesinglebar();
				dao.teacherListMy(m_id);
				mainView.onesinglebar();
				
				TblTeacherDTO dto = new TblTeacherDTO();	
				String t_id = "";
				
				while(loop) {
					mainView.singlebar();
					mainView.choice("교사아이디");
					t_id = scan.nextLine();
					dto.setT_id(t_id);
					mainView.singlebar();
					
					
					
					
					if(!t_id.equals("")) {
						
								if (dao.checkMy(dto, m_id) == 1) {
							
										if(dao.teacherAvaSubjectPrint(dto)==1) {
											dao.teacherListOne(dto);// 교사 1명 정보
											dao.teacherAvaSubject(dto);
											loop = false;
										}else if(dao.teacherAvaSubjectPrint(dto)==0)  {
											bView.result("강의가능한 과목이 없습니다.");
											loop = false;
										}
										
								} else if (dao.checkMy(dto, m_id) == 2){
									bView.result("목록에 있는 아이디만 입력해주세요");
								} else if (dao.checkMy(dto, m_id) == 0){
									bView.result("아이디를 정확히 입력해 주세요.");
								}
								
					}else {
						bView.result("번호를 입력해주세요.");
					}
				}//while
			}
		
	
	//===============================================등록====================================
			
			
			//신규교사등록
			public void teacherAdd() throws SQLException {
				mainView.titlebar("신규교사 등록하기");
				
				

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
									mainView.singlebar();
									bView.result("이미 존재하는 교사입니다. 다시입력하세요");
									mainView.singlebar();
								}else {
									mainView.singlebar();
									bView.result("숫자로만 바르게 입력하세요.");
									mainView.singlebar();
								}
								
							}else if(  !(ssn.length() == 7) || !((ssn.startsWith( "1" )) || (ssn.startsWith( "2" )) || (ssn.startsWith( "3" )) || (ssn.startsWith( "4" )))){
								mainView.singlebar();
								bView.result("7자리 주민등록번호로 바르게 입력하세요.");
								mainView.singlebar();
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
						mainView.singlebar();
				
						if(!name.equals("")&& ! phone_number.equals("")) {
					dao.teacherAdd(dto);
					bView.result("등록되었습니다.");
					mainView.singlebar();
					loop = false;
						}else {
							bView.result("모든 항목을 입력하세요.");
							mainView.singlebar();
						}
						
				}
			
			}//teacherAdd()
	
			
			
			
			//강의가능과목 등록
			public void teacherAvaSubjectAdd() throws SQLException {
				teacherList();

				teacherAvaSubject();
				
				bdao.subjectList();
				
				mainView.titlebar("강의가능과목등록");
						
						
							TblTeacherDTO dto = new TblTeacherDTO();
							dto.setT_id(t_id);
						
							
	
								
								boolean loop = true;
								while(loop) {
									
	
									String sub_seq = "";
									TblAvaSubjectDTO adto = new TblAvaSubjectDTO();
				
										mainView.choice("추가할 과목번호");
										sub_seq = scan.nextLine();
										adto.setSub_seq(sub_seq);
										mainView.singlebar();
								
									if(dao.teacherAvaSubjectAdd(dto, adto) ==1) {
										bView.result("등록되었습니다.");
										mainView.singlebar();
										loop = false;
									
									}else if(dao.teacherAvaSubjectAdd(dto, adto) ==2){
										bView.result("이미 강의가능한 과목입니다.");
										mainView.singlebar();
									}else if(dao.teacherAvaSubjectAdd(dto, adto) ==3) {
										bView.result("과목번호를 똑바로 다시입력하세요");
										mainView.singlebar();
									}else {
										System.out.println("문제가뭐냐고");
									}
									
								}		
			}
			
	
//======================================교사삭제=================================================
	public void teacherDel() throws SQLException {
		
		
		mainView.titlebar("교사계정 삭제하기");
		dao.teacherList();
		mainView.singlebar();
		
			boolean loop = true;
			while(loop) {
				mainView.choice("교사아이디");
				String t_id = "";
				t_id =  scan.nextLine();
				mainView.singlebar();
				TblTeacherDTO dto = new TblTeacherDTO();
				
				if(!t_id.equals("")) {
					dto.setT_id(t_id);
						int checkMy = dao.check(dto);
						if (checkMy == 1) {
								int delAva = dao.teacherDelAva(dto);
								if(delAva ==1) {
									dao.teacherDel(dto);
									bView.result("삭제되었습니다.");
									mainView.singlebar();
									loop = false;
								}else if(delAva ==2) {
									bView.result("강의 중/강의예정인 교사입니다. 삭제를 원하시면 개설과정에서 교사를 변경해주세요");
									mainView.singlebar();
								}else {
									bView.result("아이디를 바르게 입력하세요");
									mainView.singlebar();
								}
	
					} else if (checkMy == 2){
						bView.result("목록에 있는 아이디만 입력해주세요");
						mainView.singlebar();
					} else if (checkMy == 0){
						bView.result("아이디를 정확히 입력해 주세요.");
						mainView.singlebar();
					}
				
				}else {
					bView.result("번호를 입력해주세요.");
					mainView.singlebar();
				}

				

			}
	}//teacherDel()


	
	
	
	//교사 강의가능과목 삭제하기 
	public void teacherAvaSubjectDel() throws SQLException {
		
		teacherList();

		teacherAvaSubject();
		
		mainView.titlebar("강의가능과목삭제");
	
	
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
					mainView.singlebar();
					adto.setAva_sub_seq(ava_sub_seq);
					
					//과목리스트 출력

				if(dao.teacherAvaSubjectDel(dto, adto) ==1) {
					bView.result("삭제되었습니다.");
					mainView.singlebar();
					loop = false;
				
				}else if(dao.teacherAvaSubjectDel(dto, adto) ==2){
					bView.result("이미 강의가능한 과목입니다.");
					mainView.singlebar();
				}else if(dao.teacherAvaSubjectDel(dto, adto) ==3) {
					bView.result("강의가능번호를 똑바로 다시입력하세요");
					mainView.singlebar();
				}else {
					System.out.println("문제가뭐냐고");
				}
				
			}
			

		}else if(delAva ==2) {
			bView.result("강의 중/강의예정인 교사입니다. 수정 불가합니다.");
			mainView.singlebar();
		}else {
			bView.result("다시입력하세요.");
			mainView.singlebar();
		}	
		
	}
	


	
	
//==============================교사정보 수정==================================	
//교사 개인정보 수정 
public void teacherInfoEdit() throws SQLException {

	mainView.titlebar("교사계정 삭제하기");
	dao.teacherList();
	mainView.singlebar();
	
	TblTeacherDTO dto = new TblTeacherDTO();	
	String t_id = "";
	
	while(loop) {
		mainView.choice("교사아이디");
		t_id = scan.nextLine();
		dto.setT_id(t_id);
		mainView.singlebar();
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
												mainView.singlebar();
												
												dao.teacherEdit(dto);//수정 비즈니스 코드
												bView.result("수정되었습니다.");
												mainView.singlebar();
												
												loop = false;
												
									} else if (dao.check(dto) == 2){
										bView.result("목록에 있는 아이디만 입력해주세요");
										mainView.singlebar();
									} else if (dao.check(dto) == 0){
										bView.result("아이디를 정확히 입력해 주세요.");
										mainView.singlebar();
									}
									
						}else {
							bView.result("번호를 입력해주세요.");
							mainView.singlebar();
						}
			}//while
		
}


//교사 강의가능과목 수정하기
public void teacherAvaSubjectEdit() throws SQLException {
			teacherList();

			teacherAvaSubject();
			
			bdao.subjectList();
			
			mainView.titlebar("강의가능과목수정");
		
		
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
						mainView.singlebar();
					if(dao.teacherAvaSubjectEdit(dto, adto) ==1) {
						bView.result("수정되었습니다.");
						mainView.singlebar();
						loop = false;
					
					}else if(dao.teacherAvaSubjectEdit(dto, adto) ==2){
						bView.result("이미 강의가능한 과목입니다.");
						mainView.singlebar();
					}else if(dao.teacherAvaSubjectEdit(dto, adto) ==3) {
						bView.result("강의가능번호를 똑바로 다시입력하세요");
						mainView.singlebar();
					}else {
						System.out.println("");
					}
					
				}
				

			}else if(delAva ==2) {
				bView.result("강의 중/강의예정인 교사입니다. 수정 불가합니다.");
				mainView.singlebar();
			}else {
				bView.result("다시입력하세요.");
				mainView.singlebar();
			}
	
	}
	
}//class












