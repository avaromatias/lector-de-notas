package repositorios;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import dominio.Asignacion;

public class RepositorioAsignaciones {

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private static List<String> notasDisenio = (List<String>) new ArrayList(Arrays.asList("2", "7.5"));
	private static Asignacion disenio = new Asignacion(RepositorioTareas.get().get(0), notasDisenio);
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private static List<String> notasOperativos = (List<String>) new ArrayList(Arrays.asList("2", "4", "8"));
	private static Asignacion operativos = new Asignacion(RepositorioTareas.get().get(1), notasOperativos);
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private static List<String> notasParadigmas = (List<String>) new ArrayList(Arrays.asList("9"));
	private static Asignacion paradigmas = new Asignacion(RepositorioTareas.get().get(2), notasParadigmas);
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private static List<String> notasTPParadigmas = (List<String>) new ArrayList(Arrays.asList("R+", "R+", "B", "B", "B"));
	private static Asignacion paradigmasTp = new Asignacion(RepositorioTareas.get().get(3), notasTPParadigmas);
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private static List<String> notasTPOperativos = (List<String>) new ArrayList(Arrays.asList("R+", "M", "R+", "B", "R+"));
	private static Asignacion operativosTp = new Asignacion(RepositorioTareas.get().get(4), notasTPOperativos);
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private static List<Asignacion> asignaciones = (List<Asignacion>) new ArrayList(Arrays.asList(disenio, operativos, paradigmas,
			paradigmasTp, operativosTp));

	public static List<Asignacion> get() {
		return asignaciones;
	}
	
}
