package com.entidades;

import java.util.ArrayList;

public class Naipe {
	private ArrayList<Numero> numerosPosibles;
	private ArrayList<Carta> cartas;

	
	public Naipe() {
		this.numerosPosibles= new ArrayList<Numero>();
		this.cartas=new ArrayList<Carta>();
		Palos palos=new Palos();
		
		numerosPosibles.add(new Numero("A",11));
		numerosPosibles.add(new Numero("2",2));
		numerosPosibles.add(new Numero("3",3));
		numerosPosibles.add(new Numero("4",4));
		numerosPosibles.add(new Numero("5",5));
		numerosPosibles.add(new Numero("6",6));
		numerosPosibles.add(new Numero("7",7));
		numerosPosibles.add(new Numero("8",8));
		numerosPosibles.add(new Numero("9",9));
		numerosPosibles.add(new Numero("10",10));
		numerosPosibles.add(new Numero("J",10));
		numerosPosibles.add(new Numero("Q",10));
		numerosPosibles.add(new Numero("K",10));
		
		Numero elemento;
		for(int i=0;i<numerosPosibles.size();i++) {
			elemento=numerosPosibles.get(i);
			cartas.add(new Carta(elemento,palos.getCorazonNegro()));
			cartas.add(new Carta(elemento,palos.getCorazonRojo()));
			cartas.add(new Carta(elemento,palos.getDiamante()));
			cartas.add(new Carta(elemento,palos.getTrebol()));
		}
	}
	
	public ArrayList<Carta> barajar(){
		ArrayList<Carta> auxiliar=new ArrayList<Carta>();
		for(int i=1;i<100;i++) {
			int pos=Random.obtenerPosicion();
			Carta cartaP=cartas.get(pos);
			if(cartaP.getEsatdo().equals("N")) {
				auxiliar.add(cartaP);
				cartaP.setEsatdo("C");
			}
		}
		Carta elemen;
		for(int j=0;j<cartas.size();j++) {
			elemen=cartas.get(j);
			if(elemen.getEsatdo().equals("N")) {
				auxiliar.add(elemen);
				elemen.setEsatdo("C");
			}
		}
		
		return auxiliar;
		
	}


	public ArrayList<Carta> getCartas() {
		return cartas;
	}
	
	
	

}
