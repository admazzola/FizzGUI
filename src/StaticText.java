package GUI.FizzGUI;

import com.jme3.asset.AssetManager;
import com.jme3.font.BitmapFont;
import com.jme3.font.BitmapText;

public class StaticText extends GUIElement{

	 
	BitmapText displaytext;
	
	public StaticText(BitmapFont font)
	{		
	    displaytext = new BitmapText(font);
	    displaytext.setSize(font.getCharSet().getRenderedSize());
	    displaytext.move(10, displaytext.getLineHeight() + 2, 0);
	    displaytext.setText("NULL STRING");	    
	    attachChild(displaytext);
	}
	
	public void setLabelString(String labelString)
	{
		displaytext.setText(labelString);
		 this.setDimensions(displaytext.getLineWidth(), displaytext.getLineHeight());
	}
	
	
	
}
