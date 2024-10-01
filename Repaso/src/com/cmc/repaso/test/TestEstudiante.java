package com.cmc.repaso.test;

import com.cmc.repaso.entidades.Estudiante;

public class TestEstudiante {

	public static void main(String[] args) {
		
		Estudiante estudiante1= new Estudiante("Marco");
		Estudiante estudiante2= new Estudiante("Maía");
		
		estudiante1.calificar(7.8);
		estudiante2.calificar(9);
		
		System.out.println("Estudiante 1");
		System.out.println("Nombre: "+estudiante1.getNombre());
		System.out.println("Nota: "+estudiante1.getNota());
		System.out.println("Resultado: "+estudiante1.getResultado());
		
		System.out.println("***************************************");
		
		System.out.println("Estudiante 2");
		System.out.println("Nombre: "+estudiante2.getNombre());
		System.out.println("Nota: "+estudiante2.getNota());
		System.out.println("Resultado: "+estudiante2.getResultado());

	}

}
