package dominio;

import java.util.List;

public class Asignacion {

	Tarea tarea;
	List<String> notas;
	
	public Asignacion(Tarea unaTarea, List<String> unasNotas) {
		this.tarea = unaTarea;
		this.notas = unasNotas;
	}
	
	public String getNotaActual() {
		return this.notas.get(notas.size()-1);
	}

	public List<String> getNotas() {
		return notas;
	}

	public Tarea getTarea() {
		return tarea;
	}
	
}
