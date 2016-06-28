package fre.mmm.application.manager.impl;

import java.util.ArrayList;

import fre.mmm.application.manager.ApplicationManager;
import fre.mmm.application.manager.ProjectsManager;
import fre.mmm.databases.DataBase;
import fre.mmm.model.Livrable;
import fre.mmm.model.Project;
import fre.mmm.model.User;
import fre.mmm.model.impl.ProjetImpl;

public class ProjectManagerImpl implements ProjectsManager {

	private static ProjectManagerImpl PROJECT_MANAGER_INSTANCE;
	
	private ApplicationManager _appliManager;
	
	private DataBase _dbInstance;
	
	private ProjectManagerImpl(ApplicationManager appliManager_) {
		_appliManager = appliManager_;
		initProjectManager();
	}
	
	public static ProjectManagerImpl getInstance(ApplicationManager appliManager_){
		
		// Le singleton qui va bien.
		if (PROJECT_MANAGER_INSTANCE == null) {
			PROJECT_MANAGER_INSTANCE = new ProjectManagerImpl(appliManager_);
		}
		return PROJECT_MANAGER_INSTANCE;
	}
	
	private void initProjectManager(){
		_dbInstance = _appliManager.getDataBaseManager();
	}
	
	@Override
	public void do_createProject(Integer id_user_, String project_name_, String project_num_, boolean is_destroyed_)
			throws Exception {
		
		ProjetImpl projet = new ProjetImpl(project_name_, id_user_, null, null);
		projet.set_destroyed(is_destroyed_);
		projet.set_projectNum(project_num_);
		
		_dbInstance.createProject(projet);
	}
	
	@Override
	public Project do_getProject(String projectName_) throws Exception {
		return null;
	}

	@Override
	public void do_addUserToProject(String projectName_, User user_) throws Exception {
	}

	@Override
	public void do_removeUserToProject(String projectName_, String userLogin_) throws Exception {
	}

	@Override
	public void do_addVersionToProject(String projectName_, Livrable version_) throws Exception {
	}

	@Override
	public void do_removeVersionToProject(String projectName_, String versionName_) throws Exception {
	}

	@Override
	public void do_saveProject(Project project_) throws Exception {
	}

	@Override
	public ArrayList<Integer> do_getProjectUsersList(String projectName_) throws Exception {
		return null;
	}

	@Override
	public int do_getNBProjects() throws Exception {
		return _dbInstance.getNBProjects();
	}
	
	@Override
	public ArrayList<Project> do_getProjects() throws Exception {
		return _dbInstance.getProjects();
	}

}
