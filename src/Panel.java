package GUI.MazzGUI;

import com.jme3.math.Vector2f;
import superquad.GameRoot;
import GUI.MazzGUI.components.AlignmentComponent;

public class Panel extends GUIElement{

	
	
	NinePatch ninePatch;
	
	public Panel(String name, Vector2f dimensions )
	{
		this.setName(name);
		this.setDimensions(dimensions);
		
		
		
		
		
	}
	
	public void setBackground(NinePatch ninepatch)
	{
		 this.ninePatch=ninepatch;
		
		ninePatch.setDimensions(this.getDimensions());
		this.attachChild(ninePatch);	
	}
	
	

	protected void simpleUpdate(float tpf) {
		 
		
	}


	
	
}
