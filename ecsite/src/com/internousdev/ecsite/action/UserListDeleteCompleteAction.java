package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.UserListDeleteCompleteDAO;
import com.internousdev.ecsite.dto.UserInfoDTO;
import com.opensymphony.xwork2.ActionSupport;


public class UserListDeleteCompleteAction extends ActionSupport implements SessionAware{

	public Map<String,Object> session;
	private UserListDeleteCompleteDAO UDDAO=new UserListDeleteCompleteDAO();
	private ArrayList<UserInfoDTO> userList=new ArrayList<UserInfoDTO>();
	private String deleteFig;
	private String message;

	public String execute() throws SQLException{
		String rel=ERROR;
		if(deleteFig.equals("1")){
			delete();
			rel= SUCCESS;

		}
		return rel;
	}

	public void delete() throws SQLException{

	int res=UDDAO.UserListDelete();
		if(res>0){
			userList=null;
			setMessage("ユーザ情報を正しく削除しました。");
		}else if(res==0){
			setMessage("ユーザ情報の削除に失敗しました。");
		}
	}
	public void setDeleteFig(String deleteFig){
		this.deleteFig=deleteFig;
	}
	@Override
	public void setSession(Map<String,Object> session){
		this.session=session;
	}
	public ArrayList<UserInfoDTO> getUserList(){
		return this.userList;
	}
	public String getMessage(){
		return message;
	}
	public void setMessage(String message){
		this.message=message;
	}


}
