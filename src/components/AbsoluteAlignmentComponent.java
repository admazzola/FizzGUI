package GUI.FizzGUI.components;

import com.jme3.math.Vector2f;
import com.jme3.math.Vector3f;

import superquad.GameRoot;
import GUI.FizzGUI.GUIElement;
import GUI.FizzGUI.positioning.PositionAnchor;

public class AbsoluteAlignmentComponent extends AlignmentComponent {

	PositionAnchor anchor;
	Vector2f margins = new Vector2f(0,0);
	
	
	public AbsoluteAlignmentComponent(GUIElement element,PositionAnchor anchor) {
		super(element);
		this.anchor=anchor;
	}
	
	@Override
	public void update(float tpf)
	{
		offset.setX(GameRoot.getDisplayController().getScreenResolution().x * anchor.x - element.getDimensions().x /2 + margins.x); 
		offset.setY(GameRoot.getDisplayController().getScreenResolution().y * anchor.y - element.getDimensions().y /2 + margins.y); 
		 
		 super.update(tpf);		
	}

	public void setMargins(Vector2f vec) {
		margins.set(vec);
	}

	public Vector3f getOffset() {
		return offset;
	}
	
	

	
}
