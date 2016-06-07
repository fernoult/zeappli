package fre.mmm.model.impl;

import java.io.Serializable;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

import fre.mmm.model.Evolution;

/**
 * Classe représentant une evolution 
 * pour une version.
 * @author fernoult
 *
 */
public class EvolutionImpl extends ActionImpl implements Serializable, Evolution {
	
	/** Nombre de jours de CTU */
	protected Double _evolNBJoursCTU;
	
	/** Nombre de jours d' AIV */
	protected Double _evolNBJoursAIV;
	
	/** Prix de l'evolution */
	protected Double _evolPrice;
	
	/** Liste des liens vers les documents
	 * associés a l'evolution.
	 */
	protected ArrayList<URL> _documentsList;
	
	/**
	 * Constructeur.
	 * 
	 * @param actionName_
	 * @param actionNum_
	 * @param actionDesc_
	 * @param livrablesList_
	 * @param idRespGeek_
	 * @param lienCollab_
	 * @param _evolNBJoursCTU
	 * @param _evolNBJoursAIV
	 * @param _evolPrice
	 * @param _documentsList
	 */
	public EvolutionImpl(String actionName_, String actionNum_,
			StringBuffer actionDesc_, ArrayList<String> livrablesList_,
			Integer idRespGeek_, URL lienCollab_, Double _evolNBJoursCTU,
			Double _evolNBJoursAIV, Double _evolPrice,
			ArrayList<URL> _documentsList) {
		super(actionName_, actionNum_, actionDesc_, livrablesList_,
				idRespGeek_, lienCollab_);
		this._evolNBJoursCTU = _evolNBJoursCTU;
		this._evolNBJoursAIV = _evolNBJoursAIV;
		this._evolPrice = _evolPrice;
		this._documentsList = _documentsList;
	}

	/**
	 * Constructeur.
	 */
	public EvolutionImpl() {
		super();
	}

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
	public EvolutionImpl(String actionName_, String actionNum_,
			StringBuffer actionDesc_, ArrayList<String> livrablesList_,
			Integer idRespGeek_, URL lienCollab_) {
		super(actionName_, actionNum_, actionDesc_, livrablesList_, idRespGeek_,
				lienCollab_);
	}


	/* (non-Javadoc)
	 * @see fre.mmm.model.impl.Evolution#get_evolNBJoursCTU()
	 */
	@Override
	public Double get_evolNBJoursCTU() {
		return _evolNBJoursCTU;
	}

	/* (non-Javadoc)
	 * @see fre.mmm.model.impl.Evolution#set_evolNBJoursCTU(java.lang.Double)
	 */
	@Override
	public void set_evolNBJoursCTU(Double evolNBJoursCTU_) {
		this._evolNBJoursCTU = evolNBJoursCTU_;
	}

	/* (non-Javadoc)
	 * @see fre.mmm.model.impl.Evolution#get_evolNBJoursAIV()
	 */
	@Override
	public Double get_evolNBJoursAIV() {
		return _evolNBJoursAIV;
	}

	/* (non-Javadoc)
	 * @see fre.mmm.model.impl.Evolution#set_evolNBJoursAIV(java.lang.Double)
	 */
	@Override
	public void set_evolNBJoursAIV(Double evolNBJoursAIV_) {
		this._evolNBJoursAIV = evolNBJoursAIV_;
	}

	/* (non-Javadoc)
	 * @see fre.mmm.model.impl.Evolution#get_evolPrice()
	 */
	@Override
	public Double get_evolPrice() {
		return _evolPrice;
	}

	/* (non-Javadoc)
	 * @see fre.mmm.model.impl.Evolution#set_evolPrice(java.lang.Double)
	 */
	@Override
	public void set_evolPrice(Double evolPrice_) {
		this._evolPrice = evolPrice_;
	}

	/* (non-Javadoc)
	 * @see fre.mmm.model.impl.Evolution#get_documentsList()
	 */
	@Override
	public ArrayList<URL> get_documentsList() {
		return _documentsList;
	}

	/* (non-Javadoc)
	 * @see fre.mmm.model.impl.Evolution#set_documentsList(java.util.ArrayList)
	 */
	@Override
	public void set_documentsList(ArrayList<URL> _documentsList) {
		this._documentsList = _documentsList;
	}

	
	
	
	
	
}
