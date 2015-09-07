package Model;

import java.awt.image.BufferedImage;

public class ZodiacHouse extends Tile{
	
	private int number;
	private String name;
	private int difficulty;
	
	public ZodiacHouse(TileType type, BufferedImage img, int number,
			String name, int difficulty) {
		super(type, img);
		this.number = number;
		this.name = name;
		this.difficulty = difficulty;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(int difficulty) {
		this.difficulty = difficulty;
	}
	
	
	
	

	
}
