package Controller;

public class Constants {
	
	static public int squareSize = 17;
	static public int sideArea = 310;
	static public int bottomArea = 23;
	static public int mapSide = 42;
	
	static int ScreenWidth(){
		return squareSize*mapSide + sideArea;
	}
	
	static int ScreenHeight(){
		return squareSize*mapSide + bottomArea;
	}

}
