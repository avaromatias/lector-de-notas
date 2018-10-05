package repositorios;

import dominio.Estudiante;

public class EstudianteLogueado {

	private static Estudiante estudiante;
	public static Estudiante get() {
		ClienteHTTP miCliente= new ClienteHTTP();
		estudiante=miCliente.getEstudiante();
		return estudiante;
	}
	
}
