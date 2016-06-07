package fre.mmm.model.impl;

import java.io.Serializable;
import java.util.ArrayList;

import fre.mmm.model.Conge;
import fre.mmm.model.Customer;
import fre.mmm.resources.enums.EnumRoles;

/**
 * Classe repr�santant un client d'un perojet.
 * @author fernoult
 *
 */
public class CustomerImpl extends UserImpl implements Serializable, Customer {

	/** L'entreprise du client */
	protected String _customerCompany;
	
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
	 * @param _customerCompany
	 */
	public CustomerImpl(Integer _idUser, String _userLastName,
			String _userFirstName, String _userLogin, char[] _userPassword,
			EnumRoles _userrole, String _userEmail, String _userTel,
			ArrayList<Integer> _projetctIDList, ArrayList<Conge> _congeList,
			String _customerCompany) {
		super(_idUser, _userLastName, _userFirstName, _userLogin,
				_userPassword, _userrole, _userEmail, _userTel,
				_projetctIDList, _congeList);
		this._customerCompany = _customerCompany;
	}

	/**
	 * Constructeur.
	 */
	public CustomerImpl() {
		super();
	}

	/* (non-Javadoc)
	 * @see fre.mmm.model.impl.Customer#get_customerCompany()
	 */
	@Override
	public String get_customerCompany() {
		return _customerCompany;
	}

	/* (non-Javadoc)
	 * @see fre.mmm.model.impl.Customer#set_customerCompany(java.lang.String)
	 */
	@Override
	public void set_customerCompany(String customerCompany_) {
		this._customerCompany = customerCompany_;
	}

	/* (non-Javadoc)
	 * @see fre.mmm.model.impl.Customer#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime
				* result
				+ ((_customerCompany == null) ? 0 : _customerCompany.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see fre.mmm.model.impl.Customer#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		CustomerImpl other = (CustomerImpl) obj;
		if (_customerCompany == null) {
			if (other._customerCompany != null)
				return false;
		} else if (!_customerCompany.equals(other._customerCompany))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see fre.mmm.model.impl.Customer#toString()
	 */
	@Override
	public String toString() {
		return "CustomerImpl [_customerCompany=" + _customerCompany + "]";
	}

	
	
	
}
