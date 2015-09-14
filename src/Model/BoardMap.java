package Model;

import java.awt.Point;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Scanner;

import Controller.Constants;

public class BoardMap {

	private String path1 = System.getProperty("user.dir");
	private String path2 = "/src/DataSource/";
	private Scanner in;
	private int matrix[][] = new int[Constants.mapSide][Constants.mapSide];
	private Point start, end ;

	private HashMap<Point, Graph> graphMap;


	public BoardMap(){

		graphMap = new HashMap<Point, Graph>();

		try {
			in = new Scanner(new FileReader(path1 + path2 + "Map.txt"));

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		for(int i=0;i<Constants.mapSide;i++){
			for(int j=0;j<Constants.mapSide;j++){
				matrix[i][j] = in.nextInt();

				if(matrix[i][j] == 5){
					start = new Point(i,j);
				}
				if(matrix[i][j] == 4){
					end = new Point(i,j);
				}
				if(matrix[i][j]==0){
					graphMap.put(new Point(i, j), new Graph(200,new Point(i,j)));
				}
				if(matrix[i][j]==1){
					graphMap.put(new Point(i, j), new Graph(1,new Point(i,j)));
				}
				if(matrix[i][j]==2){
					graphMap.put(new Point(i, j), new Graph(5, new Point(i,j)));
				}
				if(matrix[i][j]==3 || matrix[i][j]==4 || matrix[i][j]==5){
					graphMap.put(new Point(i, j), new Graph(0, new Point(i,j)));
				}

			}
		}

		this.connectGraph();
		//this.printMap();


	}

	private void connectGraph() {

		for(int i=0;i<Constants.mapSide;i++){
			for(int j=0;j<Constants.mapSide;j++){
				Graph aux = graphMap.get(new Point(i,j));

				aux.setNorth(graphMap.get(new Point(i-1,j)));
				aux.setSouth(graphMap.get(new Point(i+1,j)));
				aux.setLest(graphMap.get(new Point(i,j+1)));
				aux.setWest(graphMap.get(new Point(i,j-1)));
			}
		}

	}

	public int[][] getMatrix() {
		return matrix;
	}	
	public Point getStart(){
		return start;
	}

	public void printMap(){
		Graph aux = graphMap.get(new Point(0,0));

		Graph nextl = aux.getLest();

		while(nextl.getSouth()!=null){
			while(nextl.getLest()!=null){
				System.out.printf("%d ",nextl.getCost());
				nextl = nextl.getLest();

			}
			System.out.println();
			nextl = nextl.getSouth();
			while(nextl.getWest()!=null){
				nextl = nextl.getWest();
			}
		}

	}
}
