package fre.mmm.resources;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

import javax.swing.ImageIcon;

import fre.mmm.MAccess;
import fre.mmm.resources.enums.EnumExtensions;

public class Resources {

	private static Resources RESOURCES_INSTANCE;
	
	/** separateur systeme */
	private static final String SEP_SYS = System.getProperty("file.separator");

	/** separateur de l'application. */
	private static final String SEP = "/";
	
	private final String RESOURCES = Resources.class.getPackage().getName(); 
	
	private final String RESOURCES_IMAGES_PATH = Resources.class.getResource("./images").getFile();
	
	private final String RESOURCES_DOCUMENTS_PATH = Resources.class.getResource("./documents").getFile();
	
	private final ResourceBundle RESOURCES_BUNDLE = ResourceBundle.getBundle(RESOURCES + ".Resources");
	
	private final SimpleDateFormat SDF_LOG = new SimpleDateFormat(RESOURCES_BUNDLE.getString("data.date.logsFormat.text"));
	
	private final SimpleDateFormat SDF_LOG_FILENAME = new SimpleDateFormat(RESOURCES_BUNDLE.getString("data.date.logsFileName.text"));
	
	private final SimpleDateFormat SDF_IHM = new SimpleDateFormat(RESOURCES_BUNDLE.getString("data.date.ihm.text"));
	
	public final static String SERIALIZABLE = MAccess.class.getResource("./serializables").getFile();
	
	public final static String SERIALIZABLE_LOGS = SERIALIZABLE + "/logs";
	
	/** Chemin de la racine des packages "utiles" */
	private static final String PACKAGE_RACINE = MAccess.class.getPackage().getName().replace(".", SEP);
	
	/** Chemin de la racine des resources communes de l'appli */
	private static final String COMMON_RACINE = PACKAGE_RACINE + SEP + "common";
	
	/** Racine du package des fichiers de conf et de bd. */
	private static final String FILES_RACINE =  PACKAGE_RACINE + SEP + "common" + SEP + "localdb";
	
	/** Racine des fichiers .properties. */
	private static final String PROPS_DIRECTORY = FILES_RACINE + SEP + "props";
	
	/** Racine des fichiers xml. */
	private static final String XML_DIRECTORY = FILES_RACINE + SEP + "xml";
	
	/** Racine des fichiers csv. */
	private static final String CSV_DIRECTORY = FILES_RACINE + SEP + "csv";
	
	/** Racine des fichiers txt. */
	private final String TXT_DIRECTORY = FILES_RACINE + SEP + "txt";
	
	private Resources(){
		
	}
	
	public static Resources getInstance(){
		
		// Le singleton qui va bien.
		if (RESOURCES_INSTANCE == null) {
			RESOURCES_INSTANCE = new Resources();
		}
		return RESOURCES_INSTANCE;
	}
	
	public String getAppliLabel(String key_){
		return RESOURCES_BUNDLE.getString(key_);
	}
	
	public ImageIcon getAppliImage(String key_){
		ImageIcon image = new ImageIcon(RESOURCES_IMAGES_PATH + "/" + key_);
		return image;
	}
	
	public File getAppliFileDocument(String key_){
		File file = new File(RESOURCES_DOCUMENTS_PATH + "/" + key_);
		return file;
	}
	
	public String getFilenameDateLog(){
		return SDF_LOG_FILENAME.format(new Date());
	}
	public String getFullDateLog(){
		return SDF_LOG.format(new Date());
	}
	
	public String getDateToString(Date date_){
		return SDF_IHM.format(date_);
	}
	
	// ALREADY RUNNING
	/** Titre de la JOPtionPane du already running. */
	public static final String ALREADY_RUN_TITLE = getInstance().getAppliLabel("alreadyrun.title.text");

	/** Message de la JOPtionPane du already running. */
	public static final String ALREADY_RUN_MESSAGE = getInstance().getAppliLabel("alreadyrun.message.text");
	
	/** Nom de la Preference */
	public static final String ALREADY_INSTALLED = getInstance().getAppliLabel("config.alreadyInstalled.text");
	
	/** Numero de port associe a l'instance de l'application */
	public static final int LAUNCH_PORT = 12000;

	// LAndFImpl
	public static String getDefaultLAF() {
		return getInstance().getAppliLabel("laf.default.name");
	}
	
	/**
	 * <b>Methode:  org.se.common.resources.getFilePath()</b><br/>
	 *
	 *<b>Description: </b> Renvoit le chemin du fichier passe en parametre et <br/>
	 * 	renomme le fichier avec la bonne extensio le cas echeant.<br/>
	 *<br/>
	 * @param fileName_
	 * @param type_
	 * @return String
	 */
	public String getFilePath(String fileName_, EnumExtensions type_){
		
		String ext = type_.getExtension(), retour = null, prefix = type_.getRepository() + SEP;
		int begin = 0, end = 0;
		
		if (fileName_.contains(".")) {
			
			begin = fileName_.lastIndexOf(".");
			end = fileName_.length();
			
			for (int i = 0; i < EnumExtensions.values().length; i++) {
				if (!fileName_.substring(begin, end).equals(ext)) {
					retour = prefix + reformat(fileName_, ext, begin, end);
				}else {
					retour = prefix + fileName_;
				}
			}
			
		}else {
			retour = prefix + fileName_ + ext;
		}
		
		return retour;
	}

	/**
	 * <b>Methode:  org.se.common.resources.getRepositoryPath()</b><br/>
	 *
	 *<b>Description: </b> Renvoit le chemin du repertoire passe en parametre.<br/>
	 *<br/>
	 * @param type_
	 * @return String
	 */
	public String getRepositoryPath(EnumExtensions type_){
		return type_.getRepository();
	}
	
	/**
	 * <b>Methode:  org.se.common.resources.reformat()</b><br/>
	 *
	 *<b>Description: </b> Reformate le fichier passe en parametre avec la bonne extension.<br/>
	 *<br/>
	 * @param fileName_
	 * @param ext
	 * @return String
	 */
	private String reformat(String fileName_, String ext, int begin_, int end_) {
		
		String old = fileName_.substring(begin_, end_);
		return fileName_.replace(old, ext);
		
	}
	
	/**
	 * <b>Methode:  org.se.common.resources.get_sep()</b><br/>
	 *
	 *<b>Description: </b> Renvoit le separateur.<br/>
	 *<br/>
	 * @return String
	 */
	public String getSepProj() {
		return SEP;
	}

	public String getSepSystem(){
		return SEP_SYS;
	}
	/**
	 * <b>Methode:  org.se.common.resources.get_fileRacine()</b><br/>
	 *
	 *<b>Description: </b> Renvoit la racine des fichiers de db.<br/>
	 *<br/>
	 * @return String
	 */
	public String getFileRacine() {
		return FILES_RACINE;
	}

	/**
	 * <b>Methode:  org.se.common.resources.get_propsDirectory()</b><br/>
	 *
	 *<b>Description: </b> Renvoit le chemin du repertoire des fichiers de properties.<br/>
	 *<br/>
	 * @return String
	 */
	public String getPropsDirectory() {
		return PROPS_DIRECTORY;
	}

	/**
	 * <b>Methode:  org.se.common.resources.get_xmlDirectory()</b><br/>
	 *
	 *<b>Description: </b> Renvoit le chemin du repertoire des fichiers xml.<br/>
	 *<br/>
	 * @return String
	 */
	public String getXmlDirectory() {
		return XML_DIRECTORY;
	}

	/**
	 * <b>Methode:  org.se.common.resources.get_csvDirectory()</b><br/>
	 *
	 *<b>Description: </b> Renvoit le chemin du repertoire des fichiers csv.<br/>
	 *<br/>
	 * @return String
	 */
	public String getCsvDirectory() {
		return CSV_DIRECTORY;
	}

	/**
	 * <b>Methode:  org.se.common.resources.get_txtDirectory()</b><br/>
	 *
	 *<b>Description: </b> Renvoit le chemin du repertoire des fichiers txt<br/>
	 *<br/>
	 * @return String
	 */
	public String getTxtDirectory() {
		return TXT_DIRECTORY;
	}
	

}
