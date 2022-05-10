package ar.edu.ort.tp1.pacial2.clases;

public class Tradicional extends Pizza {

	private TipoDeMasa tipo;

	public Tradicional(String nombre, float costoDeProduccion, float porcentajeGanancia, TipoDeMasa tipo) {
		super(nombre, costoDeProduccion, porcentajeGanancia);
		this.tipo = tipo;
	}

	@Override
	public void mostrar() {
		System.out.println(getClass().getSimpleName() +" - "+ this.getNombre()  +" - "+ this.getPrecioDeVenta());
	}

	@Override
	public float getPrecioDeCosto() {
		// TODO Auto-generated method stub
		return getCostoDeProduccion() * this.tipo.getPorcentaje();
	}

	@Override
	public TipoPizza tipo() {
		// TODO Auto-generated method stub
		return TipoPizza.TRADICIONAL;
	}

}
