package Model;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

import Controller.Constants;

public class BoardMap {

	private String path1 = System.getProperty("user.dir");
	private String path2 = "/src/DataSource/";
	private Scanner in;
	private int matrix[][] = new int[Constants.mapSide][Constants.mapSide];
	

	public BoardMap(){
		
		try {
			 in = new Scanner(new FileReader(path1 + path2 + "Map.txt"));
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(int i=0;i<Constants.mapSide;i++){
			for(int j=0;j<Constants.mapSide;j++){
				matrix[i][j] = in.nextInt();
			}
		}
		
	}

	public int[][] getMatrix() {
		return matrix;
	}	
}
