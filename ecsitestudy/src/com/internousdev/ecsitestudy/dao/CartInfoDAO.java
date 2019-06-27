package com.internousdev.ecsitestudy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.internousdev.ecsitestudy.dto.CartInfoDTO;
import com.internousdev.ecsitestudy.util.DBConnector;
import com.internousdev.ecsitestudy.util.DateUtil;
public class CartInfoDAO {



	public void AddCart(String user_id, String product_id,String product_count,String price) throws SQLException{

		DBConnector db=new DBConnector();
		Connection con=db.getConnection();
		DateUtil DU=new DateUtil();


		String sql="insert into cart_info (user_id,product_id,product_count,price,regist_date) values(?,?,?,?,?)";
		try{
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, user_id);
			ps.setString(2, product_id);
			ps.setString(3, product_count);
		    ps.setString(4, price);
		    ps.setString(5,DU.getDate());
		    ps.execute();


		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			con.close();
		}
	}


		public ArrayList<CartInfoDTO> CartInfo (String user_id) throws SQLException{
			DBConnector db= new DBConnector();
			Connection con=db.getConnection();

			ArrayList<CartInfoDTO> CIDTO=new ArrayList<CartInfoDTO>();

			String sql="select ci.id,pi.product_name,pi.product_name_kana,pi.image_file_path,pi.price,pi.release_company,ci.regist_date,ci.product_count from product_info pi left join cart_info ci on pi.product_id=ci.product_id where ci.user_id=? order by ci.id ASC";

			try{
				PreparedStatement ps=con.prepareStatement(sql);
				ps.setString(1, user_id);
				ResultSet rs=ps.executeQuery();

				while(rs.next()){

					CartInfoDTO dto=new CartInfoDTO();
					dto.setId(rs.getInt("id"));
					dto.setProduct_name(rs.getString("product_name"));
					dto.setProduct_name_kana(rs.getString("product_name_kana"));
					dto.setImage_file_path(rs.getString("image_file_path"));
					dto.setPrice(rs.getInt("price"));
					dto.setRelease_company(rs.getString("release_company"));
					dto.setDate(rs.getString("regist_date"));
					dto.setProduct_count(rs.getInt("product_count"));
					int p=dto.getPrice();
					int c=dto.getProduct_count();
					dto.setSumprice(p*c);
					CIDTO.add(dto);

				}

			}catch(SQLException e){
				e.printStackTrace();
		}finally{
			con.close();
		}
			return CIDTO;
				}

	public int goukeiprice(String id) throws SQLException{
		DBConnector DB=new DBConnector();
		Connection con=DB.getConnection();
		int goukei=0;
		String SQL="select price,product_count from cart_info where user_id=?";
		try{
			PreparedStatement ps=con.prepareStatement(SQL);
			ps.setString(1, id);
			ResultSet rs=ps.executeQuery();

			while(rs.next()){
				int price=rs.getInt("price");
				int num=rs.getInt("product_count");
				int sump=price*num;
				  goukei+=sump;

			}

			}
		    catch(SQLException e){
			e.printStackTrace();
			}finally{
				con.close();
			}

			return goukei;


	}

	public void DeleteCartItem(String id) throws SQLException{
		DBConnector db=new DBConnector();
		Connection con=db.getConnection();
		String sql="delete from cart_info where id=?";
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

	public List<String> getId(String userid) throws SQLException{

		DBConnector db=new DBConnector();
		Connection con=db.getConnection();
		List<String> id=new ArrayList<>();

		String sql="select id from cart_info where user_id=? order by id ASC";
		try{
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, userid);
			ResultSet rs=ps.executeQuery();

			while(rs.next()){
				id.add(rs.getString("id"));
			}
		}
			catch(SQLException e){
				e.printStackTrace();
			}finally{
				con.close();
			}
			return id;
		}

	public void compBuy(String destid,String cartid) throws SQLException{

		DBConnector db=new DBConnector();
		Connection con=db.getConnection();
		DateUtil DU=new DateUtil();
		String sql="insert into purchase_history_info (user_id,product_id,product_count,price,destination_id,regist_date) select user_id,product_id,product_count,price,?,? from cart_info where id=?";

		try{
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, destid);
			ps.setString(2, DU.getDate());
			ps.setString(3, cartid);
			ps.execute();

		}catch(SQLException e){

			e.printStackTrace();
		}finally{
			con.close();
		}


	}


	public void DelCartbyId(String id) throws SQLException{

		DBConnector db=new DBConnector();
		Connection con=db.getConnection();
		String sql="delete from cart_info where id=?";

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

	public void MoveCart(String genuineid,String randomid) throws SQLException{
		DBConnector db=new DBConnector();
		Connection con=db.getConnection();
		String sql="update cart_info set user_id=? where user_id=?";
		try{
			PreparedStatement ps =con.prepareStatement(sql);
			ps.setString(1, genuineid);
			ps.setString(2, randomid);
			ps.execute();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			con.close();
		}
	}

	public boolean searchCItem(String proid,String userid) throws SQLException{
		DBConnector db=new DBConnector();
		Connection con=db.getConnection();
		String sql="select * from cart_info where product_id=?  and user_id=?";
		int i=0;
		boolean result=true;
		try{
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, proid);
		    ps.setString(2, userid);
		    ResultSet rs=ps.executeQuery();
		    while(rs.next()){
		    	i++;
		    }
		    if(i==0){
		    	result=true;
		    }
		    else{
		    	result=false;
		    }
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			con.close();
		}
		return result;
	}


	public int updateCitem(String proid,String itemcount,String userid) throws SQLException{

		DBConnector db=new DBConnector();
		Connection con=db.getConnection();
		int i=0;
		String sql="update cart_info set product_count=product_count+? where user_id=? and product_id=?";
		try{
		  PreparedStatement ps=con.prepareStatement(sql);
		  ps.setString(1, itemcount);
		  ps.setString(2, userid);
		  ps.setString(3, proid);
		  i=ps.executeUpdate();

		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			con.close();
		}
		return i;


	}

	}


