package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.ecsite.util.DBConnector;
import com.internousdev.ecsite.util.DateUtil;


public class UserCreateCompleteDAO {

	private DateUtil DU=new DateUtil();
	private String sql
	="insert into login_user_transaction (login_id,login_pass,user_name,insert_date) values(?,?,?,?)";
    public void createUser(String loginUserId,String loginPassword,String userName)
     throws SQLException{
    	DBConnector db=new DBConnector();
    	Connection con=db.getConnection();
    	PreparedStatement ps=con.prepareStatement(sql);
    	try{
    	ps.setString(1, loginUserId);
    	ps.setString(2, loginPassword);
    	ps.setString(3, userName);
    	ps.setString(4,DU. getDate());
    	ps.execute();
    }catch(SQLException e){
    	e.printStackTrace();
    }finally{
    	con.close();
    }
}

}
