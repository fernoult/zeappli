package fre.mmm.application.manager;

import java.util.ResourceBundle;
import java.util.prefs.BackingStoreException;
import java.util.prefs.Preferences;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import fre.mmm.MAccess;
import fre.mmm.resources.Resources;
import fre.mmm.resources.enums.EnumMessageDisplayer;
import fre.mmm.utils.FilesUtils;

public class InstallManager {

	/** Instance de la classe de ressources. */
	private static final Resources RESSOURCES = Resources.getInstance();
	
	/** Attribut static du singleton de la classe nstaller. */
	private static InstallManager INSTALL_INSTANCE;
	
	/** Constante du nom du repertoire prncipal de l'installation. */
	private static final String APPLI_NAME = "MultiMissionsManager";
	
	/** Chemin du fichier de properties de l'installer. */
	private static final String INSTALL_PROPS = InstallManager.class.getPackage().getName() + ".Install";
	
	/** Bundle d'access aux proprietes de l'installer. */
	private static final ResourceBundle INSTALL_BUNDLE = ResourceBundle.getBundle(INSTALL_PROPS);
	
	/** Initialisation a vide du chemin d'installation */
	private static String INSTALL_PATH = "";
	
	/** Initialisation a vide du parametrage du FileChooser. */
	private String FILE_CHOOSER_PATH = "";
	
	private Preferences PREFS = Preferences.userNodeForPackage(MAccess.class);
	
	private String FLAG = Resources.ALREADY_INSTALLED;
	
	/**
	 * Constructeur prive.
	 */
	private InstallManager(){
		
	}
	
	/**
	 * <b>Methode:  org.se.install.getInstance()</b><br/>
	 *
	 *<b>Description: </b> Singleton de la classe Installer.<br/>
	 *	Renvoit une instance de cette classe qui permet d'utiliser ses methodes publiques.
	 *<br/>
	 * @return Installer
	 */
	public static InstallManager getInstance(){
		
		// Si l'instance de la classe Installer est nulle:
		if (INSTALL_INSTANCE == null) {
			
			// Instanciation de la Classe installer.
			INSTALL_INSTANCE = new InstallManager();
		}
		
		// Retourne la classe Installer.
		return INSTALL_INSTANCE;
	}
	
	/**
	 * <b>Methode:  org.se.install.getLabel()</b><br/>
	 *
	 *<b>Description: </b> Renvoit la valeur correspondant a la cle passee en parametre.<br/>
	 *<br/>
	 * @param key_
	 * @return String
	 */
	public static String getLabel(String key_){
		
		// Retourne la valeur.
		return INSTALL_BUNDLE.getString("installer.isInstalled");
	}
	
	/**
	 * <b>Methode:  org.se.install.install()</b><br/>
	 *
	 *<b>Description: </b> Lance l'installation de l'application par le deploiement de l'arborescence<br/>
	 *	sur le systeme hote. 
	 *	Positionne la valeur True sur le fichier de configuration pour le prochain demarrage.
	 *<br/>
	 * @param confObj_ void
	 */
	public void install(){
		
		// Tentative de deploiement de l'arborescence.
		// Si le deploiement s'effectue bien:
		if (deploie()) {
			
			// Affichage du log en console.
			EnumMessageDisplayer.SUCCES.logMessage("Succes de l'installation.");
		}else { // Sinon:
			
			// Affichage du log en console
			// et la PopUp d'erreur affichee a l'ecran.
			EnumMessageDisplayer.ERROR.logMessage("echec de l'installation.");
			JOptionPane.showMessageDialog(null, INSTALL_BUNDLE.getString("installer.message.erreurInstall.text"), 
					INSTALL_BUNDLE.getString("installer.message.titre.erreur.text"), JOptionPane.ERROR_MESSAGE);
			
			// Sortie forcee du processus.
			System.exit(0);
		}

	}
	
	/**
	 * <b>Methode:  org.se.install.isAlreadyInstalled()</b><br/>
	 *
	 *<b>Description: </b> Booleen de controle si l'application est deja installee ou non.<br/>
	 *<br/>
	 * @return boolean
	 */
	public boolean isAlreadyInstalled(){
		
		try {
			
			if (!PREFS.nodeExists(FLAG)) {
				return false;
			}
		} catch (BackingStoreException e) {
			EnumMessageDisplayer.ERROR.displayException(e);
		}
		return true;
	}
	
	/**
	 * <b>Methode:  org.se.install.removePrefs()</b><br/>
	 *
	 *<b>Description: </b> Remove de la preference already running et du path.<br/>
	 *<br/> void
	 */
	public void removePrefs() {
		
		PREFS.remove(FLAG);
		EnumMessageDisplayer.SUCCES.logMessage(" Remove des preferences.");
	}

	/**
	 * <b>Methode:  org.se.install.deploie()</b><br/>
	 *
	 *<b>Description: </b> Deploi l'arborescence de l'application.<br/>
	 *<br/>
	 * @return boolean
	 */
	private static boolean deploie(){
		
		String path = null;
		
		// Affichage du log en console.
		JOptionPane.showMessageDialog(null, INSTALL_BUNDLE.getString("installer.message.directive.text"));
		
		// On declenche le FileChooser.
		String fileChooserPath = getInstance().getFileChooserPath();
		if (fileChooserPath.equals("")) {
			fileChooserPath = System.getProperty("user.home");
		}
		JFileChooser jfc = new JFileChooser(fileChooserPath);
		jfc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		
		if (jfc.showOpenDialog(jfc) == 0) {
			
			// On recupere le path d'installation.
			path = jfc.getSelectedFile().getAbsolutePath();
			INSTALL_PATH = path + RESSOURCES.getSepSystem() + APPLI_NAME;
			
			// On declenche la creation de l'arborescnece.
			if (!FilesUtils.getInstance().createArbo(path + RESSOURCES.getSepSystem() + APPLI_NAME)) {
				EnumMessageDisplayer.WARNING.logMessage(INSTALL_PATH);
				return false;
			}else {
				getInstance().getPREFS().put("CONFIG_PATH", path + RESSOURCES.getSepSystem() + APPLI_NAME + 
						RESSOURCES.getSepSystem() + "conf" + RESSOURCES.getSepSystem() + "conf.xml");
			}
			
		}else {
			EnumMessageDisplayer.ERROR.logMessage("deploie FAILED!");
			return false;
		}

		JOptionPane.showMessageDialog(null, INSTALL_BUNDLE.getString("installer.message.confirm.text") + path + RESSOURCES.getSepSystem() + APPLI_NAME,
				INSTALL_BUNDLE.getString("installer.message.titre.succes.text"), JOptionPane.INFORMATION_MESSAGE);
		return true;
	}

	/**
	 * <b>Methode:  org.se.install.getInstallPath()</b><br/>
	 *
	 *<b>Description: </b> Renvoit le chemin d'installation.<br/>
	 *<br/>
	 * @return String
	 */
	public static String getInstallPath(){
		return INSTALL_PATH;
	}
	
	/**
	 * <b>Methode:  org.se.install.getFileChooserPath()</b><br/>
	 *
	 *<b>Description: </b> Renvoit le parametrage du FileChooser.<br/>
	 *<br/>
	 * @return String
	 */
	public String getFileChooserPath(){
		return FILE_CHOOSER_PATH;
	}
	
	/**
	 * <b>Methode:  org.se.install.setFileChooserPath()</b><br/>
	 *
	 *<b>Description: </b> Initialise le parametrage du FileChooser.<br/>
	 *<br/>
	 * @param fileChooserFilePath_ void
	 */
	public void setFileChooserPath(String fileChooserFilePath_){
		FILE_CHOOSER_PATH = fileChooserFilePath_;
	}

	public Preferences getPREFS() {
		return PREFS;
	}

	public void setPREFS(Preferences pREFS) {
		PREFS = pREFS;
	}

	
	
	
}
