package com.clearminds.maquina;

import com.clearminds.componentes.Celda;
import com.clearminds.componentes.Producto;

public class MaquinaDulces {
	private Celda celda1;
	private Celda celda2;
	private Celda celda3;
	private Celda celda4;
	private double saldo;
	
	public void configurarMaquina(String codigo1,String codigo2,String codigo3,String codigo4) {
		celda1=new Celda(codigo1);
		celda2=new Celda(codigo2);
		celda3=new Celda(codigo3);
		celda4=new Celda(codigo4);
		
	}
	
	public void mostrarConfiguracion() {
		System.out.println("Celda 1: "+celda1.getCodigo());
		System.out.println("Celda 2: "+celda2.getCodigo());
		System.out.println("Celda 3: "+celda3.getCodigo());
		System.out.println("Celda 4: "+celda4.getCodigo());
	}
	
	public Celda buscarCelda(String codigo) {
		if(celda1.getCodigo()==codigo) {
			return celda1;
		}else if(celda2.getCodigo()==codigo) {
			return celda2;
		}else if(celda3.getCodigo()==codigo) {
			return celda3;
		}else if(celda4.getCodigo()==codigo) {
			return celda4;
		}else {
			return null;
		}
	}
	
	public void cargarProducto(Producto producto,String codigo,int items) {
		Celda celdaRecuperada=buscarCelda(codigo);
		celdaRecuperada.ingresarProducto(producto, items);
	}
	
	public void mostrarProductos() {
		if(celda1.getProducto() != null) {
			System.out.println("*******CELDA " +celda1.getCodigo());
			System.out.println("Stock: "+celda1.getStock());
			System.out.println("Nombre: "+celda1.getProducto().getNombre());
			System.out.println("Precio: "+celda1.getProducto().getPrecio());
			System.out.println("Codigo: "+celda1.getProducto().getCodigo());
		}else {
			System.out.println("*******CELDA " +celda1.getCodigo());
			System.out.println("Stock: "+celda1.getStock());
			System.out.println("La celda no tiene producto!!!");
		}
		
		if(celda2.getProducto() != null) {
			System.out.println("*******CELDA "+celda2.getCodigo());
			System.out.println("Stock: "+celda2.getStock());
			System.out.println("Nombre: "+celda2.getProducto().getNombre());
			System.out.println("Precio: "+celda2.getProducto().getPrecio());
			System.out.println("Codigo: "+celda2.getProducto().getCodigo());
		}else {
			System.out.println("*******CELDA " +celda2.getCodigo());
			System.out.println("Stock: "+celda2.getStock());
			System.out.println("La celda no tiene producto!!!");
		}
		
		if(celda3.getProducto() != null) {
			System.out.println("*******CELDA "+celda3.getCodigo());
			System.out.println("Stock: "+celda3.getStock());
			System.out.println("Nombre: "+celda3.getProducto().getNombre());
			System.out.println("Precio: "+celda3.getProducto().getPrecio());
			System.out.println("Codigo: "+celda3.getProducto().getCodigo());
		}else {
			System.out.println("*******CELDA " +celda3.getCodigo());
			System.out.println("Stock: "+celda3.getStock());
			System.out.println("La celda no tiene producto!!!");
		}
		
		if(celda4.getProducto() != null) {
			System.out.println("*******CELDA "+celda4.getCodigo());
			System.out.println("Stock: "+celda4.getStock());
			System.out.println("Nombre: "+celda4.getProducto().getNombre());
			System.out.println("Precio: "+celda4.getProducto().getPrecio());
			System.out.println("Codigo: "+celda4.getProducto().getCodigo());
		}else {
			System.out.println("*******CELDA " +celda4.getCodigo());
			System.out.println("Stock: "+celda4.getStock());
			System.out.println("La celda no tiene producto!!!");
		}
		System.out.println("Saldo: "+saldo);
		
	}
	
	public Producto buscarProductoEnCelda(String codigo) {
		Celda celdaEnc=buscarCelda(codigo);
		if(celdaEnc != null) {
			return celdaEnc.getProducto();
		}else {
			return null;
		}
	}
	
	public double consultarPrecio(String codigo) {
		if(celda1.getCodigo()==codigo) {
			return celda1.getProducto().getPrecio();
		}else if(celda2.getCodigo()==codigo) {
			return celda2.getProducto().getPrecio();
		}else if(celda3.getCodigo()==codigo) {
			return celda3.getProducto().getPrecio();
		}else if(celda4.getCodigo()==codigo) {
			return celda4.getProducto().getPrecio();
		}else {
			return saldo;
		}
	}
	
	public Celda buscarCeldaProducto(String codigoP) {
		if(celda1.getProducto()!=null && celda1.getProducto().getCodigo()==codigoP) {
			return celda1;
		}else if(celda2.getProducto()!=null && celda2.getProducto().getCodigo()==codigoP) {
			return celda2;
		}else if(celda3.getProducto()!=null && celda3.getProducto().getCodigo()==codigoP) {
			return celda3;
		}else if(celda4.getProducto()!=null && celda4.getProducto().getCodigo()==codigoP) {
			return celda4;
		}else {
			return null;
		}
	}
	
	public void incrementarProductos(String codigoP,int itemsIncr) {
		Celda celdaEncontrada=buscarCeldaProducto(codigoP);
		int incremento=celdaEncontrada.getStock()+itemsIncr;
		celdaEncontrada.setStock(incremento);
	}
	
	public void vender(String codigo) {
		Producto productoEncontrado=buscarProductoEnCelda(codigo);
		Celda celdaEncontrada=buscarCeldaProducto(productoEncontrado.getCodigo());
		int vendido=celdaEncontrada.getStock()-1;
		celdaEncontrada.setStock(vendido);
		saldo+=productoEncontrado.getPrecio();
		mostrarProductos();
	}
	
	public double venderConCambio(String codigo,double valorIng) {
		Producto productoEncontrado=buscarProductoEnCelda(codigo);
		Celda celdaEncontrada=buscarCeldaProducto(productoEncontrado.getCodigo());
		int vendido=celdaEncontrada.getStock()-1;
		celdaEncontrada.setStock(vendido);
		saldo+=productoEncontrado.getPrecio();
		double cambio=valorIng-productoEncontrado.getPrecio();
		return cambio;
	}
	
	
	
	
	public Celda getCelda1() {
		return celda1;
	}
	public void setCelda1(Celda celda1) {
		this.celda1 = celda1;
	}
	public Celda getCelda2() {
		return celda2;
	}
	public void setCelda2(Celda celda2) {
		this.celda2 = celda2;
	}
	public Celda getCelda3() {
		return celda3;
	}
	public void setCelda3(Celda celda3) {
		this.celda3 = celda3;
	}
	public Celda getCelda4() {
		return celda4;
	}
	public void setCelda4(Celda celda4) {
		this.celda4 = celda4;
	}
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	
	

}
