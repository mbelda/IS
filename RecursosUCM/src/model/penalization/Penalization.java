package model.penalization;

import model.material.Fecha;

public class Penalization {

	private Fecha fechaFin;
	private String details, cause;

	public Penalization(Fecha f, String details, String cause) {
		this.fechaFin = f;
		this.details = details;
		this.cause = cause;
	}

	public Fecha getFecha() {
		return this.fechaFin;
	}

	public String getPenalizationDetails() {
		return this.details;
	}

	public String getPenalizationCause() {
		return this.cause;
	}

}
