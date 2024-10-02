package com.cmc.directorio.test;

import com.cmc.directorio.entidades.AdminContactos;
import com.cmc.directorio.entidades.Contacto;
import com.cmc.directorio.entidades.Telefono;

public class TestActivos {

	public static void main(String[] args) {
		Telefono telf1=new Telefono("claro","0989635268",14);
		Contacto c1=new Contacto("Claudia", "Acosta", telf1, 36);
        System.out.println(telf1.isTieneWhatsapp());
        
        AdminContactos p1=new AdminContactos();
        p1.activarUsuario(c1);
        System.out.println("Contacto más pesado");
		System.out.println("Nombre: "+c1.getNombre());
		System.out.println("Apellido: "+c1.getApellido());
		System.out.println("Operadora: "+c1.getTelefono().getOperadora());
		System.out.println("Número: "+c1.getTelefono().getNumero());
		System.out.println("Tiene Whtass?: "+c1.getTelefono().isTieneWhatsapp());
		System.out.println("Peso: "+c1.getPeso());
		System.out.println("Esta Activo?: "+c1.isActivo());
	}

}
