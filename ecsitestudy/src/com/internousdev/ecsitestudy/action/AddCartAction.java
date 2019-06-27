package com.internousdev.ecsitestudy.action;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsitestudy.dao.CartInfoDAO;
import com.internousdev.ecsitestudy.dto.CartInfoDTO;
import com.opensymphony.xwork2.ActionSupport;


public class AddCartAction extends ActionSupport implements SessionAware{

	Map<String,Object> session;

	private String buynum;
	private String infomsg;
	public String result;
	private int goukei;

	ArrayList<CartInfoDTO> cartList=new ArrayList<CartInfoDTO>();
	public String execute() throws SQLException{
		CartInfoDAO CIDAO=new CartInfoDAO();
		String result=ERROR;

		if(session.isEmpty()){
			result="sessiontimeout";
		}
		else{
			String user=session.get("user_id").toString();




			if(session.containsKey("proid")){
				String price=session.get("detprice").toString();
				String productid=session.get("proid").toString();
			   boolean sameitem=CIDAO.searchCItem(productid, user);
				if(sameitem==true){
				CIDAO.AddCart(user,productid,buynum,price);
				}
				else{
					int it=CIDAO.updateCitem(productid, buynum, user);

				}
			}

        cartList=CIDAO.CartInfo(user);


        if(cartList.size()>0){

        	session.remove("proid");
			session.remove("detproduct_name");
			session.remove("detproduct_name_kana");
			session.remove("detprice");
			session.remove("release_company");
			session.remove("release_date");
			session.remove("product_desc");
			session.remove("image_file_path");
			session.remove("KANREN");
			goukei=CIDAO.goukeiprice(session.get("user_id").toString());
			infomsg="";


        }else{
        	infomsg="カートに商品はありません。";
        }
        if(!session.containsKey("logined")){
        	session.put("fromaddcartlogin", 1);
        	String randomid=session.get("user_id").toString();
        	session.put("randomid", randomid);
        	result="LOGIN";
        }else{
        	result=SUCCESS;

        }
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

    public String getInfomsg(){
    	return infomsg;
    }

    public void setInfomsg(String infomsg){
    	this.infomsg=infomsg;
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

    public String getBuynum(){
    	return buynum;
    }

    public void setBuynum(String buynum){

    	this.buynum=buynum;
    }


	}


