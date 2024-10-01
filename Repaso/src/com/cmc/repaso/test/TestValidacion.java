package com.cmc.repaso.test;

import com.cmc.repaso.entidades.Validacion;

public class TestValidacion {

	public static void main(String[] args) {
		Validacion validacion1=new Validacion();
		Validacion validacion2=new Validacion();
		
		boolean respuesta1;
		boolean respuesta2;
		
		respuesta1=validacion1.validarMonto(500);
		respuesta2=validacion2.validarMonto(-2);
		
		System.out.println("Validación 1 "+respuesta1);
		System.out.println("Validación 2 "+respuesta2);
	}

}
