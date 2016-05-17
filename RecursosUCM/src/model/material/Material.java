package model.material;

public class Material {
	private String id;
	private boolean borrowed;

	public Material(String id) {
		this.id = id;
		this.borrowed = false;
	}

	public String getId() {
		return id;
	}

	public boolean isBorrowed() {
		return borrowed;
	}

	public void setBorrowed(boolean borrowed) {
		this.borrowed = borrowed;
	}
	
	public String toString(){
		return id;
	}
}
