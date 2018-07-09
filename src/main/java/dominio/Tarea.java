package dominio;

import org.uqbar.commons.model.annotations.Observable;

@Observable
public class Tarea {

	private String nombre;
	private TipoCalificacion tipoCalificacion;
	
	public Tarea(String nombre, TipoCalificacion tipoCalificacion) {
		this.nombre = nombre;
		this.tipoCalificacion = tipoCalificacion;
	}
	
	public boolean aprobo(Asignacion asignacion) {
		
		return this.tipoCalificacion.estaAprobada(asignacion);
	}

	public String getNombre() {
		return nombre;
	}
	
}
