package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.ecsite.util.DBConnector;
import com.internousdev.ecsite.util.DateUtil;


public class ItemCreateCompleteDAO {

	private DateUtil DU=new DateUtil();

	private String sql
	="insert into item_info_transaction (item_name,item_price,item_stock,insert_date) values(?,?,?,?)";
    public void createItem(String itemName,String itemPrice,String itemStock)
     throws SQLException{
    	DBConnector db=new DBConnector();
    	Connection con=db.getConnection();
    	PreparedStatement ps=con.prepareStatement(sql);
    	try{
    	ps.setString(1, itemName);
    	ps.setString(2, itemPrice);
    	ps.setString(3, itemStock);
    	ps.setString(4,DU. getDate());
    	ps.execute();
    }catch(SQLException e){
    	e.printStackTrace();
    }finally{
    	con.close();
    }
}

}
