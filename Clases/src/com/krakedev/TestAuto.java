package com.krakedev;

public class TestAuto {

	public static void main(String[] args) {
		Auto auto1=new Auto();
		Auto auto2=new Auto();
		
		
		//modifico atributos auto1
		auto1.setMarca("KIA"); 
		auto1.setAnio(2018); 
		auto1.setPrecio(113000.00); 
		
		//modifico atributos auto2
		auto2.setMarca("Volvo");
		auto2.setAnio(2016); 
		auto2.setPrecio(10400.00); 
		
		
		
		//mostrar valores de los atributos de los autos
		System.out.println("AUTO 1");
		System.out.println("marca:"+auto1.getMarca());
		System.out.println("año:"+auto1.getAnio());
		System.out.println("precio:"+auto1.getPrecio());
		
		System.out.println("---------------------");
		
		System.out.println("AUTO 2");
		System.out.println("marca:"+auto2.getMarca());
		System.out.println("año:"+auto2.getAnio());
		System.out.println("precio:"+auto2.getPrecio());
		

	}

}
