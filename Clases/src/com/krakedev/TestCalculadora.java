package com.krakedev;

public class TestCalculadora {

	public static void main(String[] args) {
		Calculadora calcu;
		int resultadoSuma;
		double resultadoResta;
		double resultadoMultiplicacion;
		double resultadoDivision;
		double resultadoPromedio;
		
		calcu=new Calculadora();
		
		resultadoSuma=calcu.sumar(5, 3);
		resultadoResta=calcu.restar(10, 3);
		resultadoMultiplicacion=calcu.multiplicar(10, 5);
		resultadoDivision=calcu.dividir(10, 2);
		resultadoPromedio=calcu.promediar(10, 8, 9);
		
		System.out.println("RESULTADO SUMA: "+resultadoSuma);
		System.out.println("RESULTADO RESTA: "+resultadoResta);
		System.out.println("RESULTADO MULTIPLICACIÓN: "+resultadoMultiplicacion);
		System.out.println("RESULTADO DIVISIÓN: "+resultadoDivision);
		System.out.println("RESULTADO PROMEDIO: "+resultadoPromedio);
		calcu.mostrarResultado();

	}

}
