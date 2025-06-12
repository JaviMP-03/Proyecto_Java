package proyecto_github;

import java.util.List;

public class Programa {

	public static void main(String[] args) {
		
		List<Evento> eventos = Metodos.crearEventos();
		
		Metodos.mostrarMenu();
	}
}
