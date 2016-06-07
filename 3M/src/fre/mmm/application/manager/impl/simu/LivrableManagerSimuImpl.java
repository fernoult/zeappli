package fre.mmm.application.manager.impl.simu;

import fre.mmm.application.manager.ApplicationManager;
import fre.mmm.application.manager.LivrablesManager;
import fre.mmm.databases.DataBase;

public class LivrableManagerSimuImpl implements LivrablesManager {

	/** Instance unique du LivrableManager */
	private static LivrablesManager LIVRABLE_MANAGER_INSTANCE;
	
	/** L'instance de l'ApplicationManager. */
	private ApplicationManager _appliManager;
	
	/** L'instance de la DataBaseConnexion */
	private DataBase _dbInstance;
	
	private LivrableManagerSimuImpl(ApplicationManager appliManager_) {
		_appliManager = appliManager_;
	}
	
	public static LivrablesManager getInstance(ApplicationManager appliManager_){
		
		// Le singleton qui va bien
		if (LIVRABLE_MANAGER_INSTANCE == null) {
			LIVRABLE_MANAGER_INSTANCE = new LivrableManagerSimuImpl(appliManager_);
		}
		
		return LIVRABLE_MANAGER_INSTANCE;
	}
	
	private void initLivrableManager(){
		_dbInstance = _appliManager.getDataBaseManager();
	}
	
	/* (non-Javadoc)
	 * @see fre.mmm.application.manager.impl.simu.LivrableImpl#do_createNewVersion()
	 */
	@Override
	public synchronized void do_createNewVersion() throws Exception{
		
	}
	
	/* (non-Javadoc)
	 * @see fre.mmm.application.manager.impl.simu.LivrableImpl#do_removeVersion()
	 */
	@Override
	public synchronized void do_removeVersion() throws Exception{
		
	}
	
	/* (non-Javadoc)
	 * @see fre.mmm.application.manager.impl.simu.LivrableImpl#do_createNewPatch()
	 */
	@Override
	public synchronized void do_createNewPatch() throws Exception{
		
	}
	
	/* (non-Javadoc)
	 * @see fre.mmm.application.manager.impl.simu.LivrableImpl#do_addPatchToVersion()
	 */
	@Override
	public synchronized void do_addPatchToVersion() throws Exception{
		
	}
	
	/* (non-Javadoc)
	 * @see fre.mmm.application.manager.impl.simu.LivrableImpl#do_removePatchToVersion()
	 */
	@Override
	public synchronized void do_removePatchToVersion() throws Exception{
		
	}
	
	
}
