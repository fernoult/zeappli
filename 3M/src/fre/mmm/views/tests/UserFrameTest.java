//package fre.mmm.views.tests;
//
//import java.awt.FlowLayout;
//import java.awt.GridLayout;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//
//import javax.swing.JButton;
//import javax.swing.JFrame;
//import javax.swing.JLabel;
//import javax.swing.JPanel;
//import javax.swing.JTextField;
//
//import fre.mmm.application.manager.ApplicationManager;
//import fre.mmm.application.manager.UsersManager;
//import fre.mmm.application.manager.impl.local.UserManagerImpl;
//import fre.mmm.resources.EnumMessageDisplayer;
//
//public class UserFrameTest extends JFrame{
//
//	private JLabel _userID;
//	private JLabel _userFirstName;
//	private JLabel _userLastName;
//	private JLabel _userEmail;
//	private JLabel _userPhone;
//	private JLabel _userEntreprise;
//	
//	private JTextField _userIDTF;
//	private JTextField _userFirstNameTF;
//	private JTextField _userLastNameTF;
//	private JTextField _userEmailTF;
//	private JTextField _userPhoneTF;
//	private JTextField _userEntepriseTF;
//	
//	private JPanel _userInfosPanel;
//	private JPanel _userIDPane;
//	private JPanel _userFirstNamePane;
//	private JPanel _userLastNamePane;
//	private JPanel _userEmailPane;
//	private JPanel _userPhonePane;
//	private JPanel _userEntreprisePane;
//	private JPanel _buttonPane;
//	
//	private JButton _submitButton;
//	private JButton _cancelButton;
//	
//	private UsersManager _userManager;
//	
//	public UserFrameTest(){
//		
//		_userManager = ApplicationManager.getInstance(false).getUserManager();
//		initUserTestFrame();
//		
//		add(_userInfosPanel);
//		
//		setSize(500, 500);
//		setLocationRelativeTo(null);
//		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//		setVisible(true);
//		
//	}
//	
//	private void initUserTestFrame(){
//		
//		_userID = new JLabel("ID : ");
//		_userIDTF = new JTextField(15);
//		_userFirstName = new JLabel("Nom : ");
//		_userFirstNameTF = new JTextField(15);
//		_userLastName = new JLabel("Prénom : ");
//		_userLastNameTF = new JTextField(15);
//		_userEmail = new JLabel("Email : ");
//		_userEmailTF = new JTextField(15);
//		_userPhone = new JLabel("Téléphone : ");
//		_userPhoneTF = new JTextField(15);
//		_userEntreprise = new JLabel("Entreprise : ");
//		_userEntepriseTF = new JTextField(15);
//		
//		_submitButton = new JButton("SOUMETTRE");
//		_submitButton.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e_) {
//				
//				try {
//					System.out.println("test");
//					_userManager.do_createUser(Integer.parseInt(_userIDTF.getText()), 
//							_userFirstNameTF.getText(), _userLastNameTF.getText(), 
//							null, null, null, _userEmailTF.getText(), _userPhoneTF.getText(), null, null);
//				} catch (NumberFormatException e) {
//					EnumMessageDisplayer.ERROR.logMessage(e.getMessage());
//				} catch (Exception e) {
//					e.printStackTrace();
//					EnumMessageDisplayer.ERROR.logMessage(e.getMessage());
//				}
//			}
//		});
//		JButton getUser = new JButton("GET USER");
//		getUser.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e_) {
//				try {
//					_userManager.do_getUser(Integer.parseInt(_userIDTF.getText()));
//				} catch (NumberFormatException e) {
//					EnumMessageDisplayer.ERROR.logMessage(e.getMessage());
//				} catch (Exception e) {
//					EnumMessageDisplayer.ERROR.logMessage(e.getMessage());
//				}
//			}
//		});
//		_cancelButton = new JButton("ANNULER");
//		_cancelButton.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e_) {
//				System.out.println("CANCEL");
//			}
//		});
//		
//		_userInfosPanel = new JPanel(new GridLayout(7, 1));
//		
//		_userIDPane = new JPanel(new FlowLayout(FlowLayout.LEFT));
//		_userIDPane.add(_userID);
//		_userIDPane.add(_userIDTF);
//		
//		_userFirstNamePane = new JPanel(new FlowLayout(FlowLayout.LEFT));
//		_userFirstNamePane.add(_userFirstName);
//		_userFirstNamePane.add(_userFirstNameTF);
//		
//		_userLastNamePane = new JPanel(new FlowLayout(FlowLayout.LEFT));
//		_userLastNamePane.add(_userLastName);
//		_userLastNamePane.add(_userLastNameTF);
//		
//		_userEmailPane = new JPanel(new FlowLayout(FlowLayout.LEFT));
//		_userEmailPane.add(_userEmail);
//		_userEmailPane.add(_userEmailTF);
//		
//		_userPhonePane = new JPanel(new FlowLayout(FlowLayout.LEFT));
//		_userPhonePane.add(_userPhone);
//		_userPhonePane.add(_userPhoneTF);
//		
//		_userEntreprisePane = new JPanel(new FlowLayout(FlowLayout.LEFT));
//		_userEntreprisePane.add(_userEntreprise);
//		_userEntreprisePane.add(_userEntepriseTF);
//		
//		_buttonPane = new JPanel(new FlowLayout(FlowLayout.CENTER));
//		_buttonPane.add(_submitButton);
//		_buttonPane.add(_cancelButton);
//		_buttonPane.add(getUser);
//		
//		_userInfosPanel.add(_userIDPane);
//		_userInfosPanel.add(_userFirstNamePane);
//		_userInfosPanel.add(_userLastNamePane);
//		_userInfosPanel.add(_userEmailPane);
//		_userInfosPanel.add(_userPhonePane);
//		_userInfosPanel.add(_userEntreprisePane);
//		_userInfosPanel.add(_buttonPane);
//		
//		
//	}
//}
