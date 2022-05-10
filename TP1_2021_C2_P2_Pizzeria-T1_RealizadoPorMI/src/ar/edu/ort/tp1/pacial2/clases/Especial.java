package ar.edu.ort.tp1.pacial2.clases;

public class Especial extends Pizza {

	private static final float PRECIOFAINA = 70;

	private TamanioDePizza size;
	private int faina;

	public Especial(String nombre, float costoDeProduccion, float porcentajeGanancia, TamanioDePizza size, int faina) {
		super(nombre, costoDeProduccion, porcentajeGanancia);
		setSize(size);
		setFaina(faina);
		this.size = size;
		this.faina = faina;
	}

	private TamanioDePizza getSize() {
		return size;
	}

	private void setSize(TamanioDePizza size) {
		this.size = size;
	}

	private int getFaina() {
		return faina;
	}

	private void setFaina(int faina) {
		this.faina = faina;
	}

	@Override
	public void mostrar() {
		System.out.println(getClass().getSimpleName() + " - " + this.getNombre() + " - " + this.getPrecioDeVenta()
				+ " - " + this.faina + " - " + size.getDescripcion());
	}

	@Override
	public float getPrecioDeCosto() {
		// TODO Auto-generated method stub
		return (getCostoDeProduccion() * this.size.getPorcentaje()) + (PRECIOFAINA * faina);
	}

	@Override
	public TipoPizza tipo() {
		// TODO Auto-generated method stub
		return TipoPizza.ESPECIAL;
	}

}
