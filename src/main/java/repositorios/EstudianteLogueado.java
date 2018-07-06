package repositorios;

import dominio.Estudiante;

public class EstudianteLogueado {

	private static Estudiante estudiante = new Estudiante("Messi", "Lionel", 10, "liomessi", RepositorioAsignaciones.get());

	public static Estudiante get() {
		return estudiante;
	}
	
}
