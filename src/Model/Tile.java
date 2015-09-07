package Model;

import java.awt.image.BufferedImage;

public class Tile {

	private TileType type;
	private BufferedImage img;
	
	public Tile(TileType type, BufferedImage img) {
		super();
		this.type = type;
		this.img = img;
	}

	public BufferedImage getImg() {
		return img;
	}

	public void setImg(BufferedImage img) {
		this.img = img;
	}

	public TileType getType() {
		return type;
	}
	
}
