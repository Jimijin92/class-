package com.test.mvc.address;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


public class AddressDAO {

	private Connection conn;
	private PreparedStatement stat;
	
	public AddressDAO() {
			try {
		
				conn = DBUtil.open();
				
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	//AddOk 서블릿이 dto를 주면서 insert해달라고 요청(위임)
	public int add(AddressDTO dto) {
		
		try {
			String sql="insert into tblAddress(seq, name, age, gender, tel, address) values(address_seq.nextval,?,?,?,?,?)";
			
			stat = conn.prepareStatement(sql);
			
			stat.setString(1, dto.getName());
			stat.setString(2, dto.getAge());
			stat.setString(3, dto.getGender());
			stat.setString(4, dto.getTel());
			stat.setString(5, dto.getAddress());
			
			return stat.executeUpdate();//리턴값 1또는 0
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		//캐치에 걸렸을 때 -> 백프로 실패한거 -> 0
		return 0;
		
	}

	//List 서블릿이 목록 달라고...
	public ArrayList<AddressDTO> list() {
		
		try {
			
			String sql = "select * from tblAddress order by name asc";
			stat = conn.prepareStatement(sql);
			
			ResultSet rs = stat.executeQuery();
			
			ArrayList<AddressDTO> list = new ArrayList<AddressDTO>();
			
			//rs -> list 복사
			while(rs.next()) {
				AddressDTO dto = new AddressDTO();//꼭 이 안에 만들어야 함 , 밖에 만든거랑 전혀 다른 결과!
				
				dto.setSeq(rs.getString("seq"));
				dto.setName(rs.getString("name"));
				dto.setAge(rs.getString("age"));
				dto.setGender(rs.getString("gender"));
				dto.setTel(rs.getString("tel"));
				dto.setAddress(rs.getString("address"));
				
				list.add(dto);
			}
			
			return list;//컨트롤러에게 반환
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
		return null;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
