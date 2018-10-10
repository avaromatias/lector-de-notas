package ui.viewModels;

import javax.ws.rs.core.MediaType;

import org.uqbar.commons.model.annotations.Observable;

import com.sun.jersey.api.client.ClientResponse;

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
		EstudianteLogueado.token = token;
	}

	public boolean puedeLoguearse(){
		ClientResponse response = EstudianteLogueado.client
				.resource(EstudianteLogueado.URL)
				.path(EstudianteLogueado.RECURSOESTUDIANTE)
				.header("Authorization", "Bearer " + EstudianteLogueado.token)
				.accept(MediaType.APPLICATION_JSON)
				.get(ClientResponse.class);
		
		return response.getStatus() == 200;
	}
}