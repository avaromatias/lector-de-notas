package ui.windows;

import org.uqbar.arena.layout.ColumnLayout;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.windows.SimpleWindow;
import org.uqbar.arena.windows.WindowOwner;

import ui.viewModels.MenuPrincipalViewModel;;

public class ErrorWindow extends SimpleWindow<MenuPrincipalViewModel> {
	
	public ErrorWindow(WindowOwner parent) {
		super(parent, new MenuPrincipalViewModel());
	}
	
	@Override
	protected void addActions(Panel arg0) {}

	@Override
	protected void createFormPanel(Panel mainPanel){
		Panel formPanel = new Panel(mainPanel);
		
		this.setTitle("Error");
		formPanel.setLayout(new ColumnLayout(2));
		
		new Label(formPanel)
		.setText("Token Invalido");
	
	}
}