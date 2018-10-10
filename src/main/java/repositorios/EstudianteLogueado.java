package repositorios;

import com.sun.jersey.api.client.Client;

import dominio.Estudiante;

public class EstudianteLogueado {

	public static Estudiante estudiante;
	public static Client client = new Client();
	
	public static final String URL = "http://notitas.herokuapp.com";
	public static final String RECURSOESTUDIANTE = "/student";
	public static final String RECURSOMATERIAS = "/student/assignments";
	public static final String TOKEN = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiIxMTEyMjIzMzMiLCJybmQiOiJ5SXNmZFIwN2lIR3BRRmVjYU9KT2VRPT0ifQ.9pVJGUXhrJPQ-TptNCt971l0h_1dWqWgMrHAWXJchho";
	
}
