package fre.mmm.resources.enums;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import fre.mmm.resources.Resources;

public enum EnumDataCheck {

	EMAIL("email"), 
	PHONE("phone");
	
	
	private String _type;
	
	private Resources _resources = Resources.getInstance();
	
	private EnumDataCheck(String type_){
		_type = type_;
	}
	
	public boolean verify(Object objToVerify_){

		// En fonction de ce que l'on veut verifier:
		switch (_type) {
		
			case "email": 
				
				// On utilise les classes qui font deja le cafe.
				Pattern pattern = Pattern.compile(_resources.getAppliLabel("data.email.regex.text"));
				Matcher matcher = pattern.matcher((String) objToVerify_);
				return matcher.matches();
				
			default:
				return true;
		}
	}
}
