package com.internousdev.ecsitestudy.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsitestudy.dao.CartInfoDAO;
import com.internousdev.ecsitestudy.dao.UserInfoDAO;
import com.internousdev.ecsitestudy.dto.CartInfoDTO;
import com.internousdev.ecsitestudy.dto.UserInfoDTO;
import com.opensymphony.xwork2.ActionSupport;


public class UserCreateCompleteAction extends ActionSupport implements SessionAware {


	Map<String,Object> session;
	UserInfoDTO dto=new UserInfoDTO();
	CartInfoDAO CIDAO=new CartInfoDAO();
	ArrayList<CartInfoDTO> cartList=new ArrayList<CartInfoDTO>();
    private String errmsg;

	public String execute() throws SQLException{
		String result=ERROR;
		UserInfoDAO dao=new UserInfoDAO();
		int i=dao.CreateUser(session.get("userId").toString(),session.get("shinkipassword").toString(),session.get("family").toString(),
				session.get("first").toString(),session.get("familyk").toString(),session.get("firstk").toString(),
				session.get("sex").toString(),session.get("email").toString());

		if(i>0){
			result=SUCCESS;
			session.remove("family");
			session.remove("familyk");
			session.remove("first");
			session.remove("firstk");
			session.remove("sex");
			session.remove("email");
		}





		return result;

	}


	public Map<String,Object> getSession(){
		return session;
	}
	@Override
	public void setSession(Map<String,Object>session){
		this.session=session;
	}

	public String getErrmsg(){
		return errmsg;
	}
	public void setErrmsg(String errmsg){
		this.errmsg=errmsg;

	}



}
