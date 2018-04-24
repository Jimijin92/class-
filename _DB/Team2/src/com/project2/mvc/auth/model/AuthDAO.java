package com.project2.mvc.auth.model;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.project2.mvc.auth.AuthClass;
import com.project2.mvc.model.DBUtil;
import com.project2.mvc.model.DataSource;

import oracle.jdbc.internal.OracleTypes;

public class AuthDAO {

   private Connection conn;
   private DataSource ds;
   
   
   public AuthDAO() {
      
      try {
         conn = DBUtil.open();
         ds = new DataSource();
         
      } catch (Exception e) {
         System.out.println("authdao, authdao" + e.toString());
      }
   }
   
   
   
   public String idCheck(AuthDTO dto) {
      
      try {
         
         CallableStatement stat = conn.prepareCall(ds.get("auth.login"));
         
         stat.setString(1,dto.getId());
         stat.setString(2,dto.getPw());
         stat.registerOutParameter(3, OracleTypes.VARCHAR);
         
         
         stat.executeQuery();
         
         String checkedId = stat.getString(3);
         
         if(checkedId.equals("rejected")) {
            String message = "rejected";
            return message;
         }
         
         
         return checkedId;
         
      } catch (Exception e) {
         
         System.out.println("AuthDAO, idCheck" + e.toString());
         return e.toString();
      }
      
   }
   
   
   
}