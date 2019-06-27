package com.internousdev.ecsitestudy.dto;

public class DestinationInfoDTO {


	private String id;
	private String faname;
	private String fanamek;
	private String finame;
	private String finamek;
    private String email;
    private String telnum;
    private String address;


    public String getId(){
    	return id;
    }

    public void setId(String id){

    	this.id=id;
    }
    public String getAddress(){
    	return address;
    }

    public void setAddress(String address){

    	this.address=address;
    }


    public String getFaname(){
    	return faname;
    }

    public void setFaname(String faname){

    	this.faname=faname;
    }

    public String getFanamek(){
    	return fanamek;
    }

    public void setFanamek(String fanamek){

    	this.fanamek=fanamek;
    }

    public String getFiname(){
    	return finame;
    }

    public void setFiname(String finame){

    	this.finame=finame;
    }

    public String getFinamek(){
    	return finamek;
    }

    public void setFinamek(String finamek){

    	this.finamek=finamek;
    }

    public String getEmail(){
    	return email;
    }

    public void setEmail(String email){

    	this.email=email;
    }

    public String getTelnum(){
    	return telnum;
    }

    public void setTelnum(String telnum){

    	this.telnum=telnum;
    }
}
