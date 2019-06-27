package com.internousdev.ecsitestudy.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsitestudy.dao.UserInfoDAO;
import com.internousdev.ecsitestudy.dto.UserInfoDTO;
import com.internousdev.ecsitestudy.util.InputChecker;
import com.opensymphony.xwork2.ActionSupport;

public class UserCreateConfirmAction extends ActionSupport implements SessionAware {

	private String family;
	private String first;
	private String familyk;
	private String firstk;
	private int sex;
	private String email;
	private String userId;
	private String shinkipassword;
	Map<String,Object> session;
	UserInfoDTO dto=new UserInfoDTO();
	InputChecker IC=new InputChecker();
	String errormsg1=null;
	String errormsg2=null;
	String errormsg3=null;
	String errormsg4=null;
	String errormsg5=null;
	String errormsg6=null;
	String errormsg7=null;
	String errormsg8=null;
	String errormsg9=null;
	String hiddenpass=null;
	String hiddenpass2=null;



	public String execute() throws SQLException{
		String result=SUCCESS;


		switch(IC.familychk(family)){
		case 1:
			errormsg1="姓は1文字以上16字以内で入力してください。";
			result=ERROR;
			break;

		case 2:
			errormsg1="姓は半角英字、ひらがな、漢字で入力してください。";
			result=ERROR;
			break;
		}

		switch(IC.firstchk(first)){
		case 1:
			errormsg2="名は1字以上16字以内で入力してください。";
			result=ERROR;
			break;

		case 2:
			errormsg2="名は半角英字、ひらがな、漢字で入力してください。";
			result=ERROR;
			break;
		}

		switch(IC.firstkchk(firstk)){

		case 1:
			errormsg3="姓ふりがなは1字以上16字以内で入力してください。";
			result=ERROR;
			break;

		case 2:
		    errormsg3="姓ふりがなはひらがなのみで入力してください。";
		    result=ERROR;
		    break;
		}

		switch(IC.familykchk(familyk)){

		case 1:
			errormsg4="名ふりがなは1字以上16字以内で入力してください。";
			result=ERROR;
			break;

		case 2:
			errormsg4="名ふりがなはひらがなのみで入力してください。";
			result=ERROR;
			break;
		}
		if(sex!=1 && sex!=2 ){
			errormsg5="性別を選択してください。";
			result=ERROR;
		}
		switch(IC.emailchk(email)){

		case 1:
			errormsg6="メールアドレスは10字以上32字以内で入力してください。";
			result=ERROR;
			break;

		case 2:
			errormsg6="正しいメールアドレスを入力してください。";
			result=ERROR;
			break;
		}

		switch(IC.useridchk(userId)){

		case 1:
			errormsg7="ユーザーIDは1字以上8字以内で入力してください。";
			result=ERROR;
			break;

		case 2:
			errormsg7="ユーザーIDは半角英数字で入力してください。";
			result=ERROR;
			break;

		}
		switch(IC.passwordchk(shinkipassword)){

		case 1:
			errormsg8="パスワードは1字以上16字以内で入力してください。";
			result=ERROR;
			break;

		case 2:
			errormsg8="パスワードは半角英数字で入力してください。";
			result=ERROR;
			break;

		case 0:
			int passnum=shinkipassword.length();
			char passhd=shinkipassword.charAt(0);
			String passhed=String.valueOf(passhd);
			StringBuffer hiddenpass=new StringBuffer(passhed);
			String u="*";
			for(int i=1; i<passnum; i++){
				hiddenpass.append(u);
			}
			String hiddenpass2=hiddenpass.toString();
			session.put("hiddenpass", hiddenpass2);
		}



		UserInfoDAO dao=new UserInfoDAO();
		if(dao.CheckSameID(userId)==false){
			errormsg9="そのユーザーIDは既に使用されています。";
			result=ERROR;
		}


		session.put("family", family);
		session.put("first", first);
		session.put("familyk", familyk);
		session.put("firstk", firstk);
		session.put("sex", sex);
		session.put("email", email);
		session.put("userId", userId);
		session.put("shinkipassword", shinkipassword);



		return result;
	}


		public String getFamily(){
			return family;
		}

		public void setFamily(String family){
			this.family=family;
		}

		public String getFirst(){
			return first;
		}

		public void setFirst(String first){
			this.first=first;
		}
		public String getFamilyk(){
			return familyk;
		}

		public void setFamilyk(String familyk){
			this.familyk=familyk;
		}

		public String getFirstk(){
			return firstk;
		}

		public void setFirstk(String firstk){
			this.firstk=firstk;
		}
		public int getSex(){
			return sex;
		}

		public void setSex(int sex){
			this.sex=sex;
		}
		public String getEmail(){
			return email;
		}

		public void setEmail(String email){
			this.email=email;
		}

		public String getUserId(){
			return userId;
		}

		public void setUserId(String userId){
			this.userId=userId;
		}
		public String getShinkipassword(){
			return shinkipassword;
		}

		public void setShinkipassword(String shinkipassword){
			this.shinkipassword=shinkipassword;
		}
		public Map<String,Object> getSession(){
			return session;
		}
		@Override
		public void setSession(Map<String,Object>session){
			this.session=session;
		}

		public String getErrormsg1(){
			return errormsg1;
		}
		public void setErrormsg1(String errormsg1){
			this.errormsg1=errormsg1;
		}

		public String getErrormsg2(){
			return errormsg2;
		}
		public void setErrormsg2(String errormsg2){
			this.errormsg2=errormsg2;
		}
		public String getErrormsg3(){
			return errormsg3;
		}

		public void setErrormsg3(String errormsg3){

			this.errormsg3=errormsg3;

		}public String getErrormsg4(){
			return errormsg4;
		}
		public void setErrormsg4(String errormsg4){
			this.errormsg4=errormsg4;
		}

		public String getErrormsg5(){
			return errormsg5;
		}
		public void setErrormsg5(String errormsg5){
			this.errormsg5=errormsg5;
		}
		public String getErrormsg6(){
			return errormsg6;
		}
		public void setErrormsg6(String errormsg6){
			this.errormsg6=errormsg6;

		}
		public String getErrormsg7(){
			return errormsg7;
		}
		public void setErrormsg7(String errormsg7){
			this.errormsg7=errormsg7;
		}

		public String getErrormsg8(){
			return errormsg8;
		}
		public void setErrormsg8(String errormsg8){
			this.errormsg8=errormsg8;
		}

		public String getErrormsg9(){
			return errormsg9;
		}
		public void setErrormsg9(String errormsg9){
			this.errormsg9=errormsg9;
		}


}





