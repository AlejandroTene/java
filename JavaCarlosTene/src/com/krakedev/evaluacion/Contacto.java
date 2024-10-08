package com.krakedev.evaluacion;

import java.util.ArrayList;

public class Contacto {
	private String cedula;
	private String nombre;
	private String apellido;
	private Direccion direccion;
	private ArrayList<Telefono> telefonos;
	
	public void imprimir() {
		System.out.println("***"+nombre+" "+apellido+"***");
		if(direccion!=null) {
			System.out.println("Dirección: "+direccion.getCallePrincipal());
		}else {
			System.out.println("No tiene asociada una dirección ");
		}
	}
	
	public void agregarTelefono(Telefono telefono) {
		telefonos.add(telefono);
	}
	
	public void mostrarTelefonos() {
		Telefono elemento;
		System.out.println("Teléfonos con estado 'C':");
		for(int i=0;i<telefonos.size();i++) {
			elemento=telefonos.get(i);
			if(elemento.getEstado().equals("C")) {
				System.err.println("Número: "+elemento.getNumero()+", Tipo: "+elemento.getTipo());
			}
		}
	}
	
	public ArrayList<Telefono> recuperarIncorrectos(){
		ArrayList<Telefono> telefonosIn=new ArrayList<Telefono>();
		Telefono elemento;
		for(int i=0;i<telefonos.size();i++) {
			elemento=telefonos.get(i);
			if(elemento.getEstado().equals("E")) {
				telefonosIn.add(elemento);
			}
		}
		return telefonosIn;
	}
	
	
	public Contacto(String cedula, String nombre, String apellido) {
		this.cedula = cedula;
		this.nombre = nombre;
		this.apellido = apellido;
		this.telefonos=new ArrayList<Telefono>();
	}
		
	
	public Contacto(ArrayList<Telefono> telefonos) {
		this.telefonos = telefonos;
	}

	public String getCedula() {
		return cedula;
	}
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public Direccion getDireccion() {
		return direccion;
	}
	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}

	public ArrayList<Telefono> getTelefonos() {
		return telefonos;
	}

	public void setTelefonos(ArrayList<Telefono> telefonos) {
		this.telefonos = telefonos;
	}
	
	
	
}
