package ui.viewModels;

import org.uqbar.commons.model.annotations.Observable;

import repositorios.EstudianteLogueado;

@Observable
public class VerDatosViewModel {

	private String last_name;
	private String first_name;
	private int code;
	private String github_user;
	
	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getGithub_user() {
		return github_user;
	}

	public void setGithub_user(String github_user) {
		this.github_user = github_user;
	}

	public VerDatosViewModel() {
		EstudianteLogueado.cargarDatosEstudiante();
		
		this.last_name = EstudianteLogueado.estudiante.getApellido();
		this.first_name = EstudianteLogueado.estudiante.getNombre();
		this.code = EstudianteLogueado.estudiante.getLegajo();
		this.github_user = EstudianteLogueado.estudiante.getUsuarioGit();
	}
	
}
