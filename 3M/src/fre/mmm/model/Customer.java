package fre.mmm.model;

public interface Customer {

	/**
	 * <b>Methode:  fre.mmm.model.impl.get_customerCompany()</b><br/>
	 * Retourne l'entreprise du client.
	 * @return String
	 */
	public abstract String get_customerCompany();

	/**
	 * <b>Methode:  fre.mmm.model.impl.set_customerCompany()</b><br/>
	 * Initialise l'entreprise du client.
	 * @param customerCompany_ void
	 */
	public abstract void set_customerCompany(String customerCompany_);

	public abstract int hashCode();

	public abstract boolean equals(Object obj);

	public abstract String toString();

}