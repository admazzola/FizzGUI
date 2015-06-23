package GUI.FizzGUI;



import com.jme3.scene.Node;
import com.jme3.scene.SceneGraphVisitor;
import com.jme3.scene.Spatial;
import superquad.GameStates.EnvironmentState;

public class MenuBase extends Node implements GUIEventListener{
	/**
	 * This is the currently focused element.. so if you press Enter or move the sticks, this will react or change
	 */
	GUIElement focusedElement; 
	
	EnvironmentState parentState;
	
	public MenuBase(EnvironmentState parentState)	
	{
		this.parentState=parentState;
		
	}
	
	protected boolean isEnabled() {
		return getParentState().isEnabled() && this.hasAncestor(getParentState().getGUINode() );
	}
	
	float lastTPF = 10;
	
	public void update(float tpf)
	{
		lastTPF = tpf;
		breadthFirstTraversal(updater); //kind lags..
		
		updateFocus(tpf);
		
	}
	
	

	private void updateFocus(float tpf) {
		if(focusedElement == null)
		{
			for(int i=0; i<this.getChildren().size(); i++)
			{
				if(this.getChild(i) instanceof GUIElement && ((GUIElement)this.getChild(i)).isFocusable()  )   
				{
					focusedElement = (GUIElement) this.getChild(i) ;
				}
			}
			
			
		}
		
		
	}



	SceneGraphVisitor updater = new SceneGraphVisitor() {
		 
		  @Override
		  public void visit(Spatial child) {
			  			  
			   if(child instanceof GUIElement)
			   {
				   ((GUIElement) child).update(lastTPF);
			   }
		    
		  }
		 
		};

	@Override
	public void onGUIEvent(GUIElement element) {
		
		
	}



	protected EnvironmentState getParentState() {
		return parentState;
	}

	
}
