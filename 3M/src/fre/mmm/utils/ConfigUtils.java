package fre.mmm.utils;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.prefs.Preferences;

import javax.swing.JOptionPane;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

import fre.mmm.MAccess;
import fre.mmm.conf.IConfig;
import fre.mmm.conf.impl.ConfigImpl;
import fre.mmm.resources.Resources;
import fre.mmm.resources.enums.EnumMessageDisplayer;
import fre.mmm.views.erreurs.ErrorFrame;

public class ConfigUtils {

	private static ConfigUtils CU_INSTANCE;
	
	private InputStream _is;
	
	private ObjectInputStream _ois;
	
	private FileOutputStream _fos;
	
	private ObjectOutputStream _oos;
	
	private Resources _ressources = Resources.getInstance();
	
	private IConfig _configObj;
	
	private ConfigUtils(){
		
	}
	
	public static ConfigUtils getInstance(){
		if (CU_INSTANCE == null) {
			CU_INSTANCE = new ConfigUtils();
		}
		return CU_INSTANCE;
	}
	
	public IConfig getConfigObject(){
		
		IConfig confObj = new ConfigImpl();
		Preferences prefs = Preferences.userNodeForPackage(MAccess.class);

		try {
			Document document = FilesUtils.getInstance().readXMLFile(prefs.get("CONFIG_PATH", ""), "NOT_LOCAL");
			Element elem = document.getRootElement();
			List<Element> liste = elem.getChildren();
			for (Iterator<Element> iterator = liste.iterator(); iterator.hasNext();) {
				Element element = iterator.next();
				
				if (element.getName().equals("INSTALED")) {
					confObj.set_installed(element.getValue());
					
				}else if (element.getName().equals("APP_PATH")) {
					confObj.set_appliRacine(element.getValue());
					
				}else if (element.getName().equals("DBA_PATH")) {
					confObj.set_dbRacine(element.getValue());
					
				}else if (element.getName().equals("CONF_PATH")) {
					confObj.set_confRacine(element.getValue());
					
				}
			}
		} catch (JDOMException e) {
			EnumMessageDisplayer.ERROR.displayException(e);
		} catch (IOException e) {
			EnumMessageDisplayer.ERROR.displayException(e);
		}
		
		return confObj;
	}
	
	/**
	 * <b>Methode:  org.se.common.utils.createConfigObject()</b><br/>
	 *
	 *<b>Description: </b> Cree et renvoit un objet ConfigImpl a partir des parametres passes a la methode.<br/>
	 *<br/>
	 * @param configTab_
	 * @return ConfigImpl
	 */
	public IConfig createConfigObject(String[] configTab_, ArrayList<String> listeReps_){
		
		// Cration de l'objet de conf.
		
		IConfig confObj = new ConfigImpl();
		
		confObj.set_installed(configTab_[3]);
		
		for (Iterator<String> iterator = listeReps_.iterator(); iterator.hasNext();) {
			String rep = iterator.next();
			
			if (!rep.contains("conf") && !rep.contains("xml") && !rep.contains("csv")) {
				confObj.set_appliRacine(rep);
			}else if (rep.contains("conf")) {
				confObj.set_confRacine(rep);
			}else {
				confObj.set_dbRacine(rep.substring(0, rep.lastIndexOf(_ressources.getSepSystem())));
			}
		}
		
		return confObj;
	}
	
	public boolean writeConfigObject(IConfig confObj_, String path_){
		
		String confxml = _ressources.getSepProj() + _ressources.getXmlDirectory() + _ressources.getSepProj() + "users.xml";	// Chemin du fichier xml

		// Chargement du fichier xml.
		Document document = null;
		Element racine = null;
		try {
			document = FilesUtils.getInstance().readXMLFile(confxml, "LOCAL");
			racine = document.getRootElement();
		} catch (JDOMException jdomexcep) {
			JOptionPane.showMessageDialog(null, jdomexcep.getMessage() + "\nChemin : " + confxml);
			return false;
		} catch (IOException ioexcep) {
			JOptionPane.showMessageDialog(null, ioexcep.getMessage() + "\nChemin : " + confxml);
			return false;
		}

		// On initialise le user
		Element installed = new Element("INSTALLED");
		Element app_path = new Element("APP_PATH");
		Element dba_path = new Element("DBA_PATH");
		Element conf_path = new Element("CONF_PATH");
		
		installed.setText(confObj_.get_installed());
		app_path.setText(confObj_.get_appliRacine());
		dba_path.setText(confObj_.get_dbRacine());
		conf_path.setText(confObj_.get_confRacine());
		
		racine.addContent(installed);
		racine.addContent(app_path);
		racine.addContent(dba_path);
		racine.addContent(conf_path);

		XMLOutputter outputter = new XMLOutputter(Format.getPrettyFormat());
		
		try {
			outputter.output(document, new FileOutputStream(path_));
		} catch (FileNotFoundException e) {
			EnumMessageDisplayer.ERROR.displayException(e);
			return false;
		} catch (IOException e) {
			EnumMessageDisplayer.ERROR.displayException(e);
			return false;
		}

		return true;
	}


	public IConfig get_configObj() {
		return _configObj;
	}

	public void set_configObj(IConfig _configObj) {
		this._configObj = _configObj;
	}
	
	
	
}
