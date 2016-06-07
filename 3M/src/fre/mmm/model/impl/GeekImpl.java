package fre.mmm.model.impl;

import java.io.Serializable;
import java.util.ArrayList;

import fre.mmm.model.Conge;
import fre.mmm.model.Geek;
import fre.mmm.resources.enums.EnumRoles;

/**
 * Classe repr�santant un membre de l'�quipe
 * CapGemini sur le projet.
 * @author fernoult
 *
 */
public class GeekImpl extends UserImpl implements Serializable, Geek {

	/** Une description viteuf */
	protected String _geekTouch;
	
	/** La liste des IDs des actions attribuee
	 *  a l'utilisateur.
	 */
	protected ArrayList<String> _actionsIDList;

	/**
	 * Constructeur.
	 * 
	 * @param _idUser
	 * @param _userLastName
	 * @param _userFirstName
	 * @param _userLogin
	 * @param _userPassword
	 * @param _userrole
	 * @param _userEmail
	 * @param _userTel
	 * @param _projetctIDList
	 * @param _congeList
	 * @param _geekTouch
	 * @param _actionsIDList
	 */
	public GeekImpl(Integer _idUser, String _userLastName,
			String _userFirstName, String _userLogin, char[] _userPassword,
			EnumRoles _userrole, String _userEmail, String _userTel,
			ArrayList<Integer> _projetctIDList, ArrayList<Conge> _congeList,
			String _geekTouch, ArrayList<String> _actionsIDList) {
		super(_idUser, _userLastName, _userFirstName, _userLogin,
				_userPassword, _userrole, _userEmail, _userTel,
				_projetctIDList, _congeList);
		this._geekTouch = _geekTouch;
		this._actionsIDList = _actionsIDList;
	}

	/**
	 * Constructeur.
	 */
	public GeekImpl() {
		super();
	}

	/* (non-Javadoc)
	 * @see fre.mmm.model.impl.Geek#get_geekTouch()
	 */
	@Override
	public String get_geekTouch() {
		return _geekTouch;
	}

	/* (non-Javadoc)
	 * @see fre.mmm.model.impl.Geek#set_geekTouch(java.lang.String)
	 */
	@Override
	public void set_geekTouch(String geekTouch_) {
		this._geekTouch = geekTouch_;
	}

	/* (non-Javadoc)
	 * @see fre.mmm.model.impl.Geek#get_actionsIDList()
	 */
	@Override
	public ArrayList<String> get_actionsIDList() {
		return _actionsIDList;
	}

	/* (non-Javadoc)
	 * @see fre.mmm.model.impl.Geek#set_actionsMap(java.util.ArrayList)
	 */
	@Override
	public void set_actionsMap(ArrayList<String> actionsIDList_) {
		this._actionsIDList = actionsIDList_;
	}

	/* (non-Javadoc)
	 * @see fre.mmm.model.impl.Geek#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ ((_geekTouch == null) ? 0 : _geekTouch.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see fre.mmm.model.impl.Geek#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		GeekImpl other = (GeekImpl) obj;
		if (_geekTouch == null) {
			if (other._geekTouch != null)
				return false;
		} else if (!_geekTouch.equals(other._geekTouch))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see fre.mmm.model.impl.Geek#toString()
	 */
	@Override
	public String toString() {
		return "GeekImpl [_geekTouch=" + _geekTouch + "]";
	}
	
	

	
	
}
