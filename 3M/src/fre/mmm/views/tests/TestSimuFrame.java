package fre.mmm.views.tests;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import fre.mmm.databases.manager.DBEmbededManager;
import fre.mmm.resources.enums.EnumMessageDisplayer;

public class TestSimuFrame extends JFrame {

	public TestSimuFrame(){
		initTestSimuFrame();

        // On ajoute un controle sur les fenetres "metier"
		// lors de la fermeture de celles-ci.
        addWindowListener(new WindowAdapter() {
        	
			@Override
        	public void windowClosing(WindowEvent e) {
        		
				try {
					DBEmbededManager.getInstance().closeEmbededDatabase();
					EnumMessageDisplayer.INFO.logMessage("Fermeture de la base de donnees");
				} catch (SQLException e1) {
					EnumMessageDisplayer.ERROR.logMessage(e1.getMessage());
				}
				
				EnumMessageDisplayer.INFO.logMessage("Fermeture du programme.");
        		
        	}
		});
		
	}

	private void initTestSimuFrame() {
		
		setLayout(new BorderLayout());
		
		JPanel northPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));

		JButton testDB = new JButton("TEST DB ET LOGS");
		testDB.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e_) {
				
				try {
					DBEmbededManager.getInstance().createShema();
					Thread.sleep(2000);
					DBEmbededManager.getInstance().initDatasDB();
					Thread.sleep(2000);
					DBEmbededManager.getInstance().dropShema();
					
				} catch (InterruptedException e) {
					EnumMessageDisplayer.ERROR.logMessage(e.getMessage());
				}
				
			}
		});
		
		JButton newUser = new JButton("USERS");
		newUser.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e_) {
				new TestUserFrame2();
			}
		});
		
		JButton reset = new JButton("RESET DB");
		reset.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e_) {
				try {
					DBEmbededManager.getInstance().dropShema();
					Thread.sleep(2000);					
					DBEmbededManager.getInstance().initEmbededDB();
					Thread.sleep(2000);
					
				} catch (InterruptedException e) {
					EnumMessageDisplayer.ERROR.logMessage(e.getMessage());
				}
			}
		});
		
		JButton testSelect = new JButton("INIT DB");
		testSelect.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e_) {
				try {
					DBEmbededManager.getInstance().initEmbededDB();
					Thread.sleep(2000);
					
				} catch (InterruptedException e) {
					EnumMessageDisplayer.ERROR.logMessage(e.getMessage());
				}
			}
		});
		
		
		northPanel.add(testDB);
		northPanel.add(testSelect);
		northPanel.add(reset);
		northPanel.add(newUser);
		
		add(northPanel, BorderLayout.NORTH);
		
		setSize(500, 500);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

}
