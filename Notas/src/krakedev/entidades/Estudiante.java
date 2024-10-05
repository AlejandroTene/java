package krakedev.entidades;

import java.util.ArrayList;

public class Estudiante {
	private String nombre;
	private String apellido;
	private String cedula;
	private ArrayList<Nota> notas;
	
	public void agregarNota(Nota nuevaNota) {

		boolean error=false;
		//boolean fuera=false;
		if(nuevaNota.getCalificacion()>=0 && nuevaNota.getCalificacion()<=10) {
			Nota elementoNota;
			for(int i=0;i<notas.size();i++) {
				elementoNota=notas.get(i);
				if(nuevaNota.getMateria().getCodigo().equals(elementoNota.getMateria().getCodigo())) {
					System.out.println("Ya existe una nota para la metaria con código: "+nuevaNota.getMateria().getCodigo());
					error=true;
				}
			}
		}else {
			System.out.println("La calificación deber ser entre 0 y 10");
			error=true;
		}
		if(error!=true) {
			notas.add(nuevaNota);
			System.out.println("Agregada");
		}
		
		
	}
	
	public void modificarNota(String codigo, double nuevaNota) {
		boolean encontrada=false;
		if(nuevaNota>=0 && nuevaNota<=10) {
			Nota elementoNota;
			for(int i=0;i<notas.size();i++) {
				elementoNota=notas.get(i);
				if(codigo.equals(elementoNota.getMateria().getCodigo())) {
					elementoNota.setCalificacion(nuevaNota);
					System.out.println("Nota modificada");
					encontrada=true;
				}
			}
		}else {
			System.out.println("La calificación deber ser entre 0 y 10");
			encontrada=true;
		}

		if(encontrada!=true) {
			System.out.println("No se encontro la materia con el codigo ingresado");
		}
	}
	
	public double calcularPromedioNotasEstudiante() {		Nota elementoNota;
		double promedio;
		double suma = 0;
		for(int i=0;i<notas.size();i++) {
			elementoNota=notas.get(i);
			suma+=elementoNota.getCalificacion();
		}
		promedio=suma/notas.size();
		return promedio;
	}
	
	public void mostrar() {
		Nota elemento;
		for(int i=0;i<notas.size();i++) {
			elemento=notas.get(i);
			System.out.println("Nombre: "+elemento.getMateria().getNombre()+" Codigo: "+elemento.getMateria().getCodigo()+" Califiacion: "+elemento.getCalificacion());
		}
	}
	
	
	
	public Estudiante( String cedula, String nombre, String apellido) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.cedula = cedula;
		notas=new ArrayList<Nota>();
	}

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getCedula() {
		return cedula;
	}
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	public ArrayList<Nota> getNotas() {
		return notas;
	}
	public void setNotas(ArrayList<Nota> notas) {
		this.notas = notas;
	}
	
	
}
