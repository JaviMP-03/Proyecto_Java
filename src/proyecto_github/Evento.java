package proyecto_github;

import java.time.LocalDate;

public abstract class Evento implements Interactuable{

	String nombre;
	LocalDate fecha;
	double precioEntrada;
	Categoria categoria;
	
	public Evento(String nombre, LocalDate fecha, double precioEntrada, Categoria categoria) {
		super();
		this.nombre = nombre;
		this.fecha = fecha;
		this.precioEntrada = precioEntrada;
		this.categoria = categoria;
	}

	//Getters & Setters
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public double getPrecioEntrada() {
		return precioEntrada;
	}

	public void setPrecioEntrada(double precioEntrada) {
		this.precioEntrada = precioEntrada;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	//ToString
	@Override
	public String toString() {
		return getNombre() + " | Fecha: " + getFecha() + " | Entrada: " + getPrecioEntrada() + " | Categoria: " + categoria.getValor();
	}
	
}
