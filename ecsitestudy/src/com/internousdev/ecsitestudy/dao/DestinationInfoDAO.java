package com.internousdev.ecsitestudy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.ecsitestudy.dto.DestinationInfoDTO;
import com.internousdev.ecsitestudy.util.DBConnector;
import com.internousdev.ecsitestudy.util.DateUtil;

public class DestinationInfoDAO {

	public ArrayList<DestinationInfoDTO> getDest (String userid) throws SQLException{

		DBConnector db=new DBConnector();
		Connection con=db.getConnection();
		ArrayList<DestinationInfoDTO> DI=new ArrayList<DestinationInfoDTO>();
		String sql="select id,family_name,family_name_kana,first_name,first_name_kana,tel_number,user_address,email from destination_info where user_id=?";

		try{
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, userid);
			ResultSet rs=ps.executeQuery();

			while(rs.next()){
				DestinationInfoDTO dto=new DestinationInfoDTO();
				dto.setId(rs.getString("id"));
				dto.setFaname(rs.getString("family_name"));
				dto.setFanamek(rs.getString("family_name_kana"));
				dto.setFanamek(rs.getString("family_name_kana"));
				dto.setFiname(rs.getString("first_name"));
				dto.setFinamek(rs.getString("first_name_kana"));
				dto.setTelnum(rs.getString("tel_number"));
				dto.setAddress(rs.getString("user_address"));
				dto.setEmail(rs.getString("email"));
				DI.add(dto);
			}

			}catch(SQLException e){
				e.printStackTrace();
			}finally{
				con.close();
			}


		return DI;

		}



	public int setDest(String faname,String fanamek,String finame,String finamek,String email,String telnum,String address,String userid) throws SQLException{

		DateUtil DU=new DateUtil();
		DBConnector db=new DBConnector();
		Connection con=db.getConnection();
		int result=0;

		String sql="insert into destination_info(family_name,family_name_kana,first_name,first_name_kana,email,tel_number,user_address,regist_date,user_id) values(?,?,?,?,?,?,?,?,?)";
		try{
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, faname);
			ps.setString(2, fanamek);
			ps.setString(3,finame);
			ps.setString(4,finamek);
			ps.setString(5, email);
			ps.setString(6, telnum);
			ps.setString(7, address);
			ps.setString(8,DU.getDate());
			ps.setString(9, userid);

			result=ps.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			con.close();
		}

		return result;
	}



	public void DeleteDet(String id) throws SQLException{
		DBConnector db=new DBConnector();
		Connection con=db.getConnection();

	    String sql="delete from destination_info where id=?";

	    try{
	    	PreparedStatement ps=con.prepareStatement(sql);
	    	ps.setString(1, id);
	    	ps.execute();
	    }catch(SQLException e){
	    	e.printStackTrace();
	    }finally{
	    	con.close();
	    }
	}






}





