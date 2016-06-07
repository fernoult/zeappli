package fre.mmm.model;

public interface Anomalie {

	/**
	 * <b>Methode:  fre.mmm.model.impl.get_anoResponse()</b><br/>
	 * Retourne la reponse de l'anomalie.
	 * @return StringBuffer
	 */
	public abstract StringBuffer get_anoResponse();

	/**
	 * <b>Methode:  fre.mmm.model.impl.set_anoResponse()</b><br/>
	 * Initialise la reponse de l'anomalie.
	 * @param anoResponse_ void
	 */
	public abstract void set_anoResponse(StringBuffer anoResponse_);

	/**
	 * <b>Methode:  fre.mmm.model.impl.get_anoAnalyse()</b><br/>
	 * Retourne l'analyse de l'anomalie.
	 * @return StringBuffer
	 */
	public abstract StringBuffer get_anoAnalyse();

	/**
	 * <b>Methode:  fre.mmm.model.impl.set_anoAnalyse()</b><br/>
	 * Initialise l'analyse de l'anomalie.
	 * @param anoAnalyse_ void
	 */
	public abstract void set_anoAnalyse(StringBuffer anoAnalyse_);

	/**
	 * <b>Methode:  fre.mmm.model.impl.get_anoNBJoursEstim()</b><br/>
	 * Retourne le nombre de jours estimés pour
	 * la resolution de l'anomalie.
	 * @return Double
	 */
	public abstract Double get_anoNBJoursEstim();

	/**
	 * <b>Methode:  fre.mmm.model.impl.set_anoNBJoursEstim()</b><br/>
	 * Initialise le nombre de jours esimés pour
	 * la resolution de l'anomalie.
	 * @param anoNBJoursEstim_ void
	 */
	public abstract void set_anoNBJoursEstim(Double anoNBJoursEstim_);

	public abstract int hashCode();

	public abstract boolean equals(Object obj);

	public abstract String toString();

}