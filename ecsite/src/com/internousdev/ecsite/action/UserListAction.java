package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.UserListDAO;
import com.internousdev.ecsite.dto.UserInfoDTO;
import com.opensymphony.xwork2.ActionSupport;


public class UserListAction extends ActionSupport implements SessionAware{

	public Map<String,Object> session;
	private UserListDAO ULDAO=new UserListDAO();
	private ArrayList<UserInfoDTO> userList=new ArrayList<UserInfoDTO>();
	private String message;

	public String execute() throws SQLException{
     String rel=ERROR;
     userList=ULDAO.getUserInfo();
     if(userList.size()>0){
    	 session.put("userList", userList);
    	 rel=SUCCESS;
     }else{
    	 message="ユーザー情報はありません。";
    			 rel=SUCCESS;
     }
     return rel;

	}





	@Override
	public void setSession(Map<String,Object> session){
		this.session=session;
	}
	public ArrayList<UserInfoDTO> getUserList(){
		return this.userList;
	}
	public String getMessage(){
		return message;
	}
	public void setMessage(String message){
		this.message=message;
	}


}
