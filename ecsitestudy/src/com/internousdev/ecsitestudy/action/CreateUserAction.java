package com.internousdev.ecsitestudy.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class CreateUserAction extends ActionSupport implements SessionAware {

	Map<String,Object> session;
    private String TopFig;
	public String execute(){

		String result=ERROR;
		if(TopFig==null){

			result= SUCCESS;

		}
		else if(TopFig.equals("1")){ //新規登録（初期画面）経由だと内容初期化
			session.remove("family");
			session.remove("familyk");
			session.remove("first");
			session.remove("firstk");
			session.remove("sex");
			session.remove("email");
			session.remove("userId");
			session.remove("password");

			result= SUCCESS;
		}

        return result;

	}



	@Override
	public void setSession(Map<String,Object>session){
		this.session=session;
	}
	public String getTopFig(){
		return TopFig;
	}
	public void setTopFig(String TopFig){
		this.TopFig=TopFig;
	}
}
