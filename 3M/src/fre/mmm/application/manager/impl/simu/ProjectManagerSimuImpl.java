package fre.mmm.application.manager.impl.simu;

import java.util.ArrayList;

import fre.mmm.application.manager.ApplicationManager;
import fre.mmm.application.manager.ProjectsManager;
import fre.mmm.databases.DataBase;
import fre.mmm.model.Livrable;
import fre.mmm.model.Project;
import fre.mmm.model.User;

public class ProjectManagerSimuImpl implements ProjectsManager {

	/** Instance unique du ProjectsManager. */
	private static ProjectsManager PROJ_MANAGER_INSTANCE;
	
	/** L'instance de l'ApplicationManager. */
	private ApplicationManager _appliManager;
	
	/** L'instance de la DataBaseConnexion */
	private DataBase _dbInstance;
	
	/**
	 * Constructeur prive.
	 * @param appliManager_
	 */
	private ProjectManagerSimuImpl(ApplicationManager appliManager_) {
		_appliManager = appliManager_;
		initProjectManager();
	}
	
	/**
	 * <b>Methode:  fre.mmm.application.manager.impl.simu.getInstance()</b><br/>
	 *
	 *<b>Description: </b><br/>
	 *	Retourne l'instance unique du ProjectsManager. <br/>
	 * @param appliManager_
	 * @return ProjectManagerSimuImpl
	 */
	public static ProjectsManager getInstance(ApplicationManager appliManager_){
		
		// Le singleton qui va bien.
		if (PROJ_MANAGER_INSTANCE == null) {
			PROJ_MANAGER_INSTANCE = new ProjectManagerSimuImpl(appliManager_);
		}
		
		return PROJ_MANAGER_INSTANCE;
	}

	private void initProjectManager(){
		_dbInstance = _appliManager.getDataBaseManager();
	}

	/* (non-Javadoc)
	 * @see fre.mmm.application.manager.impl.simu.ProjectManager#do_getProject(java.lang.String)
	 */
	@Override
	public synchronized Project do_getProject(String projectName_) throws Exception{
		return _dbInstance.getProjectsMap().get(projectName_);
	}

	/* (non-Javadoc)
	 * @see fre.mmm.application.manager.impl.simu.ProjectManager#do_addUserToProject(java.lang.String, fre.mmm.model.User)
	 */
	@Override
	public synchronized void do_addUserToProject(String projectName_, User user_) throws Exception{
		
	}

	/* (non-Javadoc)
	 * @see fre.mmm.application.manager.impl.simu.ProjectManager#do_removeUserToProject(java.lang.String, java.lang.String)
	 */
	@Override
	public synchronized void do_removeUserToProject(String projectName_, String userLogin_) throws Exception{
		
	}

	/* (non-Javadoc)
	 * @see fre.mmm.application.manager.impl.simu.ProjectManager#do_addVersionToProject(java.lang.String, fre.mmm.model.Livrable)
	 */
	@Override
	public synchronized void do_addVersionToProject(String projectName_, Livrable version_) throws Exception{

	}

	/* (non-Javadoc)
	 * @see fre.mmm.application.manager.impl.simu.ProjectManager#do_removeVersionToProject(java.lang.String, java.lang.String)
	 */
	@Override
	public synchronized void do_removeVersionToProject(String projectName_, String versionName_) throws Exception{
		
	}

	/* (non-Javadoc)
	 * @see fre.mmm.application.manager.impl.simu.ProjectManager#do_saveProject(fre.mmm.model.Project)
	 */
	@Override
	public synchronized void do_saveProject(Project project_) throws Exception{
		
	}

	/* (non-Javadoc)
	 * @see fre.mmm.application.manager.impl.simu.ProjectManager#do_getProjectUsersList(java.lang.String)
	 */
	@Override
	public synchronized ArrayList<Integer> do_getProjectUsersList(String projectName_) throws Exception{
		return (ArrayList<Integer>) _dbInstance.getProjectsMap().get(projectName_).get_projectUsersList();
	}
	
	
}
