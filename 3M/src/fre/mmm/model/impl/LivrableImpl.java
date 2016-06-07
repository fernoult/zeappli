package fre.mmm.model.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

import fre.mmm.model.Livrable;
import fre.mmm.model.Project;
import fre.mmm.resources.enums.EnumLivrables;

/**
 * Classe repr�sentant un livrable
 * (Une version ou un patch)
 * @author fernoult
 *
 */
public class LivrableImpl implements Serializable, Livrable {

	/** Nom du livrable */
	protected String _livName;
	
	/** Numero du livrable */
	protected String _livNum;
	
	/** Nombre de jours total de CTU */
	protected Double _livNBJoursCTU;// Calcule
	
	/** Nombre de jours total d'AIV */
	protected Double _livNBJoursAIV;// Calcule
	
	/** Cout total du livrable */
	protected Double _livCoutTotal;// Calcule
	
	/** Date de livraison au plus tot du livrable */
	protected Date _livDateLivraison;// Calcule
	
	/** Type du livrable (Version ou patch) */
	protected EnumLivrables _livType;
	
	/** Liste des actions attachees au livrable. */
	protected ArrayList<String> _actionsList;
	
	/** Le projet parent du livrable. */
	protected String _projetID;
	
	/** Le status du livrable */
	protected String _status;
	
	/** Le booleen qui va bien. */
	protected boolean _destroyed;

	/**
	 * Constructeur.
	 * 
	 * @param livName_
	 * @param livNum_
	 * @param livType_
	 * @param actionMap_
	 * @param project_
	 */
	public LivrableImpl(String livName_, String livNum_, EnumLivrables livType_,
			ArrayList<String> actionsList_, String project_) {
		super();
		this._livName = livName_;
		this._livNum = livNum_;
		this._livType = livType_;
		this._actionsList = actionsList_;
		_projetID = project_;
	}

	/**
	 * Constructeur.
	 */
	public LivrableImpl() {
		super();
	}

	/* (non-Javadoc)
	 * @see fre.mmm.model.impl.Livrable#get_livName()
	 */
	@Override
	public String get_livName() {
		return _livName;
	}

	/* (non-Javadoc)
	 * @see fre.mmm.model.impl.Livrable#set_livName(java.lang.String)
	 */
	@Override
	public void set_livName(String _livName) {
		this._livName = _livName;
	}

	/* (non-Javadoc)
	 * @see fre.mmm.model.impl.Livrable#get_livNum()
	 */
	@Override
	public String get_livNum() {
		return _livNum;
	}

	/* (non-Javadoc)
	 * @see fre.mmm.model.impl.Livrable#set_livNum(java.lang.String)
	 */
	@Override
	public void set_livNum(String _livNum) {
		this._livNum = _livNum;
	}

	/* (non-Javadoc)
	 * @see fre.mmm.model.impl.Livrable#get_livNBJoursCTU()
	 */
	@Override
	public Double get_livNBJoursCTU() {
		return _livNBJoursCTU;
	}

	/* (non-Javadoc)
	 * @see fre.mmm.model.impl.Livrable#get_livNBJoursAIV()
	 */
	@Override
	public Double get_livNBJoursAIV() {
		return _livNBJoursAIV;
	}

	/* (non-Javadoc)
	 * @see fre.mmm.model.impl.Livrable#get_livCoutTotal()
	 */
	@Override
	public Double get_livCoutTotal() {
		return _livCoutTotal;
	}

	/* (non-Javadoc)
	 * @see fre.mmm.model.impl.Livrable#get_livType()
	 */
	@Override
	public EnumLivrables get_livType() {
		return _livType;
	}

	/* (non-Javadoc)
	 * @see fre.mmm.model.impl.Livrable#set_livType(fre.mmm.resources.EnumLivrables)
	 */
	@Override
	public void set_livType(EnumLivrables _livType) {
		this._livType = _livType;
	}

	/* (non-Javadoc)
	 * @see fre.mmm.model.impl.Livrable#get_actionsList()
	 */
	@Override
	public ArrayList<String> get_actionsList() {
		return _actionsList;
	}

	/* (non-Javadoc)
	 * @see fre.mmm.model.impl.Livrable#set_actionsList(java.util.ArrayList)
	 */
	@Override
	public void set_actionsList(ArrayList<String> actionsList_) {
		this._actionsList = actionsList_;
	}

	/* (non-Javadoc)
	 * @see fre.mmm.model.impl.Livrable#get_livDateLivraison()
	 */
	@Override
	public Date get_livDateLivraison() {
		return _livDateLivraison;
	}

	/* (non-Javadoc)
	 * @see fre.mmm.model.impl.Livrable#get_project()
	 */
	@Override
	public String get_projectID() {
		return _projetID;
	}

	/* (non-Javadoc)
	 * @see fre.mmm.model.impl.Livrable#set_project(fre.mmm.model.Project)
	 */
	@Override
	public void set_projectID(String project_) {
		_projetID = project_;
	}
	
	/*
	 * (non-Javadoc)
	 * @see fre.mmm.model.Livrable#get_status()
	 */
	@Override
	public String get_status() {
		return _status;
	}
	
	/*
	 * (non-Javadoc)
	 * @see fre.mmm.model.Livrable#set_status(java.lang.String)
	 */
	@Override
	public void set_status(String status_) {
		_status = status_;
	}
	
	/*
	 * (non-Javadoc)
	 * @see fre.mmm.model.Livrable#set_destroyed(boolean)
	 */
	@Override
	public void set_destroyed(boolean destroyed_) {
		_destroyed = destroyed_;
	}
	
	/*
	 * (non-Javadoc)
	 * @see fre.mmm.model.Livrable#is_destroyed()
	 */
	@Override
	public boolean is_destroyed() {
		return _destroyed;
	}

	/* (non-Javadoc)
	 * @see fre.mmm.model.impl.Livrable#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((_actionsList == null) ? 0 : _actionsList.hashCode());
		result = prime * result
				+ ((_livCoutTotal == null) ? 0 : _livCoutTotal.hashCode());
		result = prime
				* result
				+ ((_livDateLivraison == null) ? 0 : _livDateLivraison
						.hashCode());
		result = prime * result
				+ ((_livNBJoursAIV == null) ? 0 : _livNBJoursAIV.hashCode());
		result = prime * result
				+ ((_livNBJoursCTU == null) ? 0 : _livNBJoursCTU.hashCode());
		result = prime * result
				+ ((_livName == null) ? 0 : _livName.hashCode());
		result = prime * result + ((_livNum == null) ? 0 : _livNum.hashCode());
		result = prime * result
				+ ((_livType == null) ? 0 : _livType.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see fre.mmm.model.impl.Livrable#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LivrableImpl other = (LivrableImpl) obj;
		if (_actionsList == null) {
			if (other._actionsList != null)
				return false;
		} else if (!_actionsList.equals(other._actionsList))
			return false;
		if (_livCoutTotal == null) {
			if (other._livCoutTotal != null)
				return false;
		} else if (!_livCoutTotal.equals(other._livCoutTotal))
			return false;
		if (_livDateLivraison == null) {
			if (other._livDateLivraison != null)
				return false;
		} else if (!_livDateLivraison.equals(other._livDateLivraison))
			return false;
		if (_livNBJoursAIV == null) {
			if (other._livNBJoursAIV != null)
				return false;
		} else if (!_livNBJoursAIV.equals(other._livNBJoursAIV))
			return false;
		if (_livNBJoursCTU == null) {
			if (other._livNBJoursCTU != null)
				return false;
		} else if (!_livNBJoursCTU.equals(other._livNBJoursCTU))
			return false;
		if (_livName == null) {
			if (other._livName != null)
				return false;
		} else if (!_livName.equals(other._livName))
			return false;
		if (_livNum == null) {
			if (other._livNum != null)
				return false;
		} else if (!_livNum.equals(other._livNum))
			return false;
		if (_livType != other._livType)
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see fre.mmm.model.impl.Livrable#toString()
	 */
	@Override
	public String toString() {
		return "LivrableImpl [_livName=" + _livName + ", _livNum=" + _livNum
				+ ", _livNBJoursCTU=" + _livNBJoursCTU + ", _livNBJoursAIV="
				+ _livNBJoursAIV + ", _livCoutTotal=" + _livCoutTotal
				+ ", _livDateLivraison=" + _livDateLivraison + ", _livType="
				+ _livType + ", _actionsList=" + _actionsList + "]";
	}


	

	
	
	

}
