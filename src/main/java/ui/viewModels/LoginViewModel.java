package ui.viewModels;

import java.util.ArrayList;

import javax.ws.rs.core.MediaType;

import org.uqbar.commons.model.annotations.Observable;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.sun.jersey.api.client.ClientResponse;

import dominio.Estudiante;
import repositorios.EstudianteLogueado;

@Observable
public class LoginViewModel {
	
	public String token;
	
	public LoginViewModel() {}
	
	public String getToken() {
		return token;
	}
	
	public void setToken(String token) {
		this.token = token;
	}

	public boolean puedeLoguearse(){
		ClientResponse response = this.acceder();
		if (response.getStatus() == 200) {
			EstudianteLogueado.estudiante = this.loguearEstudiante(response);
			return true;
		} else {
			return false;
		}
	}
	
	private ClientResponse acceder(){
		ClientResponse response = EstudianteLogueado.client
				.resource(EstudianteLogueado.URL)
				.path(EstudianteLogueado.RECURSOESTUDIANTE)
				.header("Authorization", "Bearer " + this.token)
				.accept(MediaType.APPLICATION_JSON)
				.get(ClientResponse.class);
		return response;
	}
	
	private Estudiante loguearEstudiante(ClientResponse response) {
		String salida = response.getEntity(String.class);
		JsonParser parser = new JsonParser();
		JsonObject mi = parser.parse(salida).getAsJsonObject();
		int codigo = mi.get("code").getAsInt();
		String nombre = mi.get("first_name").getAsString();
		String apellido = mi.get("last_name").getAsString();
		String usuarioGit = mi.get("github_user").getAsString();
		return new Estudiante(apellido, nombre, codigo, usuarioGit, new ArrayList<>());
	}
}