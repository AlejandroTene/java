package com.cmc.evaluacion.servicios;

import java.util.ArrayList;

import com.cmc.evaluacion.entidades.Cuota;
import com.cmc.evaluacion.entidades.Prestamo;
import com.cmc.evaluacion.entidades.Utilitario;

public class CalculadoraAmortizacion {
	
	public static double calcularCuota(Prestamo prestamo) {
		double cuota=0;
		double inte=(prestamo.getInteres()/12)/100;
		
		cuota=(prestamo.getMonto()*inte)/(1-Math.pow(1+inte, -prestamo.getPlazo()));
		Utilitario ut=new Utilitario();
		double cuotaR=ut.redondear(cuota);

		return cuotaR;
		
	}
	
	public static  void generarTabla(Prestamo prestamo) {
		double cuotaC =calcularCuota(prestamo);
		

		for(int i=0;i<prestamo.getPlazo();i++) {
			Cuota cuota=new Cuota(i+1);
			cuota.setCuota(cuotaC);
			if(i==0) {
				cuota.setInicio(prestamo.getMonto());
				cuota.setSaldo(prestamo.getMonto());;
			}else {
				cuota.setSaldo(prestamo.getCuotas()[i-1].getSaldo());
			}
			prestamo.getCuotas()[i]=cuota;
		}
		for(int i=0;i<prestamo.getPlazo();i++) {
			Cuota cuota=prestamo.getCuotas()[i];
			if(i<prestamo.getPlazo()-1) {
				calcularValoresCuota(prestamo.getInteres(),cuota,prestamo.getCuotas()[i+1]);
			}else {
				calcularValoresCuota(prestamo.getInteres(),cuota,null);
			}
		}
		
		
	}
	
	public static void calcularValoresCuota(double interes,Cuota cuota,Cuota cuotaSi) {
		Utilitario ut=new Utilitario();
		double valorIn=interes/12/100;
		cuota.setInteres(ut.redondear(valorIn*cuota.getInicio()));
		cuota.setAbonoCapital(ut.redondear(cuota.getCuota()-cuota.getInteres()));
		cuota.setSaldo(ut.redondear(cuota.getInicio()-cuota.getAbonoCapital()));
		
		if(cuotaSi!=null) {
			cuotaSi.setInicio(cuota.getSaldo());
		}else {
			cuota.setCuota(cuota.getCuota()+cuota.getSaldo());
			cuota.setSaldo(0);
		}
		
		//if(cuotaSi!=null) {
			
			//cuotaSi.setInicio(cuotaAc.getSaldo());
		//}
	}
	
	public static void mostrarTabla(Prestamo prestamo) {
		System.out.println("Número |  Cuota  |   Inicio  |   Interés   |   Abono |   Saldo");
		Cuota elem;
		for(int i=0;i<prestamo.getPlazo();i++) {
			elem=prestamo.getCuotas()[i];
			elem.mostrarPrestamo();
		}

		
	}
	

}
