/* ihmref-PrefsPane.java
 * HISTORIQUE
 *
 * [MODIF]: Version - le 8 avr. 2015 - Creation de la classe.
 *
 * FIN HISTORIQUE
 */
package fre.mmm.views.composants.panes;

import java.awt.BorderLayout;
import java.awt.LayoutManager;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;

import com.jtattoo.plaf.About;
import com.jtattoo.plaf.AbstractBorderFactory;
import com.jtattoo.plaf.AbstractIconFactory;
import com.jtattoo.plaf.AbstractLookAndFeel;

import fre.mmm.resources.Resources;
import fre.mmm.views.LafFrame;
import fre.mmm.views.PFrame;
import fre.mmm.views.ViewsRessources;
import fre.mmm.views.composants.tables.LafTable;
import fre.mmm.views.composants.tables.models.LafTableModel;
import fre.mmm.views.composants.tables.renderers.LafRowsTableRenderer;
import fre.mmm.views.laf.ILAndF;
import fre.mmm.views.laf.impl.LAndFImpl;

public class LafPane extends JPanel {

	private ArrayList<PFrame> _displayFrames;
	
	private JPanel _northPrefPane;
	
	private JPanel _centerPrefPane;
	
	private JLabel _lafImage;
	
	private JLabel _jtVersion;
	
	private LafTable _lafTable;

	private TableModel _lafTableModel;
	
	private JTextField _lafTF;
	
	private LafFrame _lafFrame;

	/** PrefsPane
	 * Constructeur
	 */
	public LafPane() {
		super();
		initPane();
	}

	/** PrefsPane
	 * Constructeur
	 */
	public LafPane(LayoutManager layout_) {
		super(layout_);
		initPane();
	}
	
	public LafPane(JTextField lafTF_, LafFrame lafFrame_){
		super();
		_lafTF = lafTF_;
		_lafFrame = lafFrame_;
		initPane();
	}
	
	private void initPane(){
		
		
		// Init
		initLafTable();
		initComposants();
		
		_northPrefPane = new JPanel(new BorderLayout());
		_northPrefPane.add(_lafImage, BorderLayout.EAST);
		_northPrefPane.add(_jtVersion, BorderLayout.CENTER);
		
		_centerPrefPane = new JPanel(new BorderLayout());
		JScrollPane sp = new JScrollPane(_lafTable);
		_centerPrefPane.add(sp, BorderLayout.CENTER);
		
		add(_northPrefPane, BorderLayout.NORTH);
		add(_centerPrefPane, BorderLayout.CENTER);
		 
		setVisible(true);
	}
	
	private void initComposants(){
		
		_lafImage = new JLabel(new ImageIcon(getClass().getResource(ViewsRessources.getInstance().getImgsPath() 
				+ Resources.getInstance().getSepProj() + "laf_graphite.jpg")));
		_jtVersion = new JLabel("Librarire JTattoo " + About.JTATTOO_VERSION);

	}
	
	private void initLafTable(){
		
		String[] tabLAF = ViewsRessources.getInstance().getLafAvaible();
		ArrayList<LAndFImpl> lafList = new ArrayList<>();
		
		for (int i = 0; i < tabLAF.length; i++) {
			String lafname = tabLAF[i].substring(0, tabLAF[i].lastIndexOf("."));
			String lafPath = ViewsRessources.getInstance().getPrefixLaf() + tabLAF[i];
			LAndFImpl lAndFImpl = new LAndFImpl(lafname, lafPath, new AbstractLookAndFeel() {
				@Override
				public AbstractIconFactory getIconFactory() {
					return null;
				}
				@Override
				public AbstractBorderFactory getBorderFactory() {
					return null;
				}
			});
			
			lafList.add(lAndFImpl);
			
		}
		
		_lafTableModel = new LafTableModel();
		_lafTable = new LafTable(_lafTableModel);
		_lafTable.setRowHeight(20);
		((LafTableModel) _lafTable.getModel()).addLAFObjects(lafList);
		
		for (int i = 0; i < _lafTable.getModel().getColumnCount(); i++) {
			TableColumn colonne = _lafTable.getColumnModel().getColumn(i);
			colonne.setCellRenderer(new LafRowsTableRenderer());
		}

		_lafTable.addMouseMotionListener(new MouseMotionListener() {
			
			String prefix = ViewsRessources.getInstance().getImgsPath() + Resources.getInstance().getSepProj() + "laf_";
			String suffix = ".jpg";
			
			@Override
			public void mouseMoved(MouseEvent e) {
				
				ILAndF lAndFImpl = ((LafTableModel)_lafTable.getModel()).getLAFObject(_lafTable.rowAtPoint(e.getPoint()));
				_lafImage.setIcon(new ImageIcon(getClass().getResource(prefix + lAndFImpl.getLafName() + suffix)));
			}
			
			@Override
			public void mouseDragged(MouseEvent e) {
			}
		});
		
		_lafTable.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				//TODO JavaDoc tout de suite !!!!!!
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				//TODO JavaDoc tout de suite !!!!!!
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				//TODO JavaDoc tout de suite !!!!!!
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				//TODO JavaDoc tout de suite !!!!!!
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				
				ILAndF lAndFImpl = ((LafTableModel)_lafTable.getModel()).getLAFObject(_lafTable.rowAtPoint(e.getPoint()));
				_lafTF.setText(lAndFImpl.getLafPath());
				_lafTF.revalidate();
				
				_lafFrame.dispose();
				
				
			}
		});
	}
	
}
