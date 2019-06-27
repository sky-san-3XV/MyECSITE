package com.internousdev.ecsitestudy.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsitestudy.dao.DestinationInfoDAO;
import com.internousdev.ecsitestudy.dto.DestinationInfoDTO;
import com.opensymphony.xwork2.ActionSupport;

public class SettlementConfirmAction extends ActionSupport implements SessionAware {

	Map<String,Object> session;
	ArrayList<DestinationInfoDTO> di=new ArrayList<DestinationInfoDTO>();
	DestinationInfoDAO dao=new DestinationInfoDAO();
	private String msg;

	public String execute() throws SQLException{

		if(!session.containsKey("logined")){
			return LOGIN;
		}
		else{
			di=dao.getDest(session.get("user_id").toString());

			if(di.size()>0){
				msg="";
				return SUCCESS;

			}

		else{
			msg="決済情報がありません。";
			return SUCCESS;

	}
 }
	}


   @Override
   public void setSession(Map<String,Object> session){
	   this.session=session;
   }

   public String getMsg(){
	   return msg;
   }

   public void setMsg(String msg){
	   this.msg=msg;
   }



   public ArrayList<DestinationInfoDTO> getDi(){
	   return di;
   }

   public void setDi(ArrayList<DestinationInfoDTO> di){
	   this.di=di;
   }



}
