package com.internousdev.ecsitestudy.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsitestudy.dao.ProductsInfoDAO;
import com.internousdev.ecsitestudy.dto.ProductsInfoDTO;
import com.internousdev.ecsitestudy.util.InputChecker;
import com.opensymphony.xwork2.ActionSupport;






public class SearchAction extends ActionSupport implements SessionAware{

	Map<String,Object> session;
	private ArrayList<ProductsInfoDTO> ProList=new ArrayList<ProductsInfoDTO>();
	ProductsInfoDAO dao=new ProductsInfoDAO();

	private String searchwords;
	private String category;

	InputChecker IC=new InputChecker();
	private String message;
	public String execute() throws SQLException{
		session.put("searchwords", searchwords);
		searchwords=searchwords.trim();
		searchwords=searchwords.replaceAll("　", " ").replaceAll("\\s{2,}", " ");
		if(StringUtils.isBlank(searchwords))
		{
		searchwords="";
		}

		String result=ERROR;
		switch(IC.searchwdchk(searchwords)){
		case 1:
		    message="検索ワードは50字以内で入力してください。";
		    result=SUCCESS;
		    break;

		case 2:
			message="文字種類エラー";
			result=SUCCESS;
			break;

		case 0:






		String[] searchwordss= searchwords.split(" ", 0);
		int i=searchwordss.length;
		System.out.println(i);






		if(i==1 || i==0){





			if(category.equals("0") && searchwords.equals("")){
				ProList=dao.getItemTop();

			}else if(category.equals("0") && !searchwords.equals("")){
					ProList=dao.searchItem(searchwordss[0]);

					result=SUCCESS;


		    }else if(!category.equals("0") && searchwords.equals("")){

					ProList=dao.searchItmbyCat(category);
					result=SUCCESS;

		    }else if(!category.equals("0") && !searchwords.equals("")){

					ProList=dao.getItmbyIdandword(category, searchwordss[0]);
					result=SUCCESS;
				}

		}else{
			if(category.equals("0") && !searchwords.equals("")){

				ProList=dao.getitmmanywords(i, searchwordss);

			}
			else if(!category.equals("0") && !searchwords.equals("")){

				ProList=dao.getitmmanywordsandcategory(i, category, searchwordss);
				result=SUCCESS;

			}
		}

		if(ProList.size()>0){
			message="";
			result=SUCCESS;
		}else{
			message="商品が見つかりませんでした。";
			result=SUCCESS;

		}
		}


		return result;

	}




@Override
public void setSession(Map<String,Object> session){
	this.session=session;
}

public String getCategory(){
	return category;
}

public void setCategory(String category){
	this.category=category;
}

public String getSearchwords(){
	return searchwords;
}

public void setSearchwords(String searchwords){
	this.searchwords=searchwords;
}

public ArrayList<ProductsInfoDTO> getProList(){
	return this.ProList;
}

public void setProList(ArrayList<ProductsInfoDTO> ProList){
	this.ProList=ProList;
}
public String getMessage(){
	return message;
}
public void setMessage(String message){
	this.message=message;
}
}
