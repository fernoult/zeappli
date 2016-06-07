package fre.mmm.model.impl;

import java.io.Serializable;
import java.util.ArrayList;

import fre.mmm.model.Project;

/**
 * Classe repr�sentant un projet gere
 * par l'outil.
 * @author fernoult
 *
 */
public class ProjetImpl implements Serializable, Project {

	/** Le nom du projet (Aussi son ID) */
	protected String _projectName;
	
	/** L'ID du manager du projet */
	protected Integer _projectIDManager;
	
	/** La liste des utilisateur attach�s au projet */
	protected ArrayList<Integer> _projectIDUsersList;
	
	/** La liste des livrables du projet */
	protected ArrayList<String> _projectIDLivrablesList;
	
	/** le booleen */
	protected boolean _destroyed;

	/**
	 * Constructeur.
	 *
	 * @param _projectName
	 * @param _projectIDManager
	 * @param _projectIDUsersList
	 * @param _projectIDLivrablesList
	 */
	public ProjetImpl(String _projectName, Integer _projectIDManager,
			ArrayList<Integer> _projectIDUsersList,
			ArrayList<String> _projectIDLivrablesList) {
		super();
		this._projectName = _projectName;
		this._projectIDManager = _projectIDManager;
		this._projectIDUsersList = _projectIDUsersList;
		this._projectIDLivrablesList = _projectIDLivrablesList;
	}

	/**
	 * Constructeur.
	 */
	public ProjetImpl() {
		super();
	}

	/* (non-Javadoc)
	 * @see fre.mmm.model.impl.Project#get_projectName()
	 */
	@Override
	public String get_projectName() {
		return _projectName;
	}

	/* (non-Javadoc)
	 * @see fre.mmm.model.impl.Project#set_projectName(java.lang.String)
	 */
	@Override
	public void set_projectName(String _projectName) {
		this._projectName = _projectName;
	}

	/* (non-Javadoc)
	 * @see fre.mmm.model.impl.Project#get_projectIDManager()
	 */
	@Override
	public Integer get_projectIDManager() {
		return _projectIDManager;
	}

	/* (non-Javadoc)
	 * @see fre.mmm.model.impl.Project#set_projectIDManager(java.lang.Integer)
	 */
	@Override
	public void set_projectIDManager(Integer _projectManager) {
		this._projectIDManager = _projectManager;
	}

	/* (non-Javadoc)
	 * @see fre.mmm.model.impl.Project#get_projectUsersList()
	 */
	@Override
	public ArrayList<Integer> get_projectUsersList() {
		return _projectIDUsersList;
	}

	/* (non-Javadoc)
	 * @see fre.mmm.model.impl.Project#set_projectUsersMap(java.util.ArrayList)
	 */
	@Override
	public void set_projectUsersMap(ArrayList<Integer> projectIDUsersList_) {
		this._projectIDUsersList = projectIDUsersList_;
	}

	/* (non-Javadoc)
	 * @see fre.mmm.model.impl.Project#get_projectIDLivrablesList()
	 */
	@Override
	public ArrayList<String> get_projectIDLivrablesList() {
		return _projectIDLivrablesList;
	}

	/* (non-Javadoc)
	 * @see fre.mmm.model.impl.Project#set_projectLivrablesMap(java.util.ArrayList)
	 */
	@Override
	public void set_projectLivrablesMap(
			ArrayList<String> _projectIDLivrablesList_) {
		this._projectIDLivrablesList = _projectIDLivrablesList_;
	}

	/*
	 * (non-Javadoc)
	 * @see fre.mmm.model.Project#set_destroyed(boolean)
	 */
	@Override
	public void set_destroyed(boolean destroyed_) {
		_destroyed = destroyed_;
	}
	
	@Override
	public boolean is_destroyed() {
		return _destroyed;
	}
	
	/* (non-Javadoc)
	 * @see fre.mmm.model.impl.Project#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((_projectIDLivrablesList == null) ? 0
						: _projectIDLivrablesList.hashCode());
		result = prime
				* result
				+ ((_projectIDManager == null) ? 0 : _projectIDManager
						.hashCode());
		result = prime
				* result
				+ ((_projectIDUsersList == null) ? 0 : _projectIDUsersList
						.hashCode());
		result = prime * result
				+ ((_projectName == null) ? 0 : _projectName.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see fre.mmm.model.impl.Project#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProjetImpl other = (ProjetImpl) obj;
		if (_projectIDLivrablesList == null) {
			if (other._projectIDLivrablesList != null)
				return false;
		} else if (!_projectIDLivrablesList
				.equals(other._projectIDLivrablesList))
			return false;
		if (_projectIDManager == null) {
			if (other._projectIDManager != null)
				return false;
		} else if (!_projectIDManager.equals(other._projectIDManager))
			return false;
		if (_projectIDUsersList == null) {
			if (other._projectIDUsersList != null)
				return false;
		} else if (!_projectIDUsersList.equals(other._projectIDUsersList))
			return false;
		if (_projectName == null) {
			if (other._projectName != null)
				return false;
		} else if (!_projectName.equals(other._projectName))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see fre.mmm.model.impl.Project#toString()
	 */
	@Override
	public String toString() {
		return "ProjetImpl [_projectName=" + _projectName
				+ ", _projectIDManager=" + _projectIDManager
				+ ", _projectIDUsersList=" + _projectIDUsersList
				+ ", _projectIDLivrablesList=" + _projectIDLivrablesList + "]";
	}

	
	
	
	
}
