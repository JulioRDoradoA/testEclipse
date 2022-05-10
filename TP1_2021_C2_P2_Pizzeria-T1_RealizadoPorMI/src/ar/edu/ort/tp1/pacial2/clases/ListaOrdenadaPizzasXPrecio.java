package ar.edu.ort.tp1.pacial2.clases;

import ar.edu.ort.tp1.tdas.implementaciones.ListaOrdenadaNodos;

public class ListaOrdenadaPizzasXPrecio extends ListaOrdenadaNodos<Float, Pizza> {

	@Override
	public int compare(Pizza dato1, Pizza dato2) {
		// TODO Auto-generated method stub
		return Float.valueOf(dato1.getPrecioDeVenta()).compareTo(Float.valueOf(dato2.getPrecioDeVenta()));
	}

	@Override
	public int compareByKey(Float clave, Pizza elemento) {
		// TODO Auto-generated method stub
		return clave.compareTo(Float.valueOf(elemento.getPrecioDeVenta()));
	}

}
