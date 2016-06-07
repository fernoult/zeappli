package fre.mmm.application.manager;

import java.util.ArrayList;
import java.util.HashMap;

import fre.mmm.model.Conge;
import fre.mmm.model.User;
import fre.mmm.resources.enums.EnumRoles;

public interface UsersManager {

	public abstract void do_createUser(String lastName_, String firstName_,
			String login_, char[] passw_, EnumRoles role_, String email_,
			String tel_, ArrayList<String> projectIDList_, ArrayList<Conge> congeList_) throws Exception;
	
	public abstract User do_getUser(String userLogin_) throws Exception;
	
	public abstract ArrayList<User> do_getUsers() throws Exception;
	
	public abstract void do_removeUser(String userLogin_)
			throws NullPointerException, Exception;

	public abstract void do_updateUser(User user_) throws Exception;

	public abstract boolean do_isUserAlreadyExist(String userLogin_);
	
	public abstract ArrayList<Conge> do_getUserCongeList(Integer idUser_);
	
	public abstract void do_addCongeToUser(Integer idUser, Conge period_);
	
	public abstract void do_removeCongeToUser(Integer idUser, Conge period_);

}