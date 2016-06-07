//package fre.mmm.databases.manager;
//
//import java.net.MalformedURLException;
//import java.net.URL;
//import java.text.MessageFormat;
//import java.util.ArrayList;
//import java.util.HashMap;
//
//import fre.mmm.databases.DataBase;
//import fre.mmm.exceptions.EnumAppliExceptionType;
//import fre.mmm.model.Action;
//import fre.mmm.model.Conge;
//import fre.mmm.model.Livrable;
//import fre.mmm.model.Project;
//import fre.mmm.model.User;
//import fre.mmm.model.impl.CustomerImpl;
//import fre.mmm.model.impl.EvolutionImpl;
//import fre.mmm.model.impl.GeekImpl;
//import fre.mmm.model.impl.LivrableImpl;
//import fre.mmm.model.impl.ProjetImpl;
//import fre.mmm.resources.EnumCompagny;
//import fre.mmm.resources.EnumLivrables;
//import fre.mmm.resources.EnumMessageDisplayer;
//import fre.mmm.resources.EnumRoles;
//import fre.mmm.resources.Resources;
//
///**
// * Classe de simulation qui instancie
// * les objets de base pour maquetter l'application.
// * @author fernoult
// *
// */
//public class DBSimuManager implements DataBase {
//
//	/** Instance unique du Simu. */
//	private static DataBase DB_SIMU_INSTANCE;
//	
//	/** La liste des utilisateurs. */
//	private HashMap<Integer, User> _userDBSimu;
//	
//	/** La liste des projets */
//	private HashMap<String, Project> _projectDBSimu;
//	
//	/**
//	 * Constructeur prive.
//	 */
//	private DBSimuManager(){
//		initDBSimu();
//	}
//	
//	/**
//	 * <b>Methode:  fre.mmm.databases.manager.getInstance()</b><br/>
//	 * Retourne l'instance unique du Simu.
//	 * @return DataBase
//	 */
//	public static DataBase getInstance(){
//		
//		// Le singleton qui va bien.
//		if (DB_SIMU_INSTANCE == null) {
//			DB_SIMU_INSTANCE = new DBSimuManager();
//		}
//		
//		return DB_SIMU_INSTANCE;
//	}
//	
//	private void initDBSimu(){
//		
//		// Le petit log qui va bien.
//		EnumMessageDisplayer.INFO.logMessage(Resources.getInstance().getAppliLabel("message.simu.loginfo.text"));
//		EnumMessageDisplayer.INFO.logMessage("\n**************************************************************************");
//		
//		// ============ Init des users ============
//		Integer compteur = 0;
//		Object[] tabMessFormat = new Object[1];
//		
//		GeekImpl g0 = new GeekImpl(compteur, "DEBAT", "Laurent", "ldebat", null, EnumRoles.DEV, 
//				"laurent.debat@capgemini.com", "0000000000", 
//				new ArrayList<String>(), new ArrayList<Conge>(), "zeTouch", new ArrayList<String>());
//		tabMessFormat[0] = "ldebat";
//		EnumMessageDisplayer.SUCCES.logMessage(MessageFormat.format(
//				Resources.getInstance().getAppliLabel("message.users.create.succes.text"), 
//				tabMessFormat[0]));
//		
//		compteur++;
//		GeekImpl g1 = new GeekImpl(compteur, "ERNOULT", "Fran�ois", "fernoult", null, EnumRoles.DEV, 
//				"francois.ernoult@capgemini.com", "0000000000", 
//				new ArrayList<String>(), new ArrayList<Conge>(), "zeTouch", new ArrayList<String>());
//		tabMessFormat[0] = "fernoult";
//		EnumMessageDisplayer.SUCCES.logMessage(MessageFormat.format(
//				Resources.getInstance().getAppliLabel("message.users.create.succes.text"), 
//				tabMessFormat[0]));
//		
//		compteur++;
//		GeekImpl g2 = new GeekImpl(compteur, "GEHU", "Bruno", "bgehu", null, EnumRoles.RT, 
//				"bruno.gehu@capgemini.com", "0000000000",
//				new ArrayList<String>(), new ArrayList<Conge>(), "zeTouch", new ArrayList<String>());
//		tabMessFormat[0] = "bgehu";
//		EnumMessageDisplayer.SUCCES.logMessage(MessageFormat.format(
//				Resources.getInstance().getAppliLabel("message.users.create.succes.text"), 
//				tabMessFormat[0]));
//		
//		compteur++;
//		GeekImpl g3 = new GeekImpl(compteur, "FABRE", "Nicolas", "nfabre", null, EnumRoles.EM, 
//				"nicolas.fabre@capgemini.com", "0000000000",
//				new ArrayList<String>(), new ArrayList<Conge>(), "zeTouch", new ArrayList<String>());
//		tabMessFormat[0] = "nfabre";
//		EnumMessageDisplayer.SUCCES.logMessage(MessageFormat.format(
//				Resources.getInstance().getAppliLabel("message.users.create.succes.text"), 
//				tabMessFormat[0]));
//		
//		compteur++;
//		GeekImpl g4 = new GeekImpl(compteur, "DO", "Jian-Ying", "jiando", null, EnumRoles.RF, 
//				"jian-ying.do@capgemini.com", "0000000000",
//				new ArrayList<String>(), new ArrayList<Conge>(), "zeTouch", new ArrayList<String>());
//		tabMessFormat[0] = "jiando";
//		EnumMessageDisplayer.SUCCES.logMessage(MessageFormat.format(
//				Resources.getInstance().getAppliLabel("message.users.create.succes.text"), 
//				tabMessFormat[0]));
//		
//		compteur++;
//		GeekImpl g5 = new GeekImpl(compteur, "JOUANNE", "Fabien", "fjouanne", null, EnumRoles.RT, 
//				"fabien.jouanne@c-s.fr", "0000000000",
//				new ArrayList<String>(), new ArrayList<Conge>(), "zeTouch", new ArrayList<String>());
//		tabMessFormat[0] = "fjouanne";
//		EnumMessageDisplayer.SUCCES.logMessage(MessageFormat.format(
//				Resources.getInstance().getAppliLabel("message.users.create.succes.text"), 
//				tabMessFormat[0]));
//		
//		compteur++;
//		GeekImpl g6 = new GeekImpl(compteur, "DUPONT", "Romain", "rdupont", null, EnumRoles.DEV, 
//				"romain.dupont@c-s.fr", "0000000000",
//				new ArrayList<String>(), new ArrayList<Conge>(), "zeTouch", new ArrayList<String>());
//		tabMessFormat[0] = "rdupont";
//		EnumMessageDisplayer.SUCCES.logMessage(MessageFormat.format(
//				Resources.getInstance().getAppliLabel("message.users.create.succes.text"), 
//				tabMessFormat[0]));
//		
//		compteur++;
//		GeekImpl g7 = new GeekImpl(compteur, "CHARCORNAC", "Simon-Pierre", "spchacornac", null, EnumRoles.DEV, 
//				"simon-pierre.chacornac@c-s.fr", "0000000000",
//				new ArrayList<String>(), new ArrayList<Conge>(), "zeTouch", new ArrayList<String>());
//		tabMessFormat[0] = "spchacornac";
//		EnumMessageDisplayer.SUCCES.logMessage(MessageFormat.format(
//				Resources.getInstance().getAppliLabel("message.users.create.succes.text"), 
//				tabMessFormat[0]));
//		
//		compteur++;
//		GeekImpl g8 = new GeekImpl(compteur, "LALLEMANT", "Jean-Claude", "jlallemant", null, EnumRoles.EM, 
//				"jean-claude.lallemant@capgemini.com", "0000000000",
//				new ArrayList<String>(), new ArrayList<Conge>(), "zeTouch", new ArrayList<String>());
//		tabMessFormat[0] = "jlallemant";
//		EnumMessageDisplayer.SUCCES.logMessage(MessageFormat.format(
//				Resources.getInstance().getAppliLabel("message.users.create.succes.text"), 
//				tabMessFormat[0]));
//		
//		compteur++;
//		CustomerImpl c1 = new CustomerImpl(compteur, "MARESTIN", "Nicolas", "nmarestin", null, EnumRoles.CUSTOMER, 
//				"nicolas.marestin@airbus.com", "0000000000",
//				new ArrayList<String>(), new ArrayList<Conge>(), EnumCompagny.ADS.toString());
//		tabMessFormat[0] = "nmarestin";
//		EnumMessageDisplayer.SUCCES.logMessage(MessageFormat.format(
//				Resources.getInstance().getAppliLabel("message.users.create.succes.text"), 
//				tabMessFormat[0]));
//		
//		compteur++;
//		CustomerImpl c2 = new CustomerImpl(compteur, "LEFEVRE", "Charlotte", "clefevre", null, EnumRoles.CUSTOMER, 
//				"charlotte.lefevre@airbus.com", "0000000000",
//				new ArrayList<String>(), new ArrayList<Conge>(), EnumCompagny.ADS.toString());
//		tabMessFormat[0] = "clefevre";
//		EnumMessageDisplayer.SUCCES.logMessage(MessageFormat.format(
//				Resources.getInstance().getAppliLabel("message.users.create.succes.text"), 
//				tabMessFormat[0]));
//		
//		compteur++;
//		CustomerImpl c3 = new CustomerImpl(compteur, "BRUTUS", "Julien", "jbrutus", null, EnumRoles.CUSTOMER, 
//				"julien.brutus@airbus.com", "0000000000",
//				new ArrayList<String>(), new ArrayList<Conge>(), EnumCompagny.ADS.toString());
//		tabMessFormat[0] = "jbrutus";
//		EnumMessageDisplayer.SUCCES.logMessage(MessageFormat.format(
//				Resources.getInstance().getAppliLabel("message.users.create.succes.text"), 
//				tabMessFormat[0]));
//		
//		compteur++;
//		CustomerImpl c4 = new CustomerImpl(compteur, "BROCARD", "S�bastien", "sbrocard", null, EnumRoles.CUSTOMER, 
//				"sebastien.brocard@airbus.com", "0000000000",
//				new ArrayList<String>(), new ArrayList<Conge>(), EnumCompagny.ADS.toString());
//		tabMessFormat[0] = "sbrocard";
//		EnumMessageDisplayer.SUCCES.logMessage(MessageFormat.format(
//				Resources.getInstance().getAppliLabel("message.users.create.succes.text"), 
//				tabMessFormat[0]));
//		
//		compteur++;
//		CustomerImpl c5 = new CustomerImpl(compteur, "SALARY", "Benjamin", "bsalary", null, EnumRoles.CUSTOMER, 
//				"benjamin.salary@airbus.com", "0000000000",
//				new ArrayList<String>(), new ArrayList<Conge>(), EnumCompagny.ADS.toString());
//		tabMessFormat[0] = "bsalary";
//		EnumMessageDisplayer.SUCCES.logMessage(MessageFormat.format(
//				Resources.getInstance().getAppliLabel("message.users.create.succes.text"), 
//				tabMessFormat[0]));
//		
//		_userDBSimu = new HashMap<>();
//		_userDBSimu.put(g0.get_idUser(), g0);
//		_userDBSimu.put(g1.get_idUser(), g1);
//		_userDBSimu.put(g2.get_idUser(), g2);
//		_userDBSimu.put(g3.get_idUser(), g3);
//		_userDBSimu.put(g4.get_idUser(), g4);
//		_userDBSimu.put(g5.get_idUser(), g5);
//		_userDBSimu.put(g6.get_idUser(), g6);
//		_userDBSimu.put(g7.get_idUser(), g7);
//		_userDBSimu.put(g8.get_idUser(), g8);
//		_userDBSimu.put(c1.get_idUser(), c1);
//		_userDBSimu.put(c2.get_idUser(), c2);
//		_userDBSimu.put(c3.get_idUser(), c3);
//		_userDBSimu.put(c4.get_idUser(), c4);
//		_userDBSimu.put(c5.get_idUser(), c5);
//		
//		// ============ Init des projets ============
//		/* Astroterra */
//		GeekImpl projectManager = null;
//		for (int i = 0; i < _userDBSimu.size(); i++) {
//			if (_userDBSimu.get(i).get_userLogin().equals("jlallemant")) {
//				projectManager = (GeekImpl) _userDBSimu.get(i);
//				break;
//			}
//		}
//		Project p1 = new ProjetImpl("Astroterra", projectManager.get_idUser(), 
//				new ArrayList<Integer>(), 
//				new ArrayList<String>());
//	
//		p1.get_projectUsersList().add(g8.get_idUser());
//		p1.get_projectUsersList().add(g2.get_idUser());
//		p1.get_projectUsersList().add(g4.get_idUser());
//		p1.get_projectUsersList().add(g1.get_idUser());
//		p1.get_projectUsersList().add(g0.get_idUser());
//		p1.get_projectUsersList().add(c1.get_idUser());
//		p1.get_projectUsersList().add(c2.get_idUser());
//		
//		tabMessFormat[0] = "Astroterra";
//		EnumMessageDisplayer.SUCCES.logMessage(MessageFormat.format(
//				Resources.getInstance().getAppliLabel("message.projets.create.succes.text"), 
//				tabMessFormat[0]));
//
//		/* Pleiades */
//		GeekImpl projectManager2 = null;
//		for (int i = 0; i < _userDBSimu.size(); i++) {
//			if (_userDBSimu.get(i).get_userLogin().equals("nfabre")) {
//				projectManager2 = (GeekImpl) _userDBSimu.get(i);
//				break;
//			}
//		}
//		Project p2 = new ProjetImpl("Pleiades", projectManager2.get_idUser(), 
//				new ArrayList<Integer>(), 
//				new ArrayList<String>());
//		
//		p2.get_projectUsersList().add(g3.get_idUser());
//		p2.get_projectUsersList().add(g5.get_idUser());
//		p2.get_projectUsersList().add(g6.get_idUser());
//		p2.get_projectUsersList().add(g1.get_idUser());
//		p2.get_projectUsersList().add(c3.get_idUser());
//		p2.get_projectUsersList().add(c4.get_idUser());
//		p2.get_projectUsersList().add(c5.get_idUser());
//		
//		tabMessFormat[0] = "Pleiades";
//		EnumMessageDisplayer.SUCCES.logMessage(MessageFormat.format(
//				Resources.getInstance().getAppliLabel("message.projets.create.succes.text"), 
//				tabMessFormat[0]));
//
//		// ============ Init des livrables ============
//		/* Astroterra */
//		Livrable liv1 = new LivrableImpl("V03-02", "03-02", 
//				EnumLivrables.VERSION, new ArrayList<String>(), p1.get_projectName());
//		tabMessFormat[0] = "V03-02";
//		EnumMessageDisplayer.SUCCES.logMessage(MessageFormat.format(
//				Resources.getInstance().getAppliLabel("message.livrable.create.succes.text"), 
//				tabMessFormat[0]));
//		
//		Livrable liv2 = new LivrableImpl("V03-02-01", "03-02_01",
//				EnumLivrables.PATCH, new ArrayList<String>(), p1.get_projectName());
//		tabMessFormat[0] = "V03-02-01";
//		EnumMessageDisplayer.SUCCES.logMessage(MessageFormat.format(
//				Resources.getInstance().getAppliLabel("message.livrable.create.succes.text"), 
//				tabMessFormat[0]));
//		
//		Livrable liv3 = new LivrableImpl("V04-02", "04-02", 
//				EnumLivrables.VERSION, new ArrayList<String>(), p1.get_projectName());
//		tabMessFormat[0] = "V04-02";
//		EnumMessageDisplayer.SUCCES.logMessage(MessageFormat.format(
//				Resources.getInstance().getAppliLabel("message.livrable.create.succes.text"), 
//				tabMessFormat[0]));
//		
//		/* Pleiades */
//		Livrable liv4 = new LivrableImpl("V04-13", "04-13",
//				EnumLivrables.VERSION, new ArrayList<String>(), p2.get_projectName());
//		tabMessFormat[0] = "V04-13";
//		EnumMessageDisplayer.SUCCES.logMessage(MessageFormat.format(
//				Resources.getInstance().getAppliLabel("message.livrable.create.succes.text"), 
//				tabMessFormat[0]));
//		
//		Livrable liv5 = new LivrableImpl("04-12-30", "04-12-30",
//				EnumLivrables.PATCH, new ArrayList<String>(), p2.get_projectName());
//		tabMessFormat[0] = "04-12-30";
//		EnumMessageDisplayer.SUCCES.logMessage(MessageFormat.format(
//				Resources.getInstance().getAppliLabel("message.livrable.create.succes.text"), 
//				tabMessFormat[0]));
//
//		// ============ Init des actions ============
//		
//		EvolutionImpl evol1 = null;
//		EvolutionImpl evol2 = null;
//		EvolutionImpl evol3 = null;
//		EvolutionImpl evol4 = null;
//		EvolutionImpl evol5 = null;
//		EvolutionImpl evol6 = null;
//		EvolutionImpl evol7 = null;
//		try {
//			/* Pleiades */
//			evol1 = new EvolutionImpl("Amelioration des fonctions AU de notification", "PM 34894",
//					new StringBuffer(), new ArrayList<String>(), g1.get_idUser(), new URL("http://www.google.fr"),
//					8.5, 3.0, 13720.00, new ArrayList<URL>());
//			tabMessFormat[0] = "PM 34894";
//			EnumMessageDisplayer.SUCCES.logMessage(MessageFormat.format(
//					Resources.getInstance().getAppliLabel("message.action.create.succes.text"), 
//					tabMessFormat[0]));
//			
//			evol2 = new EvolutionImpl("Amelioration ergonomie AU", "PM 34896",
//					new StringBuffer(), new ArrayList<String>(), g1.get_idUser(), new URL("http://www.google.fr"),
//					12.0, 4.0, 19551.0, new ArrayList<URL>());
//			tabMessFormat[0] = "PM 34896";
//			EnumMessageDisplayer.SUCCES.logMessage(MessageFormat.format(
//					Resources.getInstance().getAppliLabel("message.action.create.succes.text"), 
//					tabMessFormat[0]));
//			
//			evol3 = new EvolutionImpl("Acces OCCAT", "PM 33546",
//					new StringBuffer(), new ArrayList<String>(), g1.get_idUser(), new URL("http://www.google.fr"),
//					11.5, 4.5, 23524.0, new ArrayList<URL>());
//			tabMessFormat[0] = "PM 33546";
//			EnumMessageDisplayer.SUCCES.logMessage(MessageFormat.format(
//					Resources.getInstance().getAppliLabel("message.action.create.succes.text"), 
//					tabMessFormat[0]));
//			
//			evol4 = new EvolutionImpl("Optimisation des propagations de requetes ICR / PR", "PM 34514",
//					new StringBuffer(), new ArrayList<String>(), g1.get_idUser(), new URL("http://www.google.fr"),
//					2.5, 1.0, 5145.0, new ArrayList<URL>());
//			tabMessFormat[0] = "PM 34514";
//			EnumMessageDisplayer.SUCCES.logMessage(MessageFormat.format(
//					Resources.getInstance().getAppliLabel("message.action.create.succes.text"), 
//					tabMessFormat[0]));
//			
//			/* Astroterra */
//			evol5 = new EvolutionImpl("Amelioration ergonomie UAS", "CN 483",
//					new StringBuffer(), new ArrayList<String>(), g1.get_idUser(), new URL("http://www.google.fr"),
//					11.0, 7.0, 19545.99, new ArrayList<URL>());
//			tabMessFormat[0] = "CN 483";
//			EnumMessageDisplayer.SUCCES.logMessage(MessageFormat.format(
//					Resources.getInstance().getAppliLabel("message.action.create.succes.text"), 
//					tabMessFormat[0]));
//			
//			evol6 = new EvolutionImpl("Amelioration des fonctions AU de notification", "CN 484",
//					new StringBuffer(), new ArrayList<String>(), g1.get_idUser(), new URL("http://www.google.fr"),
//					5.0, 6.0, 9672.66, new ArrayList<URL>());
//			tabMessFormat[0] = "CN 484";
//			EnumMessageDisplayer.SUCCES.logMessage(MessageFormat.format(
//					Resources.getInstance().getAppliLabel("message.action.create.succes.text"), 
//					tabMessFormat[0]));
//			
//			evol7 = new EvolutionImpl("Modification de la retention des exports ICR", "CN 485",
//					new StringBuffer(), new ArrayList<String>(), g2.get_idUser(), new URL("http://www.google.fr"),
//					1.0, 1.0, 1450.90, new ArrayList<URL>());
//			tabMessFormat[0] = "CN 485";
//			EnumMessageDisplayer.SUCCES.logMessage(MessageFormat.format(
//					Resources.getInstance().getAppliLabel("message.action.create.succes.text"), 
//					tabMessFormat[0]));
//			
//		} catch (MalformedURLException e) {
//			EnumMessageDisplayer.ERROR.logMessage("MalformedURLException");
//		}
//		
//		// Tout le monde couche avec tout le monde !!
//		liv1.get_actionsList().add(evol7.get_actionNum());
//		tabMessFormat[0] = liv1.get_livNum();
//		EnumMessageDisplayer.SUCCES.logMessage(MessageFormat.format(
//				Resources.getInstance().getAppliLabel("message.livrable.update.succes.text"), 
//				tabMessFormat[0]));
//		
//		liv2.get_actionsList().add(evol5.get_actionNum());
//		tabMessFormat[0] = liv2.get_livNum();
//		EnumMessageDisplayer.SUCCES.logMessage(MessageFormat.format(
//				Resources.getInstance().getAppliLabel("message.livrable.update.succes.text"), 
//				tabMessFormat[0]));
//		
//		liv2.get_actionsList().add(evol6.get_actionNum());
//		tabMessFormat[0] = liv3.get_livNum();
//		EnumMessageDisplayer.SUCCES.logMessage(MessageFormat.format(
//				Resources.getInstance().getAppliLabel("message.livrable.update.succes.text"), 
//				tabMessFormat[0]));
//
//		
//		liv4.get_actionsList().add(evol1.get_actionNum());
//		tabMessFormat[0] = liv4.get_livNum();
//		EnumMessageDisplayer.SUCCES.logMessage(MessageFormat.format(
//				Resources.getInstance().getAppliLabel("message.livrable.update.succes.text"), 
//				tabMessFormat[0]));
//		
//		liv4.get_actionsList().add(evol2.get_actionNum());
//		tabMessFormat[0] = liv4.get_livNum();
//		EnumMessageDisplayer.SUCCES.logMessage(MessageFormat.format(
//				Resources.getInstance().getAppliLabel("message.livrable.update.succes.text"), 
//				tabMessFormat[0]));
//		
//		liv4.get_actionsList().add(evol3.get_actionNum());
//		tabMessFormat[0] = liv4.get_livNum();
//		EnumMessageDisplayer.SUCCES.logMessage(MessageFormat.format(
//				Resources.getInstance().getAppliLabel("message.livrable.update.succes.text"), 
//				tabMessFormat[0]));
//		
//		liv4.get_actionsList().add(evol4.get_actionNum());
//		tabMessFormat[0] = liv4.get_livNum();
//		EnumMessageDisplayer.SUCCES.logMessage(MessageFormat.format(
//				Resources.getInstance().getAppliLabel("message.livrable.update.succes.text"), 
//				tabMessFormat[0]));
//		
//		p1.get_projectIDLivrablesList().add(liv1.get_livName());
//		tabMessFormat[0] = p1.get_projectName();
//		EnumMessageDisplayer.SUCCES.logMessage(MessageFormat.format(
//				Resources.getInstance().getAppliLabel("message.projets.update.succes.text"), 
//				tabMessFormat[0]));
//		
//		p1.get_projectIDLivrablesList().add(liv2.get_livName());
//		tabMessFormat[0] = p1.get_projectName();
//		EnumMessageDisplayer.SUCCES.logMessage(MessageFormat.format(
//				Resources.getInstance().getAppliLabel("message.projets.update.succes.text"), 
//				tabMessFormat[0]));
//		
//		p2.get_projectIDLivrablesList().add(liv4.get_livName());
//		tabMessFormat[0] = p2.get_projectName();
//		EnumMessageDisplayer.SUCCES.logMessage(MessageFormat.format(
//				Resources.getInstance().getAppliLabel("message.projets.update.succes.text"), 
//				tabMessFormat[0]));
//		EnumMessageDisplayer.INFO.logMessage("\n**************************************************************************\n");
//		EnumMessageDisplayer.INFO.logMessage("Test saut de ligne.");
//	}
//
//	
//	/* (non-Javadoc)
//	 * @see fre.mmm.databases.manager.DataBase#addUser(fre.mmm.model.User)
//	 */
//	@Override
//	public synchronized void createUser(User user_) throws Exception{
//		
//		if (user_ == null || user_.get_userLogin() == null) {
//			throw new NullPointerException();
//		}else {
//			if (getUsersMap().put(user_.get_idUser(), user_) == null) {
//				throw new Exception();
//			}
//		}
//
//		
//	}
//	
//	/*
//	 * (non-Javadoc)
//	 * @see fre.mmm.databases.DataBase#getUser(java.lang.Integer)
//	 */
//	@Override
//	public User getUser(Integer user_) throws Exception {
//		return null;
//	}
//	
//	/*
//	 * (non-Javadoc)
//	 * @see fre.mmm.databases.DataBase#getUsers()
//	 */
//	@Override
//	public HashMap<Integer, User> getUsers() throws Exception {
//		return null;
//	}
//	
//	/* (non-Javadoc)
//	 * @see fre.mmm.databases.manager.DataBase#updateUser(java.lang.String)
//	 */
//	@Override
//	public synchronized void updateUser(User user_) throws Exception{
//		
//		if (user_ == null || user_.get_userLogin() == null) {
//			throw new NullPointerException();
//			
//		}else {
//			
//			if (getUsersMap().get(user_.get_userLogin()) == null) {
//				
//				throw EnumAppliExceptionType.NO_USER_EXIST_EXCEPTION.getException();
//			}else {
//				
//				getUsersMap().remove(user_.get_userLogin());
//				getUsersMap().put(user_.get_idUser(), user_);
//			}
//		}
//
//	}
//	
//	/* (non-Javadoc)
//	 * @see fre.mmm.databases.manager.DataBase#removeUser(java.lang.String)
//	 */
//	@Override
//	public synchronized void removeUser(String userLogin_) throws Exception{
//		
//		if (getUsersMap().get(userLogin_) == null) {
//			throw EnumAppliExceptionType.NO_USER_EXIST_EXCEPTION.getException();
//		}else {
//			getUsersMap().remove(userLogin_);
//		}
//	}
//	
//	/* (non-Javadoc)
//	 * @see fre.mmm.databases.manager.DataBase#addProject(fre.mmm.model.Project)
//	 */
//	@Override
//	public synchronized void createProject(Project project_) throws Exception{
//		
//		if (project_ == null || project_.get_projectName() == null) {
//			throw new NullPointerException();
//		}else {
//			getProjectsMap().put(project_.get_projectName(), project_);
//		}
//	}
//	
//	/* (non-Javadoc)
//	 * @see fre.mmm.databases.manager.DataBase#updateProject(java.lang.String)
//	 */
//	@Override
//	public synchronized void updateProject(Project project_) throws Exception{
//		
//		if (project_ == null || project_.get_projectName() == null) {
//			throw new NullPointerException();
//			
//		}else {
//			
//			if (getProjectsMap().get(project_.get_projectName()) == null) {
//				
//				throw EnumAppliExceptionType.NO_USER_EXIST_EXCEPTION.getException();
//			}else {
//				
//				getProjectsMap().remove(project_.get_projectName());
//				getProjectsMap().put(project_.get_projectName(), project_);
//			}
//		}
//	}
//	
//	/* (non-Javadoc)
//	 * @see fre.mmm.databases.manager.DataBase#removeProject(java.lang.String)
//	 */
//	@Override
//	public synchronized void removeProject(String projectName_) throws Exception{
//		
//		if (getProjectsMap().get(projectName_) == null) {
//			throw EnumAppliExceptionType.NO_USER_EXIST_EXCEPTION.getException();
//		}else {
//			getProjectsMap().remove(projectName_);
//		}
//	}
//	
//	/* (non-Javadoc)
//	 * @see fre.mmm.databases.manager.DataBase#addLivrable(fre.mmm.model.Livrable)
//	 */
//	@Override
//	public synchronized void createLivrable(Livrable livrable_) throws Exception{
//		
//		if (livrable_ == null || livrable_.get_livNum() == null) {
//			throw new NullPointerException();
//		}else {
////			getProjectsMap().get(livrable_.get);
//		}
//	}
//	
//	/* (non-Javadoc)
//	 * @see fre.mmm.databases.manager.DataBase#updateLivrable(java.lang.String)
//	 */
//	@Override
//	public synchronized void updateLivrable(Livrable livrable_) throws Exception{
////		return true;
//	}
//	
//	/* (non-Javadoc)
//	 * @see fre.mmm.databases.manager.DataBase#removeLivrable(java.lang.String)
//	 */
//	@Override
//	public synchronized void removeLivrable(String livrableName_) throws Exception{
////		return true;
//	}
//	
//	/* (non-Javadoc)
//	 * @see fre.mmm.databases.manager.DataBase#addAction(fre.mmm.model.Action)
//	 */
//	@Override
//	public synchronized void createAction(Action action_) throws Exception{
////		return true;
//	}
//	
//	/* (non-Javadoc)
//	 * @see fre.mmm.databases.manager.DataBase#updateAction(java.lang.String)
//	 */
//	@Override
//	public synchronized void updateAction(Action action_) throws Exception{
////		return true;
//	}
//	
//	/* (non-Javadoc)
//	 * @see fre.mmm.databases.manager.DataBase#removeAction(java.lang.String)
//	 */
//	@Override
//	public synchronized void removeAction(String actionName_) throws Exception{
////		return true;
//	}
//
//	@Override
//	public synchronized HashMap<String, Project> getProjectsMap() throws Exception{
//		return _projectDBSimu;
//	}
//
//	@Override
//	public synchronized HashMap<Integer, User> getUsersMap() throws Exception{
//		return _userDBSimu;
//	}
//	
//	
//	
//	
//}
