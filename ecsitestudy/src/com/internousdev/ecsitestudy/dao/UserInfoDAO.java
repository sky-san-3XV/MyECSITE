package com.internousdev.ecsitestudy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.internousdev.ecsitestudy.dto.UserInfoDTO;
import com.internousdev.ecsitestudy.util.DBConnector;
import com.internousdev.ecsitestudy.util.DateUtil;

public class UserInfoDAO {


	public UserInfoDTO getLogin(String loginUserId,String loginPassword) throws SQLException{

		DBConnector DB=new DBConnector();
		Connection con=DB.getConnection();
	    UserInfoDTO dto=new UserInfoDTO();
		String sql="select * from user_info where user_id = ? and password = ?";

		try{
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, loginUserId);
			ps.setString(2, loginPassword);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				dto.setLoginUserId(rs.getString("user_id"));
				dto.setLoginPassword(rs.getString("password"));

				if(!((rs.getString("user_id")).equals(null))){
					dto.setLoginFig(true);
					dto.setLogined(1);
				}
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			con.close();
		}
		return dto;
	}

	public int CreateUser(String userId,String password,String family,String first,String familyk,String firstk,String sex,String email) throws SQLException{


		DateUtil DU=new DateUtil();


		DBConnector db=new DBConnector();
		Connection CON=db.getConnection();
		int i=0;

		String SQLL="insert into user_info (user_id,password,family_name,first_name,family_name_kana,first_name_kana,sex,email,regist_date) values(?,?,?,?,?,?,?,?,?) ";

		try{
			PreparedStatement PS=CON.prepareStatement(SQLL);
			PS.setString(1, userId);
			PS.setString(2, password);
			PS.setString(3, family);
			PS.setString(4, first);
			PS.setString(5, familyk);
			PS.setString(6, firstk);
			PS.setString(7, sex);
			PS.setString(8, email);
			PS.setString(9, DU.getDate());
			i=PS.executeUpdate();

		}catch(SQLException e){
			e.printStackTrace();

		}finally{
			CON.close();
		}
		return i;

	}

	public boolean CheckSameID(String userId) throws SQLException{
	     DBConnector db=new DBConnector();
		Connection con=db.getConnection();
		boolean result=true;

		String sql="select * from user_info where user_id=?";
		try{
			 PreparedStatement ps=con.prepareStatement(sql);
			 ps.setString(1, userId);
			 ResultSet rs=ps.executeQuery();
			 if(rs.next()){
				 String CHK=rs.getString("user_id");
				 if(CHK!=null){
					 result=false;
				 }
			 }

		}catch(SQLException e){
			e.printStackTrace();
			result=false;

		}finally{
			con.close();
		}
		return result;

	}




	public boolean LoginStat(int stat,String userId) throws SQLException{
		boolean result=false;
		DBConnector db=new DBConnector();
		Connection con=db.getConnection();
		UserInfoDTO dto=new UserInfoDTO();
		String sql="update user_info set logined=? where user_id=?";
		try{
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1, stat);
			ps.setString(2, userId);
			ps.executeUpdate();
			result=true;

		if(stat==1){
			dto.setLogined(1);
		}
		else if(stat==0){
			dto.setLogined(0);
		}
		}catch(SQLException e){
			e.printStackTrace();
			result=false;
		}finally{
			con.close();
		}
		return result;

	}

	public int Resetpass(String loginPasswordnew,String loginUserId) throws SQLException{

		DBConnector db=new DBConnector();
		Connection con=db.getConnection();
		DateUtil DU=new DateUtil();

		int i=0;
		String SQL="update user_info set password= ? ,update_date= ? where user_id=?";
		try{
			PreparedStatement ps=con.prepareStatement(SQL);
			ps.setString(1, loginPasswordnew);
			ps.setString(2, DU.getDate());
			ps.setString(3, loginUserId);
			i=ps.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			con.close();
		}
		return i;
	}


	public UserInfoDTO getMyPage(String userid) throws SQLException{

		DBConnector db=new DBConnector();
		Connection con=db.getConnection();
		UserInfoDTO dto=new UserInfoDTO();

		String sql="select family_name,first_name,family_name_kana,first_name_kana,sex,email from user_info where user_id=?";

		try{
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, userid);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				dto.setFamily(rs.getString("family_name"));
				dto.setFirst(rs.getString("first_name"));
				dto.setFamilyk(rs.getString("family_name_kana"));
				dto.setFirstk(rs.getString("first_name_kana"));
				dto.setSex(rs.getInt("sex"));
				dto.setEmail(rs.getString("email"));
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			con.close();
		}
		return dto;

	}













}



