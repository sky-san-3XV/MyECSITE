package com.internousdev.ecsitestudy.action;


import java.util.Map;
import java.util.ArrayList;
import java.sql.SQLException;

import com.internousdev.ecsitestudy.dto.MyPageDTO;
import com.internousdev.ecsitestudy.dao.MyPageDAO;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;

public class DeletePurchaseHistoryAction extends ActionSupport implements SessionAware {

	ArrayList<MyPageDTO> hist=new ArrayList<MyPageDTO>();
	MyPageDAO dao=new MyPageDAO();
	Map<String,Object> session;
	private String infomsg;

	public String execute() throws SQLException{

		String result=ERROR;
		if(session.containsKey("logined")){


			dao.Deletehist(session.get("user_id").toString());

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


