package ui.windows;

import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.tables.Column;
import org.uqbar.arena.widgets.tables.Table;
import org.uqbar.arena.windows.Dialog;
import org.uqbar.arena.windows.WindowOwner;

import dominio.Asignacion;
import ui.viewModels.VerAsignacionesViewModel;

public class VerAsignacionesWindow extends Dialog<VerAsignacionesViewModel> {

	public VerAsignacionesWindow(WindowOwner owner) {
		super(owner, new VerAsignacionesViewModel());
	}

	@Override
	protected void createFormPanel(Panel formPanel) {
		this.setTitle("Asignaciones");
		
		Table<Asignacion> tableNotas = new Table<Asignacion>(formPanel, Asignacion.class);
		tableNotas.bindItemsToProperty("asignaciones");
		tableNotas.bindValueToProperty("asignacionSeleccionada");
		tableNotas.setNumberVisibleRows(this.getModelObject().cantidadAsignaciones() + 1);
		
		Column<Asignacion> columnaId = new Column<Asignacion>(tableNotas);
		columnaId.setFixedSize(30);
		columnaId.setTitle("Id");
		columnaId.bindContentsToProperty("id");
		
		Column<Asignacion> columnaTitle = new Column<Asignacion>(tableNotas);
		columnaTitle.setFixedSize(75);
		columnaTitle.setTitle("Titulo");
		columnaTitle.bindContentsToProperty("title");
		
		Column<Asignacion> columnaDescription = new Column<Asignacion>(tableNotas);
		columnaDescription.setFixedSize(150);
		columnaDescription.setTitle("Descripcion");
		columnaDescription.bindContentsToProperty("description");
		
		new Button(formPanel)
		.setCaption("Ver notas")
		.onClick(() -> this.abrirVentanaNotas());
	}
	
	private void abrirVentanaNotas(){
		Dialog<?> ventanaEvento = new VerNotasWindow(this);
		ventanaEvento.open();
	}

}