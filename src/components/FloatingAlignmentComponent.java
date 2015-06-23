package GUI.MazzGUI.components;

import com.jme3.math.Vector2f;
import com.jme3.scene.Spatial;
import superquad.GameRoot;
import GUI.MazzGUI.GUIElement;
import GUI.MazzGUI.positioning.PositionAnchor;

public class FloatingAlignmentComponent extends AlignmentComponent {

	PositionAnchor anchor;
		
	
	public FloatingAlignmentComponent(GUIElement element,PositionAnchor anchor) {
		super(element);
		this.anchor=anchor;
	}
	
	@Override
	public void update(float tpf)
	{
		
		GUIElement parent = (GUIElement) element.getParent();
		
		float runningY = 0;
		Vector2f childMargins = new Vector2f(0,0);
		
		if(parent.getComponent(GUIComponentType.ChildLayout) != null)
		{
			runningY = ((ChildLayoutComponent) parent.getComponent(GUIComponentType.ChildLayout)).innerPadding.y;
			childMargins.set(  ((ChildLayoutComponent) parent.getComponent(GUIComponentType.ChildLayout)).childMargins   );
		}
		
		//iterate through all children before me and add up their y offsets
		for(int brotherIndex = 0; brotherIndex < parent.getChildIndex(element); brotherIndex++)
		{
			Spatial brother = parent.getChild(brotherIndex);
			
			if(brother instanceof GUIElement && ((GUIElement)brother).getComponent(GUIComponentType.Alignment) instanceof FloatingAlignmentComponent )
			{
				runningY += ((GUIElement)brother).getDimensions().y + childMargins.y;
			}
			
			
		}
		
		
		float y = parent.getDimensions().y - runningY - element.getDimensions().y;
		
		
		
		//offset.setX(GameRoot.getDisplayController().getScreenResolution().x * anchor.x  - element.getDimensions().x /2); 
		offset.setY( y ); 
		
		if(parent.getComponent(GUIComponentType.ChildLayout) != null)
		{
			offset.setX( ((ChildLayoutComponent) parent.getComponent(GUIComponentType.ChildLayout)).innerPadding.x );  
		}
		 //depends on the brother elements and my index in them
		
		
		 super.update(tpf);		
	}
	
	

	
}
