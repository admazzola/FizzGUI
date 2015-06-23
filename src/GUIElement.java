package GUI.MazzGUI;

import java.util.HashMap;
import com.jme3.math.Vector2f;
import com.jme3.scene.Node;
import GUI.FizzGUI.components.AlignmentComponent;
import GUI.FizzGUI.components.GUIComponent;
import GUI.FizzGUI.components.GUIComponentType;

/**
 * 
 * Similar to GUINode.. can receive focus and automatically updates, resizes, recenters, and listens for clicks
 * 
 *  * @author mazzolaa
 *
 */
public class GUIElement extends Node{
	
	
	//A hashmap is used so that only 1 of any type of component can be registered (cant have floating AND absolute align)
	HashMap<GUIComponentType,GUIComponent> components = new HashMap<GUIComponentType,GUIComponent>();
	
	
	public GUIElement()
	{
		registerComponent( new AlignmentComponent(this) ); //starts with blank alignment
	}
	
	public void setAlignmentComponent(AlignmentComponent component)
	{
		registerComponent( component );
	}
	
	private Vector2f dimensions = new Vector2f(0,0);
//	private Vector2f offset = new Vector2f(0,0);

	public Vector2f getDimensions() {
		return dimensions;
	}

	
	

	public void setOffset(float x, float y) {
		 ((AlignmentComponent)this.getComponent(GUIComponentType.Alignment)).setOffset(x,y,0);		
	}

	
	
	public void setDimensions(Vector2f vec) {
		
		setDimensions(vec.x,vec.y);
	}

	
	
	public void setDimensions(float h, float w) {
		dimensions.set(h,w);
		refresh();
	}

	
	public void refresh()  
	{
		
	}

	public void update(float tpf) {
		updateComponents(tpf);

		simpleUpdate(tpf);
		
	}
	
	protected void simpleUpdate(float tpf) {
		 
		
	}

	private void updateComponents(float tpf) {
		 
		

		for(GUIComponent ec : components.values()){
			ec.update( tpf);
		}
	}

	public void registerComponent(GUIComponent comp)
	{		
		components.put(comp.getType(), comp);
	}
	
	
	public GUIComponent getComponent(GUIComponentType type) {
		
		return components.get(type);
		
	
	}

	public HashMap<GUIComponentType, GUIComponent> getGUIComponents() {
		return components;
	}

	public boolean isFocusable() {
		 //determined by having an event component or not
		return true;
	}
	
	
}
