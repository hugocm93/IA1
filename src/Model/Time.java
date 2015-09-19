package Model;

import java.util.ArrayList;

public class Time {
	
	private float elapsedTime;
	private ArrayList<Integer> costs = new ArrayList<Integer>();
	
	public ArrayList<Integer> getCosts() {
		return costs;
	}

	public void setCosts(ArrayList<Integer> costs) {
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
