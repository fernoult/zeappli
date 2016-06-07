package fre.mmm.application.manager;

import java.util.HashMap;

import fre.mmm.model.Anomalie;
import fre.mmm.model.Evolution;

public interface ActionsManager {

	/**
	 * <b>Methode:  fre.mmm.application.manager.do_createNewEvolution()</b><br/>
	 * Cree une nouvelle Evolution.
	 * @param idProject_
	 * @param idLivrable
	 * @throws Exception void
	 */
	public abstract void do_createNewEvolution(String idProject_,
			String idLivrable) throws Exception;

	/**
	 * <b>Methode:  fre.mmm.application.manager.do_createNewAnomalie()</b><br/>
	 * Cree une nouvelle anomalie.
	 * @param idProject_
	 * @param idLivrable
	 * @throws Exception void
	 */
	public abstract void do_createNewAnomalie(String idProject_,
			String idLivrable) throws Exception;

	/**
	 * <b>Methode:  fre.mmm.application.manager.do_createNewAdminAction()</b><br/>
	 * Cree une nouvelle action administrative.
	 * @param idProject_
	 * @param idLivrable
	 * @throws Exception void
	 */
	public abstract void do_createNewAdminAction(String idProject_,
			String idLivrable) throws Exception;

	/**
	 * <b>Methode:  fre.mmm.application.manager.do_getEvolution()</b><br/>
	 * Retourne une evolution a partir de son id.
	 * @param evolName_
	 * @return
	 * @throws Exception Evolution
	 */
	public abstract Evolution do_getEvolution(String evolName_)
			throws Exception;

	/**
	 * <b>Methode:  fre.mmm.application.manager.do_getEvolutions()</b><br/>
	 * retourne la liste des evolutions d'un projet.
	 * @param idProject_
	 * @return
	 * @throws Exception HashMap<String,Evolution>
	 */
	public abstract HashMap<String, Evolution> do_getEvolutions(
			String idProject_) throws Exception;

	public abstract HashMap<String, Evolution> do_getEvolutions(
			String idProject_, String idLivrable) throws Exception;

	public abstract void do_updateEvolution(Evolution evol_) throws Exception;

	public abstract Anomalie do_getAnomalie(String anoName_) throws Exception;

	public abstract HashMap<String, Anomalie> do_getAnomalies(String idProject_)
			throws Exception;

	public abstract HashMap<String, Anomalie> do_getAnomalies(
			String idProject_, String idLivrable) throws Exception;

	public abstract void do_updateAnomalie(Anomalie ano_) throws Exception;

}