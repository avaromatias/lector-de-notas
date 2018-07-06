package dominio;

import java.util.List;

import org.uqbar.commons.model.annotations.Observable;

@Observable
public class Estudiante {

	private String apellido;
	private String nombre;
	private int legajo;
	private String usuarioGit;
	private List<Asignacion> asignaciones;
		
	public Estudiante(String unApellido, String unNombre, int unLegajo, String unUsuario, List<Asignacion> unasAsignaciones) {
		this.apellido = unApellido;
		this.nombre = unNombre;
		this.legajo = unLegajo;
		this.usuarioGit = unUsuario;
		this.asignaciones = unasAsignaciones;
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
	
}
