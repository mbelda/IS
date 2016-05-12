package model;

import java.util.*;

public class Laboratorio {
	
	private String id;
	private int capacidad;
	private HashMap<Fecha, Boolean> mapa;
	
	public Laboratorio(String id, int capacidad, HashMap<Fecha, Boolean> mapa){
		this.id = id;
		this.capacidad = capacidad;
		this.mapa = mapa;
	}
	
	public String getId(){
		return id;
	}
	
	public int getCapacidad(){
		return capacidad;
	}
	
	public HashMap<Fecha, Boolean> getMapa(){
		return mapa;
	}

}

//Vamos a hacer 3 combo box -> Uno para labs, otro para días y otro para horas
