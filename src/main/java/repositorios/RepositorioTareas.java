package repositorios;

import java.util.Arrays;
import java.util.List;

import dominio.Tarea;
import dominio.TipoCalificacion;

public class RepositorioTareas {

	private static Tarea primerParcialDisenio = new Tarea("1 Parcial de diseño", TipoCalificacion.Numerica);
	private static Tarea primerParcialOperativos = new Tarea("1 Parcial de operativos", TipoCalificacion.Numerica);
	private static Tarea primerParcialParadigmas = new Tarea("1 Parcial de paradigmas", TipoCalificacion.Numerica);
	private static Tarea tpParadigmas = new Tarea("TP Anual de paradigmas", TipoCalificacion.Conceptual);
	private static Tarea tpOperativos = new Tarea("TP de Operativos", TipoCalificacion.Conceptual);
	
	public static List<Tarea> tareas = Arrays.asList(primerParcialDisenio, primerParcialOperativos, primerParcialParadigmas, tpParadigmas, tpOperativos);
	
	public static List<Tarea> get() {
		return tareas;
	}
	
}
