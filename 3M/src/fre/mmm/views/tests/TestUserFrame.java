package fre.mmm.views.tests;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import fre.mmm.application.manager.ApplicationManager;
import fre.mmm.application.manager.UsersManager;
import fre.mmm.model.User;
import fre.mmm.model.impl.UserImpl;
import fre.mmm.resources.Resources;
import fre.mmm.resources.enums.EnumMessageDisplayer;
import fre.mmm.views.utils.FormUtils;

public class TestUserFrame extends JFrame {

	private JLabel nom;
	private JLabel prenom;
	private JLabel login;
	private JLabel email;
	private JLabel tel;
	private JLabel compagny;

	private JTextField nomTF;
	private JTextField prenomTF;
	private JTextField loginTF;
	private JTextField loginSearchTF;
	private JTextField emailTF;
	private JTextField telTF;
	private JTextField compagnyTF;

	private JPanel searchPanel;
	private JPanel userPanel;
	private JPanel buttonPanel;

	private JButton submit;
	private JButton delete;
	private JButton cancel;
	private JButton get;
	private JButton reset;

	private boolean isFormValid = true;
	private StringBuffer loginBuf;
	private StringBuffer emailBuf;

	private UsersManager _userManager;

	public TestUserFrame(){

		_userManager = ApplicationManager.getInstance().getUserManager();
		initTestUsersFrame();

	}

	private void initTestUsersFrame() {

		setTitle("USER ADMIN FRAME");
		setLayout(new BorderLayout());

		initAttributes();
		initButtons();
		initPanels();

		add(searchPanel, BorderLayout.NORTH);
		add(userPanel, BorderLayout.CENTER);
		add(buttonPanel, BorderLayout.SOUTH);

		setSize(400, 250);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);

	}

	private void initPanels() {

		searchPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		searchPanel.add(reset);
		searchPanel.add(loginSearchTF);
		searchPanel.add(get);

		userPanel = new JPanel(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();

		gbc.gridx = 0; 
		gbc.gridy = 0;
		gbc.insets = new Insets(3,0,3,5); 
		userPanel.add(nom, gbc);

		gbc.gridx = 1; 
		gbc.gridy = 0;
		//		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.weightx = 1;
		gbc.anchor = GridBagConstraints.LINE_END;
		gbc.insets = new Insets(3,0,3,5);
		userPanel.add(nomTF, gbc);

		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.insets = new Insets(3,0,3,5);
		userPanel.add(prenom, gbc);

		gbc.gridx = 1;
		gbc.gridy = 1;
		//		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.weightx = 1;
		gbc.anchor = GridBagConstraints.LINE_END;
		gbc.insets = new Insets(3,0,3,5);
		userPanel.add(prenomTF, gbc);

		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.insets = new Insets(3,0,3,5);
		userPanel.add(login, gbc);

		gbc.gridx = 1;
		gbc.gridy = 2;
		//		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.weightx = 1;
		gbc.anchor = GridBagConstraints.LINE_END;
		gbc.insets = new Insets(3,0,3,5);
		userPanel.add(loginTF, gbc);

		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.insets = new Insets(3,0,3,5);
		userPanel.add(email, gbc);

		gbc.gridx = 1;
		gbc.gridy = 3;
		//		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.weightx = 1;
		gbc.anchor = GridBagConstraints.LINE_END;
		gbc.insets = new Insets(3,0,3,5);
		userPanel.add(emailTF, gbc);

		gbc.gridx = 0;
		gbc.gridy = 4;
		gbc.insets = new Insets(3,0,3,5);
		userPanel.add(tel, gbc);

		gbc.gridx = 1;
		gbc.gridy = 4;
		//		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.weightx = 1;
		gbc.anchor = GridBagConstraints.LINE_END;
		gbc.insets = new Insets(3,0,3,5);
		userPanel.add(telTF, gbc);


		buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		buttonPanel.add(submit);
		buttonPanel.add(delete);
		buttonPanel.add(cancel);
	}

	private void initButtons() {

		submit = new JButton("Enregistrer");
		submit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e_) {

				try {

					if (isFormValid) {
						if (submit.getText().equals("Enregistrer")) {
							_userManager.do_createUser(nomTF.getText(), prenomTF.getText(), loginTF.getText(),
									null, null, emailTF.getText(), telTF.getText(), null, null);
							resetIhm();
						}else if (submit.getText().equals("Modifier")) {
							_userManager.do_updateUser(buildUser());
							resetIhm();
						}
					}else {
						JOptionPane.showMessageDialog(null, "Le formulaire est incomplet ou eron�", "ERREUR FORMULAIRE", JOptionPane.ERROR_MESSAGE);
					}
				} catch (NumberFormatException e) {
					EnumMessageDisplayer.ERROR.logMessage(e.getMessage());
				} catch (Exception e) {
					e.printStackTrace();
					EnumMessageDisplayer.ERROR.logMessage(e.getMessage());
				}
			}
		});

		delete = new JButton("Supprimer");
		delete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Supprime l' utilisteur");
				try {
					_userManager.do_removeUser(loginTF.getText());
					resetIhm();
				} catch (NullPointerException e) {
					EnumMessageDisplayer.ERROR.logMessage(e.getMessage());
				} catch (Exception e) {
					EnumMessageDisplayer.ERROR.logMessage(e.getMessage());
				}
			}
		});

		cancel = new JButton("Annuler");
		cancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});

		get = new JButton("Chercher");
		get.setEnabled(false);
		get.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Cherche un utilisteur");

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
						System.out.println(user.toString());
						nomTF.setText(user.get_userLastName());
						prenomTF.setText(user.get_userFirstName());
						loginTF.setText(user.get_userLogin());
						emailTF.setText(user.get_userEmail());
						telTF.setText(user.get_userTel());

						revalidate();
						repaint();

					} catch (Exception e) {
						EnumMessageDisplayer.ERROR.logMessage(e.getMessage());
					}					
				}


				submit.setText("Modifier");
			}
		});

		reset = new JButton("Reset IHM");
		reset.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				resetIhm();
			}
		});
	}

	private void initAttributes() {

		nom = new JLabel("Nom : ");
		nomTF = new JTextField(50);
		nomTF.setMinimumSize(new Dimension(200, 25));
		nomTF.setPreferredSize(new Dimension(200, 25));
		nomTF.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		nomTF.setForeground(Color.BLUE);
		
		nomTF.addFocusListener(new FocusListener() {
			@Override
			public void focusLost(FocusEvent e) {
				nomTF.setText(nomTF.getText().toUpperCase());
				loginBuf.append(nomTF.getText().toLowerCase());
				emailBuf.append(nomTF.getText().toLowerCase() + "@");
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

		prenom = new JLabel("Prénom : ");
		prenomTF = new JTextField(50);
		prenomTF.setMinimumSize(new Dimension(200, 25));
		prenomTF.setPreferredSize(new Dimension(200, 25));
		prenomTF.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		prenomTF.setForeground(Color.BLUE);
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

		login = new JLabel("Login : ");
		loginTF = new JTextField(50);
		loginTF.setMinimumSize(new Dimension(200, 25));
		loginTF.setPreferredSize(new Dimension(200, 25));
		loginTF.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		loginTF.setForeground(Color.BLUE);
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

		loginSearchTF = new JTextField(10);
		loginSearchTF.setMinimumSize(new Dimension(100, 25));
		loginSearchTF.setPreferredSize(new Dimension(100, 25));
		loginSearchTF.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		loginSearchTF.setForeground(Color.BLUE);
		loginSearchTF.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				if (loginSearchTF.getText().equals("")) {
					get.setEnabled(false);
				}else {
					get.setEnabled(true);
				}
			}
			@Override
			public void keyReleased(KeyEvent arg0) {
				if (loginSearchTF.getText().equals("")) {
					get.setEnabled(false);
				}else {
					get.setEnabled(true);
				}
			}
			@Override
			public void keyPressed(KeyEvent arg0) {
				if (loginSearchTF.getText().equals("")) {
					get.setEnabled(false);
				}else {
					get.setEnabled(true);
				}
			}
		});

		email = new JLabel("Email : ");
		emailTF = new JTextField(50);
		emailTF.setMinimumSize(new Dimension(200, 25));
		emailTF.setPreferredSize(new Dimension(200, 25));
		emailTF.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		emailTF.setForeground(Color.BLUE);
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

		tel = new JLabel("Téléphone : ");
		telTF = new JTextField(50);
		telTF.setMinimumSize(new Dimension(200, 25));
		telTF.setPreferredSize(new Dimension(200, 25));
		telTF.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		telTF.setForeground(Color.BLUE);
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

	}

	private void resetIhm(){

		loginSearchTF.setText("");
		get.setEnabled(false);
		submit.setText("Enregistrer");

		nomTF.setText(""); 
		prenomTF.setText("");
		loginTF.setText("");
		emailTF.setText("");
		telTF.setText("");
		isFormValid = true;
	}

	private User buildUser(){

		User user = new UserImpl(null, nomTF.getText(), prenomTF.getText(), loginTF.getText(),
				null, null, emailTF.getText(), telTF.getText(), null, null);
		return user;
	}


}
