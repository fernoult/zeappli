package fre.mmm.model.impl;

import java.io.Serializable;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

import fre.mmm.model.Anomalie;

/**
 * Classe représentant une anomalie
 * levee sur une version ou un patch.
 * @author fernoult
 *
 */
public class AnomalieImpl extends BusinessAction implements Serializable, Anomalie {

	/** La reponse pour l'anomalie. */
	protected StringBuffer _anoResponse;
	
	/** l'Analyse de l'anomalie. */
	protected StringBuffer _anoAnalyse;
	
	/** Le nombre de jours estime pour la 
	 * resolution de l'anomalie. 
	 */
	protected Double _anoNBJoursEstim;

	/**
	 * Constructeur.
	 * 
	 * @param _anoResponse
	 * @param _anoAnalyse
	 * @param _anoNBJoursEstim
	 */
	public AnomalieImpl(StringBuffer _anoResponse, StringBuffer _anoAnalyse,
			Double _anoNBJoursEstim) {
		super();
		this._anoResponse = _anoResponse;
		this._anoAnalyse = _anoAnalyse;
		this._anoNBJoursEstim = _anoNBJoursEstim;
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
	public AnomalieImpl(String actionName_, String actionNum_,
			StringBuffer actionDesc_, ArrayList<String> livrablesList_,
			Integer idRespGeek_, URL lienCollab_) {
		super(actionName_, actionNum_, actionDesc_, livrablesList_, idRespGeek_,
				lienCollab_);
	}

	/**
	 * Constructeur.
	 */
	public AnomalieImpl() {
		super();
	}

	/* (non-Javadoc)
	 * @see fre.mmm.model.impl.Anomalie#get_anoResponse()
	 */
	@Override
	public StringBuffer get_anoResponse() {
		return _anoResponse;
	}

	/* (non-Javadoc)
	 * @see fre.mmm.model.impl.Anomalie#set_anoResponse(java.lang.StringBuffer)
	 */
	@Override
	public void set_anoResponse(StringBuffer anoResponse_) {
		this._anoResponse = anoResponse_;
	}

	/* (non-Javadoc)
	 * @see fre.mmm.model.impl.Anomalie#get_anoAnalyse()
	 */
	@Override
	public StringBuffer get_anoAnalyse() {
		return _anoAnalyse;
	}

	/* (non-Javadoc)
	 * @see fre.mmm.model.impl.Anomalie#set_anoAnalyse(java.lang.StringBuffer)
	 */
	@Override
	public void set_anoAnalyse(StringBuffer anoAnalyse_) {
		this._anoAnalyse = anoAnalyse_;
	}

	/* (non-Javadoc)
	 * @see fre.mmm.model.impl.Anomalie#get_anoNBJoursEstim()
	 */
	@Override
	public Double get_anoNBJoursEstim() {
		return _anoNBJoursEstim;
	}

	/* (non-Javadoc)
	 * @see fre.mmm.model.impl.Anomalie#set_anoNBJoursEstim(java.lang.Double)
	 */
	@Override
	public void set_anoNBJoursEstim(Double anoNBJoursEstim_) {
		this._anoNBJoursEstim = anoNBJoursEstim_;
	}

	/* (non-Javadoc)
	 * @see fre.mmm.model.impl.Anomalie#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ ((_anoAnalyse == null) ? 0 : _anoAnalyse.hashCode());
		result = prime
				* result
				+ ((_anoNBJoursEstim == null) ? 0 : _anoNBJoursEstim.hashCode());
		result = prime * result
				+ ((_anoResponse == null) ? 0 : _anoResponse.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see fre.mmm.model.impl.Anomalie#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		AnomalieImpl other = (AnomalieImpl) obj;
		if (_anoAnalyse == null) {
			if (other._anoAnalyse != null)
				return false;
		} else if (!_anoAnalyse.equals(other._anoAnalyse))
			return false;
		if (_anoNBJoursEstim == null) {
			if (other._anoNBJoursEstim != null)
				return false;
		} else if (!_anoNBJoursEstim.equals(other._anoNBJoursEstim))
			return false;
		if (_anoResponse == null) {
			if (other._anoResponse != null)
				return false;
		} else if (!_anoResponse.equals(other._anoResponse))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see fre.mmm.model.impl.Anomalie#toString()
	 */
	@Override
	public String toString() {
		return "AnomalieImpl [_anoResponse=" + _anoResponse + ", _anoAnalyse="
				+ _anoAnalyse + ", _anoNBJoursEstim=" + _anoNBJoursEstim + "]";
	}
	
	
	
	
}
