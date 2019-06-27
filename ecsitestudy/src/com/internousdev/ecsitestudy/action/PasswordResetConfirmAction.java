package com.internousdev.ecsitestudy.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsitestudy.dao.UserInfoDAO;
import com.internousdev.ecsitestudy.dto.UserInfoDTO;
import com.internousdev.ecsitestudy.util.InputChecker;
import com.opensymphony.xwork2.ActionSupport;

public class PasswordResetConfirmAction extends ActionSupport implements SessionAware{

	private String loginUserId;
	private String loginPassword;
	private String loginPasswordnew;
	private String loginPasswordnew2;
	Map<String,Object> session;

	String errmsg;
	UserInfoDTO dto=new UserInfoDTO();
	UserInfoDAO dao=new UserInfoDAO();
	InputChecker IC=new InputChecker();


	public String execute() throws SQLException{
		String result=ERROR;
		int chknum=IC.passwordchk(loginPasswordnew);
		dto=dao.getLogin(loginUserId, loginPassword);
		session.put("passresetUser",dto);

		if(((UserInfoDTO)session.get("passresetUser")).getLoginFig()==true){

			if(loginPassword.equals(loginPasswordnew)){
            	 errmsg="古いパスワードと同じパスワードは使用できません";
            	 result=ERROR;
             }

             else{
			if(loginPasswordnew.equals(loginPasswordnew2)){

				switch(chknum){
				case 0:
					result=SUCCESS;
					session.put("loginUserId",loginUserId);
					session.put("loginPasswordnew",loginPasswordnew);
					char pass=loginPasswordnew.charAt(0);
					int num=loginPasswordnew.length();
					String ast="*";
					String ps=StringUtils.repeat(ast, num-1);
					String hiddenpass=pass+ps;
					session.put("hiddenpass",hiddenpass);
					break;
				case 1:
					errmsg="新しいパスワードは1文字以上16字以内で入力してください";
					result=ERROR;
					break;
				case 2:
					errmsg="半角英数字で新しいパスワードを入力してください。";
					result=ERROR;
					break;
				}
			}
			else{
				errmsg="新パスワードと確認パスワードが一致しません。";
				result=ERROR;
			}

             }
		}
			else{
				errmsg="ユーザIDかパスワードが間違っています。";
				result=ERROR;

		}
		return result;

		}

	public String getLoginUserId(){
		return loginUserId;
	}

	public void setLoginUserId(String loginUserId){
		this.loginUserId=loginUserId;
	}

	public String getLoginPassword(){
		return loginPassword;
	}

	public void setLoginPassword(String loginPassword){
		this.loginPassword=loginPassword;
	}


	public String getLoginPasswordnew(){
		return loginPasswordnew;
	}

	public void setLoginPasswordnew(String loginPasswordnew){
		this.loginPasswordnew=loginPasswordnew;
	}

	public String getLoginPasswordnew2(){
		return loginPasswordnew2;
	}

	public void setLoginPasswordnew2(String loginPasswordnew2){
		this.loginPasswordnew2=loginPasswordnew2;
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
		this.errmsg=errmsg;;
	}











}
