package Controller;

import java.awt.Point;

import Model.BoardMap;

public class MapPanelController {
	
	private static BoardMap boardMap;
	
	public MapPanelController() {
		super();
		
		boardMap = new BoardMap();
	}

	public static int getIndexOfImage(int i, int j){
		return boardMap.getMatrix()[i][j];
	}
	
	public static Point getStart(){
		return boardMap.getStart();
	}

}
