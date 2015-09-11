package Model;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class BoardMap {

	private BufferedImage map;
	private String path1 = System.getProperty("user.dir");
	private String path2 = "/Images/";
	private BufferedImage tilesImg[] = new BufferedImage[]{null, null, null, null, null, null};
	private Terrain rock, mountain, plain, start, end;
	private ZodiacHouse house;

	public BoardMap(){
		
		this.getImages();
		
		mountain = new Terrain(TileType.Mountain, tilesImg[0],0);
		rock = new Terrain(TileType.Rock, tilesImg[1],0);
		plain = new Terrain(TileType.Plain, tilesImg[2],0);
		house = new ZodiacHouse(TileType.ZodiacHouse, tilesImg[3], 0, null, 0);
		start = new Terrain(TileType.Initial, tilesImg[4],0);
		end = new Terrain(TileType.Final, tilesImg[5],0);
		
	}

	private void getImages(){
		if(map==null){
			try {
				map = ImageIO.read(new File(path1 + path2 + "terrains.png"));
			} catch (IOException e) {
				System.out.println("IO error");
			}
		}

		tilesImg[0] = this.cropImage(map, new Rectangle(6*70, 21*70, 70, 70));
		tilesImg[1] = this.cropImage(map, new Rectangle(22*70, 22*70, 70, 70));
		tilesImg[2] = this.cropImage(map, new Rectangle(2*70, 2*70, 70, 70));
		tilesImg[3] = this.cropImage(map, new Rectangle(3*70, 31*70, 70, 70));
		tilesImg[4] = this.cropImage(map, new Rectangle(3*70, 25*70, 70, 70));
		tilesImg[5] = this.cropImage(map, new Rectangle(16*70, 30*70, 70, 70));	
	}

	public BufferedImage getTile(int number){
		BufferedImage aux = null;
		switch(number){
		case 0:
			aux = mountain.getImg();
			break;
		case 1:
			aux = plain.getImg();
			break;
		case 2:
			aux = rock.getImg();
			break;
		case 3:
			aux = house.getImg();
			break;
		case 4:
			aux = end.getImg();
			break;
		case 5:
			aux = start.getImg();
			
			break;
		}

		return aux;
	}

	public BufferedImage cropImage(BufferedImage src, Rectangle rect) {

		BufferedImage dest = src.getSubimage(rect.x, rect.y, rect.width, rect.height);
		
		return dest; 
	}

}
