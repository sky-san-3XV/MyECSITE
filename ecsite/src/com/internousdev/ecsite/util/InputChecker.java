package com.internousdev.ecsite.util;

public class InputChecker {

	public int result=0;

	public String mailFormat = "^[a-zA-Z0-9!#$%&'_`/=~\\*\\+\\-\\?\\^\\{\\|\\}]+(\\.[a-zA-Z0-9!#$%&'_`/=~\\*\\+\\-\\?\\^\\{\\|\\}]+)*+(.*)@[a-zA-Z0-9][a-zA-Z0-9\\-]*(\\.[a-zA-Z0-9\\-]+)+$";
    public String hiragana="/^[ぁ-ん]+$/";
    public String idchk= "/^[a-zA-Z0-9]+$/";
    public String namechk="/^[a-zA-z一-龥ぁ-ん]/+$";

	public int familychk(String family){

		int numfam=family.length();
		if(numfam>17 || numfam<1 || family.equals(null)){
			result=1;
		}
		if(!family.matches(namechk)){
			result=2;
		}
		return result;
	}
	public int firstchk(String first){

		int numfir=first.length();
		if(numfir>17 || numfir<1 || first.equals(null)){
			result=1;
		}
		if(!first.matches(namechk)){
			result=2;
		}
		return result;
	}
	public int familykchk(String familyk){
		int numfamk=familyk.length();
		if(numfamk>17 || numfamk<1 || familyk.equals(null) ){
			result=1;
		}
		if(!familyk.matches(hiragana)){
			result=2;
		}
		return result;
	}
	public int firstkchk(String firstk){
		int numfirk=firstk.length();
		if(numfirk>17 || numfirk<1 || firstk.equals(null) ){
			result=1;
		}
		if(!firstk.matches(hiragana)){
			result=2;
		}
		return result;
	}
	public int emailchk(String email){
		int emailnum=email.length();
		if(emailnum>33 || emailnum<11 || email.equals(null) ){
			result=1;
		}
		if(!email.matches(mailFormat)){
			result=2;
			}
		return result;
	}

	public int useridchk(String userId){
		int userIdnum=userId.length();
		if(userIdnum>9 || userIdnum<1 || userId.equals(null) ){
			result=1;

		if(!userId.matches(idchk)){
			result=2;
		}
		}
		return result;
	}

	public int passwordchk(String password){
		int passnum=password.length();
		if(passnum>17| passnum<1 || password.equals(null) ){
			result=1;
		}
		if(!password.matches(idchk)){
			result=2;
		}
		return result;
	}





}
