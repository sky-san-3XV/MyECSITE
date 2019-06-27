package com.internousdev.ecsitestudy.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsitestudy.dao.UserInfoDAO;
import com.internousdev.ecsitestudy.util.Randomidgend;
import com.opensymphony.xwork2.ActionSupport;

public class LogoutAction extends ActionSupport implements SessionAware {
	Map<String,Object> session;

	Randomidgend RI=new Randomidgend();
	public String execute() throws SQLException{
		String result=ERROR;
		UserInfoDAO UIDAO=new UserInfoDAO();





		if(session.containsKey("user_id")==false){
        	session.remove("logined");
        	return SUCCESS;
		}
		else{
        boolean stat=UIDAO.LoginStat(0,(session.get("user_id").toString())); //statusに0をセットする


         if(stat==true){
         session.remove("user_id");
         session.remove("logined");
         session.remove("fromaddcartlogin");
         session.remove("fromcartlogin");
         session.remove("loginUser");

         if(!session.containsKey("keepid")){

         session.remove("logininputuserid");
         }
         String randomid=RI.randomid();
         session.put("user_id", randomid);

		return SUCCESS;
        }
		}
      return result;
	}
	@Override
	public void setSession(Map<String,Object> session){
		this.session=session;
	}
}
