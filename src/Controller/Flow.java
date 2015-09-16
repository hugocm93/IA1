package Controller;

import javax.swing.JFrame;

import Interface.MapPanel;
import Interface.Scroll;

public class Flow {
	
	public static  Scroll window;
	public static  MapPanel mapPanel;
	
	public static void createWindow(){
		mapPanel = new MapPanel();
		
		window = new Scroll(mapPanel, "Zodiac Knights");
		window.setVisible(true);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//window.setResizable(false);
		
		Flow.goToMapPanel();
	}

	public static void goToMapPanel(){
		mapPanel.setVisible(true);
		mapPanel.addKeyListener(mapPanel);
		mapPanel.addMouseListener(mapPanel);
		
		window.setSize(Constants.widthDefault, Constants.heightDefault);
		window.addKeyListener(mapPanel);
	}
	
	public static void scrollUp(){
		window.getScroll().getVerticalScrollBar().setValue(window.getScroll().getVerticalScrollBar().getMinimum());
		window.getScroll().getVerticalScrollBar().setValue(window.getScroll().getVerticalScrollBar().getMinimum());
	}
}
