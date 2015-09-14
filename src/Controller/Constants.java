package Controller;

public class Constants {
	
	static public int squareSize = 24;
	static public int sideArea = 310;
	static public int bottomArea = 35;
	static public int mapSide = 42;
	static public int widthDefault = 1024;
	static public int heightDefault = 768;
	
	public static int ScreenWidth(){
		return squareSize*mapSide + sideArea;
	}
	
	public static int ScreenHeight(){
		return squareSize*mapSide + bottomArea;
	}

}
