package proyecto_github;

import java.time.LocalDate;

public class Pelicula extends Evento {

	public Pelicula(String nombre, LocalDate fecha, double precioEntrada, Categoria categoria) {
		super(nombre, fecha, precioEntrada, categoria);
	}

	@Override
	public void obtenerDescripcion() {
		System.out.println("Pelicula: " + toString());
	}

}
