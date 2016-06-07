package fre.mmm.resources.enums;

import java.text.MessageFormat;

import javax.swing.JOptionPane;

import fre.mmm.resources.Resources;
import fre.mmm.utils.LogsUtils;
import fre.mmm.views.erreurs.ErrorFrame;

public enum EnumMessageDisplayer {

	ERROR("error"),
	SUCCES("succes"),
	INFO("info"),
	WARNING("warning");
	
	private String _type;
	
	private Resources _resources = Resources.getInstance();
	
	private LogsUtils _logsutils = LogsUtils.getInstance();
	
	private EnumMessageDisplayer(String type_){
		_type = type_;
	}
	
	public void logMessage(String message_){
		
		String [] tabObjMessageFormater = {_resources.getFullDateLog(), message_};
		
		switch (_type) {
		case "error":
			_logsutils.writeOnLog(MessageFormat.format(_resources.getAppliLabel("message.logErreur.text"), tabObjMessageFormater));
			System.err.println(MessageFormat.format(_resources.getAppliLabel("message.logErreur.text"), tabObjMessageFormater));
			break;
		case "succes":
			_logsutils.writeOnLog(MessageFormat.format(_resources.getAppliLabel("message.logSucces.text"), tabObjMessageFormater));
			System.out.println(MessageFormat.format(_resources.getAppliLabel("message.logSucces.text"), tabObjMessageFormater));
			break;
		case "info":
			_logsutils.writeOnLog(MessageFormat.format(_resources.getAppliLabel("message.logInfo.text"), tabObjMessageFormater));
			System.out.println(MessageFormat.format(_resources.getAppliLabel("message.logInfo.text"), tabObjMessageFormater));
			break;
		case "warning":
			_logsutils.writeOnLog(MessageFormat.format(_resources.getAppliLabel("message.logWarning.text"), tabObjMessageFormater));
			System.err.println(MessageFormat.format(_resources.getAppliLabel("message.logWarning.text"), tabObjMessageFormater));
			break;
		default:
			break;
		}
	}
	
	public void displayMessage(String message_){
		
		switch (_type) {
		case "error":
			JOptionPane.showMessageDialog(null, message_, "ERREUR", JOptionPane.ERROR_MESSAGE);
			break;
		case "succes":
			JOptionPane.showMessageDialog(null, message_, "SUCCES", JOptionPane.INFORMATION_MESSAGE);
			break;
		case "info":
			JOptionPane.showMessageDialog(null, message_, "INFORMATION", JOptionPane.INFORMATION_MESSAGE);
			break;
		case "warning":
			JOptionPane.showMessageDialog(null, message_, "WARNING", JOptionPane.WARNING_MESSAGE);
			break;
		default:
			break;
		}
	}
	
	public void displayException(Exception excep_){
		
		String [] tabObjMessageFormater = {_resources.getFullDateLog(), excep_.getClass().getName() + " - " + excep_.getMessage()};
		_logsutils.writeOnLog(MessageFormat.format(_resources.getAppliLabel("message.logErreur.text"), tabObjMessageFormater));
		System.err.println(MessageFormat.format(_resources.getAppliLabel("message.logErreur.text"), tabObjMessageFormater));
		new ErrorFrame(excep_.getClass().toString(), excep_.getStackTrace());
	}
}
