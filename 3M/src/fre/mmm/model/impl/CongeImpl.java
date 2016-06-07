package fre.mmm.model.impl;

import java.io.Serializable;
import java.util.Date;

import fre.mmm.model.Conge;

public class CongeImpl implements Serializable, Conge {

	/** ID de l'utilisateur */
	protected Integer _idUser;
	
	/** Date de debut de la periode de conges.
	 */
	protected Date _beginDate;
	
	/** Date de fin de la periode de conge */
	protected Date _endDate;

	/**
	 * Constructeur.
	 * 
	 * @param _idUser
	 * @param _beginDate
	 * @param _endDate
	 */
	public CongeImpl(Integer _idUser, Date _beginDate, Date _endDate) {
		super();
		this._idUser = _idUser;
		this._beginDate = _beginDate;
		this._endDate = _endDate;
	}
	
	/**
	 * Constructeur
	 */
	public CongeImpl(){
		
	}

	/* (non-Javadoc)
	 * @see fre.mmm.model.impl.Conge#get_idUser()
	 */
	@Override
	public Integer get_idUser() {
		return _idUser;
	}

	/* (non-Javadoc)
	 * @see fre.mmm.model.impl.Conge#set_idUser(java.lang.Integer)
	 */
	@Override
	public void set_idUser(Integer _idUser) {
		this._idUser = _idUser;
	}

	/* (non-Javadoc)
	 * @see fre.mmm.model.impl.Conge#get_beginDate()
	 */
	@Override
	public Date get_beginDate() {
		return _beginDate;
	}

	/* (non-Javadoc)
	 * @see fre.mmm.model.impl.Conge#set_beginDate(java.util.Date)
	 */
	@Override
	public void set_beginDate(Date _beginDate) {
		this._beginDate = _beginDate;
	}

	/* (non-Javadoc)
	 * @see fre.mmm.model.impl.Conge#get_endDate()
	 */
	@Override
	public Date get_endDate() {
		return _endDate;
	}

	/* (non-Javadoc)
	 * @see fre.mmm.model.impl.Conge#set_endDate(java.util.Date)
	 */
	@Override
	public void set_endDate(Date _endDate) {
		this._endDate = _endDate;
	}

	/* (non-Javadoc)
	 * @see fre.mmm.model.impl.Conge#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((_beginDate == null) ? 0 : _beginDate.hashCode());
		result = prime * result
				+ ((_endDate == null) ? 0 : _endDate.hashCode());
		result = prime * result + ((_idUser == null) ? 0 : _idUser.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see fre.mmm.model.impl.Conge#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CongeImpl other = (CongeImpl) obj;
		if (_beginDate == null) {
			if (other._beginDate != null)
				return false;
		} else if (!_beginDate.equals(other._beginDate))
			return false;
		if (_endDate == null) {
			if (other._endDate != null)
				return false;
		} else if (!_endDate.equals(other._endDate))
			return false;
		if (_idUser == null) {
			if (other._idUser != null)
				return false;
		} else if (!_idUser.equals(other._idUser))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see fre.mmm.model.impl.Conge#toString()
	 */
	@Override
	public String toString() {
		return "CongeImpl [_idUser=" + _idUser + ", _beginDate=" + _beginDate
				+ ", _endDate=" + _endDate + "]";
	}
	
	
	
	
}
