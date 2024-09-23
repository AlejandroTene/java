package com.krakedev;

public class TestAuto {

	public static void main(String[] args) {
		Auto auto1=new Auto();
		Auto auto2=new Auto();
		
		
		//modifico atributos auto1
		auto1.marca = "KIA";
		auto1.anio = 2018;
		auto1.precio = 11300.00;
		
		//modifico atributos auto2
		auto2.marca = "Volvo";
		auto2.anio = 2016;
		auto2.precio = 10400.00;
		
		
		
		//mostrar valores de los atributos de los autos
		System.out.println("AUTO 1");
		System.out.println("marca:"+auto1.marca);
		System.out.println("año:"+auto1.anio);
		System.out.println("precio:"+auto1.precio);
		
		System.out.println("---------------------");
		
		System.out.println("AUTO 2");
		System.out.println("marca:"+auto2.marca);
		System.out.println("año:"+auto2.anio);
		System.out.println("precio:"+auto2.precio);
		

	}

}
