package repositorios;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import dominio.Asignacion;

// TODO Eliminar esta clase cuando todo ande correctamente

public class RepositorioAsignaciones {

	private static List<String> notasDisenio = Arrays.asList("2", "7.5");
	private static Asignacion disenio = new Asignacion(RepositorioTareas.get().get(0), notasDisenio);

	private static List<String> notasOperativos = Arrays.asList("2", "4", "8");
	private static Asignacion operativos = new Asignacion(RepositorioTareas.get().get(1), notasOperativos);

	private static List<String> notasParadigmas = Collections.singletonList("9");
	private static Asignacion paradigmas = new Asignacion(RepositorioTareas.get().get(2), notasParadigmas);

	private static List<String> notasTPParadigmas = Arrays.asList("R+", "R+", "B", "B", "B");
	private static Asignacion paradigmasTp = new Asignacion(RepositorioTareas.get().get(3), notasTPParadigmas);

	private static List<String> notasTPOperativos = Arrays.asList("R+", "M", "R+", "B", "R+");
	private static Asignacion operativosTp = new Asignacion(RepositorioTareas.get().get(4), notasTPOperativos);

	private static List<Asignacion> asignaciones = Arrays.asList(disenio, operativos, paradigmas,
			paradigmasTp, operativosTp);

	public static List<Asignacion> get() {
		return asignaciones;
	}
	
}
