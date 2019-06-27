package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.internousdev.ecsite.dto.CheckSameIDDTO;
import com.internousdev.ecsite.util.DBConnector;


public class CheckSameIDDAO {
	public CheckSameIDDTO CheckSameID(String loginUserId) throws SQLException{
	DBConnector db=new DBConnector();
	Connection con=db.getConnection();
    CheckSameIDDTO CDTO=new CheckSameIDDTO();


	String sql="select count(*) from login_user_transaction where login_id=?";

	try{
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setString(1, loginUserId);
		ResultSet rs=ps.executeQuery();
		if(rs.next()){
			int count=rs.getInt("count(*)");

			if(count!=0){
				CDTO.setCheckID(false);

			}
		}



	}catch(SQLException e){
		e.printStackTrace();
	}finally{
		con.close();
	}
	return CDTO;
	}
}




