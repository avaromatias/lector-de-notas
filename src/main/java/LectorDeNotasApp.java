import org.uqbar.arena.Application;
import org.uqbar.arena.windows.Window;

import ui.windows.LoginWindow;

//TOKEN: eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiIxMTEyMjIzMzMiLCJybmQiOiJ5SXNmZFIwN2lIR3BRRmVjYU9KT2VRPT0ifQ.9pVJGUXhrJPQ-TptNCt971l0h_1dWqWgMrHAWXJchho

public class LectorDeNotasApp extends Application{

	public static void main(String[] args) {
		new LectorDeNotasApp().start();
	}
		
	@Override
	protected Window<?> createMainWindow() {
		return new LoginWindow(this);
	}
}