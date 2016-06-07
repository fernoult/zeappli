package fre.mmm.model.impl;

import java.io.Serializable;
import java.net.URL;
import java.util.ArrayList;

import fre.mmm.model.Business;

/**
 * Classe abstraite des actions metier.
 * @author fernoult
 *
 */
public abstract class BusinessAction extends ActionImpl implements Serializable, Business{

	/** Liste des developpeurs de l'action */
	protected ArrayList<Integer> _devList;
	
	/** Liste des valideurs de l'action */
	protected ArrayList<Integer> _aivList;

	
	public BusinessAction() {
		super();
	}

	public BusinessAction(String actionName_, String actionNum_,
			StringBuffer actionDesc_, ArrayList<String> livrablesList_,
			Integer idRespGeek_, URL lienCollab_) {
		super(actionName_, actionNum_, actionDesc_, livrablesList_, idRespGeek_,
				lienCollab_);
	}

	/* (non-Javadoc)
	 * @see fre.mmm.model.impl.Business#get_devList()
	 */
	@Override
	public ArrayList<Integer> get_devList() {
		return _devList;
	}

	/* (non-Javadoc)
	 * @see fre.mmm.model.impl.Business#set_devList(java.util.ArrayList)
	 */
	@Override
	public void set_devList(ArrayList<Integer> _devList) {
		this._devList = _devList;
	}

	/* (non-Javadoc)
	 * @see fre.mmm.model.impl.Business#get_aivList()
	 */
	@Override
	public ArrayList<Integer> get_aivList() {
		return _aivList;
	}

	/* (non-Javadoc)
	 * @see fre.mmm.model.impl.Business#set_aivList(java.util.ArrayList)
	 */
	@Override
	public void set_aivList(ArrayList<Integer> _aivList) {
		this._aivList = _aivList;
	}
	
	
	
	
}
