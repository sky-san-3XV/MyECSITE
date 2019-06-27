package com.internousdev.ecsitestudy.dto;

public class MyPageDTO {


	private String product_name;
	private String product_name_kana;
	private String image_file_path;
	private String release_company;
	private String release_date;
	private int price;
	private int product_count;
	private int goukei;




	public int getGoukei(){
		return goukei;
	}
	public void setGoukei(int goukei){
		this.goukei=goukei;
	}

	public String getProduct_name(){
		return product_name;
	}

	public void setProduct_name(String product_name){
		this.product_name=product_name;
	}

	public String getProduct_name_kana(){
		return product_name_kana;
	}

	public void setProduct_name_kana(String product_name_kana){
		this.product_name_kana=product_name_kana;
	}

	public String getImage_file_path(){
		return image_file_path;
	}

	public void setImage_file_path(String image_file_path){
		this.image_file_path=image_file_path;
	}
	public String getRelease_company(){
		return release_company;
	}

	public void setRelease_company(String release_company){
		this.release_company=release_company;
	}

	public String getRelease_date(){
		return release_date;
	}

	public void setRelease_date(String release_date){
		this.release_date=release_date;
	}

	public int getPrice(){
		return price;
	}

	public void setPrice(int price){
		this.price=price;
	}

	public int getProduct_count(){
		return product_count;
	}

	public void setProduct_count(int product_count){
		this.product_count=product_count;
	}





}
