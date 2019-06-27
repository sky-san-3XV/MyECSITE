package com.internousdev.ecsitestudy.action;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsitestudy.dao.CategoryDAO;
import com.internousdev.ecsitestudy.dto.CategoryDTO;
import com.internousdev.ecsitestudy.util.Randomidgend;
import com.opensymphony.xwork2.ActionSupport;

public class HomeAction extends ActionSupport implements SessionAware{

	public Map<String,Object> session;
	ArrayList<CategoryDTO> dto= new ArrayList<CategoryDTO>();
	CategoryDAO dao=new CategoryDAO();
	Randomidgend RA=new Randomidgend();

	public String execute() throws SQLException{

		String result=ERROR;


		if(!session.containsKey("logined") || !session.containsKey("user_id")){

			String randomid=RA.randomid();
			session.put("user_id", randomid);
		}

		try{
		dto=dao.getCat();
		}catch(NullPointerException e){
			dto=null;
		}




		session.put("cat", dto);


			session.remove("searchwords");
			result=SUCCESS;






		return result;

	}





	public Map<String,Object> getSession(){
		return session;
	}

	@Override
	public void setSession(Map<String,Object> session){
		this.session=session;
	}



}
