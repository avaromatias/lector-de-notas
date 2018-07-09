package ui.viewModels;

import java.util.List;

import org.uqbar.commons.model.annotations.Observable;

import dominio.Tarea;
import repositorios.EstudianteLogueado;

@Observable
public class VerNotasViewModel {

	private List<Tarea> tareasAsignadas;
	private Tarea tareaSeleccionada;
	private String nota;
	private String situacion;
	
	public VerNotasViewModel() {
		this.tareasAsignadas = EstudianteLogueado.get().getTareas();
	}

	public List<Tarea> getTareasAsignadas() {
		return tareasAsignadas;
	}

	public void setTareasAsignadas(List<Tarea> tareasAsignadas) {
		this.tareasAsignadas = tareasAsignadas;
	}

	public Tarea getTareaSeleccionada() {
		return tareaSeleccionada;
	}

	public void setTareaSeleccionada(Tarea tareaSeleccionada) {
//		this.nota = EstudianteLogueado.get().getAsignaciones().stream().filter(asignacion ->
//			asignacion.getTarea().equals(tareaSeleccionada)).findFirst().get().getNotaActual();
//		this.setSituacion(tareaSeleccionada.aprobo(EstudianteLogueado.get()));

		this.nota = EstudianteLogueado.get().getNotaDeTarea(tareaSeleccionada);
		this.setSituacion(EstudianteLogueado.get().aprobo(tareaSeleccionada));
		this.tareaSeleccionada = tareaSeleccionada;
	}

	public String getNota() {
		return nota;
	}

	public void setNota(String nota) {
		this.nota = nota;
	}
	
	public void setSituacion(boolean bool) {
		situacion = bool ? "Si" : "No";
	}

	public String getSituacion() {
		return situacion;
	}
	
}
