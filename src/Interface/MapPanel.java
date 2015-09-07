package Interface;

import java.awt.Graphics;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

import javax.swing.JPanel;

import Model.BoardMap;

public class MapPanel extends JPanel{
	
	private static final long serialVersionUID = 1L;
	private BoardMap map = new BoardMap();
	private Scanner in;
	private int tileSize = 17;
	private String path1 = System.getProperty("user.dir");
	private String path2 = "/src/DataSource/";
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		System.out.println("Paint");
		
		try {
			 in = new Scanner(new FileReader(path1 + path2 + "Map.txt"));
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		for(int i=0;i<42;i++){
			for(int k=0;k<42;k++){
				g.drawImage(map.getTile(in.nextInt()), tileSize*k, tileSize*i, tileSize, tileSize, null);
			}
		}
		
		g.finalize();
	}

}
