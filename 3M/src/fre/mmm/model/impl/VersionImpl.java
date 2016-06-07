package fre.mmm.model.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

import fre.mmm.model.Project;
import fre.mmm.model.Version;
import fre.mmm.resources.enums.EnumLivrables;

/**
 * Classe rep�sentant une Version (qui est un Livrable)
 * associ� a un projet.
 * @author fernoult
 *
 */
public class VersionImpl extends LivrableImpl implements Serializable, Version {

	/** La liste des patchs attaches a la version. */
	protected ArrayList<String> _patchIDList;

	/**
	 * Constructeur.
	 * 
	 * @param livName_
	 * @param livNum_
	 * @param livNBJoursCTU_
	 * @param livNBJoursAIV_
	 * @param livCoutTotal_
	 * @param livDateLivraison_
	 * @param livType_
	 * @param actionsList_
	 * @param project_
	 * @param _patchIDList
	 */
	public VersionImpl(String livName_, String livNum_, EnumLivrables livType_,
			ArrayList<String> actionsList_, String project_,
			ArrayList<String> _patchIDList) {
		super(livName_, livNum_, livType_, actionsList_, project_);
		this._patchIDList = _patchIDList;
	}
	
	/**
	 * Constructeur.
	 */
	public VersionImpl(){
		super();
	}

	/* (non-Javadoc)
	 * @see fre.mmm.model.impl.Version#get_patchIDList()
	 */
	@Override
	public ArrayList<String> get_patchIDList() {
		return _patchIDList;
	}

	/* (non-Javadoc)
	 * @see fre.mmm.model.impl.Version#set_patchIDList(java.util.ArrayList)
	 */
	@Override
	public void set_patchIDList(ArrayList<String> _patchIDList) {
		this._patchIDList = _patchIDList;
	}

	/* (non-Javadoc)
	 * @see fre.mmm.model.impl.Version#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ ((_patchIDList == null) ? 0 : _patchIDList.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see fre.mmm.model.impl.Version#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		VersionImpl other = (VersionImpl) obj;
		if (_patchIDList == null) {
			if (other._patchIDList != null)
				return false;
		} else if (!_patchIDList.equals(other._patchIDList))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see fre.mmm.model.impl.Version#toString()
	 */
	@Override
	public String toString() {
		return "VersionImpl [_patchIDList=" + _patchIDList + "]";
	}
	
	
}
