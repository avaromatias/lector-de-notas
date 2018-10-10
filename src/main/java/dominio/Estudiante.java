package dominio;

import java.util.List;
import java.util.stream.Collectors;

public class Estudiante {

	private String apellido;
	private String nombre;
	private int legajo;
	private String usuarioGit;
	private List<Asignacion> asignaciones;
		
	public Estudiante(String apellido, String nombre, int legajo, String usuarioGit, List<Asignacion> asignaciones) {
		this.apellido = apellido;
		this.nombre = nombre;
		this.legajo = legajo;
		this.usuarioGit = usuarioGit;
		this.asignaciones = asignaciones;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getLegajo() {
		return legajo;
	}

	public void setLegajo(int legajo) {
		this.legajo = legajo;
	}

	public String getUsuarioGit() {
		return usuarioGit;
	}

	public void setUsuarioGit(String usuarioGit) {
		this.usuarioGit = usuarioGit;
	}

	public List<Asignacion> getAsignaciones() {
		return asignaciones;
	}

	public Boolean aprobo(Tarea tarea) {
		return tarea.aprobo(this.getAsignacionSegunTarea(tarea));
	}

	public String getNotaDeTarea(Tarea tarea) {
		return this.getAsignacionSegunTarea(tarea).getNotaActual();
	}

	private Asignacion getAsignacionSegunTarea(Tarea tarea) {
		return this.getAsignaciones().stream()
				.filter(asignacion -> asignacion.getTarea().equals(tarea))
				.findFirst().get();
	}

	public List<Tarea> getTareas() {
		return this.getAsignaciones().stream().map(Asignacion::getTarea).collect(Collectors.toList());

	}
}
