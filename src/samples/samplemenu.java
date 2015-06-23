package superquad.GameStates.FrontMenu;


import com.jme3.audio.AudioNode;
import com.jme3.font.BitmapFont;
import com.jme3.math.Vector2f;

import superquad.GameRoot;
import GUI.FizzGUI.Button;
import GUI.FizzGUI.GUIElement;
import GUI.FizzGUI.MenuBase;
import GUI.FizzGUI.NinePatch;
import GUI.FizzGUI.Panel;
import GUI.FizzGUI.StaticText;
import GUI.FizzGUI.components.AbsoluteAlignmentComponent;
import GUI.FizzGUI.components.ChildLayoutComponent;
import GUI.FizzGUI.components.ClickEventComponent;
import GUI.FizzGUI.components.FloatingAlignmentComponent;
import GUI.FizzGUI.positioning.PositionAnchor; 

public class FrontMenuGUI extends MenuBase{

	Panel menuButtonPanel;
		
	Button storyButton;
	
	Button freeRoamButton;
	
	Button garageButton;
	
	Button editorButton;
	
	Button settingsButton;
	 
	FrontMenuState frontMenu;
	
	public FrontMenuGUI(FrontMenuState parentState)
	{	
		super(parentState);
		buildGUI();
		
		this.frontMenu=parentState;
		
	}	
	

	
	public void buildGUI() {
		 
		
		 StaticText title = new StaticText( GameRoot.getAssetLoadController().getFontLoader().spaceFont );
		 title.setLabelString("Super Quad Racer");
		 AbsoluteAlignmentComponent absAlign = new AbsoluteAlignmentComponent(title,PositionAnchor.TOP);
		 absAlign.setMargins(new Vector2f(0,-100));		 
		 title.registerComponent(absAlign);		 
		 attachChild(title);		 
		 
		 		 
		 menuButtonPanel = new Panel("Menu Button Panel", new Vector2f(400,500));		 
		 menuButtonPanel.setBackground( new NinePatch(GameRoot.getAssetLoadController().getTextureLoader().silverUISheet.getSprite("grey_panel.png")) );
		 menuButtonPanel.registerComponent(new AbsoluteAlignmentComponent(menuButtonPanel,PositionAnchor.CENTER));		
		 		 
		 ChildLayoutComponent menuButtonPanelLayout = new ChildLayoutComponent(menuButtonPanel);
		 menuButtonPanelLayout.setInnerPadding(new Vector2f(30f,50f));
		 menuButtonPanelLayout.setChildMargins(new Vector2f(30f,30f));
		 menuButtonPanel.registerComponent(menuButtonPanelLayout);		 
		 attachChild(menuButtonPanel);
		 
		 BitmapFont buttonFont = GameRoot.getAssetLoadController().getFontLoader().guiFont;
		 
		 storyButton = new Button("Story Button", new Vector2f(300,40));
		 storyButton.setBackground( new NinePatch(GameRoot.getAssetLoadController().getTextureLoader().spaceUISheet.getSprite("metalPanel_blue.png"))); 
		 storyButton.setLabelString(buttonFont,"Story");
		 storyButton.registerComponent(new ClickEventComponent(storyButton,this));
		 storyButton.registerComponent(new FloatingAlignmentComponent(storyButton,PositionAnchor.CENTER));
		 menuButtonPanel.attachChild(storyButton);
		 
		 freeRoamButton = new Button("Free Roam Button", new Vector2f(300,40));
		 freeRoamButton.setBackground( new NinePatch(GameRoot.getAssetLoadController().getTextureLoader().spaceUISheet.getSprite("metalPanel_blue.png"))); 
		 freeRoamButton.setLabelString(buttonFont,"Free Roam");
		 freeRoamButton.registerComponent(new ClickEventComponent(freeRoamButton,this));
		 freeRoamButton.registerComponent(new FloatingAlignmentComponent(freeRoamButton,PositionAnchor.CENTER));
		 menuButtonPanel.attachChild(freeRoamButton);
		 
		 garageButton = new Button("Garage Button", new Vector2f(300,40));
		 garageButton.setBackground( new NinePatch(GameRoot.getAssetLoadController().getTextureLoader().spaceUISheet.getSprite("metalPanel_blue.png"))); 
		 garageButton.setLabelString(buttonFont,"Garage");
		 garageButton.registerComponent(new ClickEventComponent(garageButton,this));
		 garageButton.registerComponent(new FloatingAlignmentComponent(garageButton,PositionAnchor.CENTER));
		 menuButtonPanel.attachChild(garageButton);
		 	
		 editorButton = new Button("Editor Button", new Vector2f(300,40));
		 editorButton.setBackground( new NinePatch(GameRoot.getAssetLoadController().getTextureLoader().spaceUISheet.getSprite("metalPanel_blue.png")));
		 editorButton.setLabelString(buttonFont,"Map Editor");
		 editorButton.registerComponent(new ClickEventComponent(editorButton,this));
		 editorButton.registerComponent(new FloatingAlignmentComponent(editorButton,PositionAnchor.CENTER));
		 menuButtonPanel.attachChild(editorButton);
		 	
		 
		 settingsButton = new Button("Settings Button", new Vector2f(300,40));
		 settingsButton.setBackground( new NinePatch(GameRoot.getAssetLoadController().getTextureLoader().spaceUISheet.getSprite("metalPanel_blue.png")));
		 settingsButton.setLabelString(buttonFont,"Settings");
		 settingsButton.registerComponent(new ClickEventComponent(settingsButton,this));
		 settingsButton.registerComponent(new FloatingAlignmentComponent(settingsButton,PositionAnchor.CENTER));
		 menuButtonPanel.attachChild(settingsButton);
		
	}



	@Override
	public void onGUIEvent(GUIElement element) {
		
		if(isEnabled() )
		{
		System.out.println("GUI event from " + element);
		}
	}
	



}
