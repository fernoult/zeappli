/* ihmref-Ressources.java
 * HISTORIQUE
 *
 * [MODIF]: Version - le 8 avr. 2015 - Creation de la classe.
 *
 * FIN HISTORIQUE
 */
package fre.mmm.views;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

import fre.mmm.exceptions.InternalException;
import fre.mmm.resources.Resources;
import fre.mmm.resources.enums.EnumMessageDisplayer;
import fre.mmm.views.erreurs.ErrorFrame;
import fre.mmm.views.laf.impl.LAndFImpl;
import fre.prefs.PrefsGUI;

public class ViewsRessources {

	private static ViewsRessources RES_INSTANCE;
	private String[] LAF_LIST; 
	private static String LAF_PATH = LAndFImpl.class.getPackage().getName() + ".Landf";
	private static String LIBELLES_PATH = ViewsRessources.class.getPackage().getName() + ".Libelles";
	private static String FRAMES_PROPS_PATH = PFrame.class.getPackage().getName() + ".PFrame";
	private PrefsGUI PREFS = PrefsGUI.getInstance();
	private String IMGS_RACINE = Resources.class.getResource("." + Resources.getInstance().getSepProj() + "images").getFile();
	private static String ERREUR_PATH = InternalException.class.getPackage().getName() + ".ErrorLabels";
	
	
	private ViewsRessources(){
		
	}
	
	public static ViewsRessources getInstance(){
		
		// Le singleton qui va bien.
		if (RES_INSTANCE == null) {
			RES_INSTANCE = new ViewsRessources();
		}
		return RES_INSTANCE;
	}
	
	public String getLibelleValue(String key_){
		String chaine = null;
		try {
			chaine = ResourceBundle.getBundle(LIBELLES_PATH, PrefsGUI.getInstance().getLocale()).getString(key_);
			
		} catch (MissingResourceException e) {
			EnumMessageDisplayer.ERROR.displayException(e);
		}
		return chaine;
	}
	
	public String getErrorValue(String key_){
		return ResourceBundle.getBundle(ERREUR_PATH, PrefsGUI.getInstance().getLocale()).getString(key_);
	}
	
	public String getLafValue(String key_){
		return ResourceBundle.getBundle(LAF_PATH, PrefsGUI.getInstance().getLocale()).getString(key_);
	}
	
	public String getPFrameLabel(String key_){
		String chaine = null;
		try {
			chaine = ResourceBundle.getBundle(FRAMES_PROPS_PATH).getString(key_);
			
		} catch (MissingResourceException e) {
			EnumMessageDisplayer.ERROR.displayException(e);
		}
		return chaine;
	}
	
	public String[] getLibelleButtonValues(String key_){
		// TODO Ca plante ici, tu as un petit probl�me de Local  (en fait d'init de tes pr�f�rences)
		return ResourceBundle.getBundle(LIBELLES_PATH, PrefsGUI.getInstance().getLocale()).getString(key_).split("@");
	}
	
	public Dimension getSreenSize(){
		return Toolkit.getDefaultToolkit().getScreenSize();
	}
	
	public String[] getLafAvaible(){
		
		LAF_LIST = getInstance().getLafValue("laf.dispo.list.values").split(" ");
		
		for (int i = 0; i < LAF_LIST.length; i++) {
			LAF_LIST[i] = LAF_LIST[i].trim();
		}
		return LAF_LIST;
	}
	
	public String getPrefixLaf(){
		return getInstance().getLafValue("laf.dispo.prefix.value");// 
	}
	
	public void updateLocale(Locale locale_){
		
		PREFS.updateLOC(locale_);
	}
	
	public void updateLookAndFeel(String laf_){
		
		PREFS.updateLAF(laf_);
	}
	
	public void setLocale(Locale locale_){
		
	}
	
	public void setLookAndFeel(String laf_){
		
	}
	
	public String getImgsPath(){
		return Resources.getInstance().getSepProj() 
				+ IMGS_RACINE.replace(".", Resources.getInstance().getSepProj());
	}

}
