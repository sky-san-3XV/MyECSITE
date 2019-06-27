package com.internousdev.ecsitestudy.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsitestudy.dao.UserInfoDAO;
import com.opensymphony.xwork2.ActionSupport;

public class PasswordResetCompleteAction extends ActionSupport implements SessionAware {

	private String loginUserId;
	private String loginPasswordnew;
	Map<String,Object> session;

	public String execute() throws SQLException{
		String result=ERROR;
		UserInfoDAO UIDAO=new UserInfoDAO();
		int i=UIDAO.Resetpass(session.get("loginPasswordnew").toString(),session.get("loginUserId").toString());


		if(i>0){
		result=SUCCESS;
		//sessionパスワード再登録関連情報の削除
		  session.remove("loginpasswordnew");
	      session.remove("loginUserId");
		}


		return result;

	}

	public String getLoginUserId(){
		return loginUserId;
	}

	public void setLoginUserId(String loginUserId){
		this.loginUserId=loginUserId;
	}

	public String getLoginPasswordnew(){
		return loginPasswordnew;
	}

	public void setLoginPasswordnew(String loginPasswordnew){
		this.loginPasswordnew=loginPasswordnew;
	}

	public Map<String,Object> getSession(){
		return session;
	}
	@Override
	public void setSession(Map<String,Object>session){
		this.session=session;
	}

}
