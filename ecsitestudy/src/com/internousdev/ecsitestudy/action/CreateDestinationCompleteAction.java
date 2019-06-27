package com.internousdev.ecsitestudy.action;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsitestudy.dao.DestinationInfoDAO;
import com.internousdev.ecsitestudy.dto.DestinationInfoDTO;
import com.opensymphony.xwork2.ActionSupport;

public class CreateDestinationCompleteAction extends ActionSupport implements SessionAware{

	Map<String,Object>session;
	DestinationInfoDAO dao=new DestinationInfoDAO();
	ArrayList<DestinationInfoDTO> DI=new ArrayList<DestinationInfoDTO>();
	int res;


	public String execute() throws SQLException{

		String result=ERROR;
		res=dao.setDest(session.get("faname").toString(), session.get("fanamek").toString(), session.get("finame").toString(), session.get("finamek").toString(),
				session.get("email").toString(),session.get("telnum").toString(), session.get("address").toString(),session.get("user_id").toString());

		if(res>0){


		result=SUCCESS;

		session.remove("faname");
		session.remove("fanamek");
		session.remove("finame");
		session.remove("finamek");
		session.remove("email");
		session.remove("telnum");
		session.remove("address");
		}
		else{
			result=ERROR;
		}

		return result;
	}




	public Map<String,Object> getSession(){
		return session;
	}

	@Override
	public void setSession(Map<String,Object> session){
		this.session=session;
	}

	public ArrayList<DestinationInfoDTO> getDI(){
		return DI;
	}

	public void setDI(ArrayList<DestinationInfoDTO> DI){
		this.DI=DI;
	}


}
