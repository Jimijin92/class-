package com.project2.mvc.manager;

import java.sql.SQLException;
import java.util.Scanner;

import com.project2.mvc.manager.model.BasicInfoDAO;
import com.project2.mvc.manager.view.BasicInfoView;
import com.project2.mvc.model.TblBookDTO;
import com.project2.mvc.model.TblClassRoomDTO;
import com.project2.mvc.model.TblCourseDTO;
import com.project2.mvc.model.TblPublisherDTO;
import com.project2.mvc.model.TblSubjectDTO;
import com.project2.mvc.view.MainView;



public class BasicInfoClass {

	private BasicInfoDAO dao;
	private Scanner scan;
	private boolean loop;
	private MainView mainView;
	private BasicInfoView bView;
	
	
	public BasicInfoClass() {
		mainView = new MainView();
		bView = new BasicInfoView();
		dao = new BasicInfoDAO();		
		scan = new Scanner(System.in);
		loop = true;
	}
	
	public void start() throws SQLException {
	      
	      boolean loop = true;
	      while (loop) {
	         bView.menu(); 
	         int input = scan.nextInt();
	         scan.skip("\r\n");
	         switch (input) {
	            case 1: courseList(); break; //1. 과정관리
	            case 2: subjectList(); break; //2. 과목관리
	            case 3: classRoomList(); break;//3.강의실관리
	            case 4: bookList(); break;//4.교재관리
	            case 5: publisherList(); break;//5.출판사관리
	            case 0: loop = false; break;//0.뒤로가기
	            default: System.out.println("다시입력"); break;
	         }
	      }
     }
	
	
	
	public void course() throws SQLException {
	      
	      boolean loop = true;
	      while (loop) {
	         bView.middle_menu(); 
	         int input = scan.nextInt();
	         scan.skip("\r\n");
	         switch (input) {
	            case 1: courseAdd(); break; //1. 담당개설과정 관리
	            case 2: courseEdit(); break; //2. 전체개설과정 조회
	            case 3:  courseDel(); break;
	            case 0: loop = false; break;
	            default: System.out.println("다시입력"); break;
	         }
	      }
	}
	      
  public void subject() throws SQLException {
      
      boolean loop = true;
      while (loop) {
         bView.middle_menu();
         int input = scan.nextInt();
         scan.skip("\r\n");
         switch (input) {
            case 1: subjectAdd(); break; //1. 담당개설과정 관리
            case 2: subjectEdit(); break; //2. 전체개설과정 조회
            case 3: subjectDel(); break;
            case 0: loop = false; break;
            default: System.out.println("다시입력"); break;
         }
      }
  }
		      
  public void classroom() throws SQLException {
      
      boolean loop = true;
      while (loop) {
    	  bView.middle_menu();
         int input = scan.nextInt();
         scan.skip("\r\n");
         switch (input) {
            case 1: classRoomAdd(); break; //1. 담당개설과정 관리
            case 2: classRoomEdit(); break; //2. 전체개설과정 조회
            case 3: classRoomDel(); break;
            case 0: loop = false; break;
            default: System.out.println("다시입력"); break;
         }
      }
  }
			      
      public void book() throws SQLException {
	      
	      boolean loop = true;
	      while (loop) {
	    	  bView.middle_menu();
	         int input = scan.nextInt();
	         scan.skip("\r\n");
	         switch (input) {
	            case 1: bookAdd(); break; //1. 담당개설과정 관리
	            case 2: bookEdit(); break; //2. 전체개설과정 조회
	            case 3: bookDel(); break;
	            case 0: loop = false; break;
	            default: System.out.println("다시입력"); break;
	         }
	      }
      }
				      
	      public void publisher() throws SQLException {
		      
		      boolean loop = true;
		      while (loop) {
		    	  bView.middle_menu();
		         int input = scan.nextInt();
		         scan.skip("\r\n");
		         switch (input) {
		            case 1: publisherAdd(); break; //1. 담당개설과정 관리
		            case 2: publisherEdit(); break; //2. 전체개설과정 조회
		            case 3: publisherDel(); break;
		            case 0: loop = false; break;
		            default: System.out.println("다시입력"); break;
		         }
		      }
	      }   

	
	

	public static void main(String[] args) throws SQLException {
	BasicInfoClass a = new BasicInfoClass();
		
		//출력하기
//		a.courseList();
//		a.subjectList();
//		a.classRoomList();
//		a.bookList();
//		a.publisherList();
		
	
		//등록하기
		//a.courseAdd();//
		//a.subjectAdd();//
		//a.classRoomAdd();//
		//a.publisherAdd();
		//a.bookAdd();
		
		//삭제하기
		//a.courseDel();		
		//a.subjectDel();	
		//a.classRoomDel();
		//a.bookDel();
		//a.publisherDel();
		
		//수정하기
		//a.courseEdit();//완
		//a.subjectEdit();
		//a.classRoomEdit(); //
		//a.bookEdit(); //
		//a.publisherEdit(); 
		
		
	}
	
//1. 출력하기
public void courseList() throws SQLException { //과정리스트 출력
	mainView.titlebar("기초과정");
	dao.courseList();
	mainView.singlebar();
	course();
}

public void subjectList() throws SQLException {//과목리스트 출력
	mainView.titlebar("기초과목");
	dao.subjectList();
	mainView.singlebar();
	subject();
}

public void classRoomList() throws SQLException {//강의실 출력
	mainView.titlebar("  강의실");
	dao.classRoomList();
	mainView.singlebar();
	classroom();
}

public void bookList() throws SQLException {//교재리스트 출력
	mainView.titlebar("  교재  ");
	dao.bookList();
	mainView.singlebar();
	book();
}

public void publisherList() throws SQLException {//출판사리스트 출력
	mainView.titlebar("  출판사");
	dao.publisherList();
	mainView.singlebar();
	publisher();
}





	
//========================================2. 등록하기=======================================	
//과정 등록하기
public void courseAdd() throws SQLException {
	mainView.titlebar("기초과정등록");
	
	TblCourseDTO dto = new TblCourseDTO();
	String name = "";
	while(loop) {
		mainView.choice("과정명");
		name = scan.nextLine();
		dto.setName(name);
		mainView.singlebar();
		
		if(!name.equals("")) {
			if (dao.courseAdd(dto) == 1) {
				bView.result("과정이 등록되었습니다.");
				mainView.singlebar();
				loop = false;
			} else {
				bView.result("이미 존재하는 과정명입니다.");
				mainView.singlebar();
			}
		}else {
			bView.result("모든 항목을 입력해주세요.");
			mainView.singlebar();
		}
	}//while
}


public void subjectAdd() throws SQLException {//과목 등록하기
	mainView.titlebar("기초과목등록");
	
	TblSubjectDTO dto = new TblSubjectDTO();
	String name = "";
	while(loop) {
		mainView.choice("과목명");
		name = scan.nextLine();	
		dto.setName(name);
		mainView.singlebar();
		
		if(!name.equals("")) {
				if (dao.subjectAdd(dto) == 1) {
					bView.result("과목이 등록되었습니다.");
					mainView.singlebar();
					loop = false;
				} else {
					bView.result("이미 존재하는 과목명입니다.");
					mainView.singlebar();
				}
		}else {
			bView.result("모든 항목을 입력해주세요.");
			mainView.singlebar();
		}			
	}
}


public void classRoomAdd() throws SQLException {//강의실 등록하기
	mainView.titlebar("강의실등록");
	
	TblClassRoomDTO dto = new TblClassRoomDTO();	
	String name = "";
	String capacity = "";
	
	while(loop) {
		mainView.choice("강의실명");
		name = scan.nextLine();
		mainView.choice("정원");
		capacity = scan.nextLine();
		mainView.singlebar();
		
		dto.setName(name);
		dto.setCapacity(capacity);
			
		if(!name.equals("")&&!capacity.equals("")) {
				if (dao.classRoomAdd(dto) == 1) {
					bView.result("강의실이 등록되었습니다.");
					mainView.singlebar();
					loop = false;
				} else if (dao.classRoomAdd(dto) == 2){
					bView.result("이미 존재하는 강의실명입니다.");
					mainView.singlebar();
				} else if (dao.classRoomAdd(dto) == 0){
					bView.result("정원은 숫자로만 입력하세요.");
					mainView.singlebar();
				}
		}else {
			bView.result("모든 항목을 입력해주세요.");
			mainView.singlebar();
		}
	}//while
}
	


public void bookAdd() throws SQLException {//교재 등록하기
	mainView.titlebar("교재등록");
	
	dao.publisherList(); //출판사 리스트 출력
	mainView.onesinglebar();
	
	boolean loopFirst = true;
	String name = "";
	while(loopFirst) {
			mainView.choice("교재명");
			name = scan.nextLine();
			
			
			
			String pub_seq = "";
			boolean loopSecond = true;
			while(loopSecond) {
				
				mainView.choice("출판사 번호 선택");
				pub_seq = scan.nextLine();
				
				
				if(dao.CHECK_PUBLISHER(pub_seq) == 1){
					loopSecond = false;
					
				}else if(dao.CHECK_PUBLISHER(pub_seq) == 2){
				mainView.singlebar();
				bView.result("목록에 있는 번호만 입력하세요.");
				mainView.singlebar();
				}else {
				mainView.singlebar();
				bView.result("숫자로 정확히 입력하세요");
				mainView.singlebar();
				}
				
			}//while //for pub_seq
	
			loop = true;
			String book_stock = "";
			TblBookDTO dto = new TblBookDTO();
			while(loop) {
				mainView.choice("교재 수량");
				book_stock = scan.nextLine();
				mainView.singlebar();
				dto.setName(name);
				dto.setPub_seq(pub_seq);
				dto.setBook_stock(book_stock);
				
				if(!name.equals("") && !pub_seq.equals("")&&!book_stock.equals("")) {
						if (dao.bookAdd(dto) == 1) {
							bView.result("교재가 등록되었습니다.");
							mainView.singlebar();
							loop = false;
							loopFirst = false;
						} else if (dao.bookAdd(dto) == 2){
							bView.result("이미 존재하는 교재입니다."); //출판사명, 교재명 완전히 일치할 때 
							mainView.singlebar();
							loop=false;
						} else if (dao.bookAdd(dto) == 0){
							bView.result("교재수량은 숫자로만 입력하세요.");
							mainView.singlebar();
						}
				}else {
					bView.result("모든 항목을 입력해주세요.");
					mainView.singlebar();
					loop = false;
				}
			}//while //for book_stock
	}//while //for name
}

	public void publisherAdd() throws SQLException {//출판사 등록하기
		mainView.titlebar("출판사등록");
		
		TblPublisherDTO dto = new TblPublisherDTO();
		
		String name = "";
		
		while(loop) {
			mainView.choice("출판사명");
			name = scan.nextLine();
			dto.setName(name);
			mainView.singlebar();
			
			if(!name.equals("")) {
				if (dao.publisherAdd(dto) == 1) {
					bView.result("출판사가 등록되었습니다.");
					mainView.singlebar();
					loop = false;
				} else if (dao.publisherAdd(dto) == 2){
					bView.result("이미 존재하는 출판사명입니다.");
					mainView.singlebar();
				}
			}else {
				bView.result("모든 항목을 입력해주세요.");
				mainView.singlebar();
			}
		
		}
	}
//======================================3. 수정하기========================================
	
	//과정 수정하기
	public void courseEdit() throws SQLException {
		bView.titlebar("기초과정 수정");
		dao.courseList();
		mainView.singlebar();
		
		TblCourseDTO dto = new TblCourseDTO();
		String name = "";
		String cou_seq = "";
		while(loop) {
			mainView.numchoice();//번호 : 선택
			cou_seq = scan.nextLine();
			dto.setCou_seq(cou_seq);
			
			mainView.choice("과정명");
			name = scan.nextLine();
			dto.setName(name);
			mainView.singlebar();
			
			if (dao.courseEdit(dto) == 1) {
				bView.result("과정이 수정되었습니다.");
				mainView.singlebar();
				loop = false;
			}else if(dao.courseEdit(dto) == 2) {
				bView.result("이미 존재하는 과정명입니다.");
				mainView.singlebar();
			}else if(dao.courseEdit(dto) == 3) {
				bView.result("목록에 있는 번호를 선택하세요.");
				mainView.singlebar();
			}else if(dao.courseEdit(dto) == 0) {
				bView.result("번호로만 다시 입력하세요");
				mainView.singlebar();
			}
		}//while
	}


	
	//과목 수정하기
		public void subjectEdit() throws SQLException {
			bView.titlebar("    기초과목 수정");
			
			dao.subjectList();
			mainView.singlebar();
			
			TblSubjectDTO dto = new TblSubjectDTO();
			String sub_seq = "";
			String name = "";
			while(loop) {
				mainView.numchoice();
				sub_seq = scan.nextLine();
				dto.setSub_seq(sub_seq);
				
				mainView.choice("과목명");
				name = scan.nextLine();
				dto.setName(name);
				mainView.singlebar();
				
				if (dao.subjectEdit(dto) == 1) {
					bView.result("과목이 수정되었습니다.");
					mainView.singlebar();
					loop = false;
				}else if(dao.subjectEdit(dto) == 2) {
					bView.result("이미 존재하는 과정명입니다.");
					mainView.singlebar();
				}else if(dao.subjectEdit(dto) == 3) {
					bView.result("목록에 있는 번호를 선택하세요.");
					mainView.singlebar();
				}else if(dao.subjectEdit(dto) == 0) {
					bView.result("번호로만 다시 입력하세요");
					mainView.singlebar();
				}
			}//while 
		}

		//강의실 수정하기
		public void classRoomEdit() throws SQLException {
			bView.titlebar("강의실 수정");
			dao.classRoomList(); //기존 강의실 리스트 출력
			mainView.singlebar();
			
			TblClassRoomDTO dto = new TblClassRoomDTO();
			String cl_seq = "";
			String name = "";
			String capacity = "";
			while(loop) {
				mainView.numchoice();//번호 입력받기 
				cl_seq = scan.nextLine();
				dto.setCl_seq(cl_seq);//받은 번호 DTO에 세팅하기 
				
				mainView.choice("강의실명");
				name = scan.nextLine();
				dto.setName(name);
				
				mainView.choice("정원");
				capacity = scan.nextLine();
				dto.setCapacity(capacity);
				mainView.singlebar();
				
				if (dao.classRoomEdit(dto) == 1) {
					bView.result("강의실이 수정되었습니다.");
					mainView.singlebar();
					loop = false;
				}else if(dao.classRoomEdit(dto) == 2) {
					bView.result("이미 존재하는 강의실명입니다.");
					mainView.singlebar();
				}else if(dao.classRoomEdit(dto) == 3) {
					bView.result("목록에 있는 번호를 선택하세요.");
					mainView.singlebar();
				}else if(dao.classRoomEdit(dto) == 0) {
					bView.result("번호로만 다시 입력하세요");
					mainView.singlebar();
				}
			}//while
		}//classRoomDel() 
			

		//교재 수정하기
		public void bookEdit() throws SQLException {
			bView.titlebar("교재 수정");
			
		    dao.bookList();
			mainView.onesinglebar();
			dao.publisherList(); //출판사 리스트 출력
			mainView.onesinglebar();
		    
		    
			mainView.choice("교재번호선택"); //수정할 교재 받기 
			String book_seq = scan.nextLine();
		
			boolean loopFirst = true;
			String name = "";
			while(loopFirst) {
				
					mainView.choice("교재명");
					name = scan.nextLine();
				
					
					String pub_seq = "";
					mainView.choice("출판사 번호 선택");
					pub_seq = scan.nextLine();
					
					
					
					String book_stock = "";
					mainView.choice("교재 수량");
					book_stock = scan.nextLine();
					mainView.singlebar();
					
					TblBookDTO dto = new TblBookDTO();
					dto.setBook_seq(book_seq);
					dto.setName(name);
					dto.setPub_seq(pub_seq);
					dto.setBook_stock(book_stock);
					
					
					
					loop = true;
					while(loop) {
					
						if (dao.bookEdit(dto) == 1) {
							bView.result("교재가 수정되었습니다.");
							mainView.singlebar();
							loop = false;
							loopFirst = false;
						} else if (dao.bookEdit(dto) == 2){
							bView.result("이미 존재하는 교재입니다.");
							mainView.singlebar(); //출판사명, 교재명 완전히 일치할 때 
							loop=false;
						} else if (dao.bookEdit(dto) == 3){
							bView.result("목록에 있는 번호를 선택하세요.");
							mainView.singlebar();
						}else if (dao.bookEdit(dto) == 0){
							bView.result("번호로만 다시 입력하세요");
							mainView.singlebar();
						}
					}//while //for book_stock
			}//while //for name
		}
		
		
		//출판사 수정하기 
		public void publisherEdit() throws SQLException {
			bView.titlebar("     출판사 수정");
			dao.publisherList();
			mainView.singlebar();
			
			TblPublisherDTO dto = new TblPublisherDTO();
			String pub_seq = "";
			String name = "";
			while(loop) {
				mainView.numchoice();
				pub_seq = scan.nextLine();
				dto.setPub_seq(pub_seq);
				
				mainView.choice("출판사명");
				name = scan.nextLine();
				dto.setName(name);
				mainView.singlebar();
						
				if (dao.publisherEdit(dto) == 1) {
					bView.result("출판사가 수정되었습니다.");
					mainView.singlebar();
					loop = false;
				} else if(dao.publisherEdit(dto) == 2) {
					bView.result("이미 존재하는 출판사명입니다.");
					mainView.singlebar();
				} else if(dao.publisherEdit(dto) == 0) {
					bView.result("목록에 있는 번호를 선택하세요.");
					mainView.singlebar();
				}
			}//while
		}//publisherDel()

//======================================4. 삭제하기======================================== 
	
	//1. 과정 삭제하기
	public void courseDel() throws SQLException {
		bView.titlebar("기초과정 삭제");
		
		dao.courseList(); //기존 과정 리스트 보여주고 여기서 선택하게 하기 
		mainView.singlebar();
		TblCourseDTO dto = new TblCourseDTO();
		
		String cou_seq = "";
		
		while(loop) {
			mainView.numchoice();
		    cou_seq = scan.nextLine();
			dto.setCou_seq(cou_seq);
			mainView.singlebar();
			
			if (dao.courseDel(dto) == 1) {
				bView.result("과정이 삭제되었습니다.");
				mainView.singlebar();
				loop = false;
			} else if(dao.courseDel(dto) == 2) {
				bView.result("현재 개설과정 진행중/예정인 과정입니다. \n 삭제를 원하시면 먼저 개설과정메뉴에서 과정을 수정해주세요.");
				mainView.singlebar();			
			} else if(dao.courseDel(dto) == 0) {
				bView.result("목록에 있는 번호를 선택하세요.");
				mainView.singlebar();
			}
		}
	}//courseDel()

	//2. 과목 삭제하기
	public void subjectDel() throws SQLException {
		bView.titlebar("기초과목 삭제");
		
		dao.subjectList();
		mainView.singlebar();
		TblSubjectDTO dto = new TblSubjectDTO();
		String sub_seq = "";
		
		while(loop) {
			mainView.numchoice();
			sub_seq = scan.nextLine();
			dto.setSub_seq(sub_seq);
			mainView.singlebar();
			
			if (dao.subjectDel(dto) == 1) {
				bView.result("과목이 삭제되었습니다.");
				mainView.singlebar();
				loop = false;
			} else if(dao.subjectDel(dto) == 2) {
				bView.result("현재 개설과정 진행중/예정인 과목입니다. \n 삭제를 원하시면 먼저 개설과정메뉴에서 과목을 수정해주세요.");
				mainView.singlebar();
			} else if(dao.subjectDel(dto) == 0) {
				bView.result("목록에 있는 번호를 선택하세요.");
				mainView.singlebar();
			}
		}//while 
	}

	//강의실 삭제하기
	public void classRoomDel() throws SQLException {
		bView.titlebar("강의실 삭제");
		dao.classRoomList(); //기존 강의실 리스트 출력
		mainView.singlebar();
		TblClassRoomDTO dto = new TblClassRoomDTO();
		String cl_seq = "";
		while(loop) {
			mainView.numchoice();//번호 입력받기 
			cl_seq = scan.nextLine();
			dto.setCl_seq(cl_seq);//받은 번호 DTO에 세팅하기 
			mainView.singlebar();
			if (dao.classRoomDel(dto) == 1) {
				bView.result("강의실이 삭제되었습니다.");
				mainView.singlebar();
				loop = false;
			} else if(dao.classRoomDel(dto) == 2) {
				bView.result("현재 개설과정 진행중/예정인 강의실입니다. \n 삭제를 원하시면 먼저 개설과정메뉴에서 강의실을 수정해주세요.");
				mainView.singlebar();
			} else if(dao.classRoomDel(dto) == 0) {
				bView.result("목록에 있는 번호를 선택하세요.");
				mainView.singlebar();
			}
		}//while
	}//classRoomDel() 
		

	//교재 삭제하기
	public void bookDel() throws SQLException {
		bView.titlebar("교재 삭제");
		dao.bookList(); //기존 교재 리스트 출력
		mainView.singlebar();
		
		TblBookDTO dto = new TblBookDTO();
		String book_seq = "";
		while(loop) {
			mainView.numchoice();//번호 입력받기 
			book_seq = scan.nextLine();
			dto.setBook_seq(book_seq);//받은 번호 DTO에 세팅하기 
			mainView.singlebar();
			
			if (dao.bookDel(dto) == 1) {
				bView.result("교재가 삭제되었습니다.");
				mainView.singlebar();
				loop = false;
			} else if(dao.bookDel(dto) == 2) {
				bView.result("현재 진행중/예정인 개설과정에서 사용중인 교재입니다. \n 삭제를 원하시면 먼저 개설과정메뉴에서 교재를 수정해주세요.");
				mainView.singlebar();
			} else if(dao.bookDel(dto) == 0) {
				bView.result("목록에 있는 번호를 선택하세요.");
				mainView.singlebar();
			}
		}//while
	}
	
	
	//출판사 삭제하기 
	public void publisherDel() throws SQLException {//출판사 등록하기
		bView.titlebar("출판사 삭제");
		dao.publisherList();
		mainView.singlebar();
		TblPublisherDTO dto = new TblPublisherDTO();
		String pub_seq = "";
		while(loop) {
			mainView.numchoice();
			pub_seq = scan.nextLine();
			dto.setPub_seq(pub_seq);
			mainView.singlebar();
			
			if (dao.publisherDel(dto) == 1) {
				bView.result("출판사가 삭제되었습니다.");
				mainView.singlebar();
				loop = false;
			} else if(dao.publisherDel(dto) == 2) {
				bView.result("현재 진행중/예정인 개설과정에서 사용중인 교재의 출판사입니다. \n 삭제를 원하시면 먼저 해당 교재의 출판사를 수정해주세요.");
				mainView.singlebar();
			} else if(dao.publisherDel(dto) == 0) {
				bView.result("목록에 있는 번호를 선택하세요.");
				mainView.singlebar();
			}
		}//while
	}//publisherDel()
}//BasicInfoClass


