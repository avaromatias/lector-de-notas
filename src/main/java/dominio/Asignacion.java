package dominio;

import java.util.List;

public class Asignacion {

	private Tarea tarea;
	private List<String> notas;
	
	public Asignacion(Tarea tarea, List<String> notas) {
		this.tarea = tarea;
		this.notas = notas;
	}
	
	public String getNotaActual() {
		return this.notas.get(notas.size()-1);
	}

	List<String> getNotas() {
		return notas;
	}

	public Tarea getTarea() {
		return tarea;
	}
	
}
