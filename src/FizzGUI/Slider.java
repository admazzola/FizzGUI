package FizzGUI;

import com.jme3.math.Vector2f;

import superquad.GameRoot;
import FizzGUI.sprites.Sprite;

/**
 * A controllable progress bar
 * 
 *  
 *
 */
public class Slider extends GUIElement{

	ProgressBar progressBar;
	
	public Slider(String name, Vector2f dimensions) {
		
		this.setName(name);
		this.setDimensions(dimensions);
		
		 
		progressBar = new ProgressBar(name + " bar ", this.getDimensions());
		
	
		this.attachChild(progressBar);	
	}
	
	public void setForegroundSprites(Sprite[] foregroundSprites)
	{
		progressBar.setForegroundSprites(foregroundSprites);		
	}
	
	public void setBackgroundSprites(Sprite[] backgroundSprites)
	{
		progressBar.setBackgroundSprites(backgroundSprites);		
	}
	
	
	 
	public void setLabelString(String labelString)
	{		 
		progressBar.setLabelString(labelString);
	}
	
	
	
	
	
	
}
