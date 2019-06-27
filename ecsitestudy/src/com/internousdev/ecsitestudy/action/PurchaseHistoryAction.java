package com.internousdev.ecsitestudy.action;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsitestudy.dao.MyPageDAO;
import com.internousdev.ecsitestudy.dto.MyPageDTO;
import com.opensymphony.xwork2.ActionSupport;

public class PurchaseHistoryAction extends ActionSupport implements SessionAware {

	ArrayList<MyPageDTO> hist=new ArrayList<MyPageDTO>();
	MyPageDAO dao=new MyPageDAO();
	Map<String,Object> session;

	private String infomsg;

	String result;

	public String execute() throws SQLException{

		result=ERROR;

		if(session.containsKey("logined")){
			hist=dao.getHist(session.get("user_id").toString());
			if(hist.size()>0){
				infomsg="";
				result=SUCCESS;
			}else{
				infomsg="購入履歴はありません。";
				result=SUCCESS;
			}
		}
		return result;
	}


	@Override
	public void setSession(Map<String,Object> session){
		this.session=session;
	}

	public ArrayList<MyPageDTO> getHist(){
		return hist;
	}
	public void setHist(ArrayList<MyPageDTO> hist){
		this.hist=hist;
	}

	public String getInfomsg(){
		return infomsg;
	}
	public void setInfomsg(String infomsg){
		this.infomsg=infomsg;
	}
}
