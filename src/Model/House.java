package Model;

public class House {
	Float knights[];
	Integer battling[];
	Integer difficulty;
	Integer cost;
	
	
	public House(int difficulty) {
		super();
		this.difficulty = difficulty;
		
		knights = new Float[]{new Float(0),new Float(0),new Float(0),new Float(0),new Float(0)};
		battling = new Integer[]{new Integer(0),new Integer(0),new Integer(0),new Integer(0),new Integer(0)};
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
	public int getCost() {
		int aux = 0;
		for(int i = 0; i<5 ; i++){
			aux += knights[i].intValue()*battling[i].intValue();
		}
		cost = new Integer(aux);
		return cost;
	}

	public void setBattling(Integer[] battling) {
		this.battling = battling;
	}

	
}
