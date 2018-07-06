package ui.windows;

import org.uqbar.arena.layout.HorizontalLayout;
import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.windows.Dialog;
import org.uqbar.arena.windows.WindowOwner;

import dominio.Estudiante;
import repositorios.EstudianteLogueado;

public class VerDatosWindow extends Dialog<Estudiante>{

	public VerDatosWindow(WindowOwner owner) {
		super(owner, EstudianteLogueado.get());
	}

	@Override
	protected void createFormPanel(Panel mainPanel) {
		this.setTitle("Ver datos personales");
		mainPanel.setLayout(new VerticalLayout());
		
		Panel nombre = new Panel(mainPanel);
		nombre.setLayout(new HorizontalLayout());
		new Label(nombre).setText("Nombre:       ");
		new Label(nombre).bindValueToProperty("nombre");
		
		Panel apellido = new Panel(mainPanel);
		apellido.setLayout(new HorizontalLayout());
		new Label(apellido).setText("Apellido:      ");
		new Label(apellido).bindValueToProperty("apellido");
		
		Panel legajo = new Panel(mainPanel);
		legajo.setLayout(new HorizontalLayout());
		new Label(legajo).setText("Legajo:         ");
		new Label(legajo).bindValueToProperty("legajo");
		
		Panel git = new Panel(mainPanel);
		git.setLayout(new HorizontalLayout());
		new Label(git).setText("Usuario git:  ");
		new Label(git).bindValueToProperty("usuarioGit");
	}

}
