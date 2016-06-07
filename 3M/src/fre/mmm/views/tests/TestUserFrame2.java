package fre.mmm.views.tests;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;

import fre.mmm.application.manager.ApplicationManager;
import fre.mmm.application.manager.UsersManager;
import fre.mmm.model.User;
import fre.mmm.model.impl.UserImpl;
import fre.mmm.resources.Resources;
import fre.mmm.resources.enums.EnumMessageDisplayer;
import fre.mmm.views.composants.ZeTextField;
import fre.mmm.views.utils.FormUtils;

public class TestUserFrame2 extends JFrame implements KeyListener, FocusListener{

	private JLabel nom = new JLabel("Nom : ");
	private JLabel prenom = new JLabel("Prénom : ");
	private JLabel login = new JLabel("Login : ");
	private JLabel email = new JLabel("Email : ");
	private JLabel tel = new JLabel("Tel : ");
	private JLabel searchLibelle = new JLabel("login : ");
	private JLabel cadena = new JLabel();
	private JLabel add  = new JLabel();;
	private JLabel exit = new JLabel();
	private JLabel reset = new JLabel();	
	private JLabel submit = new JLabel();
	private JLabel delete = new JLabel();
	private JLabel search = new JLabel();
	private JLabel aro = new JLabel(" @ ");

	private ZeTextField nomTF;
	private ZeTextField prenomTF;
	private ZeTextField loginTF;
	private ZeTextField loginSearchTF;
	private ZeTextField emailTF;
	private ZeTextField telTF;
	
	private JPopupMenu mailSufixMenu = new JPopupMenu("capgemini.com");
	private String[] tabMailSufix = {"capgemini.com", "airbus.com", "astrium.eads.fr", "c-s.fr"};
	private JLabel sufix = new JLabel("capgemini.com");
	private JComboBox<String> combo = new JComboBox<String>(tabMailSufix);

	private JPanel commandPanel;
	private JPanel userPanel;


	private boolean isFormValid = true;
	private StringBuffer loginBuf;
	private StringBuffer emailBuf;

	private UsersManager _userManager;
	
	public TestUserFrame2(){

		_userManager = ApplicationManager.getInstance(false).getUserManager();
		initTestUsersFrame();

	}
	
	private void initTestUsersFrame() {

		setTitle("USER ADMIN FRAME");
		setLayout(new BorderLayout());

		initAttributes();
		initButtons();
		initPanels();
		
		enabledIhm(false);

		add(commandPanel, BorderLayout.NORTH);
		add(userPanel, BorderLayout.CENTER);

//		setUndecorated(true);
		setSize(450, 220);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);

	}
	
	private void initPanels() {

		/* ----- PANNEAU NORD -----*/
		commandPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		JLabel sep = new JLabel("  |  ");
		JPanel leftpane = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		JPanel rightpane = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		
		add.setIcon(Resources.getInstance().getAppliImage("add16.png"));
		add.setToolTipText("Cree un nouvel utilisateur.");
		reset.setIcon(Resources.getInstance().getAppliImage("resetView.png"));
		reset.setToolTipText("Vide la saisie.");
		search.setIcon(Resources.getInstance().getAppliImage("search16.png"));
		search.setToolTipText("Retourne l'utilisateur.");
		exit.setIcon(Resources.getInstance().getAppliImage("exit16.png"));
		
		leftpane.add(reset);
		leftpane.add(add);
		leftpane.add(exit);
		
		rightpane.add(searchLibelle);
		rightpane.add(loginSearchTF);
		rightpane.add(search);
		
		commandPanel.add(leftpane);
		commandPanel.add(sep);
		commandPanel.add(rightpane);
		
				
		/* ----- PANNEAU CENTRE ----- */
		userPanel = new JPanel(new GridBagLayout());
 
		int initer = 0;
		for (int line = 0; line < 6; line++) {
			if (line == initer) {
				initNomLine(new GridBagConstraints(), line);
			}else if (line == initer+1) {
				initPrenomLine(new GridBagConstraints(), line);
			}else if (line == initer+2) {
				initLoginLine(new GridBagConstraints(), line);
			}else if (line == initer+3) {
				initEmailLine(new GridBagConstraints(), line);
			}else if (line == initer+4) {
				initLastLine(new GridBagConstraints(), line);
			}
		}


	}

	private void initButtons() {

		submit.setIcon(Resources.getInstance().getAppliImage("submit16.png"));
		submit.setToolTipText("Enregistre l'utilisateur en BD");
		delete.setIcon(Resources.getInstance().getAppliImage("delete16.png"));
		
		submit.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent e_) {
			}
			@Override
			public void mousePressed(MouseEvent e_) {
			}
			@Override
			public void mouseExited(MouseEvent e_) {
			}
			@Override
			public void mouseEntered(MouseEvent e_) {
			}
			@Override
			public void mouseClicked(MouseEvent e_) {
				System.out.println("");
				try {
					
					if (submit.isEnabled()) {
						if (isFormValid) {
							String emailAdrr = emailTF.getText().trim() + "@" + sufix.getText();
							if (submit.getToolTipText().equals("Enregistre l'utilisateur en BD")) { // TODO Faire des properties pour ca!
								_userManager.do_createUser(nomTF.getText(), prenomTF.getText(), loginTF.getText(),
										null, null, emailAdrr, telTF.getText(), null, null);
								resetIhm();
								enabledIhm(false);
							}else if (submit.getToolTipText().equals("Modifie l'utilisateur en BD")) {
								_userManager.do_updateUser(buildUser(emailAdrr));
								resetIhm();
								enabledIhm(false);
							}
						}else {
							JOptionPane.showMessageDialog(null, "Le formulaire est incomplet ou eroné", "ERREUR FORMULAIRE", JOptionPane.ERROR_MESSAGE);
						}						
					}
				} catch (NumberFormatException e) {
					EnumMessageDisplayer.ERROR.logMessage(e.getMessage());
				} catch (Exception e) {
					e.printStackTrace();
					EnumMessageDisplayer.ERROR.logMessage(e.getMessage());
				}
			}
		});

		delete.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent e_) {
			}
			@Override
			public void mousePressed(MouseEvent e_) {
			}
			@Override
			public void mouseExited(MouseEvent e_) {
			}
			@Override
			public void mouseEntered(MouseEvent e_) {
			}
			@Override
			public void mouseClicked(MouseEvent e_) {
				
				if (delete.isEnabled()) {
					try {
						_userManager.do_removeUser(loginTF.getText());
						resetIhm();
						enabledIhm(false);
					} catch (NullPointerException e) {
						EnumMessageDisplayer.ERROR.logMessage(e.getMessage());
					} catch (Exception e) {
						EnumMessageDisplayer.ERROR.logMessage(e.getMessage());
					}
				}

			}
		});

		exit.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent e_) {
			}
			@Override
			public void mousePressed(MouseEvent e_) {
			}
			@Override
			public void mouseExited(MouseEvent e_) {
			}
			@Override
			public void mouseEntered(MouseEvent e_) {
			}
			@Override
			public void mouseClicked(MouseEvent e_) {
				dispose();
			}
		});

		search.setEnabled(false);
		search.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent e_) {
			}
			@Override
			public void mousePressed(MouseEvent e_) {
			}
			@Override
			public void mouseExited(MouseEvent e_) {
			}
			@Override
			public void mouseEntered(MouseEvent e_) {
			}
			@Override
			public void mouseClicked(MouseEvent e_) {
				System.out.println("Cherche un utilisteur");
				
				searchProcessing(e_);

			}
		});

		reset.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent e_) {
			}
			@Override
			public void mousePressed(MouseEvent e_) {
			}
			@Override
			public void mouseExited(MouseEvent e_) {
			}
			@Override
			public void mouseEntered(MouseEvent e_) {
			}
			@Override
			public void mouseClicked(MouseEvent e_) {
				resetIhm();
			}
		});
		
		add.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent e_) {
			}
			@Override
			public void mousePressed(MouseEvent e_) {
			}
			@Override
			public void mouseExited(MouseEvent e_) {
			}
			@Override
			public void mouseEntered(MouseEvent e_) {
			}
			@Override
			public void mouseClicked(MouseEvent e_) {
				enabledIhm(true);
			}
		});
		
		sufix.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent e_) {
			}
			@Override
			public void mousePressed(MouseEvent e_) {
			}
			@Override
			public void mouseExited(MouseEvent e_) {
			}
			@Override
			public void mouseEntered(MouseEvent e_) {
			}
			@Override
			public void mouseClicked(MouseEvent e_) {
				mailSufixMenu.setVisible(true);
			}
		});
	}

	private void initAttributes() {

		nom.setMinimumSize(new Dimension(60, 20));
		nom.setPreferredSize(new Dimension(60, 20));
		nomTF = new ZeTextField();
		nomTF.setPreferredSize(new Dimension(200, 20));
		nomTF.setMinimumSize(new Dimension(200, 20));
		
		prenom.setMinimumSize(new Dimension(60, 20));
		prenom.setPreferredSize(new Dimension(60, 20));
		prenomTF = new ZeTextField();
		prenomTF.setPreferredSize(new Dimension(200, 20));
		prenomTF.setMinimumSize(new Dimension(200, 20));
		
		login.setMinimumSize(new Dimension(60, 20));
		login.setPreferredSize(new Dimension(60, 20));
		loginTF = new ZeTextField();
		loginTF.setPreferredSize(new Dimension(150, 20));
		loginTF.setMinimumSize(new Dimension(150, 20));
		
		loginSearchTF = new ZeTextField();
		loginSearchTF.setPreferredSize(new Dimension(100, 20));
		loginSearchTF.setMinimumSize(new Dimension(100, 20));
		
		email.setMinimumSize(new Dimension(60, 20));
		email.setPreferredSize(new Dimension(60, 20));
		emailTF = new ZeTextField();
		emailTF.setPreferredSize(new Dimension(150, 20));
		emailTF.setMinimumSize(new Dimension(150, 20));
		
		tel.setMinimumSize(new Dimension(60, 20));
		tel.setPreferredSize(new Dimension(60, 20));
		tel.setEnabled(false);
		telTF = new ZeTextField();
		telTF.setPreferredSize(new Dimension(150, 20));
		telTF.setMinimumSize(new Dimension(150, 20));
		telTF.setEnabled(false);
		telTF.setBorder(BorderFactory.createLineBorder(Color.GRAY));
		
		combo.setMinimumSize(new Dimension(150, 20));
		combo.setPreferredSize(new Dimension(150, 20));
		
		delete.setMinimumSize(new Dimension(40, 20));
		delete.setPreferredSize(new Dimension(40, 20));
		delete.setToolTipText("Supprime l'utilisateur de la BD");
		
		submit.setMinimumSize(new Dimension(40, 20));
		submit.setPreferredSize(new Dimension(40, 20));
		submit.setToolTipText("");
		submit.setToolTipText("new");
		
		aro.setMinimumSize(new Dimension(20, 20));
		aro.setPreferredSize(new Dimension(20, 20));
		
		cadena.setMinimumSize(new Dimension(35, 35));
		cadena.setPreferredSize(new Dimension(35, 35));
		cadena.setToolTipText("Deverouille la saisie");
		cadena.setIcon(Resources.getInstance().getAppliImage("lock.png"));
		
		
		
		nomTF.addFocusListener(new FocusListener() {
			@Override
			public void focusLost(FocusEvent e) {
				nomTF.setText(nomTF.getText().toUpperCase());
				loginBuf.append(nomTF.getText().toLowerCase());
				emailBuf.append(nomTF.getText().toLowerCase());
				if (!FormUtils.checkFirstNameFormat(nomTF.getText())) {
					nomTF.setBorder(BorderFactory.createLineBorder(Color.RED));
					isFormValid = false;
				}
			}

			@Override
			public void focusGained(FocusEvent e) {
				loginBuf = new StringBuffer();
				emailBuf = new StringBuffer();
			}
		});
		
		nomTF.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e_) {
			}

			@Override
			public void keyReleased(KeyEvent e_) {
				loginTF.setText("");
				loginTF.setText(nomTF.getText().toLowerCase());
				emailTF.setText(nomTF.getText().toLowerCase());
			}

			@Override
			public void keyPressed(KeyEvent e_) {
			}
		});


		prenomTF.addFocusListener(new FocusListener() {
			@Override
			public void focusLost(FocusEvent e) {
				if (!FormUtils.checkLastNameFormat(prenomTF.getText())) {
					prenomTF.setBorder(BorderFactory.createLineBorder(Color.RED));
					isFormValid = false;
				}
			}

			@Override
			public void focusGained(FocusEvent e) {
			}
		});
		
		prenomTF.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e_) {
			}

			@Override
			public void keyReleased(KeyEvent e_) {
				
				if (prenomTF.getText().length() == 1) {
					String s = loginBuf.toString();
					String first = prenomTF.getText().toUpperCase();
					loginBuf = new StringBuffer();
					loginBuf.append(prenomTF.getText().toLowerCase());
					loginBuf.append(s);
					loginTF.setText("");
					loginTF.setText(loginBuf.toString());
					prenomTF.setText("");
					prenomTF.setText(first);
				}
				emailTF.setText(prenomTF.getText().toLowerCase() + "." + emailBuf.toString());
			}

			@Override
			public void keyPressed(KeyEvent e_) {
			}
		});


		loginTF.addFocusListener(new FocusListener() {
			@Override
			public void focusLost(FocusEvent e) {
				if (!FormUtils.checkLoginFormat(loginTF.getText())) {
					loginTF.setBorder(BorderFactory.createLineBorder(Color.RED));
					isFormValid = false;
				}
			}

			@Override
			public void focusGained(FocusEvent e) {
			}
		});

		loginTF.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e_) {
			}

			@Override
			public void keyReleased(KeyEvent e_) {
				if (nomTF.hasFocus()) {
					loginTF.setText("");
					loginTF.setText(nomTF.getText());
				}else if (prenomTF.hasFocus()) {

				}
			}

			@Override
			public void keyPressed(KeyEvent e_) {
			}
		});


		loginSearchTF.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				searchProcessing(arg0);
			}
			@Override
			public void keyReleased(KeyEvent arg0) {
				searchProcessing(arg0);
			}
			@Override
			public void keyPressed(KeyEvent arg0) {
				searchProcessing(arg0);
			}
		});


		emailTF.addFocusListener(new FocusListener() {
			@Override
			public void focusLost(FocusEvent e) {
				if (!FormUtils.checkEmailFormat(emailTF.getText())) {
					emailTF.setBorder(BorderFactory.createLineBorder(Color.RED));
					isFormValid = false;
				}
			}
			@Override
			public void focusGained(FocusEvent e) {
			}
		});

		emailTF.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e_) {
			}
			@Override
			public void keyReleased(KeyEvent e_) {
				if (nomTF.hasFocus()) {

				}else if (prenomTF.hasFocus()) {

				}
			}
			@Override
			public void keyPressed(KeyEvent e_) {
			}
		});


		telTF.addFocusListener(new FocusListener() {
			@Override
			public void focusLost(FocusEvent e) {
				if (!FormUtils.checkPhoneFormat(telTF.getText())) {
					telTF.setBorder(BorderFactory.createLineBorder(Color.RED));
					isFormValid = false;
				}
			}

			@Override
			public void focusGained(FocusEvent e) {
			}
		});
		
		for (int i = 0; i < tabMailSufix.length; i++) {
			mailSufixMenu.add(new JMenuItem(tabMailSufix[i]));			
		}
		
		cadena.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent e_) {
			}
			@Override
			public void mousePressed(MouseEvent e_) {
			}
			@Override
			public void mouseExited(MouseEvent e_) {
			}
			@Override
			public void mouseEntered(MouseEvent e_) {
			}
			@Override
			public void mouseClicked(MouseEvent e_) {
				
				if (cadena.isEnabled()) {
					
					if (telTF.isEnabled()) {
						telTF.setEnabled(false);
						tel.setEnabled(false);
						telTF.setBorder(BorderFactory.createLineBorder(Color.GRAY));
						cadena.setIcon(Resources.getInstance().getAppliImage("lock.png"));
					}else {
						telTF.setEnabled(true);
						tel.setEnabled(true);
						telTF.setBorder(BorderFactory.createLineBorder(Color.BLACK));
						cadena.setIcon(Resources.getInstance().getAppliImage("lock_open.png"));
					}
				}else {
					telTF.setEnabled(false);
					cadena.setIcon(Resources.getInstance().getAppliImage("lock.png"));
				}
			}
		});

	}
	
	private void searchProcessing(InputEvent event){
		
		if (((event instanceof KeyEvent) && ((KeyEvent) event).getKeyCode() == KeyEvent.VK_ENTER)
				|| event instanceof MouseEvent) {
			if (loginSearchTF.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "zone vide abrutit!", "login search error", JOptionPane.ERROR_MESSAGE);
			}else {
				if (loginSearchTF.getText().equals("all")) {
					try {

						ArrayList<User> list = _userManager.do_getUsers();
						for (Iterator<User> iterator = list.iterator(); iterator.hasNext();) {
							User user = (User) iterator.next();
							System.out.println(user.toString());
						}
					} catch (Exception e) {
						EnumMessageDisplayer.ERROR.logMessage(e.getMessage());
					}
				}else {
					User user;
					try {
						user = _userManager.do_getUser(loginSearchTF.getText());
						if (user != null) {

							enabledIhm(true);
							nomTF.setText(user.get_userLastName());
							prenomTF.setText(user.get_userFirstName());
							loginTF.setText(user.get_userLogin());
							emailTF.setText(user.get_userEmail().substring(0, user.get_userEmail().lastIndexOf("@")));
							telTF.setText(user.get_userTel());
							
							submit.setIcon(Resources.getInstance().getAppliImage("update16.png"));
							submit.setToolTipText("Modifie l'utilisateur en BD");
							revalidate();
							repaint();
						}else {
							JOptionPane.showMessageDialog(null, "Y a persone qui s'appelle comme ca la d'dans !", "login search info", JOptionPane.INFORMATION_MESSAGE);
						}

					} catch (Exception e) {
						EnumMessageDisplayer.ERROR.logMessage(e.getMessage());
					}					
				}
			}
		}else {
			if (loginSearchTF.getText().equals("")) {
				search.setEnabled(false);
			}else {
				search.setEnabled(true);
			}
		}
	}

	private void resetIhm(){

		loginSearchTF.setText("");
		search.setEnabled(false);
		submit.setIcon(Resources.getInstance().getAppliImage("submit16.png"));
		submit.setToolTipText("Enregistre l'utilisateur en BD");

		nomTF.setText(""); 
		prenomTF.setText("");
		loginTF.setText("");
		emailTF.setText("");
		telTF.setText("");
		combo.setSelectedItem("capgemini.com");
		isFormValid = true;
		enabledIhm(false);
	}
	
	private void enabledIhm(boolean enabled_){

		nom.setEnabled(enabled_);
		prenom.setEnabled(enabled_);
		login.setEnabled(enabled_);
		email.setEnabled(enabled_);
		cadena.setEnabled(enabled_);
		
		nomTF.setEnabled(enabled_);
		prenomTF.setEnabled(enabled_);
		loginTF.setEnabled(enabled_);
		emailTF.setEnabled(enabled_);
		
		if (enabled_ == true) {
			nomTF.setBorder(BorderFactory.createLineBorder(Color.BLACK));
			prenomTF.setBorder(BorderFactory.createLineBorder(Color.BLACK));
			loginTF.setBorder(BorderFactory.createLineBorder(Color.BLACK));
			emailTF.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		}else {
			nomTF.setBorder(BorderFactory.createLineBorder(Color.GRAY));
			prenomTF.setBorder(BorderFactory.createLineBorder(Color.GRAY));
			loginTF.setBorder(BorderFactory.createLineBorder(Color.GRAY));
			emailTF.setBorder(BorderFactory.createLineBorder(Color.GRAY));

		}

		
		delete.setEnabled(enabled_);
		submit.setEnabled(enabled_);
		combo.setEnabled(enabled_);
		
	}

	private User buildUser(String email_){

		User user = new UserImpl(null, nomTF.getText(), prenomTF.getText(), loginTF.getText(),
				null, null, email_, telTF.getText(), null, null);
		return user;
	}
	
	private void initNomLine(GridBagConstraints gbc_, int line_){
		
		gbc_.insets = new Insets(3,0,3,5);
		/* label */
		gbc_.gridx = 1; 
		gbc_.gridy = line_;
		userPanel.add(nom, gbc_);

		gbc_ = new GridBagConstraints();
		/* textfield */
		gbc_.gridx = 2; 
		gbc_.gridy = line_;
		gbc_.gridwidth = GridBagConstraints.REMAINDER;
		gbc_.anchor = GridBagConstraints.LINE_START;
		userPanel.add(nomTF, gbc_);
	}
	
	private void initPrenomLine(GridBagConstraints gbc_, int line_){
		
		gbc_.insets = new Insets(3,0,3,5);
		/* label */
		gbc_.gridx = 1;
		gbc_.gridy = line_;
		userPanel.add(prenom, gbc_);

		gbc_ = new GridBagConstraints();
		/* textfield */
		gbc_.gridx = 2;
		gbc_.gridy = line_;
		gbc_.gridwidth = GridBagConstraints.REMAINDER;
		gbc_.anchor = GridBagConstraints.LINE_START;
		userPanel.add(prenomTF, gbc_);
	}
	
	private void initLoginLine(GridBagConstraints gbc_, int line_){
		
		gbc_.insets = new Insets(3,0,3,5);
		/* label */
		gbc_.gridx = 1;
		gbc_.gridy = line_;
		userPanel.add(login, gbc_);

		gbc_ = new GridBagConstraints();
		/* textfield */
		gbc_.gridx = 2;
		gbc_.gridy = line_;
		userPanel.add(loginTF, gbc_);
	}
	
	private void initEmailLine(GridBagConstraints gbc_, int line_){
		
		gbc_.insets = new Insets(3,0,3,5);
		/* label */
		gbc_.gridx = 1;
		gbc_.gridy = line_;
		userPanel.add(email, gbc_);

		gbc_ = new GridBagConstraints();
		/* textfield */
		gbc_.gridx = 2;
		gbc_.gridy = line_;
		userPanel.add(emailTF, gbc_);
		
		gbc_ = new GridBagConstraints();
		/* @ */
		gbc_.gridx = 3;
		gbc_.gridy = line_;
		userPanel.add(aro, gbc_);
		
		gbc_ = new GridBagConstraints();
		/* menu */
		gbc_.gridx = 4;
		gbc_.gridy = line_;
		gbc_.gridwidth = GridBagConstraints.REMAINDER;
		userPanel.add(combo, gbc_);
	}
	
	private void initLastLine(GridBagConstraints gbc_, int line_){
		
		gbc_.insets = new Insets(3,0,3,5);
		/* cadena */
		gbc_.gridx = 0;
		gbc_.gridy = line_;
		userPanel.add(cadena, gbc_);
		
		gbc_ = new GridBagConstraints();
		/* label */
		gbc_.gridx = 1;
		gbc_.gridy = line_;
		userPanel.add(tel, gbc_);
		
		gbc_ = new GridBagConstraints();
		/* textfield */
		gbc_.gridx = 2;
		gbc_.gridy = line_;
		userPanel.add(telTF, gbc_);
		
		gbc_ = new GridBagConstraints();
		/* submit */
		gbc_.gridx = 6;
		gbc_.gridy = line_;
		gbc_.anchor = GridBagConstraints.LINE_END;
		userPanel.add(submit, gbc_);
		
		gbc_ = new GridBagConstraints();
		/* delete */
		gbc_.gridx = 7;
		gbc_.gridy = line_;
		gbc_.anchor = GridBagConstraints.LINE_START;
		userPanel.add(delete, gbc_);
	}

	@Override
	public void focusGained(FocusEvent e_) {
	}

	@Override
	public void focusLost(FocusEvent e_) {
	}

	@Override
	public void keyTyped(KeyEvent e_) {
	}

	@Override
	public void keyPressed(KeyEvent e_) {
	}

	@Override
	public void keyReleased(KeyEvent e_) {
	}
}
