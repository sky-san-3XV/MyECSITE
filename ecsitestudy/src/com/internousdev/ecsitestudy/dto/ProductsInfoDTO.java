package com.internousdev.ecsitestudy.dto;

public class ProductsInfoDTO {

	private String product_id;
	private String product_name;
	private String product_namek;
	private String product_desc;
	private String category_id;
	private String price;
	private String image_file_path;
	private String image_file_name;
	private String release_company;
	private int status;
	private String release_date;


	public String getProduct_name(){
		return product_name;
	}

	public void setProduct_name(String product_name){
		this.product_name=product_name;
	}

	public String getProduct_namek(){
		return product_namek;
	}

	public void setProduct_namek(String product_namek){
		this.product_namek=product_namek;
	}

	public String getProduct_desc(){
		return product_desc;
	}

	public void setProduct_desc(String product_desc){
		this.product_desc=product_desc;
	}

	public String getImage_file_path(){
		return image_file_path;
	}

	public void setImage_file_path(String image_file_path){
		this.image_file_path=image_file_path;
	}

	public String getImage_file_name(){
		return image_file_name;
	}

	public void setImage_file_name(String image_file_name){
		this.image_file_name=image_file_name;
	}
	public String getRelease_company(){
		return release_company;
	}

	public void setRelease_company(String release_company){
		this.release_company=release_company;
	}

	public String getProduct_id(){
		return product_id;
	}

	public void setProduct_id(String product_id){
		this.product_id=product_id;
	}

	public String getCategory_id(){
		return category_id;
	}

	public void setCategory_id(String category_id){
		this.category_id=category_id;
	}

	public String getPrice(){
		return price;
	}

	public void setPrice(String price){
		this.price=price;
	}

	public int getStatus(){
		return status;
	}

	public void setStatus(int status){
		this.status=status;
	}
	public String getRelease_date(){
		return release_date;
	}

	public void setRelease_date(String release_date){
		this.release_date=release_date;;
	}



}
