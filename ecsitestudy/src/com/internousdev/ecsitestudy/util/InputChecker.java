package com.internousdev.ecsitestudy.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputChecker {

 private String alpnump="^[0-9a-zA-Z]+$";
 private String emailchk="^[a-zA-Z0-9!#$%&'_`/=~\\*\\+\\-\\?\\^\\{\\|\\}]+(\\.[a-zA-Z0-9!#$%&'_`/=~\\*\\+\\-\\?\\^\\{\\|\\}]+)*+(.*)@[a-zA-Z0-9][a-zA-Z0-9\\-]*(\\.[a-zA-Z0-9\\-]+)+$";
 private String namechk="^[a-zA-zぁ-んァ-ン一-龥]+$";
 private String kanachk="^[ぁ-ん]+$";
 private String telchk="^[0-9]+$";
 private String addchk="^[0-9a-zA-zぁ-んァ-ン一-龥]+$";
 private String inputchk="^[0-9a-zA-zぁ-んァ-ン一-龥 　]+$";

	public  int familychk(String family){

		int numfam=family.length();
		int result=0;
		Pattern p=Pattern.compile(namechk);
		Matcher m=p.matcher(family);

		if(numfam>=17 || numfam<1 || family.equals(null)){
			result=1;
		}
		else if(m.find()==false){
			result=2;
		}



		return result;
	}
	public int firstchk(String first){
		int result=0;
		Pattern p=Pattern.compile(namechk);
		Matcher m=p.matcher(first);
		int numfir=first.length();
		if(numfir>=17 || numfir<1 || first.equals(null)){
			result=1;
		}
		else if(m.find()==false){
			result=2;
		}


		return result;
	}
	public int familykchk(String familyk){
		int numfamk=familyk.length();
		int result=0;
		Pattern p=Pattern.compile(kanachk);
		Matcher m=p.matcher(familyk);
		if(numfamk>=17 || numfamk<1 || familyk.equals(null) ){
			result=1;
		}
		else if(m.find()==false){
			result=2;
		}


		return result;
	}
	public int firstkchk(String firstk){
		int numfirk=firstk.length();
		int result=0;
		Pattern p=Pattern.compile(kanachk);
		Matcher m=p.matcher(firstk);
		if(numfirk>=17 || numfirk<1 || firstk.equals(null) ){
			result=1;
		}
		else if(m.find()==false){
			result=2;
		}

		return result;
	}
	public int emailchk(String email){
		int result=0;
		int emailnum=email.length();
		Pattern p=Pattern.compile(emailchk);
		Matcher m=p.matcher(email);

		if(emailnum>=33 || emailnum<=9 || email.equals(null) ){
			result=1;
		}
		else if(m.find()==false){
			result=2;
		}

		return result;
	}

	public int useridchk(String userId){
		int userIdnum=userId.length();
		int result=0;
		Pattern p=Pattern.compile(alpnump);
		Matcher m=p.matcher(userId);
		if(userIdnum>9 || userIdnum<0 || userId.equals(null) ){
			result=1;
		}
		else if(m.find()==false){
			result=2;

		}

		return result;
	}

	public int passwordchk(String password){
		int passnum=password.length();
		int result=0;
		Pattern p=Pattern.compile(alpnump);
		Matcher m=p.matcher(password);
		if(passnum>=17 || passnum<1 || password.equals(null) ){
			result=1;
		}
		else if(m.find()==false){
			result=2;
		}
		return result;
	}

	public int telnumchk(String telnum){
		int telnumnum=telnum.length();
		int result=0;
		Pattern p=Pattern.compile(telchk);
		Matcher m=p.matcher(telnum);
		if(telnumnum>=14 || telnumnum<=9 || telnum.equals(null) ){
			result=1;
		}
		else if(m.find()==false){
			result=2;
		}
		return result;

	}

	public int addresschk(String address){
		int addnum=address.length();
		int result=0;
		Pattern p=Pattern.compile(addchk);
		Matcher m=p.matcher(address);
		if(addnum>=51 || addnum<=9 || address.equals(null)){
			result=1;
		}
		else if(m.find()==false){
			result=2;
		}
		return result;
	}

	public int searchwdchk(String searchwords){
		int search=searchwords.length();
		int result=0;
		Pattern p=Pattern.compile(inputchk);
		Matcher m=p.matcher(searchwords);
		if(search>51){
			result=1;
		}else if(m.find()==false && !searchwords.equals("")){
			result=2;
		}
		return result;
	}





}
