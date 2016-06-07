package fre.mmm.utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;

import fre.mmm.resources.Resources;
import fre.mmm.resources.enums.EnumMessageDisplayer;
import sun.misc.IOUtils;

/**
 * Classe utilitaire pour la gestion des logs.
 * @author fernoult
 *
 */
public class LogsUtils {

	/** Instance unique de LogsUtils */
	private static LogsUtils LOGS_UTILS_INSTANCE;
	
	/** La classe File qui fait les operations */
	private File _logsFile;
	
	/** Le repertoire des anciens logs. */
	private File _oldRepository;
	
    private FileWriter _fileWritter;
	
	/**
	 * Constructeur prive.
	 */
	private LogsUtils(){
		
		_logsFile = new File(Resources.SERIALIZABLE_LOGS + "/" + Resources.getInstance().getAppliLabel("file.logs.name.text"));
		_oldRepository = new File(Resources.SERIALIZABLE_LOGS + "/oldLogsFiles");
		initLogFile();
		
	}
	
	/**
	 * <b>Methode:  fre.mmm.utils.getInstance()</b><br/>
	 * Retourne l'instance unique de LogsUtils.
	 * @return LogsUtils
	 */
	public static LogsUtils getInstance(){
		
		// Le singleton qui va bien.
		if (LOGS_UTILS_INSTANCE == null) {
			LOGS_UTILS_INSTANCE = new LogsUtils();
		}
		return LOGS_UTILS_INSTANCE;
	}
	
	/**
	 * <b>Methode:  fre.mmm.utils.initLogFile()</b><br/>
	 * Initialise le fichier de logs.
	 * void
	 */
	private void initLogFile(){
		
			try {
				
				// Si le fichier de logs n'existe pas
				// on le cree.
				if (!_logsFile.exists()) {
					_logsFile.createNewFile();
					
					
				// Sinon on ecrase celui existant
				// et on le recree.
				}else {
					
					// On cree un repertoire local des
					// anciens logs si il n'existe pas
					if (!_oldRepository.exists()) {
						_oldRepository.mkdir();
					}
					
					try {
						
						// On copie l'ancien fichier dans le repertoire qui va bien.
						File oldLogFile = new File(_oldRepository.getAbsolutePath() + "/" + Resources.getInstance().getFilenameDateLog() + ".log");
						
						OutputStream output = new FileOutputStream(oldLogFile);
						Path inputPath = Paths.get(_logsFile.toURI());
						Files.copy(inputPath, output);
						
						Thread.sleep(2000);
						
					} catch (InterruptedException e) {
						EnumMessageDisplayer.ERROR.logMessage(e.getMessage());
					}
					
					// On ecrase par le nouveau fichier.
					if (_logsFile.delete()) {
						_logsFile.createNewFile();						
					}
				}
				
			} catch (IOException IOExcep) {
				IOExcep.printStackTrace();
				EnumMessageDisplayer.ERROR.displayMessage(IOExcep.getMessage());
			}
	}
	
	/**
	 * <b>Methode:  fre.mmm.utils.writeOnLog()</b><br/>
	 * Ecrit le log � la suite dans le fichier. 
	 * @param log_ void
	 */
	public synchronized void writeOnLog(String log_){

		// On s'assure que le fichier de logs
		// existe bien.
		if (_logsFile.exists()) {
			try {
				_fileWritter = new FileWriter(_logsFile, true);
				_fileWritter.write(log_ + "\n");
				_fileWritter.close();
			} catch (IOException e) {
				System.out.println("CRASH write - " + e.getMessage());
			}
		}else {
			EnumMessageDisplayer.WARNING.displayMessage("Le fichier de logs est introuvable");
		}
	}
}
