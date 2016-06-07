package fre.mmm.model;

import java.net.URL;
import java.util.ArrayList;

public interface Evolution {

	/**
	 * <b>Methode:  fre.mmm.model.impl.get_evolNBJoursCTU()</b><br/>
	 * Retourne le nombre de jours de CTU.
	 * @return Double
	 */
	public abstract Double get_evolNBJoursCTU();

	/**
	 * <b>Methode:  fre.mmm.model.impl.set_evolNBJoursCTU()</b><br/>
	 * Initialise le nombre de ours de CTU.
	 * @param evolNBJoursCTU_ void
	 */
	public abstract void set_evolNBJoursCTU(Double evolNBJoursCTU_);

	/**
	 * <b>Methode:  fre.mmm.model.impl.get_evolNBJoursAIV()</b><br/>
	 * Retourne le nombre de jours d'AIV.
	 * @return Double
	 */
	public abstract Double get_evolNBJoursAIV();

	/**
	 * <b>Methode:  fre.mmm.model.impl.set_evolNBJoursAIV()</b><br/>
	 * Initialise le nombre de jours d'AIV.
	 * @param evolNBJoursAIV_ void
	 */
	public abstract void set_evolNBJoursAIV(Double evolNBJoursAIV_);

	/**
	 * <b>Methode:  fre.mmm.model.impl.get_evolPrice()</b><br/>
	 * Retourne le prix de l'evolution.
	 * @return Double
	 */
	public abstract Double get_evolPrice();

	/**
	 * <b>Methode:  fre.mmm.model.impl.set_evolPrice()</b><br/>
	 * Initialise le prix de l'evolution.
	 * @param evolPrice_ void
	 */
	public abstract void set_evolPrice(Double evolPrice_);

	/**
	 * <b>Methode:  fre.mmm.model.impl.get_documentsList()</b><br/>
	 * Retourne la liste des documents atachés
	 * a l'evolution.
	 * @return ArrayList<URL>
	 */
	public abstract ArrayList<URL> get_documentsList();

	/**
	 * <b>Methode:  fre.mmm.model.impl.set_documentsList()</b><br/>
	 * Initialise la liste des documents attachés
	 * a l'evolution.
	 * @param _documentsList void
	 */
	public abstract void set_documentsList(ArrayList<URL> _documentsList);

}