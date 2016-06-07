package fre.mmm.resources.enums;

public enum EnumCompagny {

	ADS("ads"),
	TAS("tas"),
	CNES("cnes");
	
	private String _type;
	
	private String _compagnyName;
	
	private EnumCompagny(String type_){
		initEnumCompagny(type_);
	}
	
	private void initEnumCompagny(String type_){
		
		switch (type_) {
		case "ads":
			_compagnyName = "Airbus Defense & Space";
			break;
		case "tas":
			_compagnyName = "Thales Alenia Space";
			break;
		case "cnes":
			_compagnyName = "CNES";
			break;
		default:
			break;
		}
	}
	
	@Override
	public String toString() {
		return _compagnyName;
	}
}
