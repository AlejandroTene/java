package com.clearminds.componentes;

public class Producto {
	private String nombre;
	private double precio;
	private String codigo;
	
	public void incrementarPrecio(int porIncremento) {
		double incremento=(precio*porIncremento)/100;
		precio+=incremento;
	}
	
	public void disminuirPrecio(double desc) {
		precio -=desc;
	}
	
	
	public Producto(String codigo,String nombre, double precio) {
		super();
		this.nombre = nombre;
		this.precio = precio;
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	
	

}
