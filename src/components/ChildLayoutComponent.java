package GUI.FizzGUI.components;

import com.jme3.input.event.InputEvent;
import com.jme3.math.Vector2f;
import com.jme3.math.Vector3f;
import superquad.GameRoot;
import GUI.FizzGUI.GUIElement;
import GUI.FizzGUI.GUIEventListener;
import superquad.Peripherals.InputEventListener;

public class ChildLayoutComponent extends GUIComponent {

	/**
	 * Settings for how the child components will be padded and laid out
	 * 
	 */
	
	//The entity that has this component
	GUIElement element;
	
	Vector2f innerPadding = new Vector2f(0,0);
	
	Vector2f childMargins = new Vector2f(0,0);
	
	public ChildLayoutComponent(GUIElement element)
	{
		this.element=element;
		componentType = GUIComponentType.ChildLayout;
	}
	

	@Override
	public void update(float tpf)
	{
		
		
		super.update(tpf);
	}


	public Vector2f getInnerPadding() {
		return innerPadding;
	}


	public void setInnerPadding(Vector2f innerPadding) {
		this.innerPadding = innerPadding;
	}


	public Vector2f getChildMargins() {
		return childMargins;
	}


	public void setChildMargins(Vector2f childMargins) {
		this.childMargins = childMargins;
	}


}
