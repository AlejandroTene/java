package com.krakedev;

public class Rectangulo {
	public int base;
	public int altura;
	
	public int calcularArea() {
		int area=base*altura;
		return area;
	}
	
	public double calcularPerimetro() {
		int perimetro=(base+base)+(altura+altura);
		return perimetro;
	}

}
