package fre.mmm.model.impl;

import java.io.Serializable;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

import fre.mmm.model.Action;

/**
 * Classe repr�santant une action 
 * (Anomalie, Evolution, Administrative).
 * @author fernoult
 *
 */
public class ActionImpl implements Serializable, Action {

	/** Nom de l'action */
	protected String _actionName;
	
	/** Numero de l'action */
	protected String _actionNum;
	
	/** Description de l'action */
	protected StringBuffer _actionDesc;
	
	/** Liste des livrables associes a l'action */
	protected ArrayList<String> _livrablesList;
	
	/** Id du responsable de l'action */
	protected Integer _idRespGeek;

	/** Lien vers la page de l'outil collaboratif */
	protected URL _lienCollab;
	
	protected String _status;
	
	protected boolean _destroyed;

	/**
	 * Constructeur.
	 * 
	 * @param actionName_
	 * @param actionNum_
	 * @param actionDesc_
	 * @param livrablesList_
	 * @param idRespGeek_
	 * @param lienCollab_
	 */
	public ActionImpl(String actionName_, String actionNum_,
			StringBuffer actionDesc_, ArrayList<String> livrablesList_,
			Integer idRespGeek_, URL lienCollab_) {
		super();
		this._actionName = actionName_;
		this._actionNum = actionNum_;
		this._actionDesc = actionDesc_;
		this._livrablesList = livrablesList_;
		this._idRespGeek = idRespGeek_;
		this._lienCollab = lienCollab_;
	}

	/**
	 * Constructeur.
	 */
	public ActionImpl() {
		super();
	}

	/* (non-Javadoc)
	 * @see fre.mmm.model.impl.Action#get_actionName()
	 */
	@Override
	public String get_actionName() {
		return _actionName;
	}

	/* (non-Javadoc)
	 * @see fre.mmm.model.impl.Action#set_actionName(java.lang.String)
	 */
	@Override
	public void set_actionName(String actionName_) {
		this._actionName = actionName_;
	}

	/* (non-Javadoc)
	 * @see fre.mmm.model.impl.Action#get_actionNum()
	 */
	@Override
	public String get_actionNum() {
		return _actionNum;
	}

	/* (non-Javadoc)
	 * @see fre.mmm.model.impl.Action#set_actionNum(java.lang.String)
	 */
	@Override
	public void set_actionNum(String actionNum_) {
		this._actionNum = actionNum_;
	}

	/* (non-Javadoc)
	 * @see fre.mmm.model.impl.Action#get_actionDesc()
	 */
	@Override
	public StringBuffer get_actionDesc() {
		return _actionDesc;
	}

	/* (non-Javadoc)
	 * @see fre.mmm.model.impl.Action#set_actionDesc(java.lang.StringBuffer)
	 */
	@Override
	public void set_actionDesc(StringBuffer actionDesc_) {
		this._actionDesc = actionDesc_;
	}

	/* (non-Javadoc)
	 * @see fre.mmm.model.impl.Action#get_livrablesList()
	 */
	@Override
	public ArrayList<String> get_livrablesList() {
		return _livrablesList;
	}

	/* (non-Javadoc)
	 * @see fre.mmm.model.impl.Action#set_livrablesList(java.util.ArrayList)
	 */
	@Override
	public void set_livrablesList(ArrayList<String> livrablesList_) {
		this._livrablesList = livrablesList_;
	}

	/* (non-Javadoc)
	 * @see fre.mmm.model.impl.Action#get_idRespGeek()
	 */
	@Override
	public Integer get_idRespGeek() {
		return _idRespGeek;
	}

	/* (non-Javadoc)
	 * @see fre.mmm.model.impl.Action#set_idRespGeek(java.lang.Integer)
	 */
	@Override
	public void set_idRespGeek(Integer idRespGeek_) {
		this._idRespGeek = idRespGeek_;
	}

	/* (non-Javadoc)
	 * @see fre.mmm.model.impl.Action#get_lienCollab()
	 */
	@Override
	public URL get_lienCollab() {
		return _lienCollab;
	}

	/* (non-Javadoc)
	 * @see fre.mmm.model.impl.Action#set_lienCollab(java.net.URL)
	 */
	@Override
	public void set_lienCollab(URL lienCollab_) {
		this._lienCollab = lienCollab_;
	}
	
	/*
	 * (non-Javadoc)
	 * @see fre.mmm.model.Action#get_status()
	 */
	@Override
	public String get_status() {
		return _status;
	}
	
	/*
	 * (non-Javadoc)
	 * @see fre.mmm.model.Action#set_status(java.lang.String)
	 */
	@Override
	public void set_status(String status_) {
		_status = status_;
	}
	
	/*
	 * (non-Javadoc)
	 * @see fre.mmm.model.Action#set_destroyed(boolean)
	 */
	@Override
	public void set_destroyed(boolean destroyed_) {
		_destroyed = destroyed_;
	}

	/*
	 * (non-Javadoc)
	 * @see fre.mmm.model.Action#is_destroyed()
	 */
	@Override
	public boolean is_destroyed() {
		return _destroyed;
	}
	
	/* (non-Javadoc)
	 * @see fre.mmm.model.impl.Action#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((_actionDesc == null) ? 0 : _actionDesc.hashCode());
		result = prime * result
				+ ((_actionName == null) ? 0 : _actionName.hashCode());
		result = prime * result
				+ ((_actionNum == null) ? 0 : _actionNum.hashCode());
		result = prime * result
				+ ((_idRespGeek == null) ? 0 : _idRespGeek.hashCode());
		result = prime * result
				+ ((_lienCollab == null) ? 0 : _lienCollab.hashCode());
		result = prime * result
				+ ((_livrablesList == null) ? 0 : _livrablesList.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see fre.mmm.model.impl.Action#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ActionImpl other = (ActionImpl) obj;
		if (_actionDesc == null) {
			if (other._actionDesc != null)
				return false;
		} else if (!_actionDesc.equals(other._actionDesc))
			return false;
		if (_actionName == null) {
			if (other._actionName != null)
				return false;
		} else if (!_actionName.equals(other._actionName))
			return false;
		if (_actionNum == null) {
			if (other._actionNum != null)
				return false;
		} else if (!_actionNum.equals(other._actionNum))
			return false;
		if (_idRespGeek == null) {
			if (other._idRespGeek != null)
				return false;
		} else if (!_idRespGeek.equals(other._idRespGeek))
			return false;
		if (_lienCollab == null) {
			if (other._lienCollab != null)
				return false;
		} else if (!_lienCollab.equals(other._lienCollab))
			return false;
		if (_livrablesList == null) {
			if (other._livrablesList != null)
				return false;
		} else if (!_livrablesList.equals(other._livrablesList))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see fre.mmm.model.impl.Action#toString()
	 */
	@Override
	public String toString() {
		return "ActionImpl [_actionName=" + _actionName + ", _actionNum="
				+ _actionNum + ", _actionDesc=" + _actionDesc
				+ ", _livrablesList=" + _livrablesList + ", _idRespGeek="
				+ _idRespGeek + ", _lienCollab=" + _lienCollab + "]";
	}

	
	
	
	
}
