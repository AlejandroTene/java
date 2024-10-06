package com.krakedev.evaluacion;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Directorio {
	private ArrayList<Contacto> contactos;
	private Date fechaModificacion;
	private ArrayList<Contacto> correctos;
	private ArrayList<Contacto> incorrectos;
	
	public boolean agregarContacto(Contacto contacto) {
		Contacto elemento;
		boolean contEn=false;
		for(int i=0;i<contactos.size();i++) {
			elemento=contactos.get(i);
			if(contacto.getCedula().equals(elemento.getCedula())) {
				contEn=true;
			}
		}
		if(contEn!=true) {
			contactos.add(contacto);
			this.fechaModificacion = new Date();
			return true;
		}else {
			return false;
		}
	}
	
	public String consultarUltimaModificacion() {
		SimpleDateFormat formato= new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		return formato.format(fechaModificacion);
	}
	
	public Contacto buscarPorCedula(String cedula) {
		Contacto elemento;
		Contacto contEn=null;
		for(int i=0;i<contactos.size();i++) {
			elemento=contactos.get(i);
			if(cedula.equals(elemento.getCedula())) {
				contEn=elemento;
			}
		}
		return contEn;
	}
	
	public int contarPerdidos() {
		Contacto elemento;
		int perdidos = 0;
		for(int i=0;i<contactos.size();i++) {
			elemento=contactos.get(i);
			if(elemento.getDireccion()==null) {
				perdidos+=1;
			}
		}
		return perdidos;
	}
	
	public int contarFijos() {
		Contacto elementoC;
		Telefono elementoT;
		int fijos = 0;
		for(int i=0;i<contactos.size();i++) {
			elementoC=contactos.get(i);
			for(int j=0;j<elementoC.getTelefonos().size();j++) {
				elementoT=elementoC.getTelefonos().get(j);
				if(elementoT.getTipo().equals("Convencional") && elementoT.getEstado().equals("C")) {
					fijos+=1;
				}
			}
		}
		return fijos;
	}
	
	public void depurar() {
		this.correctos=new ArrayList<Contacto> ();
		this.incorrectos=new ArrayList<Contacto> ();
		Contacto elemento;
		for(int i=0;i<contactos.size();i++) {
			elemento=contactos.get(i);
			if(elemento.getDireccion()!=null) {
				correctos.add(elemento);
			}else {
				incorrectos.add(elemento);
			}
		}
		contactos.clear();
	}
	
	public Directorio() {
		this.contactos=new ArrayList<Contacto> ();
	}



	public ArrayList<Contacto> getContactos() {
		return contactos;
	}
	public void setContactos(ArrayList<Contacto> contactos) {
		this.contactos = contactos;
	}
	public Date getFechaModificacion() {
		return fechaModificacion;
	}
	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	public ArrayList<Contacto> getCorrectos() {
		return correctos;
	}

	public void setCorrectos(ArrayList<Contacto> correctos) {
		this.correctos = correctos;
	}

	public ArrayList<Contacto> getIncorrectos() {
		return incorrectos;
	}

	public void setIncorrectos(ArrayList<Contacto> incorrectos) {
		this.incorrectos = incorrectos;
	}
	
	
	
}
