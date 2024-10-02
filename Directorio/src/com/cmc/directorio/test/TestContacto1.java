package com.cmc.directorio.test;

import com.cmc.directorio.entidades.Contacto;
import com.cmc.directorio.entidades.Telefono;

public class TestContacto1 {

	public static void main(String[] args) {
		Telefono telf=new Telefono("movi","0994785623",11);
		Contacto c=new Contacto("Carlos", "Tene", telf, 15);
		
		System.out.println("Contacto 1");
		System.out.println("Nombre: "+c.getNombre());
		System.out.println("Apellido: "+c.getApellido());
		System.out.println("Operadora: "+c.getTelefono().getOperadora());
		System.out.println("Telefono: "+c.getTelefono().getNumero());
		System.out.println("Peso: "+c.getPeso());
		
		

	}

}
