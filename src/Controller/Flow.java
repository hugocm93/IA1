package Controller;

import javax.swing.JFrame;

import Interface.MapPanel;

public class Flow {
	
	public static  JFrame window;
	public static  MapPanel mapPanel;
	

	public static void createWindow(){

		window = new JFrame("Zodiac Knights");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE );
		window.setVisible(true);
		window.setResizable(false);

		Flow.createMapPanel();
		Flow.goToMapPanel();
	}
	
	public static void createMapPanel(){
		mapPanel = new MapPanel();

	}

	public static void goToMapPanel(){
		
		window.add(mapPanel);
		mapPanel.setVisible(true);
		window.setSize(1024,750);
		
	}
}
