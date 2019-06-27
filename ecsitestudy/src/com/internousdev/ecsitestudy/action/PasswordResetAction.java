package com.internousdev.ecsitestudy.action;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class PasswordResetAction extends ActionSupport implements SessionAware{

	private String PsFig;
	Map<String,Object> session;
	public String execute(){

		if(PsFig.equals("1")){                   //ログイン画面から飛んだ場合session内のIDを初期化する

			session.remove("loginUserId");
			session.remove("loginPassword");

		}



		return SUCCESS;
	}

	@Override
	public void setSession(Map<String,Object> session){
		this.session=session;
	}

	public String getPsFig(){
		return PsFig;
	}
	public void setPsFig(String PsFig){
		this.PsFig=PsFig;
	}
}
