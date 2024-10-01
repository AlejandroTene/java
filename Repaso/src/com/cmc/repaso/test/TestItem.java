package com.cmc.repaso.test;

import com.cmc.repaso.entidades.Item;

public class TestItem {

	public static void main(String[] args) {
		//Producto 1
		Item producto1=new Item();
		producto1.setNombre("Papel");
		producto1.setProductosActuales(20);
		
		producto1.imprimir();
		System.out.println("------------");
		producto1.vender(10);
		producto1.imprimir();
		System.out.println("------------");
		producto1.devolver(5);
		producto1.imprimir();
		
		
		System.out.println("****************");
		//Producto 2
		Item producto2=new Item();
		producto2.setNombre("Cuadernos");
		producto2.setProductosActuales(40);
				
		producto2.imprimir();
		System.out.println("------------");
		producto2.vender(15);
		producto2.imprimir();
		System.out.println("------------");
		producto2.devolver(7);
		producto2.imprimir();
		
		
		
		
		

	}

}
