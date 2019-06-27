package com.internousdev.ecsitestudy.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsitestudy.dao.ProductsInfoDAO;
import com.internousdev.ecsitestudy.dto.ProductsInfoDTO;
import com.opensymphony.xwork2.ActionSupport;



public class ProductsDetailAction extends ActionSupport implements SessionAware {

	private ProductsInfoDAO dao=new ProductsInfoDAO();
	private String proerrmsg=null;
	private String product_id;
    private String infomsg;
    ProductsInfoDTO DTO=new ProductsInfoDTO();
	public ArrayList<ProductsInfoDTO> KRDTO=new ArrayList<ProductsInfoDTO>();
	Map<String,Object> session;


	public String execute() throws SQLException{

		DTO=dao.getproDet(product_id);


		if(DTO.getProduct_name().toString().equals(null)){

			proerrmsg="商品情報が見つかりませんでした。";

			return SUCCESS;


		}else{
			session.put("image_file_path", DTO.getImage_file_path());
			session.put("proid", DTO.getProduct_id());
			session.put("detproduct_name",DTO.getProduct_name());
			session.put("detproduct_name_kana", DTO.getProduct_namek());
			session.put("detprice", DTO.getPrice());
			session.put("release_company", DTO.getRelease_company());
			session.put("release_date", DTO.getRelease_date());
			session.put("product_desc", DTO.getProduct_desc());

			String category_id=DTO.getCategory_id();
			String pname=DTO.getProduct_name();
			KRDTO=dao.getKanren(category_id,pname);
			if(KRDTO.size()>0){
				session.put("KANREN", KRDTO);
				infomsg="";
			}
			else{
				infomsg="同じカテゴリの商品はほかに見つかりませんでした。";
			}


		return SUCCESS;
		}

	}

	public Map<String,Object> getSession(){
		return session;
	}
	@Override
	public void setSession(Map<String,Object> session){
		this.session=session;
	}

	public String getProerrmsg(){
		return proerrmsg;
	}

	public void setProerrmsg(String proerrmsg){
		this.proerrmsg=proerrmsg;
	}

	public String getInfomsg(){
		return infomsg;
	}

	public void setInfomsg(String infomsg){
		this.infomsg=infomsg;
	}

	public String getProduct_id(){
		return product_id;
	}
	public void setProduct_id(String product_id){
		this.product_id=product_id;
	}


}
