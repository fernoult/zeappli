package fre.mmm.model;

import java.util.ArrayList;

public interface Geek {

	/**
	 * <b>Methode:  fre.mmm.model.impl.get_geekTouch()</b><br/>
	 * Retourne la touche du geek
	 * @return String
	 */
	public abstract String get_geekTouch();

	/**
	 * <b>Methode:  fre.mmm.model.impl.set_geekTouch()</b><br/>
	 * Initialise la touche du geek.
	 * @param geekTouch_ void
	 */
	public abstract void set_geekTouch(String geekTouch_);

	/**
	 * <b>Methode:  fre.mmm.model.impl.get_actionsMap()</b><br/>
	 * Retourne la liste des IDs des actions attribuees
	 * au geek.
	 * @return HashMap<String,Action>
	 */
	public abstract ArrayList<String> get_actionsIDList();

	/**
	 * <b>Methode:  fre.mmm.model.impl.set_actionsMap()</b><br/>
	 * Initialise la liste des IDs des actions attribuees
	 * au geek.
	 * @param actionsIDList_ void
	 */
	public abstract void set_actionsMap(ArrayList<String> actionsIDList_);

	public abstract int hashCode();

	public abstract boolean equals(Object obj);

	public abstract String toString();

}