//package fre.mmm.views.tests;
//
//import java.awt.BorderLayout;
//import java.awt.Color;
//import java.awt.FlowLayout;
//import java.awt.GridBagConstraints;
//import java.awt.GridBagLayout;
//import java.awt.Insets;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.awt.event.FocusEvent;
//import java.awt.event.FocusListener;
//import java.awt.event.KeyEvent;
//import java.awt.event.KeyListener;
//import java.util.ArrayList;
//import java.util.Collection;
//import java.util.Iterator;
//
//import javax.swing.BorderFactory;
//import javax.swing.ComboBoxModel;
//import javax.swing.JButton;
//import javax.swing.JComboBox;
//import javax.swing.JFrame;
//import javax.swing.JLabel;
//import javax.swing.JOptionPane;
//import javax.swing.JPanel;
//import javax.swing.JTextField;
//
//import fre.mmm.application.manager.ApplicationManager;
//import fre.mmm.application.manager.UsersManager;
//import fre.mmm.model.Projet;
//import fre.mmm.model.User;
//import fre.mmm.resources.Resources;
//import fre.mmm.tests.views.utils.FormUtils;
//
//public class TestProjetFrame extends JFrame {
//
//	private JLabel projet;
//	private JLabel chef;
//	
//	private JTextField projetTF;
//	private JComboBox<Object> chefTF;
//	private JTextField projetSearchTF;
//	
//	private JPanel searchPanel;
//	private JPanel userPanel;
//	private JPanel buttonPanel;
//	
//	private JButton submit;
//	private JButton delete;
//	private JButton cancel;
//	private JButton get;
//	private JButton reset;
//	
//	private boolean isFormValid = true;
//	
//	private UsersManager _userManager;
//	
//	public TestProjetFrame(){
//		
//		_userManager = ApplicationManager.getInstance(false).getUserManager();
//		initTestUsersFrame();
//		
//	}
//
//	private void initTestUsersFrame() {
//		
//		setTitle("USER ADMIN FRAME");
//		setLayout(new BorderLayout());
//		
//		initAttributes();
//		initButtons();
//		initPanels();
//		
//		add(searchPanel, BorderLayout.NORTH);
//		add(userPanel, BorderLayout.CENTER);
//		add(buttonPanel, BorderLayout.SOUTH);
//		
//		setSize(350, 250);
//		setResizable(false);
//		setLocationRelativeTo(null);
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setVisible(true);
//		
//	}
//
//	private void initPanels() {
//		
//		searchPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
//		searchPanel.add(reset);
//		searchPanel.add(projetSearchTF);
//		searchPanel.add(get);
//		
//		userPanel = new JPanel(new GridBagLayout());
//		GridBagConstraints gbc = new GridBagConstraints();
//		
//		gbc.gridx = 0; 
//		gbc.gridy = 0;
//		gbc.insets = new Insets(3,0,3,0); 
//		userPanel.add(projet, gbc);
//		gbc.gridx = 1; 
//		gbc.gridy = 0;
//		gbc.insets = new Insets(3,0,3,0);
//		userPanel.add(projetTF, gbc);
//		
//		gbc.gridx = 0;
//		gbc.gridy = 1;
//		gbc.insets = new Insets(3,0,3,0);
//		userPanel.add(chef, gbc);
//		gbc.gridx = 1;
//		gbc.gridy = 1;
//		gbc.insets = new Insets(3,0,3,0);
//		userPanel.add(chefTF, gbc);
//		
//		
//		buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
//		buttonPanel.add(submit);
//		buttonPanel.add(delete);
//		buttonPanel.add(cancel);
//	}
//
//	private void initButtons() {
//		
//		submit = new JButton("Enregistrer");
//		submit.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent arg0) {
//				
//				if (isFormValid) {
//					if (submit.getText().equals("Enregistrer")) {
//						Resources.getInstance().addProjet(buildProject());
//						resetIhm();
//					}else if (submit.getText().equals("Modifier")) {
//						Resources.getInstance().updateProjet(buildProject(), projetTF.getText());
//						resetIhm();
//					}
//				}else {
//					JOptionPane.showMessageDialog(null, "Le formulaire est incomplet ou eron�", "ERREUR FORMULAIRE", JOptionPane.ERROR_MESSAGE);
//				}
//
//			}
//		});
//		
//		delete = new JButton("Supprimer");
//		delete.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent arg0) {
//				System.out.println("Supprime l' utilisteur");
//				Resources.getInstance().deleteProjet(projetTF.getText());
//				resetIhm();
//			}
//		});
//		
//		cancel = new JButton("Annuler");
//		cancel.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent arg0) {
//				dispose();
//			}
//		});
//		
//		get = new JButton("Chercher");
//		get.setEnabled(false);
//		get.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent arg0) {
//				System.out.println("Cherche un utilisteur");
//				Projet projet = Resources.getInstance().getProjet(projetSearchTF.getText());
//				projetTF.setText(projet.getNomproj());
//				chefTF.setSelectedItem(projet.getChef());
//				
//				submit.setText("Modifier");
//			}
//		});
//		
//		reset = new JButton("Reset IHM");
//		reset.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				resetIhm();
//			}
//		});
//	}
//
//	private void initAttributes() {
//		
//		projet = new JLabel("Nom du projet : ");
//		projetTF = new JTextField(20);
//		projetTF.addFocusListener(new FocusListener() {
//			@Override
//			public void focusLost(FocusEvent e) {
//				if (!FormUtils.checkFirstNameFormat(projetTF.getText())) {
//					projetTF.setBorder(BorderFactory.createLineBorder(Color.RED));
//					isFormValid = false;
//				}
//			}
//			
//			@Override
//			public void focusGained(FocusEvent e) {
//			}
//		});
//		
//		chef = new JLabel("Chef de projet : ");
//		ArrayList<String> tabName = new ArrayList<>();
//		Collection<User> list = Resources.getInstance().getUsers();
//		for (Iterator<User> iterator = list.iterator(); iterator.hasNext();) {
//			User user = (User) iterator.next();
//			tabName.add(user.getPrenom() + " " + user.getNom());
//		}
//		chefTF = new JComboBox<>(tabName.toArray());
//		chefTF.addItem(new String(""));
//		
//		projetSearchTF = new JTextField(10);
//		projetSearchTF.addKeyListener(new KeyListener() {
//			@Override
//			public void keyTyped(KeyEvent arg0) {
//				if (projetSearchTF.getText().equals("")) {
//					get.setEnabled(false);
//				}else {
//					get.setEnabled(true);
//				}
//			}
//			@Override
//			public void keyReleased(KeyEvent arg0) {
//				if (projetSearchTF.getText().equals("")) {
//					get.setEnabled(false);
//				}else {
//					get.setEnabled(true);
//				}
//			}
//			@Override
//			public void keyPressed(KeyEvent arg0) {
//				if (projetSearchTF.getText().equals("")) {
//					get.setEnabled(false);
//				}else {
//					get.setEnabled(true);
//				}
//			}
//		});
//		
//	}
//	
//	private void resetIhm(){
//		
//		projetSearchTF.setText("");
//		get.setEnabled(false);
//		submit.setText("Enregistrer");
//		
//		projetTF.setText(""); 
//		chefTF.setSelectedItem("");
//		isFormValid = true;
//	}
//	
//	private Projet buildProject(){
//		
//		Projet projet = new Projet(projetTF.getText(), 
//				(String) chefTF.getSelectedItem());
//
//		return projet;
//	}
//	
//	
//}
