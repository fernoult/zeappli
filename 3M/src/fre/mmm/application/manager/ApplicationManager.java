package fre.mmm.application.manager;

import java.util.HashMap;

import fre.mmm.application.manager.impl.local.UserManagerImpl;
import fre.mmm.application.manager.impl.simu.ActionManagerSimuImpl;
import fre.mmm.application.manager.impl.simu.LivrableManagerSimuImpl;
import fre.mmm.application.manager.impl.simu.ProjectManagerSimuImpl;
//import fre.mmm.application.manager.impl.simu.UserManagerSimuImpl;
import fre.mmm.databases.DataBase;
import fre.mmm.databases.manager.DBEmbededManager;
import fre.mmm.model.Project;

public class ApplicationManager {

	private static ApplicationManager APPLICATION_MANAGER;
	
	private ActionsManager _actionManager;
	
	private LivrablesManager _livrableManager;
	
	private ProjectsManager _projectManager;
	
	private UsersManager _userManager;
	
	private HashMap<String, Project> _projectsMap;
	
	private DataBase _dataBaseManager;
	
	private boolean _isSimu;
	
	private ApplicationManager(boolean isSimu_){
		
		_isSimu = isSimu_;

		initAppliManagers();
	}
	

	public static ApplicationManager getInstance(boolean isSimu_){
		
		// Le singleton qui va bien.
		if (APPLICATION_MANAGER == null) {
			APPLICATION_MANAGER = new ApplicationManager(isSimu_);
		}
		
		return APPLICATION_MANAGER;
	}
	
	private void initAppliManagers(){
		
		// Init de tous ces petits objets... oui oui!!
		if (_isSimu) {
//			_dataBaseManager = DBSimuManager.getInstance();
			_actionManager = ActionManagerSimuImpl.getInstance(this);
			_livrableManager = LivrableManagerSimuImpl.getInstance(this);
			_projectManager = ProjectManagerSimuImpl.getInstance(this);
//			_userManager = UserManagerSimuImpl.getInstance(this);
			
		}else {
			_dataBaseManager = DBEmbededManager.getInstance();
			_actionManager = ActionManagerSimuImpl.getInstance(this);
			_livrableManager = LivrableManagerSimuImpl.getInstance(this);
			_projectManager = ProjectManagerSimuImpl.getInstance(this);
			_userManager = UserManagerImpl.getInstance(this);
		}

	}
	
	public UsersManager getUserManager(){
		return _userManager;
	}
	
	public DataBase getDataBaseManager(){
		return _dataBaseManager;
	}
	
	public ProjectsManager getProjectManager(){
		return _projectManager;
	}
	
	public LivrablesManager getivrableManager(){
		return _livrableManager;
	}
	
	
	
	
	
	
	
	
}
