package fre.mmm;

import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.net.ServerSocket;
import java.util.prefs.BackingStoreException;
import java.util.prefs.Preferences;

import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import fre.mmm.application.manager.ApplicationManager;
import fre.mmm.application.manager.InstallManager;
import fre.mmm.conf.IConfig;
import fre.mmm.databases.manager.DBEmbededManager;
import fre.mmm.resources.Resources;
import fre.mmm.resources.enums.EnumMessageDisplayer;
import fre.mmm.utils.ConfigUtils;
import fre.mmm.utils.FilesUtils;
import fre.mmm.utils.LogsUtils;
import fre.mmm.views.ExploraterFrame;
import fre.mmm.views.RunSplashScreen;
import fre.prefs.PrefsGUI;


public class MAccess {
	
	protected static ApplicationManager _applicationManager;
	
	/** Les ressources. */
	private static Resources _ressources = Resources.getInstance();
	
	protected static boolean _isSimu = false;
	
	public static void main(String[] args) {
		// Init du demarrage.
		checkArguments(args);
		initObjectsManager();
		fixLookAndFeel();
		
		
		// On initialise les Préférences.
		PrefsGUI.getInstance().initPrefs();
		
		// On initialise les attributs de ressources.
		// et le logger.
		initResourcesAttributes();
		initLogManager();
		
		// On verifie qu'une autre instance de l'appli ne tourne pas deja,
		// on positionne le LookAndFeel, check les arguments et check si l'application
		// n'est pas deja installee sur le poste.
		checkAlreadyRunning();			
		fixLookAndFeel();				
		checkArguments(args);			
		checkAlreadyInstalled();		
		
		System.out.println("===================================================================================================");
		
		// On lance la fenetre de demarrage.
	    RunSplashScreen splash = new RunSplashScreen(4000);
	    splash.showSplashAndExit();	
		new ExploraterFrame("MMM_EXPLORATEUR");
//		new TestSimuFrame();
		
		
	}
	
	private static void checkAlreadyRunning(){
		
		try {
			
			// On instancie une ServerSocket dans la JVM sur un numero de port.
			// Si une deuxieme tentatice d'instanciation sur ce meme numero de port est faite, la JVM refusera et levera une erreur.
			ServerSocket servsock = new ServerSocket(Resources.LAUNCH_PORT);
			
			// Affichage du log en console.
			EnumMessageDisplayer.INFO.logMessage(_ressources.getAppliLabel("logs.install.AlreadyRunning.text") + servsock.getLocalPort());
		} catch (IOException e) {
			
			// Affichage du log en console.
			EnumMessageDisplayer.ERROR.logMessage(Resources.ALREADY_RUN_MESSAGE);
			
			// Positionne le LookAndFeel.
			fixLookAndFeel();
			
			// PopUp d'erreur affichee a l'ecran.
			JOptionPane.showMessageDialog(null, Resources.ALREADY_RUN_MESSAGE, 
					Resources.ALREADY_RUN_TITLE, JOptionPane.ERROR_MESSAGE);
			
			// Sortie forcee du processus.
			System.exit(0);
		}
		
	}
	
	private static void checkAlreadyInstalled() {
		
		Preferences prefs = Preferences.userNodeForPackage(MAccess.class);
		String flag = Resources.ALREADY_INSTALLED;
		
		// Affichage du log en console.
		EnumMessageDisplayer.INFO.logMessage(_ressources.getAppliLabel("logs.install.AlreadyInstalled.text") + prefs.getBoolean(flag, true));
		
			if (prefs.getBoolean(flag, true)) {
				prefs.putBoolean(flag, false);
				try {
					prefs.flush();
				} catch (BackingStoreException bse) {
					EnumMessageDisplayer.ERROR.displayException(bse);
				}
				InstallManager.getInstance().install();
			}

	}

	/**
	 * 
	 * <b>Methode: org.tref.checkArguments()</b><br/>
	 *
	 * <b>Description: </b> <br/>
	 * 		Verifie les arguments passes en parametres.<br/>
	 * <b>Tags: </b> <br/>
	 * <br/>
	 * @param args_
	 */
	private static void checkArguments(String[] args_){

		// Affichage du log en console.
		Object[] tab = {args_.length};
		EnumMessageDisplayer.INFO.logMessage(_ressources.getAppliLabel("logs.install.CheckArguments.text"));
		
		// Si il y a u argument au lancement:
		if (args_ != null && args_.length > 0 && args_.length < 2) {
			switch (args_[0]) {
			case "dev":
				
				// Parametre dev indique que l'application est lancee en mode developpement et 
				// que le path du filechooser d'install est directement positionn� sur un repertoire de test.
				File file = new File(System.getProperty("user.home") + Resources.getInstance().getSepProj() + "DEPLOIE_TEST");
				
				if (file.exists()) {
					InstallManager.getInstance().setFileChooserPath(file.getAbsolutePath());	
				}else {
					try {
						file.createNewFile();
						InstallManager.getInstance().setFileChooserPath(file.getAbsolutePath());
					} catch (IOException e) {
						EnumMessageDisplayer.ERROR.displayException(e);
					}
				}
				break;
				
			case "remove":
				
				// Remove du parametre des preferences JVM.
				InstallManager.getInstance().removePrefs();

				// Detruit l'arborescence deployee.
				IConfig conf = ConfigUtils.getInstance().getConfigObject();
				FilesUtils.getInstance().removeArbo(conf.get_appliRacine(), conf);
				
				JOptionPane.showMessageDialog(null, _ressources.getAppliLabel("popup.desinstallation.message.text"), 
						_ressources.getAppliLabel("popup.desinstallation.titre.text"), JOptionPane.INFORMATION_MESSAGE);
				System.exit(0);
				break;
				
			case "simu":
				_isSimu = true;
				break;
			case "resetdb":
				try {
					DBEmbededManager.getInstance().dropShema();
					Thread.sleep(1000);
					DBEmbededManager.getInstance().initEmbededDB();
				} catch (InterruptedException e) {
					EnumMessageDisplayer.ERROR.logMessage(e.getMessage());
				}
				break;
			default:
				break;
			}
		}	// Sinon, on ne fait rien et il y a un lancement normal.
	}
	
	private static void fixLookAndFeel(){
		
		// Affichage du log en console.
		EnumMessageDisplayer.INFO.logMessage("Positionne le LAF.");
		
		try {
			
			// On positione le LAndFImpl par defaut.
			UIManager.setLookAndFeel("com.jtattoo.plaf.fast.FastLookAndFeel");
			
			UIManager.put("ProgressBar.background", Color.WHITE);
			UIManager.put("ProgressBar.foreground", Color.decode("#0B3861"));
			UIManager.put("ProgressBar.selectionBackground", Color.BLACK);  
			UIManager.put("ProgressBar.selectionForeground",Color.decode("#CEE3F6"));
			
		} catch (ClassNotFoundException e) {
			EnumMessageDisplayer.ERROR.logMessage(e.getMessage());
		} catch (InstantiationException e) {
			EnumMessageDisplayer.ERROR.logMessage(e.getMessage());
		} catch (IllegalAccessException e) {
			EnumMessageDisplayer.ERROR.logMessage(e.getMessage());
		} catch (UnsupportedLookAndFeelException e) {
			EnumMessageDisplayer.ERROR.logMessage(e.getMessage());
		}
	}
	
	private static void initObjectsManager(){
		_applicationManager = ApplicationManager.getInstance();			
	}
	
	private static void initLogManager(){
		LogsUtils.getInstance();
		EnumMessageDisplayer.INFO.logMessage(Resources.getInstance().getAppliLabel("message.access.run.text"));
	}
	
	/**
	 * 
	 * <b>Methode: org.tref.initResourcesAttributes()</b><br/>
	 *
	 * <b>Description: </b> <br/>
	 * 		Initialise les attributs de ressources.<br/>
	 * <b>Tags: </b> <br/>
	 * <br/>
	 */
	private static void initResourcesAttributes(){
		
		// Init des ressources.
		_ressources = Resources.getInstance();
	}

}
