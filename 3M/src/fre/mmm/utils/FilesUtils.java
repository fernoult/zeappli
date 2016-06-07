package fre.mmm.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;

import org.jdom2.Document;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

import fre.mmm.MAccess;
import fre.mmm.conf.IConfig;
import fre.mmm.resources.Resources;
import fre.mmm.resources.enums.EnumMessageDisplayer;
import fre.mmm.views.erreurs.ErrorFrame;

public class FilesUtils {
	
	private static FilesUtils FILES_UTILS_INSTANCE;
	
	private ArrayList<String> _listeReps = new ArrayList<>();
	
	private ArrayList<String> _listefiles = new ArrayList<>();

	private static final Resources _ressources = Resources.getInstance();
	
	private FileOutputStream _copyXmlConfPath;
	
	private FilesUtils(){
		
	}
	
	public static FilesUtils getInstance(){
		if (FILES_UTILS_INSTANCE == null) {
			FILES_UTILS_INSTANCE = new FilesUtils();
		}
		return FILES_UTILS_INSTANCE;
	}
	
	public static void createFile(File file_){
		
	}
	
	public static void createDirectory(File file_, boolean forceCreate_){
		
		if (!file_.exists()) {
			file_.mkdirs();
		}else if (forceCreate_) {
			file_.mkdirs();
		}
	}
	
	private static boolean createFile(String repositoryPath_, String fileName_){
		
		File file = new File(repositoryPath_ + fileName_);
		try {
			file.createNewFile();
		} catch (IOException e) {
			new ErrorFrame(e.getClass().toString(), e.getStackTrace());
		}
		return true;
	}
	
	private static boolean createFile(String fullPath_){
		
		File file = new File(fullPath_);
		try {
			file.createNewFile();
			EnumMessageDisplayer.INFO.logMessage("Creation du fichier " + fullPath_);
		} catch (IOException e) {
			EnumMessageDisplayer.ERROR.displayException(e);
			return false;
		}
		return true;
	}
	
	public static boolean createRepository(String path_){
		
		File file = new File(path_);
		if (!file.exists()) {
			file.mkdirs();
			EnumMessageDisplayer.INFO.logMessage("creation du repertoire " + path_);
		}else {
			EnumMessageDisplayer.ERROR.logMessage("echec de la creation de " + path_);
			return false;
		}
		return true;
	}
	
	/**
	 * <b>Methode:  org.se.common.utils.createArbo()</b><br/>
	 *
	 *<b>Description: </b> Cree l'arborescence de repertoires et fichiers.<br/>
	 *<br/>
	 * @param path_
	 * @return boolean
	 */
	synchronized public boolean createArbo(String path_){
		
		// Initialise les chemins des repertoires.
		_listeReps.add(path_);
		_listeReps.add(path_ + _ressources.getSepSystem() + "db" + _ressources.getSepSystem() + "xml");
		_listeReps.add(path_ + _ressources.getSepSystem() + "db" + _ressources.getSepSystem() + "csv");
		_listeReps.add(path_ + _ressources.getSepSystem() + "conf");
		
		// Initialise les chemins des fichiers.
		_listefiles.add(path_ + _ressources.getSepSystem() + "conf" + _ressources.getSepSystem() + "conf.xml");
		
		File files = new File(path_);
		
		if (!files.exists()) {
			
			String confPath = null;
			
			try {
				// Creation des repertoires.
				for (Iterator<String> iterator = _listeReps.iterator(); iterator.hasNext();) {
					String rep = iterator.next();
					createRepository(rep);
				}
				Thread.sleep(1000);
				
				// Creation des fichiers.
				for (Iterator<String> iterator = _listefiles.iterator(); iterator.hasNext();) {
					String file = iterator.next();
					if (file.contains("conf")) {
						confPath = _listefiles.get(0);
					}
					createFile(file);
				}
				Thread.sleep(1000);
				
			} catch (InterruptedException e1) {
				EnumMessageDisplayer.ERROR.displayException(e1);
				return false;
			}
			
			createConfFile(confPath, _listeReps);
			
		}else {
			EnumMessageDisplayer.WARNING.logMessage("le chemin " + path_ + " n'est pas retrouve.");
			removeArbo(path_, null);
			return false;
		}
		return true;
	}
	
	/**
	 * <b>Methode:  org.se.common.utils.removeArbo()</b><br/>
	 *
	 *<b>Description: </b> Detruit l'arborescende de l'application.<br/>
	 *<br/>
	 * @param path_ void
	 */
	public void removeArbo(String path_, IConfig confObj_){ // D:\DEPLOIE_TEST\EveSports
		
		try {
			
			EnumMessageDisplayer.INFO.logMessage("Supression des fichiers de l'arborescence");
			Files.deleteIfExists(Paths.get(confObj_.get_confRacine() + _ressources.getSepSystem() + "conf.xml"));
			Files.deleteIfExists(Paths.get(confObj_.get_dbRacine() + _ressources.getSepSystem() + "xml" + _ressources.getSepSystem() + "users.xml"));
			Thread.sleep(500);
			
			EnumMessageDisplayer.INFO.logMessage("Supression des repertoires de l'arborescence");
			Files.deleteIfExists(Paths.get(confObj_.get_confRacine()));
			Files.deleteIfExists(Paths.get(confObj_.get_dbRacine() + _ressources.getSepSystem() + "xml"));
			Files.deleteIfExists(Paths.get(confObj_.get_dbRacine() + _ressources.getSepSystem() + "csv"));
			Files.deleteIfExists(Paths.get(confObj_.get_dbRacine()));
			Thread.sleep(500);

			EnumMessageDisplayer.INFO.logMessage("Supression du repertoire principal");
			Files.deleteIfExists(Paths.get(confObj_.get_appliRacine()));
			
			
		} catch (IOException e) {
			EnumMessageDisplayer.ERROR.displayException(e);
		} catch (InterruptedException e) {
			EnumMessageDisplayer.ERROR.displayException(e);
		}
	}
	
	private boolean createConfFile(String path_, ArrayList<String> listeReps_){
		
		// On recupere les valeurs par defaut:
		String[] tab = _ressources.getAppliLabel("config.default.values").split(" ");
		if (!ConfigUtils.getInstance().writeConfigObject(ConfigUtils.getInstance().createConfigObject(tab, listeReps_), path_)) {
			return false;
		}
		
		return true;
	}
	
	public Document readXMLFile(String fullFileName_, String type_) throws JDOMException, IOException{
		
		Document document = new Document();										// Creation du document de retour.
		SAXBuilder sxb = new SAXBuilder();										// Creation du builder.
		
		if (type_.equals("LOCAL")) {
			document = sxb.build(MAccess.class.getResourceAsStream(fullFileName_));	// Initialisation du document de retour.			
		}else {
			document = sxb.build(new File(fullFileName_));	// Initialisation du document de retour.
		}
		
		return document;
	}
}
