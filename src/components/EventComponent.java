package GUI.FizzGUI.components;

import com.jme3.input.event.InputEvent;
import com.jme3.math.Vector2f;
import com.jme3.math.Vector3f;
import superquad.GameRoot;
import GUI.FizzGUI.GUIElement;
import GUI.FizzGUI.GUIEventListener;
import superquad.Peripherals.InputEventListener;

public class EventComponent extends GUIComponent implements InputEventListener{

	/**
	 * Can have either absolute positioning, locked to a corner or center, or having floating position (float left) like HTML
	 * 
	 */
	
	//The entity that has this component
	GUIElement element;
	GUIEventListener eventListener;
	
	public EventComponent(GUIElement element, GUIEventListener eventListener)
	{
		this.element=element;
		this.eventListener=eventListener;
		
		GameRoot.getHardwareInputManager().registerInputListener( this );
	}
	

	protected GUIEventListener getGUIEventListener() {
		
		return eventListener;
	}
	
	@Override
	public void update(float tpf)
	{
		
		
		super.update(tpf);
	}


	@Override
	public int getPriority() {
		
		return 0;
	}


	@Override
	public boolean getIsActive() {
		
		return true;
	}


	@Override
	public boolean onInputEvent(InputEvent evt) {
		
				
		return false;
	}


	


}
