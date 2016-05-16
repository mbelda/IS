package model;

public class Laboratorio {
	
	private String id;
	private int capacidad;
	private Pair<Fecha, Boolean> pair;
	
	public Laboratorio(String id, int capacidad,final Pair<Fecha, Boolean> par){
		this.id = id;
		this.capacidad = capacidad;
		this.pair = par;
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

	//Vamos a hacer 3 combo box -> Uno para labs, otro para días y otro para horas


