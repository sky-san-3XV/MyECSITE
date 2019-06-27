package com.internousdev.ecsitestudy.action;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsitestudy.dao.ProductsInfoDAO;
import com.internousdev.ecsitestudy.dto.ProductsInfoDTO;
import com.opensymphony.xwork2.ActionSupport;

public class ProductsAction extends ActionSupport implements SessionAware {

	public Map<String,Object> session;
	private ProductsInfoDAO PIDAO=new ProductsInfoDAO();
	private ArrayList<ProductsInfoDTO> ProList=new ArrayList<ProductsInfoDTO>();
	private String message;


	public String execute() throws SQLException{

		String result=ERROR;
		ProList=PIDAO.getItemTop();
		if(ProList.size()>0){
			message="";
			result=SUCCESS;
		}
		else{
			message="商品情報が見つかりませんでした。";
			result=SUCCESS;
		}
		return result;
	}





	public Map<String,Object> getSession(){
		return session;
	}
	@Override
	public void setSession(Map<String,Object> session){
		this.session=session;
	}
	public ArrayList<ProductsInfoDTO> getProList(){
		return this.ProList;
	}
	public String getMessage(){
		return message;
	}
	public void setMessage(String message){
		this.message=message;
	}

}
