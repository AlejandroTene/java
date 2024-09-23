package com.krakedev;

public class TestProducto {

	public static void main(String[] args) {
		Producto productoA=new Producto();
		Producto productoB=new Producto();
		Producto productoC=new Producto();
		
		//modifico atributos productoA
		productoA.nombre = "Alcohol";
		productoA.descripcion = "de un litro";
		productoA.precio = 2.5;
		productoA.stockActual = 50;
				
		//modifico atributos productoB
		productoB.nombre = "Pañitos humedos";
		productoB.descripcion = "sin alcohol super suaves, 100 U";
		productoB.precio = 1.5;
		productoB.stockActual = 20;
		
		//modifico atributos productoC
		productoC.nombre = "Aspirina";
		productoC.descripcion = "efervescente para dolor de cabeza";
		productoC.precio = 0.75;
		productoC.stockActual = 70;
		
		//mostrar valores de los atributos de los productos
		System.out.println("Producto A");
		System.out.println("nombre:"+productoA.nombre);
		System.out.println("descripcion:"+productoA.descripcion);
		System.out.println("precio:"+productoA.precio);
		System.out.println("stockActual:"+productoA.stockActual);
				
		System.out.println("---------------------");
		
		System.out.println("Producto B");
		System.out.println("nombre:"+productoB.nombre);
		System.out.println("descripcion:"+productoB.descripcion);
		System.out.println("precio:"+productoB.precio);
		System.out.println("stockActual:"+productoB.stockActual);
		
        System.out.println("---------------------");
		
		System.out.println("Producto C");
		System.out.println("nombre:"+productoC.nombre);
		System.out.println("descripcion:"+productoC.descripcion);
		System.out.println("precio:"+productoC.precio);
		System.out.println("stockActual:"+productoC.stockActual);
		
		

	}

}
