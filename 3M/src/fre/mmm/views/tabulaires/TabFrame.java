package fre.mmm.views.tabulaires;

import java.awt.Toolkit;

import javax.swing.WindowConstants;

import fre.mmm.resources.Resources;
import fre.mmm.views.AppFrame;
import fre.mmm.views.ViewsRessources;

public class TabFrame extends AppFrame {

	public TabFrame() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TabFrame(String title_){
		super();
		title_ = ViewsRessources.getInstance().getLibelleValue("frame.tab.title.text");
		setTitle(title_);
	}

	@Override
	protected void initPFrame() {
		super.initPFrame();
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource(ViewsRessources.getInstance().getImgsPath() 
				+ Resources.getInstance().getSepProj() + "list.png")));
		setSize(250, 200);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		
	}
	
}
