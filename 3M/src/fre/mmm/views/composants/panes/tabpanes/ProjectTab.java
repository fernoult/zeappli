package fre.mmm.views.composants.panes.tabpanes;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import fre.mmm.model.Project;
import fre.mmm.resources.Resources;
import fre.mmm.views.tests.TestUserFrame2;

public class ProjectTab extends JPanel implements MouseListener {

	private JPanel _toolPanel;
	private JPanel _toolRightPanel;
	private JPanel _toolLeftPanel;
	
	private JLabel _descriptifProjet;
	
	private Project _projet;
	
	private JButton _users;
	
	
	/**
	 * 
	 */
	public ProjectTab() {
		super();
	}

	/**
	 * @param isDoubleBuffered_
	 */
	public ProjectTab(boolean isDoubleBuffered_) {
		super(isDoubleBuffered_);
	}

	/**
	 * @param layout_
	 * @param isDoubleBuffered_
	 */
	public ProjectTab(LayoutManager layout_, boolean isDoubleBuffered_) {
		super(layout_, isDoubleBuffered_);
	}

	/**
	 * @param layout_
	 */
	public ProjectTab(LayoutManager layout_) {
		super(layout_);
	}

	public ProjectTab(Project projet_){
		super();
		_projet = projet_;
		initPanel();
	}
	
	private void initPanel(){
		
		setLayout(new BorderLayout());
		
		// Init des composants.
		// et des sous panneaux.
		initComposants();
		initSubPanels();
		
		add(_toolPanel, BorderLayout.NORTH);
		
		
	}
	
	private void initSubPanels(){
		
		_toolLeftPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		_toolLeftPanel.add(_descriptifProjet);
		
		_toolRightPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		_toolRightPanel.add(_users);
		
		_toolPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		_toolPanel.add(_toolLeftPanel);
		_toolPanel.add(_toolRightPanel);
		
	}
	
	private void initComposants(){
		
		_descriptifProjet = new JLabel("Desc : " + _projet.get_projectNum() + " # " + _projet.get_projectName());
		
		_users = new JButton(Resources.getInstance().getAppliImage("users.png"));
		_users.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e_) {
				new TestUserFrame2();
			}
		});
		
	}
	
	/**
	 * Retourne 
	 * @return the toolPanel
	 */
	public JPanel getToolPanel() {
		return _toolPanel;
	}

	/**
	 * Initialise 
	 * @param toolPanel_ the toolPanel to set
	 */
	public void setToolPanel(JPanel toolPanel_) {
		_toolPanel = toolPanel_;
	}

	@Override
	public void mouseClicked(MouseEvent e_) {
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
