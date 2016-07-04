package fre.mmm.views.utils;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SuccessPopup extends JFrame {

	private String message = "Operation effectuee avec success";

	/**
	 * @throws HeadlessException
	 */
	public SuccessPopup() throws HeadlessException {
		super();
		initSuccessPopup();
	}

	/**
	 * @param gc_
	 */
	public SuccessPopup(GraphicsConfiguration gc_) {
		super(gc_);
		initSuccessPopup();
	}

	/**
	 * @param title_
	 * @param gc_
	 */
	public SuccessPopup(String title_, GraphicsConfiguration gc_) {
		super(title_, gc_);
		initSuccessPopup();
	}

	/**
	 * @param title_
	 * @throws HeadlessException
	 */
	public SuccessPopup(String title_) throws HeadlessException {
		super(title_);
		initSuccessPopup();
	}
	
	private void initSuccessPopup(){
		
		setLayout(new BorderLayout());
		
		JLabel text = new JLabel(message);
//		text.setForeground(Color.DARK_GRAY);
		
		JPanel pane = new JPanel(new FlowLayout(FlowLayout.CENTER));
		pane.add(text);
		pane.setBackground(Color.GREEN);
		
		add(pane);
		
		setSize(200, 150);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setUndecorated(true);
		setVisible(true);
	}
}
