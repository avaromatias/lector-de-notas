package ui.windows;

import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.windows.Dialog;
import org.uqbar.arena.windows.SimpleWindow;
import org.uqbar.arena.windows.WindowOwner;

import ui.viewModels.MenuPrincipalViewModel;

public class MenuPrincipalWindow extends SimpleWindow<MenuPrincipalViewModel> {

	public MenuPrincipalWindow(WindowOwner parent) {
		super(parent, new MenuPrincipalViewModel());
	}
	
	@Override
	protected void addActions(Panel actionsPanel) {
	}

	@Override
	protected void createFormPanel(Panel mainPanel) {
		this.setTitle("Lector de notas");
		
		new Button(mainPanel).setCaption("Ver asignaciones").onClick(this::verAsignaciones);
		new Button(mainPanel).setCaption("Ver datos personales").onClick(this::verDatos);
		new Button(mainPanel).setCaption("Editar datos personales").onClick(this::editarDatos);
	}

	private void verAsignaciones() {
		Dialog<?> dialog = new VerAsignacionesWindow(this);
		dialog.open();
	}
	
	private void verDatos() {
		Dialog<?> dialog = new VerDatosWindow(this);
		dialog.open();
	}
		
	private void editarDatos() {
		Dialog<?> dialog = new EditarDatosWindow(this);
		dialog.open();
	}

}
