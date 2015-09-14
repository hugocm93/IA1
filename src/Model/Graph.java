package Model;

import java.awt.Point;

public class Graph {
	private Point self;
	private Graph north;
	private Graph south;
	private Graph lest;
	private Graph west;
	private int cost;
	
	
	public Graph(int cost, Point self) {
		super();
		this.cost = cost;
		this.self = self;
	}
	public Point getSelf() {
		return self;
	}
	public void setSelf(Point self) {
		this.self = self;
	}
	public Graph getNorth() {
		return north;
	}
	public void setNorth(Graph north) {
		this.north = north;
	}
	public Graph getSouth() {
		return south;
	}
	public void setSouth(Graph south) {
		this.south = south;
	}
	public Graph getLest() {
		return lest;
	}
	public void setLest(Graph lest) {
		this.lest = lest;
	}
	public Graph getWest() {
		return west;
	}
	public void setWest(Graph west) {
		this.west = west;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	
	
	

}