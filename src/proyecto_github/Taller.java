package proyecto_github;

import java.time.LocalDate;

public class Taller extends Evento{

	public Taller(String nombre, LocalDate fecha, double precioEntrada, Categoria categoria) {
		super(nombre, fecha, precioEntrada, categoria);
	}

	@Override
	public void obtenerDescripcion() {
		System.out.println("Taller: " + toString());
	}

}
