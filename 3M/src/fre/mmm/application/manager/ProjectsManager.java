package fre.mmm.application.manager;

import java.util.ArrayList;

import fre.mmm.model.Livrable;
import fre.mmm.model.Project;
import fre.mmm.model.User;

public interface ProjectsManager {

	public abstract Project do_getProject(String projectName_) throws Exception;

	public abstract void do_addUserToProject(String projectName_, User user_)
			throws Exception;

	public abstract void do_removeUserToProject(String projectName_,
			String userLogin_) throws Exception;

	public abstract void do_addVersionToProject(String projectName_,
			Livrable version_) throws Exception;

	public abstract void do_removeVersionToProject(String projectName_,
			String versionName_) throws Exception;

	public abstract void do_saveProject(Project project_) throws Exception;

	public abstract ArrayList<Integer> do_getProjectUsersList(String projectName_)
			throws Exception;

}