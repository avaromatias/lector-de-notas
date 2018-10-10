package ui.viewModels;

import java.util.ArrayList;

import javax.ws.rs.core.MediaType;

import org.uqbar.commons.model.annotations.Observable;

import com.google.gson.Gson;
import com.sun.jersey.api.client.ClientResponse;

import dominio.Estudiante;
import repositorios.EstudianteLogueado;

@Observable
public class EditarDatosViewModel {

	private String apellido;
	private String nombre;
	private int legajo;
	private String usuarioGit;
	
	public EditarDatosViewModel() {
		this.apellido = EstudianteLogueado.estudiante.getApellido();
		this.nombre = EstudianteLogueado.estudiante.getNombre();
		this.legajo = EstudianteLogueado.estudiante.getLegajo();
		this.usuarioGit = EstudianteLogueado.estudiante.getUsuarioGit();
	}
	
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getLegajo() {
		return legajo;
	}
	public void setLegajo(int legajo) {
		this.legajo = legajo;
	}
	public String getUsuarioGit() {
		return usuarioGit;
	}
	public void setUsuarioGit(String usuarioGit) {
		this.usuarioGit = usuarioGit;
	}
	
	private void hacerElPut(String datosModificados){
		ClientResponse respuesta = EstudianteLogueado.client
		.resource(EstudianteLogueado.URL)
		.path(EstudianteLogueado.RECURSOESTUDIANTE)
		.header("Authorization", "Bearer " + EstudianteLogueado.TOKEN)
		.type(MediaType.APPLICATION_JSON)
		.put(ClientResponse.class, datosModificados);
		
		System.out.println(respuesta); // Devuelve un 201, o sea que deberia hacer el put correctamente, pero por alguna razon no lo hace
	}
	
	public void actualizarDatos(){
		Gson gson = new Gson();
		Estudiante estudianteAMandar = new Estudiante(this.apellido, this.nombre, this.legajo, this.usuarioGit, new ArrayList<>());
		String paqueteAMandar = gson.toJson(estudianteAMandar, Estudiante.class);
		System.out.println(paqueteAMandar); // Los datos se envian bien
		this.hacerElPut(paqueteAMandar);
	}
	
}
