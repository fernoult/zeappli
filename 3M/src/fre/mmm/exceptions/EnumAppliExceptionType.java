package fre.mmm.exceptions;

import fre.mmm.resources.Resources;

public enum EnumAppliExceptionType {

	NO_USER_EXIST_EXCEPTION("no_user_exist"),
	OBJECT_ALREADY_EXIST_EXCEPTION("already_exist"),
	DATA_FORMAT_EXCEPTION("data_format");
	
	private String _type;
	
	private Resources _resources;
	
	private EnumAppliExceptionType(String type_){
		_type = type_;
		_resources = Resources.getInstance();
	}
	
	public Exception getException(){
		switch (_type) {
		case "no_user_exist":
			return new Exception(_resources.getAppliLabel("exception.user.noUserExist.text"));
		case "already_exist":
			return new Exception(_resources.getAppliLabel("exception.object.objectAlreadyExist.text"));
		case "data_format":
			return new Exception(_resources.getAppliLabel("exception.data.dataFormat.text"));
		default:
			return null;
		}
	}
	
	
}
