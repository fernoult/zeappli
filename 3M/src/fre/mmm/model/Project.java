package fre.mmm.model;

import java.util.ArrayList;

public interface Project {

	public abstract Integer get_projectID();
	
	public abstract void set_projectID(Integer projectID_);
	/**
	 * <b>Methode:  fre.mmm.model.impl.get_projectName()</b><br/>
	 * Retourne le nom (ID) du projet.
	 * @return String
	 */
	public abstract String get_projectName();

	/**
	 * <b>Methode:  fre.mmm.model.impl.set_projectName()</b><br/>
	 * Initialise le nom (ID) du projet.
	 * @param _projectName void
	 */
	public abstract void set_projectName(String _projectName);
	
	public abstract String get_projectNum();
	
	public abstract void set_projectNum(String projectNum_);

	/**
	 * <b>Methode:  fre.mmm.model.impl.get_projectManager()</b><br/>
	 * Retourne l'ID du manager du projet.
	 * @return Geek
	 */
	public abstract Integer get_projectIDManager();

	/**
	 * <b>Methode:  fre.mmm.model.impl.set_projectIDManager()</b><br/>
	 * Initialise l'ID du manager du projet.
	 * @param _projectManager void
	 */
	public abstract void set_projectIDManager(Integer _projectManager);

	/**
	 * <b>Methode:  fre.mmm.model.impl.get_projectUsersList()</b><br/>
	 * Retourne la liste de IDs des utilisateurs 
	 * attaches au projet.
	 * @return ArrayList<Integer>
	 */
	public abstract ArrayList<Integer> get_projectUsersList();

	/**
	 * <b>Methode:  fre.mmm.model.impl.set_projectUsersMap()</b><br/>
	 * Initialise la liste des IDs des utilisateurs
	 * attaches au projet.
	 * @param projectIDUsersList_ void
	 */
	public abstract void set_projectUsersMap(
			ArrayList<Integer> projectIDUsersList_);

	/**
	 * <b>Methode:  fre.mmm.model.impl.get_projectIDLivrablesList()</b><br/>
	 * Retourne la liste des IDs des livrables
	 * attaches au projet.
	 * @return ArrayList<String>
	 */
	public abstract ArrayList<String> get_projectIDLivrablesList();

	/**
	 * <b>Methode:  fre.mmm.model.impl.set_projectLivrablesMap()</b><br/>
	 * Initialise la liste des IDs des livrables
	 * attaches au projet.
	 * @param _projectIDLivrablesList_ void
	 */
	public abstract void set_projectLivrablesMap(
			ArrayList<String> _projectIDLivrablesList_);
	
	public abstract void set_destroyed(boolean destroyed_);
	
	public abstract boolean is_destroyed();

	public abstract int hashCode();

	public abstract boolean equals(Object obj);

	public abstract String toString();

}