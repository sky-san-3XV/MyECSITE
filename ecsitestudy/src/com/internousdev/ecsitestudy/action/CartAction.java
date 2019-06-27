package com.internousdev.ecsitestudy.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsitestudy.dao.CartInfoDAO;
import com.internousdev.ecsitestudy.dto.CartInfoDTO;
import com.opensymphony.xwork2.ActionSupport;

public class CartAction extends ActionSupport implements SessionAware {

	Map<String,Object> session;
	ArrayList<CartInfoDTO> cartList=new ArrayList<CartInfoDTO>();
	CartInfoDAO dao=new CartInfoDAO();
	public String infomsg;
	private int goukei;


	public String execute() throws SQLException{

		String result=ERROR;
		if(!session.containsKey("logined")){
			session.put("fromcartlogin", 1);
			result="LOGIN";
		}
		else{

		cartList=dao.CartInfo(session.get("user_id").toString());

		if(cartList.size()>0){

			result=SUCCESS;
			goukei=dao.goukeiprice(session.get("user_id").toString());
			infomsg="";

		}
		else{
			infomsg="カートに商品はありません。";
			result=SUCCESS;

		}
		}
		return result;

	}



	@Override
	public void setSession(Map<String,Object> session){
		this.session=session;
	}
	public ArrayList<CartInfoDTO> getCartList(){
		return cartList;
	}
	public void setCartList(ArrayList<CartInfoDTO> cartList){
		this.cartList=cartList;
	}

	public int getGoukei(){
		return goukei;
	}

	public void setGoukei(int goukei){
		this.goukei=goukei;
	}

	public String getInfomsg(){
		return infomsg;
	}

	public void setInfomsg(String infomsg){
		this.infomsg=infomsg;
	}

}
