package krakedev.entidades;

import java.util.ArrayList;

public class Curso {
	private ArrayList<Estudiante> estudiantes;
	
	public Estudiante buscarEstudiantePorCedula(Estudiante estudiante) {
		Estudiante elemento;
		for(int i=0;i<estudiantes.size();i++) {
			elemento=estudiantes.get(i);
			if(estudiante.getCedula().equals(elemento.getCedula())){
				System.out.println("El estudiante fue encontrado");
				return elemento;
			}
		}
		return null;
	}
	
	public void matricularEstudiante(Estudiante estudiante) {
		Estudiante est=buscarEstudiantePorCedula(estudiante);
		if(est==null) {
			estudiantes.add(estudiante);
			System.out.println("Matriculado");
		}else {
			System.out.println("Ya Existe");
		}
	}
	
	public double calcularPromedioCurso() {
		Estudiante elemento;
		double suma = 0;
		double promedio;
		for(int i=0;i<estudiantes.size();i++) {
			elemento=estudiantes.get(i);
			suma+=elemento.calcularPromedioNotasEstudiante();
		}
		promedio=suma/estudiantes.size();
		return promedio;
	}
	
	public void mostrar() {
		Estudiante elemento;
		int num;
		for(int i=0;i<estudiantes.size();i++) {
			elemento=estudiantes.get(i);
			num=i+1;
			System.out.println("Estudiante"+num+" Nombre:"+elemento.getNombre()+" Apellido:"+elemento.getApellido()+" Cédula:"+elemento.getCedula());
		}
	}
	
	public Curso() {
        this.estudiantes = new ArrayList<>();
    }
	
	
	public ArrayList<Estudiante> getEstudiantes() {
		return estudiantes;
	}

	public void setEstudiantes(ArrayList<Estudiante> estudiantes) {
		this.estudiantes = estudiantes;
	}
	
	
	
	
	
}
