/* HISTORIQUE:
 *
 * Version 1.0 - 16/10/2014 - Cr�ation de la classe.
 * 
 * FIN HISTORIQUE.
 */

package fre.mmm.views.composants.panes;

import javax.swing.ImageIcon;

import fre.mmm.exceptions.InternalException;
import fre.mmm.resources.Resources;
import fre.mmm.views.erreurs.ErrorFrame;

/**Infos:</br>
 * Classe PRSInternalExceptionPane.java</br>
 * Description:</br>
 *	-
 * @author fernoult
 * @since  16/10/2014
 */
public class InternalExceptionPane extends ExceptionPane {

    private InternalException _exception;
    
    private String _excepMessage;
    
    private StackTraceElement[] _excepStackTrace;
    /**<h3>prs.views.composants.panneaux.PRSInternalExceptionPane();</h3>
     * {@code }</br>
     *<p>Constructeur 
     *</p>
     *<b>Note: </b>Neant
     */
    public InternalExceptionPane(ErrorFrame errorFrame_, InternalException exception_) {
	super(errorFrame_);
	_exception = exception_;
	initInternalExceptionPane();
    }
    
    /**<h3>prs.views.composants.panneaux.PRSInternalExceptionPane();</h3>
     * {@code }</br>
     *<p>Constructeur 
     *</p>
     *<b>Note: </b>Neant
     * @param prsErrorFrame_
     * @param excepMessage_
     * @param excepStackTrace_
     */
    public InternalExceptionPane(ErrorFrame prsErrorFrame_,
	    String excepMessage_, StackTraceElement[] excepStackTrace_) {
	super(prsErrorFrame_);
	_excepMessage = excepMessage_;
	_excepStackTrace = excepStackTrace_;
	initInternalExceptionPane();
    }

    private void initInternalExceptionPane() {
//	
//	_icone.setIcon(new ImageIcon(getClass().getResource(_vresources.getImgsPath() + Resources.getInstance().getSepProj() 
//			+ _vresources.getErrorValue("ErreurLabel.Message.Icone.Value"))));
	_messageLibelle.setText(_vresources.getErrorValue("ErreurLabel.Message.Text.Value"));
	_cause.setText(_excepMessage);
	
	StringBuffer buf = new StringBuffer();
	for (int i = 0; i < _excepStackTrace.length; i++) {
	    buf.append(_excepStackTrace[i].toString() + "\n");
	}
	_stackPane.setText(buf.toString());
	
	
    }

//    /* M�thode Overrid�e des classes parentes.
//     * @see prs.views.composants.panneaux.PRSPane#initTabComposants()
//     */
//    @Override
//    protected void initTabComposants() {
//    }
//    
//    /* M�thode Overrid�e des classes parentes.
//     * @see prs.views.composants.panneaux.PRSPane#initTabPanels()
//     */
//    @Override
//    protected void initTabPanels() {
//    }
    
    

}
