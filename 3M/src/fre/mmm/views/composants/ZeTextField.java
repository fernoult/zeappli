package fre.mmm.views.composants;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JTextField;
import javax.swing.text.Document;

public class ZeTextField extends JTextField {

	/**
	 * Constructeur
	 */
	public ZeTextField() {
		super();
		initZeTextField();
	}

	/**
	 * @param doc_
	 * @param text_
	 * @param columns_
	 */
	public ZeTextField(Document doc_, String text_, int columns_) {
		super(doc_, text_, columns_);
		initZeTextField();
	}

	/**
	 * @param columns_
	 */
	public ZeTextField(int columns_) {
		super(columns_);
		initZeTextField();
	}

	/**
	 * @param text_
	 * @param columns_
	 */
	public ZeTextField(String text_, int columns_) {
		super(text_, columns_);
		initZeTextField();
	}

	/**
	 * @param text_
	 */
	public ZeTextField(String text_) {
		super(text_);
		initZeTextField();
	}
	
	private void initZeTextField(){
		
		setPreferredSize(new Dimension(getPreferredSize().width, 10));
		setForeground(Color.BLUE);
		setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
	}

	
}
