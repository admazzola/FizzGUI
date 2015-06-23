package FizzGUI.components;

import com.jme3.math.Vector2f;
import com.jme3.math.Vector3f;
import FizzGUI.GUIElement;

public class AlignmentComponent extends GUIComponent{

	/**
	 * Can have either absolute positioning, locked to a corner or center, or having floating position (float left) like HTML
	 * 
	 */
	
	//The entity that has this component
	GUIElement element;
	
	public AlignmentComponent(GUIElement element)
	{
		this.element=element;
		componentType = GUIComponentType.Alignment;
	}
	
	Vector3f offset = new Vector3f(0,0,0);
	
	public void setOffset(Vector3f vec) {
		setOffset(vec.x,vec.y,vec.z);
	}
	
	public void setOffset(float x, float y, float z) {
		offset.set(x,y,z);
		element.refresh();
	}
	
	@Override
	public void update(float tpf)
	{
		
		element.setLocalTranslation(offset.getX(), offset.getY(),  0 ); 
		
		super.update(tpf);
	}
	
}
