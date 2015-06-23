package GUI.MazzGUI;

import com.jme3.math.Vector2f;
import com.jme3.texture.Texture;
import GUI.FizzGUI.sprites.Sprite;
import GUI.FizzGUI.sprites.TextureRegion;




//split into 9 panels and only resize the center panel
public class NinePatch extends GUIElement{
	
	
	Sprite panels[] = new Sprite[9];

	public NinePatch(Sprite sprite) {

		build(sprite.getTexture(), sprite.getTextureRegion()  );
		
		refresh();
	}

	Vector2f panelDimensions  ;
	private void build(Texture texture, TextureRegion textureRegion) {
		
		/*
		 * GRAPHICAL REPRESENTATION
		 *   0  1  2 
		 *   3  4  5 
		 *   6  7  8
		 *   
		 *   Panel 5 stretches while the others move
		 */
		
		
		for(int i=0;i<9;i++)
		{
			int x = textureRegion.getX() +  ((textureRegion.getWidth()/3) * (i%3));
			int y =  textureRegion.getY() + ((textureRegion.getHeight()/3) * (i/3));
			panels[i] = new Sprite(texture, new TextureRegion("",x,y,textureRegion.getWidth()/3,textureRegion.getHeight()/3)  );
		
			panelDimensions = new Vector2f( textureRegion.getWidth()/3,textureRegion.getHeight()/3 );
			
			this.attachChild(panels[i]);
		}
		
		
	}
	
	Vector2f dimensions = new Vector2f(50,50);
	public void setDimensions(Vector2f dimensions)
	{
		this.dimensions.set(dimensions);
		refresh();
	}

	@Override
	public void update(float tpf)
	{
		super.update(tpf);
		
		
		//setDimensions(new Vector2f(200,60));
		//setOffset(-400,-400,0);
		
		refresh();
		
	}
	
	//Moves and sizes children 
	public void refresh() {
		
		for(Sprite panel : panels)
		{			
			panel.setDimensions(panelDimensions.getX(), panelDimensions.getY());
		}
		

		panels[0].setOffset( 0, dimensions.getY() - panelDimensions.getY() );
		panels[1].setOffset( panelDimensions.getX(), dimensions.getY() - panelDimensions.getY() );
		panels[1].setDimensions(dimensions.getX() - (panelDimensions.getX()*2),  panelDimensions.getY());
		panels[2].setOffset(dimensions.getX() - panelDimensions.getX(), dimensions.getY() - panelDimensions.getY() );
		
		panels[3].setOffset( 0,panelDimensions.getY() );
		panels[3].setDimensions( panelDimensions.getX(),dimensions.getY() - (panelDimensions.getY()*2));
		panels[4].setOffset( panelDimensions.getX(), panelDimensions.getY() );
		panels[4].setDimensions(dimensions.getX() - (panelDimensions.getX()*2), dimensions.getY() - (panelDimensions.getY()*2));
		panels[5].setOffset( dimensions.getX() - panelDimensions.getX(),panelDimensions.getY() );
		panels[5].setDimensions( panelDimensions.getX(),dimensions.getY() - (panelDimensions.getY()*2));
		
		panels[6].setOffset( 0, 0 );
		panels[7].setOffset( panelDimensions.getX(), 0 );
		panels[7].setDimensions(dimensions.getX() - (panelDimensions.getX()*2),  panelDimensions.getY());
		panels[8].setOffset( dimensions.getX() - panelDimensions.getX(), 0 );
		
	}
	
	
	

}
