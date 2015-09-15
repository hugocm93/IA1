package Interface;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import Controller.Constants;
import Controller.MapPanelController;
import org.imgscalr.Scalr;
import java.util.ListIterator;

public class MapPanel extends Adapter{

	private static final long serialVersionUID = 1L;
	private int x=0,y=0;
	private String path1 = System.getProperty("user.dir");
	private String path3 = "/src/Images/"; 
	private BufferedImage map;
	private BufferedImage tilesImg[] = new BufferedImage[]{null, null, null, null, null, null};
	private BufferedImage players;
	private BufferedImage player[][] = new BufferedImage[12][8];
	private JLabel playerSprite[] = new JLabel[5]; 
	private JButton startButton;
	private ArrayList<String> movements;

	public MapPanel() {
		super();
		
		this.getImages();
		new MapPanelController();
		playerSprite[0] = new JLabel();

		this.add(playerSprite[0]);

		playerSprite[0].setVisible(true);
		playerSprite[0].addKeyListener(this);

		this.setFocusable(true);
		this.requestFocus();

		this.setPreferredSize(new Dimension(Constants.ScreenWidth(), Constants.ScreenHeight()));

		x = (int) MapPanelController.getStart().getX()*Constants.squareSize;
		y = (int) MapPanelController.getStart().getY()*Constants.squareSize;

		startButton = new JButton("Start");
		startButton.setVisible(true);
		startButton.addMouseListener(this);
		this.add(startButton);

		movements = new ArrayList<String>();
		movements.add("left");
		movements.add("left");
		movements.add("up");
		movements.add("left");
		movements.add("down");
		movements.add("left");
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		for(int i=0;i<42;i++){
			for(int k=0;k<42;k++){
				g.drawImage(tilesImg[MapPanelController.getIndexOfImage(i, k)], Constants.squareSize*k, Constants.squareSize*i, Constants.squareSize, Constants.squareSize, null);
			}
		}
		
		playerSprite[0].setBounds(x, y, Constants.squareSize, Constants.squareSize);
		startButton.setBounds(Constants.squareSize*Constants.mapSide, Constants.squareSize*Constants.mapSide-30, 80, 30);

		g.finalize();
	}

	private void getImages(){
		if(map==null){
			try {
				map = ImageIO.read(new File(path1 + path3 + "terrains.png"));
				players = ImageIO.read(new File(path1 + path3 + "characters.png"));
			} catch (IOException e) {
				System.out.println(path1 + path3);
			}
		}

		tilesImg[0] = this.cropImage(map, new Rectangle(8*70, 21*70, 70, 70));
		tilesImg[1] = this.cropImage(map, new Rectangle(2*70, 2*70, 70, 70));
		tilesImg[2] = this.cropImage(map, new Rectangle(22*70, 22*70, 70, 70));
		tilesImg[3] = this.cropImage(map, new Rectangle(3*70, 31*70, 70, 70));
		tilesImg[4] = this.cropImage(map, new Rectangle(13*70, 26*70, 70, 70));	
		tilesImg[5] = this.cropImage(map, new Rectangle(3*70, 25*70, 70, 70));

		for(int i=0;i<12;i++){
			for(int j=0;j<8;j++){
				player[i][j] = this.cropImage(players, new Rectangle(i*32, j*32, 32, 32));
			}
		}
	}

	public BufferedImage cropImage(BufferedImage src, Rectangle rect) {
		BufferedImage dest = src.getSubimage(rect.x, rect.y, rect.width, rect.height);

		return dest; 
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int code = e.getKeyCode();
		System.out.println("A key was typed");

		x = playerSprite[0].getBounds().x;
		y = playerSprite[0].getBounds().y;

		if (code == KeyEvent.VK_DOWN) {
			this.walkDown(0);
		}
		if (code == KeyEvent.VK_UP) {
			this.walkUp(0);
		}
		if (code == KeyEvent.VK_LEFT) {
			this.walkLeft(0);
		}
		if (code == KeyEvent.VK_RIGHT) {
			this.walkRight(0);
		}

	}

	private void walkRight(int index){
		for(int i=1;i<4;i++){
			playerSprite[index].setIcon(new ImageIcon(Scalr.resize(player[0+i-1][2], Constants.squareSize, (BufferedImageOp[])null)));
			x += (Constants.squareSize/3);
			
			this.move(index);
		}
	}

	private void walkLeft(int index){
		for(int i=1;i<4;i++){
			playerSprite[index].setIcon(new ImageIcon(Scalr.resize(player[0+i-1][1], Constants.squareSize, (BufferedImageOp[])null)));
			x -= (Constants.squareSize/3);
			
			this.move(index);
		}
	}

	private void walkUp(int index){
		for(int i=1;i<4;i++){
			playerSprite[index].setIcon(new ImageIcon(Scalr.resize(player[0+i-1][3], Constants.squareSize, (BufferedImageOp[])null)));
			y -= (Constants.squareSize/3);
			
			this.move(index);
		}
	}
	
	private void walkDown(int index){
		for(int i=1;i<4;i++){
			playerSprite[index].setIcon(new ImageIcon(Scalr.resize(player[0+i-1][0], Constants.squareSize, (BufferedImageOp[])null)));
			y += (Constants.squareSize/3);
			
			this.move(index);
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getSource() == startButton){
			ListIterator<String> ls = movements.listIterator();

			while(ls.hasNext()){
				String aux = ls.next();

				if(aux == "right"){
					this.walkRight(0);
				}
				if(aux == "left"){
					this.walkLeft(0);
				}
				if(aux == "up"){
					this.walkUp(0);
				}
				if(aux == "down"){
					this.walkDown(0);
				}
			}
		}

	}
	
	private void move(int index){
		playerSprite[index].setLocation(x, y);
		this.paintImmediately(new Rectangle(playerSprite[index].getBounds().x - playerSprite[index].getBounds().width, playerSprite[index].getBounds().y - playerSprite[index].getBounds().height, playerSprite[index].getBounds().width*3, playerSprite[index].getBounds().height*3));

		try {
			Thread.sleep(100);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
	}
}
