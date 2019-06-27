package com.internousdev.ecsitestudy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.ecsitestudy.dto.CategoryDTO;
import com.internousdev.ecsitestudy.util.DBConnector;

public class CategoryDAO {


	public ArrayList<CategoryDTO> getCat() throws SQLException{

		ArrayList<CategoryDTO> cat=new ArrayList<CategoryDTO>();
		DBConnector db=new DBConnector();
		Connection con=db.getConnection();

		String sql="select category_id,category_name from m_category";

		try{
			PreparedStatement ps=con.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();

			while(rs.next()){
				CategoryDTO dto=new CategoryDTO();
				dto.setId(rs.getInt("category_id"));
				dto.setCategory(rs.getString("category_name"));
				cat.add(dto);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			con.close();
		}

		return cat;

	}







}
