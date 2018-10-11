package dominio;

import java.util.List;

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

	public void setAsignaciones(List<Asignacion> asignaciones) {
		this.asignaciones = asignaciones;
	}
}
