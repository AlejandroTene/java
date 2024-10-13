package com.krakedev.estaticos.ejercicio.logica;

import java.util.ArrayList;

import com.krakedev.estaticos.ejercicio.entidades.Alarma;

public class AdminAlertas {
	private ArrayList<Alarma> alarmas;
	
	public void agregarAlarma(Alarma alarmaN) {
		 alarmas.add(alarmaN);
	}

	public ArrayList<Alarma> getAlarmas() {
		return alarmas;
	}

	public AdminAlertas() {
		super();
		this.alarmas=new ArrayList<Alarma>();
	}
	
	
	
	
	
}
