package Interface;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import Controller.Constants;
import Controller.MapPanelController;


public class MapPanel extends JPanel{
	
	private static final long serialVersionUID = 1L;
	private String path1 = System.getProperty("user.dir");
	private String path3 = "/Images/";
	private BufferedImage map;
	private BufferedImage tilesImg[] = new BufferedImage[]{null, null, null, null, null, null};


	public MapPanel() {
		super();
		
		this.getImages();
		new MapPanelController();
		
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		System.out.println("Paint");
		
		for(int i=0;i<42;i++){
			for(int k=0;k<42;k++){
				g.drawImage(tilesImg[MapPanelController.getIndexOfImage(i, k)], Constants.squareSize*k, Constants.squareSize*i, Constants.squareSize, Constants.squareSize, null);
			}
		}
		
		g.finalize();
	}
	
	private void getImages(){
		if(map==null){
			try {
				map = ImageIO.read(new File(path1 + path3 + "terrains.png"));
			} catch (IOException e) {
				System.out.println("IO error");
			}
		}

		tilesImg[0] = this.cropImage(map, new Rectangle(6*70, 21*70, 70, 70));
		tilesImg[2] = this.cropImage(map, new Rectangle(22*70, 22*70, 70, 70));
		tilesImg[1] = this.cropImage(map, new Rectangle(2*70, 2*70, 70, 70));
		tilesImg[3] = this.cropImage(map, new Rectangle(3*70, 31*70, 70, 70));
		tilesImg[5] = this.cropImage(map, new Rectangle(3*70, 25*70, 70, 70));
		tilesImg[4] = this.cropImage(map, new Rectangle(13*70, 26*70, 70, 70));	
	}
	
	public BufferedImage cropImage(BufferedImage src, Rectangle rect) {

		BufferedImage dest = src.getSubimage(rect.x, rect.y, rect.width, rect.height);
		
		return dest; 
	}

}
