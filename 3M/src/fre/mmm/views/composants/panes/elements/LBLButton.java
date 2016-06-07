package fre.mmm.views.composants.panes.elements;

import java.awt.Dimension;

import javax.swing.Icon;
import javax.swing.JLabel;

public class LBLButton extends JLabel {
	
	private final int BTN_WIDTH_ICO = 25;
	private final int BTN_HEIGHT = 25;
	private final int BTN_WIDTH_TXT = 40;

	/**
	 * 
	 */
	public LBLButton() {
		super();
	}

	/**
	 * @param image_
	 * @param horizontalAlignment_
	 */
	public LBLButton(Icon image_, int horizontalAlignment_) {
		super(image_, horizontalAlignment_);
	}

	/**
	 * @param image_
	 */
	public LBLButton(Icon image_) {
		super(image_);
		setMinimumSize(new Dimension(BTN_WIDTH_ICO, BTN_HEIGHT));
	}

	/**
	 * @param text_
	 * @param icon_
	 * @param horizontalAlignment_
	 */
	public LBLButton(String text_, Icon icon_, int horizontalAlignment_) {
		super(text_, icon_, horizontalAlignment_);
	}

	/**
	 * @param text_
	 * @param horizontalAlignment_
	 */
	public LBLButton(String text_, int horizontalAlignment_) {
		super(text_, horizontalAlignment_);
	}

	/**
	 * @param text_
	 */
	public LBLButton(String text_) {
		super(text_);
	}
	
	public LBLButton(Icon image_, String tooltype_){
		this(image_);
		setToolTipText(tooltype_);
	}

	
}
