package Model;

public class Knight {
	
	private String name;
	private float cosmicPower; 
	private int energyPoints;
	
	
	public Knight(String name, float cosmicPower, int energyPoints) {
		super();
		this.name = name;
		this.cosmicPower = cosmicPower;
		this.energyPoints = energyPoints;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getCosmicPower() {
		return cosmicPower;
	}
	public void setCosmicPower(float cosmicPower) {
		this.cosmicPower = cosmicPower;
	}
	public int getEnergyPoints() {
		return energyPoints;
	}
	public void setEnergyPoints(int energyPoints) {
		this.energyPoints = energyPoints;
	}
	
	

}
