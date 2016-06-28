package fre.mmm.databases;

import java.util.ArrayList;
import java.util.HashMap;

import fre.mmm.model.Action;
import fre.mmm.model.Livrable;
import fre.mmm.model.Project;
import fre.mmm.model.User;

public interface DataBase {

	public abstract void createUser(User user_) throws Exception;
	
	public abstract User getUser(String userLogin_) throws Exception;
	
	public abstract ArrayList<User> getUsers() throws Exception;

	public abstract void updateUser(User user_) throws Exception;

	public abstract void removeUser(String userLogin_) throws Exception;

	public abstract void createProject(Project project_) throws Exception;

	public abstract void updateProject(Project project_) throws Exception;

	public abstract void removeProject(String projectName_) throws Exception;

	public abstract void createLivrable(Livrable livrable_) throws Exception;

	public abstract void updateLivrable(Livrable livrable_) throws Exception;

	public abstract void removeLivrable(String livrableName_) throws Exception;

	public abstract void createAction(Action action_) throws Exception;

	public abstract void updateAction(Action action_) throws Exception;

	public abstract void removeAction(String actionName_) throws Exception;
	
	public abstract HashMap<String, Project> getProjectsMap() throws Exception;
	
	public abstract ArrayList<Project> getProjects() throws Exception;
	
	public abstract int getNBProjects() throws Exception;
	
	public abstract HashMap<Integer, User> getUsersMap() throws Exception;
	

}