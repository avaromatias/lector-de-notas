package dominio;

import java.util.stream.Collectors;

public class Tarea {

	String nombre;
	TipoCalificacion tipoCalificacion;
	
	public Tarea(String unNombre, TipoCalificacion unTipoCalificacion) {
		this.nombre = unNombre;
		this.tipoCalificacion = unTipoCalificacion;
	}
	
	public boolean aprobo(Estudiante estudiante) {
		Asignacion asignacionActual = estudiante.getAsignaciones().stream().filter(asignacion ->
			asignacion.getTarea().equals(this)).collect(Collectors.toList()).get(0);
		
		if(this.tipoCalificacion == TipoCalificacion.Numerica) return this.aproboNumerica(asignacionActual);
		else return this.aproboConceptual(asignacionActual);
	}
	
	public boolean aproboNumerica(Asignacion asignacion) {
		return Double.parseDouble(asignacion.getNotaActual()) >= 6;
	}
	
	public boolean aproboConceptual(Asignacion asignacion) {
		return !(asignacion.getNotas().contains("M"));
	}

	public String getNombre() {
		return nombre;
	}
	
}
