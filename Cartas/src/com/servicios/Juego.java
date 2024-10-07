package com.servicios;

import java.util.ArrayList;

import com.entidades.Carta;
import com.entidades.Naipe;

public class Juego {
	private Naipe naipe;
	private ArrayList<ArrayList<Carta>> cartasJugadores;
	private ArrayList<Carta> naipeBarajado;
	
	public Juego(ArrayList<String> idsJugadores) {
		this.cartasJugadores=new ArrayList<>();
		this.naipe=new Naipe();
		naipeBarajado=naipe.barajar();
		
		for(int i=0;i<idsJugadores.size();i++) {
			ArrayList<Carta> lisCart=new ArrayList<Carta>();
			cartasJugadores.add(lisCart);
		}
	}

	
	public Juego() {
		this.cartasJugadores=new ArrayList<ArrayList<Carta>>();
		naipe= new Naipe();
		this.naipeBarajado=new ArrayList<Carta>();
		naipeBarajado=naipe.barajar();
	}
	
	public void entregarCartas(int cartasPorJugador) {
		int numeroJugadores=cartasJugadores.size();
		int cartaC=cartasPorJugador*numeroJugadores;
		int id=0;
		for(int i=0;i<cartaC;i++) {
			Carta carta= naipeBarajado.get(i);
			cartasJugadores.get(id).add(carta);
			id=(id+1)%numeroJugadores;	
		}
	}
	
	public int devolverTotal(int idJugador) {
		ArrayList<Carta> cartas= cartasJugadores.get(idJugador);
		int total=0;
		Carta elemen;
        for(int i=0;i<cartas.size();i++) {
        	elemen=cartas.get(i);
			total+=elemen.getNumero().getValor();
		}
        return total;
	}
	
	public String determinarGanador() {
		int idGanador=0;
		int sumaGanador=devolverTotal(idGanador);
		Jugadores jugadores=new Jugadores();
			
		for(int i=1;i<cartasJugadores.size();i++) {
			int sumaAct=devolverTotal(i);
        	if(sumaAct>=sumaGanador) {
        		idGanador=i;
        		sumaGanador=sumaAct;
        	}
		}
		
		return "jugador "+(idGanador+1)+"";
		
	}


	public ArrayList<ArrayList<Carta>> getCartasJugadores() {
		return cartasJugadores;
	}
	
	
	

}
