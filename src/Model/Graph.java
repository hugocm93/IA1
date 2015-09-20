package Model;

import java.awt.Point;

public class Graph {
	private Point self;
	private Graph north;
	private Graph south;
	private Graph lest;
	private Graph west;
	private float cost;
	private float f,g,h;
	private Graph parent;
	private int numberOfSteps;
	
	public Graph(float cost, Point self) {
		super();
		this.cost = cost;
		this.self = self;
	}
	
	public int getNumberOfSteps() {
		return numberOfSteps;
	}

	public void setNumberOfSteps(int numberOfSteps) {
		this.numberOfSteps = numberOfSteps;
	}

	public float getF() {
		f = g + h;
		return f;
	}

	public void setF(float f) {
		this.f = f;
	}

	public float getG() {
		return g;
	}

	public void setG(float g) {
		this.g = g;
	}

	public float getH() {
		return h;
	}

	public void setH(float h) {
		this.h = h;
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
	public float getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}

	public Graph getParent() {
		return parent;
	}

	public void setParent(Graph parent) {
		this.parent = parent;
	}
	
}
