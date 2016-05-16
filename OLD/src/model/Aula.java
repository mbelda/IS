package model;

public class Aula {
	private String id;
	private int capacidad;
	private Pair<Fecha, Boolean> pair;
	
	public Aula(String id, int capacidad, final Pair<Fecha, Boolean> pair){
		this.id = id;
		this.capacidad = capacidad;
		this.pair = pair;
	}
	
	public String getId(){
		return id;
	}
	
	public int getCapacidad(){
		return capacidad;
	}
	
	public Pair<Fecha, Boolean> getPair(){
		return pair;
	}


}

