package Model;

public class noArv {

	private noArv parent;
	private noArv offsprings[];
	private int f,g,h;
	private Graph self;

	public noArv(noArv parent, Graph start, Graph end, Graph current){
		this.parent = parent;
		this.self = current;
		this.offsprings  = new noArv[4];
		this.g = this.calcG(start, current);
		this.h = this.calcH(end, current);
		this.f = g + h;
	}

	public noArv(Graph start, Graph end) {
		super();
		this.parent = null;
		this.self = start;
		this.offsprings  = new noArv[4];
		this.g = 0;
		this.h = this.calcH(end, start);
		this.f = g + h;
	}
	
	public noArv getParent() {
		return parent;
	}

	public void setParent(noArv parent) {
		this.parent = parent;
	}

	public noArv[] getOffsprings() {
		return offsprings;
	}

	public void setOffsprings(noArv[] offsprings) {
		this.offsprings = offsprings;
	}

	public int getF() {
		return f;
	}

	public void setF(int f) {
		this.f = f;
	}

	public int getG() {
		return g;
	}

	public void setG(int g) {
		this.g = g;
	}

	public int getH() {
		return h;
	}

	public void setH(int h) {
		this.h = h;
	}

	public Graph getSelf() {
		return self;
	}

	public void setSelf(Graph self) {
		this.self = self;
	}

	private int calcH(Graph end, Graph current) {
		// TODO Auto-generated method stub
		return 0;
	}

	private int calcG(Graph start, Graph current) {
		// TODO Auto-generated method stub
		return 0;
	}



}
