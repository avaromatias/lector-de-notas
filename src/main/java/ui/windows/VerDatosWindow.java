package ui.windows;

import org.uqbar.arena.layout.HorizontalLayout;
import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.windows.Dialog;
import org.uqbar.arena.windows.WindowOwner;

import ui.viewModels.VerDatosViewModel;

public class VerDatosWindow extends Dialog<VerDatosViewModel>{

	public VerDatosWindow(WindowOwner owner) {
		super(owner, new VerDatosViewModel());
	}

	@Override
	protected void createFormPanel(Panel mainPanel) {
		this.setTitle("Ver datos personales");
		mainPanel.setLayout(new VerticalLayout());
		
		Panel nombre = new Panel(mainPanel);
		nombre.setLayout(new HorizontalLayout());
		new Label(nombre).setText("Nombre:       ");
		new Label(nombre).bindValueToProperty("first_name");
		
		Panel apellido = new Panel(mainPanel);
		apellido.setLayout(new HorizontalLayout());
		new Label(apellido).setText("Apellido:      ");
		new Label(apellido).bindValueToProperty("last_name");
		
		Panel legajo = new Panel(mainPanel);
		legajo.setLayout(new HorizontalLayout());
		new Label(legajo).setText("Legajo:         ");
		new Label(legajo).bindValueToProperty("code");
		
		Panel git = new Panel(mainPanel);
		git.setLayout(new HorizontalLayout());
		new Label(git).setText("Usuario git:  ");
		new Label(git).bindValueToProperty("github_user");
	}

}
