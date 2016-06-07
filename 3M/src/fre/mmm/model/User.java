package fre.mmm.model;

import java.util.ArrayList;

import fre.mmm.resources.enums.EnumRoles;

public interface User {

	/**
	 * <b>Methode:  fre.mmm.model.get_userID()</b><br/>
	 * Retourne l'ID de l'utilisateur.
	 * @return Integer
	 */
	public abstract Integer get_userID();
	
	/**
	 * <b>Methode:  fre.mmm.model.set_userID()</b><br/>
	 * Initialise l'ID de l'utilisateur.
	 * @param userID_ void
	 */
	public abstract void set_userID(Integer userID_);
	
	/**
	 * <b>Methode:  fre.mmm.model.impl.get_userLastName()</b><br/>
	 * Retourne le nom de l'utilisateur.
	 * @return String
	 */
	public abstract String get_userLastName();

	/**
	 * <b>Methode:  fre.mmm.model.impl.set_userLastName()</b><br/>
	 * Initialise le nom de l'utilisateur.
	 * @param userLastName_ void
	 */
	public abstract void set_userLastName(String userLastName_);

	/**
	 * <b>Methode:  fre.mmm.model.impl.get_userFirstName()</b><br/>
	 * Retourne le prenom de l'utilisateur.
	 * @return String
	 */
	public abstract String get_userFirstName();

	/**
	 * <b>Methode:  fre.mmm.model.impl.set_userFirstName()</b><br/>
	 * Initialise le prenom de l'utilisateur.
	 * @param userFirstName_ void
	 */
	public abstract void set_userFirstName(String userFirstName_);

	/**
	 * <b>Methode:  fre.mmm.model.impl.get_userLogin()</b><br/>
	 * Retourne le login de l'utilisateur.
	 * @return String
	 */
	public abstract String get_userLogin();

	/**
	 * <b>Methode:  fre.mmm.model.impl.set_userLogin()</b><br/>
	 * Initialise le login de l'utilisateur.
	 * @param userLogin_ void
	 */
	public abstract void set_userLogin(String userLogin_);

	/**
	 * <b>Methode:  fre.mmm.model.impl.get_userPassword()</b><br/>
	 * Retourne le password de l'utilisateur.
	 * @return char[]
	 */
	public abstract char[] get_userPassword();

	/**
	 * <b>Methode:  fre.mmm.model.impl.set_userPassword()</b><br/>
	 * Initialise le password de l'utilisateur.
	 * @param userPassword_ void
	 */
	public abstract void set_userPassword(char[] userPassword_);

	/**
	 * <b>Methode:  fre.mmm.model.impl.get_userrole()</b><br/>
	 * Retourne le role de l'utilisateur.
	 * @return EnumRoles
	 */
	public abstract EnumRoles get_userrole();

	/**
	 * <b>Methode:  fre.mmm.model.impl.set_userrole()</b><br/>
	 * Initialise le role de l'utilisateur.
	 * @param userrole_ void
	 */
	public abstract void set_userrole(EnumRoles userrole_);

	/**
	 * <b>Methode:  fre.mmm.model.impl.get_userEmail()</b><br/>
	 * Retourne l'email de l'utilisateur.
	 * @return String
	 */
	public abstract String get_userEmail();

	/**
	 * <b>Methode:  fre.mmm.model.impl.set_userEmail()</b><br/>
	 * Initialise l'email de l'utilisateur.
	 * @param userEmail_ void
	 */
	public abstract void set_userEmail(String userEmail_);

	/**
	 * <b>Methode:  fre.mmm.model.impl.get_userTel()</b><br/>
	 * Retourne le telephone de l'utilisateur.
	 * @return String
	 */
	public abstract String get_userTel();

	/**
	 * <b>Methode:  fre.mmm.model.impl.set_userTel()</b><br/>
	 * Initialise le telephone de l'utilisateur.
	 * @param userTel_ void
	 */
	public abstract void set_userTel(String userTel_);

	/**
	 * <b>Methode:  fre.mmm.model.impl.get_projetctIDList()</b><br/>
	 * Retourne la liste des IDs des projets
	 * attaches a un utilisateur de l'outil.
	 * @return ArrayList<String>
	 */
	public abstract ArrayList<Integer> get_projetctIDList();

	/**
	 * <b>Methode:  fre.mmm.model.impl.set_projetctIDList()</b><br/>
	 * Initialise la liste des IDs des projets 
	 * ataches a un utilisateur de l'outil.
	 * @param _projetctIDList void
	 */
	public abstract void set_projetctIDList(ArrayList<Integer> _projetctIDList);
	
	/**
	 * <b>Methode:  fre.mmm.model.get_congeList()</b><br/>
	 * Retourne la liste des periodes de conge
	 * de l'utilisateur.
	 * @return ArrayList<Conge>
	 */
	public abstract ArrayList<Conge> get_congeList();
	
	/**
	 * <b>Methode:  fre.mmm.model.set_congeList()</b><br/>
	 * Initialise la liste des periodes 
	 * de conge de l'utilisateur.
	 * @param congeList_ void
	 */
	public abstract void set_congeList(ArrayList<Conge> congeList_);
	
	public abstract void set_staff(boolean staffed_);
	
	public abstract boolean is_staff();

	public abstract int hashCode();

	public abstract boolean equals(Object obj);

	public abstract String toString();

}