package com.krakedev.persistencia.test;

import java.util.ArrayList;

import com.krakedev.persistencia.entidades.Persona;
import com.krakedev.persistencia.servicios.AdminPersonas;

public class TestConsultarPersonasPorCedula {

	public static void main(String[] args) {
		try {
			Persona p=AdminPersonas.buscarPorCedula("1150963084");
			System.out.println(p);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
