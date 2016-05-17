package model.material;

import java.util.HashMap;

public class Laboratory {
	private String id;
	private int capacidad;
	private HashMap<Fecha, Boolean> map;
	
	public Laboratory(String id, int capacidad,final HashMap<Fecha, Boolean> map){
		this.id = id;
		this.capacidad = capacidad;
		this.map = map;
	}
	
	public String getId(){
		return id;
	}
	
	public int getCapacidad(){
		return capacidad;
	}
	
	public HashMap<Fecha, Boolean> getPair(){
		return map;
	}
	
	public boolean reservado(Fecha fecha){
		return map.get(fecha);
	}
	
	public void reservar(Fecha fecha){
		map.put(fecha, true);
	}
}
