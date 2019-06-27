package com.internousdev.ecsitestudy.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class CreateDestinationAction extends ActionSupport implements SessionAware {

	Map<String,Object> session;
	private String shinkiFig;

	public String execute(){

		if(shinkiFig.equals("1")){

		if(session.containsKey("faname")){

			session.remove("faname");
		}
		if(session.containsKey("fanamek")){

			session.remove("fanamek");
		}
		if(session.containsKey("finame")){

		   session.remove("finame");

		}
		if(session.containsKey("finamek")){

			session.remove("finamek");

		}
		if(session.containsKey("email")){

			session.remove("email");

		}
		if(session.containsKey("telnum")){

		    session.remove("telnum");
		}
		if(session.containsKey("address")){
			session.remove("address");

		}//ぬるぽ対策のつもり
		}else{

		}


		return SUCCESS;
	}

	@Override
	public void setSession(Map<String,Object> session){
		this.session=session;
	}

	public String getShinkiFig(){
		return shinkiFig;
	}

	public void setShinkiFig(String shinkiFig){
		this.shinkiFig=shinkiFig;
	}

}
