package com.internousdev.ecsitestudy.dto;

public class CartInfoDTO {

	private String user_id;
	private int product_id;
	private int product_count;
	private int price;
	private String product_name;
	private String image_file_path;
	private String product_name_kana;
	private String release_company;
	private int id;
	private String date;
	private int sumprice;


	public String getUser_id(){
		return user_id;
	}

	public void setUser_id(String user_id){
		this.user_id=user_id;
	}

	public String getDate(){
		return date;
	}

	public void setDate(String date){
		this.date=date;
	}
	public int getProduct_id(){
		return product_id;
	}

	public void setProduct_id(int product_id){
		this.product_id=product_id;
	}

	public int getSumprice(){
		return sumprice;
	}

	public void setSumprice(int sumprice){
		this.sumprice=sumprice;
	}





	public int getId(){
		return id;
	}

	public void setId(int id){
		this.id=id;
	}
	public int getProduct_count(){
		return product_count;
	}

	public void setProduct_count(int product_count){
		this.product_count=product_count;;
	}

	public int getPrice(){
		return price;
	}

	public void setPrice(int price){
		this.price=price;
	}

	public String getProduct_name(){
		return product_name;
	}

	public void setProduct_name(String product_name){
		this.product_name=product_name;
	}

	public String getImage_file_path(){
		return image_file_path;
	}

	public void setImage_file_path(String image_file_path){
		this.image_file_path=image_file_path;
	}

	public String getProduct_name_kana(){
		return product_name_kana;
	}

	public void setProduct_name_kana(String product_name_kana){
		this.product_name_kana=product_name_kana;
	}

	public String getRelease_company(){
		return release_company;
	}

	public void setRelease_company(String release_company){
		this.release_company=release_company;
	}





}
