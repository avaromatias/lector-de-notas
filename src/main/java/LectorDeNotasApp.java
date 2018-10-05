import org.uqbar.arena.Application;
import org.uqbar.arena.windows.Window;

import ui.windows.MenuPrincipalWindow;

public class LectorDeNotasApp extends Application{

	public static void main(String[] args) {
		new LectorDeNotasApp().start();
	}
		
	@Override
	protected Window<?> createMainWindow() {
		return new MenuPrincipalWindow(this);
	}
}