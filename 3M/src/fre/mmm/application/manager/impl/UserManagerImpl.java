package fre.mmm.application.manager.impl;

import java.util.ArrayList;
import java.util.HashMap;

import fre.mmm.application.manager.ApplicationManager;
import fre.mmm.application.manager.UsersManager;
import fre.mmm.databases.DataBase;
import fre.mmm.model.Conge;
import fre.mmm.model.User;
import fre.mmm.model.impl.UserImpl;
import fre.mmm.resources.enums.EnumRoles;

public class UserManagerImpl implements UsersManager {

	private static UsersManager USER_MANAGER_INSTANCE;
	
	private ApplicationManager _appliManager;
	
	private DataBase _dbInstance;
	
	private UserManagerImpl(ApplicationManager appliManager_){
		_appliManager = appliManager_;
		initUserManager();
	}
	
	
	public static UsersManager getInstance(ApplicationManager appliManager_) {
		
		// Le singleton qui va bien.
		if (USER_MANAGER_INSTANCE == null) {
			USER_MANAGER_INSTANCE = new UserManagerImpl(appliManager_);
		}
		return USER_MANAGER_INSTANCE;
	}
	
	private void initUserManager(){
		_dbInstance = _appliManager.getDataBaseManager();
	}
	
	@Override
	public void do_createUser(String lastName_, String firstName_, String login_, char[] passw_,
			EnumRoles role_, String email_, String tel_, ArrayList<String> projectIDList_, ArrayList<Conge> congeList_)
					throws Exception {
		// On controle l'integrite des donnees
		// a fournir a la BD pour la creation du user.
		User user = new UserImpl(null, firstName_, lastName_, login_, null, null, email_, tel_, null, null);
		_dbInstance.createUser(user);
	}
	
	@Override
	public User do_getUser(String userLogin_) throws Exception {
		return _dbInstance.getUser(userLogin_);
	}

	@Override
	public ArrayList<User> do_getUsers() throws Exception {
		return _dbInstance.getUsers();
	}
	
	@Override
	public void do_removeUser(String userLogin_) throws NullPointerException, Exception {
	}

	@Override
	public void do_updateUser(User user_) throws Exception {
	}

	@Override
	public boolean do_isUserAlreadyExist(String userLogin_) {
		return false;
	}

	@Override
	public ArrayList<Conge> do_getUserCongeList(Integer idUser_) {
		return null;
	}

	@Override
	public void do_addCongeToUser(Integer idUser_, Conge period_) {
	}

	@Override
	public void do_removeCongeToUser(Integer idUser_, Conge period_) {
	}

}
