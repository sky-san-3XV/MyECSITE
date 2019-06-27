package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.ItemListDeleteCompleteDAO;
import com.internousdev.ecsite.dto.ItemListDTO;
import com.opensymphony.xwork2.ActionSupport;


public class ItemListDeleteCompleteAction extends ActionSupport implements SessionAware{

	public Map<String,Object> session;
	private ItemListDeleteCompleteDAO IDDAO=new ItemListDeleteCompleteDAO();
	private ArrayList<ItemListDTO> itemList=new ArrayList<ItemListDTO>();
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

	int res=IDDAO.ItemListDelete();
		if(res>0){
			itemList=null;
			setMessage("商品情報を正しく削除しました。");
		}else if(res==0){
			setMessage("商品情報の削除に失敗しました。");
		}
	}
	public void setDeleteFig(String deleteFig){
		this.deleteFig=deleteFig;
	}
	@Override
	public void setSession(Map<String,Object> session){
		this.session=session;
	}
	public ArrayList<ItemListDTO> getItemList(){
		return this.itemList;
	}
	public String getMessage(){
		return message;
	}
	public void setMessage(String message){
		this.message=message;
	}


}
