package FizzGUI.positioning;

public enum PositionAnchor {
	NONE(0,0),
	BOTTOMLEFT(0,0),
	LEFT(0,0.5f),
	TOPLEFT(0,1f),
	TOP(0.5f,1f),
	TOPRIGHT(1f,1f),
	RIGHT(1f,0.5f),
	BOTTOMRIGHT(1f,0),
	BOTTOM(0.5f,0),
	CENTER(0.5f,0.5f),
	
	;
	
	
	PositionAnchor(float x, float y){
		this.x=x;
		this.y=y;
	}
	
	public float x = 0;
	public float y = 0;
}
