package com.krakedev.test;

import com.krakedev.Producto;

public class TestProducto {

	public static void main(String[] args) {
		Producto productoA=new Producto();
		Producto productoB=new Producto();
		Producto productoC=new Producto();
		
		//modifico atributos productoA
		productoA.setNombre("Alcohol");
		productoA.setDescripcion("de un litro");
		productoA.setPrecio(2.5); 
		productoA.setStockActual(50); 
				
		//modifico atributos productoB
		productoB.setNombre( "Pañitos humedos");
		productoB.setDescripcion("sin alcohol super suaves, 100 U"); 
		productoB.setPrecio(1.5);
		productoB.setStockActual(20);
		
		//modifico atributos productoC
		productoC.setNombre("Aspirina"); 
		productoC.setDescripcion( "efervescente para dolor de cabeza"); 
		productoC.setPrecio(0.75); 
		productoC.setStockActual(70); 
		
		//mostrar valores de los atributos de los productos
		System.out.println("Producto A");
		System.out.println("nombre:"+productoA.getNombre());
		System.out.println("descripcion:"+productoA.getDescripcion());
		System.out.println("precio:"+productoA.getPrecio());
		System.out.println("stockActual:"+productoA.getStockActual());
				
		System.out.println("---------------------");
		
		System.out.println("Producto B");
		System.out.println("nombre:"+productoB.getNombre());
		System.out.println("descripcion:"+productoB.getDescripcion());
		System.out.println("precio:"+productoB.getPrecio());
		System.out.println("stockActual:"+productoB.getStockActual());
		
        System.out.println("---------------------");
		
		System.out.println("Producto C");
		System.out.println("nombre:"+productoC.getNombre());
		System.out.println("descripcion:"+productoC.getDescripcion());
		System.out.println("precio:"+productoC.getPrecio());
		System.out.println("stockActual:"+productoC.getStockActual());
		
		

	}

}
