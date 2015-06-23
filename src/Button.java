package GUI.FizzGUI;

import com.jme3.font.BitmapFont;
import com.jme3.math.Vector2f;


public class Button  extends GUIElement{

	NinePatch ninePatch;
	
	public Button(String name, Vector2f dimensions) {
		
		this.setName(name);
		this.setDimensions(dimensions);
		
		 
	}
	
	public void setBackground(NinePatch ninepatch)
	{
		 this.ninePatch=ninepatch;
		
		ninePatch.setDimensions(this.getDimensions());
		this.attachChild(ninePatch);	
	}
	
	StaticText textLabel;	
	public void setLabelString(BitmapFont font, String labelString)
	{		 
		textLabel = new StaticText(font);
		textLabel.setLabelString(labelString);
		this.attachChild(textLabel);
	}
	
	
	
	
	
	
}
