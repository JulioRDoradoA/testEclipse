package ar.edu.ort.tp1.pacial2.clases;

public class Rectangular extends Pizza {

	private static final float PRECIO_POR_PORCION = 45;

	private long largo;
	private long ancho;
	private AdicionalQueso adicionalQueso;

	public Rectangular(String nombre, float costoDeProduccion, float porcentajeGanancia, long largo, long ancho,
			AdicionalQueso adicional) {
		super(nombre, costoDeProduccion, porcentajeGanancia);
		this.largo = largo;
		this.ancho = ancho;
		this.adicionalQueso = adicional;
	}

	@Override
	public void mostrar() {
		System.out.println(getClass().getSimpleName() + " - " + this.getNombre() + " - " + getPrecioDeVenta() + " - "
				+ this.largo * this.ancho + " - " + adicionalQueso.getDescripcion());

	}

	@Override
	public float getPrecioDeCosto() {
		// TODO Auto-generated method stub
		float costo;
		costo = (super.getCostoDeProduccion() + (PRECIO_POR_PORCION * this.largo * this.ancho));
		costo = costo * adicionalQueso.getMultiplicadorQueso();
		return costo;
	}

	@Override
	public TipoPizza tipo() {
		// TODO Auto-generated method stub
		return TipoPizza.RECTANGULAR;
	}

}
