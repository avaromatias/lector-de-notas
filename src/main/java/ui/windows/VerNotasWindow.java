package ui.windows;

import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.tables.Column;
import org.uqbar.arena.widgets.tables.Table;
import org.uqbar.arena.windows.Dialog;
import org.uqbar.arena.windows.WindowOwner;

import dominio.Grade;
import ui.viewModels.VerNotasViewModel;

public class VerNotasWindow extends Dialog<VerNotasViewModel> {

	public VerNotasWindow(WindowOwner owner) {
		super(owner, new VerNotasViewModel());
	}
	
	@Override
	protected void createFormPanel(Panel formPanel) {
		this.setTitle("Notas");
		
		Table<Grade> tableNotas = new Table<Grade>(formPanel, Grade.class);
		tableNotas.bindItemsToProperty("grades");
		tableNotas.setNumberVisibleRows(this.getModelObject().cantidadGradesEnAsignacion() + 1);
		System.out.println(this.getModelObject().cantidadGradesEnAsignacion());
		
		Column<Grade> columnaId = new Column<Grade>(tableNotas);
		columnaId.setFixedSize(30);
		columnaId.setTitle("Id");
		columnaId.bindContentsToProperty("id");
		
		Column<Grade> columnaValue = new Column<Grade>(tableNotas);
		columnaValue.setFixedSize(75);
		columnaValue.setTitle("Valor");
		columnaValue.bindContentsToProperty("value");
		
		Column<Grade> columnaCreado = new Column<Grade>(tableNotas);
		columnaCreado.setFixedSize(150);
		columnaCreado.setTitle("Creado");
		columnaCreado.bindContentsToProperty("created_at");
		
		Column<Grade> columnaModificado = new Column<Grade>(tableNotas);
		columnaModificado.setFixedSize(150);
		columnaModificado.setTitle("Modificado");
		columnaModificado.bindContentsToProperty("updated_at");
	}
	
}