package com.krakedev;

public class Calculadora {
	public int sumar(int valor1, int valor2) {
		int resultado;//declaro la varible
		resultado=valor1 + valor2;
		return resultado;
	}
	
	public double restar(int valor1,int valor2) {
		double resultado;
		resultado=valor1-valor2;
		return resultado;
	}
	
	public double multiplicar(double valor1,double valor2) {
		double producto;
		producto=valor1*valor2;
		return producto;
	}
	
	public double dividir(double dividiendo,double divisor) {
		double resultado;
		resultado=dividiendo/divisor;
		return resultado;
	}
	
	public double promediar(double valor1,double valor2,double valor3) {
		double promedio;
		promedio=(valor1+valor2+valor3)/3;
		return promedio;
	}
	
	
	


}
