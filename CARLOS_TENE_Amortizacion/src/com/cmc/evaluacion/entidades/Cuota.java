package com.cmc.evaluacion.entidades;

public class Cuota {
	private int numero;
	private double cuota;
	private double capital;
	private double inicio;
	private double interes;
	private double abonoCapital;
	private double saldo;
	
	public void mostrarPrestamo() {
		Utilitario ut=new Utilitario();
		double cuotaR=ut.redondear(cuota);
		double capitalR=ut.redondear(capital);
		double inicioR=ut.redondear(inicio);
		double interesR=ut.redondear(interes);
		double abonoCR=ut.redondear(abonoCapital);
		double saldoR=ut.redondear(saldo);
		
		System.out.println(numero+"      | "+cuotaR+"  | "+inicioR+"    | "+interesR+"     | "+abonoCR+"    | "+saldoR);
	}
	
	public Cuota(int numero) {
		this.numero = numero;
	}
	
	public double getCuota() {
		return cuota;
	}
	public void setCuota(double cuota) {
		this.cuota = cuota;
	}
	public double getCapital() {
		return capital;
	}
	public void setCapital(double capital) {
		this.capital = capital;
	}
	public double getInicio() {
		return inicio;
	}
	public void setInicio(double inicio) {
		this.inicio = inicio;
	}
	public double getInteres() {
		return interes;
	}
	public void setInteres(double interes) {
		this.interes = interes;
	}
	public double getAbonoCapital() {
		return abonoCapital;
	}
	public void setAbonoCapital(double abonoCapital) {
		this.abonoCapital = abonoCapital;
	}
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public int getNumero() {
		return numero;
	}
	
	
	
	
	

}
