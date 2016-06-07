package fre.mmm.model.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

import fre.mmm.model.Patch;
import fre.mmm.model.Project;
import fre.mmm.resources.enums.EnumLivrables;

/**
 * Classe repr�sentant un patch d'une version.
 * @author fernoult
 *
 */
public class PatchsImpl extends LivrableImpl implements Serializable, Patch {

	/** L'ID de la version parente. */
	protected String _idVersion;

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
	 * @param _idVersion
	 */
	public PatchsImpl(String livName_, String livNum_, EnumLivrables livType_,
			ArrayList<String> actionsList_, String project_, String _idVersion) {
		super(livName_, livNum_, livType_, actionsList_, project_);
		this._idVersion = _idVersion;
	}
	
	/**
	 * Constructeur.
	 */
	public PatchsImpl(){
		super();
	}

	/* (non-Javadoc)
	 * @see fre.mmm.model.impl.Patch#get_idVersion()
	 */
	@Override
	public String get_idVersion() {
		return _idVersion;
	}

	/* (non-Javadoc)
	 * @see fre.mmm.model.impl.Patch#set_idVersion(java.lang.String)
	 */
	@Override
	public void set_idVersion(String _idVersion) {
		this._idVersion = _idVersion;
	}

	/* (non-Javadoc)
	 * @see fre.mmm.model.impl.Patch#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ ((_idVersion == null) ? 0 : _idVersion.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see fre.mmm.model.impl.Patch#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		PatchsImpl other = (PatchsImpl) obj;
		if (_idVersion == null) {
			if (other._idVersion != null)
				return false;
		} else if (!_idVersion.equals(other._idVersion))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see fre.mmm.model.impl.Patch#toString()
	 */
	@Override
	public String toString() {
		return "PatchsImpl [_idVersion=" + _idVersion + "]";
	}
	
	
	
}
