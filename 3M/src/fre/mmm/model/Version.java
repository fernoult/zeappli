package fre.mmm.model;

import java.util.ArrayList;

public interface Version {

	/**
	 * <b>Methode:  fre.mmm.model.impl.get_patchIDList()</b><br/>
	 * Retourne la liste des IDs des patches associes 
	 * a la version.
	 * @return ArrayList<String>
	 */
	public abstract ArrayList<String> get_patchIDList();

	/**
	 * <b>Methode:  fre.mmm.model.impl.set_patchIDList()</b><br/>
	 * Initialise la liste des patchs associes 
	 * a la version.
	 * @param _patchIDList void
	 */
	public abstract void set_patchIDList(ArrayList<String> _patchIDList);

	public abstract int hashCode();

	public abstract boolean equals(Object obj);

	public abstract String toString();

}