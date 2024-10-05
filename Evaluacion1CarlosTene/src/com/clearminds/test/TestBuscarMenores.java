package com.clearminds.test;

import java.util.ArrayList;

import com.clearminds.componentes.Celda;
import com.clearminds.componentes.Producto;
import com.clearminds.maquina.MaquinaDulces;

public class TestBuscarMenores {

	public static void main(String[] args) {
		MaquinaDulces maquina = new MaquinaDulces();
        maquina.agregarCelda(new Celda("A1"));
        maquina.agregarCelda(new Celda("A2"));
        maquina.agregarCelda(new Celda("A3"));
        maquina.agregarCelda(new Celda("B1"));
        maquina.agregarCelda(new Celda("B2"));
        maquina.agregarCelda(new Celda("B3"));
        
        maquina.cargarProducto(new Producto("A5R2", "Papas", 0.75), "A1", 15);
        maquina.cargarProducto(new Producto("Q9F6", "Pasta", 0.80), "A2", 8);
        maquina.cargarProducto(new Producto("F3S6", "Papel", 1.25), "A3", 10);
        maquina.cargarProducto(new Producto("AP85", "Hojas", 0.65), "B1", 40);
        maquina.cargarProducto(new Producto("C3S9", "Chocolate", 0.85), "B2", 5);
        maquina.cargarProducto(new Producto("E9H6", "Arroz", 0.60), "B3", 11);

        ArrayList<Producto> listaMenores=maquina.buscarMenores(1);
        System.out.println("Productos Menores: " + listaMenores.size());
        
        Producto producto;
        for (int i=0;i<listaMenores.size();i++) {
        	producto=listaMenores.get(i);
            System.out.println("Nombre:"+producto.getNombre()+" Precio:"+producto.getPrecio());
        }
	}

}
