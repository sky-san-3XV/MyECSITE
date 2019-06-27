package com.internousdev.ecsitestudy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.ecsitestudy.dto.MyPageDTO;
import com.internousdev.ecsitestudy.util.DBConnector;


public class MyPageDAO {


	public ArrayList<MyPageDTO> getHist(String userid) throws SQLException{

		ArrayList<MyPageDTO> hist=new ArrayList<MyPageDTO>();
		DBConnector db=new DBConnector();
		Connection con=db.getConnection();

		String sql="select pi.product_name,pi.product_name_kana,pi.image_file_path,pi.release_company,pi.release_date,pi.price,ph.product_count from product_info pi left join purchase_history_info ph on pi.product_id=ph.product_id where ph.user_id=?";

		try{
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, userid);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				MyPageDTO dto=new MyPageDTO();
				dto.setProduct_name(rs.getString("product_name"));
				dto.setProduct_name_kana(rs.getString("product_name_kana"));
				dto.setImage_file_path(rs.getString("image_file_path"));
				dto.setRelease_company(rs.getString("release_company"));
				dto.setRelease_date(rs.getString("release_date"));
				dto.setPrice(rs.getInt("price"));
				dto.setProduct_count(rs.getInt("product_count"));
				int p=dto.getPrice();
				int pc=dto.getProduct_count();
				dto.setGoukei(p*pc);
				hist.add(dto);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			con.close();
		}
         return hist;
		}

	public void Deletehist(String userid) throws SQLException{

		DBConnector db=new DBConnector();
		Connection con=db.getConnection();
		String sql="delete from purchase_history_info where user_id=?";

		try{
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, userid);
			ps.execute();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			con.close();
		}

	}


	}


