package proyecto_github;

import java.time.LocalDate;

public class Concierto extends Evento{

	public Concierto(String nombre, LocalDate fecha, double precioEntrada, Categoria categoria) {
		super(nombre, fecha, precioEntrada, categoria);
	}

	@Override
	public void obtenerDescripcion() {
		System.out.println("Concierto: " + toString());
	}

}
