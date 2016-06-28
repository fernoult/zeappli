/* ihmref-ElementFactory.java
 * HISTORIQUE
 *
 * [MODIF]: Version - le 18 avr. 2015 - Creation de la classe.
 *
 * FIN HISTORIQUE
 */
package fre.mmm.views.composants.panes.elements;

import javax.swing.ImageIcon;

import fre.mmm.resources.Resources;
import fre.mmm.resources.enums.EnumMessageDisplayer;
import fre.mmm.views.AppFrame;
import fre.mmm.views.ViewsRessources;
import fre.mmm.views.composants.ElementEnum;
import fre.mmm.views.composants.panes.parents.ComposantPane;

public class ElementFactory {

	private static ElementFactory FACTORY_INSTANCE;
	
	private ElementFactory(){
		
	}
	
	public static ElementFactory getInstance(){
		
		// Le singleton qui va bien.
		if (FACTORY_INSTANCE == null) {
			FACTORY_INSTANCE = new ElementFactory();
		}
		
		return FACTORY_INSTANCE;
	}
	
	public RButton getButton(ElementEnum type_, String[] values_){
		
		RButton button = new RButton();
		try {
			ImageIcon icone = Resources.getInstance().getAppliImage(values_[3]);
			
			button.setName(values_[0]);
			button.setToolTipText(values_[2]);
			
			if (type_.equals(ElementEnum.ICON_BUTTON)) {
				button.setIcon(icone);
			}else if (type_.equals(ElementEnum.TEXT_BUTTON)) {
				button.setText(values_[1]);
			}else if (type_.equals(ElementEnum.MIXTE_BUTTON)) {
				button.setText(values_[1]);
				button.setIcon(icone);
			}
			
		} catch (Exception e) {
			EnumMessageDisplayer.ERROR.displayException(e);
			return null;
		}
		
		return button;
	}
	
	public LBLButton getLblButton(ElementEnum type_, String[] values_){
		
		LBLButton button = new LBLButton();
		try {
			// TODO Faire le tableau qui va bien dans les properties pour
			// l'icone et le tooltype.
		} catch (Exception e) {
			EnumMessageDisplayer.ERROR.displayException(e);
		}
		
		return button;
	}
	
	public ComposantPane getElement(ElementEnum type_, String libelle_, RButton button_, AppFrame parent_, String zoneName_){
		
		ComposantPane comp = null;
		
		if (type_.equals(ElementEnum.BT_ELEMENT)) {
			comp = new BTElement(libelle_);
			
		}else if (type_.equals(ElementEnum.CB_ELEMENT)) {
			comp = new CBElement(libelle_);
			
		}else if (type_.equals(ElementEnum.ChB_ELEMENT)) {
			comp = new ChBElement(libelle_);
			
		}else if (type_.equals(ElementEnum.RB_ELEMENT)) {
			comp = new RBElement(libelle_);
			
		}else if (type_.equals(ElementEnum.TF_ELEMENT)) {
			comp = new TFElement(libelle_, button_, parent_, zoneName_);
			
		}
		
		return comp;
		
	}
	
	
	
}
