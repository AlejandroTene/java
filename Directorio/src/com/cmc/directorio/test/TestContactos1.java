package com.cmc.directorio.test;

import com.cmc.directorio.entidades.AdminContactos;
import com.cmc.directorio.entidades.Contacto;
import com.cmc.directorio.entidades.Telefono;

public class TestContactos1 {

	public static void main(String[] args) {
		Telefono telf1=new Telefono("movi","0959639894",10);
		Telefono telf2=new Telefono("claro","0991436845",15);
		Contacto c1=new Contacto("Mateo", "Moran", telf1, 10);
		Contacto c2=new Contacto("María", "Teran", telf2, 15);
		
		AdminContactos p1=new AdminContactos();
		Contacto contMasPesado=p1.buscarMasPesado(c1, c2);
		System.out.println("Contacto más pesado");
		System.out.println("Nombre: "+contMasPesado.getNombre());
		System.out.println("Apellido: "+contMasPesado.getApellido());
		System.out.println("Operadora: "+contMasPesado.getTelefono().getOperadora());
		System.out.println("Número: "+contMasPesado.getTelefono().getNumero());
		System.out.println("Peso: "+contMasPesado.getPeso());
		
		boolean mismaOperadora=p1.compararOperadoras(c1, c2);
		System.out.println("Tienen las mismas operadoras? "+mismaOperadora);
		
		

	}

}
