public class Fecha {

	private int hora, dia, mes, a�o;

	public Fecha(int hora, int dia, int mes, int a�o) {
		this.dia = dia;
		this.hora = hora;
		this.mes = mes;
		this.a�o = a�o;
	}

	public String toString() {
		return dia + ":" + mes + ":" + a�o;
	}

}
