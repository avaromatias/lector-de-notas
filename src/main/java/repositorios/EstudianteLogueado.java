package repositorios;

import java.util.ArrayList;

import javax.ws.rs.core.MediaType;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;

import dominio.Estudiante;

public class EstudianteLogueado {

	public static Estudiante estudiante;
	public static String token;
	public static Client client = new Client();
	
	public static final String URL = "http://notitas.herokuapp.com";
	public static final String RECURSOESTUDIANTE = "/student";
	public static final String RECURSOMATERIAS = "/student/assignments";
	
	public static void cargarDatosEstudiante() {
		String salida = EstudianteLogueado.client
				.resource(EstudianteLogueado.URL)
				.path(EstudianteLogueado.RECURSOESTUDIANTE)
				.header("Authorization", "Bearer " + EstudianteLogueado.token)
				.accept(MediaType.APPLICATION_JSON)
				.get(ClientResponse.class).getEntity(String.class);
		
		JsonParser parser = new JsonParser();
		JsonObject mi = parser.parse(salida).getAsJsonObject();
		String apellido = mi.get("last_name").getAsString();
		String nombre = mi.get("first_name").getAsString();
		int codigo = mi.get("code").getAsInt();
		String usuarioGit = mi.get("github_user").getAsString();
		
		EstudianteLogueado.estudiante = new Estudiante(apellido, nombre, codigo, usuarioGit, new ArrayList<>());
	}
	
}
