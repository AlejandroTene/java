package com.krakedev.persistencia.test;

import java.math.BigDecimal;
import java.util.Date;

import com.krakedev.persistencia.entidades.EstadoCivil;
import com.krakedev.persistencia.entidades.Persona;
import com.krakedev.persistencia.servicios.AdminPersonas;
import com.krakedev.persistencia.utils.Convertidor;

public class TestActualizar {

	public static void main(String[] args) {
		EstadoCivil ec=new EstadoCivil("C", "Casado");
		Persona p=new Persona("1150253084","Carlos","Tene",ec);
		try {
			Date fechaNac=Convertidor.convertirFecha("2006/09/28");
			Date horaNac=Convertidor.convertirHora("18:00");
			p.setFechaNacimiento(fechaNac);
			p.setHoraNacimeinto(horaNac);
			p.setCantidadAhorrada(new BigDecimal(700.20));
			p.setNumeroHijos(1);
			AdminPersonas.actualizar(p);
			
		} catch (Exception e) {
			System.out.println("error en el sistema: "+e.getMessage());
		}


	}

}
