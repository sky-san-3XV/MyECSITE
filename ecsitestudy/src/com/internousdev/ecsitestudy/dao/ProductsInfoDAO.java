package com.internousdev.ecsitestudy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.ecsitestudy.dto.ProductsInfoDTO;
import com.internousdev.ecsitestudy.util.DBConnector;

public class ProductsInfoDAO {


	public ArrayList<ProductsInfoDTO> getItemTop() throws SQLException{

		ArrayList<ProductsInfoDTO> PIDTO=new ArrayList<ProductsInfoDTO>();
		DBConnector db=new DBConnector();
		Connection con=db.getConnection();

		String sql="select product_id,product_name,product_name_kana,image_file_path,image_file_name,price from product_info";
		try{
			PreparedStatement ps=con.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();

			while(rs.next()){
				ProductsInfoDTO dto=new ProductsInfoDTO();
				dto.setProduct_id(rs.getString("product_id"));
				dto.setProduct_name(rs.getString("product_name"));
				dto.setProduct_namek(rs.getString("product_name_kana"));
				dto.setImage_file_path(rs.getString("image_file_path"));
				dto.setImage_file_name(rs.getString("image_file_name"));
				dto.setPrice(rs.getString("price"));
				PIDTO.add(dto);


			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			con.close();
		} return PIDTO;
	}


	public ProductsInfoDTO getproDet(String id) throws SQLException{

		ProductsInfoDTO DTO=new ProductsInfoDTO();
		DBConnector db=new DBConnector();
		Connection con=db.getConnection();


		String sql="select product_id,product_name,product_name_kana,product_description,category_id,price,image_file_path,release_date,release_company from product_info where product_id=?";
		try{
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, id);
			ResultSet rs=ps.executeQuery();

			if(rs.next()){

				DTO.setProduct_id(rs.getString("product_id"));
				DTO.setProduct_name(rs.getString("product_name"));
				DTO.setProduct_namek(rs.getString("product_name_kana"));
				DTO.setProduct_desc(rs.getString("product_description"));
				DTO.setCategory_id(rs.getString("category_id"));
				DTO.setPrice(rs.getString("price"));
				DTO.setImage_file_path(rs.getString("image_file_path"));
				DTO.setRelease_date(rs.getString("release_date"));
				DTO.setRelease_company(rs.getString("release_company"));



			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			con.close();
		}

		return DTO;


	}

	public ArrayList<ProductsInfoDTO> getKanren(String id,String name) throws SQLException{
		ArrayList<ProductsInfoDTO> KRDTO=new ArrayList<ProductsInfoDTO>();
		DBConnector db=new DBConnector();
		Connection con=db.getConnection();

		String sql="select product_name,product_id,image_file_path from product_info where category_id=? and product_name !=? order by rand() limit 3";
		try{
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, name);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				ProductsInfoDTO dto=new ProductsInfoDTO();
				dto.setProduct_name(rs.getString("product_name"));
				dto.setImage_file_name(rs.getString("image_file_path"));
				dto.setProduct_id(rs.getString("product_id"));
				KRDTO.add(dto);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			con.close();
		}
		return KRDTO;


	}

	public ArrayList<ProductsInfoDTO> searchItem(String searchword) throws SQLException{

		ArrayList<ProductsInfoDTO> PIDTO=new ArrayList<ProductsInfoDTO>();
		DBConnector db=new DBConnector();
		Connection con=db.getConnection();
		String sql="select product_id,product_name,product_name_kana,image_file_path,image_file_name,price from product_info where product_name like ? or product_name_kana like ?";

		try{
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, "%"+searchword+"%");
			ps.setString(2, "%"+searchword+"%");
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				ProductsInfoDTO dto=new ProductsInfoDTO();
				dto.setProduct_id(rs.getString("product_id"));
				dto.setProduct_name(rs.getString("product_name"));
				dto.setProduct_namek(rs.getString("product_name_kana"));
				dto.setImage_file_path(rs.getString("image_file_path"));
				dto.setImage_file_name(rs.getString("image_file_name"));
				dto.setPrice(rs.getString("price"));
				PIDTO.add(dto);
			}

		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			con.close();
		}
		return PIDTO;
	}

	public ArrayList<ProductsInfoDTO> searchItmbyCat(String id) throws SQLException{

		ArrayList<ProductsInfoDTO> PIDTO=new ArrayList<ProductsInfoDTO>();
		DBConnector db=new DBConnector();
		Connection con=db.getConnection();
		String sql="select product_id,product_name,product_name_kana,image_file_path,image_file_name,price from product_info where category_id=?";

		try{
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, id);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
					ProductsInfoDTO dto=new ProductsInfoDTO();
					dto.setProduct_id(rs.getString("product_id"));
					dto.setProduct_name(rs.getString("product_name"));
					dto.setProduct_namek(rs.getString("product_name_kana"));
					dto.setImage_file_path(rs.getString("image_file_path"));
					dto.setImage_file_name(rs.getString("image_file_name"));
					dto.setPrice(rs.getString("price"));
					PIDTO.add(dto);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			con.close();
		}

		return PIDTO;
	}


	public ArrayList<ProductsInfoDTO> getItmbyIdandword(String id,String word) throws SQLException{
		ArrayList<ProductsInfoDTO> PIDTO=new ArrayList<ProductsInfoDTO>();
		DBConnector db=new DBConnector();
		Connection con=db.getConnection();
		String sql="select product_id,product_name,product_name_kana,image_file_path,image_file_name,price from product_info where category_id=? and (product_name like ? or product_name_kana like ?)";
		try{
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2,"%"+word+"%" );
			ps.setString(3, "%"+word+"%");
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				ProductsInfoDTO dto=new ProductsInfoDTO();
				dto.setProduct_id(rs.getString("product_id"));
				dto.setProduct_name(rs.getString("product_name"));
				dto.setProduct_namek(rs.getString("product_name_kana"));
				dto.setImage_file_path(rs.getString("image_file_path"));
				dto.setImage_file_name(rs.getString("image_file_name"));
				dto.setPrice(rs.getString("price"));
				PIDTO.add(dto);
			}

		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			con.close();
		}
		return PIDTO;

	}

	public ArrayList<ProductsInfoDTO> getitmmanywords(int i,String[] word) throws SQLException{


		ArrayList<ProductsInfoDTO> PIDTO=new ArrayList<ProductsInfoDTO>();
		DBConnector db=new DBConnector();
		Connection con=db.getConnection();
		String tmp="or product_name like ? or product_name_kana like ?";
		StringBuffer sql=new StringBuffer("select product_id,product_name,product_name_kana,image_file_path,image_file_name,price from product_info where product_name like ? or product_name_kana like ?");

		try{
			for(int num=1; num<i; num++){
			sql.append(tmp);
		}
			String sqll=sql.toString();
			PreparedStatement ps=con.prepareStatement(sqll);

			for(int num2=1; num2<i+1; num2++){
				int sets1=2*num2-1;
				int sets2=2*num2;
				int chr=num2-1;
				ps.setString(sets1,"%"+word[chr]+"%");
				ps.setString(sets2,"%"+word[chr]+"%");
			}
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				ProductsInfoDTO dto=new ProductsInfoDTO();
				dto.setProduct_id(rs.getString("product_id"));
				dto.setProduct_name(rs.getString("product_name"));
				dto.setProduct_namek(rs.getString("product_name_kana"));
				dto.setImage_file_path(rs.getString("image_file_path"));
				dto.setImage_file_name(rs.getString("image_file_name"));
				dto.setPrice(rs.getString("price"));
				PIDTO.add(dto);
			}


		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			con.close();
		}
		return PIDTO;

	}


	public ArrayList<ProductsInfoDTO> getitmmanywordsandcategory(int i,String category,String[] word) throws SQLException{


		ArrayList<ProductsInfoDTO> PIDTO=new ArrayList<ProductsInfoDTO>();
		DBConnector db=new DBConnector();
		Connection con=db.getConnection();

		StringBuffer sql=new StringBuffer("select product_id,product_name,product_name_kana,image_file_path,image_file_name,price from product_info where category_id=? and (product_name like ? or product_name_kana like ?");
		String tmp="or product_name like ? or product_name_kana like ?";


		try{
			for(int num=1; num<i; num++){
			sql.append(tmp);       // or文を条件の回数-1回（初回はメインのsqlに記載されている為)くっつける
			if(num==i-1){
				sql.append(")");  // 回数分ループしたら）で閉じる処理 全体として select~ where ? and(~or~)の形となる
			}

			System.out.println(sql);

		}
			String sqll=sql.toString();
			PreparedStatement ps=con.prepareStatement(sqll);
			ps.setString(1,category);

			for(int num2=1; num2<i+1; num2++){
				int sets1=2*num2;
				int sets2=2*num2+1;
				int chr=num2-1;
				ps.setString(sets1,"%"+word[chr]+"%");
				ps.setString(sets2,"%"+word[chr]+"%");
			}
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				ProductsInfoDTO dto=new ProductsInfoDTO();
				dto.setProduct_id(rs.getString("product_id"));
				dto.setProduct_name(rs.getString("product_name"));
				dto.setProduct_namek(rs.getString("product_name_kana"));
				dto.setImage_file_path(rs.getString("image_file_path"));
				dto.setImage_file_name(rs.getString("image_file_name"));
				dto.setPrice(rs.getString("price"));
				PIDTO.add(dto);
			}


		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			con.close();
		}
		return PIDTO;

	}


	public ArrayList<ProductsInfoDTO> AllinOneGetter(String searchword,String catid,String[] searchwordss,int wordkazu) throws SQLException{ //作るだけ作ったけど使う予定がなし
		ArrayList<ProductsInfoDTO> PIDTO=new ArrayList<ProductsInfoDTO>();
		DBConnector db=new DBConnector();
		Connection con=db.getConnection();
		StringBuffer sql=new StringBuffer("select product_id,product_name,product_name_kana,image_file_path,image_file_name,price from product_info where 1=1");
		try{
			PreparedStatement ps;
			ResultSet rs = null;
			if(catid.equals("0") && wordkazu==1 || wordkazu==0 && searchword.equals("")){ //カテゴリ全て　検索ワード空欄
			String sql1=sql.toString();
			ps=con.prepareStatement(sql1);
			rs=ps.executeQuery();

		}
		else if(!catid.equals("0") && wordkazu==1 || wordkazu==0 && searchword.equals("")){ //カテゴリのみ指定
			sql.append("and category_id=?");
			String sql2=sql.toString();
			ps=con.prepareStatement(sql2);
			ps.setString(1, catid);
			rs=ps.executeQuery();
		}
		else if(catid.equals("0") && wordkazu==1 && !searchword.equals("")){ //カテゴリ全て、検索ワード1つ
			sql.append("and (product_name like ? or product_name_kana like ?)");
			String sql3=sql.toString();
			ps=con.prepareStatement(sql3);
			ps.setString(1, searchword);
			ps.setString(2, searchword);
			rs=ps.executeQuery();
		}
		else if(!catid.equals("0") && wordkazu==1 && !searchword.equals("")){ //カテゴリ固定、検索ワード1つ
			sql.append("and category id= ? and (product_name like ? or product_name_kana like ?");
			String sql4=sql.toString();
			ps=con.prepareStatement(sql4);
			ps.setString(1, catid);
			ps.setString(2, searchword);
			ps.setString(3, searchword);
			rs=ps.executeQuery();
		}
		else if(catid.equals("0") && wordkazu>1 && !searchword.equals("")){ //カテゴリ全て　検索ワード複数
			sql.append("and product_name like ? or product_name_kana like ?");
			for(int num=1; num<wordkazu; num++){
				sql.append("or product_name like ? or product_name_kana like ?");
			}
			String sql5=sql.toString();
			ps=con.prepareStatement(sql5);
			for(int num2=1; num2<wordkazu+1; num2++){
				int sets1=2*num2-1;
				int sets2=2*num2;
				int chr=num2-1;
				ps.setString(sets1,"%"+searchwordss[chr]+"%");
				ps.setString(sets2,"%"+searchwordss[chr]+"%");
			}
			rs=ps.executeQuery();

		}
		else if(!catid.equals("0") && wordkazu>1 && !searchword.equals("")){  //カテゴリ固定　検索ワード複数
			sql.append("and category_id =? and (product_name like ? or product_name_kana like ?");

			for(int num2=1; num2<wordkazu; num2++){
				sql.append("or product_name like ? or product_name_kana like ?");  // or文を条件の回数-1回（初回はメインのsqlに記載されている為)くっつける
				if(num2==wordkazu-1){
					sql.append(")");  // 回数分ループしたら）で閉じる処理 全体として select~ where ? and(~or~)の形となる
				}
			}
			String sql6=sql.toString();
			ps=con.prepareStatement(sql6);
			ps.setString(1, catid);
			for(int num3=1; num3<wordkazu+1; num3++){
				int sets1=2*num3;
				int sets2=2*num3+1;
				int chr=num3-1;
				ps.setString(sets1,"%"+searchwordss[chr]+"%");
				ps.setString(sets2,"%"+searchwordss[chr]+"%");
			}
			rs=ps.executeQuery();
		}


			while(rs.next()){
				ProductsInfoDTO dto=new ProductsInfoDTO();
				dto.setProduct_id(rs.getString("product_id"));
				dto.setProduct_name(rs.getString("product_name"));
				dto.setProduct_namek(rs.getString("product_name_kana"));
				dto.setImage_file_path(rs.getString("image_file_path"));
				dto.setImage_file_name(rs.getString("image_file_name"));
				dto.setPrice(rs.getString("price"));
				PIDTO.add(dto);
			}



		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			con.close();
		}
		return PIDTO;
	}

}

