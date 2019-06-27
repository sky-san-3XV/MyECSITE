package com.internousdev.ecsitestudy.dto;

public class BuyItemDTO {

	private String pName;
	private String pNamekana;
	private int price;

	public String getPName(){
		return pName;
	}
	public void setPName(String pName){
		this.pName=pName;
	}

	public String getPnamekana(){
		return pNamekana;
	}
	public void setPNamekana(String pNamekana){
		this.pNamekana=pNamekana;
	}

	public int getPrice(){
		return price;
	}
	public void setPrice(int price){
		this.price=price;
	}
}

