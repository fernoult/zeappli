package fre.mmm.databases.manager;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import fre.mmm.databases.DataBase;
import fre.mmm.databases.DataBaseResources;
import fre.mmm.model.Action;
import fre.mmm.model.Livrable;
import fre.mmm.model.Project;
import fre.mmm.model.User;
import fre.mmm.model.impl.ProjetImpl;
import fre.mmm.model.impl.UserImpl;
import fre.mmm.resources.Resources;
import fre.mmm.resources.enums.EnumMessageDisplayer;
import fre.mmm.utils.FilesUtils;

public class DBEmbededManager implements DataBase {
	
	private static DBEmbededManager DB_EMBEDED_INSTANCE;
	
	private static Connection _connexion;
	
	private static URL _createshemaScript = DataBase.class.getResource("./scripts/mmm_createshema.sql");
	private static URL _dropshemaScript = DataBase.class.getResource("./scripts/mmm_dropshema.sql");
	private static URL _insertDatasScript = DataBase.class.getResource("./scripts/mmm_insertDatasTest.sql");
	private static URL _selecttestsScript = DataBase.class.getResource("./scripts/mmm_selectTests.sql");
	
	private DBEmbededManager() {
		
		try {
			
			// Chargement du driver de connexion HSQLDB
			// et connexion a la base.
			Class.forName(Resources.getInstance().getAppliLabel("database.embeded.hsqldb.driver.text")).newInstance();
			_connexion = DriverManager.getConnection("jdbc:hsqldb:file:mmm_database", "sa", "");
			
		} catch (InstantiationException e) {
			EnumMessageDisplayer.ERROR.logMessage(e.getMessage());
		} catch (IllegalAccessException e) {
			EnumMessageDisplayer.ERROR.logMessage(e.getMessage());
		} catch (ClassNotFoundException e) {
			EnumMessageDisplayer.ERROR.logMessage(e.getMessage());
		} catch (SQLException e) {
			EnumMessageDisplayer.ERROR.logMessage(e.getMessage());
		}
	}

	public static DBEmbededManager getInstance(){
		
		// Le singleton qui va bien.
		if (DB_EMBEDED_INSTANCE == null) {
			DB_EMBEDED_INSTANCE = new DBEmbededManager();
		}
		return DB_EMBEDED_INSTANCE;
	}

	public void createShema(){
		EnumMessageDisplayer.INFO.logMessage("Tentative de creation du shema de la base de donnee.");
		try {
			executeAdminInstruction(new File(_createshemaScript.getPath()));
		} catch (Exception e) {
			EnumMessageDisplayer.ERROR.logMessage(e.getMessage());
		}
	}
	
	public void dropShema(){
		EnumMessageDisplayer.INFO.logMessage("Tentative de destruction du shema de la base de donnee.");
		try {
			executeAdminInstruction(new File(_dropshemaScript.getPath()));
		} catch (Exception e) {
			EnumMessageDisplayer.ERROR.logMessage(e.getMessage());
		}
	}
	
	public void initDatasDB(){
		EnumMessageDisplayer.INFO.logMessage("Tentative d'initialisation des données de test de la base de donnee.");
		try {
			executeAdminInstruction(new File(_insertDatasScript.getPath()));
		} catch (Exception e) {
			EnumMessageDisplayer.ERROR.logMessage(e.getMessage());
		}
	}

	public void initEmbededDB(){
		EnumMessageDisplayer.INFO.logMessage("Tentative d'initialisation de la BD embarquée.");
		try {
			
			createShema();
			Thread.sleep(2000);
			initDatasDB();
			
		} catch (InterruptedException e) {
			EnumMessageDisplayer.ERROR.logMessage(e.getMessage());
		}
	}
	public void testSelects(){
		EnumMessageDisplayer.INFO.logMessage("Tentative de test de selects sur les tables du shema.");
		try {
			executeAdminInstruction(new File(_selecttestsScript.getPath()));
		} catch (Exception e) {
			EnumMessageDisplayer.ERROR.logMessage(e.getMessage());
		} finally {
			EnumMessageDisplayer.INFO.logMessage("Fin du traitement.");
		}
	}

	public void displayDataBasaTables(){
		
		try {
			DatabaseMetaData dmd = _connexion.getMetaData();
			ResultSet rs = dmd.getTables(_connexion.getCatalog(), null, "%", null);
			
			while(rs.next()){ 
				   System.out.println("###################################"); 
				   for(int i=0; i<rs.getMetaData().getColumnCount();i++){ 
				      String nomColonne = rs.getMetaData().getColumnName(i+1); 
				      Object valeurColonne = rs.getObject(i+1); 
				      System.out.println(nomColonne+" = "+valeurColonne); 
				   } 
				}
		} catch (SQLException e) {
			EnumMessageDisplayer.ERROR.logMessage(e.getMessage());
		}
	}
	
	private void executeAdminInstruction(File file_) throws Exception{
		
		InputStream ips = null;
		InputStreamReader ipsr = null;
		BufferedReader bfr = null;
		String chaine = "";
		String status = "";
		
		try {
			ips = new FileInputStream(file_);
			ipsr = new InputStreamReader(ips);
			bfr = new BufferedReader(ipsr);
			
			String line;
			
			while ((line = bfr.readLine()) != null) {
				chaine+=line+"\n";
			}
			
			bfr.close();
			
			Statement statement = _connexion.createStatement();
			statement.executeUpdate(chaine);
			
		} catch (FileNotFoundException e) {
			status = "FUCK FileNotFoundException";
			EnumMessageDisplayer.ERROR.logMessage(e.getMessage());
			throw new Exception("Aucun fichier ou dossier trouvé.");
		} catch (IOException e) {
			status = "FUCK IOException";
			EnumMessageDisplayer.ERROR.logMessage(e.getMessage());
		} catch (SQLException e) {
			status = "FUCK SQLException";
			EnumMessageDisplayer.ERROR.logMessage(e.getMessage());
		}
		
	}
	
	public void closeEmbededDatabase() throws SQLException{
		
		Statement statement = _connexion.createStatement();
		statement.executeQuery("SHUTDOWN");
		statement.close();
		_connexion.close();
	
	}
	
	@Override
	public boolean isUserAlreadyExist(String loginUser_) throws Exception {
		
		EnumMessageDisplayer.INFO.logMessage("Test si l'utilisateur existe.");
		PreparedStatement preparedState = _connexion.prepareStatement(DataBaseResources.selectUserCount());
		ResultSet retour = null;
		boolean ret = false;
		try {
			
			preparedState.setString(1, loginUser_);
			retour = preparedState.executeQuery();
			if (retour.getRow() != 0) {
				ret = true;				
			}
			
		} catch (SQLException e) {
			EnumMessageDisplayer.ERROR.logMessage(e.getErrorCode() + " | " + e.getMessage());
			throw new Exception("Erreur SQL niveau Base de données.\n"
					+ "Code erreur SQL : " + e.getErrorCode());
		} finally {
			EnumMessageDisplayer.INFO.logMessage("Fermeture du PreparedStatement.");
			retour.close();
			preparedState.close();
			EnumMessageDisplayer.INFO.logMessage("Fin du traitement.");
		}
		return ret;
	}
	
	@Override
	public boolean isUserStaffed(String loginUser_) throws Exception {
		
		EnumMessageDisplayer.INFO.logMessage("Test si l'utilisateur existe.");
		PreparedStatement preparedState = _connexion.prepareStatement(DataBaseResources.selectUserIsDestroyed());
		ResultSet retour = null;
		boolean ret = false;
		try {
			
			preparedState.setString(1, loginUser_);
			retour = preparedState.executeQuery();
			
			ret = retour.getBoolean("is_staffed");
						
		} catch (SQLException e) {
			EnumMessageDisplayer.ERROR.logMessage(e.getErrorCode() + " | " + e.getMessage());
			throw new Exception("Erreur SQL niveau Base de données.\n"
					+ "Code erreur SQL : " + e.getErrorCode());
		} finally {
			EnumMessageDisplayer.INFO.logMessage("Fermeture du PreparedStatement.");
			retour.close();
			preparedState.close();
			EnumMessageDisplayer.INFO.logMessage("Fin du traitement.");
		}
		return ret;
	}
	
	@Override
	public void createUser(User user_) throws Exception {
		
		EnumMessageDisplayer.INFO.logMessage("Tentative d'ajout d'un utilisateur.");
		PreparedStatement prepaState = _connexion.prepareStatement(DataBaseResources.addUser());
		try {
			prepaState.setString(1, user_.get_userLogin());
			prepaState.setString(2, user_.get_userFirstName());
			prepaState.setString(3, user_.get_userLastName());
			prepaState.setString(4, user_.get_userEmail());
			prepaState.setString(5, user_.get_userTel());
			prepaState.setString(6, "NO COMPAGNY");
			prepaState.setBoolean(7, true);
			System.out.println("");
			int statut = prepaState.executeUpdate();
			EnumMessageDisplayer.SUCCES.logMessage(DataBaseResources.addUser());
		} catch (SQLException e) {
			EnumMessageDisplayer.ERROR.logMessage(e.getMessage());
		} finally {
			EnumMessageDisplayer.INFO.logMessage("Fermeture du PreparedStatement.");
			prepaState.close();
			EnumMessageDisplayer.INFO.logMessage("Fin du traitement.");
			
		}

	}
	
	@Override
	public User getUser(String userLogin_) throws Exception {
		
		//TODO Comment on gere les erreurs SQL? 
		// https://openclassrooms.com/courses/developpez-des-sites-web-avec-java-ee/gerer-les-erreurs-avec-son-dao
		UserImpl user = new UserImpl();
		PreparedStatement preparedStatement = null;
		ResultSet retour = null;
		try {
			preparedStatement = _connexion.prepareStatement(DataBaseResources.selectUsersWhereLogin());
			preparedStatement.setString(1, userLogin_);
			retour = preparedStatement.executeQuery();

			while (retour.next()) {
				user.set_userID(retour.getInt("id_user"));
				user.set_userLogin((String) retour.getObject("user_login"));
				user.set_userFirstName((String) retour.getObject("user_lastname"));
				user.set_userLastName((String) retour.getObject("user_firstname"));
				user.set_userEmail((String) retour.getObject("user_email"));
				user.set_userTel((String) retour.getObject("user_phone"));
				user.set_staff(retour.getBoolean("is_staffer"));
			}
			if (retour.getRow() == 0) { // TODO Ca c'est degueulasse
				user = null;
			}
		} catch (SQLException e) {
			user = null;
			EnumMessageDisplayer.ERROR.logMessage(e.getErrorCode() + " | " + e.getMessage());
			throw new Exception("Echec de la tentative de récupération d'un utilisateur.\n"
					+ "Erreur SQL niveau Base de données.\n"
					+ "Code erreur SQL : " + e.getErrorCode());
		} finally {
			EnumMessageDisplayer.INFO.logMessage("Fermeture du PreparedStatement.");
			retour.close();
			preparedStatement.close();
			EnumMessageDisplayer.INFO.logMessage("Fin du traitement.");
		}
		if (user.is_staff() == true) {
			return user;			
		}else {
			return null;
		}
	}

	@Override
	public ArrayList<User> getUsers() throws Exception {

		EnumMessageDisplayer.INFO.logMessage("Tentative de récupération de tous les utilisteurs enregistres.");
		ArrayList<User> list = new ArrayList<User>();

		PreparedStatement preparedStatement = _connexion.prepareStatement(DataBaseResources.selectUsers());
		ResultSet retour = preparedStatement.executeQuery();


		try {
			while (retour.next()) {
				User user = new UserImpl();
				user.set_userID(retour.getInt("id_user"));
				user.set_userLogin(retour.getString(2));
				user.set_userFirstName(retour.getString(3));
				user.set_userLastName(retour.getString(4));
				user.set_userEmail(retour.getString(5));
				user.set_userTel(retour.getString(6));
				user.set_staff(retour.getBoolean("is_staffer"));

				if (user.is_staff() == true) {
					list.add(user);						
				}
			}

			// Tout s'est bien passe, on log pour info.
			EnumMessageDisplayer.SUCCES.logMessage("Y a tout le monde.");
		} catch (SQLException e) {
			list = null;
			EnumMessageDisplayer.ERROR.logMessage(e.getErrorCode() + " | " + e.getMessage());
			throw new Exception("Echec de la tentative de récupération de tous les utilisateurs.\n"
					+ "Erreur SQL niveau Base de données.\n"
					+ "Code erreur SQL : " + e.getErrorCode());// TODO Faire des Properties pour ca.
		}	finally {
			EnumMessageDisplayer.INFO.logMessage("Fermeture du PreparedStatement.");
			retour.close();
			preparedStatement.close();
			EnumMessageDisplayer.INFO.logMessage("Fin du traitement.");
		}			


		return list;
	}
	
	@Override
	public void updateUser(User user_) throws Exception {
		
		EnumMessageDisplayer.INFO.logMessage("Tentative de modification d'un utilisateur..");
		PreparedStatement prepaState = _connexion.prepareStatement(DataBaseResources.updateUser());
		
		try {
			
			prepaState.setString(1, user_.get_userLogin());
			prepaState.setString(2, user_.get_userFirstName());
			prepaState.setString(3, user_.get_userLastName());
			prepaState.setString(4, user_.get_userEmail());
			prepaState.setString(5, user_.get_userTel());
			prepaState.setString(6, "NO COMPAGNY");
			prepaState.setBoolean(7, false);
			prepaState.setInt(8, user_.get_userID());
			
			// Tout s'est bien passe, on log pour info.
			EnumMessageDisplayer.SUCCES.logMessage("Utilisateur modifié.");
		} catch (SQLException e) {
			EnumMessageDisplayer.ERROR.logMessage(e.getErrorCode() + " | " + e.getMessage());
			throw new Exception("Echec de la tentative de modification de l'utilisateur.\n"
					+ "Erreur SQL niveau Base de données.\n"
					+ "Code erreur SQL : " + e.getErrorCode());// TODO Faire des Properties pour ca.
		} finally {
			EnumMessageDisplayer.INFO.logMessage("Fermeture du PreparedStatement.");
			prepaState.close();
			EnumMessageDisplayer.INFO.logMessage("Fin du traitement.");
		}
	}

	@Override
	public void removeUser(String userLogin_) throws Exception {
		
		EnumMessageDisplayer.INFO.logMessage("Tentative de suppression d'un utilisateur.");
		PreparedStatement prepaState = _connexion.prepareStatement(DataBaseResources.updateUser());
		
		try {
			User user = getUser(userLogin_);
			prepaState.setString(1, user.get_userLogin());
			prepaState.setString(2, user.get_userFirstName());
			prepaState.setString(3, user.get_userLastName());
			prepaState.setString(4, user.get_userEmail());
			prepaState.setString(5, user.get_userTel());
			prepaState.setString(6, "NO COMPAGNY");
			prepaState.setBoolean(7, false);
			prepaState.setInt(8, user.get_userID());
			
			prepaState.executeUpdate();
			
			// Tout s'est bien passe, on log pour info.
			EnumMessageDisplayer.SUCCES.logMessage("Utilisateur supprimé.");
			
		} catch (SQLException e) {
			EnumMessageDisplayer.ERROR.logMessage(e.getErrorCode() + " | " + e.getMessage());
			throw new Exception("Echec de la tentative de suppression de l'utilisateur.\n"
					+ "Erreur SQL niveau Base de données.\n"
					+ "Code erreur SQL : " + e.getErrorCode());// TODO Faire des Properties pour ca.
		} finally {
			EnumMessageDisplayer.INFO.logMessage("Fermeture du PreparedStatement.");
			prepaState.close();
			EnumMessageDisplayer.INFO.logMessage("Fin du traitement.");
		}
		
	}

	@Override
	public void createProject(Project project_) throws Exception {
		
		EnumMessageDisplayer.INFO.logMessage("Tentative d'ajout d'un projet.");
		PreparedStatement prepaState = _connexion.prepareStatement(DataBaseResources.addProject());
		try {
			prepaState.setInt(1, project_.get_projectIDManager());
			prepaState.setString(2, project_.get_projectName());
			prepaState.setString(3, project_.get_projectNum());
			prepaState.setBoolean(4, false);
			int statut = prepaState.executeUpdate();
			EnumMessageDisplayer.SUCCES.logMessage(DataBaseResources.addProject());
		} catch (SQLException e) {
			EnumMessageDisplayer.ERROR.logMessage(e.getErrorCode() + " | " + e.getMessage());
			throw new Exception("Echec de la tentative d'ajout d'un projet.\n"
					+ "Erreur SQL niveau Base de données.\n"
					+ "Code erreur SQL : " + e.getErrorCode());// TODO Faire des Properties pour ca.
			
		} finally {
			EnumMessageDisplayer.INFO.logMessage("Fermeture du PreparedStatement.");
			prepaState.close();
			EnumMessageDisplayer.INFO.logMessage("Fin du traitement.");
		}
	}

	@Override
	public void updateProject(Project project_) throws Exception {
	}

	@Override
	public void removeProject(String projectName_) throws Exception {
		
		EnumMessageDisplayer.INFO.logMessage("Tentative de suppression d'un projet.");
		PreparedStatement prepaState = _connexion.prepareStatement(DataBaseResources.updateProject());
		
		try {
			Project projet = getProjet(projectName_);
			prepaState.setInt(1, projet.get_projectIDManager());
			prepaState.setString(2, projet.get_projectName());
			prepaState.setString(3, projet.get_projectNum());
			prepaState.setBoolean(4, true);
			prepaState.setInt(5, projet.get_projectID());
			
			// Tout s'est bien passe, on log pour info.
			EnumMessageDisplayer.SUCCES.logMessage("Projet supprimé.");
			
		} catch (SQLException e) {
			EnumMessageDisplayer.ERROR.logMessage(e.getErrorCode() + " | " + e.getMessage());
			throw new Exception("Echec de la tentative de suppression de l'utilisateur.\n"
					+ "Erreur SQL niveau Base de données.\n"
					+ "Code erreur SQL : " + e.getErrorCode());// TODO Faire des Properties pour ca.
		} finally {
			EnumMessageDisplayer.INFO.logMessage("Fermeture du PreparedStatement.");
			prepaState.close();
			EnumMessageDisplayer.INFO.logMessage("Fin du traitement.");
		}
	}

	@Override
	public ArrayList<Project> getProjects() throws Exception {
		
		EnumMessageDisplayer.INFO.logMessage("Tentative de recupération des projets.");
		
		ArrayList<Project> list = new ArrayList<Project>();
		
		PreparedStatement prepaState = _connexion.prepareStatement(DataBaseResources.selectProjects());
		ResultSet resus = prepaState.executeQuery();
		
		while (resus.next()) {
			
			if (resus.getBoolean("is_destroyed") == false) {
				Project projet = new ProjetImpl();
				try {
					projet.set_projectID(resus.getInt("id_projet"));
					projet.set_projectIDManager(resus.getInt("id_user"));
					projet.set_projectName(resus.getString("project_name"));
					projet.set_projectNum(resus.getString("project_num"));
					projet.set_destroyed(resus.getBoolean("is_destroyed"));
					if (!projet.is_destroyed()) {
						list.add(projet);						
					}
					
				} catch (SQLException e) {
					EnumMessageDisplayer.ERROR.logMessage(e.getMessage());
				}				
			}
			
		}
		return list;
	}
	
	@Override
	public Project getProjet(String projetName_) throws Exception {
		
		//TODO Comment on gere les erreurs SQL? 
		// https://openclassrooms.com/courses/developpez-des-sites-web-avec-java-ee/gerer-les-erreurs-avec-son-dao
		ProjetImpl projet = new ProjetImpl();
		PreparedStatement preparedStatement = null;
		ResultSet retour = null;
		try {
			preparedStatement = _connexion.prepareStatement(DataBaseResources.selectProjectWithProjectName());
			preparedStatement.setString(1, projetName_);
			retour = preparedStatement.executeQuery();

			while (retour.next()) {
				projet.set_projectID(retour.getInt("id_projet"));
				projet.set_projectIDManager(retour.getInt("id_user"));
				projet.set_projectName(retour.getString("project_name"));
				projet.set_projectNum(retour.getString("project_num"));
				projet.set_destroyed(retour.getBoolean("is_destroyed"));
			}
			if (retour.getRow() == 0) { // TODO Ca c'est degueulasse
				projet = null;
			}
		} catch (SQLException e) {
			projet = null;
			EnumMessageDisplayer.ERROR.logMessage(e.getErrorCode() + " | " + e.getMessage());
			throw new Exception("Echec de la tentative de récupération du projet.\n"
					+ "Erreur SQL niveau Base de données.\n"
					+ "Code erreur SQL : " + e.getErrorCode());
		} finally {
			EnumMessageDisplayer.INFO.logMessage("Fermeture du PreparedStatement.");
			retour.close();
			preparedStatement.close();
			EnumMessageDisplayer.INFO.logMessage("Fin du traitement.");
		}

		return projet;
	}

	@Override
	public void createLivrable(Livrable livrable_) throws Exception {
	}

	@Override
	public void updateLivrable(Livrable livrable_) throws Exception {
	}

	@Override
	public void removeLivrable(String livrableName_) throws Exception {
	}

	@Override
	public void createAction(Action action_) throws Exception {
	}

	@Override
	public void updateAction(Action action_) throws Exception {
	}

	@Override
	public void removeAction(String actionName_) throws Exception {
	}

	@Override
	public HashMap<String, Project> getProjectsMap() throws Exception {
		return null;
	}
	
	
	@Override
	public int getNBProjects() throws Exception {
		EnumMessageDisplayer.INFO.logMessage("Tentative de récupération du nombre de projets en BD.");
		
		int res = 0;
		PreparedStatement prepaState = _connexion.prepareStatement(DataBaseResources.selectProjects());
		ResultSet resus = prepaState.executeQuery();
		
		while (resus.next()) {
			res++;

		}
		return res;
	}

	@Override
	public HashMap<Integer, User> getUsersMap() throws Exception {
		return null;
	}

}
