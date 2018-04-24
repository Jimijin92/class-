package com.project2.mvc.manager.model;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.project2.mvc.model.DBUtil;
import com.project2.mvc.model.DataSource;
import com.project2.mvc.model.TblClassRoomDTO;
import com.project2.mvc.model.TblCourseDTO;
import com.project2.mvc.model.TblManagerDTO;
import com.project2.mvc.model.TblOpenCourseDTO;
import com.project2.mvc.model.TblTeacherDTO;

import oracle.jdbc.internal.OracleTypes;

public class OpenCourseInfoDAO {


		private DataSource ds;
		private Connection conn;
		
		public OpenCourseInfoDAO() {
			try {
				ds = new DataSource();
				conn = DBUtil.open();
			} catch (Exception e) {
				System.out.println("BasicInfoDAO.Contructor" + e.toString());
			}
		}
		
		
		//(전체용)개설과정 출력
		public void openCourseList() {
			
			CallableStatement stat = null;
			
			try {	
				stat = conn.prepareCall(ds.get("openCourseInfo.openCourseList"));
				stat.registerOutParameter(1, OracleTypes.CURSOR);
				stat.executeQuery();
		
				ResultSet rs = (ResultSet)stat.getObject(1);
				
				while (rs.next()) {
					System.out.printf("%s\t%s\t%s\t%s\t%s\t%s\n"
							  , rs.getString("O_COU_SEQ")
							  , rs.getString("name")
							  , rs.getString("start_date")
							  , rs.getString("end_date")
							  , rs.getString("강의실")
							  , rs.getString("강의인원"));
							
							
				}
				rs.close();
				stat.close();
				
			} catch (Exception e) {
				System.out.println("오류 BasicInfoDAO.openCourseList : " + e.toString());
			}
		}//courseList() 
		
		
		//(전체용)특정 개설과정 제대로 선택했는지 확인용
		public int checkOpenCourseChoice(TblOpenCourseDTO dto) throws SQLException {
			
			CallableStatement stat = null;
			
			try {	
				stat = conn.prepareCall(ds.get("openCourseInfo.checkOpenCourseChoice"));
				stat.setString(1, dto.getO_cou_seq());
				stat.registerOutParameter(2, OracleTypes.INTEGER);
				stat.executeQuery();
		
			} catch (Exception e) {
				System.out.println("오류 BasicInfoDAO.checkOpenCourseChoice : " + e.toString());
			}
			return stat.getInt(2);
		}
			
		
		
		//(전체용)특정 개설과정 개설과목 출력
		public void openCourseSubjectList(TblOpenCourseDTO dto) throws SQLException {
			CallableStatement stat = null;
			
			try {	
				stat = conn.prepareCall(ds.get("openCourseInfo.openCourseSubjectList"));
				stat.setString(1, dto.getO_cou_seq());
				stat.registerOutParameter(2, OracleTypes.CURSOR);
				stat.executeQuery();
		
				ResultSet rs = (ResultSet)stat.getObject(2);
				
				while (rs.next()) {
					System.out.printf("%s\t\t %s\t %s\t %s\t %s\n"
							  , rs.getString(1)
							  , rs.getString(2)
							  , rs.getString(3)
							  , rs.getString(4)
							  , rs.getString(5));
							
				}
				rs.close();
				stat.close();
				
			} catch (Exception e) {
				System.out.println("오류 BasicInfoDAO.openSubjectList : " + e.toString());
			}
	
		}

		public void openCourseStudentList(TblOpenCourseDTO dto) {
			CallableStatement stat = null;
			
			try {	
				stat = conn.prepareCall(ds.get("openCourseInfo.openCourseStudentList"));
				stat.setString(1, dto.getO_cou_seq());
				stat.registerOutParameter(2, OracleTypes.CURSOR);
				stat.executeQuery();
		
				ResultSet rs = (ResultSet)stat.getObject(2);
				
				while (rs.next()) {
					System.out.printf("%s\t\t %s\t %s\t %s\t\n"
							  , rs.getString(1)
							  , rs.getString(2)
							  , rs.getString(3)
							  , rs.getString(4));
							
				}
				rs.close();
				stat.close();
				
			} catch (Exception e) {
				System.out.println("오류 BasicInfoDAO.openSubjectList : " + e.toString());
			}
			
		}

		
		//담당 전체출력
		public void openCourseListMy(String m_id) {
			CallableStatement stat = null;

			try {	
				stat = conn.prepareCall(ds.get("openCourseInfo.openCourseListMy"));
				stat.setString(1, m_id);
				stat.registerOutParameter(2, OracleTypes.CURSOR);
				stat.executeQuery();
		
				ResultSet rs = (ResultSet)stat.getObject(2);
				
				
			
				while (rs.next()) {
					System.out.printf("%s\t%s\t%s\t%s\t%s\t%s\n"
							  , rs.getString("O_COU_SEQ")
							  , rs.getString("과정명")
							  , rs.getString("시작일자")
							  , rs.getString("종료일자")
							  , rs.getString("강의실")
							  , rs.getString("수강인원"));
				}
				rs.close();
				stat.close();
			
			} catch (Exception e) {
				System.out.println("오류 BasicInfoDAO.openCourseListMy : " + e.toString());
			}
	
		
			
		}//openCourseListMy

		
		
		
		
		public int openCourseListMyCheck(String m_id) {
			CallableStatement stat = null;
			int a = 1;
			try {	
				stat = conn.prepareCall(ds.get("openCourseInfo.openCourseListMy"));
				stat.setString(1, m_id);
				stat.registerOutParameter(2, OracleTypes.CURSOR);
				stat.executeQuery();
		
				ResultSet rs = (ResultSet)stat.getObject(2);
				
					if(rs.next() == false) {
							a = 0;
					}
					
			rs.close();
			stat.close();
				
			} catch (Exception e) {
				System.out.println("오류 BasicInfoDAO.openCourseListMyCheck : " + e.toString());
			}
			return a;
			
		}//openCourseListMy
		
		
		
		//담당) 제대로 과정번호입력했는지 확인용
		public int checkOpenCourseChoiceMy(TblOpenCourseDTO dto, String m_id) throws SQLException {
			CallableStatement stat = null;
			
			try {	
				stat = conn.prepareCall(ds.get("openCourseInfo.checkOpenCourseChoiceMy"));
				stat.setString(1, m_id);
				stat.setString(2, dto.getO_cou_seq());
				stat.registerOutParameter(3, OracleTypes.INTEGER);
				stat.executeQuery();
		
			} catch (Exception e) {
				System.out.println("오류 BasicInfoDAO.checkOpenCourseChoiceMy : " + e.toString());
			}
			return stat.getInt(3);
		}


		
		//개설과정 등록
		public void openCourseAdd(TblOpenCourseDTO dto, String m_id) throws SQLException {
			CallableStatement stat = null;
			
			try {	
				stat = conn.prepareCall(ds.get("openCourseInfo.openCourseAdd"));
				stat.setString(1, dto.getStart_date());
				stat.setString(2, dto.getEnd_date());
				stat.setString(3, dto.getCl_seq());
				stat.setString(4, dto.getCou_seq());
				stat.setString(5, m_id);
				stat.setString(6, dto.getT_id());
				stat.executeQuery();
		
			} catch (Exception e) {
				System.out.println("오류 BasicInfoDAO.openCourseAdd: " + e.toString());
			}
		}
		

		//사용가능한 강의실 내에서 선택했는지 확인용
		public int avaClassRoomCheck(TblOpenCourseDTO dto) throws SQLException {
			CallableStatement stat = null;
			
			try {	
				stat = conn.prepareCall(ds.get("openCourseInfo.avaClassRoomCheck"));
				stat.setString(1, dto.getCl_seq());
				stat.setString(2, dto.getStart_date());
				stat.setString(3, dto.getO_cou_seq());
				stat.registerOutParameter(4, OracleTypes.INTEGER);
				stat.executeQuery();
		
			} catch (Exception e) {
				System.out.println("오류 BasicInfoDAO.avaClassRoomCheck : " + e.toString());
			}
			return stat.getInt(4);
		}

		
		//과정주면 기간만 돌려받기 
//		public TblOpenCourseDTO returnPeriod(TblOpenCourseDTO dto) throws SQLException {
//			
//			
//			C
//					
//			
//							//  return odto;
//				}
//			} catch (Exception e) {
//				System.out.println("오류 BasicInfoDAO.returnPeriod : " + e.toString());
//			}
//			return odto;
//	
//		}
//		
		
		
		
		
		//사용가능한 강의실 출력
		public void avaClassRoom(TblOpenCourseDTO dto) {

			CallableStatement stat2 = null;
			CallableStatement stat = null;
			
			try {	
				
				stat2 = conn.prepareCall(ds.get("openCourseInfo.returnPeriod"));
				stat2.setString(1, dto.getO_cou_seq());
				stat2.registerOutParameter(2, OracleTypes.CURSOR);
				stat2.executeQuery();
		
				ResultSet rs2 = (ResultSet)stat2.getObject(2);
				
				while (rs2.next()) {
							  dto.setStart_date(rs2.getString(1));//시작일자
							  dto.setEnd_date(rs2.getString(2));//종료일자
			
				}
				System.out.println(dto.getStart_date());
				
				
				stat = conn.prepareCall(ds.get("openCourseInfo.avaClassRoom"));
				stat.setString(1, "2018-01-01");
				stat.setString(2, "2019-02-02");
				stat.registerOutParameter(3, OracleTypes.CURSOR);
				stat.executeQuery();
		
				
				
				ResultSet rs = (ResultSet)stat.getObject(3);
				
				while (rs.next()) {
					System.out.printf("%s\n"
							  , rs.getString(1));//강의실번호
							
					
				}
				
				} catch (Exception e) {
				System.out.println("오류 BasicInfoDAO.avaClassRoom : " + e.toString());
			}
		}
		
		
		
			
			
			
			
			
			
			
			
			
			
		//과정 제대로 선택했는지 확인
		public int courseChoiceCheck(TblOpenCourseDTO dto) throws SQLException {
			
			
			CallableStatement stat = null;
			
			try {	
				stat = conn.prepareCall(ds.get("openCourseInfo.courseChoiceCheck"));
				stat.setString(1,dto.getCou_seq());
				stat.registerOutParameter(2, OracleTypes.INTEGER);
				stat.executeQuery();
		
			} catch (Exception e) {
				System.out.println("오류 BasicInfoDAO.courseChoiceCheck : " + e.toString());
			}

			return stat.getInt(2);
		}

		
		
		
		
		//선택가능한 선생님 출력
				public void avaTeacher(TblOpenCourseDTO dto) {
					CallableStatement stat = null;
					
					try {	
						stat = conn.prepareCall(ds.get("openCourseInfo.avaTeacher"));
						stat.setString(1, dto.getStart_date());
						stat.setString(2, dto.getEnd_date());
						stat.registerOutParameter(3, OracleTypes.CURSOR);
						stat.executeQuery();

						ResultSet rs = (ResultSet)stat.getObject(3);
						
						while (rs.next()) {
							System.out.printf("%s\t\t%s\t\n"
									  , rs.getString(1)//교사번호
									  , rs.getString(2));//교사이름
									
						}
						
					} catch (Exception e) {
						System.out.println("오류 BasicInfoDAO.avaTeacher : " + e.toString());
					}
				}
			
				
				
				
		//선생님 제대로 선택했는지 확인
				public int avaTeacherCheck(TblOpenCourseDTO dto) throws SQLException {
					CallableStatement stat = null;
					
					try {	
						stat = conn.prepareCall(ds.get("openCourseInfo.avaTeacherCheck"));
						stat.setString(1, dto.getT_id());
						stat.setString(2, dto.getStart_date());
						stat.setString(3, dto.getEnd_date());
						stat.registerOutParameter(4, OracleTypes.INTEGER);
						stat.executeQuery();
				
					} catch (Exception e) {
						System.out.println("오류 BasicInfoDAO.avaTeacherCheck : " + e.toString());
					}
					return stat.getInt(4);
				}




				//개설과정 삭제
				public int openCourseDel(TblOpenCourseDTO dto, String m_id) throws SQLException {
					CallableStatement stat = null;
					
					try {	
						stat = conn.prepareCall(ds.get("openCourseInfo.openCourseDel"));
						stat.setString(1, m_id);
						stat.setString(2, dto.getO_cou_seq());
						stat.registerOutParameter(3, OracleTypes.INTEGER);
						stat.executeQuery();
				
					} catch (Exception e) {
						System.out.println("오류 BasicInfoDAO.openCourseDel : " + e.toString());
					}
					return stat.getInt(3);
				}

				
			
				
				
			//개설과정 수정(강의실 수정)
				
				
				public void openCourseClEdit(TblOpenCourseDTO dto) throws SQLException {
					CallableStatement stat = null;
					
					try {	
						stat = conn.prepareCall(ds.get("openCourseInfo.openCourseClEdit"));
						stat.setString(1, dto.getO_cou_seq());
						stat.setString(2, dto.getCl_seq());
						
						stat.executeQuery();
				
					} catch (Exception e) {
						System.out.println("오류 BasicInfoDAO.openCourseClEdit : " + e.toString());
					}
				
				}

				
				
				
				
				
				
}


		

