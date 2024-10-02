package com.cmc.directorio.test;

import com.cmc.directorio.entidades.AdminTelefono;
import com.cmc.directorio.entidades.Telefono;

public class TestTelefono4 {

	public static void main(String[] args) {
		Telefono telf1=new Telefono("movi","0959639895",18);
		Telefono telf2=new Telefono("claro","0994785963",21);
		Telefono telf3=new Telefono("claro","0991436589",17);
		Telefono telf4=new Telefono("claro","0959639891",23);
		AdminTelefono at=new AdminTelefono();
		
		int conc=at.contarClaro(telf1, telf2, telf3, telf4);
		
		System.out.println(conc);
	}

}
