package com.clearminds.maquina;

import java.util.ArrayList;

import com.clearminds.componentes.Celda;
import com.clearminds.componentes.Producto;



public class MaquinaDulces {
	private ArrayList<Celda> celdas;
	private double saldo;
	
	
	public void agregarCelda(Celda celda) {
        celdas.add(celda);
	}
	
	public void mostrarConfiguracion() {
		Celda elementoCelda;
		int nC;
		for(int i=0;i<celdas.size();i++) {
			elementoCelda=celdas.get(i);
			nC=i+1;
			System.out.println("Celda"+nC+": "+elementoCelda.getCodigo());
		}
	}
	
	public Celda buscarCelda(String codigo) {
		Celda celdaEncontrada=null;
		Celda elementoCelda;
		for(int i=0;i<celdas.size();i++) {
			elementoCelda=celdas.get(i);
			if(codigo.equals(elementoCelda.getCodigo())) {
				celdaEncontrada= elementoCelda;
			}	
		}
		return celdaEncontrada;
	}
	
	public void cargarProducto(Producto producto,String codigoC,int items) {
		Celda celdarecuperada=buscarCelda(codigoC);
		celdarecuperada.ingresarProducto(producto, items);
	}
	
	public void mostrarProductos() {
		Celda elementoCelda;
		for(int i=0;i<celdas.size();i++) {
			elementoCelda=celdas.get(i);
			if(elementoCelda.getProducto()!=null) {
				System.out.println("Celda:"+elementoCelda.getCodigo()+" Stock:"+elementoCelda.getStock()+" Producto:"+elementoCelda.getProducto().getNombre()+" Precio:"+elementoCelda.getProducto().getPrecio());
			}else {
				System.out.println("Celda:"+elementoCelda.getCodigo()+" Stock:"+elementoCelda.getStock()+" Sin Producto Asignado");
			}
		}
		System.out.println("Saldo:"+saldo);
	}
	
	public Producto buscarProductoEnCelda(String codigoC) {
		Celda celdaEnc=buscarCelda(codigoC);
		Producto productoEnc=null;
		if(celdaEnc!=null) {
			productoEnc=celdaEnc.getProducto();
	    }
		return productoEnc;
	}
	
	public double consultarPrecio(String codigoC) {
		Celda celdaEnc=buscarCelda(codigoC);
		double precio;
	    precio=celdaEnc.getProducto().getPrecio();
		return precio;
	}
	
	public Celda buscarCeldaProducto(String codigoP) {
		Celda celdaEnc=null;
		Celda elementoCelda;
		for(int i=0;i<celdas.size();i++) {
			elementoCelda=celdas.get(i);
			if(elementoCelda.getProducto()!=null) {
				if(codigoP.equals(elementoCelda.getProducto().getCodigo())) {
					celdaEnc=elementoCelda;
				}
			}
		}
		return celdaEnc;
	}
	
	public void incrementarProductos(String codigoP,int items) {
		Celda celdaEncontrada=buscarCeldaProducto(codigoP);
		int incremento;
		if(celdaEncontrada!=null) {
			incremento=celdaEncontrada.getStock()+items;
			celdaEncontrada.setStock(incremento);
		}
	}
	
	public void vender(String codigoC) {
		Celda celdaEncon=buscarCelda(codigoC);
		int disminuir;
		if(celdaEncon!=null) {
			disminuir=celdaEncon.getStock()-1;
			saldo+=celdaEncon.getProducto().getPrecio();
			celdaEncon.setStock(disminuir);
			mostrarProductos();
		}
	}
	
	public double venderConCambio(String codigoC,double valorIn) {
		Celda celdaEncon=buscarCelda(codigoC);
		double cambio = 0;
		int disminuir;
		if(celdaEncon!=null) {
			cambio=valorIn-celdaEncon.getProducto().getPrecio();
			disminuir=celdaEncon.getStock()-1;
			celdaEncon.setStock(disminuir);
			saldo+=celdaEncon.getProducto().getPrecio();
		}
		return cambio;
	}
	
	public ArrayList<Producto> buscarMenores(double limite){
		ArrayList<Producto> menores=new ArrayList<Producto>();
		Producto elementoProducto=null;
		
		for(int i=0;i<celdas.size();i++) {
			elementoProducto=celdas.get(i).getProducto();
			if(elementoProducto.getPrecio()<=limite) {
				menores.add(elementoProducto);
			}
		}
		
		return menores;
		
	}
	
	public MaquinaDulces() {
		celdas = new ArrayList<Celda>();
	}
	
	public ArrayList<Celda> getCeldas() {
		return celdas;
	}
	public void setCeldas(ArrayList<Celda> celdas) {
		this.celdas = celdas;
	}
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	
	

}
