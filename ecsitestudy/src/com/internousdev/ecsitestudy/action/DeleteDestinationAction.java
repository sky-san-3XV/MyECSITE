package com.internousdev.ecsitestudy.action;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsitestudy.dao.DestinationInfoDAO;
import com.internousdev.ecsitestudy.dto.DestinationInfoDTO;
import com.opensymphony.xwork2.ActionSupport;


public class DeleteDestinationAction extends ActionSupport implements SessionAware{

	Map<String,Object> session;
	private String id;
	ArrayList<DestinationInfoDTO> di=new ArrayList<DestinationInfoDTO>();
	DestinationInfoDAO dao=new DestinationInfoDAO();

	private String msg;



	public String execute() throws SQLException{


		dao.DeleteDet(id);



          di=dao.getDest(session.get("user_id").toString());
          if(di.size()>0){
        	  msg="";
          }else
          {
        	  msg="宛先情報がありません。";
          }
		return SUCCESS;

	}

	public Map<String,Object> getSession(){
		return session;
	}
	@Override
	public void setSession(Map<String,Object> session){
		this.session=session;
	}

	public String getId(){
		return id;
	}

	public void setId(String id){
		this.id=id;
	}


	public ArrayList<DestinationInfoDTO> getDi(){
		return di;
	}
	public void setDi(ArrayList<DestinationInfoDTO> di){
		this.di=di;
	}

	public String getMsg(){
		return msg;
	}

	public void setMsg(String msg){
		this.msg=msg;
	}




}