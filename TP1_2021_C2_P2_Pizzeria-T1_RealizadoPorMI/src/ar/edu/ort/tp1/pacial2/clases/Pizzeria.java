package ar.edu.ort.tp1.pacial2.clases;

import ar.edu.ort.tp1.tdas.implementaciones.ColaNodos;
import ar.edu.ort.tp1.tdas.interfaces.Cola;
import ar.edu.ort.tp1.tdas.interfaces.ListaOrdenada;

public class Pizzeria implements Mostrable {

	private static final String MSG_PIZZA_TOPPINGS_NULO = "No se pudo fabricar Pizza o Topping nulo.";
	private static final String MSG_TOPPINGS = "Error de parámetros incorporando toppings";
	private static final String MSG_TOTALES = "La venta total fue: $%8.2f\n";
	private static final String MSG_CANTIDADES = "Se han fabricado: %d Tradicionales, %d Especiales y %d Rectangulares\n";

	private ListaOrdenada<Float, Pizza> pizzasFabricadas;
	private Cola<String> pedidosConError;
	private String nombre;
	private int[][] toppings;

	private int tradicionales;
	private int especiales;
	private int rectangulares;
	private float total;;

	public Pizzeria(String nombre) {
		this.nombre = nombre;
		this.pizzasFabricadas = new ListaOrdenadaPizzasXPrecio();
		this.toppings = new int[Topping.values().length][TipoPizza.values().length];
		this.pedidosConError = new ColaNodos<>();
	}

	public void incorporarTopping(TipoPizza tipoPizza, Topping topping, int cantidad) {
		if (topping == null || tipoPizza == null || cantidad < 1) {
			throw new RuntimeException(MSG_TOPPINGS);
		}
		this.toppings[topping.ordinal()][tipoPizza.ordinal()]+= cantidad;
	}

	public void ingresarPedido(Pizza p, Topping topping) {
		if (topping == null || p == null) {
			pedidosConError.add(MSG_PIZZA_TOPPINGS_NULO);
			throw new RuntimeException(MSG_PIZZA_TOPPINGS_NULO);
		}
		if (!stockTopping(p.tipo(), topping)) {
			String msg = "no se pudo fabricar " + p.getNombre() + " por falta del topping " + topping.getNombre();
			pedidosConError.add(msg);
			throw new RuntimeException(msg);
		}
		if (p instanceof Tradicional) {
			tradicionales++;
		} else if (p instanceof Especial) {
			especiales++;
		} else if (p instanceof Rectangular) {
			rectangulares++;
		}
		total += p.getPrecioDeVenta();
		pizzasFabricadas.add(p);
		ajustarStockToppings(p.tipo(), topping);

	}

	private void ajustarStockToppings(TipoPizza tipo, Topping topping) {
		this.toppings[topping.ordinal()][tipo.ordinal()]--;
	}

	private boolean stockTopping(TipoPizza tipo, Topping topping) {
		// TODO Auto-generated method stub
		return this.toppings[topping.ordinal()][tipo.ordinal()] > 0;
	}

	@Override
	public void mostrar() {
		System.out.println(this.nombre);
		System.out.println("Pizzas Tradicionales :" + tradicionales + " unidades");
		System.out.println("Pizzas Especiales :" + especiales + " unidades");
		System.out.println("Pizzas Rectangulares :" + rectangulares + " unidades");
		System.out.println("Venta total de : $" + total);
		mostrarPizzasPorPrecio();
		mostrarErrores();

	}

	private void mostrarErrores() {
		String cent = null;
		pedidosConError.add(cent);
		String m = pedidosConError.remove();
		while (m != cent) {
			System.out.println(m);
			this.pedidosConError.add(m);
			m = this.pedidosConError.remove();
		}

	}

	private void mostrarPizzasPorPrecio() {
		System.out.println("Pizzas fabricadas por precio");
		for (Pizza pizza : pizzasFabricadas) {
			pizza.mostrar();
		}
	}

	public int vendidasConPrecioEntre(float min, float max) {
		int i = 0;
		int cant = 0;
		while (i < pizzasFabricadas.size() && pizzasFabricadas.get(i).getPrecioDeVenta() < max) {
			if(pizzasFabricadas.get(i).getPrecioDeVenta()>=min) {
			cant++;}
			i++;
		}
		return cant;
	}

}
