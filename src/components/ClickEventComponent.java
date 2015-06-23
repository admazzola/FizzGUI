package GUI.MazzGUI.components;

import com.jme3.input.event.InputEvent;
import com.jme3.input.event.MouseButtonEvent;
import com.jme3.math.Vector2f;
import com.jme3.math.Vector3f;
import superquad.GameRoot;
import GUI.FizzGUI.GUIElement;
import GUI.FizzGUI.GUIEventListener;
import superquad.Peripherals.MouseButton;

public class ClickEventComponent extends EventComponent {

	/**
	 * Can have either absolute positioning, locked to a corner or center, or having floating position (float left) like HTML
	 * 
	 */
	
	
	public ClickEventComponent(GUIElement element, GUIEventListener eventListener)
	{
		super(element,eventListener);
		componentType = GUIComponentType.MouseEvent;
	}
	
	
	
	@Override
	public void update(float tpf)
	{
		
		
		super.update(tpf);
	}


	/**
	 * Listen for hardware events.. if a mouse click occurs and the mouse is within the dimensions of my
	 * element, then tell my event listener (the menu gui) about that!
	 * 
	 */
	@Override
	public int getPriority() {
		
		return 1;
	}


	@Override
	public boolean getIsActive() {
		
		return true;
	}

	@Override
	public boolean onInputEvent(InputEvent evt) {
		
		
		
		
		if(evt instanceof MouseButtonEvent)
		{
			if( ((MouseButtonEvent) evt).isPressed() && ((MouseButtonEvent) evt).getButtonIndex() == MouseButton.LEFT )
			{
				
				if( cursorCoordsOnGuiElement( element   )   )
				{					 
					this.getGUIEventListener().onGUIEvent(element);
				}
				
				
				return true;
			}
		}
		
		return false;
	}



	private static boolean cursorCoordsOnGuiElement(GUIElement element) {

		Vector2f mouseCoords = GameRoot.getHardwareInputManager().getCursorPosition();
		
		if(mouseCoords.x > element.getWorldTranslation().x 
				&& mouseCoords.x < element.getWorldTranslation().x + element.getDimensions().x
				&& mouseCoords.y > element.getWorldTranslation().y
				&& mouseCoords.y < element.getWorldTranslation().y + element.getDimensions().y )
		{
			return true;
		}
		
		
		return false;
	}
	
	
	
	
}
