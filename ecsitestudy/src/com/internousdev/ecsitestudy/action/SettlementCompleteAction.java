package com.internousdev.ecsitestudy.action;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsitestudy.dao.CartInfoDAO;
import com.opensymphony.xwork2.ActionSupport;


public class SettlementCompleteAction extends ActionSupport implements SessionAware{

	Map<String,Object> session;


	CartInfoDAO dao1=new CartInfoDAO();
	public List<String> getId=new ArrayList<>();

	private String id;

	public String execute() throws SQLException{

		String result=ERROR;

		if(session.containsKey("logined")){

		getId=dao1.getId(session.get("user_id").toString());
		if(getId.size()>0){
			 for(int i = 0; i < getId.size(); ++i){
		            String s = getId.get(i);
		            dao1.compBuy(id, s);

		            dao1.DelCartbyId(s);
		        }

			 result=SUCCESS;
		        }
		}else{
			result=ERROR;

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

	public List<String> getGetId(){
		return getId;
	}

	public void setGetId(List<String> getId){
		this.getId=getId;
	}

	public String getId(){
		return id;
	}

	public void setId(String id){
		this.id=id;
	}





}
