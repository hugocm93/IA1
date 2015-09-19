package Model;

import java.awt.Point;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Scanner;
import Controller.Constants;

public class BoardMap {

	private int matrix[][] = new int[Constants.mapSide][Constants.mapSide];
	private String path1 = System.getProperty("user.dir");
	private String path2 = "/src/DataSource/";
	private Scanner in, in2;
	private Point start, end ;
	private HashMap<Point, Graph> graphMap;
	private Time time = new Time(0, 12*60);

	public BoardMap(){

		graphMap = new HashMap<Point, Graph>();

		try {
			in = new Scanner(new FileReader(path1 + path2 + "Map.txt"));
			in2 = new Scanner(new FileReader(path1 + path2 + "Terrains.txt"));

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		in2.next("Rock");
		int rock = in2.nextInt();
		in2.next("Plain");
		int plain = in2.nextInt();
		in2.next("Mountain");
		int mountain = in2.nextInt();

		for(int j=0;j<Constants.mapSide;j++)
			for(int i=0;i<Constants.mapSide;i++){
				{
					matrix[i][j] = in.nextInt();

					if(matrix[i][j] == 5){
						start = new Point(i,j);
					}
					if(matrix[i][j] == 4){
						end = new Point(i,j);
					}
					if(matrix[i][j]==0){
						graphMap.put(new Point(i, j), new Graph(mountain,new Point(i,j)));
					}
					if(matrix[i][j]==1){
						graphMap.put(new Point(i, j), new Graph(plain,new Point(i,j)));
					}
					if(matrix[i][j]==2){
						graphMap.put(new Point(i, j), new Graph(rock, new Point(i,j)));
					}
					if(matrix[i][j]==3 || matrix[i][j]==4 || matrix[i][j]==5){
						graphMap.put(new Point(i, j), new Graph(1, new Point(i,j)));
					}
				}
			}
	}


	public int[][] getMatrix() {
		return matrix;
	}	

	public Point getStart(){
		return start;
	}

	public Point getEnd() {
		return end;
	}

	public void setEnd(Point end) {
		this.end = end;
	}


	public String getPath1() {
		return path1;
	}


	public void setPath1(String path1) {
		this.path1 = path1;
	}


	public String getPath2() {
		return path2;
	}


	public void setPath2(String path2) {
		this.path2 = path2;
	}


	public Scanner getIn() {
		return in;
	}


	public void setIn(Scanner in) {
		this.in = in;
	}


	public Scanner getIn2() {
		return in2;
	}


	public void setIn2(Scanner in2) {
		this.in2 = in2;
	}


	public HashMap<Point, Graph> getGraphMap() {
		return graphMap;
	}


	public void setGraphMap(HashMap<Point, Graph> graphMap) {
		this.graphMap = graphMap;
	}


	public void setMatrix(int[][] matrix) {
		this.matrix = matrix;
	}


	public void setStart(Point start) {
		this.start = start;
	}


	public Time getTime() {
		return time;
	}


	public void setTime(Time time) {
		this.time = time;
	}
	
	

	
}
