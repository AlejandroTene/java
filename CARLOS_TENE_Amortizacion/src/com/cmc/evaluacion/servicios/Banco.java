package com.cmc.evaluacion.servicios;

import java.util.ArrayList;

import com.cmc.evaluacion.entidades.Cliente;
import com.cmc.evaluacion.entidades.Prestamo;

public class Banco {
	private ArrayList<Prestamo> prestamos;
	private ArrayList<Cliente> clientes;
	
	public Cliente buscarCliente(String cedula) {
		Cliente elemento;
		Cliente clienteEncontrado=null;
		for(int i=0;i<clientes.size();i++) {
			elemento=clientes.get(i);
			if(cedula.equals(elemento.getCedula())) {
				clienteEncontrado=elemento;
			}
		}
		return clienteEncontrado;
	}
	
	public void registrarCliente(Cliente clienteN) {
		Cliente cliente=buscarCliente(clienteN.getCedula());
		if(cliente!=null) {
			System.out.println("Cliente ya existe: "+clienteN.getCedula());
		}else {
			clientes.add(clienteN);
			System.out.println("Cliente registrado: "+clienteN.getNombre()+" "+clienteN.getApellido());
		}
	}
	
	public void asignarPrestamo(String cedula,Prestamo prestamo) {
		Cliente cliente=buscarCliente(cedula);
		if(cliente!=null) {
			prestamo= new Prestamo(prestamo.getMonto(),prestamo.getInteres(),prestamo.getPlazo(),cliente);
			CalculadoraAmortizacion calc=new CalculadoraAmortizacion();
			calc.generarTabla(prestamo);
			prestamos.add(prestamo);
		}else {
			System.out.println("No es cliente del banco");
		}
	}
	
	public ArrayList<Prestamo> buscarPrestamos(String cedula){
		ArrayList<Prestamo> prestamosClien=new ArrayList<Prestamo>();

		for(Prestamo prestamo :prestamos) {

			if(prestamo.getCliente().getCedula().equals(cedula)) {
				prestamosClien.add(prestamo);
			}
		}
		if(prestamosClien.isEmpty()) {
			return null;
		}
		return prestamosClien;
		
	}
	public Banco() {
		this.clientes = new ArrayList<Cliente>();
		this.prestamos = new ArrayList<Prestamo>();
	}

	public ArrayList<Prestamo> getPrestamos() {
		return prestamos;
	}
	public ArrayList<Cliente> getClientes() {
		return clientes;
	}
	
	
}
