package GUI.MazzGUI;

import com.jme3.math.Vector2f;

import superquad.GameRoot;
import GUI.MazzGUI.sprites.Sprite;

	public class Icon extends GUIElement{
		
	
	Sprite image;
	
	public Icon(String name, String iconName) {		
		this.setName(name);
		this.setDimensions(new Vector2f(40,40)); //default
		 
		image = GameRoot.getAssetLoadController().getTextureLoader().lorcSheet.getSprite(iconName);
		image.setDimensions(40, 40);
		this.attachChild(image);	
	}
	
	
	
}
