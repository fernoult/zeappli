package fre.mmm.model;

import java.util.ArrayList;
import java.util.Date;

import fre.mmm.resources.enums.EnumLivrables;

public interface Livrable {

	/**
	 * <b>Methode:  fre.mmm.model.impl.get_livName()</b><br/>
	 * Retourne le nom du livrable.
	 * @return String
	 */
	public abstract String get_livName();

	/**
	 * <b>Methode:  fre.mmm.model.impl.set_livName()</b><br/>
	 * Initialise le nom du livrable
	 * @param _livName void
	 */
	public abstract void set_livName(String _livName);

	/**
	 * <b>Methode:  fre.mmm.model.impl.get_livNum()</b><br/>
	 * Retourne le numero du livrable.
	 * @return String
	 */
	public abstract String get_livNum();

	/**
	 * <b>Methode:  fre.mmm.model.impl.set_livNum()</b><br/>
	 * Initialise le numero du livrable.
	 * @param _livNum void
	 */
	public abstract void set_livNum(String _livNum);

	/**
	 * <b>Methode:  fre.mmm.model.impl.get_livNBJoursCTU()</b><br/>
	 * Retourne le nombre de jours total de CTU
	 * du livrable
	 * @return Double
	 */
	public abstract Double get_livNBJoursCTU();

	/**
	 * <b>Methode:  fre.mmm.model.impl.get_livNBJoursAIV()</b><br/>
	 * Retourne le nombre de jours total d'AIV
	 * du livrable
	 * @return Double
	 */
	public abstract Double get_livNBJoursAIV();

	/**
	 * <b>Methode:  fre.mmm.model.impl.get_livCoutTotal()</b><br/>
	 * Retourne le cout total du livrable.
	 * @return Double
	 */
	public abstract Double get_livCoutTotal();

	/**
	 * <b>Methode:  fre.mmm.model.impl.get_livType()</b><br/>
	 * Retourne le type du livrable
	 * @return EnumLivrables
	 */
	public abstract EnumLivrables get_livType();

	/**
	 * <b>Methode:  fre.mmm.model.impl.set_livType()</b><br/>
	 * Initialise le type du livrable.
	 * @param _livType void
	 */
	public abstract void set_livType(EnumLivrables _livType);

	/**
	 * <b>Methode:  fre.mmm.model.impl.get_actionsList()</b><br/>
	 * Retourne la liste de id des action 
	 * attachees au livrable.
	 * @return ArrayList<String>
	 */
	public abstract ArrayList<String> get_actionsList();

	/**
	 * <b>Methode:  fre.mmm.model.impl.set_actionsList()</b><br/>
	 * Initialise la liste des id des actions
	 * attachees au livrable.
	 * @param actionsList_ void
	 */
	public abstract void set_actionsList(ArrayList<String> actionsList_);

	/**
	 * <b>Methode:  fre.mmm.model.impl.get_livDateLivraison()</b><br/>
	 * Retourne la date de livraison au plus
	 * tot pour le livrable.
	 * @return Date
	 */
	public abstract Date get_livDateLivraison();

	/**
	 * <b>Methode:  fre.mmm.model.impl.get_project()</b><br/>
	 * Retourne la projet parent
	 * du livarble.
	 * @return Project
	 */
	public abstract String get_projectID();

	/**
	 * <b>Methode:  fre.mmm.model.impl.set_project()</b><br/>
	 * Initialise le projet parent
	 * du livrable.
	 * @param project_ void
	 */
	public abstract void set_projectID(String projectID_);
	
	public abstract String get_status();
	
	public abstract void set_status(String status_);
	
	public abstract void set_destroyed(boolean destroyed_);
	
	public abstract boolean is_destroyed();

	public abstract int hashCode();

	public abstract boolean equals(Object obj);

	public abstract String toString();

}