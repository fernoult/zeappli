/* ihmref-RButton.java
 * HISTORIQUE
 *
 * [MODIF]: Version - le 24 avr. 2015 - Creation de la classe.
 *
 * FIN HISTORIQUE
 */
package fre.mmm.views.composants.panes.elements;

import java.awt.Dimension;

import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.JButton;

public class RButton extends JButton {

	private final int BTN_WIDTH_ICO = 25;
	private final int BTN_HEIGHT = 25;
	private final int BTN_WIDTH_TXT = 40;

	/** RButton
	 * Constructeur
	 */
	public RButton() {
		super();
	}
	
	/** RButton
	 * Constructeur
	 */
	public RButton(Action a_) {
		super(a_);
	}

	/** RButton
	 * Constructeur
	 */
	public RButton(Icon icon_) {
		super(icon_);
		setMinimumSize(new Dimension(BTN_WIDTH_ICO, BTN_HEIGHT));
	}

	/** RButton
	 * Constructeur
	 */
	public RButton(String text_, Icon icon_) {
		super(text_, icon_);
	}

	/** RButton
	 * Constructeur
	 */
	public RButton(String text_) {
		super(text_);
		setMinimumSize(new Dimension(BTN_WIDTH_TXT, BTN_HEIGHT));
	}
	
	@Override
	public String toString() {
		
		return getName() + " * " + getToolTipText() + " * " + getIcon();
	}
	
	
	
	
}
