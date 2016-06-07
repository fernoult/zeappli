package fre.mmm.application.manager.impl.simu;

import java.util.HashMap;

import fre.mmm.application.manager.ActionsManager;
import fre.mmm.application.manager.ApplicationManager;
import fre.mmm.databases.DataBase;
import fre.mmm.model.Action;
import fre.mmm.model.Anomalie;
import fre.mmm.model.Evolution;

public class ActionManagerSimuImpl implements ActionsManager {

	private static ActionsManager ACTION_MANAGER_INSTANCE;
	
	/** L'instance de l'ApplicationManager. */
	private ApplicationManager _appliManager;
	
	/** L'instance de la DataBaseConnexion */
	private DataBase _dbInstance;
	
	/**
	 * Constructeur prive.
	 * @param appliManager_
	 */
	private ActionManagerSimuImpl(ApplicationManager appliManager_) {
		_appliManager = appliManager_;
		initActionManager();
	}
	
	public static ActionsManager getInstance(ApplicationManager appliManager_){
		
		// Le singmleton qui va bien.
		if (ACTION_MANAGER_INSTANCE == null) {
			ACTION_MANAGER_INSTANCE = new ActionManagerSimuImpl(appliManager_);
		}
		
		return ACTION_MANAGER_INSTANCE;
	}
	
	private void initActionManager(){
		_dbInstance = _appliManager.getDataBaseManager();
	}
	
	/* (non-Javadoc)
	 * @see fre.mmm.application.manager.impl.simu.ActionsManager#do_createNewEvolution(java.lang.String, java.lang.String)
	 */
	@Override
	public synchronized void do_createNewEvolution(String idProject_, String idLivrable) throws Exception{
		
	}
	
	/* (non-Javadoc)
	 * @see fre.mmm.application.manager.impl.simu.ActionsManager#do_createNewAnomalie(java.lang.String, java.lang.String)
	 */
	@Override
	public synchronized void do_createNewAnomalie(String idProject_, String idLivrable) throws Exception{
		
	}
	
	/* (non-Javadoc)
	 * @see fre.mmm.application.manager.impl.simu.ActionsManager#do_createNewAdminAction(java.lang.String, java.lang.String)
	 */
	@Override
	public synchronized void do_createNewAdminAction(String idProject_, String idLivrable) throws Exception{
		
	}
	
	/* (non-Javadoc)
	 * @see fre.mmm.application.manager.impl.simu.ActionsManager#do_getEvolution(java.lang.String)
	 */
	@Override
	public synchronized Evolution do_getEvolution(String evolName_) throws Exception{
		return null;
	}
	
	/* (non-Javadoc)
	 * @see fre.mmm.application.manager.impl.simu.ActionsManager#do_getEvolutions(java.lang.String)
	 */
	@Override
	public synchronized HashMap<String, Evolution> do_getEvolutions(String idProject_) throws Exception{
		HashMap<String, Evolution> evolMap = new HashMap<>();
		return evolMap;
	}
	
	/* (non-Javadoc)
	 * @see fre.mmm.application.manager.impl.simu.ActionsManager#do_getEvolutions(java.lang.String, java.lang.String)
	 */
	@Override
	public synchronized HashMap<String, Evolution> do_getEvolutions(String idProject_, String idLivrable) throws Exception{
		HashMap<String, Evolution> evolMap = new HashMap<>();
		return evolMap;
	}
	
	/* (non-Javadoc)
	 * @see fre.mmm.application.manager.impl.simu.ActionsManager#do_updateEvolution(fre.mmm.model.Evolution)
	 */
	@Override
	public synchronized void do_updateEvolution(Evolution evol_) throws Exception{
		
	}
	
	/* (non-Javadoc)
	 * @see fre.mmm.application.manager.impl.simu.ActionsManager#do_getAnomalie(java.lang.String)
	 */
	@Override
	public synchronized Anomalie do_getAnomalie(String anoName_) throws Exception{
		return null;
	}
	
	/* (non-Javadoc)
	 * @see fre.mmm.application.manager.impl.simu.ActionsManager#do_getAnomalies(java.lang.String)
	 */
	@Override
	public synchronized HashMap<String, Anomalie> do_getAnomalies(String idProject_) throws Exception{
		HashMap<String, Anomalie> anoMap = new HashMap<>();
		return anoMap;
	}
	
	/* (non-Javadoc)
	 * @see fre.mmm.application.manager.impl.simu.ActionsManager#do_getAnomalies(java.lang.String, java.lang.String)
	 */
	@Override
	public synchronized HashMap<String, Anomalie> do_getAnomalies(String idProject_, String idLivrable) throws Exception{
		HashMap<String, Anomalie> anoMap = new HashMap<>();
		return anoMap;
	}
	
	/* (non-Javadoc)
	 * @see fre.mmm.application.manager.impl.simu.ActionsManager#do_updateAnomalie(fre.mmm.model.Anomalie)
	 */
	@Override
	public synchronized void do_updateAnomalie(Anomalie ano_) throws Exception{
		
	}
}
