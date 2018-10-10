package ui.viewModels;

import javax.ws.rs.core.MediaType;

import org.uqbar.commons.model.annotations.Observable;

import com.google.gson.Gson;
import com.sun.jersey.api.client.ClientResponse;

import repositorios.EstudianteLogueado;

@Observable
public class EditarDatosViewModel {

	private String last_name;
	private String first_name;
	private String github_user;
	
	public EditarDatosViewModel() {
		this.last_name = EstudianteLogueado.estudiante.getApellido();
		this.first_name = EstudianteLogueado.estudiante.getNombre();
		this.github_user = EstudianteLogueado.estudiante.getUsuarioGit();
	}
	
	public EditarDatosViewModel(String apellido, String nombre, String usuarioGit) {
		this.last_name = apellido;
		this.first_name = nombre;
		this.github_user = usuarioGit;
	}
	
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

	public String getGithub_user() {
		return github_user;
	}

	public void setGithub_user(String github_user) {
		this.github_user = github_user;
	}

	private void hacerElPut(String datosModificados){
		ClientResponse respuesta = EstudianteLogueado.client
		.resource(EstudianteLogueado.URL)
		.path(EstudianteLogueado.RECURSOESTUDIANTE)
		.header("Authorization", "Bearer " + EstudianteLogueado.TOKEN)
		.type(MediaType.APPLICATION_JSON)
		.put(ClientResponse.class, datosModificados);
		
		System.out.println(respuesta);
	}
	
	public void actualizarDatos(){
		Gson gson = new Gson();
		EditarDatosViewModel estudianteAMandar = new EditarDatosViewModel(this.last_name, this.first_name, this.github_user);
		String paqueteAMandar = gson.toJson(estudianteAMandar, EditarDatosViewModel.class);
		System.out.println(paqueteAMandar);
		this.hacerElPut(paqueteAMandar);
	}
	
}
