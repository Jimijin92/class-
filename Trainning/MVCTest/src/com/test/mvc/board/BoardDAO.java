package com.test.mvc.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.test.mvc.address.DBUtil;

public class BoardDAO {
	
	private Connection conn;
	private PreparedStatement stat;
	
	public BoardDAO() {
		try {
			conn = DBUtil.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//AddOk 서블릿이 dto를 줄테니 글써달라고 요청
	public int add(BoardDTO dto) {
		
		try {
			
			String sql = "insert into tblBoard (seq, subject, content, id, regdate, readcount, tag) values (board_seq.nextval, ?, ?, ?, default, default, ?)";
			
			stat = conn.prepareStatement(sql);
			
			stat.setString(1, dto.getSubject());
			stat.setString(2, dto.getContent());
			stat.setString(3, dto.getId());
			stat.setString(4, dto.getTag());
			
			return stat.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return 0;
	}
	
	//List 서블릿이 목록주세요.. 위임//25번
	public ArrayList<BoardDTO> list() {
		
		try {
			String sql="select seq, subject, id, (select name from tblMember where id = b.id) as name, regdate, readcount, round((sysdate - regdate)*24*60) as gap from tblBoard b order by seq desc";
			
			stat = conn.prepareStatement(sql);
			
			ResultSet rs = stat.executeQuery();
			
			//rs -> list
			ArrayList<BoardDTO> list = new ArrayList<BoardDTO>();
			
			while(rs.next()) {
				//레코드 1개 -> DTO 1개
				BoardDTO dto = new BoardDTO();
				
				dto.setSeq(rs.getString("seq"));
				dto.setSubject(rs.getString("subject"));
				dto.setId(rs.getString("id"));
				dto.setName(rs.getString("name"));//subquery alias
				dto.setRegdate(rs.getString("regdate"));
				dto.setReadcount(rs.getInt("readcount"));
				dto.setGap(rs.getInt("gap"));
				
				list.add(dto);
			}
			
			return list;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

	//View 서블릿이 글번호를 줄테니 레코드(DTO)를 주세요...
	public BoardDTO get(String seq) {
		try {
			
			String sql = "select b.*, (select name from tblMember where id = b.id) as name from tblBoard b where seq=?";
			stat = conn.prepareStatement(sql);
			stat.setString(1, seq);
			
			ResultSet rs = stat.executeQuery();
			
			//rs -> dto
			BoardDTO dto = new BoardDTO();
			
			if(rs.next()) {
				//레코드 1건 -> dto 1개
				dto.setSeq(rs.getString("seq"));
				dto.setSubject(rs.getString("subject"));
				dto.setContent(rs.getString("content"));
				dto.setId(rs.getString("id"));
				dto.setName(rs.getString("name"));
				dto.setRegdate(rs.getString("regdate"));
				dto.setReadcount(rs.getInt("readcount"));
				dto.setTag(rs.getString("tag"));
			}
			
			return dto;
			
			
		} catch (Exception e) {
			System.out.println("BoardDAO.get" + e.toString());
		}
		return null;
	}

	//View 서블릿이 글번호를 줄테니 조회수 + 1 요청
	public void updateReadCount(String seq) {
		try {
			String sql="update tblBoard set readcount = readcount + 1 where seq = ?";
			
			stat = conn.prepareStatement(sql);
			stat.setString(1, seq);
			
			stat.executeUpdate();
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	//EditOk 서블릿이 dto를 줄테니 수정해주세요...
	//add() 메소드 복사
	public int edit(BoardDTO dto) {
		
		try {
			
			String sql = "update tblBoard set subject = ?, content = ?, tag = ? where seq=?";
			
			stat = conn.prepareStatement(sql);
			
			stat.setString(1, dto.getSubject());
			stat.setString(2, dto.getContent());
			stat.setString(3, dto.getTag());
			stat.setString(4, dto.getSeq());
			
			return stat.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return 0;
	}

	//DAO안에서 권한체크 하지 말것 
	//DelOk 서블릿이 글번호를 줄테니 삭제해주세요..
	public int del(String seq) {
		
		try {
			
			String sql = "delete from tblBoard where seq=?";
			
			stat = conn.prepareStatement(sql);

			stat.setString(1, seq);
			
			return stat.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return 0;
	}

}