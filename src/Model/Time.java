package Model;

public class Time {
	
	private float elapsedTime;
	private float timeRemaining;
	
	public Time(float elapsedTime, float timeRemaining) {
		super();
		this.elapsedTime = elapsedTime;
		this.timeRemaining = timeRemaining;
	}

	public float getElapsedTime() {
		return elapsedTime;
	}

	public void setElapsedTime(float elapsedTime) {
		this.elapsedTime = elapsedTime;
	}

	public float getTimeRemaining() {
		return timeRemaining;
	}

	public void setTimeRemaining(float timeRemaining) {
		this.timeRemaining = timeRemaining;
	}
}
