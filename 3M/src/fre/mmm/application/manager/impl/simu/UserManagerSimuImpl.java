//package fre.mmm.application.manager.impl.simu;
//
//import java.util.ArrayList;
//import java.util.Iterator;
//
//import org.apache.log4j.Logger;
//
//import fre.mmm.application.manager.ApplicationManager;
//import fre.mmm.application.manager.UsersManager;
//import fre.mmm.databases.DataBase;
//import fre.mmm.exceptions.EnumAppliExceptionType;
//import fre.mmm.model.Conge;
//import fre.mmm.model.User;
//import fre.mmm.model.impl.UserImpl;
//import fre.mmm.resources.EnumMessageDisplayer;
//import fre.mmm.resources.EnumRoles;
//import fre.mmm.resources.Resources;
//
//
//public class UserManagerSimuImpl implements UsersManager{
//
//	private static UsersManager USER_MANAGER_INSTANCE;
//	
//	private ApplicationManager _appliManager;
//	
//	private DataBase _dbInstance;
//	
//	private UserManagerSimuImpl(ApplicationManager appliManager_){
//		_appliManager = appliManager_;
//		initUserManager();
//	}
//	
//	
//	public static UsersManager getInstance(ApplicationManager appliManager_) {
//		
//		// Le singleton qui va bien.
//		if (USER_MANAGER_INSTANCE == null) {
//			USER_MANAGER_INSTANCE = new UserManagerSimuImpl(appliManager_);
//		}
//		return USER_MANAGER_INSTANCE;
//	}
//	
//	private void initUserManager(){
//		_dbInstance = _appliManager.getDataBaseManager();
//	}
//
//	/* (non-Javadoc)
//	 * @see fre.mmm.application.manager.impl.simu.UserManager#do_createUser(java.lang.String, java.lang.String, java.lang.String, char[], fre.mmm.resources.EnumRoles, java.lang.String, java.lang.String)
//	 */
//	@Override
//	public synchronized void do_createUser(Integer idUser_, String lastName_, String firstName_, String login_,
//			char[] passw_, EnumRoles role_, String email_, String tel_, 
//			ArrayList<String> projectIDList_, ArrayList<Conge> congeList_) throws Exception{
//		
//		User user = new UserImpl(idUser_, lastName_, firstName_, login_, passw_, role_, email_, tel_, projectIDList_, congeList_);
//		_dbInstance.getUsersMap().put(user.get_idUser(), user);
//		EnumMessageDisplayer.SUCCES.logMessage(Resources.getInstance().getAppliLabel("message.users.create.succes.text"));
//	}
//
//	/*
//	 * (non-Javadoc)
//	 * @see fre.mmm.application.manager.UsersManager#do_getUser(java.lang.Integer)
//	 */
//	@Override
//	public void do_getUser(Integer idUser_) throws Exception {
//	}
//	
//	/*
//	 * (non-Javadoc)
//	 * @see fre.mmm.application.manager.UsersManager#do_getUsers()
//	 */
//	@Override
//	public void do_getUsers() throws Exception {
//	}
//	
//	/* (non-Javadoc)
//	 * @see fre.mmm.application.manager.impl.simu.UserManager#do_removeUser(java.lang.String)
//	 */
//	@Override
//	public synchronized void do_removeUser(String userLogin_) throws NullPointerException, Exception{
//		
//		if (userLogin_ != null) {
//			if (do_isUserAlreadyExist(userLogin_)) {
//				_dbInstance.getUsersMap().remove(userLogin_);
//			}else {
//				throw EnumAppliExceptionType.NO_USER_EXIST_EXCEPTION.getException();
//			}
//		}else {
//			throw new NullPointerException("Parametre null");
//		}
//	}
//
//	/* (non-Javadoc)
//	 * @see fre.mmm.application.manager.impl.simu.UserManager#do_updateUser(fre.mmm.model.User)
//	 */
//	@Override
//	public synchronized void do_updateUser(User user_) throws Exception{
//		
//	}
//
//	/* (non-Javadoc)
//	 * @see fre.mmm.application.manager.impl.simu.UserManager#do_isUserAlreadyExist(java.lang.String)
//	 */
//	@Override
//	public boolean do_isUserAlreadyExist(String userLogin_){
//		
//		if (userLogin_ != null) {
//			
//			ArrayList<User> usersList = null;
//			try {
//				usersList = (ArrayList<User>) _dbInstance.getUsersMap().values();
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//			int compt = 0;
//			
//			for (Iterator<User> iterator = usersList.iterator(); iterator.hasNext();) {
//				User user = (User) iterator.next();
//				if (user.get_userLogin().equals(userLogin_)) {
//					compt++;
//				}
//			}
//			if (compt > 0) {
//				return true;
//			}else {
//				return false;
//			}
//			
//		}else {
//			return false;
//		}
//	}
//
//	/*
//	 * (non-Javadoc)
//	 * @see fre.mmm.application.manager.UsersManager#do_getUserCongeList(java.lang.Integer)
//	 */
//	@Override
//	public ArrayList<Conge> do_getUserCongeList(Integer idUser_) {
//		
//		ArrayList<Conge> userCongeList = null;
//		try {
//			userCongeList = _dbInstance.getUsersMap().get(idUser_).get_congeList();
//		} catch (Exception e) {
//			EnumMessageDisplayer.ERROR.logMessage(e.getMessage());
//		}
//		return userCongeList;
//	}
//
//	/*
//	 * (non-Javadoc)
//	 * @see fre.mmm.application.manager.UsersManager#do_addCongeToUser(java.lang.Integer, fre.mmm.model.Conge)
//	 */
//	@Override
//	public void do_addCongeToUser(Integer idUser, Conge period_) {
//	}
//
//	/*
//	 * (non-Javadoc)
//	 * @see fre.mmm.application.manager.UsersManager#do_removeCongeToUser(java.lang.Integer, fre.mmm.model.Conge)
//	 */
//	@Override
//	public void do_removeCongeToUser(Integer idUser, Conge period_) {
//	}
//
//	
//	
//}
