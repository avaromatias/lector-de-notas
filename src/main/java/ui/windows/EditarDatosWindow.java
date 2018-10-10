package ui.windows;

import org.uqbar.arena.layout.HorizontalLayout;
import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.TextBox;
import org.uqbar.arena.windows.Dialog;
import org.uqbar.arena.windows.WindowOwner;

import ui.viewModels.EditarDatosViewModel;

public class EditarDatosWindow extends Dialog<EditarDatosViewModel> {

	public EditarDatosWindow(WindowOwner owner) {
		super(owner, new EditarDatosViewModel());
	}

	@Override
	protected void createFormPanel(Panel mainPanel) {
		this.setTitle("Editar datos personales");
		mainPanel.setLayout(new VerticalLayout());
		
		Panel nombre = new Panel(mainPanel);
		nombre.setLayout(new HorizontalLayout());
		new Label(nombre).setText("Nombre:      ");
		new TextBox(nombre).setWidth(100).bindValueToProperty("first_name");
		
		Panel apellido = new Panel(mainPanel);
		apellido.setLayout(new HorizontalLayout());
		new Label(apellido).setText("Apellido:     ");
		new TextBox(apellido).setWidth(100).bindValueToProperty("last_name");
		
		Panel git = new Panel(mainPanel);
		git.setLayout(new HorizontalLayout());
		new Label(git).setText("Usuario git: ");
		new TextBox(git).setWidth(100).bindValueToProperty("github_user");
		
		new Button(mainPanel).setCaption("Guardar").onClick(()->this.getModelObject().actualizarDatos());
	}

}
