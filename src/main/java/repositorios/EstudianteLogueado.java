package repositorios;

import java.util.List;

import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;

import dominio.Asignacion;
import dominio.Estudiante;

public class EstudianteLogueado {

	public static Estudiante estudiante;
	public static String token;
	public static Client client = new Client();
	
	public static Asignacion asignacionSeleccionada;
	
	public static final String URL = "http://notitas.herokuapp.com";
	public static final String RECURSOESTUDIANTE = "/student";
	public static final String RECURSOMATERIAS = "/assignments";
	
	public static void cargarDatosEstudiante() {
		String respuestaDatos = EstudianteLogueado.client
				.resource(EstudianteLogueado.URL)
				.path(EstudianteLogueado.RECURSOESTUDIANTE)
				.header("Authorization", "Bearer " + EstudianteLogueado.token)
				.accept(MediaType.APPLICATION_JSON)
				.get(ClientResponse.class).getEntity(String.class);
		
		JsonParser parser = new JsonParser();
		JsonObject datosPersonales = parser.parse(respuestaDatos).getAsJsonObject();
		String apellido = datosPersonales.get("last_name").getAsString();
		String nombre = datosPersonales.get("first_name").getAsString();
		int codigo = datosPersonales.get("code").getAsInt();
		String usuarioGit = datosPersonales.get("github_user").getAsString();
		
		String respuestaAsignaciones = EstudianteLogueado.client
				.resource(EstudianteLogueado.URL)
				.path(EstudianteLogueado.RECURSOESTUDIANTE + EstudianteLogueado.RECURSOMATERIAS)
				.header("Authorization", "Bearer " + EstudianteLogueado.token)
				.accept(MediaType.APPLICATION_JSON)
				.get(ClientResponse.class).getEntity(String.class);
		
		System.out.println(respuestaAsignaciones); // Por alguna razón no me trae las notas de las asignaciones
		System.out.println(respuestaDatos);
		
		Gson gson = new Gson();
		Assignment assignments = gson.fromJson(respuestaAsignaciones, Assignment.class);
		List<Asignacion> asignaciones = assignments.getAssignments();
		
		EstudianteLogueado.estudiante = new Estudiante(apellido, nombre, codigo, usuarioGit, asignaciones);
	}
	
}
