package Model;

import java.util.ArrayList;

public class Time {
	
	private float elapsedTime;
	private ArrayList<Float> costs = new ArrayList<Float>();
	
	public ArrayList<Float> getCosts() {
		return costs;
	}

	public void setCosts(ArrayList<Float> costs) {
		this.costs = costs;
	}

	public Time(float elapsedTime, float timeRemaining) {
		super();
		this.elapsedTime = elapsedTime;
	}

	public float getElapsedTime() {
		return elapsedTime;
	}

	public void setElapsedTime(float elapsedTime) {
		this.elapsedTime = elapsedTime;
	}
}
