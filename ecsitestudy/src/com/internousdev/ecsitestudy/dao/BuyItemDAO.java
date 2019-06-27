package com.internousdev.ecsitestudy.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.internousdev.ecsitestudy.dto.BuyItemDTO;
import com.internousdev.ecsitestudy.util.DBConnector;

public class BuyItemDAO {
	public BuyItemDTO getBuyItemInfo(){
		DBConnector db=new DBConnector();
		Connection con=db.getConnection();
		BuyItemDTO buyItemDTO=new BuyItemDTO();

		String sql="select product_name,product_name_kana,price from product_info";
		try{
			PreparedStatement ps=con.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				buyItemDTO.setPName(rs.getString("product_name"));
				buyItemDTO.setPNamekana(rs.getString("product_name_kana"));
				buyItemDTO.setPrice(rs.getInt("price"));

			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return buyItemDTO;
	}

}
