package Model;

import java.awt.image.BufferedImage;

public class Terrain extends Tile{
	
	private int requiredTime;

	public Terrain(TileType type, BufferedImage img, int requiredTime) {
		super(type, img);
		this.requiredTime = requiredTime;
	}

	public int getRequiredTime() {
		return requiredTime;
	}

	public void setRequiredTime(int requiredTime) {
		this.requiredTime = requiredTime;
	}
	
	
	

}
