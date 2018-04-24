package com.project2.mvc.manager;

import java.sql.SQLException;
import java.util.Scanner;

import com.project2.mvc.manager.model.BasicInfoDAO;
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
	
	
	public BasicInfoClass() {
		mainView = new MainView();
		dao = new BasicInfoDAO();		
		scan = new Scanner(System.in);
		loop = true;
	}
	
	
	
	
	

//	public static void main(String[] args) throws SQLException {
//	BasicInfoClass a = new BasicInfoClass();
//		
//		//출력하기
//		//a.courseList();
//		//a.subjectList();
//		//a.classRoomList();
//		//a.bookList();
//		//a.publisherList();
//		
//	
//		//등록하기
//		//a.courseAdd();
//		//a.subjectAdd();
//		//a.classRoomAdd();
//		//a.publisherAdd();
//		//a.bookAdd();
//		
//		//삭제하기
//		//a.courseDel();		
//		//a.subjectDel();	
//		//a.classRoomDel();
//		//a.bookDel();
//		//a.publisherDel();
//		
//		//수정하기
//		//a.courseEdit();//완
//		//a.subjectEdit();
//		//a.classRoomEdit(); //미완-> null값일 때 처리하기 
//		//a.bookEdit(); //미완 -> null값일 떄 처리하기
//		a.publisherEdit(); 
//		
//		
//	}
	
//1. 출력하기
public void courseList() { //과정리스트 출력
	
	dao.courseList();
}

public void subjectList() {//과목리스트 출력
	dao.subjectList();
}

public void classRoomList() {//강의실 출력
	dao.classRoomList();
}

public void bookList() {//교재리스트 출력
	dao.bookList();
}

public void publisherList() {//출판사리스트 출력
	dao.publisherList();
}





	
//========================================2. 등록하기=======================================	
//과정 등록하기
public void courseAdd() throws SQLException {
	mainView.header("과정 등록하기");
	
	TblCourseDTO dto = new TblCourseDTO();
	String name = "";
	while(loop) {
		mainView.choice("과정명");
		name = scan.nextLine();
		dto.setName(name);
		
		if(!name.equals("")) {
			if (dao.courseAdd(dto) == 1) {
				mainView.result("과정이 등록되었습니다.");
				loop = false;
			} else {
				mainView.result("이미 존재하는 과정명입니다.");
			}
		}else {
			mainView.result("모든 항목을 입력해주세요.");
		}
	}//while
}


public void subjectAdd() throws SQLException {//과목 등록하기
	mainView.header("과목 등록하기");
	
	TblSubjectDTO dto = new TblSubjectDTO();
	String name = "";
	while(loop) {
		mainView.choice("과목명");
		name = scan.nextLine();	
		dto.setName(name);
		
		if(!name.equals("")) {
				if (dao.subjectAdd(dto) == 1) {
					mainView.result("과목이 등록되었습니다.");
					loop = false;
				} else {
					mainView.result("이미 존재하는 과목명입니다.");
				}
		}else {
			mainView.result("모든 항목을 입력해주세요.");
		}			
	}
}


public void classRoomAdd() throws SQLException {//강의실 등록하기
	mainView.header("강의실 등록하기");
	
	TblClassRoomDTO dto = new TblClassRoomDTO();	
	String name = "";
	String capacity = "";
	
	while(loop) {
		mainView.choice("강의실명");
		name = scan.nextLine();
		mainView.choice("정원");
		capacity = scan.nextLine();
	
		dto.setName(name);
		dto.setCapacity(capacity);
			
		if(!name.equals("")&&!capacity.equals("")) {
				if (dao.classRoomAdd(dto) == 1) {
					mainView.result("강의실이 등록되었습니다.");
					loop = false;
				} else if (dao.classRoomAdd(dto) == 2){
					mainView.result("이미 존재하는 강의실명입니다.");
				} else if (dao.classRoomAdd(dto) == 0){
					mainView.result("정원은 숫자로만 입력하세요.");
				}
		}else {
			mainView.result("모든 항목을 입력해주세요.");
		}
	}//while
}
	


public void bookAdd() throws SQLException {//교재 등록하기
	mainView.header("교재 등록하기");
	
	boolean loopFirst = true;
	String name = "";
	while(loopFirst) {
			mainView.choice("교재명");
			name = scan.nextLine();
			
			dao.publisherList(); //출판사 리스트 출력
			
			String pub_seq = "";
			boolean loopSecond = true;
			while(loopSecond) {
				mainView.choice("출판사 번호 선택");
				pub_seq = scan.nextLine();
				
				if(dao.CHECK_PUBLISHER(pub_seq) == 1){
					loopSecond = false;
					
				}else if(dao.CHECK_PUBLISHER(pub_seq) == 2){
				mainView.result("목록에 있는 번호만 입력하세요.");
				}else {
				mainView.result("숫자로 정확히 입력하세요");
				}
				
			}//while //for pub_seq
	
			loop = true;
			String book_stock = "";
			TblBookDTO dto = new TblBookDTO();
			while(loop) {
				mainView.choice("교재 수량");
				book_stock = scan.nextLine();
				
				dto.setName(name);
				dto.setPub_seq(pub_seq);
				dto.setBook_stock(book_stock);
				
				if(!name.equals("") && !pub_seq.equals("")&&!book_stock.equals("")) {
						if (dao.bookAdd(dto) == 1) {
							mainView.result("교재가 등록되었습니다.");
							loop = false;
							loopFirst = false;
						} else if (dao.bookAdd(dto) == 2){
							mainView.result("이미 존재하는 교재입니다."); //출판사명, 교재명 완전히 일치할 때 
							loop=false;
						} else if (dao.bookAdd(dto) == 0){
							mainView.result("교재수량은 숫자로만 입력하세요.");
						}
				}else {
					mainView.result("모든 항목을 입력해주세요.");
					loop = false;
				}
			}//while //for book_stock
	}//while //for name
}

	public void publisherAdd() throws SQLException {//출판사 등록하기
		mainView.header("출판사 등록하기");
		
		TblPublisherDTO dto = new TblPublisherDTO();
		
		String name = "";
		
		while(loop) {
			mainView.choice("출판사명");
			name = scan.nextLine();
			dto.setName(name);
			
			if(!name.equals("")) {
				if (dao.publisherAdd(dto) == 1) {
					mainView.result("출판사가 등록되었습니다.");
					loop = false;
				} else if (dao.publisherAdd(dto) == 2){
					mainView.result("이미 존재하는 출판사명입니다.");
				}
			}else {
				mainView.result("모든 항목을 입력해주세요.");
			}
		
		}
	}
//======================================3. 수정하기========================================
	
	//과정 수정하기
	public void courseEdit() throws SQLException {
		mainView.header("과정 수정하기");
		courseList();
		
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
			
			if (dao.courseEdit(dto) == 1) {
				mainView.result("과정이 수정되었습니다.");
				loop = false;
			}else if(dao.courseEdit(dto) == 2) {
				mainView.result("이미 존재하는 과정명입니다.");
			}else if(dao.courseEdit(dto) == 3) {
				mainView.result("목록에 있는 번호를 선택하세요.");
			}else if(dao.courseEdit(dto) == 0) {
				mainView.result("번호로만 다시 입력하세요");
			}
		}//while
	}


	
	//과목 수정하기
		public void subjectEdit() throws SQLException {
			mainView.header("과목 수정하기");
			
			subjectList();
			
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
				
				if (dao.subjectEdit(dto) == 1) {
					mainView.result("과정이 수정되었습니다.");
					loop = false;
				}else if(dao.subjectEdit(dto) == 2) {
					mainView.result("이미 존재하는 과정명입니다.");
				}else if(dao.subjectEdit(dto) == 3) {
					mainView.result("목록에 있는 번호를 선택하세요.");
				}else if(dao.subjectEdit(dto) == 0) {
					mainView.result("번호로만 다시 입력하세요");
				}
			}//while 
		}

		//강의실 수정하기
		public void classRoomEdit() throws SQLException {
			mainView.header("강의실 수정하기");
			classRoomList(); //기존 강의실 리스트 출력
			
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
				
				if (dao.classRoomEdit(dto) == 1) {
					mainView.result("강의실이 수정되었습니다.");
					loop = false;
				}else if(dao.classRoomEdit(dto) == 2) {
					mainView.result("이미 존재하는 강의실명입니다.");
				}else if(dao.classRoomEdit(dto) == 3) {
					mainView.result("목록에 있는 번호를 선택하세요.");
				}else if(dao.classRoomEdit(dto) == 0) {
					mainView.result("번호와 정원은 숫자로만 입력하세요");
				}
			}//while
		}//classRoomDel() 
			

		//교재 수정하기
		public void bookEdit() throws SQLException {
			mainView.header("교재 수정하기");
			
			bookList();
			mainView.numchoice(); //수정할 교재 받기 
			String book_seq = scan.nextLine();
		
			boolean loopFirst = true;
			String name = "";
			while(loopFirst) {
				
					mainView.choice("교재명");
					name = scan.nextLine();
					
					dao.publisherList(); //출판사 리스트 출력
					
					String pub_seq = "";
					mainView.choice("출판사 번호 선택");
					pub_seq = scan.nextLine();
					
					String book_stock = "";
					mainView.choice("교재 수량");
					book_stock = scan.nextLine();
					
					TblBookDTO dto = new TblBookDTO();
					dto.setBook_seq(book_seq);
					dto.setName(name);
					dto.setPub_seq(pub_seq);
					dto.setBook_stock(book_stock);
					
					
					
					loop = true;
					while(loop) {
					
						if (dao.bookEdit(dto) == 1) {
							mainView.result("교재가 수정되었습니다.");
							loop = false;
							loopFirst = false;
						} else if (dao.bookEdit(dto) == 2){
							mainView.result("이미 존재하는 교재입니다."); //출판사명, 교재명 완전히 일치할 때 
							loop=false;
						} else if (dao.bookEdit(dto) == 3){
							mainView.result("목록에 있는 번호만 입력하세요.");
						}else if (dao.bookEdit(dto) == 0){
							mainView.result("번호는 숫자로만 입력하세요.");
						}
					}//while //for book_stock
			}//while //for name
		}
		
		
		//출판사 수정하기 
		public void publisherEdit() throws SQLException {
			mainView.header("출판사 수정하기");
			publisherList();
			
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
						
				if (dao.publisherEdit(dto) == 1) {
					mainView.result("출판사가 수정되었습니다.");
					loop = false;
				} else if(dao.publisherEdit(dto) == 2) {
					mainView.result("이미 존재하는 출판사명입니다.");
				} else if(dao.publisherEdit(dto) == 0) {
					mainView.result("목록에 있는 번호를 선택하세요.");
				}
			}//while
		}//publisherDel()

//======================================4. 삭제하기======================================== 
	
	//1. 과정 삭제하기
	public void courseDel() throws SQLException {
		mainView.header("과정 삭제하기");
		
		courseList(); //기존 과정 리스트 보여주고 여기서 선택하게 하기 
		
		TblCourseDTO dto = new TblCourseDTO();
		
		String cou_seq = "";
		
		while(loop) {
			mainView.numchoice();
		    cou_seq = scan.nextLine();
			dto.setCou_seq(cou_seq);
			
			if (dao.courseDel(dto) == 1) {
				mainView.result("과정이 삭제되었습니다.");
				loop = false;
			} else if(dao.courseDel(dto) == 2) {
				mainView.result("현재 개설과정 진행중/예정인 과정입니다. \n 삭제를 원하시면 먼저 개설과정메뉴에서 과정을 수정해주세요.");
			} else if(dao.courseDel(dto) == 0) {
				mainView.result("목록에 있는 번호를 선택하세요.");
			}
		}
	}//courseDel()

	//2. 과목 삭제하기
	public void subjectDel() throws SQLException {
		mainView.header("과목 삭제하기");
		
		subjectList();
		
		TblSubjectDTO dto = new TblSubjectDTO();
		String sub_seq = "";
		
		while(loop) {
			mainView.numchoice();
			sub_seq = scan.nextLine();
			dto.setSub_seq(sub_seq);
			
			if (dao.subjectDel(dto) == 1) {
				mainView.result("과목이 삭제되었습니다.");
				loop = false;
			} else if(dao.subjectDel(dto) == 2) {
				mainView.result("현재 개설과정 진행중/예정인 과목입니다. \n 삭제를 원하시면 먼저 개설과정메뉴에서 과목을 수정해주세요.");
			} else if(dao.subjectDel(dto) == 0) {
				mainView.result("목록에 있는 번호를 선택하세요.");
			}
		}//while 
	}

	//강의실 삭제하기
	public void classRoomDel() throws SQLException {
		mainView.header("강의실 삭제하기");
		classRoomList(); //기존 강의실 리스트 출력
		
		TblClassRoomDTO dto = new TblClassRoomDTO();
		String cl_seq = "";
		while(loop) {
			mainView.numchoice();//번호 입력받기 
			cl_seq = scan.nextLine();
			dto.setCl_seq(cl_seq);//받은 번호 DTO에 세팅하기 
			
			if (dao.classRoomDel(dto) == 1) {
				mainView.result("강의실이 삭제되었습니다.");
				loop = false;
			} else if(dao.classRoomDel(dto) == 2) {
				mainView.result("현재 개설과정 진행중/예정인 강의실입니다. \n 삭제를 원하시면 먼저 개설과정메뉴에서 강의실을 수정해주세요.");
			} else if(dao.classRoomDel(dto) == 0) {
				mainView.result("목록에 있는 번호를 선택하세요.");
			}
		}//while
	}//classRoomDel() 
		

	//교재 삭제하기
	public void bookDel() throws SQLException {
		mainView.header("교재 삭제하기");
		bookList(); //기존 교재 리스트 출력
		
		TblBookDTO dto = new TblBookDTO();
		String book_seq = "";
		while(loop) {
			mainView.numchoice();//번호 입력받기 
			book_seq = scan.nextLine();
			dto.setBook_seq(book_seq);//받은 번호 DTO에 세팅하기 
			
			if (dao.bookDel(dto) == 1) {
				mainView.result("교재가 삭제되었습니다.");
				loop = false;
			} else if(dao.bookDel(dto) == 2) {
				mainView.result("현재 진행중/예정인 개설과정에서 사용중인 교재입니다. \n 삭제를 원하시면 먼저 개설과정메뉴에서 교재를 수정해주세요.");
			} else if(dao.bookDel(dto) == 0) {
				mainView.result("목록에 있는 번호를 선택하세요.");
			}
		}//while
	}
	
	
	//출판사 삭제하기 
	public void publisherDel() throws SQLException {//출판사 등록하기
		mainView.header("출판사 삭제하기");
		publisherList();
		
		TblPublisherDTO dto = new TblPublisherDTO();
		String pub_seq = "";
		while(loop) {
			mainView.numchoice();
			pub_seq = scan.nextLine();
			dto.setPub_seq(pub_seq);
			
			if (dao.publisherDel(dto) == 1) {
				mainView.result("출판사가 삭제되었습니다.");
				loop = false;
			} else if(dao.publisherDel(dto) == 2) {
				mainView.result("현재 진행중/예정인 개설과정에서 사용중인 교재의 출판사입니다. \n 삭제를 원하시면 먼저 해당 교재의 출판사를 수정해주세요.");
			} else if(dao.publisherDel(dto) == 0) {
				mainView.result("목록에 있는 번호를 선택하세요.");
			}
		}//while
	}//publisherDel()
}//BasicInfoClass


