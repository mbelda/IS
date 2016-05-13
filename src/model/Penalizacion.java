package model;

public class Penalizacion {

	private Fecha fin;
	private String detalles;
	private String causa;

	public Penalizacion(Fecha fecha, String detalles, String causa) {
		this.fin = fecha;
		this.detalles = detalles;
		this.causa = causa;
	}

	public Fecha getFin() {
		return this.fin;
	}

	public String getDetalles() {
		return this.detalles;
	}

	public String getCausa() {
		return this.causa;
	}
}
