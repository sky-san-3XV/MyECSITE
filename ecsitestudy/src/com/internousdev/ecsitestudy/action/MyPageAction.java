package com.internousdev.ecsitestudy.action;


import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsitestudy.dao.UserInfoDAO;
import com.internousdev.ecsitestudy.dto.UserInfoDTO;
import com.opensymphony.xwork2.ActionSupport;

public class MyPageAction extends ActionSupport implements SessionAware{

	Map<String,Object> session;
	UserInfoDAO dao=new UserInfoDAO();
	UserInfoDTO dto=new UserInfoDTO();

	public String execute() throws SQLException{

		String result=ERROR;
		if(session.containsKey("logined")){

			dto=dao.getMyPage(session.get("user_id").toString());

			result=SUCCESS;
		}

		return result;

	}

	@Override
	public void setSession(Map<String,Object> session){
		this.session=session;
	}

	public UserInfoDTO getDto(){
		return dto;
	}

	public void setDto(UserInfoDTO dto){
		this.dto=dto;
	}

}
