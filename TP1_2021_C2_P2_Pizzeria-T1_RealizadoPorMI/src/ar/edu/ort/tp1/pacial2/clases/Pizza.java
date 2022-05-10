package ar.edu.ort.tp1.pacial2.clases;

public abstract class Pizza implements Mostrable {

	private static final String MSG_GANANCIA_INVALIDA = "Ganancia inválida";
	private static final String MSG_COSTO_INVALIDO = "Costo inválido";
	private static final String MSG_NOMBRE_INVALIDO = "Nombre inválido";

	private String nombre;
	private float costoDeProduccion;
	private float porcentajeGanancia;

	// TODO A completar

	public Pizza(String nombre, float costoDeProduccion, float porcentajeGanancia) {
		setNombre(nombre);
		setCostoDeProduccion(costoDeProduccion);
		setPorcentajeGanancia(porcentajeGanancia);
	}

	private void setNombre(String nombre) {
		if (nombre.isBlank() || nombre == null) {
			throw new RuntimeException(MSG_NOMBRE_INVALIDO);
		}
		this.nombre = nombre;
	}

	private void setCostoDeProduccion(float costoDeProduccion) {
		if (costoDeProduccion <= 0) {
			throw new RuntimeException(MSG_COSTO_INVALIDO);
		}
		this.costoDeProduccion = costoDeProduccion;
	}

	private void setPorcentajeGanancia(float porcentajeGanancia) {
		if (porcentajeGanancia < 0) {
			throw new RuntimeException(MSG_GANANCIA_INVALIDA);
		}
		this.porcentajeGanancia = porcentajeGanancia;
	}

	public abstract float getPrecioDeCosto();

	public float getPrecioDeVenta() {
		float costo = this.getPrecioDeCosto();
		return costo + (this.porcentajeGanancia * costo / 100);
	}

	protected float getCostoDeProduccion() {
		return costoDeProduccion;
	}

	protected String getNombre() {
		return nombre;
	}

	protected float getPorcentajeGanancia() {
		return porcentajeGanancia;
	}

	public abstract TipoPizza tipo();
}
