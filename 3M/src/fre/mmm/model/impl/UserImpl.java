package fre.mmm.model.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

import fre.mmm.model.Conge;
import fre.mmm.model.User;
import fre.mmm.resources.enums.EnumRoles;

/**
 * Classe repr�santant un utilisateur 
 * concerne par le projet.
 * @author fernoult
 *
 */
public class UserImpl implements Serializable, User {
	
	/** L'ID de l'utilisateur. */
	protected Integer _userID;
	
	/** Nom de l'utilisateur. */
	protected String _userLastName;
	
	/** Prenom de l'utilisateur. */
	protected String _userFirstName;
	
	/** Login de l'utilisateur. */
	protected String _userLogin;
	
	/** Password de l'utilisateur. */
	protected char[] _userPassword;
	
	/** Role de l'utilisateur. */
	protected EnumRoles _userrole;
	
	/** Email de l'utilisateur. */
	protected String _userEmail;
	
	/** Telephone de l'utilisateur. */
	protected String _userTel;
	
	/** La liste des IDs des projets attaches
	 * a un utilistaeur de l'outil.
	 */
	protected ArrayList<Integer> _projetctIDList;
	
	/** La liste des periodes de conge de l' utilisateur. */
	protected ArrayList<Conge> _congeList;
	
	/** Le booleen qui va bien */
	protected boolean _staffed;
	


	/**
	 * @param userID_
	 * @param userLastName_
	 * @param userFirstName_
	 * @param userLogin_
	 * @param userPassword_
	 * @param userrole_
	 * @param userEmail_
	 * @param userTel_
	 * @param projetctIDList_
	 * @param congeList_
	 */
	public UserImpl(Integer userID_, String userLastName_, String userFirstName_, String userLogin_,
			char[] userPassword_, EnumRoles userrole_, String userEmail_, String userTel_,
			ArrayList<Integer> projetctIDList_, ArrayList<Conge> congeList_) {
		super();
		_userID = userID_;
		_userLastName = userLastName_;
		_userFirstName = userFirstName_;
		_userLogin = userLogin_;
		_userPassword = userPassword_;
		_userrole = userrole_;
		_userEmail = userEmail_;
		_userTel = userTel_;
		_projetctIDList = projetctIDList_;
		_congeList = congeList_;
	}

	/**
	 * Constructeur.
	 */
	public UserImpl() {
		super();
	}

	/*
	 * (non-Javadoc)
	 * @see fre.mmm.model.User#get_userID()
	 */
	@Override
	public Integer get_userID() {
		return _userID;
	}
	
	/*
	 * (non-Javadoc)
	 * @see fre.mmm.model.User#set_userID(java.lang.Integer)
	 */
	@Override
	public void set_userID(Integer userID_) {
		_userID = userID_;
	}
	
	/* (non-Javadoc)
	 * @see fre.mmm.model.impl.User#get_userLastName()
	 */
	@Override
	public String get_userLastName() {
		return _userLastName;
	}

	/* (non-Javadoc)
	 * @see fre.mmm.model.impl.User#set_userLastName(java.lang.String)
	 */
	@Override
	public void set_userLastName(String userLastName_) {
		this._userLastName = userLastName_;
	}

	/* (non-Javadoc)
	 * @see fre.mmm.model.impl.User#get_userFirstName()
	 */
	@Override
	public String get_userFirstName() {
		return _userFirstName;
	}

	/* (non-Javadoc)
	 * @see fre.mmm.model.impl.User#set_userFirstName(java.lang.String)
	 */
	@Override
	public void set_userFirstName(String userFirstName_) {
		this._userFirstName = userFirstName_;
	}

	/* (non-Javadoc)
	 * @see fre.mmm.model.impl.User#get_userLogin()
	 */
	@Override
	public String get_userLogin() {
		return _userLogin;
	}

	/* (non-Javadoc)
	 * @see fre.mmm.model.impl.User#set_userLogin(java.lang.String)
	 */
	@Override
	public void set_userLogin(String userLogin_) {
		this._userLogin = userLogin_;
	}

	/* (non-Javadoc)
	 * @see fre.mmm.model.impl.User#get_userPassword()
	 */
	@Override
	public char[] get_userPassword() {
		return _userPassword;
	}

	/* (non-Javadoc)
	 * @see fre.mmm.model.impl.User#set_userPassword(char[])
	 */
	@Override
	public void set_userPassword(char[] userPassword_) {
		this._userPassword = userPassword_;
	}

	/* (non-Javadoc)
	 * @see fre.mmm.model.impl.User#get_userrole()
	 */
	@Override
	public EnumRoles get_userrole() {
		return _userrole;
	}

	/* (non-Javadoc)
	 * @see fre.mmm.model.impl.User#set_userrole(fre.mmm.resources.EnumRoles)
	 */
	@Override
	public void set_userrole(EnumRoles userrole_) {
		this._userrole = userrole_;
	}

	/* (non-Javadoc)
	 * @see fre.mmm.model.impl.User#get_userEmail()
	 */
	@Override
	public String get_userEmail() {
		return _userEmail;
	}

	/* (non-Javadoc)
	 * @see fre.mmm.model.impl.User#set_userEmail(java.lang.String)
	 */
	@Override
	public void set_userEmail(String userEmail_) {
		this._userEmail = userEmail_;
	}

	/* (non-Javadoc)
	 * @see fre.mmm.model.impl.User#get_userTel()
	 */
	@Override
	public String get_userTel() {
		return _userTel;
	}

	/* (non-Javadoc)
	 * @see fre.mmm.model.impl.User#set_userTel(java.lang.String)
	 */
	@Override
	public void set_userTel(String userTel_) {
		this._userTel = userTel_;
	}

	/* (non-Javadoc)
	 * @see fre.mmm.model.impl.User#get_projetctIDList()
	 */
	@Override
	public ArrayList<Integer> get_projetctIDList() {
		return _projetctIDList;
	}

	/* (non-Javadoc)
	 * @see fre.mmm.model.impl.User#set_projetctIDList(java.util.ArrayList)
	 */
	@Override
	public void set_projetctIDList(ArrayList<Integer> _projetctIDList) {
		this._projetctIDList = _projetctIDList;
	}
	
	/*
	 * (non-Javadoc)
	 * @see fre.mmm.model.User#get_congeList()
	 */
	@Override
	public ArrayList<Conge> get_congeList() {
		return _congeList;
	}

	/*
	 * (non-Javadoc)
	 * @see fre.mmm.model.User#set_congeList(java.util.ArrayList)
	 */
	@Override
	public void set_congeList(ArrayList<Conge> congeList_) {
		this._congeList = congeList_;
	}
	
	/*
	 * (non-Javadoc)
	 * @see fre.mmm.model.User#set_staff(boolean)
	 */
	@Override
	public void set_staff(boolean staffed_) {
		_staffed = staffed_;
	}

	/*
	 * (non-Javadoc)
	 * @see fre.mmm.model.User#is_staff()
	 */
	@Override
	public boolean is_staff() {
		return _staffed;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((_congeList == null) ? 0 : _congeList.hashCode());
		result = prime * result + ((_projetctIDList == null) ? 0 : _projetctIDList.hashCode());
		result = prime * result + ((_userEmail == null) ? 0 : _userEmail.hashCode());
		result = prime * result + ((_userFirstName == null) ? 0 : _userFirstName.hashCode());
		result = prime * result + ((_userID == null) ? 0 : _userID.hashCode());
		result = prime * result + ((_userLastName == null) ? 0 : _userLastName.hashCode());
		result = prime * result + ((_userLogin == null) ? 0 : _userLogin.hashCode());
		result = prime * result + Arrays.hashCode(_userPassword);
		result = prime * result + ((_userTel == null) ? 0 : _userTel.hashCode());
		result = prime * result + ((_userrole == null) ? 0 : _userrole.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserImpl other = (UserImpl) obj;
		if (_congeList == null) {
			if (other._congeList != null)
				return false;
		} else if (!_congeList.equals(other._congeList))
			return false;
		if (_projetctIDList == null) {
			if (other._projetctIDList != null)
				return false;
		} else if (!_projetctIDList.equals(other._projetctIDList))
			return false;
		if (_userEmail == null) {
			if (other._userEmail != null)
				return false;
		} else if (!_userEmail.equals(other._userEmail))
			return false;
		if (_userFirstName == null) {
			if (other._userFirstName != null)
				return false;
		} else if (!_userFirstName.equals(other._userFirstName))
			return false;
		if (_userID == null) {
			if (other._userID != null)
				return false;
		} else if (!_userID.equals(other._userID))
			return false;
		if (_userLastName == null) {
			if (other._userLastName != null)
				return false;
		} else if (!_userLastName.equals(other._userLastName))
			return false;
		if (_userLogin == null) {
			if (other._userLogin != null)
				return false;
		} else if (!_userLogin.equals(other._userLogin))
			return false;
		if (!Arrays.equals(_userPassword, other._userPassword))
			return false;
		if (_userTel == null) {
			if (other._userTel != null)
				return false;
		} else if (!_userTel.equals(other._userTel))
			return false;
		if (_userrole != other._userrole)
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "---- USER ----:\nID = \t" + _userID + "\nNOM = \t" + _userLastName + "\nPRENOM = \t"
				+ _userFirstName + "\nLOGIN = \t" + _userLogin + "\nPASSWORD = \t" + Arrays.toString(_userPassword)
				+ "\nROLE = \t" + _userrole + "\nEMAIL = \t" + _userEmail + "\nPHONE = \t" + _userTel
				+ "\nPROJETS = \t" + _projetctIDList + "\nCONGES = \t" + _congeList + "\n";
	}



	

	
	

	
	
	
	
	
	
}
