package GUI.MazzGUI.sprites;

public class TextureRegion
{
	
	String name;
	int x;
	int y;
	int width;
	int height;
	
	public TextureRegion(String name, int x, int y, int width, int height) {
		this.name=name;
		this.x=x;
		this.y=y;
		this.width=width;
		this.height=height;
	}
	
	
	@Override
	public String toString()
	{
		return name;
	}


	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public int getWidth() {
		return width;
	}
	public int getHeight() {
		return height;
	}

}
