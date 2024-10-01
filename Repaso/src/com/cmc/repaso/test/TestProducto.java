package com.cmc.repaso.test;

import com.cmc.repaso.entidades.Producto;

public class TestProducto {

	public static void main(String[] args) {
		double producto1Desc;
		double producto2Desc;
		
		Producto producto1= new Producto("Cuaderno",1.75);
		producto1Desc=producto1.calcularPrecioPromo(25);
		
		Producto producto2= new Producto("Pizarra",15);
		producto2.setPrecio(-24);
		producto2Desc=producto2.calcularPrecioPromo(10);
		
		System.out.println("Producto 1");
		System.out.println("Nombre: "+producto1.getNombre());
		System.out.println("Precio: "+producto1.getPrecio());
		System.out.println("Precio con descuento: "+producto1Desc);
		
		System.out.println("****************************************");
		
		System.out.println("Producto 2");
		System.out.println("Nombre: "+producto2.getNombre());
		System.out.println("Precio: "+producto2.getPrecio());
		System.out.println("Precio con descuento: "+producto2Desc);
	}

}
