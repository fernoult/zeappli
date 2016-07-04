/* ihmref-ExploraterFrame.java
 * HISTORIQUE
 *
 * [MODIF]: Version - le 8 avr. 2015 - Creation de la classe.
 *
 * FIN HISTORIQUE
 */
package fre.mmm.views;

import java.awt.BorderLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import fre.mmm.application.manager.ApplicationManager;
import fre.mmm.model.Project;
import fre.mmm.resources.Resources;
import fre.mmm.resources.enums.EnumMessageDisplayer;
import fre.mmm.views.attributaires.NewProjAttributeFrame;
import fre.mmm.views.attributaires.ObjFrame;
import fre.mmm.views.attributaires.PrefsFrame;
import fre.mmm.views.composants.ElementEnum;
import fre.mmm.views.composants.panes.elements.ElementFactory;
import fre.mmm.views.composants.panes.elements.RButton;
import fre.mmm.views.composants.panes.tabpanes.ProjectTab;
import fre.mmm.views.tabulaires.TabFrame;

/**
 * @author fre
 *
 */
public class ExploraterFrame extends AppFrame {
	
	/** Le bouton de sortie de l'application. */
	private RButton _exit;

	/** Le bouton de création d'un nouveau projet. */
	private RButton _newProj;
	
	/** Bouton de creation de la fenetre des preferences. */
	private RButton _prefs;
	
	/** Largeur de la fenetre explorateur. */
	private int _width;
	
	/** Hauteur de la fenetre explorateur. */
	private int _height;
	
	/** Instance de l'explorateur pour passage dans un listner. */
	private ExploraterFrame _explo;
	
	private ApplicationManager _appliManager;
	
	private JTabbedPane tabbedPane;

	/**
	 * 
	 * Constructeur de la classe ExploraterFrame.java
	 */
	public ExploraterFrame() {
		super();
		initSize();
		initPFrame();
	}
	
	/**
	 * 
	 * Constructeur de la classe ExploraterFrame.java
	 * @param title_
	 */
	public ExploraterFrame(String title_){
		super();
		setTitle(title_);
		initSize();
		initPFrame();
	}
	
	/**
	 * 
	 * <b>initSize() - org.tref.views.frames.ExploraterFrame.initSize()</b><br/>
	 *
	 * <b>Description: </b> <br/>
	 * 		Positionne la taille de l'exploratuer.<br/>
	 * <br/>
	 */
	protected void initSize(){
		
		// On poisitionne la taille de l'explorateur.
		_width = get_ressources().getSreenSize().width - 50;
		_height = get_ressources().getSreenSize().height - 50;
	}
	
	/*
	 * (non-Javadoc)
	 * @see org.tref.views.frames.PFrame#initPFrame()
	 */
	@Override
	protected void initPFrame() {
		
		// Appel de l'init de la fenetre parente.
		super.initPFrame();
		
		_appliManager = ApplicationManager.getInstance();
		
		// On instancie this.
		// et init des composants.
		_explo = this;
		initComposants();
		initPanels();
		
		// On ajoute le panneau nord.
		add(get_northPane(), BorderLayout.NORTH);
		add(_centerPane, BorderLayout.CENTER);
		
		
		// Comportement de base de la fenetre.
		// Taille, position sur l'ecran, comportement de fermeture.
		setSize(_width, _height);
//		try {
//			setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource(_ressources.getImgsPath() + Resources.getInstance().getSepProj() + _ressources.getPFrameLabel("explorater.icon.name"))));
//
//		} catch (NullPointerException e) {
//			EnumMessageDisplayer.ERROR.displayException(e);
//		}
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	/*
	 * (non-Javadoc)
	 * @see org.tref.views.frames.PFrame#initPanels()
	 */
	@Override
	protected void initPanels() {
		
		// On initialise le panneau nord.
		_northPane.add(_toolBar);
		
		// On initialise le panneau d'exploration 
		// des projets.
		tabbedPane = new JTabbedPane();
		try {
			if (_appliManager.getProjectManager().do_getNBProjects() != 0) {
				ArrayList<Project> liste = _appliManager.getProjectManager().do_getProjects();
				for (Iterator<Project> iterator = liste.iterator(); iterator.hasNext();) {
					Project project = (Project) iterator.next();
					JPanel pane = new ProjectTab(project);
					tabbedPane.addTab(project.get_projectName(), pane);
				}
			}
		} catch (Exception e) {
			EnumMessageDisplayer.ERROR.logMessage(e.getMessage());
		}
		
		_centerPane.add(tabbedPane);
		
		
	}
	
	/*
	 * (non-Javadoc)
	 * @see org.tref.views.frames.PFrame#initComposants()
	 */
	@Override
	protected void initComposants() {
		
		// ============= BOUTONS =================
		_exit = ElementFactory.getInstance().getButton(ElementEnum.ICON_BUTTON, 
				_ressources.getLibelleButtonValues("explorateur.btn.exit.values"));
		_exit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e_) {
				if (confirmCloseApplication() == 0) {
					dispose();					
				}
			}
		});
		
		_newProj = ElementFactory.getInstance().getButton(ElementEnum.ICON_BUTTON, 
				_ressources.getLibelleButtonValues("explorateur.btn.newproj.values"));
		_newProj.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e_) {
				
				// Ouvre une vue attributaire de cration d'un nouveau projet.
				new NewProjAttributeFrame();
				
				// Cree un nouvel onglet initialisé avec les premieres donnees.
			}
		});

		
		_prefs = ElementFactory.getInstance().getButton(ElementEnum.ICON_BUTTON, 
				_ressources.getLibelleButtonValues("explorateur.btn.prefs.values"));
		_prefs.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				PrefsFrame laff = new PrefsFrame("PREFS", _explo);
				addFrame(laff);
			}
		});
		
		// ============= TOOLBAR =================

		_toolBar.add(_prefs);
		_toolBar.add(_newProj);
		_toolBar.add(_exit);
		
	}
	
	/*
	 * (non-Javadoc)
	 * @see org.tref.views.frames.AppFrame#dispose()
	 */
	@Override
	public void dispose() {
		super.dispose();
		// Exit du programme
		System.exit(0);

	}
	
	/*
	 * (non-Javadoc)
	 * @see org.tref.views.frames.AppFrame#confirmCloseApplication()
	 */
	@Override
	protected int confirmCloseApplication() {
		// TODO Auto-generated method stub
		return super.confirmCloseApplication();
	}

	
}
