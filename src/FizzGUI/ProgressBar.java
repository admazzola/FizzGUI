package FizzGUI;

import com.jme3.math.Vector2f;

import superquad.GameRoot;
import FizzGUI.sprites.Sprite;

/**
 *  
 * 
 *  
 *
 */
public class ProgressBar extends GUIElement{

	 
	
	public ProgressBar(String name, Vector2f dimensions) {
		
		this.setName(name);
		this.setDimensions(dimensions);
		
		
		 
	}
	
	float value = 1.0f;
	
	StaticText textLabel;	
	public void setLabelString(String labelString)
	{		 
		textLabel = new StaticText(GameRoot.getAssetLoadController().getFontLoader().guiFont);
		textLabel.setLabelString(labelString);
		this.attachChild(textLabel);
	}

	Sprite[] backgroundSprites;

	public void setBackgroundSprites(Sprite[] backgroundSprites) {
		this.backgroundSprites=backgroundSprites;
		rebuild();
	}

	Sprite[] foregroundSprites;

	public void setForegroundSprites(Sprite[] foregroundSprites) {
		this.foregroundSprites=foregroundSprites;
		rebuild();
	}
	
	
	//The arrow that shows the current value position
	public void setLocatorSprite(Sprite locator)
	{
		
		
	}
	
	public void setValue(float val)
	{
		this.value = val;
		rebuild();
	}

	static final int SPRITE_LEFT = 0;
	static final int SPRITE_MID = 1;
	static final int SPRITE_RIGHT = 2;

	private void rebuild() {
		if(backgroundSprites != null && backgroundSprites.length >= 3)
		{
			this.attachChild(backgroundSprites[SPRITE_LEFT]);
			
		}
		
		if(foregroundSprites != null && foregroundSprites.length >= 3)
		{
			if(this.getValue() > 0.05f)
			{
				this.attachChild(backgroundSprites[SPRITE_LEFT]);
			}
		}
		
	}


	private float getValue() { 
		return value;
	}
	
	
	
	
	
}
