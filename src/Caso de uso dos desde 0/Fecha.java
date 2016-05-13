public class Fecha {

	private int hora, dia, mes, año;

	public Fecha(int hora, int dia, int mes, int año) {
		this.dia = dia;
		this.hora = hora;
		this.mes = mes;
		this.año = año;
	}

	public String toString() {
		return dia + ":" + mes + ":" + año;
	}

}
