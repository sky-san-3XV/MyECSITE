package com.internousdev.ecsitestudy.action;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsitestudy.dao.CartInfoDAO;
import com.internousdev.ecsitestudy.dto.CartInfoDTO;
import com.opensymphony.xwork2.ActionSupport;


public class DeleteCartAction extends ActionSupport implements SessionAware{

	Map<String,Object> session;
	private List<String> chkdelete=new ArrayList<>();
	ArrayList<CartInfoDTO> cartList=new ArrayList<CartInfoDTO>();
	CartInfoDAO dao=new CartInfoDAO();
	private int goukei=0;
	String infomsg;


	public String execute() throws SQLException{

		String result=ERROR;
		if(chkdelete.size()>0){
		 for(int i = 0; i < chkdelete.size(); ++i){
	            String s = chkdelete.get(i);
	            dao.DeleteCartItem(s);    //これ単純に項目の量増えるとすごく重そうだから改善の余地がある
	        }

	        }



		cartList=dao.CartInfo(session.get("user_id").toString());
		if(cartList.size()>0){
		goukei=dao.goukeiprice(session.get("user_id").toString());
		infomsg="";
		result=SUCCESS;
		}
		else{
			infomsg="カートに商品がありません。";
			result=SUCCESS;
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

	public List<String> getChkdelete(){
		return chkdelete;
	}

	public void setChkdelete(List<String> chkdelete){
		this.chkdelete=chkdelete;
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


