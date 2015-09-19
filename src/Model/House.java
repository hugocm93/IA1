package Model;

public class House {
	Float knights[];
	Integer battling[];
	Integer difficulty;
	Float cost;
	
	
	public House(int difficulty) {
		super();
		this.difficulty = difficulty;
		
		knights = new Float[]{new Float(0),new Float(0),new Float(0),new Float(0),new Float(0)};
		battling = new Integer[]{new Integer(0),new Integer(0),new Integer(0),new Integer(0),new Integer(0)};
	}

	public House cloneH() {
		House clone = new House(new Integer(this.difficulty.intValue()));
		
		clone.setKnights(new Float[5]);
		for(int i=0;i<5;i++){
			clone.getKnights()[i] = new Float(this.getKnights()[i].floatValue());
		}
		
		clone.setBattling(new Integer[5]);
		for(int i=0;i<5;i++){
			clone.getBattling()[i] = new Integer(this.getBattling()[i].intValue());
		}
		return clone;
	}
	
	public void setDifficulty(Integer difficulty) {
		this.difficulty = difficulty;
	}

	public void setCost(Float cost) {
		this.cost = cost;
	}

	public Float[] getKnights() {
		return knights;
	}


	public void setKnights(Float[] knights) {
		this.knights = knights;
	}


	public Integer[] getBattling() {
		return battling;
	}

	public int getDifficulty() {
		return difficulty;
	}
	public void setDifficulty(int difficulty) {
		this.difficulty = difficulty;
	}
	public float getCost() {
		float aux = 0;
		for(int i = 0; i<5 ; i++){
			aux += knights[i].floatValue()*battling[i].intValue();
		}
		cost = new Float(this.difficulty/aux);
		return cost.floatValue();
	}

	public void setBattling(Integer[] battling) {
		this.battling = battling;
	}

	
}
