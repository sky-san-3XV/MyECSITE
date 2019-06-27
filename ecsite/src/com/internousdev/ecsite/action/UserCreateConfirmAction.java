package com.internousdev.ecsite.action;
import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.CheckSameIDV3DAO;
import com.internousdev.ecsite.dto.CheckSameIDDTO;
import com.opensymphony.xwork2.ActionSupport;

public class UserCreateConfirmAction extends ActionSupport implements SessionAware {

	private String loginUserId;
	private String loginPassword;
	private String userName;
	public Map<String,Object> session;
	private String errorMessage;
	CheckSameIDV3DAO dao=new CheckSameIDV3DAO();
	CheckSameIDDTO dto=new CheckSameIDDTO();



	public String execute()throws SQLException{
		dto=dao.CheckSameID(loginUserId);
		session.put("chkloginId", dto);
		String result=SUCCESS;
		if(((CheckSameIDDTO)session.get("chkloginId")).getCheckID()==false){
			result =ERROR;
		 setErrorMessage("このIDは既に使用されております。");
           return result;
		}

		else if(!(loginUserId.equals("")) && !(loginPassword.equals("")) && !(userName.equals(""))){
			session.put("loginUserId",loginUserId);
			session.put("loginPassword", loginPassword);
			session.put("userName", userName);




			}else{
			setErrorMessage("未入力の項目があります。");
			result=ERROR;
		}
		return result;

}

	public String getUserName(){
		return userName;
	}
	public void setUserName(String userName){
		this.userName=userName;
	}
	public String getLoginPassword(){
		return loginPassword;
	}
	public void setLoginPassword(String loginPassword){
		this.loginPassword=loginPassword;
	}
	public String getLoginUserId(){
		return loginUserId;
	}
	public void setLoginUserId(String loginUserId){
		this.loginUserId=loginUserId;
	}
	public Map<String,Object> getSession(){
		return session;
	}
	@Override
	public void setSession(Map<String,Object>session){
		this.session=session;
	}
	public String getErrorMessage(){
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage){
		this.errorMessage=errorMessage;
	}
}
