package com.project2.mvc.manager.model;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.project2.mvc.model.DBUtil;
import com.project2.mvc.model.DataSource;
import com.project2.mvc.model.TblBookDTO;
import com.project2.mvc.model.TblClassRoomDTO;
import com.project2.mvc.model.TblCourseDTO;
import com.project2.mvc.model.TblPublisherDTO;
import com.project2.mvc.model.TblSubjectDTO;
import com.project2.mvc.view.MainView;

import oracle.jdbc.internal.OracleTypes;

public class BasicInfoDAO {
  
	
	
	private DataSource ds;
	private Connection conn;
	private MainView mainView;
	public BasicInfoDAO() {
		mainView = new MainView();
		
		try {
			ds = new DataSource();
			conn = DBUtil.open();
		} catch (Exception e) {
			System.out.println("BasicInfoDAO.Contructor" + e.toString());
		}
	}
	
	
	//BasicInfoList 출력하는 메소드 
	
	//과정출력
	public void courseList() {
		
		CallableStatement stat = null;
		
		try {	
			stat = conn.prepareCall(ds.get("basicInfo.courseList"));
			stat.registerOutParameter(1, OracleTypes.CURSOR);
			stat.executeUpdate();
	
			ResultSet rs = (ResultSet)stat.getObject(1);
			
			System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t"
					+ "   과정목록");
			mainView.onesinglebar();
			System.out.println("\t\t\t\t\t\t\t\t\t\t\t"+ "[번호]\t\t\t\t\t\t[과정명]");
			while (rs.next()) {
				System.out.printf("\t\t\t\t\t\t\t\t\t\t\t   "+"%s\t\t\t\t%s\n", rs.getString(1), rs.getString(2));
			}
			rs.close();
			stat.close();
			
		} catch (Exception e) {
			System.out.println("오류 BasicInfoDAO.courseList : " + e.toString());
		}
	}//courseList() 
	
	
	
	public void subjectList() {
		
		CallableStatement stat = null;
		
		try {

			stat = conn.prepareCall(ds.get("basicInfo.subjectList"));
			stat.registerOutParameter(1, OracleTypes.CURSOR);
			stat.executeUpdate();
	
			ResultSet rs = (ResultSet)stat.getObject(1);
			
			System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t"+"    [번호]\t\t\t[과목명]");
			mainView.onesinglebar();
			while (rs.next()) {
				System.out.printf("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t"+"%s\t\t%s\n"
												, rs.getString("sub_seq"), rs.getString("name"));
			}
			rs.close();
			stat.close();
			
		} catch (Exception e) {
			System.out.println("오류 BasicInfoDAO.subjectList : " + e.toString());
		}
	}//subjectList()
	
	
	public void classRoomList() {
	
		CallableStatement stat = null;
		
		try {
			
			stat = conn.prepareCall(ds.get("basicInfo.classRoomList"));
			stat.registerOutParameter(1, OracleTypes.CURSOR);
			stat.executeUpdate();
	
			ResultSet rs = (ResultSet)stat.getObject(1);
			
			System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t"+"    [번호]\t\t\t[강의실명]\t\t\t[정원]");
			mainView.onesinglebar();
			while (rs.next()) {
				System.out.printf("\t\t\t\t\t\t\t\t\t\t\t\t\t"+"%s\t\t\t%s\t\t\t  %s\n", rs.getString("cl_seq")
																					, rs.getString("name")
																					, rs.getString("capacity"));
			}
			rs.close();
			stat.close();
			
		} catch (Exception e) {
			System.out.println("오류 BasicInfoDAO.classRoomList : " + e.toString());
		}
	}//classRoomList()


	public void bookList() {
	
		CallableStatement stat = null;
		
		try {
			stat = conn.prepareCall(ds.get("basicInfo.bookList"));
			stat.registerOutParameter(1, OracleTypes.CURSOR);
			stat.executeUpdate();
	
			ResultSet rs = (ResultSet)stat.getObject(1);
			System.out.println("\t\t\t\t\t\t\t\t\t"+"    [번호]\t\t\t\t[교재명]\t\t\t\t\t[재고량]\t\t[출판사명]");
			mainView.onesinglebar();
			while (rs.next()) {
				System.out.printf("\t\t\t\t\t\t\t\t\t\t"+"%s\t\t %-25s \t          %5s \t\t%s\t\n"
													, rs.getString(1)
													, rs.getString(2)
													, rs.getString(4)
													, rs.getString(3));
			}
			rs.close();
			stat.close();
		
		} catch (Exception e) {
			System.out.println("오류 BasicInfoDAO.bookList : " + e.toString());
		}
	}//bookList()
	
	public void publisherList() {
		
		CallableStatement stat = null;
		
		try {
			stat = conn.prepareCall(ds.get("basicInfo.publisherList"));
			stat.registerOutParameter(1, OracleTypes.CURSOR);
			stat.executeUpdate();

			ResultSet rs = (ResultSet)stat.getObject(1);
			System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t"+"    [번호]\t\t\t[출판사명]");
			mainView.onesinglebar();
			while (rs.next()) {
				System.out.printf("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t"+"%s\t\t      %s\n"
													, rs.getString("pub_seq")
													, rs.getString("name"));										
			}
			rs.close();
			stat.close();
		
		} catch (Exception e) {
			System.out.println("오류 BasicInfoDAO.publisherList" + e.toString());
		}
	}//publisherList()
	

	
	//BasicInfoAdd 등록하는 메소드 
	
	//과정 등록하기
	public int courseAdd(TblCourseDTO dto) throws SQLException {
		
		CallableStatement stat = null;
		
		try {
			stat = conn.prepareCall(ds.get("basicInfo.courseAdd"));
			stat.setString(1, dto.getName());
			stat.registerOutParameter(2, OracleTypes.INTEGER);
			stat.executeQuery();
			
		} catch (Exception e) {
			System.out.println("오류 BasicInfoDAO.courseAdd : " + e.toString());
		}
		
		return stat.getInt(2);
	}//courseList() 
	
	//과목 등록하기 
	public int subjectAdd(TblSubjectDTO dto) throws SQLException {
		
		CallableStatement stat = null;
		
		try {
			stat = conn.prepareCall(ds.get("basicInfo.subjectAdd"));
			stat.setString(1, dto.getName());
			stat.registerOutParameter(2, OracleTypes.INTEGER);
			stat.executeQuery();
			
		} catch (Exception e) {
			System.out.println("오류 BasicInfoDAO.subjectAdd : " + e.toString());
		}
		
		return stat.getInt(2);
	}//courseList() 


	public int classRoomAdd(TblClassRoomDTO dto) throws SQLException {
		CallableStatement stat = null;
		
		try {
			stat = conn.prepareCall(ds.get("basicInfo.classRoomAdd"));
			stat.setString(1, dto.getName());
			stat.setString(2, dto.getCapacity());
			stat.registerOutParameter(3, OracleTypes.INTEGER);
			stat.executeQuery();
			
		} catch (Exception e) {
			System.out.println("오류 BasicInfoDAO.classRoomAdd : " + e.toString());
		}
		return stat.getInt(3);
		
	}


	public int publisherAdd(TblPublisherDTO dto) throws SQLException {
		CallableStatement stat = null;
		
		try {
			stat = conn.prepareCall(ds.get("basicInfo.publisherAdd"));
			stat.setString(1, dto.getName());
			stat.registerOutParameter(2, OracleTypes.INTEGER);
			stat.executeQuery();
			
		} catch (Exception e) {
			System.out.println("오류 BasicInfoDAO.publisherAdd : " + e.toString());
		}
		
		return stat.getInt(2);
	}
   

	
	
	public int CHECK_PUBLISHER(String pub_seq) throws SQLException {
		CallableStatement stat = null;
		
		try {

			stat = conn.prepareCall(ds.get("basicInfo.CHECK_PUBLISHER"));
			stat.setString(1, pub_seq);
			stat.registerOutParameter(2, OracleTypes.INTEGER);
			stat.executeQuery();
			
		} catch (Exception e) {
		//	System.out.println("오류 BasicInfoDAO.CHECK_PUBLISHER : " + e.toString());
		}
		return stat.getInt(2);
		
	}
	
	
	
	
	
	public int bookAdd(TblBookDTO dto) throws SQLException {
		CallableStatement stat = null;
		
		try {
			
			stat = conn.prepareCall(ds.get("basicInfo.bookAdd"));
			stat.setString(1, dto.getName());
			stat.setString(2, dto.getBook_stock());
			stat.setString(3, dto.getPub_seq());
			stat.registerOutParameter(4, OracleTypes.INTEGER);
			stat.executeQuery();
			
		} catch (Exception e) {
			//System.out.println("오류 BasicInfoDAO.bookAdd : " + e.toString());
		}
		
		return stat.getInt(4);
	}
	
	
	
	
	

//===============================================================================삭제하기
public int courseDel(TblCourseDTO dto) throws SQLException {
		
		CallableStatement stat = null;
		
		try {
			stat = conn.prepareCall(ds.get("basicInfo.courseDel"));
			stat.setString(1, dto.getCou_seq());
			stat.registerOutParameter(2, OracleTypes.INTEGER);
			stat.executeQuery();
			
		} catch (Exception e) {
			System.out.println("오류 BasicInfoDAO.courseDel : " + e.toString());
		}
		
		return stat.getInt(2);
	}//courseList() 


public int subjectDel(TblSubjectDTO dto) throws SQLException {
	CallableStatement stat = null;
	
	try {
					
		stat = conn.prepareCall(ds.get("basicInfo. subjectDel"));
		stat.setString(1, dto.getSub_seq());
		stat.registerOutParameter(2, OracleTypes.INTEGER);
		stat.executeQuery();
		
	} catch (Exception e) {
		System.out.println("오류 BasicInfoDAO.subjectDel : " + e.toString());
	}
	
	return stat.getInt(2);
}


public int classRoomDel(TblClassRoomDTO dto) throws SQLException {
	CallableStatement stat = null;
	
	try {
		stat = conn.prepareCall(ds.get("basicInfo.classRoomDel"));
		stat.setString(1, dto.getCl_seq());
		stat.registerOutParameter(2, OracleTypes.INTEGER);
		stat.executeQuery();
		
	} catch (Exception e) {
		System.out.println("오류 BasicInfoDAO.classRoomDel : " + e.toString());
	}
	return stat.getInt(2);
	
}


public int bookDel(TblBookDTO dto) throws SQLException {
	CallableStatement stat = null;
	
	try {

		stat = conn.prepareCall(ds.get("basicInfo.bookDel"));
		stat.setString(1, dto.getBook_seq());
		stat.registerOutParameter(2, OracleTypes.INTEGER);
		stat.executeQuery();
		
	} catch (Exception e) {
		System.out.println("오류 BasicInfoDAO.bookDel : " + e.toString());
	}
	
	return stat.getInt(2);
}


public int publisherDel(TblPublisherDTO dto) throws SQLException {
	CallableStatement stat = null;

	try {

		stat = conn.prepareCall(ds.get("basicInfo.publisherDel"));
		stat.setString(1, dto.getPub_seq());
		stat.registerOutParameter(2, OracleTypes.INTEGER);
		stat.executeQuery();
		
	} catch (Exception e) {
	//	System.out.println("오류 BasicInfoDAO.publisherDel : " + e.toString());
	}
	
	return stat.getInt(2);
}

//===============================================================================수정하기
public int courseEdit(TblCourseDTO dto) throws SQLException {
	CallableStatement stat = null;
	CallableStatement stat2 = null;
	try {	

		stat2 = conn.prepareCall(ds.get("basicInfo.courseEditOriginal"));
		stat2.setString(1, dto.getCou_seq());
		stat2.registerOutParameter(2, OracleTypes.CURSOR);
		stat2.executeQuery();
		
		ResultSet rs = (ResultSet)stat2.getObject(2);
		
	while(rs.next()) {
            if(dto.getName().equals("")) {
            	dto.setName(rs.getString("name"));
            }
	}
	
	rs.close();
	stat2.close();
	

		stat = conn.prepareCall(ds.get("basicInfo.courseEdit"));
		stat.setString(1, dto.getCou_seq());
		stat.setString(2, dto.getName());
		stat.registerOutParameter(3, OracleTypes.INTEGER);
		stat.executeQuery();
		
	} catch (Exception e) {
		System.out.println("오류 BasicInfoDAO.courseEdit : " + e.toString());
	}
	
	return stat.getInt(3);
}





public int subjectEdit(TblSubjectDTO dto) throws SQLException {
	CallableStatement stat = null;
	CallableStatement stat2 = null;
	try {	

		stat2 = conn.prepareCall(ds.get("basicInfo.subjectEditOriginal"));
		stat2.setString(1, dto.getSub_seq());
		stat2.registerOutParameter(2, OracleTypes.CURSOR);
		stat2.executeQuery();
		
		ResultSet rs = (ResultSet)stat2.getObject(2);
		
	while(rs.next()) {
            if(dto.getName().equals("")) {
            	dto.setName(rs.getString("name"));
            }
	}
	
	rs.close();
	stat2.close();

		stat = conn.prepareCall(ds.get("basicInfo.subjectEdit"));
		stat.setString(1, dto.getSub_seq());
		stat.setString(2, dto.getName());
		stat.registerOutParameter(3, OracleTypes.INTEGER);
		stat.executeQuery();
		
	} catch (Exception e) {
		System.out.println("오류 BasicInfoDAO.subjectEdit : " + e.toString());
	}
	
	return stat.getInt(3);
}


public int classRoomEdit(TblClassRoomDTO dto) throws SQLException {
	CallableStatement stat = null;
	CallableStatement stat2 = null;
	try {	

		stat2 = conn.prepareCall(ds.get("basicInfo.classRoomEditOriginal"));
		stat2.setString(1, dto.getCl_seq());
		stat2.registerOutParameter(2, OracleTypes.CURSOR);
		stat2.executeQuery();
		
		ResultSet rs = (ResultSet)stat2.getObject(2);
		
	while(rs.next()) {
            if(dto.getName().equals("")) {
            	dto.setName(rs.getString("name"));
            }if(dto.getCapacity().equals("")) {
            	dto.setCapacity(rs.getString("Capacity"));
            }
	}
	
	rs.close();
	stat2.close();
		
		stat = conn.prepareCall(ds.get("basicInfo.classRoomEdit"));
		stat.setString(1, dto.getCl_seq());
		stat.setString(2, dto.getName());
		stat.setString(3, dto.getCapacity());
		stat.registerOutParameter(4, OracleTypes.INTEGER);
		stat.executeQuery();
		
	} catch (Exception e) {
		System.out.println("오류 BasicInfoDAO.classRoomEdit : " + e.toString());
	}
	return stat.getInt(4);
}


public int bookEdit(TblBookDTO dto) throws SQLException {
	CallableStatement stat = null;
	CallableStatement stat2 = null;
	try {	

		stat2 = conn.prepareCall(ds.get("basicInfo.bookEditOriginal"));
		stat2.setString(1, dto.getBook_seq());
		stat2.registerOutParameter(2, OracleTypes.CURSOR);
		stat2.executeQuery();
		
		ResultSet rs = (ResultSet)stat2.getObject(2);
		
	while(rs.next()) {
            if(dto.getName().equals("")) {
            	dto.setName(rs.getString("name"));
            }if(dto.getBook_stock().equals("")) {
            	dto.setBook_stock(rs.getString("book_stock"));
            }if(dto.getPub_seq().equals("")) {
            	dto.setPub_seq(rs.getString("pub_seq"));
            }
	}
	
	rs.close();
	stat2.close();
		stat = conn.prepareCall(ds.get("basicInfo.bookEdit"));
		stat.setString(1, dto.getBook_seq());
		stat.setString(2, dto.getName());
		stat.setString(3, dto.getBook_stock());
		stat.setString(4, dto.getPub_seq());
		stat.registerOutParameter(5, OracleTypes.INTEGER);
		stat.executeQuery();
		
	} catch (Exception e) {
		System.out.println("오류 BasicInfoDAO.bookEdit : " + e.toString());
	}
	return stat.getInt(5);
}


public int publisherEdit(TblPublisherDTO dto) throws SQLException {
	CallableStatement stat = null;
	CallableStatement stat2 = null;
	try {	

		stat2 = conn.prepareCall(ds.get("basicInfo.publisherEditOriginal"));
		stat2.setString(1, dto.getPub_seq());
		stat2.registerOutParameter(2, OracleTypes.CURSOR);
		stat2.executeQuery();
		
		ResultSet rs = (ResultSet)stat2.getObject(2);
		
	while(rs.next()) {
            if(dto.getName().equals("")) {
            	dto.setName(rs.getString("name"));
            }
	}
	
	rs.close();
	stat2.close();
		
		stat = conn.prepareCall(ds.get("basicInfo.publisherEdit"));
		stat.setString(1, dto.getPub_seq());
		stat.setString(2, dto.getName());
		stat.registerOutParameter(3, OracleTypes.INTEGER);
		stat.executeQuery();
		
	} catch (Exception e) {
		System.out.println("오류 BasicInfoDAO.publisherEdit : " + e.toString());
	}
	
	return stat.getInt(3);
}



	
}//BasicInfoDAO
 
