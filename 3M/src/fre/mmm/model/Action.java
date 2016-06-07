package fre.mmm.model;

import java.net.URL;
import java.util.ArrayList;

public interface Action {

	/**
	 * <b>Methode:  fre.mmm.model.impl.get_actionName()</b><br/>
	 * Retourne le nom d el'action.
	 * @return String
	 */
	public abstract String get_actionName();

	/**
	 * <b>Methode:  fre.mmm.model.impl.set_actionName()</b><br/>
	 * Initialise le nom de l'action.
	 * @param actionName_ void
	 */
	public abstract void set_actionName(String actionName_);

	/**
	 * <b>Methode:  fre.mmm.model.impl.get_actionNum()</b><br/>
	 * Retourne le numero de l'action.
	 * @return String
	 */
	public abstract String get_actionNum();

	/**
	 * <b>Methode:  fre.mmm.model.impl.set_actionNum()</b><br/>
	 * Initialise le numero de l'action.
	 * @param actionNum_ void
	 */
	public abstract void set_actionNum(String actionNum_);

	/**
	 * <b>Methode:  fre.mmm.model.impl.get_actionDesc()</b><br/>
	 * retourne la description de l'action.
	 * @return StringBuffer
	 */
	public abstract StringBuffer get_actionDesc();

	/**
	 * <b>Methode:  fre.mmm.model.impl.set_actionDesc()</b><br/>
	 * Initialise la description de l'action.
	 * @param actionDesc_ void
	 */
	public abstract void set_actionDesc(StringBuffer actionDesc_);

	/**
	 * <b>Methode:  fre.mmm.model.impl.get_livrablesList()</b><br/>
	 * Retourne la liste des id des livrables
	 * attaches.
	 * @return ArrayList<String>
	 */
	public abstract ArrayList<String> get_livrablesList();

	/**
	 * <b>Methode:  fre.mmm.model.impl.set_livrablesList()</b><br/>
	 * Initialise la liste des id
	 * des livrables attaches.
	 * @param livrablesList_ void
	 */
	public abstract void set_livrablesList(ArrayList<String> livrablesList_);

	/**
	 * <b>Methode:  fre.mmm.model.impl.get_idRespGeek()</b><br/>
	 * Retourne l'id du ggek responsable
	 * de l'action.
	 * @return Integer
	 */
	public abstract Integer get_idRespGeek();

	/**
	 * <b>Methode:  fre.mmm.model.impl.set_idRespGeek()</b><br/>
	 * Initialise l'id du geek responsable
	 * de l'action.
	 * @param idRespGeek_ void
	 */
	public abstract void set_idRespGeek(Integer idRespGeek_);

	/**
	 * <b>Methode:  fre.mmm.model.impl.get_lienCollab()</b><br/>
	 * Retourne le lien de la page de l'action
	 * dans l'outil de collaboration du projet.
	 * @return URL
	 */
	public abstract URL get_lienCollab();

	/**
	 * <b>Methode:  fre.mmm.model.impl.set_lienCollab()</b><br/>
	 * Initialise le liende la page de l'action
	 * dzans l'outil de collaboration du projet.
	 * @param lienCollab_ void
	 */
	public abstract void set_lienCollab(URL lienCollab_);
	
	public abstract String get_status();
	
	public abstract void set_status(String status_);
	
	public abstract void set_destroyed(boolean destroyed_);
	
	public abstract boolean is_destroyed();

	public abstract int hashCode();

	public abstract boolean equals(Object obj);

	public abstract String toString();

}