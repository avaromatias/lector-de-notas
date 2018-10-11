package ui.viewModels;

import java.util.List;

import org.uqbar.commons.model.annotations.Observable;

import dominio.Grade;
import repositorios.EstudianteLogueado;

@Observable
public class VerNotasViewModel {

	private List<Grade> grades;

	public VerNotasViewModel() {
		this.obtenerListaGrades();
	}

	public List<Grade> getGrades() {
		return grades;
	}

	public void setGrades(List<Grade> grades) {
		this.grades = grades;
	}

	private void obtenerListaGrades() {
		this.grades = EstudianteLogueado.asignacionSeleccionada.getGrades();
	}

	public int cantidadGradesEnAsignacion() {
		return EstudianteLogueado.asignacionSeleccionada.getGrades().size();
	}
}
