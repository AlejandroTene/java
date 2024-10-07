package com.entidades;

public class Carta {
	private Numero numero;
	private String palo;
	private String esatdo="N";
	
	public void mostrarInformacion() {
		System.out.println(numero.getNumeroCarta()+"-"+palo);
	}
	
	public Carta(Numero numero, String palo) {
		this.numero = numero;
		this.palo = palo;
	}
	public Numero getNumero() {
		return numero;
	}
	public void setNumero(Numero numero) {
		this.numero = numero;
	}
	public String getPalo() {
		return palo;
	}
	public void setPalo(String palo) {
		this.palo = palo;
	}

	public String getEsatdo() {
		return esatdo;
	}

	public void setEsatdo(String esatdo) {
		this.esatdo = esatdo;
	}
	
	
	

}
