package fre.mmm.model;

import java.util.ArrayList;

public interface Business {

	/**
	 * <b>Methode:  fre.mmm.model.impl.get_devList()</b><br/>
	 * Retourne la liste des developpeurs de l'action.
	 * @return ArrayList<Integer>
	 */
	public abstract ArrayList<Integer> get_devList();

	/**
	 * <b>Methode:  fre.mmm.model.impl.set_devList()</b><br/>
	 * Initialise la liste des developpeurs de l'action.
	 * @param _devList void
	 */
	public abstract void set_devList(ArrayList<Integer> _devList);

	/**
	 * <b>Methode:  fre.mmm.model.impl.get_aivList()</b><br/>
	 * Retourne la liste des valideurs de l'action.
	 * @return ArrayList<Integer>
	 */
	public abstract ArrayList<Integer> get_aivList();

	/**
	 * <b>Methode:  fre.mmm.model.impl.set_aivList()</b><br/>
	 * Initialise la liste des valideurs de l'action.
	 * @param _aivList void
	 */
	public abstract void set_aivList(ArrayList<Integer> _aivList);

}