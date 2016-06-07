package fre.mmm.model;

public interface Patch {

	/**
	 * <b>Methode:  fre.mmm.model.impl.get_idVersion()</b><br/>
	 * Retourne l'ID de la version parente.
	 * @return String
	 */
	public abstract String get_idVersion();

	/**
	 * <b>Methode:  fre.mmm.model.impl.set_idVersion()</b><br/>
	 * Initialise l'ID de la version parente.
	 * @param _idVersion void
	 */
	public abstract void set_idVersion(String _idVersion);

	public abstract int hashCode();

	public abstract boolean equals(Object obj);

	public abstract String toString();

}