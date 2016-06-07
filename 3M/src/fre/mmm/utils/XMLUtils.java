package fre.mmm.utils;

import java.io.File;
import java.io.IOException;

import org.jdom2.Document;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

import fre.mmm.MAccess;

public class XMLUtils {

	/** Instance unique de la classe. */
	private static XMLUtils XMLU_INSTANCE;
	
	/**
	 * Constructeur
	 */
	private XMLUtils() {
	}
	
	/**
	 * Retourne l'instance de la classe.
	 * @return
	 */
	public static XMLUtils getInstance(){
		
		// Le singleton qui va bien.
		if (XMLU_INSTANCE == null) {
			XMLU_INSTANCE = new XMLUtils();
		}
		
		return XMLU_INSTANCE;
	}
	
	/**
	 * Creer un fichier XML
	 * @return
	 */
	public boolean createXMLFile(){
		return true;
	}
	
	/**
	 * Creer plusieurs fichiers XML
	 * @return
	 */
	public boolean createXMLFiles(){
		return true;
	}
	
	/**
	 * Lit et retourne un objet Document a partir d'un fichier XML.
	 * @param fullFileName_
	 * @param type_
	 * @return
	 * @throws JDOMException
	 * @throws IOException
	 */
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
