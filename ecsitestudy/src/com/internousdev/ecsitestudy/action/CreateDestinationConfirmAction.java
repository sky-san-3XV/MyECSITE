package com.internousdev.ecsitestudy.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsitestudy.util.InputChecker;
import com.opensymphony.xwork2.ActionSupport;


public class CreateDestinationConfirmAction extends ActionSupport implements SessionAware {

	Map<String,Object> session;
	private String faname;
	private String fanamek;
	private String finame;
	private String finamek;
    private String email;
    private String telnum;
    private String address;
    InputChecker IC=new InputChecker();
    private String errmsg1;
    private String errmsg2;
    private String errmsg3;
    private String errmsg4;
    private String errmsg5;
    private String errmsg6;
    private String errmsg7;


    public String execute(){
    	String result=SUCCESS;
    	switch(IC.familychk(faname)){
    	case 1:
    		errmsg1="文字数1";
    		result=ERROR;
    		break;

    	case 2:
    		errmsg1="文字種類1";
    		result=ERROR;
    		break;
    		}
    	switch(IC.firstchk(finame)){
    	case 1:
    		errmsg2="文字数2";
    		result=ERROR;
    		break;

    	case 2:
    		errmsg2="文字種類2";
    		result=ERROR;
    		break;
    	}
    	switch(IC.familykchk(fanamek)){
    	case 1:
    		errmsg3="文字数3";
    		result=ERROR;
    		break;

    	case 2:
    		errmsg3="文字種類3";
    		result=ERROR;
    		break;
    	}
    	switch(IC.firstkchk(finamek)){
    	case 1:
    		errmsg4="文字数4";
    		result=ERROR;
    		break;

    	case 2:
    		errmsg4="文字種類4";
    		result=ERROR;
    		break;
    	}
    	switch(IC.emailchk(email)){
    	case 1:
    		errmsg5="文字数5";
    		result=ERROR;
    		break;

    	case 2:
    		errmsg5="正しいメールアドレスを入力してください（アドレスの形式に即していません）";
    		result=ERROR;
    		break;
    	}
    	switch(IC.telnumchk(telnum)){
    	case 1:
    		errmsg6="文字数6";
    		result=ERROR;
    		break;

    	case 2:
    		errmsg6="半角数字で入力してください";
    		result=ERROR;
    		break;
    	}
    	switch(IC.addresschk(address)){
    	case 1:
    		errmsg7="文字数7";
    		result=ERROR;
    		break;

    	case 2:
    		errmsg7="文字種類7";
    		result=ERROR;
    		break;
    	}

    	session.put("faname", faname);
    	session.put("finame", finame);
    	session.put("fanamek", fanamek);
    	session.put("finamek", finamek);
    	session.put("email", email);
    	session.put("telnum", telnum);
    	session.put("address", address);

    	return result;



    }


    public Map<String,Object> getSession(){
    	return session;
    }

    @Override
    public void setSession(Map<String,Object> session){
    	this.session=session;
    }


    public String getErrmsg1(){
    	return errmsg1;
    }

    public void setErrmsg1(String errmsg1){
    	this.errmsg1=errmsg1;
    }
    public String getErrmsg2(){
    	return errmsg2;
    }

    public void setErrmsg2(String errmsg2){
    	this.errmsg2=errmsg2;
    }
    public String getErrmsg3(){
    	return errmsg3;
    }

    public void setErrmsg3(String errmsg3){
    	this.errmsg3=errmsg3;
    }
    public String getErrmsg4(){
    	return errmsg4;
    }

    public void setErrmsg4(String errmsg4){
    	this.errmsg4=errmsg4;
    }
    public String getErrmsg5(){
    	return errmsg5;
    }

    public void setErrmsg5(String errmsg5){
    	this.errmsg5=errmsg5;
    }
    public String getErrmsg6(){
    	return errmsg6;
    }

    public void setErrmsg6(String errmsg6){
    	this.errmsg6=errmsg6;
    }
    public String getErrmsg7(){
    	return errmsg7;
    }

    public void setErrmsg7(String errmsg7){
    	this.errmsg7=errmsg7;
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


