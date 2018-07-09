package dominio;

public enum TipoCalificacion {

	Numerica {
		@Override
		public Boolean estaAprobada(Asignacion asignacion) {
			return Double.parseDouble(asignacion.getNotaActual()) >= 6;
		}
	},
	Conceptual {
		@Override
		public Boolean estaAprobada(Asignacion asignacion) {
			return !asignacion.getNotas().contains("M");
		}
	};

	public abstract Boolean estaAprobada(Asignacion asignacion);
}