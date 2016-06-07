package fre.mmm.model;

import java.util.Date;

public interface Conge {

	/**
	 * <b>Methode:  fre.mmm.model.impl.get_idUser()</b><br/>
	 * Retourne l'ID d el'utilisateur.
	 * @return Integer
	 */
	public abstract Integer get_idUser();

	/**
	 * <b>Methode:  fre.mmm.model.impl.set_idUser()</b><br/>
	 * Initialise l'ID de l'utilisateur.
	 * @param _idUser void
	 */
	public abstract void set_idUser(Integer _idUser);

	/**
	 * <b>Methode:  fre.mmm.model.impl.get_beginDate()</b><br/>
	 * Retourne la date de debut de la periode
	 * de conges.
	 * @return Date
	 */
	public abstract Date get_beginDate();

	/**
	 * <b>Methode:  fre.mmm.model.impl.set_beginDate()</b><br/>
	 * Initialise la periode de debut de la date
	 * de conge.
	 * @param _beginDate void
	 */
	public abstract void set_beginDate(Date _beginDate);

	/**
	 * <b>Methode:  fre.mmm.model.impl.get_endDate()</b><br/>
	 * Retourne la date de fin de la periode
	 * de conge.
	 * @return Date
	 */
	public abstract Date get_endDate();

	/**
	 * <b>Methode:  fre.mmm.model.impl.set_endDate()</b><br/>
	 * Initialise la date de fin de la periode
	 * de conge.
	 * @param _endDate void
	 */
	public abstract void set_endDate(Date _endDate);

	public abstract int hashCode();

	public abstract boolean equals(Object obj);

	public abstract String toString();

}