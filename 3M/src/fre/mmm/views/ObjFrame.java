package fre.mmm.views;

import java.awt.Toolkit;

import javax.swing.WindowConstants;

import fre.mmm.resources.Resources;

public class ObjFrame extends AppFrame{

	public ObjFrame() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public ObjFrame(String title_){
		super();
		title_ = ViewsRessources.getInstance().getLibelleValue("frame.obj.title.text");
		setTitle(title_);
	}

	@Override
	protected void initPFrame() {
		super.initPFrame();
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource(ViewsRessources.getInstance().getImgsPath() 
				+ Resources.getInstance().getSepProj() + "objet.png")));
		setSize(250, 200);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
	}
	
}
