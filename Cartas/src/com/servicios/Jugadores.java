package com.servicios;

import java.util.ArrayList;

import com.entidades.Carta;

public class Jugadores {
	private ArrayList<String> nombresJugadores;

	public void jugar() {
		nombresJugadores.add("Jugador 1");
		nombresJugadores.add("Jugador 2");
		nombresJugadores.add("Jugador 3");
		String nombre;
		String ganador;
		
		Juego jue=new Juego(new ArrayList<>(nombresJugadores));
		jue.entregarCartas(5);
		
		
		for(int i=0;i<nombresJugadores.size();i++) {
			nombre=nombresJugadores.get(i);
			ArrayList<Carta> cartas= jue.getCartasJugadores().get(i);
			System.out.println("Total de "+nombre+": "+cartas.size());
		}
		
		ganador=jue.determinarGanador();
		System.out.println("El ganador es: "+ganador);
	}
	
	
	
	public Jugadores() {
		this.nombresJugadores=new ArrayList<String>();
	}




	public ArrayList<String> getNombresJugadores() {
		return nombresJugadores;
	}

	public void setNombresJugadores(ArrayList<String> nombresJugadores) {
		this.nombresJugadores = nombresJugadores;
	}
	
	
	
	
}
