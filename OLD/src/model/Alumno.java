package model;

import java.util.List;

public class Alumno extends Usuario {

	private Penalizacion penalizacion;
	private List<Objeto> prestamos;

	public Alumno(String id) {
		super(id, false);
		this.penalizacion = null;
	}

	@Override
	public void penalizar(Alumno usuario, Penalizacion penalizacion) {
		throw new UnsupportedOperationException();
	}

	public void setPenalizacion(Penalizacion penalizacion) {
		this.penalizacion = penalizacion;
	}

	public Fecha getEndPenalizacion() {
		return this.penalizacion.getFin();
	}
	
	public boolean tienePrestamos(){
		/*igual es mejor idea codificarlo con un null, ya se verá.*/
		return this.prestamos.size() == 0;
	}
}
