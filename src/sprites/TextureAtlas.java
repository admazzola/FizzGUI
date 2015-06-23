package GUI.FizzGUI.sprites;

import java.io.File;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

 



import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import com.jme3.asset.AssetManager;
import com.jme3.texture.Texture;

import superquad.GameRoot;

/**
 * 
 * 
 * see  https://github.com/libgdx/libgdx/blob/master/gdx/src/com/badlogic/gdx/graphics/g2d/TextureAtlas.java
 * 


 *
 */

public class TextureAtlas {
	
	
	
	
	public Texture tex; //this stays null ?
	
	public List<TextureRegion> subTextures = new ArrayList<TextureRegion>();
	
	
	public TextureAtlas(AssetManager assetManager, String path) {

	
		try {
			loadTextureAtlas(assetManager,path);
			
			System.out.println("loaded file at "+ path);
		} catch (Exception e) {
			
			System.out.println("failed to load file at "+ path);
			e.printStackTrace();
		}
		
		
	}

	
	
	
	public void loadTextureAtlas(AssetManager assetManager, String path) throws Exception 
	{
	
		 
		//URL test = SharedData.getPathToLocalFiles( "/Textures/GUI/uipack_rpg_sheet.xml" );
		InputStream stream = GameRoot.class.getResourceAsStream( path );
		
		//File file = new File( url.toURI()  ) ; //this only works when run from eclipse...
		DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory
		    .newInstance();
		DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
		Document document = documentBuilder.parse(stream);
		
		
		NodeList textureAtlasNodeList = document.getElementsByTagName("TextureAtlas");
		 Element textureAtlasElement = (Element)textureAtlasNodeList.item(0);
		String imagePath = textureAtlasElement.getAttribute("imagePath");
		 tex = assetManager.loadTexture(imagePath);
		
		
		NodeList subTextureNodeList = document.getElementsByTagName("SubTexture");
		
		for(int i = 0 ; i < subTextureNodeList.getLength(); i++){
		    Element subTextureElement = (Element)subTextureNodeList.item(i);
		    String name = subTextureElement.getAttribute("name");
		    String x= subTextureElement.getAttribute("x");
		    String y= subTextureElement.getAttribute("y");
		    String width = subTextureElement.getAttribute("width");
		    String height= subTextureElement.getAttribute("height");

		    subTextures.add(new TextureRegion(name,Integer.parseInt(x),Integer.parseInt(y),Integer.parseInt(width),Integer.parseInt(height)));
		    
		   // System.out.println("added subtexture " + subTextures.get(  subTextures.size() - 1));

		    // GET THE PICTURE FROM SHEET WITH THESE?
		    }
		
		
		
		}
		
		
	/** Returns all regions with the specified name as sprites, ordered by smallest to largest {@link AtlasRegion#index index}. This
	 * method uses string comparison to find the regions and constructs new sprites, so the result should be cached rather than
	 * calling this method multiple times.
	 * @see #createSprite(String) */
		public Sprite getSprite(String name) {
		
		for (int i = 0, n = subTextures.size(); i < n; i++) {
			TextureRegion region = subTextures.get(i);
			if (region.name.equals(name))
			{
				
				return new Sprite(tex, region);
			}
		}
		return null;
	}




	public Sprite[] getSprites(String... names) {
		Sprite[] sprites = new Sprite[names.length];

		for(int i=0;i<names.length;i++)
		{
			sprites[i] = getSprite(names[i]);
		}
				
		return sprites;
	}
	
	
	
	
	
}
