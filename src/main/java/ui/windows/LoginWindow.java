package ui.windows;

import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.TextBox;
import org.uqbar.arena.windows.SimpleWindow;
import org.uqbar.arena.windows.WindowOwner;

import ui.viewModels.LoginViewModel;

public class LoginWindow extends SimpleWindow<LoginViewModel> {
	
	public LoginWindow(WindowOwner parent) {
		super(parent, new LoginViewModel());
	}
	
	@Override
	protected void addActions(Panel panelActions) {}

	protected void createFormPanel(Panel formPanel){
		this.setTitle("Lector de notas");
		formPanel.setLayout(new VerticalLayout());
		
		new Label(formPanel)
		.setText("Ingrese su codigo token");
		
		new TextBox(formPanel)
		.bindValueToProperty("token");
		
		new Button(formPanel)
		.setCaption("Iniciar sesion")
		.onClick(()-> this.atenderLogin(this.getModelObject().getToken()));
	}
	
	private void atenderLogin(String token){
		if(this.getModelObject().puedeLoguearse()) {
			this.abrirMenuPrincipal();
		} else {
			this.abrirVentanaDeErorr();
		}
	}
	
	private void abrirMenuPrincipal(){
		SimpleWindow<?> menuPrincipal = new MenuPrincipalWindow(this);
		menuPrincipal.open();
	}
	
	private void abrirVentanaDeErorr(){
		SimpleWindow<?> ventanaError = new ErrorWindow(this);
		ventanaError.open();
	}
	
}