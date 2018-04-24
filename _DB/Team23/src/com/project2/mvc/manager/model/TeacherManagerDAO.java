package com.project2.mvc.manager.model;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.project2.mvc.model.DBUtil;
import com.project2.mvc.model.DataSource;
import com.project2.mvc.model.TblAvaSubjectDTO;
import com.project2.mvc.model.TblOpenCourseDTO;
import com.project2.mvc.model.TblTeacherDTO;
import com.project2.mvc.view.MainView;

import oracle.jdbc.internal.OracleTypes;

public class TeacherManagerDAO {
	private DataSource ds;
	private Connection conn;	
	private MainView mainView;

	
	public TeacherManagerDAO()  {
		mainView = new MainView();
		try {
			ds = new DataSource();
			conn = DBUtil.open();
		} catch (Exception e) {
			System.out.println("TeacherManagerDAO.Contructor" + e.toString());
		}
	}
	
	
	
	//전체용) 교사 전체 정보 출력 
	public void teacherList() {
		CallableStatement stat = null;
		
		try {	
			stat = conn.prepareCall(ds.get("teacherManage.teacherList"));
			stat.registerOutParameter(1, OracleTypes.CURSOR);
			stat.executeQuery();
	
			ResultSet rs = (ResultSet)stat.getObject(1);
			
			System.out.println("\t\t\t\t\t\t"+"\t\t\t\t[ID]"
					+ "\t\t\t[이름]\t\t\t"
					+ "[주민번호(뒷자리)]\t\t\t[전화번호]");
			mainView.onesinglebar();
			
			
			while (rs.next()) {
				System.out.printf("\t\t\t\t\t\t\t\t\t\t"+"%s\t\t\t%s\t\t\t\t%s\t\t\t  %s\t\n"
						  , rs.getString("T_ID")
						  , rs.getString("name")
						  , rs.getString("ssn")
						  , rs.getString("phone_number"));
	
				
						
			}
			rs.close();
			stat.close();
			
		} catch (Exception e) {
			System.out.println("오류 TeacherManagerDAO.teacherList : " + e.toString());
		}
	}
	
	//선택한 한명 보여주기 
	public void teacherListOne(TblTeacherDTO dto) {
		CallableStatement stat = null;
		
		try {	
			stat = conn.prepareCall(ds.get("teacherManage.teacherListOne"));
			stat.setString(1, dto.getT_id());
			stat.registerOutParameter(2, OracleTypes.CURSOR);
			stat.executeQuery();
	
			ResultSet rs = (ResultSet)stat.getObject(2);
			
			while (rs.next()) {
				System.out.printf(
						   "┍━━━━━━━┐\n"
						+ "│┻┻┻┻┻┻┻│▶ 아이디 : %s\n"
						+ "│    ⌒        ⌒    │▶ 이름 : %s\n"
						+ " │      ◕           ◕      │ ▶ 주민번호(뒷자리) :%s\n"
						+ " │             ‿              │ ▶ 휴대전화 :%s\n"
						+ "└───────┘\n"
						  , rs.getString("T_ID")
						  , rs.getString("name")
						  , rs.getString("ssn")
						  , rs.getString("phone_number"));
	
				
						
			}
			rs.close();
			stat.close();
			
		} catch (Exception e) {
			System.out.println("오류 TeacherManagerDAO.teacherListOne : " + e.toString());
		}
	}
	
	
	
	
	
	
	//담당용) 교사 전체 정보 출력
	public void teacherListMy(String m_id) {
		CallableStatement stat = null;
		
		try {	
			stat = conn.prepareCall(ds.get("teacherManage.teacherListMy"));
			stat.setString(1, m_id);
			stat.registerOutParameter(2, OracleTypes.CURSOR);
			stat.executeQuery();
	
			ResultSet rs = (ResultSet)stat.getObject(2);
			System.out.println("\t\t\t\t\t\t"+"\t\t\t\t[ID]"
					+ "\t\t\t[이름]\t\t\t"
					+ "[주민번호(뒷자리)]\t\t\t[전화번호]");
			mainView.onesinglebar();
			
			
			while (rs.next()) {
				System.out.printf("\t\t\t\t\t\t\t\t\t\t"+"%s\t\t\t%s\t\t\t\t%s\t\t\t  %s\t\n"
						  , rs.getString("T_ID")
						  , rs.getString("name")
						  , rs.getString("ssn")
						  , rs.getString("phone_number"));
	
				
						
			}
			rs.close();
			stat.close();
			
		} catch (Exception e) {
			System.out.println("오류 TeacherManagerDAO.teacherListMy : " + e.toString());
		}
	}

	
	
	
	//교사 개설과정 출력 (없을때 담당과정 없습니다 로 찍어줄거)
	public int teacherOpenCoursePrint(TblTeacherDTO dto) {
		CallableStatement stat = null;
		int a = 1;
		try {	
			stat = conn.prepareCall(ds.get("teacherManage.teacherOpenCourse"));
			stat.setString(1, dto.getT_id());
			stat.registerOutParameter(2, OracleTypes.CURSOR);
			stat.executeQuery();

			ResultSet rs = (ResultSet)stat.getObject(2);
            if(rs.next() == false) {
            	a = 0;
            }

		} catch (Exception e) {
			System.out.println("오류 TeacherManagerDAO.teacherOpenCourse : " + e.toString());
		}
		
		
	return a;
	}
	//교사 개설과정 출력(목록 보여주기) 
	public void teacherOpenCourse(TblTeacherDTO dto) {
		CallableStatement stat = null;
		try {	
			stat = conn.prepareCall(ds.get("teacherManage.teacherOpenCourse"));
			stat.setString(1, dto.getT_id());
			stat.registerOutParameter(2, OracleTypes.CURSOR);
			stat.executeQuery();

			ResultSet rs = (ResultSet)stat.getObject(2);
			
			mainView.onesinglebar();
			System.out.println("\t\t     ♣ 개설과정♣");
			mainView.onesinglebar();
			System.out.println("[과정명]"
					+ "\t\t\t\t\t\t\t[기간]\t\t\t"
					+ "\t\t\t[강의실]\t\t[강의현황]");
			mainView.onesinglebar();
			
			while (rs.next()) {
				System.out.printf(
			"%s\t\t%s\t\t%s\t\t   %s\n"
						  , rs.getString(1)
						 
						  , rs.getString(3) + " ~ "+ rs.getString(4)
						  , rs.getString(2)
						  , rs.getString(5));
						
						
			}
				rs.close();
				stat.close();
		} catch (Exception e) {
			System.out.println("오류 TeacherManagerDAO.teacherOpenCourse : " + e.toString());
		}
	}
	
	
	//교사 강의가능과목 (없을때 없다고 찍어주는)
	public int teacherAvaSubjectPrint(TblTeacherDTO dto) {
		CallableStatement stat = null;
		int a = 1;
		try {	
			stat = conn.prepareCall(ds.get("teacherManage.teacherAvaSubject"));
			stat.setString(1, dto.getT_id());
			stat.registerOutParameter(2, OracleTypes.CURSOR);
			stat.executeQuery();
	
			ResultSet rs = (ResultSet)stat.getObject(2);
            if(rs.next() == false) {
            	a = 0;
            }
			
            rs.close();
			stat.close();
            
		} catch (Exception e) {
			System.out.println("오류 TeacherManagerDAO.teacherAvaSubject : " + e.toString());
		}
		
		
		return a;
	}
	
	//교사 강의가능과목 출력
	public void teacherAvaSubject(TblTeacherDTO dto) {
		CallableStatement stat = null;
		
		try {	
			stat = conn.prepareCall(ds.get("teacherManage.teacherAvaSubject"));
			stat.setString(1, dto.getT_id());
			stat.registerOutParameter(2, OracleTypes.CURSOR);
			stat.executeQuery();
	
			ResultSet rs = (ResultSet)stat.getObject(2);
			mainView.onesinglebar();
			System.out.println("\t\t  ♣ 강의가능과목 ♣");
			mainView.onesinglebar();
			System.out.println("\t\t[번호]\t\t[과목명]");
			mainView.onesinglebar();
			
			while (rs.next()) {
				System.out.printf("\t\t%s\t\t\t%s\t\n"
						  , rs.getString(1)
						  , rs.getString(2));
						
			}
			rs.close();
			stat.close();
			
		} catch (Exception e) {
			System.out.println("오류 TeacherManagerDAO.teacherAvaSubject : " + e.toString());
		}
	}
	
	
	
	//교사 개설과목 
	public void teacherOpenSubject(TblTeacherDTO dto) {
		CallableStatement stat = null;
		
		try {	
			stat = conn.prepareCall(ds.get("teacherManage.teacherOpenSubject"));
			stat.setString(1, dto.getT_id());
			stat.registerOutParameter(2, OracleTypes.CURSOR);
			stat.executeQuery();
	
			ResultSet rs = (ResultSet)stat.getObject(2);
			mainView.onesinglebar();
			System.out.println("\t\t  ♣ 개설과목정보 ♣");
			mainView.onesinglebar();
			System.out.println("\t\t[과정명]\t\t[과목명]\t\t[교재명]\t\t[강의현황]");
			mainView.onesinglebar();
			
			
			while (rs.next()) {
				System.out.printf("%s\t\t%s\t\t%s\t\t%s\t\t\n"
						  , rs.getString("과정명")
						  , rs.getString("과목명")
						  , rs.getString("교재명")
						  , rs.getString("상태"));
				
						
			}
			rs.close();
			stat.close();
			
		} catch (Exception e) {
			System.out.println("오류 TeacherManagerDAO.teacherOpenSubject: " + e.toString());
		}
	}
	
	//교사 개설과목 출력 존재하는지
	public int teacherOpenSubjectPrint(TblTeacherDTO dto) {
		CallableStatement stat = null;
		int a = 1;
		try {	
			stat = conn.prepareCall(ds.get("teacherManage.teacherOpenSubject"));
			stat.setString(1, dto.getT_id());
			stat.registerOutParameter(2, OracleTypes.CURSOR);
			stat.executeQuery();
	
			
			ResultSet rs = (ResultSet)stat.getObject(2);
	
            if(rs.next() == false) {
            	a = 0;
            }
			
		} catch (Exception e) {
			System.out.println("오류 TeacherManagerDAO.teacherOpenSubject: " + e.toString());
		}
		return a;
	}
	
	
	
	
	
	//전체용)제대로 입력했는지 확인용
	public int check(TblTeacherDTO dto) throws SQLException {
		CallableStatement stat = null;
		
		try {	
			stat = conn.prepareCall(ds.get("teacherManage.check"));
			stat.setString(1, dto.getT_id());
			stat.registerOutParameter(2, OracleTypes.INTEGER);
			stat.executeQuery();
	
		} catch (Exception e) {
			System.out.println("오류 TeacherManagerDAO.check : " + e.toString());
		}
		return stat.getInt(2);
	}
	
	//담당용)제대로 입력했는지 확인용
	public int checkMy(TblTeacherDTO dto, String m_id) throws SQLException {
		CallableStatement stat = null;
		
		try {	
			stat = conn.prepareCall(ds.get("teacherManage.checkMy"));
			stat.setString(1, m_id);
			stat.setString(2, dto.getT_id());
			stat.registerOutParameter(3, OracleTypes.INTEGER);
			stat.executeQuery();
	
		} catch (Exception e) {
			System.out.println("오류 TeacherManagerDAO.checkMy : " + e.toString());
		}
		return stat.getInt(3);
	}

//=========================================등록하기================================================
	
	//기존에 같은 교사 있는지 확인하기

	public int teacherAddCheck(TblTeacherDTO dto) throws SQLException {
		CallableStatement stat = null;
		
		try {	
			stat = conn.prepareCall(ds.get("teacherManage.teacherAddCheck"));
			stat.setString(1, dto.getSsn());
			stat.registerOutParameter(2, OracleTypes.INTEGER);
			stat.executeQuery();
	
		} catch (Exception e) {
			System.out.println("오류 TeacherManagerDAO.teacherAddCheck : " + e.toString());
		}
		return stat.getInt(2);
	}


	//교사 추가하기 
	public void teacherAdd(TblTeacherDTO dto) {
		CallableStatement stat = null;
		
		try {	
			stat = conn.prepareCall(ds.get("teacherManage.teacherAdd"));
			stat.setString(1, dto.getSsn());
			stat.setString(2, dto.getName());
			stat.setString(3, dto.getPhone_number());
	
			stat.executeQuery();
	
		} catch (Exception e) {
			System.out.println("오류 TeacherManagerDAO.teacherAdd : " + e.toString());
		}
	}
	
	
	
	//강의가능과목 등록하기

	public int teacherAvaSubjectAdd(TblTeacherDTO dto, TblAvaSubjectDTO adto) throws SQLException {
		CallableStatement stat = null;
		
		try {	
			stat = conn.prepareCall(ds.get("teacherManage.avaSubAdd"));
			stat.setString(1, dto.getT_id());
			stat.setString(2, adto.getSub_seq());
			stat.registerOutParameter(3, OracleTypes.INTEGER);
			stat.executeQuery();
	
		} catch (Exception e) {
			System.out.println("오류 TeacherManagerDAO.avaSubAdd : " + e.toString());
		}
		return stat.getInt(3);
	}
	
	
	//==============================================삭제하기==========================================================
	//교사 삭제하기
	public void teacherDel(TblTeacherDTO dto) {
		CallableStatement stat = null;
		
		try {	
			stat = conn.prepareCall(ds.get("teacherManage.teacherDel"));
			stat.setString(1, dto.getT_id());
			stat.executeQuery();
	
		} catch (Exception e) {
			System.out.println("오류 TeacherManagerDAO.teacherDel : " + e.toString());
		}
	}
	
	
	//삭제해도 되는 교사인지 확인
	public int teacherDelAva(TblTeacherDTO dto) throws SQLException {
		CallableStatement stat = null;
		
		try {	
			stat = conn.prepareCall(ds.get("teacherManage.teacherDelAva"));
			stat.setString(1, dto.getT_id());
			stat.registerOutParameter(2, OracleTypes.INTEGER);
			stat.executeQuery();
	
		} catch (Exception e) {
			System.out.println("오류 TeacherManagerDAO.teacherDelAva : " + e.toString());
		}
		return stat.getInt(2);
	}
	
	//강의가능과목 삭제하기
	public int teacherAvaSubjectDel(TblTeacherDTO dto, TblAvaSubjectDTO adto) throws SQLException {
		CallableStatement stat = null;
		
		try {	
			stat = conn.prepareCall(ds.get("teacherManage.avaSubDel"));
			stat.setString(1, dto.getT_id());
			stat.setString(2, adto.getAva_sub_seq());
			stat.registerOutParameter(3, OracleTypes.INTEGER);
			
			stat.executeQuery();
	
		} catch (Exception e) {
			System.out.println("오류 TeacherManagerDAO.avaSubDel : " + e.toString());
		}
		
		return stat.getInt(3);
		}
	
	
	
	
//	=========================================수정하기=====================================================
	//교사정보 수정하기
	public void teacherEdit(TblTeacherDTO dto) throws SQLException {
		CallableStatement stat = null;
		CallableStatement stat2 = null;
		try {	

			stat = conn.prepareCall(ds.get("teacherManage.teacherEditOriginal"));
			stat.setString(1, dto.getT_id());
			stat.registerOutParameter(2, OracleTypes.CURSOR);
			stat.executeQuery();
			
			ResultSet rs = (ResultSet)stat.getObject(2);
			
		while(rs.next()) {
	            if(dto.getName().equals("")) {
	            	dto.setName(rs.getString(1));
	            }
	            if(dto.getPhone_number().equals("")) {
	            	dto.setPhone_number(rs.getString(2));
	            }
	            if(dto.getPassword().equals("")) {
	            	dto.setPassword(rs.getString(3));
	            }
		}
		
		rs.close();
		stat.close();
    
		
		
            stat2 = conn.prepareCall(ds.get("teacherManage.teacherEdit"));
            stat2.setString(1, dto.getName());
            stat2.setString(2, dto.getPhone_number());
            stat2.setString(3, dto.getPassword());
            stat2.setString(4, dto.getT_id());
            stat2.executeQuery();
           
		} catch (Exception e) {
			System.out.println("오류 TeacherManagerDAO.teacherEdit : " + e.toString());
		}
	}


//강의가능과목 수정하기
	public int teacherAvaSubjectEdit(TblTeacherDTO dto, TblAvaSubjectDTO adto) throws SQLException {
		CallableStatement stat = null;
		
		try {	
			stat = conn.prepareCall(ds.get("teacherManage.avaSubEdit"));
			stat.setString(1, dto.getT_id());
			stat.setString(2, adto.getSub_seq());
			stat.setString(3, adto.getAva_sub_seq());
			stat.registerOutParameter(4, OracleTypes.INTEGER);
			
			stat.executeQuery();
	
		} catch (Exception e) {
			System.out.println("오류 TeacherManagerDAO.avaSubEdit : " + e.toString());
		}
		
		return stat.getInt(4);
	}



	
}
