package repositorios;

import com.sun.jersey.api.client.Client;

import dominio.Estudiante;

public class EstudianteLogueado {

	public static Estudiante estudiante;
	public static String token;
	public static Client client = new Client();
	
	public static final String URL = "http://notitas.herokuapp.com";
	public static final String RECURSOESTUDIANTE = "/student";
	public static final String RECURSOMATERIAS = "/student/assignments";
	
}
