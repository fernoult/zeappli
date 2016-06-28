package fre.mmm.views.attributaires;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import fre.mmm.application.manager.ApplicationManager;
import fre.mmm.application.manager.ProjectsManager;
import fre.mmm.model.User;
import fre.mmm.resources.Resources;
import fre.mmm.resources.enums.EnumMessageDisplayer;

public class NewProjAttributeFrame extends ObjFrame implements MouseListener{

	private JPanel _zePanel;
	private JPanel _southPanel;
	
	private JLabel _lblProjectName;
	private JLabel _lblProjcetNum;
	private JLabel _lblProjectChief;
	private JLabel _submit;
	private JLabel _cancel;
	
	
	private JTextField _tfProjectName;
	private JTextField _tfProjectNum;
	private JComboBox<String> _cbProjectChief;
	
	private ArrayList<User> _usersList = new ArrayList<User>();
	
	private ProjectsManager _projetManager;
	
	public NewProjAttributeFrame(){
		this("NEW_PROJ_ATT_FRAME");
	}
	
	/**
	 * @param title_
	 */
	public NewProjAttributeFrame(String title_) {
		super(title_);
		try {
			_projetManager = ApplicationManager.getInstance().getProjectManager();
			_usersList = ApplicationManager.getInstance().getDataBaseManager().getUsers();
		} catch (Exception e) {
			EnumMessageDisplayer.ERROR.logMessage(e.getMessage());
		}
		initNewProjattributeFrame();
	}



	private void initNewProjattributeFrame(){
		
		initComposants();
		initPanels();
		
		add(_centerPane, BorderLayout.CENTER);
		add(_southPane, BorderLayout.SOUTH);
		
		setSize(400, 200);
		setLocationRelativeTo(null);

	}
	
	@Override
	protected void initPanels() {
		super.initPanels();
		
		_centerPane = new JPanel(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.insets = new Insets(3, 0, 3, 0);
		_centerPane.add(_lblProjectName, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.insets = new Insets(3, 0, 3, 0);
		_centerPane.add(_tfProjectName, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.insets = new Insets(3, 0, 3, 0);
		_centerPane.add(_lblProjcetNum, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.insets = new Insets(3, 0, 3, 0);
		_centerPane.add(_tfProjectNum, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.insets = new Insets(3, 0, 3, 0);
		_centerPane.add(_lblProjectChief, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 2;
		gbc.insets = new Insets(3, 0, 3, 0);
		_centerPane.add(_cbProjectChief, gbc);
		
		_southPane = new JPanel(new FlowLayout(FlowLayout.CENTER));
		_southPane.add(_cancel);
		_southPane.add(_submit);
	}
	
	@Override
	protected void initComposants() {
		super.initComposants();
		
		_lblProjectName = new JLabel("zeNom");
		_lblProjcetNum = new JLabel("zeNum");
		_lblProjectChief = new JLabel("zePatron");
		
		_tfProjectName = new JTextField();
		_tfProjectName.setPreferredSize(new Dimension(150, 20));
		_tfProjectName.setMinimumSize(new Dimension(150, 20));
		
		_tfProjectNum = new JTextField();
		_tfProjectNum.setPreferredSize(new Dimension(150, 20));
		_tfProjectNum.setMinimumSize(new Dimension(150, 20));
		
		String[] tab = new String[_usersList.size()];
		for (int i = 0; i < _usersList.size(); i++) {
			tab[i] = _usersList.get(i).get_userFirstName() + " " + _usersList.get(i).get_userLastName();
		}
		_cbProjectChief = new JComboBox<String>(tab);
		
		_submit = new JLabel(Resources.getInstance().getAppliImage("submit16.png"));
		_submit.addMouseListener(new MouseListener() {
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
				
				Integer idUser = null;
				if (_cbProjectChief.getSelectedItem() != null) {
					
					for (Iterator<User> iterator = _usersList.iterator(); iterator.hasNext();) {
						User user = (User) iterator.next();
						String fullname = user.get_userFirstName() + " " + user.get_userLastName();
						if (fullname.equals(_cbProjectChief.getSelectedItem())) {
							idUser = user.get_userID();
							try {
								_projetManager.do_createProject(idUser, 
										_tfProjectName.getText(), 
										_tfProjectNum.getText(), 
										false);
								
								dispose();
							} catch (Exception e) {
								EnumMessageDisplayer.ERROR.logMessage(e.getMessage());
								break;
							}
							break;
						}
					}
				}
			}
		});
		
		_cancel = new JLabel(Resources.getInstance().getAppliImage("exit16.png"));
		_cancel.addMouseListener(new MouseListener() {
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
	}

	/**
	 * Retourne 
	 * @return the lblProjectName
	 */
	public JLabel getLblProjectName() {
		return _lblProjectName;
	}

	/**
	 * Initialise 
	 * @param lblProjectName_ the lblProjectName to set
	 */
	public void setLblProjectName(JLabel lblProjectName_) {
		_lblProjectName = lblProjectName_;
	}

	/**
	 * Retourne 
	 * @return the lblProjcetNum
	 */
	public JLabel getLblProjcetNum() {
		return _lblProjcetNum;
	}

	/**
	 * Initialise 
	 * @param lblProjcetNum_ the lblProjcetNum to set
	 */
	public void setLblProjcetNum(JLabel lblProjcetNum_) {
		_lblProjcetNum = lblProjcetNum_;
	}

	/**
	 * Retourne 
	 * @return the lblProjectChief
	 */
	public JLabel getLblProjectChief() {
		return _lblProjectChief;
	}

	/**
	 * Initialise 
	 * @param lblProjectChief_ the lblProjectChief to set
	 */
	public void setLblProjectChief(JLabel lblProjectChief_) {
		_lblProjectChief = lblProjectChief_;
	}

	/**
	 * Retourne 
	 * @return the submit
	 */
	public JLabel getSubmit() {
		return _submit;
	}

	/**
	 * Initialise 
	 * @param submit_ the submit to set
	 */
	public void setSubmit(JLabel submit_) {
		_submit = submit_;
	}

	/**
	 * Retourne 
	 * @return the cancel
	 */
	public JLabel getCancel() {
		return _cancel;
	}

	/**
	 * Initialise 
	 * @param cancel_ the cancel to set
	 */
	public void setCancel(JLabel cancel_) {
		_cancel = cancel_;
	}

	/**
	 * Retourne 
	 * @return the tfProjectName
	 */
	public JTextField getTfProjectName() {
		return _tfProjectName;
	}

	/**
	 * Initialise 
	 * @param tfProjectName_ the tfProjectName to set
	 */
	public void setTfProjectName(JTextField tfProjectName_) {
		_tfProjectName = tfProjectName_;
	}

	/**
	 * Retourne 
	 * @return the tfProjectNum
	 */
	public JTextField getTfProjectNum() {
		return _tfProjectNum;
	}

	/**
	 * Initialise 
	 * @param tfProjectNum_ the tfProjectNum to set
	 */
	public void setTfProjectNum(JTextField tfProjectNum_) {
		_tfProjectNum = tfProjectNum_;
	}

	/**
	 * Retourne 
	 * @return the cbProjectChief
	 */
	public JComboBox<String> getCbProjectChief() {
		return _cbProjectChief;
	}

	/**
	 * Initialise 
	 * @param cbProjectChief_ the cbProjectChief to set
	 */
	public void setCbProjectChief(JComboBox<String> cbProjectChief_) {
		_cbProjectChief = cbProjectChief_;
	}

	/**
	 * Retourne 
	 * @return the usersList
	 */
	public ArrayList<User> getUsersList() {
		return _usersList;
	}

	/**
	 * Initialise 
	 * @param usersList_ the usersList to set
	 */
	public void setUsersList(ArrayList<User> usersList_) {
		_usersList = usersList_;
	}

	@Override
	public void mouseClicked(MouseEvent e_) {
		if (e_.getSource().equals(_submit)) {
			
			// Si tout roule, (Si la creation BD s'est bien passée),
			// On cree le nouvel onglet.
			
		}else if (e_.getSource().equals(_cancel)) {
			
		}
	}

	@Override
	public void mousePressed(MouseEvent e_) {
	}

	@Override
	public void mouseReleased(MouseEvent e_) {
	}

	@Override
	public void mouseEntered(MouseEvent e_) {
	}

	@Override
	public void mouseExited(MouseEvent e_) {
	}
	
	
	
	
	
}
