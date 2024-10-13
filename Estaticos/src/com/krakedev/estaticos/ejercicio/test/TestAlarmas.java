package com.krakedev.estaticos.ejercicio.test;

import java.util.ArrayList;

import com.krakedev.estaticos.DiasSemana;
import com.krakedev.estaticos.ejercicio.entidades.Alarma;
import com.krakedev.estaticos.ejercicio.logica.AdminAlertas;

public class TestAlarmas {

	public static void main(String[] args) {
		Alarma a1=new Alarma(DiasSemana.LUNES,5,45);
		Alarma a2=new Alarma(DiasSemana.MARTES,6,45);
		Alarma a3=new Alarma(DiasSemana.MIERCOLES,7,45);
		Alarma a4=new Alarma(DiasSemana.JUEVES,8,45);
		Alarma a5=new Alarma(DiasSemana.VIERNES,9,45);
		
		AdminAlertas admin=new AdminAlertas();
		admin.agregarAlarma(a1);
		admin.agregarAlarma(a2);
		admin.agregarAlarma(a3);
		admin.agregarAlarma(a4);
		admin.agregarAlarma(a5);
		
		
		ArrayList<Alarma> alarmasAct=admin.getAlarmas();
		System.out.println(alarmasAct);
	}

}
