package proyecto_github;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.ArrayList;
//import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Metodos {
	
	public static void mostrarMenu() {
	    Scanner scanner = new Scanner(System.in);
	    int continuar = 1;

	    while (continuar == 1) {
	        System.out.println("1. Ver todos los eventos");
	        System.out.println("2. Ver Conciertos");
	        System.out.println("3. Ver Peliculas");
	        System.out.println("4. Ver Talleres");
	        System.out.println("5. Ver eventos ordenados por fecha");
	        System.out.println("6. Ver eventos ordenados por categoria");
	        System.out.println("7. Add evento"); //me daba error si ponia la palabra en castellano ya que no existe esa letra (la n con una raya encima)
	        System.out.println("8. Eliminar evento");
	        System.out.println("9. Salir");

	        try {
	            if (!scanner.hasNextInt()) {
	                scanner.nextLine(); 
	                throw new IllegalArgumentException("Introduce un numero entre el 1 y 9: ");
	            }

	            int opcion = scanner.nextInt();
	            scanner.nextLine(); 

	            if (opcion < 1 || opcion > 9) {
	                throw new IllegalArgumentException("Introduce un numero entre el 1 y 9: ");
	            }

	            metodosOpciones(opcion);
	        } catch (IllegalArgumentException e) {
	            System.out.println(e.getMessage());
	            continue; 
	        }

	        boolean entradaValida = false;
	        while (!entradaValida) {
	            System.out.println("1. Continuar | 2. Salir");

	            try {
	                if (!scanner.hasNextInt()) {
	                    scanner.nextLine();
	                    throw new IllegalArgumentException("Introduce un numero valido: 1. Continuar | 2. Salir");
	                }

	                continuar = scanner.nextInt();
	                scanner.nextLine(); 

	                if (continuar < 1 || continuar > 2) {
	                    throw new IllegalArgumentException("Introduce un numero valido: 1. Continuar | 2. Salir");
	                }

	                entradaValida = true;
	            } catch (IllegalArgumentException e) {
	                System.out.println(e.getMessage());
	            }
	        }
	    }

	    System.out.println("Chao");
	    scanner.close();
	}

	
	public static void metodosOpciones(int opcion) {
		switch (opcion) {
		case 1: {
			mostrarTodo();
			break;
		}
		case 2: {
			mostrarConciertos();
			break;
		}
		case 3: {
			mostrarPeliculas();
			break;
		}
		case 4: {
			mostrarTalleres();
			break;
		}
		case 5: {
			ordenarPorFecha();
			break;
		}
		case 6: {
			ordenarPorCategoria();
			break;
		}
		case 7: {
			crearEvento();
			break;
		}
		case 8: {
			eliminarEvento();
			break;
		}
		case 9: {
			return;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + opcion);
		}
	}
	
	
	static List<Evento> eventos = new ArrayList<Evento>();
	public static List<Evento> crearEventos() {
		
		eventos.add(new Concierto("Jazz Magnetism", LocalDate.of(2014, 10, 7), 10.25, Categoria.DIECISEIS));
		eventos.add(new Concierto("El Circulo", LocalDate.of(2026, 6, 14), 25.50, Categoria.DIECIOCHO));
		eventos.add(new Concierto("Vivir para contarlo", LocalDate.of(2002, 4, 20), 5.75, Categoria.TRES));
		eventos.add(new Concierto("Guia para la accion", LocalDate.of(2012, 11, 19), 9.99, Categoria.DOCE));
		
		eventos.add(new Pelicula("El padrino", LocalDate.of(1972, 12, 31), 3.75, Categoria.DIECIOCHO));
		eventos.add(new Pelicula("El bueno, el feo y el malo", LocalDate.of(1966, 12, 23), 2.25, Categoria.DIECISEIS));
		eventos.add(new Pelicula("Cars 2", LocalDate.of(2011, 6, 29), 14.75, Categoria.TRES));
		eventos.add(new Pelicula("El nacimiento de una nacion", LocalDate.of(1915, 2, 8), 1.99, Categoria.DIECIOCHO));

		eventos.add(new Taller("Taller de Robotica", LocalDate.of(2025, 7, 10), 15.25, Categoria.TRES));
		eventos.add(new Taller("Taller de Programacion", LocalDate.of(2025, 7, 12), 20.50, Categoria.DOCE));
		eventos.add(new Taller("Taller de Diseño 3D", LocalDate.of(2025, 7, 14), 18.5, Categoria.DIECISEIS));
		eventos.add(new Taller("Taller de Inteligencia Artificial", LocalDate.of(2025, 7, 16), 25.99, Categoria.DIECIOCHO));
		return eventos;
	}
	
	public static void mostrarTodo() {
		
		for (Evento evento : eventos) {
			evento.obtenerDescripcion();
		}
	}
	
	public static void mostrarConciertos() {
		for (Evento evento : eventos) {
			if (evento instanceof Concierto) {
				evento.obtenerDescripcion();
			}
		}
	}
	
	public static void mostrarPeliculas() {
		for (Evento evento : eventos) {
			if (evento instanceof Pelicula) {
				evento.obtenerDescripcion();
			}
		}
	}
	
	public static void mostrarTalleres() {
		for (Evento evento : eventos) {
			if (evento instanceof Taller) {
				evento.obtenerDescripcion();
			}
		}
	}
	
	public static void ordenarPorFecha() {
	    List<Evento> ordenadosPorFecha = new ArrayList<>(eventos); 

	    ordenadosPorFecha.sort((e1, e2) -> e1.getFecha().compareTo(e2.getFecha()));

	    for (Evento evento : ordenadosPorFecha) {
	        System.out.println(evento);
	    }
	}
	
	public static void ordenarPorCategoria() {
	    List<Evento> ordenadosPorCategoria = new ArrayList<Evento>(eventos);

	    ordenadosPorCategoria.sort((e1, e2) -> e2.getCategoria().compareTo(e1.getCategoria()));

	    for (Evento evento : ordenadosPorCategoria) {
	    	System.out.println(evento);
	    }
	}
	
	public static void crearEvento() {
	    Scanner scanner = new Scanner(System.in);
	    boolean valido = false;

	    int opcion = -1;
	    String nombre = null;
	    LocalDate fecha = LocalDate.now();
	    double precioEntrada = -1;
	    Categoria categoria = Categoria.TRES;

	    while (!valido) {
	        System.out.println("Opciones");
	        System.out.println("1. Concierto");
	        System.out.println("2. Pelicula");
	        System.out.println("3. Taller");
	        System.out.println("4. Salir");

	        try {
	            if (!scanner.hasNextInt()) {
	                scanner.nextLine();
	                throw new IllegalArgumentException("Introduce un numero");
	            }

	            opcion = scanner.nextInt();
	            scanner.nextLine();

	            if (opcion < 1 || opcion > 4) {
	                throw new IllegalArgumentException("Introduce un numero entre 1 y 4");
	            }

	            if (opcion == 4) {
	                return;
	            }
	            
	            System.out.println("Nombre:");
	            nombre = scanner.nextLine();

	            //Fecha del evento
	            int year, mes, dia;
	            while (true) {
	                try {
	                    System.out.println("Year:");
	                    year = Integer.parseInt(scanner.nextLine());
	                    System.out.println("Mes (1-12):");
	                    mes = Integer.parseInt(scanner.nextLine());
	                    System.out.println("Dia:");
	                    dia = Integer.parseInt(scanner.nextLine());
	                    fecha = LocalDate.of(year, mes, dia);
	                    break;
	                } catch (NumberFormatException e) {
	                    System.out.println("Por favor, introduce numeros validos.");
	                } catch (DateTimeException e) {
	                    System.out.println("Fecha invalida. Intenta de nuevo.");
	                }
	            }

	            //Precio
	            while (true) {
	                try {
	                    System.out.println("Precio entrada:");
	                    precioEntrada = Double.parseDouble(scanner.nextLine());
	                    if (precioEntrada < 0) {
	                        System.out.println("El precio no puede ser negativo.");
	                    } else {
	                        break;
	                    }
	                } catch (NumberFormatException e) {
	                    System.out.println("Introduce un numero valido para el precio.");
	                }
	            }

	            //Categoría
	            while (true) {
	                try {
	                    System.out.println("Categorias:");
	                    System.out.println("1. 3");
	                    System.out.println("2. 12");
	                    System.out.println("3. 16");
	                    System.out.println("4. 18");

	                    int categoriaEscogida = Integer.parseInt(scanner.nextLine());

	                    switch (categoriaEscogida) {
	                        case 1: {
	                        	categoria = Categoria.TRES; 
	                        	break;
	                        }
	                        case 2: {
	                        	categoria = Categoria.DOCE; 
	                        	break;
	                        }

	                        case 3: {
	                        	categoria = Categoria.DIECISEIS; 
	                        	break;
	                        }
	                        case 4: {
	                        	categoria = Categoria.DIECIOCHO; 
	                        	break;
	                        }
	                        default:
	                            System.out.println("Selecciona una opcion valida entre 1 y 4.");
	                            continue;
	                    }
	                    break;
	                } catch (NumberFormatException e) {
	                    System.out.println("Introduce un numero valido.");
	                }
	            }
	            
	            switch (opcion) {
	                case 1:
	                    eventos.add(new Concierto(nombre, fecha, precioEntrada, categoria));
	                    break;
	                case 2:
	                    eventos.add(new Pelicula(nombre, fecha, precioEntrada, categoria));
	                    break;
	                case 3:
	                    eventos.add(new Taller(nombre, fecha, precioEntrada, categoria));
	                    break;
	                default:
	                    throw new IllegalArgumentException("Unexpected value: " + opcion);
	            }

	            valido = true; //Todo funciona

	        } catch (Exception e) {
	            System.out.println(e.getMessage());
	        }
	    }
	   
	}

	public static void eliminarEvento() {
	    Scanner scanner = new Scanner(System.in);
	    System.out.println("Titulo:");
	    String nombre = scanner.nextLine();
	    
	    boolean eliminado = false;
	    
	    for (int i = 0; i < eventos.size(); i++) {
	        if (eventos.get(i).getNombre().equals(nombre)) {
	            System.out.println(eventos.get(i).getNombre() + " ha sido eliminado");
	            eventos.remove(i);
	            eliminado = true;
	            break;
	        }
	    }
	    
	    if (!eliminado) {
	        System.out.println("No se ha encontrado el evento");
	    }
	    
	}
}
