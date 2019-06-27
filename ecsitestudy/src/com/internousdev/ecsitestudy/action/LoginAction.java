package com.internousdev.ecsitestudy.action;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Optional;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsitestudy.dao.CartInfoDAO;
import com.internousdev.ecsitestudy.dao.UserInfoDAO;
import com.internousdev.ecsitestudy.dto.CartInfoDTO;
import com.internousdev.ecsitestudy.dto.UserInfoDTO;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport implements SessionAware {

	private String loginUserId;
	private String loginPassword;
	public Map<String,Object> session;
	private UserInfoDAO UIDAO=new UserInfoDAO();
	private UserInfoDTO UIDTO=new UserInfoDTO();
	CartInfoDAO CIDAO=new CartInfoDAO();
	ArrayList<CartInfoDTO> cartList=new ArrayList<CartInfoDTO>();

    String errmsg;
    private String keepID;
    public String errfig=null;
    private String infomsg;

    private int goukei;

	public String execute() throws SQLException{
		String result=ERROR;

		Optional<String> chkkeepId=Optional.ofNullable(keepID);
		keepID=chkkeepId.orElse("0");


		if(session.containsKey("userId")){    ///UserCreateCompleteから来たら自動ログイン

		  loginUserId=session.get("userId").toString();
		  session.remove("userId");

		  if(session.containsKey("shinkipassword")){

			  loginPassword=session.get("shinkipassword").toString();
			  session.remove("shinkipassword");

		    }

		}

		UIDTO=UIDAO.getLogin(loginUserId, loginPassword);
		session.put("loginUser",UIDTO);
		session.put("logininputuserid", loginUserId);
		if(((UserInfoDTO)session.get("loginUser")).getLoginFig()==true){
			boolean stat=UIDAO.LoginStat(1,loginUserId); //ステータスの書き換え

            if(stat==true){
			result=SUCCESS;
			session.put("user_id",UIDTO.getLoginUserId());
			session.put("logined",UIDTO.getLogined());
			session.put("keepid", UIDTO.getLoginFig());
			errmsg="";

			if(keepID.equals("0")){
				session.remove("keepid");
				session.remove("logininputuserid");
			}

			if(session.containsKey("fromaddcartlogin")){ //未ログインからの購入の場合

				String randomid=session.get("randomid").toString();
				CIDAO.MoveCart(session.get("user_id").toString(),randomid);
				cartList=CIDAO.CartInfo(session.get("user_id").toString());

				if(cartList.size()>0){

					goukei=CIDAO.goukeiprice(session.get("user_id").toString());
					infomsg="";

				}else{
					infomsg="カートに商品はありません。";
				}
				session.remove("randomid");
				session.remove("fromaddcartlogin");
				result="CART";

			}else if(session.containsKey("fromcartlogin")){  //カートから飛んできた場合
				cartList=CIDAO.CartInfo(session.get("user_id").toString());
				if(cartList.size()>0){
					goukei=CIDAO.goukeiprice(session.get("user_id").toString());
					infomsg="";
				}else{
					infomsg="カートに商品はありません。";
				}

				session.remove("fromcartlogin");

				result="CART";
			}
			else{
				result=SUCCESS;
			}


            }
            else{
            	result=ERROR;
            	errmsg="LoginStatus_update_failed,try RELOGIN.(データベース更新エラー)";
            }

		}else{

			result=ERROR;
			errmsg="ユーザーIDかパスワードが間違っています。";
			session.remove("loginUser");
			}



		return result;
	}







	public String getLoginUserId(){
		return loginUserId;
	}
	public void setLoginUserId(String loginUserId){
		this.loginUserId=loginUserId;
	}
	public String getLoginPassword(){
		return loginPassword;
	}
	public void setLoginPassword(String loginPassword){
		this.loginPassword=loginPassword;

	}
	public String getErrmsg(){
		return errmsg;
	}
	public void setErrmsg(String errmsg){
		this.errmsg=errmsg;

	}
	public String getErrfig(){
		return errfig;
	}
	public void setErrfig(String errfig){
		this.errfig=errfig;

	}
	public String getKeepID(){
		return keepID;
	}

	public void setKeepID(String keepID){
		this.keepID=keepID;
	}

	public ArrayList<CartInfoDTO> getCartList(){
		return cartList;
	}
	public void setCartList(ArrayList<CartInfoDTO> cartList){
		this.cartList=cartList;
	}

	public String getInfomsg(){
		return infomsg;
	}
	public void setInfomsg(String infomsg){
		this.infomsg=infomsg;
	}

	public Map<String,Object> getSession(){
		return session;
	}

	@Override
	public void setSession(Map<String,Object> session){
		this.session=session;
	}

	public int getGoukei(){
		return goukei;
	}

	public void setGoukei(int goukei){
		this.goukei=goukei;
	}
}

