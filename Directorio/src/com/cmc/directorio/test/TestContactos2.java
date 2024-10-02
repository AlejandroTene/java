package com.cmc.directorio.test;

import com.cmc.directorio.entidades.AdminContactos;
import com.cmc.directorio.entidades.Contacto;
import com.cmc.directorio.entidades.Telefono;

public class TestContactos2 {

	public static void main(String[] args) {
		Telefono telf1=new Telefono("claro","0953698987",19);
		Telefono telf2=new Telefono("claro","0991542368",25);
		Contacto c1=new Contacto("Fer", "Merino", telf1, 19);
		Contacto c2=new Contacto("Cristina", "Ojeda", telf2, 14);
		
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
