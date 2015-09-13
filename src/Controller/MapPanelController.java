package Controller;

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

}
