package ui.viewModels;

import java.util.List;

import org.uqbar.commons.model.annotations.Observable;

import dominio.Asignacion;
import repositorios.EstudianteLogueado;

@Observable
public class VerAsignacionesViewModel {

	private List<Asignacion> asignaciones;
	private Asignacion asignacionSeleccionada;

	public VerAsignacionesViewModel() {
		EstudianteLogueado.cargarDatosEstudiante();
		this.asignaciones = EstudianteLogueado.estudiante.getAsignaciones();
	}

	public List<Asignacion> getAsignaciones() {
		return asignaciones;
	}

	public void setAsignaciones(List<Asignacion> asignaciones) {
		this.asignaciones = asignaciones;
	}

	public Asignacion getAsignacionSeleccionada() {
		return asignacionSeleccionada;
	}

	public void setAsignacionSeleccionada(Asignacion asignacionSeleccionada) {
		this.asignacionSeleccionada = asignacionSeleccionada;
		EstudianteLogueado.asignacionSeleccionada = asignacionSeleccionada;
	}

	public int cantidadAsignaciones() {
		return EstudianteLogueado.estudiante.getAsignaciones().size();
	}
}