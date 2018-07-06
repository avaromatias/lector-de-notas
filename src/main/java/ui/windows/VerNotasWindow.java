package ui.windows;

import java.awt.Color;

import org.uqbar.arena.bindings.ObservableProperty;
import org.uqbar.arena.layout.HorizontalLayout;
import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.Selector;
import org.uqbar.arena.windows.Dialog;
import org.uqbar.arena.windows.WindowOwner;

import dominio.Tarea;
import ui.viewModels.VerNotasViewModel;

public class VerNotasWindow extends Dialog<VerNotasViewModel> {

	public VerNotasWindow(WindowOwner owner) {
		super(owner, new VerNotasViewModel());
	}

	@Override
	protected void createFormPanel(Panel mainPanel) {
		this.setTitle("Consulta de notas");
		
		mainPanel.setLayout(new VerticalLayout());
		Panel asignaciones = new Panel(mainPanel);
		asignaciones.setLayout(new HorizontalLayout());

		new Label(asignaciones).setText("Asignación: ");
		Selector<Tarea> selectorTarea = new Selector<Tarea>(asignaciones).allowNull(true);
		selectorTarea.bindItems(new ObservableProperty<>("tareasAsignadas")).adaptWith(Tarea.class, "nombre");
		selectorTarea.bindValue(new ObservableProperty<>("tareaSeleccionada"));
		
		Panel nota = new Panel(mainPanel);
		nota.setLayout(new HorizontalLayout());
		new Label(nota).setText("Nota: ");
		new Label(nota).bindValueToProperty("nota");
		
		Panel aprobado = new Panel(mainPanel);
		aprobado.setLayout(new HorizontalLayout());
		new Label(aprobado).setText("Aprobó: ");
		new Label(aprobado).bindValueToProperty("situacion");		
	}
	
	/*private void situacion(Panel panel) {
		if(this.getModelObject().isAprobado()) {
			new Label(panel).setText("APROBÓ").setBackground(Color.GREEN);
		}
		else new Label(panel).setText("NO APROBÓ").setBackground(Color.RED);
		System.out.println(this.getModelObject().isAprobado());
	}*/

}
