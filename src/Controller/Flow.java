package Controller;

import javax.swing.JFrame;

import Interface.MapPanel;
import Interface.Scroll;

public class Flow {
	
	public static  JFrame window;
	public static  MapPanel mapPanel;
	
	public static void createWindow(){
		mapPanel = new MapPanel();
		window = new Scroll(mapPanel, "Zodiac Knights");
		
		Flow.goToMapPanel();
	}

	public static void goToMapPanel(){
		mapPanel.setVisible(true);
		mapPanel.addKeyListener(mapPanel);
		mapPanel.addMouseListener(mapPanel);
		window.setSize(Constants.widthDefault, Constants.heightDefault);
		window.addKeyListener(mapPanel);
	}
}
