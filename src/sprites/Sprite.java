package GUI.MazzGUI.sprites;


import com.jme3.material.Material;
import com.jme3.material.RenderState.BlendMode;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Vector2f;
import com.jme3.math.Vector3f;
import com.jme3.renderer.queue.RenderQueue.Bucket;
import com.jme3.scene.Geometry;
import com.jme3.scene.Mesh;
import com.jme3.scene.Node;
import com.jme3.scene.Spatial.CullHint;
import com.jme3.scene.VertexBuffer.Type;
import com.jme3.texture.Texture;
import com.jme3.texture.Texture.MagFilter;
import com.jme3.texture.Texture.MinFilter;
import com.jme3.util.BufferUtils;
import superquad.GameRoot;
import GUI.MazzGUI.GUIElement;

public class Sprite extends GUIElement{

			

	Texture tex = null;
	TextureRegion region;
	
	public Sprite(Texture tex,TextureRegion region){
		
		this.tex = tex;
		
		tex.setMagFilter(MagFilter.Nearest);
		tex.setMinFilter(MinFilter.NearestNoMipMaps);
		
		this.region=region;
		
		getDimensions().set(region.getWidth(), region.getHeight());
		
		init();
		
	}


	Mesh m;
	
	Vector2f [] texCoord = new Vector2f[4];


	Material mat;
	
	Geometry geom;
	
	void init(){
		
		   m = new Mesh();


	        refresh();
	        
	        
  	    
  	    //geo.setLocalTranslation(loc.getX()*CubesSettings.BLOCK_SIZE, loc.getY()*CubesSettings.BLOCK_SIZE, loc.getZ()*CubesSettings.BLOCK_SIZE);
	        // Creating a geometry, and apply a single color material to it
	        geom = new Geometry();
	        geom.setName("Sprite");
	        geom.setMesh(m);
	        
	        //Need to clone materials or they will overwrite on you!
	        mat = GameRoot.getAssetLoadController().getTextureLoader().unshaded.clone();// new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
	        mat.getAdditionalRenderState().setBlendMode(BlendMode.Alpha); // activate transparency
	        mat.setTransparent(true);
	        
	        if(tex==null){
	        	System.err.println("TEXTURE IS NULL FOR " + this);
	        	//tex = MainApp.getGameState().getGamedata().getTexturePack();
	        }
	        
	        //tex = mainapp.getAssetManager().loadTexture(SharedData.BLOCK_TEXTURE_PATH);
	       // tex.setAnisotropicFilter(2);
	        tex.setMinFilter(MinFilter.Trilinear);
	        tex.setMagFilter(MagFilter.Nearest);
	        mat.setTexture("ColorMap", tex);	     
	       // mat.setReceivesShadows(false);
	        mat.setColor("Color", ColorRGBA.White); 
	        geom.setMaterial(mat);
	        geom.setQueueBucket(Bucket.Gui);
	        geom.setCullHint(CullHint.Never);
	        
	        this.attachChild(geom);
	        // Attaching our geometry to the root node.
	        //MainApp.getGameState().rootNode.attachChild(geom);
	       
	}
	

    
    public void setColor(ColorRGBA color){
    	mat.setColor("Color", color); 
    }
    
    
   
    private void updateTexCoords(){
    

    	float totalheight = tex.getImage().getHeight();
    	float totalwidth = tex.getImage().getWidth();

    	
    	
    	
       	   // float tile_size = (1f/(float)tilesPerRow);
	      
        	
	        float x = region.getX();
	        float y =  region.getY();
	        
	        float tileheight = region.getHeight();
	        float tilewidth = region.getWidth();
	        
	        
	        // Texture coordinates
	        
	        texCoord[2] = new Vector2f(x/totalwidth,1f - (y/totalheight)); 
	        texCoord[3] = new Vector2f((x+(tilewidth))/totalwidth,1f - (y/totalheight));
	        texCoord[0] = new Vector2f(x/totalwidth,1f - ((y+tileheight)/totalheight));
	        texCoord[1] = new Vector2f((x+(tilewidth))/totalwidth,1f - ((y+tileheight)/totalheight));
	        
    }
    
    
    
    
    public void refresh() {
    
		 updateTexCoords();		
	     setBuffers();
	 
	}
    
    	
	
	void setBuffers(){
		
		
		 m.setBuffer(Type.Position, 3, new float[]{
	        		0,      0,      0,
	        		getDimensions().x,  0,      0,
	                0,  getDimensions().y, 0,
	                getDimensions().x,     getDimensions().y, 0
	                });
		 
		 
	     m.setBuffer(Type.TexCoord, 2, BufferUtils.createFloatBuffer(texCoord));
	     
	     m.setBuffer(Type.Index, 3, new short[]{2,0,1,1,3,2});
	    
	     m.updateBound();
	     
	       
	}

	public Material getMaterial() {
		return geom.getMaterial();
	}





	public TextureRegion getTextureRegion() {
		return region;
	}

	public Texture getTexture() {
		return tex;
	}








	
	
}
