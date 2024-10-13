package com.krakedev.estaticos;

public class TestEstaticos {

	public static void main(String[] args) {
		// Para invocar un metodo estatico, se lo hace directamente desde 
		//la clase no hcae falta instanciarlo directamnete
		double numero=Math.random();
		System.out.println(numero);
		
		int radio=10;
		double area=Math.PI*radio;
		System.out.println(area);

	}

}
